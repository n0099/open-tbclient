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
    private int dCe;
    private int dEC;
    private int dED;
    private LinearLayout.LayoutParams dEj;
    private LinearLayout.LayoutParams dEk;
    public ViewPager.OnPageChangeListener dEm;
    private LinearLayout dEn;
    private ViewPager dEo;
    private int dEp;
    private Paint dEr;
    private boolean dEs;
    private int dEt;
    private int dGs;
    private int dividerPadding;
    private int eqA;
    private int eqB;
    private int eqC;
    private int eqD;
    private int eqE;
    private int eqF;
    private int eqG;
    private boolean eqH;
    private int eqI;
    private int eqJ;
    private int eqK;
    private float eqL;
    private float eqM;
    private TextView eqN;
    private int eqO;
    private int eqP;
    private int eqQ;
    private int eqR;
    private boolean eqS;
    private a eqT;
    private int[] eqp;
    private FrameLayout.LayoutParams eqq;
    private final b eqr;
    private float eqs;
    private int eqt;
    private int equ;
    private Paint eqv;
    private RectF eqw;
    private int eqx;
    private boolean eqy;
    private int eqz;
    private boolean isLoading;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void j(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqr = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eqs = 0.0f;
        this.eqt = 0;
        this.equ = 0;
        this.dEs = false;
        this.eqy = false;
        this.eqz = R.color.cp_other_f;
        this.eqA = R.color.cp_cont_b;
        this.eqB = R.color.cp_cont_j;
        this.dEt = am.getColor(this.eqA);
        this.dCe = am.getColor(this.eqB);
        this.eqC = 52;
        this.mIndicatorHeight = 4;
        this.eqG = 16;
        this.dividerPadding = 12;
        this.dGs = 1;
        this.eqH = false;
        this.eqI = 17;
        this.eqJ = 17;
        this.dEC = 0;
        this.dED = R.drawable.pager_sliding_view;
        this.eqS = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.eqy) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.eqq == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.eqq);
            }
            addView(this.mContainer);
        }
        this.dEn = new LinearLayout(getContext());
        this.dEn.setOrientation(0);
        if (this.eqy) {
            this.dEn.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.dEn);
        } else {
            this.dEn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.dEn);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eqC = (int) TypedValue.applyDimension(1, this.eqC, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dGs = (int) TypedValue.applyDimension(1, this.dGs, displayMetrics);
        this.eqI = i;
        this.eqJ = i2;
        this.eqK = l.getDimens(getContext(), R.dimen.tbds74);
        this.eqL = (this.eqJ * 1.0f) / this.eqI;
        this.eqM = (this.eqK * 1.0f) / this.eqI;
        this.mIndicatorHeight = i3;
        this.dEs = z;
        this.dEr = new Paint();
        this.dEr.setAntiAlias(true);
        this.dEr.setStyle(Paint.Style.FILL);
        this.dEr.setColor(am.getColor(this.eqz));
        this.eqv = new Paint();
        this.eqv.setAntiAlias(true);
        this.eqv.setStyle(Paint.Style.FILL);
        this.eqv.setColor(am.getColor(R.color.cp_cont_h));
        this.eqw = new RectF();
        this.eqP = l.getDimens(getContext(), R.dimen.tbds20);
        this.eqQ = l.getDimens(getContext(), R.dimen.tbds16);
        this.eqR = l.getDimens(getContext(), R.dimen.tbds25);
        this.dEj = new LinearLayout.LayoutParams(-2, -1);
        this.dEk = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.eqE = l.getDimens(getContext(), R.dimen.tbds22);
        this.eqD = l.getDimens(getContext(), R.dimen.tbds20);
        this.eqF = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.eqy && this.mContainer != null) {
            this.eqO = l.getDimens(getContext(), R.dimen.tbds32);
            this.eqN = new TextView(getContext());
            this.eqN.setGravity(17);
            this.eqN.setTextSize(0, this.eqO);
            this.eqN.setSingleLine();
            this.eqN.setTextColor(this.dCe);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.eqN, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.eqK = i4;
        this.eqM = (this.eqK * 1.0f) / this.eqI;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.eqy = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.eqE = i;
        this.eqH = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.eqH = true;
    }

    public void setRectPaintColor(int i) {
        this.eqz = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.eqD = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.eqp = new int[4];
        this.eqp[0] = i;
        this.eqp[1] = i2;
        this.eqp[2] = i3;
        this.eqp[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dEk = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.eqq = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.eqF = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dEj = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.eqS = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dEo = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eqr);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEm = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.dEo != null && this.dEo.getAdapter() != null && this.dEo.getAdapter().getCount() != 0) {
            this.dEn.removeAllViews();
            this.dEp = this.dEo.getAdapter().getCount();
            int i = 0;
            while (i < this.dEp) {
                boolean nM = this.dEo.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.dEo.getAdapter()).nM(i) : z;
                e(i, this.dEo.getAdapter().getPageTitle(i).toString(), nM);
                i++;
                z = nM;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dEo.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.eqt = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void xz(String str) {
        if (this.dEo != null && this.dEo.getAdapter() != null && this.dEo.getAdapter().getCount() != 0 && this.eqy && this.eqN != null) {
            this.eqN.setText(str);
        }
    }

    private void e(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.eqI);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.eqT != null) {
                        NewPagerSlidingTabBaseStrip.this.eqT.j(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.dEo.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.eqS = true;
                        NewPagerSlidingTabBaseStrip.this.dEo.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.eqp != null && this.eqp.length == 4) {
            view.setPadding(this.eqp[0], this.eqp[1], this.eqp[2], this.eqp[3]);
        }
        this.dEn.addView(view, i, this.dEs ? this.dEk : this.dEj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dEp != 0) {
            int left = this.dEn.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eqC;
            }
            if (left != this.dEC) {
                this.dEC = left;
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
        if (!isInEditMode() && this.dEp != 0) {
            View childAt = this.dEn.getChildAt(this.mCurrentTabIndex);
            if (this.eqH && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.eqE;
                right = childAt.getRight() - this.eqE;
            }
            if (this.eqs > 0.0f && this.mCurrentTabIndex != this.eqt && this.eqt <= this.dEp - 1 && this.eqt >= 0) {
                View childAt2 = this.dEn.getChildAt(this.eqt);
                if (this.eqH && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.eqE;
                    right2 = childAt2.getRight() - this.eqE;
                }
                left = e(left, left2, this.eqs);
                right = f(right, right2, this.eqs);
            }
            int height = getHeight();
            if (this.Fg == null) {
                this.Fg = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eqD, right + getPaddingLeft(), height - this.eqD);
            } else {
                this.Fg.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eqD, right + getPaddingLeft(), height - this.eqD);
            }
            canvas.drawRoundRect(this.Fg, this.eqG, this.eqG, this.dEr);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.eqF + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.eqF + f2) - ((this.eqF * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.eqF + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.eqF) + ((this.eqF * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.eqA = R.color.cp_cont_b;
            this.eqB = R.color.cp_cont_j;
        } else {
            this.eqA = R.color.cp_cont_a;
            this.eqB = R.color.cp_cont_a;
        }
        this.dEt = am.getColor(this.eqA);
        this.dCe = am.getColor(this.eqB);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dEt = am.getColor(this.eqA);
            this.dCe = am.getColor(this.eqB);
            this.dEr.setColor(am.getColor(this.eqz));
            this.eqv.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eqM - 1.0f) / (0.1f - 1.0f))) + this.eqM;
        }
        return (((this.eqM - this.eqL) / 0.1f) * f) + this.eqL;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eqM) / (0.1f - 0.9f)));
        }
        return (((this.eqM - this.eqL) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eqM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.eqs;
        float f2 = this.eqt < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dEp) {
            View childAt = this.dEn.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dED);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.eqt ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (f2 >= 0.5f) {
                        if (i == this.eqt) {
                            textView.setTextColor(this.dEt);
                        } else {
                            textView.setTextColor(this.dCe);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dEt);
                    } else {
                        textView.setTextColor(this.dCe);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.eqt) {
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
            if (NewPagerSlidingTabBaseStrip.this.dEn.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.eqS) {
                    if (i == NewPagerSlidingTabBaseStrip.this.equ) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eqt = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.equ) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eqt = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.eqt = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.equ = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eqt = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.eqs = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dEn.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.dEm != null) {
                    NewPagerSlidingTabBaseStrip.this.dEm.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dEn.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.dEo.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.eqs = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.eqS = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.equ = NewPagerSlidingTabBaseStrip.this.dEo.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.equ;
                    NewPagerSlidingTabBaseStrip.this.eqt = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.dEm != null) {
                    NewPagerSlidingTabBaseStrip.this.dEm.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dEm != null) {
                NewPagerSlidingTabBaseStrip.this.dEm.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.eqS) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eqs * NewPagerSlidingTabBaseStrip.this.dEn.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.equ = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.eqt = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.dEn.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.dEn.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.dEn.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.XP;
        this.eqt = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.XP = this.mCurrentTabIndex;
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
            /* renamed from: nN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int XP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.XP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XP);
        }
    }

    public void setConcernTabIndex(int i) {
        this.eqx = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.eqA = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.eqB = i;
    }

    public void setIndicatorRadius(int i) {
        this.eqG = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eqT = aVar;
    }

    /* loaded from: classes8.dex */
    public class TabTextView extends TextView {
        boolean eqV;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.eqV = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.eqV = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.eqV) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.eqR) - NewPagerSlidingTabBaseStrip.this.eqP;
                int i = NewPagerSlidingTabBaseStrip.this.eqQ;
                NewPagerSlidingTabBaseStrip.this.eqw.set(width, i, width + NewPagerSlidingTabBaseStrip.this.eqP, i + NewPagerSlidingTabBaseStrip.this.eqP);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.eqw, NewPagerSlidingTabBaseStrip.this.eqv);
            }
        }
    }
}
