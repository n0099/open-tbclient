package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollHorizontalTabView extends com.baidu.tbadk.widget.horizonalScrollListView.b {
    private final a dOj;
    private b dOk;
    private float mCurrentPositionOffset;
    private int mCurrentTabIndex;
    private final int mIndicatorHeight;
    private final int mIndicatorWidth;
    private boolean mIsClicked;
    private int mLastScrollX;
    private View.OnClickListener mOnItemClickListener;
    private ViewPager mPager;
    private Paint mRectPaint;
    private int mScrollOffset;
    private int mSelectorColor;
    private final List<f> mTabDataList;
    private final List<TextView> mTabItemView;
    private LinearLayout mTabsContainer;

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(int i, f fVar);

        void b(int i, f fVar);
    }

    public ScrollHorizontalTabView(Context context) {
        super(context);
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = l.t(TbadkCoreApplication.getInst(), d.e.tbds4);
        this.mIndicatorWidth = l.t(TbadkCoreApplication.getInst(), d.e.tbds84);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = aj.getColor(d.C0141d.cp_cont_f);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.dOj = new a();
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = ScrollHorizontalTabView.this.mTabItemView.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        i = 0;
                        break;
                    } else if (view == ScrollHorizontalTabView.this.mTabItemView.get(i)) {
                        break;
                    } else {
                        i++;
                    }
                }
                ScrollHorizontalTabView.this.mIsClicked = true;
                if (ScrollHorizontalTabView.this.mPager != null) {
                    ScrollHorizontalTabView.this.mPager.setCurrentItem(i);
                }
            }
        };
        init();
    }

    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = l.t(TbadkCoreApplication.getInst(), d.e.tbds4);
        this.mIndicatorWidth = l.t(TbadkCoreApplication.getInst(), d.e.tbds84);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = aj.getColor(d.C0141d.cp_cont_f);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.dOj = new a();
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = ScrollHorizontalTabView.this.mTabItemView.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        i = 0;
                        break;
                    } else if (view == ScrollHorizontalTabView.this.mTabItemView.get(i)) {
                        break;
                    } else {
                        i++;
                    }
                }
                ScrollHorizontalTabView.this.mIsClicked = true;
                if (ScrollHorizontalTabView.this.mPager != null) {
                    ScrollHorizontalTabView.this.mPager.setCurrentItem(i);
                }
            }
        };
        init();
    }

    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabDataList = new ArrayList();
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = l.t(TbadkCoreApplication.getInst(), d.e.tbds4);
        this.mIndicatorWidth = l.t(TbadkCoreApplication.getInst(), d.e.tbds84);
        this.mIsClicked = false;
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = aj.getColor(d.C0141d.cp_cont_f);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        this.mLastScrollX = 0;
        this.dOj = new a();
        this.mOnItemClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int size = ScrollHorizontalTabView.this.mTabItemView.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        i2 = 0;
                        break;
                    } else if (view == ScrollHorizontalTabView.this.mTabItemView.get(i2)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                ScrollHorizontalTabView.this.mIsClicked = true;
                if (ScrollHorizontalTabView.this.mPager != null) {
                    ScrollHorizontalTabView.this.mPager.setCurrentItem(i2);
                }
            }
        };
        init();
    }

    private void init() {
        setHorizontalScrollBarEnabled(false);
        this.mTabsContainer = new LinearLayout(getContext());
        this.mTabsContainer.setGravity(16);
        this.mTabsContainer.setOrientation(0);
        this.mTabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.mTabsContainer);
        this.mRectPaint = new Paint();
        this.mRectPaint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
        this.mScrollOffset = (int) TypedValue.applyDimension(1, this.mScrollOffset, getResources().getDisplayMetrics());
    }

    public void setData(List<f> list) {
        this.mTabDataList.clear();
        if (!v.E(list)) {
            this.mTabDataList.addAll(list);
        }
        setupTabItems();
        fillTabData();
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ScrollHorizontalTabView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ScrollHorizontalTabView.this.mCurrentTabIndex = ScrollHorizontalTabView.this.mPager.getCurrentItem();
                ScrollHorizontalTabView.this.scrollToChild(ScrollHorizontalTabView.this.mCurrentTabIndex, 0);
            }
        });
    }

    private void setupTabItems() {
        int size = this.mTabDataList.size();
        int size2 = this.mTabItemView.size();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds4);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(d.e.ds32);
        if (size > size2) {
            while (size2 < size) {
                TextView textView = new TextView(getContext());
                textView.setOnClickListener(this.mOnItemClickListener);
                textView.setTextSize(0, getContext().getResources().getDimensionPixelSize(d.e.tbfontsize42));
                textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
                textView.setGravity(17);
                this.mTabItemView.add(textView);
                size2++;
            }
        } else if (size < size2) {
            for (int i = size2 - 1; i >= size; i--) {
                this.mTabItemView.remove(i);
            }
        }
        this.mTabsContainer.removeAllViews();
        int size3 = this.mTabItemView.size();
        for (int i2 = 0; i2 < size3; i2++) {
            this.mTabsContainer.addView(this.mTabItemView.get(i2));
        }
    }

    private void fillTabData() {
        int size = this.mTabDataList.size();
        int size2 = this.mTabItemView.size();
        for (int i = 0; i < size && i < size2; i++) {
            f fVar = this.mTabDataList.get(i);
            TextView textView = this.mTabItemView.get(i);
            if (fVar != null && textView != null) {
                textView.setText(fVar.tabName);
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.mPager = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dOj);
        }
    }

    public void setScrollTabPageListener(b bVar) {
        this.dOk = bVar;
    }

    public int getCurrentIndex() {
        return this.mCurrentTabIndex;
    }

    public void setCurrentIndex(int i) {
        setCurrentIndex(i, true);
    }

    public void setCurrentIndex(int i, boolean z) {
        if (z) {
            int[] iArr = new int[2];
            ((View) v.f(this.mTabItemView, i)).getLocationOnScreen(iArr);
            int ao = l.ao(getContext()) - iArr[0];
            final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds160);
            if (iArr[0] < 0) {
                post(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ScrollHorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                    }
                });
            } else if (ao < dimensionPixelSize) {
                post(new Runnable() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ScrollHorizontalTabView.this.scrollBy(ScrollHorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.e.ds160), 0);
                    }
                });
            }
        }
        if (this.mPager != null) {
            this.mPager.setCurrentItem(i);
        }
        updateTabStyles();
    }

    private void setTabStatus(TextView textView, boolean z) {
        if (textView != null) {
            if (z) {
                aj.r(textView, d.C0141d.cp_cont_b);
            } else {
                aj.r(textView, d.C0141d.cp_cont_j);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && !this.mTabItemView.isEmpty()) {
            int height = getHeight();
            this.mRectPaint.setColor(this.mSelectorColor);
            View childAt = this.mTabsContainer.getChildAt(this.mCurrentTabIndex);
            float paddingLeft = childAt.getPaddingLeft() + this.mTabsContainer.getLeft() + childAt.getLeft() + ((((childAt.getWidth() - childAt.getPaddingLeft()) - childAt.getPaddingRight()) - this.mIndicatorWidth) / 2);
            float f = paddingLeft + this.mIndicatorWidth;
            if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.mTabsContainer.getChildCount() - 1) {
                View childAt2 = this.mTabsContainer.getChildAt(this.mCurrentTabIndex + 1);
                float paddingLeft2 = childAt2.getPaddingLeft() + childAt2.getLeft() + this.mTabsContainer.getLeft() + ((((childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft()) - this.mIndicatorWidth) / 2);
                paddingLeft = (paddingLeft * (1.0f - this.mCurrentPositionOffset)) + (paddingLeft2 * this.mCurrentPositionOffset);
                f = (f * (1.0f - this.mCurrentPositionOffset)) + (this.mCurrentPositionOffset * (this.mIndicatorWidth + paddingLeft2));
            }
            canvas.drawRect(paddingLeft, height - this.mIndicatorHeight, f, height, this.mRectPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        int size = this.mTabItemView.size();
        for (int i = 0; i < size; i++) {
            TextView textView = this.mTabItemView.get(i);
            if (textView instanceof TextView) {
                TextView textView2 = textView;
                if (i == this.mCurrentTabIndex) {
                    setTabStatus(textView2, true);
                } else {
                    setTabStatus(textView2, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (!this.mTabItemView.isEmpty()) {
            int left = this.mTabItemView.get(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.mScrollOffset;
            }
            if (left != this.mLastScrollX) {
                this.mLastScrollX = left;
                scrollTo(left, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int mLastPosition;

        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (ScrollHorizontalTabView.this.mTabsContainer.getChildCount() != 0 && !ScrollHorizontalTabView.this.mIsClicked) {
                if (ScrollHorizontalTabView.this.mCurrentTabIndex != i) {
                    this.mLastPosition = ScrollHorizontalTabView.this.mCurrentTabIndex;
                }
                ScrollHorizontalTabView.this.mCurrentTabIndex = i;
                ScrollHorizontalTabView.this.mCurrentPositionOffset = f;
                ScrollHorizontalTabView.this.scrollToChild(i, (int) (ScrollHorizontalTabView.this.mTabsContainer.getChildAt(i).getWidth() * f));
                ScrollHorizontalTabView.this.updateTabStyles();
                ScrollHorizontalTabView.this.invalidate();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (ScrollHorizontalTabView.this.mTabsContainer.getChildCount() != 0 && ScrollHorizontalTabView.this.mPager != null && i == 0) {
                ScrollHorizontalTabView.this.mCurrentPositionOffset = 0.0f;
                ScrollHorizontalTabView.this.mIsClicked = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            f fVar = (f) v.f(ScrollHorizontalTabView.this.mTabDataList, i);
            if (ScrollHorizontalTabView.this.dOk == null || ScrollHorizontalTabView.this.dOk.a(i, fVar)) {
                if (ScrollHorizontalTabView.this.dOk != null) {
                    ScrollHorizontalTabView.this.dOk.b(i, fVar);
                }
                if (ScrollHorizontalTabView.this.mIsClicked) {
                    if (ScrollHorizontalTabView.this.mCurrentTabIndex != i) {
                        this.mLastPosition = ScrollHorizontalTabView.this.mCurrentTabIndex;
                    }
                    ScrollHorizontalTabView.this.mCurrentTabIndex = i;
                    ScrollHorizontalTabView.this.scrollToChild(i, (int) (ScrollHorizontalTabView.this.mCurrentPositionOffset * ScrollHorizontalTabView.this.mTabsContainer.getChildAt(i).getWidth()));
                    ScrollHorizontalTabView.this.updateTabStyles();
                    ScrollHorizontalTabView.this.invalidate();
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.mSelectorColor = aj.getColor(d.C0141d.cp_cont_f);
        updateTabStyles();
    }
}
