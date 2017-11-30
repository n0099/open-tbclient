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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams ajQ;
    private LinearLayout.LayoutParams ajR;
    public ViewPager.OnPageChangeListener ajT;
    private LinearLayout ajU;
    private ViewPager ajV;
    private int ajW;
    private float ajX;
    private Paint ajY;
    private boolean ajZ;
    private int aka;
    private int akb;
    private int akc;
    private int akd;
    private int akj;
    private int akm;
    private int akn;
    private int amA;
    private int amz;
    private int currentPosition;
    private int dividerPadding;
    private final a doV;
    private Drawable doW;
    private boolean doX;
    private boolean doY;
    private int ds20;
    private boolean isLoading;
    private Locale locale;

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.doV = new a();
        this.currentPosition = 0;
        this.ajX = 0.0f;
        this.ajZ = false;
        this.aka = aj.getColor(d.C0082d.cp_cont_b);
        this.akb = aj.getColor(d.C0082d.cp_cont_j);
        this.akc = 52;
        this.akd = 4;
        this.dividerPadding = 12;
        this.amz = 28;
        this.amA = 1;
        this.akj = 17;
        this.akm = 0;
        this.akn = d.f.pager_sliding_view;
        this.doY = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajU = new LinearLayout(getContext());
        this.ajU.setOrientation(0);
        this.ajU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajU);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.akc = (int) TypedValue.applyDimension(1, this.akc, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.amz = (int) TypedValue.applyDimension(1, this.amz, displayMetrics);
        this.amA = (int) TypedValue.applyDimension(1, this.amA, displayMetrics);
        this.akj = i;
        this.akd = i2;
        this.ajZ = z;
        this.ajY = new Paint();
        this.ajY.setAntiAlias(true);
        this.ajY.setStyle(Paint.Style.FILL);
        this.doW = aj.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.f(getContext(), d.e.ds20);
        this.ajQ = new LinearLayout.LayoutParams(-2, -1);
        this.ajR = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.amz = l.f(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.doX = z;
        invalidate();
    }

    public boolean atQ() {
        return this.doX;
    }

    public void setTabItemClicked(boolean z) {
        this.doY = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.doV);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajV != null && this.ajV.getAdapter() != null && this.ajV.getAdapter().getCount() != 0) {
            this.ajU.removeAllViews();
            this.ajW = this.ajV.getAdapter().getCount();
            for (int i = 0; i < this.ajW; i++) {
                i(i, this.ajV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.ajV.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.currentPosition, 0);
                }
            });
        }
    }

    private void i(int i, String str) {
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
                    if (PagerSlidingTabStrip.this.ajV.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").r("obj_locate", i + 1).ac("obj_type", "1"));
                    PagerSlidingTabStrip.this.doY = true;
                    if (PagerSlidingTabStrip.this.ajV.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.ajV.getAdapter()).lO(i);
                    }
                    PagerSlidingTabStrip.this.ajV.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.amz, 0, this.amz, 0);
        this.ajU.addView(view, i, this.ajZ ? this.ajR : this.ajQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ajW; i++) {
            View childAt = this.ajU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.akn);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.akj);
                    if (i == this.ajV.getCurrentItem()) {
                        textView.setTextColor(this.aka);
                    } else {
                        textView.setTextColor(this.akb);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ajW != 0) {
            int left = this.ajU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.akc;
            }
            if (left != this.akm) {
                this.akm = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajW != 0) {
            int height = getHeight();
            this.ajY.setColor(this.aka);
            View childAt = this.ajU.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.ajX > 0.0f && this.currentPosition < this.ajW - 1) {
                View childAt2 = this.ajU.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ajX)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.ajX);
                right = (right * (1.0f - this.ajX)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.ajX);
            }
            canvas.drawRoundRect(new RectF(left, height - this.akd, right, height), 10.0f, 10.0f, this.ajY);
            if (this.doX) {
                View childAt3 = this.ajU.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.doW.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.doW.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aka = aj.getColor(d.C0082d.cp_cont_b);
        this.akb = aj.getColor(d.C0082d.cp_cont_j);
        this.doW = aj.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.ajU.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.doY) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.ajX = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.ajU.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.ajT != null) {
                    PagerSlidingTabStrip.this.ajT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ajU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.ajV.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.ajX = 0.0f;
                    PagerSlidingTabStrip.this.doY = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.ajT != null) {
                    PagerSlidingTabStrip.this.ajT.onPageScrollStateChanged(i);
                }
                HomePageStatic.dmm = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ajT != null) {
                PagerSlidingTabStrip.this.ajT.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.doY) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.ajX * PagerSlidingTabStrip.this.ajU.getChildAt(i).getWidth()));
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
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: j */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lP */
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
