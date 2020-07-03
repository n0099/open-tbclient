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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes8.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF FG;
    private int dXd;
    private int dZG;
    private int dZH;
    private LinearLayout.LayoutParams dZn;
    private LinearLayout.LayoutParams dZo;
    public ViewPager.OnPageChangeListener dZq;
    private LinearLayout dZr;
    private ViewPager dZs;
    private int dZt;
    private Paint dZv;
    private boolean dZw;
    private int dZx;
    private int dividerPadding;
    private int ePA;
    private int ePB;
    private int ePC;
    private int ePD;
    private int ePE;
    private boolean ePF;
    private int ePG;
    private int ePH;
    private int ePI;
    private float ePJ;
    private float ePK;
    private TextView ePL;
    private int ePM;
    private int ePN;
    private int ePO;
    private int ePP;
    private boolean ePQ;
    private a ePR;
    private int[] ePn;
    private FrameLayout.LayoutParams ePo;
    private final b ePp;
    private float ePq;
    private int ePr;
    private int ePs;
    private Paint ePt;
    private RectF ePu;
    private int ePv;
    private boolean ePw;
    private int ePx;
    private int ePy;
    private int ePz;
    private int ebT;
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
        this.ePp = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.ePq = 0.0f;
        this.ePr = 0;
        this.ePs = 0;
        this.dZw = false;
        this.ePw = false;
        this.ePx = R.color.cp_other_f;
        this.ePy = R.color.cp_cont_b;
        this.ePz = R.color.cp_cont_j;
        this.dZx = an.getColor(this.ePy);
        this.dXd = an.getColor(this.ePz);
        this.ePA = 52;
        this.mIndicatorHeight = 4;
        this.ePE = 16;
        this.dividerPadding = 12;
        this.ebT = 1;
        this.ePF = false;
        this.ePG = 17;
        this.ePH = 17;
        this.dZG = 0;
        this.dZH = R.drawable.pager_sliding_view;
        this.ePQ = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.ePw) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.ePo == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.ePo);
            }
            addView(this.mContainer);
        }
        this.dZr = new LinearLayout(getContext());
        this.dZr.setOrientation(0);
        if (this.ePw) {
            this.dZr.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.dZr);
        } else {
            this.dZr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.dZr);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ePA = (int) TypedValue.applyDimension(1, this.ePA, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.ebT = (int) TypedValue.applyDimension(1, this.ebT, displayMetrics);
        this.ePG = i;
        this.ePH = i2;
        this.ePI = l.getDimens(getContext(), R.dimen.tbds74);
        this.ePJ = (this.ePH * 1.0f) / this.ePG;
        this.ePK = (this.ePI * 1.0f) / this.ePG;
        this.mIndicatorHeight = i3;
        this.dZw = z;
        this.dZv = new Paint();
        this.dZv.setAntiAlias(true);
        this.dZv.setStyle(Paint.Style.FILL);
        this.dZv.setColor(an.getColor(this.ePx));
        this.ePt = new Paint();
        this.ePt.setAntiAlias(true);
        this.ePt.setStyle(Paint.Style.FILL);
        this.ePt.setColor(an.getColor(R.color.cp_cont_h));
        this.ePu = new RectF();
        this.ePN = l.getDimens(getContext(), R.dimen.tbds20);
        this.ePO = l.getDimens(getContext(), R.dimen.tbds16);
        this.ePP = l.getDimens(getContext(), R.dimen.tbds25);
        this.dZn = new LinearLayout.LayoutParams(-2, -1);
        this.dZo = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.ePC = l.getDimens(getContext(), R.dimen.tbds22);
        this.ePB = l.getDimens(getContext(), R.dimen.tbds20);
        this.ePD = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.ePw && this.mContainer != null) {
            this.ePM = l.getDimens(getContext(), R.dimen.tbds32);
            this.ePL = new TextView(getContext());
            this.ePL.setGravity(17);
            this.ePL.setTextSize(0, this.ePM);
            this.ePL.setSingleLine();
            this.ePL.setTextColor(this.dXd);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.ePL, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.ePI = i4;
        this.ePK = (this.ePI * 1.0f) / this.ePG;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.ePw = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.ePC = i;
        this.ePF = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.ePF = true;
    }

    public void setRectPaintColor(int i) {
        this.ePx = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.ePB = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.ePn = new int[4];
        this.ePn[0] = i;
        this.ePn[1] = i2;
        this.ePn[2] = i3;
        this.ePn[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dZo = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.ePo = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.ePD = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dZn = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.ePQ = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dZs = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ePp);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dZq = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.dZs != null && this.dZs.getAdapter() != null && this.dZs.getAdapter().getCount() != 0) {
            this.dZr.removeAllViews();
            this.dZt = this.dZs.getAdapter().getCount();
            int i = 0;
            while (i < this.dZt) {
                boolean oR = this.dZs.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.dZs.getAdapter()).oR(i) : z;
                f(i, this.dZs.getAdapter().getPageTitle(i).toString(), oR);
                i++;
                z = oR;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dZs.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.ePr = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void zy(String str) {
        if (this.dZs != null && this.dZs.getAdapter() != null && this.dZs.getAdapter().getCount() != 0 && this.ePw && this.ePL != null) {
            this.ePL.setText(str);
        }
    }

    private void f(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.ePG);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.ePR != null) {
                        NewPagerSlidingTabBaseStrip.this.ePR.k(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.dZs.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.ePQ = true;
                        NewPagerSlidingTabBaseStrip.this.dZs.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.ePn != null && this.ePn.length == 4) {
            view.setPadding(this.ePn[0], this.ePn[1], this.ePn[2], this.ePn[3]);
        }
        this.dZr.addView(view, i, this.dZw ? this.dZo : this.dZn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dZt != 0) {
            int left = this.dZr.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ePA;
            }
            if (left != this.dZG) {
                this.dZG = left;
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
        if (!isInEditMode() && this.dZt != 0) {
            View childAt = this.dZr.getChildAt(this.mCurrentTabIndex);
            if (this.ePF && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.ePC;
                right = childAt.getRight() - this.ePC;
            }
            if (this.ePq > 0.0f && this.mCurrentTabIndex != this.ePr && this.ePr <= this.dZt - 1 && this.ePr >= 0) {
                View childAt2 = this.dZr.getChildAt(this.ePr);
                if (this.ePF && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.ePC;
                    right2 = childAt2.getRight() - this.ePC;
                }
                left = e(left, left2, this.ePq);
                right = f(right, right2, this.ePq);
            }
            int height = getHeight();
            if (this.FG == null) {
                this.FG = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.ePB, right + getPaddingLeft(), height - this.ePB);
            } else {
                this.FG.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.ePB, right + getPaddingLeft(), height - this.ePB);
            }
            canvas.drawRoundRect(this.FG, this.ePE, this.ePE, this.dZv);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.ePD + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.ePD + f2) - ((this.ePD * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.ePD + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.ePD) + ((this.ePD * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.ePy = R.color.cp_cont_b;
            this.ePz = R.color.cp_cont_j;
        } else {
            this.ePy = R.color.cp_cont_a;
            this.ePz = R.color.cp_cont_a;
        }
        this.dZx = an.getColor(this.ePy);
        this.dXd = an.getColor(this.ePz);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dZx = an.getColor(this.ePy);
            this.dXd = an.getColor(this.ePz);
            this.dZv.setColor(an.getColor(this.ePx));
            this.ePt.setColor(an.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.ePK - 1.0f) / (0.1f - 1.0f))) + this.ePK;
        }
        return (((this.ePK - this.ePJ) / 0.1f) * f) + this.ePJ;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.ePK) / (0.1f - 0.9f)));
        }
        return (((this.ePK - this.ePJ) / (0.9f - 1.0f)) * (f - 0.9f)) + this.ePK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.ePq;
        float f2 = this.ePr < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dZt) {
            View childAt = this.dZr.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dZH);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.ePr ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (f2 >= 0.5f) {
                        if (i == this.ePr) {
                            textView.setTextColor(this.dZx);
                        } else {
                            textView.setTextColor(this.dXd);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dZx);
                    } else {
                        textView.setTextColor(this.dXd);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.ePr) {
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
            if (NewPagerSlidingTabBaseStrip.this.dZr.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.ePQ) {
                    if (i == NewPagerSlidingTabBaseStrip.this.ePs) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.ePr = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.ePs) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.ePr = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.ePr = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.ePs = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.ePr = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.ePq = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dZr.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.dZq != null) {
                    NewPagerSlidingTabBaseStrip.this.dZq.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dZr.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.dZs.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.ePq = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.ePQ = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.ePs = NewPagerSlidingTabBaseStrip.this.dZs.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.ePs;
                    NewPagerSlidingTabBaseStrip.this.ePr = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.dZq != null) {
                    NewPagerSlidingTabBaseStrip.this.dZq.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dZq != null) {
                NewPagerSlidingTabBaseStrip.this.dZq.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.ePQ) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.ePq * NewPagerSlidingTabBaseStrip.this.dZr.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.ePs = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.ePr = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.dZr.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.dZr.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.dZr.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.YJ;
        this.ePr = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.YJ = this.mCurrentTabIndex;
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
            /* renamed from: oS */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int YJ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.YJ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.YJ);
        }
    }

    public void setConcernTabIndex(int i) {
        this.ePv = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.ePy = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.ePz = i;
    }

    public void setIndicatorRadius(int i) {
        this.ePE = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ePR = aVar;
    }

    /* loaded from: classes8.dex */
    public class TabTextView extends TextView {
        boolean ePT;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.ePT = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.ePT = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.ePT) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.ePP) - NewPagerSlidingTabBaseStrip.this.ePN;
                int i = NewPagerSlidingTabBaseStrip.this.ePO;
                NewPagerSlidingTabBaseStrip.this.ePu.set(width, i, width + NewPagerSlidingTabBaseStrip.this.ePN, i + NewPagerSlidingTabBaseStrip.this.ePN);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.ePu, NewPagerSlidingTabBaseStrip.this.ePt);
            }
        }
    }
}
