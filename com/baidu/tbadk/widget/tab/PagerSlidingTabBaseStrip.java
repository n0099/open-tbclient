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
    private LinearLayout.LayoutParams eRF;
    private LinearLayout.LayoutParams eRG;
    public ViewPager.OnPageChangeListener eRI;
    private LinearLayout eRJ;
    private ViewPager eRK;
    private int eRL;
    private Paint eRN;
    private boolean eRO;
    private int eRP;
    private int eRQ;
    private int eRX;
    private int eRY;
    private float fJQ;
    private int fJR;
    private int fJS;
    private Paint fJT;
    private RectF fJU;
    private int fJV;
    private int fJY;
    private int fKa;
    private int fKb;
    private int fKc;
    private int fKd;
    private int fKg;
    private int fKh;
    private float fKj;
    private float fKk;
    private int fKn;
    private int fKo;
    private int fKp;
    private boolean fKq;
    private final b fKu;
    private boolean fKv;
    private boolean fKw;
    private a fKx;
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
        this.fKu = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fJQ = 0.0f;
        this.fJR = 0;
        this.fJS = 0;
        this.eRO = false;
        this.fJY = R.color.cp_cont_b;
        this.eRP = ap.getColor(this.fJY);
        this.eRQ = ap.getColor(R.color.cp_cont_j);
        this.fKa = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fKg = 17;
        this.fKh = 17;
        this.eRX = 0;
        this.eRY = R.drawable.pager_sliding_view;
        this.fKq = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fKc = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eRF = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fKw = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.fKq = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eRK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fKu);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eRI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eRK != null && this.eRK.getAdapter() != null && this.eRK.getAdapter().getCount() != 0) {
            this.eRJ.removeAllViews();
            this.eRL = this.eRK.getAdapter().getCount();
            for (int i = 0; i < this.eRL; i++) {
                aF(i, this.eRK.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.eRK.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fJR = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.fKg);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fKx != null) {
                        PagerSlidingTabBaseStrip.this.fKx.n(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.eRK.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.fKq = true;
                        PagerSlidingTabBaseStrip.this.eRK.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.eRJ.addView(view, i, this.eRO ? this.eRG : this.eRF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eRL != 0) {
            int left = this.eRJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fKa;
            }
            if (left != this.eRX) {
                this.eRX = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.eRL != 0) {
            View childAt = this.eRJ.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fKc;
            float right2 = childAt.getRight() - this.fKc;
            if (this.fJQ > 0.0f && this.mCurrentTabIndex != this.fJR && this.fJR <= this.eRL - 1 && this.fJR >= 0) {
                View childAt2 = this.eRJ.getChildAt(this.fJR);
                left = e(left, childAt2.getLeft() + this.fKc, this.fJQ);
                right2 = f(right2, childAt2.getRight() - this.fKc, this.fJQ);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left, (height - this.mIndicatorHeight) - this.fKb, right2, height - this.fKb);
            } else {
                this.GD.set(left, (height - this.mIndicatorHeight) - this.fKb, right2, height - this.fKb);
            }
            canvas.drawRoundRect(this.GD, 16.0f, 16.0f, this.eRN);
            if (this.fKw) {
                View childAt3 = this.eRJ.getChildAt(this.fJV);
                this.fJU.set((childAt3.getRight() - this.fKp) - this.fKn, childAt3.getTop() + this.fKo, right + this.fKn, top + this.fKn);
                canvas.drawOval(this.fJU, this.fJT);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fKd + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fKd + f2) - ((this.fKd * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.fKd) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fKd) + ((this.fKd * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fKv = z;
        if (!z) {
            this.eRP = ap.getColor(this.fJY);
            this.eRQ = ap.getColor(R.color.cp_cont_j);
        } else {
            this.eRP = ap.getColor(R.color.cp_cont_a);
            this.eRQ = ap.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float an(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fKk - 1.0f) / (0.1f - 1.0f))) + this.fKk;
        }
        return (((this.fKk - this.fKj) / 0.1f) * f) + this.fKj;
    }

    private float ao(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fKk) / (0.1f - 0.9f)));
        }
        return (((this.fKk - this.fKj) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fKk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ao;
        float f = this.fJQ;
        float f2 = this.fJR < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eRL) {
            View childAt = this.eRJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eRY);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ao = an(f2);
                    } else {
                        ao = i == this.fJR ? ao(f2) : 1.0f;
                    }
                    textView.setScaleX(ao);
                    textView.setScaleY(ao);
                    if (ao <= 1.0f) {
                        textView.setTextColor(this.eRQ);
                    } else {
                        textView.setTextColor(this.eRP);
                    }
                    if (ao <= 1.03f) {
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
            if (PagerSlidingTabBaseStrip.this.eRJ.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.fKq) {
                    if (i == PagerSlidingTabBaseStrip.this.fJS) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fJR = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fJS) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fJR = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fJR = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fJS = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fJR = i;
                    }
                    PagerSlidingTabBaseStrip.this.fJQ = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.eRJ.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.eRI != null) {
                    PagerSlidingTabBaseStrip.this.eRI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.eRJ.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.eRK.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fJQ = 0.0f;
                    PagerSlidingTabBaseStrip.this.fKq = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fJS = PagerSlidingTabBaseStrip.this.eRK.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fJS;
                    PagerSlidingTabBaseStrip.this.fJR = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.eRI != null) {
                    PagerSlidingTabBaseStrip.this.eRI.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.eRI != null) {
                PagerSlidingTabBaseStrip.this.eRI.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.fKq) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fJQ * PagerSlidingTabBaseStrip.this.eRJ.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fJS = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fJR = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZQ;
        this.fJR = this.mCurrentTabIndex;
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
            /* renamed from: sG */
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
        this.fJV = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fJY = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fKx = aVar;
    }
}
