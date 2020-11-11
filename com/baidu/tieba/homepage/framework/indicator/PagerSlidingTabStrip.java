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
    private LinearLayout.LayoutParams eRF;
    private LinearLayout.LayoutParams eRG;
    public ViewPager.OnPageChangeListener eRI;
    private LinearLayout eRJ;
    private ViewPager eRK;
    private int eRL;
    private Paint eRN;
    private boolean eRO;
    private int eRP;
    private int eRQ;
    private int eRX;
    private int eRY;
    private float fJQ;
    private int fJR;
    private int fJS;
    private Paint fJT;
    private RectF fJU;
    private int fJV;
    private int fKa;
    private int fKb;
    private int fKc;
    private int fKd;
    private int fKg;
    private int fKh;
    private int fKi;
    private float fKj;
    private float fKk;
    private int fKn;
    private int fKo;
    private int fKp;
    private boolean fKq;
    private boolean fKw;
    private boolean isLoading;
    private final b jzb;
    private boolean jzc;
    private int jzd;
    private int jze;
    private int jzf;
    private int jzg;
    private a jzh;
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
        this.jzb = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fJQ = 0.0f;
        this.fJR = 0;
        this.fJS = 0;
        this.eRO = false;
        this.jze = R.color.cp_cont_b;
        this.jzf = R.color.cp_cont_j;
        this.jzg = R.color.cp_link_tip_a;
        this.eRP = ap.getColor(this.jze);
        this.eRQ = ap.getColor(this.jzf);
        this.fKa = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fKg = 17;
        this.fKh = 17;
        this.eRX = 0;
        this.eRY = R.drawable.pager_sliding_view;
        this.fKq = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eRJ = new LinearLayout(getContext());
        this.eRJ.setOrientation(0);
        this.eRJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eRJ);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fKa = (int) TypedValue.applyDimension(1, this.fKa, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fKg = i;
        this.fKh = i2;
        this.fKi = l.getDimens(getContext(), R.dimen.tbds46);
        this.fKj = (this.fKh * 1.0f) / this.fKg;
        this.fKk = (this.fKi * 1.0f) / this.fKg;
        this.mIndicatorHeight = i3;
        this.eRO = z;
        this.eRN = new Paint();
        this.eRN.setAntiAlias(true);
        this.eRN.setStyle(Paint.Style.FILL);
        this.eRN.setColor(ap.getColor(R.color.cp_link_tip_a));
        this.fJT = new Paint();
        this.fJT.setAntiAlias(true);
        this.fJT.setStyle(Paint.Style.FILL);
        this.fJT.setColor(ap.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.fJT.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
        this.fJU = new RectF();
        this.fKn = l.getDimens(getContext(), R.dimen.tbds20);
        this.fKo = l.getDimens(getContext(), R.dimen.tbds28);
        this.fKp = l.getDimens(getContext(), R.dimen.tbds22);
        this.eRF = new LinearLayout.LayoutParams(-2, -1);
        this.eRG = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fKc = l.getDimens(getContext(), R.dimen.tbds62);
        this.fKb = l.getDimens(getContext(), R.dimen.tbds0);
        this.fKd = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eRG = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fKw = z;
        invalidate();
    }

    public boolean cJz() {
        return this.fKw;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.jzc = z;
        invalidate();
    }

    public boolean cJA() {
        return this.jzc;
    }

    public void setTabItemClicked(boolean z) {
        this.fKq = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eRK = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.jzb);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eRI = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eRK != null && this.eRK.getAdapter() != null && this.eRK.getAdapter().getCount() != 0) {
            this.eRJ.removeAllViews();
            this.eRL = this.eRK.getAdapter().getCount();
            for (int i = 0; i < this.eRL; i++) {
                aF(i, this.eRK.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.eRK.getCurrentItem();
                    PagerSlidingTabStrip.this.fJR = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aF(int i, String str) {
        String string;
        if (d.bid() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.fKg);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds42), 0, 0, 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            SvgManager.brn().a(imageView, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        TextView textView2 = new TextView(getContext());
        if (i == 0) {
            if (d.bid() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        textView2.setText(str);
        textView2.setGravity(17);
        textView2.setTextSize(0, this.fKg);
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
                    if (PagerSlidingTabStrip.this.jzh != null) {
                        PagerSlidingTabStrip.this.jzh.n(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.eRK.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.bid()) {
                        if (PagerSlidingTabStrip.this.eRK.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).al("obj_locate", i + 1).dR("obj_type", "1"));
                        PagerSlidingTabStrip.this.fKq = true;
                        if (PagerSlidingTabStrip.this.eRK.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.eRK.getAdapter()).By(i);
                        }
                        PagerSlidingTabStrip.this.eRK.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.bid()) {
            this.eRJ.addView(view, i, this.eRF);
        } else {
            this.eRJ.addView(view, i, this.eRO ? this.eRG : this.eRF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eRL != 0) {
            int left = this.eRJ.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fKa;
            }
            if (left != this.eRX) {
                this.eRX = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.eRL != 0) {
            View childAt = this.eRJ.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fKc;
            float right2 = childAt.getRight() - this.fKc;
            if (childAt instanceof LinearLayout) {
                right2 = b(right2, childAt);
                left = c(left, childAt);
            }
            if (this.fJQ > 0.0f && this.mCurrentTabIndex != this.fJR && this.fJR <= this.eRL - 1 && this.fJR >= 0) {
                View childAt2 = this.eRJ.getChildAt(this.fJR);
                float left2 = childAt2.getLeft() + this.fKc;
                float right3 = childAt2.getRight() - this.fKc;
                if (childAt2 instanceof LinearLayout) {
                    right3 = b(right3, childAt2);
                    left2 = c(left2, childAt2);
                }
                left = e(left, left2, this.fJQ);
                right2 = f(right2, right3, this.fJQ);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left, (height - this.mIndicatorHeight) - this.fKb, right2, height - this.fKb);
            } else {
                this.GD.set(left, (height - this.mIndicatorHeight) - this.fKb, right2, height - this.fKb);
            }
            canvas.drawRoundRect(this.GD, 16.0f, 16.0f, this.eRN);
            if (this.jzc) {
                View childAt3 = this.eRJ.getChildAt(this.jzd);
                this.fJU.set((childAt3.getRight() - this.fKp) - this.fKn, childAt3.getTop() + this.fKo, right + this.fKn, top + this.fKn);
                canvas.drawOval(this.fJU, this.fJT);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fKd + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fKd + f2) - ((this.fKd * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fKd + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fKd) + ((this.fKd * (0.2f - f3)) / 0.2f);
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
            this.eRP = ap.getColor(this.jze);
            this.eRQ = ap.getColor(this.jzf);
            this.eRN.setColor(ap.getColor(this.jzg));
            this.fJT.setColor(ap.getColor(R.color.cp_cont_h));
            this.fJT.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float an(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fKk - 1.0f) / (0.1f - 1.0f))) + this.fKk;
        }
        return (((this.fKk - this.fKj) / 0.1f) * f) + this.fKj;
    }

    private float ao(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fKk) / (0.1f - 0.9f)));
        }
        return (((this.fKk - this.fKj) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fKk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ao;
        float f = this.fJQ;
        float f2 = this.fJR < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eRL) {
            View childAt = this.eRJ.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eRY);
                TextView textView = null;
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                } else if (childAt instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) childAt;
                    textView = (TextView) linearLayout.getChildAt(0);
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        SvgManager.brn().a((ImageView) linearLayout.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                    }
                }
                if (textView != null) {
                    if (i == this.mCurrentTabIndex) {
                        ao = an(f2);
                    } else {
                        ao = i == this.fJR ? ao(f2) : 1.0f;
                    }
                    textView.setScaleX(ao);
                    textView.setScaleY(ao);
                    if (f2 >= 0.5f) {
                        if (i == this.fJR) {
                            textView.setTextColor(this.eRP);
                        } else {
                            textView.setTextColor(this.eRQ);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eRP);
                    } else {
                        textView.setTextColor(this.eRQ);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fJR) {
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
            if (PagerSlidingTabStrip.this.eRJ.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.fKq) {
                    if (i == PagerSlidingTabStrip.this.fJS) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fJR = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fJS) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fJR = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fJR = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fJS = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fJR = i;
                    }
                    PagerSlidingTabStrip.this.fJQ = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eRJ.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.eRI != null) {
                    PagerSlidingTabStrip.this.eRI.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.eRJ.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.eRK.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fJQ = 0.0f;
                    PagerSlidingTabStrip.this.fKq = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fJS = PagerSlidingTabStrip.this.eRK.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fJS;
                    PagerSlidingTabStrip.this.fJR = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.eRI != null) {
                    PagerSlidingTabStrip.this.eRI.onPageScrollStateChanged(i);
                }
                HomePageStatic.juA = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.eRI != null) {
                PagerSlidingTabStrip.this.eRI.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.fKq) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fJQ * PagerSlidingTabStrip.this.eRJ.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fJS = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fJR = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZQ;
        this.fJR = this.mCurrentTabIndex;
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
            /* renamed from: BA */
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

    public View Bz(int i) {
        return this.eRJ.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fJV = i;
    }

    public void setHotTopicIndex(int i) {
        this.jzd = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jzh = aVar;
    }
}
