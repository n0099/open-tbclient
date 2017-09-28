package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
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
    private int ajD;
    private int ajG;
    private int ajH;
    private LinearLayout.LayoutParams ajk;
    private LinearLayout.LayoutParams ajl;
    public ViewPager.OnPageChangeListener ajn;
    private LinearLayout ajo;
    private ViewPager ajp;
    private int ajq;
    private float ajr;
    private Paint ajs;
    private boolean ajt;
    private int aju;
    private int ajv;
    private int ajw;
    private int ajx;
    private int alU;
    private int alV;
    private final a cXP;
    private Drawable cXQ;
    private boolean cXR;
    private boolean cXS;
    private int currentPosition;
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
        this.cXP = new a();
        this.currentPosition = 0;
        this.ajr = 0.0f;
        this.ajt = false;
        this.aju = aj.getColor(d.e.cp_cont_b);
        this.ajv = aj.getColor(d.e.cp_cont_f);
        this.ajw = 52;
        this.ajx = 4;
        this.dividerPadding = 12;
        this.alU = 24;
        this.alV = 1;
        this.ajD = 12;
        this.ajG = 0;
        this.ajH = d.g.pager_sliding_view;
        this.cXS = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajo = new LinearLayout(getContext());
        this.ajo.setOrientation(0);
        this.ajo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajo);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ajw = (int) TypedValue.applyDimension(1, this.ajw, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.alU = (int) TypedValue.applyDimension(1, this.alU, displayMetrics);
        this.alV = (int) TypedValue.applyDimension(1, this.alV, displayMetrics);
        this.ajD = i;
        this.ajx = i2;
        this.ajt = z;
        this.ajs = new Paint();
        this.ajs.setAntiAlias(true);
        this.ajs.setStyle(Paint.Style.FILL);
        this.cXQ = aj.getDrawable(d.g.icon_news_down_bar_one);
        this.ds20 = l.f(getContext(), d.f.ds20);
        this.ajk = new LinearLayout.LayoutParams(-2, -1);
        this.ajl = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.alU = l.f(getContext(), d.f.ds40);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cXR = z;
        invalidate();
    }

    public boolean apn() {
        return this.cXR;
    }

    public void setTabItemClicked(boolean z) {
        this.cXS = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajp = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cXP);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajn = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajp != null && this.ajp.getAdapter() != null && this.ajp.getAdapter().getCount() != 0) {
            this.ajo.removeAllViews();
            this.ajq = this.ajp.getAdapter().getCount();
            for (int i = 0; i < this.ajq; i++) {
                i(i, this.ajp.getAdapter().getPageTitle(i).toString());
            }
            wb();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.ajp.getCurrentItem();
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
                    if (PagerSlidingTabStrip.this.ajp.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").r("obj_locate", i + 1).ad("obj_type", "1"));
                    PagerSlidingTabStrip.this.cXS = true;
                    if (PagerSlidingTabStrip.this.ajp.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.ajp.getAdapter()).kZ(i);
                    }
                    PagerSlidingTabStrip.this.ajp.setCurrentItem(i);
                    PagerSlidingTabStrip.this.wb();
                }
            }
        });
        view.setPadding(this.alU, 0, this.alU, 0);
        this.ajo.addView(view, i, this.ajt ? this.ajl : this.ajk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb() {
        for (int i = 0; i < this.ajq; i++) {
            View childAt = this.ajo.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.ajH);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ajD);
                    if (i == this.ajp.getCurrentItem()) {
                        textView.setTextColor(this.aju);
                    } else {
                        textView.setTextColor(this.ajv);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, int i2) {
        if (this.ajq != 0) {
            int left = this.ajo.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ajw;
            }
            if (left != this.ajG) {
                this.ajG = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajq != 0) {
            int height = getHeight();
            this.ajs.setColor(this.aju);
            View childAt = this.ajo.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.ajr > 0.0f && this.currentPosition < this.ajq - 1) {
                View childAt2 = this.ajo.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ajr)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.ajr);
                right = (right * (1.0f - this.ajr)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.ajr);
            }
            canvas.drawRect(left, height - this.ajx, right, height, this.ajs);
            if (this.cXR) {
                View childAt3 = this.ajo.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.cXQ.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.cXQ.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aju = aj.getColor(d.e.cp_cont_b);
        this.ajv = aj.getColor(d.e.cp_cont_f);
        this.cXQ = aj.getDrawable(d.g.icon_news_down_bar_one);
        wb();
        invalidate();
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.ajo.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cXS) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.ajr = f;
                    PagerSlidingTabStrip.this.x(i, (int) (PagerSlidingTabStrip.this.ajo.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.ajn != null) {
                    PagerSlidingTabStrip.this.ajn.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ajo.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.x(PagerSlidingTabStrip.this.ajp.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.ajr = 0.0f;
                    PagerSlidingTabStrip.this.cXS = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.ajn != null) {
                    PagerSlidingTabStrip.this.ajn.onPageScrollStateChanged(i);
                }
                HomePageStatic.cUG = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ajn != null) {
                PagerSlidingTabStrip.this.ajn.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cXS) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.x(i, (int) (PagerSlidingTabStrip.this.ajr * PagerSlidingTabStrip.this.ajo.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.wb();
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
            /* renamed from: la */
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
