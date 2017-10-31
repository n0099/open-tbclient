package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.au;
/* loaded from: classes.dex */
public class e {
    private MorePopupWindow RH;
    private au cPG;
    private View cPH;
    private SparseArray<com.baidu.tieba.frs.tab.a> cPI = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cPJ;
    private b cPt;
    private a cPu;
    private LinearLayout cnf;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void kt(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aTH;
        public ImageView cPM;
        public View cPN;
        public View cPO;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cPt = bVar;
        this.cPu = aVar;
        this.cnf = new LinearLayout(context);
        this.cnf.setOrientation(1);
        this.cnf.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cPH = new View(context);
        this.cPH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.RH);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.RH == null) {
            this.RH = new MorePopupWindow(activity, this.cnf, view, aj.getDrawable(d.f.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void op() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void oq() {
                    if (e.this.RH != null) {
                        com.baidu.adp.lib.g.g.a(e.this.RH);
                    }
                }
            });
        }
        this.RH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cPu != null) {
                    e.this.cPu.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.cPG = auVar;
        this.cPJ = this.cPI.get(this.cPG.cAz);
        if (this.cPJ == null) {
            this.cPJ = h.kv(this.cPG.cAz);
            this.cPJ.a(this.mContext, this);
            this.cPI.put(this.cPG.cAz, this.cPJ);
        }
        this.cPJ.setData(auVar.cAA);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ad(horizontalTabView.getContext());
                int ae = l.ae(horizontalTabView.getContext());
                int aoh = this.cPJ.aoh();
                int measuredHeight = (ae - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aoh) {
                    horizontalTabView.getmShowMenuCallBack().jJ(aoh - measuredHeight);
                }
            }
        }
        this.cnf.removeAllViews();
        this.cnf.addView(this.cPJ.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aj.j(this.cPH, d.C0080d.common_color_10050);
        this.cnf.addView(this.cPH, layoutParams);
        a(activity, view, tabItemView);
        if (this.RH != null) {
            this.RH.refresh();
            this.RH.setWidthAsWidthOfDeviceScreen(activity);
            this.RH.setHeight(-1);
            this.RH.showWindowInCustomPosition(0, 0);
        }
    }

    public void aoj() {
        if (this.RH != null) {
            try {
                this.RH.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wB() {
        if (this.cPJ != null) {
            this.cPJ.wB();
        }
        if (this.cPH != null) {
            aj.j(this.cPH, d.C0080d.common_color_10050);
        }
        if (this.RH != null) {
            this.RH.setBackgroundDrawable(aj.getDrawable(d.f.transparent_bg));
        }
    }

    public b aok() {
        return this.cPt;
    }
}
