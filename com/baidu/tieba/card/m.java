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
    private TextView aHT;
    private View cIg;
    private String cXA;
    private TextView cXl;
    private LinearLayout cXm;
    private LinearLayout cXn;
    private LinearLayout cXo;
    private LinearLayout cXp;
    private TextView cXq;
    private TextView cXr;
    private TextView cXs;
    private TextView cXt;
    private View cXu;
    private View cXv;
    private View cXw;
    private View cXx;
    private com.baidu.tieba.card.data.o cXy;
    private String cXz;
    private View mRootView;

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.home_card_hot_topic_root_view);
        this.aHT = (TextView) view.findViewById(d.g.home_card_topic_title);
        this.cXl = (TextView) view.findViewById(d.g.home_card_topic_more);
        this.cXm = (LinearLayout) view.findViewById(d.g.home_card_topic_group_one);
        this.cXn = (LinearLayout) view.findViewById(d.g.home_card_topic_group_two);
        this.cXo = (LinearLayout) view.findViewById(d.g.home_card_topic_group_three);
        this.cXp = (LinearLayout) view.findViewById(d.g.home_card_topic_group_four);
        this.cXq = (TextView) view.findViewById(d.g.home_card_topic_one);
        this.cXr = (TextView) view.findViewById(d.g.home_card_topic_two);
        this.cXs = (TextView) view.findViewById(d.g.home_card_topic_three);
        this.cXt = (TextView) view.findViewById(d.g.home_card_topic_four);
        this.cXu = view.findViewById(d.g.home_top_div);
        this.cXv = view.findViewById(d.g.home_top_topic_div_one);
        this.cXw = view.findViewById(d.g.home_top_topic_div_two);
        this.cXx = view.findViewById(d.g.home_card_top_divider_line);
        this.cIg = view.findViewById(d.g.home_card_bottom_divider_line);
        this.cXm.setOnClickListener(this);
        this.cXn.setOnClickListener(this);
        this.cXo.setOnClickListener(this);
        this.cXp.setOnClickListener(this);
        this.cXl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.a.e(m.this.akN())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(m.this.akN().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void aI(String str, String str2) {
        this.cXz = str;
        this.cXA = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int h = com.baidu.adp.lib.g.b.h((String) view.getTag(), -1);
        if (this.cXy != null && com.baidu.tbadk.core.util.v.f(this.cXy.das, h) != null) {
            TiebaStatic.log(new ak(this.cXA).ab("obj_locate", String.valueOf(this.cXy.bZn)).ab("obj_name", this.cXy.das.get(h).aNQ));
            if (h >= 0 && !com.baidu.tbadk.plugins.a.e(akN())) {
                akN().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(akN().getPageActivity()).createNormalConfig(String.valueOf(this.cXy.das.get(h).aNP), this.cXy.das.get(h).aNQ, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
            aj.e(this.aHT, d.C0141d.cp_cont_d, 1);
            aj.e(this.cXl, d.C0141d.cp_cont_d, 1);
            aj.e(this.cXq, d.C0141d.cp_cont_b, 1);
            aj.e(this.cXr, d.C0141d.cp_cont_b, 1);
            aj.e(this.cXs, d.C0141d.cp_cont_b, 1);
            aj.e(this.cXt, d.C0141d.cp_cont_b, 1);
            aj.s(this.cXu, d.C0141d.cp_bg_line_b);
            aj.s(this.cXv, d.C0141d.cp_bg_line_b);
            aj.s(this.cXw, d.C0141d.cp_bg_line_b);
            aj.s(this.cXx, d.C0141d.cp_bg_line_c);
            aj.s(this.cIg, d.C0141d.cp_bg_line_c);
            aj.s(this.cXm, d.f.card_topic_click_selector);
            aj.s(this.cXn, d.f.card_topic_click_selector);
            aj.s(this.cXo, d.f.card_topic_click_selector);
            aj.s(this.cXp, d.f.card_topic_click_selector);
            l(this.cXq, 0);
            l(this.cXr, 1);
            l(this.cXs, 2);
            l(this.cXt, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || StringUtils.isNull(oVar.dar) || com.baidu.tbadk.core.util.v.D(oVar.das) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cXy = oVar;
        this.cXx.setVisibility(this.cXy.dap ? 0 : 8);
        showBottomLine(this.cXy.daq);
        this.aHT.setText(this.cXy.dar.trim());
        k(this.cXq, 0);
        k(this.cXr, 1);
        k(this.cXs, 2);
        k(this.cXt, 3);
        l(this.cXq, 0);
        l(this.cXr, 1);
        l(this.cXs, 2);
        l(this.cXt, 3);
    }

    private void k(TextView textView, int i) {
        textView.setText(this.cXy.das.get(i).aNQ.trim());
    }

    private void l(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar;
        if (this.cXy != null && com.baidu.tbadk.core.util.v.D(this.cXy.das) >= 4 && (nVar = (com.baidu.tieba.card.data.n) com.baidu.tbadk.core.util.v.f(this.cXy.das, i)) != null) {
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
            this.cIg.setVisibility(0);
        } else {
            this.cIg.setVisibility(8);
        }
    }

    public void lA(int i) {
        ViewGroup.LayoutParams layoutParams = this.cXx.getLayoutParams();
        layoutParams.height = i;
        this.cXx.setLayoutParams(layoutParams);
    }
}
