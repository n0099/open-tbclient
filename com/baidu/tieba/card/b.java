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
    protected RelativeLayout bYT;
    protected TextView bYU;
    public TextView bYV;
    public TextView bYW;
    private View bYX;
    private View bYY;
    private View bYZ;
    public ImageView bZa;
    public LinearLayout bZb;
    public View bZc;
    public View bZd;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bYT = null;
        this.bYU = null;
        this.bYV = null;
        this.bYW = null;
        this.bYX = null;
        this.bYY = null;
        this.bYZ = null;
        this.bZb = null;
        ab(getView());
    }

    private void ab(View view) {
        this.bYT = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.bYU = (TextView) view.findViewById(d.g.item_group_title);
        this.bYV = (TextView) view.findViewById(d.g.item_right_tv);
        this.bYW = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.bYX = view.findViewById(d.g.divider_line_top);
        this.bYY = view.findViewById(d.g.divider_line_middle);
        this.bYZ = view.findViewById(d.g.divider_line_bottom);
        this.bZb = (LinearLayout) view.findViewById(d.g.card_container);
        this.bZc = view.findViewById(d.g.divider_card);
        this.bZd = view.findViewById(d.g.divider_card_top);
        this.bZa = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void abu() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.c(this.bYU, d.C0096d.cp_cont_d, 1);
            this.bZa.setVisibility(8);
        } else {
            aj.c(this.bYU, d.C0096d.cp_cont_f, 1);
            aj.c(this.bZa, d.f.icon_arrow_tab);
        }
        aj.c(this.bYV, d.C0096d.cp_link_tip_c, 1);
        aj.c(this.bYW, d.C0096d.cp_cont_d, 1);
        aj.k(getView(), d.C0096d.cp_bg_line_d);
        aj.k(this.bYX, d.C0096d.cp_bg_line_c);
        aj.k(this.bYY, d.C0096d.cp_bg_line_c);
        aj.k(this.bYZ, d.C0096d.cp_bg_line_c);
        aj.k(this.bZc, d.C0096d.cp_bg_line_c);
        aj.k(this.bZd, d.C0096d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            abu();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bYU.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bYV.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bZd.setVisibility(0);
        } else {
            this.bZd.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bZc.setVisibility(0);
        } else {
            this.bZc.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bYW.setVisibility(0);
            this.bYZ.setVisibility(0);
            this.bYY.setVisibility(0);
            this.bYW.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bYW.setTag(str);
                this.bYW.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bYW.setVisibility(8);
        this.bYZ.setVisibility(8);
        this.bYY.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bYW == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                av.vI().c(abs(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void iC(int i) {
        if (this.bYX != null && this.bYX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bYX.getLayoutParams();
            layoutParams.height = i;
            this.bYX.setLayoutParams(layoutParams);
        }
        if (this.bYY != null && this.bYY.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bYY.getLayoutParams();
            layoutParams2.height = i;
            this.bYY.setLayoutParams(layoutParams2);
        }
        if (this.bYZ != null && this.bYZ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bYZ.getLayoutParams();
            layoutParams3.height = i;
            this.bYZ.setLayoutParams(layoutParams3);
        }
    }

    public void dN(boolean z) {
        if (this.bZc != null) {
            this.bZc.setVisibility(z ? 0 : 8);
        }
    }
}
