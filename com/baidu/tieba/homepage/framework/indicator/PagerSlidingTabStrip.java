package com.baidu.tieba.homepage.framework.indicator;

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
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import java.util.Locale;
/* loaded from: classes9.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private RectF Fg;
    private int dCe;
    private int dEC;
    private int dED;
    private LinearLayout.LayoutParams dEj;
    private LinearLayout.LayoutParams dEk;
    public ViewPager.OnPageChangeListener dEm;
    private LinearLayout dEn;
    private ViewPager dEo;
    private int dEp;
    private Paint dEr;
    private boolean dEs;
    private int dEt;
    private int dGs;
    private int dividerPadding;
    private int eqC;
    private int eqD;
    private int eqE;
    private int eqF;
    private int eqI;
    private int eqJ;
    private int eqK;
    private float eqL;
    private float eqM;
    private int eqP;
    private int eqQ;
    private int eqR;
    private boolean eqS;
    private boolean eqY;
    private float eqs;
    private int eqt;
    private int equ;
    private Paint eqv;
    private RectF eqw;
    private int eqx;
    private final b hKV;
    private int hKW;
    private int hKX;
    private int hKY;
    private a hKZ;
    private boolean isLoading;
    private Locale locale;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void j(View view, int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hKV = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eqs = 0.0f;
        this.eqt = 0;
        this.equ = 0;
        this.dEs = false;
        this.hKW = R.color.cp_cont_b;
        this.hKX = R.color.cp_cont_j;
        this.hKY = R.color.cp_link_tip_a;
        this.dEt = am.getColor(this.hKW);
        this.dCe = am.getColor(this.hKX);
        this.eqC = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dGs = 1;
        this.eqI = 17;
        this.eqJ = 17;
        this.dEC = 0;
        this.dED = R.drawable.pager_sliding_view;
        this.eqS = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dEn = new LinearLayout(getContext());
        this.dEn.setOrientation(0);
        this.dEn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dEn);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eqC = (int) TypedValue.applyDimension(1, this.eqC, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dGs = (int) TypedValue.applyDimension(1, this.dGs, displayMetrics);
        this.eqI = i;
        this.eqJ = i2;
        this.eqK = l.getDimens(getContext(), R.dimen.tbds46);
        this.eqL = (this.eqJ * 1.0f) / this.eqI;
        this.eqM = (this.eqK * 1.0f) / this.eqI;
        this.mIndicatorHeight = i3;
        this.dEs = z;
        this.dEr = new Paint();
        this.dEr.setAntiAlias(true);
        this.dEr.setStyle(Paint.Style.FILL);
        this.dEr.setColor(am.getColor(R.color.cp_link_tip_a));
        this.eqv = new Paint();
        this.eqv.setAntiAlias(true);
        this.eqv.setStyle(Paint.Style.FILL);
        this.eqv.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.eqv.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.eqw = new RectF();
        this.eqP = l.getDimens(getContext(), R.dimen.tbds20);
        this.eqQ = l.getDimens(getContext(), R.dimen.tbds28);
        this.eqR = l.getDimens(getContext(), R.dimen.tbds22);
        this.dEj = new LinearLayout.LayoutParams(-2, -1);
        this.dEk = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.eqE = l.getDimens(getContext(), R.dimen.tbds62);
        this.eqD = l.getDimens(getContext(), R.dimen.tbds0);
        this.eqF = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dEk = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.eqY = z;
        invalidate();
    }

    public boolean bYt() {
        return this.eqY;
    }

    public void setTabItemClicked(boolean z) {
        this.eqS = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dEo = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.hKV);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEm = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dEo != null && this.dEo.getAdapter() != null && this.dEo.getAdapter().getCount() != 0) {
            this.dEn.removeAllViews();
            this.dEp = this.dEo.getAdapter().getCount();
            for (int i = 0; i < this.dEp; i++) {
                ai(i, this.dEo.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dEo.getCurrentItem();
                    PagerSlidingTabStrip.this.eqt = PagerSlidingTabStrip.this.mCurrentTabIndex;
                    PagerSlidingTabStrip.this.updateTabStyles();
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void ai(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.eqI);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.hKZ != null) {
                        PagerSlidingTabStrip.this.hKZ.j(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.dEo.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).af("obj_locate", i + 1).cI("obj_type", "1"));
                    PagerSlidingTabStrip.this.eqS = true;
                    if (PagerSlidingTabStrip.this.dEo.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.dEo.getAdapter()).vL(i);
                    }
                    PagerSlidingTabStrip.this.dEo.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.dEn.addView(view, i, this.dEs ? this.dEk : this.dEj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dEp != 0) {
            int left = this.dEn.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eqC;
            }
            if (left != this.dEC) {
                this.dEC = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dEp != 0) {
            View childAt = this.dEn.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.eqE;
            float right2 = childAt.getRight() - this.eqE;
            if (this.eqs > 0.0f && this.mCurrentTabIndex != this.eqt && this.eqt <= this.dEp - 1 && this.eqt >= 0) {
                View childAt2 = this.dEn.getChildAt(this.eqt);
                left = e(left, childAt2.getLeft() + this.eqE, this.eqs);
                right2 = f(right2, childAt2.getRight() - this.eqE, this.eqs);
            }
            int height = getHeight();
            if (this.Fg == null) {
                this.Fg = new RectF(left, (height - this.mIndicatorHeight) - this.eqD, right2, height - this.eqD);
            } else {
                this.Fg.set(left, (height - this.mIndicatorHeight) - this.eqD, right2, height - this.eqD);
            }
            canvas.drawRoundRect(this.Fg, 16.0f, 16.0f, this.dEr);
            if (this.eqY) {
                View childAt3 = this.dEn.getChildAt(this.eqx);
                this.eqw.set((childAt3.getRight() - this.eqR) - this.eqP, childAt3.getTop() + this.eqQ, right + this.eqP, top2 + this.eqP);
                canvas.drawOval(this.eqw, this.eqv);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.eqF + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.eqF + f2) - ((this.eqF * (f3 - 0.8f)) / 0.2f);
        } else {
            return f;
        }
    }

    private float f(float f, float f2, float f3) {
        if (f2 > f) {
            if (f3 <= 0.5d) {
                return f + (((f2 - f) * f3) / 0.5f);
            }
            return f2;
        } else if (f3 >= 0.5d) {
            return f;
        } else {
            if (f3 >= 0.2d) {
                return f - ((((this.eqF + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.eqF) + ((this.eqF * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dEt = am.getColor(this.hKW);
            this.dCe = am.getColor(this.hKX);
            this.dEr.setColor(am.getColor(this.hKY));
            this.eqv.setColor(am.getColor(R.color.cp_cont_h));
            this.eqv.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eqM - 1.0f) / (0.1f - 1.0f))) + this.eqM;
        }
        return (((this.eqM - this.eqL) / 0.1f) * f) + this.eqL;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eqM) / (0.1f - 0.9f)));
        }
        return (((this.eqM - this.eqL) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eqM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.eqs;
        float f2 = this.eqt < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dEp) {
            View childAt = this.dEn.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dED);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.eqt ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (f2 >= 0.5f) {
                        if (i == this.eqt) {
                            textView.setTextColor(this.dEt);
                        } else {
                            textView.setTextColor(this.dCe);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dEt);
                    } else {
                        textView.setTextColor(this.dCe);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.eqt) {
                            textView.setTypeface(Typeface.defaultFromStyle(1));
                        } else {
                            textView.setTypeface(Typeface.defaultFromStyle(0));
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes9.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabStrip.this.dEn.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.eqS) {
                    if (i == PagerSlidingTabStrip.this.equ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eqt = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.equ) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eqt = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.eqt = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.equ = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eqt = i;
                    }
                    PagerSlidingTabStrip.this.eqs = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dEn.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dEm != null) {
                    PagerSlidingTabStrip.this.dEm.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dEn.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dEo.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.eqs = 0.0f;
                    PagerSlidingTabStrip.this.eqS = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.equ = PagerSlidingTabStrip.this.dEo.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.equ;
                    PagerSlidingTabStrip.this.eqt = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.dEm != null) {
                    PagerSlidingTabStrip.this.dEm.onPageScrollStateChanged(i);
                }
                HomePageStatic.hHA = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dEm != null) {
                PagerSlidingTabStrip.this.dEm.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.eqS) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eqs * PagerSlidingTabStrip.this.dEn.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.equ = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.eqt = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.XP;
        this.eqt = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.XP = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: T */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: vN */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int XP;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.XP = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XP);
        }
    }

    public View vM(int i) {
        return this.dEn.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.eqx = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.hKZ = aVar;
    }
}
