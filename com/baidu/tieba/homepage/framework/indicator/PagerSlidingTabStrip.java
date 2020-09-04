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
    private LinearLayout.LayoutParams epe;
    private LinearLayout.LayoutParams epf;
    public ViewPager.OnPageChangeListener eph;
    private LinearLayout epi;
    private ViewPager epj;
    private int epk;
    private Paint epm;
    private boolean epn;
    private int epo;
    private int epp;
    private int epw;
    private int epx;
    private Paint fgA;
    private RectF fgB;
    private int fgC;
    private int fgH;
    private int fgI;
    private int fgJ;
    private int fgK;
    private int fgN;
    private int fgO;
    private int fgP;
    private float fgQ;
    private float fgR;
    private int fgU;
    private int fgV;
    private int fgW;
    private boolean fgX;
    private float fgx;
    private int fgy;
    private int fgz;
    private boolean fhd;
    private final b iJj;
    private boolean iJk;
    private int iJl;
    private int iJm;
    private int iJn;
    private int iJo;
    private a iJp;
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
        this.iJj = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fgx = 0.0f;
        this.fgy = 0;
        this.fgz = 0;
        this.epn = false;
        this.iJm = R.color.cp_cont_b;
        this.iJn = R.color.cp_cont_j;
        this.iJo = R.color.cp_link_tip_a;
        this.epo = ap.getColor(this.iJm);
        this.epp = ap.getColor(this.iJn);
        this.fgH = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fgN = 17;
        this.fgO = 17;
        this.epw = 0;
        this.epx = R.drawable.pager_sliding_view;
        this.fgX = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.epi = new LinearLayout(getContext());
        this.epi.setOrientation(0);
        this.epi.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.epi);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.fgH = (int) TypedValue.applyDimension(1, this.fgH, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.fgN = i;
        this.fgO = i2;
        this.fgP = l.getDimens(getContext(), R.dimen.tbds46);
        this.fgQ = (this.fgO * 1.0f) / this.fgN;
        this.fgR = (this.fgP * 1.0f) / this.fgN;
        this.mIndicatorHeight = i3;
        this.epn = z;
        this.epm = new Paint();
        this.epm.setAntiAlias(true);
        this.epm.setStyle(Paint.Style.FILL);
        this.epm.setColor(ap.getColor(R.color.cp_link_tip_a));
        this.fgA = new Paint();
        this.fgA.setAntiAlias(true);
        this.fgA.setStyle(Paint.Style.FILL);
        this.fgA.setColor(ap.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.fgA.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
        this.fgB = new RectF();
        this.fgU = l.getDimens(getContext(), R.dimen.tbds20);
        this.fgV = l.getDimens(getContext(), R.dimen.tbds28);
        this.fgW = l.getDimens(getContext(), R.dimen.tbds22);
        this.epe = new LinearLayout.LayoutParams(-2, -1);
        this.epf = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.fgJ = l.getDimens(getContext(), R.dimen.tbds62);
        this.fgI = l.getDimens(getContext(), R.dimen.tbds0);
        this.fgK = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.epf = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fhd = z;
        invalidate();
    }

    public boolean cwD() {
        return this.fhd;
    }

    public void setShowHotTopicRedTip(boolean z) {
        this.iJk = z;
        invalidate();
    }

    public boolean cwE() {
        return this.iJk;
    }

    public void setTabItemClicked(boolean z) {
        this.fgX = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.epj = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.iJj);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eph = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.epj != null && this.epj.getAdapter() != null && this.epj.getAdapter().getCount() != 0) {
            this.epi.removeAllViews();
            this.epk = this.epj.getAdapter().getCount();
            for (int i = 0; i < this.epk; i++) {
                an(i, this.epj.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.epj.getCurrentItem();
                    PagerSlidingTabStrip.this.fgy = PagerSlidingTabStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.fgN);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.iJp != null) {
                        PagerSlidingTabStrip.this.iJp.l(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.epj.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new aq(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).ai("obj_locate", i + 1).dD("obj_type", "1"));
                    PagerSlidingTabStrip.this.fgX = true;
                    if (PagerSlidingTabStrip.this.epj.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.epj.getAdapter()).zL(i);
                    }
                    PagerSlidingTabStrip.this.epj.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.epi.addView(view, i, this.epn ? this.epf : this.epe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.epk != 0) {
            int left = this.epi.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fgH;
            }
            if (left != this.epw) {
                this.epw = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.epk != 0) {
            View childAt = this.epi.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fgJ;
            float right2 = childAt.getRight() - this.fgJ;
            if (this.fgx > 0.0f && this.mCurrentTabIndex != this.fgy && this.fgy <= this.epk - 1 && this.fgy >= 0) {
                View childAt2 = this.epi.getChildAt(this.fgy);
                left = e(left, childAt2.getLeft() + this.fgJ, this.fgx);
                right2 = f(right2, childAt2.getRight() - this.fgJ, this.fgx);
            }
            int height = getHeight();
            if (this.Gl == null) {
                this.Gl = new RectF(left, (height - this.mIndicatorHeight) - this.fgI, right2, height - this.fgI);
            } else {
                this.Gl.set(left, (height - this.mIndicatorHeight) - this.fgI, right2, height - this.fgI);
            }
            canvas.drawRoundRect(this.Gl, 16.0f, 16.0f, this.epm);
            if (this.iJk) {
                View childAt3 = this.epi.getChildAt(this.iJl);
                this.fgB.set((childAt3.getRight() - this.fgW) - this.fgU, childAt3.getTop() + this.fgV, right + this.fgU, top + this.fgU);
                canvas.drawOval(this.fgB, this.fgA);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.fgK + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.fgK + f2) - ((this.fgK * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.fgK + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.fgK) + ((this.fgK * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.epo = ap.getColor(this.iJm);
            this.epp = ap.getColor(this.iJn);
            this.epm.setColor(ap.getColor(this.iJo));
            this.fgA.setColor(ap.getColor(R.color.cp_cont_h));
            this.fgA.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), ap.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float ah(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fgR - 1.0f) / (0.1f - 1.0f))) + this.fgR;
        }
        return (((this.fgR - this.fgQ) / 0.1f) * f) + this.fgQ;
    }

    private float ai(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fgR) / (0.1f - 0.9f)));
        }
        return (((this.fgR - this.fgQ) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fgR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ai;
        float f = this.fgx;
        float f2 = this.fgy < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.epk) {
            View childAt = this.epi.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.epx);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ai = ah(f2);
                    } else {
                        ai = i == this.fgy ? ai(f2) : 1.0f;
                    }
                    textView.setScaleX(ai);
                    textView.setScaleY(ai);
                    if (f2 >= 0.5f) {
                        if (i == this.fgy) {
                            textView.setTextColor(this.epo);
                        } else {
                            textView.setTextColor(this.epp);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.epo);
                    } else {
                        textView.setTextColor(this.epp);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.fgy) {
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
            if (PagerSlidingTabStrip.this.epi.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.fgX) {
                    if (i == PagerSlidingTabStrip.this.fgz) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fgy = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.fgz) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fgy = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.fgy = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.fgz = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.fgy = i;
                    }
                    PagerSlidingTabStrip.this.fgx = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.epi.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.eph != null) {
                    PagerSlidingTabStrip.this.eph.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.epi.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.epj.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.fgx = 0.0f;
                    PagerSlidingTabStrip.this.fgX = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.fgz = PagerSlidingTabStrip.this.epj.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.fgz;
                    PagerSlidingTabStrip.this.fgy = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.eph != null) {
                    PagerSlidingTabStrip.this.eph.onPageScrollStateChanged(i);
                }
                HomePageStatic.iFV = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.eph != null) {
                PagerSlidingTabStrip.this.eph.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.fgX) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.fgx * PagerSlidingTabStrip.this.epi.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.fgz = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.fgy = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Zh;
        this.fgy = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Zh = this.mCurrentTabIndex;
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
        int Zh;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Zh = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Zh);
        }
    }

    public View zM(int i) {
        return this.epi.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.fgC = i;
    }

    public void setHotTopicIndex(int i) {
        this.iJl = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.iJp = aVar;
    }
}
