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
/* loaded from: classes4.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private float cXO;
    private int cXP;
    private int cXQ;
    private Paint cXR;
    private RectF cXS;
    private boolean cXT;
    private int cXU;
    private int cXV;
    private int cXW;
    private int cXX;
    private int cXY;
    private int cXZ;
    private int cYa;
    private int cYb;
    private float cYc;
    private float cYd;
    private int cYe;
    private int cYf;
    private int cYg;
    private boolean cYh;
    public ViewPager.OnPageChangeListener cnA;
    private LinearLayout cnB;
    private ViewPager cnC;
    private int cnD;
    private Paint cnF;
    private boolean cnG;
    private int cnH;
    private int cnI;
    private int cnT;
    private int cnU;
    private LinearLayout.LayoutParams cnx;
    private LinearLayout.LayoutParams cny;
    private int cpF;
    private int dividerPadding;
    private final b ghB;
    private a ghC;
    private boolean isLoading;
    private RectF iu;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes4.dex */
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
        this.ghB = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cXO = 0.0f;
        this.cXP = 0;
        this.cXQ = 0;
        this.cnG = false;
        this.cnH = am.getColor(R.color.cp_cont_b);
        this.cnI = am.getColor(R.color.cp_cont_j);
        this.cXV = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.cpF = 1;
        this.cXZ = 17;
        this.cYa = 17;
        this.cnT = 0;
        this.cnU = R.drawable.pager_sliding_view;
        this.cYh = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.cnB = new LinearLayout(getContext());
        this.cnB.setOrientation(0);
        this.cnB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.cnB);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cXV = (int) TypedValue.applyDimension(1, this.cXV, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.cpF = (int) TypedValue.applyDimension(1, this.cpF, displayMetrics);
        this.cXZ = i;
        this.cYa = i2;
        this.cYb = l.getDimens(getContext(), R.dimen.tbds74);
        this.cYc = (this.cYa * 1.0f) / this.cXZ;
        this.cYd = (this.cYb * 1.0f) / this.cXZ;
        this.mIndicatorHeight = i3;
        this.cnG = z;
        this.cnF = new Paint();
        this.cnF.setAntiAlias(true);
        this.cnF.setStyle(Paint.Style.FILL);
        this.cnF.setColor(am.getColor(R.color.cp_other_e));
        this.cXR = new Paint();
        this.cXR.setAntiAlias(true);
        this.cXR.setStyle(Paint.Style.FILL);
        this.cXR.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.cXR.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.cXS = new RectF();
        this.cYe = l.getDimens(getContext(), R.dimen.tbds20);
        this.cYf = l.getDimens(getContext(), R.dimen.tbds28);
        this.cYg = l.getDimens(getContext(), R.dimen.tbds22);
        this.cnx = new LinearLayout.LayoutParams(-2, -1);
        this.cny = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.cXX = l.getDimens(getContext(), R.dimen.tbds22);
        this.cXW = l.getDimens(getContext(), R.dimen.tbds20);
        this.cXY = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cXT = z;
        invalidate();
    }

    public boolean btJ() {
        return this.cXT;
    }

    public void setTabItemClicked(boolean z) {
        this.cYh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cnC = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ghB);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cnA = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.cnC != null && this.cnC.getAdapter() != null && this.cnC.getAdapter().getCount() != 0) {
            this.cnB.removeAllViews();
            this.cnD = this.cnC.getAdapter().getCount();
            for (int i = 0; i < this.cnD; i++) {
                G(i, this.cnC.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.cnC.getCurrentItem();
                    PagerSlidingTabStrip.this.cXP = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void G(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.cXZ);
        textView.setSingleLine();
        f(i, textView);
    }

    private void f(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.ghC != null) {
                        PagerSlidingTabStrip.this.ghC.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.cnC.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).O("obj_locate", i + 1).bS("obj_type", "1"));
                    PagerSlidingTabStrip.this.cYh = true;
                    if (PagerSlidingTabStrip.this.cnC.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.cnC.getAdapter()).sS(i);
                    }
                    PagerSlidingTabStrip.this.cnC.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.cnB.addView(view, i, this.cnG ? this.cny : this.cnx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.cnD != 0) {
            int left = this.cnB.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cXV;
            }
            if (left != this.cnT) {
                this.cnT = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.cnD != 0) {
            View childAt = this.cnB.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cXX;
            float right2 = childAt.getRight() - this.cXX;
            if (this.cXO > 0.0f && this.mCurrentTabIndex != this.cXP && this.cXP <= this.cnD - 1 && this.cXP >= 0) {
                View childAt2 = this.cnB.getChildAt(this.cXP);
                left = b(left, childAt2.getLeft() + this.cXX, this.cXO);
                right2 = c(right2, childAt2.getRight() - this.cXX, this.cXO);
            }
            int height = getHeight();
            if (this.iu == null) {
                this.iu = new RectF(left, (height - this.mIndicatorHeight) - this.cXW, right2, height - this.cXW);
            } else {
                this.iu.set(left, (height - this.mIndicatorHeight) - this.cXW, right2, height - this.cXW);
            }
            canvas.drawRoundRect(this.iu, 16.0f, 16.0f, this.cnF);
            if (this.cXT) {
                View childAt3 = this.cnB.getChildAt(this.cXU);
                this.cXS.set((childAt3.getRight() - this.cYg) - this.cYe, childAt3.getTop() + this.cYf, right + this.cYe, top + this.cYe);
                canvas.drawOval(this.cXS, this.cXR);
            }
        }
    }

    private float b(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cXY + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cXY + f2) - ((this.cXY * (f3 - 0.85f)) / 0.15f);
        } else {
            return f;
        }
    }

    private float c(float f, float f2, float f3) {
        if (f2 > f) {
            if (f3 <= 0.5d) {
                return f + (((f2 - f) * f3) / 0.5f);
            }
            return f2;
        } else if (f3 >= 0.5d) {
            return f;
        } else {
            if (f3 >= 0.15d) {
                return f - ((((f - this.cXY) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cXY) + ((this.cXY * (0.15f - f3)) / 0.15f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.cnH = am.getColor(R.color.cp_other_d);
            this.cnI = am.getColor(R.color.cp_cont_j);
            this.cnF.setColor(am.getColor(R.color.cp_other_e));
            this.cXR.setColor(am.getColor(R.color.cp_cont_h));
            this.cXR.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float af(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cYd - 1.0f) / (0.1f - 1.0f))) + this.cYd;
        }
        return (((this.cYd - this.cYc) / 0.1f) * f) + this.cYc;
    }

    private float ag(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cYd) / (0.1f - 0.9f)));
        }
        return (((this.cYd - this.cYc) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cYd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ag;
        float f = this.cXO;
        float f2 = this.cXP < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.cnD) {
            View childAt = this.cnB.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.cnU);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ag = af(f2);
                    } else {
                        ag = i == this.cXP ? ag(f2) : 1.0f;
                    }
                    textView.setScaleX(ag);
                    textView.setScaleY(ag);
                    if (ag <= 1.0f) {
                        textView.setTextColor(this.cnI);
                    } else {
                        textView.setTextColor(this.cnH);
                    }
                    if (ag <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes4.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.cnB.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cYh) {
                    if (i == PagerSlidingTabStrip.this.cXQ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cXP = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.cXQ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cXP = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.cXP = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.cXQ = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cXP = i;
                    }
                    PagerSlidingTabStrip.this.cXO = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cnB.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.cnA != null) {
                    PagerSlidingTabStrip.this.cnA.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.cnB.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.cnC.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.cXO = 0.0f;
                    PagerSlidingTabStrip.this.cYh = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.cXQ = PagerSlidingTabStrip.this.cnC.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.cXQ;
                    PagerSlidingTabStrip.this.cXP = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.cnA != null) {
                    PagerSlidingTabStrip.this.cnA.onPageScrollStateChanged(i);
                }
                HomePageStatic.gdA = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.cnA != null) {
                PagerSlidingTabStrip.this.cnA.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cYh) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cXO * PagerSlidingTabStrip.this.cnB.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.cXQ = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.cXP = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.BQ;
        this.cXP = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.BQ = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: P */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: sU */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int BQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.BQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.BQ);
        }
    }

    public View sT(int i) {
        return this.cnB.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.cXU = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ghC = aVar;
    }
}
