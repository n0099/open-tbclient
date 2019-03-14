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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    private View efA;
    public ImageView efB;
    public LinearLayout efC;
    public View efD;
    public View efE;
    protected RelativeLayout efu;
    protected TextView efv;
    public TextView efw;
    public TextView efx;
    private View efy;
    private View efz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.efu = null;
        this.efv = null;
        this.efw = null;
        this.efx = null;
        this.efy = null;
        this.efz = null;
        this.efA = null;
        this.efC = null;
        O(getView());
    }

    private void O(View view) {
        this.efu = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.efv = (TextView) view.findViewById(d.g.item_group_title);
        this.efw = (TextView) view.findViewById(d.g.item_right_tv);
        this.efx = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.efy = view.findViewById(d.g.divider_line_top);
        this.efz = view.findViewById(d.g.divider_line_middle);
        this.efA = view.findViewById(d.g.divider_line_bottom);
        this.efC = (LinearLayout) view.findViewById(d.g.card_container);
        this.efD = view.findViewById(d.g.divider_card);
        this.efE = view.findViewById(d.g.divider_card_top);
        this.efB = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aQi() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.d(this.efv, d.C0277d.cp_cont_d, 1);
            this.efB.setVisibility(8);
        } else {
            al.d(this.efv, d.C0277d.cp_cont_f, 1);
            al.c(this.efB, d.f.icon_arrow_tab);
        }
        al.d(this.efw, d.C0277d.cp_link_tip_c, 1);
        al.d(this.efx, d.C0277d.cp_cont_d, 1);
        al.l(getView(), d.C0277d.cp_bg_line_d);
        al.l(this.efy, d.C0277d.cp_bg_line_c);
        al.l(this.efz, d.C0277d.cp_bg_line_c);
        al.l(this.efA, d.C0277d.cp_bg_line_c);
        al.l(this.efD, d.C0277d.cp_bg_line_c);
        al.l(this.efE, d.C0277d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aQi();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.efv.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.efw.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.efE.setVisibility(0);
        } else {
            this.efE.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.efD.setVisibility(0);
        } else {
            this.efD.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.efx.setVisibility(0);
            this.efA.setVisibility(0);
            this.efz.setVisibility(0);
            this.efx.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.efx.setTag(str);
                this.efx.setOnClickListener(this);
                return;
            }
            return;
        }
        this.efx.setVisibility(8);
        this.efA.setVisibility(8);
        this.efz.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.efx == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.adD().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void ok(int i) {
        if (this.efy != null && this.efy.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.efy.getLayoutParams();
            layoutParams.height = i;
            this.efy.setLayoutParams(layoutParams);
        }
        if (this.efz != null && this.efz.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.efz.getLayoutParams();
            layoutParams2.height = i;
            this.efz.setLayoutParams(layoutParams2);
        }
        if (this.efA != null && this.efA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.efA.getLayoutParams();
            layoutParams3.height = i;
            this.efA.setLayoutParams(layoutParams3);
        }
    }

    public void hJ(boolean z) {
        if (this.efD != null) {
            this.efD.setVisibility(z ? 0 : 8);
        }
    }
}
