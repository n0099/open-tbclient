package com.baidu.tbadk.widget.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes3.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    public ViewPager.OnPageChangeListener bWA;
    private LinearLayout bWB;
    private ViewPager bWC;
    private int bWD;
    private Paint bWF;
    private boolean bWG;
    private int bWH;
    private int bWI;
    private int bWT;
    private int bWU;
    private LinearLayout.LayoutParams bWx;
    private LinearLayout.LayoutParams bWy;
    private int bZb;
    private final b cMc;
    private boolean cMd;
    private float cMe;
    private int cMf;
    private int cMg;
    private Paint cMh;
    private RectF cMi;
    private boolean cMj;
    private int cMk;
    private int cMl;
    private int cMm;
    private int cMn;
    private int cMo;
    private int cMp;
    private int cMq;
    private int cMr;
    private float cMs;
    private float cMt;
    private int cMu;
    private int cMv;
    private int cMw;
    private boolean cMx;
    private a cMy;
    private int dividerPadding;
    private boolean isLoading;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;
    private RectF qc;

    /* loaded from: classes3.dex */
    public interface a {
        void r(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cMc = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cMe = 0.0f;
        this.cMf = 0;
        this.cMg = 0;
        this.bWG = false;
        this.bWH = al.getColor(R.color.cp_cont_b);
        this.bWI = al.getColor(R.color.cp_cont_j);
        this.cMl = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.bZb = 1;
        this.cMp = 17;
        this.cMq = 17;
        this.bWT = 0;
        this.bWU = R.drawable.pager_sliding_view;
        this.cMx = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bWB = new LinearLayout(getContext());
        this.bWB.setOrientation(0);
        this.bWB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bWB);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cMl = (int) TypedValue.applyDimension(1, this.cMl, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.bZb = (int) TypedValue.applyDimension(1, this.bZb, displayMetrics);
        this.cMp = i;
        this.cMq = i2;
        this.cMr = l.g(getContext(), R.dimen.tbds74);
        this.cMs = (this.cMq * 1.0f) / this.cMp;
        this.cMt = (this.cMr * 1.0f) / this.cMp;
        this.mIndicatorHeight = i3;
        this.bWG = z;
        this.bWF = new Paint();
        this.bWF.setAntiAlias(true);
        this.bWF.setStyle(Paint.Style.FILL);
        this.bWF.setColor(al.getColor(R.color.cp_other_e));
        this.cMh = new Paint();
        this.cMh.setAntiAlias(true);
        this.cMh.setStyle(Paint.Style.FILL);
        this.cMh.setColor(al.getColor(R.color.cp_cont_h));
        this.cMi = new RectF();
        this.cMu = l.g(getContext(), R.dimen.tbds20);
        this.cMv = l.g(getContext(), R.dimen.tbds28);
        this.cMw = l.g(getContext(), R.dimen.tbds22);
        this.bWx = new LinearLayout.LayoutParams(-2, -1);
        this.bWy = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.tbds200), -1);
        this.cMn = l.g(getContext(), R.dimen.tbds22);
        this.cMm = l.g(getContext(), R.dimen.tbds20);
        this.cMo = l.g(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cMj = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.cMx = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bWC = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cMc);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bWA = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bWC != null && this.bWC.getAdapter() != null && this.bWC.getAdapter().getCount() != 0) {
            this.bWB.removeAllViews();
            this.bWD = this.bWC.getAdapter().getCount();
            for (int i = 0; i < this.bWD; i++) {
                D(i, this.bWC.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.bWC.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.cMf = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void D(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.cMp);
        textView.setSingleLine();
        e(i, textView);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.cMy != null) {
                        PagerSlidingTabBaseStrip.this.cMy.r(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.bWC.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.cMx = true;
                        PagerSlidingTabBaseStrip.this.bWC.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                }
            }
        });
        this.bWB.addView(view, i, this.bWG ? this.bWy : this.bWx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bWD != 0) {
            int left = this.bWB.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cMl;
            }
            if (left != this.bWT) {
                this.bWT = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.bWD != 0) {
            View childAt = this.bWB.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cMn;
            float right2 = childAt.getRight() - this.cMn;
            if (this.cMe > 0.0f && this.mCurrentTabIndex != this.cMf && this.cMf <= this.bWD - 1 && this.cMf >= 0) {
                View childAt2 = this.bWB.getChildAt(this.cMf);
                left = d(left, childAt2.getLeft() + this.cMn, this.cMe);
                right2 = e(right2, childAt2.getRight() - this.cMn, this.cMe);
            }
            int height = getHeight();
            if (this.qc == null) {
                this.qc = new RectF(left, (height - this.mIndicatorHeight) - this.cMm, right2, height - this.cMm);
            } else {
                this.qc.set(left, (height - this.mIndicatorHeight) - this.cMm, right2, height - this.cMm);
            }
            canvas.drawRoundRect(this.qc, 16.0f, 16.0f, this.bWF);
            if (this.cMj) {
                View childAt3 = this.bWB.getChildAt(this.cMk);
                this.cMi.set((childAt3.getRight() - this.cMw) - this.cMu, childAt3.getTop() + this.cMv, right + this.cMu, top + this.cMu);
                canvas.drawOval(this.cMi, this.cMh);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cMo + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cMo + f2) - ((this.cMo * (f3 - 0.85f)) / 0.15f);
        } else {
            return f;
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 > f) {
            if (f3 <= 0.5d) {
                return f + (((f2 - f) * f3) / 0.5f);
            }
            return f2;
        } else if (f3 >= 0.5d) {
            return f;
        } else {
            if (f3 >= 0.15d) {
                return f - ((((f - this.cMo) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cMo) + ((this.cMo * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.cMd = z;
        if (!z) {
            this.bWH = al.getColor(R.color.cp_cont_b);
            this.bWI = al.getColor(R.color.cp_cont_j);
        } else {
            this.bWH = al.getColor(R.color.cp_btn_a);
            this.bWI = al.getColor(R.color.cp_btn_a);
        }
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.cMd) {
                this.bWH = al.getColor(R.color.cp_cont_b);
                this.bWI = al.getColor(R.color.cp_cont_j);
            } else {
                this.bWH = al.getColor(R.color.cp_btn_a);
                this.bWI = al.getColor(R.color.cp_btn_a);
            }
            this.bWF.setColor(al.getColor(R.color.cp_other_e));
            this.cMh.setColor(al.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cMt - 1.0f) / (0.1f - 1.0f))) + this.cMt;
        }
        return (((this.cMt - this.cMs) / 0.1f) * f) + this.cMs;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cMt) / (0.1f - 0.9f)));
        }
        return (((this.cMt - this.cMs) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cMt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.cMe;
        float f2 = this.cMf < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.bWD) {
            View childAt = this.bWB.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bWU);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.cMf ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (au <= 1.0f) {
                        textView.setTextColor(this.bWI);
                    } else {
                        textView.setTextColor(this.bWH);
                    }
                    if (au <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.bWB.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.cMx) {
                    if (i == PagerSlidingTabBaseStrip.this.cMg) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cMf = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.cMg) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cMf = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.cMf = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.cMg = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cMf = i;
                    }
                    PagerSlidingTabBaseStrip.this.cMe = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.bWB.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.bWA != null) {
                    PagerSlidingTabBaseStrip.this.bWA.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.bWB.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.bWC.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.cMe = 0.0f;
                    PagerSlidingTabBaseStrip.this.cMx = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.cMg = PagerSlidingTabBaseStrip.this.bWC.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.cMg;
                    PagerSlidingTabBaseStrip.this.cMf = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.bWA != null) {
                    PagerSlidingTabBaseStrip.this.bWA.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.bWA != null) {
                PagerSlidingTabBaseStrip.this.bWA.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.cMx) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.cMe * PagerSlidingTabBaseStrip.this.bWB.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.cMg = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.cMf = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Sf;
        this.cMf = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Sf = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: E */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lD */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Sf;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Sf = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Sf);
        }
    }

    public void setConcernTabIndex(int i) {
        this.cMk = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cMy = aVar;
    }
}
