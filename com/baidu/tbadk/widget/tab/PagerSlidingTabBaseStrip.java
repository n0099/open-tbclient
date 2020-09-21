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
/* loaded from: classes20.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF Gl;
    private int dividerPadding;
    private int dividerWidth;
    private int erB;
    private int erC;
    private LinearLayout.LayoutParams eri;
    private LinearLayout.LayoutParams erj;
    public ViewPager.OnPageChangeListener erl;
    private LinearLayout erm;
    private ViewPager ern;
    private int ero;
    private Paint erq;
    private boolean ers;
    private int ert;
    private int eru;
    private int fjB;
    private int fjC;
    private int fjD;
    private int fjE;
    private int fjH;
    private int fjI;
    private float fjK;
    private float fjL;
    private int fjO;
    private int fjP;
    private int fjQ;
    private boolean fjR;
    private final b fjV;
    private boolean fjW;
    private boolean fjX;
    private a fjY;
    private float fjr;
    private int fjs;
    private int fjt;
    private Paint fju;
    private RectF fjv;
    private int fjw;
    private int fjz;
    private boolean isLoading;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes20.dex */
    public interface a {
        void m(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fjV = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fjr = 0.0f;
        this.fjs = 0;
        this.fjt = 0;
        this.ers = false;
        this.fjz = R.color.cp_cont_b;
        this.ert = ap.getColor(this.fjz);
        this.eru = ap.getColor(R.color.cp_cont_j);
        this.fjB = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fjH = 17;
        this.fjI = 17;
        this.erB = 0;
        this.erC = R.drawable.pager_sliding_view;
        this.fjR = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fjD = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eri = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fjX = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.fjR = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ern = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fjV);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.erl = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ern != null && this.ern.getAdapter() != null && this.ern.getAdapter().getCount() != 0) {
            this.erm.removeAllViews();
            this.ero = this.ern.getAdapter().getCount();
            for (int i = 0; i < this.ero; i++) {
                ao(i, this.ern.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.ern.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fjs = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.fjH);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fjY != null) {
                        PagerSlidingTabBaseStrip.this.fjY.m(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.ern.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.fjR = true;
                        PagerSlidingTabBaseStrip.this.ern.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.erm.addView(view, i, this.ers ? this.erj : this.eri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ero != 0) {
            int left = this.erm.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fjB;
            }
            if (left != this.erB) {
                this.erB = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.ero != 0) {
            View childAt = this.erm.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fjD;
            float right2 = childAt.getRight() - this.fjD;
            if (this.fjr > 0.0f && this.mCurrentTabIndex != this.fjs && this.fjs <= this.ero - 1 && this.fjs >= 0) {
                View childAt2 = this.erm.getChildAt(this.fjs);
                left = e(left, childAt2.getLeft() + this.fjD, this.fjr);
                right2 = f(right2, childAt2.getRight() - this.fjD, this.fjr);
            }
            int height = getHeight();
            if (this.Gl == null) {
                this.Gl = new RectF(left, (height - this.mIndicatorHeight) - this.fjC, right2, height - this.fjC);
            } else {
                this.Gl.set(left, (height - this.mIndicatorHeight) - this.fjC, right2, height - this.fjC);
            }
            canvas.drawRoundRect(this.Gl, 16.0f, 16.0f, this.erq);
            if (this.fjX) {
                View childAt3 = this.erm.getChildAt(this.fjw);
                this.fjv.set((childAt3.getRight() - this.fjQ) - this.fjO, childAt3.getTop() + this.fjP, right + this.fjO, top + this.fjO);
                canvas.drawOval(this.fjv, this.fju);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fjE + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fjE + f2) - ((this.fjE * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.fjE) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fjE) + ((this.fjE * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fjW = z;
        if (!z) {
            this.ert = ap.getColor(this.fjz);
            this.eru = ap.getColor(R.color.cp_cont_j);
        } else {
            this.ert = ap.getColor(R.color.cp_cont_a);
            this.eru = ap.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float ah(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fjL - 1.0f) / (0.1f - 1.0f))) + this.fjL;
        }
        return (((this.fjL - this.fjK) / 0.1f) * f) + this.fjK;
    }

    private float ai(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fjL) / (0.1f - 0.9f)));
        }
        return (((this.fjL - this.fjK) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fjL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ai;
        float f = this.fjr;
        float f2 = this.fjs < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.ero) {
            View childAt = this.erm.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.erC);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ai = ah(f2);
                    } else {
                        ai = i == this.fjs ? ai(f2) : 1.0f;
                    }
                    textView.setScaleX(ai);
                    textView.setScaleY(ai);
                    if (ai <= 1.0f) {
                        textView.setTextColor(this.eru);
                    } else {
                        textView.setTextColor(this.ert);
                    }
                    if (ai <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes20.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.erm.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.fjR) {
                    if (i == PagerSlidingTabBaseStrip.this.fjt) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fjs = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fjt) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fjs = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fjs = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fjt = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fjs = i;
                    }
                    PagerSlidingTabBaseStrip.this.fjr = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.erm.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.erl != null) {
                    PagerSlidingTabBaseStrip.this.erl.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.erm.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.ern.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fjr = 0.0f;
                    PagerSlidingTabBaseStrip.this.fjR = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fjt = PagerSlidingTabBaseStrip.this.ern.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fjt;
                    PagerSlidingTabBaseStrip.this.fjs = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.erl != null) {
                    PagerSlidingTabBaseStrip.this.erl.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.erl != null) {
                PagerSlidingTabBaseStrip.this.erl.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.fjR) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fjr * PagerSlidingTabBaseStrip.this.erm.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fjt = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fjs = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Zz;
        this.fjs = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zz = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
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
            /* renamed from: rN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Zz;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zz = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zz);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fjw = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fjz = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fjY = aVar;
    }
}
