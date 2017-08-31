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
    private ViewPager amA;
    private int amB;
    private float amC;
    private Paint amD;
    private boolean amE;
    private int amF;
    private int amG;
    private int amI;
    private int amJ;
    private int amL;
    private int amM;
    private int amN;
    private int amQ;
    private int amR;
    private LinearLayout.LayoutParams amv;
    private LinearLayout.LayoutParams amw;
    public ViewPager.OnPageChangeListener amy;
    private LinearLayout amz;
    private int currentPosition;
    private final a dav;
    private Drawable daw;
    private boolean dax;
    private boolean daz;
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
        this.dav = new a();
        this.currentPosition = 0;
        this.amC = 0.0f;
        this.amE = false;
        this.amF = aj.getColor(d.e.cp_cont_b);
        this.amG = aj.getColor(d.e.cp_cont_f);
        this.amI = 52;
        this.amJ = 4;
        this.dividerPadding = 12;
        this.amL = 24;
        this.amM = 1;
        this.amN = 12;
        this.amQ = 0;
        this.amR = d.g.pager_sliding_view;
        this.daz = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.amz = new LinearLayout(getContext());
        this.amz.setOrientation(0);
        this.amz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.amz);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.amI = (int) TypedValue.applyDimension(1, this.amI, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.amL = (int) TypedValue.applyDimension(1, this.amL, displayMetrics);
        this.amM = (int) TypedValue.applyDimension(1, this.amM, displayMetrics);
        this.amN = i;
        this.amJ = i2;
        this.amE = z;
        this.amD = new Paint();
        this.amD.setAntiAlias(true);
        this.amD.setStyle(Paint.Style.FILL);
        this.daw = aj.getDrawable(d.g.icon_news_down_bar_one);
        this.ds20 = k.g(getContext(), d.f.ds20);
        this.amv = new LinearLayout.LayoutParams(-2, -1);
        this.amw = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.amL = k.g(getContext(), d.f.ds40);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.dax = z;
        invalidate();
    }

    public boolean aqv() {
        return this.dax;
    }

    public void setTabItemClicked(boolean z) {
        this.daz = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.amA = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dav);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.amy = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.amA != null && this.amA.getAdapter() != null && this.amA.getAdapter().getCount() != 0) {
            this.amz.removeAllViews();
            this.amB = this.amA.getAdapter().getCount();
            for (int i = 0; i < this.amB; i++) {
                i(i, this.amA.getAdapter().getPageTitle(i).toString());
            }
            wQ();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.amA.getCurrentItem();
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
                    if (PagerSlidingTabStrip.this.amA.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").r("obj_locate", i + 1).ad("obj_type", "1"));
                    PagerSlidingTabStrip.this.daz = true;
                    if (PagerSlidingTabStrip.this.amA.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.amA.getAdapter()).lc(i);
                    }
                    PagerSlidingTabStrip.this.amA.setCurrentItem(i);
                    PagerSlidingTabStrip.this.wQ();
                }
            }
        });
        view.setPadding(this.amL, 0, this.amL, 0);
        this.amz.addView(view, i, this.amE ? this.amw : this.amv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wQ() {
        for (int i = 0; i < this.amB; i++) {
            View childAt = this.amz.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.amR);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.amN);
                    if (i == this.amA.getCurrentItem()) {
                        textView.setTextColor(this.amF);
                    } else {
                        textView.setTextColor(this.amG);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i, int i2) {
        if (this.amB != 0) {
            int left = this.amz.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.amI;
            }
            if (left != this.amQ) {
                this.amQ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.amB != 0) {
            int height = getHeight();
            this.amD.setColor(this.amF);
            View childAt = this.amz.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.amC > 0.0f && this.currentPosition < this.amB - 1) {
                View childAt2 = this.amz.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.amC)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.amC);
                right = (right * (1.0f - this.amC)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.amC);
            }
            canvas.drawRect(left, height - this.amJ, right, height, this.amD);
            if (this.dax) {
                View childAt3 = this.amz.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.daw.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.daw.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.amF = aj.getColor(d.e.cp_cont_b);
        this.amG = aj.getColor(d.e.cp_cont_f);
        this.daw = aj.getDrawable(d.g.icon_news_down_bar_one);
        wQ();
        invalidate();
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.amz.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.daz) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.amC = f;
                    PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.amz.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.amy != null) {
                    PagerSlidingTabStrip.this.amy.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.amz.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.amA.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.amC = 0.0f;
                    PagerSlidingTabStrip.this.daz = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.amy != null) {
                    PagerSlidingTabStrip.this.amy.onPageScrollStateChanged(i);
                }
                HomePageStatic.cXu = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.amy != null) {
                PagerSlidingTabStrip.this.amy.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.daz) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.amC * PagerSlidingTabStrip.this.amz.getChildAt(i).getWidth()));
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
            /* renamed from: ld */
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
