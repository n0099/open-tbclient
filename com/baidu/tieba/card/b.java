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
    protected RelativeLayout gmJ;
    protected TextView gmK;
    public TextView gmL;
    public TextView gmM;
    private View gmN;
    private View gmO;
    private View gmP;
    public ImageView gmQ;
    public LinearLayout gmR;
    public View gmS;
    public View gmT;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gmJ = null;
        this.gmK = null;
        this.gmL = null;
        this.gmM = null;
        this.gmN = null;
        this.gmO = null;
        this.gmP = null;
        this.gmR = null;
        ag(getView());
    }

    private void ag(View view) {
        this.gmJ = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.gmK = (TextView) view.findViewById(R.id.item_group_title);
        this.gmL = (TextView) view.findViewById(R.id.item_right_tv);
        this.gmM = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.gmN = view.findViewById(R.id.divider_line_top);
        this.gmO = view.findViewById(R.id.divider_line_middle);
        this.gmP = view.findViewById(R.id.divider_line_bottom);
        this.gmR = (LinearLayout) view.findViewById(R.id.card_container);
        this.gmS = view.findViewById(R.id.divider_card);
        this.gmT = view.findViewById(R.id.divider_card_top);
        this.gmQ = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void bEz() {
        if (getFrom() != null && getFrom().equals("home")) {
            am.setViewTextColor(this.gmK, R.color.cp_cont_d, 1);
            this.gmQ.setVisibility(8);
        } else {
            am.setViewTextColor(this.gmK, R.color.cp_cont_f, 1);
            am.setImageResource(this.gmQ, R.drawable.icon_arrow_tab);
        }
        am.setViewTextColor(this.gmL, R.color.cp_link_tip_c, 1);
        am.setViewTextColor(this.gmM, R.color.cp_cont_d, 1);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.gmN, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gmO, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gmP, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gmS, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gmT, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bEz();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.gmK.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.gmL.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.gmT.setVisibility(0);
        } else {
            this.gmT.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.gmS.setVisibility(0);
        } else {
            this.gmS.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.gmM.setVisibility(0);
            this.gmP.setVisibility(0);
            this.gmO.setVisibility(0);
            this.gmM.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.gmM.setTag(str);
                this.gmM.setOnClickListener(this);
                return;
            }
            return;
        }
        this.gmM.setVisibility(8);
        this.gmP.setVisibility(8);
        this.gmO.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gmM == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ba.aOY().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void rF(int i) {
        if (this.gmN != null && this.gmN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gmN.getLayoutParams();
            layoutParams.height = i;
            this.gmN.setLayoutParams(layoutParams);
        }
        if (this.gmO != null && this.gmO.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.gmO.getLayoutParams();
            layoutParams2.height = i;
            this.gmO.setLayoutParams(layoutParams2);
        }
        if (this.gmP != null && this.gmP.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.gmP.getLayoutParams();
            layoutParams3.height = i;
            this.gmP.setLayoutParams(layoutParams3);
        }
    }

    public void lp(boolean z) {
        if (this.gmS != null) {
            this.gmS.setVisibility(z ? 0 : 8);
        }
    }
}
