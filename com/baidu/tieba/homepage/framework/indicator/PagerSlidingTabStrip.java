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
    private LinearLayout.LayoutParams bXA;
    private LinearLayout.LayoutParams bXB;
    public ViewPager.OnPageChangeListener bXD;
    private LinearLayout bXE;
    private ViewPager bXF;
    private int bXG;
    private Paint bXI;
    private boolean bXJ;
    private int bXK;
    private int bXL;
    private int bXW;
    private int bXX;
    private int cNA;
    private int cNB;
    private Paint cNC;
    private RectF cND;
    private boolean cNE;
    private int cNF;
    private int cNG;
    private int cNH;
    private int cNI;
    private int cNJ;
    private int cNK;
    private int cNL;
    private int cNM;
    private float cNN;
    private float cNO;
    private int cNP;
    private int cNQ;
    private int cNR;
    private boolean cNS;
    private float cNz;
    private int cae;
    private int dividerPadding;
    private final b gfv;
    private a gfw;
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
        this.gfv = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cNz = 0.0f;
        this.cNA = 0;
        this.cNB = 0;
        this.bXJ = false;
        this.bXK = am.getColor(R.color.cp_cont_b);
        this.bXL = am.getColor(R.color.cp_cont_j);
        this.cNG = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.cae = 1;
        this.cNK = 17;
        this.cNL = 17;
        this.bXW = 0;
        this.bXX = R.drawable.pager_sliding_view;
        this.cNS = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bXE = new LinearLayout(getContext());
        this.bXE.setOrientation(0);
        this.bXE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bXE);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cNG = (int) TypedValue.applyDimension(1, this.cNG, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.cae = (int) TypedValue.applyDimension(1, this.cae, displayMetrics);
        this.cNK = i;
        this.cNL = i2;
        this.cNM = l.g(getContext(), R.dimen.tbds74);
        this.cNN = (this.cNL * 1.0f) / this.cNK;
        this.cNO = (this.cNM * 1.0f) / this.cNK;
        this.mIndicatorHeight = i3;
        this.bXJ = z;
        this.bXI = new Paint();
        this.bXI.setAntiAlias(true);
        this.bXI.setStyle(Paint.Style.FILL);
        this.bXI.setColor(am.getColor(R.color.cp_other_e));
        this.cNC = new Paint();
        this.cNC.setAntiAlias(true);
        this.cNC.setStyle(Paint.Style.FILL);
        this.cNC.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.cNC.setShadowLayer(l.g(getContext(), R.dimen.tbds8), 0.0f, l.g(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.cND = new RectF();
        this.cNP = l.g(getContext(), R.dimen.tbds20);
        this.cNQ = l.g(getContext(), R.dimen.tbds28);
        this.cNR = l.g(getContext(), R.dimen.tbds22);
        this.bXA = new LinearLayout.LayoutParams(-2, -1);
        this.bXB = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.tbds200), -1);
        this.cNI = l.g(getContext(), R.dimen.tbds22);
        this.cNH = l.g(getContext(), R.dimen.tbds20);
        this.cNJ = l.g(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cNE = z;
        invalidate();
    }

    public boolean bvD() {
        return this.cNE;
    }

    public void setTabItemClicked(boolean z) {
        this.cNS = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bXF = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gfv);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bXD = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bXF != null && this.bXF.getAdapter() != null && this.bXF.getAdapter().getCount() != 0) {
            this.bXE.removeAllViews();
            this.bXG = this.bXF.getAdapter().getCount();
            for (int i = 0; i < this.bXG; i++) {
                D(i, this.bXF.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.bXF.getCurrentItem();
                    PagerSlidingTabStrip.this.cNA = PagerSlidingTabStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.cNK);
        textView.setSingleLine();
        e(i, textView);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.gfw != null) {
                        PagerSlidingTabStrip.this.gfw.r(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.bXF.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new an("c12049").P("obj_locate", i + 1).bT("obj_type", "1"));
                    PagerSlidingTabStrip.this.cNS = true;
                    if (PagerSlidingTabStrip.this.bXF.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.bXF.getAdapter()).tR(i);
                    }
                    PagerSlidingTabStrip.this.bXF.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.bXE.addView(view, i, this.bXJ ? this.bXB : this.bXA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bXG != 0) {
            int left = this.bXE.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cNG;
            }
            if (left != this.bXW) {
                this.bXW = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.bXG != 0) {
            View childAt = this.bXE.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cNI;
            float right2 = childAt.getRight() - this.cNI;
            if (this.cNz > 0.0f && this.mCurrentTabIndex != this.cNA && this.cNA <= this.bXG - 1 && this.cNA >= 0) {
                View childAt2 = this.bXE.getChildAt(this.cNA);
                left = d(left, childAt2.getLeft() + this.cNI, this.cNz);
                right2 = e(right2, childAt2.getRight() - this.cNI, this.cNz);
            }
            int height = getHeight();
            if (this.qe == null) {
                this.qe = new RectF(left, (height - this.mIndicatorHeight) - this.cNH, right2, height - this.cNH);
            } else {
                this.qe.set(left, (height - this.mIndicatorHeight) - this.cNH, right2, height - this.cNH);
            }
            canvas.drawRoundRect(this.qe, 16.0f, 16.0f, this.bXI);
            if (this.cNE) {
                View childAt3 = this.bXE.getChildAt(this.cNF);
                this.cND.set((childAt3.getRight() - this.cNR) - this.cNP, childAt3.getTop() + this.cNQ, right + this.cNP, top + this.cNP);
                canvas.drawOval(this.cND, this.cNC);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cNJ + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cNJ + f2) - ((this.cNJ * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.cNJ) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cNJ) + ((this.cNJ * (0.15f - f3)) / 0.15f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.bXK = am.getColor(R.color.cp_cont_b);
            this.bXL = am.getColor(R.color.cp_cont_j);
            this.bXI.setColor(am.getColor(R.color.cp_other_e));
            this.cNC.setColor(am.getColor(R.color.cp_cont_h));
            this.cNC.setShadowLayer(l.g(getContext(), R.dimen.tbds8), 0.0f, l.g(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cNO - 1.0f) / (0.1f - 1.0f))) + this.cNO;
        }
        return (((this.cNO - this.cNN) / 0.1f) * f) + this.cNN;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cNO) / (0.1f - 0.9f)));
        }
        return (((this.cNO - this.cNN) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cNO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.cNz;
        float f2 = this.cNA < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.bXG) {
            View childAt = this.bXE.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bXX);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.cNA ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (au <= 1.0f) {
                        textView.setTextColor(this.bXL);
                    } else {
                        textView.setTextColor(this.bXK);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.bXE.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cNS) {
                    if (i == PagerSlidingTabStrip.this.cNB) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cNA = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.cNB) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cNA = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.cNA = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.cNB = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cNA = i;
                    }
                    PagerSlidingTabStrip.this.cNz = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bXE.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.bXD != null) {
                    PagerSlidingTabStrip.this.bXD.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bXE.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bXF.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.cNz = 0.0f;
                    PagerSlidingTabStrip.this.cNS = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.cNB = PagerSlidingTabStrip.this.bXF.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.cNB;
                    PagerSlidingTabStrip.this.cNA = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.bXD != null) {
                    PagerSlidingTabStrip.this.bXD.onPageScrollStateChanged(i);
                }
                HomePageStatic.gbw = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bXD != null) {
                PagerSlidingTabStrip.this.bXD.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cNS) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cNz * PagerSlidingTabStrip.this.bXE.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.cNB = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.cNA = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Sw;
        this.cNA = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Sw = this.mCurrentTabIndex;
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
            /* renamed from: tT */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Sw;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Sw = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Sw);
        }
    }

    public View tS(int i) {
        return this.bXE.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.cNF = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gfw = aVar;
    }
}
