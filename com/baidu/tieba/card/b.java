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
    protected RelativeLayout bQR;
    protected TextView bQS;
    public TextView bQT;
    public TextView bQU;
    private View bQV;
    private View bQW;
    private View bQX;
    public ImageView bQY;
    public LinearLayout bQZ;
    public View bRa;
    public View bRb;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bQR = null;
        this.bQS = null;
        this.bQT = null;
        this.bQU = null;
        this.bQV = null;
        this.bQW = null;
        this.bQX = null;
        this.bQZ = null;
        Z(getView());
    }

    private void Z(View view) {
        this.bQR = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.bQS = (TextView) view.findViewById(d.g.item_group_title);
        this.bQT = (TextView) view.findViewById(d.g.item_right_tv);
        this.bQU = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.bQV = view.findViewById(d.g.divider_line_top);
        this.bQW = view.findViewById(d.g.divider_line_middle);
        this.bQX = view.findViewById(d.g.divider_line_bottom);
        this.bQZ = (LinearLayout) view.findViewById(d.g.card_container);
        this.bRa = view.findViewById(d.g.divider_card);
        this.bRb = view.findViewById(d.g.divider_card_top);
        this.bQY = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void ZK() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.c(this.bQS, d.C0080d.cp_cont_d, 1);
            this.bQY.setVisibility(8);
        } else {
            aj.c(this.bQS, d.C0080d.cp_cont_f, 1);
            aj.c(this.bQY, d.f.icon_arrow_tab);
        }
        aj.c(this.bQT, d.C0080d.cp_link_tip_c, 1);
        aj.c(this.bQU, d.C0080d.cp_cont_d, 1);
        aj.k(getView(), d.C0080d.cp_bg_line_d);
        aj.k(this.bQV, d.C0080d.cp_bg_line_c);
        aj.k(this.bQW, d.C0080d.cp_bg_line_c);
        aj.k(this.bQX, d.C0080d.cp_bg_line_c);
        aj.k(this.bRa, d.C0080d.cp_bg_line_c);
        aj.k(this.bRb, d.C0080d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ZK();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bQS.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bQT.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bRb.setVisibility(0);
        } else {
            this.bRb.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bRa.setVisibility(0);
        } else {
            this.bRa.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bQU.setVisibility(0);
            this.bQX.setVisibility(0);
            this.bQW.setVisibility(0);
            this.bQU.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bQU.setTag(str);
                this.bQU.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bQU.setVisibility(8);
        this.bQX.setVisibility(8);
        this.bQW.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bQU == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                av.vI().c(ZI(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    /* renamed from: if  reason: not valid java name */
    public void m11if(int i) {
        if (this.bQV != null && this.bQV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bQV.getLayoutParams();
            layoutParams.height = i;
            this.bQV.setLayoutParams(layoutParams);
        }
        if (this.bQW != null && this.bQW.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bQW.getLayoutParams();
            layoutParams2.height = i;
            this.bQW.setLayoutParams(layoutParams2);
        }
        if (this.bQX != null && this.bQX.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bQX.getLayoutParams();
            layoutParams3.height = i;
            this.bQX.setLayoutParams(layoutParams3);
        }
    }

    public void dC(boolean z) {
        if (this.bRa != null) {
            this.bRa.setVisibility(z ? 0 : 8);
        }
    }
}
