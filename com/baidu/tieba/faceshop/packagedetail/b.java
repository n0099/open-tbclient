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
/* loaded from: classes8.dex */
public class b {
    private Handler itJ;
    private EmotionPreview jcE;
    private PackageDetailListView jcF;
    private FrameLayout jcI;
    private a jcJ;
    private EmotionPackageDetailActivity jcy;
    private final float jcz;
    private final int previewHeight;
    private final int previewWidth;
    private final Rect rect = new Rect();
    private int jcA = -1;
    private int jcB = -1;
    private int jcC = -1;
    private int jcD = -1;
    private boolean jcG = false;
    private boolean jcH = false;
    private int aln = 3;
    private final Runnable jcK = new Runnable() { // from class: com.baidu.tieba.faceshop.packagedetail.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.cAI();
        }
    };
    private final PackageDetailListView.a jcw = new PackageDetailListView.a() { // from class: com.baidu.tieba.faceshop.packagedetail.b.2
        @Override // com.baidu.tieba.faceshop.packagedetail.PackageDetailListView.a
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            a cAE;
            if (motionEvent == null) {
                return false;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    b.this.jcA = (int) motionEvent.getX();
                    b.this.jcB = (int) motionEvent.getY();
                    b.this.jcG = false;
                    b.this.cAH();
                    return false;
                case 1:
                case 3:
                    b.this.cAG();
                    return false;
                case 2:
                    if (b.this.jcA > -1 && b.this.jcB > -1) {
                        b.this.jcC = (int) motionEvent.getX();
                        b.this.jcD = (int) motionEvent.getY();
                        if (b.this.jcG || b.this.jcJ != null) {
                            if (b.this.jcJ != null && (cAE = b.this.cAE()) != null && (b.this.jcJ == null || !b.this.jcJ.equals(cAE))) {
                                b.this.a(cAE);
                            }
                        } else {
                            float f = b.this.jcC - b.this.jcA;
                            float f2 = b.this.jcD - b.this.jcB;
                            if ((f * f) + (f2 * f2) > b.this.jcz * b.this.jcz) {
                                b.this.jcG = true;
                            }
                        }
                    }
                    return b.this.jcJ != null;
                default:
                    return false;
            }
        }
    };

    public b(EmotionPackageDetailActivity emotionPackageDetailActivity) {
        this.jcy = emotionPackageDetailActivity;
        this.jcF = emotionPackageDetailActivity.cyL();
        this.jcF.setTouchEventInterceptHandler(this.jcw);
        this.itJ = emotionPackageDetailActivity.getSafeHandler();
        this.jcF = emotionPackageDetailActivity.cyL();
        this.jcz = ViewConfiguration.get(emotionPackageDetailActivity).getScaledTouchSlop() * 2;
        this.previewWidth = l.getDimens(emotionPackageDetailActivity, R.dimen.ds240);
        this.previewHeight = l.getDimens(emotionPackageDetailActivity, R.dimen.ds260);
        this.jcF.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.faceshop.packagedetail.b.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                b.this.cAG();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        SwipeBackLayout cyQ = emotionPackageDetailActivity.cyQ();
        if (cyQ != null) {
            cyQ.setOnSlidingStateChangeListener(new SwipeBackLayout.b() { // from class: com.baidu.tieba.faceshop.packagedetail.b.4
                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingStart() {
                    b.this.jcH = true;
                    b.this.cAG();
                }

                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingEnd(boolean z) {
                    b.this.jcH = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a cAE() {
        int i = this.jcC;
        int i2 = this.jcD;
        if (i < 0) {
            i = this.jcA;
        }
        if (i2 < 0) {
            i2 = this.jcB;
        }
        int pointToPosition = this.jcF.pointToPosition(i, i2);
        if (pointToPosition >= 0) {
            this.rect.set(i, i2, i + 1, i2 + 1);
            View childAt = this.jcF.getChildAt(pointToPosition);
            if (childAt != null && (childAt instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                this.jcF.offsetRectIntoDescendantCoords(childAt, this.rect);
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    if (childAt2.getLeft() < this.rect.left && childAt2.getRight() > this.rect.right && childAt2.getTop() < this.rect.left && childAt2.getBottom() > this.rect.bottom) {
                        int headerViewsCount = pointToPosition - this.jcF.getHeaderViewsCount();
                        a aVar = new a(childAt2, headerViewsCount, i3);
                        Log.d("PackageDetailPreview", "touch cell: (" + headerViewsCount + ", " + i3 + ")");
                        return aVar;
                    }
                }
            }
        }
        return null;
    }

    private EmotionPackageData.SingleEmotionData ck(int i, int i2) {
        List list;
        e adapter = this.jcF.getAdapter();
        int i3 = (i * 4) + i2;
        int headerViewsCount = this.jcF.getHeaderViewsCount() + i;
        if (adapter == null || headerViewsCount <= -1 || headerViewsCount >= adapter.getCount() || (list = (List) adapter.getItem(headerViewsCount)) == null || i3 <= -1 || i3 >= list.size()) {
            return null;
        }
        return (EmotionPackageData.SingleEmotionData) list.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            cAF();
            if (a(aVar.view, ck(aVar.row, aVar.column))) {
                this.jcJ = aVar;
                this.jcF.setDisableListViewTouchIntercept(true);
                this.jcy.setSwipeBackEnabled(false);
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
        this.jcE = new EmotionPreview(this.jcy);
        ap.setBackgroundResource(this.jcE, R.drawable.bg_expression_bubble, this.aln);
        this.jcE.a(singleEmotionData.url, singleEmotionData.thumbnail, false, 10);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.previewWidth, this.previewHeight);
        layoutParams.leftMargin = iArr[0] - 60;
        layoutParams.topMargin = iArr[1] - this.previewHeight;
        if (layoutParams.leftMargin < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.previewWidth > l.getEquipmentWidth(this.jcy)) {
            layoutParams.leftMargin = l.getEquipmentWidth(this.jcy) - this.previewWidth;
        }
        if (this.jcI == null) {
            this.jcI = (FrameLayout) this.jcy.getWindow().getDecorView();
        }
        if (this.jcE.getParent() != null && this.jcE.getParent() == this.jcI) {
            this.jcI.removeView(this.jcE);
        }
        this.jcI.addView(this.jcE, layoutParams);
        return true;
    }

    private void cAF() {
        if (this.jcE != null && this.jcI != null) {
            if (this.jcE.getParent() != null && this.jcE.getParent() == this.jcI) {
                this.jcI.removeView(this.jcE);
            }
            this.jcE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAG() {
        this.jcD = -1;
        this.jcC = -1;
        this.jcB = -1;
        this.jcA = -1;
        this.jcG = false;
        this.jcy.setSwipeBackEnabled(true);
        if (this.jcE != null && this.jcJ != null) {
            if (this.jcE.getParent() != null && this.jcE.getParent() == this.jcI) {
                this.jcI.removeView(this.jcE);
            }
            this.jcJ = null;
            this.jcF.setDisableListViewTouchIntercept(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAH() {
        this.itJ.removeCallbacks(this.jcK);
        this.itJ.postDelayed(this.jcK, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAI() {
        a cAE;
        if (!this.jcG && !this.jcH && this.jcJ == null && (cAE = cAE()) != null) {
            a(cAE);
        }
    }

    public void cAJ() {
        this.itJ.removeCallbacks(this.jcK);
        cAG();
    }

    public void onChangeSkinType(int i) {
        this.aln = i;
        if (this.jcE != null) {
            ap.setBackgroundResource(this.jcE, R.drawable.bg_expression_bubble, i);
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
