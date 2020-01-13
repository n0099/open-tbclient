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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes6.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private FrameLayout.LayoutParams dLE;
    private final b dLF;
    private boolean dLG;
    private float dLH;
    private int dLI;
    private int dLJ;
    private Paint dLK;
    private RectF dLL;
    private boolean dLM;
    private int dLN;
    private boolean dLO;
    private int dLP;
    private int dLQ;
    private int dLR;
    private int dLS;
    private int dLT;
    private int dLU;
    private int dLV;
    private int dLW;
    private int dLX;
    private int dLY;
    private int dLZ;
    private float dMa;
    private float dMb;
    private TextView dMc;
    private int dMd;
    private int dMe;
    private int dMf;
    private int dMg;
    private boolean dMh;
    private a dMi;
    private LinearLayout.LayoutParams daa;
    private LinearLayout.LayoutParams dab;
    public ViewPager.OnPageChangeListener dad;
    private LinearLayout dae;
    private ViewPager daf;
    private int dag;
    private Paint dai;
    private boolean daj;
    private int dak;
    private int dal;
    private int dau;
    private int dav;
    private int dcl;
    private int dividerPadding;
    private boolean isLoading;
    private RectF jD;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes6.dex */
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
        this.dLF = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dLH = 0.0f;
        this.dLI = 0;
        this.dLJ = 0;
        this.daj = false;
        this.dLO = false;
        this.dLP = R.color.cp_other_f;
        this.dLQ = R.color.cp_cont_b;
        this.dLR = R.color.cp_cont_j;
        this.dak = am.getColor(this.dLQ);
        this.dal = am.getColor(this.dLR);
        this.dLS = 52;
        this.mIndicatorHeight = 4;
        this.dLW = 16;
        this.dividerPadding = 12;
        this.dcl = 1;
        this.dLX = 17;
        this.dLY = 17;
        this.dau = 0;
        this.dav = R.drawable.pager_sliding_view;
        this.dMh = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.dLO) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.dLE == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.dLE);
            }
            addView(this.mContainer);
        }
        this.dae = new LinearLayout(getContext());
        this.dae.setOrientation(0);
        if (this.dLO) {
            this.dae.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.dae);
        } else {
            this.dae.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.dae);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dLS = (int) TypedValue.applyDimension(1, this.dLS, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dcl = (int) TypedValue.applyDimension(1, this.dcl, displayMetrics);
        this.dLX = i;
        this.dLY = i2;
        this.dLZ = l.getDimens(getContext(), R.dimen.tbds74);
        this.dMa = (this.dLY * 1.0f) / this.dLX;
        this.dMb = (this.dLZ * 1.0f) / this.dLX;
        this.mIndicatorHeight = i3;
        this.daj = z;
        this.dai = new Paint();
        this.dai.setAntiAlias(true);
        this.dai.setStyle(Paint.Style.FILL);
        this.dai.setColor(am.getColor(this.dLP));
        this.dLK = new Paint();
        this.dLK.setAntiAlias(true);
        this.dLK.setStyle(Paint.Style.FILL);
        this.dLK.setColor(am.getColor(R.color.cp_cont_h));
        this.dLL = new RectF();
        this.dMe = l.getDimens(getContext(), R.dimen.tbds20);
        this.dMf = l.getDimens(getContext(), R.dimen.tbds28);
        this.dMg = l.getDimens(getContext(), R.dimen.tbds22);
        this.daa = new LinearLayout.LayoutParams(-2, -1);
        this.dab = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.dLU = l.getDimens(getContext(), R.dimen.tbds22);
        this.dLT = l.getDimens(getContext(), R.dimen.tbds20);
        this.dLV = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.dLO && this.mContainer != null) {
            this.dMd = l.getDimens(getContext(), R.dimen.tbds32);
            this.dMc = new TextView(getContext());
            this.dMc.setGravity(17);
            this.dMc.setTextSize(0, this.dMd);
            this.dMc.setSingleLine();
            this.dMc.setTextColor(this.dal);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.dMc, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.dLZ = i4;
        this.dMb = (this.dLZ * 1.0f) / this.dLX;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.dLO = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.dLU = i;
    }

    public void setRectPaintColor(int i) {
        this.dLP = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.dLT = i;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dab = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.dLE = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.dLV = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.daa = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dLM = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dMh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.daf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dLF);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dad = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.daf != null && this.daf.getAdapter() != null && this.daf.getAdapter().getCount() != 0) {
            this.dae.removeAllViews();
            this.dag = this.daf.getAdapter().getCount();
            for (int i = 0; i < this.dag; i++) {
                P(i, this.daf.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.daf.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.dLI = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void vO(String str) {
        if (this.daf != null && this.daf.getAdapter() != null && this.daf.getAdapter().getCount() != 0 && this.dLO && this.dMc != null) {
            this.dMc.setText(str);
        }
    }

    private void P(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dLX);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.dMi != null) {
                        NewPagerSlidingTabBaseStrip.this.dMi.k(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.daf.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.dMh = true;
                        NewPagerSlidingTabBaseStrip.this.daf.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dae.addView(view, i, this.daj ? this.dab : this.daa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dag != 0) {
            int left = this.dae.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dLS;
            }
            if (left != this.dau) {
                this.dau = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dag != 0) {
            View childAt = this.dae.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dLU;
            float right2 = childAt.getRight() - this.dLU;
            if (this.dLH > 0.0f && this.mCurrentTabIndex != this.dLI && this.dLI <= this.dag - 1 && this.dLI >= 0) {
                View childAt2 = this.dae.getChildAt(this.dLI);
                left = d(left, childAt2.getLeft() + this.dLU, this.dLH);
                right2 = e(right2, childAt2.getRight() - this.dLU, this.dLH);
            }
            int height = getHeight();
            if (this.jD == null) {
                this.jD = new RectF(left, (height - this.mIndicatorHeight) - this.dLT, right2, height - this.dLT);
            } else {
                this.jD.set(left, (height - this.mIndicatorHeight) - this.dLT, right2, height - this.dLT);
            }
            canvas.drawRoundRect(this.jD, this.dLW, this.dLW, this.dai);
            if (this.dLM) {
                View childAt3 = this.dae.getChildAt(this.dLN);
                this.dLL.set((childAt3.getRight() - this.dMg) - this.dMe, childAt3.getTop() + this.dMf, right + this.dMe, top + this.dMe);
                canvas.drawOval(this.dLL, this.dLK);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dLV + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dLV + f2) - ((this.dLV * (f3 - 0.8f)) / 0.2f);
        } else {
            return f;
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 > f) {
            if (f3 <= 0.5d) {
                return f + (((f2 - f) * f3) / 0.5f);
            }
            return f2;
        } else if (f3 >= 0.5d) {
            return f;
        } else {
            if (f3 >= 0.2d) {
                return f - ((((this.dLV + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dLV) + ((this.dLV * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.dLG = z;
        if (!z) {
            this.dLQ = R.color.cp_cont_b;
            this.dLR = R.color.cp_cont_j;
        } else {
            this.dLQ = R.color.cp_cont_a;
            this.dLR = R.color.cp_cont_a;
        }
        this.dak = am.getColor(this.dLQ);
        this.dal = am.getColor(this.dLR);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dak = am.getColor(this.dLQ);
            this.dal = am.getColor(this.dLR);
            this.dai.setColor(am.getColor(this.dLP));
            this.dLK.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dMb - 1.0f) / (0.1f - 1.0f))) + this.dMb;
        }
        return (((this.dMb - this.dMa) / 0.1f) * f) + this.dMa;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dMb) / (0.1f - 0.9f)));
        }
        return (((this.dMb - this.dMa) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dMb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.dLH;
        float f2 = this.dLI < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dag) {
            View childAt = this.dae.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dav);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.dLI ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (f2 >= 0.5f) {
                        if (i == this.dLI) {
                            textView.setTextColor(this.dak);
                        } else {
                            textView.setTextColor(this.dal);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dak);
                    } else {
                        textView.setTextColor(this.dal);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dLI) {
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

    /* loaded from: classes6.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (NewPagerSlidingTabBaseStrip.this.dae.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.dMh) {
                    if (i == NewPagerSlidingTabBaseStrip.this.dLJ) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dLI = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.dLJ) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dLI = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.dLI = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.dLJ = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dLI = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.dLH = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dae.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.dad != null) {
                    NewPagerSlidingTabBaseStrip.this.dad.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dae.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.daf.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.dLH = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.dMh = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.dLJ = NewPagerSlidingTabBaseStrip.this.daf.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dLJ;
                    NewPagerSlidingTabBaseStrip.this.dLI = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.dad != null) {
                    NewPagerSlidingTabBaseStrip.this.dad.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dad != null) {
                NewPagerSlidingTabBaseStrip.this.dad.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.dMh) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dLH * NewPagerSlidingTabBaseStrip.this.dae.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.dLJ = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.dLI = i;
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ec;
        this.dLI = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ec = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: X */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: nh */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ec;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ec = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ec);
        }
    }

    public void setConcernTabIndex(int i) {
        this.dLN = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dLQ = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.dLR = i;
    }

    public void setIndicatorRadius(int i) {
        this.dLW = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dMi = aVar;
    }
}
