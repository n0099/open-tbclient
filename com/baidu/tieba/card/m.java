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
    private TextView aHU;
    private View cIj;
    private View cXA;
    private com.baidu.tieba.card.data.o cXB;
    private String cXC;
    private String cXD;
    private TextView cXo;
    private LinearLayout cXp;
    private LinearLayout cXq;
    private LinearLayout cXr;
    private LinearLayout cXs;
    private TextView cXt;
    private TextView cXu;
    private TextView cXv;
    private TextView cXw;
    private View cXx;
    private View cXy;
    private View cXz;
    private View mRootView;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.home_card_hot_topic_root_view);
        this.aHU = (TextView) view.findViewById(d.g.home_card_topic_title);
        this.cXo = (TextView) view.findViewById(d.g.home_card_topic_more);
        this.cXp = (LinearLayout) view.findViewById(d.g.home_card_topic_group_one);
        this.cXq = (LinearLayout) view.findViewById(d.g.home_card_topic_group_two);
        this.cXr = (LinearLayout) view.findViewById(d.g.home_card_topic_group_three);
        this.cXs = (LinearLayout) view.findViewById(d.g.home_card_topic_group_four);
        this.cXt = (TextView) view.findViewById(d.g.home_card_topic_one);
        this.cXu = (TextView) view.findViewById(d.g.home_card_topic_two);
        this.cXv = (TextView) view.findViewById(d.g.home_card_topic_three);
        this.cXw = (TextView) view.findViewById(d.g.home_card_topic_four);
        this.cXx = view.findViewById(d.g.home_top_div);
        this.cXy = view.findViewById(d.g.home_top_topic_div_one);
        this.cXz = view.findViewById(d.g.home_top_topic_div_two);
        this.cXA = view.findViewById(d.g.home_card_top_divider_line);
        this.cIj = view.findViewById(d.g.home_card_bottom_divider_line);
        this.cXp.setOnClickListener(this);
        this.cXq.setOnClickListener(this);
        this.cXr.setOnClickListener(this);
        this.cXs.setOnClickListener(this);
        this.cXo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.a.e(m.this.akO())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(m.this.akO().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void aI(String str, String str2) {
        this.cXC = str;
        this.cXD = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int h = com.baidu.adp.lib.g.b.h((String) view.getTag(), -1);
        if (this.cXB != null && com.baidu.tbadk.core.util.v.f(this.cXB.daw, h) != null) {
            TiebaStatic.log(new ak(this.cXD).ab("obj_locate", String.valueOf(this.cXB.bZq)).ab("obj_name", this.cXB.daw.get(h).aNR));
            if (h >= 0 && !com.baidu.tbadk.plugins.a.e(akO())) {
                akO().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(akO().getPageActivity()).createNormalConfig(String.valueOf(this.cXB.daw.get(h).aNQ), this.cXB.daw.get(h).aNR, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
            aj.e(this.aHU, d.C0141d.cp_cont_d, 1);
            aj.e(this.cXo, d.C0141d.cp_cont_d, 1);
            aj.e(this.cXt, d.C0141d.cp_cont_b, 1);
            aj.e(this.cXu, d.C0141d.cp_cont_b, 1);
            aj.e(this.cXv, d.C0141d.cp_cont_b, 1);
            aj.e(this.cXw, d.C0141d.cp_cont_b, 1);
            aj.s(this.cXx, d.C0141d.cp_bg_line_b);
            aj.s(this.cXy, d.C0141d.cp_bg_line_b);
            aj.s(this.cXz, d.C0141d.cp_bg_line_b);
            aj.s(this.cXA, d.C0141d.cp_bg_line_c);
            aj.s(this.cIj, d.C0141d.cp_bg_line_c);
            aj.s(this.cXp, d.f.card_topic_click_selector);
            aj.s(this.cXq, d.f.card_topic_click_selector);
            aj.s(this.cXr, d.f.card_topic_click_selector);
            aj.s(this.cXs, d.f.card_topic_click_selector);
            l(this.cXt, 0);
            l(this.cXu, 1);
            l(this.cXv, 2);
            l(this.cXw, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || StringUtils.isNull(oVar.dav) || com.baidu.tbadk.core.util.v.D(oVar.daw) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cXB = oVar;
        this.cXA.setVisibility(this.cXB.das ? 0 : 8);
        showBottomLine(this.cXB.dau);
        this.aHU.setText(this.cXB.dav.trim());
        k(this.cXt, 0);
        k(this.cXu, 1);
        k(this.cXv, 2);
        k(this.cXw, 3);
        l(this.cXt, 0);
        l(this.cXu, 1);
        l(this.cXv, 2);
        l(this.cXw, 3);
    }

    private void k(TextView textView, int i) {
        textView.setText(this.cXB.daw.get(i).aNR.trim());
    }

    private void l(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar;
        if (this.cXB != null && com.baidu.tbadk.core.util.v.D(this.cXB.daw) >= 4 && (nVar = (com.baidu.tieba.card.data.n) com.baidu.tbadk.core.util.v.f(this.cXB.daw, i)) != null) {
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
            this.cIj.setVisibility(0);
        } else {
            this.cIj.setVisibility(8);
        }
    }

    public void lA(int i) {
        ViewGroup.LayoutParams layoutParams = this.cXA.getLayoutParams();
        layoutParams.height = i;
        this.cXA.setLayoutParams(layoutParams);
    }
}
