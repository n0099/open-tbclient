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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends a<com.baidu.tieba.card.data.n> {
    private TextView Tm;
    private View bYq;
    private TextView cpe;
    private LinearLayout cpf;
    private LinearLayout cpg;
    private LinearLayout cph;
    private LinearLayout cpi;
    private TextView cpj;
    private TextView cpk;
    private TextView cpl;
    private TextView cpm;
    private View cpn;
    private View cpo;
    private View cpp;
    private View cpq;
    private com.baidu.tieba.card.data.n cpr;
    private String cps;
    private String cpt;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.home_card_hot_topic_root_view);
        this.Tm = (TextView) view2.findViewById(d.g.home_card_topic_title);
        this.cpe = (TextView) view2.findViewById(d.g.home_card_topic_more);
        this.cpf = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_one);
        this.cpg = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_two);
        this.cph = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_three);
        this.cpi = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_four);
        this.cpj = (TextView) view2.findViewById(d.g.home_card_topic_one);
        this.cpk = (TextView) view2.findViewById(d.g.home_card_topic_two);
        this.cpl = (TextView) view2.findViewById(d.g.home_card_topic_three);
        this.cpm = (TextView) view2.findViewById(d.g.home_card_topic_four);
        this.cpn = view2.findViewById(d.g.home_top_div);
        this.cpo = view2.findViewById(d.g.home_top_topic_div_one);
        this.cpp = view2.findViewById(d.g.home_top_topic_div_two);
        this.cpq = view2.findViewById(d.g.home_card_top_divider_line);
        this.bYq = view2.findViewById(d.g.home_card_bottom_divider_line);
        this.cpf.setOnClickListener(this);
        this.cpg.setOnClickListener(this);
        this.cph.setOnClickListener(this);
        this.cpi.setOnClickListener(this);
        this.cpe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.aeY())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.aeY().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cps = str;
        this.cpt = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int g = com.baidu.adp.lib.g.b.g((String) view2.getTag(), -1);
        if (this.cpr != null && com.baidu.tbadk.core.util.v.c(this.cpr.csq, g) != null) {
            TiebaStatic.log(new al(this.cpt).ac("obj_locate", String.valueOf(this.cpr.bjq)).ac("obj_name", this.cpr.csq.get(g).Zo));
            if (g >= 0 && !com.baidu.tbadk.plugins.b.e(aeY())) {
                aeY().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(aeY().getPageActivity()).createNormalConfig(String.valueOf(this.cpr.csq.get(g).Zn), this.cpr.csq.get(g).Zo, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.c(this.Tm, d.C0126d.cp_cont_d, 1);
            ak.c(this.cpe, d.C0126d.cp_cont_d, 1);
            ak.c(this.cpj, d.C0126d.cp_cont_b, 1);
            ak.c(this.cpk, d.C0126d.cp_cont_b, 1);
            ak.c(this.cpl, d.C0126d.cp_cont_b, 1);
            ak.c(this.cpm, d.C0126d.cp_cont_b, 1);
            ak.i(this.cpn, d.C0126d.cp_bg_line_b);
            ak.i(this.cpo, d.C0126d.cp_bg_line_b);
            ak.i(this.cpp, d.C0126d.cp_bg_line_b);
            ak.i(this.cpq, d.C0126d.cp_bg_line_c);
            ak.i(this.bYq, d.C0126d.cp_bg_line_c);
            ak.i(this.cpf, d.f.card_topic_click_selector);
            ak.i(this.cpg, d.f.card_topic_click_selector);
            ak.i(this.cph, d.f.card_topic_click_selector);
            ak.i(this.cpi, d.f.card_topic_click_selector);
            k(this.cpj, 0);
            k(this.cpk, 1);
            k(this.cpl, 2);
            k(this.cpm, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.csp) || com.baidu.tbadk.core.util.v.v(nVar.csq) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cpr = nVar;
        this.cpq.setVisibility(this.cpr.csn ? 0 : 8);
        showBottomLine(this.cpr.cso);
        this.Tm.setText(this.cpr.csp.trim());
        j(this.cpj, 0);
        j(this.cpk, 1);
        j(this.cpl, 2);
        j(this.cpm, 3);
        k(this.cpj, 0);
        k(this.cpk, 1);
        k(this.cpl, 2);
        k(this.cpm, 3);
    }

    private void j(TextView textView, int i) {
        textView.setText(this.cpr.csq.get(i).Zo.trim());
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cpr != null && com.baidu.tbadk.core.util.v.v(this.cpr.csq) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.cpr.csq, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ak.getDrawable(d.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.bYq.setVisibility(0);
        } else {
            this.bYq.setVisibility(8);
        }
    }

    public void iM(int i) {
        ViewGroup.LayoutParams layoutParams = this.cpq.getLayoutParams();
        layoutParams.height = i;
        this.cpq.setLayoutParams(layoutParams);
    }
}
