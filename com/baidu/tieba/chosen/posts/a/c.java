package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes22.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aBS;
    private TextView dUN;
    private TextView hvM;
    private TextView hvN;
    private TextView hvR;
    private RelativeLayout hvV;
    private TbImageView hvW;
    private TbImageView hvX;
    private TbImageView hvY;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.buV().dispatchMvcEvent(bVar);
                }
            }
        };
        this.dUN = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.hvM = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.hvN = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.hvR = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.hvV = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.hvW = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.hvX = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.hvY = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.hvW.setOnClickListener(this.aBS);
        this.hvX.setOnClickListener(this.aBS);
        this.hvY.setOnClickListener(this.aBS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ar(final tinfo tinfoVar) {
        super.ar(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.dUN.setVisibility(8);
            } else {
                this.dUN.setVisibility(0);
                this.dUN.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.dUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (at.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.hvR.setVisibility(8);
            } else {
                this.hvR.setVisibility(0);
                this.hvR.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.hvM.setVisibility(8);
            } else {
                this.hvM.setVisibility(0);
                this.hvM.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.hvN.setVisibility(8);
            } else {
                this.hvN.setVisibility(0);
                this.hvN.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.bcG().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.hvV.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.hvY.setVisibility(0);
                        this.hvY.startLoad(str, 10, false);
                        this.hvY.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.hvX.setVisibility(0);
                        this.hvX.startLoad(str2, 10, false);
                        this.hvX.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.hvW.setVisibility(0);
                this.hvW.startLoad(str3, 10, false);
                this.hvW.setTag(0);
                return;
            }
            this.hvV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
