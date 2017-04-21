package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    public LinearLayout btA;
    public View btB;
    public View btC;
    protected RelativeLayout bts;
    protected TextView btt;
    public TextView btu;
    public TextView btv;
    private View btw;
    private View btx;
    private View bty;
    public ImageView btz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bts = null;
        this.btt = null;
        this.btu = null;
        this.btv = null;
        this.btw = null;
        this.btx = null;
        this.bty = null;
        this.btA = null;
        P(getView());
    }

    private void P(View view) {
        this.bts = (RelativeLayout) view.findViewById(w.h.item_layout_group_title);
        this.btt = (TextView) view.findViewById(w.h.item_group_title);
        this.btu = (TextView) view.findViewById(w.h.item_right_tv);
        this.btv = (TextView) view.findViewById(w.h.item_bottom_more_tv);
        this.btw = view.findViewById(w.h.divider_line_top);
        this.btx = view.findViewById(w.h.divider_line_middle);
        this.bty = view.findViewById(w.h.divider_line_bottom);
        this.btA = (LinearLayout) view.findViewById(w.h.card_container);
        this.btB = view.findViewById(w.h.divider_card);
        this.btC = view.findViewById(w.h.divider_card_top);
        this.btz = (ImageView) view.findViewById(w.h.item_right_arrow);
    }

    private void TG() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.aq.c(this.btt, w.e.cp_cont_d, 1);
            this.btz.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.btt, w.e.cp_cont_f, 1);
            com.baidu.tbadk.core.util.aq.c(this.btz, w.g.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.aq.c(this.btu, w.e.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.aq.c(this.btv, w.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.btw, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.btx, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.bty, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.btB, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.btC, w.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            TG();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.btt.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.btu.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.btC.setVisibility(0);
        } else {
            this.btC.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.btB.setVisibility(0);
        } else {
            this.btB.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.btv.setVisibility(0);
            this.bty.setVisibility(0);
            this.btx.setVisibility(0);
            this.btv.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.btv.setTag(str);
                this.btv.setOnClickListener(this);
                return;
            }
            return;
        }
        this.btv.setVisibility(8);
        this.bty.setVisibility(8);
        this.btx.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.btv == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bb.wn().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return w.j.card_group;
    }

    public void gN(int i) {
        if (this.btw != null && this.btw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.btw.getLayoutParams();
            layoutParams.height = i;
            this.btw.setLayoutParams(layoutParams);
        }
        if (this.btx != null && this.btx.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.btx.getLayoutParams();
            layoutParams2.height = i;
            this.btx.setLayoutParams(layoutParams2);
        }
        if (this.bty != null && this.bty.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bty.getLayoutParams();
            layoutParams3.height = i;
            this.bty.setLayoutParams(layoutParams3);
        }
    }

    public void cX(boolean z) {
        if (this.btB != null) {
            this.btB.setVisibility(z ? 0 : 8);
        }
    }
}
