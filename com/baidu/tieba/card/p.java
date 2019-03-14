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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class p extends a<com.baidu.tieba.card.data.n> {
    private TextView btZ;
    private View dTL;
    private LinearLayout eiA;
    private TextView eiB;
    private TextView eiC;
    private TextView eiD;
    private TextView eiE;
    private View eiF;
    private View eiG;
    private View eiH;
    private View eiI;
    private com.baidu.tieba.card.data.n eiJ;
    private String eiK;
    private String eiL;
    private TextView eiw;
    private LinearLayout eix;
    private LinearLayout eiy;
    private LinearLayout eiz;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.home_card_hot_topic_root_view);
        this.btZ = (TextView) view.findViewById(d.g.home_card_topic_title);
        this.eiw = (TextView) view.findViewById(d.g.home_card_topic_more);
        this.eix = (LinearLayout) view.findViewById(d.g.home_card_topic_group_one);
        this.eiy = (LinearLayout) view.findViewById(d.g.home_card_topic_group_two);
        this.eiz = (LinearLayout) view.findViewById(d.g.home_card_topic_group_three);
        this.eiA = (LinearLayout) view.findViewById(d.g.home_card_topic_group_four);
        this.eiB = (TextView) view.findViewById(d.g.home_card_topic_one);
        this.eiC = (TextView) view.findViewById(d.g.home_card_topic_two);
        this.eiD = (TextView) view.findViewById(d.g.home_card_topic_three);
        this.eiE = (TextView) view.findViewById(d.g.home_card_topic_four);
        this.eiF = view.findViewById(d.g.home_top_div);
        this.eiG = view.findViewById(d.g.home_top_topic_div_one);
        this.eiH = view.findViewById(d.g.home_top_topic_div_two);
        this.eiI = view.findViewById(d.g.home_card_top_divider_line);
        this.dTL = view.findViewById(d.g.home_card_bottom_divider_line);
        this.eix.setOnClickListener(this);
        this.eiy.setOnClickListener(this);
        this.eiz.setOnClickListener(this);
        this.eiA.setOnClickListener(this);
        this.eiw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eiK = str;
        this.eiL = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l = com.baidu.adp.lib.g.b.l((String) view.getTag(), -1);
        if (this.eiJ != null && com.baidu.tbadk.core.util.v.c(this.eiJ.elW, l) != null) {
            TiebaStatic.log(new am(this.eiL).bJ("obj_locate", String.valueOf(this.eiJ.locate)).bJ("obj_name", this.eiJ.elW.get(l).bAm));
            if (l >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eiJ.elW.get(l).topicId), this.eiJ.elW.get(l).bAm, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.C0277d.cp_bg_line_d);
            al.d(this.btZ, d.C0277d.cp_cont_d, 1);
            al.d(this.eiw, d.C0277d.cp_cont_d, 1);
            al.d(this.eiB, d.C0277d.cp_cont_b, 1);
            al.d(this.eiC, d.C0277d.cp_cont_b, 1);
            al.d(this.eiD, d.C0277d.cp_cont_b, 1);
            al.d(this.eiE, d.C0277d.cp_cont_b, 1);
            al.k(this.eiF, d.C0277d.cp_bg_line_b);
            al.k(this.eiG, d.C0277d.cp_bg_line_b);
            al.k(this.eiH, d.C0277d.cp_bg_line_b);
            al.k(this.eiI, d.C0277d.cp_bg_line_c);
            al.k(this.dTL, d.C0277d.cp_bg_line_c);
            al.k(this.eix, d.f.card_topic_click_selector);
            al.k(this.eiy, d.f.card_topic_click_selector);
            al.k(this.eiz, d.f.card_topic_click_selector);
            al.k(this.eiA, d.f.card_topic_click_selector);
            j(this.eiB, 0);
            j(this.eiC, 1);
            j(this.eiD, 2);
            j(this.eiE, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.elV) || com.baidu.tbadk.core.util.v.S(nVar.elW) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eiJ = nVar;
        this.eiI.setVisibility(this.eiJ.elT ? 0 : 8);
        showBottomLine(this.eiJ.elU);
        this.btZ.setText(this.eiJ.elV.trim());
        i(this.eiB, 0);
        i(this.eiC, 1);
        i(this.eiD, 2);
        i(this.eiE, 3);
        j(this.eiB, 0);
        j(this.eiC, 1);
        j(this.eiD, 2);
        j(this.eiE, 3);
    }

    private void i(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eiJ.elW.get(i);
        if (!StringUtils.isNull(mVar.bAm)) {
            textView.setText(mVar.bAm.trim());
        }
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eiJ != null && com.baidu.tbadk.core.util.v.S(this.eiJ.elW) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.eiJ.elW, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.dTL.setVisibility(0);
        } else {
            this.dTL.setVisibility(8);
        }
    }

    public void op(int i) {
        ViewGroup.LayoutParams layoutParams = this.eiI.getLayoutParams();
        layoutParams.height = i;
        this.eiI.setLayoutParams(layoutParams);
    }
}
