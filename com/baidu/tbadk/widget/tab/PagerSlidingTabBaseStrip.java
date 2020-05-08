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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF Fg;
    private int dCe;
    private int dEC;
    private int dED;
    private LinearLayout.LayoutParams dEj;
    private LinearLayout.LayoutParams dEk;
    public ViewPager.OnPageChangeListener dEm;
    private LinearLayout dEn;
    private ViewPager dEo;
    private int dEp;
    private Paint dEr;
    private boolean dEs;
    private int dEt;
    private int dGs;
    private int dividerPadding;
    private int eqA;
    private int eqC;
    private int eqD;
    private int eqE;
    private int eqF;
    private int eqI;
    private int eqJ;
    private float eqL;
    private float eqM;
    private int eqP;
    private int eqQ;
    private int eqR;
    private boolean eqS;
    private final b eqW;
    private boolean eqX;
    private boolean eqY;
    private a eqZ;
    private float eqs;
    private int eqt;
    private int equ;
    private Paint eqv;
    private RectF eqw;
    private int eqx;
    private boolean isLoading;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void j(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqW = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eqs = 0.0f;
        this.eqt = 0;
        this.equ = 0;
        this.dEs = false;
        this.eqA = R.color.cp_cont_b;
        this.dEt = am.getColor(this.eqA);
        this.dCe = am.getColor(R.color.cp_cont_j);
        this.eqC = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dGs = 1;
        this.eqI = 17;
        this.eqJ = 17;
        this.dEC = 0;
        this.dED = R.drawable.pager_sliding_view;
        this.eqS = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.eqE = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dEj = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.eqY = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.eqS = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dEo = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eqW);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEm = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dEo != null && this.dEo.getAdapter() != null && this.dEo.getAdapter().getCount() != 0) {
            this.dEn.removeAllViews();
            this.dEp = this.dEo.getAdapter().getCount();
            for (int i = 0; i < this.dEp; i++) {
                ai(i, this.dEo.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dEo.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.eqt = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void ai(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.eqI);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.eqZ != null) {
                        PagerSlidingTabBaseStrip.this.eqZ.j(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.dEo.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.eqS = true;
                        PagerSlidingTabBaseStrip.this.dEo.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dEn.addView(view, i, this.dEs ? this.dEk : this.dEj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dEp != 0) {
            int left = this.dEn.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eqC;
            }
            if (left != this.dEC) {
                this.dEC = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dEp != 0) {
            View childAt = this.dEn.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.eqE;
            float right2 = childAt.getRight() - this.eqE;
            if (this.eqs > 0.0f && this.mCurrentTabIndex != this.eqt && this.eqt <= this.dEp - 1 && this.eqt >= 0) {
                View childAt2 = this.dEn.getChildAt(this.eqt);
                left = e(left, childAt2.getLeft() + this.eqE, this.eqs);
                right2 = f(right2, childAt2.getRight() - this.eqE, this.eqs);
            }
            int height = getHeight();
            if (this.Fg == null) {
                this.Fg = new RectF(left, (height - this.mIndicatorHeight) - this.eqD, right2, height - this.eqD);
            } else {
                this.Fg.set(left, (height - this.mIndicatorHeight) - this.eqD, right2, height - this.eqD);
            }
            canvas.drawRoundRect(this.Fg, 16.0f, 16.0f, this.dEr);
            if (this.eqY) {
                View childAt3 = this.dEn.getChildAt(this.eqx);
                this.eqw.set((childAt3.getRight() - this.eqR) - this.eqP, childAt3.getTop() + this.eqQ, right + this.eqP, top2 + this.eqP);
                canvas.drawOval(this.eqw, this.eqv);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.eqF + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.eqF + f2) - ((this.eqF * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.eqF) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.eqF) + ((this.eqF * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.eqX = z;
        if (!z) {
            this.dEt = am.getColor(this.eqA);
            this.dCe = am.getColor(R.color.cp_cont_j);
        } else {
            this.dEt = am.getColor(R.color.cp_cont_a);
            this.dCe = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eqM - 1.0f) / (0.1f - 1.0f))) + this.eqM;
        }
        return (((this.eqM - this.eqL) / 0.1f) * f) + this.eqL;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eqM) / (0.1f - 0.9f)));
        }
        return (((this.eqM - this.eqL) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eqM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.eqs;
        float f2 = this.eqt < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dEp) {
            View childAt = this.dEn.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dED);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.eqt ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (ad <= 1.0f) {
                        textView.setTextColor(this.dCe);
                    } else {
                        textView.setTextColor(this.dEt);
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
            if (PagerSlidingTabBaseStrip.this.dEn.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.eqS) {
                    if (i == PagerSlidingTabBaseStrip.this.equ) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eqt = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.equ) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eqt = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.eqt = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.equ = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eqt = i;
                    }
                    PagerSlidingTabBaseStrip.this.eqs = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dEn.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.dEm != null) {
                    PagerSlidingTabBaseStrip.this.dEm.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.dEn.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.dEo.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.eqs = 0.0f;
                    PagerSlidingTabBaseStrip.this.eqS = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.equ = PagerSlidingTabBaseStrip.this.dEo.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.equ;
                    PagerSlidingTabBaseStrip.this.eqt = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.dEm != null) {
                    PagerSlidingTabBaseStrip.this.dEm.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.dEm != null) {
                PagerSlidingTabBaseStrip.this.dEm.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.eqS) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.eqs * PagerSlidingTabBaseStrip.this.dEn.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.equ = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.eqt = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.XP;
        this.eqt = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.XP = this.mCurrentTabIndex;
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
            /* renamed from: nO */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int XP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.XP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XP);
        }
    }

    public void setConcernTabIndex(int i) {
        this.eqx = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.eqA = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eqZ = aVar;
    }
}
