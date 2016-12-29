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
    protected RelativeLayout baC;
    protected TextView baD;
    public TextView baE;
    public TextView baF;
    private View baG;
    private View baH;
    private View baI;
    public ImageView baJ;
    public LinearLayout baK;
    public View baL;
    public View baM;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.baC = null;
        this.baD = null;
        this.baE = null;
        this.baF = null;
        this.baG = null;
        this.baH = null;
        this.baI = null;
        this.baK = null;
        S(getView());
    }

    private void S(View view) {
        this.baC = (RelativeLayout) view.findViewById(r.g.item_layout_group_title);
        this.baD = (TextView) view.findViewById(r.g.item_group_title);
        this.baE = (TextView) view.findViewById(r.g.item_right_tv);
        this.baF = (TextView) view.findViewById(r.g.item_bottom_more_tv);
        this.baG = view.findViewById(r.g.divider_line_top);
        this.baH = view.findViewById(r.g.divider_line_middle);
        this.baI = view.findViewById(r.g.divider_line_bottom);
        this.baK = (LinearLayout) view.findViewById(r.g.card_container);
        this.baL = view.findViewById(r.g.divider_card);
        this.baM = view.findViewById(r.g.divider_card_top);
        this.baJ = (ImageView) view.findViewById(r.g.item_right_arrow);
    }

    private void Oq() {
        if (getFrom() != null && getFrom().equals("home")) {
            com.baidu.tbadk.core.util.ar.c(this.baD, r.d.cp_cont_d, 1);
            this.baJ.setVisibility(8);
        } else {
            com.baidu.tbadk.core.util.ar.c(this.baD, r.d.cp_cont_f, 1);
            com.baidu.tbadk.core.util.ar.c(this.baJ, r.f.icon_arrow_tab);
        }
        com.baidu.tbadk.core.util.ar.c(this.baE, r.d.cp_link_tip_c, 1);
        com.baidu.tbadk.core.util.ar.c(this.baF, r.d.cp_cont_d, 1);
        com.baidu.tbadk.core.util.ar.l(getView(), r.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.ar.l(this.baG, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.baH, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.baI, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.baL, r.d.cp_bg_line_c);
        com.baidu.tbadk.core.util.ar.l(this.baM, r.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            Oq();
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
        this.baD.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.baE.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.baM.setVisibility(0);
        } else {
            this.baM.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.baL.setVisibility(0);
        } else {
            this.baL.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.baF.setVisibility(0);
            this.baI.setVisibility(0);
            this.baH.setVisibility(0);
            this.baF.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.baF.setTag(str);
                this.baF.setOnClickListener(this);
                return;
            }
            return;
        }
        this.baF.setVisibility(8);
        this.baI.setVisibility(8);
        this.baH.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.baF == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                com.baidu.tbadk.core.util.bc.vz().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return r.h.card_group;
    }

    public void gf(int i) {
        if (this.baG != null && this.baG.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.baG.getLayoutParams();
            layoutParams.height = i;
            this.baG.setLayoutParams(layoutParams);
        }
        if (this.baH != null && this.baH.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.baH.getLayoutParams();
            layoutParams2.height = i;
            this.baH.setLayoutParams(layoutParams2);
        }
        if (this.baI != null && this.baI.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.baI.getLayoutParams();
            layoutParams3.height = i;
            this.baI.setLayoutParams(layoutParams3);
        }
    }

    public void cx(boolean z) {
        if (this.baL != null) {
            this.baL.setVisibility(z ? 0 : 8);
        }
    }
}
