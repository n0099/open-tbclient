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
/* loaded from: classes6.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private boolean dLG;
    private float dLH;
    private int dLI;
    private int dLJ;
    private Paint dLK;
    private RectF dLL;
    private boolean dLM;
    private int dLN;
    private int dLQ;
    private int dLS;
    private int dLT;
    private int dLU;
    private int dLV;
    private int dLX;
    private int dLY;
    private float dMa;
    private float dMb;
    private int dMe;
    private int dMf;
    private int dMg;
    private boolean dMh;
    private final b dMk;
    private a dMl;
    private LinearLayout.LayoutParams daa;
    private LinearLayout.LayoutParams dab;
    public ViewPager.OnPageChangeListener dad;
    private LinearLayout dae;
    private ViewPager daf;
    private int dag;
    private Paint dai;
    private boolean daj;
    private int dak;
    private int dal;
    private int dau;
    private int dav;
    private int dcl;
    private int dividerPadding;
    private boolean isLoading;
    private RectF jD;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes6.dex */
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
        this.dMk = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dLH = 0.0f;
        this.dLI = 0;
        this.dLJ = 0;
        this.daj = false;
        this.dLQ = R.color.cp_cont_b;
        this.dak = am.getColor(this.dLQ);
        this.dal = am.getColor(R.color.cp_cont_j);
        this.dLS = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dcl = 1;
        this.dLX = 17;
        this.dLY = 17;
        this.dau = 0;
        this.dav = R.drawable.pager_sliding_view;
        this.dMh = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.dLU = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.daa = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dLM = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dMh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.daf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dMk);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dad = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.daf != null && this.daf.getAdapter() != null && this.daf.getAdapter().getCount() != 0) {
            this.dae.removeAllViews();
            this.dag = this.daf.getAdapter().getCount();
            for (int i = 0; i < this.dag; i++) {
                P(i, this.daf.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.daf.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.dLI = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void P(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dLX);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.dMl != null) {
                        PagerSlidingTabBaseStrip.this.dMl.k(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.daf.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.dMh = true;
                        PagerSlidingTabBaseStrip.this.daf.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dae.addView(view, i, this.daj ? this.dab : this.daa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dag != 0) {
            int left = this.dae.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dLS;
            }
            if (left != this.dau) {
                this.dau = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dag != 0) {
            View childAt = this.dae.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dLU;
            float right2 = childAt.getRight() - this.dLU;
            if (this.dLH > 0.0f && this.mCurrentTabIndex != this.dLI && this.dLI <= this.dag - 1 && this.dLI >= 0) {
                View childAt2 = this.dae.getChildAt(this.dLI);
                left = d(left, childAt2.getLeft() + this.dLU, this.dLH);
                right2 = e(right2, childAt2.getRight() - this.dLU, this.dLH);
            }
            int height = getHeight();
            if (this.jD == null) {
                this.jD = new RectF(left, (height - this.mIndicatorHeight) - this.dLT, right2, height - this.dLT);
            } else {
                this.jD.set(left, (height - this.mIndicatorHeight) - this.dLT, right2, height - this.dLT);
            }
            canvas.drawRoundRect(this.jD, 16.0f, 16.0f, this.dai);
            if (this.dLM) {
                View childAt3 = this.dae.getChildAt(this.dLN);
                this.dLL.set((childAt3.getRight() - this.dMg) - this.dMe, childAt3.getTop() + this.dMf, right + this.dMe, top + this.dMe);
                canvas.drawOval(this.dLL, this.dLK);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.dLV + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.dLV + f2) - ((this.dLV * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.dLV) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.dLV) + ((this.dLV * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.dLG = z;
        if (!z) {
            this.dak = am.getColor(this.dLQ);
            this.dal = am.getColor(R.color.cp_cont_j);
        } else {
            this.dak = am.getColor(R.color.cp_cont_a);
            this.dal = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dMb - 1.0f) / (0.1f - 1.0f))) + this.dMb;
        }
        return (((this.dMb - this.dMa) / 0.1f) * f) + this.dMa;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dMb) / (0.1f - 0.9f)));
        }
        return (((this.dMb - this.dMa) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dMb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.dLH;
        float f2 = this.dLI < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dag) {
            View childAt = this.dae.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dav);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.dLI ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (au <= 1.0f) {
                        textView.setTextColor(this.dal);
                    } else {
                        textView.setTextColor(this.dak);
                    }
                    if (au <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes6.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.dae.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.dMh) {
                    if (i == PagerSlidingTabBaseStrip.this.dLJ) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dLI = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.dLJ) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dLI = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.dLI = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.dLJ = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dLI = i;
                    }
                    PagerSlidingTabBaseStrip.this.dLH = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dae.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.dad != null) {
                    PagerSlidingTabBaseStrip.this.dad.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.dae.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.daf.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.dLH = 0.0f;
                    PagerSlidingTabBaseStrip.this.dMh = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.dLJ = PagerSlidingTabBaseStrip.this.daf.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dLJ;
                    PagerSlidingTabBaseStrip.this.dLI = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.dad != null) {
                    PagerSlidingTabBaseStrip.this.dad.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.dad != null) {
                PagerSlidingTabBaseStrip.this.dad.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.dMh) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dLH * PagerSlidingTabBaseStrip.this.dae.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.dLJ = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.dLI = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ec;
        this.dLI = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ec = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
        int Ec;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ec = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ec);
        }
    }

    public void setConcernTabIndex(int i) {
        this.dLN = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dLQ = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dMl = aVar;
    }
}
