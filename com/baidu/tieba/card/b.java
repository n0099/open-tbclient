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
    protected RelativeLayout bYX;
    protected TextView bYY;
    public TextView bYZ;
    public TextView bZa;
    private View bZb;
    private View bZc;
    private View bZd;
    public ImageView bZe;
    public LinearLayout bZf;
    public View bZg;
    public View bZh;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bYX = null;
        this.bYY = null;
        this.bYZ = null;
        this.bZa = null;
        this.bZb = null;
        this.bZc = null;
        this.bZd = null;
        this.bZf = null;
        ab(getView());
    }

    private void ab(View view) {
        this.bYX = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.bYY = (TextView) view.findViewById(d.g.item_group_title);
        this.bYZ = (TextView) view.findViewById(d.g.item_right_tv);
        this.bZa = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.bZb = view.findViewById(d.g.divider_line_top);
        this.bZc = view.findViewById(d.g.divider_line_middle);
        this.bZd = view.findViewById(d.g.divider_line_bottom);
        this.bZf = (LinearLayout) view.findViewById(d.g.card_container);
        this.bZg = view.findViewById(d.g.divider_card);
        this.bZh = view.findViewById(d.g.divider_card_top);
        this.bZe = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void abu() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.c(this.bYY, d.C0095d.cp_cont_d, 1);
            this.bZe.setVisibility(8);
        } else {
            aj.c(this.bYY, d.C0095d.cp_cont_f, 1);
            aj.c(this.bZe, d.f.icon_arrow_tab);
        }
        aj.c(this.bYZ, d.C0095d.cp_link_tip_c, 1);
        aj.c(this.bZa, d.C0095d.cp_cont_d, 1);
        aj.k(getView(), d.C0095d.cp_bg_line_d);
        aj.k(this.bZb, d.C0095d.cp_bg_line_c);
        aj.k(this.bZc, d.C0095d.cp_bg_line_c);
        aj.k(this.bZd, d.C0095d.cp_bg_line_c);
        aj.k(this.bZg, d.C0095d.cp_bg_line_c);
        aj.k(this.bZh, d.C0095d.cp_bg_line_c);
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
        this.bYY.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bYZ.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bZh.setVisibility(0);
        } else {
            this.bZh.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bZg.setVisibility(0);
        } else {
            this.bZg.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bZa.setVisibility(0);
            this.bZd.setVisibility(0);
            this.bZc.setVisibility(0);
            this.bZa.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bZa.setTag(str);
                this.bZa.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bZa.setVisibility(8);
        this.bZd.setVisibility(8);
        this.bZc.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bZa == view && view != null && (view.getTag() instanceof String)) {
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
        if (this.bZb != null && this.bZb.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bZb.getLayoutParams();
            layoutParams.height = i;
            this.bZb.setLayoutParams(layoutParams);
        }
        if (this.bZc != null && this.bZc.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bZc.getLayoutParams();
            layoutParams2.height = i;
            this.bZc.setLayoutParams(layoutParams2);
        }
        if (this.bZd != null && this.bZd.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bZd.getLayoutParams();
            layoutParams3.height = i;
            this.bZd.setLayoutParams(layoutParams3);
        }
    }

    public void dN(boolean z) {
        if (this.bZg != null) {
            this.bZg.setVisibility(z ? 0 : 8);
        }
    }
}
