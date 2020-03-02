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
    private float dPO;
    private int dPP;
    private int dPQ;
    private Paint dPR;
    private RectF dPS;
    private boolean dPT;
    private int dPU;
    private int dPX;
    private int dPZ;
    private int dQa;
    private int dQb;
    private int dQc;
    private int dQe;
    private int dQf;
    private float dQh;
    private float dQi;
    private int dQl;
    private int dQm;
    private int dQn;
    private boolean dQo;
    private final b dQr;
    private boolean dQs;
    private a dQt;
    private int deB;
    private int deC;
    private LinearLayout.LayoutParams deg;
    private LinearLayout.LayoutParams deh;
    public ViewPager.OnPageChangeListener dej;
    private LinearLayout dek;
    private ViewPager del;
    private int dem;
    private Paint deo;
    private boolean dep;
    private int deq;
    private int der;
    private int dgr;
    private int dividerPadding;
    private boolean isLoading;
    private RectF jH;
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
        this.dQr = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dPO = 0.0f;
        this.dPP = 0;
        this.dPQ = 0;
        this.dep = false;
        this.dPX = R.color.cp_cont_b;
        this.deq = am.getColor(this.dPX);
        this.der = am.getColor(R.color.cp_cont_j);
        this.dPZ = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dgr = 1;
        this.dQe = 17;
        this.dQf = 17;
        this.deB = 0;
        this.deC = R.drawable.pager_sliding_view;
        this.dQo = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.dQb = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deg = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dPT = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dQo = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.del = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dQr);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dej = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.del != null && this.del.getAdapter() != null && this.del.getAdapter().getCount() != 0) {
            this.dek.removeAllViews();
            this.dem = this.del.getAdapter().getCount();
            for (int i = 0; i < this.dem; i++) {
                R(i, this.del.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.del.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.dPP = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void R(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dQe);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.dQt != null) {
                        PagerSlidingTabBaseStrip.this.dQt.k(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.del.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.dQo = true;
                        PagerSlidingTabBaseStrip.this.del.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dek.addView(view, i, this.dep ? this.deh : this.deg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dem != 0) {
            int left = this.dek.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dPZ;
            }
            if (left != this.deB) {
                this.deB = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dem != 0) {
            View childAt = this.dek.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQb;
            float right2 = childAt.getRight() - this.dQb;
            if (this.dPO > 0.0f && this.mCurrentTabIndex != this.dPP && this.dPP <= this.dem - 1 && this.dPP >= 0) {
                View childAt2 = this.dek.getChildAt(this.dPP);
                left = d(left, childAt2.getLeft() + this.dQb, this.dPO);
                right2 = e(right2, childAt2.getRight() - this.dQb, this.dPO);
            }
            int height = getHeight();
            if (this.jH == null) {
                this.jH = new RectF(left, (height - this.mIndicatorHeight) - this.dQa, right2, height - this.dQa);
            } else {
                this.jH.set(left, (height - this.mIndicatorHeight) - this.dQa, right2, height - this.dQa);
            }
            canvas.drawRoundRect(this.jH, 16.0f, 16.0f, this.deo);
            if (this.dPT) {
                View childAt3 = this.dek.getChildAt(this.dPU);
                this.dPS.set((childAt3.getRight() - this.dQn) - this.dQl, childAt3.getTop() + this.dQm, right + this.dQl, top2 + this.dQl);
                canvas.drawOval(this.dPS, this.dPR);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.dQc + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.dQc + f2) - ((this.dQc * (f3 - 0.85f)) / 0.15f);
        } else {
            return f;
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 > f) {
            if (f3 <= 0.5d) {
                return f + (((f2 - f) * f3) / 0.5f);
            }
            return f2;
        } else if (f3 >= 0.5d) {
            return f;
        } else {
            if (f3 >= 0.15d) {
                return f - ((((f - this.dQc) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.dQc) + ((this.dQc * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.dQs = z;
        if (!z) {
            this.deq = am.getColor(this.dPX);
            this.der = am.getColor(R.color.cp_cont_j);
        } else {
            this.deq = am.getColor(R.color.cp_cont_a);
            this.der = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQi - 1.0f) / (0.1f - 1.0f))) + this.dQi;
        }
        return (((this.dQi - this.dQh) / 0.1f) * f) + this.dQh;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQi) / (0.1f - 0.9f)));
        }
        return (((this.dQi - this.dQh) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dPO;
        float f2 = this.dPP < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dem) {
            View childAt = this.dek.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deC);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dPP ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (at <= 1.0f) {
                        textView.setTextColor(this.der);
                    } else {
                        textView.setTextColor(this.deq);
                    }
                    if (at <= 1.03f) {
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
            if (PagerSlidingTabBaseStrip.this.dek.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.dQo) {
                    if (i == PagerSlidingTabBaseStrip.this.dPQ) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dPP = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.dPQ) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dPP = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.dPP = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.dPQ = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dPP = i;
                    }
                    PagerSlidingTabBaseStrip.this.dPO = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dek.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.dej != null) {
                    PagerSlidingTabBaseStrip.this.dej.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.dek.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.del.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.dPO = 0.0f;
                    PagerSlidingTabBaseStrip.this.dQo = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.dPQ = PagerSlidingTabBaseStrip.this.del.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dPQ;
                    PagerSlidingTabBaseStrip.this.dPP = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.dej != null) {
                    PagerSlidingTabBaseStrip.this.dej.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.dej != null) {
                PagerSlidingTabBaseStrip.this.dej.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.dQo) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dPO * PagerSlidingTabBaseStrip.this.dek.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.dPQ = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.dPP = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dPP = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ev = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: nz */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ev;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ev = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ev);
        }
    }

    public void setConcernTabIndex(int i) {
        this.dPU = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dPX = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dQt = aVar;
    }
}
