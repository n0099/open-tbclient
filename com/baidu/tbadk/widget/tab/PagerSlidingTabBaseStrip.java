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
    private int dQA;
    private boolean dQB;
    private final b dQE;
    private boolean dQF;
    private a dQG;
    private float dQb;
    private int dQc;
    private int dQd;
    private Paint dQe;
    private RectF dQf;
    private boolean dQg;
    private int dQh;
    private int dQk;
    private int dQm;
    private int dQn;
    private int dQo;
    private int dQp;
    private int dQr;
    private int dQs;
    private float dQu;
    private float dQv;
    private int dQy;
    private int dQz;
    private int deA;
    private Paint deC;
    private boolean deD;
    private int deE;
    private int deF;
    private int deO;
    private int deP;
    private LinearLayout.LayoutParams deu;
    private LinearLayout.LayoutParams dev;
    public ViewPager.OnPageChangeListener dex;
    private LinearLayout dey;
    private ViewPager dez;
    private int dgE;
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
        this.dQE = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dQb = 0.0f;
        this.dQc = 0;
        this.dQd = 0;
        this.deD = false;
        this.dQk = R.color.cp_cont_b;
        this.deE = am.getColor(this.dQk);
        this.deF = am.getColor(R.color.cp_cont_j);
        this.dQm = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dgE = 1;
        this.dQr = 17;
        this.dQs = 17;
        this.deO = 0;
        this.deP = R.drawable.pager_sliding_view;
        this.dQB = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.dQo = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deu = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dQg = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dQB = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dez = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dQE);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dex = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dez != null && this.dez.getAdapter() != null && this.dez.getAdapter().getCount() != 0) {
            this.dey.removeAllViews();
            this.deA = this.dez.getAdapter().getCount();
            for (int i = 0; i < this.deA; i++) {
                R(i, this.dez.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dez.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.dQc = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.dQr);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.dQG != null) {
                        PagerSlidingTabBaseStrip.this.dQG.k(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.dez.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.dQB = true;
                        PagerSlidingTabBaseStrip.this.dez.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dey.addView(view, i, this.deD ? this.dev : this.deu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.deA != 0) {
            int left = this.dey.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dQm;
            }
            if (left != this.deO) {
                this.deO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.deA != 0) {
            View childAt = this.dey.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQo;
            float right2 = childAt.getRight() - this.dQo;
            if (this.dQb > 0.0f && this.mCurrentTabIndex != this.dQc && this.dQc <= this.deA - 1 && this.dQc >= 0) {
                View childAt2 = this.dey.getChildAt(this.dQc);
                left = d(left, childAt2.getLeft() + this.dQo, this.dQb);
                right2 = e(right2, childAt2.getRight() - this.dQo, this.dQb);
            }
            int height = getHeight();
            if (this.jH == null) {
                this.jH = new RectF(left, (height - this.mIndicatorHeight) - this.dQn, right2, height - this.dQn);
            } else {
                this.jH.set(left, (height - this.mIndicatorHeight) - this.dQn, right2, height - this.dQn);
            }
            canvas.drawRoundRect(this.jH, 16.0f, 16.0f, this.deC);
            if (this.dQg) {
                View childAt3 = this.dey.getChildAt(this.dQh);
                this.dQf.set((childAt3.getRight() - this.dQA) - this.dQy, childAt3.getTop() + this.dQz, right + this.dQy, top2 + this.dQy);
                canvas.drawOval(this.dQf, this.dQe);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.dQp + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.dQp + f2) - ((this.dQp * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.dQp) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.dQp) + ((this.dQp * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.dQF = z;
        if (!z) {
            this.deE = am.getColor(this.dQk);
            this.deF = am.getColor(R.color.cp_cont_j);
        } else {
            this.deE = am.getColor(R.color.cp_cont_a);
            this.deF = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQv - 1.0f) / (0.1f - 1.0f))) + this.dQv;
        }
        return (((this.dQv - this.dQu) / 0.1f) * f) + this.dQu;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQv) / (0.1f - 0.9f)));
        }
        return (((this.dQv - this.dQu) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dQb;
        float f2 = this.dQc < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.deA) {
            View childAt = this.dey.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dQc ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (at <= 1.0f) {
                        textView.setTextColor(this.deF);
                    } else {
                        textView.setTextColor(this.deE);
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
            if (PagerSlidingTabBaseStrip.this.dey.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.dQB) {
                    if (i == PagerSlidingTabBaseStrip.this.dQd) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dQc = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.dQd) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dQc = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.dQc = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.dQd = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.dQc = i;
                    }
                    PagerSlidingTabBaseStrip.this.dQb = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dey.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.dex != null) {
                    PagerSlidingTabBaseStrip.this.dex.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.dey.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.dez.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.dQb = 0.0f;
                    PagerSlidingTabBaseStrip.this.dQB = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.dQd = PagerSlidingTabBaseStrip.this.dez.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.dQd;
                    PagerSlidingTabBaseStrip.this.dQc = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.dex != null) {
                    PagerSlidingTabBaseStrip.this.dex.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.dex != null) {
                PagerSlidingTabBaseStrip.this.dex.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.dQB) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.dQb * PagerSlidingTabBaseStrip.this.dey.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.dQd = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.dQc = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dQc = this.mCurrentTabIndex;
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
        this.dQh = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dQk = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dQG = aVar;
    }
}
