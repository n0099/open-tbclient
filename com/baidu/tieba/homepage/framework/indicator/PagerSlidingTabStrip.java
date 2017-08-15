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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.d;
import java.util.Locale;
/* loaded from: classes.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private LinearLayout.LayoutParams anb;
    private LinearLayout.LayoutParams anc;
    public ViewPager.OnPageChangeListener ane;
    private LinearLayout anf;
    private ViewPager ang;
    private int anh;
    private float ani;
    private Paint anj;
    private boolean ank;
    private int anl;
    private int anm;
    private int ano;
    private int anp;
    private int anr;
    private int ans;
    private int ant;
    private int anw;
    private int anx;
    private final a cTV;
    private Drawable cTW;
    private boolean cTX;
    private boolean cTY;
    private int currentPosition;
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
        this.cTV = new a();
        this.currentPosition = 0;
        this.ani = 0.0f;
        this.ank = false;
        this.anl = ai.getColor(d.e.cp_cont_b);
        this.anm = ai.getColor(d.e.cp_cont_f);
        this.ano = 52;
        this.anp = 4;
        this.dividerPadding = 12;
        this.anr = 24;
        this.ans = 1;
        this.ant = 12;
        this.anw = 0;
        this.anx = d.g.pager_sliding_view;
        this.cTY = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.anf = new LinearLayout(getContext());
        this.anf.setOrientation(0);
        this.anf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.anf);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ano = (int) TypedValue.applyDimension(1, this.ano, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.anr = (int) TypedValue.applyDimension(1, this.anr, displayMetrics);
        this.ans = (int) TypedValue.applyDimension(1, this.ans, displayMetrics);
        this.ant = i;
        this.anp = i2;
        this.ank = z;
        this.anj = new Paint();
        this.anj.setAntiAlias(true);
        this.anj.setStyle(Paint.Style.FILL);
        this.cTW = ai.getDrawable(d.g.icon_news_down_bar_one);
        this.ds20 = k.g(getContext(), d.f.ds20);
        this.anb = new LinearLayout.LayoutParams(-2, -1);
        this.anc = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.anr = k.g(getContext(), d.f.ds40);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cTX = z;
        invalidate();
    }

    public boolean aoS() {
        return this.cTX;
    }

    public void setTabItemClicked(boolean z) {
        this.cTY = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.ang = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cTV);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.ane = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.ang != null && this.ang.getAdapter() != null && this.ang.getAdapter().getCount() != 0) {
            this.anf.removeAllViews();
            this.anh = this.ang.getAdapter().getCount();
            for (int i = 0; i < this.anh; i++) {
                i(i, this.ang.getAdapter().getPageTitle(i).toString());
            }
            wR();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.ang.getCurrentItem();
                    PagerSlidingTabStrip.this.E(PagerSlidingTabStrip.this.currentPosition, 0);
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
                    if (PagerSlidingTabStrip.this.ang.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                    } else if (i != com.baidu.tieba.homepage.framework.indicator.a.cTQ || aw.aO(PagerSlidingTabStrip.this.getContext())) {
                        TiebaStatic.log(new aj("c12049").r("obj_locate", i + 1).aa("obj_type", "1"));
                        PagerSlidingTabStrip.this.cTY = true;
                        if (PagerSlidingTabStrip.this.ang.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                            ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.ang.getAdapter()).kM(i);
                        }
                        PagerSlidingTabStrip.this.ang.setCurrentItem(i);
                        PagerSlidingTabStrip.this.wR();
                    }
                }
            }
        });
        view.setPadding(this.anr, 0, this.anr, 0);
        this.anf.addView(view, i, this.ank ? this.anc : this.anb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR() {
        for (int i = 0; i < this.anh; i++) {
            View childAt = this.anf.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.anx);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.ant);
                    if (i == this.ang.getCurrentItem()) {
                        textView.setTextColor(this.anl);
                    } else {
                        textView.setTextColor(this.anm);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i, int i2) {
        if (this.anh != 0) {
            int left = this.anf.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.ano;
            }
            if (left != this.anw) {
                this.anw = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.anh != 0) {
            int height = getHeight();
            this.anj.setColor(this.anl);
            View childAt = this.anf.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.ani > 0.0f && this.currentPosition < this.anh - 1) {
                View childAt2 = this.anf.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.ani)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.ani);
                right = (right * (1.0f - this.ani)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.ani);
            }
            canvas.drawRect(left, height - this.anp, right, height, this.anj);
            if (this.cTX) {
                View childAt3 = this.anf.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.cTW.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.cTW.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.anl = ai.getColor(d.e.cp_cont_b);
        this.anm = ai.getColor(d.e.cp_cont_f);
        this.cTW = ai.getDrawable(d.g.icon_news_down_bar_one);
        wR();
        invalidate();
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int aSO;

        private a() {
            this.aSO = com.baidu.tieba.homepage.framework.indicator.a.cTT;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.anf.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cTY) {
                    if (PagerSlidingTabStrip.this.currentPosition != i) {
                        this.aSO = PagerSlidingTabStrip.this.currentPosition;
                    }
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.ani = f;
                    PagerSlidingTabStrip.this.E(i, (int) (PagerSlidingTabStrip.this.anf.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.ane != null) {
                    PagerSlidingTabStrip.this.ane.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.anf.getChildCount() != 0) {
                if (i == 0) {
                    if (PagerSlidingTabStrip.this.currentPosition != com.baidu.tieba.homepage.framework.indicator.a.cTQ || aw.aO(PagerSlidingTabStrip.this.getContext())) {
                        PagerSlidingTabStrip.this.E(PagerSlidingTabStrip.this.ang.getCurrentItem(), 0);
                    } else {
                        PagerSlidingTabStrip.this.ang.setCurrentItem(this.aSO, false);
                    }
                    PagerSlidingTabStrip.this.ani = 0.0f;
                    PagerSlidingTabStrip.this.cTY = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.ane != null) {
                    PagerSlidingTabStrip.this.ane.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.ane != null) {
                PagerSlidingTabStrip.this.ane.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cTY) {
                PagerSlidingTabStrip.this.currentPosition = i;
                if (PagerSlidingTabStrip.this.currentPosition != i) {
                    this.aSO = PagerSlidingTabStrip.this.currentPosition;
                }
                PagerSlidingTabStrip.this.E(i, (int) (PagerSlidingTabStrip.this.ani * PagerSlidingTabStrip.this.anf.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.wR();
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
            /* renamed from: kN */
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
