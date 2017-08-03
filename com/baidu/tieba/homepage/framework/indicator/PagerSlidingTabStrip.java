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
    private LinearLayout.LayoutParams alH;
    private LinearLayout.LayoutParams alI;
    public ViewPager.OnPageChangeListener alK;
    private LinearLayout alL;
    private ViewPager alM;
    private int alN;
    private float alO;
    private Paint alP;
    private boolean alQ;
    private int alR;
    private int alS;
    private int alU;
    private int alV;
    private int alX;
    private int alY;
    private int alZ;
    private int amc;
    private int amd;
    private final a cQD;
    private Drawable cQE;
    private boolean cQF;
    private boolean cQG;
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
        this.cQD = new a();
        this.currentPosition = 0;
        this.alO = 0.0f;
        this.alQ = false;
        this.alR = ai.getColor(d.e.cp_cont_b);
        this.alS = ai.getColor(d.e.cp_cont_f);
        this.alU = 52;
        this.alV = 4;
        this.dividerPadding = 12;
        this.alX = 24;
        this.alY = 1;
        this.alZ = 12;
        this.amc = 0;
        this.amd = d.g.pager_sliding_view;
        this.cQG = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.alL = new LinearLayout(getContext());
        this.alL.setOrientation(0);
        this.alL.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.alL);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.alU = (int) TypedValue.applyDimension(1, this.alU, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.alX = (int) TypedValue.applyDimension(1, this.alX, displayMetrics);
        this.alY = (int) TypedValue.applyDimension(1, this.alY, displayMetrics);
        this.alZ = i;
        this.alV = i2;
        this.alQ = z;
        this.alP = new Paint();
        this.alP.setAntiAlias(true);
        this.alP.setStyle(Paint.Style.FILL);
        this.cQE = ai.getDrawable(d.g.icon_news_down_bar_one);
        this.ds20 = k.g(getContext(), d.f.ds20);
        this.alH = new LinearLayout.LayoutParams(-2, -1);
        this.alI = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.alX = k.g(getContext(), d.f.ds40);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cQF = z;
        invalidate();
    }

    public boolean anZ() {
        return this.cQF;
    }

    public void setTabItemClicked(boolean z) {
        this.cQG = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.alM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cQD);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.alK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.alM != null && this.alM.getAdapter() != null && this.alM.getAdapter().getCount() != 0) {
            this.alL.removeAllViews();
            this.alN = this.alM.getAdapter().getCount();
            for (int i = 0; i < this.alN; i++) {
                i(i, this.alM.getAdapter().getPageTitle(i).toString());
            }
            wI();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.alM.getCurrentItem();
                    PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.currentPosition, 0);
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
                    if (PagerSlidingTabStrip.this.alM.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                    } else if (i != com.baidu.tieba.homepage.framework.indicator.a.cQy || aw.aN(PagerSlidingTabStrip.this.getContext())) {
                        TiebaStatic.log(new aj("c12049").r("obj_locate", i + 1).aa("obj_type", "1"));
                        PagerSlidingTabStrip.this.cQG = true;
                        if (PagerSlidingTabStrip.this.alM.getAdapter() instanceof com.baidu.tieba.homepage.framework.indicator.a) {
                            ((com.baidu.tieba.homepage.framework.indicator.a) PagerSlidingTabStrip.this.alM.getAdapter()).kC(i);
                        }
                        PagerSlidingTabStrip.this.alM.setCurrentItem(i);
                        PagerSlidingTabStrip.this.wI();
                    }
                }
            }
        });
        view.setPadding(this.alX, 0, this.alX, 0);
        this.alL.addView(view, i, this.alQ ? this.alI : this.alH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI() {
        for (int i = 0; i < this.alN; i++) {
            View childAt = this.alL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.amd);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setTextSize(0, this.alZ);
                    if (i == this.alM.getCurrentItem()) {
                        textView.setTextColor(this.alR);
                    } else {
                        textView.setTextColor(this.alS);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(int i, int i2) {
        if (this.alN != 0) {
            int left = this.alL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.alU;
            }
            if (left != this.amc) {
                this.amc = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.alN != 0) {
            int height = getHeight();
            this.alP.setColor(this.alR);
            View childAt = this.alL.getChildAt(this.currentPosition);
            float left = childAt.getLeft() + childAt.getPaddingLeft();
            float right = childAt.getRight() - childAt.getPaddingRight();
            if (this.alO > 0.0f && this.currentPosition < this.alN - 1) {
                View childAt2 = this.alL.getChildAt(this.currentPosition + 1);
                left = (left * (1.0f - this.alO)) + ((childAt2.getLeft() + childAt2.getPaddingLeft()) * this.alO);
                right = (right * (1.0f - this.alO)) + ((childAt2.getRight() - childAt2.getPaddingRight()) * this.alO);
            }
            canvas.drawRect(left, height - this.alV, right, height, this.alP);
            if (this.cQF) {
                View childAt3 = this.alL.getChildAt(0);
                int right2 = childAt3.getRight() - childAt.getPaddingRight();
                int top = childAt3.getTop() + this.ds20;
                this.cQE.setBounds(right2, top, this.ds20 + right2, this.ds20 + top);
                this.cQE.draw(canvas);
            }
        }
    }

    public void onChangeSkinType() {
        this.alR = ai.getColor(d.e.cp_cont_b);
        this.alS = ai.getColor(d.e.cp_cont_f);
        this.cQE = ai.getDrawable(d.g.icon_news_down_bar_one);
        wI();
        invalidate();
    }

    /* loaded from: classes.dex */
    private class a implements ViewPager.OnPageChangeListener {
        private int aRB;

        private a() {
            this.aRB = com.baidu.tieba.homepage.framework.indicator.a.cQB;
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.alL.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.cQG) {
                    if (PagerSlidingTabStrip.this.currentPosition != i) {
                        this.aRB = PagerSlidingTabStrip.this.currentPosition;
                    }
                    PagerSlidingTabStrip.this.currentPosition = i;
                    PagerSlidingTabStrip.this.alO = f;
                    PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.alL.getChildAt(i).getWidth() * f));
                    PagerSlidingTabStrip.this.invalidate();
                }
                if (PagerSlidingTabStrip.this.alK != null) {
                    PagerSlidingTabStrip.this.alK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.alL.getChildCount() != 0) {
                if (i == 0) {
                    if (PagerSlidingTabStrip.this.currentPosition != com.baidu.tieba.homepage.framework.indicator.a.cQy || aw.aN(PagerSlidingTabStrip.this.getContext())) {
                        PagerSlidingTabStrip.this.D(PagerSlidingTabStrip.this.alM.getCurrentItem(), 0);
                    } else {
                        PagerSlidingTabStrip.this.alM.setCurrentItem(this.aRB, false);
                    }
                    PagerSlidingTabStrip.this.alO = 0.0f;
                    PagerSlidingTabStrip.this.cQG = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                }
                if (PagerSlidingTabStrip.this.alK != null) {
                    PagerSlidingTabStrip.this.alK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.alK != null) {
                PagerSlidingTabStrip.this.alK.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.cQG) {
                PagerSlidingTabStrip.this.currentPosition = i;
                if (PagerSlidingTabStrip.this.currentPosition != i) {
                    this.aRB = PagerSlidingTabStrip.this.currentPosition;
                }
                PagerSlidingTabStrip.this.D(i, (int) (PagerSlidingTabStrip.this.alO * PagerSlidingTabStrip.this.alL.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.invalidate();
            }
            PagerSlidingTabStrip.this.wI();
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
            /* renamed from: i */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kD */
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
