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
    private boolean bsw;
    private int dividerPadding;
    private int dividerWidth;
    private int[] fZO;
    private FrameLayout.LayoutParams fZP;
    private final b fZQ;
    private float fZR;
    private int fZS;
    private int fZT;
    private Paint fZU;
    private RectF fZV;
    private int fZW;
    private boolean fZX;
    private int fZY;
    private int fZZ;
    private LinearLayout.LayoutParams fgE;
    private LinearLayout.LayoutParams fgF;
    public ViewPager.OnPageChangeListener fgH;
    private LinearLayout fgI;
    private ViewPager fgJ;
    private int fgK;
    private Paint fgM;
    private boolean fgN;
    private int fgO;
    private int fgP;
    private int fha;
    private int gaa;
    private int gab;
    private int gac;
    private int gad;
    private int gae;
    private int gaf;
    private boolean gag;
    private int gah;
    private int gai;
    private int gaj;
    private float gak;
    private float gal;
    private TextView gam;
    private int gan;
    private int gao;
    private int gaq;
    private int gar;
    private a gas;
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
        this.fZQ = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fZR = 0.0f;
        this.fZS = 0;
        this.fZT = 0;
        this.fgN = false;
        this.fZX = false;
        this.fZY = R.color.CAM_X0312;
        this.fZZ = R.color.CAM_X0105;
        this.gaa = R.color.CAM_X0107;
        this.fgO = ap.getColor(this.fZZ);
        this.fgP = ap.getColor(this.gaa);
        this.gab = 52;
        this.mIndicatorHeight = 4;
        this.gaf = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.gag = false;
        this.gah = 17;
        this.gai = 17;
        this.fha = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bsw = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fZX) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fZP == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fZP);
            }
            addView(this.mContainer);
        }
        this.fgI = new LinearLayout(getContext());
        this.fgI.setOrientation(0);
        if (this.fZX) {
            this.fgI.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.fgI);
        } else {
            this.fgI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.fgI);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.gab = (int) TypedValue.applyDimension(1, this.gab, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.gah = i;
        this.gai = i2;
        this.gaj = l.getDimens(getContext(), R.dimen.tbds74);
        this.gak = (this.gai * 1.0f) / this.gah;
        this.gal = (this.gaj * 1.0f) / this.gah;
        this.mIndicatorHeight = i3;
        this.fgN = z;
        this.fgM = new Paint();
        this.fgM.setAntiAlias(true);
        this.fgM.setStyle(Paint.Style.FILL);
        this.fgM.setColor(ap.getColor(this.fZY));
        this.fZU = new Paint();
        this.fZU.setAntiAlias(true);
        this.fZU.setStyle(Paint.Style.FILL);
        this.fZU.setColor(ap.getColor(R.color.CAM_X0301));
        this.fZV = new RectF();
        this.gao = l.getDimens(getContext(), R.dimen.tbds20);
        this.gaq = l.getDimens(getContext(), R.dimen.tbds16);
        this.gar = l.getDimens(getContext(), R.dimen.tbds25);
        this.fgE = new LinearLayout.LayoutParams(-2, -1);
        this.fgF = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.gad = l.getDimens(getContext(), R.dimen.tbds22);
        this.gac = l.getDimens(getContext(), R.dimen.tbds20);
        this.gae = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fZX && this.mContainer != null) {
            this.gan = l.getDimens(getContext(), R.dimen.tbds32);
            this.gam = new TextView(getContext());
            this.gam.setGravity(17);
            this.gam.setTextSize(0, this.gan);
            this.gam.setSingleLine();
            this.gam.setTextColor(this.fgP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.gam, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        c(i, i2, i3, z);
        this.gaj = i4;
        this.gal = (this.gaj * 1.0f) / this.gah;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fZX = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.gad = i;
        this.gag = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.gag = true;
    }

    public void setRectPaintColor(int i) {
        this.fZY = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.gac = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fZO = new int[4];
        this.fZO[0] = i;
        this.fZO[1] = i2;
        this.fZO[2] = i3;
        this.fZO[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fgF = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fZP = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.gae = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fgE = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.bsw = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fgJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fZQ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fgH = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fgJ != null && this.fgJ.getAdapter() != null && this.fgJ.getAdapter().getCount() != 0) {
            this.fgI.removeAllViews();
            this.fgK = this.fgJ.getAdapter().getCount();
            boolean z = false;
            for (int i = 0; i < this.fgK; i++) {
                if (this.fgJ.getAdapter() instanceof com.baidu.tbadk.widget.tab.a) {
                    z = ((com.baidu.tbadk.widget.tab.a) this.fgJ.getAdapter()).sr(i);
                }
                f(i, this.fgJ.getAdapter().getPageTitle(i).toString(), z);
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fgJ.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fZS = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void En(String str) {
        if (this.fgJ != null && this.fgJ.getAdapter() != null && this.fgJ.getAdapter().getCount() != 0 && this.fZX && this.gam != null) {
            this.gam.setText(str);
        }
    }

    private void f(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.gah);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.gas != null) {
                        NewPagerSlidingTabBaseStrip.this.gas.t(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.fgJ.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.bsw = true;
                        NewPagerSlidingTabBaseStrip.this.fgJ.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fZO != null && this.fZO.length == 4) {
            view.setPadding(this.fZO[0], this.fZO[1], this.fZO[2], this.fZO[3]);
        }
        this.fgI.addView(view, i, this.fgN ? this.fgF : this.fgE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fgK != 0) {
            int left = this.fgI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.gab;
            }
            if (left != this.fha) {
                this.fha = left;
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
        if (!isInEditMode() && this.fgK != 0) {
            View childAt = this.fgI.getChildAt(this.mCurrentTabIndex);
            if (this.gag && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.gad;
                right = childAt.getRight() - this.gad;
            }
            if (this.fZR > 0.0f && this.mCurrentTabIndex != this.fZS && this.fZS <= this.fgK - 1 && this.fZS >= 0) {
                View childAt2 = this.fgI.getChildAt(this.fZS);
                if (this.gag && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.gad;
                    right2 = childAt2.getRight() - this.gad;
                }
                left = e(left, left2, this.fZR);
                right = f(right, right2, this.fZR);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.gac, right + getPaddingLeft(), height - this.gac);
            } else {
                this.rectF.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.gac, right + getPaddingLeft(), height - this.gac);
            }
            canvas.drawRoundRect(this.rectF, this.gaf, this.gaf, this.fgM);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.gae + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.gae + f2) - ((this.gae * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.gae + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.gae) + ((this.gae * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fZZ = R.color.CAM_X0105;
            this.gaa = R.color.CAM_X0107;
        } else {
            this.fZZ = R.color.CAM_X0101;
            this.gaa = R.color.CAM_X0101;
        }
        this.fgO = ap.getColor(this.fZZ);
        this.fgP = ap.getColor(this.gaa);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.fgO = ap.getColor(this.fZZ);
            this.fgP = ap.getColor(this.gaa);
            this.fgM.setColor(ap.getColor(this.fZY));
            this.fZU.setColor(ap.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float ax(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.gal - 1.0f) / (0.1f - 1.0f))) + this.gal;
        }
        return (((this.gal - this.gak) / 0.1f) * f) + this.gak;
    }

    private float ay(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.gal) / (0.1f - 0.9f)));
        }
        return (((this.gal - this.gak) / (0.9f - 1.0f)) * (f - 0.9f)) + this.gal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ay;
        float f = this.fZR;
        float f2 = this.fZS < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.fgK) {
            View childAt = this.fgI.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ay = ax(f2);
                    } else {
                        ay = i == this.fZS ? ay(f2) : 1.0f;
                    }
                    textView.setScaleX(ay);
                    textView.setScaleY(ay);
                    if (f2 >= 0.5f) {
                        if (i == this.fZS) {
                            textView.setTextColor(this.fgO);
                        } else {
                            textView.setTextColor(this.fgP);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.fgO);
                    } else {
                        textView.setTextColor(this.fgP);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fZS) {
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
            if (NewPagerSlidingTabBaseStrip.this.fgI.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.bsw) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fZT) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fZS = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fZT) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fZS = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fZS = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fZT = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fZS = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fZR = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fgI.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.fgH != null) {
                    NewPagerSlidingTabBaseStrip.this.fgH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.fgI.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.fgJ.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fZR = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.bsw = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fZT = NewPagerSlidingTabBaseStrip.this.fgJ.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fZT;
                    NewPagerSlidingTabBaseStrip.this.fZS = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.fgH != null) {
                    NewPagerSlidingTabBaseStrip.this.fgH.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.fgH != null) {
                NewPagerSlidingTabBaseStrip.this.fgH.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.bsw) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fZR * NewPagerSlidingTabBaseStrip.this.fgI.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fZT = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fZS = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.fgI.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.fgI.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.fgI.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.acR;
        this.fZS = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.acR = this.mCurrentTabIndex;
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
            /* renamed from: ss */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int acR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.acR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.acR);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fZW = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fZZ = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.gaa = i;
    }

    public void setIndicatorRadius(int i) {
        this.gaf = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gas = aVar;
    }

    /* loaded from: classes.dex */
    public class TabTextView extends TextView {
        boolean gau;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.gau = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.gau = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.gau) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.gar) - NewPagerSlidingTabBaseStrip.this.gao;
                int i = NewPagerSlidingTabBaseStrip.this.gaq;
                NewPagerSlidingTabBaseStrip.this.fZV.set(width, i, width + NewPagerSlidingTabBaseStrip.this.gao, i + NewPagerSlidingTabBaseStrip.this.gao);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fZV, NewPagerSlidingTabBaseStrip.this.fZU);
            }
        }
    }
}
