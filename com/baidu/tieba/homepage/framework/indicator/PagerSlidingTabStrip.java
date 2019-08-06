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
    private LinearLayout.LayoutParams bXG;
    private LinearLayout.LayoutParams bXH;
    public ViewPager.OnPageChangeListener bXJ;
    private LinearLayout bXK;
    private ViewPager bXL;
    private int bXM;
    private Paint bXO;
    private boolean bXP;
    private int bXQ;
    private int bXR;
    private int bYc;
    private int bYd;
    private float cNG;
    private int cNH;
    private int cNI;
    private Paint cNJ;
    private RectF cNK;
    private boolean cNL;
    private int cNM;
    private int cNN;
    private int cNO;
    private int cNP;
    private int cNQ;
    private int cNR;
    private int cNS;
    private int cNT;
    private float cNU;
    private float cNV;
    private int cNW;
    private int cNX;
    private int cNY;
    private boolean cNZ;
    private int cak;
    private int dividerPadding;
    private final b ggl;
    private a ggm;
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
        this.ggl = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cNG = 0.0f;
        this.cNH = 0;
        this.cNI = 0;
        this.bXP = false;
        this.bXQ = am.getColor(R.color.cp_cont_b);
        this.bXR = am.getColor(R.color.cp_cont_j);
        this.cNN = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.cak = 1;
        this.cNR = 17;
        this.cNS = 17;
        this.bYc = 0;
        this.bYd = R.drawable.pager_sliding_view;
        this.cNZ = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bXK = new LinearLayout(getContext());
        this.bXK.setOrientation(0);
        this.bXK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bXK);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cNN = (int) TypedValue.applyDimension(1, this.cNN, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.cak = (int) TypedValue.applyDimension(1, this.cak, displayMetrics);
        this.cNR = i;
        this.cNS = i2;
        this.cNT = l.g(getContext(), R.dimen.tbds74);
        this.cNU = (this.cNS * 1.0f) / this.cNR;
        this.cNV = (this.cNT * 1.0f) / this.cNR;
        this.mIndicatorHeight = i3;
        this.bXP = z;
        this.bXO = new Paint();
        this.bXO.setAntiAlias(true);
        this.bXO.setStyle(Paint.Style.FILL);
        this.bXO.setColor(am.getColor(R.color.cp_other_e));
        this.cNJ = new Paint();
        this.cNJ.setAntiAlias(true);
        this.cNJ.setStyle(Paint.Style.FILL);
        this.cNJ.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.cNJ.setShadowLayer(l.g(getContext(), R.dimen.tbds8), 0.0f, l.g(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.cNK = new RectF();
        this.cNW = l.g(getContext(), R.dimen.tbds20);
        this.cNX = l.g(getContext(), R.dimen.tbds28);
        this.cNY = l.g(getContext(), R.dimen.tbds22);
        this.bXG = new LinearLayout.LayoutParams(-2, -1);
        this.bXH = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.tbds200), -1);
        this.cNP = l.g(getContext(), R.dimen.tbds22);
        this.cNO = l.g(getContext(), R.dimen.tbds20);
        this.cNQ = l.g(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cNL = z;
        invalidate();
    }

    public boolean bvQ() {
        return this.cNL;
    }

    public void setTabItemClicked(boolean z) {
        this.cNZ = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bXL = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ggl);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bXJ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bXL != null && this.bXL.getAdapter() != null && this.bXL.getAdapter().getCount() != 0) {
            this.bXK.removeAllViews();
            this.bXM = this.bXL.getAdapter().getCount();
            for (int i = 0; i < this.bXM; i++) {
                D(i, this.bXL.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.bXL.getCurrentItem();
                    PagerSlidingTabStrip.this.cNH = PagerSlidingTabStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.cNR);
        textView.setSingleLine();
        e(i, textView);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.ggm != null) {
                        PagerSlidingTabStrip.this.ggm.r(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.bXL.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new an("c12049").P("obj_locate", i + 1).bT("obj_type", "1"));
                    PagerSlidingTabStrip.this.cNZ = true;
                    if (PagerSlidingTabStrip.this.bXL.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.bXL.getAdapter()).tT(i);
                    }
                    PagerSlidingTabStrip.this.bXL.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.bXK.addView(view, i, this.bXP ? this.bXH : this.bXG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bXM != 0) {
            int left = this.bXK.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cNN;
            }
            if (left != this.bYc) {
                this.bYc = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.bXM != 0) {
            View childAt = this.bXK.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cNP;
            float right2 = childAt.getRight() - this.cNP;
            if (this.cNG > 0.0f && this.mCurrentTabIndex != this.cNH && this.cNH <= this.bXM - 1 && this.cNH >= 0) {
                View childAt2 = this.bXK.getChildAt(this.cNH);
                left = d(left, childAt2.getLeft() + this.cNP, this.cNG);
                right2 = e(right2, childAt2.getRight() - this.cNP, this.cNG);
            }
            int height = getHeight();
            if (this.qe == null) {
                this.qe = new RectF(left, (height - this.mIndicatorHeight) - this.cNO, right2, height - this.cNO);
            } else {
                this.qe.set(left, (height - this.mIndicatorHeight) - this.cNO, right2, height - this.cNO);
            }
            canvas.drawRoundRect(this.qe, 16.0f, 16.0f, this.bXO);
            if (this.cNL) {
                View childAt3 = this.bXK.getChildAt(this.cNM);
                this.cNK.set((childAt3.getRight() - this.cNY) - this.cNW, childAt3.getTop() + this.cNX, right + this.cNW, top + this.cNW);
                canvas.drawOval(this.cNK, this.cNJ);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cNQ + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cNQ + f2) - ((this.cNQ * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.cNQ) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cNQ) + ((this.cNQ * (0.15f - f3)) / 0.15f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.bXQ = am.getColor(R.color.cp_cont_b);
            this.bXR = am.getColor(R.color.cp_cont_j);
            this.bXO.setColor(am.getColor(R.color.cp_other_e));
            this.cNJ.setColor(am.getColor(R.color.cp_cont_h));
            this.cNJ.setShadowLayer(l.g(getContext(), R.dimen.tbds8), 0.0f, l.g(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cNV - 1.0f) / (0.1f - 1.0f))) + this.cNV;
        }
        return (((this.cNV - this.cNU) / 0.1f) * f) + this.cNU;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cNV) / (0.1f - 0.9f)));
        }
        return (((this.cNV - this.cNU) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cNV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.cNG;
        float f2 = this.cNH < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.bXM) {
            View childAt = this.bXK.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bYd);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.cNH ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (au <= 1.0f) {
                        textView.setTextColor(this.bXR);
                    } else {
                        textView.setTextColor(this.bXQ);
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
            if (PagerSlidingTabStrip.this.bXK.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cNZ) {
                    if (i == PagerSlidingTabStrip.this.cNI) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cNH = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.cNI) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cNH = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.cNH = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.cNI = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cNH = i;
                    }
                    PagerSlidingTabStrip.this.cNG = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.bXK.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.bXJ != null) {
                    PagerSlidingTabStrip.this.bXJ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.bXK.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.bXL.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.cNG = 0.0f;
                    PagerSlidingTabStrip.this.cNZ = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.cNI = PagerSlidingTabStrip.this.bXL.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.cNI;
                    PagerSlidingTabStrip.this.cNH = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.bXJ != null) {
                    PagerSlidingTabStrip.this.bXJ.onPageScrollStateChanged(i);
                }
                HomePageStatic.gcm = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.bXJ != null) {
                PagerSlidingTabStrip.this.bXJ.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cNZ) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cNG * PagerSlidingTabStrip.this.bXK.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.cNI = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.cNH = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Sw;
        this.cNH = this.mCurrentTabIndex;
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
            /* renamed from: tV */
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

    public View tU(int i) {
        return this.bXK.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.cNM = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ggm = aVar;
    }
}
