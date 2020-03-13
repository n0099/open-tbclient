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
/* loaded from: classes8.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
    private FrameLayout.LayoutParams dPZ;
    private int dQA;
    private boolean dQB;
    private a dQC;
    private final b dQa;
    private float dQb;
    private int dQc;
    private int dQd;
    private Paint dQe;
    private RectF dQf;
    private boolean dQg;
    private int dQh;
    private boolean dQi;
    private int dQj;
    private int dQk;
    private int dQl;
    private int dQm;
    private int dQn;
    private int dQo;
    private int dQp;
    private int dQq;
    private int dQr;
    private int dQs;
    private int dQt;
    private float dQu;
    private float dQv;
    private TextView dQw;
    private int dQx;
    private int dQy;
    private int dQz;
    private int deA;
    private Paint deC;
    private boolean deD;
    private int deE;
    private int deF;
    private int deO;
    private int deP;
    private LinearLayout.LayoutParams deu;
    private LinearLayout.LayoutParams dev;
    public ViewPager.OnPageChangeListener dex;
    private LinearLayout dey;
    private ViewPager dez;
    private int dgE;
    private int dividerPadding;
    private boolean isLoading;
    private RectF jH;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void k(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dQa = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.dQb = 0.0f;
        this.dQc = 0;
        this.dQd = 0;
        this.deD = false;
        this.dQi = false;
        this.dQj = R.color.cp_other_f;
        this.dQk = R.color.cp_cont_b;
        this.dQl = R.color.cp_cont_j;
        this.deE = am.getColor(this.dQk);
        this.deF = am.getColor(this.dQl);
        this.dQm = 52;
        this.mIndicatorHeight = 4;
        this.dQq = 16;
        this.dividerPadding = 12;
        this.dgE = 1;
        this.dQr = 17;
        this.dQs = 17;
        this.deO = 0;
        this.deP = R.drawable.pager_sliding_view;
        this.dQB = false;
        this.isLoading = false;
    }

    public void b(int i, int i2, int i3, boolean z) {
        setFillViewport(true);
        setWillNotDraw(false);
        if (this.dQi) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.dPZ == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.dPZ);
            }
            addView(this.mContainer);
        }
        this.dey = new LinearLayout(getContext());
        this.dey.setOrientation(0);
        if (this.dQi) {
            this.dey.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.dey);
        } else {
            this.dey.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.dey);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.dQm = (int) TypedValue.applyDimension(1, this.dQm, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dgE = (int) TypedValue.applyDimension(1, this.dgE, displayMetrics);
        this.dQr = i;
        this.dQs = i2;
        this.dQt = l.getDimens(getContext(), R.dimen.tbds74);
        this.dQu = (this.dQs * 1.0f) / this.dQr;
        this.dQv = (this.dQt * 1.0f) / this.dQr;
        this.mIndicatorHeight = i3;
        this.deD = z;
        this.deC = new Paint();
        this.deC.setAntiAlias(true);
        this.deC.setStyle(Paint.Style.FILL);
        this.deC.setColor(am.getColor(this.dQj));
        this.dQe = new Paint();
        this.dQe.setAntiAlias(true);
        this.dQe.setStyle(Paint.Style.FILL);
        this.dQe.setColor(am.getColor(R.color.cp_cont_h));
        this.dQf = new RectF();
        this.dQy = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQz = l.getDimens(getContext(), R.dimen.tbds28);
        this.dQA = l.getDimens(getContext(), R.dimen.tbds22);
        this.deu = new LinearLayout.LayoutParams(-2, -1);
        this.dev = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.dQo = l.getDimens(getContext(), R.dimen.tbds22);
        this.dQn = l.getDimens(getContext(), R.dimen.tbds20);
        this.dQp = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.dQi && this.mContainer != null) {
            this.dQx = l.getDimens(getContext(), R.dimen.tbds32);
            this.dQw = new TextView(getContext());
            this.dQw.setGravity(17);
            this.dQw.setTextSize(0, this.dQx);
            this.dQw.setSingleLine();
            this.dQw.setTextColor(this.deF);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.dQw, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.dQt = i4;
        this.dQv = (this.dQt * 1.0f) / this.dQr;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.dQi = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.dQo = i;
    }

    public void setRectPaintColor(int i) {
        this.dQj = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.dQn = i;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dev = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.dPZ = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.dQp = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.deu = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.dQg = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.dQB = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dez = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.dQa);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dex = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.dez != null && this.dez.getAdapter() != null && this.dez.getAdapter().getCount() != 0) {
            this.dey.removeAllViews();
            this.deA = this.dez.getAdapter().getCount();
            for (int i = 0; i < this.deA; i++) {
                R(i, this.dez.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dez.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.dQc = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void wj(String str) {
        if (this.dez != null && this.dez.getAdapter() != null && this.dez.getAdapter().getCount() != 0 && this.dQi && this.dQw != null) {
            this.dQw.setText(str);
        }
    }

    private void R(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.dQr);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.dQC != null) {
                        NewPagerSlidingTabBaseStrip.this.dQC.k(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.dez.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.dQB = true;
                        NewPagerSlidingTabBaseStrip.this.dez.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.dey.addView(view, i, this.deD ? this.dev : this.deu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.deA != 0) {
            int left = this.dey.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.dQm;
            }
            if (left != this.deO) {
                this.deO = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.deA != 0) {
            View childAt = this.dey.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.dQo;
            float right2 = childAt.getRight() - this.dQo;
            if (this.dQb > 0.0f && this.mCurrentTabIndex != this.dQc && this.dQc <= this.deA - 1 && this.dQc >= 0) {
                View childAt2 = this.dey.getChildAt(this.dQc);
                left = d(left, childAt2.getLeft() + this.dQo, this.dQb);
                right2 = e(right2, childAt2.getRight() - this.dQo, this.dQb);
            }
            int height = getHeight();
            if (this.jH == null) {
                this.jH = new RectF(left, (height - this.mIndicatorHeight) - this.dQn, right2, height - this.dQn);
            } else {
                this.jH.set(left, (height - this.mIndicatorHeight) - this.dQn, right2, height - this.dQn);
            }
            canvas.drawRoundRect(this.jH, this.dQq, this.dQq, this.deC);
            if (this.dQg) {
                View childAt3 = this.dey.getChildAt(this.dQh);
                this.dQf.set((childAt3.getRight() - this.dQA) - this.dQy, childAt3.getTop() + this.dQz, right + this.dQy, top2 + this.dQy);
                canvas.drawOval(this.dQf, this.dQe);
            }
        }
    }

    private float d(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.8d) {
                return f + ((((this.dQp + f2) - f) * (f3 - 0.5f)) / 0.3f);
            }
            return (this.dQp + f2) - ((this.dQp * (f3 - 0.8f)) / 0.2f);
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
            if (f3 >= 0.2d) {
                return f - ((((this.dQp + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            return (f2 - this.dQp) + ((this.dQp * (0.2f - f3)) / 0.2f);
        }
    }

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.dQk = R.color.cp_cont_b;
            this.dQl = R.color.cp_cont_j;
        } else {
            this.dQk = R.color.cp_cont_a;
            this.dQl = R.color.cp_cont_a;
        }
        this.deE = am.getColor(this.dQk);
        this.deF = am.getColor(this.dQl);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.deE = am.getColor(this.dQk);
            this.deF = am.getColor(this.dQl);
            this.deC.setColor(am.getColor(this.dQj));
            this.dQe.setColor(am.getColor(R.color.cp_cont_h));
            updateTabStyles();
            invalidate();
        }
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.dQv - 1.0f) / (0.1f - 1.0f))) + this.dQv;
        }
        return (((this.dQv - this.dQu) / 0.1f) * f) + this.dQu;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.dQv) / (0.1f - 0.9f)));
        }
        return (((this.dQv - this.dQu) / (0.9f - 1.0f)) * (f - 0.9f)) + this.dQv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.dQb;
        float f2 = this.dQc < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.deA) {
            View childAt = this.dey.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.deP);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.dQc ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (f2 >= 0.5f) {
                        if (i == this.dQc) {
                            textView.setTextColor(this.deE);
                        } else {
                            textView.setTextColor(this.deF);
                        }
                    } else if (i == this.mCurrentTabIndex) {
                        textView.setTextColor(this.deE);
                    } else {
                        textView.setTextColor(this.deF);
                    }
                    if (f2 >= 0.5f) {
                        if (i == this.dQc) {
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

    /* loaded from: classes8.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (NewPagerSlidingTabBaseStrip.this.dey.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.dQB) {
                    if (i == NewPagerSlidingTabBaseStrip.this.dQd) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dQc = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.dQd) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dQc = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.dQc = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.dQd = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.dQc = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.dQb = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dey.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.dex != null) {
                    NewPagerSlidingTabBaseStrip.this.dex.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dey.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.dez.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.dQb = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.dQB = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.dQd = NewPagerSlidingTabBaseStrip.this.dez.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dQd;
                    NewPagerSlidingTabBaseStrip.this.dQc = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.dex != null) {
                    NewPagerSlidingTabBaseStrip.this.dex.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dex != null) {
                NewPagerSlidingTabBaseStrip.this.dex.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.dQB) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dQb * NewPagerSlidingTabBaseStrip.this.dey.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.dQd = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.dQc = i;
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.Ev;
        this.dQc = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Ev = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: X */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ny */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Ev;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.Ev = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.Ev);
        }
    }

    public void setConcernTabIndex(int i) {
        this.dQh = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.dQk = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.dQl = i;
    }

    public void setIndicatorRadius(int i) {
        this.dQq = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dQC = aVar;
    }
}
