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
    protected RelativeLayout bAk;
    protected TextView bAl;
    public TextView bAm;
    public TextView bAn;
    private View bAo;
    private View bAp;
    private View bAq;
    public ImageView bAr;
    public LinearLayout bAs;
    public View bAt;
    public View bAu;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bAk = null;
        this.bAl = null;
        this.bAm = null;
        this.bAn = null;
        this.bAo = null;
        this.bAp = null;
        this.bAq = null;
        this.bAs = null;
        O(getView());
    }

    private void O(View view) {
        this.bAk = (RelativeLayout) view.findViewById(w.h.item_layout_group_title);
        this.bAl = (TextView) view.findViewById(w.h.item_group_title);
        this.bAm = (TextView) view.findViewById(w.h.item_right_tv);
        this.bAn = (TextView) view.findViewById(w.h.item_bottom_more_tv);
        this.bAo = view.findViewById(w.h.divider_line_top);
        this.bAp = view.findViewById(w.h.divider_line_middle);
        this.bAq = view.findViewById(w.h.divider_line_bottom);
        this.bAs = (LinearLayout) view.findViewById(w.h.card_container);
        this.bAt = view.findViewById(w.h.divider_card);
        this.bAu = view.findViewById(w.h.divider_card_top);
        this.bAr = (ImageView) view.findViewById(w.h.item_right_arrow);
    }

    private void Vt() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.as.c(this.bAl, w.e.cp_cont_d, 1);
            this.bAr.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.as.c(this.bAl, w.e.cp_cont_f, 1);
            com.baidu.tbadk.core.util.as.c(this.bAr, w.g.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.as.c(this.bAm, w.e.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.as.c(this.bAn, w.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.as.k(getView(), w.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.k(this.bAo, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.k(this.bAp, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.k(this.bAq, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.k(this.bAt, w.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.as.k(this.bAu, w.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Vt();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bAl.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bAm.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bAu.setVisibility(0);
        } else {
            this.bAu.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bAt.setVisibility(0);
        } else {
            this.bAt.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bAn.setVisibility(0);
            this.bAq.setVisibility(0);
            this.bAp.setVisibility(0);
            this.bAn.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bAn.setTag(str);
                this.bAn.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bAn.setVisibility(8);
        this.bAq.setVisibility(8);
        this.bAp.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bAn == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.be.vP().c(Vr(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return w.j.card_group;
    }

    public void hl(int i) {
        if (this.bAo != null && this.bAo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bAo.getLayoutParams();
            layoutParams.height = i;
            this.bAo.setLayoutParams(layoutParams);
        }
        if (this.bAp != null && this.bAp.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bAp.getLayoutParams();
            layoutParams2.height = i;
            this.bAp.setLayoutParams(layoutParams2);
        }
        if (this.bAq != null && this.bAq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bAq.getLayoutParams();
            layoutParams3.height = i;
            this.bAq.setLayoutParams(layoutParams3);
        }
    }

    public void dt(boolean z) {
        if (this.bAt != null) {
            this.bAt.setVisibility(z ? 0 : 8);
        }
    }
}
