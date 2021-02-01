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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private boolean bqW;
    private int dividerPadding;
    private int dividerWidth;
    private int fYB;
    private int fYC;
    private int fYD;
    private int fYE;
    private int fYH;
    private int fYI;
    private float fYK;
    private float fYL;
    private int fYO;
    private int fYP;
    private int fYQ;
    private final b fYU;
    private boolean fYV;
    private boolean fYW;
    private a fYX;
    private float fYr;
    private int fYs;
    private int fYt;
    private Paint fYu;
    private RectF fYv;
    private int fYw;
    private int fYz;
    private int ffB;
    private LinearLayout.LayoutParams fff;
    private LinearLayout.LayoutParams ffg;
    public ViewPager.OnPageChangeListener ffi;
    private LinearLayout ffj;
    private ViewPager ffk;
    private int ffl;
    private Paint ffn;
    private boolean ffo;
    private int ffp;
    private int ffq;
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
        this.fYU = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fYr = 0.0f;
        this.fYs = 0;
        this.fYt = 0;
        this.ffo = false;
        this.fYz = R.color.CAM_X0105;
        this.ffp = ap.getColor(this.fYz);
        this.ffq = ap.getColor(R.color.CAM_X0107);
        this.fYB = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fYH = 17;
        this.fYI = 17;
        this.ffB = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bqW = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fYD = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fff = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fYW = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.bqW = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ffk = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fYU);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ffi = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ffk != null && this.ffk.getAdapter() != null && this.ffk.getAdapter().getCount() != 0) {
            this.ffj.removeAllViews();
            this.ffl = this.ffk.getAdapter().getCount();
            for (int i = 0; i < this.ffl; i++) {
                aK(i, this.ffk.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.ffk.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fYs = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aK(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.fYH);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fYX != null) {
                        PagerSlidingTabBaseStrip.this.fYX.t(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.ffk.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.bqW = true;
                        PagerSlidingTabBaseStrip.this.ffk.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.ffj.addView(view, i, this.ffo ? this.ffg : this.fff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ffl != 0) {
            int left = this.ffj.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fYB;
            }
            if (left != this.ffB) {
                this.ffB = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.ffl != 0) {
            View childAt = this.ffj.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fYD;
            float right2 = childAt.getRight() - this.fYD;
            if (this.fYr > 0.0f && this.mCurrentTabIndex != this.fYs && this.fYs <= this.ffl - 1 && this.fYs >= 0) {
                View childAt2 = this.ffj.getChildAt(this.fYs);
                left = e(left, childAt2.getLeft() + this.fYD, this.fYr);
                right2 = f(right2, childAt2.getRight() - this.fYD, this.fYr);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left, (height - this.mIndicatorHeight) - this.fYC, right2, height - this.fYC);
            } else {
                this.rectF.set(left, (height - this.mIndicatorHeight) - this.fYC, right2, height - this.fYC);
            }
            canvas.drawRoundRect(this.rectF, 16.0f, 16.0f, this.ffn);
            if (this.fYW) {
                View childAt3 = this.ffj.getChildAt(this.fYw);
                this.fYv.set((childAt3.getRight() - this.fYQ) - this.fYO, childAt3.getTop() + this.fYP, right + this.fYO, top + this.fYO);
                canvas.drawOval(this.fYv, this.fYu);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fYE + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fYE + f2) - ((this.fYE * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.fYE) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fYE) + ((this.fYE * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fYV = z;
        if (!z) {
            this.ffp = ap.getColor(this.fYz);
            this.ffq = ap.getColor(R.color.CAM_X0107);
        } else {
            this.ffp = ap.getColor(R.color.CAM_X0101);
            this.ffq = ap.getColor(R.color.CAM_X0101);
        }
        updateTabStyles();
        invalidate();
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fYL - 1.0f) / (0.1f - 1.0f))) + this.fYL;
        }
        return (((this.fYL - this.fYK) / 0.1f) * f) + this.fYK;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fYL) / (0.1f - 0.9f)));
        }
        return (((this.fYL - this.fYK) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fYL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.fYr;
        float f2 = this.fYs < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.ffl) {
            View childAt = this.ffj.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.fYs ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (au <= 1.0f) {
                        textView.setTextColor(this.ffq);
                    } else {
                        textView.setTextColor(this.ffp);
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

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.ffj.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.bqW) {
                    if (i == PagerSlidingTabBaseStrip.this.fYt) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fYs = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fYt) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fYs = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fYs = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fYt = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fYs = i;
                    }
                    PagerSlidingTabBaseStrip.this.fYr = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.ffj.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.ffi != null) {
                    PagerSlidingTabBaseStrip.this.ffi.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.ffj.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.ffk.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fYr = 0.0f;
                    PagerSlidingTabBaseStrip.this.bqW = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fYt = PagerSlidingTabBaseStrip.this.ffk.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fYt;
                    PagerSlidingTabBaseStrip.this.fYs = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.ffi != null) {
                    PagerSlidingTabBaseStrip.this.ffi.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.ffi != null) {
                PagerSlidingTabBaseStrip.this.ffi.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.bqW) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fYr * PagerSlidingTabBaseStrip.this.ffj.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fYt = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fYs = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.abv;
        this.fYs = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abv = this.mCurrentTabIndex;
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
            /* renamed from: sr */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abv;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abv = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abv);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fYw = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fYz = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fYX = aVar;
    }
}
