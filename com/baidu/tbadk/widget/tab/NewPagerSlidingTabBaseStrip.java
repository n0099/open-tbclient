package com.baidu.tbadk.widget.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private boolean bqW;
    private int dividerPadding;
    private int dividerWidth;
    private int fYA;
    private int fYB;
    private int fYC;
    private int fYD;
    private int fYE;
    private int fYF;
    private boolean fYG;
    private int fYH;
    private int fYI;
    private int fYJ;
    private float fYK;
    private float fYL;
    private TextView fYM;
    private int fYN;
    private int fYO;
    private int fYP;
    private int fYQ;
    private a fYR;
    private int[] fYo;
    private FrameLayout.LayoutParams fYp;
    private final b fYq;
    private float fYr;
    private int fYs;
    private int fYt;
    private Paint fYu;
    private RectF fYv;
    private int fYw;
    private boolean fYx;
    private int fYy;
    private int fYz;
    private int ffB;
    private LinearLayout.LayoutParams fff;
    private LinearLayout.LayoutParams ffg;
    public ViewPager.OnPageChangeListener ffi;
    private LinearLayout ffj;
    private ViewPager ffk;
    private int ffl;
    private Paint ffn;
    private boolean ffo;
    private int ffp;
    private int ffq;
    private boolean isLoading;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
    private int mSkinType;
    private RectF rectF;
    private int tabBackgroundResId;

    /* loaded from: classes.dex */
    public interface a {
        void t(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fYq = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fYr = 0.0f;
        this.fYs = 0;
        this.fYt = 0;
        this.ffo = false;
        this.fYx = false;
        this.fYy = R.color.CAM_X0312;
        this.fYz = R.color.CAM_X0105;
        this.fYA = R.color.CAM_X0107;
        this.ffp = ap.getColor(this.fYz);
        this.ffq = ap.getColor(this.fYA);
        this.fYB = 52;
        this.mIndicatorHeight = 4;
        this.fYF = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fYG = false;
        this.fYH = 17;
        this.fYI = 17;
        this.ffB = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bqW = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fYx) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fYp == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fYp);
            }
            addView(this.mContainer);
        }
        this.ffj = new LinearLayout(getContext());
        this.ffj.setOrientation(0);
        if (this.fYx) {
            this.ffj.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.ffj);
        } else {
            this.ffj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.ffj);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fYB = (int) TypedValue.applyDimension(1, this.fYB, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fYH = i;
        this.fYI = i2;
        this.fYJ = l.getDimens(getContext(), R.dimen.tbds74);
        this.fYK = (this.fYI * 1.0f) / this.fYH;
        this.fYL = (this.fYJ * 1.0f) / this.fYH;
        this.mIndicatorHeight = i3;
        this.ffo = z;
        this.ffn = new Paint();
        this.ffn.setAntiAlias(true);
        this.ffn.setStyle(Paint.Style.FILL);
        this.ffn.setColor(ap.getColor(this.fYy));
        this.fYu = new Paint();
        this.fYu.setAntiAlias(true);
        this.fYu.setStyle(Paint.Style.FILL);
        this.fYu.setColor(ap.getColor(R.color.CAM_X0301));
        this.fYv = new RectF();
        this.fYO = l.getDimens(getContext(), R.dimen.tbds20);
        this.fYP = l.getDimens(getContext(), R.dimen.tbds16);
        this.fYQ = l.getDimens(getContext(), R.dimen.tbds25);
        this.fff = new LinearLayout.LayoutParams(-2, -1);
        this.ffg = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fYD = l.getDimens(getContext(), R.dimen.tbds22);
        this.fYC = l.getDimens(getContext(), R.dimen.tbds20);
        this.fYE = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fYx && this.mContainer != null) {
            this.fYN = l.getDimens(getContext(), R.dimen.tbds32);
            this.fYM = new TextView(getContext());
            this.fYM.setGravity(17);
            this.fYM.setTextSize(0, this.fYN);
            this.fYM.setSingleLine();
            this.fYM.setTextColor(this.ffq);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fYM, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        c(i, i2, i3, z);
        this.fYJ = i4;
        this.fYL = (this.fYJ * 1.0f) / this.fYH;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fYx = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fYD = i;
        this.fYG = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fYG = true;
    }

    public void setRectPaintColor(int i) {
        this.fYy = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fYC = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fYo = new int[4];
        this.fYo[0] = i;
        this.fYo[1] = i2;
        this.fYo[2] = i3;
        this.fYo[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.ffg = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fYp = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fYE = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fff = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.bqW = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ffk = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fYq);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ffi = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ffk != null && this.ffk.getAdapter() != null && this.ffk.getAdapter().getCount() != 0) {
            this.ffj.removeAllViews();
            this.ffl = this.ffk.getAdapter().getCount();
            boolean z = false;
            for (int i = 0; i < this.ffl; i++) {
                if (this.ffk.getAdapter() instanceof com.baidu.tbadk.widget.tab.a) {
                    z = ((com.baidu.tbadk.widget.tab.a) this.ffk.getAdapter()).sp(i);
                }
                f(i, this.ffk.getAdapter().getPageTitle(i).toString(), z);
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.ffk.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fYs = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void Ei(String str) {
        if (this.ffk != null && this.ffk.getAdapter() != null && this.ffk.getAdapter().getCount() != 0 && this.fYx && this.fYM != null) {
            this.fYM.setText(str);
        }
    }

    private void f(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fYH);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fYR != null) {
                        NewPagerSlidingTabBaseStrip.this.fYR.t(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.ffk.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.bqW = true;
                        NewPagerSlidingTabBaseStrip.this.ffk.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fYo != null && this.fYo.length == 4) {
            view.setPadding(this.fYo[0], this.fYo[1], this.fYo[2], this.fYo[3]);
        }
        this.ffj.addView(view, i, this.ffo ? this.ffg : this.fff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ffl != 0) {
            int left = this.ffj.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fYB;
            }
            if (left != this.ffB) {
                this.ffB = left;
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
        if (!isInEditMode() && this.ffl != 0) {
            View childAt = this.ffj.getChildAt(this.mCurrentTabIndex);
            if (this.fYG && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fYD;
                right = childAt.getRight() - this.fYD;
            }
            if (this.fYr > 0.0f && this.mCurrentTabIndex != this.fYs && this.fYs <= this.ffl - 1 && this.fYs >= 0) {
                View childAt2 = this.ffj.getChildAt(this.fYs);
                if (this.fYG && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fYD;
                    right2 = childAt2.getRight() - this.fYD;
                }
                left = e(left, left2, this.fYr);
                right = f(right, right2, this.fYr);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fYC, right + getPaddingLeft(), height - this.fYC);
            } else {
                this.rectF.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fYC, right + getPaddingLeft(), height - this.fYC);
            }
            canvas.drawRoundRect(this.rectF, this.fYF, this.fYF, this.ffn);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fYE + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fYE + f2) - ((this.fYE * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fYE + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fYE) + ((this.fYE * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fYz = R.color.CAM_X0105;
            this.fYA = R.color.CAM_X0107;
        } else {
            this.fYz = R.color.CAM_X0101;
            this.fYA = R.color.CAM_X0101;
        }
        this.ffp = ap.getColor(this.fYz);
        this.ffq = ap.getColor(this.fYA);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.ffp = ap.getColor(this.fYz);
            this.ffq = ap.getColor(this.fYA);
            this.ffn.setColor(ap.getColor(this.fYy));
            this.fYu.setColor(ap.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fYL - 1.0f) / (0.1f - 1.0f))) + this.fYL;
        }
        return (((this.fYL - this.fYK) / 0.1f) * f) + this.fYK;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fYL) / (0.1f - 0.9f)));
        }
        return (((this.fYL - this.fYK) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fYL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.fYr;
        float f2 = this.fYs < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.ffl) {
            View childAt = this.ffj.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.fYs ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (f2 >= 0.5f) {
                        if (i == this.fYs) {
                            textView.setTextColor(this.ffp);
                        } else {
                            textView.setTextColor(this.ffq);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.ffp);
                    } else {
                        textView.setTextColor(this.ffq);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fYs) {
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
    /* loaded from: classes.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (NewPagerSlidingTabBaseStrip.this.ffj.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.bqW) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fYt) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fYs = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fYt) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fYs = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fYs = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fYt = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fYs = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fYr = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.ffj.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.ffi != null) {
                    NewPagerSlidingTabBaseStrip.this.ffi.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.ffj.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.ffk.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fYr = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.bqW = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fYt = NewPagerSlidingTabBaseStrip.this.ffk.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fYt;
                    NewPagerSlidingTabBaseStrip.this.fYs = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.ffi != null) {
                    NewPagerSlidingTabBaseStrip.this.ffi.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.ffi != null) {
                NewPagerSlidingTabBaseStrip.this.ffi.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.bqW) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fYr * NewPagerSlidingTabBaseStrip.this.ffj.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fYt = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fYs = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.ffj.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.ffj.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.ffj.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.abv;
        this.fYs = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abv = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: U */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: sq */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abv;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abv = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abv);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fYw = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fYz = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.fYA = i;
    }

    public void setIndicatorRadius(int i) {
        this.fYF = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fYR = aVar;
    }

    /* loaded from: classes.dex */
    public class TabTextView extends TextView {
        boolean fYT;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fYT = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fYT = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fYT) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fYQ) - NewPagerSlidingTabBaseStrip.this.fYO;
                int i = NewPagerSlidingTabBaseStrip.this.fYP;
                NewPagerSlidingTabBaseStrip.this.fYv.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fYO, i + NewPagerSlidingTabBaseStrip.this.fYO);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fYv, NewPagerSlidingTabBaseStrip.this.fYu);
            }
        }
    }
}
