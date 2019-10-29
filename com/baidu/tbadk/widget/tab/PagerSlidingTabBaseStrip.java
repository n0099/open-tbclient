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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes3.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private final b cXM;
    private boolean cXN;
    private float cXO;
    private int cXP;
    private int cXQ;
    private Paint cXR;
    private RectF cXS;
    private boolean cXT;
    private int cXU;
    private int cXV;
    private int cXW;
    private int cXX;
    private int cXY;
    private int cXZ;
    private int cYa;
    private int cYb;
    private float cYc;
    private float cYd;
    private int cYe;
    private int cYf;
    private int cYg;
    private boolean cYh;
    private a cYi;
    public ViewPager.OnPageChangeListener cnA;
    private LinearLayout cnB;
    private ViewPager cnC;
    private int cnD;
    private Paint cnF;
    private boolean cnG;
    private int cnH;
    private int cnI;
    private int cnT;
    private int cnU;
    private LinearLayout.LayoutParams cnx;
    private LinearLayout.LayoutParams cny;
    private int cpF;
    private int dividerPadding;
    private boolean isLoading;
    private RectF iu;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes3.dex */
    public interface a {
        void k(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cXM = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.cXO = 0.0f;
        this.cXP = 0;
        this.cXQ = 0;
        this.cnG = false;
        this.cnH = am.getColor(R.color.cp_cont_b);
        this.cnI = am.getColor(R.color.cp_cont_j);
        this.cXV = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.cpF = 1;
        this.cXZ = 17;
        this.cYa = 17;
        this.cnT = 0;
        this.cnU = R.drawable.pager_sliding_view;
        this.cYh = false;
        this.isLoading = false;
    }

    public void d(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.cnB = new LinearLayout(getContext());
        this.cnB.setOrientation(0);
        this.cnB.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.cnB);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.cXV = (int) TypedValue.applyDimension(1, this.cXV, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.cpF = (int) TypedValue.applyDimension(1, this.cpF, displayMetrics);
        this.cXZ = i;
        this.cYa = i2;
        this.cYb = l.getDimens(getContext(), R.dimen.tbds74);
        this.cYc = (this.cYa * 1.0f) / this.cXZ;
        this.cYd = (this.cYb * 1.0f) / this.cXZ;
        this.mIndicatorHeight = i3;
        this.cnG = z;
        this.cnF = new Paint();
        this.cnF.setAntiAlias(true);
        this.cnF.setStyle(Paint.Style.FILL);
        this.cnF.setColor(am.getColor(R.color.cp_other_e));
        this.cXR = new Paint();
        this.cXR.setAntiAlias(true);
        this.cXR.setStyle(Paint.Style.FILL);
        this.cXR.setColor(am.getColor(R.color.cp_cont_h));
        this.cXS = new RectF();
        this.cYe = l.getDimens(getContext(), R.dimen.tbds20);
        this.cYf = l.getDimens(getContext(), R.dimen.tbds28);
        this.cYg = l.getDimens(getContext(), R.dimen.tbds22);
        this.cnx = new LinearLayout.LayoutParams(-2, -1);
        this.cny = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.cXX = l.getDimens(getContext(), R.dimen.tbds22);
        this.cXW = l.getDimens(getContext(), R.dimen.tbds20);
        this.cXY = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        this.cXT = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.cYh = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cnC = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.cXM);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cnA = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.cnC != null && this.cnC.getAdapter() != null && this.cnC.getAdapter().getCount() != 0) {
            this.cnB.removeAllViews();
            this.cnD = this.cnC.getAdapter().getCount();
            for (int i = 0; i < this.cnD; i++) {
                G(i, this.cnC.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.cnC.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.cXP = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void G(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.cXZ);
        textView.setSingleLine();
        f(i, textView);
    }

    private void f(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.cYi != null) {
                        PagerSlidingTabBaseStrip.this.cYi.k(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.cnC.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.cYh = true;
                        PagerSlidingTabBaseStrip.this.cnC.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.cnB.addView(view, i, this.cnG ? this.cny : this.cnx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.cnD != 0) {
            int left = this.cnB.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.cXV;
            }
            if (left != this.cnT) {
                this.cnT = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.cnD != 0) {
            View childAt = this.cnB.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.cXX;
            float right2 = childAt.getRight() - this.cXX;
            if (this.cXO > 0.0f && this.mCurrentTabIndex != this.cXP && this.cXP <= this.cnD - 1 && this.cXP >= 0) {
                View childAt2 = this.cnB.getChildAt(this.cXP);
                left = b(left, childAt2.getLeft() + this.cXX, this.cXO);
                right2 = c(right2, childAt2.getRight() - this.cXX, this.cXO);
            }
            int height = getHeight();
            if (this.iu == null) {
                this.iu = new RectF(left, (height - this.mIndicatorHeight) - this.cXW, right2, height - this.cXW);
            } else {
                this.iu.set(left, (height - this.mIndicatorHeight) - this.cXW, right2, height - this.cXW);
            }
            canvas.drawRoundRect(this.iu, 16.0f, 16.0f, this.cnF);
            if (this.cXT) {
                View childAt3 = this.cnB.getChildAt(this.cXU);
                this.cXS.set((childAt3.getRight() - this.cYg) - this.cYe, childAt3.getTop() + this.cYf, right + this.cYe, top + this.cYe);
                canvas.drawOval(this.cXS, this.cXR);
            }
        }
    }

    private float b(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.cXY + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.cXY + f2) - ((this.cXY * (f3 - 0.85f)) / 0.15f);
        } else {
            return f;
        }
    }

    private float c(float f, float f2, float f3) {
        if (f2 > f) {
            if (f3 <= 0.5d) {
                return f + (((f2 - f) * f3) / 0.5f);
            }
            return f2;
        } else if (f3 >= 0.5d) {
            return f;
        } else {
            if (f3 >= 0.15d) {
                return f - ((((f - this.cXY) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.cXY) + ((this.cXY * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.cXN = z;
        if (!z) {
            this.cnH = am.getColor(R.color.cp_cont_b);
            this.cnI = am.getColor(R.color.cp_cont_j);
        } else {
            this.cnH = am.getColor(R.color.cp_cont_a);
            this.cnI = am.getColor(R.color.cp_cont_a);
        }
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.cXN) {
                this.cnH = am.getColor(R.color.cp_cont_b);
                this.cnI = am.getColor(R.color.cp_cont_j);
            } else {
                this.cnH = am.getColor(R.color.cp_cont_a);
                this.cnI = am.getColor(R.color.cp_cont_a);
            }
            this.cnF.setColor(am.getColor(R.color.cp_other_e));
            this.cXR.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float af(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.cYd - 1.0f) / (0.1f - 1.0f))) + this.cYd;
        }
        return (((this.cYd - this.cYc) / 0.1f) * f) + this.cYc;
    }

    private float ag(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.cYd) / (0.1f - 0.9f)));
        }
        return (((this.cYd - this.cYc) / (0.9f - 1.0f)) * (f - 0.9f)) + this.cYd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ag;
        float f = this.cXO;
        float f2 = this.cXP < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.cnD) {
            View childAt = this.cnB.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.cnU);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ag = af(f2);
                    } else {
                        ag = i == this.cXP ? ag(f2) : 1.0f;
                    }
                    textView.setScaleX(ag);
                    textView.setScaleY(ag);
                    if (ag <= 1.0f) {
                        textView.setTextColor(this.cnI);
                    } else {
                        textView.setTextColor(this.cnH);
                    }
                    if (ag <= 1.03f) {
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
            if (PagerSlidingTabBaseStrip.this.cnB.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.cYh) {
                    if (i == PagerSlidingTabBaseStrip.this.cXQ) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cXP = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.cXQ) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cXP = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.cXP = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.cXQ = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.cXP = i;
                    }
                    PagerSlidingTabBaseStrip.this.cXO = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.cnB.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.cnA != null) {
                    PagerSlidingTabBaseStrip.this.cnA.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.cnB.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.cnC.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.cXO = 0.0f;
                    PagerSlidingTabBaseStrip.this.cYh = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.cXQ = PagerSlidingTabBaseStrip.this.cnC.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.cXQ;
                    PagerSlidingTabBaseStrip.this.cXP = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.cnA != null) {
                    PagerSlidingTabBaseStrip.this.cnA.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.cnA != null) {
                PagerSlidingTabBaseStrip.this.cnA.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.cYh) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.cXO * PagerSlidingTabBaseStrip.this.cnB.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.cXQ = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.cXP = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.BQ;
        this.cXP = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.BQ = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: M */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kT */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int BQ;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.BQ = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.BQ);
        }
    }

    public void setConcernTabIndex(int i) {
        this.cXU = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cYi = aVar;
    }
}
