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
    private LinearLayout.LayoutParams aFU;
    private LinearLayout.LayoutParams aFV;
    public ViewPager.OnPageChangeListener aFX;
    private LinearLayout aFY;
    private ViewPager aFZ;
    private int aGa;
    private int aGb;
    private float aGc;
    private Paint aGd;
    private boolean aGe;
    private int aGf;
    private int aGg;
    private int aGh;
    private int aGi;
    private int aGo;
    private int aGr;
    private int aGs;
    private int dividerPadding;
    private int dividerWidth;
    private int ds20;
    private final b ewt;
    private Drawable ewu;
    private boolean ewv;
    private int eww;
    private boolean ewx;
    private a ewy;
    private boolean isLoading;
    private Locale locale;
    private RectF sD;
    private int tabPadding;

    /* loaded from: classes6.dex */
    public interface a {
        void s(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewt = new b();
        this.aGb = 0;
        this.aGc = 0.0f;
        this.aGe = false;
        this.aGf = al.getColor(e.d.cp_cont_b);
        this.aGg = al.getColor(e.d.cp_cont_j);
        this.aGh = 52;
        this.aGi = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.dividerWidth = 1;
        this.aGo = 17;
        this.aGr = 0;
        this.aGs = e.f.pager_sliding_view;
        this.ewx = false;
        this.isLoading = false;
    }

    public void e(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aFY = new LinearLayout(getContext());
        this.aFY.setOrientation(0);
        this.aFY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aFY);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aGh = (int) TypedValue.applyDimension(1, this.aGh, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aGo = i;
        this.aGi = i2;
        this.aGe = z;
        this.aGd = new Paint();
        this.aGd.setAntiAlias(true);
        this.aGd.setStyle(Paint.Style.FILL);
        this.ewu = al.getDrawable(e.f.icon_news_down_bar_one);
        this.ds20 = l.h(getContext(), e.C0210e.ds20);
        this.aFU = new LinearLayout.LayoutParams(-2, -1);
        this.aFV = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.h(getContext(), e.C0210e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.ewv = z;
        invalidate();
    }

    public boolean aLB() {
        return this.ewv;
    }

    public void setTabItemClicked(boolean z) {
        this.ewx = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aFZ = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.ewt);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aFX = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aFZ != null && this.aFZ.getAdapter() != null && this.aFZ.getAdapter().getCount() != 0) {
            this.aFY.removeAllViews();
            this.aGa = this.aFZ.getAdapter().getCount();
            for (int i = 0; i < this.aGa; i++) {
                i(i, this.aFZ.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.aGb = PagerSlidingTabStrip.this.aFZ.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGb, 0);
                }
            });
        }
    }

    private void i(int i, String str) {
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
                    if (PagerSlidingTabStrip.this.ewy != null) {
                        PagerSlidingTabStrip.this.ewy.s(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.aFZ.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new am("c12049").x("obj_locate", i + 1).aA("obj_type", "1"));
                    PagerSlidingTabStrip.this.ewx = true;
                    if (PagerSlidingTabStrip.this.aFZ.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.aFZ.getAdapter()).oM(i);
                    }
                    PagerSlidingTabStrip.this.aFZ.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aFY.addView(view, i, this.aGe ? this.aFV : this.aFU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aGa; i++) {
            View childAt = this.aFY.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGs);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGo);
                    if (i == this.aFZ.getCurrentItem()) {
                        textView.setTextColor(this.aGf);
                    } else {
                        textView.setTextColor(this.aGg);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aGa != 0) {
            int left = this.aFY.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGh;
            }
            if (left != this.aGr) {
                this.aGr = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aGa != 0) {
            int height = getHeight();
            this.aGd.setColor(this.aGf);
            View childAt = this.aFY.getChildAt(this.aGb);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aGc > 0.0f && this.aGb < this.aGa - 1) {
                View childAt2 = this.aFY.getChildAt(this.aGb + 1);
                left = (left * (1.0f - this.aGc)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aGc);
                right = (right * (1.0f - this.aGc)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aGc);
            }
            if (this.sD == null) {
                this.sD = new RectF(left, height - this.aGi, right, height);
            } else {
                this.sD.set(left, height - this.aGi, right, height);
            }
            canvas.drawRoundRect(this.sD, 10.0f, 10.0f, this.aGd);
            if (this.ewv) {
                View childAt3 = this.aFY.getChildAt(this.eww);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.ewu.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.ewu.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aGf = al.getColor(e.d.cp_cont_b);
        this.aGg = al.getColor(e.d.cp_cont_j);
        this.ewu = al.getDrawable(e.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes6.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aFY.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.ewx) {
                    PagerSlidingTabStrip.this.aGb = i;
                    PagerSlidingTabStrip.this.aGc = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aFY.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aFX != null) {
                    PagerSlidingTabStrip.this.aFX.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aFY.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aFZ.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aGc = 0.0f;
                    PagerSlidingTabStrip.this.ewx = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aFX != null) {
                    PagerSlidingTabStrip.this.aFX.onPageScrollStateChanged(i);
                }
                HomePageStatic.esH = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aFX != null) {
                PagerSlidingTabStrip.this.aFX.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.ewx) {
                PagerSlidingTabStrip.this.aGb = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aGc * PagerSlidingTabStrip.this.aFY.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGb = savedState.aGb;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGb = this.aGb;
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
            /* renamed from: oO */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aGb;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGb = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGb);
        }
    }

    public View oN(int i) {
        return this.aFY.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.eww = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ewy = aVar;
    }
}
