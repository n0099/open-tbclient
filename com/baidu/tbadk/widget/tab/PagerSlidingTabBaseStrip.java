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
    private float dPN;
    private int dPO;
    private int dPP;
    private Paint dPQ;
    private RectF dPR;
    private boolean dPS;
    private int dPT;
    private int dPW;
    private int dPY;
    private int dPZ;
    private int dQa;
    private int dQb;
    private int dQd;
    private int dQe;
    private float dQg;
    private float dQh;
    private int dQk;
    private int dQl;
    private int dQm;
    private boolean dQn;
    private final b dQq;
    private boolean dQr;
    private a dQs;
    private int deA;
    private int deB;
    private LinearLayout.LayoutParams def;
    private LinearLayout.LayoutParams deg;
    public ViewPager.OnPageChangeListener dei;
    private LinearLayout dej;
    private ViewPager dek;
    private int del;
    private Paint den;
    private boolean deo;
    private int dep;
    private int deq;
    private int dgq;
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
        this.dQq = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dPN = 0.0f;
        this.dPO = 0;
        this.dPP = 0;
        this.deo = false;
        this.dPW = R.color.cp_cont_b;
        this.dep = am.getColor(this.dPW);
        this.deq = am.getColor(R.color.cp_cont_j);
        this.dPY = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dgq = 1;
        this.dQd = 17;
        this.dQe = 17;
        this.deA = 0;
        this.deB = R.drawable.pager_sliding_view;
        this.dQn = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.dQa = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.def = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dPS = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dQn = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dek = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dQq);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dei = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dek != null && this.dek.getAdapter() != null && this.dek.getAdapter().getCount() != 0) {
            this.dej.removeAllViews();
            this.del = this.dek.getAdapter().getCount();
            for (int i = 0; i < this.del; i++) {
                R(i, this.dek.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dek.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.dPO = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.dQd);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.dQs != null) {
                        PagerSlidingTabBaseStrip.this.dQs.k(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.dek.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.dQn = true;
                        PagerSlidingTabBaseStrip.this.dek.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dej.addView(view, i, this.deo ? this.deg : this.def);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.del != 0) {
            int left = this.dej.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dPY;
            }
            if (left != this.deA) {
                this.deA = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.del != 0) {
            View childAt = this.dej.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQa;
            float right2 = childAt.getRight() - this.dQa;
            if (this.dPN > 0.0f && this.mCurrentTabIndex != this.dPO && this.dPO <= this.del - 1 && this.dPO >= 0) {
                View childAt2 = this.dej.getChildAt(this.dPO);
                left = d(left, childAt2.getLeft() + this.dQa, this.dPN);
                right2 = e(right2, childAt2.getRight() - this.dQa, this.dPN);
            }
            int height = getHeight();
            if (this.jH == null) {
                this.jH = new RectF(left, (height - this.mIndicatorHeight) - this.dPZ, right2, height - this.dPZ);
            } else {
                this.jH.set(left, (height - this.mIndicatorHeight) - this.dPZ, right2, height - this.dPZ);
            }
            canvas.drawRoundRect(this.jH, 16.0f, 16.0f, this.den);
            if (this.dPS) {
                View childAt3 = this.dej.getChildAt(this.dPT);
                this.dPR.set((childAt3.getRight() - this.dQm) - this.dQk, childAt3.getTop() + this.dQl, right + this.dQk, top2 + this.dQk);
                canvas.drawOval(this.dPR, this.dPQ);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.dQb + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.dQb + f2) - ((this.dQb * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.dQb) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.dQb) + ((this.dQb * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.dQr = z;
        if (!z) {
            this.dep = am.getColor(this.dPW);
            this.deq = am.getColor(R.color.cp_cont_j);
        } else {
            this.dep = am.getColor(R.color.cp_cont_a);
            this.deq = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQh - 1.0f) / (0.1f - 1.0f))) + this.dQh;
        }
        return (((this.dQh - this.dQg) / 0.1f) * f) + this.dQg;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQh) / (0.1f - 0.9f)));
        }
        return (((this.dQh - this.dQg) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dPN;
        float f2 = this.dPO < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.del) {
            View childAt = this.dej.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deB);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dPO ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (at <= 1.0f) {
                        textView.setTextColor(this.deq);
                    } else {
                        textView.setTextColor(this.dep);
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
            if (PagerSlidingTabBaseStrip.this.dej.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.dQn) {
                    if (i == PagerSlidingTabBaseStrip.this.dPP) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dPO = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.dPP) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dPO = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.dPO = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.dPP = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dPO = i;
                    }
                    PagerSlidingTabBaseStrip.this.dPN = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dej.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.dei != null) {
                    PagerSlidingTabBaseStrip.this.dei.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.dej.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.dek.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.dPN = 0.0f;
                    PagerSlidingTabBaseStrip.this.dQn = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.dPP = PagerSlidingTabBaseStrip.this.dek.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dPP;
                    PagerSlidingTabBaseStrip.this.dPO = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.dei != null) {
                    PagerSlidingTabBaseStrip.this.dei.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.dei != null) {
                PagerSlidingTabBaseStrip.this.dei.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.dQn) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dPN * PagerSlidingTabBaseStrip.this.dej.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.dPP = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.dPO = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dPO = this.mCurrentTabIndex;
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
        this.dPT = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dPW = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dQs = aVar;
    }
}
