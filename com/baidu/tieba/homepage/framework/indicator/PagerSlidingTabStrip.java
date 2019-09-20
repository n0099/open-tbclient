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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes4.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams bYA;
    public ViewPager.OnPageChangeListener bYC;
    private LinearLayout bYD;
    private ViewPager bYE;
    private int bYF;
    private Paint bYH;
    private boolean bYI;
    private int bYJ;
    private int bYK;
    private int bYV;
    private int bYW;
    private LinearLayout.LayoutParams bYz;
    private RectF cOA;
    private boolean cOB;
    private int cOC;
    private int cOD;
    private int cOE;
    private int cOF;
    private int cOG;
    private int cOH;
    private int cOI;
    private int cOJ;
    private float cOK;
    private float cOL;
    private int cOM;
    private int cON;
    private int cOO;
    private boolean cOP;
    private float cOw;
    private int cOx;
    private int cOy;
    private Paint cOz;
    private int cbd;
    private int dividerPadding;
    private final b gie;
    private a gif;
    private boolean isLoading;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;
    private RectF qe;

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
        this.gie = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cOw = 0.0f;
        this.cOx = 0;
        this.cOy = 0;
        this.bYI = false;
        this.bYJ = am.getColor(R.color.cp_cont_b);
        this.bYK = am.getColor(R.color.cp_cont_j);
        this.cOD = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.cbd = 1;
        this.cOH = 17;
        this.cOI = 17;
        this.bYV = 0;
        this.bYW = R.drawable.pager_sliding_view;
        this.cOP = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bYD = new LinearLayout(getContext());
        this.bYD.setOrientation(0);
        this.bYD.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bYD);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cOD = (int) TypedValue.applyDimension(1, this.cOD, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.cbd = (int) TypedValue.applyDimension(1, this.cbd, displayMetrics);
        this.cOH = i;
        this.cOI = i2;
        this.cOJ = l.g(getContext(), R.dimen.tbds74);
        this.cOK = (this.cOI * 1.0f) / this.cOH;
        this.cOL = (this.cOJ * 1.0f) / this.cOH;
        this.mIndicatorHeight = i3;
        this.bYI = z;
        this.bYH = new Paint();
        this.bYH.setAntiAlias(true);
        this.bYH.setStyle(Paint.Style.FILL);
        this.bYH.setColor(am.getColor(R.color.cp_other_e));
        this.cOz = new Paint();
        this.cOz.setAntiAlias(true);
        this.cOz.setStyle(Paint.Style.FILL);
        this.cOz.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.cOz.setShadowLayer(l.g(getContext(), R.dimen.tbds8), 0.0f, l.g(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.cOA = new RectF();
        this.cOM = l.g(getContext(), R.dimen.tbds20);
        this.cON = l.g(getContext(), R.dimen.tbds28);
        this.cOO = l.g(getContext(), R.dimen.tbds22);
        this.bYz = new LinearLayout.LayoutParams(-2, -1);
        this.bYA = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.tbds200), -1);
        this.cOF = l.g(getContext(), R.dimen.tbds22);
        this.cOE = l.g(getContext(), R.dimen.tbds20);
        this.cOG = l.g(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cOB = z;
        invalidate();
    }

    public boolean bwE() {
        return this.cOB;
    }

    public void setTabItemClicked(boolean z) {
        this.cOP = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bYE = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gie);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bYC = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bYE != null && this.bYE.getAdapter() != null && this.bYE.getAdapter().getCount() != 0) {
            this.bYD.removeAllViews();
            this.bYF = this.bYE.getAdapter().getCount();
            for (int i = 0; i < this.bYF; i++) {
                D(i, this.bYE.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.bYE.getCurrentItem();
                    PagerSlidingTabStrip.this.cOx = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void D(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.cOH);
        textView.setSingleLine();
        e(i, textView);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.gif != null) {
                        PagerSlidingTabStrip.this.gif.r(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.bYE.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new an("c12049").P("obj_locate", i + 1).bT("obj_type", "1"));
                    PagerSlidingTabStrip.this.cOP = true;
                    if (PagerSlidingTabStrip.this.bYE.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.bYE.getAdapter()).tX(i);
                    }
                    PagerSlidingTabStrip.this.bYE.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.bYD.addView(view, i, this.bYI ? this.bYA : this.bYz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bYF != 0) {
            int left = this.bYD.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cOD;
            }
            if (left != this.bYV) {
                this.bYV = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.bYF != 0) {
            View childAt = this.bYD.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cOF;
            float right2 = childAt.getRight() - this.cOF;
            if (this.cOw > 0.0f && this.mCurrentTabIndex != this.cOx && this.cOx <= this.bYF - 1 && this.cOx >= 0) {
                View childAt2 = this.bYD.getChildAt(this.cOx);
                left = d(left, childAt2.getLeft() + this.cOF, this.cOw);
                right2 = e(right2, childAt2.getRight() - this.cOF, this.cOw);
            }
            int height = getHeight();
            if (this.qe == null) {
                this.qe = new RectF(left, (height - this.mIndicatorHeight) - this.cOE, right2, height - this.cOE);
            } else {
                this.qe.set(left, (height - this.mIndicatorHeight) - this.cOE, right2, height - this.cOE);
            }
            canvas.drawRoundRect(this.qe, 16.0f, 16.0f, this.bYH);
            if (this.cOB) {
                View childAt3 = this.bYD.getChildAt(this.cOC);
                this.cOA.set((childAt3.getRight() - this.cOO) - this.cOM, childAt3.getTop() + this.cON, right + this.cOM, top + this.cOM);
                canvas.drawOval(this.cOA, this.cOz);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cOG + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cOG + f2) - ((this.cOG * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.cOG) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cOG) + ((this.cOG * (0.15f - f3)) / 0.15f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.bYJ = am.getColor(R.color.cp_other_d);
            this.bYK = am.getColor(R.color.cp_cont_j);
            this.bYH.setColor(am.getColor(R.color.cp_other_e));
            this.cOz.setColor(am.getColor(R.color.cp_cont_h));
            this.cOz.setShadowLayer(l.g(getContext(), R.dimen.tbds8), 0.0f, l.g(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cOL - 1.0f) / (0.1f - 1.0f))) + this.cOL;
        }
        return (((this.cOL - this.cOK) / 0.1f) * f) + this.cOK;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cOL) / (0.1f - 0.9f)));
        }
        return (((this.cOL - this.cOK) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cOL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.cOw;
        float f2 = this.cOx < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.bYF) {
            View childAt = this.bYD.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bYW);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.cOx ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (au <= 1.0f) {
                        textView.setTextColor(this.bYK);
                    } else {
                        textView.setTextColor(this.bYJ);
                    }
                    if (au <= 1.03f) {
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
            if (PagerSlidingTabStrip.this.bYD.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cOP) {
                    if (i == PagerSlidingTabStrip.this.cOy) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cOx = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.cOy) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cOx = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.cOx = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.cOy = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cOx = i;
                    }
                    PagerSlidingTabStrip.this.cOw = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bYD.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.bYC != null) {
                    PagerSlidingTabStrip.this.bYC.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bYD.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bYE.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.cOw = 0.0f;
                    PagerSlidingTabStrip.this.cOP = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.cOy = PagerSlidingTabStrip.this.bYE.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.cOy;
                    PagerSlidingTabStrip.this.cOx = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.bYC != null) {
                    PagerSlidingTabStrip.this.bYC.onPageScrollStateChanged(i);
                }
                HomePageStatic.ged = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bYC != null) {
                PagerSlidingTabStrip.this.bYC.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cOP) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cOw * PagerSlidingTabStrip.this.bYD.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.cOy = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.cOx = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Sv;
        this.cOx = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Sv = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: K */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: tZ */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Sv;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Sv = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Sv);
        }
    }

    public View tY(int i) {
        return this.bYD.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.cOC = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gif = aVar;
    }
}
