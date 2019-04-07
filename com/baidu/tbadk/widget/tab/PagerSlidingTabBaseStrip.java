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
    private LinearLayout.LayoutParams bOI;
    private LinearLayout.LayoutParams bOJ;
    public ViewPager.OnPageChangeListener bOL;
    private LinearLayout bOM;
    private ViewPager bON;
    private int bOO;
    private Paint bOQ;
    private boolean bOR;
    private int bOS;
    private int bOT;
    private int bPe;
    private int bPf;
    private int bRj;
    private final b cDT;
    private float cDU;
    private int cDV;
    private int cDW;
    private Paint cDX;
    private RectF cDY;
    private boolean cDZ;
    private int cEa;
    private int cEb;
    private int cEc;
    private int cEd;
    private int cEe;
    private int cEf;
    private int cEg;
    private int cEh;
    private float cEi;
    private float cEj;
    private int cEk;
    private int cEl;
    private int cEm;
    private boolean cEn;
    private a cEo;
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
        this.cDT = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cDU = 0.0f;
        this.cDV = 0;
        this.cDW = 0;
        this.bOR = false;
        this.bOS = al.getColor(d.C0277d.cp_cont_b);
        this.bOT = al.getColor(d.C0277d.cp_cont_j);
        this.cEb = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.bRj = 1;
        this.cEf = 17;
        this.cEg = 17;
        this.bPe = 0;
        this.bPf = d.f.pager_sliding_view;
        this.cEn = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bOM = new LinearLayout(getContext());
        this.bOM.setOrientation(0);
        this.bOM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bOM);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cEb = (int) TypedValue.applyDimension(1, this.cEb, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.bRj = (int) TypedValue.applyDimension(1, this.bRj, displayMetrics);
        this.cEf = i;
        this.cEg = i2;
        this.cEh = l.h(getContext(), d.e.tbds74);
        this.cEi = (this.cEg * 1.0f) / this.cEf;
        this.cEj = (this.cEh * 1.0f) / this.cEf;
        this.mIndicatorHeight = i3;
        this.bOR = z;
        this.bOQ = new Paint();
        this.bOQ.setAntiAlias(true);
        this.bOQ.setStyle(Paint.Style.FILL);
        this.bOQ.setColor(al.getColor(d.C0277d.cp_other_e));
        this.cDX = new Paint();
        this.cDX.setAntiAlias(true);
        this.cDX.setStyle(Paint.Style.FILL);
        this.cDX.setColor(al.getColor(d.C0277d.cp_cont_h));
        this.cDY = new RectF();
        this.cEk = l.h(getContext(), d.e.tbds20);
        this.cEl = l.h(getContext(), d.e.tbds28);
        this.cEm = l.h(getContext(), d.e.tbds22);
        this.bOI = new LinearLayout.LayoutParams(-2, -1);
        this.bOJ = new LinearLayout.LayoutParams(l.h(getContext(), d.e.tbds200), -1);
        this.cEd = l.h(getContext(), d.e.tbds22);
        this.cEc = l.h(getContext(), d.e.tbds20);
        this.cEe = l.h(getContext(), d.e.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cDZ = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.cEn = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bON = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cDT);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bOL = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bON != null && this.bON.getAdapter() != null && this.bON.getAdapter().getCount() != 0) {
            this.bOM.removeAllViews();
            this.bOO = this.bON.getAdapter().getCount();
            for (int i = 0; i < this.bOO; i++) {
                A(i, this.bON.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.bON.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.cDV = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.cEf);
        textView.setSingleLine();
        e(i, textView);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.cEo != null) {
                        PagerSlidingTabBaseStrip.this.cEo.r(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.bON.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.cEn = true;
                        PagerSlidingTabBaseStrip.this.bON.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                }
            }
        });
        this.bOM.addView(view, i, this.bOR ? this.bOJ : this.bOI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bOO != 0) {
            int left = this.bOM.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cEb;
            }
            if (left != this.bPe) {
                this.bPe = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.bOO != 0) {
            View childAt = this.bOM.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cEd;
            float right2 = childAt.getRight() - this.cEd;
            if (this.cDU > 0.0f && this.mCurrentTabIndex != this.cDV && this.cDV <= this.bOO - 1 && this.cDV >= 0) {
                View childAt2 = this.bOM.getChildAt(this.cDV);
                left = d(left, childAt2.getLeft() + this.cEd, this.cDU);
                right2 = e(right2, childAt2.getRight() - this.cEd, this.cDU);
            }
            int height = getHeight();
            if (this.sz == null) {
                this.sz = new RectF(left, (height - this.mIndicatorHeight) - this.cEc, right2, height - this.cEc);
            } else {
                this.sz.set(left, (height - this.mIndicatorHeight) - this.cEc, right2, height - this.cEc);
            }
            canvas.drawRoundRect(this.sz, 16.0f, 16.0f, this.bOQ);
            if (this.cDZ) {
                View childAt3 = this.bOM.getChildAt(this.cEa);
                this.cDY.set((childAt3.getRight() - this.cEm) - this.cEk, childAt3.getTop() + this.cEl, right + this.cEk, top + this.cEk);
                canvas.drawOval(this.cDY, this.cDX);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cEe + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cEe + f2) - ((this.cEe * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.cEe) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cEe) + ((this.cEe * (0.15f - f3)) / 0.15f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.bOS = al.getColor(d.C0277d.cp_cont_b);
            this.bOT = al.getColor(d.C0277d.cp_cont_j);
            this.bOQ.setColor(al.getColor(d.C0277d.cp_other_e));
            this.cDX.setColor(al.getColor(d.C0277d.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float ar(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cEj - 1.0f) / (0.1f - 1.0f))) + this.cEj;
        }
        return (((this.cEj - this.cEi) / 0.1f) * f) + this.cEi;
    }

    private float as(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cEj) / (0.1f - 0.9f)));
        }
        return (((this.cEj - this.cEi) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cEj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float as;
        float f = this.cDU;
        float f2 = this.cDV < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.bOO) {
            View childAt = this.bOM.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bPf);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        as = ar(f2);
                    } else {
                        as = i == this.cDV ? as(f2) : 1.0f;
                    }
                    textView.setScaleX(as);
                    textView.setScaleY(as);
                    if (as <= 1.0f) {
                        textView.setTextColor(this.bOT);
                    } else {
                        textView.setTextColor(this.bOS);
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
            if (PagerSlidingTabBaseStrip.this.bOM.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.cEn) {
                    if (i == PagerSlidingTabBaseStrip.this.cDW) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cDV = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.cDW) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cDV = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.cDV = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.cDW = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cDV = i;
                    }
                    PagerSlidingTabBaseStrip.this.cDU = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.bOM.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.bOL != null) {
                    PagerSlidingTabBaseStrip.this.bOL.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.bOM.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.bON.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.cDU = 0.0f;
                    PagerSlidingTabBaseStrip.this.cEn = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.cDW = PagerSlidingTabBaseStrip.this.bON.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.cDW;
                    PagerSlidingTabBaseStrip.this.cDV = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.bOL != null) {
                    PagerSlidingTabBaseStrip.this.bOL.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.bOL != null) {
                PagerSlidingTabBaseStrip.this.bOL.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.cEn) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.cDU * PagerSlidingTabBaseStrip.this.bOM.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.cDW = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.cDV = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Us;
        this.cDV = this.mCurrentTabIndex;
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
            /* renamed from: kO */
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
        this.cEa = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cEo = aVar;
    }
}
