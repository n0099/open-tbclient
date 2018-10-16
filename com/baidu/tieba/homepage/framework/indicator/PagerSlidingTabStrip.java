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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes6.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams aBE;
    private LinearLayout.LayoutParams aBF;
    public ViewPager.OnPageChangeListener aBH;
    private LinearLayout aBI;
    private ViewPager aBJ;
    private int aBK;
    private int aBL;
    private float aBM;
    private Paint aBN;
    private boolean aBO;
    private int aBP;
    private int aBQ;
    private int aBR;
    private int aBS;
    private int aBY;
    private int aCb;
    private int aCc;
    private int dividerPadding;
    private int dividerWidth;
    private int ds20;
    private final b eln;
    private Drawable elo;
    private boolean elp;
    private int elq;
    private boolean elr;
    private a els;
    private boolean isLoading;
    private Locale locale;
    private RectF sB;
    private int tabPadding;

    /* loaded from: classes6.dex */
    public interface a {
        void r(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eln = new b();
        this.aBL = 0;
        this.aBM = 0.0f;
        this.aBO = false;
        this.aBP = al.getColor(e.d.cp_cont_b);
        this.aBQ = al.getColor(e.d.cp_cont_j);
        this.aBR = 52;
        this.aBS = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.dividerWidth = 1;
        this.aBY = 17;
        this.aCb = 0;
        this.aCc = e.f.pager_sliding_view;
        this.elr = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aBI = new LinearLayout(getContext());
        this.aBI.setOrientation(0);
        this.aBI.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aBI);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aBR = (int) TypedValue.applyDimension(1, this.aBR, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aBY = i;
        this.aBS = i2;
        this.aBO = z;
        this.aBN = new Paint();
        this.aBN.setAntiAlias(true);
        this.aBN.setStyle(Paint.Style.FILL);
        this.elo = al.getDrawable(e.f.icon_news_down_bar_one);
        this.ds20 = l.h(getContext(), e.C0175e.ds20);
        this.aBE = new LinearLayout.LayoutParams(-2, -1);
        this.aBF = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.h(getContext(), e.C0175e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.elp = z;
        invalidate();
    }

    public boolean aJy() {
        return this.elp;
    }

    public void setTabItemClicked(boolean z) {
        this.elr = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aBJ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eln);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aBH = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aBJ != null && this.aBJ.getAdapter() != null && this.aBJ.getAdapter().getCount() != 0) {
            this.aBI.removeAllViews();
            this.aBK = this.aBJ.getAdapter().getCount();
            for (int i = 0; i < this.aBK; i++) {
                j(i, this.aBJ.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.aBL = PagerSlidingTabStrip.this.aBJ.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aBL, 0);
                }
            });
        }
    }

    private void j(int i, String str) {
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
                    if (PagerSlidingTabStrip.this.els != null) {
                        PagerSlidingTabStrip.this.els.r(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.aBJ.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new am("c12049").x("obj_locate", i + 1).ax("obj_type", "1"));
                    PagerSlidingTabStrip.this.elr = true;
                    if (PagerSlidingTabStrip.this.aBJ.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.aBJ.getAdapter()).nN(i);
                    }
                    PagerSlidingTabStrip.this.aBJ.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aBI.addView(view, i, this.aBO ? this.aBF : this.aBE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aBK; i++) {
            View childAt = this.aBI.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aCc);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aBY);
                    if (i == this.aBJ.getCurrentItem()) {
                        textView.setTextColor(this.aBP);
                    } else {
                        textView.setTextColor(this.aBQ);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aBK != 0) {
            int left = this.aBI.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aBR;
            }
            if (left != this.aCb) {
                this.aCb = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aBK != 0) {
            int height = getHeight();
            this.aBN.setColor(this.aBP);
            View childAt = this.aBI.getChildAt(this.aBL);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aBM > 0.0f && this.aBL < this.aBK - 1) {
                View childAt2 = this.aBI.getChildAt(this.aBL + 1);
                left = (left * (1.0f - this.aBM)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aBM);
                right = (right * (1.0f - this.aBM)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aBM);
            }
            if (this.sB == null) {
                this.sB = new RectF(left, height - this.aBS, right, height);
            } else {
                this.sB.set(left, height - this.aBS, right, height);
            }
            canvas.drawRoundRect(this.sB, 10.0f, 10.0f, this.aBN);
            if (this.elp) {
                View childAt3 = this.aBI.getChildAt(this.elq);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.elo.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.elo.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aBP = al.getColor(e.d.cp_cont_b);
        this.aBQ = al.getColor(e.d.cp_cont_j);
        this.elo = al.getDrawable(e.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes6.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aBI.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.elr) {
                    PagerSlidingTabStrip.this.aBL = i;
                    PagerSlidingTabStrip.this.aBM = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aBI.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aBH != null) {
                    PagerSlidingTabStrip.this.aBH.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aBI.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aBJ.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aBM = 0.0f;
                    PagerSlidingTabStrip.this.elr = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aBH != null) {
                    PagerSlidingTabStrip.this.aBH.onPageScrollStateChanged(i);
                }
                HomePageStatic.ehB = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aBH != null) {
                PagerSlidingTabStrip.this.aBH.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.elr) {
                PagerSlidingTabStrip.this.aBL = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aBM * PagerSlidingTabStrip.this.aBI.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aBL = savedState.aBL;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aBL = this.aBL;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: o */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: nP */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aBL;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aBL = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aBL);
        }
    }

    public View nO(int i) {
        return this.aBI.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.elq = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.els = aVar;
    }
}
