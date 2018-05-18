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
    private TextView Ti;
    private View bZm;
    private String cqA;
    private TextView cql;
    private LinearLayout cqm;
    private LinearLayout cqn;
    private LinearLayout cqo;
    private LinearLayout cqp;
    private TextView cqq;
    private TextView cqr;
    private TextView cqs;
    private TextView cqt;
    private View cqu;
    private View cqv;
    private View cqw;
    private View cqx;
    private com.baidu.tieba.card.data.n cqy;
    private String cqz;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.home_card_hot_topic_root_view);
        this.Ti = (TextView) view2.findViewById(d.g.home_card_topic_title);
        this.cql = (TextView) view2.findViewById(d.g.home_card_topic_more);
        this.cqm = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_one);
        this.cqn = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_two);
        this.cqo = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_three);
        this.cqp = (LinearLayout) view2.findViewById(d.g.home_card_topic_group_four);
        this.cqq = (TextView) view2.findViewById(d.g.home_card_topic_one);
        this.cqr = (TextView) view2.findViewById(d.g.home_card_topic_two);
        this.cqs = (TextView) view2.findViewById(d.g.home_card_topic_three);
        this.cqt = (TextView) view2.findViewById(d.g.home_card_topic_four);
        this.cqu = view2.findViewById(d.g.home_top_div);
        this.cqv = view2.findViewById(d.g.home_top_topic_div_one);
        this.cqw = view2.findViewById(d.g.home_top_topic_div_two);
        this.cqx = view2.findViewById(d.g.home_card_top_divider_line);
        this.bZm = view2.findViewById(d.g.home_card_bottom_divider_line);
        this.cqm.setOnClickListener(this);
        this.cqn.setOnClickListener(this);
        this.cqo.setOnClickListener(this);
        this.cqp.setOnClickListener(this);
        this.cql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.aeY())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.aeY().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cqz = str;
        this.cqA = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int g = com.baidu.adp.lib.g.b.g((String) view2.getTag(), -1);
        if (this.cqy != null && com.baidu.tbadk.core.util.v.c(this.cqy.ctw, g) != null) {
            TiebaStatic.log(new al(this.cqA).ac("obj_locate", String.valueOf(this.cqy.bjG)).ac("obj_name", this.cqy.ctw.get(g).Zo));
            if (g >= 0 && !com.baidu.tbadk.plugins.b.e(aeY())) {
                aeY().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(aeY().getPageActivity()).createNormalConfig(String.valueOf(this.cqy.ctw.get(g).Zn), this.cqy.ctw.get(g).Zo, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
            ak.c(this.Ti, d.C0126d.cp_cont_d, 1);
            ak.c(this.cql, d.C0126d.cp_cont_d, 1);
            ak.c(this.cqq, d.C0126d.cp_cont_b, 1);
            ak.c(this.cqr, d.C0126d.cp_cont_b, 1);
            ak.c(this.cqs, d.C0126d.cp_cont_b, 1);
            ak.c(this.cqt, d.C0126d.cp_cont_b, 1);
            ak.i(this.cqu, d.C0126d.cp_bg_line_b);
            ak.i(this.cqv, d.C0126d.cp_bg_line_b);
            ak.i(this.cqw, d.C0126d.cp_bg_line_b);
            ak.i(this.cqx, d.C0126d.cp_bg_line_c);
            ak.i(this.bZm, d.C0126d.cp_bg_line_c);
            ak.i(this.cqm, d.f.card_topic_click_selector);
            ak.i(this.cqn, d.f.card_topic_click_selector);
            ak.i(this.cqo, d.f.card_topic_click_selector);
            ak.i(this.cqp, d.f.card_topic_click_selector);
            k(this.cqq, 0);
            k(this.cqr, 1);
            k(this.cqs, 2);
            k(this.cqt, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.ctv) || com.baidu.tbadk.core.util.v.v(nVar.ctw) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cqy = nVar;
        this.cqx.setVisibility(this.cqy.ctt ? 0 : 8);
        showBottomLine(this.cqy.ctu);
        this.Ti.setText(this.cqy.ctv.trim());
        j(this.cqq, 0);
        j(this.cqr, 1);
        j(this.cqs, 2);
        j(this.cqt, 3);
        k(this.cqq, 0);
        k(this.cqr, 1);
        k(this.cqs, 2);
        k(this.cqt, 3);
    }

    private void j(TextView textView, int i) {
        textView.setText(this.cqy.ctw.get(i).Zo.trim());
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cqy != null && com.baidu.tbadk.core.util.v.v(this.cqy.ctw) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.c(this.cqy.ctw, i)) != null) {
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
            this.bZm.setVisibility(0);
        } else {
            this.bZm.setVisibility(8);
        }
    }

    public void iK(int i) {
        ViewGroup.LayoutParams layoutParams = this.cqx.getLayoutParams();
        layoutParams.height = i;
        this.cqx.setLayoutParams(layoutParams);
    }
}
