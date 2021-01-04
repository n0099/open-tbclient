package com.baidu.tbadk.widget.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private boolean bsh;
    private int dividerPadding;
    private int dividerWidth;
    public ViewPager.OnPageChangeListener fhB;
    private LinearLayout fhC;
    private ViewPager fhD;
    private int fhE;
    private Paint fhG;
    private boolean fhH;
    private int fhI;
    private int fhJ;
    private int fhU;
    private LinearLayout.LayoutParams fhy;
    private LinearLayout.LayoutParams fhz;
    private float gaJ;
    private int gaK;
    private int gaL;
    private Paint gaM;
    private RectF gaN;
    private int gaO;
    private int gaR;
    private int gaT;
    private int gaU;
    private int gaV;
    private int gaW;
    private int gaZ;
    private int gba;
    private float gbc;
    private float gbd;
    private int gbg;
    private int gbh;
    private int gbi;
    private final b gbm;
    private boolean gbn;
    private boolean gbo;
    private a gbp;
    private boolean isLoading;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;
    private RectF rectF;
    private int tabBackgroundResId;

    /* loaded from: classes.dex */
    public interface a {
        void t(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbm = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.gaJ = 0.0f;
        this.gaK = 0;
        this.gaL = 0;
        this.fhH = false;
        this.gaR = R.color.CAM_X0105;
        this.fhI = ao.getColor(this.gaR);
        this.fhJ = ao.getColor(R.color.CAM_X0107);
        this.gaT = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.gaZ = 17;
        this.gba = 17;
        this.fhU = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bsh = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.gaV = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fhy = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.gbo = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.bsh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fhD = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gbm);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fhB = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fhD != null && this.fhD.getAdapter() != null && this.fhD.getAdapter().getCount() != 0) {
            this.fhC.removeAllViews();
            this.fhE = this.fhD.getAdapter().getCount();
            for (int i = 0; i < this.fhE; i++) {
                aF(i, this.fhD.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fhD.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.gaK = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aF(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.gaZ);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.gbp != null) {
                        PagerSlidingTabBaseStrip.this.gbp.t(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.fhD.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.bsh = true;
                        PagerSlidingTabBaseStrip.this.fhD.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.fhC.addView(view, i, this.fhH ? this.fhz : this.fhy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fhE != 0) {
            int left = this.fhC.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.gaT;
            }
            if (left != this.fhU) {
                this.fhU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.fhE != 0) {
            View childAt = this.fhC.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.gaV;
            float right2 = childAt.getRight() - this.gaV;
            if (this.gaJ > 0.0f && this.mCurrentTabIndex != this.gaK && this.gaK <= this.fhE - 1 && this.gaK >= 0) {
                View childAt2 = this.fhC.getChildAt(this.gaK);
                left = e(left, childAt2.getLeft() + this.gaV, this.gaJ);
                right2 = f(right2, childAt2.getRight() - this.gaV, this.gaJ);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left, (height - this.mIndicatorHeight) - this.gaU, right2, height - this.gaU);
            } else {
                this.rectF.set(left, (height - this.mIndicatorHeight) - this.gaU, right2, height - this.gaU);
            }
            canvas.drawRoundRect(this.rectF, 16.0f, 16.0f, this.fhG);
            if (this.gbo) {
                View childAt3 = this.fhC.getChildAt(this.gaO);
                this.gaN.set((childAt3.getRight() - this.gbi) - this.gbg, childAt3.getTop() + this.gbh, right + this.gbg, top + this.gbg);
                canvas.drawOval(this.gaN, this.gaM);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.gaW + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.gaW + f2) - ((this.gaW * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.gaW) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.gaW) + ((this.gaW * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.gbn = z;
        if (!z) {
            this.fhI = ao.getColor(this.gaR);
            this.fhJ = ao.getColor(R.color.CAM_X0107);
        } else {
            this.fhI = ao.getColor(R.color.CAM_X0101);
            this.fhJ = ao.getColor(R.color.CAM_X0101);
        }
        updateTabStyles();
        invalidate();
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.gbd - 1.0f) / (0.1f - 1.0f))) + this.gbd;
        }
        return (((this.gbd - this.gbc) / 0.1f) * f) + this.gbc;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.gbd) / (0.1f - 0.9f)));
        }
        return (((this.gbd - this.gbc) / (0.9f - 1.0f)) * (f - 0.9f)) + this.gbd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.gaJ;
        float f2 = this.gaK < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.fhE) {
            View childAt = this.fhC.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.gaK ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (at <= 1.0f) {
                        textView.setTextColor(this.fhJ);
                    } else {
                        textView.setTextColor(this.fhI);
                    }
                    if (at <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.fhC.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.bsh) {
                    if (i == PagerSlidingTabBaseStrip.this.gaL) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.gaK = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.gaL) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.gaK = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.gaK = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.gaL = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.gaK = i;
                    }
                    PagerSlidingTabBaseStrip.this.gaJ = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fhC.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.fhB != null) {
                    PagerSlidingTabBaseStrip.this.fhB.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.fhC.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.fhD.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.gaJ = 0.0f;
                    PagerSlidingTabBaseStrip.this.bsh = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.gaL = PagerSlidingTabBaseStrip.this.fhD.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.gaL;
                    PagerSlidingTabBaseStrip.this.gaK = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.fhB != null) {
                    PagerSlidingTabBaseStrip.this.fhB.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.fhB != null) {
                PagerSlidingTabBaseStrip.this.fhB.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.bsh) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.gaJ * PagerSlidingTabBaseStrip.this.fhC.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.gaL = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.gaK = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.abC;
        this.gaK = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abC = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: V */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: tS */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abC;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abC = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abC);
        }
    }

    public void setConcernTabIndex(int i) {
        this.gaO = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.gaR = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gbp = aVar;
    }
}
