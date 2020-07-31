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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes16.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private RectF FG;
    private int dividerPadding;
    private int dividerWidth;
    private float eVL;
    private int eVM;
    private int eVN;
    private Paint eVO;
    private RectF eVP;
    private int eVQ;
    private int eVV;
    private int eVW;
    private int eVX;
    private int eVY;
    private int eWb;
    private int eWc;
    private int eWd;
    private float eWe;
    private float eWf;
    private int eWi;
    private int eWj;
    private int eWk;
    private boolean eWl;
    private boolean eWr;
    private int edx;
    private LinearLayout.LayoutParams efA;
    private LinearLayout.LayoutParams efB;
    public ViewPager.OnPageChangeListener efD;
    private LinearLayout efE;
    private ViewPager efF;
    private int efG;
    private Paint efI;
    private boolean efJ;
    private int efK;
    private int efR;
    private int efS;
    private boolean isLoading;
    private final b iuM;
    private boolean iuN;
    private int iuO;
    private int iuP;
    private int iuQ;
    private int iuR;
    private a iuS;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes16.dex */
    public interface a {
        void l(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iuM = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eVL = 0.0f;
        this.eVM = 0;
        this.eVN = 0;
        this.efJ = false;
        this.iuP = R.color.cp_cont_b;
        this.iuQ = R.color.cp_cont_j;
        this.iuR = R.color.cp_link_tip_a;
        this.efK = ao.getColor(this.iuP);
        this.edx = ao.getColor(this.iuQ);
        this.eVV = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.eWb = 17;
        this.eWc = 17;
        this.efR = 0;
        this.efS = R.drawable.pager_sliding_view;
        this.eWl = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.efE = new LinearLayout(getContext());
        this.efE.setOrientation(0);
        this.efE.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.efE);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eVV = (int) TypedValue.applyDimension(1, this.eVV, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.eWb = i;
        this.eWc = i2;
        this.eWd = l.getDimens(getContext(), R.dimen.tbds46);
        this.eWe = (this.eWc * 1.0f) / this.eWb;
        this.eWf = (this.eWd * 1.0f) / this.eWb;
        this.mIndicatorHeight = i3;
        this.efJ = z;
        this.efI = new Paint();
        this.efI.setAntiAlias(true);
        this.efI.setStyle(Paint.Style.FILL);
        this.efI.setColor(ao.getColor(R.color.cp_link_tip_a));
        this.eVO = new Paint();
        this.eVO.setAntiAlias(true);
        this.eVO.setStyle(Paint.Style.FILL);
        this.eVO.setColor(ao.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.eVO.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ao.getColor(R.color.cp_cont_h_alpha66));
        this.eVP = new RectF();
        this.eWi = l.getDimens(getContext(), R.dimen.tbds20);
        this.eWj = l.getDimens(getContext(), R.dimen.tbds28);
        this.eWk = l.getDimens(getContext(), R.dimen.tbds22);
        this.efA = new LinearLayout.LayoutParams(-2, -1);
        this.efB = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.eVX = l.getDimens(getContext(), R.dimen.tbds62);
        this.eVW = l.getDimens(getContext(), R.dimen.tbds0);
        this.eVY = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.efB = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.eWr = z;
        invalidate();
    }

    public boolean clT() {
        return this.eWr;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.iuN = z;
        invalidate();
    }

    public boolean clU() {
        return this.iuN;
    }

    public void setTabItemClicked(boolean z) {
        this.eWl = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.efF = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.iuM);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.efD = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.efF != null && this.efF.getAdapter() != null && this.efF.getAdapter().getCount() != 0) {
            this.efE.removeAllViews();
            this.efG = this.efF.getAdapter().getCount();
            for (int i = 0; i < this.efG; i++) {
                ap(i, this.efF.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.efF.getCurrentItem();
                    PagerSlidingTabStrip.this.eVM = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void ap(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.eWb);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.iuS != null) {
                        PagerSlidingTabStrip.this.iuS.l(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.efF.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ap(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).ah("obj_locate", i + 1).dn("obj_type", "1"));
                    PagerSlidingTabStrip.this.eWl = true;
                    if (PagerSlidingTabStrip.this.efF.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.efF.getAdapter()).xr(i);
                    }
                    PagerSlidingTabStrip.this.efF.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.efE.addView(view, i, this.efJ ? this.efB : this.efA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.efG != 0) {
            int left = this.efE.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eVV;
            }
            if (left != this.efR) {
                this.efR = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.efG != 0) {
            View childAt = this.efE.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.eVX;
            float right2 = childAt.getRight() - this.eVX;
            if (this.eVL > 0.0f && this.mCurrentTabIndex != this.eVM && this.eVM <= this.efG - 1 && this.eVM >= 0) {
                View childAt2 = this.efE.getChildAt(this.eVM);
                left = e(left, childAt2.getLeft() + this.eVX, this.eVL);
                right2 = f(right2, childAt2.getRight() - this.eVX, this.eVL);
            }
            int height = getHeight();
            if (this.FG == null) {
                this.FG = new RectF(left, (height - this.mIndicatorHeight) - this.eVW, right2, height - this.eVW);
            } else {
                this.FG.set(left, (height - this.mIndicatorHeight) - this.eVW, right2, height - this.eVW);
            }
            canvas.drawRoundRect(this.FG, 16.0f, 16.0f, this.efI);
            if (this.iuN) {
                View childAt3 = this.efE.getChildAt(this.iuO);
                this.eVP.set((childAt3.getRight() - this.eWk) - this.eWi, childAt3.getTop() + this.eWj, right + this.eWi, top + this.eWi);
                canvas.drawOval(this.eVP, this.eVO);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.eVY + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.eVY + f2) - ((this.eVY * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.eVY + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.eVY) + ((this.eVY * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.efK = ao.getColor(this.iuP);
            this.edx = ao.getColor(this.iuQ);
            this.efI.setColor(ao.getColor(this.iuR));
            this.eVO.setColor(ao.getColor(R.color.cp_cont_h));
            this.eVO.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ao.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eWf - 1.0f) / (0.1f - 1.0f))) + this.eWf;
        }
        return (((this.eWf - this.eWe) / 0.1f) * f) + this.eWe;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eWf) / (0.1f - 0.9f)));
        }
        return (((this.eWf - this.eWe) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eWf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.eVL;
        float f2 = this.eVM < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.efG) {
            View childAt = this.efE.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.efS);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.eVM ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (f2 >= 0.5f) {
                        if (i == this.eVM) {
                            textView.setTextColor(this.efK);
                        } else {
                            textView.setTextColor(this.edx);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.efK);
                    } else {
                        textView.setTextColor(this.edx);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.eVM) {
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

    /* loaded from: classes16.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.efE.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.eWl) {
                    if (i == PagerSlidingTabStrip.this.eVN) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eVM = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.eVN) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eVM = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.eVM = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.eVN = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eVM = i;
                    }
                    PagerSlidingTabStrip.this.eVL = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.efE.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.efD != null) {
                    PagerSlidingTabStrip.this.efD.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.efE.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.efF.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.eVL = 0.0f;
                    PagerSlidingTabStrip.this.eWl = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.eVN = PagerSlidingTabStrip.this.efF.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.eVN;
                    PagerSlidingTabStrip.this.eVM = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.efD != null) {
                    PagerSlidingTabStrip.this.efD.onPageScrollStateChanged(i);
                }
                HomePageStatic.iry = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.efD != null) {
                PagerSlidingTabStrip.this.efD.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.eWl) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eVL * PagerSlidingTabStrip.this.efE.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.eVN = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.eVM = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Yz;
        this.eVM = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Yz = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: W */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: xt */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Yz;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Yz = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Yz);
        }
    }

    public View xs(int i) {
        return this.efE.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.eVQ = i;
    }

    public void setHotTopicIndex(int i) {
        this.iuO = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.iuS = aVar;
    }
}
