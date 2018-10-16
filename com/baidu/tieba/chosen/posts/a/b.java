package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aZe;
    private TextView aiy;
    private TextView cVd;
    private TextView cVe;
    private TextView cVi;
    private LinearLayout cVj;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aiy = (TextView) view.findViewById(e.g.chosen_no_picture_title);
        this.cVd = (TextView) view.findViewById(e.g.chosen_no_picture_praise);
        this.cVe = (TextView) view.findViewById(e.g.chosen_no_picture_comment);
        this.cVi = (TextView) view.findViewById(e.g.chosen_no_picture_head);
        this.aZe = (TextView) view.findViewById(e.g.chosen_no_picture_sub);
        this.cVj = (LinearLayout) view.findViewById(e.g.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(final tinfo tinfoVar) {
        super.L(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.cVi.setVisibility(8);
        } else {
            this.cVi.setVisibility(0);
            this.cVi.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.cVj.setVisibility(8);
        } else {
            this.cVj.setVisibility(0);
            this.aiy.setVisibility(0);
            this.aiy.setText(UtilHelper.getFixedText(getContext().getString(e.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aiy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (ao.bv(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.cVd.setVisibility(8);
            } else {
                this.cVd.setVisibility(0);
                this.cVd.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cVe.setVisibility(8);
            } else {
                this.cVe.setVisibility(0);
                this.cVe.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.aZe.setVisibility(8);
            return;
        }
        this.aZe.setVisibility(0);
        this.aZe.setText(tinfoVar._abstract);
    }
}
