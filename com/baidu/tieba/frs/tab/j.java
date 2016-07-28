package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.dz;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow KI;
    private dz bSD;
    private View bSE;
    private SparseArray<f> bSF = new SparseArray<>();
    private f bSG;
    private b bSs;
    private a bSt;
    private LinearLayout byy;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void hS(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aHI;
        public ImageView bSJ;
        public View bSK;
        public View bSL;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.bSs = bVar;
        this.bSt = aVar;
        this.byy = new LinearLayout(context);
        this.byy.setOrientation(1);
        this.byy.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bSE = new View(context);
        this.bSE.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.KI == null) {
            this.KI = new MorePopupWindow(activity, this.byy, view, av.getDrawable(u.f.transparent_bg), new l(this));
        }
        this.KI.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, dz dzVar) {
        this.bSD = dzVar;
        this.bSG = this.bSF.get(this.bSD.bIm);
        if (this.bSG == null) {
            this.bSG = s.hU(this.bSD.bIm);
            this.bSG.a(this.mContext, this);
            this.bSF.put(this.bSD.bIm, this.bSG);
        }
        this.bSG.setData(dzVar.bIn);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.z(horizontalTabView.getContext());
                int B = com.baidu.adp.lib.util.k.B(horizontalTabView.getContext());
                int aao = this.bSG.aao();
                int measuredHeight = (B - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aao) {
                    horizontalTabView.getmShowMenuCallBack().hz(aao - measuredHeight);
                }
            }
        }
        this.byy.removeAllViews();
        this.byy.addView(this.bSG.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        av.k(this.bSE, u.d.common_color_10050);
        this.byy.addView(this.bSE, layoutParams);
        a(activity, view, tabItemView);
        if (this.KI != null) {
            this.KI.refresh();
            this.KI.setWidthAsWidthOfDeviceScreen(activity);
            this.KI.setHeight(-1);
            this.KI.showWindowInCustomPosition(0, 0);
        }
    }

    public void aaq() {
        if (this.KI != null) {
            try {
                this.KI.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void vm() {
        if (this.bSG != null) {
            this.bSG.vm();
        }
        if (this.bSE != null) {
            av.k(this.bSE, u.d.common_color_10050);
        }
        if (this.KI != null) {
            this.KI.setBackgroundDrawable(av.getDrawable(u.f.transparent_bg));
        }
    }

    public b aar() {
        return this.bSs;
    }
}
