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
    private float cWX;
    private int cWY;
    private int cWZ;
    private Paint cXa;
    private RectF cXb;
    private boolean cXc;
    private int cXd;
    private int cXe;
    private int cXf;
    private int cXg;
    private int cXh;
    private int cXi;
    private int cXj;
    private int cXk;
    private float cXl;
    private float cXm;
    private int cXn;
    private int cXo;
    private int cXp;
    private boolean cXq;
    private LinearLayout.LayoutParams cmF;
    private LinearLayout.LayoutParams cmG;
    public ViewPager.OnPageChangeListener cmI;
    private LinearLayout cmJ;
    private ViewPager cmK;
    private int cmL;
    private Paint cmN;
    private boolean cmO;
    private int cmP;
    private int cmQ;
    private int cnb;
    private int cnc;
    private int coN;
    private int dividerPadding;
    private final b ggK;
    private a ggL;
    private RectF hQ;
    private boolean isLoading;
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
        this.ggK = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cWX = 0.0f;
        this.cWY = 0;
        this.cWZ = 0;
        this.cmO = false;
        this.cmP = am.getColor(R.color.cp_cont_b);
        this.cmQ = am.getColor(R.color.cp_cont_j);
        this.cXe = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.coN = 1;
        this.cXi = 17;
        this.cXj = 17;
        this.cnb = 0;
        this.cnc = R.drawable.pager_sliding_view;
        this.cXq = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.cmJ = new LinearLayout(getContext());
        this.cmJ.setOrientation(0);
        this.cmJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.cmJ);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cXe = (int) TypedValue.applyDimension(1, this.cXe, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.coN = (int) TypedValue.applyDimension(1, this.coN, displayMetrics);
        this.cXi = i;
        this.cXj = i2;
        this.cXk = l.getDimens(getContext(), R.dimen.tbds74);
        this.cXl = (this.cXj * 1.0f) / this.cXi;
        this.cXm = (this.cXk * 1.0f) / this.cXi;
        this.mIndicatorHeight = i3;
        this.cmO = z;
        this.cmN = new Paint();
        this.cmN.setAntiAlias(true);
        this.cmN.setStyle(Paint.Style.FILL);
        this.cmN.setColor(am.getColor(R.color.cp_other_e));
        this.cXa = new Paint();
        this.cXa.setAntiAlias(true);
        this.cXa.setStyle(Paint.Style.FILL);
        this.cXa.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.cXa.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.cXb = new RectF();
        this.cXn = l.getDimens(getContext(), R.dimen.tbds20);
        this.cXo = l.getDimens(getContext(), R.dimen.tbds28);
        this.cXp = l.getDimens(getContext(), R.dimen.tbds22);
        this.cmF = new LinearLayout.LayoutParams(-2, -1);
        this.cmG = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.cXg = l.getDimens(getContext(), R.dimen.tbds22);
        this.cXf = l.getDimens(getContext(), R.dimen.tbds20);
        this.cXh = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cXc = z;
        invalidate();
    }

    public boolean btH() {
        return this.cXc;
    }

    public void setTabItemClicked(boolean z) {
        this.cXq = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cmK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ggK);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cmI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.cmK != null && this.cmK.getAdapter() != null && this.cmK.getAdapter().getCount() != 0) {
            this.cmJ.removeAllViews();
            this.cmL = this.cmK.getAdapter().getCount();
            for (int i = 0; i < this.cmL; i++) {
                F(i, this.cmK.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.cmK.getCurrentItem();
                    PagerSlidingTabStrip.this.cWY = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void F(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.cXi);
        textView.setSingleLine();
        f(i, textView);
    }

    private void f(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.ggL != null) {
                        PagerSlidingTabStrip.this.ggL.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.cmK.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).O("obj_locate", i + 1).bS("obj_type", "1"));
                    PagerSlidingTabStrip.this.cXq = true;
                    if (PagerSlidingTabStrip.this.cmK.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.cmK.getAdapter()).sR(i);
                    }
                    PagerSlidingTabStrip.this.cmK.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.cmJ.addView(view, i, this.cmO ? this.cmG : this.cmF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.cmL != 0) {
            int left = this.cmJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cXe;
            }
            if (left != this.cnb) {
                this.cnb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.cmL != 0) {
            View childAt = this.cmJ.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cXg;
            float right2 = childAt.getRight() - this.cXg;
            if (this.cWX > 0.0f && this.mCurrentTabIndex != this.cWY && this.cWY <= this.cmL - 1 && this.cWY >= 0) {
                View childAt2 = this.cmJ.getChildAt(this.cWY);
                left = b(left, childAt2.getLeft() + this.cXg, this.cWX);
                right2 = c(right2, childAt2.getRight() - this.cXg, this.cWX);
            }
            int height = getHeight();
            if (this.hQ == null) {
                this.hQ = new RectF(left, (height - this.mIndicatorHeight) - this.cXf, right2, height - this.cXf);
            } else {
                this.hQ.set(left, (height - this.mIndicatorHeight) - this.cXf, right2, height - this.cXf);
            }
            canvas.drawRoundRect(this.hQ, 16.0f, 16.0f, this.cmN);
            if (this.cXc) {
                View childAt3 = this.cmJ.getChildAt(this.cXd);
                this.cXb.set((childAt3.getRight() - this.cXp) - this.cXn, childAt3.getTop() + this.cXo, right + this.cXn, top + this.cXn);
                canvas.drawOval(this.cXb, this.cXa);
            }
        }
    }

    private float b(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cXh + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cXh + f2) - ((this.cXh * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.cXh) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cXh) + ((this.cXh * (0.15f - f3)) / 0.15f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.cmP = am.getColor(R.color.cp_other_d);
            this.cmQ = am.getColor(R.color.cp_cont_j);
            this.cmN.setColor(am.getColor(R.color.cp_other_e));
            this.cXa.setColor(am.getColor(R.color.cp_cont_h));
            this.cXa.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float af(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cXm - 1.0f) / (0.1f - 1.0f))) + this.cXm;
        }
        return (((this.cXm - this.cXl) / 0.1f) * f) + this.cXl;
    }

    private float ag(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cXm) / (0.1f - 0.9f)));
        }
        return (((this.cXm - this.cXl) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cXm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ag;
        float f = this.cWX;
        float f2 = this.cWY < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.cmL) {
            View childAt = this.cmJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.cnc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ag = af(f2);
                    } else {
                        ag = i == this.cWY ? ag(f2) : 1.0f;
                    }
                    textView.setScaleX(ag);
                    textView.setScaleY(ag);
                    if (ag <= 1.0f) {
                        textView.setTextColor(this.cmQ);
                    } else {
                        textView.setTextColor(this.cmP);
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
            if (PagerSlidingTabStrip.this.cmJ.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cXq) {
                    if (i == PagerSlidingTabStrip.this.cWZ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cWY = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.cWZ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cWY = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.cWY = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.cWZ = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.cWY = i;
                    }
                    PagerSlidingTabStrip.this.cWX = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cmJ.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.cmI != null) {
                    PagerSlidingTabStrip.this.cmI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.cmJ.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.cmK.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.cWX = 0.0f;
                    PagerSlidingTabStrip.this.cXq = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.cWZ = PagerSlidingTabStrip.this.cmK.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.cWZ;
                    PagerSlidingTabStrip.this.cWY = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.cmI != null) {
                    PagerSlidingTabStrip.this.cmI.onPageScrollStateChanged(i);
                }
                HomePageStatic.gcJ = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.cmI != null) {
                PagerSlidingTabStrip.this.cmI.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cXq) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cWX * PagerSlidingTabStrip.this.cmJ.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.cWZ = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.cWY = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Bq;
        this.cWY = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Bq = this.mCurrentTabIndex;
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
            /* renamed from: sT */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Bq;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Bq = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Bq);
        }
    }

    public View sS(int i) {
        return this.cmJ.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.cXd = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ggL = aVar;
    }
}
