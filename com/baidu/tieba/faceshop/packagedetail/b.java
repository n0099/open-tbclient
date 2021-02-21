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
    private Handler isa;
    private EmotionPackageDetailActivity jaP;
    private final float jaQ;
    private EmotionPreview jaV;
    private PackageDetailListView jaW;
    private FrameLayout jaZ;
    private a jba;
    private final int previewHeight;
    private final int previewWidth;
    private final Rect rect = new Rect();
    private int jaR = -1;
    private int jaS = -1;
    private int jaT = -1;
    private int jaU = -1;
    private boolean jaX = false;
    private boolean jaY = false;
    private int ajU = 3;
    private final Runnable jbb = new Runnable() { // from class: com.baidu.tieba.faceshop.packagedetail.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.cAC();
        }
    };
    private final PackageDetailListView.a jaN = new PackageDetailListView.a() { // from class: com.baidu.tieba.faceshop.packagedetail.b.2
        @Override // com.baidu.tieba.faceshop.packagedetail.PackageDetailListView.a
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            a cAy;
            if (motionEvent == null) {
                return false;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    b.this.jaR = (int) motionEvent.getX();
                    b.this.jaS = (int) motionEvent.getY();
                    b.this.jaX = false;
                    b.this.cAB();
                    return false;
                case 1:
                case 3:
                    b.this.cAA();
                    return false;
                case 2:
                    if (b.this.jaR > -1 && b.this.jaS > -1) {
                        b.this.jaT = (int) motionEvent.getX();
                        b.this.jaU = (int) motionEvent.getY();
                        if (b.this.jaX || b.this.jba != null) {
                            if (b.this.jba != null && (cAy = b.this.cAy()) != null && (b.this.jba == null || !b.this.jba.equals(cAy))) {
                                b.this.a(cAy);
                            }
                        } else {
                            float f = b.this.jaT - b.this.jaR;
                            float f2 = b.this.jaU - b.this.jaS;
                            if ((f * f) + (f2 * f2) > b.this.jaQ * b.this.jaQ) {
                                b.this.jaX = true;
                            }
                        }
                    }
                    return b.this.jba != null;
                default:
                    return false;
            }
        }
    };

    public b(EmotionPackageDetailActivity emotionPackageDetailActivity) {
        this.jaP = emotionPackageDetailActivity;
        this.jaW = emotionPackageDetailActivity.cyF();
        this.jaW.setTouchEventInterceptHandler(this.jaN);
        this.isa = emotionPackageDetailActivity.getSafeHandler();
        this.jaW = emotionPackageDetailActivity.cyF();
        this.jaQ = ViewConfiguration.get(emotionPackageDetailActivity).getScaledTouchSlop() * 2;
        this.previewWidth = l.getDimens(emotionPackageDetailActivity, R.dimen.ds240);
        this.previewHeight = l.getDimens(emotionPackageDetailActivity, R.dimen.ds260);
        this.jaW.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.faceshop.packagedetail.b.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                b.this.cAA();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        SwipeBackLayout cyK = emotionPackageDetailActivity.cyK();
        if (cyK != null) {
            cyK.setOnSlidingStateChangeListener(new SwipeBackLayout.b() { // from class: com.baidu.tieba.faceshop.packagedetail.b.4
                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingStart() {
                    b.this.jaY = true;
                    b.this.cAA();
                }

                @Override // com.baidu.adp.widget.SwipeBackLayout.b
                public void onSlidingEnd(boolean z) {
                    b.this.jaY = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a cAy() {
        int i = this.jaT;
        int i2 = this.jaU;
        if (i < 0) {
            i = this.jaR;
        }
        if (i2 < 0) {
            i2 = this.jaS;
        }
        int pointToPosition = this.jaW.pointToPosition(i, i2);
        if (pointToPosition >= 0) {
            this.rect.set(i, i2, i + 1, i2 + 1);
            View childAt = this.jaW.getChildAt(pointToPosition);
            if (childAt != null && (childAt instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                this.jaW.offsetRectIntoDescendantCoords(childAt, this.rect);
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    if (childAt2.getLeft() < this.rect.left && childAt2.getRight() > this.rect.right && childAt2.getTop() < this.rect.left && childAt2.getBottom() > this.rect.bottom) {
                        int headerViewsCount = pointToPosition - this.jaW.getHeaderViewsCount();
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
        e adapter = this.jaW.getAdapter();
        int i3 = (i * 4) + i2;
        int headerViewsCount = this.jaW.getHeaderViewsCount() + i;
        if (adapter == null || headerViewsCount <= -1 || headerViewsCount >= adapter.getCount() || (list = (List) adapter.getItem(headerViewsCount)) == null || i3 <= -1 || i3 >= list.size()) {
            return null;
        }
        return (EmotionPackageData.SingleEmotionData) list.get(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            cAz();
            if (a(aVar.view, ck(aVar.row, aVar.column))) {
                this.jba = aVar;
                this.jaW.setDisableListViewTouchIntercept(true);
                this.jaP.setSwipeBackEnabled(false);
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
        this.jaV = new EmotionPreview(this.jaP);
        ap.setBackgroundResource(this.jaV, R.drawable.bg_expression_bubble, this.ajU);
        this.jaV.a(singleEmotionData.url, singleEmotionData.thumbnail, false, 10);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.previewWidth, this.previewHeight);
        layoutParams.leftMargin = iArr[0] - 60;
        layoutParams.topMargin = iArr[1] - this.previewHeight;
        if (layoutParams.leftMargin < 0) {
            layoutParams.leftMargin = 0;
        }
        if (layoutParams.leftMargin + this.previewWidth > l.getEquipmentWidth(this.jaP)) {
            layoutParams.leftMargin = l.getEquipmentWidth(this.jaP) - this.previewWidth;
        }
        if (this.jaZ == null) {
            this.jaZ = (FrameLayout) this.jaP.getWindow().getDecorView();
        }
        if (this.jaV.getParent() != null && this.jaV.getParent() == this.jaZ) {
            this.jaZ.removeView(this.jaV);
        }
        this.jaZ.addView(this.jaV, layoutParams);
        return true;
    }

    private void cAz() {
        if (this.jaV != null && this.jaZ != null) {
            if (this.jaV.getParent() != null && this.jaV.getParent() == this.jaZ) {
                this.jaZ.removeView(this.jaV);
            }
            this.jaV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAA() {
        this.jaU = -1;
        this.jaT = -1;
        this.jaS = -1;
        this.jaR = -1;
        this.jaX = false;
        this.jaP.setSwipeBackEnabled(true);
        if (this.jaV != null && this.jba != null) {
            if (this.jaV.getParent() != null && this.jaV.getParent() == this.jaZ) {
                this.jaZ.removeView(this.jaV);
            }
            this.jba = null;
            this.jaW.setDisableListViewTouchIntercept(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAB() {
        this.isa.removeCallbacks(this.jbb);
        this.isa.postDelayed(this.jbb, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAC() {
        a cAy;
        if (!this.jaX && !this.jaY && this.jba == null && (cAy = cAy()) != null) {
            a(cAy);
        }
    }

    public void cAD() {
        this.isa.removeCallbacks(this.jbb);
        cAA();
    }

    public void onChangeSkinType(int i) {
        this.ajU = i;
        if (this.jaV != null) {
            ap.setBackgroundResource(this.jaV, R.drawable.bg_expression_bubble, i);
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
