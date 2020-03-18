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
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes10.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener avi;
    private TextView cLd;
    private TextView fPA;
    private TextView fPE;
    private RelativeLayout fPI;
    private TbImageView fPJ;
    private TbImageView fPK;
    private TbImageView fPL;
    private TextView fPz;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.aQU().dispatchMvcEvent(bVar);
                }
            }
        };
        this.cLd = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.fPz = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.fPA = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.fPE = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.fPI = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.fPJ = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.fPK = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.fPL = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.fPJ.setOnClickListener(this.avi);
        this.fPK.setOnClickListener(this.avi);
        this.fPL.setOnClickListener(this.avi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(final tinfo tinfoVar) {
        super.ai(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.cLd.setVisibility(8);
            } else {
                this.cLd.setVisibility(0);
                this.cLd.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.cLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (aq.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.fPE.setVisibility(8);
            } else {
                this.fPE.setVisibility(0);
                this.fPE.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.fPz.setVisibility(8);
            } else {
                this.fPz.setVisibility(0);
                this.fPz.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.fPA.setVisibility(8);
            } else {
                this.fPA.setVisibility(0);
                this.fPA.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.azR().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.fPI.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.fPL.setVisibility(0);
                        this.fPL.startLoad(str, 10, false);
                        this.fPL.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.fPK.setVisibility(0);
                        this.fPK.startLoad(str2, 10, false);
                        this.fPK.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.fPJ.setVisibility(0);
                this.fPJ.startLoad(str3, 10, false);
                this.fPJ.setTag(0);
                return;
            }
            this.fPI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
