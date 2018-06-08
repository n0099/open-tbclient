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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private boolean atA;
    private int atB;
    private int atC;
    private int atD;
    private int atE;
    private int atK;
    private int atN;
    private int atO;
    private LinearLayout.LayoutParams atr;
    private LinearLayout.LayoutParams ats;
    public ViewPager.OnPageChangeListener atu;
    private LinearLayout atv;
    private ViewPager atw;
    private int atx;
    private float aty;
    private Paint atz;
    private int avP;
    private int currentPosition;
    private final a dPd;
    private Drawable dPe;
    private boolean dPf;
    private boolean dPg;
    private int dividerPadding;
    private int ds20;
    private boolean isLoading;
    private Locale locale;
    private RectF rectF;
    private int tabPadding;

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dPd = new a();
        this.currentPosition = 0;
        this.aty = 0.0f;
        this.atA = false;
        this.atB = al.getColor(d.C0141d.cp_cont_b);
        this.atC = al.getColor(d.C0141d.cp_cont_j);
        this.atD = 52;
        this.atE = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.avP = 1;
        this.atK = 17;
        this.atN = 0;
        this.atO = d.f.pager_sliding_view;
        this.dPg = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.atv = new LinearLayout(getContext());
        this.atv.setOrientation(0);
        this.atv.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.atv);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.atD = (int) TypedValue.applyDimension(1, this.atD, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.avP = (int) TypedValue.applyDimension(1, this.avP, displayMetrics);
        this.atK = i;
        this.atE = i2;
        this.atA = z;
        this.atz = new Paint();
        this.atz.setAntiAlias(true);
        this.atz.setStyle(Paint.Style.FILL);
        this.dPe = al.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.e(getContext(), d.e.ds20);
        this.atr = new LinearLayout.LayoutParams(-2, -1);
        this.ats = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.e(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.dPf = z;
        invalidate();
    }

    public boolean aCu() {
        return this.dPf;
    }

    public void setTabItemClicked(boolean z) {
        this.dPg = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.atw = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dPd);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.atu = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.atw != null && this.atw.getAdapter() != null && this.atw.getAdapter().getCount() != 0) {
            this.atv.removeAllViews();
            this.atx = this.atw.getAdapter().getCount();
            for (int i = 0; i < this.atx; i++) {
                h(i, this.atw.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.atw.getCurrentItem();
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
                    if (PagerSlidingTabStrip.this.atw.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new am("c12049").r("obj_locate", i + 1).ah("obj_type", "1"));
                    PagerSlidingTabStrip.this.dPg = true;
                    if (PagerSlidingTabStrip.this.atw.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.atw.getAdapter()).mq(i);
                    }
                    PagerSlidingTabStrip.this.atw.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.atv.addView(view, i, this.atA ? this.ats : this.atr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.atx; i++) {
            View childAt = this.atv.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.atO);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.atK);
                    if (i == this.atw.getCurrentItem()) {
                        textView.setTextColor(this.atB);
                    } else {
                        textView.setTextColor(this.atC);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.atx != 0) {
            int left = this.atv.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.atD;
            }
            if (left != this.atN) {
                this.atN = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.atx != 0) {
            int height = getHeight();
            this.atz.setColor(this.atB);
            View childAt = this.atv.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.aty > 0.0f && this.currentPosition < this.atx - 1) {
                View childAt2 = this.atv.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.aty)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.aty);
                right = (right * (1.0f - this.aty)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.aty);
            }
            if (this.rectF == null) {
                this.rectF = new RectF(left, height - this.atE, right, height);
            } else {
                this.rectF.set(left, height - this.atE, right, height);
            }
            canvas.drawRoundRect(this.rectF, 10.0f, 10.0f, this.atz);
            if (this.dPf) {
                View childAt3 = this.atv.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.dPe.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.dPe.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.atB = al.getColor(d.C0141d.cp_cont_b);
        this.atC = al.getColor(d.C0141d.cp_cont_j);
        this.dPe = al.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.atv.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dPg) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.aty = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.atv.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.atu != null) {
                    PagerSlidingTabStrip.this.atu.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.atv.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.atw.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.aty = 0.0f;
                    PagerSlidingTabStrip.this.dPg = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.atu != null) {
                    PagerSlidingTabStrip.this.atu.onPageScrollStateChanged(i);
                }
                HomePageStatic.dMt = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.atu != null) {
                PagerSlidingTabStrip.this.atu.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dPg) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.aty * PagerSlidingTabStrip.this.atv.getChildAt(i).getWidth()));
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
            /* renamed from: n */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ms */
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

    public View mr(int i) {
        return this.atv.getChildAt(i);
    }
}
