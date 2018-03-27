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
    private TextView aHU;
    private TextView bxz;
    private TextView deZ;
    private TextView dfa;
    private TextView dfe;
    private LinearLayout dff;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aHU = (TextView) view.findViewById(d.g.chosen_no_picture_title);
        this.deZ = (TextView) view.findViewById(d.g.chosen_no_picture_praise);
        this.dfa = (TextView) view.findViewById(d.g.chosen_no_picture_comment);
        this.dfe = (TextView) view.findViewById(d.g.chosen_no_picture_head);
        this.bxz = (TextView) view.findViewById(d.g.chosen_no_picture_sub);
        this.dff = (LinearLayout) view.findViewById(d.g.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.p
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
            this.dfe.setVisibility(8);
        } else {
            this.dfe.setVisibility(0);
            this.dfe.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.dff.setVisibility(8);
        } else {
            this.dff.setVisibility(0);
            this.aHU.setVisibility(0);
            this.aHU.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.aHU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
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
                this.deZ.setVisibility(8);
            } else {
                this.deZ.setVisibility(0);
                this.deZ.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.dfa.setVisibility(8);
            } else {
                this.dfa.setVisibility(0);
                this.dfa.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.bxz.setVisibility(8);
            return;
        }
        this.bxz.setVisibility(0);
        this.bxz.setText(tinfoVar._abstract);
    }
}
