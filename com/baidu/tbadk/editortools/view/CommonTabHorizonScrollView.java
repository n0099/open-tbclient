package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.editortools.view.a;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    private LinearLayout.LayoutParams cyl;
    private View dzA;
    private DeskLinearLayout dzv;
    private CommonTabWidgetView.a dzw;
    private int dzx;
    private int dzy;
    private TextView dzz;
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
        this.dzv = new DeskLinearLayout(getContext());
        this.dzv.setOrientation(0);
        this.dzv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dzv.setBaselineAligned(false);
        addView(this.dzv);
        this.dzx = getResources().getDimensionPixelSize(R.dimen.ds8);
        this.dzy = getResources().getDimensionPixelSize(R.dimen.ds10);
        this.dzv.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
        this.cyl = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
        this.dzA = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.dzA.setLayoutParams(layoutParams);
        am.setBackgroundResource(this.dzA, R.drawable.bg_expression_bar_n);
        this.dzv.addView(this.dzA);
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
        am.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
        tbImageView.setPadding(this.dzy, this.dzx, this.dzy, this.dzx);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        am.setImageResource(tbImageView, bVar.dzu);
        linearLayout.setOnClickListener(new a(this.dzv.getChildCount() - 1));
        this.dzv.addView(linearLayout, this.dzv.getChildCount() - 1, this.cyl);
        return tbImageView;
    }

    public void c(a.b bVar) {
        b(bVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.dzv.getChildAt(this.mCurrentIndex);
                if (linearLayout != null) {
                    linearLayout.setSelected(false);
                    ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).aPy().dzu);
                } else {
                    return;
                }
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.dzv.getChildAt(this.mCurrentIndex);
            if (linearLayout2 != null) {
                linearLayout2.setSelected(true);
                am.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).aPy().dzt);
            }
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.dzv.removeAllViews();
    }

    public void onChangeSkin(int i) {
        if (this.dzz != null) {
            am.setBackgroundResource(this.dzz, R.drawable.icon_news_head_prompt_one);
            this.dzz.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.dzv.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.dzv.getChildAt(i2);
            if (childAt != null) {
                am.setBackgroundResource(childAt, R.drawable.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            am.setImageResource(tbImageView, this.mDatas.get(i2).aPy().dzt);
                        } else {
                            am.setImageResource(tbImageView, this.mDatas.get(i2).aPy().dzu);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.a aVar) {
        this.dzw = aVar;
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
            CommonTabHorizonScrollView.this.dzw.mA(this.mTabIndex);
        }
    }
}
