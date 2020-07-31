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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes15.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF FG;
    private int dividerPadding;
    private int dividerWidth;
    private int[] eVI;
    private FrameLayout.LayoutParams eVJ;
    private final b eVK;
    private float eVL;
    private int eVM;
    private int eVN;
    private Paint eVO;
    private RectF eVP;
    private int eVQ;
    private boolean eVR;
    private int eVS;
    private int eVT;
    private int eVU;
    private int eVV;
    private int eVW;
    private int eVX;
    private int eVY;
    private int eVZ;
    private boolean eWa;
    private int eWb;
    private int eWc;
    private int eWd;
    private float eWe;
    private float eWf;
    private TextView eWg;
    private int eWh;
    private int eWi;
    private int eWj;
    private int eWk;
    private boolean eWl;
    private a eWm;
    private int edx;
    private LinearLayout.LayoutParams efA;
    private LinearLayout.LayoutParams efB;
    public ViewPager.OnPageChangeListener efD;
    private LinearLayout efE;
    private ViewPager efF;
    private int efG;
    private Paint efI;
    private boolean efJ;
    private int efK;
    private int efR;
    private int efS;
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
        this.eVK = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eVL = 0.0f;
        this.eVM = 0;
        this.eVN = 0;
        this.efJ = false;
        this.eVR = false;
        this.eVS = R.color.cp_other_f;
        this.eVT = R.color.cp_cont_b;
        this.eVU = R.color.cp_cont_j;
        this.efK = ao.getColor(this.eVT);
        this.edx = ao.getColor(this.eVU);
        this.eVV = 52;
        this.mIndicatorHeight = 4;
        this.eVZ = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.eWa = false;
        this.eWb = 17;
        this.eWc = 17;
        this.efR = 0;
        this.efS = R.drawable.pager_sliding_view;
        this.eWl = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.eVR) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.eVJ == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.eVJ);
            }
            addView(this.mContainer);
        }
        this.efE = new LinearLayout(getContext());
        this.efE.setOrientation(0);
        if (this.eVR) {
            this.efE.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.efE);
        } else {
            this.efE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.efE);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eVV = (int) TypedValue.applyDimension(1, this.eVV, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.eWb = i;
        this.eWc = i2;
        this.eWd = l.getDimens(getContext(), R.dimen.tbds74);
        this.eWe = (this.eWc * 1.0f) / this.eWb;
        this.eWf = (this.eWd * 1.0f) / this.eWb;
        this.mIndicatorHeight = i3;
        this.efJ = z;
        this.efI = new Paint();
        this.efI.setAntiAlias(true);
        this.efI.setStyle(Paint.Style.FILL);
        this.efI.setColor(ao.getColor(this.eVS));
        this.eVO = new Paint();
        this.eVO.setAntiAlias(true);
        this.eVO.setStyle(Paint.Style.FILL);
        this.eVO.setColor(ao.getColor(R.color.cp_cont_h));
        this.eVP = new RectF();
        this.eWi = l.getDimens(getContext(), R.dimen.tbds20);
        this.eWj = l.getDimens(getContext(), R.dimen.tbds16);
        this.eWk = l.getDimens(getContext(), R.dimen.tbds25);
        this.efA = new LinearLayout.LayoutParams(-2, -1);
        this.efB = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.eVX = l.getDimens(getContext(), R.dimen.tbds22);
        this.eVW = l.getDimens(getContext(), R.dimen.tbds20);
        this.eVY = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.eVR && this.mContainer != null) {
            this.eWh = l.getDimens(getContext(), R.dimen.tbds32);
            this.eWg = new TextView(getContext());
            this.eWg.setGravity(17);
            this.eWg.setTextSize(0, this.eWh);
            this.eWg.setSingleLine();
            this.eWg.setTextColor(this.edx);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.eWg, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.eWd = i4;
        this.eWf = (this.eWd * 1.0f) / this.eWb;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.eVR = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.eVX = i;
        this.eWa = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.eWa = true;
    }

    public void setRectPaintColor(int i) {
        this.eVS = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.eVW = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.eVI = new int[4];
        this.eVI[0] = i;
        this.eVI[1] = i2;
        this.eVI[2] = i3;
        this.eVI[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.efB = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.eVJ = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.eVY = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.efA = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.eWl = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.efF = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eVK);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.efD = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.efF != null && this.efF.getAdapter() != null && this.efF.getAdapter().getCount() != 0) {
            this.efE.removeAllViews();
            this.efG = this.efF.getAdapter().getCount();
            int i = 0;
            while (i < this.efG) {
                boolean pi = this.efF.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.efF.getAdapter()).pi(i) : z;
                f(i, this.efF.getAdapter().getPageTitle(i).toString(), pi);
                i++;
                z = pi;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.efF.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.eVM = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void AG(String str) {
        if (this.efF != null && this.efF.getAdapter() != null && this.efF.getAdapter().getCount() != 0 && this.eVR && this.eWg != null) {
            this.eWg.setText(str);
        }
    }

    private void f(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.eWb);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.eWm != null) {
                        NewPagerSlidingTabBaseStrip.this.eWm.l(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.efF.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.eWl = true;
                        NewPagerSlidingTabBaseStrip.this.efF.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.eVI != null && this.eVI.length == 4) {
            view.setPadding(this.eVI[0], this.eVI[1], this.eVI[2], this.eVI[3]);
        }
        this.efE.addView(view, i, this.efJ ? this.efB : this.efA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.efG != 0) {
            int left = this.efE.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eVV;
            }
            if (left != this.efR) {
                this.efR = left;
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
        if (!isInEditMode() && this.efG != 0) {
            View childAt = this.efE.getChildAt(this.mCurrentTabIndex);
            if (this.eWa && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.eVX;
                right = childAt.getRight() - this.eVX;
            }
            if (this.eVL > 0.0f && this.mCurrentTabIndex != this.eVM && this.eVM <= this.efG - 1 && this.eVM >= 0) {
                View childAt2 = this.efE.getChildAt(this.eVM);
                if (this.eWa && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.eVX;
                    right2 = childAt2.getRight() - this.eVX;
                }
                left = e(left, left2, this.eVL);
                right = f(right, right2, this.eVL);
            }
            int height = getHeight();
            if (this.FG == null) {
                this.FG = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eVW, right + getPaddingLeft(), height - this.eVW);
            } else {
                this.FG.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eVW, right + getPaddingLeft(), height - this.eVW);
            }
            canvas.drawRoundRect(this.FG, this.eVZ, this.eVZ, this.efI);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.eVY + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.eVY + f2) - ((this.eVY * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.eVY + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.eVY) + ((this.eVY * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.eVT = R.color.cp_cont_b;
            this.eVU = R.color.cp_cont_j;
        } else {
            this.eVT = R.color.cp_cont_a;
            this.eVU = R.color.cp_cont_a;
        }
        this.efK = ao.getColor(this.eVT);
        this.edx = ao.getColor(this.eVU);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.efK = ao.getColor(this.eVT);
            this.edx = ao.getColor(this.eVU);
            this.efI.setColor(ao.getColor(this.eVS));
            this.eVO.setColor(ao.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eWf - 1.0f) / (0.1f - 1.0f))) + this.eWf;
        }
        return (((this.eWf - this.eWe) / 0.1f) * f) + this.eWe;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eWf) / (0.1f - 0.9f)));
        }
        return (((this.eWf - this.eWe) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eWf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.eVL;
        float f2 = this.eVM < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.efG) {
            View childAt = this.efE.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.efS);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.eVM ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (f2 >= 0.5f) {
                        if (i == this.eVM) {
                            textView.setTextColor(this.efK);
                        } else {
                            textView.setTextColor(this.edx);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.efK);
                    } else {
                        textView.setTextColor(this.edx);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.eVM) {
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
            if (NewPagerSlidingTabBaseStrip.this.efE.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.eWl) {
                    if (i == NewPagerSlidingTabBaseStrip.this.eVN) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eVM = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.eVN) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eVM = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.eVM = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.eVN = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eVM = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.eVL = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.efE.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.efD != null) {
                    NewPagerSlidingTabBaseStrip.this.efD.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.efE.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.efF.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.eVL = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.eWl = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.eVN = NewPagerSlidingTabBaseStrip.this.efF.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.eVN;
                    NewPagerSlidingTabBaseStrip.this.eVM = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.efD != null) {
                    NewPagerSlidingTabBaseStrip.this.efD.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.efD != null) {
                NewPagerSlidingTabBaseStrip.this.efD.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.eWl) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eVL * NewPagerSlidingTabBaseStrip.this.efE.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.eVN = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.eVM = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.efE.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.efE.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.efE.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Yz;
        this.eVM = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yz = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: S */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pj */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yz;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yz = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yz);
        }
    }

    public void setConcernTabIndex(int i) {
        this.eVQ = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.eVT = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.eVU = i;
    }

    public void setIndicatorRadius(int i) {
        this.eVZ = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eWm = aVar;
    }

    /* loaded from: classes15.dex */
    public class TabTextView extends TextView {
        boolean eWo;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.eWo = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.eWo = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.eWo) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.eWk) - NewPagerSlidingTabBaseStrip.this.eWi;
                int i = NewPagerSlidingTabBaseStrip.this.eWj;
                NewPagerSlidingTabBaseStrip.this.eVP.set(width, i, width + NewPagerSlidingTabBaseStrip.this.eWi, i + NewPagerSlidingTabBaseStrip.this.eWi);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.eVP, NewPagerSlidingTabBaseStrip.this.eVO);
            }
        }
    }
}
