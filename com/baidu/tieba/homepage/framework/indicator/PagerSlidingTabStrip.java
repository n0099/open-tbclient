package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams atI;
    private LinearLayout.LayoutParams atJ;
    public ViewPager.OnPageChangeListener atL;
    private LinearLayout atM;
    private ViewPager atN;
    private int atO;
    private int atP;
    private float atQ;
    private Paint atR;
    private boolean atS;
    private int atT;
    private int atU;
    private int atV;
    private int atW;
    private int auc;
    private int auf;
    private int aug;
    private final b dWc;
    private Drawable dWd;
    private boolean dWe;
    private int dWf;
    private boolean dWg;
    private a dWh;
    private int dividerPadding;
    private int dividerWidth;
    private int ds20;
    private boolean isLoading;
    private Locale locale;
    private RectF pq;
    private int tabPadding;

    /* loaded from: classes2.dex */
    public interface a {
        void r(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dWc = new b();
        this.atP = 0;
        this.atQ = 0.0f;
        this.atS = false;
        this.atT = am.getColor(f.d.cp_cont_b);
        this.atU = am.getColor(f.d.cp_cont_j);
        this.atV = 52;
        this.atW = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.dividerWidth = 1;
        this.auc = 17;
        this.auf = 0;
        this.aug = f.C0146f.pager_sliding_view;
        this.dWg = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.atM = new LinearLayout(getContext());
        this.atM.setOrientation(0);
        this.atM.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.atM);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.atV = (int) TypedValue.applyDimension(1, this.atV, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.auc = i;
        this.atW = i2;
        this.atS = z;
        this.atR = new Paint();
        this.atR.setAntiAlias(true);
        this.atR.setStyle(Paint.Style.FILL);
        this.dWd = am.getDrawable(f.C0146f.icon_news_down_bar_one);
        this.ds20 = l.f(getContext(), f.e.ds20);
        this.atI = new LinearLayout.LayoutParams(-2, -1);
        this.atJ = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.f(getContext(), f.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.dWe = z;
        invalidate();
    }

    public boolean aDT() {
        return this.dWe;
    }

    public void setTabItemClicked(boolean z) {
        this.dWg = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.atN = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dWc);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.atL = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.atN != null && this.atN.getAdapter() != null && this.atN.getAdapter().getCount() != 0) {
            this.atM.removeAllViews();
            this.atO = this.atN.getAdapter().getCount();
            for (int i = 0; i < this.atO; i++) {
                j(i, this.atN.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.atP = PagerSlidingTabStrip.this.atN.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.atP, 0);
                }
            });
        }
    }

    private void j(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        b(i, textView);
    }

    private void b(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.dWh != null) {
                        PagerSlidingTabStrip.this.dWh.r(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.atN.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new an("c12049").r("obj_locate", i + 1).ae("obj_type", "1"));
                    PagerSlidingTabStrip.this.dWg = true;
                    if (PagerSlidingTabStrip.this.atN.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.atN.getAdapter()).mL(i);
                    }
                    PagerSlidingTabStrip.this.atN.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.atM.addView(view, i, this.atS ? this.atJ : this.atI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.atO; i++) {
            View childAt = this.atM.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aug);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.auc);
                    if (i == this.atN.getCurrentItem()) {
                        textView.setTextColor(this.atT);
                    } else {
                        textView.setTextColor(this.atU);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.atO != 0) {
            int left = this.atM.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.atV;
            }
            if (left != this.auf) {
                this.auf = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.atO != 0) {
            int height = getHeight();
            this.atR.setColor(this.atT);
            View childAt = this.atM.getChildAt(this.atP);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.atQ > 0.0f && this.atP < this.atO - 1) {
                View childAt2 = this.atM.getChildAt(this.atP + 1);
                left = (left * (1.0f - this.atQ)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.atQ);
                right = (right * (1.0f - this.atQ)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.atQ);
            }
            if (this.pq == null) {
                this.pq = new RectF(left, height - this.atW, right, height);
            } else {
                this.pq.set(left, height - this.atW, right, height);
            }
            canvas.drawRoundRect(this.pq, 10.0f, 10.0f, this.atR);
            if (this.dWe) {
                View childAt3 = this.atM.getChildAt(this.dWf);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.dWd.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.dWd.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.atT = am.getColor(f.d.cp_cont_b);
        this.atU = am.getColor(f.d.cp_cont_j);
        this.dWd = am.getDrawable(f.C0146f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.atM.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dWg) {
                    PagerSlidingTabStrip.this.atP = i;
                    PagerSlidingTabStrip.this.atQ = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.atM.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.atL != null) {
                    PagerSlidingTabStrip.this.atL.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.atM.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.atN.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.atQ = 0.0f;
                    PagerSlidingTabStrip.this.dWg = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.atL != null) {
                    PagerSlidingTabStrip.this.atL.onPageScrollStateChanged(i);
                }
                HomePageStatic.dSr = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.atL != null) {
                PagerSlidingTabStrip.this.atL.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dWg) {
                PagerSlidingTabStrip.this.atP = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.atQ * PagerSlidingTabStrip.this.atM.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.atP = savedState.atP;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.atP = this.atP;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: n */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int atP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.atP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.atP);
        }
    }

    public View mM(int i) {
        return this.atM.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.dWf = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dWh = aVar;
    }
}
