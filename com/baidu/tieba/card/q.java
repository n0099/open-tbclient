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
    private TextView amN;
    private View cFB;
    private TextView cXX;
    private LinearLayout cXY;
    private LinearLayout cXZ;
    private LinearLayout cYa;
    private LinearLayout cYb;
    private TextView cYc;
    private TextView cYd;
    private TextView cYe;
    private TextView cYf;
    private View cYg;
    private View cYh;
    private View cYi;
    private View cYj;
    private com.baidu.tieba.card.data.n cYk;
    private String cYl;
    private String cYm;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.home_card_hot_topic_root_view);
        this.amN = (TextView) view.findViewById(e.g.home_card_topic_title);
        this.cXX = (TextView) view.findViewById(e.g.home_card_topic_more);
        this.cXY = (LinearLayout) view.findViewById(e.g.home_card_topic_group_one);
        this.cXZ = (LinearLayout) view.findViewById(e.g.home_card_topic_group_two);
        this.cYa = (LinearLayout) view.findViewById(e.g.home_card_topic_group_three);
        this.cYb = (LinearLayout) view.findViewById(e.g.home_card_topic_group_four);
        this.cYc = (TextView) view.findViewById(e.g.home_card_topic_one);
        this.cYd = (TextView) view.findViewById(e.g.home_card_topic_two);
        this.cYe = (TextView) view.findViewById(e.g.home_card_topic_three);
        this.cYf = (TextView) view.findViewById(e.g.home_card_topic_four);
        this.cYg = view.findViewById(e.g.home_top_div);
        this.cYh = view.findViewById(e.g.home_top_topic_div_one);
        this.cYi = view.findViewById(e.g.home_top_topic_div_two);
        this.cYj = view.findViewById(e.g.home_card_top_divider_line);
        this.cFB = view.findViewById(e.g.home_card_bottom_divider_line);
        this.cXY.setOnClickListener(this);
        this.cXZ.setOnClickListener(this);
        this.cYa.setOnClickListener(this);
        this.cYb.setOnClickListener(this);
        this.cXX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cYl = str;
        this.cYm = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l = com.baidu.adp.lib.g.b.l((String) view.getTag(), -1);
        if (this.cYk != null && com.baidu.tbadk.core.util.v.d(this.cYk.dbm, l) != null) {
            TiebaStatic.log(new am(this.cYm).aA("obj_locate", String.valueOf(this.cYk.bMU)).aA("obj_name", this.cYk.dbm.get(l).asM));
            if (l >= 0 && !com.baidu.tbadk.plugins.b.e(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.cYk.dbm.get(l).asL), this.cYk.dbm.get(l).asM, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.amN, e.d.cp_cont_d, 1);
            al.c(this.cXX, e.d.cp_cont_d, 1);
            al.c(this.cYc, e.d.cp_cont_b, 1);
            al.c(this.cYd, e.d.cp_cont_b, 1);
            al.c(this.cYe, e.d.cp_cont_b, 1);
            al.c(this.cYf, e.d.cp_cont_b, 1);
            al.i(this.cYg, e.d.cp_bg_line_b);
            al.i(this.cYh, e.d.cp_bg_line_b);
            al.i(this.cYi, e.d.cp_bg_line_b);
            al.i(this.cYj, e.d.cp_bg_line_c);
            al.i(this.cFB, e.d.cp_bg_line_c);
            al.i(this.cXY, e.f.card_topic_click_selector);
            al.i(this.cXZ, e.f.card_topic_click_selector);
            al.i(this.cYa, e.f.card_topic_click_selector);
            al.i(this.cYb, e.f.card_topic_click_selector);
            l(this.cYc, 0);
            l(this.cYd, 1);
            l(this.cYe, 2);
            l(this.cYf, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.dbl) || com.baidu.tbadk.core.util.v.H(nVar.dbm) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cYk = nVar;
        this.cYj.setVisibility(this.cYk.dbj ? 0 : 8);
        showBottomLine(this.cYk.dbk);
        this.amN.setText(this.cYk.dbl.trim());
        k(this.cYc, 0);
        k(this.cYd, 1);
        k(this.cYe, 2);
        k(this.cYf, 3);
        l(this.cYc, 0);
        l(this.cYd, 1);
        l(this.cYe, 2);
        l(this.cYf, 3);
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.cYk.dbm.get(i);
        if (!StringUtils.isNull(mVar.asM)) {
            textView.setText(mVar.asM.trim());
        }
    }

    private void l(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cYk != null && com.baidu.tbadk.core.util.v.H(this.cYk.dbm) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.d(this.cYk.dbm, i)) != null) {
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
            this.cFB.setVisibility(0);
        } else {
            this.cFB.setVisibility(8);
        }
    }

    public void kM(int i) {
        ViewGroup.LayoutParams layoutParams = this.cYj.getLayoutParams();
        layoutParams.height = i;
        this.cYj.setLayoutParams(layoutParams);
    }
}
