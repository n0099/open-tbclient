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
    private LinearLayout.LayoutParams aFT;
    private LinearLayout.LayoutParams aFU;
    public ViewPager.OnPageChangeListener aFW;
    private LinearLayout aFX;
    private ViewPager aFY;
    private int aFZ;
    private int aGa;
    private float aGb;
    private Paint aGc;
    private boolean aGd;
    private int aGe;
    private int aGf;
    private int aGg;
    private int aGh;
    private int aGn;
    private int aGq;
    private int aGr;
    private int dividerPadding;
    private int dividerWidth;
    private int ds20;
    private final b etD;
    private Drawable etE;
    private boolean etF;
    private int etG;
    private boolean etH;
    private a etI;
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
        this.etD = new b();
        this.aGa = 0;
        this.aGb = 0.0f;
        this.aGd = false;
        this.aGe = al.getColor(e.d.cp_cont_b);
        this.aGf = al.getColor(e.d.cp_cont_j);
        this.aGg = 52;
        this.aGh = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.dividerWidth = 1;
        this.aGn = 17;
        this.aGq = 0;
        this.aGr = e.f.pager_sliding_view;
        this.etH = false;
        this.isLoading = false;
    }

    public void e(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aFX = new LinearLayout(getContext());
        this.aFX.setOrientation(0);
        this.aFX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aFX);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aGg = (int) TypedValue.applyDimension(1, this.aGg, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aGn = i;
        this.aGh = i2;
        this.aGd = z;
        this.aGc = new Paint();
        this.aGc.setAntiAlias(true);
        this.aGc.setStyle(Paint.Style.FILL);
        this.etE = al.getDrawable(e.f.icon_news_down_bar_one);
        this.ds20 = l.h(getContext(), e.C0210e.ds20);
        this.aFT = new LinearLayout.LayoutParams(-2, -1);
        this.aFU = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.h(getContext(), e.C0210e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.etF = z;
        invalidate();
    }

    public boolean aKN() {
        return this.etF;
    }

    public void setTabItemClicked(boolean z) {
        this.etH = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aFY = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.etD);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aFW = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aFY != null && this.aFY.getAdapter() != null && this.aFY.getAdapter().getCount() != 0) {
            this.aFX.removeAllViews();
            this.aFZ = this.aFY.getAdapter().getCount();
            for (int i = 0; i < this.aFZ; i++) {
                i(i, this.aFY.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.aGa = PagerSlidingTabStrip.this.aFY.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aGa, 0);
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
                    if (PagerSlidingTabStrip.this.etI != null) {
                        PagerSlidingTabStrip.this.etI.s(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.aFY.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new am("c12049").x("obj_locate", i + 1).aA("obj_type", "1"));
                    PagerSlidingTabStrip.this.etH = true;
                    if (PagerSlidingTabStrip.this.aFY.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.aFY.getAdapter()).oz(i);
                    }
                    PagerSlidingTabStrip.this.aFY.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aFX.addView(view, i, this.aGd ? this.aFU : this.aFT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aFZ; i++) {
            View childAt = this.aFX.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aGr);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aGn);
                    if (i == this.aFY.getCurrentItem()) {
                        textView.setTextColor(this.aGe);
                    } else {
                        textView.setTextColor(this.aGf);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aFZ != 0) {
            int left = this.aFX.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aGg;
            }
            if (left != this.aGq) {
                this.aGq = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aFZ != 0) {
            int height = getHeight();
            this.aGc.setColor(this.aGe);
            View childAt = this.aFX.getChildAt(this.aGa);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aGb > 0.0f && this.aGa < this.aFZ - 1) {
                View childAt2 = this.aFX.getChildAt(this.aGa + 1);
                left = (left * (1.0f - this.aGb)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aGb);
                right = (right * (1.0f - this.aGb)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aGb);
            }
            if (this.sD == null) {
                this.sD = new RectF(left, height - this.aGh, right, height);
            } else {
                this.sD.set(left, height - this.aGh, right, height);
            }
            canvas.drawRoundRect(this.sD, 10.0f, 10.0f, this.aGc);
            if (this.etF) {
                View childAt3 = this.aFX.getChildAt(this.etG);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.etE.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.etE.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aGe = al.getColor(e.d.cp_cont_b);
        this.aGf = al.getColor(e.d.cp_cont_j);
        this.etE = al.getDrawable(e.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes6.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aFX.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.etH) {
                    PagerSlidingTabStrip.this.aGa = i;
                    PagerSlidingTabStrip.this.aGb = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aFX.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aFW != null) {
                    PagerSlidingTabStrip.this.aFW.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aFX.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aFY.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aGb = 0.0f;
                    PagerSlidingTabStrip.this.etH = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aFW != null) {
                    PagerSlidingTabStrip.this.aFW.onPageScrollStateChanged(i);
                }
                HomePageStatic.epQ = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aFW != null) {
                PagerSlidingTabStrip.this.aFW.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.etH) {
                PagerSlidingTabStrip.this.aGa = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aGb * PagerSlidingTabStrip.this.aFX.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aGa = savedState.aGa;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aGa = this.aGa;
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
            /* renamed from: oB */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aGa;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aGa = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aGa);
        }
    }

    public View oA(int i) {
        return this.aFX.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.etG = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.etI = aVar;
    }
}
