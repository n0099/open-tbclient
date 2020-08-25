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
    private LinearLayout.LayoutParams epa;
    private LinearLayout.LayoutParams epb;
    public ViewPager.OnPageChangeListener epd;
    private LinearLayout epe;
    private ViewPager epf;
    private int epg;
    private Paint epi;
    private boolean epj;
    private int epk;
    private int epl;
    private int eps;
    private int ept;
    private int fgB;
    private int fgD;
    private int fgE;
    private int fgF;
    private int fgG;
    private int fgJ;
    private int fgK;
    private float fgM;
    private float fgN;
    private int fgQ;
    private int fgR;
    private int fgS;
    private boolean fgT;
    private final b fgX;
    private boolean fgY;
    private boolean fgZ;
    private float fgt;
    private int fgu;
    private int fgv;
    private Paint fgw;
    private RectF fgx;
    private int fgy;
    private a fha;
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
        this.fgX = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fgt = 0.0f;
        this.fgu = 0;
        this.fgv = 0;
        this.epj = false;
        this.fgB = R.color.cp_cont_b;
        this.epk = ap.getColor(this.fgB);
        this.epl = ap.getColor(R.color.cp_cont_j);
        this.fgD = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fgJ = 17;
        this.fgK = 17;
        this.eps = 0;
        this.ept = R.drawable.pager_sliding_view;
        this.fgT = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fgF = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.epa = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fgZ = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.fgT = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.epf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fgX);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.epd = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.epf != null && this.epf.getAdapter() != null && this.epf.getAdapter().getCount() != 0) {
            this.epe.removeAllViews();
            this.epg = this.epf.getAdapter().getCount();
            for (int i = 0; i < this.epg; i++) {
                an(i, this.epf.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.epf.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fgu = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.fgJ);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fha != null) {
                        PagerSlidingTabBaseStrip.this.fha.l(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.epf.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.fgT = true;
                        PagerSlidingTabBaseStrip.this.epf.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.epe.addView(view, i, this.epj ? this.epb : this.epa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.epg != 0) {
            int left = this.epe.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fgD;
            }
            if (left != this.eps) {
                this.eps = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.epg != 0) {
            View childAt = this.epe.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fgF;
            float right2 = childAt.getRight() - this.fgF;
            if (this.fgt > 0.0f && this.mCurrentTabIndex != this.fgu && this.fgu <= this.epg - 1 && this.fgu >= 0) {
                View childAt2 = this.epe.getChildAt(this.fgu);
                left = e(left, childAt2.getLeft() + this.fgF, this.fgt);
                right2 = f(right2, childAt2.getRight() - this.fgF, this.fgt);
            }
            int height = getHeight();
            if (this.Gl == null) {
                this.Gl = new RectF(left, (height - this.mIndicatorHeight) - this.fgE, right2, height - this.fgE);
            } else {
                this.Gl.set(left, (height - this.mIndicatorHeight) - this.fgE, right2, height - this.fgE);
            }
            canvas.drawRoundRect(this.Gl, 16.0f, 16.0f, this.epi);
            if (this.fgZ) {
                View childAt3 = this.epe.getChildAt(this.fgy);
                this.fgx.set((childAt3.getRight() - this.fgS) - this.fgQ, childAt3.getTop() + this.fgR, right + this.fgQ, top + this.fgQ);
                canvas.drawOval(this.fgx, this.fgw);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fgG + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fgG + f2) - ((this.fgG * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.fgG) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fgG) + ((this.fgG * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fgY = z;
        if (!z) {
            this.epk = ap.getColor(this.fgB);
            this.epl = ap.getColor(R.color.cp_cont_j);
        } else {
            this.epk = ap.getColor(R.color.cp_cont_a);
            this.epl = ap.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float ah(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fgN - 1.0f) / (0.1f - 1.0f))) + this.fgN;
        }
        return (((this.fgN - this.fgM) / 0.1f) * f) + this.fgM;
    }

    private float ai(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fgN) / (0.1f - 0.9f)));
        }
        return (((this.fgN - this.fgM) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fgN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ai;
        float f = this.fgt;
        float f2 = this.fgu < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.epg) {
            View childAt = this.epe.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ept);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ai = ah(f2);
                    } else {
                        ai = i == this.fgu ? ai(f2) : 1.0f;
                    }
                    textView.setScaleX(ai);
                    textView.setScaleY(ai);
                    if (ai <= 1.0f) {
                        textView.setTextColor(this.epl);
                    } else {
                        textView.setTextColor(this.epk);
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
            if (PagerSlidingTabBaseStrip.this.epe.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.fgT) {
                    if (i == PagerSlidingTabBaseStrip.this.fgv) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fgu = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fgv) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fgu = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fgu = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fgv = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fgu = i;
                    }
                    PagerSlidingTabBaseStrip.this.fgt = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.epe.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.epd != null) {
                    PagerSlidingTabBaseStrip.this.epd.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.epe.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.epf.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fgt = 0.0f;
                    PagerSlidingTabBaseStrip.this.fgT = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fgv = PagerSlidingTabBaseStrip.this.epf.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fgv;
                    PagerSlidingTabBaseStrip.this.fgu = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.epd != null) {
                    PagerSlidingTabBaseStrip.this.epd.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.epd != null) {
                PagerSlidingTabBaseStrip.this.epd.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.fgT) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fgt * PagerSlidingTabBaseStrip.this.epe.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fgv = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fgu = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Zf;
        this.fgu = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zf = this.mCurrentTabIndex;
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
        int Zf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zf);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fgy = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fgB = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fha = aVar;
    }
}
