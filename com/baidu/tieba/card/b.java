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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.a;
/* loaded from: classes8.dex */
public abstract class b<T extends com.baidu.tieba.card.data.a> extends a<T> {
    protected RelativeLayout gmP;
    protected TextView gmQ;
    public TextView gmR;
    public TextView gmS;
    private View gmT;
    private View gmU;
    private View gmV;
    public ImageView gmW;
    public LinearLayout gmX;
    public View gmY;
    public View gmZ;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gmP = null;
        this.gmQ = null;
        this.gmR = null;
        this.gmS = null;
        this.gmT = null;
        this.gmU = null;
        this.gmV = null;
        this.gmX = null;
        ag(getView());
    }

    private void ag(View view) {
        this.gmP = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.gmQ = (TextView) view.findViewById(R.id.item_group_title);
        this.gmR = (TextView) view.findViewById(R.id.item_right_tv);
        this.gmS = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.gmT = view.findViewById(R.id.divider_line_top);
        this.gmU = view.findViewById(R.id.divider_line_middle);
        this.gmV = view.findViewById(R.id.divider_line_bottom);
        this.gmX = (LinearLayout) view.findViewById(R.id.card_container);
        this.gmY = view.findViewById(R.id.divider_card);
        this.gmZ = view.findViewById(R.id.divider_card_top);
        this.gmW = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void bEx() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.gmQ, R.color.cp_cont_d, 1);
            this.gmW.setVisibility(8);
        } else {
            am.setViewTextColor(this.gmQ, R.color.cp_cont_f, 1);
            am.setImageResource(this.gmW, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.gmR, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.gmS, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.gmT, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gmU, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gmV, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gmY, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gmZ, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bEx();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.gmQ.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.gmR.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.gmZ.setVisibility(0);
        } else {
            this.gmZ.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.gmY.setVisibility(0);
        } else {
            this.gmY.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.gmS.setVisibility(0);
            this.gmV.setVisibility(0);
            this.gmU.setVisibility(0);
            this.gmS.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.gmS.setTag(str);
                this.gmS.setOnClickListener(this);
                return;
            }
            return;
        }
        this.gmS.setVisibility(8);
        this.gmV.setVisibility(8);
        this.gmU.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gmS == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aOV().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void rF(int i) {
        if (this.gmT != null && this.gmT.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gmT.getLayoutParams();
            layoutParams.height = i;
            this.gmT.setLayoutParams(layoutParams);
        }
        if (this.gmU != null && this.gmU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.gmU.getLayoutParams();
            layoutParams2.height = i;
            this.gmU.setLayoutParams(layoutParams2);
        }
        if (this.gmV != null && this.gmV.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.gmV.getLayoutParams();
            layoutParams3.height = i;
            this.gmV.setLayoutParams(layoutParams3);
        }
    }

    public void lp(boolean z) {
        if (this.gmY != null) {
            this.gmY.setVisibility(z ? 0 : 8);
        }
    }
}
