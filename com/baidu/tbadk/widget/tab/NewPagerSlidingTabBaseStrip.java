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
    private int[] eEQ;
    private FrameLayout.LayoutParams eER;
    private final b eES;
    private float eET;
    private int eEU;
    private int eEV;
    private Paint eEW;
    private RectF eEX;
    private int eEY;
    private boolean eEZ;
    private int eFa;
    private int eFb;
    private int eFc;
    private int eFd;
    private int eFe;
    private int eFf;
    private int eFg;
    private int eFh;
    private boolean eFi;
    private int eFj;
    private int eFk;
    private int eFl;
    private float eFm;
    private float eFn;
    private TextView eFo;
    private int eFp;
    private int eFq;
    private int eFr;
    private int eFs;
    private boolean eFt;
    private a eFu;
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
        this.eES = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eET = 0.0f;
        this.eEU = 0;
        this.eEV = 0;
        this.dSE = false;
        this.eEZ = false;
        this.eFa = R.color.cp_other_f;
        this.eFb = R.color.cp_cont_b;
        this.eFc = R.color.cp_cont_j;
        this.dSF = am.getColor(this.eFb);
        this.dQl = am.getColor(this.eFc);
        this.eFd = 52;
        this.mIndicatorHeight = 4;
        this.eFh = 16;
        this.dividerPadding = 12;
        this.dUE = 1;
        this.eFi = false;
        this.eFj = 17;
        this.eFk = 17;
        this.dSO = 0;
        this.dSP = R.drawable.pager_sliding_view;
        this.eFt = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.eEZ) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.eER == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.eER);
            }
            addView(this.mContainer);
        }
        this.dSz = new LinearLayout(getContext());
        this.dSz.setOrientation(0);
        if (this.eEZ) {
            this.dSz.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.dSz);
        } else {
            this.dSz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.dSz);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eFd = (int) TypedValue.applyDimension(1, this.eFd, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dUE = (int) TypedValue.applyDimension(1, this.dUE, displayMetrics);
        this.eFj = i;
        this.eFk = i2;
        this.eFl = l.getDimens(getContext(), R.dimen.tbds74);
        this.eFm = (this.eFk * 1.0f) / this.eFj;
        this.eFn = (this.eFl * 1.0f) / this.eFj;
        this.mIndicatorHeight = i3;
        this.dSE = z;
        this.dSD = new Paint();
        this.dSD.setAntiAlias(true);
        this.dSD.setStyle(Paint.Style.FILL);
        this.dSD.setColor(am.getColor(this.eFa));
        this.eEW = new Paint();
        this.eEW.setAntiAlias(true);
        this.eEW.setStyle(Paint.Style.FILL);
        this.eEW.setColor(am.getColor(R.color.cp_cont_h));
        this.eEX = new RectF();
        this.eFq = l.getDimens(getContext(), R.dimen.tbds20);
        this.eFr = l.getDimens(getContext(), R.dimen.tbds16);
        this.eFs = l.getDimens(getContext(), R.dimen.tbds25);
        this.dSv = new LinearLayout.LayoutParams(-2, -1);
        this.dSw = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.eFf = l.getDimens(getContext(), R.dimen.tbds22);
        this.eFe = l.getDimens(getContext(), R.dimen.tbds20);
        this.eFg = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.eEZ && this.mContainer != null) {
            this.eFp = l.getDimens(getContext(), R.dimen.tbds32);
            this.eFo = new TextView(getContext());
            this.eFo.setGravity(17);
            this.eFo.setTextSize(0, this.eFp);
            this.eFo.setSingleLine();
            this.eFo.setTextColor(this.dQl);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.eFo, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.eFl = i4;
        this.eFn = (this.eFl * 1.0f) / this.eFj;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.eEZ = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.eFf = i;
        this.eFi = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.eFi = true;
    }

    public void setRectPaintColor(int i) {
        this.eFa = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.eFe = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.eEQ = new int[4];
        this.eEQ[0] = i;
        this.eEQ[1] = i2;
        this.eEQ[2] = i3;
        this.eEQ[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dSw = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.eER = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.eFg = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dSv = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.eFt = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dSA = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eES);
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
                boolean or = this.dSA.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.dSA.getAdapter()).or(i) : z;
                f(i, this.dSA.getAdapter().getPageTitle(i).toString(), or);
                i++;
                z = or;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dSA.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.eEU = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void zf(String str) {
        if (this.dSA != null && this.dSA.getAdapter() != null && this.dSA.getAdapter().getCount() != 0 && this.eEZ && this.eFo != null) {
            this.eFo.setText(str);
        }
    }

    private void f(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.eFj);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.eFu != null) {
                        NewPagerSlidingTabBaseStrip.this.eFu.k(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.dSA.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.eFt = true;
                        NewPagerSlidingTabBaseStrip.this.dSA.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.eEQ != null && this.eEQ.length == 4) {
            view.setPadding(this.eEQ[0], this.eEQ[1], this.eEQ[2], this.eEQ[3]);
        }
        this.dSz.addView(view, i, this.dSE ? this.dSw : this.dSv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dSB != 0) {
            int left = this.dSz.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eFd;
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
            if (this.eFi && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.eFf;
                right = childAt.getRight() - this.eFf;
            }
            if (this.eET > 0.0f && this.mCurrentTabIndex != this.eEU && this.eEU <= this.dSB - 1 && this.eEU >= 0) {
                View childAt2 = this.dSz.getChildAt(this.eEU);
                if (this.eFi && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.eFf;
                    right2 = childAt2.getRight() - this.eFf;
                }
                left = e(left, left2, this.eET);
                right = f(right, right2, this.eET);
            }
            int height = getHeight();
            if (this.Fg == null) {
                this.Fg = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eFe, right + getPaddingLeft(), height - this.eFe);
            } else {
                this.Fg.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eFe, right + getPaddingLeft(), height - this.eFe);
            }
            canvas.drawRoundRect(this.Fg, this.eFh, this.eFh, this.dSD);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.eFg + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.eFg + f2) - ((this.eFg * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.eFg + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.eFg) + ((this.eFg * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.eFb = R.color.cp_cont_b;
            this.eFc = R.color.cp_cont_j;
        } else {
            this.eFb = R.color.cp_cont_a;
            this.eFc = R.color.cp_cont_a;
        }
        this.dSF = am.getColor(this.eFb);
        this.dQl = am.getColor(this.eFc);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dSF = am.getColor(this.eFb);
            this.dQl = am.getColor(this.eFc);
            this.dSD.setColor(am.getColor(this.eFa));
            this.eEW.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float aa(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eFn - 1.0f) / (0.1f - 1.0f))) + this.eFn;
        }
        return (((this.eFn - this.eFm) / 0.1f) * f) + this.eFm;
    }

    private float ab(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eFn) / (0.1f - 0.9f)));
        }
        return (((this.eFn - this.eFm) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eFn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ab;
        float f = this.eET;
        float f2 = this.eEU < this.mCurrentTabIndex ? 1.0f - f : f;
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
                        ab = i == this.eEU ? ab(f2) : 1.0f;
                    }
                    textView.setScaleX(ab);
                    textView.setScaleY(ab);
                    if (f2 >= 0.5f) {
                        if (i == this.eEU) {
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
                        if (i == this.eEU) {
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
                if (!NewPagerSlidingTabBaseStrip.this.eFt) {
                    if (i == NewPagerSlidingTabBaseStrip.this.eEV) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eEU = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.eEV) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eEU = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.eEU = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.eEV = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eEU = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.eET = f;
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
                    NewPagerSlidingTabBaseStrip.this.eET = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.eFt = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.eEV = NewPagerSlidingTabBaseStrip.this.dSA.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.eEV;
                    NewPagerSlidingTabBaseStrip.this.eEU = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
            if (NewPagerSlidingTabBaseStrip.this.eFt) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eET * NewPagerSlidingTabBaseStrip.this.dSz.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.eEV = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.eEU = i;
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
        this.eEU = this.mCurrentTabIndex;
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
            /* renamed from: os */
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
        this.eEY = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.eFb = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.eFc = i;
    }

    public void setIndicatorRadius(int i) {
        this.eFh = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eFu = aVar;
    }

    /* loaded from: classes8.dex */
    public class TabTextView extends TextView {
        boolean eFw;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.eFw = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.eFw = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.eFw) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.eFs) - NewPagerSlidingTabBaseStrip.this.eFq;
                int i = NewPagerSlidingTabBaseStrip.this.eFr;
                NewPagerSlidingTabBaseStrip.this.eEX.set(width, i, width + NewPagerSlidingTabBaseStrip.this.eFq, i + NewPagerSlidingTabBaseStrip.this.eFq);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.eEX, NewPagerSlidingTabBaseStrip.this.eEW);
            }
        }
    }
}
