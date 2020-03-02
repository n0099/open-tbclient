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
    private float dPO;
    private int dPP;
    private int dPQ;
    private Paint dPR;
    private RectF dPS;
    private boolean dPT;
    private int dPU;
    private int dPZ;
    private int dQa;
    private int dQb;
    private int dQc;
    private int dQe;
    private int dQf;
    private int dQg;
    private float dQh;
    private float dQi;
    private int dQl;
    private int dQm;
    private int dQn;
    private boolean dQo;
    private int deB;
    private int deC;
    private LinearLayout.LayoutParams deg;
    private LinearLayout.LayoutParams deh;
    public ViewPager.OnPageChangeListener dej;
    private LinearLayout dek;
    private ViewPager del;
    private int dem;
    private Paint deo;
    private boolean dep;
    private int deq;
    private int der;
    private int dgr;
    private int dividerPadding;
    private final b gZG;
    private int gZH;
    private int gZI;
    private int gZJ;
    private a gZK;
    private boolean isLoading;
    private RectF jH;
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
        this.gZG = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dPO = 0.0f;
        this.dPP = 0;
        this.dPQ = 0;
        this.dep = false;
        this.gZH = R.color.cp_cont_b;
        this.gZI = R.color.cp_cont_j;
        this.gZJ = R.color.cp_link_tip_a;
        this.deq = am.getColor(this.gZH);
        this.der = am.getColor(this.gZI);
        this.dPZ = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dgr = 1;
        this.dQe = 17;
        this.dQf = 17;
        this.deB = 0;
        this.deC = R.drawable.pager_sliding_view;
        this.dQo = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dek = new LinearLayout(getContext());
        this.dek.setOrientation(0);
        this.dek.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dek);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dPZ = (int) TypedValue.applyDimension(1, this.dPZ, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dgr = (int) TypedValue.applyDimension(1, this.dgr, displayMetrics);
        this.dQe = i;
        this.dQf = i2;
        this.dQg = l.getDimens(getContext(), R.dimen.tbds46);
        this.dQh = (this.dQf * 1.0f) / this.dQe;
        this.dQi = (this.dQg * 1.0f) / this.dQe;
        this.mIndicatorHeight = i3;
        this.dep = z;
        this.deo = new Paint();
        this.deo.setAntiAlias(true);
        this.deo.setStyle(Paint.Style.FILL);
        this.deo.setColor(am.getColor(R.color.cp_link_tip_a));
        this.dPR = new Paint();
        this.dPR.setAntiAlias(true);
        this.dPR.setStyle(Paint.Style.FILL);
        this.dPR.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.dPR.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.dPS = new RectF();
        this.dQl = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQm = l.getDimens(getContext(), R.dimen.tbds28);
        this.dQn = l.getDimens(getContext(), R.dimen.tbds22);
        this.deg = new LinearLayout.LayoutParams(-2, -1);
        this.deh = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.dQb = l.getDimens(getContext(), R.dimen.tbds62);
        this.dQa = l.getDimens(getContext(), R.dimen.tbds0);
        this.dQc = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deh = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dPT = z;
        invalidate();
    }

    public boolean bNF() {
        return this.dPT;
    }

    public void setTabItemClicked(boolean z) {
        this.dQo = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.del = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gZG);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dej = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.del != null && this.del.getAdapter() != null && this.del.getAdapter().getCount() != 0) {
            this.dek.removeAllViews();
            this.dem = this.del.getAdapter().getCount();
            for (int i = 0; i < this.dem; i++) {
                R(i, this.del.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.del.getCurrentItem();
                    PagerSlidingTabStrip.this.dPP = PagerSlidingTabStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.dQe);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.gZK != null) {
                        PagerSlidingTabStrip.this.gZK.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.del.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).X("obj_locate", i + 1).cy("obj_type", "1"));
                    PagerSlidingTabStrip.this.dQo = true;
                    if (PagerSlidingTabStrip.this.del.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.del.getAdapter()).vg(i);
                    }
                    PagerSlidingTabStrip.this.del.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.dek.addView(view, i, this.dep ? this.deh : this.deg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dem != 0) {
            int left = this.dek.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dPZ;
            }
            if (left != this.deB) {
                this.deB = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dem != 0) {
            View childAt = this.dek.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQb;
            float right2 = childAt.getRight() - this.dQb;
            if (this.dPO > 0.0f && this.mCurrentTabIndex != this.dPP && this.dPP <= this.dem - 1 && this.dPP >= 0) {
                View childAt2 = this.dek.getChildAt(this.dPP);
                left = d(left, childAt2.getLeft() + this.dQb, this.dPO);
                right2 = e(right2, childAt2.getRight() - this.dQb, this.dPO);
            }
            int height = getHeight();
            if (this.jH == null) {
                this.jH = new RectF(left, (height - this.mIndicatorHeight) - this.dQa, right2, height - this.dQa);
            } else {
                this.jH.set(left, (height - this.mIndicatorHeight) - this.dQa, right2, height - this.dQa);
            }
            canvas.drawRoundRect(this.jH, 16.0f, 16.0f, this.deo);
            if (this.dPT) {
                View childAt3 = this.dek.getChildAt(this.dPU);
                this.dPS.set((childAt3.getRight() - this.dQn) - this.dQl, childAt3.getTop() + this.dQm, right + this.dQl, top2 + this.dQl);
                canvas.drawOval(this.dPS, this.dPR);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dQc + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dQc + f2) - ((this.dQc * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.dQc + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dQc) + ((this.dQc * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.deq = am.getColor(this.gZH);
            this.der = am.getColor(this.gZI);
            this.deo.setColor(am.getColor(this.gZJ));
            this.dPR.setColor(am.getColor(R.color.cp_cont_h));
            this.dPR.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQi - 1.0f) / (0.1f - 1.0f))) + this.dQi;
        }
        return (((this.dQi - this.dQh) / 0.1f) * f) + this.dQh;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQi) / (0.1f - 0.9f)));
        }
        return (((this.dQi - this.dQh) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dPO;
        float f2 = this.dPP < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dem) {
            View childAt = this.dek.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deC);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dPP ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.dPP) {
                            textView.setTextColor(this.deq);
                        } else {
                            textView.setTextColor(this.der);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.deq);
                    } else {
                        textView.setTextColor(this.der);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dPP) {
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
            if (PagerSlidingTabStrip.this.dek.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dQo) {
                    if (i == PagerSlidingTabStrip.this.dPQ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dPP = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.dPQ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dPP = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.dPP = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.dPQ = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dPP = i;
                    }
                    PagerSlidingTabStrip.this.dPO = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dek.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.dej != null) {
                    PagerSlidingTabStrip.this.dej.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dek.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.del.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.dPO = 0.0f;
                    PagerSlidingTabStrip.this.dQo = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.dPQ = PagerSlidingTabStrip.this.del.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dPQ;
                    PagerSlidingTabStrip.this.dPP = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.dej != null) {
                    PagerSlidingTabStrip.this.dej.onPageScrollStateChanged(i);
                }
                HomePageStatic.gWk = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dej != null) {
                PagerSlidingTabStrip.this.dej.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dQo) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dPO * PagerSlidingTabStrip.this.dek.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.dPQ = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.dPP = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dPP = this.mCurrentTabIndex;
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
            /* renamed from: vi */
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

    public View vh(int i) {
        return this.dek.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.dPU = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gZK = aVar;
    }
}
