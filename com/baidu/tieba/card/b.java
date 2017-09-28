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
    protected RelativeLayout bJk;
    protected TextView bJl;
    public TextView bJm;
    public TextView bJn;
    private View bJo;
    private View bJp;
    private View bJq;
    public ImageView bJr;
    public LinearLayout bJs;
    public View bJt;
    public View bJu;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJk = null;
        this.bJl = null;
        this.bJm = null;
        this.bJn = null;
        this.bJo = null;
        this.bJp = null;
        this.bJq = null;
        this.bJs = null;
        X(getView());
    }

    private void X(View view) {
        this.bJk = (RelativeLayout) view.findViewById(d.h.item_layout_group_title);
        this.bJl = (TextView) view.findViewById(d.h.item_group_title);
        this.bJm = (TextView) view.findViewById(d.h.item_right_tv);
        this.bJn = (TextView) view.findViewById(d.h.item_bottom_more_tv);
        this.bJo = view.findViewById(d.h.divider_line_top);
        this.bJp = view.findViewById(d.h.divider_line_middle);
        this.bJq = view.findViewById(d.h.divider_line_bottom);
        this.bJs = (LinearLayout) view.findViewById(d.h.card_container);
        this.bJt = view.findViewById(d.h.divider_card);
        this.bJu = view.findViewById(d.h.divider_card_top);
        this.bJr = (ImageView) view.findViewById(d.h.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void Xs() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.c(this.bJl, d.e.cp_cont_d, 1);
            this.bJr.setVisibility(8);
        } else {
            aj.c(this.bJl, d.e.cp_cont_f, 1);
            aj.c(this.bJr, d.g.icon_arrow_tab);
        }
        aj.c(this.bJm, d.e.cp_link_tip_c, 1);
        aj.c(this.bJn, d.e.cp_cont_d, 1);
        aj.k(getView(), d.e.cp_bg_line_d);
        aj.k(this.bJo, d.e.cp_bg_line_c);
        aj.k(this.bJp, d.e.cp_bg_line_c);
        aj.k(this.bJq, d.e.cp_bg_line_c);
        aj.k(this.bJt, d.e.cp_bg_line_c);
        aj.k(this.bJu, d.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Xs();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bJl.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bJm.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bJu.setVisibility(0);
        } else {
            this.bJu.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bJt.setVisibility(0);
        } else {
            this.bJt.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bJn.setVisibility(0);
            this.bJq.setVisibility(0);
            this.bJp.setVisibility(0);
            this.bJn.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bJn.setTag(str);
                this.bJn.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bJn.setVisibility(8);
        this.bJq.setVisibility(8);
        this.bJp.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bJn == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                av.vH().c(Xq(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.j.card_group;
    }

    public void hO(int i) {
        if (this.bJo != null && this.bJo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bJo.getLayoutParams();
            layoutParams.height = i;
            this.bJo.setLayoutParams(layoutParams);
        }
        if (this.bJp != null && this.bJp.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bJp.getLayoutParams();
            layoutParams2.height = i;
            this.bJp.setLayoutParams(layoutParams2);
        }
        if (this.bJq != null && this.bJq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bJq.getLayoutParams();
            layoutParams3.height = i;
            this.bJq.setLayoutParams(layoutParams3);
        }
    }

    public void dz(boolean z) {
        if (this.bJt != null) {
            this.bJt.setVisibility(z ? 0 : 8);
        }
    }
}
