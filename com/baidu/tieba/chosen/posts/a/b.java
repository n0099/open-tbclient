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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aIe;
    private TextView bxJ;
    private TextView dfi;
    private TextView dfj;
    private TextView dfn;
    private LinearLayout dfo;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aIe = (TextView) view.findViewById(d.g.chosen_no_picture_title);
        this.dfi = (TextView) view.findViewById(d.g.chosen_no_picture_praise);
        this.dfj = (TextView) view.findViewById(d.g.chosen_no_picture_comment);
        this.dfn = (TextView) view.findViewById(d.g.chosen_no_picture_head);
        this.bxJ = (TextView) view.findViewById(d.g.chosen_no_picture_sub);
        this.dfo = (LinearLayout) view.findViewById(d.g.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.aQ(i == 1);
        layoutMode.aM(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(final tinfo tinfoVar) {
        super.aI(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.dfn.setVisibility(8);
        } else {
            this.dfn.setVisibility(0);
            this.dfn.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.dfo.setVisibility(8);
        } else {
            this.dfo.setVisibility(0);
            this.aIe.setVisibility(0);
            this.aIe.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aIe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (am.aT(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.dfi.setVisibility(8);
            } else {
                this.dfi.setVisibility(0);
                this.dfi.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.dfj.setVisibility(8);
            } else {
                this.dfj.setVisibility(0);
                this.dfj.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.bxJ.setVisibility(8);
            return;
        }
        this.bxJ.setVisibility(0);
        this.bxJ.setText(tinfoVar._abstract);
    }
}
