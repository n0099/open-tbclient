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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.data.a;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout cUV;
    protected TextView cUW;
    public TextView cUX;
    public TextView cUY;
    private View cUZ;
    private View cVa;
    private View cVb;
    public ImageView cVc;
    public LinearLayout cVd;
    public View cVe;
    public View cVf;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cUV = null;
        this.cUW = null;
        this.cUX = null;
        this.cUY = null;
        this.cUZ = null;
        this.cVa = null;
        this.cVb = null;
        this.cVd = null;
        initView(getView());
    }

    private void initView(View view) {
        this.cUV = (RelativeLayout) view.findViewById(e.g.item_layout_group_title);
        this.cUW = (TextView) view.findViewById(e.g.item_group_title);
        this.cUX = (TextView) view.findViewById(e.g.item_right_tv);
        this.cUY = (TextView) view.findViewById(e.g.item_bottom_more_tv);
        this.cUZ = view.findViewById(e.g.divider_line_top);
        this.cVa = view.findViewById(e.g.divider_line_middle);
        this.cVb = view.findViewById(e.g.divider_line_bottom);
        this.cVd = (LinearLayout) view.findViewById(e.g.card_container);
        this.cVe = view.findViewById(e.g.divider_card);
        this.cVf = view.findViewById(e.g.divider_card_top);
        this.cVc = (ImageView) view.findViewById(e.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void apT() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.c(this.cUW, e.d.cp_cont_d, 1);
            this.cVc.setVisibility(8);
        } else {
            al.c(this.cUW, e.d.cp_cont_f, 1);
            al.c(this.cVc, e.f.icon_arrow_tab);
        }
        al.c(this.cUX, e.d.cp_link_tip_c, 1);
        al.c(this.cUY, e.d.cp_cont_d, 1);
        al.j(getView(), e.d.cp_bg_line_d);
        al.j(this.cUZ, e.d.cp_bg_line_c);
        al.j(this.cVa, e.d.cp_bg_line_c);
        al.j(this.cVb, e.d.cp_bg_line_c);
        al.j(this.cVe, e.d.cp_bg_line_c);
        al.j(this.cVf, e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            apT();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cUW.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cUX.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cVf.setVisibility(0);
        } else {
            this.cVf.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cVe.setVisibility(0);
        } else {
            this.cVe.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cUY.setVisibility(0);
            this.cVb.setVisibility(0);
            this.cVa.setVisibility(0);
            this.cUY.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cUY.setTag(str);
                this.cUY.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cUY.setVisibility(8);
        this.cVb.setVisibility(8);
        this.cVa.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cUY == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ay.Ef().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return e.h.card_group;
    }

    public void kH(int i) {
        if (this.cUZ != null && this.cUZ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cUZ.getLayoutParams();
            layoutParams.height = i;
            this.cUZ.setLayoutParams(layoutParams);
        }
        if (this.cVa != null && this.cVa.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cVa.getLayoutParams();
            layoutParams2.height = i;
            this.cVa.setLayoutParams(layoutParams2);
        }
        if (this.cVb != null && this.cVb.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cVb.getLayoutParams();
            layoutParams3.height = i;
            this.cVb.setLayoutParams(layoutParams3);
        }
    }

    public void fo(boolean z) {
        if (this.cVe != null) {
            this.cVe.setVisibility(z ? 0 : 8);
        }
    }
}
