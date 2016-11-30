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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow MV;
    private LinearLayout bMU;
    private cy chJ;
    private View chK;
    private SparseArray<f> chL = new SparseArray<>();
    private f chM;
    private b chx;
    private a chy;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void iF(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aLq;
        public ImageView chP;
        public View chQ;
        public View chR;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.chx = bVar;
        this.chy = aVar;
        this.bMU = new LinearLayout(context);
        this.bMU.setOrientation(1);
        this.bMU.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.chK = new View(context);
        this.chK.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.MV == null) {
            this.MV = new MorePopupWindow(activity, this.bMU, view, at.getDrawable(r.f.transparent_bg), new l(this));
        }
        this.MV.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, cy cyVar) {
        this.chJ = cyVar;
        this.chM = this.chL.get(this.chJ.bVr);
        if (this.chM == null) {
            this.chM = s.iH(this.chJ.bVr);
            this.chM.a(this.mContext, this);
            this.chL.put(this.chJ.bVr, this.chM);
        }
        this.chM.setData(cyVar.bVs);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.J(horizontalTabView.getContext());
                int L = com.baidu.adp.lib.util.k.L(horizontalTabView.getContext());
                int agX = this.chM.agX();
                int measuredHeight = (L - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < agX) {
                    horizontalTabView.getmShowMenuCallBack().ig(agX - measuredHeight);
                }
            }
        }
        this.bMU.removeAllViews();
        this.bMU.addView(this.chM.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        at.k(this.chK, r.d.common_color_10050);
        this.bMU.addView(this.chK, layoutParams);
        a(activity, view, tabItemView);
        if (this.MV != null) {
            this.MV.refresh();
            this.MV.setWidthAsWidthOfDeviceScreen(activity);
            this.MV.setHeight(-1);
            this.MV.showWindowInCustomPosition(0, 0);
        }
    }

    public void agZ() {
        if (this.MV != null) {
            try {
                this.MV.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wM() {
        if (this.chM != null) {
            this.chM.wM();
        }
        if (this.chK != null) {
            at.k(this.chK, r.d.common_color_10050);
        }
        if (this.MV != null) {
            this.MV.setBackgroundDrawable(at.getDrawable(r.f.transparent_bg));
        }
    }

    public b aha() {
        return this.chx;
    }
}
