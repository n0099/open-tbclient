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
    private RectF GD;
    private int dividerPadding;
    private int dividerWidth;
    private int eDA;
    private Paint eDC;
    private boolean eDD;
    private int eDE;
    private int eDF;
    private int eDM;
    private int eDN;
    private LinearLayout.LayoutParams eDu;
    private LinearLayout.LayoutParams eDv;
    public ViewPager.OnPageChangeListener eDx;
    private LinearLayout eDy;
    private ViewPager eDz;
    private float fvF;
    private int fvG;
    private int fvH;
    private Paint fvI;
    private RectF fvJ;
    private int fvK;
    private int fvN;
    private int fvP;
    private int fvQ;
    private int fvR;
    private int fvS;
    private int fvV;
    private int fvW;
    private float fvY;
    private float fvZ;
    private int fwc;
    private int fwd;
    private int fwe;
    private boolean fwf;
    private final b fwj;
    private boolean fwk;
    private boolean fwl;
    private a fwm;
    private boolean isLoading;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void n(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fwj = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fvF = 0.0f;
        this.fvG = 0;
        this.fvH = 0;
        this.eDD = false;
        this.fvN = R.color.cp_cont_b;
        this.eDE = ap.getColor(this.fvN);
        this.eDF = ap.getColor(R.color.cp_cont_j);
        this.fvP = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fvV = 17;
        this.fvW = 17;
        this.eDM = 0;
        this.eDN = R.drawable.pager_sliding_view;
        this.fwf = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fvR = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eDu = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fwl = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.fwf = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eDz = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fwj);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eDx = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eDz != null && this.eDz.getAdapter() != null && this.eDz.getAdapter().getCount() != 0) {
            this.eDy.removeAllViews();
            this.eDA = this.eDz.getAdapter().getCount();
            for (int i = 0; i < this.eDA; i++) {
                az(i, this.eDz.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.eDz.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fvG = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void az(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.fvV);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fwm != null) {
                        PagerSlidingTabBaseStrip.this.fwm.n(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.eDz.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.fwf = true;
                        PagerSlidingTabBaseStrip.this.eDz.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.eDy.addView(view, i, this.eDD ? this.eDv : this.eDu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eDA != 0) {
            int left = this.eDy.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fvP;
            }
            if (left != this.eDM) {
                this.eDM = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.eDA != 0) {
            View childAt = this.eDy.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fvR;
            float right2 = childAt.getRight() - this.fvR;
            if (this.fvF > 0.0f && this.mCurrentTabIndex != this.fvG && this.fvG <= this.eDA - 1 && this.fvG >= 0) {
                View childAt2 = this.eDy.getChildAt(this.fvG);
                left = e(left, childAt2.getLeft() + this.fvR, this.fvF);
                right2 = f(right2, childAt2.getRight() - this.fvR, this.fvF);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left, (height - this.mIndicatorHeight) - this.fvQ, right2, height - this.fvQ);
            } else {
                this.GD.set(left, (height - this.mIndicatorHeight) - this.fvQ, right2, height - this.fvQ);
            }
            canvas.drawRoundRect(this.GD, 16.0f, 16.0f, this.eDC);
            if (this.fwl) {
                View childAt3 = this.eDy.getChildAt(this.fvK);
                this.fvJ.set((childAt3.getRight() - this.fwe) - this.fwc, childAt3.getTop() + this.fwd, right + this.fwc, top + this.fwc);
                canvas.drawOval(this.fvJ, this.fvI);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fvS + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fvS + f2) - ((this.fvS * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.fvS) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fvS) + ((this.fvS * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fwk = z;
        if (!z) {
            this.eDE = ap.getColor(this.fvN);
            this.eDF = ap.getColor(R.color.cp_cont_j);
        } else {
            this.eDE = ap.getColor(R.color.cp_cont_a);
            this.eDF = ap.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float aj(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fvZ - 1.0f) / (0.1f - 1.0f))) + this.fvZ;
        }
        return (((this.fvZ - this.fvY) / 0.1f) * f) + this.fvY;
    }

    private float ak(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fvZ) / (0.1f - 0.9f)));
        }
        return (((this.fvZ - this.fvY) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fvZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ak;
        float f = this.fvF;
        float f2 = this.fvG < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eDA) {
            View childAt = this.eDy.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eDN);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ak = aj(f2);
                    } else {
                        ak = i == this.fvG ? ak(f2) : 1.0f;
                    }
                    textView.setScaleX(ak);
                    textView.setScaleY(ak);
                    if (ak <= 1.0f) {
                        textView.setTextColor(this.eDF);
                    } else {
                        textView.setTextColor(this.eDE);
                    }
                    if (ak <= 1.03f) {
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
            if (PagerSlidingTabBaseStrip.this.eDy.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.fwf) {
                    if (i == PagerSlidingTabBaseStrip.this.fvH) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fvG = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fvH) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fvG = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fvG = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fvH = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fvG = i;
                    }
                    PagerSlidingTabBaseStrip.this.fvF = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.eDy.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.eDx != null) {
                    PagerSlidingTabBaseStrip.this.eDx.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.eDy.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.eDz.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fvF = 0.0f;
                    PagerSlidingTabBaseStrip.this.fwf = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fvH = PagerSlidingTabBaseStrip.this.eDz.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fvH;
                    PagerSlidingTabBaseStrip.this.fvG = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.eDx != null) {
                    PagerSlidingTabBaseStrip.this.eDx.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.eDx != null) {
                PagerSlidingTabBaseStrip.this.eDx.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.fwf) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fvF * PagerSlidingTabBaseStrip.this.eDy.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fvH = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fvG = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZP;
        this.fvG = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZP = this.mCurrentTabIndex;
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
            /* renamed from: sl */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZP);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fvK = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fvN = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fwm = aVar;
    }
}
