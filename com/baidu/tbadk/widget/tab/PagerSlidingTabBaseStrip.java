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
    private RectF Fd;
    private int dCa;
    private LinearLayout.LayoutParams dEf;
    private LinearLayout.LayoutParams dEg;
    public ViewPager.OnPageChangeListener dEi;
    private LinearLayout dEj;
    private ViewPager dEk;
    private int dEl;
    private Paint dEn;
    private boolean dEo;
    private int dEp;
    private int dEy;
    private int dEz;
    private int dGo;
    private int dividerPadding;
    private int eqA;
    private int eqD;
    private int eqE;
    private float eqG;
    private float eqH;
    private int eqK;
    private int eqL;
    private int eqM;
    private boolean eqN;
    private final b eqR;
    private boolean eqS;
    private boolean eqT;
    private a eqU;
    private float eqn;
    private int eqo;
    private int eqp;
    private Paint eqq;
    private RectF eqr;
    private int eqs;
    private int eqv;
    private int eqx;
    private int eqy;
    private int eqz;
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
        this.eqR = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eqn = 0.0f;
        this.eqo = 0;
        this.eqp = 0;
        this.dEo = false;
        this.eqv = R.color.cp_cont_b;
        this.dEp = am.getColor(this.eqv);
        this.dCa = am.getColor(R.color.cp_cont_j);
        this.eqx = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dGo = 1;
        this.eqD = 17;
        this.eqE = 17;
        this.dEy = 0;
        this.dEz = R.drawable.pager_sliding_view;
        this.eqN = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.eqz = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dEf = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.eqT = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.eqN = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dEk = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eqR);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEi = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dEk != null && this.dEk.getAdapter() != null && this.dEk.getAdapter().getCount() != 0) {
            this.dEj.removeAllViews();
            this.dEl = this.dEk.getAdapter().getCount();
            for (int i = 0; i < this.dEl; i++) {
                ai(i, this.dEk.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dEk.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.eqo = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.eqD);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.eqU != null) {
                        PagerSlidingTabBaseStrip.this.eqU.j(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.dEk.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.eqN = true;
                        PagerSlidingTabBaseStrip.this.dEk.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dEj.addView(view, i, this.dEo ? this.dEg : this.dEf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dEl != 0) {
            int left = this.dEj.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eqx;
            }
            if (left != this.dEy) {
                this.dEy = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dEl != 0) {
            View childAt = this.dEj.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.eqz;
            float right2 = childAt.getRight() - this.eqz;
            if (this.eqn > 0.0f && this.mCurrentTabIndex != this.eqo && this.eqo <= this.dEl - 1 && this.eqo >= 0) {
                View childAt2 = this.dEj.getChildAt(this.eqo);
                left = e(left, childAt2.getLeft() + this.eqz, this.eqn);
                right2 = f(right2, childAt2.getRight() - this.eqz, this.eqn);
            }
            int height = getHeight();
            if (this.Fd == null) {
                this.Fd = new RectF(left, (height - this.mIndicatorHeight) - this.eqy, right2, height - this.eqy);
            } else {
                this.Fd.set(left, (height - this.mIndicatorHeight) - this.eqy, right2, height - this.eqy);
            }
            canvas.drawRoundRect(this.Fd, 16.0f, 16.0f, this.dEn);
            if (this.eqT) {
                View childAt3 = this.dEj.getChildAt(this.eqs);
                this.eqr.set((childAt3.getRight() - this.eqM) - this.eqK, childAt3.getTop() + this.eqL, right + this.eqK, top2 + this.eqK);
                canvas.drawOval(this.eqr, this.eqq);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.eqA + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.eqA + f2) - ((this.eqA * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.eqA) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.eqA) + ((this.eqA * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.eqS = z;
        if (!z) {
            this.dEp = am.getColor(this.eqv);
            this.dCa = am.getColor(R.color.cp_cont_j);
        } else {
            this.dEp = am.getColor(R.color.cp_cont_a);
            this.dCa = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eqH - 1.0f) / (0.1f - 1.0f))) + this.eqH;
        }
        return (((this.eqH - this.eqG) / 0.1f) * f) + this.eqG;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eqH) / (0.1f - 0.9f)));
        }
        return (((this.eqH - this.eqG) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eqH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.eqn;
        float f2 = this.eqo < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dEl) {
            View childAt = this.dEj.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dEz);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.eqo ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (ad <= 1.0f) {
                        textView.setTextColor(this.dCa);
                    } else {
                        textView.setTextColor(this.dEp);
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
            if (PagerSlidingTabBaseStrip.this.dEj.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.eqN) {
                    if (i == PagerSlidingTabBaseStrip.this.eqp) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eqo = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.eqp) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eqo = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.eqo = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.eqp = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.eqo = i;
                    }
                    PagerSlidingTabBaseStrip.this.eqn = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dEj.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.dEi != null) {
                    PagerSlidingTabBaseStrip.this.dEi.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.dEj.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.dEk.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.eqn = 0.0f;
                    PagerSlidingTabBaseStrip.this.eqN = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.eqp = PagerSlidingTabBaseStrip.this.dEk.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.eqp;
                    PagerSlidingTabBaseStrip.this.eqo = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.dEi != null) {
                    PagerSlidingTabBaseStrip.this.dEi.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.dEi != null) {
                PagerSlidingTabBaseStrip.this.dEi.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.eqN) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.eqn * PagerSlidingTabBaseStrip.this.dEj.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.eqp = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.eqo = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.XM;
        this.eqo = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.XM = this.mCurrentTabIndex;
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
        int XM;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.XM = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XM);
        }
    }

    public void setConcernTabIndex(int i) {
        this.eqs = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.eqv = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eqU = aVar;
    }
}
