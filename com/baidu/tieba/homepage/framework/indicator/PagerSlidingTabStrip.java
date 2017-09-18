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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private float amA;
    private Paint amB;
    private boolean amC;
    private int amD;
    private int amE;
    private int amG;
    private int amH;
    private int amJ;
    private int amK;
    private int amL;
    private int amO;
    private int amP;
    private LinearLayout.LayoutParams amt;
    private LinearLayout.LayoutParams amu;
    public ViewPager.OnPageChangeListener amw;
    private LinearLayout amx;
    private ViewPager amy;
    private int amz;
    private int currentPosition;
    private final a dbq;
    private Drawable dbr;
    private boolean dbs;
    private boolean dbt;
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
        this.dbq = new a();
        this.currentPosition = 0;
        this.amA = 0.0f;
        this.amC = false;
        this.amD = aj.getColor(d.e.cp_cont_b);
        this.amE = aj.getColor(d.e.cp_cont_f);
        this.amG = 52;
        this.amH = 4;
        this.dividerPadding = 12;
        this.amJ = 24;
        this.amK = 1;
        this.amL = 12;
        this.amO = 0;
        this.amP = d.g.pager_sliding_view;
        this.dbt = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.amx = new LinearLayout(getContext());
        this.amx.setOrientation(0);
        this.amx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.amx);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.amG = (int) TypedValue.applyDimension(1, this.amG, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.amJ = (int) TypedValue.applyDimension(1, this.amJ, displayMetrics);
        this.amK = (int) TypedValue.applyDimension(1, this.amK, displayMetrics);
        this.amL = i;
        this.amH = i2;
        this.amC = z;
        this.amB = new Paint();
        this.amB.setAntiAlias(true);
        this.amB.setStyle(Paint.Style.FILL);
        this.dbr = aj.getDrawable(d.g.icon_news_down_bar_one);
        this.ds20 = k.f(getContext(), d.f.ds20);
        this.amt = new LinearLayout.LayoutParams(-2, -1);
        this.amu = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.amJ = k.f(getContext(), d.f.ds40);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.dbs = z;
        invalidate();
    }

    public boolean aqG() {
        return this.dbs;
    }

    public void setTabItemClicked(boolean z) {
        this.dbt = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.amy = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dbq);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.amw = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.amy != null && this.amy.getAdapter() != null && this.amy.getAdapter().getCount() != 0) {
            this.amx.removeAllViews();
            this.amz = this.amy.getAdapter().getCount();
            for (int i = 0; i < this.amz; i++) {
                i(i, this.amy.getAdapter().getPageTitle(i).toString());
            }
            wQ();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.amy.getCurrentItem();
                    PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.currentPosition, 0);
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
                    if (PagerSlidingTabStrip.this.amy.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").r("obj_locate", i + 1).ad("obj_type", "1"));
                    PagerSlidingTabStrip.this.dbt = true;
                    if (PagerSlidingTabStrip.this.amy.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.amy.getAdapter()).le(i);
                    }
                    PagerSlidingTabStrip.this.amy.setCurrentItem(i);
                    PagerSlidingTabStrip.this.wQ();
                }
            }
        });
        view.setPadding(this.amJ, 0, this.amJ, 0);
        this.amx.addView(view, i, this.amC ? this.amu : this.amt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wQ() {
        for (int i = 0; i < this.amz; i++) {
            View childAt = this.amx.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.amP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.amL);
                    if (i == this.amy.getCurrentItem()) {
                        textView.setTextColor(this.amD);
                    } else {
                        textView.setTextColor(this.amE);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i, int i2) {
        if (this.amz != 0) {
            int left = this.amx.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.amG;
            }
            if (left != this.amO) {
                this.amO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.amz != 0) {
            int height = getHeight();
            this.amB.setColor(this.amD);
            View childAt = this.amx.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.amA > 0.0f && this.currentPosition < this.amz - 1) {
                View childAt2 = this.amx.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.amA)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.amA);
                right = (right * (1.0f - this.amA)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.amA);
            }
            canvas.drawRect(left, height - this.amH, right, height, this.amB);
            if (this.dbs) {
                View childAt3 = this.amx.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.dbr.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.dbr.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.amD = aj.getColor(d.e.cp_cont_b);
        this.amE = aj.getColor(d.e.cp_cont_f);
        this.dbr = aj.getDrawable(d.g.icon_news_down_bar_one);
        wQ();
        invalidate();
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.amx.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dbt) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.amA = f;
                    PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.amx.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.amw != null) {
                    PagerSlidingTabStrip.this.amw.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.amx.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.amy.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.amA = 0.0f;
                    PagerSlidingTabStrip.this.dbt = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.amw != null) {
                    PagerSlidingTabStrip.this.amw.onPageScrollStateChanged(i);
                }
                HomePageStatic.cYo = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.amw != null) {
                PagerSlidingTabStrip.this.amw.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dbt) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.amA * PagerSlidingTabStrip.this.amx.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.wQ();
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
            /* renamed from: lf */
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
