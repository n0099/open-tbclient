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
/* loaded from: classes15.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF Gl;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams epe;
    private LinearLayout.LayoutParams epf;
    public ViewPager.OnPageChangeListener eph;
    private LinearLayout epi;
    private ViewPager epj;
    private int epk;
    private Paint epm;
    private boolean epn;
    private int epo;
    private int epp;
    private int epw;
    private int epx;
    private Paint fgA;
    private RectF fgB;
    private int fgC;
    private int fgF;
    private int fgH;
    private int fgI;
    private int fgJ;
    private int fgK;
    private int fgN;
    private int fgO;
    private float fgQ;
    private float fgR;
    private int fgU;
    private int fgV;
    private int fgW;
    private boolean fgX;
    private float fgx;
    private int fgy;
    private int fgz;
    private final b fhb;
    private boolean fhc;
    private boolean fhd;
    private a fhe;
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
        this.fhb = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fgx = 0.0f;
        this.fgy = 0;
        this.fgz = 0;
        this.epn = false;
        this.fgF = R.color.cp_cont_b;
        this.epo = ap.getColor(this.fgF);
        this.epp = ap.getColor(R.color.cp_cont_j);
        this.fgH = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fgN = 17;
        this.fgO = 17;
        this.epw = 0;
        this.epx = R.drawable.pager_sliding_view;
        this.fgX = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fgJ = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.epe = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fhd = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.fgX = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.epj = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fhb);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eph = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.epj != null && this.epj.getAdapter() != null && this.epj.getAdapter().getCount() != 0) {
            this.epi.removeAllViews();
            this.epk = this.epj.getAdapter().getCount();
            for (int i = 0; i < this.epk; i++) {
                an(i, this.epj.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.epj.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fgy = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void an(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.fgN);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fhe != null) {
                        PagerSlidingTabBaseStrip.this.fhe.l(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.epj.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.fgX = true;
                        PagerSlidingTabBaseStrip.this.epj.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.epi.addView(view, i, this.epn ? this.epf : this.epe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.epk != 0) {
            int left = this.epi.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fgH;
            }
            if (left != this.epw) {
                this.epw = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.epk != 0) {
            View childAt = this.epi.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fgJ;
            float right2 = childAt.getRight() - this.fgJ;
            if (this.fgx > 0.0f && this.mCurrentTabIndex != this.fgy && this.fgy <= this.epk - 1 && this.fgy >= 0) {
                View childAt2 = this.epi.getChildAt(this.fgy);
                left = e(left, childAt2.getLeft() + this.fgJ, this.fgx);
                right2 = f(right2, childAt2.getRight() - this.fgJ, this.fgx);
            }
            int height = getHeight();
            if (this.Gl == null) {
                this.Gl = new RectF(left, (height - this.mIndicatorHeight) - this.fgI, right2, height - this.fgI);
            } else {
                this.Gl.set(left, (height - this.mIndicatorHeight) - this.fgI, right2, height - this.fgI);
            }
            canvas.drawRoundRect(this.Gl, 16.0f, 16.0f, this.epm);
            if (this.fhd) {
                View childAt3 = this.epi.getChildAt(this.fgC);
                this.fgB.set((childAt3.getRight() - this.fgW) - this.fgU, childAt3.getTop() + this.fgV, right + this.fgU, top + this.fgU);
                canvas.drawOval(this.fgB, this.fgA);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fgK + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fgK + f2) - ((this.fgK * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.fgK) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fgK) + ((this.fgK * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fhc = z;
        if (!z) {
            this.epo = ap.getColor(this.fgF);
            this.epp = ap.getColor(R.color.cp_cont_j);
        } else {
            this.epo = ap.getColor(R.color.cp_cont_a);
            this.epp = ap.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float ah(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fgR - 1.0f) / (0.1f - 1.0f))) + this.fgR;
        }
        return (((this.fgR - this.fgQ) / 0.1f) * f) + this.fgQ;
    }

    private float ai(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fgR) / (0.1f - 0.9f)));
        }
        return (((this.fgR - this.fgQ) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fgR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ai;
        float f = this.fgx;
        float f2 = this.fgy < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.epk) {
            View childAt = this.epi.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.epx);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ai = ah(f2);
                    } else {
                        ai = i == this.fgy ? ai(f2) : 1.0f;
                    }
                    textView.setScaleX(ai);
                    textView.setScaleY(ai);
                    if (ai <= 1.0f) {
                        textView.setTextColor(this.epp);
                    } else {
                        textView.setTextColor(this.epo);
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

    /* loaded from: classes15.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.epi.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.fgX) {
                    if (i == PagerSlidingTabBaseStrip.this.fgz) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fgy = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fgz) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fgy = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fgy = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fgz = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fgy = i;
                    }
                    PagerSlidingTabBaseStrip.this.fgx = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.epi.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.eph != null) {
                    PagerSlidingTabBaseStrip.this.eph.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.epi.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.epj.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fgx = 0.0f;
                    PagerSlidingTabBaseStrip.this.fgX = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fgz = PagerSlidingTabBaseStrip.this.epj.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fgz;
                    PagerSlidingTabBaseStrip.this.fgy = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.eph != null) {
                    PagerSlidingTabBaseStrip.this.eph.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.eph != null) {
                PagerSlidingTabBaseStrip.this.eph.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.fgX) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fgx * PagerSlidingTabBaseStrip.this.epi.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fgz = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fgy = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Zh;
        this.fgy = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zh = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
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
            /* renamed from: rw */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Zh;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zh = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zh);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fgC = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fgF = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fhe = aVar;
    }
}
