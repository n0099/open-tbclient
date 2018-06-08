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
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView aQu;
    private TextView abq;
    private TextView cGD;
    private LinearLayout cGE;
    private TextView cGy;
    private TextView cGz;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.abq = (TextView) view.findViewById(d.g.chosen_no_picture_title);
        this.cGy = (TextView) view.findViewById(d.g.chosen_no_picture_praise);
        this.cGz = (TextView) view.findViewById(d.g.chosen_no_picture_comment);
        this.cGD = (TextView) view.findViewById(d.g.chosen_no_picture_head);
        this.aQu = (TextView) view.findViewById(d.g.chosen_no_picture_sub);
        this.cGE = (LinearLayout) view.findViewById(d.g.chosen_no_picture_comment_line);
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
    public void G(final tinfo tinfoVar) {
        super.G(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.cGD.setVisibility(8);
        } else {
            this.cGD.setVisibility(0);
            this.cGD.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.cGE.setVisibility(8);
        } else {
            this.cGE.setVisibility(0);
            this.abq.setVisibility(0);
            this.abq.setText(UtilHelper.getFixedText(getContext().getString(d.k.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.abq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (ao.bc(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.cGy.setVisibility(8);
            } else {
                this.cGy.setVisibility(0);
                this.cGy.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cGz.setVisibility(8);
            } else {
                this.cGz.setVisibility(0);
                this.cGz.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.aQu.setVisibility(8);
            return;
        }
        this.aQu.setVisibility(0);
        this.aQu.setText(tinfoVar._abstract);
    }
}
