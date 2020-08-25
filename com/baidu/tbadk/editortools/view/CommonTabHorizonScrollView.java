package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private LinearLayout.LayoutParams dDi;
    private DeskLinearLayout eNA;
    private CommonTabWidgetView.a eNB;
    private int eNC;
    private int eND;
    private TextView eNE;
    private View eNF;
    private int mCurrentIndex;
    private List<com.baidu.tbadk.editortools.view.a> mDatas;

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        init();
    }

    public CommonTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.eNA = new DeskLinearLayout(getContext());
        this.eNA.setOrientation(0);
        this.eNA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eNA.setBaselineAligned(false);
        addView(this.eNA);
        this.eNC = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.eND = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.eNA.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.dDi = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.eNF = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.eNF.setLayoutParams(layoutParams);
        ap.setBackgroundResource(this.eNF, R.drawable.bg_expression_bar_n);
        this.eNA.addView(this.eNF);
    }

    public void setDatas(List<com.baidu.tbadk.editortools.view.a> list) {
        this.mDatas = list;
    }

    private TbImageView b(a.b bVar) {
        if (bVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        ap.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.eND, this.eNC, this.eND, this.eNC);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ap.setImageResource(tbImageView, bVar.eNz);
        linearLayout.setOnClickListener(new a(this.eNA.getChildCount() - 1));
        this.eNA.addView(linearLayout, this.eNA.getChildCount() - 1, this.dDi);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.eNA.getChildAt(this.mCurrentIndex);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).bsE().eNz);
                } else {
                    return;
                }
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.eNA.getChildAt(this.mCurrentIndex);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ap.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).bsE().eNy);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.eNA.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.eNE != null) {
            ap.setBackgroundResource(this.eNE, R.drawable.icon_news_head_prompt_one, i);
            this.eNE.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.eNA.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.eNA.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            ap.setImageResource(tbImageView, this.mDatas.get(i2).bsE().eNy, i);
                        } else {
                            ap.setImageResource(tbImageView, this.mDatas.get(i2).bsE().eNz, i);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.eNB = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        private final int mTabIndex;

        private a(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.eNB.qo(this.mTabIndex);
        }
    }
}
