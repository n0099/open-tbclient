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
    private TextView Tm;
    private TextView aHW;
    private TextView cwP;
    private TextView cwQ;
    private TextView cwU;
    private LinearLayout cwV;

    public b(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        this.Tm = (TextView) view2.findViewById(d.g.chosen_no_picture_title);
        this.cwP = (TextView) view2.findViewById(d.g.chosen_no_picture_praise);
        this.cwQ = (TextView) view2.findViewById(d.g.chosen_no_picture_comment);
        this.cwU = (TextView) view2.findViewById(d.g.chosen_no_picture_head);
        this.aHW = (TextView) view2.findViewById(d.g.chosen_no_picture_sub);
        this.cwV = (LinearLayout) view2.findViewById(d.g.chosen_no_picture_comment_line);
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
            this.cwU.setVisibility(8);
        } else {
            this.cwU.setVisibility(0);
            this.cwU.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.cwV.setVisibility(8);
        } else {
            this.cwV.setVisibility(0);
            this.Tm.setVisibility(0);
            this.Tm.setText(UtilHelper.getFixedText(getContext().getString(d.k.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.Tm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
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
                this.cwP.setVisibility(8);
            } else {
                this.cwP.setVisibility(0);
                this.cwP.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.cwQ.setVisibility(8);
            } else {
                this.cwQ.setVisibility(0);
                this.cwQ.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.aHW.setVisibility(8);
            return;
        }
        this.aHW.setVisibility(0);
        this.aHW.setText(tinfoVar._abstract);
    }
}
