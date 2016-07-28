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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class bt extends a<com.baidu.tieba.card.a.q> {
    private TextView KB;
    private View aSw;
    private TextView aVj;
    private LinearLayout aVk;
    private LinearLayout aVl;
    private LinearLayout aVm;
    private LinearLayout aVn;
    private TextView aVo;
    private TextView aVp;
    private TextView aVq;
    private TextView aVr;
    private View aVs;
    private View aVt;
    private View aVu;
    private com.baidu.tieba.card.a.q aVv;
    private String aVw;
    private String aVx;
    private View bottomLine;
    private View mRootView;

    public bt(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        S(getView());
    }

    private void S(View view) {
        this.mRootView = view.findViewById(u.g.home_card_hot_topic_root_view);
        this.KB = (TextView) view.findViewById(u.g.home_card_topic_title);
        this.aVj = (TextView) view.findViewById(u.g.home_card_topic_more);
        this.aVk = (LinearLayout) view.findViewById(u.g.home_card_topic_group_one);
        this.aVl = (LinearLayout) view.findViewById(u.g.home_card_topic_group_two);
        this.aVm = (LinearLayout) view.findViewById(u.g.home_card_topic_group_three);
        this.aVn = (LinearLayout) view.findViewById(u.g.home_card_topic_group_four);
        this.aVo = (TextView) view.findViewById(u.g.home_card_topic_one);
        this.aVp = (TextView) view.findViewById(u.g.home_card_topic_two);
        this.aVq = (TextView) view.findViewById(u.g.home_card_topic_three);
        this.aVr = (TextView) view.findViewById(u.g.home_card_topic_four);
        this.aVs = view.findViewById(u.g.home_top_div);
        this.aVt = view.findViewById(u.g.home_top_topic_div_one);
        this.aVu = view.findViewById(u.g.home_top_topic_div_two);
        this.aSw = view.findViewById(u.g.home_card_top_divider_line);
        this.bottomLine = view.findViewById(u.g.home_card_bottom_divider_line);
        this.aVk.setOnClickListener(this);
        this.aVl.setOnClickListener(this);
        this.aVm.setOnClickListener(this);
        this.aVn.setOnClickListener(this);
        this.aVj.setOnClickListener(new bu(this));
    }

    public void aw(String str, String str2) {
        this.aVw = str;
        this.aVx = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return u.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int g = com.baidu.adp.lib.h.b.g((String) view.getTag(), -1);
        if (this.aVv != null && com.baidu.tbadk.core.util.y.c(this.aVv.aWI, g) != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(this.aVx).ab("obj_locate", String.valueOf(this.aVv.aWJ)).ab("obj_name", this.aVv.aWI.get(g).Qd));
            if (g >= 0 && !com.baidu.tbadk.plugins.a.f(KM())) {
                KM().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(KM().getPageActivity()).createNormalConfig(String.valueOf(this.aVv.aWI.get(g).Qc), this.aVv.aWI.get(g).Qd, "")));
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, u.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.av.c(this.KB, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.aVj, u.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.aVo, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aVp, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aVq, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.aVr, u.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.k(this.aVs, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.aVt, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.aVu, u.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.k(this.aSw, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.bottomLine, u.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.k(this.aVk, u.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.aVl, u.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.aVm, u.f.card_topic_click_selector);
            com.baidu.tbadk.core.util.av.k(this.aVn, u.f.card_topic_click_selector);
            o(this.aVo, 0);
            o(this.aVp, 1);
            o(this.aVq, 2);
            o(this.aVr, 3);
        }
        this.mSkinType = i;
    }

    public void a(com.baidu.tieba.card.a.q qVar) {
        if (qVar == null || StringUtils.isNull(qVar.aWH) || com.baidu.tbadk.core.util.y.s(qVar.aWI) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.aVv = qVar;
        this.aSw.setVisibility(this.aVv.aVX ? 0 : 8);
        this.KB.setText(this.aVv.aWH.trim());
        n(this.aVo, 0);
        n(this.aVp, 1);
        n(this.aVq, 2);
        n(this.aVr, 3);
        o(this.aVo, 0);
        o(this.aVp, 1);
        o(this.aVq, 2);
        o(this.aVr, 3);
    }

    private void n(TextView textView, int i) {
        textView.setText(this.aVv.aWI.get(i).Qd.trim());
    }

    private void o(TextView textView, int i) {
        com.baidu.tieba.card.a.p pVar;
        if (this.aVv != null && com.baidu.tbadk.core.util.y.s(this.aVv.aWI) >= 4 && (pVar = (com.baidu.tieba.card.a.p) com.baidu.tbadk.core.util.y.c(this.aVv.aWI, i)) != null) {
            switch (pVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_hottopic_tuijian), (Drawable) null);
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

    public void fG(int i) {
        ViewGroup.LayoutParams layoutParams = this.aSw.getLayoutParams();
        layoutParams.height = i;
        this.aSw.setLayoutParams(layoutParams);
    }
}
