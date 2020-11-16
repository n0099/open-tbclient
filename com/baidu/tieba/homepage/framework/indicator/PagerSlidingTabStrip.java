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
/* loaded from: classes21.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private RectF GD;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams eQH;
    private LinearLayout.LayoutParams eQI;
    public ViewPager.OnPageChangeListener eQK;
    private LinearLayout eQL;
    private ViewPager eQM;
    private int eQN;
    private Paint eQP;
    private boolean eQQ;
    private int eQR;
    private int eQS;
    private int eQZ;
    private int eRa;
    private int fJD;
    private int fJE;
    private int fJF;
    private int fJG;
    private int fJJ;
    private int fJK;
    private int fJL;
    private float fJM;
    private float fJN;
    private int fJQ;
    private int fJR;
    private int fJS;
    private boolean fJT;
    private boolean fJZ;
    private float fJt;
    private int fJu;
    private int fJv;
    private Paint fJw;
    private RectF fJx;
    private int fJy;
    private boolean isLoading;
    private final b jzS;
    private boolean jzT;
    private int jzU;
    private int jzV;
    private int jzW;
    private int jzX;
    private int jzY;
    private a jzZ;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes21.dex */
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
        this.jzS = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fJt = 0.0f;
        this.fJu = 0;
        this.fJv = 0;
        this.eQQ = false;
        this.jzV = R.color.CAM_X0105;
        this.jzW = R.color.CAM_X0105;
        this.jzX = R.color.CAM_X0302;
        this.eQR = ap.getColor(this.jzV);
        this.eQS = ap.getColor(this.jzW);
        this.fJD = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fJJ = 17;
        this.fJK = 17;
        this.eQZ = 0;
        this.eRa = R.drawable.pager_sliding_view;
        this.fJT = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.eQL = new LinearLayout(getContext());
        this.eQL.setOrientation(0);
        this.eQL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.eQL);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fJD = (int) TypedValue.applyDimension(1, this.fJD, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fJJ = i;
        this.fJK = i2;
        this.fJL = l.getDimens(getContext(), R.dimen.tbds46);
        this.fJM = (this.fJK * 1.0f) / this.fJJ;
        this.fJN = (this.fJL * 1.0f) / this.fJJ;
        this.jzY = -l.getDimens(getContext(), R.dimen.tbds11);
        this.mIndicatorHeight = i3;
        this.eQQ = z;
        this.eQP = new Paint();
        this.eQP.setAntiAlias(true);
        this.eQP.setStyle(Paint.Style.FILL);
        this.eQP.setColor(ap.getColor(R.color.CAM_X0302));
        this.fJw = new Paint();
        this.fJw.setAntiAlias(true);
        this.fJw.setStyle(Paint.Style.FILL);
        this.fJw.setColor(ap.getColor(R.color.CAM_X0301));
        setLayerType(1, null);
        this.fJx = new RectF();
        this.fJQ = l.getDimens(getContext(), R.dimen.tbds20);
        this.fJR = (int) (l.getDimens(getContext(), R.dimen.tbds28) * 0.5d);
        this.fJS = (int) (l.getDimens(getContext(), R.dimen.tbds22) * 0.4d);
        this.eQH = new LinearLayout.LayoutParams(-2, -1);
        this.eQI = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fJF = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) + Math.round(i * 0.5f);
        this.fJE = l.getDimens(getContext(), R.dimen.tbds5);
        this.fJG = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eQI = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fJZ = z;
        invalidate();
    }

    public boolean cJe() {
        return this.fJZ;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.jzT = z;
        invalidate();
    }

    public boolean cJf() {
        return this.jzT;
    }

    public void setTabItemClicked(boolean z) {
        this.fJT = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eQM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.jzS);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eQK = onPageChangeListener;
    }

    public void bgA() {
        if (this.eQM != null && this.eQM.getAdapter() != null && this.eQM.getAdapter().getCount() != 0) {
            this.eQL.removeAllViews();
            this.eQN = this.eQM.getAdapter().getCount();
            for (int i = 0; i < this.eQN; i++) {
                aD(i, this.eQM.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
        }
    }

    public void notifyDataSetChanged() {
        if (this.eQM != null && this.eQM.getAdapter() != null && this.eQM.getAdapter().getCount() != 0) {
            this.eQL.removeAllViews();
            this.eQN = this.eQM.getAdapter().getCount();
            for (int i = 0; i < this.eQN; i++) {
                aD(i, this.eQM.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.eQM.getCurrentItem();
                    PagerSlidingTabStrip.this.fJu = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aD(int i, String str) {
        String string;
        if (d.bhv() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.fJJ);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            imageView.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_unfold16, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.jzY;
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        EMTextView eMTextView = new EMTextView(getContext());
        if (i == 0) {
            if (d.bhv() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        eMTextView.setTextSize(0, this.fJJ);
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
                    if (PagerSlidingTabStrip.this.jzZ != null) {
                        PagerSlidingTabStrip.this.jzZ.q(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.eQM.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.bhv()) {
                        if (PagerSlidingTabStrip.this.eQM.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new ar(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).ak("obj_locate", i + 1).dR("obj_type", "1"));
                        PagerSlidingTabStrip.this.fJT = true;
                        if (PagerSlidingTabStrip.this.eQM.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.eQM.getAdapter()).BW(i);
                        }
                        PagerSlidingTabStrip.this.eQM.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.bhv()) {
            this.eQL.addView(view, i, this.eQH);
        } else {
            this.eQL.addView(view, i, this.eQQ ? this.eQI : this.eQH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eQN != 0) {
            int left = this.eQL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fJD;
            }
            if (left != this.eQZ) {
                this.eQZ = left;
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
        if (!isInEditMode() && this.eQN != 0) {
            View childAt = this.eQL.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fJF;
            float right2 = childAt.getRight() - this.fJF;
            if ((childAt instanceof LinearLayout) && (((LinearLayout) childAt).getChildAt(0) instanceof TextView)) {
                float left2 = (childAt.getLeft() + childAt.getRight()) / 2.0f;
                float b2 = b(left2, childAt);
                float c = c(left2, childAt);
                right2 = b2;
                left = c;
            }
            if (this.fJt > 0.0f && this.mCurrentTabIndex != this.fJu && this.fJu <= this.eQN - 1 && this.fJu >= 0) {
                View childAt2 = this.eQL.getChildAt(this.fJu);
                float left3 = childAt2.getLeft() + this.fJF;
                float right3 = childAt2.getRight() - this.fJF;
                if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                    float left4 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                    f = b(left4, childAt2);
                    f2 = c(left4, childAt2);
                } else {
                    f = right3;
                    f2 = left3;
                }
                left = e(left, f2, this.fJt);
                right2 = f(right2, f, this.fJt);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left, (height - this.mIndicatorHeight) - this.fJE, right2, height - this.fJE);
            } else {
                this.GD.set(left, (height - this.mIndicatorHeight) - this.fJE, right2, height - this.fJE);
            }
            canvas.drawRoundRect(this.GD, this.mIndicatorHeight * 0.5f, this.mIndicatorHeight * 0.5f, this.eQP);
            if (this.jzT) {
                View childAt3 = this.eQL.getChildAt(this.jzU);
                this.fJx.set((childAt3.getRight() - this.fJS) - this.fJQ, childAt3.getTop() + this.fJR, right + this.fJQ, top + this.fJQ);
                canvas.drawOval(this.fJx, this.fJw);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fJG + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fJG + f2) - ((this.fJG * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fJG + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fJG) + ((this.fJG * (0.2f - f3)) / 0.2f);
        }
    }

    private float b(float f, View view) {
        return (((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f) + f) - this.fJF;
    }

    private float c(float f, View view) {
        return (f - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2)) / 2.0f)) + this.fJF;
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.eQR = ap.getColor(this.jzV);
            this.eQS = ap.getColor(this.jzW);
            this.eQP.setColor(ap.getColor(this.jzX));
            this.fJw.setColor(ap.getColor(R.color.CAM_X0301));
            updateTabStyles();
            invalidate();
        }
    }

    private float ap(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fJN - 1.0f) / (0.1f - 1.0f))) + this.fJN;
        }
        return (((this.fJN - this.fJM) / 0.1f) * f) + this.fJM;
    }

    private float aq(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fJN) / (0.1f - 0.9f)));
        }
        return (((this.fJN - this.fJM) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fJN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float aq;
        float f = this.fJt;
        float f2 = this.fJu < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eQN) {
            View childAt = this.eQL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eRa);
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
                        aq = ap(f2);
                    } else {
                        aq = i == this.fJu ? aq(f2) : 1.0f;
                    }
                    textView.setScaleX(aq);
                    textView.setScaleY(aq);
                    if (f2 >= 0.5f) {
                        if (i == this.fJu) {
                            textView.setTextColor(this.eQR);
                        } else {
                            textView.setTextColor(this.eQS);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.eQR);
                    } else {
                        textView.setTextColor(this.eQS);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fJu) {
                            c.bj(textView).oV(R.string.F_X02);
                        } else {
                            c.bj(textView).oV(R.string.F_X01);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        c.bj(textView).oV(R.string.F_X02);
                    } else {
                        c.bj(textView).oV(R.string.F_X01);
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes21.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.eQL.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.fJT) {
                    if (i == PagerSlidingTabStrip.this.fJv) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fJu = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fJv) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fJu = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fJu = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fJv = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fJu = i;
                    }
                    PagerSlidingTabStrip.this.fJt = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eQL.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.eQK != null) {
                    PagerSlidingTabStrip.this.eQK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.eQL.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.eQM.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fJt = 0.0f;
                    PagerSlidingTabStrip.this.fJT = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fJv = PagerSlidingTabStrip.this.eQM.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fJv;
                    PagerSlidingTabStrip.this.fJu = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.eQK != null) {
                    PagerSlidingTabStrip.this.eQK.onPageScrollStateChanged(i);
                }
                HomePageStatic.jvh = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.eQK != null) {
                PagerSlidingTabStrip.this.eQK.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.fJT) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fJt * PagerSlidingTabStrip.this.eQL.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fJv = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fJu = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZV;
        this.fJu = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZV = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
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
            /* renamed from: BY */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZV;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZV = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZV);
        }
    }

    public View BX(int i) {
        return this.eQL.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fJy = i;
    }

    public void setHotTopicIndex(int i) {
        this.jzU = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jzZ = aVar;
    }
}
