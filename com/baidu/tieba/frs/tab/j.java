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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow MU;
    private LinearLayout bKb;
    private du cdI;
    private View cdJ;
    private SparseArray<f> cdK = new SparseArray<>();
    private f cdL;
    private b cdw;
    private a cdx;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void iA(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aKy;
        public ImageView cdO;
        public View cdP;
        public View cdQ;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cdw = bVar;
        this.cdx = aVar;
        this.bKb = new LinearLayout(context);
        this.bKb.setOrientation(1);
        this.bKb.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cdJ = new View(context);
        this.cdJ.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.MU == null) {
            this.MU = new MorePopupWindow(activity, this.bKb, view, av.getDrawable(r.f.transparent_bg), new l(this));
        }
        this.MU.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, du duVar) {
        this.cdI = duVar;
        this.cdL = this.cdK.get(this.cdI.bTl);
        if (this.cdL == null) {
            this.cdL = s.iC(this.cdI.bTl);
            this.cdL.a(this.mContext, this);
            this.cdK.put(this.cdI.bTl, this.cdL);
        }
        this.cdL.setData(duVar.bTm);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.J(horizontalTabView.getContext());
                int L = com.baidu.adp.lib.util.k.L(horizontalTabView.getContext());
                int afn = this.cdL.afn();
                int measuredHeight = (L - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < afn) {
                    horizontalTabView.getmShowMenuCallBack().ig(afn - measuredHeight);
                }
            }
        }
        this.bKb.removeAllViews();
        this.bKb.addView(this.cdL.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        av.k(this.cdJ, r.d.common_color_10050);
        this.bKb.addView(this.cdJ, layoutParams);
        a(activity, view, tabItemView);
        if (this.MU != null) {
            this.MU.refresh();
            this.MU.setWidthAsWidthOfDeviceScreen(activity);
            this.MU.setHeight(-1);
            this.MU.showWindowInCustomPosition(0, 0);
        }
    }

    public void afp() {
        if (this.MU != null) {
            try {
                this.MU.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wH() {
        if (this.cdL != null) {
            this.cdL.wH();
        }
        if (this.cdJ != null) {
            av.k(this.cdJ, r.d.common_color_10050);
        }
        if (this.MU != null) {
            this.MU.setBackgroundDrawable(av.getDrawable(r.f.transparent_bg));
        }
    }

    public b afq() {
        return this.cdw;
    }
}
