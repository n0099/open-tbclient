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
    private RectF Fd;
    private int dCa;
    private LinearLayout.LayoutParams dEf;
    private LinearLayout.LayoutParams dEg;
    public ViewPager.OnPageChangeListener dEi;
    private LinearLayout dEj;
    private ViewPager dEk;
    private int dEl;
    private Paint dEn;
    private boolean dEo;
    private int dEp;
    private int dEy;
    private int dEz;
    private int dGo;
    private int dividerPadding;
    private int eqA;
    private int eqD;
    private int eqE;
    private int eqF;
    private float eqG;
    private float eqH;
    private int eqK;
    private int eqL;
    private int eqM;
    private boolean eqN;
    private boolean eqT;
    private float eqn;
    private int eqo;
    private int eqp;
    private Paint eqq;
    private RectF eqr;
    private int eqs;
    private int eqx;
    private int eqy;
    private int eqz;
    private final b hKP;
    private int hKQ;
    private int hKR;
    private int hKS;
    private a hKT;
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
        this.hKP = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eqn = 0.0f;
        this.eqo = 0;
        this.eqp = 0;
        this.dEo = false;
        this.hKQ = R.color.cp_cont_b;
        this.hKR = R.color.cp_cont_j;
        this.hKS = R.color.cp_link_tip_a;
        this.dEp = am.getColor(this.hKQ);
        this.dCa = am.getColor(this.hKR);
        this.eqx = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dGo = 1;
        this.eqD = 17;
        this.eqE = 17;
        this.dEy = 0;
        this.dEz = R.drawable.pager_sliding_view;
        this.eqN = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        this.dEj = new LinearLayout(getContext());
        this.dEj.setOrientation(0);
        this.dEj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.dEj);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eqx = (int) TypedValue.applyDimension(1, this.eqx, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dGo = (int) TypedValue.applyDimension(1, this.dGo, displayMetrics);
        this.eqD = i;
        this.eqE = i2;
        this.eqF = l.getDimens(getContext(), R.dimen.tbds46);
        this.eqG = (this.eqE * 1.0f) / this.eqD;
        this.eqH = (this.eqF * 1.0f) / this.eqD;
        this.mIndicatorHeight = i3;
        this.dEo = z;
        this.dEn = new Paint();
        this.dEn.setAntiAlias(true);
        this.dEn.setStyle(Paint.Style.FILL);
        this.dEn.setColor(am.getColor(R.color.cp_link_tip_a));
        this.eqq = new Paint();
        this.eqq.setAntiAlias(true);
        this.eqq.setStyle(Paint.Style.FILL);
        this.eqq.setColor(am.getColor(R.color.cp_cont_h));
        setLayerType(1, null);
        this.eqq.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
        this.eqr = new RectF();
        this.eqK = l.getDimens(getContext(), R.dimen.tbds20);
        this.eqL = l.getDimens(getContext(), R.dimen.tbds28);
        this.eqM = l.getDimens(getContext(), R.dimen.tbds22);
        this.dEf = new LinearLayout.LayoutParams(-2, -1);
        this.dEg = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds165), -1);
        this.eqz = l.getDimens(getContext(), R.dimen.tbds62);
        this.eqy = l.getDimens(getContext(), R.dimen.tbds0);
        this.eqA = l.getDimens(getContext(), R.dimen.tbds8);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dEg = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.eqT = z;
        invalidate();
    }

    public boolean bYv() {
        return this.eqT;
    }

    public void setTabItemClicked(boolean z) {
        this.eqN = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dEk = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.hKP);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEi = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dEk != null && this.dEk.getAdapter() != null && this.dEk.getAdapter().getCount() != 0) {
            this.dEj.removeAllViews();
            this.dEl = this.dEk.getAdapter().getCount();
            for (int i = 0; i < this.dEl; i++) {
                ai(i, this.dEk.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.dEk.getCurrentItem();
                    PagerSlidingTabStrip.this.eqo = PagerSlidingTabStrip.this.mCurrentTabIndex;
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
        textView.setTextSize(0, this.eqD);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabStrip.this.isLoading) {
                    if (PagerSlidingTabStrip.this.hKT != null) {
                        PagerSlidingTabStrip.this.hKT.j(view2, i);
                    }
                    if (PagerSlidingTabStrip.this.dEk.getCurrentItem() == i) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                        return;
                    }
                    TiebaStatic.log(new an(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).af("obj_locate", i + 1).cI("obj_type", "1"));
                    PagerSlidingTabStrip.this.eqN = true;
                    if (PagerSlidingTabStrip.this.dEk.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) PagerSlidingTabStrip.this.dEk.getAdapter()).vL(i);
                    }
                    PagerSlidingTabStrip.this.dEk.setCurrentItem(i);
                    PagerSlidingTabStrip.this.updateTabStyles();
                }
            }
        });
        this.dEj.addView(view, i, this.dEo ? this.dEg : this.dEf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.dEl != 0) {
            int left = this.dEj.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.eqx;
            }
            if (left != this.dEy) {
                this.dEy = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dEl != 0) {
            View childAt = this.dEj.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.eqz;
            float right2 = childAt.getRight() - this.eqz;
            if (this.eqn > 0.0f && this.mCurrentTabIndex != this.eqo && this.eqo <= this.dEl - 1 && this.eqo >= 0) {
                View childAt2 = this.dEj.getChildAt(this.eqo);
                left = e(left, childAt2.getLeft() + this.eqz, this.eqn);
                right2 = f(right2, childAt2.getRight() - this.eqz, this.eqn);
            }
            int height = getHeight();
            if (this.Fd == null) {
                this.Fd = new RectF(left, (height - this.mIndicatorHeight) - this.eqy, right2, height - this.eqy);
            } else {
                this.Fd.set(left, (height - this.mIndicatorHeight) - this.eqy, right2, height - this.eqy);
            }
            canvas.drawRoundRect(this.Fd, 16.0f, 16.0f, this.dEn);
            if (this.eqT) {
                View childAt3 = this.dEj.getChildAt(this.eqs);
                this.eqr.set((childAt3.getRight() - this.eqM) - this.eqK, childAt3.getTop() + this.eqL, right + this.eqK, top2 + this.eqK);
                canvas.drawOval(this.eqr, this.eqq);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.eqA + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.eqA + f2) - ((this.eqA * (f3 - 0.8f)) / 0.2f);
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
                return f - ((((this.eqA + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.eqA) + ((this.eqA * (0.2f - f3)) / 0.2f);
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dEp = am.getColor(this.hKQ);
            this.dCa = am.getColor(this.hKR);
            this.dEn.setColor(am.getColor(this.hKS));
            this.eqq.setColor(am.getColor(R.color.cp_cont_h));
            this.eqq.setShadowLayer(l.getDimens(getContext(), R.dimen.tbds8), 0.0f, l.getDimens(getContext(), R.dimen.tbds3), am.getColor(R.color.cp_cont_h_alpha66));
            updateTabStyles();
            invalidate();
        }
    }

    private float ac(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.eqH - 1.0f) / (0.1f - 1.0f))) + this.eqH;
        }
        return (((this.eqH - this.eqG) / 0.1f) * f) + this.eqG;
    }

    private float ad(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.eqH) / (0.1f - 0.9f)));
        }
        return (((this.eqH - this.eqG) / (0.9f - 1.0f)) * (f - 0.9f)) + this.eqH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float ad;
        float f = this.eqn;
        float f2 = this.eqo < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.dEl) {
            View childAt = this.dEj.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.dEz);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        ad = ac(f2);
                    } else {
                        ad = i == this.eqo ? ad(f2) : 1.0f;
                    }
                    textView.setScaleX(ad);
                    textView.setScaleY(ad);
                    if (f2 >= 0.5f) {
                        if (i == this.eqo) {
                            textView.setTextColor(this.dEp);
                        } else {
                            textView.setTextColor(this.dCa);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.dEp);
                    } else {
                        textView.setTextColor(this.dCa);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.eqo) {
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
            if (PagerSlidingTabStrip.this.dEj.getChildCount() != 0) {
                if (!PagerSlidingTabStrip.this.eqN) {
                    if (i == PagerSlidingTabStrip.this.eqp) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eqo = i + 1;
                    } else if (i > PagerSlidingTabStrip.this.eqp) {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eqo = i + 1;
                    } else {
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabStrip.this.eqo = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabStrip.this.eqp = i;
                        PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabStrip.this.eqo = i;
                    }
                    PagerSlidingTabStrip.this.eqn = f;
                    PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.dEj.getChildAt(i).getWidth() * f));
                }
                PagerSlidingTabStrip.this.updateTabStyles();
                PagerSlidingTabStrip.this.invalidate();
                if (PagerSlidingTabStrip.this.dEi != null) {
                    PagerSlidingTabStrip.this.dEi.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabStrip.this.dEj.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.dEk.getCurrentItem(), 0);
                    PagerSlidingTabStrip.this.eqn = 0.0f;
                    PagerSlidingTabStrip.this.eqN = false;
                    PagerSlidingTabStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabStrip.this.isLoading = true;
                    PagerSlidingTabStrip.this.eqp = PagerSlidingTabStrip.this.dEk.getCurrentItem();
                    PagerSlidingTabStrip.this.mCurrentTabIndex = PagerSlidingTabStrip.this.eqp;
                    PagerSlidingTabStrip.this.eqo = PagerSlidingTabStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabStrip.this.dEi != null) {
                    PagerSlidingTabStrip.this.dEi.onPageScrollStateChanged(i);
                }
                HomePageStatic.hHu = false;
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabStrip.this.dEi != null) {
                PagerSlidingTabStrip.this.dEi.onPageSelected(i);
            }
            if (PagerSlidingTabStrip.this.eqN) {
                PagerSlidingTabStrip.this.scrollToChild(i, (int) (PagerSlidingTabStrip.this.eqn * PagerSlidingTabStrip.this.dEj.getChildAt(i).getWidth()));
                PagerSlidingTabStrip.this.eqp = i;
                PagerSlidingTabStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabStrip.this.eqo = i;
            }
            PagerSlidingTabStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.XM;
        this.eqo = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.XM = this.mCurrentTabIndex;
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
        int XM;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.XM = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.XM);
        }
    }

    public View vM(int i) {
        return this.dEj.getChildAt(i);
    }

    public int getCurrentTabIndex() {
        return this.mCurrentTabIndex;
    }

    public void setConcernTabIndex(int i) {
        this.eqs = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.hKT = aVar;
    }
}
