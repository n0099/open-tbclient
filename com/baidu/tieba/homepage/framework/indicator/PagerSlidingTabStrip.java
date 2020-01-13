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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes7.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private float dLH;
    private int dLI;
    private int dLJ;
    private Paint dLK;
    private RectF dLL;
    private boolean dLM;
    private int dLN;
    private int dLS;
    private int dLT;
    private int dLU;
    private int dLV;
    private int dLX;
    private int dLY;
    private int dLZ;
    private float dMa;
    private float dMb;
    private int dMe;
    private int dMf;
    private int dMg;
    private boolean dMh;
    private LinearLayout.LayoutParams daa;
    private LinearLayout.LayoutParams dab;
    public ViewPager.OnPageChangeListener dad;
    private LinearLayout dae;
    private ViewPager daf;
    private int dag;
    private Paint dai;
    private boolean daj;
    private int dak;
    private int dal;
    private int dau;
    private int dav;
    private int dcl;
    private int dividerPadding;
    private final b gXD;
    private int gXE;
    private int gXF;
    private int gXG;
    private a gXH;
    private boolean isLoading;
    private RectF jD;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes7.dex */
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
        this.gXD = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dLH = 0.0f;
        this.dLI = 0;
        this.dLJ = 0;
        this.daj = false;
        this.gXE = R.color.cp_cont_b;
        this.gXF = R.color.cp_cont_j;
        this.gXG = R.color.cp_link_tip_a;
        this.dak = am.getColor(this.gXE);
        this.dal = am.getColor(this.gXF);
        this.dLS = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dcl = 1;
        this.dLX = 17;
        this.dLY = 17;
        this.dau = 0;
        this.dav = R.drawable.pager_sliding_view;
        this.dMh = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dae = new LinearLayout(getContext());
        this.dae.setOrientation(0);
        this.dae.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dae);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dLS = (int) TypedValue.applyDimension(1, this.dLS, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dcl = (int) TypedValue.applyDimension(1, this.dcl, displayMetrics);
        this.dLX = i;
        this.dLY = i2;
        this.dLZ = l.getDimens(getContext(), R.dimen.tbds46);
        this.dMa = (this.dLY * 1.0f) / this.dLX;
        this.dMb = (this.dLZ * 1.0f) / this.dLX;
        this.mIndicatorHeight = i3;
        this.daj = z;
        this.dai = new Paint();
        this.dai.setAntiAlias(true);
        this.dai.setStyle(Paint.Style.FILL);
        this.dai.setColor(am.getColor(R.color.cp_link_tip_a));
        this.dLK = new Paint();
        this.dLK.setAntiAlias(true);
        this.dLK.setStyle(Paint.Style.FILL);
        this.dLK.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.dLK.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.dLL = new RectF();
        this.dMe = l.getDimens(getContext(), R.dimen.tbds20);
        this.dMf = l.getDimens(getContext(), R.dimen.tbds28);
        this.dMg = l.getDimens(getContext(), R.dimen.tbds22);
        this.daa = new LinearLayout.LayoutParams(-2, -1);
        this.dab = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.dLU = l.getDimens(getContext(), R.dimen.tbds62);
        this.dLT = l.getDimens(getContext(), R.dimen.tbds0);
        this.dLV = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dab = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dLM = z;
        invalidate();
    }

    public boolean bMa() {
        return this.dLM;
    }

    public void setTabItemClicked(boolean z) {
        this.dMh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.daf = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gXD);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dad = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.daf != null && this.daf.getAdapter() != null && this.daf.getAdapter().getCount() != 0) {
            this.dae.removeAllViews();
            this.dag = this.daf.getAdapter().getCount();
            for (int i = 0; i < this.dag; i++) {
                P(i, this.daf.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.daf.getCurrentItem();
                    PagerSlidingTabStrip.this.dLI = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void P(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dLX);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.gXH != null) {
                        PagerSlidingTabStrip.this.gXH.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.daf.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).Z("obj_locate", i + 1).cp("obj_type", "1"));
                    PagerSlidingTabStrip.this.dMh = true;
                    if (PagerSlidingTabStrip.this.daf.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.daf.getAdapter()).va(i);
                    }
                    PagerSlidingTabStrip.this.daf.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.dae.addView(view, i, this.daj ? this.dab : this.daa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dag != 0) {
            int left = this.dae.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dLS;
            }
            if (left != this.dau) {
                this.dau = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dag != 0) {
            View childAt = this.dae.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dLU;
            float right2 = childAt.getRight() - this.dLU;
            if (this.dLH > 0.0f && this.mCurrentTabIndex != this.dLI && this.dLI <= this.dag - 1 && this.dLI >= 0) {
                View childAt2 = this.dae.getChildAt(this.dLI);
                left = d(left, childAt2.getLeft() + this.dLU, this.dLH);
                right2 = e(right2, childAt2.getRight() - this.dLU, this.dLH);
            }
            int height = getHeight();
            if (this.jD == null) {
                this.jD = new RectF(left, (height - this.mIndicatorHeight) - this.dLT, right2, height - this.dLT);
            } else {
                this.jD.set(left, (height - this.mIndicatorHeight) - this.dLT, right2, height - this.dLT);
            }
            canvas.drawRoundRect(this.jD, 16.0f, 16.0f, this.dai);
            if (this.dLM) {
                View childAt3 = this.dae.getChildAt(this.dLN);
                this.dLL.set((childAt3.getRight() - this.dMg) - this.dMe, childAt3.getTop() + this.dMf, right + this.dMe, top + this.dMe);
                canvas.drawOval(this.dLL, this.dLK);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dLV + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dLV + f2) - ((this.dLV * (f3 - 0.8f)) / 0.2f);
        } else {
            return f;
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 > f) {
            if (f3 <= 0.5d) {
                return f + (((f2 - f) * f3) / 0.5f);
            }
            return f2;
        } else if (f3 >= 0.5d) {
            return f;
        } else {
            if (f3 >= 0.2d) {
                return f - ((((this.dLV + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dLV) + ((this.dLV * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dak = am.getColor(this.gXE);
            this.dal = am.getColor(this.gXF);
            this.dai.setColor(am.getColor(this.gXG));
            this.dLK.setColor(am.getColor(R.color.cp_cont_h));
            this.dLK.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    public void bMb() {
        this.gXE = R.color.cp_other_f;
        this.gXF = R.color.cp_cont_a;
        this.gXG = R.color.cp_other_f;
        this.dak = am.getColor(this.gXE);
        this.dal = am.getColor(this.gXF);
        this.dai.setColor(am.getColor(this.gXG));
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dMb - 1.0f) / (0.1f - 1.0f))) + this.dMb;
        }
        return (((this.dMb - this.dMa) / 0.1f) * f) + this.dMa;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dMb) / (0.1f - 0.9f)));
        }
        return (((this.dMb - this.dMa) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dMb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.dLH;
        float f2 = this.dLI < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dag) {
            View childAt = this.dae.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dav);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.dLI ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (f2 >= 0.5f) {
                        if (i == this.dLI) {
                            textView.setTextColor(this.dak);
                        } else {
                            textView.setTextColor(this.dal);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dak);
                    } else {
                        textView.setTextColor(this.dal);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dLI) {
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

    /* loaded from: classes7.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dae.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dMh) {
                    if (i == PagerSlidingTabStrip.this.dLJ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dLI = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.dLJ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dLI = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.dLI = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.dLJ = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dLI = i;
                    }
                    PagerSlidingTabStrip.this.dLH = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dae.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.dad != null) {
                    PagerSlidingTabStrip.this.dad.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dae.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.daf.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.dLH = 0.0f;
                    PagerSlidingTabStrip.this.dMh = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.dLJ = PagerSlidingTabStrip.this.daf.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dLJ;
                    PagerSlidingTabStrip.this.dLI = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.dad != null) {
                    PagerSlidingTabStrip.this.dad.onPageScrollStateChanged(i);
                }
                HomePageStatic.gUh = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dad != null) {
                PagerSlidingTabStrip.this.dad.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dMh) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dLH * PagerSlidingTabStrip.this.dae.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.dLJ = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.dLI = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ec;
        this.dLI = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ec = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: aa */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: vc */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ec;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ec = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ec);
        }
    }

    public View vb(int i) {
        return this.dae.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.dLN = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gXH = aVar;
    }
}
