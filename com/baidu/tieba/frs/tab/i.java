package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.fd;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class i {
    private LinearLayout aTy;
    private SparseArray<f> biA = new SparseArray<>();
    private f biB;
    private a bin;
    private fd biy;
    private View biz;
    private Context mContext;
    private MorePopupWindow mPopWindow;

    /* loaded from: classes.dex */
    public interface a {
        void gw(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TextView aER;
        public ImageView biE;
        public View biF;
        public View biG;
    }

    public i(Context context, a aVar) {
        this.mContext = context;
        this.bin = aVar;
        this.aTy = new LinearLayout(context);
        this.aTy.setOrientation(1);
        this.aTy.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.biz = new View(context);
        this.biz.setOnClickListener(new j(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow(activity, this.aTy, view, as.getDrawable(n.e.transparent_bg), new k(this));
        }
        this.mPopWindow.setOnDismissListener(new l(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, fd fdVar) {
        this.biy = fdVar;
        this.biB = this.biA.get(this.biy.beI);
        if (this.biB == null) {
            this.biB = r.gA(this.biy.beI);
            this.biB.a(this.mContext, this);
            this.biA.put(this.biy.beI, this.biB);
        }
        this.biB.setData(fdVar.beJ);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.J(horizontalTabView.getContext());
                int L = com.baidu.adp.lib.util.k.L(horizontalTabView.getContext());
                int Pi = this.biB.Pi();
                int measuredHeight = (L - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < Pi) {
                    horizontalTabView.getmShowMenuCallBack().gx(Pi - measuredHeight);
                }
            }
        }
        this.aTy.removeAllViews();
        this.aTy.addView(this.biB.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        as.i(this.biz, n.c.black_alpha40);
        this.aTy.addView(this.biz, layoutParams);
        a(activity, view, tabItemView);
        if (this.mPopWindow != null) {
            this.mPopWindow.refresh();
            this.mPopWindow.setWidthAsWidthOfDeviceScreen(activity);
            this.mPopWindow.setHeight(-1);
            this.mPopWindow.showWindowInCustomPosition(0, 0);
        }
    }

    public void Pj() {
        if (this.mPopWindow != null) {
            com.baidu.adp.lib.h.j.a(this.mPopWindow);
        }
    }

    public void wh() {
        if (this.biB != null) {
            this.biB.wh();
        }
        if (this.biz != null) {
            as.i(this.biz, n.c.black_alpha40);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.setBackgroundDrawable(as.getDrawable(n.e.transparent_bg));
        }
    }

    public a Pk() {
        return this.bin;
    }
}
