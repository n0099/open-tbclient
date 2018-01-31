package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int aYC;
    private int aYD;
    private LinearLayout.LayoutParams aYg;
    private LinearLayout.LayoutParams aYh;
    public ViewPager.OnPageChangeListener aYj;
    private LinearLayout aYk;
    private ViewPager aYl;
    private int aYm;
    private float aYn;
    private Paint aYo;
    private boolean aYp;
    private int aYq;
    private int aYr;
    private int aYs;
    private int aYt;
    private int aYz;
    private int baG;
    private int currentPosition;
    private int dividerPadding;
    private int ds20;
    private final a edU;
    private Drawable edV;
    private boolean edW;
    private boolean edX;
    private boolean isLoading;
    private Locale locale;
    private int tabPadding;

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.edU = new a();
        this.currentPosition = 0;
        this.aYn = 0.0f;
        this.aYp = false;
        this.aYq = aj.getColor(d.C0108d.cp_cont_b);
        this.aYr = aj.getColor(d.C0108d.cp_cont_j);
        this.aYs = 52;
        this.aYt = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.baG = 1;
        this.aYz = 17;
        this.aYC = 0;
        this.aYD = d.f.pager_sliding_view;
        this.edX = false;
        this.isLoading = false;
    }

    public void g(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aYk = new LinearLayout(getContext());
        this.aYk.setOrientation(0);
        this.aYk.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aYk);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aYs = (int) TypedValue.applyDimension(1, this.aYs, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.baG = (int) TypedValue.applyDimension(1, this.baG, displayMetrics);
        this.aYz = i;
        this.aYt = i2;
        this.aYp = z;
        this.aYo = new Paint();
        this.aYo.setAntiAlias(true);
        this.aYo.setStyle(Paint.Style.FILL);
        this.edV = aj.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.s(getContext(), d.e.ds20);
        this.aYg = new LinearLayout.LayoutParams(-2, -1);
        this.aYh = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.s(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.edW = z;
        invalidate();
    }

    public boolean aBj() {
        return this.edW;
    }

    public void setTabItemClicked(boolean z) {
        this.edX = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aYl = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.edU);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aYj = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aYl != null && this.aYl.getAdapter() != null && this.aYl.getAdapter().getCount() != 0) {
            this.aYk.removeAllViews();
            this.aYm = this.aYl.getAdapter().getCount();
            for (int i = 0; i < this.aYm; i++) {
                h(i, this.aYl.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aYl.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.currentPosition, 0);
                }
            });
        }
    }

    private void h(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.aYl.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").s("obj_locate", i + 1).aa("obj_type", "1"));
                    PagerSlidingTabStrip.this.edX = true;
                    if (PagerSlidingTabStrip.this.aYl.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.aYl.getAdapter()).oF(i);
                    }
                    PagerSlidingTabStrip.this.aYl.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aYk.addView(view, i, this.aYp ? this.aYh : this.aYg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aYm; i++) {
            View childAt = this.aYk.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aYD);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aYz);
                    if (i == this.aYl.getCurrentItem()) {
                        textView.setTextColor(this.aYq);
                    } else {
                        textView.setTextColor(this.aYr);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aYm != 0) {
            int left = this.aYk.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aYs;
            }
            if (left != this.aYC) {
                this.aYC = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aYm != 0) {
            int height = getHeight();
            this.aYo.setColor(this.aYq);
            View childAt = this.aYk.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aYn > 0.0f && this.currentPosition < this.aYm - 1) {
                View childAt2 = this.aYk.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aYn)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aYn);
                right = (right * (1.0f - this.aYn)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aYn);
            }
            canvas.drawRoundRect(new RectF(left, height - this.aYt, right, height), 10.0f, 10.0f, this.aYo);
            if (this.edW) {
                View childAt3 = this.aYk.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.edV.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.edV.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aYq = aj.getColor(d.C0108d.cp_cont_b);
        this.aYr = aj.getColor(d.C0108d.cp_cont_j);
        this.edV = aj.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aYk.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.edX) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.aYn = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aYk.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aYj != null) {
                    PagerSlidingTabStrip.this.aYj.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aYk.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aYl.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aYn = 0.0f;
                    PagerSlidingTabStrip.this.edX = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aYj != null) {
                    PagerSlidingTabStrip.this.aYj.onPageScrollStateChanged(i);
                }
                HomePageStatic.ebj = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aYj != null) {
                PagerSlidingTabStrip.this.aYj.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.edX) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aYn * PagerSlidingTabStrip.this.aYk.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: z */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oG */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int currentPosition;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }
    }
}
