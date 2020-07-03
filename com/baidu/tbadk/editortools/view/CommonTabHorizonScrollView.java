package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private LinearLayout.LayoutParams dnm;
    private DeskLinearLayout ewI;
    private CommonTabWidgetView.a ewJ;
    private int ewK;
    private int ewL;
    private TextView ewM;
    private View ewN;
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
        this.ewI = new DeskLinearLayout(getContext());
        this.ewI.setOrientation(0);
        this.ewI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ewI.setBaselineAligned(false);
        addView(this.ewI);
        this.ewK = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.ewL = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.ewI.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.dnm = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.ewN = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.ewN.setLayoutParams(layoutParams);
        an.setBackgroundResource(this.ewN, R.drawable.bg_expression_bar_n);
        this.ewI.addView(this.ewN);
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
        an.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.ewL, this.ewK, this.ewL, this.ewK);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        an.setImageResource(tbImageView, bVar.ewH);
        linearLayout.setOnClickListener(new a(this.ewI.getChildCount() - 1));
        this.ewI.addView(linearLayout, this.ewI.getChildCount() - 1, this.dnm);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.ewI.getChildAt(this.mCurrentIndex);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).bgh().ewH);
                } else {
                    return;
                }
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.ewI.getChildAt(this.mCurrentIndex);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                an.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).bgh().ewG);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.ewI.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.ewM != null) {
            an.setBackgroundResource(this.ewM, R.drawable.icon_news_head_prompt_one);
            this.ewM.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.ewI.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.ewI.getChildAt(i2);
            if (childAt != null) {
                an.setBackgroundResource(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            an.setImageResource(tbImageView, this.mDatas.get(i2).bgh().ewG);
                        } else {
                            an.setImageResource(tbImageView, this.mDatas.get(i2).bgh().ewH);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.ewJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private final int mTabIndex;

        private a(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CommonTabHorizonScrollView.this.ewJ.nL(this.mTabIndex);
        }
    }
}
