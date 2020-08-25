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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes16.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private RectF Gl;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams epa;
    private LinearLayout.LayoutParams epb;
    public ViewPager.OnPageChangeListener epd;
    private LinearLayout epe;
    private ViewPager epf;
    private int epg;
    private Paint epi;
    private boolean epj;
    private int epk;
    private int epl;
    private int eps;
    private int ept;
    private int fgD;
    private int fgE;
    private int fgF;
    private int fgG;
    private int fgJ;
    private int fgK;
    private int fgL;
    private float fgM;
    private float fgN;
    private int fgQ;
    private int fgR;
    private int fgS;
    private boolean fgT;
    private boolean fgZ;
    private float fgt;
    private int fgu;
    private int fgv;
    private Paint fgw;
    private RectF fgx;
    private int fgy;
    private final b iJd;
    private boolean iJe;
    private int iJf;
    private int iJg;
    private int iJh;
    private int iJi;
    private a iJj;
    private boolean isLoading;
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
        this.iJd = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fgt = 0.0f;
        this.fgu = 0;
        this.fgv = 0;
        this.epj = false;
        this.iJg = R.color.cp_cont_b;
        this.iJh = R.color.cp_cont_j;
        this.iJi = R.color.cp_link_tip_a;
        this.epk = ap.getColor(this.iJg);
        this.epl = ap.getColor(this.iJh);
        this.fgD = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fgJ = 17;
        this.fgK = 17;
        this.eps = 0;
        this.ept = R.drawable.pager_sliding_view;
        this.fgT = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.epe = new LinearLayout(getContext());
        this.epe.setOrientation(0);
        this.epe.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.epe);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fgD = (int) TypedValue.applyDimension(1, this.fgD, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fgJ = i;
        this.fgK = i2;
        this.fgL = l.getDimens(getContext(), R.dimen.tbds46);
        this.fgM = (this.fgK * 1.0f) / this.fgJ;
        this.fgN = (this.fgL * 1.0f) / this.fgJ;
        this.mIndicatorHeight = i3;
        this.epj = z;
        this.epi = new Paint();
        this.epi.setAntiAlias(true);
        this.epi.setStyle(Paint.Style.FILL);
        this.epi.setColor(ap.getColor(R.color.cp_link_tip_a));
        this.fgw = new Paint();
        this.fgw.setAntiAlias(true);
        this.fgw.setStyle(Paint.Style.FILL);
        this.fgw.setColor(ap.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.fgw.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
        this.fgx = new RectF();
        this.fgQ = l.getDimens(getContext(), R.dimen.tbds20);
        this.fgR = l.getDimens(getContext(), R.dimen.tbds28);
        this.fgS = l.getDimens(getContext(), R.dimen.tbds22);
        this.epa = new LinearLayout.LayoutParams(-2, -1);
        this.epb = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fgF = l.getDimens(getContext(), R.dimen.tbds62);
        this.fgE = l.getDimens(getContext(), R.dimen.tbds0);
        this.fgG = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.epb = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fgZ = z;
        invalidate();
    }

    public boolean cwC() {
        return this.fgZ;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.iJe = z;
        invalidate();
    }

    public boolean cwD() {
        return this.iJe;
    }

    public void setTabItemClicked(boolean z) {
        this.fgT = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.epf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.iJd);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.epd = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.epf != null && this.epf.getAdapter() != null && this.epf.getAdapter().getCount() != 0) {
            this.epe.removeAllViews();
            this.epg = this.epf.getAdapter().getCount();
            for (int i = 0; i < this.epg; i++) {
                an(i, this.epf.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.epf.getCurrentItem();
                    PagerSlidingTabStrip.this.fgu = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void an(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.fgJ);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.iJj != null) {
                        PagerSlidingTabStrip.this.iJj.l(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.epf.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).ai("obj_locate", i + 1).dD("obj_type", "1"));
                    PagerSlidingTabStrip.this.fgT = true;
                    if (PagerSlidingTabStrip.this.epf.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.epf.getAdapter()).zL(i);
                    }
                    PagerSlidingTabStrip.this.epf.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.epe.addView(view, i, this.epj ? this.epb : this.epa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.epg != 0) {
            int left = this.epe.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fgD;
            }
            if (left != this.eps) {
                this.eps = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.epg != 0) {
            View childAt = this.epe.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fgF;
            float right2 = childAt.getRight() - this.fgF;
            if (this.fgt > 0.0f && this.mCurrentTabIndex != this.fgu && this.fgu <= this.epg - 1 && this.fgu >= 0) {
                View childAt2 = this.epe.getChildAt(this.fgu);
                left = e(left, childAt2.getLeft() + this.fgF, this.fgt);
                right2 = f(right2, childAt2.getRight() - this.fgF, this.fgt);
            }
            int height = getHeight();
            if (this.Gl == null) {
                this.Gl = new RectF(left, (height - this.mIndicatorHeight) - this.fgE, right2, height - this.fgE);
            } else {
                this.Gl.set(left, (height - this.mIndicatorHeight) - this.fgE, right2, height - this.fgE);
            }
            canvas.drawRoundRect(this.Gl, 16.0f, 16.0f, this.epi);
            if (this.iJe) {
                View childAt3 = this.epe.getChildAt(this.iJf);
                this.fgx.set((childAt3.getRight() - this.fgS) - this.fgQ, childAt3.getTop() + this.fgR, right + this.fgQ, top + this.fgQ);
                canvas.drawOval(this.fgx, this.fgw);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fgG + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fgG + f2) - ((this.fgG * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fgG + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fgG) + ((this.fgG * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.epk = ap.getColor(this.iJg);
            this.epl = ap.getColor(this.iJh);
            this.epi.setColor(ap.getColor(this.iJi));
            this.fgw.setColor(ap.getColor(R.color.cp_cont_h));
            this.fgw.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float ah(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fgN - 1.0f) / (0.1f - 1.0f))) + this.fgN;
        }
        return (((this.fgN - this.fgM) / 0.1f) * f) + this.fgM;
    }

    private float ai(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fgN) / (0.1f - 0.9f)));
        }
        return (((this.fgN - this.fgM) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fgN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ai;
        float f = this.fgt;
        float f2 = this.fgu < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.epg) {
            View childAt = this.epe.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ept);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ai = ah(f2);
                    } else {
                        ai = i == this.fgu ? ai(f2) : 1.0f;
                    }
                    textView.setScaleX(ai);
                    textView.setScaleY(ai);
                    if (f2 >= 0.5f) {
                        if (i == this.fgu) {
                            textView.setTextColor(this.epk);
                        } else {
                            textView.setTextColor(this.epl);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.epk);
                    } else {
                        textView.setTextColor(this.epl);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fgu) {
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
            if (PagerSlidingTabStrip.this.epe.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.fgT) {
                    if (i == PagerSlidingTabStrip.this.fgv) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fgu = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fgv) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fgu = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fgu = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fgv = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fgu = i;
                    }
                    PagerSlidingTabStrip.this.fgt = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.epe.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.epd != null) {
                    PagerSlidingTabStrip.this.epd.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.epe.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.epf.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fgt = 0.0f;
                    PagerSlidingTabStrip.this.fgT = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fgv = PagerSlidingTabStrip.this.epf.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fgv;
                    PagerSlidingTabStrip.this.fgu = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.epd != null) {
                    PagerSlidingTabStrip.this.epd.onPageScrollStateChanged(i);
                }
                HomePageStatic.iFP = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.epd != null) {
                PagerSlidingTabStrip.this.epd.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.fgT) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fgt * PagerSlidingTabStrip.this.epe.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fgv = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fgu = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Zf;
        this.fgu = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zf = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
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
            /* renamed from: zN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Zf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zf);
        }
    }

    public View zM(int i) {
        return this.epe.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fgy = i;
    }

    public void setHotTopicIndex(int i) {
        this.iJf = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.iJj = aVar;
    }
}
