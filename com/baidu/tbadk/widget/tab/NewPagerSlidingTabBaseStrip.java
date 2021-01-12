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
    private boolean bnv;
    private int dividerPadding;
    private int dividerWidth;
    private int[] fVY;
    private FrameLayout.LayoutParams fVZ;
    private int fWA;
    private a fWB;
    private final b fWa;
    private float fWb;
    private int fWc;
    private int fWd;
    private Paint fWe;
    private RectF fWf;
    private int fWg;
    private boolean fWh;
    private int fWi;
    private int fWj;
    private int fWk;
    private int fWl;
    private int fWm;
    private int fWn;
    private int fWo;
    private int fWp;
    private boolean fWq;
    private int fWr;
    private int fWs;
    private int fWt;
    private float fWu;
    private float fWv;
    private TextView fWw;
    private int fWx;
    private int fWy;
    private int fWz;
    private LinearLayout.LayoutParams fcQ;
    private LinearLayout.LayoutParams fcR;
    public ViewPager.OnPageChangeListener fcT;
    private LinearLayout fcU;
    private ViewPager fcV;
    private int fcW;
    private Paint fcY;
    private boolean fcZ;
    private int fda;
    private int fdb;
    private int fdm;
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
        this.fWa = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fWb = 0.0f;
        this.fWc = 0;
        this.fWd = 0;
        this.fcZ = false;
        this.fWh = false;
        this.fWi = R.color.CAM_X0312;
        this.fWj = R.color.CAM_X0105;
        this.fWk = R.color.CAM_X0107;
        this.fda = ao.getColor(this.fWj);
        this.fdb = ao.getColor(this.fWk);
        this.fWl = 52;
        this.mIndicatorHeight = 4;
        this.fWp = 16;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fWq = false;
        this.fWr = 17;
        this.fWs = 17;
        this.fdm = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bnv = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.fWh) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.fVZ == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.fVZ);
            }
            addView(this.mContainer);
        }
        this.fcU = new LinearLayout(getContext());
        this.fcU.setOrientation(0);
        if (this.fWh) {
            this.fcU.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.fcU);
        } else {
            this.fcU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.fcU);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fWl = (int) TypedValue.applyDimension(1, this.fWl, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fWr = i;
        this.fWs = i2;
        this.fWt = l.getDimens(getContext(), R.dimen.tbds74);
        this.fWu = (this.fWs * 1.0f) / this.fWr;
        this.fWv = (this.fWt * 1.0f) / this.fWr;
        this.mIndicatorHeight = i3;
        this.fcZ = z;
        this.fcY = new Paint();
        this.fcY.setAntiAlias(true);
        this.fcY.setStyle(Paint.Style.FILL);
        this.fcY.setColor(ao.getColor(this.fWi));
        this.fWe = new Paint();
        this.fWe.setAntiAlias(true);
        this.fWe.setStyle(Paint.Style.FILL);
        this.fWe.setColor(ao.getColor(R.color.CAM_X0301));
        this.fWf = new RectF();
        this.fWy = l.getDimens(getContext(), R.dimen.tbds20);
        this.fWz = l.getDimens(getContext(), R.dimen.tbds16);
        this.fWA = l.getDimens(getContext(), R.dimen.tbds25);
        this.fcQ = new LinearLayout.LayoutParams(-2, -1);
        this.fcR = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.fWn = l.getDimens(getContext(), R.dimen.tbds22);
        this.fWm = l.getDimens(getContext(), R.dimen.tbds20);
        this.fWo = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.fWh && this.mContainer != null) {
            this.fWx = l.getDimens(getContext(), R.dimen.tbds32);
            this.fWw = new TextView(getContext());
            this.fWw.setGravity(17);
            this.fWw.setTextSize(0, this.fWx);
            this.fWw.setSingleLine();
            this.fWw.setTextColor(this.fdb);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.fWw, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        c(i, i2, i3, z);
        this.fWt = i4;
        this.fWv = (this.fWt * 1.0f) / this.fWr;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.fWh = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.fWn = i;
        this.fWq = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.fWq = true;
    }

    public void setRectPaintColor(int i) {
        this.fWi = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.fWm = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.fVY = new int[4];
        this.fVY[0] = i;
        this.fVY[1] = i2;
        this.fVY[2] = i3;
        this.fVY[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fcR = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.fVZ = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.fWo = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fcQ = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.bnv = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fcV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fWa);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fcT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fcV != null && this.fcV.getAdapter() != null && this.fcV.getAdapter().getCount() != 0) {
            this.fcU.removeAllViews();
            this.fcW = this.fcV.getAdapter().getCount();
            boolean z = false;
            for (int i = 0; i < this.fcW; i++) {
                if (this.fcV.getAdapter() instanceof com.baidu.tbadk.widget.tab.a) {
                    z = ((com.baidu.tbadk.widget.tab.a) this.fcV.getAdapter()).sk(i);
                }
                g(i, this.fcV.getAdapter().getPageTitle(i).toString(), z);
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fcV.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.fWc = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void DL(String str) {
        if (this.fcV != null && this.fcV.getAdapter() != null && this.fcV.getAdapter().getCount() != 0 && this.fWh && this.fWw != null) {
            this.fWw.setText(str);
        }
    }

    private void g(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.fWr);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.fWB != null) {
                        NewPagerSlidingTabBaseStrip.this.fWB.t(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.fcV.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.bnv = true;
                        NewPagerSlidingTabBaseStrip.this.fcV.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.fVY != null && this.fVY.length == 4) {
            view.setPadding(this.fVY[0], this.fVY[1], this.fVY[2], this.fVY[3]);
        }
        this.fcU.addView(view, i, this.fcZ ? this.fcR : this.fcQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fcW != 0) {
            int left = this.fcU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fWl;
            }
            if (left != this.fdm) {
                this.fdm = left;
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
        if (!isInEditMode() && this.fcW != 0) {
            View childAt = this.fcU.getChildAt(this.mCurrentTabIndex);
            if (this.fWq && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.fWn;
                right = childAt.getRight() - this.fWn;
            }
            if (this.fWb > 0.0f && this.mCurrentTabIndex != this.fWc && this.fWc <= this.fcW - 1 && this.fWc >= 0) {
                View childAt2 = this.fcU.getChildAt(this.fWc);
                if (this.fWq && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.fWn;
                    right2 = childAt2.getRight() - this.fWn;
                }
                left = e(left, left2, this.fWb);
                right = f(right, right2, this.fWb);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fWm, right + getPaddingLeft(), height - this.fWm);
            } else {
                this.rectF.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.fWm, right + getPaddingLeft(), height - this.fWm);
            }
            canvas.drawRoundRect(this.rectF, this.fWp, this.fWp, this.fcY);
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fWo + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fWo + f2) - ((this.fWo * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fWo + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fWo) + ((this.fWo * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.fWj = R.color.CAM_X0105;
            this.fWk = R.color.CAM_X0107;
        } else {
            this.fWj = R.color.CAM_X0101;
            this.fWk = R.color.CAM_X0101;
        }
        this.fda = ao.getColor(this.fWj);
        this.fdb = ao.getColor(this.fWk);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.fda = ao.getColor(this.fWj);
            this.fdb = ao.getColor(this.fWk);
            this.fcY.setColor(ao.getColor(this.fWi));
            this.fWe.setColor(ao.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fWv - 1.0f) / (0.1f - 1.0f))) + this.fWv;
        }
        return (((this.fWv - this.fWu) / 0.1f) * f) + this.fWu;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fWv) / (0.1f - 0.9f)));
        }
        return (((this.fWv - this.fWu) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fWv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.fWb;
        float f2 = this.fWc < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.fcW) {
            View childAt = this.fcU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.fWc ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.fWc) {
                            textView.setTextColor(this.fda);
                        } else {
                            textView.setTextColor(this.fdb);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.fda);
                    } else {
                        textView.setTextColor(this.fdb);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fWc) {
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
            if (NewPagerSlidingTabBaseStrip.this.fcU.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.bnv) {
                    if (i == NewPagerSlidingTabBaseStrip.this.fWd) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fWc = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.fWd) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fWc = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.fWc = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.fWd = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.fWc = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.fWb = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fcU.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.fcT != null) {
                    NewPagerSlidingTabBaseStrip.this.fcT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.fcU.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.fcV.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.fWb = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.bnv = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.fWd = NewPagerSlidingTabBaseStrip.this.fcV.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.fWd;
                    NewPagerSlidingTabBaseStrip.this.fWc = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.fcT != null) {
                    NewPagerSlidingTabBaseStrip.this.fcT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.fcT != null) {
                NewPagerSlidingTabBaseStrip.this.fcT.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.bnv) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.fWb * NewPagerSlidingTabBaseStrip.this.fcU.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.fWd = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.fWc = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.fcU.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.fcU.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.fcU.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.abA;
        this.fWc = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abA = this.mCurrentTabIndex;
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
            /* renamed from: sl */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abA;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abA = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abA);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fWg = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fWj = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.fWk = i;
    }

    public void setIndicatorRadius(int i) {
        this.fWp = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fWB = aVar;
    }

    /* loaded from: classes.dex */
    public class TabTextView extends TextView {
        boolean fWD;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.fWD = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.fWD = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.fWD) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.fWA) - NewPagerSlidingTabBaseStrip.this.fWy;
                int i = NewPagerSlidingTabBaseStrip.this.fWz;
                NewPagerSlidingTabBaseStrip.this.fWf.set(width, i, width + NewPagerSlidingTabBaseStrip.this.fWy, i + NewPagerSlidingTabBaseStrip.this.fWy);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.fWf, NewPagerSlidingTabBaseStrip.this.fWe);
            }
        }
    }
}
