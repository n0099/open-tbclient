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
/* loaded from: classes9.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int dQD;
    private int dQE;
    private int dQF;
    private int dQG;
    private int dQI;
    private int dQJ;
    private int dQK;
    private float dQL;
    private float dQM;
    private int dQP;
    private int dQQ;
    private int dQR;
    private boolean dQS;
    private float dQs;
    private int dQt;
    private int dQu;
    private Paint dQv;
    private RectF dQw;
    private boolean dQx;
    private int dQy;
    private LinearLayout.LayoutParams deH;
    private LinearLayout.LayoutParams deI;
    public ViewPager.OnPageChangeListener deK;
    private LinearLayout deL;
    private ViewPager deM;
    private int deN;
    private Paint deP;
    private boolean deQ;
    private int deR;
    private int deS;
    private int dfb;
    private int dfc;
    private int dgR;
    private int dividerPadding;
    private final b hba;
    private int hbb;
    private int hbc;
    private int hbd;
    private a hbe;
    private boolean isLoading;
    private RectF jG;
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
        this.hba = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dQs = 0.0f;
        this.dQt = 0;
        this.dQu = 0;
        this.deQ = false;
        this.hbb = R.color.cp_cont_b;
        this.hbc = R.color.cp_cont_j;
        this.hbd = R.color.cp_link_tip_a;
        this.deR = am.getColor(this.hbb);
        this.deS = am.getColor(this.hbc);
        this.dQD = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dgR = 1;
        this.dQI = 17;
        this.dQJ = 17;
        this.dfb = 0;
        this.dfc = R.drawable.pager_sliding_view;
        this.dQS = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.deL = new LinearLayout(getContext());
        this.deL.setOrientation(0);
        this.deL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.deL);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dQD = (int) TypedValue.applyDimension(1, this.dQD, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dgR = (int) TypedValue.applyDimension(1, this.dgR, displayMetrics);
        this.dQI = i;
        this.dQJ = i2;
        this.dQK = l.getDimens(getContext(), R.dimen.tbds46);
        this.dQL = (this.dQJ * 1.0f) / this.dQI;
        this.dQM = (this.dQK * 1.0f) / this.dQI;
        this.mIndicatorHeight = i3;
        this.deQ = z;
        this.deP = new Paint();
        this.deP.setAntiAlias(true);
        this.deP.setStyle(Paint.Style.FILL);
        this.deP.setColor(am.getColor(R.color.cp_link_tip_a));
        this.dQv = new Paint();
        this.dQv.setAntiAlias(true);
        this.dQv.setStyle(Paint.Style.FILL);
        this.dQv.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.dQv.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.dQw = new RectF();
        this.dQP = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQQ = l.getDimens(getContext(), R.dimen.tbds28);
        this.dQR = l.getDimens(getContext(), R.dimen.tbds22);
        this.deH = new LinearLayout.LayoutParams(-2, -1);
        this.deI = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.dQF = l.getDimens(getContext(), R.dimen.tbds62);
        this.dQE = l.getDimens(getContext(), R.dimen.tbds0);
        this.dQG = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deI = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dQx = z;
        invalidate();
    }

    public boolean bNU() {
        return this.dQx;
    }

    public void setTabItemClicked(boolean z) {
        this.dQS = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.deM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.hba);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.deK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.deM != null && this.deM.getAdapter() != null && this.deM.getAdapter().getCount() != 0) {
            this.deL.removeAllViews();
            this.deN = this.deM.getAdapter().getCount();
            for (int i = 0; i < this.deN; i++) {
                R(i, this.deM.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.deM.getCurrentItem();
                    PagerSlidingTabStrip.this.dQt = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void R(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dQI);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.hbe != null) {
                        PagerSlidingTabStrip.this.hbe.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.deM.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).X("obj_locate", i + 1).cx("obj_type", "1"));
                    PagerSlidingTabStrip.this.dQS = true;
                    if (PagerSlidingTabStrip.this.deM.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.deM.getAdapter()).vn(i);
                    }
                    PagerSlidingTabStrip.this.deM.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.deL.addView(view, i, this.deQ ? this.deI : this.deH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.deN != 0) {
            int left = this.deL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dQD;
            }
            if (left != this.dfb) {
                this.dfb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.deN != 0) {
            View childAt = this.deL.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQF;
            float right2 = childAt.getRight() - this.dQF;
            if (this.dQs > 0.0f && this.mCurrentTabIndex != this.dQt && this.dQt <= this.deN - 1 && this.dQt >= 0) {
                View childAt2 = this.deL.getChildAt(this.dQt);
                left = d(left, childAt2.getLeft() + this.dQF, this.dQs);
                right2 = e(right2, childAt2.getRight() - this.dQF, this.dQs);
            }
            int height = getHeight();
            if (this.jG == null) {
                this.jG = new RectF(left, (height - this.mIndicatorHeight) - this.dQE, right2, height - this.dQE);
            } else {
                this.jG.set(left, (height - this.mIndicatorHeight) - this.dQE, right2, height - this.dQE);
            }
            canvas.drawRoundRect(this.jG, 16.0f, 16.0f, this.deP);
            if (this.dQx) {
                View childAt3 = this.deL.getChildAt(this.dQy);
                this.dQw.set((childAt3.getRight() - this.dQR) - this.dQP, childAt3.getTop() + this.dQQ, right + this.dQP, top2 + this.dQP);
                canvas.drawOval(this.dQw, this.dQv);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dQG + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dQG + f2) - ((this.dQG * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.dQG + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dQG) + ((this.dQG * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.deR = am.getColor(this.hbb);
            this.deS = am.getColor(this.hbc);
            this.deP.setColor(am.getColor(this.hbd));
            this.dQv.setColor(am.getColor(R.color.cp_cont_h));
            this.dQv.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQM - 1.0f) / (0.1f - 1.0f))) + this.dQM;
        }
        return (((this.dQM - this.dQL) / 0.1f) * f) + this.dQL;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQM) / (0.1f - 0.9f)));
        }
        return (((this.dQM - this.dQL) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dQs;
        float f2 = this.dQt < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.deN) {
            View childAt = this.deL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dfc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dQt ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.dQt) {
                            textView.setTextColor(this.deR);
                        } else {
                            textView.setTextColor(this.deS);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.deR);
                    } else {
                        textView.setTextColor(this.deS);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dQt) {
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
            if (PagerSlidingTabStrip.this.deL.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dQS) {
                    if (i == PagerSlidingTabStrip.this.dQu) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dQt = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.dQu) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dQt = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.dQt = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.dQu = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dQt = i;
                    }
                    PagerSlidingTabStrip.this.dQs = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.deL.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.deK != null) {
                    PagerSlidingTabStrip.this.deK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.deL.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.deM.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.dQs = 0.0f;
                    PagerSlidingTabStrip.this.dQS = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.dQu = PagerSlidingTabStrip.this.deM.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dQu;
                    PagerSlidingTabStrip.this.dQt = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.deK != null) {
                    PagerSlidingTabStrip.this.deK.onPageScrollStateChanged(i);
                }
                HomePageStatic.gXD = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.deK != null) {
                PagerSlidingTabStrip.this.deK.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dQS) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dQs * PagerSlidingTabStrip.this.deL.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.dQu = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.dQt = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dQt = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ev = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
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
            /* renamed from: vp */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ev;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ev = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ev);
        }
    }

    public View vo(int i) {
        return this.deL.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.dQy = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.hbe = aVar;
    }
}
