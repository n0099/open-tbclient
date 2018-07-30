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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams atH;
    private LinearLayout.LayoutParams atI;
    public ViewPager.OnPageChangeListener atK;
    private LinearLayout atL;
    private ViewPager atM;
    private int atN;
    private int atO;
    private float atP;
    private Paint atQ;
    private boolean atR;
    private int atS;
    private int atT;
    private int atU;
    private int atV;
    private int aub;
    private int aue;
    private int auf;
    private int awe;
    private final a dWh;
    private Drawable dWi;
    private boolean dWj;
    private int dWk;
    private boolean dWl;
    private int dividerPadding;
    private int ds20;
    private boolean isLoading;
    private Locale locale;
    private RectF pp;
    private int tabPadding;

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dWh = new a();
        this.atO = 0;
        this.atP = 0.0f;
        this.atR = false;
        this.atS = am.getColor(d.C0140d.cp_cont_b);
        this.atT = am.getColor(d.C0140d.cp_cont_j);
        this.atU = 52;
        this.atV = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.awe = 1;
        this.aub = 17;
        this.aue = 0;
        this.auf = d.f.pager_sliding_view;
        this.dWl = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.atL = new LinearLayout(getContext());
        this.atL.setOrientation(0);
        this.atL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.atL);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.atU = (int) TypedValue.applyDimension(1, this.atU, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.awe = (int) TypedValue.applyDimension(1, this.awe, displayMetrics);
        this.aub = i;
        this.atV = i2;
        this.atR = z;
        this.atQ = new Paint();
        this.atQ.setAntiAlias(true);
        this.atQ.setStyle(Paint.Style.FILL);
        this.dWi = am.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.f(getContext(), d.e.ds20);
        this.atH = new LinearLayout.LayoutParams(-2, -1);
        this.atI = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.f(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.dWj = z;
        invalidate();
    }

    public boolean aDW() {
        return this.dWj;
    }

    public void setTabItemClicked(boolean z) {
        this.dWl = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.atM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dWh);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.atK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.atM != null && this.atM.getAdapter() != null && this.atM.getAdapter().getCount() != 0) {
            this.atL.removeAllViews();
            this.atN = this.atM.getAdapter().getCount();
            for (int i = 0; i < this.atN; i++) {
                j(i, this.atM.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.atO = PagerSlidingTabStrip.this.atM.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.atO, 0);
                }
            });
        }
    }

    private void j(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        a(i, textView);
    }

    private void a(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.atM.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new an("c12049").r("obj_locate", i + 1).af("obj_type", "1"));
                    PagerSlidingTabStrip.this.dWl = true;
                    if (PagerSlidingTabStrip.this.atM.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.atM.getAdapter()).mL(i);
                    }
                    PagerSlidingTabStrip.this.atM.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                    TiebaStatic.log(new an("c13172").r("obj_type", 2));
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.atL.addView(view, i, this.atR ? this.atI : this.atH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.atN; i++) {
            View childAt = this.atL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.auf);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aub);
                    if (i == this.atM.getCurrentItem()) {
                        textView.setTextColor(this.atS);
                    } else {
                        textView.setTextColor(this.atT);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.atN != 0) {
            int left = this.atL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.atU;
            }
            if (left != this.aue) {
                this.aue = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.atN != 0) {
            int height = getHeight();
            this.atQ.setColor(this.atS);
            View childAt = this.atL.getChildAt(this.atO);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.atP > 0.0f && this.atO < this.atN - 1) {
                View childAt2 = this.atL.getChildAt(this.atO + 1);
                left = (left * (1.0f - this.atP)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.atP);
                right = (right * (1.0f - this.atP)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.atP);
            }
            if (this.pp == null) {
                this.pp = new RectF(left, height - this.atV, right, height);
            } else {
                this.pp.set(left, height - this.atV, right, height);
            }
            canvas.drawRoundRect(this.pp, 10.0f, 10.0f, this.atQ);
            if (this.dWj) {
                View childAt3 = this.atL.getChildAt(this.dWk);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.dWi.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.dWi.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.atS = am.getColor(d.C0140d.cp_cont_b);
        this.atT = am.getColor(d.C0140d.cp_cont_j);
        this.dWi = am.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.atL.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dWl) {
                    PagerSlidingTabStrip.this.atO = i;
                    PagerSlidingTabStrip.this.atP = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.atL.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.atK != null) {
                    PagerSlidingTabStrip.this.atK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.atL.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.atM.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.atP = 0.0f;
                    PagerSlidingTabStrip.this.dWl = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.atK != null) {
                    PagerSlidingTabStrip.this.atK.onPageScrollStateChanged(i);
                }
                HomePageStatic.dSw = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.atK != null) {
                PagerSlidingTabStrip.this.atK.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dWl) {
                PagerSlidingTabStrip.this.atO = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.atP * PagerSlidingTabStrip.this.atL.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.atO = savedState.atO;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.atO = this.atO;
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
        int atO;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.atO = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.atO);
        }
    }

    public View mM(int i) {
        return this.atL.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.dWk = i;
    }
}
