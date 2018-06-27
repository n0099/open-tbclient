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
    private TextView abu;
    private View cjz;
    private TextView cwI;
    private LinearLayout cwJ;
    private LinearLayout cwK;
    private LinearLayout cwL;
    private LinearLayout cwM;
    private TextView cwN;
    private TextView cwO;
    private TextView cwP;
    private TextView cwQ;
    private View cwR;
    private View cwS;
    private View cwT;
    private View cwU;
    private com.baidu.tieba.card.data.n cwV;
    private String cwW;
    private String cwX;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.home_card_hot_topic_root_view);
        this.abu = (TextView) view.findViewById(d.g.home_card_topic_title);
        this.cwI = (TextView) view.findViewById(d.g.home_card_topic_more);
        this.cwJ = (LinearLayout) view.findViewById(d.g.home_card_topic_group_one);
        this.cwK = (LinearLayout) view.findViewById(d.g.home_card_topic_group_two);
        this.cwL = (LinearLayout) view.findViewById(d.g.home_card_topic_group_three);
        this.cwM = (LinearLayout) view.findViewById(d.g.home_card_topic_group_four);
        this.cwN = (TextView) view.findViewById(d.g.home_card_topic_one);
        this.cwO = (TextView) view.findViewById(d.g.home_card_topic_two);
        this.cwP = (TextView) view.findViewById(d.g.home_card_topic_three);
        this.cwQ = (TextView) view.findViewById(d.g.home_card_topic_four);
        this.cwR = view.findViewById(d.g.home_top_div);
        this.cwS = view.findViewById(d.g.home_top_topic_div_one);
        this.cwT = view.findViewById(d.g.home_top_topic_div_two);
        this.cwU = view.findViewById(d.g.home_card_top_divider_line);
        this.cjz = view.findViewById(d.g.home_card_bottom_divider_line);
        this.cwJ.setOnClickListener(this);
        this.cwK.setOnClickListener(this);
        this.cwL.setOnClickListener(this);
        this.cwM.setOnClickListener(this);
        this.cwI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.ahZ())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.ahZ().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cwW = str;
        this.cwX = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.g.b.g((String) view.getTag(), -1);
        if (this.cwV != null && com.baidu.tbadk.core.util.w.d(this.cwV.czV, g) != null) {
            TiebaStatic.log(new an(this.cwX).ah("obj_locate", String.valueOf(this.cwV.btk)).ah("obj_name", this.cwV.czV.get(g).ahJ));
            if (g >= 0 && !com.baidu.tbadk.plugins.b.e(ahZ())) {
                ahZ().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(ahZ().getPageActivity()).createNormalConfig(String.valueOf(this.cwV.czV.get(g).ahI), this.cwV.czV.get(g).ahJ, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, d.C0142d.cp_bg_line_d);
            am.c(this.abu, d.C0142d.cp_cont_d, 1);
            am.c(this.cwI, d.C0142d.cp_cont_d, 1);
            am.c(this.cwN, d.C0142d.cp_cont_b, 1);
            am.c(this.cwO, d.C0142d.cp_cont_b, 1);
            am.c(this.cwP, d.C0142d.cp_cont_b, 1);
            am.c(this.cwQ, d.C0142d.cp_cont_b, 1);
            am.i(this.cwR, d.C0142d.cp_bg_line_b);
            am.i(this.cwS, d.C0142d.cp_bg_line_b);
            am.i(this.cwT, d.C0142d.cp_bg_line_b);
            am.i(this.cwU, d.C0142d.cp_bg_line_c);
            am.i(this.cjz, d.C0142d.cp_bg_line_c);
            am.i(this.cwJ, d.f.card_topic_click_selector);
            am.i(this.cwK, d.f.card_topic_click_selector);
            am.i(this.cwL, d.f.card_topic_click_selector);
            am.i(this.cwM, d.f.card_topic_click_selector);
            k(this.cwN, 0);
            k(this.cwO, 1);
            k(this.cwP, 2);
            k(this.cwQ, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.czU) || com.baidu.tbadk.core.util.w.z(nVar.czV) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cwV = nVar;
        this.cwU.setVisibility(this.cwV.czS ? 0 : 8);
        showBottomLine(this.cwV.czT);
        this.abu.setText(this.cwV.czU.trim());
        j(this.cwN, 0);
        j(this.cwO, 1);
        j(this.cwP, 2);
        j(this.cwQ, 3);
        k(this.cwN, 0);
        k(this.cwO, 1);
        k(this.cwP, 2);
        k(this.cwQ, 3);
    }

    private void j(TextView textView, int i) {
        textView.setText(this.cwV.czV.get(i).ahJ.trim());
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cwV != null && com.baidu.tbadk.core.util.w.z(this.cwV.czV) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.w.d(this.cwV.czV, i)) != null) {
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
            this.cjz.setVisibility(0);
        } else {
            this.cjz.setVisibility(8);
        }
    }

    public void iI(int i) {
        ViewGroup.LayoutParams layoutParams = this.cwU.getLayoutParams();
        layoutParams.height = i;
        this.cwU.setLayoutParams(layoutParams);
    }
}
