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
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private LinearLayout.LayoutParams efB;
    private DeskLinearLayout fqT;
    private CommonTabWidgetView.a fqU;
    private int fqV;
    private int fqW;
    private TextView fqX;
    private View fqY;
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
        this.fqT = new DeskLinearLayout(getContext());
        this.fqT.setOrientation(0);
        this.fqT.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fqT.setBaselineAligned(false);
        addView(this.fqT);
        this.fqV = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.fqW = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.fqT.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.efB = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.fqY = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.fqY.setLayoutParams(layoutParams);
        ap.setBackgroundResource(this.fqY, R.drawable.bg_expression_bar_n);
        this.fqT.addView(this.fqY);
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
        tbImageView.setPadding(this.fqW, this.fqV, this.fqW, this.fqV);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ap.setImageResource(tbImageView, bVar.fqS);
        linearLayout.setOnClickListener(new a(this.fqT.getChildCount() - 1));
        this.fqT.addView(linearLayout, this.fqT.getChildCount() - 1, this.efB);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.fqT.getChildAt(this.mCurrentIndex);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).bAL().fqS);
                } else {
                    return;
                }
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.fqT.getChildAt(this.mCurrentIndex);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                ap.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).bAL().fqR);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.fqT.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.fqX != null) {
            ap.setBackgroundResource(this.fqX, R.drawable.icon_news_head_prompt_one, i);
            this.fqX.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.fqT.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.fqT.getChildAt(i2);
            if (childAt != null) {
                ap.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            ap.setImageResource(tbImageView, this.mDatas.get(i2).bAL().fqR, i);
                        } else {
                            ap.setImageResource(tbImageView, this.mDatas.get(i2).bAL().fqS, i);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.fqU = aVar;
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
            CommonTabHorizonScrollView.this.fqU.ry(this.mTabIndex);
        }
    }
}
