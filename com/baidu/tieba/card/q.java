package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class q extends a<com.baidu.tieba.card.data.n> {
    private TextView ajl;
    private View cAJ;
    private TextView cOA;
    private LinearLayout cOB;
    private LinearLayout cOC;
    private LinearLayout cOD;
    private LinearLayout cOE;
    private TextView cOF;
    private TextView cOG;
    private TextView cOH;
    private TextView cOI;
    private View cOJ;
    private View cOK;
    private View cOL;
    private View cOM;
    private com.baidu.tieba.card.data.n cON;
    private String cOO;
    private String cOP;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.home_card_hot_topic_root_view);
        this.ajl = (TextView) view.findViewById(e.g.home_card_topic_title);
        this.cOA = (TextView) view.findViewById(e.g.home_card_topic_more);
        this.cOB = (LinearLayout) view.findViewById(e.g.home_card_topic_group_one);
        this.cOC = (LinearLayout) view.findViewById(e.g.home_card_topic_group_two);
        this.cOD = (LinearLayout) view.findViewById(e.g.home_card_topic_group_three);
        this.cOE = (LinearLayout) view.findViewById(e.g.home_card_topic_group_four);
        this.cOF = (TextView) view.findViewById(e.g.home_card_topic_one);
        this.cOG = (TextView) view.findViewById(e.g.home_card_topic_two);
        this.cOH = (TextView) view.findViewById(e.g.home_card_topic_three);
        this.cOI = (TextView) view.findViewById(e.g.home_card_topic_four);
        this.cOJ = view.findViewById(e.g.home_top_div);
        this.cOK = view.findViewById(e.g.home_top_topic_div_one);
        this.cOL = view.findViewById(e.g.home_top_topic_div_two);
        this.cOM = view.findViewById(e.g.home_card_top_divider_line);
        this.cAJ = view.findViewById(e.g.home_card_bottom_divider_line);
        this.cOB.setOnClickListener(this);
        this.cOC.setOnClickListener(this);
        this.cOD.setOnClickListener(this);
        this.cOE.setOnClickListener(this);
        this.cOA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cOO = str;
        this.cOP = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l = com.baidu.adp.lib.g.b.l((String) view.getTag(), -1);
        if (this.cON != null && com.baidu.tbadk.core.util.v.d(this.cON.cRN, l) != null) {
            TiebaStatic.log(new am(this.cOP).ax("obj_locate", String.valueOf(this.cON.bJc)).ax("obj_name", this.cON.cRN.get(l).apl));
            if (l >= 0 && !com.baidu.tbadk.plugins.b.e(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.cON.cRN.get(l).apk), this.cON.cRN.get(l).apl, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.ajl, e.d.cp_cont_d, 1);
            al.c(this.cOA, e.d.cp_cont_d, 1);
            al.c(this.cOF, e.d.cp_cont_b, 1);
            al.c(this.cOG, e.d.cp_cont_b, 1);
            al.c(this.cOH, e.d.cp_cont_b, 1);
            al.c(this.cOI, e.d.cp_cont_b, 1);
            al.i(this.cOJ, e.d.cp_bg_line_b);
            al.i(this.cOK, e.d.cp_bg_line_b);
            al.i(this.cOL, e.d.cp_bg_line_b);
            al.i(this.cOM, e.d.cp_bg_line_c);
            al.i(this.cAJ, e.d.cp_bg_line_c);
            al.i(this.cOB, e.f.card_topic_click_selector);
            al.i(this.cOC, e.f.card_topic_click_selector);
            al.i(this.cOD, e.f.card_topic_click_selector);
            al.i(this.cOE, e.f.card_topic_click_selector);
            k(this.cOF, 0);
            k(this.cOG, 1);
            k(this.cOH, 2);
            k(this.cOI, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.cRM) || com.baidu.tbadk.core.util.v.H(nVar.cRN) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cON = nVar;
        this.cOM.setVisibility(this.cON.cRK ? 0 : 8);
        showBottomLine(this.cON.cRL);
        this.ajl.setText(this.cON.cRM.trim());
        j(this.cOF, 0);
        j(this.cOG, 1);
        j(this.cOH, 2);
        j(this.cOI, 3);
        k(this.cOF, 0);
        k(this.cOG, 1);
        k(this.cOH, 2);
        k(this.cOI, 3);
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.cON.cRN.get(i);
        if (!StringUtils.isNull(mVar.apl)) {
            textView.setText(mVar.apl.trim());
        }
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cON != null && com.baidu.tbadk.core.util.v.H(this.cON.cRN) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.d(this.cON.cRN, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.cAJ.setVisibility(0);
        } else {
            this.cAJ.setVisibility(8);
        }
    }

    public void kj(int i) {
        ViewGroup.LayoutParams layoutParams = this.cOM.getLayoutParams();
        layoutParams.height = i;
        this.cOM.setLayoutParams(layoutParams);
    }
}
