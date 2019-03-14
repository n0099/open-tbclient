package com.baidu.tieba.homepage.framework.indicator;

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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes4.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
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
    private int dividerPadding;
    private final b fJF;
    private a fJG;
    private boolean isLoading;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;
    private RectF sz;

    /* loaded from: classes4.dex */
    public interface a {
        void r(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fJF = new b();
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
        setLayerType(1, null);
        this.cDV.setShadowLayer(l.h(getContext(), d.e.tbds8), 0.0f, l.h(getContext(), d.e.tbds3), al.getColor(d.C0277d.cp_cont_h_alpha66));
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

    public boolean bmc() {
        return this.cDX;
    }

    public void setTabItemClicked(boolean z) {
        this.cEl = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bOL = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fJF);
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
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.bOL.getCurrentItem();
                    PagerSlidingTabStrip.this.cDT = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.fJG != null) {
                        PagerSlidingTabStrip.this.fJG.r(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.bOL.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new am("c12049").T("obj_locate", i + 1).bJ("obj_type", "1"));
                    PagerSlidingTabStrip.this.cEl = true;
                    if (PagerSlidingTabStrip.this.bOL.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.bOL.getAdapter()).sw(i);
                    }
                    PagerSlidingTabStrip.this.bOL.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
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
            this.cDV.setShadowLayer(l.h(getContext(), d.e.tbds8), 0.0f, l.h(getContext(), d.e.tbds3), al.getColor(d.C0277d.cp_cont_h_alpha66));
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

    /* loaded from: classes4.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.bOK.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cEl) {
                    if (i == PagerSlidingTabStrip.this.cDU) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cDT = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.cDU) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cDT = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.cDT = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.cDU = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cDT = i;
                    }
                    PagerSlidingTabStrip.this.cDS = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bOK.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.bOJ != null) {
                    PagerSlidingTabStrip.this.bOJ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bOK.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bOL.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.cDS = 0.0f;
                    PagerSlidingTabStrip.this.cEl = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.cDU = PagerSlidingTabStrip.this.bOL.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.cDU;
                    PagerSlidingTabStrip.this.cDT = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.bOJ != null) {
                    PagerSlidingTabStrip.this.bOJ.onPageScrollStateChanged(i);
                }
                HomePageStatic.fFL = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bOJ != null) {
                PagerSlidingTabStrip.this.bOJ.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cEl) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cDS * PagerSlidingTabStrip.this.bOK.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.cDU = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.cDT = i;
            }
            PagerSlidingTabStrip.this.invalidate();
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
    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: F */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: sy */
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

    public View sx(int i) {
        return this.bOK.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.cDY = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fJG = aVar;
    }
}
