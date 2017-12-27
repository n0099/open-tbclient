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
    protected RelativeLayout cND;
    protected TextView cNE;
    public TextView cNF;
    public TextView cNG;
    private View cNH;
    private View cNI;
    private View cNJ;
    public ImageView cNK;
    public LinearLayout cNL;
    public View cNM;
    public View cNN;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cND = null;
        this.cNE = null;
        this.cNF = null;
        this.cNG = null;
        this.cNH = null;
        this.cNI = null;
        this.cNJ = null;
        this.cNL = null;
        bt(getView());
    }

    private void bt(View view) {
        this.cND = (RelativeLayout) view.findViewById(d.g.item_layout_group_title);
        this.cNE = (TextView) view.findViewById(d.g.item_group_title);
        this.cNF = (TextView) view.findViewById(d.g.item_right_tv);
        this.cNG = (TextView) view.findViewById(d.g.item_bottom_more_tv);
        this.cNH = view.findViewById(d.g.divider_line_top);
        this.cNI = view.findViewById(d.g.divider_line_middle);
        this.cNJ = view.findViewById(d.g.divider_line_bottom);
        this.cNL = (LinearLayout) view.findViewById(d.g.card_container);
        this.cNM = view.findViewById(d.g.divider_card);
        this.cNN = view.findViewById(d.g.divider_card_top);
        this.cNK = (ImageView) view.findViewById(d.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aiZ() {
        if (getFrom() != null && getFrom().equals("home")) {
            aj.e(this.cNE, d.C0108d.cp_cont_d, 1);
            this.cNK.setVisibility(8);
        } else {
            aj.e(this.cNE, d.C0108d.cp_cont_f, 1);
            aj.c(this.cNK, d.f.icon_arrow_tab);
        }
        aj.e(this.cNF, d.C0108d.cp_link_tip_c, 1);
        aj.e(this.cNG, d.C0108d.cp_cont_d, 1);
        aj.t(getView(), d.C0108d.cp_bg_line_d);
        aj.t(this.cNH, d.C0108d.cp_bg_line_c);
        aj.t(this.cNI, d.C0108d.cp_bg_line_c);
        aj.t(this.cNJ, d.C0108d.cp_bg_line_c);
        aj.t(this.cNM, d.C0108d.cp_bg_line_c);
        aj.t(this.cNN, d.C0108d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aiZ();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cNE.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cNF.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cNN.setVisibility(0);
        } else {
            this.cNN.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cNM.setVisibility(0);
        } else {
            this.cNM.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cNG.setVisibility(0);
            this.cNJ.setVisibility(0);
            this.cNI.setVisibility(0);
            this.cNG.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cNG.setTag(str);
                this.cNG.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cNG.setVisibility(8);
        this.cNJ.setVisibility(8);
        this.cNI.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cNG == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                av.Di().c(aiX(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return d.h.card_group;
    }

    public void lA(int i) {
        if (this.cNH != null && this.cNH.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cNH.getLayoutParams();
            layoutParams.height = i;
            this.cNH.setLayoutParams(layoutParams);
        }
        if (this.cNI != null && this.cNI.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cNI.getLayoutParams();
            layoutParams2.height = i;
            this.cNI.setLayoutParams(layoutParams2);
        }
        if (this.cNJ != null && this.cNJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cNJ.getLayoutParams();
            layoutParams3.height = i;
            this.cNJ.setLayoutParams(layoutParams3);
        }
    }

    public void eu(boolean z) {
        if (this.cNM != null) {
            this.cNM.setVisibility(z ? 0 : 8);
        }
    }
}
