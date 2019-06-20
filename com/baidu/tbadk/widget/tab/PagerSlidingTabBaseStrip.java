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
    public ViewPager.OnPageChangeListener bWB;
    private LinearLayout bWC;
    private ViewPager bWD;
    private int bWE;
    private Paint bWG;
    private boolean bWH;
    private int bWI;
    private int bWJ;
    private int bWU;
    private int bWV;
    private LinearLayout.LayoutParams bWy;
    private LinearLayout.LayoutParams bWz;
    private int bZc;
    private final b cMd;
    private boolean cMe;
    private float cMf;
    private int cMg;
    private int cMh;
    private Paint cMi;
    private RectF cMj;
    private boolean cMk;
    private int cMl;
    private int cMm;
    private int cMn;
    private int cMo;
    private int cMp;
    private int cMq;
    private int cMr;
    private int cMs;
    private float cMt;
    private float cMu;
    private int cMv;
    private int cMw;
    private int cMx;
    private boolean cMy;
    private a cMz;
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
        this.cMd = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cMf = 0.0f;
        this.cMg = 0;
        this.cMh = 0;
        this.bWH = false;
        this.bWI = al.getColor(R.color.cp_cont_b);
        this.bWJ = al.getColor(R.color.cp_cont_j);
        this.cMm = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.bZc = 1;
        this.cMq = 17;
        this.cMr = 17;
        this.bWU = 0;
        this.bWV = R.drawable.pager_sliding_view;
        this.cMy = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.bWC = new LinearLayout(getContext());
        this.bWC.setOrientation(0);
        this.bWC.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.bWC);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cMm = (int) TypedValue.applyDimension(1, this.cMm, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.bZc = (int) TypedValue.applyDimension(1, this.bZc, displayMetrics);
        this.cMq = i;
        this.cMr = i2;
        this.cMs = l.g(getContext(), R.dimen.tbds74);
        this.cMt = (this.cMr * 1.0f) / this.cMq;
        this.cMu = (this.cMs * 1.0f) / this.cMq;
        this.mIndicatorHeight = i3;
        this.bWH = z;
        this.bWG = new Paint();
        this.bWG.setAntiAlias(true);
        this.bWG.setStyle(Paint.Style.FILL);
        this.bWG.setColor(al.getColor(R.color.cp_other_e));
        this.cMi = new Paint();
        this.cMi.setAntiAlias(true);
        this.cMi.setStyle(Paint.Style.FILL);
        this.cMi.setColor(al.getColor(R.color.cp_cont_h));
        this.cMj = new RectF();
        this.cMv = l.g(getContext(), R.dimen.tbds20);
        this.cMw = l.g(getContext(), R.dimen.tbds28);
        this.cMx = l.g(getContext(), R.dimen.tbds22);
        this.bWy = new LinearLayout.LayoutParams(-2, -1);
        this.bWz = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.tbds200), -1);
        this.cMo = l.g(getContext(), R.dimen.tbds22);
        this.cMn = l.g(getContext(), R.dimen.tbds20);
        this.cMp = l.g(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cMk = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.cMy = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.bWD = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cMd);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.bWB = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.bWD != null && this.bWD.getAdapter() != null && this.bWD.getAdapter().getCount() != 0) {
            this.bWC.removeAllViews();
            this.bWE = this.bWD.getAdapter().getCount();
            for (int i = 0; i < this.bWE; i++) {
                D(i, this.bWD.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.bWD.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.cMg = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.cMq);
        textView.setSingleLine();
        e(i, textView);
    }

    private void e(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.cMz != null) {
                        PagerSlidingTabBaseStrip.this.cMz.r(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.bWD.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.cMy = true;
                        PagerSlidingTabBaseStrip.this.bWD.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                }
            }
        });
        this.bWC.addView(view, i, this.bWH ? this.bWz : this.bWy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.bWE != 0) {
            int left = this.bWC.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cMm;
            }
            if (left != this.bWU) {
                this.bWU = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.bWE != 0) {
            View childAt = this.bWC.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cMo;
            float right2 = childAt.getRight() - this.cMo;
            if (this.cMf > 0.0f && this.mCurrentTabIndex != this.cMg && this.cMg <= this.bWE - 1 && this.cMg >= 0) {
                View childAt2 = this.bWC.getChildAt(this.cMg);
                left = d(left, childAt2.getLeft() + this.cMo, this.cMf);
                right2 = e(right2, childAt2.getRight() - this.cMo, this.cMf);
            }
            int height = getHeight();
            if (this.qc == null) {
                this.qc = new RectF(left, (height - this.mIndicatorHeight) - this.cMn, right2, height - this.cMn);
            } else {
                this.qc.set(left, (height - this.mIndicatorHeight) - this.cMn, right2, height - this.cMn);
            }
            canvas.drawRoundRect(this.qc, 16.0f, 16.0f, this.bWG);
            if (this.cMk) {
                View childAt3 = this.bWC.getChildAt(this.cMl);
                this.cMj.set((childAt3.getRight() - this.cMx) - this.cMv, childAt3.getTop() + this.cMw, right + this.cMv, top + this.cMv);
                canvas.drawOval(this.cMj, this.cMi);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cMp + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cMp + f2) - ((this.cMp * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.cMp) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cMp) + ((this.cMp * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.cMe = z;
        if (!z) {
            this.bWI = al.getColor(R.color.cp_cont_b);
            this.bWJ = al.getColor(R.color.cp_cont_j);
        } else {
            this.bWI = al.getColor(R.color.cp_btn_a);
            this.bWJ = al.getColor(R.color.cp_btn_a);
        }
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.cMe) {
                this.bWI = al.getColor(R.color.cp_cont_b);
                this.bWJ = al.getColor(R.color.cp_cont_j);
            } else {
                this.bWI = al.getColor(R.color.cp_btn_a);
                this.bWJ = al.getColor(R.color.cp_btn_a);
            }
            this.bWG.setColor(al.getColor(R.color.cp_other_e));
            this.cMi.setColor(al.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float at(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cMu - 1.0f) / (0.1f - 1.0f))) + this.cMu;
        }
        return (((this.cMu - this.cMt) / 0.1f) * f) + this.cMt;
    }

    private float au(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cMu) / (0.1f - 0.9f)));
        }
        return (((this.cMu - this.cMt) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cMu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float au;
        float f = this.cMf;
        float f2 = this.cMg < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.bWE) {
            View childAt = this.bWC.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.bWV);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        au = at(f2);
                    } else {
                        au = i == this.cMg ? au(f2) : 1.0f;
                    }
                    textView.setScaleX(au);
                    textView.setScaleY(au);
                    if (au <= 1.0f) {
                        textView.setTextColor(this.bWJ);
                    } else {
                        textView.setTextColor(this.bWI);
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
            if (PagerSlidingTabBaseStrip.this.bWC.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.cMy) {
                    if (i == PagerSlidingTabBaseStrip.this.cMh) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cMg = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.cMh) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cMg = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.cMg = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.cMh = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cMg = i;
                    }
                    PagerSlidingTabBaseStrip.this.cMf = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.bWC.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.bWB != null) {
                    PagerSlidingTabBaseStrip.this.bWB.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.bWC.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.bWD.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.cMf = 0.0f;
                    PagerSlidingTabBaseStrip.this.cMy = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.cMh = PagerSlidingTabBaseStrip.this.bWD.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.cMh;
                    PagerSlidingTabBaseStrip.this.cMg = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.bWB != null) {
                    PagerSlidingTabBaseStrip.this.bWB.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.bWB != null) {
                PagerSlidingTabBaseStrip.this.bWB.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.cMy) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.cMf * PagerSlidingTabBaseStrip.this.bWC.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.cMh = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.cMg = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Se;
        this.cMg = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Se = this.mCurrentTabIndex;
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
        int Se;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Se = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Se);
        }
    }

    public void setConcernTabIndex(int i) {
        this.cMl = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cMz = aVar;
    }
}
