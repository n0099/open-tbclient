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
    private int dQA;
    private boolean dQB;
    private float dQb;
    private int dQc;
    private int dQd;
    private Paint dQe;
    private RectF dQf;
    private boolean dQg;
    private int dQh;
    private int dQm;
    private int dQn;
    private int dQo;
    private int dQp;
    private int dQr;
    private int dQs;
    private int dQt;
    private float dQu;
    private float dQv;
    private int dQy;
    private int dQz;
    private int deA;
    private Paint deC;
    private boolean deD;
    private int deE;
    private int deF;
    private int deO;
    private int deP;
    private LinearLayout.LayoutParams deu;
    private LinearLayout.LayoutParams dev;
    public ViewPager.OnPageChangeListener dex;
    private LinearLayout dey;
    private ViewPager dez;
    private int dgE;
    private int dividerPadding;
    private final b gZS;
    private int gZT;
    private int gZU;
    private int gZV;
    private a gZW;
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
        this.gZS = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dQb = 0.0f;
        this.dQc = 0;
        this.dQd = 0;
        this.deD = false;
        this.gZT = R.color.cp_cont_b;
        this.gZU = R.color.cp_cont_j;
        this.gZV = R.color.cp_link_tip_a;
        this.deE = am.getColor(this.gZT);
        this.deF = am.getColor(this.gZU);
        this.dQm = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dgE = 1;
        this.dQr = 17;
        this.dQs = 17;
        this.deO = 0;
        this.deP = R.drawable.pager_sliding_view;
        this.dQB = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dey = new LinearLayout(getContext());
        this.dey.setOrientation(0);
        this.dey.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dey);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dQm = (int) TypedValue.applyDimension(1, this.dQm, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dgE = (int) TypedValue.applyDimension(1, this.dgE, displayMetrics);
        this.dQr = i;
        this.dQs = i2;
        this.dQt = l.getDimens(getContext(), R.dimen.tbds46);
        this.dQu = (this.dQs * 1.0f) / this.dQr;
        this.dQv = (this.dQt * 1.0f) / this.dQr;
        this.mIndicatorHeight = i3;
        this.deD = z;
        this.deC = new Paint();
        this.deC.setAntiAlias(true);
        this.deC.setStyle(Paint.Style.FILL);
        this.deC.setColor(am.getColor(R.color.cp_link_tip_a));
        this.dQe = new Paint();
        this.dQe.setAntiAlias(true);
        this.dQe.setStyle(Paint.Style.FILL);
        this.dQe.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.dQe.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.dQf = new RectF();
        this.dQy = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQz = l.getDimens(getContext(), R.dimen.tbds28);
        this.dQA = l.getDimens(getContext(), R.dimen.tbds22);
        this.deu = new LinearLayout.LayoutParams(-2, -1);
        this.dev = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.dQo = l.getDimens(getContext(), R.dimen.tbds62);
        this.dQn = l.getDimens(getContext(), R.dimen.tbds0);
        this.dQp = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dev = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dQg = z;
        invalidate();
    }

    public boolean bNG() {
        return this.dQg;
    }

    public void setTabItemClicked(boolean z) {
        this.dQB = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dez = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.gZS);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dex = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dez != null && this.dez.getAdapter() != null && this.dez.getAdapter().getCount() != 0) {
            this.dey.removeAllViews();
            this.deA = this.dez.getAdapter().getCount();
            for (int i = 0; i < this.deA; i++) {
                R(i, this.dez.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dez.getCurrentItem();
                    PagerSlidingTabStrip.this.dQc = PagerSlidingTabStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.dQr);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.gZW != null) {
                        PagerSlidingTabStrip.this.gZW.k(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.dez.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).X("obj_locate", i + 1).cy("obj_type", "1"));
                    PagerSlidingTabStrip.this.dQB = true;
                    if (PagerSlidingTabStrip.this.dez.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.dez.getAdapter()).vg(i);
                    }
                    PagerSlidingTabStrip.this.dez.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.dey.addView(view, i, this.deD ? this.dev : this.deu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.deA != 0) {
            int left = this.dey.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dQm;
            }
            if (left != this.deO) {
                this.deO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.deA != 0) {
            View childAt = this.dey.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQo;
            float right2 = childAt.getRight() - this.dQo;
            if (this.dQb > 0.0f && this.mCurrentTabIndex != this.dQc && this.dQc <= this.deA - 1 && this.dQc >= 0) {
                View childAt2 = this.dey.getChildAt(this.dQc);
                left = d(left, childAt2.getLeft() + this.dQo, this.dQb);
                right2 = e(right2, childAt2.getRight() - this.dQo, this.dQb);
            }
            int height = getHeight();
            if (this.jH == null) {
                this.jH = new RectF(left, (height - this.mIndicatorHeight) - this.dQn, right2, height - this.dQn);
            } else {
                this.jH.set(left, (height - this.mIndicatorHeight) - this.dQn, right2, height - this.dQn);
            }
            canvas.drawRoundRect(this.jH, 16.0f, 16.0f, this.deC);
            if (this.dQg) {
                View childAt3 = this.dey.getChildAt(this.dQh);
                this.dQf.set((childAt3.getRight() - this.dQA) - this.dQy, childAt3.getTop() + this.dQz, right + this.dQy, top2 + this.dQy);
                canvas.drawOval(this.dQf, this.dQe);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dQp + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dQp + f2) - ((this.dQp * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.dQp + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dQp) + ((this.dQp * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.deE = am.getColor(this.gZT);
            this.deF = am.getColor(this.gZU);
            this.deC.setColor(am.getColor(this.gZV));
            this.dQe.setColor(am.getColor(R.color.cp_cont_h));
            this.dQe.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQv - 1.0f) / (0.1f - 1.0f))) + this.dQv;
        }
        return (((this.dQv - this.dQu) / 0.1f) * f) + this.dQu;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQv) / (0.1f - 0.9f)));
        }
        return (((this.dQv - this.dQu) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dQb;
        float f2 = this.dQc < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.deA) {
            View childAt = this.dey.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dQc ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.dQc) {
                            textView.setTextColor(this.deE);
                        } else {
                            textView.setTextColor(this.deF);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.deE);
                    } else {
                        textView.setTextColor(this.deF);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dQc) {
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
            if (PagerSlidingTabStrip.this.dey.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dQB) {
                    if (i == PagerSlidingTabStrip.this.dQd) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dQc = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.dQd) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dQc = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.dQc = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.dQd = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.dQc = i;
                    }
                    PagerSlidingTabStrip.this.dQb = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dey.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.dex != null) {
                    PagerSlidingTabStrip.this.dex.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dey.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dez.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.dQb = 0.0f;
                    PagerSlidingTabStrip.this.dQB = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.dQd = PagerSlidingTabStrip.this.dez.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dQd;
                    PagerSlidingTabStrip.this.dQc = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.dex != null) {
                    PagerSlidingTabStrip.this.dex.onPageScrollStateChanged(i);
                }
                HomePageStatic.gWw = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dex != null) {
                PagerSlidingTabStrip.this.dex.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dQB) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dQb * PagerSlidingTabStrip.this.dey.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.dQd = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.dQc = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dQc = this.mCurrentTabIndex;
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
        return this.dey.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.dQh = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gZW = aVar;
    }
}
