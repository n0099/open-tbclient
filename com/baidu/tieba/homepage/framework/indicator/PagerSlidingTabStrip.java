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
    private int ajA;
    private float ajB;
    private Paint ajC;
    private boolean ajD;
    private int ajE;
    private int ajF;
    private int ajG;
    private int ajH;
    private int ajN;
    private int ajQ;
    private int ajR;
    private LinearLayout.LayoutParams aju;
    private LinearLayout.LayoutParams ajv;
    public ViewPager.OnPageChangeListener ajx;
    private LinearLayout ajy;
    private ViewPager ajz;
    private int ame;
    private int amf;
    private int currentPosition;
    private final a dfV;
    private Drawable dfW;
    private boolean dfX;
    private boolean dfY;
    private int dividerPadding;
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
        this.dfV = new a();
        this.currentPosition = 0;
        this.ajB = 0.0f;
        this.ajD = false;
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_j);
        this.ajG = 52;
        this.ajH = 4;
        this.dividerPadding = 12;
        this.ame = 28;
        this.amf = 1;
        this.ajN = 17;
        this.ajQ = 0;
        this.ajR = d.f.pager_sliding_view;
        this.dfY = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajy = new LinearLayout(getContext());
        this.ajy.setOrientation(0);
        this.ajy.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajy);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ajG = (int) TypedValue.applyDimension(1, this.ajG, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.ame = (int) TypedValue.applyDimension(1, this.ame, displayMetrics);
        this.amf = (int) TypedValue.applyDimension(1, this.amf, displayMetrics);
        this.ajN = i;
        this.ajH = i2;
        this.ajD = z;
        this.ajC = new Paint();
        this.ajC.setAntiAlias(true);
        this.ajC.setStyle(Paint.Style.FILL);
        this.dfW = aj.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.f(getContext(), d.e.ds20);
        this.aju = new LinearLayout.LayoutParams(-2, -1);
        this.ajv = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.ame = l.f(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.dfX = z;
        invalidate();
    }

    public boolean arH() {
        return this.dfX;
    }

    public void setTabItemClicked(boolean z) {
        this.dfY = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajz = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dfV);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajx = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajz != null && this.ajz.getAdapter() != null && this.ajz.getAdapter().getCount() != 0) {
            this.ajy.removeAllViews();
            this.ajA = this.ajz.getAdapter().getCount();
            for (int i = 0; i < this.ajA; i++) {
                i(i, this.ajz.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.ajz.getCurrentItem();
                    PagerSlidingTabStrip.this.x(PagerSlidingTabStrip.this.currentPosition, 0);
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
                    if (PagerSlidingTabStrip.this.ajz.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").r("obj_locate", i + 1).ac("obj_type", "1"));
                    PagerSlidingTabStrip.this.dfY = true;
                    if (PagerSlidingTabStrip.this.ajz.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.ajz.getAdapter()).lq(i);
                    }
                    PagerSlidingTabStrip.this.ajz.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.ame, 0, this.ame, 0);
        this.ajy.addView(view, i, this.ajD ? this.ajv : this.aju);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ajA; i++) {
            View childAt = this.ajy.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ajR);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ajN);
                    if (i == this.ajz.getCurrentItem()) {
                        textView.setTextColor(this.ajE);
                    } else {
                        textView.setTextColor(this.ajF);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, int i2) {
        if (this.ajA != 0) {
            int left = this.ajy.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ajG;
            }
            if (left != this.ajQ) {
                this.ajQ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajA != 0) {
            int height = getHeight();
            this.ajC.setColor(this.ajE);
            View childAt = this.ajy.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.ajB > 0.0f && this.currentPosition < this.ajA - 1) {
                View childAt2 = this.ajy.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ajB)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.ajB);
                right = (right * (1.0f - this.ajB)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.ajB);
            }
            canvas.drawRoundRect(new RectF(left, height - this.ajH, right, height), 10.0f, 10.0f, this.ajC);
            if (this.dfX) {
                View childAt3 = this.ajy.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.dfW.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.dfW.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.ajE = aj.getColor(d.C0080d.cp_cont_b);
        this.ajF = aj.getColor(d.C0080d.cp_cont_j);
        this.dfW = aj.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.ajy.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dfY) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.ajB = f;
                    PagerSlidingTabStrip.this.x(i, (int) (PagerSlidingTabStrip.this.ajy.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.ajx != null) {
                    PagerSlidingTabStrip.this.ajx.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ajy.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.x(PagerSlidingTabStrip.this.ajz.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.ajB = 0.0f;
                    PagerSlidingTabStrip.this.dfY = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.ajx != null) {
                    PagerSlidingTabStrip.this.ajx.onPageScrollStateChanged(i);
                }
                HomePageStatic.ddm = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ajx != null) {
                PagerSlidingTabStrip.this.ajx.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dfY) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.x(i, (int) (PagerSlidingTabStrip.this.ajB * PagerSlidingTabStrip.this.ajy.getChildAt(i).getWidth()));
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
            /* renamed from: lr */
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
