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
/* loaded from: classes8.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private int dQA;
    private int dQB;
    private int dQC;
    private int dQD;
    private int dQE;
    private int dQF;
    private int dQG;
    private int dQH;
    private int dQI;
    private int dQJ;
    private int dQK;
    private float dQL;
    private float dQM;
    private TextView dQN;
    private int dQO;
    private int dQP;
    private int dQQ;
    private int dQR;
    private boolean dQS;
    private a dQT;
    private FrameLayout.LayoutParams dQq;
    private final b dQr;
    private float dQs;
    private int dQt;
    private int dQu;
    private Paint dQv;
    private RectF dQw;
    private boolean dQx;
    private int dQy;
    private boolean dQz;
    private LinearLayout.LayoutParams deH;
    private LinearLayout.LayoutParams deI;
    public ViewPager.OnPageChangeListener deK;
    private LinearLayout deL;
    private ViewPager deM;
    private int deN;
    private Paint deP;
    private boolean deQ;
    private int deR;
    private int deS;
    private int dfb;
    private int dfc;
    private int dgR;
    private int dividerPadding;
    private boolean isLoading;
    private RectF jG;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes8.dex */
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
        this.dQr = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dQs = 0.0f;
        this.dQt = 0;
        this.dQu = 0;
        this.deQ = false;
        this.dQz = false;
        this.dQA = R.color.cp_other_f;
        this.dQB = R.color.cp_cont_b;
        this.dQC = R.color.cp_cont_j;
        this.deR = am.getColor(this.dQB);
        this.deS = am.getColor(this.dQC);
        this.dQD = 52;
        this.mIndicatorHeight = 4;
        this.dQH = 16;
        this.dividerPadding = 12;
        this.dgR = 1;
        this.dQI = 17;
        this.dQJ = 17;
        this.dfb = 0;
        this.dfc = R.drawable.pager_sliding_view;
        this.dQS = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.dQz) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.dQq == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.dQq);
            }
            addView(this.mContainer);
        }
        this.deL = new LinearLayout(getContext());
        this.deL.setOrientation(0);
        if (this.dQz) {
            this.deL.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.deL);
        } else {
            this.deL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.deL);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dQD = (int) TypedValue.applyDimension(1, this.dQD, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dgR = (int) TypedValue.applyDimension(1, this.dgR, displayMetrics);
        this.dQI = i;
        this.dQJ = i2;
        this.dQK = l.getDimens(getContext(), R.dimen.tbds74);
        this.dQL = (this.dQJ * 1.0f) / this.dQI;
        this.dQM = (this.dQK * 1.0f) / this.dQI;
        this.mIndicatorHeight = i3;
        this.deQ = z;
        this.deP = new Paint();
        this.deP.setAntiAlias(true);
        this.deP.setStyle(Paint.Style.FILL);
        this.deP.setColor(am.getColor(this.dQA));
        this.dQv = new Paint();
        this.dQv.setAntiAlias(true);
        this.dQv.setStyle(Paint.Style.FILL);
        this.dQv.setColor(am.getColor(R.color.cp_cont_h));
        this.dQw = new RectF();
        this.dQP = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQQ = l.getDimens(getContext(), R.dimen.tbds28);
        this.dQR = l.getDimens(getContext(), R.dimen.tbds22);
        this.deH = new LinearLayout.LayoutParams(-2, -1);
        this.deI = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.dQF = l.getDimens(getContext(), R.dimen.tbds22);
        this.dQE = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQG = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.dQz && this.mContainer != null) {
            this.dQO = l.getDimens(getContext(), R.dimen.tbds32);
            this.dQN = new TextView(getContext());
            this.dQN.setGravity(17);
            this.dQN.setTextSize(0, this.dQO);
            this.dQN.setSingleLine();
            this.dQN.setTextColor(this.deS);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.dQN, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.dQK = i4;
        this.dQM = (this.dQK * 1.0f) / this.dQI;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.dQz = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.dQF = i;
    }

    public void setRectPaintColor(int i) {
        this.dQA = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.dQE = i;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deI = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.dQq = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.dQG = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deH = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dQx = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dQS = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.deM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dQr);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.deK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.deM != null && this.deM.getAdapter() != null && this.deM.getAdapter().getCount() != 0) {
            this.deL.removeAllViews();
            this.deN = this.deM.getAdapter().getCount();
            for (int i = 0; i < this.deN; i++) {
                R(i, this.deM.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.deM.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.dQt = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void wk(String str) {
        if (this.deM != null && this.deM.getAdapter() != null && this.deM.getAdapter().getCount() != 0 && this.dQz && this.dQN != null) {
            this.dQN.setText(str);
        }
    }

    private void R(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dQI);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.dQT != null) {
                        NewPagerSlidingTabBaseStrip.this.dQT.k(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.deM.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.dQS = true;
                        NewPagerSlidingTabBaseStrip.this.deM.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.deL.addView(view, i, this.deQ ? this.deI : this.deH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.deN != 0) {
            int left = this.deL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dQD;
            }
            if (left != this.dfb) {
                this.dfb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.deN != 0) {
            View childAt = this.deL.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQF;
            float right2 = childAt.getRight() - this.dQF;
            if (this.dQs > 0.0f && this.mCurrentTabIndex != this.dQt && this.dQt <= this.deN - 1 && this.dQt >= 0) {
                View childAt2 = this.deL.getChildAt(this.dQt);
                left = d(left, childAt2.getLeft() + this.dQF, this.dQs);
                right2 = e(right2, childAt2.getRight() - this.dQF, this.dQs);
            }
            int height = getHeight();
            if (this.jG == null) {
                this.jG = new RectF(left, (height - this.mIndicatorHeight) - this.dQE, right2, height - this.dQE);
            } else {
                this.jG.set(left, (height - this.mIndicatorHeight) - this.dQE, right2, height - this.dQE);
            }
            canvas.drawRoundRect(this.jG, this.dQH, this.dQH, this.deP);
            if (this.dQx) {
                View childAt3 = this.deL.getChildAt(this.dQy);
                this.dQw.set((childAt3.getRight() - this.dQR) - this.dQP, childAt3.getTop() + this.dQQ, right + this.dQP, top2 + this.dQP);
                canvas.drawOval(this.dQw, this.dQv);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dQG + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dQG + f2) - ((this.dQG * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.dQG + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dQG) + ((this.dQG * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.dQB = R.color.cp_cont_b;
            this.dQC = R.color.cp_cont_j;
        } else {
            this.dQB = R.color.cp_cont_a;
            this.dQC = R.color.cp_cont_a;
        }
        this.deR = am.getColor(this.dQB);
        this.deS = am.getColor(this.dQC);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.deR = am.getColor(this.dQB);
            this.deS = am.getColor(this.dQC);
            this.deP.setColor(am.getColor(this.dQA));
            this.dQv.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQM - 1.0f) / (0.1f - 1.0f))) + this.dQM;
        }
        return (((this.dQM - this.dQL) / 0.1f) * f) + this.dQL;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQM) / (0.1f - 0.9f)));
        }
        return (((this.dQM - this.dQL) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dQs;
        float f2 = this.dQt < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.deN) {
            View childAt = this.deL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dfc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dQt ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.dQt) {
                            textView.setTextColor(this.deR);
                        } else {
                            textView.setTextColor(this.deS);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.deR);
                    } else {
                        textView.setTextColor(this.deS);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dQt) {
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

    /* loaded from: classes8.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (NewPagerSlidingTabBaseStrip.this.deL.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.dQS) {
                    if (i == NewPagerSlidingTabBaseStrip.this.dQu) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dQt = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.dQu) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dQt = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.dQt = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.dQu = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dQt = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.dQs = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.deL.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.deK != null) {
                    NewPagerSlidingTabBaseStrip.this.deK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.deL.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.deM.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.dQs = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.dQS = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.dQu = NewPagerSlidingTabBaseStrip.this.deM.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dQu;
                    NewPagerSlidingTabBaseStrip.this.dQt = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.deK != null) {
                    NewPagerSlidingTabBaseStrip.this.deK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.deK != null) {
                NewPagerSlidingTabBaseStrip.this.deK.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.dQS) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dQs * NewPagerSlidingTabBaseStrip.this.deL.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.dQu = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.dQt = i;
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dQt = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ev = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
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
            /* renamed from: nA */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ev;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ev = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ev);
        }
    }

    public void setConcernTabIndex(int i) {
        this.dQy = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dQB = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.dQC = i;
    }

    public void setIndicatorRadius(int i) {
        this.dQH = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dQT = aVar;
    }
}
