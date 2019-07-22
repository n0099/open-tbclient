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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.a;
/* loaded from: classes3.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    private View eAa;
    public ImageView eAb;
    public LinearLayout eAc;
    public View eAd;
    public View eAe;
    protected RelativeLayout ezU;
    protected TextView ezV;
    public TextView ezW;
    public TextView ezX;
    private View ezY;
    private View ezZ;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ezU = null;
        this.ezV = null;
        this.ezW = null;
        this.ezX = null;
        this.ezY = null;
        this.ezZ = null;
        this.eAa = null;
        this.eAc = null;
        Q(getView());
    }

    private void Q(View view) {
        this.ezU = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.ezV = (TextView) view.findViewById(R.id.item_group_title);
        this.ezW = (TextView) view.findViewById(R.id.item_right_tv);
        this.ezX = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.ezY = view.findViewById(R.id.divider_line_top);
        this.ezZ = view.findViewById(R.id.divider_line_middle);
        this.eAa = view.findViewById(R.id.divider_line_bottom);
        this.eAc = (LinearLayout) view.findViewById(R.id.card_container);
        this.eAd = view.findViewById(R.id.divider_card);
        this.eAe = view.findViewById(R.id.divider_card_top);
        this.eAb = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aZp() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.f(this.ezV, R.color.cp_cont_d, 1);
            this.eAb.setVisibility(8);
        } else {
            am.f(this.ezV, R.color.cp_cont_f, 1);
            am.c(this.eAb, (int) R.drawable.icon_arrow_tab);
        }
        am.f(this.ezW, R.color.cp_link_tip_c, 1);
        am.f(this.ezX, R.color.cp_cont_d, 1);
        am.l(getView(), R.color.cp_bg_line_d);
        am.l(this.ezY, R.color.cp_bg_line_c);
        am.l(this.ezZ, R.color.cp_bg_line_c);
        am.l(this.eAa, R.color.cp_bg_line_c);
        am.l(this.eAd, R.color.cp_bg_line_c);
        am.l(this.eAe, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aZp();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.ezV.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.ezW.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.eAe.setVisibility(0);
        } else {
            this.eAe.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.eAd.setVisibility(0);
        } else {
            this.eAd.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.ezX.setVisibility(0);
            this.eAa.setVisibility(0);
            this.ezZ.setVisibility(0);
            this.ezX.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.ezX.setTag(str);
                this.ezX.setOnClickListener(this);
                return;
            }
            return;
        }
        this.ezX.setVisibility(8);
        this.eAa.setVisibility(8);
        this.ezZ.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ezX == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bb.ajC().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void pA(int i) {
        if (this.ezY != null && this.ezY.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ezY.getLayoutParams();
            layoutParams.height = i;
            this.ezY.setLayoutParams(layoutParams);
        }
        if (this.ezZ != null && this.ezZ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.ezZ.getLayoutParams();
            layoutParams2.height = i;
            this.ezZ.setLayoutParams(layoutParams2);
        }
        if (this.eAa != null && this.eAa.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.eAa.getLayoutParams();
            layoutParams3.height = i;
            this.eAa.setLayoutParams(layoutParams3);
        }
    }

    public void ix(boolean z) {
        if (this.eAd != null) {
            this.eAd.setVisibility(z ? 0 : 8);
        }
    }
}
