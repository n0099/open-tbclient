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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.face.view.EmotionPreview;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.EmotionPackageDetailActivity;
import com.baidu.tieba.faceshop.packagedetail.PackageDetailListView;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private Handler irM;
    private EmotionPackageDetailActivity jaB;
    private final float jaC;
    private EmotionPreview jaH;
    private PackageDetailListView jaI;
    private FrameLayout jaL;
    private a jaM;
    private final int previewHeight;
    private final int previewWidth;
    private final Rect rect = new Rect();
    private int jaD = -1;
    private int jaE = -1;
    private int jaF = -1;
    private int jaG = -1;
    private boolean jaJ = false;
    private boolean jaK = false;
    private int ajU = 3;
    private final Runnable jaN = new Runnable() { // from class: com.baidu.tieba.faceshop.packagedetail.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.cAv();
        }
    };
    private final PackageDetailListView.a jaz = new PackageDetailListView.a() { // from class: com.baidu.tieba.faceshop.packagedetail.b.2
        @Override // com.baidu.tieba.faceshop.packagedetail.PackageDetailListView.a
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            a cAr;
            if (motionEvent == null) {
                return false;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    b.this.jaD = (int) motionEvent.getX();
                    b.this.jaE = (int) motionEvent.getY();
                    b.this.jaJ = false;
                    b.this.cAu();
                    return false;
                case 1:
                case 3:
                    b.this.cAt();
                    return false;
                case 2:
                    if (b.this.jaD > -1 && b.this.jaE > -1) {
                        b.this.jaF = (int) motionEvent.getX();
                        b.this.jaG = (int) motionEvent.getY();
                        if (b.this.jaJ || b.this.jaM != null) {
                            if (b.this.jaM != null && (cAr = b.this.cAr()) != null && (b.this.jaM == null || !b.this.jaM.equals(cAr))) {
                                b.this.a(cAr);
                            }
                        } else {
                            float f = b.this.jaF - b.this.jaD;
                            float f2 = b.this.jaG - b.this.jaE;
                            if ((f * f) + (f2 * f2) > b.this.jaC * b.this.jaC) {
                                b.this.jaJ = true;
                            }
                        }
                    }
                    return b.this.jaM != null;
                default:
                    return false;
            }
        }
    };

    public b(EmotionPackageDetailActivity emotionPackageDetailActivity) {
        this.jaB = emotionPackageDetailActivity;
        this.jaI = emotionPackageDetailActivity.cyy();
        this.jaI.setTouchEventInterceptHandler(this.jaz);
        this.irM = emotionPackageDetailActivity.getSafeHandler();
        this.jaI = emotionPackageDetailActivity.cyy();
        this.jaC = ViewConfiguration.get(emotionPackageDetailActivity).getScaledTouchSlop() * 2;
        this.previewWidth = l.getDimens(emotionPackageDetailActivity, R.dimen.ds240);
        this.previewHeight = l.getDimens(emotionPackageDetailActivity, R.dimen.ds260);
        this.jaI.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.faceshop.packagedetail.b.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                b.this.cAt();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        SwipeBackLayout cyD = emotionPackageDetailActivity.cyD();
        if (cyD != null) {
            cyD.setOnSlidingStateChangeListener(new SwipeBackLayout.b() { // from class: com.baidu.tieba.faceshop.packagedetail.b.4
                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingStart() {
                    b.this.jaK = true;
                    b.this.cAt();
                }

                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingEnd(boolean z) {
                    b.this.jaK = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a cAr() {
        int i = this.jaF;
        int i2 = this.jaG;
        if (i < 0) {
            i = this.jaD;
        }
        if (i2 < 0) {
            i2 = this.jaE;
        }
        int pointToPosition = this.jaI.pointToPosition(i, i2);
        if (pointToPosition >= 0) {
            this.rect.set(i, i2, i + 1, i2 + 1);
            View childAt = this.jaI.getChildAt(pointToPosition);
            if (childAt != null && (childAt instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                this.jaI.offsetRectIntoDescendantCoords(childAt, this.rect);
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    if (childAt2.getLeft() < this.rect.left && childAt2.getRight() > this.rect.right && childAt2.getTop() < this.rect.left && childAt2.getBottom() > this.rect.bottom) {
                        int headerViewsCount = pointToPosition - this.jaI.getHeaderViewsCount();
                        a aVar = new a(childAt2, headerViewsCount, i3);
                        Log.d("PackageDetailPreview", "touch cell: (" + headerViewsCount + ", " + i3 + ")");
                        return aVar;
                    }
                }
            }
        }
        return null;
    }

    private EmotionPackageData.SingleEmotionData cj(int i, int i2) {
        List list;
        e adapter = this.jaI.getAdapter();
        int i3 = (i * 4) + i2;
        int headerViewsCount = this.jaI.getHeaderViewsCount() + i;
        if (adapter == null || headerViewsCount <= -1 || headerViewsCount >= adapter.getCount() || (list = (List) adapter.getItem(headerViewsCount)) == null || i3 <= -1 || i3 >= list.size()) {
            return null;
        }
        return (EmotionPackageData.SingleEmotionData) list.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            cAs();
            if (a(aVar.view, cj(aVar.row, aVar.column))) {
                this.jaM = aVar;
                this.jaI.setDisableListViewTouchIntercept(true);
                this.jaB.setSwipeBackEnabled(false);
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
        this.jaH = new EmotionPreview(this.jaB);
        ap.setBackgroundResource(this.jaH, R.drawable.bg_expression_bubble, this.ajU);
        this.jaH.a(singleEmotionData.url, singleEmotionData.thumbnail, false, 10);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.previewWidth, this.previewHeight);
        layoutParams.leftMargin = iArr[0] - 60;
        layoutParams.topMargin = iArr[1] - this.previewHeight;
        if (layoutParams.leftMargin < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.previewWidth > l.getEquipmentWidth(this.jaB)) {
            layoutParams.leftMargin = l.getEquipmentWidth(this.jaB) - this.previewWidth;
        }
        if (this.jaL == null) {
            this.jaL = (FrameLayout) this.jaB.getWindow().getDecorView();
        }
        if (this.jaH.getParent() != null && this.jaH.getParent() == this.jaL) {
            this.jaL.removeView(this.jaH);
        }
        this.jaL.addView(this.jaH, layoutParams);
        return true;
    }

    private void cAs() {
        if (this.jaH != null && this.jaL != null) {
            if (this.jaH.getParent() != null && this.jaH.getParent() == this.jaL) {
                this.jaL.removeView(this.jaH);
            }
            this.jaH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAt() {
        this.jaG = -1;
        this.jaF = -1;
        this.jaE = -1;
        this.jaD = -1;
        this.jaJ = false;
        this.jaB.setSwipeBackEnabled(true);
        if (this.jaH != null && this.jaM != null) {
            if (this.jaH.getParent() != null && this.jaH.getParent() == this.jaL) {
                this.jaL.removeView(this.jaH);
            }
            this.jaM = null;
            this.jaI.setDisableListViewTouchIntercept(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAu() {
        this.irM.removeCallbacks(this.jaN);
        this.irM.postDelayed(this.jaN, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAv() {
        a cAr;
        if (!this.jaJ && !this.jaK && this.jaM == null && (cAr = cAr()) != null) {
            a(cAr);
        }
    }

    public void cAw() {
        this.irM.removeCallbacks(this.jaN);
        cAt();
    }

    public void onChangeSkinType(int i) {
        this.ajU = i;
        if (this.jaH != null) {
            ap.setBackgroundResource(this.jaH, R.drawable.bg_expression_bubble, i);
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
