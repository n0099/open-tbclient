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
    private LinearLayout aGA;
    private ViewPager aGB;
    private int aGC;
    private int aGD;
    private float aGE;
    private Paint aGF;
    private boolean aGG;
    private int aGH;
    private int aGI;
    private int aGJ;
    private int aGK;
    private int aGQ;
    private int aGT;
    private int aGU;
    private LinearLayout.LayoutParams aGw;
    private LinearLayout.LayoutParams aGx;
    public ViewPager.OnPageChangeListener aGz;
    private int dividerPadding;
    private int dividerWidth;
    private int ds20;
    private final b exd;
    private Drawable exe;
    private boolean exf;
    private int exg;
    private boolean exh;
    private a exi;
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
        this.exd = new b();
        this.aGD = 0;
        this.aGE = 0.0f;
        this.aGG = false;
        this.aGH = al.getColor(e.d.cp_cont_b);
        this.aGI = al.getColor(e.d.cp_cont_j);
        this.aGJ = 52;
        this.aGK = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.dividerWidth = 1;
        this.aGQ = 17;
        this.aGT = 0;
        this.aGU = e.f.pager_sliding_view;
        this.exh = false;
        this.isLoading = false;
    }

    public void e(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aGA = new LinearLayout(getContext());
        this.aGA.setOrientation(0);
        this.aGA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aGA);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aGJ = (int) TypedValue.applyDimension(1, this.aGJ, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aGQ = i;
        this.aGK = i2;
        this.aGG = z;
        this.aGF = new Paint();
        this.aGF.setAntiAlias(true);
        this.aGF.setStyle(Paint.Style.FILL);
        this.exe = al.getDrawable(e.f.icon_news_down_bar_one);
        this.ds20 = l.h(getContext(), e.C0210e.ds20);
        this.aGw = new LinearLayout.LayoutParams(-2, -1);
        this.aGx = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.h(getContext(), e.C0210e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.exf = z;
        invalidate();
    }

    public boolean aMa() {
        return this.exf;
    }

    public void setTabItemClicked(boolean z) {
        this.exh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aGB = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.exd);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aGz = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aGB != null && this.aGB.getAdapter() != null && this.aGB.getAdapter().getCount() != 0) {
            this.aGA.removeAllViews();
            this.aGC = this.aGB.getAdapter().getCount();
            for (int i = 0; i < this.aGC; i++) {
                k(i, this.aGB.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.aGD = PagerSlidingTabStrip.this.aGB.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGD, 0);
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
                    if (PagerSlidingTabStrip.this.exi != null) {
                        PagerSlidingTabStrip.this.exi.s(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.aGB.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new am("c12049").y("obj_locate", i + 1).aB("obj_type", "1"));
                    PagerSlidingTabStrip.this.exh = true;
                    if (PagerSlidingTabStrip.this.aGB.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.aGB.getAdapter()).oN(i);
                    }
                    PagerSlidingTabStrip.this.aGB.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aGA.addView(view, i, this.aGG ? this.aGx : this.aGw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aGC; i++) {
            View childAt = this.aGA.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGU);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGQ);
                    if (i == this.aGB.getCurrentItem()) {
                        textView.setTextColor(this.aGH);
                    } else {
                        textView.setTextColor(this.aGI);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aGC != 0) {
            int left = this.aGA.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGJ;
            }
            if (left != this.aGT) {
                this.aGT = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aGC != 0) {
            int height = getHeight();
            this.aGF.setColor(this.aGH);
            View childAt = this.aGA.getChildAt(this.aGD);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aGE > 0.0f && this.aGD < this.aGC - 1) {
                View childAt2 = this.aGA.getChildAt(this.aGD + 1);
                left = (left * (1.0f - this.aGE)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aGE);
                right = (right * (1.0f - this.aGE)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aGE);
            }
            if (this.sD == null) {
                this.sD = new RectF(left, height - this.aGK, right, height);
            } else {
                this.sD.set(left, height - this.aGK, right, height);
            }
            canvas.drawRoundRect(this.sD, 10.0f, 10.0f, this.aGF);
            if (this.exf) {
                View childAt3 = this.aGA.getChildAt(this.exg);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.exe.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.exe.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aGH = al.getColor(e.d.cp_cont_b);
        this.aGI = al.getColor(e.d.cp_cont_j);
        this.exe = al.getDrawable(e.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes6.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aGA.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.exh) {
                    PagerSlidingTabStrip.this.aGD = i;
                    PagerSlidingTabStrip.this.aGE = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aGA.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aGz != null) {
                    PagerSlidingTabStrip.this.aGz.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aGA.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGB.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aGE = 0.0f;
                    PagerSlidingTabStrip.this.exh = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aGz != null) {
                    PagerSlidingTabStrip.this.aGz.onPageScrollStateChanged(i);
                }
                HomePageStatic.eto = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aGz != null) {
                PagerSlidingTabStrip.this.aGz.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.exh) {
                PagerSlidingTabStrip.this.aGD = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aGE * PagerSlidingTabStrip.this.aGA.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGD = savedState.aGD;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGD = this.aGD;
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
        int aGD;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGD = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGD);
        }
    }

    public View oO(int i) {
        return this.aGA.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.exg = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.exi = aVar;
    }
}
