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
    protected RelativeLayout iha;
    protected TextView ihb;
    public TextView ihc;
    public TextView ihd;
    private View ihe;
    private View ihf;
    private View ihg;
    public ImageView ihh;
    public LinearLayout ihi;
    public View ihj;
    public View ihk;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(BaseCardInfo baseCardInfo) {
        a((c<T>) ((com.baidu.tieba.card.data.a) baseCardInfo));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iha = null;
        this.ihb = null;
        this.ihc = null;
        this.ihd = null;
        this.ihe = null;
        this.ihf = null;
        this.ihg = null;
        this.ihi = null;
        an(getView());
    }

    private void an(View view) {
        this.iha = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.ihb = (TextView) view.findViewById(R.id.item_group_title);
        this.ihc = (TextView) view.findViewById(R.id.item_right_tv);
        this.ihd = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.ihe = view.findViewById(R.id.divider_line_top);
        this.ihf = view.findViewById(R.id.divider_line_middle);
        this.ihg = view.findViewById(R.id.divider_line_bottom);
        this.ihi = (LinearLayout) view.findViewById(R.id.card_container);
        this.ihj = view.findViewById(R.id.divider_card);
        this.ihk = view.findViewById(R.id.divider_card_top);
        this.ihh = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void crJ() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.ihb, R.color.CAM_X0109, 1);
            this.ihh.setVisibility(8);
        } else {
            ap.setViewTextColor(this.ihb, R.color.CAM_X0106, 1);
            ap.setImageResource(this.ihh, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.ihc, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.ihd, R.color.CAM_X0109, 1);
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        ap.setBackgroundColor(this.ihe, R.color.CAM_X0204);
        ap.setBackgroundColor(this.ihf, R.color.CAM_X0204);
        ap.setBackgroundColor(this.ihg, R.color.CAM_X0204);
        ap.setBackgroundColor(this.ihj, R.color.CAM_X0204);
        ap.setBackgroundColor(this.ihk, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            crJ();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.ihb.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.ihc.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.ihk.setVisibility(0);
        } else {
            this.ihk.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.ihj.setVisibility(0);
        } else {
            this.ihj.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.ihd.setVisibility(0);
            this.ihg.setVisibility(0);
            this.ihf.setVisibility(0);
            this.ihd.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.ihd.setTag(str);
                this.ihd.setOnClickListener(this);
                return;
            }
            return;
        }
        this.ihd.setVisibility(8);
        this.ihg.setVisibility(8);
        this.ihf.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ihd == view && view != null && (view.getTag() instanceof String)) {
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
        if (this.ihe != null && this.ihe.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ihe.getLayoutParams();
            layoutParams.height = i;
            this.ihe.setLayoutParams(layoutParams);
        }
        if (this.ihf != null && this.ihf.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.ihf.getLayoutParams();
            layoutParams2.height = i;
            this.ihf.setLayoutParams(layoutParams2);
        }
        if (this.ihg != null && this.ihg.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.ihg.getLayoutParams();
            layoutParams3.height = i;
            this.ihg.setLayoutParams(layoutParams3);
        }
    }

    public void oO(boolean z) {
        if (this.ihj != null) {
            this.ihj.setVisibility(z ? 0 : 8);
        }
    }
}
