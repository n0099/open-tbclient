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
    private FrameLayout.LayoutParams dPM;
    private final b dPN;
    private float dPO;
    private int dPP;
    private int dPQ;
    private Paint dPR;
    private RectF dPS;
    private boolean dPT;
    private int dPU;
    private boolean dPV;
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
    private int dQg;
    private float dQh;
    private float dQi;
    private TextView dQj;
    private int dQk;
    private int dQl;
    private int dQm;
    private int dQn;
    private boolean dQo;
    private a dQp;
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
        this.dPN = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dPO = 0.0f;
        this.dPP = 0;
        this.dPQ = 0;
        this.dep = false;
        this.dPV = false;
        this.dPW = R.color.cp_other_f;
        this.dPX = R.color.cp_cont_b;
        this.dPY = R.color.cp_cont_j;
        this.deq = am.getColor(this.dPX);
        this.der = am.getColor(this.dPY);
        this.dPZ = 52;
        this.mIndicatorHeight = 4;
        this.dQd = 16;
        this.dividerPadding = 12;
        this.dgr = 1;
        this.dQe = 17;
        this.dQf = 17;
        this.deB = 0;
        this.deC = R.drawable.pager_sliding_view;
        this.dQo = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.dPV) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.dPM == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.dPM);
            }
            addView(this.mContainer);
        }
        this.dek = new LinearLayout(getContext());
        this.dek.setOrientation(0);
        if (this.dPV) {
            this.dek.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.dek);
        } else {
            this.dek.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.dek);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dPZ = (int) TypedValue.applyDimension(1, this.dPZ, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dgr = (int) TypedValue.applyDimension(1, this.dgr, displayMetrics);
        this.dQe = i;
        this.dQf = i2;
        this.dQg = l.getDimens(getContext(), R.dimen.tbds74);
        this.dQh = (this.dQf * 1.0f) / this.dQe;
        this.dQi = (this.dQg * 1.0f) / this.dQe;
        this.mIndicatorHeight = i3;
        this.dep = z;
        this.deo = new Paint();
        this.deo.setAntiAlias(true);
        this.deo.setStyle(Paint.Style.FILL);
        this.deo.setColor(am.getColor(this.dPW));
        this.dPR = new Paint();
        this.dPR.setAntiAlias(true);
        this.dPR.setStyle(Paint.Style.FILL);
        this.dPR.setColor(am.getColor(R.color.cp_cont_h));
        this.dPS = new RectF();
        this.dQl = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQm = l.getDimens(getContext(), R.dimen.tbds28);
        this.dQn = l.getDimens(getContext(), R.dimen.tbds22);
        this.deg = new LinearLayout.LayoutParams(-2, -1);
        this.deh = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.dQb = l.getDimens(getContext(), R.dimen.tbds22);
        this.dQa = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQc = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.dPV && this.mContainer != null) {
            this.dQk = l.getDimens(getContext(), R.dimen.tbds32);
            this.dQj = new TextView(getContext());
            this.dQj.setGravity(17);
            this.dQj.setTextSize(0, this.dQk);
            this.dQj.setSingleLine();
            this.dQj.setTextColor(this.der);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.dQj, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.dQg = i4;
        this.dQi = (this.dQg * 1.0f) / this.dQe;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.dPV = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.dQb = i;
    }

    public void setRectPaintColor(int i) {
        this.dPW = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.dQa = i;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deh = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.dPM = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.dQc = i;
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
            viewPager.setOnPageChangeListener(this.dPN);
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
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.del.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.dPP = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void wi(String str) {
        if (this.del != null && this.del.getAdapter() != null && this.del.getAdapter().getCount() != 0 && this.dPV && this.dQj != null) {
            this.dQj.setText(str);
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.dQp != null) {
                        NewPagerSlidingTabBaseStrip.this.dQp.k(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.del.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.dQo = true;
                        NewPagerSlidingTabBaseStrip.this.del.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
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
            canvas.drawRoundRect(this.jH, this.dQd, this.dQd, this.deo);
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
            if (f3 <= 0.8d) {
                return f + ((((this.dQc + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dQc + f2) - ((this.dQc * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.dQc + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dQc) + ((this.dQc * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.dPX = R.color.cp_cont_b;
            this.dPY = R.color.cp_cont_j;
        } else {
            this.dPX = R.color.cp_cont_a;
            this.dPY = R.color.cp_cont_a;
        }
        this.deq = am.getColor(this.dPX);
        this.der = am.getColor(this.dPY);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.deq = am.getColor(this.dPX);
            this.der = am.getColor(this.dPY);
            this.deo.setColor(am.getColor(this.dPW));
            this.dPR.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
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
                    if (f2 >= 0.5f) {
                        if (i == this.dPP) {
                            textView.setTextColor(this.deq);
                        } else {
                            textView.setTextColor(this.der);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.deq);
                    } else {
                        textView.setTextColor(this.der);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dPP) {
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
            if (NewPagerSlidingTabBaseStrip.this.dek.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.dQo) {
                    if (i == NewPagerSlidingTabBaseStrip.this.dPQ) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dPP = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.dPQ) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dPP = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.dPP = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.dPQ = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dPP = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.dPO = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dek.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.dej != null) {
                    NewPagerSlidingTabBaseStrip.this.dej.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dek.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.del.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.dPO = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.dQo = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.dPQ = NewPagerSlidingTabBaseStrip.this.del.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dPQ;
                    NewPagerSlidingTabBaseStrip.this.dPP = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.dej != null) {
                    NewPagerSlidingTabBaseStrip.this.dej.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dej != null) {
                NewPagerSlidingTabBaseStrip.this.dej.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.dQo) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dPO * NewPagerSlidingTabBaseStrip.this.dek.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.dPQ = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.dPP = i;
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
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
        this.dPU = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dPX = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.dPY = i;
    }

    public void setIndicatorRadius(int i) {
        this.dQd = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dQp = aVar;
    }
}
