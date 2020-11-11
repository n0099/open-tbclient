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
    private LinearLayout.LayoutParams eRF;
    private LinearLayout.LayoutParams eRG;
    public ViewPager.OnPageChangeListener eRI;
    private LinearLayout eRJ;
    private ViewPager eRK;
    private int eRL;
    private Paint eRN;
    private boolean eRO;
    private int eRP;
    private int eRQ;
    private int eRX;
    private int eRY;
    private int[] fJN;
    private FrameLayout.LayoutParams fJO;
    private final b fJP;
    private float fJQ;
    private int fJR;
    private int fJS;
    private Paint fJT;
    private RectF fJU;
    private int fJV;
    private boolean fJW;
    private int fJX;
    private int fJY;
    private int fJZ;
    private int fKa;
    private int fKb;
    private int fKc;
    private int fKd;
    private int fKe;
    private boolean fKf;
    private int fKg;
    private int fKh;
    private int fKi;
    private float fKj;
    private float fKk;
    private TextView fKl;
    private int fKm;
    private int fKn;
    private int fKo;
    private int fKp;
    private boolean fKq;
    private a fKr;
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
        this.fJP = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fJQ = 0.0f;
        this.fJR = 0;
        this.fJS = 0;
        this.eRO = false;
        this.fJW = false;
        this.fJX = R.color.cp_other_f;
        this.fJY = R.color.cp_cont_b;
        this.fJZ = R.color.cp_cont_j;
        this.eRP = ap.getColor(this.fJY);
        this.eRQ = ap.getColor(this.fJZ);
        this.fKa = 52;
        this.mIndicatorHeight = 4;
        this.fKe = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fKf = false;
        this.fKg = 17;
        this.fKh = 17;
        this.eRX = 0;
        this.eRY = R.drawable.pager_sliding_view;
        this.fKq = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fJW) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fJO == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fJO);
            }
            addView(this.mContainer);
        }
        this.eRJ = new LinearLayout(getContext());
        this.eRJ.setOrientation(0);
        if (this.fJW) {
            this.eRJ.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.eRJ);
        } else {
            this.eRJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.eRJ);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fKa = (int) TypedValue.applyDimension(1, this.fKa, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fKg = i;
        this.fKh = i2;
        this.fKi = l.getDimens(getContext(), R.dimen.tbds74);
        this.fKj = (this.fKh * 1.0f) / this.fKg;
        this.fKk = (this.fKi * 1.0f) / this.fKg;
        this.mIndicatorHeight = i3;
        this.eRO = z;
        this.eRN = new Paint();
        this.eRN.setAntiAlias(true);
        this.eRN.setStyle(Paint.Style.FILL);
        this.eRN.setColor(ap.getColor(this.fJX));
        this.fJT = new Paint();
        this.fJT.setAntiAlias(true);
        this.fJT.setStyle(Paint.Style.FILL);
        this.fJT.setColor(ap.getColor(R.color.cp_cont_h));
        this.fJU = new RectF();
        this.fKn = l.getDimens(getContext(), R.dimen.tbds20);
        this.fKo = l.getDimens(getContext(), R.dimen.tbds16);
        this.fKp = l.getDimens(getContext(), R.dimen.tbds25);
        this.eRF = new LinearLayout.LayoutParams(-2, -1);
        this.eRG = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fKc = l.getDimens(getContext(), R.dimen.tbds22);
        this.fKb = l.getDimens(getContext(), R.dimen.tbds20);
        this.fKd = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fJW && this.mContainer != null) {
            this.fKm = l.getDimens(getContext(), R.dimen.tbds32);
            this.fKl = new TextView(getContext());
            this.fKl.setGravity(17);
            this.fKl.setTextSize(0, this.fKm);
            this.fKl.setSingleLine();
            this.fKl.setTextColor(this.eRQ);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fKl, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.fKi = i4;
        this.fKk = (this.fKi * 1.0f) / this.fKg;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fJW = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fKc = i;
        this.fKf = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fKf = true;
    }

    public void setRectPaintColor(int i) {
        this.fJX = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fKb = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fJN = new int[4];
        this.fJN[0] = i;
        this.fJN[1] = i2;
        this.fJN[2] = i3;
        this.fJN[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eRG = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fJO = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fKd = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eRF = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.fKq = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eRK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fJP);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eRI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.eRK != null && this.eRK.getAdapter() != null && this.eRK.getAdapter().getCount() != 0) {
            this.eRJ.removeAllViews();
            this.eRL = this.eRK.getAdapter().getCount();
            int i = 0;
            while (i < this.eRL) {
                boolean sE = this.eRK.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.eRK.getAdapter()).sE(i) : z;
                g(i, this.eRK.getAdapter().getPageTitle(i).toString(), sE);
                i++;
                z = sE;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.eRK.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fJR = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void EL(String str) {
        if (this.eRK != null && this.eRK.getAdapter() != null && this.eRK.getAdapter().getCount() != 0 && this.fJW && this.fKl != null) {
            this.fKl.setText(str);
        }
    }

    private void g(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fKg);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fKr != null) {
                        NewPagerSlidingTabBaseStrip.this.fKr.n(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.eRK.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.fKq = true;
                        NewPagerSlidingTabBaseStrip.this.eRK.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fJN != null && this.fJN.length == 4) {
            view.setPadding(this.fJN[0], this.fJN[1], this.fJN[2], this.fJN[3]);
        }
        this.eRJ.addView(view, i, this.eRO ? this.eRG : this.eRF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eRL != 0) {
            int left = this.eRJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fKa;
            }
            if (left != this.eRX) {
                this.eRX = left;
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
        if (!isInEditMode() && this.eRL != 0) {
            View childAt = this.eRJ.getChildAt(this.mCurrentTabIndex);
            if (this.fKf && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fKc;
                right = childAt.getRight() - this.fKc;
            }
            if (this.fJQ > 0.0f && this.mCurrentTabIndex != this.fJR && this.fJR <= this.eRL - 1 && this.fJR >= 0) {
                View childAt2 = this.eRJ.getChildAt(this.fJR);
                if (this.fKf && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fKc;
                    right2 = childAt2.getRight() - this.fKc;
                }
                left = e(left, left2, this.fJQ);
                right = f(right, right2, this.fJQ);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fKb, right + getPaddingLeft(), height - this.fKb);
            } else {
                this.GD.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fKb, right + getPaddingLeft(), height - this.fKb);
            }
            canvas.drawRoundRect(this.GD, this.fKe, this.fKe, this.eRN);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fKd + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fKd + f2) - ((this.fKd * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fKd + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fKd) + ((this.fKd * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fJY = R.color.cp_cont_b;
            this.fJZ = R.color.cp_cont_j;
        } else {
            this.fJY = R.color.cp_cont_a;
            this.fJZ = R.color.cp_cont_a;
        }
        this.eRP = ap.getColor(this.fJY);
        this.eRQ = ap.getColor(this.fJZ);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.eRP = ap.getColor(this.fJY);
            this.eRQ = ap.getColor(this.fJZ);
            this.eRN.setColor(ap.getColor(this.fJX));
            this.fJT.setColor(ap.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float an(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fKk - 1.0f) / (0.1f - 1.0f))) + this.fKk;
        }
        return (((this.fKk - this.fKj) / 0.1f) * f) + this.fKj;
    }

    private float ao(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fKk) / (0.1f - 0.9f)));
        }
        return (((this.fKk - this.fKj) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fKk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ao;
        float f = this.fJQ;
        float f2 = this.fJR < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eRL) {
            View childAt = this.eRJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eRY);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ao = an(f2);
                    } else {
                        ao = i == this.fJR ? ao(f2) : 1.0f;
                    }
                    textView.setScaleX(ao);
                    textView.setScaleY(ao);
                    if (f2 >= 0.5f) {
                        if (i == this.fJR) {
                            textView.setTextColor(this.eRP);
                        } else {
                            textView.setTextColor(this.eRQ);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eRP);
                    } else {
                        textView.setTextColor(this.eRQ);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fJR) {
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
            if (NewPagerSlidingTabBaseStrip.this.eRJ.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.fKq) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fJS) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fJR = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fJS) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fJR = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fJR = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fJS = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fJR = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fJQ = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eRJ.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.eRI != null) {
                    NewPagerSlidingTabBaseStrip.this.eRI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eRJ.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.eRK.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fJQ = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.fKq = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fJS = NewPagerSlidingTabBaseStrip.this.eRK.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fJS;
                    NewPagerSlidingTabBaseStrip.this.fJR = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.eRI != null) {
                    NewPagerSlidingTabBaseStrip.this.eRI.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eRI != null) {
                NewPagerSlidingTabBaseStrip.this.eRI.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.fKq) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fJQ * NewPagerSlidingTabBaseStrip.this.eRJ.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fJS = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fJR = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.eRJ.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.eRJ.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.eRJ.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZQ;
        this.fJR = this.mCurrentTabIndex;
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
            /* renamed from: sF */
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
        this.fJV = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fJY = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.fJZ = i;
    }

    public void setIndicatorRadius(int i) {
        this.fKe = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fKr = aVar;
    }

    /* loaded from: classes21.dex */
    public class TabTextView extends TextView {
        boolean fKt;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fKt = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fKt = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fKt) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fKp) - NewPagerSlidingTabBaseStrip.this.fKn;
                int i = NewPagerSlidingTabBaseStrip.this.fKo;
                NewPagerSlidingTabBaseStrip.this.fJU.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fKn, i + NewPagerSlidingTabBaseStrip.this.fKn);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fJU, NewPagerSlidingTabBaseStrip.this.fJT);
            }
        }
    }
}
