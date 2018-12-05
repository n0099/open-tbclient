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
    private View cEB;
    private TextView cVh;
    private LinearLayout cVi;
    private LinearLayout cVj;
    private LinearLayout cVk;
    private LinearLayout cVl;
    private TextView cVm;
    private TextView cVn;
    private TextView cVo;
    private TextView cVp;
    private View cVq;
    private View cVr;
    private View cVs;
    private View cVt;
    private com.baidu.tieba.card.data.n cVu;
    private String cVv;
    private String cVw;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.home_card_hot_topic_root_view);
        this.amN = (TextView) view.findViewById(e.g.home_card_topic_title);
        this.cVh = (TextView) view.findViewById(e.g.home_card_topic_more);
        this.cVi = (LinearLayout) view.findViewById(e.g.home_card_topic_group_one);
        this.cVj = (LinearLayout) view.findViewById(e.g.home_card_topic_group_two);
        this.cVk = (LinearLayout) view.findViewById(e.g.home_card_topic_group_three);
        this.cVl = (LinearLayout) view.findViewById(e.g.home_card_topic_group_four);
        this.cVm = (TextView) view.findViewById(e.g.home_card_topic_one);
        this.cVn = (TextView) view.findViewById(e.g.home_card_topic_two);
        this.cVo = (TextView) view.findViewById(e.g.home_card_topic_three);
        this.cVp = (TextView) view.findViewById(e.g.home_card_topic_four);
        this.cVq = view.findViewById(e.g.home_top_div);
        this.cVr = view.findViewById(e.g.home_top_topic_div_one);
        this.cVs = view.findViewById(e.g.home_top_topic_div_two);
        this.cVt = view.findViewById(e.g.home_card_top_divider_line);
        this.cEB = view.findViewById(e.g.home_card_bottom_divider_line);
        this.cVi.setOnClickListener(this);
        this.cVj.setOnClickListener(this);
        this.cVk.setOnClickListener(this);
        this.cVl.setOnClickListener(this);
        this.cVh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.q.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.e(q.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotRanklistActivityConfig(q.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.cVv = str;
        this.cVw = str2;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int l = com.baidu.adp.lib.g.b.l((String) view.getTag(), -1);
        if (this.cVu != null && com.baidu.tbadk.core.util.v.d(this.cVu.cYu, l) != null) {
            TiebaStatic.log(new am(this.cVw).aA("obj_locate", String.valueOf(this.cVu.bMR)).aA("obj_name", this.cVu.cYu.get(l).asM));
            if (l >= 0 && !com.baidu.tbadk.plugins.b.e(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.cVu.cYu.get(l).asL), this.cVu.cYu.get(l).asM, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.d.cp_bg_line_d);
            al.c(this.amN, e.d.cp_cont_d, 1);
            al.c(this.cVh, e.d.cp_cont_d, 1);
            al.c(this.cVm, e.d.cp_cont_b, 1);
            al.c(this.cVn, e.d.cp_cont_b, 1);
            al.c(this.cVo, e.d.cp_cont_b, 1);
            al.c(this.cVp, e.d.cp_cont_b, 1);
            al.i(this.cVq, e.d.cp_bg_line_b);
            al.i(this.cVr, e.d.cp_bg_line_b);
            al.i(this.cVs, e.d.cp_bg_line_b);
            al.i(this.cVt, e.d.cp_bg_line_c);
            al.i(this.cEB, e.d.cp_bg_line_c);
            al.i(this.cVi, e.f.card_topic_click_selector);
            al.i(this.cVj, e.f.card_topic_click_selector);
            al.i(this.cVk, e.f.card_topic_click_selector);
            al.i(this.cVl, e.f.card_topic_click_selector);
            l(this.cVm, 0);
            l(this.cVn, 1);
            l(this.cVo, 2);
            l(this.cVp, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.cYt) || com.baidu.tbadk.core.util.v.H(nVar.cYu) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.cVu = nVar;
        this.cVt.setVisibility(this.cVu.cYr ? 0 : 8);
        showBottomLine(this.cVu.cYs);
        this.amN.setText(this.cVu.cYt.trim());
        k(this.cVm, 0);
        k(this.cVn, 1);
        k(this.cVo, 2);
        k(this.cVp, 3);
        l(this.cVm, 0);
        l(this.cVn, 1);
        l(this.cVo, 2);
        l(this.cVp, 3);
    }

    private void k(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.cVu.cYu.get(i);
        if (!StringUtils.isNull(mVar.asM)) {
            textView.setText(mVar.asM.trim());
        }
    }

    private void l(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.cVu != null && com.baidu.tbadk.core.util.v.H(this.cVu.cYu) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.d(this.cVu.cYu, i)) != null) {
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
            this.cEB.setVisibility(0);
        } else {
            this.cEB.setVisibility(8);
        }
    }

    public void kz(int i) {
        ViewGroup.LayoutParams layoutParams = this.cVt.getLayoutParams();
        layoutParams.height = i;
        this.cVt.setLayoutParams(layoutParams);
    }
}
