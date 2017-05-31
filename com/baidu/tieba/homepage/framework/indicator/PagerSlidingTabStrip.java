package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int akA;
    private int akC;
    private int akD;
    private int akF;
    private int akG;
    private int akH;
    private int akK;
    private int akL;
    private LinearLayout.LayoutParams akp;
    private LinearLayout.LayoutParams akq;
    public ViewPager.OnPageChangeListener aks;
    private LinearLayout akt;
    private ViewPager aku;
    private int akv;
    private float akw;
    private Paint akx;
    private boolean aky;
    private int akz;
    private final a cAd;
    private boolean cAe;
    private int currentPosition;
    private int dividerPadding;
    private boolean isLoading;
    private Locale locale;

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cAd = new a(this, null);
        this.currentPosition = 0;
        this.akw = 0.0f;
        this.aky = false;
        this.akz = aq.getColor(w.e.cp_cont_b);
        this.akA = aq.getColor(w.e.cp_cont_f);
        this.akC = 52;
        this.akD = 4;
        this.dividerPadding = 12;
        this.akF = 24;
        this.akG = 1;
        this.akH = 12;
        this.akK = 0;
        this.akL = w.g.pager_sliding_view;
        this.cAe = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.akt = new LinearLayout(getContext());
        this.akt.setOrientation(0);
        this.akt.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.akt);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.akC = (int) TypedValue.applyDimension(1, this.akC, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.akF = (int) TypedValue.applyDimension(1, this.akF, displayMetrics);
        this.akG = (int) TypedValue.applyDimension(1, this.akG, displayMetrics);
        this.akH = i;
        this.akD = i2;
        this.aky = z;
        this.akx = new Paint();
        this.akx.setAntiAlias(true);
        this.akx.setStyle(Paint.Style.FILL);
        this.akp = new LinearLayout.LayoutParams(-2, -1);
        this.akq = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.akF = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setTabItemClicked(boolean z) {
        this.cAe = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aku = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cAd);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aks = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aku != null && this.aku.getAdapter() != null && this.aku.getAdapter().getCount() != 0) {
            this.akt.removeAllViews();
            this.akv = this.aku.getAdapter().getCount();
            for (int i = 0; i < this.akv; i++) {
                i(i, this.aku.getAdapter().getPageTitle(i).toString());
            }
            wg();
            getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
        }
    }

    private void i(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        a(i, textView);
    }

    private void a(int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new f(this, i));
        view.setPadding(this.akF, 0, this.akF, 0);
        this.akt.addView(view, i, this.aky ? this.akq : this.akp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg() {
        for (int i = 0; i < this.akv; i++) {
            View childAt = this.akt.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.akL);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.akH);
                    if (i == this.aku.getCurrentItem()) {
                        textView.setTextColor(this.akz);
                    } else {
                        textView.setTextColor(this.akA);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i, int i2) {
        if (this.akv != 0) {
            int left = this.akt.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.akC;
            }
            if (left != this.akK) {
                this.akK = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.akv != 0) {
            int height = getHeight();
            this.akx.setColor(this.akz);
            View childAt = this.akt.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.akw > 0.0f && this.currentPosition < this.akv - 1) {
                View childAt2 = this.akt.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.akw)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.akw);
                right = (right * (1.0f - this.akw)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.akw);
            }
            canvas.drawRect(left, height - this.akD, right, height, this.akx);
        }
    }

    public void onChangeSkinType() {
        this.akz = aq.getColor(w.e.cp_cont_b);
        this.akA = aq.getColor(w.e.cp_cont_f);
        wg();
        invalidate();
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        /* synthetic */ a(PagerSlidingTabStrip pagerSlidingTabStrip, a aVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.akt.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cAe) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.akw = f;
                    PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.akt.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aks != null) {
                    PagerSlidingTabStrip.this.aks.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.akt.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.aku.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.akw = 0.0f;
                    PagerSlidingTabStrip.this.cAe = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aks != null) {
                    PagerSlidingTabStrip.this.aks.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aks != null) {
                PagerSlidingTabStrip.this.aks.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cAe) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.akw * PagerSlidingTabStrip.this.akt.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.wg();
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

    /* loaded from: classes.dex */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new g();
        int currentPosition;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ SavedState(Parcel parcel, SavedState savedState) {
            this(parcel);
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
