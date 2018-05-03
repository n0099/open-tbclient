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
    private View bYn;
    private TextView cpb;
    private LinearLayout cpc;
    private LinearLayout cpd;
    private LinearLayout cpe;
    private LinearLayout cpf;
    private TextView cpg;
    private TextView cph;
    private TextView cpi;
    private TextView cpj;
    private View cpk;
    private View cpl;
    private View cpm;
    private View cpn;
    private com.baidu.tieba.card.data.n cpo;
    private String cpp;
    private String cpq;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.home_card_hot_topic_root_view);
        this.Tm = (TextView) view2.findViewById(d.g.home_card_topic_title);
        this.cpb = (TextView) view2.findViewById(d.g.home_card_topic_more);
        this.cpc = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_one);
        this.cpd = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_two);
        this.cpe = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_three);
        this.cpf = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_four);
        this.cpg = (TextView) view2.findViewById(d.g.home_card_topic_one);
        this.cph = (TextView) view2.findViewById(d.g.home_card_topic_two);
        this.cpi = (TextView) view2.findViewById(d.g.home_card_topic_three);
        this.cpj = (TextView) view2.findViewById(d.g.home_card_topic_four);
        this.cpk = view2.findViewById(d.g.home_top_div);
        this.cpl = view2.findViewById(d.g.home_top_topic_div_one);
        this.cpm = view2.findViewById(d.g.home_top_topic_div_two);
        this.cpn = view2.findViewById(d.g.home_card_top_divider_line);
        this.bYn = view2.findViewById(d.g.home_card_bottom_divider_line);
        this.cpc.setOnClickListener(this);
        this.cpd.setOnClickListener(this);
        this.cpe.setOnClickListener(this);
        this.cpf.setOnClickListener(this);
        this.cpb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.aeY())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.aeY().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cpp = str;
        this.cpq = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int g = com.baidu.adp.lib.g.b.g((String) view2.getTag(), -1);
        if (this.cpo != null && com.baidu.tbadk.core.util.v.c(this.cpo.csn, g) != null) {
            TiebaStatic.log(new al(this.cpq).ac("obj_locate", String.valueOf(this.cpo.bjq)).ac("obj_name", this.cpo.csn.get(g).Zo));
            if (g >= 0 && !com.baidu.tbadk.plugins.b.e(aeY())) {
                aeY().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(aeY().getPageActivity()).createNormalConfig(String.valueOf(this.cpo.csn.get(g).Zn), this.cpo.csn.get(g).Zo, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.c(this.Tm, d.C0126d.cp_cont_d, 1);
            ak.c(this.cpb, d.C0126d.cp_cont_d, 1);
            ak.c(this.cpg, d.C0126d.cp_cont_b, 1);
            ak.c(this.cph, d.C0126d.cp_cont_b, 1);
            ak.c(this.cpi, d.C0126d.cp_cont_b, 1);
            ak.c(this.cpj, d.C0126d.cp_cont_b, 1);
            ak.i(this.cpk, d.C0126d.cp_bg_line_b);
            ak.i(this.cpl, d.C0126d.cp_bg_line_b);
            ak.i(this.cpm, d.C0126d.cp_bg_line_b);
            ak.i(this.cpn, d.C0126d.cp_bg_line_c);
            ak.i(this.bYn, d.C0126d.cp_bg_line_c);
            ak.i(this.cpc, d.f.card_topic_click_selector);
            ak.i(this.cpd, d.f.card_topic_click_selector);
            ak.i(this.cpe, d.f.card_topic_click_selector);
            ak.i(this.cpf, d.f.card_topic_click_selector);
            k(this.cpg, 0);
            k(this.cph, 1);
            k(this.cpi, 2);
            k(this.cpj, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.csm) || com.baidu.tbadk.core.util.v.v(nVar.csn) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cpo = nVar;
        this.cpn.setVisibility(this.cpo.csk ? 0 : 8);
        showBottomLine(this.cpo.csl);
        this.Tm.setText(this.cpo.csm.trim());
        j(this.cpg, 0);
        j(this.cph, 1);
        j(this.cpi, 2);
        j(this.cpj, 3);
        k(this.cpg, 0);
        k(this.cph, 1);
        k(this.cpi, 2);
        k(this.cpj, 3);
    }

    private void j(TextView textView, int i) {
        textView.setText(this.cpo.csn.get(i).Zo.trim());
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cpo != null && com.baidu.tbadk.core.util.v.v(this.cpo.csn) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.cpo.csn, i)) != null) {
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
            this.bYn.setVisibility(0);
        } else {
            this.bYn.setVisibility(8);
        }
    }

    public void iL(int i) {
        ViewGroup.LayoutParams layoutParams = this.cpn.getLayoutParams();
        layoutParams.height = i;
        this.cpn.setLayoutParams(layoutParams);
    }
}
