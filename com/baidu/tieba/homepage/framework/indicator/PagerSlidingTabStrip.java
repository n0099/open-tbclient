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
    private boolean bnv;
    private int dividerPadding;
    private int dividerWidth;
    private int fWA;
    private boolean fWG;
    private float fWb;
    private int fWc;
    private int fWd;
    private Paint fWe;
    private RectF fWf;
    private int fWg;
    private int fWl;
    private int fWm;
    private int fWn;
    private int fWo;
    private int fWr;
    private int fWs;
    private int fWt;
    private float fWu;
    private float fWv;
    private int fWy;
    private int fWz;
    private LinearLayout.LayoutParams fcQ;
    private LinearLayout.LayoutParams fcR;
    public ViewPager.OnPageChangeListener fcT;
    private LinearLayout fcU;
    private ViewPager fcV;
    private int fcW;
    private Paint fcY;
    private boolean fcZ;
    private int fda;
    private int fdb;
    private int fdm;
    private boolean isLoading;
    private final b jWf;
    private boolean jWg;
    private int jWh;
    private int jWi;
    private int jWj;
    private int jWk;
    private int jWl;
    private a jWm;
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
        this.jWf = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fWb = 0.0f;
        this.fWc = 0;
        this.fWd = 0;
        this.fcZ = false;
        this.jWi = R.color.CAM_X0105;
        this.jWj = R.color.CAM_X0105;
        this.jWk = R.color.CAM_X0302;
        this.fda = ao.getColor(this.jWi);
        this.fdb = ao.getColor(this.jWj);
        this.fWl = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fWr = 17;
        this.fWs = 17;
        this.fdm = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bnv = false;
        this.isLoading = false;
    }

    public void c(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.fcU = new LinearLayout(getContext());
        this.fcU.setOrientation(0);
        this.fcU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.fcU);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fWl = (int) TypedValue.applyDimension(1, this.fWl, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fWr = i;
        this.fWs = i2;
        this.fWt = l.getDimens(getContext(), R.dimen.tbds46);
        this.fWu = (this.fWs * 1.0f) / this.fWr;
        this.fWv = (this.fWt * 1.0f) / this.fWr;
        this.jWl = -l.getDimens(getContext(), R.dimen.tbds11);
        this.mIndicatorHeight = i3;
        this.fcZ = z;
        this.fcY = new Paint();
        this.fcY.setAntiAlias(true);
        this.fcY.setStyle(Paint.Style.FILL);
        this.fcY.setColor(ao.getColor(R.color.CAM_X0302));
        this.fWe = new Paint();
        this.fWe.setAntiAlias(true);
        this.fWe.setStyle(Paint.Style.FILL);
        this.fWe.setColor(ao.getColor(R.color.CAM_X0301));
        setLayerType(1, null);
        this.fWf = new RectF();
        this.fWy = l.getDimens(getContext(), R.dimen.tbds20);
        this.fWz = (int) (l.getDimens(getContext(), R.dimen.tbds28) * 0.5d);
        this.fWA = (int) (l.getDimens(getContext(), R.dimen.tbds22) * 0.4d);
        this.fcQ = new LinearLayout.LayoutParams(-2, -1);
        this.fcR = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fWn = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) + Math.round(i * 0.5f);
        this.fWm = l.getDimens(getContext(), R.dimen.tbds5);
        this.fWo = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fcR = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fWG = z;
        invalidate();
    }

    public boolean cNJ() {
        return this.fWG;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.jWg = z;
        invalidate();
    }

    public boolean cNK() {
        return this.jWg;
    }

    public void setTabItemClicked(boolean z) {
        this.bnv = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fcV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.jWf);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fcT = onPageChangeListener;
    }

    public void KM() {
        if (this.fcV != null && this.fcV.getAdapter() != null && this.fcV.getAdapter().getCount() != 0) {
            this.fcU.removeAllViews();
            this.fcW = this.fcV.getAdapter().getCount();
            for (int i = 0; i < this.fcW; i++) {
                aG(i, this.fcV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fcV != null && this.fcV.getAdapter() != null && this.fcV.getAdapter().getCount() != 0) {
            this.fcU.removeAllViews();
            this.fcW = this.fcV.getAdapter().getCount();
            for (int i = 0; i < this.fcW; i++) {
                aG(i, this.fcV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fcV.getCurrentItem();
                    PagerSlidingTabStrip.this.fWc = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aG(int i, String str) {
        String string;
        if (d.biU() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.fWr);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_unfold16, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.jWl;
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        EMTextView eMTextView = new EMTextView(getContext());
        if (i == 0) {
            if (d.biU() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        eMTextView.setTextSize(0, this.fWr);
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
                    if (PagerSlidingTabStrip.this.jWm != null) {
                        PagerSlidingTabStrip.this.jWm.t(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.fcV.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.biU()) {
                        if (PagerSlidingTabStrip.this.fcV.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).an("obj_locate", i + 1).dW("obj_type", "1"));
                        PagerSlidingTabStrip.this.bnv = true;
                        if (PagerSlidingTabStrip.this.fcV.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.fcV.getAdapter()).Bs(i);
                        }
                        PagerSlidingTabStrip.this.fcV.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.biU()) {
            this.fcU.addView(view, i, this.fcQ);
        } else {
            this.fcU.addView(view, i, this.fcZ ? this.fcR : this.fcQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fcW != 0) {
            int left = this.fcU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fWl;
            }
            if (left != this.fdm) {
                this.fdm = left;
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
        if (!isInEditMode() && this.fcW != 0) {
            View childAt = this.fcU.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fWn;
            float right2 = childAt.getRight() - this.fWn;
            if ((childAt instanceof LinearLayout) && (((LinearLayout) childAt).getChildAt(0) instanceof TextView)) {
                float left2 = (childAt.getLeft() + childAt.getRight()) / 2.0f;
                float a2 = a(left2, childAt);
                float b2 = b(left2, childAt);
                right2 = a2;
                left = b2;
            }
            if (this.fWb > 0.0f && this.mCurrentTabIndex != this.fWc && this.fWc <= this.fcW - 1 && this.fWc >= 0) {
                View childAt2 = this.fcU.getChildAt(this.fWc);
                float left3 = childAt2.getLeft() + this.fWn;
                float right3 = childAt2.getRight() - this.fWn;
                if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                    float left4 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                    f = a(left4, childAt2);
                    f2 = b(left4, childAt2);
                } else {
                    f = right3;
                    f2 = left3;
                }
                left = e(left, f2, this.fWb);
                right2 = f(right2, f, this.fWb);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left, (height - this.mIndicatorHeight) - this.fWm, right2, height - this.fWm);
            } else {
                this.rectF.set(left, (height - this.mIndicatorHeight) - this.fWm, right2, height - this.fWm);
            }
            canvas.drawRoundRect(this.rectF, this.mIndicatorHeight * 0.5f, this.mIndicatorHeight * 0.5f, this.fcY);
            if (this.jWg) {
                View childAt3 = this.fcU.getChildAt(this.jWh);
                this.fWf.set((childAt3.getRight() - this.fWA) - this.fWy, childAt3.getTop() + this.fWz, right + this.fWy, top + this.fWy);
                canvas.drawOval(this.fWf, this.fWe);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fWo + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fWo + f2) - ((this.fWo * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fWo + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fWo) + ((this.fWo * (0.2f - f3)) / 0.2f);
        }
    }

    private float a(float f, View view) {
        return (((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f) + f) - this.fWn;
    }

    private float b(float f, View view) {
        return (f - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f)) + this.fWn;
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.fda = ao.getColor(this.jWi);
            this.fdb = ao.getColor(this.jWj);
            this.fcY.setColor(ao.getColor(this.jWk));
            this.fWe.setColor(ao.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fWv - 1.0f) / (0.1f - 1.0f))) + this.fWv;
        }
        return (((this.fWv - this.fWu) / 0.1f) * f) + this.fWu;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fWv) / (0.1f - 0.9f)));
        }
        return (((this.fWv - this.fWu) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fWv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.fWb;
        float f2 = this.fWc < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.fcW) {
            View childAt = this.fcU.getChildAt(i);
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
                        at = i == this.fWc ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.fWc) {
                            textView.setTextColor(this.fda);
                        } else {
                            textView.setTextColor(this.fdb);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.fda);
                    } else {
                        textView.setTextColor(this.fdb);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fWc) {
                            c.bv(textView).nX(R.string.F_X02);
                        } else {
                            c.bv(textView).nX(R.string.F_X01);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        c.bv(textView).nX(R.string.F_X02);
                    } else {
                        c.bv(textView).nX(R.string.F_X01);
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
            if (PagerSlidingTabStrip.this.fcU.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.bnv) {
                    if (i == PagerSlidingTabStrip.this.fWd) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fWc = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fWd) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fWc = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fWc = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fWd = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fWc = i;
                    }
                    PagerSlidingTabStrip.this.fWb = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fcU.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.fcT != null) {
                    PagerSlidingTabStrip.this.fcT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.fcU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.fcV.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fWb = 0.0f;
                    PagerSlidingTabStrip.this.bnv = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fWd = PagerSlidingTabStrip.this.fcV.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fWd;
                    PagerSlidingTabStrip.this.fWc = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.fcT != null) {
                    PagerSlidingTabStrip.this.fcT.onPageScrollStateChanged(i);
                }
                HomePageStatic.jRo = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.fcT != null) {
                PagerSlidingTabStrip.this.fcT.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.bnv) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fWb * PagerSlidingTabStrip.this.fcU.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fWd = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fWc = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.abA;
        this.fWc = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abA = this.mCurrentTabIndex;
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
            /* renamed from: Bu */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abA;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abA = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abA);
        }
    }

    public View Bt(int i) {
        return this.fcU.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fWg = i;
    }

    public void setHotTopicIndex(int i) {
        this.jWh = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jWm = aVar;
    }
}
