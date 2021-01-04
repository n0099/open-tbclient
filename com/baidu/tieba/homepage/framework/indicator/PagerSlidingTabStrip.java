package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private boolean bsh;
    private int dividerPadding;
    private int dividerWidth;
    public ViewPager.OnPageChangeListener fhB;
    private LinearLayout fhC;
    private ViewPager fhD;
    private int fhE;
    private Paint fhG;
    private boolean fhH;
    private int fhI;
    private int fhJ;
    private int fhU;
    private LinearLayout.LayoutParams fhy;
    private LinearLayout.LayoutParams fhz;
    private float gaJ;
    private int gaK;
    private int gaL;
    private Paint gaM;
    private RectF gaN;
    private int gaO;
    private int gaT;
    private int gaU;
    private int gaV;
    private int gaW;
    private int gaZ;
    private int gba;
    private int gbb;
    private float gbc;
    private float gbd;
    private int gbg;
    private int gbh;
    private int gbi;
    private boolean gbo;
    private boolean isLoading;
    private final b kaK;
    private boolean kaL;
    private int kaM;
    private int kaN;
    private int kaO;
    private int kaP;
    private int kaQ;
    private a kaR;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;
    private RectF rectF;
    private int tabBackgroundResId;

    /* loaded from: classes2.dex */
    public interface a {
        void t(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kaK = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.gaJ = 0.0f;
        this.gaK = 0;
        this.gaL = 0;
        this.fhH = false;
        this.kaN = R.color.CAM_X0105;
        this.kaO = R.color.CAM_X0105;
        this.kaP = R.color.CAM_X0302;
        this.fhI = ao.getColor(this.kaN);
        this.fhJ = ao.getColor(this.kaO);
        this.gaT = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.gaZ = 17;
        this.gba = 17;
        this.fhU = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bsh = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.fhC = new LinearLayout(getContext());
        this.fhC.setOrientation(0);
        this.fhC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.fhC);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.gaT = (int) TypedValue.applyDimension(1, this.gaT, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.gaZ = i;
        this.gba = i2;
        this.gbb = l.getDimens(getContext(), R.dimen.tbds46);
        this.gbc = (this.gba * 1.0f) / this.gaZ;
        this.gbd = (this.gbb * 1.0f) / this.gaZ;
        this.kaQ = -l.getDimens(getContext(), R.dimen.tbds11);
        this.mIndicatorHeight = i3;
        this.fhH = z;
        this.fhG = new Paint();
        this.fhG.setAntiAlias(true);
        this.fhG.setStyle(Paint.Style.FILL);
        this.fhG.setColor(ao.getColor(R.color.CAM_X0302));
        this.gaM = new Paint();
        this.gaM.setAntiAlias(true);
        this.gaM.setStyle(Paint.Style.FILL);
        this.gaM.setColor(ao.getColor(R.color.CAM_X0301));
        setLayerType(1, null);
        this.gaN = new RectF();
        this.gbg = l.getDimens(getContext(), R.dimen.tbds20);
        this.gbh = (int) (l.getDimens(getContext(), R.dimen.tbds28) * 0.5d);
        this.gbi = (int) (l.getDimens(getContext(), R.dimen.tbds22) * 0.4d);
        this.fhy = new LinearLayout.LayoutParams(-2, -1);
        this.fhz = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.gaV = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) + Math.round(i * 0.5f);
        this.gaU = l.getDimens(getContext(), R.dimen.tbds5);
        this.gaW = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fhz = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.gbo = z;
        invalidate();
    }

    public boolean cRA() {
        return this.gbo;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.kaL = z;
        invalidate();
    }

    public boolean cRB() {
        return this.kaL;
    }

    public void setTabItemClicked(boolean z) {
        this.bsh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fhD = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.kaK);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fhB = onPageChangeListener;
    }

    public void OH() {
        if (this.fhD != null && this.fhD.getAdapter() != null && this.fhD.getAdapter().getCount() != 0) {
            this.fhC.removeAllViews();
            this.fhE = this.fhD.getAdapter().getCount();
            for (int i = 0; i < this.fhE; i++) {
                aF(i, this.fhD.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fhD != null && this.fhD.getAdapter() != null && this.fhD.getAdapter().getCount() != 0) {
            this.fhC.removeAllViews();
            this.fhE = this.fhD.getAdapter().getCount();
            for (int i = 0; i < this.fhE; i++) {
                aF(i, this.fhD.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fhD.getCurrentItem();
                    PagerSlidingTabStrip.this.gaK = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aF(int i, String str) {
        String string;
        if (d.bmN() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.gaZ);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_unfold16, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.kaQ;
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        EMTextView eMTextView = new EMTextView(getContext());
        if (i == 0) {
            if (d.bmN() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        eMTextView.setTextSize(0, this.gaZ);
        eMTextView.setSingleLine();
        eMTextView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
        eMTextView.setGravity(17);
        eMTextView.setText(str);
        d(i, eMTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.kaR != null) {
                        PagerSlidingTabStrip.this.kaR.t(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.fhD.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.bmN()) {
                        if (PagerSlidingTabStrip.this.fhD.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).an("obj_locate", i + 1).dX("obj_type", "1"));
                        PagerSlidingTabStrip.this.bsh = true;
                        if (PagerSlidingTabStrip.this.fhD.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.fhD.getAdapter()).CZ(i);
                        }
                        PagerSlidingTabStrip.this.fhD.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.bmN()) {
            this.fhC.addView(view, i, this.fhy);
        } else {
            this.fhC.addView(view, i, this.fhH ? this.fhz : this.fhy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fhE != 0) {
            int left = this.fhC.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.gaT;
            }
            if (left != this.fhU) {
                this.fhU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        float f;
        float f2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.fhE != 0) {
            View childAt = this.fhC.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.gaV;
            float right2 = childAt.getRight() - this.gaV;
            if ((childAt instanceof LinearLayout) && (((LinearLayout) childAt).getChildAt(0) instanceof TextView)) {
                float left2 = (childAt.getLeft() + childAt.getRight()) / 2.0f;
                float b2 = b(left2, childAt);
                float c = c(left2, childAt);
                right2 = b2;
                left = c;
            }
            if (this.gaJ > 0.0f && this.mCurrentTabIndex != this.gaK && this.gaK <= this.fhE - 1 && this.gaK >= 0) {
                View childAt2 = this.fhC.getChildAt(this.gaK);
                float left3 = childAt2.getLeft() + this.gaV;
                float right3 = childAt2.getRight() - this.gaV;
                if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                    float left4 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                    f = b(left4, childAt2);
                    f2 = c(left4, childAt2);
                } else {
                    f = right3;
                    f2 = left3;
                }
                left = e(left, f2, this.gaJ);
                right2 = f(right2, f, this.gaJ);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left, (height - this.mIndicatorHeight) - this.gaU, right2, height - this.gaU);
            } else {
                this.rectF.set(left, (height - this.mIndicatorHeight) - this.gaU, right2, height - this.gaU);
            }
            canvas.drawRoundRect(this.rectF, this.mIndicatorHeight * 0.5f, this.mIndicatorHeight * 0.5f, this.fhG);
            if (this.kaL) {
                View childAt3 = this.fhC.getChildAt(this.kaM);
                this.gaN.set((childAt3.getRight() - this.gbi) - this.gbg, childAt3.getTop() + this.gbh, right + this.gbg, top + this.gbg);
                canvas.drawOval(this.gaN, this.gaM);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.gaW + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.gaW + f2) - ((this.gaW * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.gaW + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.gaW) + ((this.gaW * (0.2f - f3)) / 0.2f);
        }
    }

    private float b(float f, View view) {
        return (((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f) + f) - this.gaV;
    }

    private float c(float f, View view) {
        return (f - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f)) + this.gaV;
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.fhI = ao.getColor(this.kaN);
            this.fhJ = ao.getColor(this.kaO);
            this.fhG.setColor(ao.getColor(this.kaP));
            this.gaM.setColor(ao.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.gbd - 1.0f) / (0.1f - 1.0f))) + this.gbd;
        }
        return (((this.gbd - this.gbc) / 0.1f) * f) + this.gbc;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.gbd) / (0.1f - 0.9f)));
        }
        return (((this.gbd - this.gbc) / (0.9f - 1.0f)) * (f - 0.9f)) + this.gbd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.gaJ;
        float f2 = this.gaK < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.fhE) {
            View childAt = this.fhC.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                TextView textView = null;
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                } else if (childAt instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) childAt;
                    textView = (TextView) linearLayout.getChildAt(0);
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ((ImageView) linearLayout.getChildAt(1)).setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_unfold16, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
                    }
                }
                if (textView != null) {
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.gaK ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.gaK) {
                            textView.setTextColor(this.fhI);
                        } else {
                            textView.setTextColor(this.fhJ);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.fhI);
                    } else {
                        textView.setTextColor(this.fhJ);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.gaK) {
                            c.bv(textView).pE(R.string.F_X02);
                        } else {
                            c.bv(textView).pE(R.string.F_X01);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        c.bv(textView).pE(R.string.F_X02);
                    } else {
                        c.bv(textView).pE(R.string.F_X01);
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes2.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.fhC.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.bsh) {
                    if (i == PagerSlidingTabStrip.this.gaL) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.gaK = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.gaL) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.gaK = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.gaK = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.gaL = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.gaK = i;
                    }
                    PagerSlidingTabStrip.this.gaJ = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fhC.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.fhB != null) {
                    PagerSlidingTabStrip.this.fhB.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.fhC.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.fhD.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.gaJ = 0.0f;
                    PagerSlidingTabStrip.this.bsh = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.gaL = PagerSlidingTabStrip.this.fhD.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.gaL;
                    PagerSlidingTabStrip.this.gaK = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.fhB != null) {
                    PagerSlidingTabStrip.this.fhB.onPageScrollStateChanged(i);
                }
                HomePageStatic.jVT = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.fhB != null) {
                PagerSlidingTabStrip.this.fhB.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.bsh) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.gaJ * PagerSlidingTabStrip.this.fhC.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.gaL = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.gaK = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.abC;
        this.gaK = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abC = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Y */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Db */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abC;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abC = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abC);
        }
    }

    public View Da(int i) {
        return this.fhC.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.gaO = i;
    }

    public void setHotTopicIndex(int i) {
        this.kaM = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.kaR = aVar;
    }
}
