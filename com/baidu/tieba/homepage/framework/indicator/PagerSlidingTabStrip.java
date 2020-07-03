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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes9.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private RectF FG;
    private int dXd;
    private int dZG;
    private int dZH;
    private LinearLayout.LayoutParams dZn;
    private LinearLayout.LayoutParams dZo;
    public ViewPager.OnPageChangeListener dZq;
    private LinearLayout dZr;
    private ViewPager dZs;
    private int dZt;
    private Paint dZv;
    private boolean dZw;
    private int dZx;
    private int dividerPadding;
    private int ePA;
    private int ePB;
    private int ePC;
    private int ePD;
    private int ePG;
    private int ePH;
    private int ePI;
    private float ePJ;
    private float ePK;
    private int ePN;
    private int ePO;
    private int ePP;
    private boolean ePQ;
    private boolean ePW;
    private float ePq;
    private int ePr;
    private int ePs;
    private Paint ePt;
    private RectF ePu;
    private int ePv;
    private int ebT;
    private final b ioK;
    private int ioL;
    private int ioM;
    private int ioN;
    private a ioO;
    private boolean isLoading;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void k(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ioK = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.ePq = 0.0f;
        this.ePr = 0;
        this.ePs = 0;
        this.dZw = false;
        this.ioL = R.color.cp_cont_b;
        this.ioM = R.color.cp_cont_j;
        this.ioN = R.color.cp_link_tip_a;
        this.dZx = an.getColor(this.ioL);
        this.dXd = an.getColor(this.ioM);
        this.ePA = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.ebT = 1;
        this.ePG = 17;
        this.ePH = 17;
        this.dZG = 0;
        this.dZH = R.drawable.pager_sliding_view;
        this.ePQ = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dZr = new LinearLayout(getContext());
        this.dZr.setOrientation(0);
        this.dZr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dZr);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ePA = (int) TypedValue.applyDimension(1, this.ePA, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.ebT = (int) TypedValue.applyDimension(1, this.ebT, displayMetrics);
        this.ePG = i;
        this.ePH = i2;
        this.ePI = l.getDimens(getContext(), R.dimen.tbds46);
        this.ePJ = (this.ePH * 1.0f) / this.ePG;
        this.ePK = (this.ePI * 1.0f) / this.ePG;
        this.mIndicatorHeight = i3;
        this.dZw = z;
        this.dZv = new Paint();
        this.dZv.setAntiAlias(true);
        this.dZv.setStyle(Paint.Style.FILL);
        this.dZv.setColor(an.getColor(R.color.cp_link_tip_a));
        this.ePt = new Paint();
        this.ePt.setAntiAlias(true);
        this.ePt.setStyle(Paint.Style.FILL);
        this.ePt.setColor(an.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.ePt.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), an.getColor(R.color.cp_cont_h_alpha66));
        this.ePu = new RectF();
        this.ePN = l.getDimens(getContext(), R.dimen.tbds20);
        this.ePO = l.getDimens(getContext(), R.dimen.tbds28);
        this.ePP = l.getDimens(getContext(), R.dimen.tbds22);
        this.dZn = new LinearLayout.LayoutParams(-2, -1);
        this.dZo = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.ePC = l.getDimens(getContext(), R.dimen.tbds62);
        this.ePB = l.getDimens(getContext(), R.dimen.tbds0);
        this.ePD = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dZo = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.ePW = z;
        invalidate();
    }

    public boolean cit() {
        return this.ePW;
    }

    public void setTabItemClicked(boolean z) {
        this.ePQ = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dZs = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ioK);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dZq = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dZs != null && this.dZs.getAdapter() != null && this.dZs.getAdapter().getCount() != 0) {
            this.dZr.removeAllViews();
            this.dZt = this.dZs.getAdapter().getCount();
            for (int i = 0; i < this.dZt; i++) {
                ao(i, this.dZs.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dZs.getCurrentItem();
                    PagerSlidingTabStrip.this.ePr = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void ao(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.ePG);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.ioO != null) {
                        PagerSlidingTabStrip.this.ioO.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.dZs.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ao(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).ag("obj_locate", i + 1).dk("obj_type", "1"));
                    PagerSlidingTabStrip.this.ePQ = true;
                    if (PagerSlidingTabStrip.this.dZs.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.dZs.getAdapter()).wZ(i);
                    }
                    PagerSlidingTabStrip.this.dZs.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.dZr.addView(view, i, this.dZw ? this.dZo : this.dZn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dZt != 0) {
            int left = this.dZr.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ePA;
            }
            if (left != this.dZG) {
                this.dZG = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dZt != 0) {
            View childAt = this.dZr.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.ePC;
            float right2 = childAt.getRight() - this.ePC;
            if (this.ePq > 0.0f && this.mCurrentTabIndex != this.ePr && this.ePr <= this.dZt - 1 && this.ePr >= 0) {
                View childAt2 = this.dZr.getChildAt(this.ePr);
                left = e(left, childAt2.getLeft() + this.ePC, this.ePq);
                right2 = f(right2, childAt2.getRight() - this.ePC, this.ePq);
            }
            int height = getHeight();
            if (this.FG == null) {
                this.FG = new RectF(left, (height - this.mIndicatorHeight) - this.ePB, right2, height - this.ePB);
            } else {
                this.FG.set(left, (height - this.mIndicatorHeight) - this.ePB, right2, height - this.ePB);
            }
            canvas.drawRoundRect(this.FG, 16.0f, 16.0f, this.dZv);
            if (this.ePW) {
                View childAt3 = this.dZr.getChildAt(this.ePv);
                this.ePu.set((childAt3.getRight() - this.ePP) - this.ePN, childAt3.getTop() + this.ePO, right + this.ePN, top2 + this.ePN);
                canvas.drawOval(this.ePu, this.ePt);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.ePD + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.ePD + f2) - ((this.ePD * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.ePD + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.ePD) + ((this.ePD * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dZx = an.getColor(this.ioL);
            this.dXd = an.getColor(this.ioM);
            this.dZv.setColor(an.getColor(this.ioN));
            this.ePt.setColor(an.getColor(R.color.cp_cont_h));
            this.ePt.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), an.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.ePK - 1.0f) / (0.1f - 1.0f))) + this.ePK;
        }
        return (((this.ePK - this.ePJ) / 0.1f) * f) + this.ePJ;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.ePK) / (0.1f - 0.9f)));
        }
        return (((this.ePK - this.ePJ) / (0.9f - 1.0f)) * (f - 0.9f)) + this.ePK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.ePq;
        float f2 = this.ePr < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dZt) {
            View childAt = this.dZr.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dZH);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.ePr ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (f2 >= 0.5f) {
                        if (i == this.ePr) {
                            textView.setTextColor(this.dZx);
                        } else {
                            textView.setTextColor(this.dXd);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dZx);
                    } else {
                        textView.setTextColor(this.dXd);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.ePr) {
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

    /* loaded from: classes9.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dZr.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.ePQ) {
                    if (i == PagerSlidingTabStrip.this.ePs) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.ePr = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.ePs) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.ePr = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.ePr = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.ePs = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.ePr = i;
                    }
                    PagerSlidingTabStrip.this.ePq = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dZr.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dZq != null) {
                    PagerSlidingTabStrip.this.dZq.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dZr.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dZs.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.ePq = 0.0f;
                    PagerSlidingTabStrip.this.ePQ = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.ePs = PagerSlidingTabStrip.this.dZs.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.ePs;
                    PagerSlidingTabStrip.this.ePr = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.dZq != null) {
                    PagerSlidingTabStrip.this.dZq.onPageScrollStateChanged(i);
                }
                HomePageStatic.ilv = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dZq != null) {
                PagerSlidingTabStrip.this.dZq.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.ePQ) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.ePq * PagerSlidingTabStrip.this.dZr.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.ePs = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.ePr = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.YJ;
        this.ePr = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.YJ = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: U */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: xb */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int YJ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.YJ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.YJ);
        }
    }

    public View xa(int i) {
        return this.dZr.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.ePv = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ioO = aVar;
    }
}
