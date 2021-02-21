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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes8.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aEh;
    private RelativeLayout bpa;
    private TextView eHx;
    private TextView iCB;
    private TextView iCC;
    private TextView iCG;
    private TbImageView iCK;
    private TbImageView iCL;
    private TbImageView iCM;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.bDI().dispatchMvcEvent(bVar);
                }
            }
        };
        this.eHx = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.iCB = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.iCC = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.iCG = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.bpa = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.iCK = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.iCL = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.iCM = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.iCK.setOnClickListener(this.aEh);
        this.iCL.setOnClickListener(this.aEh);
        this.iCM.setOnClickListener(this.aEh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aw(final tinfo tinfoVar) {
        super.aw(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.eHx.setVisibility(8);
            } else {
                this.eHx.setVisibility(0);
                this.eHx.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.eHx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (au.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.iCG.setVisibility(8);
            } else {
                this.iCG.setVisibility(0);
                this.iCG.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.iCB.setVisibility(8);
            } else {
                this.iCB.setVisibility(0);
                this.iCB.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.iCC.setVisibility(8);
            } else {
                this.iCC.setVisibility(0);
                this.iCC.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.bkT().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.bpa.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.iCM.setVisibility(0);
                        this.iCM.startLoad(str, 10, false);
                        this.iCM.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.iCL.setVisibility(0);
                        this.iCL.startLoad(str2, 10, false);
                        this.iCL.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.iCK.setVisibility(0);
                this.iCK.startLoad(str3, 10, false);
                this.iCK.setTag(0);
                return;
            }
            this.bpa.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
