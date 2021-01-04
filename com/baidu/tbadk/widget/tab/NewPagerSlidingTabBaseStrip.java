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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private boolean bsh;
    private int dividerPadding;
    private int dividerWidth;
    public ViewPager.OnPageChangeListener fhB;
    private LinearLayout fhC;
    private ViewPager fhD;
    private int fhE;
    private Paint fhG;
    private boolean fhH;
    private int fhI;
    private int fhJ;
    private int fhU;
    private LinearLayout.LayoutParams fhy;
    private LinearLayout.LayoutParams fhz;
    private int[] gaG;
    private FrameLayout.LayoutParams gaH;
    private final b gaI;
    private float gaJ;
    private int gaK;
    private int gaL;
    private Paint gaM;
    private RectF gaN;
    private int gaO;
    private boolean gaP;
    private int gaQ;
    private int gaR;
    private int gaS;
    private int gaT;
    private int gaU;
    private int gaV;
    private int gaW;
    private int gaX;
    private boolean gaY;
    private int gaZ;
    private int gba;
    private int gbb;
    private float gbc;
    private float gbd;
    private TextView gbe;
    private int gbf;
    private int gbg;
    private int gbh;
    private int gbi;
    private a gbj;
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
        this.gaI = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.gaJ = 0.0f;
        this.gaK = 0;
        this.gaL = 0;
        this.fhH = false;
        this.gaP = false;
        this.gaQ = R.color.CAM_X0312;
        this.gaR = R.color.CAM_X0105;
        this.gaS = R.color.CAM_X0107;
        this.fhI = ao.getColor(this.gaR);
        this.fhJ = ao.getColor(this.gaS);
        this.gaT = 52;
        this.mIndicatorHeight = 4;
        this.gaX = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.gaY = false;
        this.gaZ = 17;
        this.gba = 17;
        this.fhU = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bsh = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.gaP) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.gaH == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.gaH);
            }
            addView(this.mContainer);
        }
        this.fhC = new LinearLayout(getContext());
        this.fhC.setOrientation(0);
        if (this.gaP) {
            this.fhC.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.fhC);
        } else {
            this.fhC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.fhC);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.gaT = (int) TypedValue.applyDimension(1, this.gaT, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.gaZ = i;
        this.gba = i2;
        this.gbb = l.getDimens(getContext(), R.dimen.tbds74);
        this.gbc = (this.gba * 1.0f) / this.gaZ;
        this.gbd = (this.gbb * 1.0f) / this.gaZ;
        this.mIndicatorHeight = i3;
        this.fhH = z;
        this.fhG = new Paint();
        this.fhG.setAntiAlias(true);
        this.fhG.setStyle(Paint.Style.FILL);
        this.fhG.setColor(ao.getColor(this.gaQ));
        this.gaM = new Paint();
        this.gaM.setAntiAlias(true);
        this.gaM.setStyle(Paint.Style.FILL);
        this.gaM.setColor(ao.getColor(R.color.CAM_X0301));
        this.gaN = new RectF();
        this.gbg = l.getDimens(getContext(), R.dimen.tbds20);
        this.gbh = l.getDimens(getContext(), R.dimen.tbds16);
        this.gbi = l.getDimens(getContext(), R.dimen.tbds25);
        this.fhy = new LinearLayout.LayoutParams(-2, -1);
        this.fhz = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.gaV = l.getDimens(getContext(), R.dimen.tbds22);
        this.gaU = l.getDimens(getContext(), R.dimen.tbds20);
        this.gaW = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.gaP && this.mContainer != null) {
            this.gbf = l.getDimens(getContext(), R.dimen.tbds32);
            this.gbe = new TextView(getContext());
            this.gbe.setGravity(17);
            this.gbe.setTextSize(0, this.gbf);
            this.gbe.setSingleLine();
            this.gbe.setTextColor(this.fhJ);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.gbe, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        c(i, i2, i3, z);
        this.gbb = i4;
        this.gbd = (this.gbb * 1.0f) / this.gaZ;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.gaP = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.gaV = i;
        this.gaY = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.gaY = true;
    }

    public void setRectPaintColor(int i) {
        this.gaQ = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.gaU = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.gaG = new int[4];
        this.gaG[0] = i;
        this.gaG[1] = i2;
        this.gaG[2] = i3;
        this.gaG[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fhz = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.gaH = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.gaW = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fhy = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.bsh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fhD = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gaI);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fhB = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fhD != null && this.fhD.getAdapter() != null && this.fhD.getAdapter().getCount() != 0) {
            this.fhC.removeAllViews();
            this.fhE = this.fhD.getAdapter().getCount();
            boolean z = false;
            for (int i = 0; i < this.fhE; i++) {
                if (this.fhD.getAdapter() instanceof com.baidu.tbadk.widget.tab.a) {
                    z = ((com.baidu.tbadk.widget.tab.a) this.fhD.getAdapter()).tQ(i);
                }
                g(i, this.fhD.getAdapter().getPageTitle(i).toString(), z);
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fhD.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.gaK = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void EX(String str) {
        if (this.fhD != null && this.fhD.getAdapter() != null && this.fhD.getAdapter().getCount() != 0 && this.gaP && this.gbe != null) {
            this.gbe.setText(str);
        }
    }

    private void g(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.gaZ);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.gbj != null) {
                        NewPagerSlidingTabBaseStrip.this.gbj.t(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.fhD.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.bsh = true;
                        NewPagerSlidingTabBaseStrip.this.fhD.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.gaG != null && this.gaG.length == 4) {
            view.setPadding(this.gaG[0], this.gaG[1], this.gaG[2], this.gaG[3]);
        }
        this.fhC.addView(view, i, this.fhH ? this.fhz : this.fhy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fhE != 0) {
            int left = this.fhC.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.gaT;
            }
            if (left != this.fhU) {
                this.fhU = left;
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
        if (!isInEditMode() && this.fhE != 0) {
            View childAt = this.fhC.getChildAt(this.mCurrentTabIndex);
            if (this.gaY && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.gaV;
                right = childAt.getRight() - this.gaV;
            }
            if (this.gaJ > 0.0f && this.mCurrentTabIndex != this.gaK && this.gaK <= this.fhE - 1 && this.gaK >= 0) {
                View childAt2 = this.fhC.getChildAt(this.gaK);
                if (this.gaY && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.gaV;
                    right2 = childAt2.getRight() - this.gaV;
                }
                left = e(left, left2, this.gaJ);
                right = f(right, right2, this.gaJ);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.gaU, right + getPaddingLeft(), height - this.gaU);
            } else {
                this.rectF.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.gaU, right + getPaddingLeft(), height - this.gaU);
            }
            canvas.drawRoundRect(this.rectF, this.gaX, this.gaX, this.fhG);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.gaW + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.gaW + f2) - ((this.gaW * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.gaW + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.gaW) + ((this.gaW * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.gaR = R.color.CAM_X0105;
            this.gaS = R.color.CAM_X0107;
        } else {
            this.gaR = R.color.CAM_X0101;
            this.gaS = R.color.CAM_X0101;
        }
        this.fhI = ao.getColor(this.gaR);
        this.fhJ = ao.getColor(this.gaS);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.fhI = ao.getColor(this.gaR);
            this.fhJ = ao.getColor(this.gaS);
            this.fhG.setColor(ao.getColor(this.gaQ));
            this.gaM.setColor(ao.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.gbd - 1.0f) / (0.1f - 1.0f))) + this.gbd;
        }
        return (((this.gbd - this.gbc) / 0.1f) * f) + this.gbc;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.gbd) / (0.1f - 0.9f)));
        }
        return (((this.gbd - this.gbc) / (0.9f - 1.0f)) * (f - 0.9f)) + this.gbd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.gaJ;
        float f2 = this.gaK < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.fhE) {
            View childAt = this.fhC.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.gaK ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.gaK) {
                            textView.setTextColor(this.fhI);
                        } else {
                            textView.setTextColor(this.fhJ);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.fhI);
                    } else {
                        textView.setTextColor(this.fhJ);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.gaK) {
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
            if (NewPagerSlidingTabBaseStrip.this.fhC.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.bsh) {
                    if (i == NewPagerSlidingTabBaseStrip.this.gaL) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.gaK = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.gaL) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.gaK = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.gaK = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.gaL = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.gaK = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.gaJ = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fhC.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.fhB != null) {
                    NewPagerSlidingTabBaseStrip.this.fhB.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.fhC.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.fhD.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.gaJ = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.bsh = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.gaL = NewPagerSlidingTabBaseStrip.this.fhD.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.gaL;
                    NewPagerSlidingTabBaseStrip.this.gaK = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.fhB != null) {
                    NewPagerSlidingTabBaseStrip.this.fhB.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.fhB != null) {
                NewPagerSlidingTabBaseStrip.this.fhB.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.bsh) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.gaJ * NewPagerSlidingTabBaseStrip.this.fhC.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.gaL = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.gaK = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.fhC.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.fhC.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.fhC.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.abC;
        this.gaK = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abC = this.mCurrentTabIndex;
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
            /* renamed from: tR */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abC;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abC = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abC);
        }
    }

    public void setConcernTabIndex(int i) {
        this.gaO = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.gaR = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.gaS = i;
    }

    public void setIndicatorRadius(int i) {
        this.gaX = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gbj = aVar;
    }

    /* loaded from: classes.dex */
    public class TabTextView extends TextView {
        boolean gbl;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.gbl = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.gbl = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.gbl) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.gbi) - NewPagerSlidingTabBaseStrip.this.gbg;
                int i = NewPagerSlidingTabBaseStrip.this.gbh;
                NewPagerSlidingTabBaseStrip.this.gaN.set(width, i, width + NewPagerSlidingTabBaseStrip.this.gbg, i + NewPagerSlidingTabBaseStrip.this.gbg);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.gaN, NewPagerSlidingTabBaseStrip.this.gaM);
            }
        }
    }
}
