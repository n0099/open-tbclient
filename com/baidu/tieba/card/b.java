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
    protected RelativeLayout bGk;
    protected TextView bGl;
    public TextView bGm;
    public TextView bGn;
    private View bGo;
    private View bGp;
    private View bGq;
    public ImageView bGr;
    public LinearLayout bGs;
    public View bGt;
    public View bGu;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bGk = null;
        this.bGl = null;
        this.bGm = null;
        this.bGn = null;
        this.bGo = null;
        this.bGp = null;
        this.bGq = null;
        this.bGs = null;
        P(getView());
    }

    private void P(View view) {
        this.bGk = (RelativeLayout) view.findViewById(d.h.item_layout_group_title);
        this.bGl = (TextView) view.findViewById(d.h.item_group_title);
        this.bGm = (TextView) view.findViewById(d.h.item_right_tv);
        this.bGn = (TextView) view.findViewById(d.h.item_bottom_more_tv);
        this.bGo = view.findViewById(d.h.divider_line_top);
        this.bGp = view.findViewById(d.h.divider_line_middle);
        this.bGq = view.findViewById(d.h.divider_line_bottom);
        this.bGs = (LinearLayout) view.findViewById(d.h.card_container);
        this.bGt = view.findViewById(d.h.divider_card);
        this.bGu = view.findViewById(d.h.divider_card_top);
        this.bGr = (ImageView) view.findViewById(d.h.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void WB() {
        if (getFrom() != null && getFrom().equals("home")) {
            ai.c(this.bGl, d.e.cp_cont_d, 1);
            this.bGr.setVisibility(8);
        } else {
            ai.c(this.bGl, d.e.cp_cont_f, 1);
            ai.c(this.bGr, d.g.icon_arrow_tab);
        }
        ai.c(this.bGm, d.e.cp_link_tip_c, 1);
        ai.c(this.bGn, d.e.cp_cont_d, 1);
        ai.k(getView(), d.e.cp_bg_line_d);
        ai.k(this.bGo, d.e.cp_bg_line_c);
        ai.k(this.bGp, d.e.cp_bg_line_c);
        ai.k(this.bGq, d.e.cp_bg_line_c);
        ai.k(this.bGt, d.e.cp_bg_line_c);
        ai.k(this.bGu, d.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            WB();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bGl.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bGm.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bGu.setVisibility(0);
        } else {
            this.bGu.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bGt.setVisibility(0);
        } else {
            this.bGt.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bGn.setVisibility(0);
            this.bGq.setVisibility(0);
            this.bGp.setVisibility(0);
            this.bGn.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bGn.setTag(str);
                this.bGn.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bGn.setVisibility(8);
        this.bGq.setVisibility(8);
        this.bGp.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bGn == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                at.wf().c(Wz(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.j.card_group;
    }

    public void ht(int i) {
        if (this.bGo != null && this.bGo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bGo.getLayoutParams();
            layoutParams.height = i;
            this.bGo.setLayoutParams(layoutParams);
        }
        if (this.bGp != null && this.bGp.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bGp.getLayoutParams();
            layoutParams2.height = i;
            this.bGp.setLayoutParams(layoutParams2);
        }
        if (this.bGq != null && this.bGq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bGq.getLayoutParams();
            layoutParams3.height = i;
            this.bGq.setLayoutParams(layoutParams3);
        }
    }

    public void dD(boolean z) {
        if (this.bGt != null) {
            this.bGt.setVisibility(z ? 0 : 8);
        }
    }
}
