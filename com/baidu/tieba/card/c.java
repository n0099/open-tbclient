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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.a;
/* loaded from: classes21.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    protected RelativeLayout hVD;
    protected TextView hVE;
    public TextView hVF;
    public TextView hVG;
    private View hVH;
    private View hVI;
    private View hVJ;
    public ImageView hVK;
    public LinearLayout hVL;
    public View hVM;
    public View hVN;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(com.baidu.tieba.card.data.b bVar) {
        a((c<T>) ((com.baidu.tieba.card.data.a) bVar));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hVD = null;
        this.hVE = null;
        this.hVF = null;
        this.hVG = null;
        this.hVH = null;
        this.hVI = null;
        this.hVJ = null;
        this.hVL = null;
        al(getView());
    }

    private void al(View view) {
        this.hVD = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.hVE = (TextView) view.findViewById(R.id.item_group_title);
        this.hVF = (TextView) view.findViewById(R.id.item_right_tv);
        this.hVG = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.hVH = view.findViewById(R.id.divider_line_top);
        this.hVI = view.findViewById(R.id.divider_line_middle);
        this.hVJ = view.findViewById(R.id.divider_line_bottom);
        this.hVL = (LinearLayout) view.findViewById(R.id.card_container);
        this.hVM = view.findViewById(R.id.divider_card);
        this.hVN = view.findViewById(R.id.divider_card_top);
        this.hVK = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cnU() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.hVE, R.color.cp_cont_d, 1);
            this.hVK.setVisibility(8);
        } else {
            ap.setViewTextColor(this.hVE, R.color.cp_cont_f, 1);
            ap.setImageResource(this.hVK, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.hVF, R.color.cp_link_tip_c, 1);
        ap.setViewTextColor(this.hVG, R.color.cp_cont_d, 1);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.hVH, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hVI, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hVJ, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hVM, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.hVN, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            cnU();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.hVE.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.hVF.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.hVN.setVisibility(0);
        } else {
            this.hVN.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.hVM.setVisibility(0);
        } else {
            this.hVM.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.hVG.setVisibility(0);
            this.hVJ.setVisibility(0);
            this.hVI.setVisibility(0);
            this.hVG.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.hVG.setTag(str);
                this.hVG.setOnClickListener(this);
                return;
            }
            return;
        }
        this.hVG.setVisibility(8);
        this.hVJ.setVisibility(8);
        this.hVI.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hVG == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                be.brr().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void xb(int i) {
        if (this.hVH != null && this.hVH.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hVH.getLayoutParams();
            layoutParams.height = i;
            this.hVH.setLayoutParams(layoutParams);
        }
        if (this.hVI != null && this.hVI.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.hVI.getLayoutParams();
            layoutParams2.height = i;
            this.hVI.setLayoutParams(layoutParams2);
        }
        if (this.hVJ != null && this.hVJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.hVJ.getLayoutParams();
            layoutParams3.height = i;
            this.hVJ.setLayoutParams(layoutParams3);
        }
    }

    public void oq(boolean z) {
        if (this.hVM != null) {
            this.hVM.setVisibility(z ? 0 : 8);
        }
    }
}
