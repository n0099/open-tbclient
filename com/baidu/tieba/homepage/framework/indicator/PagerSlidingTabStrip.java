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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private boolean bqW;
    private int dividerPadding;
    private int dividerWidth;
    private int fYB;
    private int fYC;
    private int fYD;
    private int fYE;
    private int fYH;
    private int fYI;
    private int fYJ;
    private float fYK;
    private float fYL;
    private int fYO;
    private int fYP;
    private int fYQ;
    private boolean fYW;
    private float fYr;
    private int fYs;
    private int fYt;
    private Paint fYu;
    private RectF fYv;
    private int fYw;
    private int ffB;
    private LinearLayout.LayoutParams fff;
    private LinearLayout.LayoutParams ffg;
    public ViewPager.OnPageChangeListener ffi;
    private LinearLayout ffj;
    private ViewPager ffk;
    private int ffl;
    private Paint ffn;
    private boolean ffo;
    private int ffp;
    private int ffq;
    private boolean isLoading;
    private final b kdG;
    private boolean kdH;
    private int kdI;
    private int kdJ;
    private int kdK;
    private int kdL;
    private int kdM;
    private a kdN;
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
        this.kdG = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fYr = 0.0f;
        this.fYs = 0;
        this.fYt = 0;
        this.ffo = false;
        this.kdJ = R.color.CAM_X0105;
        this.kdK = R.color.CAM_X0105;
        this.kdL = R.color.CAM_X0302;
        this.ffp = ap.getColor(this.kdJ);
        this.ffq = ap.getColor(this.kdK);
        this.fYB = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fYH = 17;
        this.fYI = 17;
        this.ffB = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bqW = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ffj = new LinearLayout(getContext());
        this.ffj.setOrientation(0);
        this.ffj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ffj);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fYB = (int) TypedValue.applyDimension(1, this.fYB, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fYH = i;
        this.fYI = i2;
        this.fYJ = l.getDimens(getContext(), R.dimen.tbds46);
        this.fYK = (this.fYI * 1.0f) / this.fYH;
        this.fYL = (this.fYJ * 1.0f) / this.fYH;
        this.kdM = -l.getDimens(getContext(), R.dimen.tbds11);
        this.mIndicatorHeight = i3;
        this.ffo = z;
        this.ffn = new Paint();
        this.ffn.setAntiAlias(true);
        this.ffn.setStyle(Paint.Style.FILL);
        this.ffn.setColor(ap.getColor(R.color.CAM_X0302));
        this.fYu = new Paint();
        this.fYu.setAntiAlias(true);
        this.fYu.setStyle(Paint.Style.FILL);
        this.fYu.setColor(ap.getColor(R.color.CAM_X0301));
        setLayerType(1, null);
        this.fYv = new RectF();
        this.fYO = l.getDimens(getContext(), R.dimen.tbds20);
        this.fYP = (int) (l.getDimens(getContext(), R.dimen.tbds28) * 0.5d);
        this.fYQ = (int) (l.getDimens(getContext(), R.dimen.tbds22) * 0.4d);
        this.fff = new LinearLayout.LayoutParams(-2, -1);
        this.ffg = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fYD = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) + Math.round(i * 0.5f);
        this.fYC = l.getDimens(getContext(), R.dimen.tbds5);
        this.fYE = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.ffg = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fYW = z;
        invalidate();
    }

    public boolean cPG() {
        return this.fYW;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.kdH = z;
        invalidate();
    }

    public boolean cPH() {
        return this.kdH;
    }

    public void setTabItemClicked(boolean z) {
        this.bqW = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ffk = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.kdG);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ffi = onPageChangeListener;
    }

    public void Mk() {
        if (this.ffk != null && this.ffk.getAdapter() != null && this.ffk.getAdapter().getCount() != 0) {
            this.ffj.removeAllViews();
            this.ffl = this.ffk.getAdapter().getCount();
            for (int i = 0; i < this.ffl; i++) {
                aK(i, this.ffk.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
        }
    }

    public void notifyDataSetChanged() {
        if (this.ffk != null && this.ffk.getAdapter() != null && this.ffk.getAdapter().getCount() != 0) {
            this.ffj.removeAllViews();
            this.ffl = this.ffk.getAdapter().getCount();
            for (int i = 0; i < this.ffl; i++) {
                aK(i, this.ffk.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.ffk.getCurrentItem();
                    PagerSlidingTabStrip.this.fYs = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aK(int i, String str) {
        String string;
        if (d.bjg() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.fYH);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_unfold16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.kdM;
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        EMTextView eMTextView = new EMTextView(getContext());
        if (i == 0) {
            if (d.bjg() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        eMTextView.setTextSize(0, this.fYH);
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
                    if (PagerSlidingTabStrip.this.kdN != null) {
                        PagerSlidingTabStrip.this.kdN.t(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.ffk.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.bjg()) {
                        if (PagerSlidingTabStrip.this.ffk.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).ap("obj_locate", i + 1).dR("obj_type", "1"));
                        PagerSlidingTabStrip.this.bqW = true;
                        if (PagerSlidingTabStrip.this.ffk.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.ffk.getAdapter()).BI(i);
                        }
                        PagerSlidingTabStrip.this.ffk.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.bjg()) {
            this.ffj.addView(view, i, this.fff);
        } else {
            this.ffj.addView(view, i, this.ffo ? this.ffg : this.fff);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ffl != 0) {
            int left = this.ffj.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fYB;
            }
            if (left != this.ffB) {
                this.ffB = left;
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
        if (!isInEditMode() && this.ffl != 0) {
            View childAt = this.ffj.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fYD;
            float right2 = childAt.getRight() - this.fYD;
            if ((childAt instanceof LinearLayout) && (((LinearLayout) childAt).getChildAt(0) instanceof TextView)) {
                float left2 = (childAt.getLeft() + childAt.getRight()) / 2.0f;
                float a2 = a(left2, childAt);
                float b2 = b(left2, childAt);
                right2 = a2;
                left = b2;
            }
            if (this.fYr > 0.0f && this.mCurrentTabIndex != this.fYs && this.fYs <= this.ffl - 1 && this.fYs >= 0) {
                View childAt2 = this.ffj.getChildAt(this.fYs);
                float left3 = childAt2.getLeft() + this.fYD;
                float right3 = childAt2.getRight() - this.fYD;
                if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                    float left4 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                    f = a(left4, childAt2);
                    f2 = b(left4, childAt2);
                } else {
                    f = right3;
                    f2 = left3;
                }
                left = e(left, f2, this.fYr);
                right2 = f(right2, f, this.fYr);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left, (height - this.mIndicatorHeight) - this.fYC, right2, height - this.fYC);
            } else {
                this.rectF.set(left, (height - this.mIndicatorHeight) - this.fYC, right2, height - this.fYC);
            }
            canvas.drawRoundRect(this.rectF, this.mIndicatorHeight * 0.5f, this.mIndicatorHeight * 0.5f, this.ffn);
            if (this.kdH) {
                View childAt3 = this.ffj.getChildAt(this.kdI);
                this.fYv.set((childAt3.getRight() - this.fYQ) - this.fYO, childAt3.getTop() + this.fYP, right + this.fYO, top + this.fYO);
                canvas.drawOval(this.fYv, this.fYu);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fYE + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fYE + f2) - ((this.fYE * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fYE + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fYE) + ((this.fYE * (0.2f - f3)) / 0.2f);
        }
    }

    private float a(float f, View view) {
        return (((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f) + f) - this.fYD;
    }

    private float b(float f, View view) {
        return (f - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f)) + this.fYD;
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.ffp = ap.getColor(this.kdJ);
            this.ffq = ap.getColor(this.kdK);
            this.ffn.setColor(ap.getColor(this.kdL));
            this.fYu.setColor(ap.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fYL - 1.0f) / (0.1f - 1.0f))) + this.fYL;
        }
        return (((this.fYL - this.fYK) / 0.1f) * f) + this.fYK;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fYL) / (0.1f - 0.9f)));
        }
        return (((this.fYL - this.fYK) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fYL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.fYr;
        float f2 = this.fYs < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.ffl) {
            View childAt = this.ffj.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
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
                        au = at(f2);
                    } else {
                        au = i == this.fYs ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (f2 >= 0.5f) {
                        if (i == this.fYs) {
                            textView.setTextColor(this.ffp);
                        } else {
                            textView.setTextColor(this.ffq);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.ffp);
                    } else {
                        textView.setTextColor(this.ffq);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fYs) {
                            c.br(textView).oa(R.string.F_X02);
                        } else {
                            c.br(textView).oa(R.string.F_X01);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        c.br(textView).oa(R.string.F_X02);
                    } else {
                        c.br(textView).oa(R.string.F_X01);
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
            if (PagerSlidingTabStrip.this.ffj.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.bqW) {
                    if (i == PagerSlidingTabStrip.this.fYt) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fYs = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fYt) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fYs = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fYs = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fYt = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fYs = i;
                    }
                    PagerSlidingTabStrip.this.fYr = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.ffj.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.ffi != null) {
                    PagerSlidingTabStrip.this.ffi.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ffj.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.ffk.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fYr = 0.0f;
                    PagerSlidingTabStrip.this.bqW = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fYt = PagerSlidingTabStrip.this.ffk.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fYt;
                    PagerSlidingTabStrip.this.fYs = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.ffi != null) {
                    PagerSlidingTabStrip.this.ffi.onPageScrollStateChanged(i);
                }
                HomePageStatic.jYQ = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ffi != null) {
                PagerSlidingTabStrip.this.ffi.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.bqW) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fYr * PagerSlidingTabStrip.this.ffj.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fYt = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fYs = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.abv;
        this.fYs = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abv = this.mCurrentTabIndex;
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
            /* renamed from: BK */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abv;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abv = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abv);
        }
    }

    public View BJ(int i) {
        return this.ffj.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fYw = i;
    }

    public void setHotTopicIndex(int i) {
        this.kdI = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.kdN = aVar;
    }
}
