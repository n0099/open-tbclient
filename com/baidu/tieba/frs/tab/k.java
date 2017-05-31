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
import com.baidu.tieba.frs.co;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k {
    private MorePopupWindow QG;
    private LinearLayout bOS;
    private b cfB;
    private a cfC;
    private co cfP;
    private View cfQ;
    private SparseArray<g> cfR = new SparseArray<>();
    private g cfS;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void iV(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView cfV;
        public View cfW;
        public View cfX;
        public TextView name;
    }

    public k(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cfB = bVar;
        this.cfC = aVar;
        this.bOS = new LinearLayout(context);
        this.bOS.setOrientation(1);
        this.bOS.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cfQ = new View(context);
        this.cfQ.setOnClickListener(new l(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.QG == null) {
            this.QG = new MorePopupWindow(activity, this.bOS, view, aq.getDrawable(w.g.transparent_bg), new m(this));
        }
        this.QG.setOnDismissListener(new n(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, co coVar) {
        this.cfP = coVar;
        this.cfS = this.cfR.get(this.cfP.bWL);
        if (this.cfS == null) {
            this.cfS = t.iX(this.cfP.bWL);
            this.cfS.a(this.mContext, this);
            this.cfR.put(this.cfP.bWL, this.cfS);
        }
        this.cfS.setData(coVar.bWM);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.ae(horizontalTabView.getContext());
                int ag = com.baidu.adp.lib.util.k.ag(horizontalTabView.getContext());
                int adz = this.cfS.adz();
                int measuredHeight = (ag - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < adz) {
                    horizontalTabView.getmShowMenuCallBack().iw(adz - measuredHeight);
                }
            }
        }
        this.bOS.removeAllViews();
        this.bOS.addView(this.cfS.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aq.j(this.cfQ, w.e.common_color_10050);
        this.bOS.addView(this.cfQ, layoutParams);
        a(activity, view, tabItemView);
        if (this.QG != null) {
            this.QG.refresh();
            this.QG.setWidthAsWidthOfDeviceScreen(activity);
            this.QG.setHeight(-1);
            this.QG.showWindowInCustomPosition(0, 0);
        }
    }

    public void adA() {
        if (this.QG != null) {
            try {
                this.QG.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void ws() {
        if (this.cfS != null) {
            this.cfS.ws();
        }
        if (this.cfQ != null) {
            aq.j(this.cfQ, w.e.common_color_10050);
        }
        if (this.QG != null) {
            this.QG.setBackgroundDrawable(aq.getDrawable(w.g.transparent_bg));
        }
    }

    public b adB() {
        return this.cfB;
    }
}
