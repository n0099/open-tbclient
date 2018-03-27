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
    private LinearLayout.LayoutParams aZG;
    private LinearLayout.LayoutParams aZH;
    public ViewPager.OnPageChangeListener aZJ;
    private LinearLayout aZK;
    private ViewPager aZL;
    private int aZM;
    private float aZN;
    private Paint aZO;
    private boolean aZP;
    private int aZQ;
    private int aZR;
    private int aZS;
    private int aZT;
    private int aZZ;
    private int bac;
    private int bad;
    private int bco;
    private int currentPosition;
    private int dividerPadding;
    private int ds20;
    private final a eik;
    private Drawable eil;
    private boolean eim;
    private boolean ein;
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
        this.eik = new a();
        this.currentPosition = 0;
        this.aZN = 0.0f;
        this.aZP = false;
        this.aZQ = aj.getColor(d.C0141d.cp_cont_b);
        this.aZR = aj.getColor(d.C0141d.cp_cont_j);
        this.aZS = 52;
        this.aZT = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.bco = 1;
        this.aZZ = 17;
        this.bac = 0;
        this.bad = d.f.pager_sliding_view;
        this.ein = false;
        this.isLoading = false;
    }

    public void g(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aZK = new LinearLayout(getContext());
        this.aZK.setOrientation(0);
        this.aZK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aZK);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aZS = (int) TypedValue.applyDimension(1, this.aZS, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bco = (int) TypedValue.applyDimension(1, this.bco, displayMetrics);
        this.aZZ = i;
        this.aZT = i2;
        this.aZP = z;
        this.aZO = new Paint();
        this.aZO.setAntiAlias(true);
        this.aZO.setStyle(Paint.Style.FILL);
        this.eil = aj.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.t(getContext(), d.e.ds20);
        this.aZG = new LinearLayout.LayoutParams(-2, -1);
        this.aZH = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.t(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.eim = z;
        invalidate();
    }

    public boolean aCD() {
        return this.eim;
    }

    public void setTabItemClicked(boolean z) {
        this.ein = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aZL = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eik);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aZJ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aZL != null && this.aZL.getAdapter() != null && this.aZL.getAdapter().getCount() != 0) {
            this.aZK.removeAllViews();
            this.aZM = this.aZL.getAdapter().getCount();
            for (int i = 0; i < this.aZM; i++) {
                h(i, this.aZL.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aZL.getCurrentItem();
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
                    if (PagerSlidingTabStrip.this.aZL.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").s("obj_locate", i + 1).ab("obj_type", "1"));
                    PagerSlidingTabStrip.this.ein = true;
                    if (PagerSlidingTabStrip.this.aZL.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.aZL.getAdapter()).oH(i);
                    }
                    PagerSlidingTabStrip.this.aZL.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aZK.addView(view, i, this.aZP ? this.aZH : this.aZG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aZM; i++) {
            View childAt = this.aZK.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bad);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aZZ);
                    if (i == this.aZL.getCurrentItem()) {
                        textView.setTextColor(this.aZQ);
                    } else {
                        textView.setTextColor(this.aZR);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aZM != 0) {
            int left = this.aZK.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aZS;
            }
            if (left != this.bac) {
                this.bac = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aZM != 0) {
            int height = getHeight();
            this.aZO.setColor(this.aZQ);
            View childAt = this.aZK.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aZN > 0.0f && this.currentPosition < this.aZM - 1) {
                View childAt2 = this.aZK.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aZN)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aZN);
                right = (right * (1.0f - this.aZN)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aZN);
            }
            canvas.drawRoundRect(new RectF(left, height - this.aZT, right, height), 10.0f, 10.0f, this.aZO);
            if (this.eim) {
                View childAt3 = this.aZK.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.eil.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.eil.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aZQ = aj.getColor(d.C0141d.cp_cont_b);
        this.aZR = aj.getColor(d.C0141d.cp_cont_j);
        this.eil = aj.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aZK.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.ein) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.aZN = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aZK.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aZJ != null) {
                    PagerSlidingTabStrip.this.aZJ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aZK.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aZL.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aZN = 0.0f;
                    PagerSlidingTabStrip.this.ein = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aZJ != null) {
                    PagerSlidingTabStrip.this.aZJ.onPageScrollStateChanged(i);
                }
                HomePageStatic.efz = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aZJ != null) {
                PagerSlidingTabStrip.this.aZJ.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.ein) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aZN * PagerSlidingTabStrip.this.aZK.getChildAt(i).getWidth()));
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
            /* renamed from: oI */
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
