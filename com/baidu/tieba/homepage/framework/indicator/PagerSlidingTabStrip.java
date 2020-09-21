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
/* loaded from: classes21.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private RectF Gl;
    private int dividerPadding;
    private int dividerWidth;
    private int erB;
    private int erC;
    private LinearLayout.LayoutParams eri;
    private LinearLayout.LayoutParams erj;
    public ViewPager.OnPageChangeListener erl;
    private LinearLayout erm;
    private ViewPager ern;
    private int ero;
    private Paint erq;
    private boolean ers;
    private int ert;
    private int eru;
    private int fjB;
    private int fjC;
    private int fjD;
    private int fjE;
    private int fjH;
    private int fjI;
    private int fjJ;
    private float fjK;
    private float fjL;
    private int fjO;
    private int fjP;
    private int fjQ;
    private boolean fjR;
    private boolean fjX;
    private float fjr;
    private int fjs;
    private int fjt;
    private Paint fju;
    private RectF fjv;
    private int fjw;
    private final b iRJ;
    private boolean iRK;
    private int iRL;
    private int iRM;
    private int iRN;
    private int iRO;
    private a iRP;
    private boolean isLoading;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void m(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iRJ = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fjr = 0.0f;
        this.fjs = 0;
        this.fjt = 0;
        this.ers = false;
        this.iRM = R.color.cp_cont_b;
        this.iRN = R.color.cp_cont_j;
        this.iRO = R.color.cp_link_tip_a;
        this.ert = ap.getColor(this.iRM);
        this.eru = ap.getColor(this.iRN);
        this.fjB = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fjH = 17;
        this.fjI = 17;
        this.erB = 0;
        this.erC = R.drawable.pager_sliding_view;
        this.fjR = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.erm = new LinearLayout(getContext());
        this.erm.setOrientation(0);
        this.erm.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.erm);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fjB = (int) TypedValue.applyDimension(1, this.fjB, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fjH = i;
        this.fjI = i2;
        this.fjJ = l.getDimens(getContext(), R.dimen.tbds46);
        this.fjK = (this.fjI * 1.0f) / this.fjH;
        this.fjL = (this.fjJ * 1.0f) / this.fjH;
        this.mIndicatorHeight = i3;
        this.ers = z;
        this.erq = new Paint();
        this.erq.setAntiAlias(true);
        this.erq.setStyle(Paint.Style.FILL);
        this.erq.setColor(ap.getColor(R.color.cp_link_tip_a));
        this.fju = new Paint();
        this.fju.setAntiAlias(true);
        this.fju.setStyle(Paint.Style.FILL);
        this.fju.setColor(ap.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.fju.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
        this.fjv = new RectF();
        this.fjO = l.getDimens(getContext(), R.dimen.tbds20);
        this.fjP = l.getDimens(getContext(), R.dimen.tbds28);
        this.fjQ = l.getDimens(getContext(), R.dimen.tbds22);
        this.eri = new LinearLayout.LayoutParams(-2, -1);
        this.erj = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fjD = l.getDimens(getContext(), R.dimen.tbds62);
        this.fjC = l.getDimens(getContext(), R.dimen.tbds0);
        this.fjE = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.erj = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fjX = z;
        invalidate();
    }

    public boolean cAk() {
        return this.fjX;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.iRK = z;
        invalidate();
    }

    public boolean cAl() {
        return this.iRK;
    }

    public void setTabItemClicked(boolean z) {
        this.fjR = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ern = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.iRJ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.erl = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ern != null && this.ern.getAdapter() != null && this.ern.getAdapter().getCount() != 0) {
            this.erm.removeAllViews();
            this.ero = this.ern.getAdapter().getCount();
            for (int i = 0; i < this.ero; i++) {
                ao(i, this.ern.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.ern.getCurrentItem();
                    PagerSlidingTabStrip.this.fjs = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void ao(int i, String str) {
        String string;
        if (d.bbc() && i == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            TextView textView = new TextView(getContext());
            if (TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_home_concern_all_status", 0) == 1) {
                string = getResources().getString(R.string.attention_person);
            } else {
                string = getResources().getString(R.string.tab_name_concern);
            }
            textView.setText(string);
            textView.setGravity(17);
            textView.setTextSize(0, this.fjH);
            textView.setSingleLine();
            textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds42), 0, 0, 0);
            ImageView imageView = new ImageView(getContext());
            imageView.setVisibility(4);
            SvgManager.bkl().a(imageView, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
            linearLayout.addView(textView);
            linearLayout.addView(imageView);
            linearLayout.setGravity(16);
            d(i, linearLayout);
            return;
        }
        TextView textView2 = new TextView(getContext());
        if (i == 0) {
            if (d.bbc() && TbadkCoreApplication.isLogin() && com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_home_concern_all_status", 0) == 1) {
                str = getResources().getString(R.string.attention_person);
            } else {
                str = getResources().getString(R.string.tab_name_concern);
            }
        }
        textView2.setText(str);
        textView2.setGravity(17);
        textView2.setTextSize(0, this.fjH);
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
                    if (PagerSlidingTabStrip.this.iRP != null) {
                        PagerSlidingTabStrip.this.iRP.m(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.ern.getCurrentItem() != i || i != 0 || !TbadkCoreApplication.isLogin() || !d.bbc()) {
                        if (PagerSlidingTabStrip.this.ern.getCurrentItem() == i) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                            return;
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).ai("obj_locate", i + 1).dF("obj_type", "1"));
                        PagerSlidingTabStrip.this.fjR = true;
                        if (PagerSlidingTabStrip.this.ern.getAdapter() instanceof NewScrollFragmentAdapter) {
                            ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.ern.getAdapter()).Am(i);
                        }
                        PagerSlidingTabStrip.this.ern.setCurrentItem(i);
                        PagerSlidingTabStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
                }
            }
        });
        if (i == 0 && (view instanceof LinearLayout) && d.bbc()) {
            this.erm.addView(view, i, this.eri);
        } else {
            this.erm.addView(view, i, this.ers ? this.erj : this.eri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ero != 0) {
            int left = this.erm.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fjB;
            }
            if (left != this.erB) {
                this.erB = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.ero != 0) {
            View childAt = this.erm.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fjD;
            float right2 = childAt.getRight() - this.fjD;
            if (childAt instanceof LinearLayout) {
                right2 = b(right2, childAt);
                left = c(left, childAt);
            }
            if (this.fjr > 0.0f && this.mCurrentTabIndex != this.fjs && this.fjs <= this.ero - 1 && this.fjs >= 0) {
                View childAt2 = this.erm.getChildAt(this.fjs);
                float left2 = childAt2.getLeft() + this.fjD;
                float right3 = childAt2.getRight() - this.fjD;
                if (childAt2 instanceof LinearLayout) {
                    right3 = b(right3, childAt2);
                    left2 = c(left2, childAt2);
                }
                left = e(left, left2, this.fjr);
                right2 = f(right2, right3, this.fjr);
            }
            int height = getHeight();
            if (this.Gl == null) {
                this.Gl = new RectF(left, (height - this.mIndicatorHeight) - this.fjC, right2, height - this.fjC);
            } else {
                this.Gl.set(left, (height - this.mIndicatorHeight) - this.fjC, right2, height - this.fjC);
            }
            canvas.drawRoundRect(this.Gl, 16.0f, 16.0f, this.erq);
            if (this.iRK) {
                View childAt3 = this.erm.getChildAt(this.iRL);
                this.fjv.set((childAt3.getRight() - this.fjQ) - this.fjO, childAt3.getTop() + this.fjP, right + this.fjO, top + this.fjO);
                canvas.drawOval(this.fjv, this.fju);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fjE + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fjE + f2) - ((this.fjE * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fjE + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fjE) + ((this.fjE * (0.2f - f3)) / 0.2f);
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
            this.ert = ap.getColor(this.iRM);
            this.eru = ap.getColor(this.iRN);
            this.erq.setColor(ap.getColor(this.iRO));
            this.fju.setColor(ap.getColor(R.color.cp_cont_h));
            this.fju.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float ah(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fjL - 1.0f) / (0.1f - 1.0f))) + this.fjL;
        }
        return (((this.fjL - this.fjK) / 0.1f) * f) + this.fjK;
    }

    private float ai(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fjL) / (0.1f - 0.9f)));
        }
        return (((this.fjL - this.fjK) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fjL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ai;
        float f = this.fjr;
        float f2 = this.fjs < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.ero) {
            View childAt = this.erm.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.erC);
                TextView textView = null;
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                } else if (childAt instanceof LinearLayout) {
                    LinearLayout linearLayout = (LinearLayout) childAt;
                    textView = (TextView) linearLayout.getChildAt(0);
                    if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                        SvgManager.bkl().a((ImageView) linearLayout.getChildAt(1), R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL);
                    }
                }
                if (textView != null) {
                    if (i == this.mCurrentTabIndex) {
                        ai = ah(f2);
                    } else {
                        ai = i == this.fjs ? ai(f2) : 1.0f;
                    }
                    textView.setScaleX(ai);
                    textView.setScaleY(ai);
                    if (f2 >= 0.5f) {
                        if (i == this.fjs) {
                            textView.setTextColor(this.ert);
                        } else {
                            textView.setTextColor(this.eru);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.ert);
                    } else {
                        textView.setTextColor(this.eru);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fjs) {
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

    /* loaded from: classes21.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.erm.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.fjR) {
                    if (i == PagerSlidingTabStrip.this.fjt) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fjs = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fjt) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fjs = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fjs = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fjt = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fjs = i;
                    }
                    PagerSlidingTabStrip.this.fjr = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.erm.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.erl != null) {
                    PagerSlidingTabStrip.this.erl.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.erm.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.ern.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fjr = 0.0f;
                    PagerSlidingTabStrip.this.fjR = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fjt = PagerSlidingTabStrip.this.ern.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fjt;
                    PagerSlidingTabStrip.this.fjs = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.erl != null) {
                    PagerSlidingTabStrip.this.erl.onPageScrollStateChanged(i);
                }
                HomePageStatic.iNq = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.erl != null) {
                PagerSlidingTabStrip.this.erl.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.fjR) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fjr * PagerSlidingTabStrip.this.erm.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fjt = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fjs = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Zz;
        this.fjs = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zz = this.mCurrentTabIndex;
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
            /* renamed from: Ao */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Zz;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zz = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zz);
        }
    }

    public View An(int i) {
        return this.erm.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fjw = i;
    }

    public void setHotTopicIndex(int i) {
        this.iRL = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.iRP = aVar;
    }
}
