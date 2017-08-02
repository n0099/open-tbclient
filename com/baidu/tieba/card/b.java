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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    public View bEA;
    public View bEB;
    protected RelativeLayout bEr;
    protected TextView bEs;
    public TextView bEt;
    public TextView bEu;
    private View bEv;
    private View bEw;
    private View bEx;
    public ImageView bEy;
    public LinearLayout bEz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bEr = null;
        this.bEs = null;
        this.bEt = null;
        this.bEu = null;
        this.bEv = null;
        this.bEw = null;
        this.bEx = null;
        this.bEz = null;
        O(getView());
    }

    private void O(View view) {
        this.bEr = (RelativeLayout) view.findViewById(d.h.item_layout_group_title);
        this.bEs = (TextView) view.findViewById(d.h.item_group_title);
        this.bEt = (TextView) view.findViewById(d.h.item_right_tv);
        this.bEu = (TextView) view.findViewById(d.h.item_bottom_more_tv);
        this.bEv = view.findViewById(d.h.divider_line_top);
        this.bEw = view.findViewById(d.h.divider_line_middle);
        this.bEx = view.findViewById(d.h.divider_line_bottom);
        this.bEz = (LinearLayout) view.findViewById(d.h.card_container);
        this.bEA = view.findViewById(d.h.divider_card);
        this.bEB = view.findViewById(d.h.divider_card_top);
        this.bEy = (ImageView) view.findViewById(d.h.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void Wa() {
        if (getFrom() != null && getFrom().equals("home")) {
            ai.c(this.bEs, d.e.cp_cont_d, 1);
            this.bEy.setVisibility(8);
        } else {
            ai.c(this.bEs, d.e.cp_cont_f, 1);
            ai.c(this.bEy, d.g.icon_arrow_tab);
        }
        ai.c(this.bEt, d.e.cp_link_tip_c, 1);
        ai.c(this.bEu, d.e.cp_cont_d, 1);
        ai.k(getView(), d.e.cp_bg_line_d);
        ai.k(this.bEv, d.e.cp_bg_line_c);
        ai.k(this.bEw, d.e.cp_bg_line_c);
        ai.k(this.bEx, d.e.cp_bg_line_c);
        ai.k(this.bEA, d.e.cp_bg_line_c);
        ai.k(this.bEB, d.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Wa();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bEs.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bEt.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bEB.setVisibility(0);
        } else {
            this.bEB.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bEA.setVisibility(0);
        } else {
            this.bEA.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bEu.setVisibility(0);
            this.bEx.setVisibility(0);
            this.bEw.setVisibility(0);
            this.bEu.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bEu.setTag(str);
                this.bEu.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bEu.setVisibility(8);
        this.bEx.setVisibility(8);
        this.bEw.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bEu == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                at.vV().c(VY(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.j.card_group;
    }

    public void hr(int i) {
        if (this.bEv != null && this.bEv.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bEv.getLayoutParams();
            layoutParams.height = i;
            this.bEv.setLayoutParams(layoutParams);
        }
        if (this.bEw != null && this.bEw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bEw.getLayoutParams();
            layoutParams2.height = i;
            this.bEw.setLayoutParams(layoutParams2);
        }
        if (this.bEx != null && this.bEx.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bEx.getLayoutParams();
            layoutParams3.height = i;
            this.bEx.setLayoutParams(layoutParams3);
        }
    }

    public void dC(boolean z) {
        if (this.bEA != null) {
            this.bEA.setVisibility(z ? 0 : 8);
        }
    }
}
