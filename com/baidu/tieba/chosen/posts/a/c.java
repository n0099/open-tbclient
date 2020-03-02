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
    private View.OnClickListener auX;
    private TextView cKR;
    private TextView fOE;
    private TextView fOF;
    private TextView fOJ;
    private RelativeLayout fON;
    private TbImageView fOO;
    private TbImageView fOP;
    private TbImageView fOQ;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.aQP().dispatchMvcEvent(bVar);
                }
            }
        };
        this.cKR = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.fOE = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.fOF = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.fOJ = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.fON = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.fOO = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.fOP = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.fOQ = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.fOO.setOnClickListener(this.auX);
        this.fOP.setOnClickListener(this.auX);
        this.fOQ.setOnClickListener(this.auX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(final tinfo tinfoVar) {
        super.ai(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.cKR.setVisibility(8);
            } else {
                this.cKR.setVisibility(0);
                this.cKR.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.cKR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.fOJ.setVisibility(8);
            } else {
                this.fOJ.setVisibility(0);
                this.fOJ.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.fOE.setVisibility(8);
            } else {
                this.fOE.setVisibility(0);
                this.fOE.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.fOF.setVisibility(8);
            } else {
                this.fOF.setVisibility(0);
                this.fOF.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.azO().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.fON.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.fOQ.setVisibility(0);
                        this.fOQ.startLoad(str, 10, false);
                        this.fOQ.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.fOP.setVisibility(0);
                        this.fOP.startLoad(str2, 10, false);
                        this.fOP.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.fOO.setVisibility(0);
                this.fOO.startLoad(str3, 10, false);
                this.fOO.setTag(0);
                return;
            }
            this.fON.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}
