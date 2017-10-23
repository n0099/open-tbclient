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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout bIY;
    protected TextView bIZ;
    public TextView bJa;
    public TextView bJb;
    private View bJc;
    private View bJd;
    private View bJe;
    public ImageView bJf;
    public LinearLayout bJg;
    public View bJh;
    public View bJi;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bIY = null;
        this.bIZ = null;
        this.bJa = null;
        this.bJb = null;
        this.bJc = null;
        this.bJd = null;
        this.bJe = null;
        this.bJg = null;
        X(getView());
    }

    private void X(View view) {
        this.bIY = (RelativeLayout) view.findViewById(d.h.item_layout_group_title);
        this.bIZ = (TextView) view.findViewById(d.h.item_group_title);
        this.bJa = (TextView) view.findViewById(d.h.item_right_tv);
        this.bJb = (TextView) view.findViewById(d.h.item_bottom_more_tv);
        this.bJc = view.findViewById(d.h.divider_line_top);
        this.bJd = view.findViewById(d.h.divider_line_middle);
        this.bJe = view.findViewById(d.h.divider_line_bottom);
        this.bJg = (LinearLayout) view.findViewById(d.h.card_container);
        this.bJh = view.findViewById(d.h.divider_card);
        this.bJi = view.findViewById(d.h.divider_card_top);
        this.bJf = (ImageView) view.findViewById(d.h.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void Xo() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.c(this.bIZ, d.e.cp_cont_d, 1);
            this.bJf.setVisibility(8);
        } else {
            aj.c(this.bIZ, d.e.cp_cont_f, 1);
            aj.c(this.bJf, d.g.icon_arrow_tab);
        }
        aj.c(this.bJa, d.e.cp_link_tip_c, 1);
        aj.c(this.bJb, d.e.cp_cont_d, 1);
        aj.k(getView(), d.e.cp_bg_line_d);
        aj.k(this.bJc, d.e.cp_bg_line_c);
        aj.k(this.bJd, d.e.cp_bg_line_c);
        aj.k(this.bJe, d.e.cp_bg_line_c);
        aj.k(this.bJh, d.e.cp_bg_line_c);
        aj.k(this.bJi, d.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Xo();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bIZ.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bJa.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bJi.setVisibility(0);
        } else {
            this.bJi.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bJh.setVisibility(0);
        } else {
            this.bJh.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bJb.setVisibility(0);
            this.bJe.setVisibility(0);
            this.bJd.setVisibility(0);
            this.bJb.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bJb.setTag(str);
                this.bJb.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bJb.setVisibility(8);
        this.bJe.setVisibility(8);
        this.bJd.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bJb == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                av.vA().c(Xm(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.j.card_group;
    }

    public void hN(int i) {
        if (this.bJc != null && this.bJc.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bJc.getLayoutParams();
            layoutParams.height = i;
            this.bJc.setLayoutParams(layoutParams);
        }
        if (this.bJd != null && this.bJd.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bJd.getLayoutParams();
            layoutParams2.height = i;
            this.bJd.setLayoutParams(layoutParams2);
        }
        if (this.bJe != null && this.bJe.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bJe.getLayoutParams();
            layoutParams3.height = i;
            this.bJe.setLayoutParams(layoutParams3);
        }
    }

    public void dy(boolean z) {
        if (this.bJh != null) {
            this.bJh.setVisibility(z ? 0 : 8);
        }
    }
}
