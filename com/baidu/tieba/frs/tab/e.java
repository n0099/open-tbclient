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
    private b cPN;
    private a cPO;
    private au cQa;
    private View cQb;
    private SparseArray<com.baidu.tieba.frs.tab.a> cQc = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cQd;
    private LinearLayout cnz;
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
        public TextView aTP;
        public ImageView cQg;
        public View cQh;
        public View cQi;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cPN = bVar;
        this.cPO = aVar;
        this.cnz = new LinearLayout(context);
        this.cnz.setOrientation(1);
        this.cnz.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cQb = new View(context);
        this.cQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.RH);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.RH == null) {
            this.RH = new MorePopupWindow(activity, this.cnz, view, aj.getDrawable(d.f.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
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
                if (e.this.cPO != null) {
                    e.this.cPO.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.cQa = auVar;
        this.cQd = this.cQc.get(this.cQa.cAS);
        if (this.cQd == null) {
            this.cQd = h.kv(this.cQa.cAS);
            this.cQd.a(this.mContext, this);
            this.cQc.put(this.cQa.cAS, this.cQd);
        }
        this.cQd.setData(auVar.cAT);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ad(horizontalTabView.getContext());
                int ae = l.ae(horizontalTabView.getContext());
                int aow = this.cQd.aow();
                int measuredHeight = (ae - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aow) {
                    horizontalTabView.getmShowMenuCallBack().jI(aow - measuredHeight);
                }
            }
        }
        this.cnz.removeAllViews();
        this.cnz.addView(this.cQd.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aj.j(this.cQb, d.C0080d.common_color_10050);
        this.cnz.addView(this.cQb, layoutParams);
        a(activity, view, tabItemView);
        if (this.RH != null) {
            this.RH.refresh();
            this.RH.setWidthAsWidthOfDeviceScreen(activity);
            this.RH.setHeight(-1);
            this.RH.showWindowInCustomPosition(0, 0);
        }
    }

    public void aoy() {
        if (this.RH != null) {
            try {
                this.RH.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wB() {
        if (this.cQd != null) {
            this.cQd.wB();
        }
        if (this.cQb != null) {
            aj.j(this.cQb, d.C0080d.common_color_10050);
        }
        if (this.RH != null) {
            this.RH.setBackgroundDrawable(aj.getDrawable(d.f.transparent_bg));
        }
    }

    public b aoz() {
        return this.cPN;
    }
}
