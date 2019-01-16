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
    protected RelativeLayout cVG;
    protected TextView cVH;
    public TextView cVI;
    public TextView cVJ;
    private View cVK;
    private View cVL;
    private View cVM;
    public ImageView cVN;
    public LinearLayout cVO;
    public View cVP;
    public View cVQ;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cVG = null;
        this.cVH = null;
        this.cVI = null;
        this.cVJ = null;
        this.cVK = null;
        this.cVL = null;
        this.cVM = null;
        this.cVO = null;
        initView(getView());
    }

    private void initView(View view) {
        this.cVG = (RelativeLayout) view.findViewById(e.g.item_layout_group_title);
        this.cVH = (TextView) view.findViewById(e.g.item_group_title);
        this.cVI = (TextView) view.findViewById(e.g.item_right_tv);
        this.cVJ = (TextView) view.findViewById(e.g.item_bottom_more_tv);
        this.cVK = view.findViewById(e.g.divider_line_top);
        this.cVL = view.findViewById(e.g.divider_line_middle);
        this.cVM = view.findViewById(e.g.divider_line_bottom);
        this.cVO = (LinearLayout) view.findViewById(e.g.card_container);
        this.cVP = view.findViewById(e.g.divider_card);
        this.cVQ = view.findViewById(e.g.divider_card_top);
        this.cVN = (ImageView) view.findViewById(e.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aqq() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.c(this.cVH, e.d.cp_cont_d, 1);
            this.cVN.setVisibility(8);
        } else {
            al.c(this.cVH, e.d.cp_cont_f, 1);
            al.c(this.cVN, e.f.icon_arrow_tab);
        }
        al.c(this.cVI, e.d.cp_link_tip_c, 1);
        al.c(this.cVJ, e.d.cp_cont_d, 1);
        al.j(getView(), e.d.cp_bg_line_d);
        al.j(this.cVK, e.d.cp_bg_line_c);
        al.j(this.cVL, e.d.cp_bg_line_c);
        al.j(this.cVM, e.d.cp_bg_line_c);
        al.j(this.cVP, e.d.cp_bg_line_c);
        al.j(this.cVQ, e.d.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aqq();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.cVH.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cVI.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cVQ.setVisibility(0);
        } else {
            this.cVQ.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cVP.setVisibility(0);
        } else {
            this.cVP.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cVJ.setVisibility(0);
            this.cVM.setVisibility(0);
            this.cVL.setVisibility(0);
            this.cVJ.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cVJ.setTag(str);
                this.cVJ.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cVJ.setVisibility(8);
        this.cVM.setVisibility(8);
        this.cVL.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cVJ == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                ay.Es().c(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public final int getLayout() {
        return e.h.card_group;
    }

    public void kH(int i) {
        if (this.cVK != null && this.cVK.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cVK.getLayoutParams();
            layoutParams.height = i;
            this.cVK.setLayoutParams(layoutParams);
        }
        if (this.cVL != null && this.cVL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cVL.getLayoutParams();
            layoutParams2.height = i;
            this.cVL.setLayoutParams(layoutParams2);
        }
        if (this.cVM != null && this.cVM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cVM.getLayoutParams();
            layoutParams3.height = i;
            this.cVM.setLayoutParams(layoutParams3);
        }
    }

    public void fr(boolean z) {
        if (this.cVP != null) {
            this.cVP.setVisibility(z ? 0 : 8);
        }
    }
}
