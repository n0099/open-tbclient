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
/* loaded from: classes6.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams cZQ;
    private LinearLayout.LayoutParams cZR;
    public ViewPager.OnPageChangeListener cZT;
    private LinearLayout cZU;
    private ViewPager cZV;
    private int cZW;
    private Paint cZY;
    private boolean cZZ;
    private float dLA;
    private int dLB;
    private int dLC;
    private Paint dLD;
    private RectF dLE;
    private boolean dLF;
    private int dLG;
    private int dLK;
    private int dLL;
    private int dLM;
    private int dLN;
    private int dLP;
    private int dLQ;
    private int dLR;
    private float dLS;
    private float dLT;
    private int dLW;
    private int dLX;
    private int dLY;
    private boolean dLZ;
    private int daa;
    private int dab;
    private int dak;
    private int dal;
    private int dcb;
    private int dividerPadding;
    private final b gUj;
    private a gUk;
    private boolean isLoading;
    private RectF jE;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes6.dex */
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
        this.gUj = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dLA = 0.0f;
        this.dLB = 0;
        this.dLC = 0;
        this.cZZ = false;
        this.daa = am.getColor(R.color.cp_cont_b);
        this.dab = am.getColor(R.color.cp_cont_j);
        this.dLK = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dcb = 1;
        this.dLP = 17;
        this.dLQ = 17;
        this.dak = 0;
        this.dal = R.drawable.pager_sliding_view;
        this.dLZ = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.cZU = new LinearLayout(getContext());
        this.cZU.setOrientation(0);
        this.cZU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.cZU);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dLK = (int) TypedValue.applyDimension(1, this.dLK, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dcb = (int) TypedValue.applyDimension(1, this.dcb, displayMetrics);
        this.dLP = i;
        this.dLQ = i2;
        this.dLR = l.getDimens(getContext(), R.dimen.tbds46);
        this.dLS = (this.dLQ * 1.0f) / this.dLP;
        this.dLT = (this.dLR * 1.0f) / this.dLP;
        this.mIndicatorHeight = i3;
        this.cZZ = z;
        this.cZY = new Paint();
        this.cZY.setAntiAlias(true);
        this.cZY.setStyle(Paint.Style.FILL);
        this.cZY.setColor(am.getColor(R.color.cp_link_tip_a));
        this.dLD = new Paint();
        this.dLD.setAntiAlias(true);
        this.dLD.setStyle(Paint.Style.FILL);
        this.dLD.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.dLD.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.dLE = new RectF();
        this.dLW = l.getDimens(getContext(), R.dimen.tbds20);
        this.dLX = l.getDimens(getContext(), R.dimen.tbds28);
        this.dLY = l.getDimens(getContext(), R.dimen.tbds22);
        this.cZQ = new LinearLayout.LayoutParams(-2, -1);
        this.cZR = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.dLM = l.getDimens(getContext(), R.dimen.tbds62);
        this.dLL = l.getDimens(getContext(), R.dimen.tbds0);
        this.dLN = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.cZR = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dLF = z;
        invalidate();
    }

    public boolean bKV() {
        return this.dLF;
    }

    public void setTabItemClicked(boolean z) {
        this.dLZ = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cZV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gUj);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cZT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.cZV != null && this.cZV.getAdapter() != null && this.cZV.getAdapter().getCount() != 0) {
            this.cZU.removeAllViews();
            this.cZW = this.cZV.getAdapter().getCount();
            for (int i = 0; i < this.cZW; i++) {
                N(i, this.cZV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.cZV.getCurrentItem();
                    PagerSlidingTabStrip.this.dLB = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void N(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dLP);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.gUk != null) {
                        PagerSlidingTabStrip.this.gUk.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.cZV.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).Z("obj_locate", i + 1).cp("obj_type", "1"));
                    PagerSlidingTabStrip.this.dLZ = true;
                    if (PagerSlidingTabStrip.this.cZV.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.cZV.getAdapter()).uV(i);
                    }
                    PagerSlidingTabStrip.this.cZV.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.cZU.addView(view, i, this.cZZ ? this.cZR : this.cZQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.cZW != 0) {
            int left = this.cZU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dLK;
            }
            if (left != this.dak) {
                this.dak = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.cZW != 0) {
            View childAt = this.cZU.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dLM;
            float right2 = childAt.getRight() - this.dLM;
            if (this.dLA > 0.0f && this.mCurrentTabIndex != this.dLB && this.dLB <= this.cZW - 1 && this.dLB >= 0) {
                View childAt2 = this.cZU.getChildAt(this.dLB);
                left = d(left, childAt2.getLeft() + this.dLM, this.dLA);
                right2 = e(right2, childAt2.getRight() - this.dLM, this.dLA);
            }
            int height = getHeight();
            if (this.jE == null) {
                this.jE = new RectF(left, (height - this.mIndicatorHeight) - this.dLL, right2, height - this.dLL);
            } else {
                this.jE.set(left, (height - this.mIndicatorHeight) - this.dLL, right2, height - this.dLL);
            }
            canvas.drawRoundRect(this.jE, 16.0f, 16.0f, this.cZY);
            if (this.dLF) {
                View childAt3 = this.cZU.getChildAt(this.dLG);
                this.dLE.set((childAt3.getRight() - this.dLY) - this.dLW, childAt3.getTop() + this.dLX, right + this.dLW, top + this.dLW);
                canvas.drawOval(this.dLE, this.dLD);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dLN + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dLN + f2) - ((this.dLN * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.dLN + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dLN) + ((this.dLN * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.daa = am.getColor(R.color.cp_cont_b);
            this.dab = am.getColor(R.color.cp_cont_j);
            this.cZY.setColor(am.getColor(R.color.cp_link_tip_a));
            this.dLD.setColor(am.getColor(R.color.cp_cont_h));
            this.dLD.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float au(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dLT - 1.0f) / (0.1f - 1.0f))) + this.dLT;
        }
        return (((this.dLT - this.dLS) / 0.1f) * f) + this.dLS;
    }

    private float av(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dLT) / (0.1f - 0.9f)));
        }
        return (((this.dLT - this.dLS) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dLT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float av;
        float f = this.dLA;
        float f2 = this.dLB < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.cZW) {
            View childAt = this.cZU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dal);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        av = au(f2);
                    } else {
                        av = i == this.dLB ? av(f2) : 1.0f;
                    }
                    textView.setScaleX(av);
                    textView.setScaleY(av);
                    if (f2 >= 0.5f) {
                        if (i == this.dLB) {
                            textView.setTextColor(this.daa);
                        } else {
                            textView.setTextColor(this.dab);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.daa);
                    } else {
                        textView.setTextColor(this.dab);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dLB) {
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

    /* loaded from: classes6.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.cZU.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dLZ) {
                    if (i == PagerSlidingTabStrip.this.dLC) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dLB = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.dLC) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dLB = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.dLB = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.dLC = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dLB = i;
                    }
                    PagerSlidingTabStrip.this.dLA = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.cZU.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.cZT != null) {
                    PagerSlidingTabStrip.this.cZT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.cZU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.cZV.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.dLA = 0.0f;
                    PagerSlidingTabStrip.this.dLZ = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.dLC = PagerSlidingTabStrip.this.cZV.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dLC;
                    PagerSlidingTabStrip.this.dLB = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.cZT != null) {
                    PagerSlidingTabStrip.this.cZT.onPageScrollStateChanged(i);
                }
                HomePageStatic.gQN = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.cZT != null) {
                PagerSlidingTabStrip.this.cZT.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dLZ) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dLA * PagerSlidingTabStrip.this.cZU.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.dLC = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.dLB = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.DX;
        this.dLB = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.DX = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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
            /* renamed from: uX */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int DX;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.DX = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.DX);
        }
    }

    public View uW(int i) {
        return this.cZU.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.dLG = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gUk = aVar;
    }
}
