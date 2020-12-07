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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF Hx;
    private boolean bqt;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams eXY;
    private LinearLayout.LayoutParams eXZ;
    public ViewPager.OnPageChangeListener eYb;
    private LinearLayout eYc;
    private ViewPager eYd;
    private int eYe;
    private Paint eYg;
    private boolean eYh;
    private int eYi;
    private int eYj;
    private int eYs;
    private int eYt;
    private int fRC;
    private int fRD;
    private int fRE;
    private final b fRI;
    private boolean fRJ;
    private boolean fRK;
    private a fRL;
    private float fRf;
    private int fRg;
    private int fRh;
    private Paint fRi;
    private RectF fRj;
    private int fRk;
    private int fRn;
    private int fRp;
    private int fRq;
    private int fRr;
    private int fRs;
    private int fRv;
    private int fRw;
    private float fRy;
    private float fRz;
    private boolean isLoading;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void q(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRI = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fRf = 0.0f;
        this.fRg = 0;
        this.fRh = 0;
        this.eYh = false;
        this.fRn = R.color.CAM_X0105;
        this.eYi = ap.getColor(this.fRn);
        this.eYj = ap.getColor(R.color.CAM_X0107);
        this.fRp = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fRv = 17;
        this.fRw = 17;
        this.eYs = 0;
        this.eYt = R.drawable.pager_sliding_view;
        this.bqt = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fRr = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eXY = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fRK = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.bqt = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eYd = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fRI);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eYb = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eYd != null && this.eYd.getAdapter() != null && this.eYd.getAdapter().getCount() != 0) {
            this.eYc.removeAllViews();
            this.eYe = this.eYd.getAdapter().getCount();
            for (int i = 0; i < this.eYe; i++) {
                aD(i, this.eYd.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.eYd.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fRg = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aD(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.fRv);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fRL != null) {
                        PagerSlidingTabBaseStrip.this.fRL.q(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.eYd.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.bqt = true;
                        PagerSlidingTabBaseStrip.this.eYd.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.eYc.addView(view, i, this.eYh ? this.eXZ : this.eXY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eYe != 0) {
            int left = this.eYc.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fRp;
            }
            if (left != this.eYs) {
                this.eYs = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.eYe != 0) {
            View childAt = this.eYc.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fRr;
            float right2 = childAt.getRight() - this.fRr;
            if (this.fRf > 0.0f && this.mCurrentTabIndex != this.fRg && this.fRg <= this.eYe - 1 && this.fRg >= 0) {
                View childAt2 = this.eYc.getChildAt(this.fRg);
                left = e(left, childAt2.getLeft() + this.fRr, this.fRf);
                right2 = f(right2, childAt2.getRight() - this.fRr, this.fRf);
            }
            int height = getHeight();
            if (this.Hx == null) {
                this.Hx = new RectF(left, (height - this.mIndicatorHeight) - this.fRq, right2, height - this.fRq);
            } else {
                this.Hx.set(left, (height - this.mIndicatorHeight) - this.fRq, right2, height - this.fRq);
            }
            canvas.drawRoundRect(this.Hx, 16.0f, 16.0f, this.eYg);
            if (this.fRK) {
                View childAt3 = this.eYc.getChildAt(this.fRk);
                this.fRj.set((childAt3.getRight() - this.fRE) - this.fRC, childAt3.getTop() + this.fRD, right + this.fRC, top + this.fRC);
                canvas.drawOval(this.fRj, this.fRi);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fRs + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fRs + f2) - ((this.fRs * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.fRs) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fRs) + ((this.fRs * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fRJ = z;
        if (!z) {
            this.eYi = ap.getColor(this.fRn);
            this.eYj = ap.getColor(R.color.CAM_X0107);
        } else {
            this.eYi = ap.getColor(R.color.CAM_X0101);
            this.eYj = ap.getColor(R.color.CAM_X0101);
        }
        updateTabStyles();
        invalidate();
    }

    private float aq(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fRz - 1.0f) / (0.1f - 1.0f))) + this.fRz;
        }
        return (((this.fRz - this.fRy) / 0.1f) * f) + this.fRy;
    }

    private float ar(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fRz) / (0.1f - 0.9f)));
        }
        return (((this.fRz - this.fRy) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fRz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ar;
        float f = this.fRf;
        float f2 = this.fRg < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eYe) {
            View childAt = this.eYc.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eYt);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ar = aq(f2);
                    } else {
                        ar = i == this.fRg ? ar(f2) : 1.0f;
                    }
                    textView.setScaleX(ar);
                    textView.setScaleY(ar);
                    if (ar <= 1.0f) {
                        textView.setTextColor(this.eYj);
                    } else {
                        textView.setTextColor(this.eYi);
                    }
                    if (ar <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes21.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.eYc.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.bqt) {
                    if (i == PagerSlidingTabBaseStrip.this.fRh) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fRg = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fRh) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fRg = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fRg = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fRh = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fRg = i;
                    }
                    PagerSlidingTabBaseStrip.this.fRf = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.eYc.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.eYb != null) {
                    PagerSlidingTabBaseStrip.this.eYb.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.eYc.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.eYd.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fRf = 0.0f;
                    PagerSlidingTabBaseStrip.this.bqt = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fRh = PagerSlidingTabBaseStrip.this.eYd.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fRh;
                    PagerSlidingTabBaseStrip.this.fRg = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.eYb != null) {
                    PagerSlidingTabBaseStrip.this.eYb.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.eYb != null) {
                PagerSlidingTabBaseStrip.this.eYb.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.bqt) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fRf * PagerSlidingTabBaseStrip.this.eYc.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fRh = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fRg = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.aaR;
        this.fRg = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aaR = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: U */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: tH */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aaR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aaR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aaR);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fRk = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fRn = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fRL = aVar;
    }
}
