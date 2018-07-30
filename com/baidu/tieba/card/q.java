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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class q extends a<com.baidu.tieba.card.data.n> {
    private TextView aaW;
    private View cli;
    private String czA;
    private TextView czl;
    private LinearLayout czm;
    private LinearLayout czn;
    private LinearLayout czo;
    private LinearLayout czp;
    private TextView czq;
    private TextView czr;
    private TextView czs;
    private TextView czt;
    private View czu;
    private View czv;
    private View czw;
    private View czx;
    private com.baidu.tieba.card.data.n czy;
    private String czz;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.home_card_hot_topic_root_view);
        this.aaW = (TextView) view.findViewById(d.g.home_card_topic_title);
        this.czl = (TextView) view.findViewById(d.g.home_card_topic_more);
        this.czm = (LinearLayout) view.findViewById(d.g.home_card_topic_group_one);
        this.czn = (LinearLayout) view.findViewById(d.g.home_card_topic_group_two);
        this.czo = (LinearLayout) view.findViewById(d.g.home_card_topic_group_three);
        this.czp = (LinearLayout) view.findViewById(d.g.home_card_topic_group_four);
        this.czq = (TextView) view.findViewById(d.g.home_card_topic_one);
        this.czr = (TextView) view.findViewById(d.g.home_card_topic_two);
        this.czs = (TextView) view.findViewById(d.g.home_card_topic_three);
        this.czt = (TextView) view.findViewById(d.g.home_card_topic_four);
        this.czu = view.findViewById(d.g.home_top_div);
        this.czv = view.findViewById(d.g.home_top_topic_div_one);
        this.czw = view.findViewById(d.g.home_top_topic_div_two);
        this.czx = view.findViewById(d.g.home_card_top_divider_line);
        this.cli = view.findViewById(d.g.home_card_bottom_divider_line);
        this.czm.setOnClickListener(this);
        this.czn.setOnClickListener(this);
        this.czo.setOnClickListener(this);
        this.czp.setOnClickListener(this);
        this.czl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.aiy())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.aiy().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.czz = str;
        this.czA = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.g.b.g((String) view.getTag(), -1);
        if (this.czy != null && com.baidu.tbadk.core.util.w.d(this.czy.cCA, g) != null) {
            TiebaStatic.log(new an(this.czA).af("obj_locate", String.valueOf(this.czy.btR)).af("obj_name", this.czy.cCA.get(g).ahd));
            if (g >= 0 && !com.baidu.tbadk.plugins.b.e(aiy())) {
                aiy().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(aiy().getPageActivity()).createNormalConfig(String.valueOf(this.czy.cCA.get(g).ahc), this.czy.cCA.get(g).ahd, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, d.C0140d.cp_bg_line_d);
            am.c(this.aaW, d.C0140d.cp_cont_d, 1);
            am.c(this.czl, d.C0140d.cp_cont_d, 1);
            am.c(this.czq, d.C0140d.cp_cont_b, 1);
            am.c(this.czr, d.C0140d.cp_cont_b, 1);
            am.c(this.czs, d.C0140d.cp_cont_b, 1);
            am.c(this.czt, d.C0140d.cp_cont_b, 1);
            am.i(this.czu, d.C0140d.cp_bg_line_b);
            am.i(this.czv, d.C0140d.cp_bg_line_b);
            am.i(this.czw, d.C0140d.cp_bg_line_b);
            am.i(this.czx, d.C0140d.cp_bg_line_c);
            am.i(this.cli, d.C0140d.cp_bg_line_c);
            am.i(this.czm, d.f.card_topic_click_selector);
            am.i(this.czn, d.f.card_topic_click_selector);
            am.i(this.czo, d.f.card_topic_click_selector);
            am.i(this.czp, d.f.card_topic_click_selector);
            k(this.czq, 0);
            k(this.czr, 1);
            k(this.czs, 2);
            k(this.czt, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.cCz) || com.baidu.tbadk.core.util.w.y(nVar.cCA) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.czy = nVar;
        this.czx.setVisibility(this.czy.cCx ? 0 : 8);
        showBottomLine(this.czy.cCy);
        this.aaW.setText(this.czy.cCz.trim());
        j(this.czq, 0);
        j(this.czr, 1);
        j(this.czs, 2);
        j(this.czt, 3);
        k(this.czq, 0);
        k(this.czr, 1);
        k(this.czs, 2);
        k(this.czt, 3);
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.czy.cCA.get(i);
        if (!StringUtils.isNull(mVar.ahd)) {
            textView.setText(mVar.ahd.trim());
        }
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.czy != null && com.baidu.tbadk.core.util.w.y(this.czy.cCA) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.w.d(this.czy.cCA, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.cli.setVisibility(0);
        } else {
            this.cli.setVisibility(8);
        }
    }

    public void iT(int i) {
        ViewGroup.LayoutParams layoutParams = this.czx.getLayoutParams();
        layoutParams.height = i;
        this.czx.setLayoutParams(layoutParams);
    }
}
