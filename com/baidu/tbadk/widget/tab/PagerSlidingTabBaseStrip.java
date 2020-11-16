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
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private RectF GD;
    private int dividerPadding;
    private int dividerWidth;
    private LinearLayout.LayoutParams eQH;
    private LinearLayout.LayoutParams eQI;
    public ViewPager.OnPageChangeListener eQK;
    private LinearLayout eQL;
    private ViewPager eQM;
    private int eQN;
    private Paint eQP;
    private boolean eQQ;
    private int eQR;
    private int eQS;
    private int eQZ;
    private int eRa;
    private int fJB;
    private int fJD;
    private int fJE;
    private int fJF;
    private int fJG;
    private int fJJ;
    private int fJK;
    private float fJM;
    private float fJN;
    private int fJQ;
    private int fJR;
    private int fJS;
    private boolean fJT;
    private final b fJX;
    private boolean fJY;
    private boolean fJZ;
    private float fJt;
    private int fJu;
    private int fJv;
    private Paint fJw;
    private RectF fJx;
    private int fJy;
    private a fKa;
    private boolean isLoading;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;

    /* loaded from: classes20.dex */
    public interface a {
        void q(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fJX = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fJt = 0.0f;
        this.fJu = 0;
        this.fJv = 0;
        this.eQQ = false;
        this.fJB = R.color.CAM_X0105;
        this.eQR = ap.getColor(this.fJB);
        this.eQS = ap.getColor(R.color.CAM_X0107);
        this.fJD = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fJJ = 17;
        this.fJK = 17;
        this.eQZ = 0;
        this.eRa = R.drawable.pager_sliding_view;
        this.fJT = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fJF = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.eQH = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fJZ = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.fJT = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.eQM = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fJX);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.eQK = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.eQM != null && this.eQM.getAdapter() != null && this.eQM.getAdapter().getCount() != 0) {
            this.eQL.removeAllViews();
            this.eQN = this.eQM.getAdapter().getCount();
            for (int i = 0; i < this.eQN; i++) {
                aD(i, this.eQM.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.eQM.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fJu = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aD(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.fJJ);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fKa != null) {
                        PagerSlidingTabBaseStrip.this.fKa.q(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.eQM.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.fJT = true;
                        PagerSlidingTabBaseStrip.this.eQM.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.eQL.addView(view, i, this.eQQ ? this.eQI : this.eQH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.eQN != 0) {
            int left = this.eQL.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fJD;
            }
            if (left != this.eQZ) {
                this.eQZ = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.eQN != 0) {
            View childAt = this.eQL.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fJF;
            float right2 = childAt.getRight() - this.fJF;
            if (this.fJt > 0.0f && this.mCurrentTabIndex != this.fJu && this.fJu <= this.eQN - 1 && this.fJu >= 0) {
                View childAt2 = this.eQL.getChildAt(this.fJu);
                left = e(left, childAt2.getLeft() + this.fJF, this.fJt);
                right2 = f(right2, childAt2.getRight() - this.fJF, this.fJt);
            }
            int height = getHeight();
            if (this.GD == null) {
                this.GD = new RectF(left, (height - this.mIndicatorHeight) - this.fJE, right2, height - this.fJE);
            } else {
                this.GD.set(left, (height - this.mIndicatorHeight) - this.fJE, right2, height - this.fJE);
            }
            canvas.drawRoundRect(this.GD, 16.0f, 16.0f, this.eQP);
            if (this.fJZ) {
                View childAt3 = this.eQL.getChildAt(this.fJy);
                this.fJx.set((childAt3.getRight() - this.fJS) - this.fJQ, childAt3.getTop() + this.fJR, right + this.fJQ, top + this.fJQ);
                canvas.drawOval(this.fJx, this.fJw);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fJG + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fJG + f2) - ((this.fJG * (f3 - 0.85f)) / 0.15f);
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
            if (f3 >= 0.15d) {
                return f - ((((f - this.fJG) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fJG) + ((this.fJG * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fJY = z;
        if (!z) {
            this.eQR = ap.getColor(this.fJB);
            this.eQS = ap.getColor(R.color.CAM_X0107);
        } else {
            this.eQR = ap.getColor(R.color.CAM_X0101);
            this.eQS = ap.getColor(R.color.CAM_X0101);
        }
        updateTabStyles();
        invalidate();
    }

    private float ap(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fJN - 1.0f) / (0.1f - 1.0f))) + this.fJN;
        }
        return (((this.fJN - this.fJM) / 0.1f) * f) + this.fJM;
    }

    private float aq(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fJN) / (0.1f - 0.9f)));
        }
        return (((this.fJN - this.fJM) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fJN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float aq;
        float f = this.fJt;
        float f2 = this.fJu < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.eQN) {
            View childAt = this.eQL.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.eRa);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        aq = ap(f2);
                    } else {
                        aq = i == this.fJu ? aq(f2) : 1.0f;
                    }
                    textView.setScaleX(aq);
                    textView.setScaleY(aq);
                    if (aq <= 1.0f) {
                        textView.setTextColor(this.eQS);
                    } else {
                        textView.setTextColor(this.eQR);
                    }
                    if (aq <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes20.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.eQL.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.fJT) {
                    if (i == PagerSlidingTabBaseStrip.this.fJv) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fJu = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fJv) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fJu = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fJu = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fJv = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fJu = i;
                    }
                    PagerSlidingTabBaseStrip.this.fJt = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.eQL.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.eQK != null) {
                    PagerSlidingTabBaseStrip.this.eQK.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.eQL.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.eQM.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fJt = 0.0f;
                    PagerSlidingTabBaseStrip.this.fJT = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fJv = PagerSlidingTabBaseStrip.this.eQM.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fJv;
                    PagerSlidingTabBaseStrip.this.fJu = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.eQK != null) {
                    PagerSlidingTabBaseStrip.this.eQK.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.eQK != null) {
                PagerSlidingTabBaseStrip.this.eQK.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.fJT) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fJt * PagerSlidingTabBaseStrip.this.eQL.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fJv = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fJu = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.ZV;
        this.fJu = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ZV = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: U */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: te */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int ZV;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.ZV = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ZV);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fJy = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fJB = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fKa = aVar;
    }
}
