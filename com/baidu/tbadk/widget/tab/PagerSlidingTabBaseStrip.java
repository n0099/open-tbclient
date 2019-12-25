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
/* loaded from: classes5.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams cZQ;
    private LinearLayout.LayoutParams cZR;
    public ViewPager.OnPageChangeListener cZT;
    private LinearLayout cZU;
    private ViewPager cZV;
    private int cZW;
    private Paint cZY;
    private boolean cZZ;
    private float dLA;
    private int dLB;
    private int dLC;
    private Paint dLD;
    private RectF dLE;
    private boolean dLF;
    private int dLG;
    private int dLI;
    private int dLK;
    private int dLL;
    private int dLM;
    private int dLN;
    private int dLP;
    private int dLQ;
    private float dLS;
    private float dLT;
    private int dLW;
    private int dLX;
    private int dLY;
    private boolean dLZ;
    private boolean dLz;
    private final b dMc;
    private a dMd;
    private int daa;
    private int dab;
    private int dak;
    private int dal;
    private int dcb;
    private int dividerPadding;
    private boolean isLoading;
    private RectF jE;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes5.dex */
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
        this.dMc = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dLA = 0.0f;
        this.dLB = 0;
        this.dLC = 0;
        this.cZZ = false;
        this.dLI = R.color.cp_cont_b;
        this.daa = am.getColor(this.dLI);
        this.dab = am.getColor(R.color.cp_cont_j);
        this.dLK = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dcb = 1;
        this.dLP = 17;
        this.dLQ = 17;
        this.dak = 0;
        this.dal = R.drawable.pager_sliding_view;
        this.dLZ = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.dLM = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.cZQ = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dLF = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dLZ = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cZV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dMc);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cZT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.cZV != null && this.cZV.getAdapter() != null && this.cZV.getAdapter().getCount() != 0) {
            this.cZU.removeAllViews();
            this.cZW = this.cZV.getAdapter().getCount();
            for (int i = 0; i < this.cZW; i++) {
                N(i, this.cZV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.cZV.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.dLB = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void N(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dLP);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.dMd != null) {
                        PagerSlidingTabBaseStrip.this.dMd.k(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.cZV.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.dLZ = true;
                        PagerSlidingTabBaseStrip.this.cZV.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.cZU.addView(view, i, this.cZZ ? this.cZR : this.cZQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.cZW != 0) {
            int left = this.cZU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dLK;
            }
            if (left != this.dak) {
                this.dak = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.cZW != 0) {
            View childAt = this.cZU.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dLM;
            float right2 = childAt.getRight() - this.dLM;
            if (this.dLA > 0.0f && this.mCurrentTabIndex != this.dLB && this.dLB <= this.cZW - 1 && this.dLB >= 0) {
                View childAt2 = this.cZU.getChildAt(this.dLB);
                left = d(left, childAt2.getLeft() + this.dLM, this.dLA);
                right2 = e(right2, childAt2.getRight() - this.dLM, this.dLA);
            }
            int height = getHeight();
            if (this.jE == null) {
                this.jE = new RectF(left, (height - this.mIndicatorHeight) - this.dLL, right2, height - this.dLL);
            } else {
                this.jE.set(left, (height - this.mIndicatorHeight) - this.dLL, right2, height - this.dLL);
            }
            canvas.drawRoundRect(this.jE, 16.0f, 16.0f, this.cZY);
            if (this.dLF) {
                View childAt3 = this.cZU.getChildAt(this.dLG);
                this.dLE.set((childAt3.getRight() - this.dLY) - this.dLW, childAt3.getTop() + this.dLX, right + this.dLW, top + this.dLW);
                canvas.drawOval(this.dLE, this.dLD);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.dLN + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.dLN + f2) - ((this.dLN * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.dLN) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.dLN) + ((this.dLN * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.dLz = z;
        if (!z) {
            this.daa = am.getColor(this.dLI);
            this.dab = am.getColor(R.color.cp_cont_j);
        } else {
            this.daa = am.getColor(R.color.cp_cont_a);
            this.dab = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float au(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dLT - 1.0f) / (0.1f - 1.0f))) + this.dLT;
        }
        return (((this.dLT - this.dLS) / 0.1f) * f) + this.dLS;
    }

    private float av(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dLT) / (0.1f - 0.9f)));
        }
        return (((this.dLT - this.dLS) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dLT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float av;
        float f = this.dLA;
        float f2 = this.dLB < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.cZW) {
            View childAt = this.cZU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dal);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        av = au(f2);
                    } else {
                        av = i == this.dLB ? av(f2) : 1.0f;
                    }
                    textView.setScaleX(av);
                    textView.setScaleY(av);
                    if (av <= 1.0f) {
                        textView.setTextColor(this.dab);
                    } else {
                        textView.setTextColor(this.daa);
                    }
                    if (av <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes5.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.cZU.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.dLZ) {
                    if (i == PagerSlidingTabBaseStrip.this.dLC) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dLB = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.dLC) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dLB = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.dLB = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.dLC = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dLB = i;
                    }
                    PagerSlidingTabBaseStrip.this.dLA = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.cZU.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.cZT != null) {
                    PagerSlidingTabBaseStrip.this.cZT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.cZU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.cZV.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.dLA = 0.0f;
                    PagerSlidingTabBaseStrip.this.dLZ = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.dLC = PagerSlidingTabBaseStrip.this.cZV.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dLC;
                    PagerSlidingTabBaseStrip.this.dLB = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.cZT != null) {
                    PagerSlidingTabBaseStrip.this.cZT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.cZT != null) {
                PagerSlidingTabBaseStrip.this.cZT.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.dLZ) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dLA * PagerSlidingTabBaseStrip.this.cZU.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.dLC = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.dLB = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.DX;
        this.dLB = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.DX = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
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
            /* renamed from: ni */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int DX;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.DX = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.DX);
        }
    }

    public void setConcernTabIndex(int i) {
        this.dLG = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dLI = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dMd = aVar;
    }
}
