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
    private boolean bsw;
    private int dividerPadding;
    private int dividerWidth;
    private float fZR;
    private int fZS;
    private int fZT;
    private Paint fZU;
    private RectF fZV;
    private int fZW;
    private int fZZ;
    private LinearLayout.LayoutParams fgE;
    private LinearLayout.LayoutParams fgF;
    public ViewPager.OnPageChangeListener fgH;
    private LinearLayout fgI;
    private ViewPager fgJ;
    private int fgK;
    private Paint fgM;
    private boolean fgN;
    private int fgO;
    private int fgP;
    private int fha;
    private int gab;
    private int gac;
    private int gad;
    private int gae;
    private int gah;
    private int gai;
    private float gak;
    private float gal;
    private int gao;
    private int gaq;
    private int gar;
    private final b gav;
    private boolean gaw;
    private boolean gax;
    private a gay;
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
        this.gav = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fZR = 0.0f;
        this.fZS = 0;
        this.fZT = 0;
        this.fgN = false;
        this.fZZ = R.color.CAM_X0105;
        this.fgO = ap.getColor(this.fZZ);
        this.fgP = ap.getColor(R.color.CAM_X0107);
        this.gab = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.gah = 17;
        this.gai = 17;
        this.fha = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bsw = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.gad = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fgE = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.gax = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.bsw = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fgJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gav);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fgH = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fgJ != null && this.fgJ.getAdapter() != null && this.fgJ.getAdapter().getCount() != 0) {
            this.fgI.removeAllViews();
            this.fgK = this.fgJ.getAdapter().getCount();
            for (int i = 0; i < this.fgK; i++) {
                aK(i, this.fgJ.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fgJ.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fZS = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.gah);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.gay != null) {
                        PagerSlidingTabBaseStrip.this.gay.t(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.fgJ.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.bsw = true;
                        PagerSlidingTabBaseStrip.this.fgJ.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.fgI.addView(view, i, this.fgN ? this.fgF : this.fgE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fgK != 0) {
            int left = this.fgI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.gab;
            }
            if (left != this.fha) {
                this.fha = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.fgK != 0) {
            View childAt = this.fgI.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.gad;
            float right2 = childAt.getRight() - this.gad;
            if (this.fZR > 0.0f && this.mCurrentTabIndex != this.fZS && this.fZS <= this.fgK - 1 && this.fZS >= 0) {
                View childAt2 = this.fgI.getChildAt(this.fZS);
                left = e(left, childAt2.getLeft() + this.gad, this.fZR);
                right2 = f(right2, childAt2.getRight() - this.gad, this.fZR);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left, (height - this.mIndicatorHeight) - this.gac, right2, height - this.gac);
            } else {
                this.rectF.set(left, (height - this.mIndicatorHeight) - this.gac, right2, height - this.gac);
            }
            canvas.drawRoundRect(this.rectF, 16.0f, 16.0f, this.fgM);
            if (this.gax) {
                View childAt3 = this.fgI.getChildAt(this.fZW);
                this.fZV.set((childAt3.getRight() - this.gar) - this.gao, childAt3.getTop() + this.gaq, right + this.gao, top + this.gao);
                canvas.drawOval(this.fZV, this.fZU);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.gae + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.gae + f2) - ((this.gae * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.gae) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.gae) + ((this.gae * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.gaw = z;
        if (!z) {
            this.fgO = ap.getColor(this.fZZ);
            this.fgP = ap.getColor(R.color.CAM_X0107);
        } else {
            this.fgO = ap.getColor(R.color.CAM_X0101);
            this.fgP = ap.getColor(R.color.CAM_X0101);
        }
        updateTabStyles();
        invalidate();
    }

    private float ax(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.gal - 1.0f) / (0.1f - 1.0f))) + this.gal;
        }
        return (((this.gal - this.gak) / 0.1f) * f) + this.gak;
    }

    private float ay(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.gal) / (0.1f - 0.9f)));
        }
        return (((this.gal - this.gak) / (0.9f - 1.0f)) * (f - 0.9f)) + this.gal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ay;
        float f = this.fZR;
        float f2 = this.fZS < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.fgK) {
            View childAt = this.fgI.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ay = ax(f2);
                    } else {
                        ay = i == this.fZS ? ay(f2) : 1.0f;
                    }
                    textView.setScaleX(ay);
                    textView.setScaleY(ay);
                    if (ay <= 1.0f) {
                        textView.setTextColor(this.fgP);
                    } else {
                        textView.setTextColor(this.fgO);
                    }
                    if (ay <= 1.03f) {
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
            if (PagerSlidingTabBaseStrip.this.fgI.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.bsw) {
                    if (i == PagerSlidingTabBaseStrip.this.fZT) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fZS = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fZT) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fZS = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fZS = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fZT = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fZS = i;
                    }
                    PagerSlidingTabBaseStrip.this.fZR = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fgI.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.fgH != null) {
                    PagerSlidingTabBaseStrip.this.fgH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.fgI.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.fgJ.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fZR = 0.0f;
                    PagerSlidingTabBaseStrip.this.bsw = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fZT = PagerSlidingTabBaseStrip.this.fgJ.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fZT;
                    PagerSlidingTabBaseStrip.this.fZS = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.fgH != null) {
                    PagerSlidingTabBaseStrip.this.fgH.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.fgH != null) {
                PagerSlidingTabBaseStrip.this.fgH.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.bsw) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fZR * PagerSlidingTabBaseStrip.this.fgI.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fZT = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fZS = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.acR;
        this.fZS = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.acR = this.mCurrentTabIndex;
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
            /* renamed from: st */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int acR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.acR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.acR);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fZW = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fZZ = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gay = aVar;
    }
}
