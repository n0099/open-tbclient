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
    private LinearLayout.LayoutParams eLQ;
    private LinearLayout.LayoutParams eLR;
    public ViewPager.OnPageChangeListener eLT;
    private LinearLayout eLU;
    private ViewPager eLV;
    private int eLW;
    private Paint eLY;
    private boolean eLZ;
    private int eMa;
    private int eMb;
    private int eMi;
    private int eMj;
    private int[] fDX;
    private FrameLayout.LayoutParams fDY;
    private final b fDZ;
    private boolean fEA;
    private a fEB;
    private float fEa;
    private int fEb;
    private int fEc;
    private Paint fEd;
    private RectF fEe;
    private int fEf;
    private boolean fEg;
    private int fEh;
    private int fEi;
    private int fEj;
    private int fEk;
    private int fEl;
    private int fEm;
    private int fEn;
    private int fEo;
    private boolean fEp;
    private int fEq;
    private int fEr;
    private int fEs;
    private float fEt;
    private float fEu;
    private TextView fEv;
    private int fEw;
    private int fEx;
    private int fEy;
    private int fEz;
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
        this.fDZ = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fEa = 0.0f;
        this.fEb = 0;
        this.fEc = 0;
        this.eLZ = false;
        this.fEg = false;
        this.fEh = R.color.cp_other_f;
        this.fEi = R.color.cp_cont_b;
        this.fEj = R.color.cp_cont_j;
        this.eMa = ap.getColor(this.fEi);
        this.eMb = ap.getColor(this.fEj);
        this.fEk = 52;
        this.mIndicatorHeight = 4;
        this.fEo = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fEp = false;
        this.fEq = 17;
        this.fEr = 17;
        this.eMi = 0;
        this.eMj = R.drawable.pager_sliding_view;
        this.fEA = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fEg) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fDY == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fDY);
            }
            addView(this.mContainer);
        }
        this.eLU = new LinearLayout(getContext());
        this.eLU.setOrientation(0);
        if (this.fEg) {
            this.eLU.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.eLU);
        } else {
            this.eLU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.eLU);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fEk = (int) TypedValue.applyDimension(1, this.fEk, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fEq = i;
        this.fEr = i2;
        this.fEs = l.getDimens(getContext(), R.dimen.tbds74);
        this.fEt = (this.fEr * 1.0f) / this.fEq;
        this.fEu = (this.fEs * 1.0f) / this.fEq;
        this.mIndicatorHeight = i3;
        this.eLZ = z;
        this.eLY = new Paint();
        this.eLY.setAntiAlias(true);
        this.eLY.setStyle(Paint.Style.FILL);
        this.eLY.setColor(ap.getColor(this.fEh));
        this.fEd = new Paint();
        this.fEd.setAntiAlias(true);
        this.fEd.setStyle(Paint.Style.FILL);
        this.fEd.setColor(ap.getColor(R.color.cp_cont_h));
        this.fEe = new RectF();
        this.fEx = l.getDimens(getContext(), R.dimen.tbds20);
        this.fEy = l.getDimens(getContext(), R.dimen.tbds16);
        this.fEz = l.getDimens(getContext(), R.dimen.tbds25);
        this.eLQ = new LinearLayout.LayoutParams(-2, -1);
        this.eLR = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fEm = l.getDimens(getContext(), R.dimen.tbds22);
        this.fEl = l.getDimens(getContext(), R.dimen.tbds20);
        this.fEn = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fEg && this.mContainer != null) {
            this.fEw = l.getDimens(getContext(), R.dimen.tbds32);
            this.fEv = new TextView(getContext());
            this.fEv.setGravity(17);
            this.fEv.setTextSize(0, this.fEw);
            this.fEv.setSingleLine();
            this.fEv.setTextColor(this.eMb);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fEv, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.fEs = i4;
        this.fEu = (this.fEs * 1.0f) / this.fEq;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fEg = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fEm = i;
        this.fEp = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fEp = true;
    }

    public void setRectPaintColor(int i) {
        this.fEh = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fEl = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fDX = new int[4];
        this.fDX[0] = i;
        this.fDX[1] = i2;
        this.fDX[2] = i3;
        this.fDX[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eLR = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fDY = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fEn = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eLQ = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.fEA = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eLV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fDZ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eLT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.eLV != null && this.eLV.getAdapter() != null && this.eLV.getAdapter().getCount() != 0) {
            this.eLU.removeAllViews();
            this.eLW = this.eLV.getAdapter().getCount();
            int i = 0;
            while (i < this.eLW) {
                boolean su = this.eLV.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.eLV.getAdapter()).su(i) : z;
                g(i, this.eLV.getAdapter().getPageTitle(i).toString(), su);
                i++;
                z = su;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.eLV.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fEb = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void Ex(String str) {
        if (this.eLV != null && this.eLV.getAdapter() != null && this.eLV.getAdapter().getCount() != 0 && this.fEg && this.fEv != null) {
            this.fEv.setText(str);
        }
    }

    private void g(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fEq);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fEB != null) {
                        NewPagerSlidingTabBaseStrip.this.fEB.n(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.eLV.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.fEA = true;
                        NewPagerSlidingTabBaseStrip.this.eLV.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fDX != null && this.fDX.length == 4) {
            view.setPadding(this.fDX[0], this.fDX[1], this.fDX[2], this.fDX[3]);
        }
        this.eLU.addView(view, i, this.eLZ ? this.eLR : this.eLQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eLW != 0) {
            int left = this.eLU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fEk;
            }
            if (left != this.eMi) {
                this.eMi = left;
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
        if (!isInEditMode() && this.eLW != 0) {
            View childAt = this.eLU.getChildAt(this.mCurrentTabIndex);
            if (this.fEp && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fEm;
                right = childAt.getRight() - this.fEm;
            }
            if (this.fEa > 0.0f && this.mCurrentTabIndex != this.fEb && this.fEb <= this.eLW - 1 && this.fEb >= 0) {
                View childAt2 = this.eLU.getChildAt(this.fEb);
                if (this.fEp && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fEm;
                    right2 = childAt2.getRight() - this.fEm;
                }
                left = e(left, left2, this.fEa);
                right = f(right, right2, this.fEa);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fEl, right + getPaddingLeft(), height - this.fEl);
            } else {
                this.GD.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fEl, right + getPaddingLeft(), height - this.fEl);
            }
            canvas.drawRoundRect(this.GD, this.fEo, this.fEo, this.eLY);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fEn + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fEn + f2) - ((this.fEn * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fEn + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fEn) + ((this.fEn * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fEi = R.color.cp_cont_b;
            this.fEj = R.color.cp_cont_j;
        } else {
            this.fEi = R.color.cp_cont_a;
            this.fEj = R.color.cp_cont_a;
        }
        this.eMa = ap.getColor(this.fEi);
        this.eMb = ap.getColor(this.fEj);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.eMa = ap.getColor(this.fEi);
            this.eMb = ap.getColor(this.fEj);
            this.eLY.setColor(ap.getColor(this.fEh));
            this.fEd.setColor(ap.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float al(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fEu - 1.0f) / (0.1f - 1.0f))) + this.fEu;
        }
        return (((this.fEu - this.fEt) / 0.1f) * f) + this.fEt;
    }

    private float am(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fEu) / (0.1f - 0.9f)));
        }
        return (((this.fEu - this.fEt) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fEu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float am;
        float f = this.fEa;
        float f2 = this.fEb < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eLW) {
            View childAt = this.eLU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eMj);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        am = al(f2);
                    } else {
                        am = i == this.fEb ? am(f2) : 1.0f;
                    }
                    textView.setScaleX(am);
                    textView.setScaleY(am);
                    if (f2 >= 0.5f) {
                        if (i == this.fEb) {
                            textView.setTextColor(this.eMa);
                        } else {
                            textView.setTextColor(this.eMb);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eMa);
                    } else {
                        textView.setTextColor(this.eMb);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fEb) {
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
            if (NewPagerSlidingTabBaseStrip.this.eLU.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.fEA) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fEc) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fEb = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fEc) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fEb = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fEb = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fEc = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fEb = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fEa = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eLU.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.eLT != null) {
                    NewPagerSlidingTabBaseStrip.this.eLT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eLU.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.eLV.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fEa = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.fEA = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fEc = NewPagerSlidingTabBaseStrip.this.eLV.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fEc;
                    NewPagerSlidingTabBaseStrip.this.fEb = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.eLT != null) {
                    NewPagerSlidingTabBaseStrip.this.eLT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eLT != null) {
                NewPagerSlidingTabBaseStrip.this.eLT.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.fEA) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fEa * NewPagerSlidingTabBaseStrip.this.eLU.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fEc = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fEb = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.eLU.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.eLU.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.eLU.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZQ;
        this.fEb = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZQ = this.mCurrentTabIndex;
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
            /* renamed from: sv */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZQ);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fEf = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fEi = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.fEj = i;
    }

    public void setIndicatorRadius(int i) {
        this.fEo = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fEB = aVar;
    }

    /* loaded from: classes21.dex */
    public class TabTextView extends TextView {
        boolean fED;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fED = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fED = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fED) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fEz) - NewPagerSlidingTabBaseStrip.this.fEx;
                int i = NewPagerSlidingTabBaseStrip.this.fEy;
                NewPagerSlidingTabBaseStrip.this.fEe.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fEx, i + NewPagerSlidingTabBaseStrip.this.fEx);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fEe, NewPagerSlidingTabBaseStrip.this.fEd);
            }
        }
    }
}
