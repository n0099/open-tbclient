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
    private int fgA;
    private int fgB;
    private int fgC;
    private int fgD;
    private int fgE;
    private int fgF;
    private int fgG;
    private int fgH;
    private boolean fgI;
    private int fgJ;
    private int fgK;
    private int fgL;
    private float fgM;
    private float fgN;
    private TextView fgO;
    private int fgP;
    private int fgQ;
    private int fgR;
    private int fgS;
    private boolean fgT;
    private a fgU;
    private int[] fgq;
    private FrameLayout.LayoutParams fgr;
    private final b fgs;
    private float fgt;
    private int fgu;
    private int fgv;
    private Paint fgw;
    private RectF fgx;
    private int fgy;
    private boolean fgz;
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
        this.fgs = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fgt = 0.0f;
        this.fgu = 0;
        this.fgv = 0;
        this.epj = false;
        this.fgz = false;
        this.fgA = R.color.cp_other_f;
        this.fgB = R.color.cp_cont_b;
        this.fgC = R.color.cp_cont_j;
        this.epk = ap.getColor(this.fgB);
        this.epl = ap.getColor(this.fgC);
        this.fgD = 52;
        this.mIndicatorHeight = 4;
        this.fgH = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fgI = false;
        this.fgJ = 17;
        this.fgK = 17;
        this.eps = 0;
        this.ept = R.drawable.pager_sliding_view;
        this.fgT = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fgz) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fgr == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fgr);
            }
            addView(this.mContainer);
        }
        this.epe = new LinearLayout(getContext());
        this.epe.setOrientation(0);
        if (this.fgz) {
            this.epe.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.epe);
        } else {
            this.epe.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.epe);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fgD = (int) TypedValue.applyDimension(1, this.fgD, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fgJ = i;
        this.fgK = i2;
        this.fgL = l.getDimens(getContext(), R.dimen.tbds74);
        this.fgM = (this.fgK * 1.0f) / this.fgJ;
        this.fgN = (this.fgL * 1.0f) / this.fgJ;
        this.mIndicatorHeight = i3;
        this.epj = z;
        this.epi = new Paint();
        this.epi.setAntiAlias(true);
        this.epi.setStyle(Paint.Style.FILL);
        this.epi.setColor(ap.getColor(this.fgA));
        this.fgw = new Paint();
        this.fgw.setAntiAlias(true);
        this.fgw.setStyle(Paint.Style.FILL);
        this.fgw.setColor(ap.getColor(R.color.cp_cont_h));
        this.fgx = new RectF();
        this.fgQ = l.getDimens(getContext(), R.dimen.tbds20);
        this.fgR = l.getDimens(getContext(), R.dimen.tbds16);
        this.fgS = l.getDimens(getContext(), R.dimen.tbds25);
        this.epa = new LinearLayout.LayoutParams(-2, -1);
        this.epb = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fgF = l.getDimens(getContext(), R.dimen.tbds22);
        this.fgE = l.getDimens(getContext(), R.dimen.tbds20);
        this.fgG = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fgz && this.mContainer != null) {
            this.fgP = l.getDimens(getContext(), R.dimen.tbds32);
            this.fgO = new TextView(getContext());
            this.fgO.setGravity(17);
            this.fgO.setTextSize(0, this.fgP);
            this.fgO.setSingleLine();
            this.fgO.setTextColor(this.epl);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fgO, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.fgL = i4;
        this.fgN = (this.fgL * 1.0f) / this.fgJ;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fgz = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fgF = i;
        this.fgI = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fgI = true;
    }

    public void setRectPaintColor(int i) {
        this.fgA = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fgE = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fgq = new int[4];
        this.fgq[0] = i;
        this.fgq[1] = i2;
        this.fgq[2] = i3;
        this.fgq[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.epb = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fgr = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fgG = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.epa = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.fgT = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.epf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fgs);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.epd = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.epf != null && this.epf.getAdapter() != null && this.epf.getAdapter().getCount() != 0) {
            this.epe.removeAllViews();
            this.epg = this.epf.getAdapter().getCount();
            int i = 0;
            while (i < this.epg) {
                boolean ru = this.epf.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.epf.getAdapter()).ru(i) : z;
                e(i, this.epf.getAdapter().getPageTitle(i).toString(), ru);
                i++;
                z = ru;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.epf.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fgu = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void CV(String str) {
        if (this.epf != null && this.epf.getAdapter() != null && this.epf.getAdapter().getCount() != 0 && this.fgz && this.fgO != null) {
            this.fgO.setText(str);
        }
    }

    private void e(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fgJ);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fgU != null) {
                        NewPagerSlidingTabBaseStrip.this.fgU.l(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.epf.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.fgT = true;
                        NewPagerSlidingTabBaseStrip.this.epf.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fgq != null && this.fgq.length == 4) {
            view.setPadding(this.fgq[0], this.fgq[1], this.fgq[2], this.fgq[3]);
        }
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
        float left;
        float right;
        float left2;
        float right2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.epg != 0) {
            View childAt = this.epe.getChildAt(this.mCurrentTabIndex);
            if (this.fgI && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fgF;
                right = childAt.getRight() - this.fgF;
            }
            if (this.fgt > 0.0f && this.mCurrentTabIndex != this.fgu && this.fgu <= this.epg - 1 && this.fgu >= 0) {
                View childAt2 = this.epe.getChildAt(this.fgu);
                if (this.fgI && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fgF;
                    right2 = childAt2.getRight() - this.fgF;
                }
                left = e(left, left2, this.fgt);
                right = f(right, right2, this.fgt);
            }
            int height = getHeight();
            if (this.Gl == null) {
                this.Gl = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fgE, right + getPaddingLeft(), height - this.fgE);
            } else {
                this.Gl.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fgE, right + getPaddingLeft(), height - this.fgE);
            }
            canvas.drawRoundRect(this.Gl, this.fgH, this.fgH, this.epi);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fgG + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fgG + f2) - ((this.fgG * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fgG + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fgG) + ((this.fgG * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fgB = R.color.cp_cont_b;
            this.fgC = R.color.cp_cont_j;
        } else {
            this.fgB = R.color.cp_cont_a;
            this.fgC = R.color.cp_cont_a;
        }
        this.epk = ap.getColor(this.fgB);
        this.epl = ap.getColor(this.fgC);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.epk = ap.getColor(this.fgB);
            this.epl = ap.getColor(this.fgC);
            this.epi.setColor(ap.getColor(this.fgA));
            this.fgw.setColor(ap.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
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
                    if (f2 >= 0.5f) {
                        if (i == this.fgu) {
                            textView.setTextColor(this.epk);
                        } else {
                            textView.setTextColor(this.epl);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.epk);
                    } else {
                        textView.setTextColor(this.epl);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fgu) {
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
            if (NewPagerSlidingTabBaseStrip.this.epe.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.fgT) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fgv) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fgu = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fgv) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fgu = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fgu = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fgv = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fgu = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fgt = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.epe.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.epd != null) {
                    NewPagerSlidingTabBaseStrip.this.epd.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.epe.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.epf.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fgt = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.fgT = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fgv = NewPagerSlidingTabBaseStrip.this.epf.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fgv;
                    NewPagerSlidingTabBaseStrip.this.fgu = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.epd != null) {
                    NewPagerSlidingTabBaseStrip.this.epd.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.epd != null) {
                NewPagerSlidingTabBaseStrip.this.epd.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.fgT) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fgt * NewPagerSlidingTabBaseStrip.this.epe.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fgv = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fgu = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.epe.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.epe.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.epe.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
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

    public void setNormalSelectorColorResId(int i) {
        this.fgC = i;
    }

    public void setIndicatorRadius(int i) {
        this.fgH = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fgU = aVar;
    }

    /* loaded from: classes15.dex */
    public class TabTextView extends TextView {
        boolean fgW;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fgW = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fgW = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fgW) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fgS) - NewPagerSlidingTabBaseStrip.this.fgQ;
                int i = NewPagerSlidingTabBaseStrip.this.fgR;
                NewPagerSlidingTabBaseStrip.this.fgx.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fgQ, i + NewPagerSlidingTabBaseStrip.this.fgQ);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fgx, NewPagerSlidingTabBaseStrip.this.fgw);
            }
        }
    }
}
