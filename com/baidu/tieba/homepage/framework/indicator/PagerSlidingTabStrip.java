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
    private LinearLayout.LayoutParams aZE;
    private LinearLayout.LayoutParams aZF;
    public ViewPager.OnPageChangeListener aZH;
    private LinearLayout aZI;
    private ViewPager aZJ;
    private int aZK;
    private float aZL;
    private Paint aZM;
    private boolean aZN;
    private int aZO;
    private int aZP;
    private int aZQ;
    private int aZR;
    private int aZX;
    private int baa;
    private int bab;
    private int bcm;
    private int currentPosition;
    private int dividerPadding;
    private int ds20;
    private final a ehU;
    private Drawable ehV;
    private boolean ehW;
    private boolean ehX;
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
        this.ehU = new a();
        this.currentPosition = 0;
        this.aZL = 0.0f;
        this.aZN = false;
        this.aZO = aj.getColor(d.C0141d.cp_cont_b);
        this.aZP = aj.getColor(d.C0141d.cp_cont_j);
        this.aZQ = 52;
        this.aZR = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.bcm = 1;
        this.aZX = 17;
        this.baa = 0;
        this.bab = d.f.pager_sliding_view;
        this.ehX = false;
        this.isLoading = false;
    }

    public void g(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aZI = new LinearLayout(getContext());
        this.aZI.setOrientation(0);
        this.aZI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aZI);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aZQ = (int) TypedValue.applyDimension(1, this.aZQ, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bcm = (int) TypedValue.applyDimension(1, this.bcm, displayMetrics);
        this.aZX = i;
        this.aZR = i2;
        this.aZN = z;
        this.aZM = new Paint();
        this.aZM.setAntiAlias(true);
        this.aZM.setStyle(Paint.Style.FILL);
        this.ehV = aj.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.t(getContext(), d.e.ds20);
        this.aZE = new LinearLayout.LayoutParams(-2, -1);
        this.aZF = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.t(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.ehW = z;
        invalidate();
    }

    public boolean aCC() {
        return this.ehW;
    }

    public void setTabItemClicked(boolean z) {
        this.ehX = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aZJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ehU);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aZH = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aZJ != null && this.aZJ.getAdapter() != null && this.aZJ.getAdapter().getCount() != 0) {
            this.aZI.removeAllViews();
            this.aZK = this.aZJ.getAdapter().getCount();
            for (int i = 0; i < this.aZK; i++) {
                h(i, this.aZJ.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aZJ.getCurrentItem();
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
                    if (PagerSlidingTabStrip.this.aZJ.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").s("obj_locate", i + 1).ab("obj_type", "1"));
                    PagerSlidingTabStrip.this.ehX = true;
                    if (PagerSlidingTabStrip.this.aZJ.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.aZJ.getAdapter()).oG(i);
                    }
                    PagerSlidingTabStrip.this.aZJ.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aZI.addView(view, i, this.aZN ? this.aZF : this.aZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aZK; i++) {
            View childAt = this.aZI.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bab);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aZX);
                    if (i == this.aZJ.getCurrentItem()) {
                        textView.setTextColor(this.aZO);
                    } else {
                        textView.setTextColor(this.aZP);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aZK != 0) {
            int left = this.aZI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aZQ;
            }
            if (left != this.baa) {
                this.baa = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aZK != 0) {
            int height = getHeight();
            this.aZM.setColor(this.aZO);
            View childAt = this.aZI.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aZL > 0.0f && this.currentPosition < this.aZK - 1) {
                View childAt2 = this.aZI.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aZL)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aZL);
                right = (right * (1.0f - this.aZL)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aZL);
            }
            canvas.drawRoundRect(new RectF(left, height - this.aZR, right, height), 10.0f, 10.0f, this.aZM);
            if (this.ehW) {
                View childAt3 = this.aZI.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.ehV.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.ehV.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aZO = aj.getColor(d.C0141d.cp_cont_b);
        this.aZP = aj.getColor(d.C0141d.cp_cont_j);
        this.ehV = aj.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aZI.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.ehX) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.aZL = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aZI.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aZH != null) {
                    PagerSlidingTabStrip.this.aZH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aZI.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aZJ.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aZL = 0.0f;
                    PagerSlidingTabStrip.this.ehX = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aZH != null) {
                    PagerSlidingTabStrip.this.aZH.onPageScrollStateChanged(i);
                }
                HomePageStatic.efj = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aZH != null) {
                PagerSlidingTabStrip.this.aZH.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.ehX) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aZL * PagerSlidingTabStrip.this.aZI.getChildAt(i).getWidth()));
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
