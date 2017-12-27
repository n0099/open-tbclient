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
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams aXZ;
    private LinearLayout.LayoutParams aYa;
    public ViewPager.OnPageChangeListener aYc;
    private LinearLayout aYd;
    private ViewPager aYe;
    private int aYf;
    private float aYg;
    private Paint aYh;
    private boolean aYi;
    private int aYj;
    private int aYk;
    private int aYl;
    private int aYm;
    private int aYs;
    private int aYv;
    private int aYw;
    private int baz;
    private int currentPosition;
    private int dividerPadding;
    private int ds20;
    private final a eco;
    private Drawable ecp;
    private boolean ecq;
    private boolean ecr;
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
        this.eco = new a();
        this.currentPosition = 0;
        this.aYg = 0.0f;
        this.aYi = false;
        this.aYj = aj.getColor(d.C0108d.cp_cont_b);
        this.aYk = aj.getColor(d.C0108d.cp_cont_j);
        this.aYl = 52;
        this.aYm = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.baz = 1;
        this.aYs = 17;
        this.aYv = 0;
        this.aYw = d.f.pager_sliding_view;
        this.ecr = false;
        this.isLoading = false;
    }

    public void g(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aYd = new LinearLayout(getContext());
        this.aYd.setOrientation(0);
        this.aYd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aYd);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aYl = (int) TypedValue.applyDimension(1, this.aYl, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.baz = (int) TypedValue.applyDimension(1, this.baz, displayMetrics);
        this.aYs = i;
        this.aYm = i2;
        this.aYi = z;
        this.aYh = new Paint();
        this.aYh.setAntiAlias(true);
        this.aYh.setStyle(Paint.Style.FILL);
        this.ecp = aj.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.s(getContext(), d.e.ds20);
        this.aXZ = new LinearLayout.LayoutParams(-2, -1);
        this.aYa = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.s(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.ecq = z;
        invalidate();
    }

    public boolean aBc() {
        return this.ecq;
    }

    public void setTabItemClicked(boolean z) {
        this.ecr = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aYe = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eco);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aYc = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aYe != null && this.aYe.getAdapter() != null && this.aYe.getAdapter().getCount() != 0) {
            this.aYd.removeAllViews();
            this.aYf = this.aYe.getAdapter().getCount();
            for (int i = 0; i < this.aYf; i++) {
                h(i, this.aYe.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aYe.getCurrentItem();
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
                    if (PagerSlidingTabStrip.this.aYe.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").s("obj_locate", i + 1).ab("obj_type", "1"));
                    PagerSlidingTabStrip.this.ecr = true;
                    if (PagerSlidingTabStrip.this.aYe.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.aYe.getAdapter()).oM(i);
                    }
                    PagerSlidingTabStrip.this.aYe.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aYd.addView(view, i, this.aYi ? this.aYa : this.aXZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aYf; i++) {
            View childAt = this.aYd.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aYw);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aYs);
                    if (i == this.aYe.getCurrentItem()) {
                        textView.setTextColor(this.aYj);
                    } else {
                        textView.setTextColor(this.aYk);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aYf != 0) {
            int left = this.aYd.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aYl;
            }
            if (left != this.aYv) {
                this.aYv = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aYf != 0) {
            int height = getHeight();
            this.aYh.setColor(this.aYj);
            View childAt = this.aYd.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aYg > 0.0f && this.currentPosition < this.aYf - 1) {
                View childAt2 = this.aYd.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aYg)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aYg);
                right = (right * (1.0f - this.aYg)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aYg);
            }
            canvas.drawRoundRect(new RectF(left, height - this.aYm, right, height), 10.0f, 10.0f, this.aYh);
            if (this.ecq) {
                View childAt3 = this.aYd.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.ecp.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.ecp.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aYj = aj.getColor(d.C0108d.cp_cont_b);
        this.aYk = aj.getColor(d.C0108d.cp_cont_j);
        this.ecp = aj.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aYd.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.ecr) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.aYg = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aYd.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aYc != null) {
                    PagerSlidingTabStrip.this.aYc.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aYd.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aYe.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aYg = 0.0f;
                    PagerSlidingTabStrip.this.ecr = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aYc != null) {
                    PagerSlidingTabStrip.this.aYc.onPageScrollStateChanged(i);
                }
                HomePageStatic.dZD = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aYc != null) {
                PagerSlidingTabStrip.this.aYc.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.ecr) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aYg * PagerSlidingTabStrip.this.aYd.getChildAt(i).getWidth()));
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
            /* renamed from: z */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oN */
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
