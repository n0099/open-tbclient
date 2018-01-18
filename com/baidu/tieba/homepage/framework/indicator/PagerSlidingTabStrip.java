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
    private LinearLayout.LayoutParams aXY;
    private LinearLayout.LayoutParams aXZ;
    public ViewPager.OnPageChangeListener aYb;
    private LinearLayout aYc;
    private ViewPager aYd;
    private int aYe;
    private float aYf;
    private Paint aYg;
    private boolean aYh;
    private int aYi;
    private int aYj;
    private int aYk;
    private int aYl;
    private int aYr;
    private int aYu;
    private int aYv;
    private int bay;
    private int currentPosition;
    private int dividerPadding;
    private int ds20;
    private Drawable edA;
    private boolean edB;
    private boolean edC;
    private final a edz;
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
        this.edz = new a();
        this.currentPosition = 0;
        this.aYf = 0.0f;
        this.aYh = false;
        this.aYi = aj.getColor(d.C0107d.cp_cont_b);
        this.aYj = aj.getColor(d.C0107d.cp_cont_j);
        this.aYk = 52;
        this.aYl = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.bay = 1;
        this.aYr = 17;
        this.aYu = 0;
        this.aYv = d.f.pager_sliding_view;
        this.edC = false;
        this.isLoading = false;
    }

    public void g(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aYc = new LinearLayout(getContext());
        this.aYc.setOrientation(0);
        this.aYc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aYc);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aYk = (int) TypedValue.applyDimension(1, this.aYk, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.bay = (int) TypedValue.applyDimension(1, this.bay, displayMetrics);
        this.aYr = i;
        this.aYl = i2;
        this.aYh = z;
        this.aYg = new Paint();
        this.aYg.setAntiAlias(true);
        this.aYg.setStyle(Paint.Style.FILL);
        this.edA = aj.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.s(getContext(), d.e.ds20);
        this.aXY = new LinearLayout.LayoutParams(-2, -1);
        this.aXZ = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.s(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.edB = z;
        invalidate();
    }

    public boolean aBe() {
        return this.edB;
    }

    public void setTabItemClicked(boolean z) {
        this.edC = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aYd = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.edz);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aYb = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aYd != null && this.aYd.getAdapter() != null && this.aYd.getAdapter().getCount() != 0) {
            this.aYc.removeAllViews();
            this.aYe = this.aYd.getAdapter().getCount();
            for (int i = 0; i < this.aYe; i++) {
                h(i, this.aYd.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aYd.getCurrentItem();
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
                    if (PagerSlidingTabStrip.this.aYd.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new ak("c12049").s("obj_locate", i + 1).ab("obj_type", "1"));
                    PagerSlidingTabStrip.this.edC = true;
                    if (PagerSlidingTabStrip.this.aYd.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                        ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.aYd.getAdapter()).oF(i);
                    }
                    PagerSlidingTabStrip.this.aYd.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aYc.addView(view, i, this.aYh ? this.aXZ : this.aXY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aYe; i++) {
            View childAt = this.aYc.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aYv);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aYr);
                    if (i == this.aYd.getCurrentItem()) {
                        textView.setTextColor(this.aYi);
                    } else {
                        textView.setTextColor(this.aYj);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aYe != 0) {
            int left = this.aYc.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aYk;
            }
            if (left != this.aYu) {
                this.aYu = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aYe != 0) {
            int height = getHeight();
            this.aYg.setColor(this.aYi);
            View childAt = this.aYc.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aYf > 0.0f && this.currentPosition < this.aYe - 1) {
                View childAt2 = this.aYc.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aYf)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aYf);
                right = (right * (1.0f - this.aYf)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aYf);
            }
            canvas.drawRoundRect(new RectF(left, height - this.aYl, right, height), 10.0f, 10.0f, this.aYg);
            if (this.edB) {
                View childAt3 = this.aYc.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.edA.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.edA.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aYi = aj.getColor(d.C0107d.cp_cont_b);
        this.aYj = aj.getColor(d.C0107d.cp_cont_j);
        this.edA = aj.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aYc.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.edC) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.aYf = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aYc.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aYb != null) {
                    PagerSlidingTabStrip.this.aYb.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aYc.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aYd.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aYf = 0.0f;
                    PagerSlidingTabStrip.this.edC = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aYb != null) {
                    PagerSlidingTabStrip.this.aYb.onPageScrollStateChanged(i);
                }
                HomePageStatic.eaO = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aYb != null) {
                PagerSlidingTabStrip.this.aYb.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.edC) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aYf * PagerSlidingTabStrip.this.aYc.getChildAt(i).getWidth()));
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
            /* renamed from: oG */
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
