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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF FG;
    private int dXd;
    private int dZG;
    private int dZH;
    private LinearLayout.LayoutParams dZn;
    private LinearLayout.LayoutParams dZo;
    public ViewPager.OnPageChangeListener dZq;
    private LinearLayout dZr;
    private ViewPager dZs;
    private int dZt;
    private Paint dZv;
    private boolean dZw;
    private int dZx;
    private int dividerPadding;
    private int ePA;
    private int ePB;
    private int ePC;
    private int ePD;
    private int ePG;
    private int ePH;
    private float ePJ;
    private float ePK;
    private int ePN;
    private int ePO;
    private int ePP;
    private boolean ePQ;
    private final b ePU;
    private boolean ePV;
    private boolean ePW;
    private a ePX;
    private float ePq;
    private int ePr;
    private int ePs;
    private Paint ePt;
    private RectF ePu;
    private int ePv;
    private int ePy;
    private int ebT;
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
        this.ePU = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.ePq = 0.0f;
        this.ePr = 0;
        this.ePs = 0;
        this.dZw = false;
        this.ePy = R.color.cp_cont_b;
        this.dZx = an.getColor(this.ePy);
        this.dXd = an.getColor(R.color.cp_cont_j);
        this.ePA = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.ebT = 1;
        this.ePG = 17;
        this.ePH = 17;
        this.dZG = 0;
        this.dZH = R.drawable.pager_sliding_view;
        this.ePQ = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.ePC = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dZn = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.ePW = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.ePQ = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dZs = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ePU);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dZq = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dZs != null && this.dZs.getAdapter() != null && this.dZs.getAdapter().getCount() != 0) {
            this.dZr.removeAllViews();
            this.dZt = this.dZs.getAdapter().getCount();
            for (int i = 0; i < this.dZt; i++) {
                ao(i, this.dZs.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dZs.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.ePr = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void ao(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.ePG);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.ePX != null) {
                        PagerSlidingTabBaseStrip.this.ePX.k(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.dZs.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.ePQ = true;
                        PagerSlidingTabBaseStrip.this.dZs.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dZr.addView(view, i, this.dZw ? this.dZo : this.dZn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dZt != 0) {
            int left = this.dZr.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ePA;
            }
            if (left != this.dZG) {
                this.dZG = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dZt != 0) {
            View childAt = this.dZr.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.ePC;
            float right2 = childAt.getRight() - this.ePC;
            if (this.ePq > 0.0f && this.mCurrentTabIndex != this.ePr && this.ePr <= this.dZt - 1 && this.ePr >= 0) {
                View childAt2 = this.dZr.getChildAt(this.ePr);
                left = e(left, childAt2.getLeft() + this.ePC, this.ePq);
                right2 = f(right2, childAt2.getRight() - this.ePC, this.ePq);
            }
            int height = getHeight();
            if (this.FG == null) {
                this.FG = new RectF(left, (height - this.mIndicatorHeight) - this.ePB, right2, height - this.ePB);
            } else {
                this.FG.set(left, (height - this.mIndicatorHeight) - this.ePB, right2, height - this.ePB);
            }
            canvas.drawRoundRect(this.FG, 16.0f, 16.0f, this.dZv);
            if (this.ePW) {
                View childAt3 = this.dZr.getChildAt(this.ePv);
                this.ePu.set((childAt3.getRight() - this.ePP) - this.ePN, childAt3.getTop() + this.ePO, right + this.ePN, top2 + this.ePN);
                canvas.drawOval(this.ePu, this.ePt);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.ePD + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.ePD + f2) - ((this.ePD * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.ePD) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.ePD) + ((this.ePD * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.ePV = z;
        if (!z) {
            this.dZx = an.getColor(this.ePy);
            this.dXd = an.getColor(R.color.cp_cont_j);
        } else {
            this.dZx = an.getColor(R.color.cp_cont_a);
            this.dXd = an.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.ePK - 1.0f) / (0.1f - 1.0f))) + this.ePK;
        }
        return (((this.ePK - this.ePJ) / 0.1f) * f) + this.ePJ;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.ePK) / (0.1f - 0.9f)));
        }
        return (((this.ePK - this.ePJ) / (0.9f - 1.0f)) * (f - 0.9f)) + this.ePK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.ePq;
        float f2 = this.ePr < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dZt) {
            View childAt = this.dZr.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dZH);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.ePr ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (ad <= 1.0f) {
                        textView.setTextColor(this.dXd);
                    } else {
                        textView.setTextColor(this.dZx);
                    }
                    if (ad <= 1.03f) {
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
            if (PagerSlidingTabBaseStrip.this.dZr.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.ePQ) {
                    if (i == PagerSlidingTabBaseStrip.this.ePs) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.ePr = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.ePs) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.ePr = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.ePr = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.ePs = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.ePr = i;
                    }
                    PagerSlidingTabBaseStrip.this.ePq = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dZr.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.dZq != null) {
                    PagerSlidingTabBaseStrip.this.dZq.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.dZr.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.dZs.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.ePq = 0.0f;
                    PagerSlidingTabBaseStrip.this.ePQ = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.ePs = PagerSlidingTabBaseStrip.this.dZs.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.ePs;
                    PagerSlidingTabBaseStrip.this.ePr = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.dZq != null) {
                    PagerSlidingTabBaseStrip.this.dZq.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.dZq != null) {
                PagerSlidingTabBaseStrip.this.dZq.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.ePQ) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.ePq * PagerSlidingTabBaseStrip.this.dZr.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.ePs = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.ePr = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.YJ;
        this.ePr = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.YJ = this.mCurrentTabIndex;
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
            /* renamed from: oT */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int YJ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.YJ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.YJ);
        }
    }

    public void setConcernTabIndex(int i) {
        this.ePv = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.ePy = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ePX = aVar;
    }
}
