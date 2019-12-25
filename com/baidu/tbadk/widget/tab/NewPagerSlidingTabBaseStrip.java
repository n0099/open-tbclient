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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes5.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams cZQ;
    private LinearLayout.LayoutParams cZR;
    public ViewPager.OnPageChangeListener cZT;
    private LinearLayout cZU;
    private ViewPager cZV;
    private int cZW;
    private Paint cZY;
    private boolean cZZ;
    private float dLA;
    private int dLB;
    private int dLC;
    private Paint dLD;
    private RectF dLE;
    private boolean dLF;
    private int dLG;
    private boolean dLH;
    private int dLI;
    private int dLJ;
    private int dLK;
    private int dLL;
    private int dLM;
    private int dLN;
    private int dLO;
    private int dLP;
    private int dLQ;
    private int dLR;
    private float dLS;
    private float dLT;
    private TextView dLU;
    private int dLV;
    private int dLW;
    private int dLX;
    private int dLY;
    private boolean dLZ;
    private FrameLayout.LayoutParams dLx;
    private final b dLy;
    private boolean dLz;
    private a dMa;
    private int daa;
    private int dab;
    private int dak;
    private int dal;
    private int dcb;
    private int dividerPadding;
    private boolean isLoading;
    private RectF jE;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes5.dex */
    public interface a {
        void k(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLy = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dLA = 0.0f;
        this.dLB = 0;
        this.dLC = 0;
        this.cZZ = false;
        this.dLH = false;
        this.dLI = R.color.cp_cont_b;
        this.daa = am.getColor(this.dLI);
        this.dab = am.getColor(R.color.cp_cont_j);
        this.dLJ = R.color.cp_other_f;
        this.dLK = 52;
        this.mIndicatorHeight = 4;
        this.dLO = 16;
        this.dividerPadding = 12;
        this.dcb = 1;
        this.dLP = 17;
        this.dLQ = 17;
        this.dak = 0;
        this.dal = R.drawable.pager_sliding_view;
        this.dLZ = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.dLH) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.dLx == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.dLx);
            }
            addView(this.mContainer);
        }
        this.cZU = new LinearLayout(getContext());
        this.cZU.setOrientation(0);
        if (this.dLH) {
            this.cZU.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.cZU);
        } else {
            this.cZU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.cZU);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dLK = (int) TypedValue.applyDimension(1, this.dLK, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dcb = (int) TypedValue.applyDimension(1, this.dcb, displayMetrics);
        this.dLP = i;
        this.dLQ = i2;
        this.dLR = l.getDimens(getContext(), R.dimen.tbds74);
        this.dLS = (this.dLQ * 1.0f) / this.dLP;
        this.dLT = (this.dLR * 1.0f) / this.dLP;
        this.mIndicatorHeight = i3;
        this.cZZ = z;
        this.cZY = new Paint();
        this.cZY.setAntiAlias(true);
        this.cZY.setStyle(Paint.Style.FILL);
        this.cZY.setColor(am.getColor(this.dLJ));
        this.dLD = new Paint();
        this.dLD.setAntiAlias(true);
        this.dLD.setStyle(Paint.Style.FILL);
        this.dLD.setColor(am.getColor(R.color.cp_cont_h));
        this.dLE = new RectF();
        this.dLW = l.getDimens(getContext(), R.dimen.tbds20);
        this.dLX = l.getDimens(getContext(), R.dimen.tbds28);
        this.dLY = l.getDimens(getContext(), R.dimen.tbds22);
        this.cZQ = new LinearLayout.LayoutParams(-2, -1);
        this.cZR = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.dLM = l.getDimens(getContext(), R.dimen.tbds22);
        this.dLL = l.getDimens(getContext(), R.dimen.tbds20);
        this.dLN = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.dLH && this.mContainer != null) {
            this.dLV = l.getDimens(getContext(), R.dimen.tbds32);
            this.dLU = new TextView(getContext());
            this.dLU.setGravity(17);
            this.dLU.setTextSize(0, this.dLV);
            this.dLU.setSingleLine();
            this.dLU.setTextColor(this.dab);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.dLU, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.dLR = i4;
        this.dLT = (this.dLR * 1.0f) / this.dLP;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.dLH = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.dLM = i;
    }

    public void setRectPaintColor(int i) {
        this.dLJ = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.dLL = i;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.cZR = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.dLx = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.dLN = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.cZQ = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dLF = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dLZ = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cZV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dLy);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cZT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.cZV != null && this.cZV.getAdapter() != null && this.cZV.getAdapter().getCount() != 0) {
            this.cZU.removeAllViews();
            this.cZW = this.cZV.getAdapter().getCount();
            for (int i = 0; i < this.cZW; i++) {
                N(i, this.cZV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.cZV.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.dLB = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void vK(String str) {
        if (this.cZV != null && this.cZV.getAdapter() != null && this.cZV.getAdapter().getCount() != 0 && this.dLH && this.dLU != null) {
            this.dLU.setText(str);
        }
    }

    private void N(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dLP);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.dMa != null) {
                        NewPagerSlidingTabBaseStrip.this.dMa.k(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.cZV.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.dLZ = true;
                        NewPagerSlidingTabBaseStrip.this.cZV.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.cZU.addView(view, i, this.cZZ ? this.cZR : this.cZQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.cZW != 0) {
            int left = this.cZU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dLK;
            }
            if (left != this.dak) {
                this.dak = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.cZW != 0) {
            View childAt = this.cZU.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dLM;
            float right2 = childAt.getRight() - this.dLM;
            if (this.dLA > 0.0f && this.mCurrentTabIndex != this.dLB && this.dLB <= this.cZW - 1 && this.dLB >= 0) {
                View childAt2 = this.cZU.getChildAt(this.dLB);
                left = d(left, childAt2.getLeft() + this.dLM, this.dLA);
                right2 = e(right2, childAt2.getRight() - this.dLM, this.dLA);
            }
            int height = getHeight();
            if (this.jE == null) {
                this.jE = new RectF(left, (height - this.mIndicatorHeight) - this.dLL, right2, height - this.dLL);
            } else {
                this.jE.set(left, (height - this.mIndicatorHeight) - this.dLL, right2, height - this.dLL);
            }
            canvas.drawRoundRect(this.jE, this.dLO, this.dLO, this.cZY);
            if (this.dLF) {
                View childAt3 = this.cZU.getChildAt(this.dLG);
                this.dLE.set((childAt3.getRight() - this.dLY) - this.dLW, childAt3.getTop() + this.dLX, right + this.dLW, top + this.dLW);
                canvas.drawOval(this.dLE, this.dLD);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dLN + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dLN + f2) - ((this.dLN * (f3 - 0.8f)) / 0.2f);
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
            if (f3 >= 0.2d) {
                return f - ((((this.dLN + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dLN) + ((this.dLN * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.dLz = z;
        if (!z) {
            this.daa = am.getColor(this.dLI);
            this.dab = am.getColor(R.color.cp_cont_j);
        } else {
            this.daa = am.getColor(R.color.cp_cont_a);
            this.dab = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.dLz) {
                this.daa = am.getColor(this.dLI);
                this.dab = am.getColor(R.color.cp_cont_j);
            } else {
                this.daa = am.getColor(R.color.cp_cont_a);
                this.dab = am.getColor(R.color.cp_cont_a);
            }
            this.cZY.setColor(am.getColor(this.dLJ));
            this.dLD.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float au(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dLT - 1.0f) / (0.1f - 1.0f))) + this.dLT;
        }
        return (((this.dLT - this.dLS) / 0.1f) * f) + this.dLS;
    }

    private float av(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dLT) / (0.1f - 0.9f)));
        }
        return (((this.dLT - this.dLS) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dLT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float av;
        float f = this.dLA;
        float f2 = this.dLB < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.cZW) {
            View childAt = this.cZU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dal);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        av = au(f2);
                    } else {
                        av = i == this.dLB ? av(f2) : 1.0f;
                    }
                    textView.setScaleX(av);
                    textView.setScaleY(av);
                    if (f2 >= 0.5f) {
                        if (i == this.dLB) {
                            textView.setTextColor(this.daa);
                        } else {
                            textView.setTextColor(this.dab);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.daa);
                    } else {
                        textView.setTextColor(this.dab);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dLB) {
                            textView.setTypeface(Typeface.defaultFromStyle(1));
                        } else {
                            textView.setTypeface(Typeface.defaultFromStyle(0));
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes5.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (NewPagerSlidingTabBaseStrip.this.cZU.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.dLZ) {
                    if (i == NewPagerSlidingTabBaseStrip.this.dLC) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dLB = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.dLC) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dLB = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.dLB = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.dLC = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dLB = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.dLA = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.cZU.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.cZT != null) {
                    NewPagerSlidingTabBaseStrip.this.cZT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.cZU.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.cZV.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.dLA = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.dLZ = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.dLC = NewPagerSlidingTabBaseStrip.this.cZV.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dLC;
                    NewPagerSlidingTabBaseStrip.this.dLB = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.cZT != null) {
                    NewPagerSlidingTabBaseStrip.this.cZT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.cZT != null) {
                NewPagerSlidingTabBaseStrip.this.cZT.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.dLZ) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dLA * NewPagerSlidingTabBaseStrip.this.cZU.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.dLC = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.dLB = i;
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.DX;
        this.dLB = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.DX = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: X */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: nh */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int DX;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.DX = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.DX);
        }
    }

    public void setConcernTabIndex(int i) {
        this.dLG = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dLI = i;
    }

    public void setIndicatorRadius(int i) {
        this.dLO = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dMa = aVar;
    }
}
