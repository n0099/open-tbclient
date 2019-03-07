package com.baidu.tbadk.widget.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.Locale;
/* loaded from: classes3.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams bOF;
    private LinearLayout.LayoutParams bOG;
    public ViewPager.OnPageChangeListener bOI;
    private LinearLayout bOJ;
    private ViewPager bOK;
    private int bOL;
    private Paint bON;
    private boolean bOO;
    private int bOP;
    private int bOQ;
    private int bPb;
    private int bPc;
    private int bRg;
    private final b cDU;
    private float cDV;
    private int cDW;
    private int cDX;
    private Paint cDY;
    private RectF cDZ;
    private boolean cEa;
    private int cEb;
    private int cEc;
    private int cEd;
    private int cEe;
    private int cEf;
    private int cEg;
    private int cEh;
    private int cEi;
    private float cEj;
    private float cEk;
    private int cEl;
    private int cEm;
    private int cEn;
    private boolean cEo;
    private a cEp;
    private int dividerPadding;
    private boolean isLoading;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;
    private RectF sz;

    /* loaded from: classes3.dex */
    public interface a {
        void r(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cDU = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cDV = 0.0f;
        this.cDW = 0;
        this.cDX = 0;
        this.bOO = false;
        this.bOP = al.getColor(d.C0236d.cp_cont_b);
        this.bOQ = al.getColor(d.C0236d.cp_cont_j);
        this.cEc = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.bRg = 1;
        this.cEg = 17;
        this.cEh = 17;
        this.bPb = 0;
        this.bPc = d.f.pager_sliding_view;
        this.cEo = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bOJ = new LinearLayout(getContext());
        this.bOJ.setOrientation(0);
        this.bOJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bOJ);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cEc = (int) TypedValue.applyDimension(1, this.cEc, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.bRg = (int) TypedValue.applyDimension(1, this.bRg, displayMetrics);
        this.cEg = i;
        this.cEh = i2;
        this.cEi = l.h(getContext(), d.e.tbds74);
        this.cEj = (this.cEh * 1.0f) / this.cEg;
        this.cEk = (this.cEi * 1.0f) / this.cEg;
        this.mIndicatorHeight = i3;
        this.bOO = z;
        this.bON = new Paint();
        this.bON.setAntiAlias(true);
        this.bON.setStyle(Paint.Style.FILL);
        this.bON.setColor(al.getColor(d.C0236d.cp_other_e));
        this.cDY = new Paint();
        this.cDY.setAntiAlias(true);
        this.cDY.setStyle(Paint.Style.FILL);
        this.cDY.setColor(al.getColor(d.C0236d.cp_cont_h));
        this.cDZ = new RectF();
        this.cEl = l.h(getContext(), d.e.tbds20);
        this.cEm = l.h(getContext(), d.e.tbds28);
        this.cEn = l.h(getContext(), d.e.tbds22);
        this.bOF = new LinearLayout.LayoutParams(-2, -1);
        this.bOG = new LinearLayout.LayoutParams(l.h(getContext(), d.e.tbds200), -1);
        this.cEe = l.h(getContext(), d.e.tbds22);
        this.cEd = l.h(getContext(), d.e.tbds20);
        this.cEf = l.h(getContext(), d.e.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cEa = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.cEo = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bOK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cDU);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bOK != null && this.bOK.getAdapter() != null && this.bOK.getAdapter().getCount() != 0) {
            this.bOJ.removeAllViews();
            this.bOL = this.bOK.getAdapter().getCount();
            for (int i = 0; i < this.bOL; i++) {
                A(i, this.bOK.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.bOK.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.cDW = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void A(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.cEg);
        textView.setSingleLine();
        e(i, textView);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.cEp != null) {
                        PagerSlidingTabBaseStrip.this.cEp.r(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.bOK.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.cEo = true;
                        PagerSlidingTabBaseStrip.this.bOK.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                }
            }
        });
        this.bOJ.addView(view, i, this.bOO ? this.bOG : this.bOF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOL != 0) {
            int left = this.bOJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cEc;
            }
            if (left != this.bPb) {
                this.bPb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOL != 0) {
            View childAt = this.bOJ.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cEe;
            float right2 = childAt.getRight() - this.cEe;
            if (this.cDV > 0.0f && this.mCurrentTabIndex != this.cDW && this.cDW <= this.bOL - 1 && this.cDW >= 0) {
                View childAt2 = this.bOJ.getChildAt(this.cDW);
                left = d(left, childAt2.getLeft() + this.cEe, this.cDV);
                right2 = e(right2, childAt2.getRight() - this.cEe, this.cDV);
            }
            int height = getHeight();
            if (this.sz == null) {
                this.sz = new RectF(left, (height - this.mIndicatorHeight) - this.cEd, right2, height - this.cEd);
            } else {
                this.sz.set(left, (height - this.mIndicatorHeight) - this.cEd, right2, height - this.cEd);
            }
            canvas.drawRoundRect(this.sz, 16.0f, 16.0f, this.bON);
            if (this.cEa) {
                View childAt3 = this.bOJ.getChildAt(this.cEb);
                this.cDZ.set((childAt3.getRight() - this.cEn) - this.cEl, childAt3.getTop() + this.cEm, right + this.cEl, top + this.cEl);
                canvas.drawOval(this.cDZ, this.cDY);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cEf + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cEf + f2) - ((this.cEf * (f3 - 0.85f)) / 0.15f);
        } else {
            return f;
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 > f) {
            if (f3 <= 0.5d) {
                return f + (((f2 - f) * f3) / 0.5f);
            }
            return f2;
        } else if (f3 >= 0.5d) {
            return f;
        } else {
            if (f3 >= 0.15d) {
                return f - ((((f - this.cEf) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cEf) + ((this.cEf * (0.15f - f3)) / 0.15f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.bOP = al.getColor(d.C0236d.cp_cont_b);
            this.bOQ = al.getColor(d.C0236d.cp_cont_j);
            this.bON.setColor(al.getColor(d.C0236d.cp_other_e));
            this.cDY.setColor(al.getColor(d.C0236d.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float ar(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cEk - 1.0f) / (0.1f - 1.0f))) + this.cEk;
        }
        return (((this.cEk - this.cEj) / 0.1f) * f) + this.cEj;
    }

    private float as(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cEk) / (0.1f - 0.9f)));
        }
        return (((this.cEk - this.cEj) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cEk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float as;
        float f = this.cDV;
        float f2 = this.cDW < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.bOL) {
            View childAt = this.bOJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        as = ar(f2);
                    } else {
                        as = i == this.cDW ? as(f2) : 1.0f;
                    }
                    textView.setScaleX(as);
                    textView.setScaleY(as);
                    if (as <= 1.0f) {
                        textView.setTextColor(this.bOQ);
                    } else {
                        textView.setTextColor(this.bOP);
                    }
                    if (as <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.bOJ.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.cEo) {
                    if (i == PagerSlidingTabBaseStrip.this.cDX) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cDW = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.cDX) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cDW = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.cDW = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.cDX = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cDW = i;
                    }
                    PagerSlidingTabBaseStrip.this.cDV = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.bOJ.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.bOI != null) {
                    PagerSlidingTabBaseStrip.this.bOI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.bOJ.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.bOK.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.cDV = 0.0f;
                    PagerSlidingTabBaseStrip.this.cEo = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.cDX = PagerSlidingTabBaseStrip.this.bOK.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.cDX;
                    PagerSlidingTabBaseStrip.this.cDW = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.bOI != null) {
                    PagerSlidingTabBaseStrip.this.bOI.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.bOI != null) {
                PagerSlidingTabBaseStrip.this.bOI.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.cEo) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.cDV * PagerSlidingTabBaseStrip.this.bOJ.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.cDX = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.cDW = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ur;
        this.cDW = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ur = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: B */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kP */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ur;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ur = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ur);
        }
    }

    public void setConcernTabIndex(int i) {
        this.cEb = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cEp = aVar;
    }
}
