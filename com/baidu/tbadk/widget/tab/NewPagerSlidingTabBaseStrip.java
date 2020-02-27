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
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes8.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private FrameLayout.LayoutParams dPL;
    private final b dPM;
    private float dPN;
    private int dPO;
    private int dPP;
    private Paint dPQ;
    private RectF dPR;
    private boolean dPS;
    private int dPT;
    private boolean dPU;
    private int dPV;
    private int dPW;
    private int dPX;
    private int dPY;
    private int dPZ;
    private int dQa;
    private int dQb;
    private int dQc;
    private int dQd;
    private int dQe;
    private int dQf;
    private float dQg;
    private float dQh;
    private TextView dQi;
    private int dQj;
    private int dQk;
    private int dQl;
    private int dQm;
    private boolean dQn;
    private a dQo;
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
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void k(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dPM = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dPN = 0.0f;
        this.dPO = 0;
        this.dPP = 0;
        this.deo = false;
        this.dPU = false;
        this.dPV = R.color.cp_other_f;
        this.dPW = R.color.cp_cont_b;
        this.dPX = R.color.cp_cont_j;
        this.dep = am.getColor(this.dPW);
        this.deq = am.getColor(this.dPX);
        this.dPY = 52;
        this.mIndicatorHeight = 4;
        this.dQc = 16;
        this.dividerPadding = 12;
        this.dgq = 1;
        this.dQd = 17;
        this.dQe = 17;
        this.deA = 0;
        this.deB = R.drawable.pager_sliding_view;
        this.dQn = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.dPU) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.dPL == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.dPL);
            }
            addView(this.mContainer);
        }
        this.dej = new LinearLayout(getContext());
        this.dej.setOrientation(0);
        if (this.dPU) {
            this.dej.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.dej);
        } else {
            this.dej.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.dej);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dPY = (int) TypedValue.applyDimension(1, this.dPY, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dgq = (int) TypedValue.applyDimension(1, this.dgq, displayMetrics);
        this.dQd = i;
        this.dQe = i2;
        this.dQf = l.getDimens(getContext(), R.dimen.tbds74);
        this.dQg = (this.dQe * 1.0f) / this.dQd;
        this.dQh = (this.dQf * 1.0f) / this.dQd;
        this.mIndicatorHeight = i3;
        this.deo = z;
        this.den = new Paint();
        this.den.setAntiAlias(true);
        this.den.setStyle(Paint.Style.FILL);
        this.den.setColor(am.getColor(this.dPV));
        this.dPQ = new Paint();
        this.dPQ.setAntiAlias(true);
        this.dPQ.setStyle(Paint.Style.FILL);
        this.dPQ.setColor(am.getColor(R.color.cp_cont_h));
        this.dPR = new RectF();
        this.dQk = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQl = l.getDimens(getContext(), R.dimen.tbds28);
        this.dQm = l.getDimens(getContext(), R.dimen.tbds22);
        this.def = new LinearLayout.LayoutParams(-2, -1);
        this.deg = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.dQa = l.getDimens(getContext(), R.dimen.tbds22);
        this.dPZ = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQb = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.dPU && this.mContainer != null) {
            this.dQj = l.getDimens(getContext(), R.dimen.tbds32);
            this.dQi = new TextView(getContext());
            this.dQi.setGravity(17);
            this.dQi.setTextSize(0, this.dQj);
            this.dQi.setSingleLine();
            this.dQi.setTextColor(this.deq);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.dQi, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.dQf = i4;
        this.dQh = (this.dQf * 1.0f) / this.dQd;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.dPU = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.dQa = i;
    }

    public void setRectPaintColor(int i) {
        this.dPV = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.dPZ = i;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deg = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.dPL = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.dQb = i;
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
            viewPager.setOnPageChangeListener(this.dPM);
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
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dek.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.dPO = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void wi(String str) {
        if (this.dek != null && this.dek.getAdapter() != null && this.dek.getAdapter().getCount() != 0 && this.dPU && this.dQi != null) {
            this.dQi.setText(str);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.dQo != null) {
                        NewPagerSlidingTabBaseStrip.this.dQo.k(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.dek.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.dQn = true;
                        NewPagerSlidingTabBaseStrip.this.dek.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
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
            canvas.drawRoundRect(this.jH, this.dQc, this.dQc, this.den);
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
            if (f3 <= 0.8d) {
                return f + ((((this.dQb + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dQb + f2) - ((this.dQb * (f3 - 0.8f)) / 0.2f);
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
            if (f3 >= 0.2d) {
                return f - ((((this.dQb + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dQb) + ((this.dQb * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.dPW = R.color.cp_cont_b;
            this.dPX = R.color.cp_cont_j;
        } else {
            this.dPW = R.color.cp_cont_a;
            this.dPX = R.color.cp_cont_a;
        }
        this.dep = am.getColor(this.dPW);
        this.deq = am.getColor(this.dPX);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dep = am.getColor(this.dPW);
            this.deq = am.getColor(this.dPX);
            this.den.setColor(am.getColor(this.dPV));
            this.dPQ.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
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
                    if (f2 >= 0.5f) {
                        if (i == this.dPO) {
                            textView.setTextColor(this.dep);
                        } else {
                            textView.setTextColor(this.deq);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dep);
                    } else {
                        textView.setTextColor(this.deq);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dPO) {
                            textView.setTypeface(Typeface.defaultFromStyle(1));
                        } else {
                            textView.setTypeface(Typeface.defaultFromStyle(0));
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
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
            if (NewPagerSlidingTabBaseStrip.this.dej.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.dQn) {
                    if (i == NewPagerSlidingTabBaseStrip.this.dPP) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dPO = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.dPP) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dPO = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.dPO = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.dPP = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dPO = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.dPN = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dej.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.dei != null) {
                    NewPagerSlidingTabBaseStrip.this.dei.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dej.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.dek.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.dPN = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.dQn = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.dPP = NewPagerSlidingTabBaseStrip.this.dek.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dPP;
                    NewPagerSlidingTabBaseStrip.this.dPO = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.dei != null) {
                    NewPagerSlidingTabBaseStrip.this.dei.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dei != null) {
                NewPagerSlidingTabBaseStrip.this.dei.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.dQn) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dPN * NewPagerSlidingTabBaseStrip.this.dej.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.dPP = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.dPO = i;
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: X */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ny */
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

    public void setNormalSelectorColorResId(int i) {
        this.dPX = i;
    }

    public void setIndicatorRadius(int i) {
        this.dQc = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dQo = aVar;
    }
}
