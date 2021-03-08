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
    private boolean bsw;
    private int dividerPadding;
    private int dividerWidth;
    private float fZR;
    private int fZS;
    private int fZT;
    private Paint fZU;
    private RectF fZV;
    private int fZW;
    private LinearLayout.LayoutParams fgE;
    private LinearLayout.LayoutParams fgF;
    public ViewPager.OnPageChangeListener fgH;
    private LinearLayout fgI;
    private ViewPager fgJ;
    private int fgK;
    private Paint fgM;
    private boolean fgN;
    private int fgO;
    private int fgP;
    private int fha;
    private int gab;
    private int gac;
    private int gad;
    private int gae;
    private int gah;
    private int gai;
    private int gaj;
    private float gak;
    private float gal;
    private int gao;
    private int gaq;
    private int gar;
    private boolean gax;
    private boolean isLoading;
    private final b kfX;
    private boolean kfY;
    private int kfZ;
    private int kga;
    private int kgb;
    private int kgc;
    private int kgd;
    private a kge;
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
        this.kfX = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fZR = 0.0f;
        this.fZS = 0;
        this.fZT = 0;
        this.fgN = false;
        this.kga = R.color.CAM_X0105;
        this.kgb = R.color.CAM_X0105;
        this.kgc = R.color.CAM_X0302;
        this.fgO = ap.getColor(this.kga);
        this.fgP = ap.getColor(this.kgb);
        this.gab = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.gah = 17;
        this.gai = 17;
        this.fha = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bsw = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.fgI = new LinearLayout(getContext());
        this.fgI.setOrientation(0);
        this.fgI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.fgI);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.gab = (int) TypedValue.applyDimension(1, this.gab, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.gah = i;
        this.gai = i2;
        this.gaj = l.getDimens(getContext(), R.dimen.tbds46);
        this.gak = (this.gai * 1.0f) / this.gah;
        this.gal = (this.gaj * 1.0f) / this.gah;
        this.kgd = -l.getDimens(getContext(), R.dimen.tbds11);
        this.mIndicatorHeight = i3;
        this.fgN = z;
        this.fgM = new Paint();
        this.fgM.setAntiAlias(true);
        this.fgM.setStyle(Paint.Style.FILL);
        this.fgM.setColor(ap.getColor(R.color.CAM_X0302));
        this.fZU = new Paint();
        this.fZU.setAntiAlias(true);
        this.fZU.setStyle(Paint.Style.FILL);
        this.fZU.setColor(ap.getColor(R.color.CAM_X0301));
        setLayerType(1, null);
        this.fZV = new RectF();
        this.gao = l.getDimens(getContext(), R.dimen.tbds20);
        this.gaq = (int) (l.getDimens(getContext(), R.dimen.tbds28) * 0.5d);
        this.gar = (int) (l.getDimens(getContext(), R.dimen.tbds22) * 0.4d);
        this.fgE = new LinearLayout.LayoutParams(-2, -1);
        this.fgF = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.gad = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) + Math.round(i * 0.5f);
        this.gac = l.getDimens(getContext(), R.dimen.tbds5);
        this.gae = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fgF = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.gax = z;
        invalidate();
    }

    public boolean cPU() {
        return this.gax;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.kfY = z;
        invalidate();
    }

    public boolean cPV() {
        return this.kfY;
    }

    public void setTabItemClicked(boolean z) {
        this.bsw = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fgJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.kfX);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fgH = onPageChangeListener;
    }

    public void Mn() {
        if (this.fgJ != null && this.fgJ.getAdapter() != null && this.fgJ.getAdapter().getCount() != 0) {
            this.fgI.removeAllViews();
            this.fgK = this.fgJ.getAdapter().getCount();
            for (int i = 0; i < this.fgK; i++) {
                aK(i, this.fgJ.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fgJ != null && this.fgJ.getAdapter() != null && this.fgJ.getAdapter().getCount() != 0) {
            this.fgI.removeAllViews();
            this.fgK = this.fgJ.getAdapter().getCount();
            for (int i = 0; i < this.fgK; i++) {
                aK(i, this.fgJ.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fgJ.getCurrentItem();
                    PagerSlidingTabStrip.this.fZS = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aK(int i, String str) {
        String string;
        if (d.bji() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.gah);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_unfold16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.kgd;
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        EMTextView eMTextView = new EMTextView(getContext());
        if (i == 0) {
            if (d.bji() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        eMTextView.setTextSize(0, this.gah);
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
                    if (PagerSlidingTabStrip.this.kge != null) {
                        PagerSlidingTabStrip.this.kge.t(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.fgJ.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.bji()) {
                        if (PagerSlidingTabStrip.this.fgJ.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).aq("obj_locate", i + 1).dR("obj_type", "1"));
                        PagerSlidingTabStrip.this.bsw = true;
                        if (PagerSlidingTabStrip.this.fgJ.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.fgJ.getAdapter()).BL(i);
                        }
                        PagerSlidingTabStrip.this.fgJ.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.bji()) {
            this.fgI.addView(view, i, this.fgE);
        } else {
            this.fgI.addView(view, i, this.fgN ? this.fgF : this.fgE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fgK != 0) {
            int left = this.fgI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.gab;
            }
            if (left != this.fha) {
                this.fha = left;
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
        if (!isInEditMode() && this.fgK != 0) {
            View childAt = this.fgI.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.gad;
            float right2 = childAt.getRight() - this.gad;
            if ((childAt instanceof LinearLayout) && (((LinearLayout) childAt).getChildAt(0) instanceof TextView)) {
                float left2 = (childAt.getLeft() + childAt.getRight()) / 2.0f;
                float a2 = a(left2, childAt);
                float b2 = b(left2, childAt);
                right2 = a2;
                left = b2;
            }
            if (this.fZR > 0.0f && this.mCurrentTabIndex != this.fZS && this.fZS <= this.fgK - 1 && this.fZS >= 0) {
                View childAt2 = this.fgI.getChildAt(this.fZS);
                float left3 = childAt2.getLeft() + this.gad;
                float right3 = childAt2.getRight() - this.gad;
                if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                    float left4 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                    f = a(left4, childAt2);
                    f2 = b(left4, childAt2);
                } else {
                    f = right3;
                    f2 = left3;
                }
                left = e(left, f2, this.fZR);
                right2 = f(right2, f, this.fZR);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left, (height - this.mIndicatorHeight) - this.gac, right2, height - this.gac);
            } else {
                this.rectF.set(left, (height - this.mIndicatorHeight) - this.gac, right2, height - this.gac);
            }
            canvas.drawRoundRect(this.rectF, this.mIndicatorHeight * 0.5f, this.mIndicatorHeight * 0.5f, this.fgM);
            if (this.kfY) {
                View childAt3 = this.fgI.getChildAt(this.kfZ);
                this.fZV.set((childAt3.getRight() - this.gar) - this.gao, childAt3.getTop() + this.gaq, right + this.gao, top + this.gao);
                canvas.drawOval(this.fZV, this.fZU);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.gae + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.gae + f2) - ((this.gae * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.gae + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.gae) + ((this.gae * (0.2f - f3)) / 0.2f);
        }
    }

    private float a(float f, View view) {
        return (((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f) + f) - this.gad;
    }

    private float b(float f, View view) {
        return (f - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f)) + this.gad;
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.fgO = ap.getColor(this.kga);
            this.fgP = ap.getColor(this.kgb);
            this.fgM.setColor(ap.getColor(this.kgc));
            this.fZU.setColor(ap.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float ax(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.gal - 1.0f) / (0.1f - 1.0f))) + this.gal;
        }
        return (((this.gal - this.gak) / 0.1f) * f) + this.gak;
    }

    private float ay(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.gal) / (0.1f - 0.9f)));
        }
        return (((this.gal - this.gak) / (0.9f - 1.0f)) * (f - 0.9f)) + this.gal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ay;
        float f = this.fZR;
        float f2 = this.fZS < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.fgK) {
            View childAt = this.fgI.getChildAt(i);
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
                        ay = ax(f2);
                    } else {
                        ay = i == this.fZS ? ay(f2) : 1.0f;
                    }
                    textView.setScaleX(ay);
                    textView.setScaleY(ay);
                    if (f2 >= 0.5f) {
                        if (i == this.fZS) {
                            textView.setTextColor(this.fgO);
                        } else {
                            textView.setTextColor(this.fgP);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.fgO);
                    } else {
                        textView.setTextColor(this.fgP);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fZS) {
                            c.br(textView).ob(R.string.F_X02);
                        } else {
                            c.br(textView).ob(R.string.F_X01);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        c.br(textView).ob(R.string.F_X02);
                    } else {
                        c.br(textView).ob(R.string.F_X01);
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
            if (PagerSlidingTabStrip.this.fgI.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.bsw) {
                    if (i == PagerSlidingTabStrip.this.fZT) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fZS = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fZT) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fZS = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fZS = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fZT = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fZS = i;
                    }
                    PagerSlidingTabStrip.this.fZR = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fgI.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.fgH != null) {
                    PagerSlidingTabStrip.this.fgH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.fgI.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.fgJ.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fZR = 0.0f;
                    PagerSlidingTabStrip.this.bsw = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fZT = PagerSlidingTabStrip.this.fgJ.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fZT;
                    PagerSlidingTabStrip.this.fZS = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.fgH != null) {
                    PagerSlidingTabStrip.this.fgH.onPageScrollStateChanged(i);
                }
                HomePageStatic.kbg = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.fgH != null) {
                PagerSlidingTabStrip.this.fgH.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.bsw) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fZR * PagerSlidingTabStrip.this.fgI.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fZT = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fZS = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.acR;
        this.fZS = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.acR = this.mCurrentTabIndex;
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
            /* renamed from: BN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int acR;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.acR = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.acR);
        }
    }

    public View BM(int i) {
        return this.fgI.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fZW = i;
    }

    public void setHotTopicIndex(int i) {
        this.kfZ = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.kge = aVar;
    }
}
