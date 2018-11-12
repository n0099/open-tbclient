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
    private int aCA;
    private float aCB;
    private Paint aCC;
    private boolean aCD;
    private int aCE;
    private int aCF;
    private int aCG;
    private int aCH;
    private int aCN;
    private int aCQ;
    private int aCR;
    private LinearLayout.LayoutParams aCt;
    private LinearLayout.LayoutParams aCu;
    public ViewPager.OnPageChangeListener aCw;
    private LinearLayout aCx;
    private ViewPager aCy;
    private int aCz;
    private int dividerPadding;
    private int dividerWidth;
    private int ds20;
    private final b emH;
    private Drawable emI;
    private boolean emJ;
    private int emK;
    private boolean emL;
    private a emM;
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
        this.emH = new b();
        this.aCA = 0;
        this.aCB = 0.0f;
        this.aCD = false;
        this.aCE = al.getColor(e.d.cp_cont_b);
        this.aCF = al.getColor(e.d.cp_cont_j);
        this.aCG = 52;
        this.aCH = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.dividerWidth = 1;
        this.aCN = 17;
        this.aCQ = 0;
        this.aCR = e.f.pager_sliding_view;
        this.emL = false;
        this.isLoading = false;
    }

    public void e(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.aCx = new LinearLayout(getContext());
        this.aCx.setOrientation(0);
        this.aCx.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.aCx);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aCG = (int) TypedValue.applyDimension(1, this.aCG, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.aCN = i;
        this.aCH = i2;
        this.aCD = z;
        this.aCC = new Paint();
        this.aCC.setAntiAlias(true);
        this.aCC.setStyle(Paint.Style.FILL);
        this.emI = al.getDrawable(e.f.icon_news_down_bar_one);
        this.ds20 = l.h(getContext(), e.C0200e.ds20);
        this.aCt = new LinearLayout.LayoutParams(-2, -1);
        this.aCu = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.h(getContext(), e.C0200e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.emJ = z;
        invalidate();
    }

    public boolean aIW() {
        return this.emJ;
    }

    public void setTabItemClicked(boolean z) {
        this.emL = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aCy = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.emH);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aCw = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aCy != null && this.aCy.getAdapter() != null && this.aCy.getAdapter().getCount() != 0) {
            this.aCx.removeAllViews();
            this.aCz = this.aCy.getAdapter().getCount();
            for (int i = 0; i < this.aCz; i++) {
                i(i, this.aCy.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.aCA = PagerSlidingTabStrip.this.aCy.getCurrentItem();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aCA, 0);
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
                    if (PagerSlidingTabStrip.this.emM != null) {
                        PagerSlidingTabStrip.this.emM.s(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.aCy.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new am("c12049").x("obj_locate", i + 1).ax("obj_type", "1"));
                    PagerSlidingTabStrip.this.emL = true;
                    if (PagerSlidingTabStrip.this.aCy.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.aCy.getAdapter()).of(i);
                    }
                    PagerSlidingTabStrip.this.aCy.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.aCx.addView(view, i, this.aCD ? this.aCu : this.aCt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.aCz; i++) {
            View childAt = this.aCx.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.aCR);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.aCN);
                    if (i == this.aCy.getCurrentItem()) {
                        textView.setTextColor(this.aCE);
                    } else {
                        textView.setTextColor(this.aCF);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.aCz != 0) {
            int left = this.aCx.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aCG;
            }
            if (left != this.aCQ) {
                this.aCQ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.aCz != 0) {
            int height = getHeight();
            this.aCC.setColor(this.aCE);
            View childAt = this.aCx.getChildAt(this.aCA);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aCB > 0.0f && this.aCA < this.aCz - 1) {
                View childAt2 = this.aCx.getChildAt(this.aCA + 1);
                left = (left * (1.0f - this.aCB)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aCB);
                right = (right * (1.0f - this.aCB)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aCB);
            }
            if (this.sD == null) {
                this.sD = new RectF(left, height - this.aCH, right, height);
            } else {
                this.sD.set(left, height - this.aCH, right, height);
            }
            canvas.drawRoundRect(this.sD, 10.0f, 10.0f, this.aCC);
            if (this.emJ) {
                View childAt3 = this.aCx.getChildAt(this.emK);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.emI.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.emI.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aCE = al.getColor(e.d.cp_cont_b);
        this.aCF = al.getColor(e.d.cp_cont_j);
        this.emI = al.getDrawable(e.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes6.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.aCx.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.emL) {
                    PagerSlidingTabStrip.this.aCA = i;
                    PagerSlidingTabStrip.this.aCB = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aCx.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aCw != null) {
                    PagerSlidingTabStrip.this.aCw.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.aCx.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aCy.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aCB = 0.0f;
                    PagerSlidingTabStrip.this.emL = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aCw != null) {
                    PagerSlidingTabStrip.this.aCw.onPageScrollStateChanged(i);
                }
                HomePageStatic.eiW = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aCw != null) {
                PagerSlidingTabStrip.this.aCw.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.emL) {
                PagerSlidingTabStrip.this.aCA = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aCB * PagerSlidingTabStrip.this.aCx.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.updateTabStyles();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.aCA = savedState.aCA;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.aCA = this.aCA;
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
            /* renamed from: oh */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int aCA;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.aCA = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aCA);
        }
    }

    public View og(int i) {
        return this.aCx.getChildAt(i);
    }

    public void setConcernTabIndex(int i) {
        this.emK = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.emM = aVar;
    }
}
