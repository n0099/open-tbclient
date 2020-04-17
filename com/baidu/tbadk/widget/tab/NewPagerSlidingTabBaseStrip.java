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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Locale;
/* loaded from: classes8.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
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
    private int eqB;
    private boolean eqC;
    private int eqD;
    private int eqE;
    private int eqF;
    private float eqG;
    private float eqH;
    private TextView eqI;
    private int eqJ;
    private int eqK;
    private int eqL;
    private int eqM;
    private boolean eqN;
    private a eqO;
    private int[] eqk;
    private FrameLayout.LayoutParams eql;
    private final b eqm;
    private float eqn;
    private int eqo;
    private int eqp;
    private Paint eqq;
    private RectF eqr;
    private int eqs;
    private boolean eqt;
    private int equ;
    private int eqv;
    private int eqw;
    private int eqx;
    private int eqy;
    private int eqz;
    private boolean isLoading;
    private Locale locale;
    private LinearLayout mContainer;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mIndicatorWidth;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void j(View view, int i);
    }

    public NewPagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqm = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.eqn = 0.0f;
        this.eqo = 0;
        this.eqp = 0;
        this.dEo = false;
        this.eqt = false;
        this.equ = R.color.cp_other_f;
        this.eqv = R.color.cp_cont_b;
        this.eqw = R.color.cp_cont_j;
        this.dEp = am.getColor(this.eqv);
        this.dCa = am.getColor(this.eqw);
        this.eqx = 52;
        this.mIndicatorHeight = 4;
        this.eqB = 16;
        this.dividerPadding = 12;
        this.dGo = 1;
        this.eqC = false;
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
        if (this.eqt) {
            this.mContainer = new LinearLayout(getContext());
            this.mContainer.setOrientation(0);
            if (this.eql == null) {
                this.mContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else {
                this.mContainer.setLayoutParams(this.eql);
            }
            addView(this.mContainer);
        }
        this.dEj = new LinearLayout(getContext());
        this.dEj.setOrientation(0);
        if (this.eqt) {
            this.dEj.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
            this.mContainer.addView(this.dEj);
        } else {
            this.dEj.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.dEj);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.eqx = (int) TypedValue.applyDimension(1, this.eqx, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.dGo = (int) TypedValue.applyDimension(1, this.dGo, displayMetrics);
        this.eqD = i;
        this.eqE = i2;
        this.eqF = l.getDimens(getContext(), R.dimen.tbds74);
        this.eqG = (this.eqE * 1.0f) / this.eqD;
        this.eqH = (this.eqF * 1.0f) / this.eqD;
        this.mIndicatorHeight = i3;
        this.dEo = z;
        this.dEn = new Paint();
        this.dEn.setAntiAlias(true);
        this.dEn.setStyle(Paint.Style.FILL);
        this.dEn.setColor(am.getColor(this.equ));
        this.eqq = new Paint();
        this.eqq.setAntiAlias(true);
        this.eqq.setStyle(Paint.Style.FILL);
        this.eqq.setColor(am.getColor(R.color.cp_cont_h));
        this.eqr = new RectF();
        this.eqK = l.getDimens(getContext(), R.dimen.tbds20);
        this.eqL = l.getDimens(getContext(), R.dimen.tbds16);
        this.eqM = l.getDimens(getContext(), R.dimen.tbds25);
        this.dEf = new LinearLayout.LayoutParams(-2, -1);
        this.dEg = new LinearLayout.LayoutParams(l.getDimens(getContext(), R.dimen.tbds200), -1);
        this.eqz = l.getDimens(getContext(), R.dimen.tbds22);
        this.eqy = l.getDimens(getContext(), R.dimen.tbds20);
        this.eqA = l.getDimens(getContext(), R.dimen.tbds15);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
        if (this.eqt && this.mContainer != null) {
            this.eqJ = l.getDimens(getContext(), R.dimen.tbds32);
            this.eqI = new TextView(getContext());
            this.eqI.setGravity(17);
            this.eqI.setTextSize(0, this.eqJ);
            this.eqI.setSingleLine();
            this.eqI.setTextColor(this.dCa);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams.gravity = 16;
            this.mContainer.addView(this.eqI, layoutParams);
        }
    }

    public void a(int i, int i2, int i3, int i4, boolean z) {
        b(i, i2, i3, z);
        this.eqF = i4;
        this.eqH = (this.eqF * 1.0f) / this.eqD;
    }

    public void a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        this.eqt = z2;
        a(i, i2, i3, i4, z);
    }

    public void setIndicatorOffset(int i) {
        this.eqz = i;
        this.eqC = false;
    }

    public void setmIndicatorWidth(int i) {
        this.mIndicatorWidth = i;
        this.eqC = true;
    }

    public void setRectPaintColor(int i) {
        this.equ = i;
    }

    public void setIndicatorMarginBottom(int i) {
        this.eqy = i;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        this.eqk = new int[4];
        this.eqk[0] = i;
        this.eqk[1] = i2;
        this.eqk[2] = i3;
        this.eqk[3] = i4;
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dEg = layoutParams;
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.eql = layoutParams;
    }

    public void setIndicatorOvershot(int i) {
        this.eqA = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.dEf = layoutParams;
    }

    public void setTabItemClicked(boolean z) {
        this.eqN = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.dEk = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.eqm);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.dEi = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        boolean z = false;
        if (this.dEk != null && this.dEk.getAdapter() != null && this.dEk.getAdapter().getCount() != 0) {
            this.dEj.removeAllViews();
            this.dEl = this.dEk.getAdapter().getCount();
            int i = 0;
            while (i < this.dEl) {
                boolean nM = this.dEk.getAdapter() instanceof com.baidu.tbadk.widget.tab.a ? ((com.baidu.tbadk.widget.tab.a) this.dEk.getAdapter()).nM(i) : z;
                e(i, this.dEk.getAdapter().getPageTitle(i).toString(), nM);
                i++;
                z = nM;
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    NewPagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.dEk.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.eqo = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    public void xw(String str) {
        if (this.dEk != null && this.dEk.getAdapter() != null && this.dEk.getAdapter().getCount() != 0 && this.eqt && this.eqI != null) {
            this.eqI.setText(str);
        }
    }

    private void e(int i, String str, boolean z) {
        TabTextView tabTextView = new TabTextView(getContext());
        tabTextView.setHasRedDot(z);
        tabTextView.setText(str);
        tabTextView.setGravity(17);
        tabTextView.setTextSize(0, this.eqD);
        tabTextView.setMaxLines(1);
        d(i, tabTextView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!NewPagerSlidingTabBaseStrip.this.isLoading) {
                    if (NewPagerSlidingTabBaseStrip.this.eqO != null) {
                        NewPagerSlidingTabBaseStrip.this.eqO.j(view2, i);
                    }
                    if (NewPagerSlidingTabBaseStrip.this.dEk.getCurrentItem() != i) {
                        NewPagerSlidingTabBaseStrip.this.eqN = true;
                        NewPagerSlidingTabBaseStrip.this.dEk.setCurrentItem(i);
                        NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    }
                }
            }
        });
        if (this.eqk != null && this.eqk.length == 4) {
            view.setPadding(this.eqk[0], this.eqk[1], this.eqk[2], this.eqk[3]);
        }
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
        float left;
        float right;
        float left2;
        float right2;
        super.onDraw(canvas);
        if (!isInEditMode() && this.dEl != 0) {
            View childAt = this.dEj.getChildAt(this.mCurrentTabIndex);
            if (this.eqC && this.mIndicatorWidth > 0) {
                left = ((childAt.getLeft() + childAt.getRight()) - this.mIndicatorWidth) / 2;
                right = ((childAt.getRight() + childAt.getLeft()) + this.mIndicatorWidth) / 2;
            } else {
                left = childAt.getLeft() + this.eqz;
                right = childAt.getRight() - this.eqz;
            }
            if (this.eqn > 0.0f && this.mCurrentTabIndex != this.eqo && this.eqo <= this.dEl - 1 && this.eqo >= 0) {
                View childAt2 = this.dEj.getChildAt(this.eqo);
                if (this.eqC && this.mIndicatorWidth > 0) {
                    left2 = ((childAt2.getLeft() + childAt2.getRight()) - this.mIndicatorWidth) / 2;
                    right2 = ((childAt2.getRight() + childAt2.getLeft()) + this.mIndicatorWidth) / 2;
                } else {
                    left2 = childAt2.getLeft() + this.eqz;
                    right2 = childAt2.getRight() - this.eqz;
                }
                left = e(left, left2, this.eqn);
                right = f(right, right2, this.eqn);
            }
            int height = getHeight();
            if (this.Fd == null) {
                this.Fd = new RectF(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eqy, right + getPaddingLeft(), height - this.eqy);
            } else {
                this.Fd.set(left + getPaddingLeft(), (height - this.mIndicatorHeight) - this.eqy, right + getPaddingLeft(), height - this.eqy);
            }
            canvas.drawRoundRect(this.Fd, this.eqB, this.eqB, this.dEn);
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

    public void setWhiteStyle(boolean z) {
        if (!z) {
            this.eqv = R.color.cp_cont_b;
            this.eqw = R.color.cp_cont_j;
        } else {
            this.eqv = R.color.cp_cont_a;
            this.eqw = R.color.cp_cont_a;
        }
        this.dEp = am.getColor(this.eqv);
        this.dCa = am.getColor(this.eqw);
        updateTabStyles();
        invalidate();
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            this.dEp = am.getColor(this.eqv);
            this.dCa = am.getColor(this.eqw);
            this.dEn.setColor(am.getColor(this.equ));
            this.eqq.setColor(am.getColor(R.color.cp_cont_h));
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

    /* loaded from: classes8.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (NewPagerSlidingTabBaseStrip.this.dEj.getChildCount() != 0) {
                if (!NewPagerSlidingTabBaseStrip.this.eqN) {
                    if (i == NewPagerSlidingTabBaseStrip.this.eqp) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eqo = i + 1;
                    } else if (i > NewPagerSlidingTabBaseStrip.this.eqp) {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eqo = i + 1;
                    } else {
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        NewPagerSlidingTabBaseStrip.this.eqo = i;
                    }
                    if (f == 0.0f) {
                        NewPagerSlidingTabBaseStrip.this.eqp = i;
                        NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        NewPagerSlidingTabBaseStrip.this.eqo = i;
                    }
                    NewPagerSlidingTabBaseStrip.this.eqn = f;
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.dEj.getChildAt(i).getWidth() * f));
                    NewPagerSlidingTabBaseStrip.this.updateTabStyles();
                    NewPagerSlidingTabBaseStrip.this.invalidate();
                }
                if (NewPagerSlidingTabBaseStrip.this.dEi != null) {
                    NewPagerSlidingTabBaseStrip.this.dEi.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dEj.getChildCount() != 0) {
                if (i == 0) {
                    NewPagerSlidingTabBaseStrip.this.scrollToChild(NewPagerSlidingTabBaseStrip.this.dEk.getCurrentItem(), 0);
                    NewPagerSlidingTabBaseStrip.this.eqn = 0.0f;
                    NewPagerSlidingTabBaseStrip.this.eqN = false;
                    NewPagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    NewPagerSlidingTabBaseStrip.this.isLoading = true;
                    NewPagerSlidingTabBaseStrip.this.eqp = NewPagerSlidingTabBaseStrip.this.dEk.getCurrentItem();
                    NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = NewPagerSlidingTabBaseStrip.this.eqp;
                    NewPagerSlidingTabBaseStrip.this.eqo = NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (NewPagerSlidingTabBaseStrip.this.dEi != null) {
                    NewPagerSlidingTabBaseStrip.this.dEi.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (NewPagerSlidingTabBaseStrip.this.dEi != null) {
                NewPagerSlidingTabBaseStrip.this.dEi.onPageSelected(i);
            }
            if (NewPagerSlidingTabBaseStrip.this.eqN) {
                NewPagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (NewPagerSlidingTabBaseStrip.this.eqn * NewPagerSlidingTabBaseStrip.this.dEj.getChildAt(i).getWidth()));
                NewPagerSlidingTabBaseStrip.this.eqp = i;
                NewPagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                NewPagerSlidingTabBaseStrip.this.eqo = i;
            }
            if (NewPagerSlidingTabBaseStrip.this.dEj.getChildAt(i) instanceof TabTextView) {
                ((TabTextView) NewPagerSlidingTabBaseStrip.this.dEj.getChildAt(i)).setHasRedDot(false);
                NewPagerSlidingTabBaseStrip.this.dEj.getChildAt(i).invalidate();
            }
            NewPagerSlidingTabBaseStrip.this.invalidate();
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
    /* loaded from: classes8.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Q */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: nN */
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

    public void setConcernTabIndex(int i) {
        this.eqs = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.eqv = i;
    }

    public void setNormalSelectorColorResId(int i) {
        this.eqw = i;
    }

    public void setIndicatorRadius(int i) {
        this.eqB = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eqO = aVar;
    }

    /* loaded from: classes8.dex */
    public class TabTextView extends TextView {
        boolean eqQ;
        Paint paint;

        public TabTextView(Context context) {
            super(context);
            this.eqQ = false;
            this.paint = new Paint();
            this.paint.setColor(-16776961);
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeWidth(20.0f);
            this.paint.setAntiAlias(true);
            this.paint.setDither(true);
        }

        public void setHasRedDot(boolean z) {
            this.eqQ = z;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.eqQ) {
                int width = (getWidth() - NewPagerSlidingTabBaseStrip.this.eqM) - NewPagerSlidingTabBaseStrip.this.eqK;
                int i = NewPagerSlidingTabBaseStrip.this.eqL;
                NewPagerSlidingTabBaseStrip.this.eqr.set(width, i, width + NewPagerSlidingTabBaseStrip.this.eqK, i + NewPagerSlidingTabBaseStrip.this.eqK);
                canvas.drawOval(NewPagerSlidingTabBaseStrip.this.eqr, NewPagerSlidingTabBaseStrip.this.eqq);
            }
        }
    }
}
