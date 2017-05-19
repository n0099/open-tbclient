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
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k {
    private MorePopupWindow QU;
    private LinearLayout bJe;
    private cn bZD;
    private View bZE;
    private SparseArray<g> bZF = new SparseArray<>();
    private g bZG;
    private b bZp;
    private a bZq;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void ix(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView bZJ;
        public View bZK;
        public View bZL;
        public TextView name;
    }

    public k(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.bZp = bVar;
        this.bZq = aVar;
        this.bJe = new LinearLayout(context);
        this.bJe.setOrientation(1);
        this.bJe.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bZE = new View(context);
        this.bZE.setOnClickListener(new l(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.QU == null) {
            this.QU = new MorePopupWindow(activity, this.bJe, view, aq.getDrawable(w.g.transparent_bg), new m(this));
        }
        this.QU.setOnDismissListener(new n(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, cn cnVar) {
        this.bZD = cnVar;
        this.bZG = this.bZF.get(this.bZD.bQU);
        if (this.bZG == null) {
            this.bZG = t.iz(this.bZD.bQU);
            this.bZG.a(this.mContext, this);
            this.bZF.put(this.bZD.bQU, this.bZG);
        }
        this.bZG.setData(cnVar.bQV);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.ae(horizontalTabView.getContext());
                int ag = com.baidu.adp.lib.util.k.ag(horizontalTabView.getContext());
                int acv = this.bZG.acv();
                int measuredHeight = (ag - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < acv) {
                    horizontalTabView.getmShowMenuCallBack().hY(acv - measuredHeight);
                }
            }
        }
        this.bJe.removeAllViews();
        this.bJe.addView(this.bZG.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aq.j(this.bZE, w.e.common_color_10050);
        this.bJe.addView(this.bZE, layoutParams);
        a(activity, view, tabItemView);
        if (this.QU != null) {
            this.QU.refresh();
            this.QU.setWidthAsWidthOfDeviceScreen(activity);
            this.QU.setHeight(-1);
            this.QU.showWindowInCustomPosition(0, 0);
        }
    }

    public void acx() {
        if (this.QU != null) {
            try {
                this.QU.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void ww() {
        if (this.bZG != null) {
            this.bZG.ww();
        }
        if (this.bZE != null) {
            aq.j(this.bZE, w.e.common_color_10050);
        }
        if (this.QU != null) {
            this.QU.setBackgroundDrawable(aq.getDrawable(w.g.transparent_bg));
        }
    }

    public b acy() {
        return this.bZp;
    }
}
