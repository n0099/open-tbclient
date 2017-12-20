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
    private LinearLayout.LayoutParams ajN;
    private LinearLayout.LayoutParams ajO;
    public ViewPager.OnPageChangeListener ajQ;
    private LinearLayout ajR;
    private ViewPager ajS;
    private int ajT;
    private float ajU;
    private Paint ajV;
    private boolean ajW;
    private int ajX;
    private int ajY;
    private int ajZ;
    private int aka;
    private int akg;
    private int akj;
    private int akk;
    private int amw;
    private int amx;
    private int currentPosition;
    private int dividerPadding;
    private final a dqa;
    private Drawable dqb;
    private boolean dqc;
    private boolean dqd;
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
        this.dqa = new a();
        this.currentPosition = 0;
        this.ajU = 0.0f;
        this.ajW = false;
        this.ajX = aj.getColor(d.C0096d.cp_cont_b);
        this.ajY = aj.getColor(d.C0096d.cp_cont_j);
        this.ajZ = 52;
        this.aka = 4;
        this.dividerPadding = 12;
        this.amw = 28;
        this.amx = 1;
        this.akg = 17;
        this.akj = 0;
        this.akk = d.f.pager_sliding_view;
        this.dqd = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.ajR = new LinearLayout(getContext());
        this.ajR.setOrientation(0);
        this.ajR.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.ajR);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ajZ = (int) TypedValue.applyDimension(1, this.ajZ, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.amw = (int) TypedValue.applyDimension(1, this.amw, displayMetrics);
        this.amx = (int) TypedValue.applyDimension(1, this.amx, displayMetrics);
        this.akg = i;
        this.aka = i2;
        this.ajW = z;
        this.ajV = new Paint();
        this.ajV.setAntiAlias(true);
        this.ajV.setStyle(Paint.Style.FILL);
        this.dqb = aj.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.f(getContext(), d.e.ds20);
        this.ajN = new LinearLayout.LayoutParams(-2, -1);
        this.ajO = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.amw = l.f(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.dqc = z;
        invalidate();
    }

    public boolean atY() {
        return this.dqc;
    }

    public void setTabItemClicked(boolean z) {
        this.dqd = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ajS = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dqa);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ajQ = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ajS != null && this.ajS.getAdapter() != null && this.ajS.getAdapter().getCount() != 0) {
            this.ajR.removeAllViews();
            this.ajT = this.ajS.getAdapter().getCount();
            for (int i = 0; i < this.ajT; i++) {
                i(i, this.ajS.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.ajS.getCurrentItem();
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
                    if (PagerSlidingTabStrip.this.ajS.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").r("obj_locate", i + 1).ac("obj_type", "1"));
                    PagerSlidingTabStrip.this.dqd = true;
                    if (PagerSlidingTabStrip.this.ajS.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.ajS.getAdapter()).lV(i);
                    }
                    PagerSlidingTabStrip.this.ajS.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.amw, 0, this.amw, 0);
        this.ajR.addView(view, i, this.ajW ? this.ajO : this.ajN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.ajT; i++) {
            View childAt = this.ajR.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.akk);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.akg);
                    if (i == this.ajS.getCurrentItem()) {
                        textView.setTextColor(this.ajX);
                    } else {
                        textView.setTextColor(this.ajY);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.ajT != 0) {
            int left = this.ajR.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ajZ;
            }
            if (left != this.akj) {
                this.akj = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.ajT != 0) {
            int height = getHeight();
            this.ajV.setColor(this.ajX);
            View childAt = this.ajR.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.ajU > 0.0f && this.currentPosition < this.ajT - 1) {
                View childAt2 = this.ajR.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ajU)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.ajU);
                right = (right * (1.0f - this.ajU)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.ajU);
            }
            canvas.drawRoundRect(new RectF(left, height - this.aka, right, height), 10.0f, 10.0f, this.ajV);
            if (this.dqc) {
                View childAt3 = this.ajR.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.dqb.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.dqb.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.ajX = aj.getColor(d.C0096d.cp_cont_b);
        this.ajY = aj.getColor(d.C0096d.cp_cont_j);
        this.dqb = aj.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.ajR.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dqd) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.ajU = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.ajR.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.ajQ != null) {
                    PagerSlidingTabStrip.this.ajQ.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.ajR.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.ajS.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.ajU = 0.0f;
                    PagerSlidingTabStrip.this.dqd = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.ajQ != null) {
                    PagerSlidingTabStrip.this.ajQ.onPageScrollStateChanged(i);
                }
                HomePageStatic.dnr = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ajQ != null) {
                PagerSlidingTabStrip.this.ajQ.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dqd) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.ajU * PagerSlidingTabStrip.this.ajR.getChildAt(i).getWidth()));
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
            /* renamed from: lW */
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
