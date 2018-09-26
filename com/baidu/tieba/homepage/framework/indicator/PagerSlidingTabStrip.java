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
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams awU;
    private LinearLayout.LayoutParams awV;
    public ViewPager.OnPageChangeListener awX;
    private LinearLayout awY;
    private ViewPager awZ;
    private int axa;
    private int axb;
    private float axc;
    private Paint axd;
    private boolean axe;
    private int axf;
    private int axg;
    private int axh;
    private int axi;
    private int axo;
    private int axr;
    private int axs;
    private int dividerPadding;
    private int dividerWidth;
    private int ds20;
    private final b edu;
    private Drawable edv;
    private boolean edw;
    private int edx;
    private boolean edy;
    private a edz;
    private boolean isLoading;
    private Locale locale;
    private RectF rL;
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
        this.edu = new b();
        this.axb = 0;
        this.axc = 0.0f;
        this.axe = false;
        this.axf = al.getColor(e.d.cp_cont_b);
        this.axg = al.getColor(e.d.cp_cont_j);
        this.axh = 52;
        this.axi = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.dividerWidth = 1;
        this.axo = 17;
        this.axr = 0;
        this.axs = e.f.pager_sliding_view;
        this.edy = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.awY = new LinearLayout(getContext());
        this.awY.setOrientation(0);
        this.awY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.awY);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.axh = (int) TypedValue.applyDimension(1, this.axh, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.axo = i;
        this.axi = i2;
        this.axe = z;
        this.axd = new Paint();
        this.axd.setAntiAlias(true);
        this.axd.setStyle(Paint.Style.FILL);
        this.edv = al.getDrawable(e.f.icon_news_down_bar_one);
        this.ds20 = l.h(getContext(), e.C0141e.ds20);
        this.awU = new LinearLayout.LayoutParams(-2, -1);
        this.awV = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.h(getContext(), e.C0141e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.edw = z;
        invalidate();
    }

    public boolean aGg() {
        return this.edw;
    }

    public void setTabItemClicked(boolean z) {
        this.edy = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.awZ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.edu);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.awX = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.awZ != null && this.awZ.getAdapter() != null && this.awZ.getAdapter().getCount() != 0) {
            this.awY.removeAllViews();
            this.axa = this.awZ.getAdapter().getCount();
            for (int i = 0; i < this.axa; i++) {
                j(i, this.awZ.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.axb = PagerSlidingTabStrip.this.awZ.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.axb, 0);
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
                    if (PagerSlidingTabStrip.this.edz != null) {
                        PagerSlidingTabStrip.this.edz.r(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.awZ.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new am("c12049").w("obj_locate", i + 1).al("obj_type", "1"));
                    PagerSlidingTabStrip.this.edy = true;
                    if (PagerSlidingTabStrip.this.awZ.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.awZ.getAdapter()).np(i);
                    }
                    PagerSlidingTabStrip.this.awZ.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.awY.addView(view, i, this.axe ? this.awV : this.awU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.axa; i++) {
            View childAt = this.awY.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.axs);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.axo);
                    if (i == this.awZ.getCurrentItem()) {
                        textView.setTextColor(this.axf);
                    } else {
                        textView.setTextColor(this.axg);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.axa != 0) {
            int left = this.awY.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.axh;
            }
            if (left != this.axr) {
                this.axr = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.axa != 0) {
            int height = getHeight();
            this.axd.setColor(this.axf);
            View childAt = this.awY.getChildAt(this.axb);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.axc > 0.0f && this.axb < this.axa - 1) {
                View childAt2 = this.awY.getChildAt(this.axb + 1);
                left = (left * (1.0f - this.axc)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.axc);
                right = (right * (1.0f - this.axc)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.axc);
            }
            if (this.rL == null) {
                this.rL = new RectF(left, height - this.axi, right, height);
            } else {
                this.rL.set(left, height - this.axi, right, height);
            }
            canvas.drawRoundRect(this.rL, 10.0f, 10.0f, this.axd);
            if (this.edw) {
                View childAt3 = this.awY.getChildAt(this.edx);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.edv.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.edv.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.axf = al.getColor(e.d.cp_cont_b);
        this.axg = al.getColor(e.d.cp_cont_j);
        this.edv = al.getDrawable(e.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.awY.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.edy) {
                    PagerSlidingTabStrip.this.axb = i;
                    PagerSlidingTabStrip.this.axc = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.awY.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.awX != null) {
                    PagerSlidingTabStrip.this.awX.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.awY.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.awZ.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.axc = 0.0f;
                    PagerSlidingTabStrip.this.edy = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.awX != null) {
                    PagerSlidingTabStrip.this.awX.onPageScrollStateChanged(i);
                }
                HomePageStatic.dZI = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.awX != null) {
                PagerSlidingTabStrip.this.awX.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.edy) {
                PagerSlidingTabStrip.this.axb = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.axc * PagerSlidingTabStrip.this.awY.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.axb = savedState.axb;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.axb = this.axb;
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
            /* renamed from: nr */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int axb;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.axb = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.axb);
        }
    }

    public View nq(int i) {
        return this.awY.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.edx = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.edz = aVar;
    }
}
