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
    private int dQB;
    private int dQD;
    private int dQE;
    private int dQF;
    private int dQG;
    private int dQI;
    private int dQJ;
    private float dQL;
    private float dQM;
    private int dQP;
    private int dQQ;
    private int dQR;
    private boolean dQS;
    private final b dQV;
    private boolean dQW;
    private a dQX;
    private float dQs;
    private int dQt;
    private int dQu;
    private Paint dQv;
    private RectF dQw;
    private boolean dQx;
    private int dQy;
    private LinearLayout.LayoutParams deH;
    private LinearLayout.LayoutParams deI;
    public ViewPager.OnPageChangeListener deK;
    private LinearLayout deL;
    private ViewPager deM;
    private int deN;
    private Paint deP;
    private boolean deQ;
    private int deR;
    private int deS;
    private int dfb;
    private int dfc;
    private int dgR;
    private int dividerPadding;
    private boolean isLoading;
    private RectF jG;
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
        this.dQV = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dQs = 0.0f;
        this.dQt = 0;
        this.dQu = 0;
        this.deQ = false;
        this.dQB = R.color.cp_cont_b;
        this.deR = am.getColor(this.dQB);
        this.deS = am.getColor(R.color.cp_cont_j);
        this.dQD = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dgR = 1;
        this.dQI = 17;
        this.dQJ = 17;
        this.dfb = 0;
        this.dfc = R.drawable.pager_sliding_view;
        this.dQS = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.dQF = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deH = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dQx = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dQS = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.deM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dQV);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.deK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.deM != null && this.deM.getAdapter() != null && this.deM.getAdapter().getCount() != 0) {
            this.deL.removeAllViews();
            this.deN = this.deM.getAdapter().getCount();
            for (int i = 0; i < this.deN; i++) {
                R(i, this.deM.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.deM.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.dQt = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.dQI);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.dQX != null) {
                        PagerSlidingTabBaseStrip.this.dQX.k(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.deM.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.dQS = true;
                        PagerSlidingTabBaseStrip.this.deM.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.deL.addView(view, i, this.deQ ? this.deI : this.deH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.deN != 0) {
            int left = this.deL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dQD;
            }
            if (left != this.dfb) {
                this.dfb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.deN != 0) {
            View childAt = this.deL.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQF;
            float right2 = childAt.getRight() - this.dQF;
            if (this.dQs > 0.0f && this.mCurrentTabIndex != this.dQt && this.dQt <= this.deN - 1 && this.dQt >= 0) {
                View childAt2 = this.deL.getChildAt(this.dQt);
                left = d(left, childAt2.getLeft() + this.dQF, this.dQs);
                right2 = e(right2, childAt2.getRight() - this.dQF, this.dQs);
            }
            int height = getHeight();
            if (this.jG == null) {
                this.jG = new RectF(left, (height - this.mIndicatorHeight) - this.dQE, right2, height - this.dQE);
            } else {
                this.jG.set(left, (height - this.mIndicatorHeight) - this.dQE, right2, height - this.dQE);
            }
            canvas.drawRoundRect(this.jG, 16.0f, 16.0f, this.deP);
            if (this.dQx) {
                View childAt3 = this.deL.getChildAt(this.dQy);
                this.dQw.set((childAt3.getRight() - this.dQR) - this.dQP, childAt3.getTop() + this.dQQ, right + this.dQP, top2 + this.dQP);
                canvas.drawOval(this.dQw, this.dQv);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.dQG + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.dQG + f2) - ((this.dQG * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.dQG) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.dQG) + ((this.dQG * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.dQW = z;
        if (!z) {
            this.deR = am.getColor(this.dQB);
            this.deS = am.getColor(R.color.cp_cont_j);
        } else {
            this.deR = am.getColor(R.color.cp_cont_a);
            this.deS = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQM - 1.0f) / (0.1f - 1.0f))) + this.dQM;
        }
        return (((this.dQM - this.dQL) / 0.1f) * f) + this.dQL;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQM) / (0.1f - 0.9f)));
        }
        return (((this.dQM - this.dQL) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dQs;
        float f2 = this.dQt < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.deN) {
            View childAt = this.deL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dfc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dQt ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (at <= 1.0f) {
                        textView.setTextColor(this.deS);
                    } else {
                        textView.setTextColor(this.deR);
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
            if (PagerSlidingTabBaseStrip.this.deL.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.dQS) {
                    if (i == PagerSlidingTabBaseStrip.this.dQu) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dQt = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.dQu) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dQt = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.dQt = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.dQu = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dQt = i;
                    }
                    PagerSlidingTabBaseStrip.this.dQs = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.deL.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.deK != null) {
                    PagerSlidingTabBaseStrip.this.deK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.deL.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.deM.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.dQs = 0.0f;
                    PagerSlidingTabBaseStrip.this.dQS = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.dQu = PagerSlidingTabBaseStrip.this.deM.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dQu;
                    PagerSlidingTabBaseStrip.this.dQt = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.deK != null) {
                    PagerSlidingTabBaseStrip.this.deK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.deK != null) {
                PagerSlidingTabBaseStrip.this.deK.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.dQS) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dQs * PagerSlidingTabBaseStrip.this.deL.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.dQu = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.dQt = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dQt = this.mCurrentTabIndex;
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
            /* renamed from: nB */
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
        this.dQy = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dQB = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dQX = aVar;
    }
}
