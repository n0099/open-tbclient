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
    private TextView buc;
    private View dTd;
    private TextView eii;
    private LinearLayout eij;
    private LinearLayout eik;
    private LinearLayout eil;
    private LinearLayout eim;
    private TextView ein;
    private TextView eio;
    private TextView eip;
    private TextView eiq;
    private View eir;
    private View eis;
    private View eit;
    private View eiu;
    private com.baidu.tieba.card.data.n eiv;
    private String eiw;
    private String eix;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.home_card_hot_topic_root_view);
        this.buc = (TextView) view.findViewById(d.g.home_card_topic_title);
        this.eii = (TextView) view.findViewById(d.g.home_card_topic_more);
        this.eij = (LinearLayout) view.findViewById(d.g.home_card_topic_group_one);
        this.eik = (LinearLayout) view.findViewById(d.g.home_card_topic_group_two);
        this.eil = (LinearLayout) view.findViewById(d.g.home_card_topic_group_three);
        this.eim = (LinearLayout) view.findViewById(d.g.home_card_topic_group_four);
        this.ein = (TextView) view.findViewById(d.g.home_card_topic_one);
        this.eio = (TextView) view.findViewById(d.g.home_card_topic_two);
        this.eip = (TextView) view.findViewById(d.g.home_card_topic_three);
        this.eiq = (TextView) view.findViewById(d.g.home_card_topic_four);
        this.eir = view.findViewById(d.g.home_top_div);
        this.eis = view.findViewById(d.g.home_top_topic_div_one);
        this.eit = view.findViewById(d.g.home_top_topic_div_two);
        this.eiu = view.findViewById(d.g.home_card_top_divider_line);
        this.dTd = view.findViewById(d.g.home_card_bottom_divider_line);
        this.eij.setOnClickListener(this);
        this.eik.setOnClickListener(this);
        this.eil.setOnClickListener(this);
        this.eim.setOnClickListener(this);
        this.eii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eiw = str;
        this.eix = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l = com.baidu.adp.lib.g.b.l((String) view.getTag(), -1);
        if (this.eiv != null && com.baidu.tbadk.core.util.v.c(this.eiv.elI, l) != null) {
            TiebaStatic.log(new am(this.eix).bJ("obj_locate", String.valueOf(this.eiv.locate)).bJ("obj_name", this.eiv.elI.get(l).bAp));
            if (l >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eiv.elI.get(l).topicId), this.eiv.elI.get(l).bAp, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.C0277d.cp_bg_line_d);
            al.d(this.buc, d.C0277d.cp_cont_d, 1);
            al.d(this.eii, d.C0277d.cp_cont_d, 1);
            al.d(this.ein, d.C0277d.cp_cont_b, 1);
            al.d(this.eio, d.C0277d.cp_cont_b, 1);
            al.d(this.eip, d.C0277d.cp_cont_b, 1);
            al.d(this.eiq, d.C0277d.cp_cont_b, 1);
            al.k(this.eir, d.C0277d.cp_bg_line_b);
            al.k(this.eis, d.C0277d.cp_bg_line_b);
            al.k(this.eit, d.C0277d.cp_bg_line_b);
            al.k(this.eiu, d.C0277d.cp_bg_line_c);
            al.k(this.dTd, d.C0277d.cp_bg_line_c);
            al.k(this.eij, d.f.card_topic_click_selector);
            al.k(this.eik, d.f.card_topic_click_selector);
            al.k(this.eil, d.f.card_topic_click_selector);
            al.k(this.eim, d.f.card_topic_click_selector);
            j(this.ein, 0);
            j(this.eio, 1);
            j(this.eip, 2);
            j(this.eiq, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.elH) || com.baidu.tbadk.core.util.v.S(nVar.elI) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eiv = nVar;
        this.eiu.setVisibility(this.eiv.elF ? 0 : 8);
        showBottomLine(this.eiv.elG);
        this.buc.setText(this.eiv.elH.trim());
        i(this.ein, 0);
        i(this.eio, 1);
        i(this.eip, 2);
        i(this.eiq, 3);
        j(this.ein, 0);
        j(this.eio, 1);
        j(this.eip, 2);
        j(this.eiq, 3);
    }

    private void i(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eiv.elI.get(i);
        if (!StringUtils.isNull(mVar.bAp)) {
            textView.setText(mVar.bAp.trim());
        }
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eiv != null && com.baidu.tbadk.core.util.v.S(this.eiv.elI) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.eiv.elI, i)) != null) {
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
            this.dTd.setVisibility(0);
        } else {
            this.dTd.setVisibility(8);
        }
    }

    public void ol(int i) {
        ViewGroup.LayoutParams layoutParams = this.eiu.getLayoutParams();
        layoutParams.height = i;
        this.eiu.setLayoutParams(layoutParams);
    }
}
