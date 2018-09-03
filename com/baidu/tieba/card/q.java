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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class q extends a<com.baidu.tieba.card.data.n> {
    private TextView aaX;
    private View clf;
    private TextView czi;
    private LinearLayout czj;
    private LinearLayout czk;
    private LinearLayout czl;
    private LinearLayout czm;
    private TextView czn;
    private TextView czo;
    private TextView czp;
    private TextView czq;
    private View czr;
    private View czs;
    private View czt;
    private View czu;
    private com.baidu.tieba.card.data.n czv;
    private String czw;
    private String czx;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(f.g.home_card_hot_topic_root_view);
        this.aaX = (TextView) view.findViewById(f.g.home_card_topic_title);
        this.czi = (TextView) view.findViewById(f.g.home_card_topic_more);
        this.czj = (LinearLayout) view.findViewById(f.g.home_card_topic_group_one);
        this.czk = (LinearLayout) view.findViewById(f.g.home_card_topic_group_two);
        this.czl = (LinearLayout) view.findViewById(f.g.home_card_topic_group_three);
        this.czm = (LinearLayout) view.findViewById(f.g.home_card_topic_group_four);
        this.czn = (TextView) view.findViewById(f.g.home_card_topic_one);
        this.czo = (TextView) view.findViewById(f.g.home_card_topic_two);
        this.czp = (TextView) view.findViewById(f.g.home_card_topic_three);
        this.czq = (TextView) view.findViewById(f.g.home_card_topic_four);
        this.czr = view.findViewById(f.g.home_top_div);
        this.czs = view.findViewById(f.g.home_top_topic_div_one);
        this.czt = view.findViewById(f.g.home_top_topic_div_two);
        this.czu = view.findViewById(f.g.home_card_top_divider_line);
        this.clf = view.findViewById(f.g.home_card_bottom_divider_line);
        this.czj.setOnClickListener(this);
        this.czk.setOnClickListener(this);
        this.czl.setOnClickListener(this);
        this.czm.setOnClickListener(this);
        this.czi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.aiB())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.aiB().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.czw = str;
        this.czx = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.g.b.g((String) view.getTag(), -1);
        if (this.czv != null && com.baidu.tbadk.core.util.w.d(this.czv.cCx, g) != null) {
            TiebaStatic.log(new an(this.czx).ae("obj_locate", String.valueOf(this.czv.btT)).ae("obj_name", this.czv.cCx.get(g).ahd));
            if (g >= 0 && !com.baidu.tbadk.plugins.b.e(aiB())) {
                aiB().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(aiB().getPageActivity()).createNormalConfig(String.valueOf(this.czv.cCx.get(g).ahc), this.czv.cCx.get(g).ahd, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, f.d.cp_bg_line_d);
            am.c(this.aaX, f.d.cp_cont_d, 1);
            am.c(this.czi, f.d.cp_cont_d, 1);
            am.c(this.czn, f.d.cp_cont_b, 1);
            am.c(this.czo, f.d.cp_cont_b, 1);
            am.c(this.czp, f.d.cp_cont_b, 1);
            am.c(this.czq, f.d.cp_cont_b, 1);
            am.i(this.czr, f.d.cp_bg_line_b);
            am.i(this.czs, f.d.cp_bg_line_b);
            am.i(this.czt, f.d.cp_bg_line_b);
            am.i(this.czu, f.d.cp_bg_line_c);
            am.i(this.clf, f.d.cp_bg_line_c);
            am.i(this.czj, f.C0146f.card_topic_click_selector);
            am.i(this.czk, f.C0146f.card_topic_click_selector);
            am.i(this.czl, f.C0146f.card_topic_click_selector);
            am.i(this.czm, f.C0146f.card_topic_click_selector);
            k(this.czn, 0);
            k(this.czo, 1);
            k(this.czp, 2);
            k(this.czq, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.cCw) || com.baidu.tbadk.core.util.w.y(nVar.cCx) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.czv = nVar;
        this.czu.setVisibility(this.czv.cCu ? 0 : 8);
        showBottomLine(this.czv.cCv);
        this.aaX.setText(this.czv.cCw.trim());
        j(this.czn, 0);
        j(this.czo, 1);
        j(this.czp, 2);
        j(this.czq, 3);
        k(this.czn, 0);
        k(this.czo, 1);
        k(this.czp, 2);
        k(this.czq, 3);
    }

    private void j(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.czv.cCx.get(i);
        if (!StringUtils.isNull(mVar.ahd)) {
            textView.setText(mVar.ahd.trim());
        }
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.czv != null && com.baidu.tbadk.core.util.w.y(this.czv.cCx) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.w.d(this.czv.cCx, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(f.C0146f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.clf.setVisibility(0);
        } else {
            this.clf.setVisibility(8);
        }
    }

    public void iS(int i) {
        ViewGroup.LayoutParams layoutParams = this.czu.getLayoutParams();
        layoutParams.height = i;
        this.czu.setLayoutParams(layoutParams);
    }
}
