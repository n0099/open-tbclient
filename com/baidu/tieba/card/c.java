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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.a;
/* loaded from: classes21.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    protected RelativeLayout ihc;
    protected TextView ihd;
    public TextView ihe;
    public TextView ihf;
    private View ihg;
    private View ihh;
    private View ihi;
    public ImageView ihj;
    public LinearLayout ihk;
    public View ihl;
    public View ihm;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(BaseCardInfo baseCardInfo) {
        a((c<T>) ((com.baidu.tieba.card.data.a) baseCardInfo));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ihc = null;
        this.ihd = null;
        this.ihe = null;
        this.ihf = null;
        this.ihg = null;
        this.ihh = null;
        this.ihi = null;
        this.ihk = null;
        an(getView());
    }

    private void an(View view) {
        this.ihc = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.ihd = (TextView) view.findViewById(R.id.item_group_title);
        this.ihe = (TextView) view.findViewById(R.id.item_right_tv);
        this.ihf = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.ihg = view.findViewById(R.id.divider_line_top);
        this.ihh = view.findViewById(R.id.divider_line_middle);
        this.ihi = view.findViewById(R.id.divider_line_bottom);
        this.ihk = (LinearLayout) view.findViewById(R.id.card_container);
        this.ihl = view.findViewById(R.id.divider_card);
        this.ihm = view.findViewById(R.id.divider_card_top);
        this.ihj = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void crK() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.ihd, R.color.CAM_X0109, 1);
            this.ihj.setVisibility(8);
        } else {
            ap.setViewTextColor(this.ihd, R.color.CAM_X0106, 1);
            ap.setImageResource(this.ihj, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.ihe, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.ihf, R.color.CAM_X0109, 1);
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        ap.setBackgroundColor(this.ihg, R.color.CAM_X0204);
        ap.setBackgroundColor(this.ihh, R.color.CAM_X0204);
        ap.setBackgroundColor(this.ihi, R.color.CAM_X0204);
        ap.setBackgroundColor(this.ihl, R.color.CAM_X0204);
        ap.setBackgroundColor(this.ihm, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            crK();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.ihd.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.ihe.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.ihm.setVisibility(0);
        } else {
            this.ihm.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.ihl.setVisibility(0);
        } else {
            this.ihl.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.ihf.setVisibility(0);
            this.ihi.setVisibility(0);
            this.ihh.setVisibility(0);
            this.ihf.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.ihf.setTag(str);
                this.ihf.setOnClickListener(this);
                return;
            }
            return;
        }
        this.ihf.setVisibility(8);
        this.ihi.setVisibility(8);
        this.ihh.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ihf == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bf.bua().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void yf(int i) {
        if (this.ihg != null && this.ihg.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ihg.getLayoutParams();
            layoutParams.height = i;
            this.ihg.setLayoutParams(layoutParams);
        }
        if (this.ihh != null && this.ihh.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.ihh.getLayoutParams();
            layoutParams2.height = i;
            this.ihh.setLayoutParams(layoutParams2);
        }
        if (this.ihi != null && this.ihi.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.ihi.getLayoutParams();
            layoutParams3.height = i;
            this.ihi.setLayoutParams(layoutParams3);
        }
    }

    public void oO(boolean z) {
        if (this.ihl != null) {
            this.ihl.setVisibility(z ? 0 : 8);
        }
    }
}
