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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes8.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF Fg;
    private int dQl;
    private ViewPager dSA;
    private int dSB;
    private Paint dSD;
    private boolean dSE;
    private int dSF;
    private int dSO;
    private int dSP;
    private LinearLayout.LayoutParams dSv;
    private LinearLayout.LayoutParams dSw;
    public ViewPager.OnPageChangeListener dSy;
    private LinearLayout dSz;
    private int dUE;
    private int dividerPadding;
    private int eFA;
    private int eFB;
    private int eFC;
    private int eFD;
    private boolean eFE;
    private a eFF;
    private int[] eFb;
    private FrameLayout.LayoutParams eFc;
    private final b eFd;
    private float eFe;
    private int eFf;
    private int eFg;
    private Paint eFh;
    private RectF eFi;
    private int eFj;
    private boolean eFk;
    private int eFl;
    private int eFm;
    private int eFn;
    private int eFo;
    private int eFp;
    private int eFq;
    private int eFr;
    private int eFs;
    private boolean eFt;
    private int eFu;
    private int eFv;
    private int eFw;
    private float eFx;
    private float eFy;
    private TextView eFz;
    private boolean isLoading;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
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
        this.eFd = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eFe = 0.0f;
        this.eFf = 0;
        this.eFg = 0;
        this.dSE = false;
        this.eFk = false;
        this.eFl = R.color.cp_other_f;
        this.eFm = R.color.cp_cont_b;
        this.eFn = R.color.cp_cont_j;
        this.dSF = am.getColor(this.eFm);
        this.dQl = am.getColor(this.eFn);
        this.eFo = 52;
        this.mIndicatorHeight = 4;
        this.eFs = 16;
        this.dividerPadding = 12;
        this.dUE = 1;
        this.eFt = false;
        this.eFu = 17;
        this.eFv = 17;
        this.dSO = 0;
        this.dSP = R.drawable.pager_sliding_view;
        this.eFE = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.eFk) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.eFc == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.eFc);
            }
            addView(this.mContainer);
        }
        this.dSz = new LinearLayout(getContext());
        this.dSz.setOrientation(0);
        if (this.eFk) {
            this.dSz.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.dSz);
        } else {
            this.dSz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.dSz);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eFo = (int) TypedValue.applyDimension(1, this.eFo, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dUE = (int) TypedValue.applyDimension(1, this.dUE, displayMetrics);
        this.eFu = i;
        this.eFv = i2;
        this.eFw = l.getDimens(getContext(), R.dimen.tbds74);
        this.eFx = (this.eFv * 1.0f) / this.eFu;
        this.eFy = (this.eFw * 1.0f) / this.eFu;
        this.mIndicatorHeight = i3;
        this.dSE = z;
        this.dSD = new Paint();
        this.dSD.setAntiAlias(true);
        this.dSD.setStyle(Paint.Style.FILL);
        this.dSD.setColor(am.getColor(this.eFl));
        this.eFh = new Paint();
        this.eFh.setAntiAlias(true);
        this.eFh.setStyle(Paint.Style.FILL);
        this.eFh.setColor(am.getColor(R.color.cp_cont_h));
        this.eFi = new RectF();
        this.eFB = l.getDimens(getContext(), R.dimen.tbds20);
        this.eFC = l.getDimens(getContext(), R.dimen.tbds16);
        this.eFD = l.getDimens(getContext(), R.dimen.tbds25);
        this.dSv = new LinearLayout.LayoutParams(-2, -1);
        this.dSw = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.eFq = l.getDimens(getContext(), R.dimen.tbds22);
        this.eFp = l.getDimens(getContext(), R.dimen.tbds20);
        this.eFr = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.eFk && this.mContainer != null) {
            this.eFA = l.getDimens(getContext(), R.dimen.tbds32);
            this.eFz = new TextView(getContext());
            this.eFz.setGravity(17);
            this.eFz.setTextSize(0, this.eFA);
            this.eFz.setSingleLine();
            this.eFz.setTextColor(this.dQl);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.eFz, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.eFw = i4;
        this.eFy = (this.eFw * 1.0f) / this.eFu;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.eFk = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.eFq = i;
        this.eFt = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.eFt = true;
    }

    public void setRectPaintColor(int i) {
        this.eFl = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.eFp = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.eFb = new int[4];
        this.eFb[0] = i;
        this.eFb[1] = i2;
        this.eFb[2] = i3;
        this.eFb[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dSw = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.eFc = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.eFr = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dSv = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.eFE = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dSA = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eFd);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dSy = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.dSA != null && this.dSA.getAdapter() != null && this.dSA.getAdapter().getCount() != 0) {
            this.dSz.removeAllViews();
            this.dSB = this.dSA.getAdapter().getCount();
            int i = 0;
            while (i < this.dSB) {
                boolean ot = this.dSA.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.dSA.getAdapter()).ot(i) : z;
                f(i, this.dSA.getAdapter().getPageTitle(i).toString(), ot);
                i++;
                z = ot;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dSA.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.eFf = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void zf(String str) {
        if (this.dSA != null && this.dSA.getAdapter() != null && this.dSA.getAdapter().getCount() != 0 && this.eFk && this.eFz != null) {
            this.eFz.setText(str);
        }
    }

    private void f(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.eFu);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.eFF != null) {
                        NewPagerSlidingTabBaseStrip.this.eFF.k(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.dSA.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.eFE = true;
                        NewPagerSlidingTabBaseStrip.this.dSA.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.eFb != null && this.eFb.length == 4) {
            view.setPadding(this.eFb[0], this.eFb[1], this.eFb[2], this.eFb[3]);
        }
        this.dSz.addView(view, i, this.dSE ? this.dSw : this.dSv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dSB != 0) {
            int left = this.dSz.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eFo;
            }
            if (left != this.dSO) {
                this.dSO = left;
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
        if (!isInEditMode() && this.dSB != 0) {
            View childAt = this.dSz.getChildAt(this.mCurrentTabIndex);
            if (this.eFt && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.eFq;
                right = childAt.getRight() - this.eFq;
            }
            if (this.eFe > 0.0f && this.mCurrentTabIndex != this.eFf && this.eFf <= this.dSB - 1 && this.eFf >= 0) {
                View childAt2 = this.dSz.getChildAt(this.eFf);
                if (this.eFt && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.eFq;
                    right2 = childAt2.getRight() - this.eFq;
                }
                left = e(left, left2, this.eFe);
                right = f(right, right2, this.eFe);
            }
            int height = getHeight();
            if (this.Fg == null) {
                this.Fg = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eFp, right + getPaddingLeft(), height - this.eFp);
            } else {
                this.Fg.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eFp, right + getPaddingLeft(), height - this.eFp);
            }
            canvas.drawRoundRect(this.Fg, this.eFs, this.eFs, this.dSD);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.eFr + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.eFr + f2) - ((this.eFr * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.eFr + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.eFr) + ((this.eFr * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.eFm = R.color.cp_cont_b;
            this.eFn = R.color.cp_cont_j;
        } else {
            this.eFm = R.color.cp_cont_a;
            this.eFn = R.color.cp_cont_a;
        }
        this.dSF = am.getColor(this.eFm);
        this.dQl = am.getColor(this.eFn);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dSF = am.getColor(this.eFm);
            this.dQl = am.getColor(this.eFn);
            this.dSD.setColor(am.getColor(this.eFl));
            this.eFh.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float aa(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eFy - 1.0f) / (0.1f - 1.0f))) + this.eFy;
        }
        return (((this.eFy - this.eFx) / 0.1f) * f) + this.eFx;
    }

    private float ab(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eFy) / (0.1f - 0.9f)));
        }
        return (((this.eFy - this.eFx) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eFy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ab;
        float f = this.eFe;
        float f2 = this.eFf < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dSB) {
            View childAt = this.dSz.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dSP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ab = aa(f2);
                    } else {
                        ab = i == this.eFf ? ab(f2) : 1.0f;
                    }
                    textView.setScaleX(ab);
                    textView.setScaleY(ab);
                    if (f2 >= 0.5f) {
                        if (i == this.eFf) {
                            textView.setTextColor(this.dSF);
                        } else {
                            textView.setTextColor(this.dQl);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dSF);
                    } else {
                        textView.setTextColor(this.dQl);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.eFf) {
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
            if (NewPagerSlidingTabBaseStrip.this.dSz.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.eFE) {
                    if (i == NewPagerSlidingTabBaseStrip.this.eFg) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eFf = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.eFg) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eFf = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.eFf = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.eFg = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eFf = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.eFe = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dSz.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.dSy != null) {
                    NewPagerSlidingTabBaseStrip.this.dSy.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dSz.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.dSA.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.eFe = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.eFE = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.eFg = NewPagerSlidingTabBaseStrip.this.dSA.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.eFg;
                    NewPagerSlidingTabBaseStrip.this.eFf = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.dSy != null) {
                    NewPagerSlidingTabBaseStrip.this.dSy.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dSy != null) {
                NewPagerSlidingTabBaseStrip.this.dSy.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.eFE) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eFe * NewPagerSlidingTabBaseStrip.this.dSz.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.eFg = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.eFf = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.dSz.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.dSz.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.dSz.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Yf;
        this.eFf = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yf = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Q */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ou */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yf);
        }
    }

    public void setConcernTabIndex(int i) {
        this.eFj = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.eFm = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.eFn = i;
    }

    public void setIndicatorRadius(int i) {
        this.eFs = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eFF = aVar;
    }

    /* loaded from: classes8.dex */
    public class TabTextView extends TextView {
        boolean eFH;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.eFH = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.eFH = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.eFH) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.eFD) - NewPagerSlidingTabBaseStrip.this.eFB;
                int i = NewPagerSlidingTabBaseStrip.this.eFC;
                NewPagerSlidingTabBaseStrip.this.eFi.set(width, i, width + NewPagerSlidingTabBaseStrip.this.eFB, i + NewPagerSlidingTabBaseStrip.this.eFB);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.eFi, NewPagerSlidingTabBaseStrip.this.eFh);
            }
        }
    }
}
