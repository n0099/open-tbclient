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
    private LinearLayout.LayoutParams akA;
    public ViewPager.OnPageChangeListener akC;
    private LinearLayout akD;
    private ViewPager akE;
    private int akF;
    private float akG;
    private Paint akH;
    private boolean akI;
    private int akJ;
    private int akK;
    private int akM;
    private int akN;
    private int akP;
    private int akQ;
    private int akR;
    private int akU;
    private int akV;
    private LinearLayout.LayoutParams akz;
    private final a ctL;
    private boolean ctM;
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
        this.ctL = new a(this, null);
        this.currentPosition = 0;
        this.akG = 0.0f;
        this.akI = false;
        this.akJ = aq.getColor(w.e.cp_cont_b);
        this.akK = aq.getColor(w.e.cp_cont_f);
        this.akM = 52;
        this.akN = 4;
        this.dividerPadding = 12;
        this.akP = 24;
        this.akQ = 1;
        this.akR = 12;
        this.akU = 0;
        this.akV = w.g.pager_sliding_view;
        this.ctM = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.akD = new LinearLayout(getContext());
        this.akD.setOrientation(0);
        this.akD.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.akD);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.akM = (int) TypedValue.applyDimension(1, this.akM, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.akP = (int) TypedValue.applyDimension(1, this.akP, displayMetrics);
        this.akQ = (int) TypedValue.applyDimension(1, this.akQ, displayMetrics);
        this.akR = i;
        this.akN = i2;
        this.akI = z;
        this.akH = new Paint();
        this.akH.setAntiAlias(true);
        this.akH.setStyle(Paint.Style.FILL);
        this.akz = new LinearLayout.LayoutParams(-2, -1);
        this.akA = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.akP = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds40);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setTabItemClicked(boolean z) {
        this.ctM = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.akE = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ctL);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.akC = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.akE != null && this.akE.getAdapter() != null && this.akE.getAdapter().getCount() != 0) {
            this.akD.removeAllViews();
            this.akF = this.akE.getAdapter().getCount();
            for (int i = 0; i < this.akF; i++) {
                i(i, this.akE.getAdapter().getPageTitle(i).toString());
            }
            wj();
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
        view.setPadding(this.akP, 0, this.akP, 0);
        this.akD.addView(view, i, this.akI ? this.akA : this.akz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj() {
        for (int i = 0; i < this.akF; i++) {
            View childAt = this.akD.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.akV);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.akR);
                    if (i == this.akE.getCurrentItem()) {
                        textView.setTextColor(this.akJ);
                    } else {
                        textView.setTextColor(this.akK);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i, int i2) {
        if (this.akF != 0) {
            int left = this.akD.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.akM;
            }
            if (left != this.akU) {
                this.akU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.akF != 0) {
            int height = getHeight();
            this.akH.setColor(this.akJ);
            View childAt = this.akD.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.akG > 0.0f && this.currentPosition < this.akF - 1) {
                View childAt2 = this.akD.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.akG)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.akG);
                right = (right * (1.0f - this.akG)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.akG);
            }
            canvas.drawRect(left, height - this.akN, right, height, this.akH);
        }
    }

    public void onChangeSkinType() {
        this.akJ = aq.getColor(w.e.cp_cont_b);
        this.akK = aq.getColor(w.e.cp_cont_f);
        wj();
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
            if (PagerSlidingTabStrip.this.akD.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.ctM) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.akG = f;
                    PagerSlidingTabStrip.this.E(i, (int) (PagerSlidingTabStrip.this.akD.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.akC != null) {
                    PagerSlidingTabStrip.this.akC.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.akD.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.E(PagerSlidingTabStrip.this.akE.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.akG = 0.0f;
                    PagerSlidingTabStrip.this.ctM = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.akC != null) {
                    PagerSlidingTabStrip.this.akC.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.akC != null) {
                PagerSlidingTabStrip.this.akC.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.ctM) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.E(i, (int) (PagerSlidingTabStrip.this.akG * PagerSlidingTabStrip.this.akD.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.wj();
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
