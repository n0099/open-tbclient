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
/* loaded from: classes20.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF Gl;
    private int dividerPadding;
    private int dividerWidth;
    private int erB;
    private int erC;
    private LinearLayout.LayoutParams eri;
    private LinearLayout.LayoutParams erj;
    public ViewPager.OnPageChangeListener erl;
    private LinearLayout erm;
    private ViewPager ern;
    private int ero;
    private Paint erq;
    private boolean ers;
    private int ert;
    private int eru;
    private int fjA;
    private int fjB;
    private int fjC;
    private int fjD;
    private int fjE;
    private int fjF;
    private boolean fjG;
    private int fjH;
    private int fjI;
    private int fjJ;
    private float fjK;
    private float fjL;
    private TextView fjM;
    private int fjN;
    private int fjO;
    private int fjP;
    private int fjQ;
    private boolean fjR;
    private a fjS;
    private int[] fjo;
    private FrameLayout.LayoutParams fjp;
    private final b fjq;
    private float fjr;
    private int fjs;
    private int fjt;
    private Paint fju;
    private RectF fjv;
    private int fjw;
    private boolean fjx;
    private int fjy;
    private int fjz;
    private boolean isLoading;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
    private int mSkinType;

    /* loaded from: classes20.dex */
    public interface a {
        void m(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fjq = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fjr = 0.0f;
        this.fjs = 0;
        this.fjt = 0;
        this.ers = false;
        this.fjx = false;
        this.fjy = R.color.cp_other_f;
        this.fjz = R.color.cp_cont_b;
        this.fjA = R.color.cp_cont_j;
        this.ert = ap.getColor(this.fjz);
        this.eru = ap.getColor(this.fjA);
        this.fjB = 52;
        this.mIndicatorHeight = 4;
        this.fjF = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fjG = false;
        this.fjH = 17;
        this.fjI = 17;
        this.erB = 0;
        this.erC = R.drawable.pager_sliding_view;
        this.fjR = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fjx) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fjp == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fjp);
            }
            addView(this.mContainer);
        }
        this.erm = new LinearLayout(getContext());
        this.erm.setOrientation(0);
        if (this.fjx) {
            this.erm.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.erm);
        } else {
            this.erm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.erm);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fjB = (int) TypedValue.applyDimension(1, this.fjB, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fjH = i;
        this.fjI = i2;
        this.fjJ = l.getDimens(getContext(), R.dimen.tbds74);
        this.fjK = (this.fjI * 1.0f) / this.fjH;
        this.fjL = (this.fjJ * 1.0f) / this.fjH;
        this.mIndicatorHeight = i3;
        this.ers = z;
        this.erq = new Paint();
        this.erq.setAntiAlias(true);
        this.erq.setStyle(Paint.Style.FILL);
        this.erq.setColor(ap.getColor(this.fjy));
        this.fju = new Paint();
        this.fju.setAntiAlias(true);
        this.fju.setStyle(Paint.Style.FILL);
        this.fju.setColor(ap.getColor(R.color.cp_cont_h));
        this.fjv = new RectF();
        this.fjO = l.getDimens(getContext(), R.dimen.tbds20);
        this.fjP = l.getDimens(getContext(), R.dimen.tbds16);
        this.fjQ = l.getDimens(getContext(), R.dimen.tbds25);
        this.eri = new LinearLayout.LayoutParams(-2, -1);
        this.erj = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fjD = l.getDimens(getContext(), R.dimen.tbds22);
        this.fjC = l.getDimens(getContext(), R.dimen.tbds20);
        this.fjE = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fjx && this.mContainer != null) {
            this.fjN = l.getDimens(getContext(), R.dimen.tbds32);
            this.fjM = new TextView(getContext());
            this.fjM.setGravity(17);
            this.fjM.setTextSize(0, this.fjN);
            this.fjM.setSingleLine();
            this.fjM.setTextColor(this.eru);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fjM, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.fjJ = i4;
        this.fjL = (this.fjJ * 1.0f) / this.fjH;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fjx = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fjD = i;
        this.fjG = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fjG = true;
    }

    public void setRectPaintColor(int i) {
        this.fjy = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fjC = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fjo = new int[4];
        this.fjo[0] = i;
        this.fjo[1] = i2;
        this.fjo[2] = i3;
        this.fjo[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.erj = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fjp = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fjE = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eri = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.fjR = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ern = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fjq);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.erl = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.ern != null && this.ern.getAdapter() != null && this.ern.getAdapter().getCount() != 0) {
            this.erm.removeAllViews();
            this.ero = this.ern.getAdapter().getCount();
            int i = 0;
            while (i < this.ero) {
                boolean rL = this.ern.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.ern.getAdapter()).rL(i) : z;
                e(i, this.ern.getAdapter().getPageTitle(i).toString(), rL);
                i++;
                z = rL;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.ern.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fjs = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void Ds(String str) {
        if (this.ern != null && this.ern.getAdapter() != null && this.ern.getAdapter().getCount() != 0 && this.fjx && this.fjM != null) {
            this.fjM.setText(str);
        }
    }

    private void e(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fjH);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fjS != null) {
                        NewPagerSlidingTabBaseStrip.this.fjS.m(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.ern.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.fjR = true;
                        NewPagerSlidingTabBaseStrip.this.ern.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fjo != null && this.fjo.length == 4) {
            view.setPadding(this.fjo[0], this.fjo[1], this.fjo[2], this.fjo[3]);
        }
        this.erm.addView(view, i, this.ers ? this.erj : this.eri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ero != 0) {
            int left = this.erm.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fjB;
            }
            if (left != this.erB) {
                this.erB = left;
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
        if (!isInEditMode() && this.ero != 0) {
            View childAt = this.erm.getChildAt(this.mCurrentTabIndex);
            if (this.fjG && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fjD;
                right = childAt.getRight() - this.fjD;
            }
            if (this.fjr > 0.0f && this.mCurrentTabIndex != this.fjs && this.fjs <= this.ero - 1 && this.fjs >= 0) {
                View childAt2 = this.erm.getChildAt(this.fjs);
                if (this.fjG && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fjD;
                    right2 = childAt2.getRight() - this.fjD;
                }
                left = e(left, left2, this.fjr);
                right = f(right, right2, this.fjr);
            }
            int height = getHeight();
            if (this.Gl == null) {
                this.Gl = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fjC, right + getPaddingLeft(), height - this.fjC);
            } else {
                this.Gl.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fjC, right + getPaddingLeft(), height - this.fjC);
            }
            canvas.drawRoundRect(this.Gl, this.fjF, this.fjF, this.erq);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fjE + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fjE + f2) - ((this.fjE * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fjE + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fjE) + ((this.fjE * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fjz = R.color.cp_cont_b;
            this.fjA = R.color.cp_cont_j;
        } else {
            this.fjz = R.color.cp_cont_a;
            this.fjA = R.color.cp_cont_a;
        }
        this.ert = ap.getColor(this.fjz);
        this.eru = ap.getColor(this.fjA);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.ert = ap.getColor(this.fjz);
            this.eru = ap.getColor(this.fjA);
            this.erq.setColor(ap.getColor(this.fjy));
            this.fju.setColor(ap.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float ah(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fjL - 1.0f) / (0.1f - 1.0f))) + this.fjL;
        }
        return (((this.fjL - this.fjK) / 0.1f) * f) + this.fjK;
    }

    private float ai(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fjL) / (0.1f - 0.9f)));
        }
        return (((this.fjL - this.fjK) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fjL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ai;
        float f = this.fjr;
        float f2 = this.fjs < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.ero) {
            View childAt = this.erm.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.erC);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ai = ah(f2);
                    } else {
                        ai = i == this.fjs ? ai(f2) : 1.0f;
                    }
                    textView.setScaleX(ai);
                    textView.setScaleY(ai);
                    if (f2 >= 0.5f) {
                        if (i == this.fjs) {
                            textView.setTextColor(this.ert);
                        } else {
                            textView.setTextColor(this.eru);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.ert);
                    } else {
                        textView.setTextColor(this.eru);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fjs) {
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
    /* loaded from: classes20.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (NewPagerSlidingTabBaseStrip.this.erm.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.fjR) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fjt) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fjs = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fjt) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fjs = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fjs = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fjt = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fjs = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fjr = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.erm.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.erl != null) {
                    NewPagerSlidingTabBaseStrip.this.erl.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.erm.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.ern.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fjr = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.fjR = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fjt = NewPagerSlidingTabBaseStrip.this.ern.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fjt;
                    NewPagerSlidingTabBaseStrip.this.fjs = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.erl != null) {
                    NewPagerSlidingTabBaseStrip.this.erl.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.erl != null) {
                NewPagerSlidingTabBaseStrip.this.erl.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.fjR) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fjr * NewPagerSlidingTabBaseStrip.this.erm.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fjt = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fjs = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.erm.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.erm.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.erm.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Zz;
        this.fjs = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zz = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
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
            /* renamed from: rM */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Zz;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zz = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zz);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fjw = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fjz = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.fjA = i;
    }

    public void setIndicatorRadius(int i) {
        this.fjF = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fjS = aVar;
    }

    /* loaded from: classes20.dex */
    public class TabTextView extends TextView {
        boolean fjU;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fjU = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fjU = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fjU) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fjQ) - NewPagerSlidingTabBaseStrip.this.fjO;
                int i = NewPagerSlidingTabBaseStrip.this.fjP;
                NewPagerSlidingTabBaseStrip.this.fjv.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fjO, i + NewPagerSlidingTabBaseStrip.this.fjO);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fjv, NewPagerSlidingTabBaseStrip.this.fju);
            }
        }
    }
}
