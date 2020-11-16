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
    private RectF GD;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams eQH;
    private LinearLayout.LayoutParams eQI;
    public ViewPager.OnPageChangeListener eQK;
    private LinearLayout eQL;
    private ViewPager eQM;
    private int eQN;
    private Paint eQP;
    private boolean eQQ;
    private int eQR;
    private int eQS;
    private int eQZ;
    private int eRa;
    private int fJA;
    private int fJB;
    private int fJC;
    private int fJD;
    private int fJE;
    private int fJF;
    private int fJG;
    private int fJH;
    private boolean fJI;
    private int fJJ;
    private int fJK;
    private int fJL;
    private float fJM;
    private float fJN;
    private TextView fJO;
    private int fJP;
    private int fJQ;
    private int fJR;
    private int fJS;
    private boolean fJT;
    private a fJU;
    private int[] fJq;
    private FrameLayout.LayoutParams fJr;
    private final b fJs;
    private float fJt;
    private int fJu;
    private int fJv;
    private Paint fJw;
    private RectF fJx;
    private int fJy;
    private boolean fJz;
    private boolean isLoading;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
    private int mSkinType;

    /* loaded from: classes20.dex */
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
        this.fJs = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fJt = 0.0f;
        this.fJu = 0;
        this.fJv = 0;
        this.eQQ = false;
        this.fJz = false;
        this.fJA = R.color.CAM_X0312;
        this.fJB = R.color.CAM_X0105;
        this.fJC = R.color.CAM_X0107;
        this.eQR = ap.getColor(this.fJB);
        this.eQS = ap.getColor(this.fJC);
        this.fJD = 52;
        this.mIndicatorHeight = 4;
        this.fJH = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fJI = false;
        this.fJJ = 17;
        this.fJK = 17;
        this.eQZ = 0;
        this.eRa = R.drawable.pager_sliding_view;
        this.fJT = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fJz) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fJr == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fJr);
            }
            addView(this.mContainer);
        }
        this.eQL = new LinearLayout(getContext());
        this.eQL.setOrientation(0);
        if (this.fJz) {
            this.eQL.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.eQL);
        } else {
            this.eQL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.eQL);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fJD = (int) TypedValue.applyDimension(1, this.fJD, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fJJ = i;
        this.fJK = i2;
        this.fJL = l.getDimens(getContext(), R.dimen.tbds74);
        this.fJM = (this.fJK * 1.0f) / this.fJJ;
        this.fJN = (this.fJL * 1.0f) / this.fJJ;
        this.mIndicatorHeight = i3;
        this.eQQ = z;
        this.eQP = new Paint();
        this.eQP.setAntiAlias(true);
        this.eQP.setStyle(Paint.Style.FILL);
        this.eQP.setColor(ap.getColor(this.fJA));
        this.fJw = new Paint();
        this.fJw.setAntiAlias(true);
        this.fJw.setStyle(Paint.Style.FILL);
        this.fJw.setColor(ap.getColor(R.color.CAM_X0301));
        this.fJx = new RectF();
        this.fJQ = l.getDimens(getContext(), R.dimen.tbds20);
        this.fJR = l.getDimens(getContext(), R.dimen.tbds16);
        this.fJS = l.getDimens(getContext(), R.dimen.tbds25);
        this.eQH = new LinearLayout.LayoutParams(-2, -1);
        this.eQI = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fJF = l.getDimens(getContext(), R.dimen.tbds22);
        this.fJE = l.getDimens(getContext(), R.dimen.tbds20);
        this.fJG = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fJz && this.mContainer != null) {
            this.fJP = l.getDimens(getContext(), R.dimen.tbds32);
            this.fJO = new TextView(getContext());
            this.fJO.setGravity(17);
            this.fJO.setTextSize(0, this.fJP);
            this.fJO.setSingleLine();
            this.fJO.setTextColor(this.eQS);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fJO, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.fJL = i4;
        this.fJN = (this.fJL * 1.0f) / this.fJJ;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fJz = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fJF = i;
        this.fJI = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fJI = true;
    }

    public void setRectPaintColor(int i) {
        this.fJA = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fJE = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fJq = new int[4];
        this.fJq[0] = i;
        this.fJq[1] = i2;
        this.fJq[2] = i3;
        this.fJq[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eQI = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fJr = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fJG = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eQH = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.fJT = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eQM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fJs);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eQK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.eQM != null && this.eQM.getAdapter() != null && this.eQM.getAdapter().getCount() != 0) {
            this.eQL.removeAllViews();
            this.eQN = this.eQM.getAdapter().getCount();
            int i = 0;
            while (i < this.eQN) {
                boolean tc = this.eQM.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.eQM.getAdapter()).tc(i) : z;
                g(i, this.eQM.getAdapter().getPageTitle(i).toString(), tc);
                i++;
                z = tc;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.eQM.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fJu = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void Em(String str) {
        if (this.eQM != null && this.eQM.getAdapter() != null && this.eQM.getAdapter().getCount() != 0 && this.fJz && this.fJO != null) {
            this.fJO.setText(str);
        }
    }

    private void g(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fJJ);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fJU != null) {
                        NewPagerSlidingTabBaseStrip.this.fJU.q(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.eQM.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.fJT = true;
                        NewPagerSlidingTabBaseStrip.this.eQM.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fJq != null && this.fJq.length == 4) {
            view.setPadding(this.fJq[0], this.fJq[1], this.fJq[2], this.fJq[3]);
        }
        this.eQL.addView(view, i, this.eQQ ? this.eQI : this.eQH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eQN != 0) {
            int left = this.eQL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fJD;
            }
            if (left != this.eQZ) {
                this.eQZ = left;
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
        if (!isInEditMode() && this.eQN != 0) {
            View childAt = this.eQL.getChildAt(this.mCurrentTabIndex);
            if (this.fJI && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fJF;
                right = childAt.getRight() - this.fJF;
            }
            if (this.fJt > 0.0f && this.mCurrentTabIndex != this.fJu && this.fJu <= this.eQN - 1 && this.fJu >= 0) {
                View childAt2 = this.eQL.getChildAt(this.fJu);
                if (this.fJI && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fJF;
                    right2 = childAt2.getRight() - this.fJF;
                }
                left = e(left, left2, this.fJt);
                right = f(right, right2, this.fJt);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fJE, right + getPaddingLeft(), height - this.fJE);
            } else {
                this.GD.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fJE, right + getPaddingLeft(), height - this.fJE);
            }
            canvas.drawRoundRect(this.GD, this.fJH, this.fJH, this.eQP);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fJG + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fJG + f2) - ((this.fJG * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fJG + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fJG) + ((this.fJG * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fJB = R.color.CAM_X0105;
            this.fJC = R.color.CAM_X0107;
        } else {
            this.fJB = R.color.CAM_X0101;
            this.fJC = R.color.CAM_X0101;
        }
        this.eQR = ap.getColor(this.fJB);
        this.eQS = ap.getColor(this.fJC);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.eQR = ap.getColor(this.fJB);
            this.eQS = ap.getColor(this.fJC);
            this.eQP.setColor(ap.getColor(this.fJA));
            this.fJw.setColor(ap.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float ap(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fJN - 1.0f) / (0.1f - 1.0f))) + this.fJN;
        }
        return (((this.fJN - this.fJM) / 0.1f) * f) + this.fJM;
    }

    private float aq(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fJN) / (0.1f - 0.9f)));
        }
        return (((this.fJN - this.fJM) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fJN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float aq;
        float f = this.fJt;
        float f2 = this.fJu < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eQN) {
            View childAt = this.eQL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eRa);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        aq = ap(f2);
                    } else {
                        aq = i == this.fJu ? aq(f2) : 1.0f;
                    }
                    textView.setScaleX(aq);
                    textView.setScaleY(aq);
                    if (f2 >= 0.5f) {
                        if (i == this.fJu) {
                            textView.setTextColor(this.eQR);
                        } else {
                            textView.setTextColor(this.eQS);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eQR);
                    } else {
                        textView.setTextColor(this.eQS);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fJu) {
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
            if (NewPagerSlidingTabBaseStrip.this.eQL.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.fJT) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fJv) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fJu = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fJv) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fJu = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fJu = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fJv = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fJu = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fJt = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eQL.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.eQK != null) {
                    NewPagerSlidingTabBaseStrip.this.eQK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eQL.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.eQM.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fJt = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.fJT = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fJv = NewPagerSlidingTabBaseStrip.this.eQM.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fJv;
                    NewPagerSlidingTabBaseStrip.this.fJu = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.eQK != null) {
                    NewPagerSlidingTabBaseStrip.this.eQK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.eQK != null) {
                NewPagerSlidingTabBaseStrip.this.eQK.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.fJT) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fJt * NewPagerSlidingTabBaseStrip.this.eQL.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fJv = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fJu = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.eQL.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.eQL.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.eQL.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZV;
        this.fJu = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZV = this.mCurrentTabIndex;
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
            /* renamed from: td */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZV;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZV = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZV);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fJy = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fJB = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.fJC = i;
    }

    public void setIndicatorRadius(int i) {
        this.fJH = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fJU = aVar;
    }

    /* loaded from: classes20.dex */
    public class TabTextView extends TextView {
        boolean fJW;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fJW = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fJW = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fJW) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fJS) - NewPagerSlidingTabBaseStrip.this.fJQ;
                int i = NewPagerSlidingTabBaseStrip.this.fJR;
                NewPagerSlidingTabBaseStrip.this.fJx.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fJQ, i + NewPagerSlidingTabBaseStrip.this.fJQ);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fJx, NewPagerSlidingTabBaseStrip.this.fJw);
            }
        }
    }
}
