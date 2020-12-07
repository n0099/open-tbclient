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
    private RectF Hx;
    private boolean bqt;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams eXY;
    private LinearLayout.LayoutParams eXZ;
    public ViewPager.OnPageChangeListener eYb;
    private LinearLayout eYc;
    private ViewPager eYd;
    private int eYe;
    private Paint eYg;
    private boolean eYh;
    private int eYi;
    private int eYj;
    private int eYs;
    private int eYt;
    private TextView fRA;
    private int fRB;
    private int fRC;
    private int fRD;
    private int fRE;
    private a fRF;
    private int[] fRc;
    private FrameLayout.LayoutParams fRd;
    private final b fRe;
    private float fRf;
    private int fRg;
    private int fRh;
    private Paint fRi;
    private RectF fRj;
    private int fRk;
    private boolean fRl;
    private int fRm;
    private int fRn;
    private int fRo;
    private int fRp;
    private int fRq;
    private int fRr;
    private int fRs;
    private int fRt;
    private boolean fRu;
    private int fRv;
    private int fRw;
    private int fRx;
    private float fRy;
    private float fRz;
    private boolean isLoading;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void q(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fRe = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fRf = 0.0f;
        this.fRg = 0;
        this.fRh = 0;
        this.eYh = false;
        this.fRl = false;
        this.fRm = R.color.CAM_X0312;
        this.fRn = R.color.CAM_X0105;
        this.fRo = R.color.CAM_X0107;
        this.eYi = ap.getColor(this.fRn);
        this.eYj = ap.getColor(this.fRo);
        this.fRp = 52;
        this.mIndicatorHeight = 4;
        this.fRt = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fRu = false;
        this.fRv = 17;
        this.fRw = 17;
        this.eYs = 0;
        this.eYt = R.drawable.pager_sliding_view;
        this.bqt = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fRl) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fRd == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fRd);
            }
            addView(this.mContainer);
        }
        this.eYc = new LinearLayout(getContext());
        this.eYc.setOrientation(0);
        if (this.fRl) {
            this.eYc.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.eYc);
        } else {
            this.eYc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.eYc);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fRp = (int) TypedValue.applyDimension(1, this.fRp, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fRv = i;
        this.fRw = i2;
        this.fRx = l.getDimens(getContext(), R.dimen.tbds74);
        this.fRy = (this.fRw * 1.0f) / this.fRv;
        this.fRz = (this.fRx * 1.0f) / this.fRv;
        this.mIndicatorHeight = i3;
        this.eYh = z;
        this.eYg = new Paint();
        this.eYg.setAntiAlias(true);
        this.eYg.setStyle(Paint.Style.FILL);
        this.eYg.setColor(ap.getColor(this.fRm));
        this.fRi = new Paint();
        this.fRi.setAntiAlias(true);
        this.fRi.setStyle(Paint.Style.FILL);
        this.fRi.setColor(ap.getColor(R.color.CAM_X0301));
        this.fRj = new RectF();
        this.fRC = l.getDimens(getContext(), R.dimen.tbds20);
        this.fRD = l.getDimens(getContext(), R.dimen.tbds16);
        this.fRE = l.getDimens(getContext(), R.dimen.tbds25);
        this.eXY = new LinearLayout.LayoutParams(-2, -1);
        this.eXZ = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fRr = l.getDimens(getContext(), R.dimen.tbds22);
        this.fRq = l.getDimens(getContext(), R.dimen.tbds20);
        this.fRs = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fRl && this.mContainer != null) {
            this.fRB = l.getDimens(getContext(), R.dimen.tbds32);
            this.fRA = new TextView(getContext());
            this.fRA.setGravity(17);
            this.fRA.setTextSize(0, this.fRB);
            this.fRA.setSingleLine();
            this.fRA.setTextColor(this.eYj);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fRA, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.fRx = i4;
        this.fRz = (this.fRx * 1.0f) / this.fRv;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fRl = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fRr = i;
        this.fRu = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fRu = true;
    }

    public void setRectPaintColor(int i) {
        this.fRm = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fRq = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fRc = new int[4];
        this.fRc[0] = i;
        this.fRc[1] = i2;
        this.fRc[2] = i3;
        this.fRc[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eXZ = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fRd = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fRs = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eXY = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.bqt = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eYd = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fRe);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eYb = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.eYd != null && this.eYd.getAdapter() != null && this.eYd.getAdapter().getCount() != 0) {
            this.eYc.removeAllViews();
            this.eYe = this.eYd.getAdapter().getCount();
            int i = 0;
            while (i < this.eYe) {
                boolean tF = this.eYd.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.eYd.getAdapter()).tF(i) : z;
                g(i, this.eYd.getAdapter().getPageTitle(i).toString(), tF);
                i++;
                z = tF;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.eYd.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fRg = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void Fa(String str) {
        if (this.eYd != null && this.eYd.getAdapter() != null && this.eYd.getAdapter().getCount() != 0 && this.fRl && this.fRA != null) {
            this.fRA.setText(str);
        }
    }

    private void g(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fRv);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fRF != null) {
                        NewPagerSlidingTabBaseStrip.this.fRF.q(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.eYd.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.bqt = true;
                        NewPagerSlidingTabBaseStrip.this.eYd.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fRc != null && this.fRc.length == 4) {
            view.setPadding(this.fRc[0], this.fRc[1], this.fRc[2], this.fRc[3]);
        }
        this.eYc.addView(view, i, this.eYh ? this.eXZ : this.eXY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eYe != 0) {
            int left = this.eYc.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fRp;
            }
            if (left != this.eYs) {
                this.eYs = left;
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
        if (!isInEditMode() && this.eYe != 0) {
            View childAt = this.eYc.getChildAt(this.mCurrentTabIndex);
            if (this.fRu && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fRr;
                right = childAt.getRight() - this.fRr;
            }
            if (this.fRf > 0.0f && this.mCurrentTabIndex != this.fRg && this.fRg <= this.eYe - 1 && this.fRg >= 0) {
                View childAt2 = this.eYc.getChildAt(this.fRg);
                if (this.fRu && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fRr;
                    right2 = childAt2.getRight() - this.fRr;
                }
                left = e(left, left2, this.fRf);
                right = f(right, right2, this.fRf);
            }
            int height = getHeight();
            if (this.Hx == null) {
                this.Hx = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fRq, right + getPaddingLeft(), height - this.fRq);
            } else {
                this.Hx.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fRq, right + getPaddingLeft(), height - this.fRq);
            }
            canvas.drawRoundRect(this.Hx, this.fRt, this.fRt, this.eYg);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fRs + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fRs + f2) - ((this.fRs * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fRs + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fRs) + ((this.fRs * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fRn = R.color.CAM_X0105;
            this.fRo = R.color.CAM_X0107;
        } else {
            this.fRn = R.color.CAM_X0101;
            this.fRo = R.color.CAM_X0101;
        }
        this.eYi = ap.getColor(this.fRn);
        this.eYj = ap.getColor(this.fRo);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.eYi = ap.getColor(this.fRn);
            this.eYj = ap.getColor(this.fRo);
            this.eYg.setColor(ap.getColor(this.fRm));
            this.fRi.setColor(ap.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float aq(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fRz - 1.0f) / (0.1f - 1.0f))) + this.fRz;
        }
        return (((this.fRz - this.fRy) / 0.1f) * f) + this.fRy;
    }

    private float ar(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fRz) / (0.1f - 0.9f)));
        }
        return (((this.fRz - this.fRy) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fRz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ar;
        float f = this.fRf;
        float f2 = this.fRg < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eYe) {
            View childAt = this.eYc.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eYt);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ar = aq(f2);
                    } else {
                        ar = i == this.fRg ? ar(f2) : 1.0f;
                    }
                    textView.setScaleX(ar);
                    textView.setScaleY(ar);
                    if (f2 >= 0.5f) {
                        if (i == this.fRg) {
                            textView.setTextColor(this.eYi);
                        } else {
                            textView.setTextColor(this.eYj);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eYi);
                    } else {
                        textView.setTextColor(this.eYj);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fRg) {
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
            if (NewPagerSlidingTabBaseStrip.this.eYc.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.bqt) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fRh) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fRg = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fRh) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fRg = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fRg = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fRh = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fRg = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fRf = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eYc.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.eYb != null) {
                    NewPagerSlidingTabBaseStrip.this.eYb.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eYc.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.eYd.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fRf = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.bqt = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fRh = NewPagerSlidingTabBaseStrip.this.eYd.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fRh;
                    NewPagerSlidingTabBaseStrip.this.fRg = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.eYb != null) {
                    NewPagerSlidingTabBaseStrip.this.eYb.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eYb != null) {
                NewPagerSlidingTabBaseStrip.this.eYb.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.bqt) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fRf * NewPagerSlidingTabBaseStrip.this.eYc.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fRh = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fRg = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.eYc.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.eYc.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.eYc.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.aaR;
        this.fRg = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aaR = this.mCurrentTabIndex;
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
            /* renamed from: tG */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aaR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aaR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aaR);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fRk = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fRn = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.fRo = i;
    }

    public void setIndicatorRadius(int i) {
        this.fRt = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fRF = aVar;
    }

    /* loaded from: classes21.dex */
    public class TabTextView extends TextView {
        boolean fRH;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fRH = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fRH = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fRH) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fRE) - NewPagerSlidingTabBaseStrip.this.fRC;
                int i = NewPagerSlidingTabBaseStrip.this.fRD;
                NewPagerSlidingTabBaseStrip.this.fRj.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fRC, i + NewPagerSlidingTabBaseStrip.this.fRC);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fRj, NewPagerSlidingTabBaseStrip.this.fRi);
            }
        }
    }
}
