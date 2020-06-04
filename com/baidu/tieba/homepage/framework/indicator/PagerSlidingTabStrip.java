package com.baidu.tieba.homepage.framework.indicator;

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
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes9.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private RectF Fg;
    private int dQl;
    private ViewPager dSA;
    private int dSB;
    private Paint dSD;
    private boolean dSE;
    private int dSF;
    private int dSO;
    private int dSP;
    private LinearLayout.LayoutParams dSv;
    private LinearLayout.LayoutParams dSw;
    public ViewPager.OnPageChangeListener dSy;
    private LinearLayout dSz;
    private int dUE;
    private int dividerPadding;
    private int eFB;
    private int eFC;
    private int eFD;
    private boolean eFE;
    private boolean eFK;
    private float eFe;
    private int eFf;
    private int eFg;
    private Paint eFh;
    private RectF eFi;
    private int eFj;
    private int eFo;
    private int eFp;
    private int eFq;
    private int eFr;
    private int eFu;
    private int eFv;
    private int eFw;
    private float eFx;
    private float eFy;
    private final b iai;
    private int iaj;
    private int iak;
    private int ial;
    private a iam;
    private boolean isLoading;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void k(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iai = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eFe = 0.0f;
        this.eFf = 0;
        this.eFg = 0;
        this.dSE = false;
        this.iaj = R.color.cp_cont_b;
        this.iak = R.color.cp_cont_j;
        this.ial = R.color.cp_link_tip_a;
        this.dSF = am.getColor(this.iaj);
        this.dQl = am.getColor(this.iak);
        this.eFo = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dUE = 1;
        this.eFu = 17;
        this.eFv = 17;
        this.dSO = 0;
        this.dSP = R.drawable.pager_sliding_view;
        this.eFE = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dSz = new LinearLayout(getContext());
        this.dSz.setOrientation(0);
        this.dSz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dSz);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eFo = (int) TypedValue.applyDimension(1, this.eFo, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dUE = (int) TypedValue.applyDimension(1, this.dUE, displayMetrics);
        this.eFu = i;
        this.eFv = i2;
        this.eFw = l.getDimens(getContext(), R.dimen.tbds46);
        this.eFx = (this.eFv * 1.0f) / this.eFu;
        this.eFy = (this.eFw * 1.0f) / this.eFu;
        this.mIndicatorHeight = i3;
        this.dSE = z;
        this.dSD = new Paint();
        this.dSD.setAntiAlias(true);
        this.dSD.setStyle(Paint.Style.FILL);
        this.dSD.setColor(am.getColor(R.color.cp_link_tip_a));
        this.eFh = new Paint();
        this.eFh.setAntiAlias(true);
        this.eFh.setStyle(Paint.Style.FILL);
        this.eFh.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.eFh.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.eFi = new RectF();
        this.eFB = l.getDimens(getContext(), R.dimen.tbds20);
        this.eFC = l.getDimens(getContext(), R.dimen.tbds28);
        this.eFD = l.getDimens(getContext(), R.dimen.tbds22);
        this.dSv = new LinearLayout.LayoutParams(-2, -1);
        this.dSw = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.eFq = l.getDimens(getContext(), R.dimen.tbds62);
        this.eFp = l.getDimens(getContext(), R.dimen.tbds0);
        this.eFr = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dSw = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.eFK = z;
        invalidate();
    }

    public boolean ceX() {
        return this.eFK;
    }

    public void setTabItemClicked(boolean z) {
        this.eFE = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dSA = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.iai);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dSy = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dSA != null && this.dSA.getAdapter() != null && this.dSA.getAdapter().getCount() != 0) {
            this.dSz.removeAllViews();
            this.dSB = this.dSA.getAdapter().getCount();
            for (int i = 0; i < this.dSB; i++) {
                an(i, this.dSA.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dSA.getCurrentItem();
                    PagerSlidingTabStrip.this.eFf = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void an(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.eFu);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.iam != null) {
                        PagerSlidingTabStrip.this.iam.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.dSA.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).ag("obj_locate", i + 1).dh("obj_type", "1"));
                    PagerSlidingTabStrip.this.eFE = true;
                    if (PagerSlidingTabStrip.this.dSA.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.dSA.getAdapter()).wt(i);
                    }
                    PagerSlidingTabStrip.this.dSA.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.dSz.addView(view, i, this.dSE ? this.dSw : this.dSv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dSB != 0) {
            int left = this.dSz.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eFo;
            }
            if (left != this.dSO) {
                this.dSO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dSB != 0) {
            View childAt = this.dSz.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.eFq;
            float right2 = childAt.getRight() - this.eFq;
            if (this.eFe > 0.0f && this.mCurrentTabIndex != this.eFf && this.eFf <= this.dSB - 1 && this.eFf >= 0) {
                View childAt2 = this.dSz.getChildAt(this.eFf);
                left = e(left, childAt2.getLeft() + this.eFq, this.eFe);
                right2 = f(right2, childAt2.getRight() - this.eFq, this.eFe);
            }
            int height = getHeight();
            if (this.Fg == null) {
                this.Fg = new RectF(left, (height - this.mIndicatorHeight) - this.eFp, right2, height - this.eFp);
            } else {
                this.Fg.set(left, (height - this.mIndicatorHeight) - this.eFp, right2, height - this.eFp);
            }
            canvas.drawRoundRect(this.Fg, 16.0f, 16.0f, this.dSD);
            if (this.eFK) {
                View childAt3 = this.dSz.getChildAt(this.eFj);
                this.eFi.set((childAt3.getRight() - this.eFD) - this.eFB, childAt3.getTop() + this.eFC, right + this.eFB, top2 + this.eFB);
                canvas.drawOval(this.eFi, this.eFh);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.eFr + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.eFr + f2) - ((this.eFr * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.eFr + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.eFr) + ((this.eFr * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dSF = am.getColor(this.iaj);
            this.dQl = am.getColor(this.iak);
            this.dSD.setColor(am.getColor(this.ial));
            this.eFh.setColor(am.getColor(R.color.cp_cont_h));
            this.eFh.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float aa(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eFy - 1.0f) / (0.1f - 1.0f))) + this.eFy;
        }
        return (((this.eFy - this.eFx) / 0.1f) * f) + this.eFx;
    }

    private float ab(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eFy) / (0.1f - 0.9f)));
        }
        return (((this.eFy - this.eFx) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eFy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ab;
        float f = this.eFe;
        float f2 = this.eFf < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dSB) {
            View childAt = this.dSz.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dSP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ab = aa(f2);
                    } else {
                        ab = i == this.eFf ? ab(f2) : 1.0f;
                    }
                    textView.setScaleX(ab);
                    textView.setScaleY(ab);
                    if (f2 >= 0.5f) {
                        if (i == this.eFf) {
                            textView.setTextColor(this.dSF);
                        } else {
                            textView.setTextColor(this.dQl);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dSF);
                    } else {
                        textView.setTextColor(this.dQl);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.eFf) {
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

    /* loaded from: classes9.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dSz.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.eFE) {
                    if (i == PagerSlidingTabStrip.this.eFg) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eFf = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.eFg) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eFf = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.eFf = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.eFg = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eFf = i;
                    }
                    PagerSlidingTabStrip.this.eFe = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dSz.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dSy != null) {
                    PagerSlidingTabStrip.this.dSy.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dSz.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dSA.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.eFe = 0.0f;
                    PagerSlidingTabStrip.this.eFE = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.eFg = PagerSlidingTabStrip.this.dSA.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.eFg;
                    PagerSlidingTabStrip.this.eFf = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.dSy != null) {
                    PagerSlidingTabStrip.this.dSy.onPageScrollStateChanged(i);
                }
                HomePageStatic.hXa = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dSy != null) {
                PagerSlidingTabStrip.this.dSy.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.eFE) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eFe * PagerSlidingTabStrip.this.dSz.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.eFg = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.eFf = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Yf;
        this.eFf = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yf = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: T */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: wv */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yf);
        }
    }

    public View wu(int i) {
        return this.dSz.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.eFj = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.iam = aVar;
    }
}
