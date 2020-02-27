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
    private float dPN;
    private int dPO;
    private int dPP;
    private Paint dPQ;
    private RectF dPR;
    private boolean dPS;
    private int dPT;
    private int dPY;
    private int dPZ;
    private int dQa;
    private int dQb;
    private int dQd;
    private int dQe;
    private int dQf;
    private float dQg;
    private float dQh;
    private int dQk;
    private int dQl;
    private int dQm;
    private boolean dQn;
    private int deA;
    private int deB;
    private LinearLayout.LayoutParams def;
    private LinearLayout.LayoutParams deg;
    public ViewPager.OnPageChangeListener dei;
    private LinearLayout dej;
    private ViewPager dek;
    private int del;
    private Paint den;
    private boolean deo;
    private int dep;
    private int deq;
    private int dgq;
    private int dividerPadding;
    private final b gZE;
    private int gZF;
    private int gZG;
    private int gZH;
    private a gZI;
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
        this.gZE = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dPN = 0.0f;
        this.dPO = 0;
        this.dPP = 0;
        this.deo = false;
        this.gZF = R.color.cp_cont_b;
        this.gZG = R.color.cp_cont_j;
        this.gZH = R.color.cp_link_tip_a;
        this.dep = am.getColor(this.gZF);
        this.deq = am.getColor(this.gZG);
        this.dPY = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dgq = 1;
        this.dQd = 17;
        this.dQe = 17;
        this.deA = 0;
        this.deB = R.drawable.pager_sliding_view;
        this.dQn = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dej = new LinearLayout(getContext());
        this.dej.setOrientation(0);
        this.dej.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dej);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dPY = (int) TypedValue.applyDimension(1, this.dPY, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dgq = (int) TypedValue.applyDimension(1, this.dgq, displayMetrics);
        this.dQd = i;
        this.dQe = i2;
        this.dQf = l.getDimens(getContext(), R.dimen.tbds46);
        this.dQg = (this.dQe * 1.0f) / this.dQd;
        this.dQh = (this.dQf * 1.0f) / this.dQd;
        this.mIndicatorHeight = i3;
        this.deo = z;
        this.den = new Paint();
        this.den.setAntiAlias(true);
        this.den.setStyle(Paint.Style.FILL);
        this.den.setColor(am.getColor(R.color.cp_link_tip_a));
        this.dPQ = new Paint();
        this.dPQ.setAntiAlias(true);
        this.dPQ.setStyle(Paint.Style.FILL);
        this.dPQ.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.dPQ.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.dPR = new RectF();
        this.dQk = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQl = l.getDimens(getContext(), R.dimen.tbds28);
        this.dQm = l.getDimens(getContext(), R.dimen.tbds22);
        this.def = new LinearLayout.LayoutParams(-2, -1);
        this.deg = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.dQa = l.getDimens(getContext(), R.dimen.tbds62);
        this.dPZ = l.getDimens(getContext(), R.dimen.tbds0);
        this.dQb = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deg = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dPS = z;
        invalidate();
    }

    public boolean bND() {
        return this.dPS;
    }

    public void setTabItemClicked(boolean z) {
        this.dQn = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dek = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gZE);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dei = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dek != null && this.dek.getAdapter() != null && this.dek.getAdapter().getCount() != 0) {
            this.dej.removeAllViews();
            this.del = this.dek.getAdapter().getCount();
            for (int i = 0; i < this.del; i++) {
                R(i, this.dek.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dek.getCurrentItem();
                    PagerSlidingTabStrip.this.dPO = PagerSlidingTabStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.dQd);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.gZI != null) {
                        PagerSlidingTabStrip.this.gZI.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.dek.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).X("obj_locate", i + 1).cy("obj_type", "1"));
                    PagerSlidingTabStrip.this.dQn = true;
                    if (PagerSlidingTabStrip.this.dek.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.dek.getAdapter()).vg(i);
                    }
                    PagerSlidingTabStrip.this.dek.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.dej.addView(view, i, this.deo ? this.deg : this.def);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.del != 0) {
            int left = this.dej.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dPY;
            }
            if (left != this.deA) {
                this.deA = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.del != 0) {
            View childAt = this.dej.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQa;
            float right2 = childAt.getRight() - this.dQa;
            if (this.dPN > 0.0f && this.mCurrentTabIndex != this.dPO && this.dPO <= this.del - 1 && this.dPO >= 0) {
                View childAt2 = this.dej.getChildAt(this.dPO);
                left = d(left, childAt2.getLeft() + this.dQa, this.dPN);
                right2 = e(right2, childAt2.getRight() - this.dQa, this.dPN);
            }
            int height = getHeight();
            if (this.jH == null) {
                this.jH = new RectF(left, (height - this.mIndicatorHeight) - this.dPZ, right2, height - this.dPZ);
            } else {
                this.jH.set(left, (height - this.mIndicatorHeight) - this.dPZ, right2, height - this.dPZ);
            }
            canvas.drawRoundRect(this.jH, 16.0f, 16.0f, this.den);
            if (this.dPS) {
                View childAt3 = this.dej.getChildAt(this.dPT);
                this.dPR.set((childAt3.getRight() - this.dQm) - this.dQk, childAt3.getTop() + this.dQl, right + this.dQk, top2 + this.dQk);
                canvas.drawOval(this.dPR, this.dPQ);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dQb + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dQb + f2) - ((this.dQb * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.dQb + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dQb) + ((this.dQb * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dep = am.getColor(this.gZF);
            this.deq = am.getColor(this.gZG);
            this.den.setColor(am.getColor(this.gZH));
            this.dPQ.setColor(am.getColor(R.color.cp_cont_h));
            this.dPQ.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQh - 1.0f) / (0.1f - 1.0f))) + this.dQh;
        }
        return (((this.dQh - this.dQg) / 0.1f) * f) + this.dQg;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQh) / (0.1f - 0.9f)));
        }
        return (((this.dQh - this.dQg) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dPN;
        float f2 = this.dPO < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.del) {
            View childAt = this.dej.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deB);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dPO ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.dPO) {
                            textView.setTextColor(this.dep);
                        } else {
                            textView.setTextColor(this.deq);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dep);
                    } else {
                        textView.setTextColor(this.deq);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dPO) {
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
            if (PagerSlidingTabStrip.this.dej.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dQn) {
                    if (i == PagerSlidingTabStrip.this.dPP) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dPO = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.dPP) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dPO = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.dPO = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.dPP = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dPO = i;
                    }
                    PagerSlidingTabStrip.this.dPN = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dej.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.dei != null) {
                    PagerSlidingTabStrip.this.dei.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dej.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dek.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.dPN = 0.0f;
                    PagerSlidingTabStrip.this.dQn = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.dPP = PagerSlidingTabStrip.this.dek.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dPP;
                    PagerSlidingTabStrip.this.dPO = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.dei != null) {
                    PagerSlidingTabStrip.this.dei.onPageScrollStateChanged(i);
                }
                HomePageStatic.gWi = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dei != null) {
                PagerSlidingTabStrip.this.dei.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dQn) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dPN * PagerSlidingTabStrip.this.dej.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.dPP = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.dPO = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dPO = this.mCurrentTabIndex;
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
        return this.dej.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.dPT = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gZI = aVar;
    }
}
