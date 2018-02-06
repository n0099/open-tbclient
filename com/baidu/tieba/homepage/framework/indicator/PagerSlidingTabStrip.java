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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams aZQ;
    private LinearLayout.LayoutParams aZR;
    public ViewPager.OnPageChangeListener aZT;
    private LinearLayout aZU;
    private ViewPager aZV;
    private int aZW;
    private float aZX;
    private Paint aZY;
    private boolean aZZ;
    private int baa;
    private int bab;
    private int bac;
    private int bad;
    private int baj;
    private int bam;
    private int ban;
    private int bcy;
    private int currentPosition;
    private int dividerPadding;
    private int ds20;
    private final a eig;
    private Drawable eih;
    private boolean eii;
    private boolean eij;
    private boolean isLoading;
    private Locale locale;
    private int tabPadding;

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eig = new a();
        this.currentPosition = 0;
        this.aZX = 0.0f;
        this.aZZ = false;
        this.baa = aj.getColor(d.C0140d.cp_cont_b);
        this.bab = aj.getColor(d.C0140d.cp_cont_j);
        this.bac = 52;
        this.bad = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.bcy = 1;
        this.baj = 17;
        this.bam = 0;
        this.ban = d.f.pager_sliding_view;
        this.eij = false;
        this.isLoading = false;
    }

    public void g(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aZU = new LinearLayout(getContext());
        this.aZU.setOrientation(0);
        this.aZU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aZU);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.bac = (int) TypedValue.applyDimension(1, this.bac, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bcy = (int) TypedValue.applyDimension(1, this.bcy, displayMetrics);
        this.baj = i;
        this.bad = i2;
        this.aZZ = z;
        this.aZY = new Paint();
        this.aZY.setAntiAlias(true);
        this.aZY.setStyle(Paint.Style.FILL);
        this.eih = aj.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.t(getContext(), d.e.ds20);
        this.aZQ = new LinearLayout.LayoutParams(-2, -1);
        this.aZR = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.t(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.eii = z;
        invalidate();
    }

    public boolean aCD() {
        return this.eii;
    }

    public void setTabItemClicked(boolean z) {
        this.eij = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aZV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eig);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aZT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aZV != null && this.aZV.getAdapter() != null && this.aZV.getAdapter().getCount() != 0) {
            this.aZU.removeAllViews();
            this.aZW = this.aZV.getAdapter().getCount();
            for (int i = 0; i < this.aZW; i++) {
                h(i, this.aZV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aZV.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.currentPosition, 0);
                }
            });
        }
    }

    private void h(int i, String str) {
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
                    if (PagerSlidingTabStrip.this.aZV.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").s("obj_locate", i + 1).ab("obj_type", "1"));
                    PagerSlidingTabStrip.this.eij = true;
                    if (PagerSlidingTabStrip.this.aZV.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.aZV.getAdapter()).oG(i);
                    }
                    PagerSlidingTabStrip.this.aZV.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aZU.addView(view, i, this.aZZ ? this.aZR : this.aZQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aZW; i++) {
            View childAt = this.aZU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ban);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.baj);
                    if (i == this.aZV.getCurrentItem()) {
                        textView.setTextColor(this.baa);
                    } else {
                        textView.setTextColor(this.bab);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aZW != 0) {
            int left = this.aZU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.bac;
            }
            if (left != this.bam) {
                this.bam = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aZW != 0) {
            int height = getHeight();
            this.aZY.setColor(this.baa);
            View childAt = this.aZU.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aZX > 0.0f && this.currentPosition < this.aZW - 1) {
                View childAt2 = this.aZU.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aZX)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aZX);
                right = (right * (1.0f - this.aZX)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aZX);
            }
            canvas.drawRoundRect(new RectF(left, height - this.bad, right, height), 10.0f, 10.0f, this.aZY);
            if (this.eii) {
                View childAt3 = this.aZU.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.eih.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.eih.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.baa = aj.getColor(d.C0140d.cp_cont_b);
        this.bab = aj.getColor(d.C0140d.cp_cont_j);
        this.eih = aj.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aZU.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.eij) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.aZX = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aZU.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aZT != null) {
                    PagerSlidingTabStrip.this.aZT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aZU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aZV.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aZX = 0.0f;
                    PagerSlidingTabStrip.this.eij = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aZT != null) {
                    PagerSlidingTabStrip.this.aZT.onPageScrollStateChanged(i);
                }
                HomePageStatic.efv = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aZT != null) {
                PagerSlidingTabStrip.this.aZT.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.eij) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aZX * PagerSlidingTabStrip.this.aZU.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: A */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oH */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int currentPosition;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }
    }
}
