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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    public View bkA;
    protected RelativeLayout bkq;
    protected TextView bkr;
    public TextView bks;
    public TextView bkt;
    private View bku;
    private View bkv;
    private View bkw;
    public ImageView bkx;
    public LinearLayout bky;
    public View bkz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bkq = null;
        this.bkr = null;
        this.bks = null;
        this.bkt = null;
        this.bku = null;
        this.bkv = null;
        this.bkw = null;
        this.bky = null;
        R(getView());
    }

    private void R(View view) {
        this.bkq = (RelativeLayout) view.findViewById(r.h.item_layout_group_title);
        this.bkr = (TextView) view.findViewById(r.h.item_group_title);
        this.bks = (TextView) view.findViewById(r.h.item_right_tv);
        this.bkt = (TextView) view.findViewById(r.h.item_bottom_more_tv);
        this.bku = view.findViewById(r.h.divider_line_top);
        this.bkv = view.findViewById(r.h.divider_line_middle);
        this.bkw = view.findViewById(r.h.divider_line_bottom);
        this.bky = (LinearLayout) view.findViewById(r.h.card_container);
        this.bkz = view.findViewById(r.h.divider_card);
        this.bkA = view.findViewById(r.h.divider_card_top);
        this.bkx = (ImageView) view.findViewById(r.h.item_right_arrow);
    }

    private void Rj() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.ap.c(this.bkr, r.e.cp_cont_d, 1);
            this.bkx.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.ap.c(this.bkr, r.e.cp_cont_f, 1);
            com.baidu.tbadk.core.util.ap.c(this.bkx, r.g.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.ap.c(this.bks, r.e.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.ap.c(this.bkt, r.e.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ap.k(getView(), r.e.cp_bg_line_d);
        com.baidu.tbadk.core.util.ap.k(this.bku, r.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.ap.k(this.bkv, r.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.ap.k(this.bkw, r.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.ap.k(this.bkz, r.e.cp_bg_line_c);
        com.baidu.tbadk.core.util.ap.k(this.bkA, r.e.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Rj();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.bkr.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.bks.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.bkA.setVisibility(0);
        } else {
            this.bkA.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.bkz.setVisibility(0);
        } else {
            this.bkz.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.bkt.setVisibility(0);
            this.bkw.setVisibility(0);
            this.bkv.setVisibility(0);
            this.bkt.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.bkt.setTag(str);
                this.bkt.setOnClickListener(this);
                return;
            }
            return;
        }
        this.bkt.setVisibility(8);
        this.bkw.setVisibility(8);
        this.bkv.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bkt == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.ba.vt().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return r.j.card_group;
    }

    public void gH(int i) {
        if (this.bku != null && this.bku.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bku.getLayoutParams();
            layoutParams.height = i;
            this.bku.setLayoutParams(layoutParams);
        }
        if (this.bkv != null && this.bkv.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.bkv.getLayoutParams();
            layoutParams2.height = i;
            this.bkv.setLayoutParams(layoutParams2);
        }
        if (this.bkw != null && this.bkw.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.bkw.getLayoutParams();
            layoutParams3.height = i;
            this.bkw.setLayoutParams(layoutParams3);
        }
    }

    public void cL(boolean z) {
        if (this.bkz != null) {
            this.bkz.setVisibility(z ? 0 : 8);
        }
    }
}
