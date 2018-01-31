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
    protected TextView cSA;
    public TextView cSB;
    public TextView cSC;
    private View cSD;
    private View cSE;
    private View cSF;
    public ImageView cSG;
    public LinearLayout cSH;
    public View cSI;
    public View cSJ;
    protected RelativeLayout cSz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cSz = null;
        this.cSA = null;
        this.cSB = null;
        this.cSC = null;
        this.cSD = null;
        this.cSE = null;
        this.cSF = null;
        this.cSH = null;
        bv(getView());
    }

    private void bv(View view) {
        this.cSz = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.cSA = (TextView) view.findViewById(d.g.item_group_title);
        this.cSB = (TextView) view.findViewById(d.g.item_right_tv);
        this.cSC = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.cSD = view.findViewById(d.g.divider_line_top);
        this.cSE = view.findViewById(d.g.divider_line_middle);
        this.cSF = view.findViewById(d.g.divider_line_bottom);
        this.cSH = (LinearLayout) view.findViewById(d.g.card_container);
        this.cSI = view.findViewById(d.g.divider_card);
        this.cSJ = view.findViewById(d.g.divider_card_top);
        this.cSG = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void akh() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.e(this.cSA, d.C0108d.cp_cont_d, 1);
            this.cSG.setVisibility(8);
        } else {
            aj.e(this.cSA, d.C0108d.cp_cont_f, 1);
            aj.c(this.cSG, d.f.icon_arrow_tab);
        }
        aj.e(this.cSB, d.C0108d.cp_link_tip_c, 1);
        aj.e(this.cSC, d.C0108d.cp_cont_d, 1);
        aj.t(getView(), d.C0108d.cp_bg_line_d);
        aj.t(this.cSD, d.C0108d.cp_bg_line_c);
        aj.t(this.cSE, d.C0108d.cp_bg_line_c);
        aj.t(this.cSF, d.C0108d.cp_bg_line_c);
        aj.t(this.cSI, d.C0108d.cp_bg_line_c);
        aj.t(this.cSJ, d.C0108d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            akh();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cSA.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cSB.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cSJ.setVisibility(0);
        } else {
            this.cSJ.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cSI.setVisibility(0);
        } else {
            this.cSI.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cSC.setVisibility(0);
            this.cSF.setVisibility(0);
            this.cSE.setVisibility(0);
            this.cSC.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cSC.setTag(str);
                this.cSC.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cSC.setVisibility(8);
        this.cSF.setVisibility(8);
        this.cSE.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cSC == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                av.Da().c(akf(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void lC(int i) {
        if (this.cSD != null && this.cSD.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cSD.getLayoutParams();
            layoutParams.height = i;
            this.cSD.setLayoutParams(layoutParams);
        }
        if (this.cSE != null && this.cSE.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cSE.getLayoutParams();
            layoutParams2.height = i;
            this.cSE.setLayoutParams(layoutParams2);
        }
        if (this.cSF != null && this.cSF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cSF.getLayoutParams();
            layoutParams3.height = i;
            this.cSF.setLayoutParams(layoutParams3);
        }
    }

    public void eA(boolean z) {
        if (this.cSI != null) {
            this.cSI.setVisibility(z ? 0 : 8);
        }
    }
}
