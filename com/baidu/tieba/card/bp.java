package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bp extends a<com.baidu.tieba.card.data.q> {
    private TextView MO;
    private LinearLayout baA;
    private TextView baB;
    private TextView baC;
    private TextView baD;
    private TextView baE;
    private View baF;
    private View baG;
    private View baH;
    private View baI;
    private com.baidu.tieba.card.data.q baJ;
    private String baK;
    private String baL;
    private TextView baw;
    private LinearLayout bax;
    private LinearLayout bay;
    private LinearLayout baz;
    private View bottomLine;
    private View mRootView;

    public bp(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        V(getView());
    }

    private void V(View view) {
        this.mRootView = view.findViewById(t.g.home_card_hot_topic_root_view);
        this.MO = (TextView) view.findViewById(t.g.home_card_topic_title);
        this.baw = (TextView) view.findViewById(t.g.home_card_topic_more);
        this.bax = (LinearLayout) view.findViewById(t.g.home_card_topic_group_one);
        this.bay = (LinearLayout) view.findViewById(t.g.home_card_topic_group_two);
        this.baz = (LinearLayout) view.findViewById(t.g.home_card_topic_group_three);
        this.baA = (LinearLayout) view.findViewById(t.g.home_card_topic_group_four);
        this.baB = (TextView) view.findViewById(t.g.home_card_topic_one);
        this.baC = (TextView) view.findViewById(t.g.home_card_topic_two);
        this.baD = (TextView) view.findViewById(t.g.home_card_topic_three);
        this.baE = (TextView) view.findViewById(t.g.home_card_topic_four);
        this.baF = view.findViewById(t.g.home_top_div);
        this.baG = view.findViewById(t.g.home_top_topic_div_one);
        this.baH = view.findViewById(t.g.home_top_topic_div_two);
        this.baI = view.findViewById(t.g.home_card_top_divider_line);
        this.bottomLine = view.findViewById(t.g.home_card_bottom_divider_line);
        this.bax.setOnClickListener(this);
        this.bay.setOnClickListener(this);
        this.baz.setOnClickListener(this);
        this.baA.setOnClickListener(this);
        this.baw.setOnClickListener(new bq(this));
    }

    public void ax(String str, String str2) {
        this.baK = str;
        this.baL = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.h.b.g((String) view.getTag(), -1);
        if (this.baJ != null && com.baidu.tbadk.core.util.y.c(this.baJ.bck, g) != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(this.baL).ab("obj_locate", String.valueOf(this.baJ.bcl)).ab("obj_name", this.baJ.bck.get(g).SM));
            if (g >= 0 && !com.baidu.tbadk.plugins.a.f(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.baJ.bck.get(g).SL), this.baJ.bck.get(g).SM, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, t.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.c(this.MO, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.baw, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.baB, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.baC, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.baD, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.baE, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.k(this.baF, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.baG, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.baH, t.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.baI, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.bottomLine, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.bax, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.bay, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.baz, t.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.baA, t.f.card_topic_click_selector);
            o(this.baB, 0);
            o(this.baC, 1);
            o(this.baD, 2);
            o(this.baE, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.q qVar) {
        if (qVar == null || StringUtils.isNull(qVar.bcj) || com.baidu.tbadk.core.util.y.s(qVar.bck) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.baJ = qVar;
        this.baI.setVisibility(this.baJ.bbz ? 0 : 8);
        this.MO.setText(this.baJ.bcj.trim());
        n(this.baB, 0);
        n(this.baC, 1);
        n(this.baD, 2);
        n(this.baE, 3);
        o(this.baB, 0);
        o(this.baC, 1);
        o(this.baD, 2);
        o(this.baE, 3);
    }

    private void n(TextView textView, int i) {
        textView.setText(this.baJ.bck.get(i).SM.trim());
    }

    private void o(TextView textView, int i) {
        com.baidu.tieba.card.data.p pVar;
        if (this.baJ != null && com.baidu.tbadk.core.util.y.s(this.baJ.bck) >= 4 && (pVar = (com.baidu.tieba.card.data.p) com.baidu.tbadk.core.util.y.c(this.baJ.bck, i)) != null) {
            switch (pVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.bottomLine.setVisibility(0);
        } else {
            this.bottomLine.setVisibility(8);
        }
    }

    public void ge(int i) {
        ViewGroup.LayoutParams layoutParams = this.baI.getLayoutParams();
        layoutParams.height = i;
        this.baI.setLayoutParams(layoutParams);
    }
}
