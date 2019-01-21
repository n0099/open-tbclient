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
    protected RelativeLayout cVH;
    protected TextView cVI;
    public TextView cVJ;
    public TextView cVK;
    private View cVL;
    private View cVM;
    private View cVN;
    public ImageView cVO;
    public LinearLayout cVP;
    public View cVQ;
    public View cVR;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.b<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.a
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((b<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cVH = null;
        this.cVI = null;
        this.cVJ = null;
        this.cVK = null;
        this.cVL = null;
        this.cVM = null;
        this.cVN = null;
        this.cVP = null;
        initView(getView());
    }

    private void initView(View view) {
        this.cVH = (RelativeLayout) view.findViewById(e.g.item_layout_group_title);
        this.cVI = (TextView) view.findViewById(e.g.item_group_title);
        this.cVJ = (TextView) view.findViewById(e.g.item_right_tv);
        this.cVK = (TextView) view.findViewById(e.g.item_bottom_more_tv);
        this.cVL = view.findViewById(e.g.divider_line_top);
        this.cVM = view.findViewById(e.g.divider_line_middle);
        this.cVN = view.findViewById(e.g.divider_line_bottom);
        this.cVP = (LinearLayout) view.findViewById(e.g.card_container);
        this.cVQ = view.findViewById(e.g.divider_card);
        this.cVR = view.findViewById(e.g.divider_card_top);
        this.cVO = (ImageView) view.findViewById(e.g.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void aqq() {
        if (getFrom() != null && getFrom().equals("home")) {
            al.c(this.cVI, e.d.cp_cont_d, 1);
            this.cVO.setVisibility(8);
        } else {
            al.c(this.cVI, e.d.cp_cont_f, 1);
            al.c(this.cVO, e.f.icon_arrow_tab);
        }
        al.c(this.cVJ, e.d.cp_link_tip_c, 1);
        al.c(this.cVK, e.d.cp_cont_d, 1);
        al.j(getView(), e.d.cp_bg_line_d);
        al.j(this.cVL, e.d.cp_bg_line_c);
        al.j(this.cVM, e.d.cp_bg_line_c);
        al.j(this.cVN, e.d.cp_bg_line_c);
        al.j(this.cVQ, e.d.cp_bg_line_c);
        al.j(this.cVR, e.d.cp_bg_line_c);
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
        this.cVI.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.cVJ.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.cVR.setVisibility(0);
        } else {
            this.cVR.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.cVQ.setVisibility(0);
        } else {
            this.cVQ.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.cVK.setVisibility(0);
            this.cVN.setVisibility(0);
            this.cVM.setVisibility(0);
            this.cVK.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.cVK.setTag(str);
                this.cVK.setOnClickListener(this);
                return;
            }
            return;
        }
        this.cVK.setVisibility(8);
        this.cVN.setVisibility(8);
        this.cVM.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cVK == view && view != null && (view.getTag() instanceof String)) {
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
        if (this.cVL != null && this.cVL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.cVL.getLayoutParams();
            layoutParams.height = i;
            this.cVL.setLayoutParams(layoutParams);
        }
        if (this.cVM != null && this.cVM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cVM.getLayoutParams();
            layoutParams2.height = i;
            this.cVM.setLayoutParams(layoutParams2);
        }
        if (this.cVN != null && this.cVN.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.cVN.getLayoutParams();
            layoutParams3.height = i;
            this.cVN.setLayoutParams(layoutParams3);
        }
    }

    public void fr(boolean z) {
        if (this.cVQ != null) {
            this.cVQ.setVisibility(z ? 0 : 8);
        }
    }
}
