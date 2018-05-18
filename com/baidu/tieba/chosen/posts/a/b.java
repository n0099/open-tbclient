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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView Ti;
    private TextView aHX;
    private TextView cxV;
    private TextView cxW;
    private TextView cya;
    private LinearLayout cyb;

    public b(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        this.Ti = (TextView) view2.findViewById(d.g.chosen_no_picture_title);
        this.cxV = (TextView) view2.findViewById(d.g.chosen_no_picture_praise);
        this.cxW = (TextView) view2.findViewById(d.g.chosen_no_picture_comment);
        this.cya = (TextView) view2.findViewById(d.g.chosen_no_picture_head);
        this.aHX = (TextView) view2.findViewById(d.g.chosen_no_picture_sub);
        this.cyb = (LinearLayout) view2.findViewById(d.g.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.u(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(final tinfo tinfoVar) {
        super.D(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.cya.setVisibility(8);
        } else {
            this.cya.setVisibility(0);
            this.cya.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.cyb.setVisibility(8);
        } else {
            this.cyb.setVisibility(0);
            this.Ti.setVisibility(0);
            this.Ti.setText(UtilHelper.getFixedText(getContext().getString(d.k.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.Ti.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str = tinfoVar.forum_name;
                    if (an.aQ(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.cxV.setVisibility(8);
            } else {
                this.cxV.setVisibility(0);
                this.cxV.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cxW.setVisibility(8);
            } else {
                this.cxW.setVisibility(0);
                this.cxW.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.aHX.setVisibility(8);
            return;
        }
        this.aHX.setVisibility(0);
        this.aHX.setText(tinfoVar._abstract);
    }
}
