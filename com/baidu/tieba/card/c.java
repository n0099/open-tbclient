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
/* loaded from: classes.dex */
public abstract class c<T extends com.baidu.tieba.card.data.a> extends b<T> {
    private View iuA;
    public ImageView iuB;
    public LinearLayout iuC;
    public View iuD;
    public View iuE;
    protected RelativeLayout iuu;
    protected TextView iuv;
    public TextView iuw;
    public TextView iux;
    private View iuy;
    private View iuz;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.card.c<T extends com.baidu.tieba.card.data.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.card.b
    public /* bridge */ /* synthetic */ void a(BaseCardInfo baseCardInfo) {
        a((c<T>) ((com.baidu.tieba.card.data.a) baseCardInfo));
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iuu = null;
        this.iuv = null;
        this.iuw = null;
        this.iux = null;
        this.iuy = null;
        this.iuz = null;
        this.iuA = null;
        this.iuC = null;
        am(getView());
    }

    private void am(View view) {
        this.iuu = (RelativeLayout) view.findViewById(R.id.item_layout_group_title);
        this.iuv = (TextView) view.findViewById(R.id.item_group_title);
        this.iuw = (TextView) view.findViewById(R.id.item_right_tv);
        this.iux = (TextView) view.findViewById(R.id.item_bottom_more_tv);
        this.iuy = view.findViewById(R.id.divider_line_top);
        this.iuz = view.findViewById(R.id.divider_line_middle);
        this.iuA = view.findViewById(R.id.divider_line_bottom);
        this.iuC = (LinearLayout) view.findViewById(R.id.card_container);
        this.iuD = view.findViewById(R.id.divider_card);
        this.iuE = view.findViewById(R.id.divider_card_top);
        this.iuB = (ImageView) view.findViewById(R.id.item_right_arrow);
    }

    @SuppressLint({"ResourceAsColor"})
    private void crW() {
        if (getFrom() != null && getFrom().equals("home")) {
            ap.setViewTextColor(this.iuv, R.color.CAM_X0109, 1);
            this.iuB.setVisibility(8);
        } else {
            ap.setViewTextColor(this.iuv, R.color.CAM_X0106, 1);
            ap.setImageResource(this.iuB, R.drawable.icon_arrow_tab);
        }
        ap.setViewTextColor(this.iuw, R.color.CAM_X0304, 1);
        ap.setViewTextColor(this.iux, R.color.CAM_X0109, 1);
        ap.setBackgroundColor(getView(), R.color.CAM_X0201);
        ap.setBackgroundColor(this.iuy, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iuz, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iuA, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iuD, R.color.CAM_X0204);
        ap.setBackgroundColor(this.iuE, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            crW();
        }
        this.mSkinType = i;
    }

    public void a(T t) {
        if (t == null) {
            getView().setVisibility(8);
            return;
        }
        this.iuv.setText(t.mGroupTitle);
        if (t.mRightIconResId > 0) {
            this.iuw.setBackgroundResource(t.mRightIconResId);
        }
        if (t.showTopDivider) {
            this.iuE.setVisibility(0);
        } else {
            this.iuE.setVisibility(8);
        }
        if (t.showBottomDivider) {
            this.iuD.setVisibility(0);
        } else {
            this.iuD.setVisibility(8);
        }
        if (!StringUtils.isNull(t.mBottomText)) {
            this.iux.setVisibility(0);
            this.iuA.setVisibility(0);
            this.iuz.setVisibility(0);
            this.iux.setText(t.mBottomText);
            String str = t.mBottomLink;
            if (!StringUtils.isNull(str)) {
                this.iux.setTag(str);
                this.iux.setOnClickListener(this);
                return;
            }
            return;
        }
        this.iux.setVisibility(8);
        this.iuA.setVisibility(8);
        this.iuz.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iux == view && view != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!StringUtils.isNull(str)) {
                bf.bsV().b(getTbPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public final int getLayout() {
        return R.layout.card_group;
    }

    public void wW(int i) {
        if (this.iuy != null && this.iuy.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.iuy.getLayoutParams();
            layoutParams.height = i;
            this.iuy.setLayoutParams(layoutParams);
        }
        if (this.iuz != null && this.iuz.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams2 = this.iuz.getLayoutParams();
            layoutParams2.height = i;
            this.iuz.setLayoutParams(layoutParams2);
        }
        if (this.iuA != null && this.iuA.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams3 = this.iuA.getLayoutParams();
            layoutParams3.height = i;
            this.iuA.setLayoutParams(layoutParams3);
        }
    }

    public void pt(boolean z) {
        if (this.iuD != null) {
            this.iuD.setVisibility(z ? 0 : 8);
        }
    }
}
