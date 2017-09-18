package com.baidu.tieba.card;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout bJW;
    protected TextView bJX;
    public TextView bJY;
    public TextView bJZ;
    private View bKa;
    private View bKb;
    private View bKc;
    public ImageView bKd;
    public LinearLayout bKe;
    public View bKf;
    public View bKg;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJW = null;
        this.bJX = null;
        this.bJY = null;
        this.bJZ = null;
        this.bKa = null;
        this.bKb = null;
        this.bKc = null;
        this.bKe = null;
        X(getView());
    }

    private void X(View view) {
        this.bJW = (RelativeLayout) view.findViewById(d.h.item_layout_group_title);
        this.bJX = (TextView) view.findViewById(d.h.item_group_title);
        this.bJY = (TextView) view.findViewById(d.h.item_right_tv);
        this.bJZ = (TextView) view.findViewById(d.h.item_bottom_more_tv);
        this.bKa = view.findViewById(d.h.divider_line_top);
        this.bKb = view.findViewById(d.h.divider_line_middle);
        this.bKc = view.findViewById(d.h.divider_line_bottom);
        this.bKe = (LinearLayout) view.findViewById(d.h.card_container);
        this.bKf = view.findViewById(d.h.divider_card);
        this.bKg = view.findViewById(d.h.divider_card_top);
        this.bKd = (ImageView) view.findViewById(d.h.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void XM() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.c(this.bJX, d.e.cp_cont_d, 1);
            this.bKd.setVisibility(8);
        } else {
            aj.c(this.bJX, d.e.cp_cont_f, 1);
            aj.c(this.bKd, d.g.icon_arrow_tab);
        }
        aj.c(this.bJY, d.e.cp_link_tip_c, 1);
        aj.c(this.bJZ, d.e.cp_cont_d, 1);
        aj.k(getView(), d.e.cp_bg_line_d);
        aj.k(this.bKa, d.e.cp_bg_line_c);
        aj.k(this.bKb, d.e.cp_bg_line_c);
        aj.k(this.bKc, d.e.cp_bg_line_c);
        aj.k(this.bKf, d.e.cp_bg_line_c);
        aj.k(this.bKg, d.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            XM();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bJX.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bJY.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bKg.setVisibility(0);
        } else {
            this.bKg.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bKf.setVisibility(0);
        } else {
            this.bKf.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bJZ.setVisibility(0);
            this.bKc.setVisibility(0);
            this.bKb.setVisibility(0);
            this.bJZ.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bJZ.setTag(str);
                this.bJZ.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bJZ.setVisibility(8);
        this.bKc.setVisibility(8);
        this.bKb.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bJZ == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                au.wd().c(XK(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.j.card_group;
    }

    public void hG(int i) {
        if (this.bKa != null && this.bKa.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bKa.getLayoutParams();
            layoutParams.height = i;
            this.bKa.setLayoutParams(layoutParams);
        }
        if (this.bKb != null && this.bKb.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bKb.getLayoutParams();
            layoutParams2.height = i;
            this.bKb.setLayoutParams(layoutParams2);
        }
        if (this.bKc != null && this.bKc.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bKc.getLayoutParams();
            layoutParams3.height = i;
            this.bKc.setLayoutParams(layoutParams3);
        }
    }

    public void dH(boolean z) {
        if (this.bKf != null) {
            this.bKf.setVisibility(z ? 0 : 8);
        }
    }
}
