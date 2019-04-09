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
    private TextView bud;
    private View dTe;
    private TextView eij;
    private LinearLayout eik;
    private LinearLayout eil;
    private LinearLayout eim;
    private LinearLayout ein;
    private TextView eio;
    private TextView eip;
    private TextView eiq;
    private TextView eir;
    private View eis;
    private View eit;
    private View eiu;
    private View eiv;
    private com.baidu.tieba.card.data.n eiw;
    private String eix;
    private String eiy;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.home_card_hot_topic_root_view);
        this.bud = (TextView) view.findViewById(d.g.home_card_topic_title);
        this.eij = (TextView) view.findViewById(d.g.home_card_topic_more);
        this.eik = (LinearLayout) view.findViewById(d.g.home_card_topic_group_one);
        this.eil = (LinearLayout) view.findViewById(d.g.home_card_topic_group_two);
        this.eim = (LinearLayout) view.findViewById(d.g.home_card_topic_group_three);
        this.ein = (LinearLayout) view.findViewById(d.g.home_card_topic_group_four);
        this.eio = (TextView) view.findViewById(d.g.home_card_topic_one);
        this.eip = (TextView) view.findViewById(d.g.home_card_topic_two);
        this.eiq = (TextView) view.findViewById(d.g.home_card_topic_three);
        this.eir = (TextView) view.findViewById(d.g.home_card_topic_four);
        this.eis = view.findViewById(d.g.home_top_div);
        this.eit = view.findViewById(d.g.home_top_topic_div_one);
        this.eiu = view.findViewById(d.g.home_top_topic_div_two);
        this.eiv = view.findViewById(d.g.home_card_top_divider_line);
        this.dTe = view.findViewById(d.g.home_card_bottom_divider_line);
        this.eik.setOnClickListener(this);
        this.eil.setOnClickListener(this);
        this.eim.setOnClickListener(this);
        this.ein.setOnClickListener(this);
        this.eij.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.f(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.eix = str;
        this.eiy = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l = com.baidu.adp.lib.g.b.l((String) view.getTag(), -1);
        if (this.eiw != null && com.baidu.tbadk.core.util.v.c(this.eiw.elJ, l) != null) {
            TiebaStatic.log(new am(this.eiy).bJ("obj_locate", String.valueOf(this.eiw.locate)).bJ("obj_name", this.eiw.elJ.get(l).bAq));
            if (l >= 0 && !com.baidu.tbadk.plugins.b.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.eiw.elJ.get(l).topicId), this.eiw.elJ.get(l).bAq, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(this.mRootView, d.C0277d.cp_bg_line_d);
            al.d(this.bud, d.C0277d.cp_cont_d, 1);
            al.d(this.eij, d.C0277d.cp_cont_d, 1);
            al.d(this.eio, d.C0277d.cp_cont_b, 1);
            al.d(this.eip, d.C0277d.cp_cont_b, 1);
            al.d(this.eiq, d.C0277d.cp_cont_b, 1);
            al.d(this.eir, d.C0277d.cp_cont_b, 1);
            al.k(this.eis, d.C0277d.cp_bg_line_b);
            al.k(this.eit, d.C0277d.cp_bg_line_b);
            al.k(this.eiu, d.C0277d.cp_bg_line_b);
            al.k(this.eiv, d.C0277d.cp_bg_line_c);
            al.k(this.dTe, d.C0277d.cp_bg_line_c);
            al.k(this.eik, d.f.card_topic_click_selector);
            al.k(this.eil, d.f.card_topic_click_selector);
            al.k(this.eim, d.f.card_topic_click_selector);
            al.k(this.ein, d.f.card_topic_click_selector);
            j(this.eio, 0);
            j(this.eip, 1);
            j(this.eiq, 2);
            j(this.eir, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.elI) || com.baidu.tbadk.core.util.v.S(nVar.elJ) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eiw = nVar;
        this.eiv.setVisibility(this.eiw.elG ? 0 : 8);
        showBottomLine(this.eiw.elH);
        this.bud.setText(this.eiw.elI.trim());
        i(this.eio, 0);
        i(this.eip, 1);
        i(this.eiq, 2);
        i(this.eir, 3);
        j(this.eio, 0);
        j(this.eip, 1);
        j(this.eiq, 2);
        j(this.eir, 3);
    }

    private void i(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.eiw.elJ.get(i);
        if (!StringUtils.isNull(mVar.bAq)) {
            textView.setText(mVar.bAq.trim());
        }
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.eiw != null && com.baidu.tbadk.core.util.v.S(this.eiw.elJ) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.eiw.elJ, i)) != null) {
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
            this.dTe.setVisibility(0);
        } else {
            this.dTe.setVisibility(8);
        }
    }

    public void ol(int i) {
        ViewGroup.LayoutParams layoutParams = this.eiv.getLayoutParams();
        layoutParams.height = i;
        this.eiv.setLayoutParams(layoutParams);
    }
}
