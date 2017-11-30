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
    protected RelativeLayout bYP;
    protected TextView bYQ;
    public TextView bYR;
    public TextView bYS;
    private View bYT;
    private View bYU;
    private View bYV;
    public ImageView bYW;
    public LinearLayout bYX;
    public View bYY;
    public View bYZ;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bYP = null;
        this.bYQ = null;
        this.bYR = null;
        this.bYS = null;
        this.bYT = null;
        this.bYU = null;
        this.bYV = null;
        this.bYX = null;
        aa(getView());
    }

    private void aa(View view) {
        this.bYP = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.bYQ = (TextView) view.findViewById(d.g.item_group_title);
        this.bYR = (TextView) view.findViewById(d.g.item_right_tv);
        this.bYS = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.bYT = view.findViewById(d.g.divider_line_top);
        this.bYU = view.findViewById(d.g.divider_line_middle);
        this.bYV = view.findViewById(d.g.divider_line_bottom);
        this.bYX = (LinearLayout) view.findViewById(d.g.card_container);
        this.bYY = view.findViewById(d.g.divider_card);
        this.bYZ = view.findViewById(d.g.divider_card_top);
        this.bYW = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void abt() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.c(this.bYQ, d.C0082d.cp_cont_d, 1);
            this.bYW.setVisibility(8);
        } else {
            aj.c(this.bYQ, d.C0082d.cp_cont_f, 1);
            aj.c(this.bYW, d.f.icon_arrow_tab);
        }
        aj.c(this.bYR, d.C0082d.cp_link_tip_c, 1);
        aj.c(this.bYS, d.C0082d.cp_cont_d, 1);
        aj.k(getView(), d.C0082d.cp_bg_line_d);
        aj.k(this.bYT, d.C0082d.cp_bg_line_c);
        aj.k(this.bYU, d.C0082d.cp_bg_line_c);
        aj.k(this.bYV, d.C0082d.cp_bg_line_c);
        aj.k(this.bYY, d.C0082d.cp_bg_line_c);
        aj.k(this.bYZ, d.C0082d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            abt();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bYQ.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bYR.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bYZ.setVisibility(0);
        } else {
            this.bYZ.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bYY.setVisibility(0);
        } else {
            this.bYY.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bYS.setVisibility(0);
            this.bYV.setVisibility(0);
            this.bYU.setVisibility(0);
            this.bYS.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bYS.setTag(str);
                this.bYS.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bYS.setVisibility(8);
        this.bYV.setVisibility(8);
        this.bYU.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bYS == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                av.vL().c(abr(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void iC(int i) {
        if (this.bYT != null && this.bYT.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bYT.getLayoutParams();
            layoutParams.height = i;
            this.bYT.setLayoutParams(layoutParams);
        }
        if (this.bYU != null && this.bYU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bYU.getLayoutParams();
            layoutParams2.height = i;
            this.bYU.setLayoutParams(layoutParams2);
        }
        if (this.bYV != null && this.bYV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bYV.getLayoutParams();
            layoutParams3.height = i;
            this.bYV.setLayoutParams(layoutParams3);
        }
    }

    public void dM(boolean z) {
        if (this.bYY != null) {
            this.bYY.setVisibility(z ? 0 : 8);
        }
    }
}
