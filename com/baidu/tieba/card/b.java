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
    protected RelativeLayout bri;
    protected TextView brj;
    public TextView brk;
    public TextView brl;
    private View brm;
    private View brn;
    private View bro;
    public ImageView brp;
    public LinearLayout brq;
    public View brr;
    public View brs;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bri = null;
        this.brj = null;
        this.brk = null;
        this.brl = null;
        this.brm = null;
        this.brn = null;
        this.bro = null;
        this.brq = null;
        P(getView());
    }

    private void P(View view) {
        this.bri = (RelativeLayout) view.findViewById(w.h.item_layout_group_title);
        this.brj = (TextView) view.findViewById(w.h.item_group_title);
        this.brk = (TextView) view.findViewById(w.h.item_right_tv);
        this.brl = (TextView) view.findViewById(w.h.item_bottom_more_tv);
        this.brm = view.findViewById(w.h.divider_line_top);
        this.brn = view.findViewById(w.h.divider_line_middle);
        this.bro = view.findViewById(w.h.divider_line_bottom);
        this.brq = (LinearLayout) view.findViewById(w.h.card_container);
        this.brr = view.findViewById(w.h.divider_card);
        this.brs = view.findViewById(w.h.divider_card_top);
        this.brp = (ImageView) view.findViewById(w.h.item_right_arrow);
    }

    private void Sg() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.aq.c(this.brj, w.e.cp_cont_d, 1);
            this.brp.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.aq.c(this.brj, w.e.cp_cont_f, 1);
            com.baidu.tbadk.core.util.aq.c(this.brp, w.g.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.aq.c(this.brk, w.e.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.aq.c(this.brl, w.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.aq.k(this.brm, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.brn, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.bro, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.brr, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.aq.k(this.brs, w.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Sg();
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
        this.brj.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.brk.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.brs.setVisibility(0);
        } else {
            this.brs.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.brr.setVisibility(0);
        } else {
            this.brr.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.brl.setVisibility(0);
            this.bro.setVisibility(0);
            this.brn.setVisibility(0);
            this.brl.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.brl.setTag(str);
                this.brl.setOnClickListener(this);
                return;
            }
            return;
        }
        this.brl.setVisibility(8);
        this.bro.setVisibility(8);
        this.brn.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.brl == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bb.vQ().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return w.j.card_group;
    }

    public void gE(int i) {
        if (this.brm != null && this.brm.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.brm.getLayoutParams();
            layoutParams.height = i;
            this.brm.setLayoutParams(layoutParams);
        }
        if (this.brn != null && this.brn.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.brn.getLayoutParams();
            layoutParams2.height = i;
            this.brn.setLayoutParams(layoutParams2);
        }
        if (this.bro != null && this.bro.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bro.getLayoutParams();
            layoutParams3.height = i;
            this.bro.setLayoutParams(layoutParams3);
        }
    }

    public void cL(boolean z) {
        if (this.brr != null) {
            this.brr.setVisibility(z ? 0 : 8);
        }
    }
}
