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
    private LinearLayout.LayoutParams bOG;
    private LinearLayout.LayoutParams bOH;
    public ViewPager.OnPageChangeListener bOJ;
    private LinearLayout bOK;
    private ViewPager bOL;
    private int bOM;
    private Paint bOO;
    private boolean bOP;
    private int bOQ;
    private int bOR;
    private int bPc;
    private int bPd;
    private int bRh;
    private final b cDR;
    private float cDS;
    private int cDT;
    private int cDU;
    private Paint cDV;
    private RectF cDW;
    private boolean cDX;
    private int cDY;
    private int cDZ;
    private int cEa;
    private int cEb;
    private int cEc;
    private int cEd;
    private int cEe;
    private int cEf;
    private float cEg;
    private float cEh;
    private int cEi;
    private int cEj;
    private int cEk;
    private boolean cEl;
    private a cEm;
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
        this.cDR = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cDS = 0.0f;
        this.cDT = 0;
        this.cDU = 0;
        this.bOP = false;
        this.bOQ = al.getColor(d.C0277d.cp_cont_b);
        this.bOR = al.getColor(d.C0277d.cp_cont_j);
        this.cDZ = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.bRh = 1;
        this.cEd = 17;
        this.cEe = 17;
        this.bPc = 0;
        this.bPd = d.f.pager_sliding_view;
        this.cEl = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bOK = new LinearLayout(getContext());
        this.bOK.setOrientation(0);
        this.bOK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bOK);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cDZ = (int) TypedValue.applyDimension(1, this.cDZ, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.bRh = (int) TypedValue.applyDimension(1, this.bRh, displayMetrics);
        this.cEd = i;
        this.cEe = i2;
        this.cEf = l.h(getContext(), d.e.tbds74);
        this.cEg = (this.cEe * 1.0f) / this.cEd;
        this.cEh = (this.cEf * 1.0f) / this.cEd;
        this.mIndicatorHeight = i3;
        this.bOP = z;
        this.bOO = new Paint();
        this.bOO.setAntiAlias(true);
        this.bOO.setStyle(Paint.Style.FILL);
        this.bOO.setColor(al.getColor(d.C0277d.cp_other_e));
        this.cDV = new Paint();
        this.cDV.setAntiAlias(true);
        this.cDV.setStyle(Paint.Style.FILL);
        this.cDV.setColor(al.getColor(d.C0277d.cp_cont_h));
        this.cDW = new RectF();
        this.cEi = l.h(getContext(), d.e.tbds20);
        this.cEj = l.h(getContext(), d.e.tbds28);
        this.cEk = l.h(getContext(), d.e.tbds22);
        this.bOG = new LinearLayout.LayoutParams(-2, -1);
        this.bOH = new LinearLayout.LayoutParams(l.h(getContext(), d.e.tbds200), -1);
        this.cEb = l.h(getContext(), d.e.tbds22);
        this.cEa = l.h(getContext(), d.e.tbds20);
        this.cEc = l.h(getContext(), d.e.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cDX = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.cEl = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bOL = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cDR);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOJ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bOL != null && this.bOL.getAdapter() != null && this.bOL.getAdapter().getCount() != 0) {
            this.bOK.removeAllViews();
            this.bOM = this.bOL.getAdapter().getCount();
            for (int i = 0; i < this.bOM; i++) {
                A(i, this.bOL.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.bOL.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.cDT = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.cEd);
        textView.setSingleLine();
        e(i, textView);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.cEm != null) {
                        PagerSlidingTabBaseStrip.this.cEm.r(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.bOL.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.cEl = true;
                        PagerSlidingTabBaseStrip.this.bOL.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                }
            }
        });
        this.bOK.addView(view, i, this.bOP ? this.bOH : this.bOG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOM != 0) {
            int left = this.bOK.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cDZ;
            }
            if (left != this.bPc) {
                this.bPc = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOM != 0) {
            View childAt = this.bOK.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cEb;
            float right2 = childAt.getRight() - this.cEb;
            if (this.cDS > 0.0f && this.mCurrentTabIndex != this.cDT && this.cDT <= this.bOM - 1 && this.cDT >= 0) {
                View childAt2 = this.bOK.getChildAt(this.cDT);
                left = d(left, childAt2.getLeft() + this.cEb, this.cDS);
                right2 = e(right2, childAt2.getRight() - this.cEb, this.cDS);
            }
            int height = getHeight();
            if (this.sz == null) {
                this.sz = new RectF(left, (height - this.mIndicatorHeight) - this.cEa, right2, height - this.cEa);
            } else {
                this.sz.set(left, (height - this.mIndicatorHeight) - this.cEa, right2, height - this.cEa);
            }
            canvas.drawRoundRect(this.sz, 16.0f, 16.0f, this.bOO);
            if (this.cDX) {
                View childAt3 = this.bOK.getChildAt(this.cDY);
                this.cDW.set((childAt3.getRight() - this.cEk) - this.cEi, childAt3.getTop() + this.cEj, right + this.cEi, top + this.cEi);
                canvas.drawOval(this.cDW, this.cDV);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cEc + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cEc + f2) - ((this.cEc * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.cEc) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cEc) + ((this.cEc * (0.15f - f3)) / 0.15f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.bOQ = al.getColor(d.C0277d.cp_cont_b);
            this.bOR = al.getColor(d.C0277d.cp_cont_j);
            this.bOO.setColor(al.getColor(d.C0277d.cp_other_e));
            this.cDV.setColor(al.getColor(d.C0277d.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float ar(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cEh - 1.0f) / (0.1f - 1.0f))) + this.cEh;
        }
        return (((this.cEh - this.cEg) / 0.1f) * f) + this.cEg;
    }

    private float as(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cEh) / (0.1f - 0.9f)));
        }
        return (((this.cEh - this.cEg) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cEh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float as;
        float f = this.cDS;
        float f2 = this.cDT < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.bOM) {
            View childAt = this.bOK.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPd);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        as = ar(f2);
                    } else {
                        as = i == this.cDT ? as(f2) : 1.0f;
                    }
                    textView.setScaleX(as);
                    textView.setScaleY(as);
                    if (as <= 1.0f) {
                        textView.setTextColor(this.bOR);
                    } else {
                        textView.setTextColor(this.bOQ);
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
            if (PagerSlidingTabBaseStrip.this.bOK.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.cEl) {
                    if (i == PagerSlidingTabBaseStrip.this.cDU) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cDT = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.cDU) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cDT = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.cDT = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.cDU = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cDT = i;
                    }
                    PagerSlidingTabBaseStrip.this.cDS = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.bOK.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.bOJ != null) {
                    PagerSlidingTabBaseStrip.this.bOJ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.bOK.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.bOL.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.cDS = 0.0f;
                    PagerSlidingTabBaseStrip.this.cEl = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.cDU = PagerSlidingTabBaseStrip.this.bOL.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.cDU;
                    PagerSlidingTabBaseStrip.this.cDT = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.bOJ != null) {
                    PagerSlidingTabBaseStrip.this.bOJ.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.bOJ != null) {
                PagerSlidingTabBaseStrip.this.bOJ.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.cEl) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.cDS * PagerSlidingTabBaseStrip.this.bOK.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.cDU = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.cDT = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Us;
        this.cDT = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Us = this.mCurrentTabIndex;
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
        int Us;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Us = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Us);
        }
    }

    public void setConcernTabIndex(int i) {
        this.cDY = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cEm = aVar;
    }
}
