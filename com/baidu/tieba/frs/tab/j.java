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
import com.baidu.tieba.frs.du;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow MV;
    private LinearLayout bKa;
    private du cdJ;
    private View cdK;
    private SparseArray<f> cdL = new SparseArray<>();
    private f cdM;
    private b cdy;
    private a cdz;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void iv(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aKZ;
        public ImageView cdP;
        public View cdQ;
        public View cdR;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cdy = bVar;
        this.cdz = aVar;
        this.bKa = new LinearLayout(context);
        this.bKa.setOrientation(1);
        this.bKa.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cdK = new View(context);
        this.cdK.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.MV == null) {
            this.MV = new MorePopupWindow(activity, this.bKa, view, av.getDrawable(t.f.transparent_bg), new l(this));
        }
        this.MV.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, du duVar) {
        this.cdJ = duVar;
        this.cdM = this.cdL.get(this.cdJ.bTs);
        if (this.cdM == null) {
            this.cdM = s.ix(this.cdJ.bTs);
            this.cdM.a(this.mContext, this);
            this.cdL.put(this.cdJ.bTs, this.cdM);
        }
        this.cdM.setData(duVar.bTt);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.J(horizontalTabView.getContext());
                int L = com.baidu.adp.lib.util.k.L(horizontalTabView.getContext());
                int aeZ = this.cdM.aeZ();
                int measuredHeight = (L - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aeZ) {
                    horizontalTabView.getmShowMenuCallBack().ic(aeZ - measuredHeight);
                }
            }
        }
        this.bKa.removeAllViews();
        this.bKa.addView(this.cdM.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        av.k(this.cdK, t.d.common_color_10050);
        this.bKa.addView(this.cdK, layoutParams);
        a(activity, view, tabItemView);
        if (this.MV != null) {
            this.MV.refresh();
            this.MV.setWidthAsWidthOfDeviceScreen(activity);
            this.MV.setHeight(-1);
            this.MV.showWindowInCustomPosition(0, 0);
        }
    }

    public void afb() {
        if (this.MV != null) {
            try {
                this.MV.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wq() {
        if (this.cdM != null) {
            this.cdM.wq();
        }
        if (this.cdK != null) {
            av.k(this.cdK, t.d.common_color_10050);
        }
        if (this.MV != null) {
            this.MV.setBackgroundDrawable(av.getDrawable(t.f.transparent_bg));
        }
    }

    public b afc() {
        return this.cdy;
    }
}
