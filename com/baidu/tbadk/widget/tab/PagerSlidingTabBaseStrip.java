package com.baidu.tbadk.widget.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PagerSlidingTabBaseStrip extends HorizontalScrollView {
    private boolean bnv;
    private int dividerPadding;
    private int dividerWidth;
    private int fWA;
    private final b fWE;
    private boolean fWF;
    private boolean fWG;
    private a fWH;
    private float fWb;
    private int fWc;
    private int fWd;
    private Paint fWe;
    private RectF fWf;
    private int fWg;
    private int fWj;
    private int fWl;
    private int fWm;
    private int fWn;
    private int fWo;
    private int fWr;
    private int fWs;
    private float fWu;
    private float fWv;
    private int fWy;
    private int fWz;
    private LinearLayout.LayoutParams fcQ;
    private LinearLayout.LayoutParams fcR;
    public ViewPager.OnPageChangeListener fcT;
    private LinearLayout fcU;
    private ViewPager fcV;
    private int fcW;
    private Paint fcY;
    private boolean fcZ;
    private int fda;
    private int fdb;
    private int fdm;
    private boolean isLoading;
    private int mCurrentTabIndex;
    private int mIndicatorHeight;
    private int mSkinType;
    private RectF rectF;
    private int tabBackgroundResId;

    /* loaded from: classes.dex */
    public interface a {
        void t(View view, int i);
    }

    public PagerSlidingTabBaseStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fWE = new b();
        this.mSkinType = 3;
        this.mCurrentTabIndex = 0;
        this.fWb = 0.0f;
        this.fWc = 0;
        this.fWd = 0;
        this.fcZ = false;
        this.fWj = R.color.CAM_X0105;
        this.fda = ao.getColor(this.fWj);
        this.fdb = ao.getColor(R.color.CAM_X0107);
        this.fWl = 52;
        this.mIndicatorHeight = 4;
        this.dividerPadding = 12;
        this.dividerWidth = 1;
        this.fWr = 17;
        this.fWs = 17;
        this.fdm = 0;
        this.tabBackgroundResId = R.drawable.pager_sliding_view;
        this.bnv = false;
        this.isLoading = false;
    }

    public void setIndicatorOffset(int i) {
        this.fWn = i;
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.fcQ = layoutParams;
    }

    public void setShowConcernRedTip(boolean z) {
        this.fWG = z;
        invalidate();
    }

    public void setTabItemClicked(boolean z) {
        this.bnv = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.fcV = viewPager;
        if (viewPager.getAdapter() != null) {
            viewPager.setOnPageChangeListener(this.fWE);
            notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.fcT = onPageChangeListener;
    }

    public void notifyDataSetChanged() {
        if (this.fcV != null && this.fcV.getAdapter() != null && this.fcV.getAdapter().getCount() != 0) {
            this.fcU.removeAllViews();
            this.fcW = this.fcV.getAdapter().getCount();
            for (int i = 0; i < this.fcW; i++) {
                aG(i, this.fcV.getAdapter().getPageTitle(i).toString());
            }
            updateTabStyles();
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PagerSlidingTabBaseStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fcV.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.fWc = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.mCurrentTabIndex, 0);
                }
            });
        }
    }

    private void aG(int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(0, this.fWr);
        textView.setSingleLine();
        d(i, textView);
    }

    private void d(final int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PagerSlidingTabBaseStrip.this.isLoading) {
                    if (PagerSlidingTabBaseStrip.this.fWH != null) {
                        PagerSlidingTabBaseStrip.this.fWH.t(view2, i);
                    }
                    if (PagerSlidingTabBaseStrip.this.fcV.getCurrentItem() != i) {
                        PagerSlidingTabBaseStrip.this.bnv = true;
                        PagerSlidingTabBaseStrip.this.fcV.setCurrentItem(i);
                        PagerSlidingTabBaseStrip.this.updateTabStyles();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                }
            }
        });
        this.fcU.addView(view, i, this.fcZ ? this.fcR : this.fcQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        if (this.fcW != 0) {
            int left = this.fcU.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.fWl;
            }
            if (left != this.fdm) {
                this.fdm = left;
                scrollTo(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int right;
        int top;
        super.onDraw(canvas);
        if (!isInEditMode() && this.fcW != 0) {
            View childAt = this.fcU.getChildAt(this.mCurrentTabIndex);
            float left = childAt.getLeft() + this.fWn;
            float right2 = childAt.getRight() - this.fWn;
            if (this.fWb > 0.0f && this.mCurrentTabIndex != this.fWc && this.fWc <= this.fcW - 1 && this.fWc >= 0) {
                View childAt2 = this.fcU.getChildAt(this.fWc);
                left = e(left, childAt2.getLeft() + this.fWn, this.fWb);
                right2 = f(right2, childAt2.getRight() - this.fWn, this.fWb);
            }
            int height = getHeight();
            if (this.rectF == null) {
                this.rectF = new RectF(left, (height - this.mIndicatorHeight) - this.fWm, right2, height - this.fWm);
            } else {
                this.rectF.set(left, (height - this.mIndicatorHeight) - this.fWm, right2, height - this.fWm);
            }
            canvas.drawRoundRect(this.rectF, 16.0f, 16.0f, this.fcY);
            if (this.fWG) {
                View childAt3 = this.fcU.getChildAt(this.fWg);
                this.fWf.set((childAt3.getRight() - this.fWA) - this.fWy, childAt3.getTop() + this.fWz, right + this.fWy, top + this.fWy);
                canvas.drawOval(this.fWf, this.fWe);
            }
        }
    }

    private float e(float f, float f2, float f3) {
        if (f2 <= f) {
            return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
        } else if (f3 > 0.5d) {
            if (f3 <= 0.85d) {
                return f + ((((this.fWo + f2) - f) * (f3 - 0.5f)) / 0.35f);
            }
            return (this.fWo + f2) - ((this.fWo * (f3 - 0.85f)) / 0.15f);
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
                return f - ((((f - this.fWo) - f2) * (0.5f - f3)) / 0.35f);
            }
            return (f2 - this.fWo) + ((this.fWo * (0.15f - f3)) / 0.15f);
        }
    }

    public void setWhiteStyle(boolean z) {
        this.fWF = z;
        if (!z) {
            this.fda = ao.getColor(this.fWj);
            this.fdb = ao.getColor(R.color.CAM_X0107);
        } else {
            this.fda = ao.getColor(R.color.CAM_X0101);
            this.fdb = ao.getColor(R.color.CAM_X0101);
        }
        updateTabStyles();
        invalidate();
    }

    private float as(float f) {
        if (f > 0.1f) {
            return ((f - 0.1f) * ((this.fWv - 1.0f) / (0.1f - 1.0f))) + this.fWv;
        }
        return (((this.fWv - this.fWu) / 0.1f) * f) + this.fWu;
    }

    private float at(float f) {
        if (f <= 0.1f) {
            return 1.0f;
        }
        if (f <= 0.9f) {
            return 1.0f + ((f - 0.1f) * ((1.0f - this.fWv) / (0.1f - 0.9f)));
        }
        return (((this.fWv - this.fWu) / (0.9f - 1.0f)) * (f - 0.9f)) + this.fWv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles() {
        float at;
        float f = this.fWb;
        float f2 = this.fWc < this.mCurrentTabIndex ? 1.0f - f : f;
        int i = 0;
        while (i < this.fcW) {
            View childAt = this.fcU.getChildAt(i);
            if (childAt != null) {
                childAt.setBackgroundResource(this.tabBackgroundResId);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (i == this.mCurrentTabIndex) {
                        at = as(f2);
                    } else {
                        at = i == this.fWc ? at(f2) : 1.0f;
                    }
                    textView.setScaleX(at);
                    textView.setScaleY(at);
                    if (at <= 1.0f) {
                        textView.setTextColor(this.fdb);
                    } else {
                        textView.setTextColor(this.fda);
                    }
                    if (at <= 1.03f) {
                        textView.setTypeface(Typeface.defaultFromStyle(0));
                    } else {
                        textView.setTypeface(Typeface.defaultFromStyle(1));
                    }
                }
            }
            i++;
        }
    }

    /* loaded from: classes.dex */
    private class b implements ViewPager.OnPageChangeListener {
        private b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (PagerSlidingTabBaseStrip.this.fcU.getChildCount() != 0) {
                if (!PagerSlidingTabBaseStrip.this.bnv) {
                    if (i == PagerSlidingTabBaseStrip.this.fWd) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fWc = i + 1;
                    } else if (i > PagerSlidingTabBaseStrip.this.fWd) {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fWc = i + 1;
                    } else {
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i + 1;
                        PagerSlidingTabBaseStrip.this.fWc = i;
                    }
                    if (f == 0.0f) {
                        PagerSlidingTabBaseStrip.this.fWd = i;
                        PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                        PagerSlidingTabBaseStrip.this.fWc = i;
                    }
                    PagerSlidingTabBaseStrip.this.fWb = f;
                    PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fcU.getChildAt(i).getWidth() * f));
                    PagerSlidingTabBaseStrip.this.updateTabStyles();
                    PagerSlidingTabBaseStrip.this.invalidate();
                }
                if (PagerSlidingTabBaseStrip.this.fcT != null) {
                    PagerSlidingTabBaseStrip.this.fcT.onPageScrolled(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (PagerSlidingTabBaseStrip.this.fcU.getChildCount() != 0) {
                if (i == 0) {
                    PagerSlidingTabBaseStrip.this.scrollToChild(PagerSlidingTabBaseStrip.this.fcV.getCurrentItem(), 0);
                    PagerSlidingTabBaseStrip.this.fWb = 0.0f;
                    PagerSlidingTabBaseStrip.this.bnv = false;
                    PagerSlidingTabBaseStrip.this.isLoading = false;
                } else if (i == 1) {
                    PagerSlidingTabBaseStrip.this.isLoading = true;
                    PagerSlidingTabBaseStrip.this.fWd = PagerSlidingTabBaseStrip.this.fcV.getCurrentItem();
                    PagerSlidingTabBaseStrip.this.mCurrentTabIndex = PagerSlidingTabBaseStrip.this.fWd;
                    PagerSlidingTabBaseStrip.this.fWc = PagerSlidingTabBaseStrip.this.mCurrentTabIndex;
                }
                if (PagerSlidingTabBaseStrip.this.fcT != null) {
                    PagerSlidingTabBaseStrip.this.fcT.onPageScrollStateChanged(i);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTabBaseStrip.this.fcT != null) {
                PagerSlidingTabBaseStrip.this.fcT.onPageSelected(i);
            }
            if (PagerSlidingTabBaseStrip.this.bnv) {
                PagerSlidingTabBaseStrip.this.scrollToChild(i, (int) (PagerSlidingTabBaseStrip.this.fWb * PagerSlidingTabBaseStrip.this.fcU.getChildAt(i).getWidth()));
                PagerSlidingTabBaseStrip.this.fWd = i;
                PagerSlidingTabBaseStrip.this.mCurrentTabIndex = i;
                PagerSlidingTabBaseStrip.this.fWc = i;
            }
            PagerSlidingTabBaseStrip.this.invalidate();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentTabIndex = savedState.abA;
        this.fWc = this.mCurrentTabIndex;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.abA = this.mCurrentTabIndex;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: V */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: sm */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int abA;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.abA = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.abA);
        }
    }

    public void setConcernTabIndex(int i) {
        this.fWg = i;
    }

    public void setDefaultSelectorColorResourceId(int i) {
        this.fWj = i;
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fWH = aVar;
    }
}
