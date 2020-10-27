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
    private LinearLayout.LayoutParams eLQ;
    private LinearLayout.LayoutParams eLR;
    public ViewPager.OnPageChangeListener eLT;
    private LinearLayout eLU;
    private ViewPager eLV;
    private int eLW;
    private Paint eLY;
    private boolean eLZ;
    private int eMa;
    private int eMb;
    private int eMi;
    private int eMj;
    private boolean fEA;
    private boolean fEG;
    private float fEa;
    private int fEb;
    private int fEc;
    private Paint fEd;
    private RectF fEe;
    private int fEf;
    private int fEk;
    private int fEl;
    private int fEm;
    private int fEn;
    private int fEq;
    private int fEr;
    private int fEs;
    private float fEt;
    private float fEu;
    private int fEx;
    private int fEy;
    private int fEz;
    private boolean isLoading;
    private final b jte;
    private boolean jtf;
    private int jtg;
    private int jth;
    private int jti;
    private int jtj;
    private a jtk;
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
        this.jte = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fEa = 0.0f;
        this.fEb = 0;
        this.fEc = 0;
        this.eLZ = false;
        this.jth = R.color.cp_cont_b;
        this.jti = R.color.cp_cont_j;
        this.jtj = R.color.cp_link_tip_a;
        this.eMa = ap.getColor(this.jth);
        this.eMb = ap.getColor(this.jti);
        this.fEk = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fEq = 17;
        this.fEr = 17;
        this.eMi = 0;
        this.eMj = R.drawable.pager_sliding_view;
        this.fEA = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eLU = new LinearLayout(getContext());
        this.eLU.setOrientation(0);
        this.eLU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eLU);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fEk = (int) TypedValue.applyDimension(1, this.fEk, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fEq = i;
        this.fEr = i2;
        this.fEs = l.getDimens(getContext(), R.dimen.tbds46);
        this.fEt = (this.fEr * 1.0f) / this.fEq;
        this.fEu = (this.fEs * 1.0f) / this.fEq;
        this.mIndicatorHeight = i3;
        this.eLZ = z;
        this.eLY = new Paint();
        this.eLY.setAntiAlias(true);
        this.eLY.setStyle(Paint.Style.FILL);
        this.eLY.setColor(ap.getColor(R.color.cp_link_tip_a));
        this.fEd = new Paint();
        this.fEd.setAntiAlias(true);
        this.fEd.setStyle(Paint.Style.FILL);
        this.fEd.setColor(ap.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.fEd.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
        this.fEe = new RectF();
        this.fEx = l.getDimens(getContext(), R.dimen.tbds20);
        this.fEy = l.getDimens(getContext(), R.dimen.tbds28);
        this.fEz = l.getDimens(getContext(), R.dimen.tbds22);
        this.eLQ = new LinearLayout.LayoutParams(-2, -1);
        this.eLR = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fEm = l.getDimens(getContext(), R.dimen.tbds62);
        this.fEl = l.getDimens(getContext(), R.dimen.tbds0);
        this.fEn = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eLR = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fEG = z;
        invalidate();
    }

    public boolean cGY() {
        return this.fEG;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.jtf = z;
        invalidate();
    }

    public boolean cGZ() {
        return this.jtf;
    }

    public void setTabItemClicked(boolean z) {
        this.fEA = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eLV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.jte);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eLT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eLV != null && this.eLV.getAdapter() != null && this.eLV.getAdapter().getCount() != 0) {
            this.eLU.removeAllViews();
            this.eLW = this.eLV.getAdapter().getCount();
            for (int i = 0; i < this.eLW; i++) {
                aB(i, this.eLV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.eLV.getCurrentItem();
                    PagerSlidingTabStrip.this.fEb = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aB(int i, String str) {
        String string;
        if (d.bfD() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.fEq);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds42), 0, 0, 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            SvgManager.boN().a(imageView, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        TextView textView2 = new TextView(getContext());
        if (i == 0) {
            if (d.bfD() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        textView2.setText(str);
        textView2.setGravity(17);
        textView2.setTextSize(0, this.fEq);
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
                    if (PagerSlidingTabStrip.this.jtk != null) {
                        PagerSlidingTabStrip.this.jtk.n(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.eLV.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.bfD()) {
                        if (PagerSlidingTabStrip.this.eLV.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).aj("obj_locate", i + 1).dR("obj_type", "1"));
                        PagerSlidingTabStrip.this.fEA = true;
                        if (PagerSlidingTabStrip.this.eLV.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.eLV.getAdapter()).Bl(i);
                        }
                        PagerSlidingTabStrip.this.eLV.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.bfD()) {
            this.eLU.addView(view, i, this.eLQ);
        } else {
            this.eLU.addView(view, i, this.eLZ ? this.eLR : this.eLQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eLW != 0) {
            int left = this.eLU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fEk;
            }
            if (left != this.eMi) {
                this.eMi = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.eLW != 0) {
            View childAt = this.eLU.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fEm;
            float right2 = childAt.getRight() - this.fEm;
            if (childAt instanceof LinearLayout) {
                right2 = b(right2, childAt);
                left = c(left, childAt);
            }
            if (this.fEa > 0.0f && this.mCurrentTabIndex != this.fEb && this.fEb <= this.eLW - 1 && this.fEb >= 0) {
                View childAt2 = this.eLU.getChildAt(this.fEb);
                float left2 = childAt2.getLeft() + this.fEm;
                float right3 = childAt2.getRight() - this.fEm;
                if (childAt2 instanceof LinearLayout) {
                    right3 = b(right3, childAt2);
                    left2 = c(left2, childAt2);
                }
                left = e(left, left2, this.fEa);
                right2 = f(right2, right3, this.fEa);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left, (height - this.mIndicatorHeight) - this.fEl, right2, height - this.fEl);
            } else {
                this.GD.set(left, (height - this.mIndicatorHeight) - this.fEl, right2, height - this.fEl);
            }
            canvas.drawRoundRect(this.GD, 16.0f, 16.0f, this.eLY);
            if (this.jtf) {
                View childAt3 = this.eLU.getChildAt(this.jtg);
                this.fEe.set((childAt3.getRight() - this.fEz) - this.fEx, childAt3.getTop() + this.fEy, right + this.fEx, top + this.fEx);
                canvas.drawOval(this.fEe, this.fEd);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fEn + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fEn + f2) - ((this.fEn * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fEn + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fEn) + ((this.fEn * (0.2f - f3)) / 0.2f);
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
            this.eMa = ap.getColor(this.jth);
            this.eMb = ap.getColor(this.jti);
            this.eLY.setColor(ap.getColor(this.jtj));
            this.fEd.setColor(ap.getColor(R.color.cp_cont_h));
            this.fEd.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float al(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fEu - 1.0f) / (0.1f - 1.0f))) + this.fEu;
        }
        return (((this.fEu - this.fEt) / 0.1f) * f) + this.fEt;
    }

    private float am(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fEu) / (0.1f - 0.9f)));
        }
        return (((this.fEu - this.fEt) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fEu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float am;
        float f = this.fEa;
        float f2 = this.fEb < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eLW) {
            View childAt = this.eLU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eMj);
                TextView textView = null;
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                } else if (childAt instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) childAt;
                    textView = (TextView) linearLayout.getChildAt(0);
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        SvgManager.boN().a((ImageView) linearLayout.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                    }
                }
                if (textView != null) {
                    if (i == this.mCurrentTabIndex) {
                        am = al(f2);
                    } else {
                        am = i == this.fEb ? am(f2) : 1.0f;
                    }
                    textView.setScaleX(am);
                    textView.setScaleY(am);
                    if (f2 >= 0.5f) {
                        if (i == this.fEb) {
                            textView.setTextColor(this.eMa);
                        } else {
                            textView.setTextColor(this.eMb);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eMa);
                    } else {
                        textView.setTextColor(this.eMb);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fEb) {
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
            if (PagerSlidingTabStrip.this.eLU.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.fEA) {
                    if (i == PagerSlidingTabStrip.this.fEc) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fEb = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fEc) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fEb = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fEb = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fEc = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fEb = i;
                    }
                    PagerSlidingTabStrip.this.fEa = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eLU.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.eLT != null) {
                    PagerSlidingTabStrip.this.eLT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.eLU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.eLV.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fEa = 0.0f;
                    PagerSlidingTabStrip.this.fEA = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fEc = PagerSlidingTabStrip.this.eLV.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fEc;
                    PagerSlidingTabStrip.this.fEb = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.eLT != null) {
                    PagerSlidingTabStrip.this.eLT.onPageScrollStateChanged(i);
                }
                HomePageStatic.joD = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.eLT != null) {
                PagerSlidingTabStrip.this.eLT.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.fEA) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fEa * PagerSlidingTabStrip.this.eLU.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fEc = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fEb = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZQ;
        this.fEb = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZQ = this.mCurrentTabIndex;
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
            /* renamed from: Bn */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZQ);
        }
    }

    public View Bm(int i) {
        return this.eLU.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fEf = i;
    }

    public void setHotTopicIndex(int i) {
        this.jtg = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jtk = aVar;
    }
}
