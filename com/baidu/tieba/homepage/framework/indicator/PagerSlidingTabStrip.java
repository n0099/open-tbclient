package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes22.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private RectF Hx;
    private boolean bqt;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams eXY;
    private LinearLayout.LayoutParams eXZ;
    public ViewPager.OnPageChangeListener eYb;
    private LinearLayout eYc;
    private ViewPager eYd;
    private int eYe;
    private Paint eYg;
    private boolean eYh;
    private int eYi;
    private int eYj;
    private int eYs;
    private int eYt;
    private int fRC;
    private int fRD;
    private int fRE;
    private boolean fRK;
    private float fRf;
    private int fRg;
    private int fRh;
    private Paint fRi;
    private RectF fRj;
    private int fRk;
    private int fRp;
    private int fRq;
    private int fRr;
    private int fRs;
    private int fRv;
    private int fRw;
    private int fRx;
    private float fRy;
    private float fRz;
    private boolean isLoading;
    private int jNA;
    private int jNB;
    private int jNC;
    private a jND;
    private final b jNw;
    private boolean jNx;
    private int jNy;
    private int jNz;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void q(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jNw = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fRf = 0.0f;
        this.fRg = 0;
        this.fRh = 0;
        this.eYh = false;
        this.jNz = R.color.CAM_X0105;
        this.jNA = R.color.CAM_X0105;
        this.jNB = R.color.CAM_X0302;
        this.eYi = ap.getColor(this.jNz);
        this.eYj = ap.getColor(this.jNA);
        this.fRp = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fRv = 17;
        this.fRw = 17;
        this.eYs = 0;
        this.eYt = R.drawable.pager_sliding_view;
        this.bqt = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eYc = new LinearLayout(getContext());
        this.eYc.setOrientation(0);
        this.eYc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eYc);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fRp = (int) TypedValue.applyDimension(1, this.fRp, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fRv = i;
        this.fRw = i2;
        this.fRx = l.getDimens(getContext(), R.dimen.tbds46);
        this.fRy = (this.fRw * 1.0f) / this.fRv;
        this.fRz = (this.fRx * 1.0f) / this.fRv;
        this.jNC = -l.getDimens(getContext(), R.dimen.tbds11);
        this.mIndicatorHeight = i3;
        this.eYh = z;
        this.eYg = new Paint();
        this.eYg.setAntiAlias(true);
        this.eYg.setStyle(Paint.Style.FILL);
        this.eYg.setColor(ap.getColor(R.color.CAM_X0302));
        this.fRi = new Paint();
        this.fRi.setAntiAlias(true);
        this.fRi.setStyle(Paint.Style.FILL);
        this.fRi.setColor(ap.getColor(R.color.CAM_X0301));
        setLayerType(1, null);
        this.fRj = new RectF();
        this.fRC = l.getDimens(getContext(), R.dimen.tbds20);
        this.fRD = (int) (l.getDimens(getContext(), R.dimen.tbds28) * 0.5d);
        this.fRE = (int) (l.getDimens(getContext(), R.dimen.tbds22) * 0.4d);
        this.eXY = new LinearLayout.LayoutParams(-2, -1);
        this.eXZ = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fRr = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) + Math.round(i * 0.5f);
        this.fRq = l.getDimens(getContext(), R.dimen.tbds5);
        this.fRs = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eXZ = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fRK = z;
        invalidate();
    }

    public boolean cOu() {
        return this.fRK;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.jNx = z;
        invalidate();
    }

    public boolean cOv() {
        return this.jNx;
    }

    public void setTabItemClicked(boolean z) {
        this.bqt = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eYd = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.jNw);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eYb = onPageChangeListener;
    }

    public void bjF() {
        if (this.eYd != null && this.eYd.getAdapter() != null && this.eYd.getAdapter().getCount() != 0) {
            this.eYc.removeAllViews();
            this.eYe = this.eYd.getAdapter().getCount();
            for (int i = 0; i < this.eYe; i++) {
                aD(i, this.eYd.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
        }
    }

    public void notifyDataSetChanged() {
        if (this.eYd != null && this.eYd.getAdapter() != null && this.eYd.getAdapter().getCount() != 0) {
            this.eYc.removeAllViews();
            this.eYe = this.eYd.getAdapter().getCount();
            for (int i = 0; i < this.eYe; i++) {
                aD(i, this.eYd.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.eYd.getCurrentItem();
                    PagerSlidingTabStrip.this.fRg = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aD(int i, String str) {
        String string;
        if (d.bkz() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.fRv);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_unfold16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.jNC;
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        EMTextView eMTextView = new EMTextView(getContext());
        if (i == 0) {
            if (d.bkz() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        eMTextView.setTextSize(0, this.fRv);
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
                    if (PagerSlidingTabStrip.this.jND != null) {
                        PagerSlidingTabStrip.this.jND.q(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.eYd.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.bkz()) {
                        if (PagerSlidingTabStrip.this.eYd.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).al("obj_locate", i + 1).dY("obj_type", "1"));
                        PagerSlidingTabStrip.this.bqt = true;
                        if (PagerSlidingTabStrip.this.eYd.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.eYd.getAdapter()).CL(i);
                        }
                        PagerSlidingTabStrip.this.eYd.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.bkz()) {
            this.eYc.addView(view, i, this.eXY);
        } else {
            this.eYc.addView(view, i, this.eYh ? this.eXZ : this.eXY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eYe != 0) {
            int left = this.eYc.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fRp;
            }
            if (left != this.eYs) {
                this.eYs = left;
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
        if (!isInEditMode() && this.eYe != 0) {
            View childAt = this.eYc.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fRr;
            float right2 = childAt.getRight() - this.fRr;
            if ((childAt instanceof LinearLayout) && (((LinearLayout) childAt).getChildAt(0) instanceof TextView)) {
                float left2 = (childAt.getLeft() + childAt.getRight()) / 2.0f;
                float b2 = b(left2, childAt);
                float c = c(left2, childAt);
                right2 = b2;
                left = c;
            }
            if (this.fRf > 0.0f && this.mCurrentTabIndex != this.fRg && this.fRg <= this.eYe - 1 && this.fRg >= 0) {
                View childAt2 = this.eYc.getChildAt(this.fRg);
                float left3 = childAt2.getLeft() + this.fRr;
                float right3 = childAt2.getRight() - this.fRr;
                if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                    float left4 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                    f = b(left4, childAt2);
                    f2 = c(left4, childAt2);
                } else {
                    f = right3;
                    f2 = left3;
                }
                left = e(left, f2, this.fRf);
                right2 = f(right2, f, this.fRf);
            }
            int height = getHeight();
            if (this.Hx == null) {
                this.Hx = new RectF(left, (height - this.mIndicatorHeight) - this.fRq, right2, height - this.fRq);
            } else {
                this.Hx.set(left, (height - this.mIndicatorHeight) - this.fRq, right2, height - this.fRq);
            }
            canvas.drawRoundRect(this.Hx, this.mIndicatorHeight * 0.5f, this.mIndicatorHeight * 0.5f, this.eYg);
            if (this.jNx) {
                View childAt3 = this.eYc.getChildAt(this.jNy);
                this.fRj.set((childAt3.getRight() - this.fRE) - this.fRC, childAt3.getTop() + this.fRD, right + this.fRC, top + this.fRC);
                canvas.drawOval(this.fRj, this.fRi);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fRs + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fRs + f2) - ((this.fRs * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fRs + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fRs) + ((this.fRs * (0.2f - f3)) / 0.2f);
        }
    }

    private float b(float f, View view) {
        return (((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f) + f) - this.fRr;
    }

    private float c(float f, View view) {
        return (f - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f)) + this.fRr;
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.eYi = ap.getColor(this.jNz);
            this.eYj = ap.getColor(this.jNA);
            this.eYg.setColor(ap.getColor(this.jNB));
            this.fRi.setColor(ap.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float aq(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fRz - 1.0f) / (0.1f - 1.0f))) + this.fRz;
        }
        return (((this.fRz - this.fRy) / 0.1f) * f) + this.fRy;
    }

    private float ar(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fRz) / (0.1f - 0.9f)));
        }
        return (((this.fRz - this.fRy) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fRz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ar;
        float f = this.fRf;
        float f2 = this.fRg < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eYe) {
            View childAt = this.eYc.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eYt);
                TextView textView = null;
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                } else if (childAt instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) childAt;
                    textView = (TextView) linearLayout.getChildAt(0);
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        ((ImageView) linearLayout.getChildAt(1)).setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_unfold16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
                    }
                }
                if (textView != null) {
                    if (i == this.mCurrentTabIndex) {
                        ar = aq(f2);
                    } else {
                        ar = i == this.fRg ? ar(f2) : 1.0f;
                    }
                    textView.setScaleX(ar);
                    textView.setScaleY(ar);
                    if (f2 >= 0.5f) {
                        if (i == this.fRg) {
                            textView.setTextColor(this.eYi);
                        } else {
                            textView.setTextColor(this.eYj);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eYi);
                    } else {
                        textView.setTextColor(this.eYj);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fRg) {
                            c.bm(textView).pu(R.string.F_X02);
                        } else {
                            c.bm(textView).pu(R.string.F_X01);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        c.bm(textView).pu(R.string.F_X02);
                    } else {
                        c.bm(textView).pu(R.string.F_X01);
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
            if (PagerSlidingTabStrip.this.eYc.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.bqt) {
                    if (i == PagerSlidingTabStrip.this.fRh) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fRg = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fRh) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fRg = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fRg = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fRh = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fRg = i;
                    }
                    PagerSlidingTabStrip.this.fRf = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eYc.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.eYb != null) {
                    PagerSlidingTabStrip.this.eYb.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.eYc.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.eYd.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fRf = 0.0f;
                    PagerSlidingTabStrip.this.bqt = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fRh = PagerSlidingTabStrip.this.eYd.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fRh;
                    PagerSlidingTabStrip.this.fRg = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.eYb != null) {
                    PagerSlidingTabStrip.this.eYb.onPageScrollStateChanged(i);
                }
                HomePageStatic.jIJ = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.eYb != null) {
                PagerSlidingTabStrip.this.eYb.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.bqt) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fRf * PagerSlidingTabStrip.this.eYc.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fRh = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fRg = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.aaR;
        this.fRg = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aaR = this.mCurrentTabIndex;
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
            /* renamed from: CN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aaR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aaR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aaR);
        }
    }

    public View CM(int i) {
        return this.eYc.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fRk = i;
    }

    public void setHotTopicIndex(int i) {
        this.jNy = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jND = aVar;
    }
}
