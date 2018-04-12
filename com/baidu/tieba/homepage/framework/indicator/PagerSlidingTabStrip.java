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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int alD;
    private int alG;
    private int alH;
    private LinearLayout.LayoutParams alj;
    private LinearLayout.LayoutParams alk;
    public ViewPager.OnPageChangeListener aln;
    private LinearLayout alo;
    private ViewPager alp;
    private int alq;
    private float alr;
    private Paint als;
    private boolean alt;
    private int alu;
    private int alv;
    private int alw;
    private int alx;
    private int anH;
    private int currentPosition;
    private final a dCQ;
    private Drawable dCR;
    private boolean dCS;
    private boolean dCT;
    private int dividerPadding;
    private int ds20;
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
        this.dCQ = new a();
        this.currentPosition = 0;
        this.alr = 0.0f;
        this.alt = false;
        this.alu = ak.getColor(d.C0126d.cp_cont_b);
        this.alv = ak.getColor(d.C0126d.cp_cont_j);
        this.alw = 52;
        this.alx = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.anH = 1;
        this.alD = 17;
        this.alG = 0;
        this.alH = d.f.pager_sliding_view;
        this.dCT = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.alo = new LinearLayout(getContext());
        this.alo.setOrientation(0);
        this.alo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.alo);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.alw = (int) TypedValue.applyDimension(1, this.alw, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.anH = (int) TypedValue.applyDimension(1, this.anH, displayMetrics);
        this.alD = i;
        this.alx = i2;
        this.alt = z;
        this.als = new Paint();
        this.als.setAntiAlias(true);
        this.als.setStyle(Paint.Style.FILL);
        this.dCR = ak.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.e(getContext(), d.e.ds20);
        this.alj = new LinearLayout.LayoutParams(-2, -1);
        this.alk = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.e(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.dCS = z;
        invalidate();
    }

    public boolean axB() {
        return this.dCS;
    }

    public void setTabItemClicked(boolean z) {
        this.dCT = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.alp = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dCQ);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aln = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.alp != null && this.alp.getAdapter() != null && this.alp.getAdapter().getCount() != 0) {
            this.alo.removeAllViews();
            this.alq = this.alp.getAdapter().getCount();
            for (int i = 0; i < this.alq; i++) {
                h(i, this.alp.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.alp.getCurrentItem();
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

    private void b(final int i, View view2) {
        view2.setFocusable(true);
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.alp.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new al("c12049").r("obj_locate", i + 1).ac("obj_type", "1"));
                    PagerSlidingTabStrip.this.dCT = true;
                    if (PagerSlidingTabStrip.this.alp.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.alp.getAdapter()).mg(i);
                    }
                    PagerSlidingTabStrip.this.alp.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view2.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.alo.addView(view2, i, this.alt ? this.alk : this.alj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.alq; i++) {
            View childAt = this.alo.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.alH);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.alD);
                    if (i == this.alp.getCurrentItem()) {
                        textView.setTextColor(this.alu);
                    } else {
                        textView.setTextColor(this.alv);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.alq != 0) {
            int left = this.alo.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.alw;
            }
            if (left != this.alG) {
                this.alG = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.alq != 0) {
            int height = getHeight();
            this.als.setColor(this.alu);
            View childAt = this.alo.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.alr > 0.0f && this.currentPosition < this.alq - 1) {
                View childAt2 = this.alo.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.alr)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.alr);
                right = (right * (1.0f - this.alr)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.alr);
            }
            canvas.drawRoundRect(new RectF(left, height - this.alx, right, height), 10.0f, 10.0f, this.als);
            if (this.dCS) {
                View childAt3 = this.alo.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.dCR.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.dCR.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.alu = ak.getColor(d.C0126d.cp_cont_b);
        this.alv = ak.getColor(d.C0126d.cp_cont_j);
        this.dCR = ak.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.alo.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dCT) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.alr = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.alo.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aln != null) {
                    PagerSlidingTabStrip.this.aln.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.alo.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.alp.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.alr = 0.0f;
                    PagerSlidingTabStrip.this.dCT = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aln != null) {
                    PagerSlidingTabStrip.this.aln.onPageScrollStateChanged(i);
                }
                HomePageStatic.dAf = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aln != null) {
                PagerSlidingTabStrip.this.aln.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dCT) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.alr * PagerSlidingTabStrip.this.alo.getChildAt(i).getWidth()));
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
            /* renamed from: l */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mh */
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
