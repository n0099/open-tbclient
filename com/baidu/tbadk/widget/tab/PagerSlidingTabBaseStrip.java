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
    private LinearLayout.LayoutParams eLQ;
    private LinearLayout.LayoutParams eLR;
    public ViewPager.OnPageChangeListener eLT;
    private LinearLayout eLU;
    private ViewPager eLV;
    private int eLW;
    private Paint eLY;
    private boolean eLZ;
    private int eMa;
    private int eMb;
    private int eMi;
    private int eMj;
    private boolean fEA;
    private final b fEE;
    private boolean fEF;
    private boolean fEG;
    private a fEH;
    private float fEa;
    private int fEb;
    private int fEc;
    private Paint fEd;
    private RectF fEe;
    private int fEf;
    private int fEi;
    private int fEk;
    private int fEl;
    private int fEm;
    private int fEn;
    private int fEq;
    private int fEr;
    private float fEt;
    private float fEu;
    private int fEx;
    private int fEy;
    private int fEz;
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
        this.fEE = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fEa = 0.0f;
        this.fEb = 0;
        this.fEc = 0;
        this.eLZ = false;
        this.fEi = R.color.cp_cont_b;
        this.eMa = ap.getColor(this.fEi);
        this.eMb = ap.getColor(R.color.cp_cont_j);
        this.fEk = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fEq = 17;
        this.fEr = 17;
        this.eMi = 0;
        this.eMj = R.drawable.pager_sliding_view;
        this.fEA = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fEm = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eLQ = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fEG = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.fEA = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eLV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fEE);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eLT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eLV != null && this.eLV.getAdapter() != null && this.eLV.getAdapter().getCount() != 0) {
            this.eLU.removeAllViews();
            this.eLW = this.eLV.getAdapter().getCount();
            for (int i = 0; i < this.eLW; i++) {
                aB(i, this.eLV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.eLV.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fEb = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aB(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.fEq);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fEH != null) {
                        PagerSlidingTabBaseStrip.this.fEH.n(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.eLV.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.fEA = true;
                        PagerSlidingTabBaseStrip.this.eLV.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.eLU.addView(view, i, this.eLZ ? this.eLR : this.eLQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eLW != 0) {
            int left = this.eLU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fEk;
            }
            if (left != this.eMi) {
                this.eMi = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.eLW != 0) {
            View childAt = this.eLU.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fEm;
            float right2 = childAt.getRight() - this.fEm;
            if (this.fEa > 0.0f && this.mCurrentTabIndex != this.fEb && this.fEb <= this.eLW - 1 && this.fEb >= 0) {
                View childAt2 = this.eLU.getChildAt(this.fEb);
                left = e(left, childAt2.getLeft() + this.fEm, this.fEa);
                right2 = f(right2, childAt2.getRight() - this.fEm, this.fEa);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left, (height - this.mIndicatorHeight) - this.fEl, right2, height - this.fEl);
            } else {
                this.GD.set(left, (height - this.mIndicatorHeight) - this.fEl, right2, height - this.fEl);
            }
            canvas.drawRoundRect(this.GD, 16.0f, 16.0f, this.eLY);
            if (this.fEG) {
                View childAt3 = this.eLU.getChildAt(this.fEf);
                this.fEe.set((childAt3.getRight() - this.fEz) - this.fEx, childAt3.getTop() + this.fEy, right + this.fEx, top + this.fEx);
                canvas.drawOval(this.fEe, this.fEd);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fEn + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fEn + f2) - ((this.fEn * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.fEn) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fEn) + ((this.fEn * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fEF = z;
        if (!z) {
            this.eMa = ap.getColor(this.fEi);
            this.eMb = ap.getColor(R.color.cp_cont_j);
        } else {
            this.eMa = ap.getColor(R.color.cp_cont_a);
            this.eMb = ap.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float al(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fEu - 1.0f) / (0.1f - 1.0f))) + this.fEu;
        }
        return (((this.fEu - this.fEt) / 0.1f) * f) + this.fEt;
    }

    private float am(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fEu) / (0.1f - 0.9f)));
        }
        return (((this.fEu - this.fEt) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fEu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float am;
        float f = this.fEa;
        float f2 = this.fEb < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eLW) {
            View childAt = this.eLU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eMj);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        am = al(f2);
                    } else {
                        am = i == this.fEb ? am(f2) : 1.0f;
                    }
                    textView.setScaleX(am);
                    textView.setScaleY(am);
                    if (am <= 1.0f) {
                        textView.setTextColor(this.eMb);
                    } else {
                        textView.setTextColor(this.eMa);
                    }
                    if (am <= 1.03f) {
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
            if (PagerSlidingTabBaseStrip.this.eLU.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.fEA) {
                    if (i == PagerSlidingTabBaseStrip.this.fEc) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fEb = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fEc) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fEb = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fEb = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fEc = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fEb = i;
                    }
                    PagerSlidingTabBaseStrip.this.fEa = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.eLU.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.eLT != null) {
                    PagerSlidingTabBaseStrip.this.eLT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.eLU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.eLV.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fEa = 0.0f;
                    PagerSlidingTabBaseStrip.this.fEA = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fEc = PagerSlidingTabBaseStrip.this.eLV.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fEc;
                    PagerSlidingTabBaseStrip.this.fEb = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.eLT != null) {
                    PagerSlidingTabBaseStrip.this.eLT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.eLT != null) {
                PagerSlidingTabBaseStrip.this.eLT.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.fEA) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fEa * PagerSlidingTabBaseStrip.this.eLU.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fEc = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fEb = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZQ;
        this.fEb = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZQ = this.mCurrentTabIndex;
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
            /* renamed from: sw */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZQ);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fEf = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fEi = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fEH = aVar;
    }
}
