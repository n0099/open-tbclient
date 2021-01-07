package com.baidu.tieba.faceshop.packagedetail;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.e;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.face.view.EmotionPreview;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.EmotionPackageDetailActivity;
import com.baidu.tieba.faceshop.packagedetail.PackageDetailListView;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private EmotionPackageDetailActivity iZB;
    private final float iZC;
    private EmotionPreview iZH;
    private PackageDetailListView iZI;
    private FrameLayout iZL;
    private a iZM;
    private Handler iqP;
    private final int previewHeight;
    private final int previewWidth;
    private final Rect rect = new Rect();
    private int iZD = -1;
    private int iZE = -1;
    private int iZF = -1;
    private int iZG = -1;
    private boolean iZJ = false;
    private boolean iZK = false;
    private int akW = 3;
    private final Runnable iZN = new Runnable() { // from class: com.baidu.tieba.faceshop.packagedetail.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.cDc();
        }
    };
    private final PackageDetailListView.a iZz = new PackageDetailListView.a() { // from class: com.baidu.tieba.faceshop.packagedetail.b.2
        @Override // com.baidu.tieba.faceshop.packagedetail.PackageDetailListView.a
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            a cCY;
            if (motionEvent == null) {
                return false;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    b.this.iZD = (int) motionEvent.getX();
                    b.this.iZE = (int) motionEvent.getY();
                    b.this.iZJ = false;
                    b.this.cDb();
                    return false;
                case 1:
                case 3:
                    b.this.cDa();
                    return false;
                case 2:
                    if (b.this.iZD > -1 && b.this.iZE > -1) {
                        b.this.iZF = (int) motionEvent.getX();
                        b.this.iZG = (int) motionEvent.getY();
                        if (b.this.iZJ || b.this.iZM != null) {
                            if (b.this.iZM != null && (cCY = b.this.cCY()) != null && (b.this.iZM == null || !b.this.iZM.equals(cCY))) {
                                b.this.a(cCY);
                            }
                        } else {
                            float f = b.this.iZF - b.this.iZD;
                            float f2 = b.this.iZG - b.this.iZE;
                            if ((f * f) + (f2 * f2) > b.this.iZC * b.this.iZC) {
                                b.this.iZJ = true;
                            }
                        }
                    }
                    return b.this.iZM != null;
                default:
                    return false;
            }
        }
    };

    public b(EmotionPackageDetailActivity emotionPackageDetailActivity) {
        this.iZB = emotionPackageDetailActivity;
        this.iZI = emotionPackageDetailActivity.cBf();
        this.iZI.setTouchEventInterceptHandler(this.iZz);
        this.iqP = emotionPackageDetailActivity.getSafeHandler();
        this.iZI = emotionPackageDetailActivity.cBf();
        this.iZC = ViewConfiguration.get(emotionPackageDetailActivity).getScaledTouchSlop() * 2;
        this.previewWidth = l.getDimens(emotionPackageDetailActivity, R.dimen.ds240);
        this.previewHeight = l.getDimens(emotionPackageDetailActivity, R.dimen.ds260);
        this.iZI.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.faceshop.packagedetail.b.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                b.this.cDa();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        SwipeBackLayout cBk = emotionPackageDetailActivity.cBk();
        if (cBk != null) {
            cBk.setOnSlidingStateChangeListener(new SwipeBackLayout.b() { // from class: com.baidu.tieba.faceshop.packagedetail.b.4
                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingStart() {
                    b.this.iZK = true;
                    b.this.cDa();
                }

                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingEnd(boolean z) {
                    b.this.iZK = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a cCY() {
        int i = this.iZF;
        int i2 = this.iZG;
        if (i < 0) {
            i = this.iZD;
        }
        if (i2 < 0) {
            i2 = this.iZE;
        }
        int pointToPosition = this.iZI.pointToPosition(i, i2);
        if (pointToPosition >= 0) {
            this.rect.set(i, i2, i + 1, i2 + 1);
            View childAt = this.iZI.getChildAt(pointToPosition);
            if (childAt != null && (childAt instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                this.iZI.offsetRectIntoDescendantCoords(childAt, this.rect);
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    if (childAt2.getLeft() < this.rect.left && childAt2.getRight() > this.rect.right && childAt2.getTop() < this.rect.left && childAt2.getBottom() > this.rect.bottom) {
                        int headerViewsCount = pointToPosition - this.iZI.getHeaderViewsCount();
                        a aVar = new a(childAt2, headerViewsCount, i3);
                        Log.d("PackageDetailPreview", "touch cell: (" + headerViewsCount + ", " + i3 + ")");
                        return aVar;
                    }
                }
            }
        }
        return null;
    }

    private EmotionPackageData.SingleEmotionData cm(int i, int i2) {
        List list;
        e adapter = this.iZI.getAdapter();
        int i3 = (i * 4) + i2;
        int headerViewsCount = this.iZI.getHeaderViewsCount() + i;
        if (adapter == null || headerViewsCount <= -1 || headerViewsCount >= adapter.getCount() || (list = (List) adapter.getItem(headerViewsCount)) == null || i3 <= -1 || i3 >= list.size()) {
            return null;
        }
        return (EmotionPackageData.SingleEmotionData) list.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            cCZ();
            if (a(aVar.view, cm(aVar.row, aVar.column))) {
                this.iZM = aVar;
                this.iZI.setDisableListViewTouchIntercept(true);
                this.iZB.setSwipeBackEnabled(false);
            }
        }
    }

    private boolean a(View view, EmotionPackageData.SingleEmotionData singleEmotionData) {
        if (singleEmotionData == null || TextUtils.isEmpty(singleEmotionData.url) || view == null) {
            return false;
        }
        Log.d("PackageDetailPreview", "show preview, url: " + singleEmotionData.url);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.iZH = new EmotionPreview(this.iZB);
        ao.setBackgroundResource(this.iZH, R.drawable.bg_expression_bubble, this.akW);
        this.iZH.a(singleEmotionData.url, singleEmotionData.thumbnail, false, 10);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.previewWidth, this.previewHeight);
        layoutParams.leftMargin = iArr[0] - 60;
        layoutParams.topMargin = iArr[1] - this.previewHeight;
        if (layoutParams.leftMargin < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.previewWidth > l.getEquipmentWidth(this.iZB)) {
            layoutParams.leftMargin = l.getEquipmentWidth(this.iZB) - this.previewWidth;
        }
        if (this.iZL == null) {
            this.iZL = (FrameLayout) this.iZB.getWindow().getDecorView();
        }
        if (this.iZH.getParent() != null && this.iZH.getParent() == this.iZL) {
            this.iZL.removeView(this.iZH);
        }
        this.iZL.addView(this.iZH, layoutParams);
        return true;
    }

    private void cCZ() {
        if (this.iZH != null && this.iZL != null) {
            if (this.iZH.getParent() != null && this.iZH.getParent() == this.iZL) {
                this.iZL.removeView(this.iZH);
            }
            this.iZH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDa() {
        this.iZG = -1;
        this.iZF = -1;
        this.iZE = -1;
        this.iZD = -1;
        this.iZJ = false;
        this.iZB.setSwipeBackEnabled(true);
        if (this.iZH != null && this.iZM != null) {
            if (this.iZH.getParent() != null && this.iZH.getParent() == this.iZL) {
                this.iZL.removeView(this.iZH);
            }
            this.iZM = null;
            this.iZI.setDisableListViewTouchIntercept(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDb() {
        this.iqP.removeCallbacks(this.iZN);
        this.iqP.postDelayed(this.iZN, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDc() {
        a cCY;
        if (!this.iZJ && !this.iZK && this.iZM == null && (cCY = cCY()) != null) {
            a(cCY);
        }
    }

    public void cDd() {
        this.iqP.removeCallbacks(this.iZN);
        cDa();
    }

    public void onChangeSkinType(int i) {
        this.akW = i;
        if (this.iZH != null) {
            ao.setBackgroundResource(this.iZH, R.drawable.bg_expression_bubble, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        public int column;
        public int row;
        public View view;

        public a(View view, int i, int i2) {
            this.view = view;
            this.row = i;
            this.column = i2;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.row == this.row && aVar.column == this.column && aVar.view == this.view;
        }
    }
}
