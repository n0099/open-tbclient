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
/* loaded from: classes21.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF GD;
    private int dividerPadding;
    private int dividerWidth;
    private int eDA;
    private Paint eDC;
    private boolean eDD;
    private int eDE;
    private int eDF;
    private int eDM;
    private int eDN;
    private LinearLayout.LayoutParams eDu;
    private LinearLayout.LayoutParams eDv;
    public ViewPager.OnPageChangeListener eDx;
    private LinearLayout eDy;
    private ViewPager eDz;
    private int[] fvC;
    private FrameLayout.LayoutParams fvD;
    private final b fvE;
    private float fvF;
    private int fvG;
    private int fvH;
    private Paint fvI;
    private RectF fvJ;
    private int fvK;
    private boolean fvL;
    private int fvM;
    private int fvN;
    private int fvO;
    private int fvP;
    private int fvQ;
    private int fvR;
    private int fvS;
    private int fvT;
    private boolean fvU;
    private int fvV;
    private int fvW;
    private int fvX;
    private float fvY;
    private float fvZ;
    private TextView fwa;
    private int fwb;
    private int fwc;
    private int fwd;
    private int fwe;
    private boolean fwf;
    private a fwg;
    private boolean isLoading;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void n(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fvE = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fvF = 0.0f;
        this.fvG = 0;
        this.fvH = 0;
        this.eDD = false;
        this.fvL = false;
        this.fvM = R.color.cp_other_f;
        this.fvN = R.color.cp_cont_b;
        this.fvO = R.color.cp_cont_j;
        this.eDE = ap.getColor(this.fvN);
        this.eDF = ap.getColor(this.fvO);
        this.fvP = 52;
        this.mIndicatorHeight = 4;
        this.fvT = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fvU = false;
        this.fvV = 17;
        this.fvW = 17;
        this.eDM = 0;
        this.eDN = R.drawable.pager_sliding_view;
        this.fwf = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fvL) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fvD == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fvD);
            }
            addView(this.mContainer);
        }
        this.eDy = new LinearLayout(getContext());
        this.eDy.setOrientation(0);
        if (this.fvL) {
            this.eDy.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.eDy);
        } else {
            this.eDy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.eDy);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fvP = (int) TypedValue.applyDimension(1, this.fvP, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fvV = i;
        this.fvW = i2;
        this.fvX = l.getDimens(getContext(), R.dimen.tbds74);
        this.fvY = (this.fvW * 1.0f) / this.fvV;
        this.fvZ = (this.fvX * 1.0f) / this.fvV;
        this.mIndicatorHeight = i3;
        this.eDD = z;
        this.eDC = new Paint();
        this.eDC.setAntiAlias(true);
        this.eDC.setStyle(Paint.Style.FILL);
        this.eDC.setColor(ap.getColor(this.fvM));
        this.fvI = new Paint();
        this.fvI.setAntiAlias(true);
        this.fvI.setStyle(Paint.Style.FILL);
        this.fvI.setColor(ap.getColor(R.color.cp_cont_h));
        this.fvJ = new RectF();
        this.fwc = l.getDimens(getContext(), R.dimen.tbds20);
        this.fwd = l.getDimens(getContext(), R.dimen.tbds16);
        this.fwe = l.getDimens(getContext(), R.dimen.tbds25);
        this.eDu = new LinearLayout.LayoutParams(-2, -1);
        this.eDv = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fvR = l.getDimens(getContext(), R.dimen.tbds22);
        this.fvQ = l.getDimens(getContext(), R.dimen.tbds20);
        this.fvS = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fvL && this.mContainer != null) {
            this.fwb = l.getDimens(getContext(), R.dimen.tbds32);
            this.fwa = new TextView(getContext());
            this.fwa.setGravity(17);
            this.fwa.setTextSize(0, this.fwb);
            this.fwa.setSingleLine();
            this.fwa.setTextColor(this.eDF);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fwa, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.fvX = i4;
        this.fvZ = (this.fvX * 1.0f) / this.fvV;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fvL = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fvR = i;
        this.fvU = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fvU = true;
    }

    public void setRectPaintColor(int i) {
        this.fvM = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fvQ = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fvC = new int[4];
        this.fvC[0] = i;
        this.fvC[1] = i2;
        this.fvC[2] = i3;
        this.fvC[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eDv = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fvD = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fvS = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eDu = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.fwf = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eDz = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fvE);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eDx = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.eDz != null && this.eDz.getAdapter() != null && this.eDz.getAdapter().getCount() != 0) {
            this.eDy.removeAllViews();
            this.eDA = this.eDz.getAdapter().getCount();
            int i = 0;
            while (i < this.eDA) {
                boolean sj = this.eDz.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.eDz.getAdapter()).sj(i) : z;
                g(i, this.eDz.getAdapter().getPageTitle(i).toString(), sj);
                i++;
                z = sj;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.eDz.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fvG = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void Ee(String str) {
        if (this.eDz != null && this.eDz.getAdapter() != null && this.eDz.getAdapter().getCount() != 0 && this.fvL && this.fwa != null) {
            this.fwa.setText(str);
        }
    }

    private void g(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fvV);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fwg != null) {
                        NewPagerSlidingTabBaseStrip.this.fwg.n(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.eDz.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.fwf = true;
                        NewPagerSlidingTabBaseStrip.this.eDz.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fvC != null && this.fvC.length == 4) {
            view.setPadding(this.fvC[0], this.fvC[1], this.fvC[2], this.fvC[3]);
        }
        this.eDy.addView(view, i, this.eDD ? this.eDv : this.eDu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eDA != 0) {
            int left = this.eDy.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fvP;
            }
            if (left != this.eDM) {
                this.eDM = left;
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
        if (!isInEditMode() && this.eDA != 0) {
            View childAt = this.eDy.getChildAt(this.mCurrentTabIndex);
            if (this.fvU && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fvR;
                right = childAt.getRight() - this.fvR;
            }
            if (this.fvF > 0.0f && this.mCurrentTabIndex != this.fvG && this.fvG <= this.eDA - 1 && this.fvG >= 0) {
                View childAt2 = this.eDy.getChildAt(this.fvG);
                if (this.fvU && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fvR;
                    right2 = childAt2.getRight() - this.fvR;
                }
                left = e(left, left2, this.fvF);
                right = f(right, right2, this.fvF);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fvQ, right + getPaddingLeft(), height - this.fvQ);
            } else {
                this.GD.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fvQ, right + getPaddingLeft(), height - this.fvQ);
            }
            canvas.drawRoundRect(this.GD, this.fvT, this.fvT, this.eDC);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fvS + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fvS + f2) - ((this.fvS * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fvS + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fvS) + ((this.fvS * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fvN = R.color.cp_cont_b;
            this.fvO = R.color.cp_cont_j;
        } else {
            this.fvN = R.color.cp_cont_a;
            this.fvO = R.color.cp_cont_a;
        }
        this.eDE = ap.getColor(this.fvN);
        this.eDF = ap.getColor(this.fvO);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.eDE = ap.getColor(this.fvN);
            this.eDF = ap.getColor(this.fvO);
            this.eDC.setColor(ap.getColor(this.fvM));
            this.fvI.setColor(ap.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float aj(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fvZ - 1.0f) / (0.1f - 1.0f))) + this.fvZ;
        }
        return (((this.fvZ - this.fvY) / 0.1f) * f) + this.fvY;
    }

    private float ak(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fvZ) / (0.1f - 0.9f)));
        }
        return (((this.fvZ - this.fvY) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fvZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ak;
        float f = this.fvF;
        float f2 = this.fvG < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eDA) {
            View childAt = this.eDy.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eDN);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ak = aj(f2);
                    } else {
                        ak = i == this.fvG ? ak(f2) : 1.0f;
                    }
                    textView.setScaleX(ak);
                    textView.setScaleY(ak);
                    if (f2 >= 0.5f) {
                        if (i == this.fvG) {
                            textView.setTextColor(this.eDE);
                        } else {
                            textView.setTextColor(this.eDF);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eDE);
                    } else {
                        textView.setTextColor(this.eDF);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fvG) {
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
    /* loaded from: classes21.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (NewPagerSlidingTabBaseStrip.this.eDy.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.fwf) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fvH) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fvG = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fvH) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fvG = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fvG = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fvH = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fvG = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fvF = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eDy.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.eDx != null) {
                    NewPagerSlidingTabBaseStrip.this.eDx.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eDy.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.eDz.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fvF = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.fwf = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fvH = NewPagerSlidingTabBaseStrip.this.eDz.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fvH;
                    NewPagerSlidingTabBaseStrip.this.fvG = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.eDx != null) {
                    NewPagerSlidingTabBaseStrip.this.eDx.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eDx != null) {
                NewPagerSlidingTabBaseStrip.this.eDx.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.fwf) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fvF * NewPagerSlidingTabBaseStrip.this.eDy.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fvH = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fvG = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.eDy.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.eDy.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.eDy.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZP;
        this.fvG = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZP = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
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
            /* renamed from: sk */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZP);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fvK = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fvN = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.fvO = i;
    }

    public void setIndicatorRadius(int i) {
        this.fvT = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fwg = aVar;
    }

    /* loaded from: classes21.dex */
    public class TabTextView extends TextView {
        boolean fwi;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fwi = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fwi = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fwi) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fwe) - NewPagerSlidingTabBaseStrip.this.fwc;
                int i = NewPagerSlidingTabBaseStrip.this.fwd;
                NewPagerSlidingTabBaseStrip.this.fvJ.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fwc, i + NewPagerSlidingTabBaseStrip.this.fwc);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fvJ, NewPagerSlidingTabBaseStrip.this.fvI);
            }
        }
    }
}
