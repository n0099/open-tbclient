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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams alc;
    private LinearLayout.LayoutParams ald;
    public ViewPager.OnPageChangeListener alf;
    private LinearLayout alg;
    private ViewPager alh;
    private int ali;
    private float alj;
    private Paint alk;
    private boolean alm;
    private int aln;
    private int alo;
    private int alq;
    private int alr;
    private int alt;
    private int alu;
    private int alv;
    private int aly;
    private int alz;
    private final a cHP;
    private boolean cHQ;
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
        this.cHP = new a(this, null);
        this.currentPosition = 0;
        this.alj = 0.0f;
        this.alm = false;
        this.aln = as.getColor(w.e.cp_cont_b);
        this.alo = as.getColor(w.e.cp_cont_f);
        this.alq = 52;
        this.alr = 4;
        this.dividerPadding = 12;
        this.alt = 24;
        this.alu = 1;
        this.alv = 12;
        this.aly = 0;
        this.alz = w.g.pager_sliding_view;
        this.cHQ = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.alg = new LinearLayout(getContext());
        this.alg.setOrientation(0);
        this.alg.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.alg);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.alq = (int) TypedValue.applyDimension(1, this.alq, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.alt = (int) TypedValue.applyDimension(1, this.alt, displayMetrics);
        this.alu = (int) TypedValue.applyDimension(1, this.alu, displayMetrics);
        this.alv = i;
        this.alr = i2;
        this.alm = z;
        this.alk = new Paint();
        this.alk.setAntiAlias(true);
        this.alk.setStyle(Paint.Style.FILL);
        this.alc = new LinearLayout.LayoutParams(-2, -1);
        this.ald = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.alt = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setTabItemClicked(boolean z) {
        this.cHQ = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.alh = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cHP);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.alf = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.alh != null && this.alh.getAdapter() != null && this.alh.getAdapter().getCount() != 0) {
            this.alg.removeAllViews();
            this.ali = this.alh.getAdapter().getCount();
            for (int i = 0; i < this.ali; i++) {
                i(i, this.alh.getAdapter().getPageTitle(i).toString());
            }
            wy();
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
        view.setPadding(this.alt, 0, this.alt, 0);
        this.alg.addView(view, i, this.alm ? this.ald : this.alc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wy() {
        for (int i = 0; i < this.ali; i++) {
            View childAt = this.alg.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.alz);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.alv);
                    if (i == this.alh.getCurrentItem()) {
                        textView.setTextColor(this.aln);
                    } else {
                        textView.setTextColor(this.alo);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i, int i2) {
        if (this.ali != 0) {
            int left = this.alg.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.alq;
            }
            if (left != this.aly) {
                this.aly = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ali != 0) {
            int height = getHeight();
            this.alk.setColor(this.aln);
            View childAt = this.alg.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.alj > 0.0f && this.currentPosition < this.ali - 1) {
                View childAt2 = this.alg.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.alj)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.alj);
                right = (right * (1.0f - this.alj)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.alj);
            }
            canvas.drawRect(left, height - this.alr, right, height, this.alk);
        }
    }

    public void onChangeSkinType() {
        this.aln = as.getColor(w.e.cp_cont_b);
        this.alo = as.getColor(w.e.cp_cont_f);
        wy();
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
            if (PagerSlidingTabStrip.this.alg.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cHQ) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.alj = f;
                    PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.alg.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.alf != null) {
                    PagerSlidingTabStrip.this.alf.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.alg.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.alh.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.alj = 0.0f;
                    PagerSlidingTabStrip.this.cHQ = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.alf != null) {
                    PagerSlidingTabStrip.this.alf.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.alf != null) {
                PagerSlidingTabStrip.this.alf.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cHQ) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.alj * PagerSlidingTabStrip.this.alg.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.wy();
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
