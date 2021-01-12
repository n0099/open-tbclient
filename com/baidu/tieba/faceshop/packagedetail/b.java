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
/* loaded from: classes8.dex */
public class b {
    private EmotionPackageDetailActivity iUU;
    private final float iUV;
    private EmotionPreview iVa;
    private PackageDetailListView iVb;
    private FrameLayout iVe;
    private a iVf;
    private Handler imh;
    private final int previewHeight;
    private final int previewWidth;
    private final Rect rect = new Rect();
    private int iUW = -1;
    private int iUX = -1;
    private int iUY = -1;
    private int iUZ = -1;
    private boolean iVc = false;
    private boolean iVd = false;
    private int akf = 3;
    private final Runnable iVg = new Runnable() { // from class: com.baidu.tieba.faceshop.packagedetail.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.czk();
        }
    };
    private final PackageDetailListView.a iUS = new PackageDetailListView.a() { // from class: com.baidu.tieba.faceshop.packagedetail.b.2
        @Override // com.baidu.tieba.faceshop.packagedetail.PackageDetailListView.a
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            a czg;
            if (motionEvent == null) {
                return false;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    b.this.iUW = (int) motionEvent.getX();
                    b.this.iUX = (int) motionEvent.getY();
                    b.this.iVc = false;
                    b.this.czj();
                    return false;
                case 1:
                case 3:
                    b.this.czi();
                    return false;
                case 2:
                    if (b.this.iUW > -1 && b.this.iUX > -1) {
                        b.this.iUY = (int) motionEvent.getX();
                        b.this.iUZ = (int) motionEvent.getY();
                        if (b.this.iVc || b.this.iVf != null) {
                            if (b.this.iVf != null && (czg = b.this.czg()) != null && (b.this.iVf == null || !b.this.iVf.equals(czg))) {
                                b.this.a(czg);
                            }
                        } else {
                            float f = b.this.iUY - b.this.iUW;
                            float f2 = b.this.iUZ - b.this.iUX;
                            if ((f * f) + (f2 * f2) > b.this.iUV * b.this.iUV) {
                                b.this.iVc = true;
                            }
                        }
                    }
                    return b.this.iVf != null;
                default:
                    return false;
            }
        }
    };

    public b(EmotionPackageDetailActivity emotionPackageDetailActivity) {
        this.iUU = emotionPackageDetailActivity;
        this.iVb = emotionPackageDetailActivity.cxn();
        this.iVb.setTouchEventInterceptHandler(this.iUS);
        this.imh = emotionPackageDetailActivity.getSafeHandler();
        this.iVb = emotionPackageDetailActivity.cxn();
        this.iUV = ViewConfiguration.get(emotionPackageDetailActivity).getScaledTouchSlop() * 2;
        this.previewWidth = l.getDimens(emotionPackageDetailActivity, R.dimen.ds240);
        this.previewHeight = l.getDimens(emotionPackageDetailActivity, R.dimen.ds260);
        this.iVb.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.faceshop.packagedetail.b.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                b.this.czi();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        SwipeBackLayout cxs = emotionPackageDetailActivity.cxs();
        if (cxs != null) {
            cxs.setOnSlidingStateChangeListener(new SwipeBackLayout.b() { // from class: com.baidu.tieba.faceshop.packagedetail.b.4
                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingStart() {
                    b.this.iVd = true;
                    b.this.czi();
                }

                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingEnd(boolean z) {
                    b.this.iVd = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a czg() {
        int i = this.iUY;
        int i2 = this.iUZ;
        if (i < 0) {
            i = this.iUW;
        }
        if (i2 < 0) {
            i2 = this.iUX;
        }
        int pointToPosition = this.iVb.pointToPosition(i, i2);
        if (pointToPosition >= 0) {
            this.rect.set(i, i2, i + 1, i2 + 1);
            View childAt = this.iVb.getChildAt(pointToPosition);
            if (childAt != null && (childAt instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                this.iVb.offsetRectIntoDescendantCoords(childAt, this.rect);
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    if (childAt2.getLeft() < this.rect.left && childAt2.getRight() > this.rect.right && childAt2.getTop() < this.rect.left && childAt2.getBottom() > this.rect.bottom) {
                        int headerViewsCount = pointToPosition - this.iVb.getHeaderViewsCount();
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
        e adapter = this.iVb.getAdapter();
        int i3 = (i * 4) + i2;
        int headerViewsCount = this.iVb.getHeaderViewsCount() + i;
        if (adapter == null || headerViewsCount <= -1 || headerViewsCount >= adapter.getCount() || (list = (List) adapter.getItem(headerViewsCount)) == null || i3 <= -1 || i3 >= list.size()) {
            return null;
        }
        return (EmotionPackageData.SingleEmotionData) list.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            czh();
            if (a(aVar.view, cm(aVar.row, aVar.column))) {
                this.iVf = aVar;
                this.iVb.setDisableListViewTouchIntercept(true);
                this.iUU.setSwipeBackEnabled(false);
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
        this.iVa = new EmotionPreview(this.iUU);
        ao.setBackgroundResource(this.iVa, R.drawable.bg_expression_bubble, this.akf);
        this.iVa.a(singleEmotionData.url, singleEmotionData.thumbnail, false, 10);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.previewWidth, this.previewHeight);
        layoutParams.leftMargin = iArr[0] - 60;
        layoutParams.topMargin = iArr[1] - this.previewHeight;
        if (layoutParams.leftMargin < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.previewWidth > l.getEquipmentWidth(this.iUU)) {
            layoutParams.leftMargin = l.getEquipmentWidth(this.iUU) - this.previewWidth;
        }
        if (this.iVe == null) {
            this.iVe = (FrameLayout) this.iUU.getWindow().getDecorView();
        }
        if (this.iVa.getParent() != null && this.iVa.getParent() == this.iVe) {
            this.iVe.removeView(this.iVa);
        }
        this.iVe.addView(this.iVa, layoutParams);
        return true;
    }

    private void czh() {
        if (this.iVa != null && this.iVe != null) {
            if (this.iVa.getParent() != null && this.iVa.getParent() == this.iVe) {
                this.iVe.removeView(this.iVa);
            }
            this.iVa = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czi() {
        this.iUZ = -1;
        this.iUY = -1;
        this.iUX = -1;
        this.iUW = -1;
        this.iVc = false;
        this.iUU.setSwipeBackEnabled(true);
        if (this.iVa != null && this.iVf != null) {
            if (this.iVa.getParent() != null && this.iVa.getParent() == this.iVe) {
                this.iVe.removeView(this.iVa);
            }
            this.iVf = null;
            this.iVb.setDisableListViewTouchIntercept(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czj() {
        this.imh.removeCallbacks(this.iVg);
        this.imh.postDelayed(this.iVg, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czk() {
        a czg;
        if (!this.iVc && !this.iVd && this.iVf == null && (czg = czg()) != null) {
            a(czg);
        }
    }

    public void czl() {
        this.imh.removeCallbacks(this.iVg);
        czi();
    }

    public void onChangeSkinType(int i) {
        this.akf = i;
        if (this.iVa != null) {
            ao.setBackgroundResource(this.iVa, R.drawable.bg_expression_bubble, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
