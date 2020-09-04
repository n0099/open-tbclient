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
/* loaded from: classes17.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aBm;
    private TextView dSD;
    private TextView hoI;
    private TextView hoJ;
    private TextView hoN;
    private RelativeLayout hoR;
    private TbImageView hoS;
    private TbImageView hoT;
    private TbImageView hoU;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.btR().dispatchMvcEvent(bVar);
                }
            }
        };
        this.dSD = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.hoI = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.hoJ = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.hoN = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.hoR = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.hoS = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.hoT = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.hoU = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.hoS.setOnClickListener(this.aBm);
        this.hoT.setOnClickListener(this.aBm);
        this.hoU.setOnClickListener(this.aBm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aq(final tinfo tinfoVar) {
        super.aq(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.dSD.setVisibility(8);
            } else {
                this.dSD.setVisibility(0);
                this.dSD.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.dSD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.hoN.setVisibility(8);
            } else {
                this.hoN.setVisibility(0);
                this.hoN.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.hoI.setVisibility(8);
            } else {
                this.hoI.setVisibility(0);
                this.hoI.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.hoJ.setVisibility(8);
            } else {
                this.hoJ.setVisibility(0);
                this.hoJ.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.bbM().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.hoR.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.hoU.setVisibility(0);
                        this.hoU.startLoad(str, 10, false);
                        this.hoU.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.hoT.setVisibility(0);
                        this.hoT.startLoad(str2, 10, false);
                        this.hoT.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.hoS.setVisibility(0);
                this.hoS.startLoad(str3, 10, false);
                this.hoS.setTag(0);
                return;
            }
            this.hoR.setVisibility(8);
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
