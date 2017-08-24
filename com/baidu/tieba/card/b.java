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
    protected RelativeLayout bGl;
    protected TextView bGm;
    public TextView bGn;
    public TextView bGo;
    private View bGp;
    private View bGq;
    private View bGr;
    public ImageView bGs;
    public LinearLayout bGt;
    public View bGu;
    public View bGv;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGl = null;
        this.bGm = null;
        this.bGn = null;
        this.bGo = null;
        this.bGp = null;
        this.bGq = null;
        this.bGr = null;
        this.bGt = null;
        P(getView());
    }

    private void P(View view) {
        this.bGl = (RelativeLayout) view.findViewById(d.h.item_layout_group_title);
        this.bGm = (TextView) view.findViewById(d.h.item_group_title);
        this.bGn = (TextView) view.findViewById(d.h.item_right_tv);
        this.bGo = (TextView) view.findViewById(d.h.item_bottom_more_tv);
        this.bGp = view.findViewById(d.h.divider_line_top);
        this.bGq = view.findViewById(d.h.divider_line_middle);
        this.bGr = view.findViewById(d.h.divider_line_bottom);
        this.bGt = (LinearLayout) view.findViewById(d.h.card_container);
        this.bGu = view.findViewById(d.h.divider_card);
        this.bGv = view.findViewById(d.h.divider_card_top);
        this.bGs = (ImageView) view.findViewById(d.h.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void Wy() {
        if (getFrom() != null && getFrom().equals("home")) {
            ai.c(this.bGm, d.e.cp_cont_d, 1);
            this.bGs.setVisibility(8);
        } else {
            ai.c(this.bGm, d.e.cp_cont_f, 1);
            ai.c(this.bGs, d.g.icon_arrow_tab);
        }
        ai.c(this.bGn, d.e.cp_link_tip_c, 1);
        ai.c(this.bGo, d.e.cp_cont_d, 1);
        ai.k(getView(), d.e.cp_bg_line_d);
        ai.k(this.bGp, d.e.cp_bg_line_c);
        ai.k(this.bGq, d.e.cp_bg_line_c);
        ai.k(this.bGr, d.e.cp_bg_line_c);
        ai.k(this.bGu, d.e.cp_bg_line_c);
        ai.k(this.bGv, d.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Wy();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bGm.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bGn.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bGv.setVisibility(0);
        } else {
            this.bGv.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bGu.setVisibility(0);
        } else {
            this.bGu.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bGo.setVisibility(0);
            this.bGr.setVisibility(0);
            this.bGq.setVisibility(0);
            this.bGo.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bGo.setTag(str);
                this.bGo.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bGo.setVisibility(8);
        this.bGr.setVisibility(8);
        this.bGq.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bGo == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                at.wg().c(Ww(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.j.card_group;
    }

    public void ht(int i) {
        if (this.bGp != null && this.bGp.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bGp.getLayoutParams();
            layoutParams.height = i;
            this.bGp.setLayoutParams(layoutParams);
        }
        if (this.bGq != null && this.bGq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bGq.getLayoutParams();
            layoutParams2.height = i;
            this.bGq.setLayoutParams(layoutParams2);
        }
        if (this.bGr != null && this.bGr.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bGr.getLayoutParams();
            layoutParams3.height = i;
            this.bGr.setLayoutParams(layoutParams3);
        }
    }

    public void dD(boolean z) {
        if (this.bGu != null) {
            this.bGu.setVisibility(z ? 0 : 8);
        }
    }
}
