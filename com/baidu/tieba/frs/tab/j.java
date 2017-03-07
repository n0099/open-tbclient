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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.cu;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow Ri;
    private LinearLayout bHQ;
    private b caG;
    private a caH;
    private cu caS;
    private View caT;
    private SparseArray<f> caU = new SparseArray<>();
    private f caV;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void iy(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView caY;
        public View caZ;
        public View cba;
        public TextView name;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.caG = bVar;
        this.caH = aVar;
        this.bHQ = new LinearLayout(context);
        this.bHQ.setOrientation(1);
        this.bHQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.caT = new View(context);
        this.caT.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.Ri == null) {
            this.Ri = new MorePopupWindow(activity, this.bHQ, view, aq.getDrawable(w.g.transparent_bg), new l(this));
        }
        this.Ri.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, cu cuVar) {
        this.caS = cuVar;
        this.caV = this.caU.get(this.caS.bQc);
        if (this.caV == null) {
            this.caV = s.iA(this.caS.bQc);
            this.caV.a(this.mContext, this);
            this.caU.put(this.caS.bQc, this.caV);
        }
        this.caV.setData(cuVar.bQd);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.af(horizontalTabView.getContext());
                int ah = com.baidu.adp.lib.util.k.ah(horizontalTabView.getContext());
                int adx = this.caV.adx();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < adx) {
                    horizontalTabView.getmShowMenuCallBack().hZ(adx - measuredHeight);
                }
            }
        }
        this.bHQ.removeAllViews();
        this.bHQ.addView(this.caV.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aq.j(this.caT, w.e.common_color_10050);
        this.bHQ.addView(this.caT, layoutParams);
        a(activity, view, tabItemView);
        if (this.Ri != null) {
            this.Ri.refresh();
            this.Ri.setWidthAsWidthOfDeviceScreen(activity);
            this.Ri.setHeight(-1);
            this.Ri.showWindowInCustomPosition(0, 0);
        }
    }

    public void adz() {
        if (this.Ri != null) {
            try {
                this.Ri.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wP() {
        if (this.caV != null) {
            this.caV.wP();
        }
        if (this.caT != null) {
            aq.j(this.caT, w.e.common_color_10050);
        }
        if (this.Ri != null) {
            this.Ri.setBackgroundDrawable(aq.getDrawable(w.g.transparent_bg));
        }
    }

    public b adA() {
        return this.caG;
    }
}
