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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF FG;
    private int dividerPadding;
    private int dividerWidth;
    private float eVL;
    private int eVM;
    private int eVN;
    private Paint eVO;
    private RectF eVP;
    private int eVQ;
    private int eVT;
    private int eVV;
    private int eVW;
    private int eVX;
    private int eVY;
    private int eWb;
    private int eWc;
    private float eWe;
    private float eWf;
    private int eWi;
    private int eWj;
    private int eWk;
    private boolean eWl;
    private final b eWp;
    private boolean eWq;
    private boolean eWr;
    private a eWs;
    private int edx;
    private LinearLayout.LayoutParams efA;
    private LinearLayout.LayoutParams efB;
    public ViewPager.OnPageChangeListener efD;
    private LinearLayout efE;
    private ViewPager efF;
    private int efG;
    private Paint efI;
    private boolean efJ;
    private int efK;
    private int efR;
    private int efS;
    private boolean isLoading;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes15.dex */
    public interface a {
        void l(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWp = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eVL = 0.0f;
        this.eVM = 0;
        this.eVN = 0;
        this.efJ = false;
        this.eVT = R.color.cp_cont_b;
        this.efK = ao.getColor(this.eVT);
        this.edx = ao.getColor(R.color.cp_cont_j);
        this.eVV = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.eWb = 17;
        this.eWc = 17;
        this.efR = 0;
        this.efS = R.drawable.pager_sliding_view;
        this.eWl = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.eVX = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.efA = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.eWr = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.eWl = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.efF = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eWp);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.efD = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.efF != null && this.efF.getAdapter() != null && this.efF.getAdapter().getCount() != 0) {
            this.efE.removeAllViews();
            this.efG = this.efF.getAdapter().getCount();
            for (int i = 0; i < this.efG; i++) {
                ap(i, this.efF.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.efF.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.eVM = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void ap(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.eWb);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.eWs != null) {
                        PagerSlidingTabBaseStrip.this.eWs.l(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.efF.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.eWl = true;
                        PagerSlidingTabBaseStrip.this.efF.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.efE.addView(view, i, this.efJ ? this.efB : this.efA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.efG != 0) {
            int left = this.efE.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eVV;
            }
            if (left != this.efR) {
                this.efR = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.efG != 0) {
            View childAt = this.efE.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.eVX;
            float right2 = childAt.getRight() - this.eVX;
            if (this.eVL > 0.0f && this.mCurrentTabIndex != this.eVM && this.eVM <= this.efG - 1 && this.eVM >= 0) {
                View childAt2 = this.efE.getChildAt(this.eVM);
                left = e(left, childAt2.getLeft() + this.eVX, this.eVL);
                right2 = f(right2, childAt2.getRight() - this.eVX, this.eVL);
            }
            int height = getHeight();
            if (this.FG == null) {
                this.FG = new RectF(left, (height - this.mIndicatorHeight) - this.eVW, right2, height - this.eVW);
            } else {
                this.FG.set(left, (height - this.mIndicatorHeight) - this.eVW, right2, height - this.eVW);
            }
            canvas.drawRoundRect(this.FG, 16.0f, 16.0f, this.efI);
            if (this.eWr) {
                View childAt3 = this.efE.getChildAt(this.eVQ);
                this.eVP.set((childAt3.getRight() - this.eWk) - this.eWi, childAt3.getTop() + this.eWj, right + this.eWi, top + this.eWi);
                canvas.drawOval(this.eVP, this.eVO);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.eVY + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.eVY + f2) - ((this.eVY * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.eVY) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.eVY) + ((this.eVY * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.eWq = z;
        if (!z) {
            this.efK = ao.getColor(this.eVT);
            this.edx = ao.getColor(R.color.cp_cont_j);
        } else {
            this.efK = ao.getColor(R.color.cp_cont_a);
            this.edx = ao.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eWf - 1.0f) / (0.1f - 1.0f))) + this.eWf;
        }
        return (((this.eWf - this.eWe) / 0.1f) * f) + this.eWe;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eWf) / (0.1f - 0.9f)));
        }
        return (((this.eWf - this.eWe) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eWf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.eVL;
        float f2 = this.eVM < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.efG) {
            View childAt = this.efE.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.efS);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.eVM ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (ad <= 1.0f) {
                        textView.setTextColor(this.edx);
                    } else {
                        textView.setTextColor(this.efK);
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

    /* loaded from: classes15.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.efE.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.eWl) {
                    if (i == PagerSlidingTabBaseStrip.this.eVN) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eVM = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.eVN) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eVM = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.eVM = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.eVN = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eVM = i;
                    }
                    PagerSlidingTabBaseStrip.this.eVL = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.efE.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.efD != null) {
                    PagerSlidingTabBaseStrip.this.efD.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.efE.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.efF.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.eVL = 0.0f;
                    PagerSlidingTabBaseStrip.this.eWl = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.eVN = PagerSlidingTabBaseStrip.this.efF.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.eVN;
                    PagerSlidingTabBaseStrip.this.eVM = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.efD != null) {
                    PagerSlidingTabBaseStrip.this.efD.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.efD != null) {
                PagerSlidingTabBaseStrip.this.efD.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.eWl) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.eVL * PagerSlidingTabBaseStrip.this.efE.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.eVN = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.eVM = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Yz;
        this.eVM = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yz = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: T */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pk */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yz;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yz = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yz);
        }
    }

    public void setConcernTabIndex(int i) {
        this.eVQ = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.eVT = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eWs = aVar;
    }
}
