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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes15.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF Gl;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams epe;
    private LinearLayout.LayoutParams epf;
    public ViewPager.OnPageChangeListener eph;
    private LinearLayout epi;
    private ViewPager epj;
    private int epk;
    private Paint epm;
    private boolean epn;
    private int epo;
    private int epp;
    private int epw;
    private int epx;
    private Paint fgA;
    private RectF fgB;
    private int fgC;
    private boolean fgD;
    private int fgE;
    private int fgF;
    private int fgG;
    private int fgH;
    private int fgI;
    private int fgJ;
    private int fgK;
    private int fgL;
    private boolean fgM;
    private int fgN;
    private int fgO;
    private int fgP;
    private float fgQ;
    private float fgR;
    private TextView fgS;
    private int fgT;
    private int fgU;
    private int fgV;
    private int fgW;
    private boolean fgX;
    private a fgY;
    private int[] fgu;
    private FrameLayout.LayoutParams fgv;
    private final b fgw;
    private float fgx;
    private int fgy;
    private int fgz;
    private boolean isLoading;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
    private int mSkinType;

    /* loaded from: classes15.dex */
    public interface a {
        void l(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fgw = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fgx = 0.0f;
        this.fgy = 0;
        this.fgz = 0;
        this.epn = false;
        this.fgD = false;
        this.fgE = R.color.cp_other_f;
        this.fgF = R.color.cp_cont_b;
        this.fgG = R.color.cp_cont_j;
        this.epo = ap.getColor(this.fgF);
        this.epp = ap.getColor(this.fgG);
        this.fgH = 52;
        this.mIndicatorHeight = 4;
        this.fgL = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fgM = false;
        this.fgN = 17;
        this.fgO = 17;
        this.epw = 0;
        this.epx = R.drawable.pager_sliding_view;
        this.fgX = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fgD) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fgv == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fgv);
            }
            addView(this.mContainer);
        }
        this.epi = new LinearLayout(getContext());
        this.epi.setOrientation(0);
        if (this.fgD) {
            this.epi.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.epi);
        } else {
            this.epi.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.epi);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fgH = (int) TypedValue.applyDimension(1, this.fgH, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fgN = i;
        this.fgO = i2;
        this.fgP = l.getDimens(getContext(), R.dimen.tbds74);
        this.fgQ = (this.fgO * 1.0f) / this.fgN;
        this.fgR = (this.fgP * 1.0f) / this.fgN;
        this.mIndicatorHeight = i3;
        this.epn = z;
        this.epm = new Paint();
        this.epm.setAntiAlias(true);
        this.epm.setStyle(Paint.Style.FILL);
        this.epm.setColor(ap.getColor(this.fgE));
        this.fgA = new Paint();
        this.fgA.setAntiAlias(true);
        this.fgA.setStyle(Paint.Style.FILL);
        this.fgA.setColor(ap.getColor(R.color.cp_cont_h));
        this.fgB = new RectF();
        this.fgU = l.getDimens(getContext(), R.dimen.tbds20);
        this.fgV = l.getDimens(getContext(), R.dimen.tbds16);
        this.fgW = l.getDimens(getContext(), R.dimen.tbds25);
        this.epe = new LinearLayout.LayoutParams(-2, -1);
        this.epf = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fgJ = l.getDimens(getContext(), R.dimen.tbds22);
        this.fgI = l.getDimens(getContext(), R.dimen.tbds20);
        this.fgK = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fgD && this.mContainer != null) {
            this.fgT = l.getDimens(getContext(), R.dimen.tbds32);
            this.fgS = new TextView(getContext());
            this.fgS.setGravity(17);
            this.fgS.setTextSize(0, this.fgT);
            this.fgS.setSingleLine();
            this.fgS.setTextColor(this.epp);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fgS, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.fgP = i4;
        this.fgR = (this.fgP * 1.0f) / this.fgN;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fgD = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fgJ = i;
        this.fgM = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fgM = true;
    }

    public void setRectPaintColor(int i) {
        this.fgE = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fgI = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fgu = new int[4];
        this.fgu[0] = i;
        this.fgu[1] = i2;
        this.fgu[2] = i3;
        this.fgu[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.epf = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fgv = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fgK = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.epe = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.fgX = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.epj = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fgw);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eph = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.epj != null && this.epj.getAdapter() != null && this.epj.getAdapter().getCount() != 0) {
            this.epi.removeAllViews();
            this.epk = this.epj.getAdapter().getCount();
            int i = 0;
            while (i < this.epk) {
                boolean ru = this.epj.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.epj.getAdapter()).ru(i) : z;
                e(i, this.epj.getAdapter().getPageTitle(i).toString(), ru);
                i++;
                z = ru;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.epj.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fgy = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void CW(String str) {
        if (this.epj != null && this.epj.getAdapter() != null && this.epj.getAdapter().getCount() != 0 && this.fgD && this.fgS != null) {
            this.fgS.setText(str);
        }
    }

    private void e(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fgN);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fgY != null) {
                        NewPagerSlidingTabBaseStrip.this.fgY.l(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.epj.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.fgX = true;
                        NewPagerSlidingTabBaseStrip.this.epj.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fgu != null && this.fgu.length == 4) {
            view.setPadding(this.fgu[0], this.fgu[1], this.fgu[2], this.fgu[3]);
        }
        this.epi.addView(view, i, this.epn ? this.epf : this.epe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.epk != 0) {
            int left = this.epi.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fgH;
            }
            if (left != this.epw) {
                this.epw = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float left;
        float right;
        float left2;
        float right2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.epk != 0) {
            View childAt = this.epi.getChildAt(this.mCurrentTabIndex);
            if (this.fgM && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fgJ;
                right = childAt.getRight() - this.fgJ;
            }
            if (this.fgx > 0.0f && this.mCurrentTabIndex != this.fgy && this.fgy <= this.epk - 1 && this.fgy >= 0) {
                View childAt2 = this.epi.getChildAt(this.fgy);
                if (this.fgM && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fgJ;
                    right2 = childAt2.getRight() - this.fgJ;
                }
                left = e(left, left2, this.fgx);
                right = f(right, right2, this.fgx);
            }
            int height = getHeight();
            if (this.Gl == null) {
                this.Gl = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fgI, right + getPaddingLeft(), height - this.fgI);
            } else {
                this.Gl.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fgI, right + getPaddingLeft(), height - this.fgI);
            }
            canvas.drawRoundRect(this.Gl, this.fgL, this.fgL, this.epm);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fgK + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fgK + f2) - ((this.fgK * (f3 - 0.8f)) / 0.2f);
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
            if (f3 >= 0.2d) {
                return f - ((((this.fgK + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fgK) + ((this.fgK * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fgF = R.color.cp_cont_b;
            this.fgG = R.color.cp_cont_j;
        } else {
            this.fgF = R.color.cp_cont_a;
            this.fgG = R.color.cp_cont_a;
        }
        this.epo = ap.getColor(this.fgF);
        this.epp = ap.getColor(this.fgG);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.epo = ap.getColor(this.fgF);
            this.epp = ap.getColor(this.fgG);
            this.epm.setColor(ap.getColor(this.fgE));
            this.fgA.setColor(ap.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float ah(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fgR - 1.0f) / (0.1f - 1.0f))) + this.fgR;
        }
        return (((this.fgR - this.fgQ) / 0.1f) * f) + this.fgQ;
    }

    private float ai(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fgR) / (0.1f - 0.9f)));
        }
        return (((this.fgR - this.fgQ) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fgR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ai;
        float f = this.fgx;
        float f2 = this.fgy < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.epk) {
            View childAt = this.epi.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.epx);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ai = ah(f2);
                    } else {
                        ai = i == this.fgy ? ai(f2) : 1.0f;
                    }
                    textView.setScaleX(ai);
                    textView.setScaleY(ai);
                    if (f2 >= 0.5f) {
                        if (i == this.fgy) {
                            textView.setTextColor(this.epo);
                        } else {
                            textView.setTextColor(this.epp);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.epo);
                    } else {
                        textView.setTextColor(this.epp);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fgy) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (NewPagerSlidingTabBaseStrip.this.epi.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.fgX) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fgz) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fgy = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fgz) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fgy = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fgy = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fgz = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fgy = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fgx = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.epi.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.eph != null) {
                    NewPagerSlidingTabBaseStrip.this.eph.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.epi.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.epj.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fgx = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.fgX = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fgz = NewPagerSlidingTabBaseStrip.this.epj.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fgz;
                    NewPagerSlidingTabBaseStrip.this.fgy = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.eph != null) {
                    NewPagerSlidingTabBaseStrip.this.eph.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eph != null) {
                NewPagerSlidingTabBaseStrip.this.eph.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.fgX) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fgx * NewPagerSlidingTabBaseStrip.this.epi.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fgz = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fgy = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.epi.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.epi.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.epi.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Zh;
        this.fgy = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zh = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: T */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: rv */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Zh;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zh = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zh);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fgC = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fgF = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.fgG = i;
    }

    public void setIndicatorRadius(int i) {
        this.fgL = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fgY = aVar;
    }

    /* loaded from: classes15.dex */
    public class TabTextView extends TextView {
        boolean fha;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fha = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fha = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fha) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fgW) - NewPagerSlidingTabBaseStrip.this.fgU;
                int i = NewPagerSlidingTabBaseStrip.this.fgV;
                NewPagerSlidingTabBaseStrip.this.fgB.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fgU, i + NewPagerSlidingTabBaseStrip.this.fgU);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fgB, NewPagerSlidingTabBaseStrip.this.fgA);
            }
        }
    }
}
