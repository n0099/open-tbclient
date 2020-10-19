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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes22.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private RectF GD;
    private int dividerPadding;
    private int dividerWidth;
    private int eDA;
    private Paint eDC;
    private boolean eDD;
    private int eDE;
    private int eDF;
    private int eDM;
    private int eDN;
    private LinearLayout.LayoutParams eDu;
    private LinearLayout.LayoutParams eDv;
    public ViewPager.OnPageChangeListener eDx;
    private LinearLayout eDy;
    private ViewPager eDz;
    private float fvF;
    private int fvG;
    private int fvH;
    private Paint fvI;
    private RectF fvJ;
    private int fvK;
    private int fvP;
    private int fvQ;
    private int fvR;
    private int fvS;
    private int fvV;
    private int fvW;
    private int fvX;
    private float fvY;
    private float fvZ;
    private int fwc;
    private int fwd;
    private int fwe;
    private boolean fwf;
    private boolean fwl;
    private boolean isLoading;
    private final b jgG;
    private boolean jgH;
    private int jgI;
    private int jgJ;
    private int jgK;
    private int jgL;
    private a jgM;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void n(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jgG = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fvF = 0.0f;
        this.fvG = 0;
        this.fvH = 0;
        this.eDD = false;
        this.jgJ = R.color.cp_cont_b;
        this.jgK = R.color.cp_cont_j;
        this.jgL = R.color.cp_link_tip_a;
        this.eDE = ap.getColor(this.jgJ);
        this.eDF = ap.getColor(this.jgK);
        this.fvP = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fvV = 17;
        this.fvW = 17;
        this.eDM = 0;
        this.eDN = R.drawable.pager_sliding_view;
        this.fwf = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eDy = new LinearLayout(getContext());
        this.eDy.setOrientation(0);
        this.eDy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eDy);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fvP = (int) TypedValue.applyDimension(1, this.fvP, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fvV = i;
        this.fvW = i2;
        this.fvX = l.getDimens(getContext(), R.dimen.tbds46);
        this.fvY = (this.fvW * 1.0f) / this.fvV;
        this.fvZ = (this.fvX * 1.0f) / this.fvV;
        this.mIndicatorHeight = i3;
        this.eDD = z;
        this.eDC = new Paint();
        this.eDC.setAntiAlias(true);
        this.eDC.setStyle(Paint.Style.FILL);
        this.eDC.setColor(ap.getColor(R.color.cp_link_tip_a));
        this.fvI = new Paint();
        this.fvI.setAntiAlias(true);
        this.fvI.setStyle(Paint.Style.FILL);
        this.fvI.setColor(ap.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.fvI.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
        this.fvJ = new RectF();
        this.fwc = l.getDimens(getContext(), R.dimen.tbds20);
        this.fwd = l.getDimens(getContext(), R.dimen.tbds28);
        this.fwe = l.getDimens(getContext(), R.dimen.tbds22);
        this.eDu = new LinearLayout.LayoutParams(-2, -1);
        this.eDv = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fvR = l.getDimens(getContext(), R.dimen.tbds62);
        this.fvQ = l.getDimens(getContext(), R.dimen.tbds0);
        this.fvS = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eDv = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fwl = z;
        invalidate();
    }

    public boolean cDR() {
        return this.fwl;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.jgH = z;
        invalidate();
    }

    public boolean cDS() {
        return this.jgH;
    }

    public void setTabItemClicked(boolean z) {
        this.fwf = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eDz = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.jgG);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eDx = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eDz != null && this.eDz.getAdapter() != null && this.eDz.getAdapter().getCount() != 0) {
            this.eDy.removeAllViews();
            this.eDA = this.eDz.getAdapter().getCount();
            for (int i = 0; i < this.eDA; i++) {
                az(i, this.eDz.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.eDz.getCurrentItem();
                    PagerSlidingTabStrip.this.fvG = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void az(int i, String str) {
        String string;
        if (d.bdK() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.fvV);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds42), 0, 0, 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            SvgManager.bmU().a(imageView, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        TextView textView2 = new TextView(getContext());
        if (i == 0) {
            if (d.bdK() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.blO().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        textView2.setText(str);
        textView2.setGravity(17);
        textView2.setTextSize(0, this.fvV);
        textView2.setSingleLine();
        textView2.setBackgroundColor(getResources().getColor(R.color.mem_center_vip_blue_1));
        d(i, textView2);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.jgM != null) {
                        PagerSlidingTabStrip.this.jgM.n(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.eDz.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.bdK()) {
                        if (PagerSlidingTabStrip.this.eDz.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).aj("obj_locate", i + 1).dK("obj_type", "1"));
                        PagerSlidingTabStrip.this.fwf = true;
                        if (PagerSlidingTabStrip.this.eDz.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.eDz.getAdapter()).AS(i);
                        }
                        PagerSlidingTabStrip.this.eDz.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.bdK()) {
            this.eDy.addView(view, i, this.eDu);
        } else {
            this.eDy.addView(view, i, this.eDD ? this.eDv : this.eDu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eDA != 0) {
            int left = this.eDy.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fvP;
            }
            if (left != this.eDM) {
                this.eDM = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.eDA != 0) {
            View childAt = this.eDy.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fvR;
            float right2 = childAt.getRight() - this.fvR;
            if (childAt instanceof LinearLayout) {
                right2 = b(right2, childAt);
                left = c(left, childAt);
            }
            if (this.fvF > 0.0f && this.mCurrentTabIndex != this.fvG && this.fvG <= this.eDA - 1 && this.fvG >= 0) {
                View childAt2 = this.eDy.getChildAt(this.fvG);
                float left2 = childAt2.getLeft() + this.fvR;
                float right3 = childAt2.getRight() - this.fvR;
                if (childAt2 instanceof LinearLayout) {
                    right3 = b(right3, childAt2);
                    left2 = c(left2, childAt2);
                }
                left = e(left, left2, this.fvF);
                right2 = f(right2, right3, this.fvF);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left, (height - this.mIndicatorHeight) - this.fvQ, right2, height - this.fvQ);
            } else {
                this.GD.set(left, (height - this.mIndicatorHeight) - this.fvQ, right2, height - this.fvQ);
            }
            canvas.drawRoundRect(this.GD, 16.0f, 16.0f, this.eDC);
            if (this.jgH) {
                View childAt3 = this.eDy.getChildAt(this.jgI);
                this.fvJ.set((childAt3.getRight() - this.fwe) - this.fwc, childAt3.getTop() + this.fwd, right + this.fwc, top + this.fwc);
                canvas.drawOval(this.fvJ, this.fvI);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fvS + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fvS + f2) - ((this.fvS * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fvS + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fvS) + ((this.fvS * (0.2f - f3)) / 0.2f);
        }
    }

    private float b(float f, View view) {
        TextView textView;
        if ((((LinearLayout) view).getChildAt(0) instanceof TextView) && (textView = (TextView) ((LinearLayout) view).getChildAt(0)) != null && getResources().getString(R.string.attention_person).equals(textView.getText())) {
            return f - (textView.getPaint().measureText(getResources().getString(R.string.attention_person).substring(2, 4)) / 2.0f);
        }
        return f;
    }

    private float c(float f, View view) {
        TextView textView;
        if ((((LinearLayout) view).getChildAt(0) instanceof TextView) && (textView = (TextView) ((LinearLayout) view).getChildAt(0)) != null && getResources().getString(R.string.attention_person).equals(textView.getText())) {
            return f + (textView.getPaint().measureText(getResources().getString(R.string.attention_person).substring(2, 4)) / 2.0f);
        }
        return f;
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.eDE = ap.getColor(this.jgJ);
            this.eDF = ap.getColor(this.jgK);
            this.eDC.setColor(ap.getColor(this.jgL));
            this.fvI.setColor(ap.getColor(R.color.cp_cont_h));
            this.fvI.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float aj(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fvZ - 1.0f) / (0.1f - 1.0f))) + this.fvZ;
        }
        return (((this.fvZ - this.fvY) / 0.1f) * f) + this.fvY;
    }

    private float ak(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fvZ) / (0.1f - 0.9f)));
        }
        return (((this.fvZ - this.fvY) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fvZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ak;
        float f = this.fvF;
        float f2 = this.fvG < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eDA) {
            View childAt = this.eDy.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eDN);
                TextView textView = null;
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                } else if (childAt instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) childAt;
                    textView = (TextView) linearLayout.getChildAt(0);
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        SvgManager.bmU().a((ImageView) linearLayout.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                    }
                }
                if (textView != null) {
                    if (i == this.mCurrentTabIndex) {
                        ak = aj(f2);
                    } else {
                        ak = i == this.fvG ? ak(f2) : 1.0f;
                    }
                    textView.setScaleX(ak);
                    textView.setScaleY(ak);
                    if (f2 >= 0.5f) {
                        if (i == this.fvG) {
                            textView.setTextColor(this.eDE);
                        } else {
                            textView.setTextColor(this.eDF);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eDE);
                    } else {
                        textView.setTextColor(this.eDF);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fvG) {
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

    /* loaded from: classes22.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.eDy.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.fwf) {
                    if (i == PagerSlidingTabStrip.this.fvH) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fvG = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fvH) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fvG = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fvG = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fvH = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fvG = i;
                    }
                    PagerSlidingTabStrip.this.fvF = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eDy.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.eDx != null) {
                    PagerSlidingTabStrip.this.eDx.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.eDy.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.eDz.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fvF = 0.0f;
                    PagerSlidingTabStrip.this.fwf = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fvH = PagerSlidingTabStrip.this.eDz.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fvH;
                    PagerSlidingTabStrip.this.fvG = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.eDx != null) {
                    PagerSlidingTabStrip.this.eDx.onPageScrollStateChanged(i);
                }
                HomePageStatic.jci = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.eDx != null) {
                PagerSlidingTabStrip.this.eDx.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.fwf) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fvF * PagerSlidingTabStrip.this.eDy.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fvH = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fvG = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZP;
        this.fvG = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZP = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: X */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: AU */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZP);
        }
    }

    public View AT(int i) {
        return this.eDy.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fvK = i;
    }

    public void setHotTopicIndex(int i) {
        this.jgI = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jgM = aVar;
    }
}
