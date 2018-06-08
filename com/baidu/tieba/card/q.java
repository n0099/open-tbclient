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
/* loaded from: classes3.dex */
public class q extends a<com.baidu.tieba.card.data.n> {
    private TextView abq;
    private View chp;
    private TextView cyO;
    private LinearLayout cyP;
    private LinearLayout cyQ;
    private LinearLayout cyR;
    private LinearLayout cyS;
    private TextView cyT;
    private TextView cyU;
    private TextView cyV;
    private TextView cyW;
    private View cyX;
    private View cyY;
    private View cyZ;
    private View cza;
    private com.baidu.tieba.card.data.n czb;
    private String czc;
    private String czd;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.home_card_hot_topic_root_view);
        this.abq = (TextView) view.findViewById(d.g.home_card_topic_title);
        this.cyO = (TextView) view.findViewById(d.g.home_card_topic_more);
        this.cyP = (LinearLayout) view.findViewById(d.g.home_card_topic_group_one);
        this.cyQ = (LinearLayout) view.findViewById(d.g.home_card_topic_group_two);
        this.cyR = (LinearLayout) view.findViewById(d.g.home_card_topic_group_three);
        this.cyS = (LinearLayout) view.findViewById(d.g.home_card_topic_group_four);
        this.cyT = (TextView) view.findViewById(d.g.home_card_topic_one);
        this.cyU = (TextView) view.findViewById(d.g.home_card_topic_two);
        this.cyV = (TextView) view.findViewById(d.g.home_card_topic_three);
        this.cyW = (TextView) view.findViewById(d.g.home_card_topic_four);
        this.cyX = view.findViewById(d.g.home_top_div);
        this.cyY = view.findViewById(d.g.home_top_topic_div_one);
        this.cyZ = view.findViewById(d.g.home_top_topic_div_two);
        this.cza = view.findViewById(d.g.home_card_top_divider_line);
        this.chp = view.findViewById(d.g.home_card_bottom_divider_line);
        this.cyP.setOnClickListener(this);
        this.cyQ.setOnClickListener(this);
        this.cyR.setOnClickListener(this);
        this.cyS.setOnClickListener(this);
        this.cyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.aiH())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.aiH().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.czc = str;
        this.czd = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.g.b.g((String) view.getTag(), -1);
        if (this.czb != null && com.baidu.tbadk.core.util.w.c(this.czb.cCb, g) != null) {
            TiebaStatic.log(new am(this.czd).ah("obj_locate", String.valueOf(this.czb.brK)).ah("obj_name", this.czb.cCb.get(g).ahq));
            if (g >= 0 && !com.baidu.tbadk.plugins.b.e(aiH())) {
                aiH().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(aiH().getPageActivity()).createNormalConfig(String.valueOf(this.czb.cCb.get(g).ahp), this.czb.cCb.get(g).ahq, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, d.C0141d.cp_bg_line_d);
            al.c(this.abq, d.C0141d.cp_cont_d, 1);
            al.c(this.cyO, d.C0141d.cp_cont_d, 1);
            al.c(this.cyT, d.C0141d.cp_cont_b, 1);
            al.c(this.cyU, d.C0141d.cp_cont_b, 1);
            al.c(this.cyV, d.C0141d.cp_cont_b, 1);
            al.c(this.cyW, d.C0141d.cp_cont_b, 1);
            al.i(this.cyX, d.C0141d.cp_bg_line_b);
            al.i(this.cyY, d.C0141d.cp_bg_line_b);
            al.i(this.cyZ, d.C0141d.cp_bg_line_b);
            al.i(this.cza, d.C0141d.cp_bg_line_c);
            al.i(this.chp, d.C0141d.cp_bg_line_c);
            al.i(this.cyP, d.f.card_topic_click_selector);
            al.i(this.cyQ, d.f.card_topic_click_selector);
            al.i(this.cyR, d.f.card_topic_click_selector);
            al.i(this.cyS, d.f.card_topic_click_selector);
            k(this.cyT, 0);
            k(this.cyU, 1);
            k(this.cyV, 2);
            k(this.cyW, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.cCa) || com.baidu.tbadk.core.util.w.y(nVar.cCb) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.czb = nVar;
        this.cza.setVisibility(this.czb.cBY ? 0 : 8);
        showBottomLine(this.czb.cBZ);
        this.abq.setText(this.czb.cCa.trim());
        j(this.cyT, 0);
        j(this.cyU, 1);
        j(this.cyV, 2);
        j(this.cyW, 3);
        k(this.cyT, 0);
        k(this.cyU, 1);
        k(this.cyV, 2);
        k(this.cyW, 3);
    }

    private void j(TextView textView, int i) {
        textView.setText(this.czb.cCb.get(i).ahq.trim());
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.czb != null && com.baidu.tbadk.core.util.w.y(this.czb.cCb) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.w.c(this.czb.cCb, i)) != null) {
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
            this.chp.setVisibility(0);
        } else {
            this.chp.setVisibility(8);
        }
    }

    public void iL(int i) {
        ViewGroup.LayoutParams layoutParams = this.cza.getLayoutParams();
        layoutParams.height = i;
        this.cza.setLayoutParams(layoutParams);
    }
}
