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
    private LinearLayout aXA;
    private a bmd;
    private fd bmo;
    private View bmq;
    private SparseArray<f> bmr = new SparseArray<>();
    private f bms;
    private Context mContext;
    private MorePopupWindow mPopWindow;

    /* loaded from: classes.dex */
    public interface a {
        void gp(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TextView aGr;
        public ImageView bmv;
        public View bmw;
        public View bmx;
    }

    public i(Context context, a aVar) {
        this.mContext = context;
        this.bmd = aVar;
        this.aXA = new LinearLayout(context);
        this.aXA.setOrientation(1);
        this.aXA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bmq = new View(context);
        this.bmq.setOnClickListener(new j(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow(activity, this.aXA, view, as.getDrawable(n.f.transparent_bg), new k(this));
        }
        this.mPopWindow.setOnDismissListener(new l(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, fd fdVar) {
        this.bmo = fdVar;
        this.bms = this.bmr.get(this.bmo.biC);
        if (this.bms == null) {
            this.bms = r.gt(this.bmo.biC);
            this.bms.a(this.mContext, this);
            this.bmr.put(this.bmo.biC, this.bms);
        }
        this.bms.setData(fdVar.biD);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.J(horizontalTabView.getContext());
                int L = com.baidu.adp.lib.util.k.L(horizontalTabView.getContext());
                int PA = this.bms.PA();
                int measuredHeight = (L - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < PA) {
                    horizontalTabView.getmShowMenuCallBack().gq(PA - measuredHeight);
                }
            }
        }
        this.aXA.removeAllViews();
        this.aXA.addView(this.bms.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        as.i(this.bmq, n.d.black_alpha40);
        this.aXA.addView(this.bmq, layoutParams);
        a(activity, view, tabItemView);
        if (this.mPopWindow != null) {
            this.mPopWindow.refresh();
            this.mPopWindow.setWidthAsWidthOfDeviceScreen(activity);
            this.mPopWindow.setHeight(-1);
            this.mPopWindow.showWindowInCustomPosition(0, 0);
        }
    }

    public void PB() {
        if (this.mPopWindow != null) {
            com.baidu.adp.lib.h.j.a(this.mPopWindow);
        }
    }

    public void vR() {
        if (this.bms != null) {
            this.bms.vR();
        }
        if (this.bmq != null) {
            as.i(this.bmq, n.d.black_alpha40);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.setBackgroundDrawable(as.getDrawable(n.f.transparent_bg));
        }
    }

    public a PC() {
        return this.bmd;
    }
}
