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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes2.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int auA;
    private LinearLayout.LayoutParams aud;
    private LinearLayout.LayoutParams aue;
    public ViewPager.OnPageChangeListener aug;
    private LinearLayout auh;
    private ViewPager aui;
    private int auj;
    private float auk;
    private Paint aul;
    private boolean aum;
    private int aun;
    private int auo;
    private int aup;
    private int auq;
    private int auw;
    private int auz;
    private int awy;
    private int currentPosition;
    private final a dSu;
    private Drawable dSv;
    private boolean dSw;
    private boolean dSx;
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
        this.dSu = new a();
        this.currentPosition = 0;
        this.auk = 0.0f;
        this.aum = false;
        this.aun = am.getColor(d.C0142d.cp_cont_b);
        this.auo = am.getColor(d.C0142d.cp_cont_j);
        this.aup = 52;
        this.auq = 4;
        this.dividerPadding = 12;
        this.tabPadding = 28;
        this.awy = 1;
        this.auw = 17;
        this.auz = 0;
        this.auA = d.f.pager_sliding_view;
        this.dSx = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.auh = new LinearLayout(getContext());
        this.auh.setOrientation(0);
        this.auh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.auh);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aup = (int) TypedValue.applyDimension(1, this.aup, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.awy = (int) TypedValue.applyDimension(1, this.awy, displayMetrics);
        this.auw = i;
        this.auq = i2;
        this.aum = z;
        this.aul = new Paint();
        this.aul.setAntiAlias(true);
        this.aul.setStyle(Paint.Style.FILL);
        this.dSv = am.getDrawable(d.f.icon_news_down_bar_one);
        this.ds20 = l.e(getContext(), d.e.ds20);
        this.aud = new LinearLayout.LayoutParams(-2, -1);
        this.aue = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.tabPadding = l.e(getContext(), d.e.ds28);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.dSw = z;
        invalidate();
    }

    public boolean aCY() {
        return this.dSw;
    }

    public void setTabItemClicked(boolean z) {
        this.dSx = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.aui = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dSu);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aug = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.aui != null && this.aui.getAdapter() != null && this.aui.getAdapter().getCount() != 0) {
            this.auh.removeAllViews();
            this.auj = this.aui.getAdapter().getCount();
            for (int i = 0; i < this.auj; i++) {
                h(i, this.aui.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.aui.getCurrentItem();
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
                    if (PagerSlidingTabStrip.this.aui.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new an("c12049").r("obj_locate", i + 1).ah("obj_type", "1"));
                    PagerSlidingTabStrip.this.dSx = true;
                    if (PagerSlidingTabStrip.this.aui.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.aui.getAdapter()).mx(i);
                    }
                    PagerSlidingTabStrip.this.aui.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        view.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.auh.addView(view, i, this.aum ? this.aue : this.aud);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        for (int i = 0; i < this.auj; i++) {
            View childAt = this.auh.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.auA);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.auw);
                    if (i == this.aui.getCurrentItem()) {
                        textView.setTextColor(this.aun);
                    } else {
                        textView.setTextColor(this.auo);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.auj != 0) {
            int left = this.auh.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.aup;
            }
            if (left != this.auz) {
                this.auz = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.auj != 0) {
            int height = getHeight();
            this.aul.setColor(this.aun);
            View childAt = this.auh.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.auk > 0.0f && this.currentPosition < this.auj - 1) {
                View childAt2 = this.auh.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.auk)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.auk);
                right = (right * (1.0f - this.auk)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.auk);
            }
            if (this.rectF == null) {
                this.rectF = new RectF(left, height - this.auq, right, height);
            } else {
                this.rectF.set(left, height - this.auq, right, height);
            }
            canvas.drawRoundRect(this.rectF, 10.0f, 10.0f, this.aul);
            if (this.dSw) {
                View childAt3 = this.auh.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.dSv.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.dSv.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.aun = am.getColor(d.C0142d.cp_cont_b);
        this.auo = am.getColor(d.C0142d.cp_cont_j);
        this.dSv = am.getDrawable(d.f.icon_news_down_bar_one);
        updateTabStyles();
        invalidate();
    }

    /* loaded from: classes2.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.auh.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.dSx) {
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.auk = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.auh.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.aug != null) {
                    PagerSlidingTabStrip.this.aug.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.auh.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.aui.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.auk = 0.0f;
                    PagerSlidingTabStrip.this.dSx = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.aug != null) {
                    PagerSlidingTabStrip.this.aug.onPageScrollStateChanged(i);
                }
                HomePageStatic.dPJ = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.aug != null) {
                PagerSlidingTabStrip.this.aug.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.dSx) {
                PagerSlidingTabStrip.this.currentPosition = i;
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.auk * PagerSlidingTabStrip.this.auh.getChildAt(i).getWidth()));
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
            /* renamed from: mz */
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

    public View my(int i) {
        return this.auh.getChildAt(i);
    }
}
