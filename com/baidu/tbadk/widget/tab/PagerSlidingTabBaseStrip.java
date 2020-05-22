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
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF Fg;
    private int dQl;
    private ViewPager dSA;
    private int dSB;
    private Paint dSD;
    private boolean dSE;
    private int dSF;
    private int dSO;
    private int dSP;
    private LinearLayout.LayoutParams dSv;
    private LinearLayout.LayoutParams dSw;
    public ViewPager.OnPageChangeListener dSy;
    private LinearLayout dSz;
    private int dUE;
    private int dividerPadding;
    private float eET;
    private int eEU;
    private int eEV;
    private Paint eEW;
    private RectF eEX;
    private int eEY;
    private a eFA;
    private int eFb;
    private int eFd;
    private int eFe;
    private int eFf;
    private int eFg;
    private int eFj;
    private int eFk;
    private float eFm;
    private float eFn;
    private int eFq;
    private int eFr;
    private int eFs;
    private boolean eFt;
    private final b eFx;
    private boolean eFy;
    private boolean eFz;
    private boolean isLoading;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void k(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFx = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eET = 0.0f;
        this.eEU = 0;
        this.eEV = 0;
        this.dSE = false;
        this.eFb = R.color.cp_cont_b;
        this.dSF = am.getColor(this.eFb);
        this.dQl = am.getColor(R.color.cp_cont_j);
        this.eFd = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dUE = 1;
        this.eFj = 17;
        this.eFk = 17;
        this.dSO = 0;
        this.dSP = R.drawable.pager_sliding_view;
        this.eFt = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.eFf = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dSv = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.eFz = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.eFt = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dSA = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eFx);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dSy = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dSA != null && this.dSA.getAdapter() != null && this.dSA.getAdapter().getCount() != 0) {
            this.dSz.removeAllViews();
            this.dSB = this.dSA.getAdapter().getCount();
            for (int i = 0; i < this.dSB; i++) {
                an(i, this.dSA.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dSA.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.eEU = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void an(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.eFj);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.eFA != null) {
                        PagerSlidingTabBaseStrip.this.eFA.k(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.dSA.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.eFt = true;
                        PagerSlidingTabBaseStrip.this.dSA.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dSz.addView(view, i, this.dSE ? this.dSw : this.dSv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dSB != 0) {
            int left = this.dSz.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eFd;
            }
            if (left != this.dSO) {
                this.dSO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dSB != 0) {
            View childAt = this.dSz.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.eFf;
            float right2 = childAt.getRight() - this.eFf;
            if (this.eET > 0.0f && this.mCurrentTabIndex != this.eEU && this.eEU <= this.dSB - 1 && this.eEU >= 0) {
                View childAt2 = this.dSz.getChildAt(this.eEU);
                left = e(left, childAt2.getLeft() + this.eFf, this.eET);
                right2 = f(right2, childAt2.getRight() - this.eFf, this.eET);
            }
            int height = getHeight();
            if (this.Fg == null) {
                this.Fg = new RectF(left, (height - this.mIndicatorHeight) - this.eFe, right2, height - this.eFe);
            } else {
                this.Fg.set(left, (height - this.mIndicatorHeight) - this.eFe, right2, height - this.eFe);
            }
            canvas.drawRoundRect(this.Fg, 16.0f, 16.0f, this.dSD);
            if (this.eFz) {
                View childAt3 = this.dSz.getChildAt(this.eEY);
                this.eEX.set((childAt3.getRight() - this.eFs) - this.eFq, childAt3.getTop() + this.eFr, right + this.eFq, top2 + this.eFq);
                canvas.drawOval(this.eEX, this.eEW);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.eFg + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.eFg + f2) - ((this.eFg * (f3 - 0.85f)) / 0.15f);
        } else {
            return f;
        }
    }

    private float f(float f, float f2, float f3) {
        if (f2 > f) {
            if (f3 <= 0.5d) {
                return f + (((f2 - f) * f3) / 0.5f);
            }
            return f2;
        } else if (f3 >= 0.5d) {
            return f;
        } else {
            if (f3 >= 0.15d) {
                return f - ((((f - this.eFg) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.eFg) + ((this.eFg * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.eFy = z;
        if (!z) {
            this.dSF = am.getColor(this.eFb);
            this.dQl = am.getColor(R.color.cp_cont_j);
        } else {
            this.dSF = am.getColor(R.color.cp_cont_a);
            this.dQl = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float aa(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eFn - 1.0f) / (0.1f - 1.0f))) + this.eFn;
        }
        return (((this.eFn - this.eFm) / 0.1f) * f) + this.eFm;
    }

    private float ab(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eFn) / (0.1f - 0.9f)));
        }
        return (((this.eFn - this.eFm) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eFn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ab;
        float f = this.eET;
        float f2 = this.eEU < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dSB) {
            View childAt = this.dSz.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dSP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ab = aa(f2);
                    } else {
                        ab = i == this.eEU ? ab(f2) : 1.0f;
                    }
                    textView.setScaleX(ab);
                    textView.setScaleY(ab);
                    if (ab <= 1.0f) {
                        textView.setTextColor(this.dQl);
                    } else {
                        textView.setTextColor(this.dSF);
                    }
                    if (ab <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
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
            if (PagerSlidingTabBaseStrip.this.dSz.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.eFt) {
                    if (i == PagerSlidingTabBaseStrip.this.eEV) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eEU = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.eEV) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eEU = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.eEU = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.eEV = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eEU = i;
                    }
                    PagerSlidingTabBaseStrip.this.eET = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dSz.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.dSy != null) {
                    PagerSlidingTabBaseStrip.this.dSy.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.dSz.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.dSA.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.eET = 0.0f;
                    PagerSlidingTabBaseStrip.this.eFt = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.eEV = PagerSlidingTabBaseStrip.this.dSA.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.eEV;
                    PagerSlidingTabBaseStrip.this.eEU = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.dSy != null) {
                    PagerSlidingTabBaseStrip.this.dSy.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.dSy != null) {
                PagerSlidingTabBaseStrip.this.dSy.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.eFt) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.eET * PagerSlidingTabBaseStrip.this.dSz.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.eEV = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.eEU = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Yf;
        this.eEU = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yf = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: R */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ot */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yf);
        }
    }

    public void setConcernTabIndex(int i) {
        this.eEY = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.eFb = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eFA = aVar;
    }
}
