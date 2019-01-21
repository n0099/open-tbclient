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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes6.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    public ViewPager.OnPageChangeListener aGA;
    private LinearLayout aGB;
    private ViewPager aGC;
    private int aGD;
    private int aGE;
    private float aGF;
    private Paint aGG;
    private boolean aGH;
    private int aGI;
    private int aGJ;
    private int aGK;
    private int aGL;
    private int aGR;
    private int aGU;
    private int aGV;
    private LinearLayout.LayoutParams aGx;
    private LinearLayout.LayoutParams aGy;
    private int dividerPadding;
    private int dividerWidth;
    private int ds20;
    private final b exe;
    private Drawable exf;
    private boolean exg;
    private int exh;
    private boolean exi;
    private a exj;
    private boolean isLoading;
    private Locale locale;
    private RectF sD;
    private int tabPadding;

    /* loaded from: classes6.dex */
    public interface a {
        void s(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.exe = new b();
        this.aGE = 0;
        this.aGF = 0.0f;
        this.aGH = false;
        this.aGI = al.getColor(e.d.cp_cont_b);
        this.aGJ = al.getColor(e.d.cp_cont_j);
        this.aGK = 52;
        this.aGL = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.dividerWidth = 1;
        this.aGR = 17;
        this.aGU = 0;
        this.aGV = e.f.pager_sliding_view;
        this.exi = false;
        this.isLoading = false;
    }

    public void e(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aGB = new LinearLayout(getContext());
        this.aGB.setOrientation(0);
        this.aGB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aGB);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aGK = (int) TypedValue.applyDimension(1, this.aGK, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aGR = i;
        this.aGL = i2;
        this.aGH = z;
        this.aGG = new Paint();
        this.aGG.setAntiAlias(true);
        this.aGG.setStyle(Paint.Style.FILL);
        this.exf = al.getDrawable(e.f.icon_news_down_bar_one);
        this.ds20 = l.h(getContext(), e.C0210e.ds20);
        this.aGx = new LinearLayout.LayoutParams(-2, -1);
        this.aGy = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.h(getContext(), e.C0210e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.exg = z;
        invalidate();
    }

    public boolean aMa() {
        return this.exg;
    }

    public void setTabItemClicked(boolean z) {
        this.exi = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aGC = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.exe);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aGA = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aGC != null && this.aGC.getAdapter() != null && this.aGC.getAdapter().getCount() != 0) {
            this.aGB.removeAllViews();
            this.aGD = this.aGC.getAdapter().getCount();
            for (int i = 0; i < this.aGD; i++) {
                k(i, this.aGC.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.aGE = PagerSlidingTabStrip.this.aGC.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGE, 0);
                }
            });
        }
    }

    private void k(int i, String str) {
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
                    if (PagerSlidingTabStrip.this.exj != null) {
                        PagerSlidingTabStrip.this.exj.s(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.aGC.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new am("c12049").y("obj_locate", i + 1).aB("obj_type", "1"));
                    PagerSlidingTabStrip.this.exi = true;
                    if (PagerSlidingTabStrip.this.aGC.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.aGC.getAdapter()).oN(i);
                    }
                    PagerSlidingTabStrip.this.aGC.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aGB.addView(view, i, this.aGH ? this.aGy : this.aGx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aGD; i++) {
            View childAt = this.aGB.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGV);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGR);
                    if (i == this.aGC.getCurrentItem()) {
                        textView.setTextColor(this.aGI);
                    } else {
                        textView.setTextColor(this.aGJ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aGD != 0) {
            int left = this.aGB.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGK;
            }
            if (left != this.aGU) {
                this.aGU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aGD != 0) {
            int height = getHeight();
            this.aGG.setColor(this.aGI);
            View childAt = this.aGB.getChildAt(this.aGE);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aGF > 0.0f && this.aGE < this.aGD - 1) {
                View childAt2 = this.aGB.getChildAt(this.aGE + 1);
                left = (left * (1.0f - this.aGF)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aGF);
                right = (right * (1.0f - this.aGF)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aGF);
            }
            if (this.sD == null) {
                this.sD = new RectF(left, height - this.aGL, right, height);
            } else {
                this.sD.set(left, height - this.aGL, right, height);
            }
            canvas.drawRoundRect(this.sD, 10.0f, 10.0f, this.aGG);
            if (this.exg) {
                View childAt3 = this.aGB.getChildAt(this.exh);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.exf.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.exf.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aGI = al.getColor(e.d.cp_cont_b);
        this.aGJ = al.getColor(e.d.cp_cont_j);
        this.exf = al.getDrawable(e.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes6.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aGB.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.exi) {
                    PagerSlidingTabStrip.this.aGE = i;
                    PagerSlidingTabStrip.this.aGF = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aGB.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aGA != null) {
                    PagerSlidingTabStrip.this.aGA.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aGB.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGC.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aGF = 0.0f;
                    PagerSlidingTabStrip.this.exi = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aGA != null) {
                    PagerSlidingTabStrip.this.aGA.onPageScrollStateChanged(i);
                }
                HomePageStatic.etp = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aGA != null) {
                PagerSlidingTabStrip.this.aGA.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.exi) {
                PagerSlidingTabStrip.this.aGE = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aGF * PagerSlidingTabStrip.this.aGB.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGE = savedState.aGE;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGE = this.aGE;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: o */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oP */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aGE;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGE = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGE);
        }
    }

    public View oO(int i) {
        return this.aGB.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.exh = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.exj = aVar;
    }
}
