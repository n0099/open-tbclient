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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class m extends a<com.baidu.tieba.card.data.o> {
    private TextView aIe;
    private View cIs;
    private LinearLayout cXA;
    private LinearLayout cXB;
    private TextView cXC;
    private TextView cXD;
    private TextView cXE;
    private TextView cXF;
    private View cXG;
    private View cXH;
    private View cXI;
    private View cXJ;
    private com.baidu.tieba.card.data.o cXK;
    private String cXL;
    private String cXM;
    private TextView cXx;
    private LinearLayout cXy;
    private LinearLayout cXz;
    private View mRootView;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.home_card_hot_topic_root_view);
        this.aIe = (TextView) view.findViewById(d.g.home_card_topic_title);
        this.cXx = (TextView) view.findViewById(d.g.home_card_topic_more);
        this.cXy = (LinearLayout) view.findViewById(d.g.home_card_topic_group_one);
        this.cXz = (LinearLayout) view.findViewById(d.g.home_card_topic_group_two);
        this.cXA = (LinearLayout) view.findViewById(d.g.home_card_topic_group_three);
        this.cXB = (LinearLayout) view.findViewById(d.g.home_card_topic_group_four);
        this.cXC = (TextView) view.findViewById(d.g.home_card_topic_one);
        this.cXD = (TextView) view.findViewById(d.g.home_card_topic_two);
        this.cXE = (TextView) view.findViewById(d.g.home_card_topic_three);
        this.cXF = (TextView) view.findViewById(d.g.home_card_topic_four);
        this.cXG = view.findViewById(d.g.home_top_div);
        this.cXH = view.findViewById(d.g.home_top_topic_div_one);
        this.cXI = view.findViewById(d.g.home_top_topic_div_two);
        this.cXJ = view.findViewById(d.g.home_card_top_divider_line);
        this.cIs = view.findViewById(d.g.home_card_bottom_divider_line);
        this.cXy.setOnClickListener(this);
        this.cXz.setOnClickListener(this);
        this.cXA.setOnClickListener(this);
        this.cXB.setOnClickListener(this);
        this.cXx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.a.e(m.this.akO())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(m.this.akO().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void aI(String str, String str2) {
        this.cXL = str;
        this.cXM = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int h = com.baidu.adp.lib.g.b.h((String) view.getTag(), -1);
        if (this.cXK != null && com.baidu.tbadk.core.util.v.f(this.cXK.daG, h) != null) {
            TiebaStatic.log(new ak(this.cXM).ab("obj_locate", String.valueOf(this.cXK.bZz)).ab("obj_name", this.cXK.daG.get(h).aOb));
            if (h >= 0 && !com.baidu.tbadk.plugins.a.e(akO())) {
                akO().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(akO().getPageActivity()).createNormalConfig(String.valueOf(this.cXK.daG.get(h).aOa), this.cXK.daG.get(h).aOb, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.C0140d.cp_bg_line_d);
            aj.e(this.aIe, d.C0140d.cp_cont_d, 1);
            aj.e(this.cXx, d.C0140d.cp_cont_d, 1);
            aj.e(this.cXC, d.C0140d.cp_cont_b, 1);
            aj.e(this.cXD, d.C0140d.cp_cont_b, 1);
            aj.e(this.cXE, d.C0140d.cp_cont_b, 1);
            aj.e(this.cXF, d.C0140d.cp_cont_b, 1);
            aj.s(this.cXG, d.C0140d.cp_bg_line_b);
            aj.s(this.cXH, d.C0140d.cp_bg_line_b);
            aj.s(this.cXI, d.C0140d.cp_bg_line_b);
            aj.s(this.cXJ, d.C0140d.cp_bg_line_c);
            aj.s(this.cIs, d.C0140d.cp_bg_line_c);
            aj.s(this.cXy, d.f.card_topic_click_selector);
            aj.s(this.cXz, d.f.card_topic_click_selector);
            aj.s(this.cXA, d.f.card_topic_click_selector);
            aj.s(this.cXB, d.f.card_topic_click_selector);
            l(this.cXC, 0);
            l(this.cXD, 1);
            l(this.cXE, 2);
            l(this.cXF, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || StringUtils.isNull(oVar.daF) || com.baidu.tbadk.core.util.v.D(oVar.daG) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cXK = oVar;
        this.cXJ.setVisibility(this.cXK.daD ? 0 : 8);
        showBottomLine(this.cXK.daE);
        this.aIe.setText(this.cXK.daF.trim());
        k(this.cXC, 0);
        k(this.cXD, 1);
        k(this.cXE, 2);
        k(this.cXF, 3);
        l(this.cXC, 0);
        l(this.cXD, 1);
        l(this.cXE, 2);
        l(this.cXF, 3);
    }

    private void k(TextView textView, int i) {
        textView.setText(this.cXK.daG.get(i).aOb.trim());
    }

    private void l(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar;
        if (this.cXK != null && com.baidu.tbadk.core.util.v.D(this.cXK.daG) >= 4 && (nVar = (com.baidu.tieba.card.data.n) com.baidu.tbadk.core.util.v.f(this.cXK.daG, i)) != null) {
            switch (nVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.cIs.setVisibility(0);
        } else {
            this.cIs.setVisibility(8);
        }
    }

    public void lA(int i) {
        ViewGroup.LayoutParams layoutParams = this.cXJ.getLayoutParams();
        layoutParams.height = i;
        this.cXJ.setLayoutParams(layoutParams);
    }
}
