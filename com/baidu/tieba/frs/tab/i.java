package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.el;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i {
    private LinearLayout aOv;
    private a bbI;
    private el bbT;
    private View bbU;
    private SparseArray<f> bbV = new SparseArray<>();
    private f bbW;
    private Context mContext;
    private MorePopupWindow mPopWindow;

    /* loaded from: classes.dex */
    public interface a {
        void ga(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TextView aCf;
        public ImageView bbZ;
        public View bca;
        public View bcb;
    }

    public i(Context context, a aVar) {
        this.mContext = context;
        this.bbI = aVar;
        this.aOv = new LinearLayout(context);
        this.aOv.setOrientation(1);
        this.aOv.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bbU = new View(context);
        this.bbU.setOnClickListener(new j(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow(activity, this.aOv, view, an.getDrawable(i.e.transparent_bg), new k(this));
        }
        this.mPopWindow.setOnDismissListener(new l(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, el elVar) {
        this.bbT = elVar;
        this.bbW = this.bbV.get(this.bbT.aYJ);
        if (this.bbW == null) {
            this.bbW = r.ge(this.bbT.aYJ);
            this.bbW.a(this.mContext, this);
            this.bbV.put(this.bbT.aYJ, this.bbW);
        }
        this.bbW.setData(elVar.aYK);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.J(horizontalTabView.getContext());
                int L = com.baidu.adp.lib.util.k.L(horizontalTabView.getContext());
                int NC = this.bbW.NC();
                int measuredHeight = (L - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < NC) {
                    horizontalTabView.getmShowMenuCallBack().gb(NC - measuredHeight);
                }
            }
        }
        this.aOv.removeAllViews();
        this.aOv.addView(this.bbW.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        an.i(this.bbU, i.c.black_alpha40);
        this.aOv.addView(this.bbU, layoutParams);
        a(activity, view, tabItemView);
        if (this.mPopWindow != null) {
            this.mPopWindow.refresh();
            this.mPopWindow.setWidthAsWidthOfDeviceScreen(activity);
            this.mPopWindow.setHeight(-1);
            this.mPopWindow.showWindowInCustomPosition(0, 0);
        }
    }

    public void ND() {
        if (this.mPopWindow != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow);
        }
    }

    public void vB() {
        if (this.bbW != null) {
            this.bbW.vB();
        }
        if (this.bbU != null) {
            an.i(this.bbU, i.c.black_alpha40);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.setBackgroundDrawable(an.getDrawable(i.e.transparent_bg));
        }
    }

    public a NE() {
        return this.bbI;
    }
}
