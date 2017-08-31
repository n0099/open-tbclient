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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.at;
/* loaded from: classes.dex */
public class e {
    private MorePopupWindow Rq;
    private b cEH;
    private a cEI;
    private at cEU;
    private View cEV;
    private SparseArray<com.baidu.tieba.frs.tab.a> cEW = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cEX;
    private LinearLayout cfR;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void jO(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView cFa;
        public View cFb;
        public View cFc;
        public TextView name;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cEH = bVar;
        this.cEI = aVar;
        this.cfR = new LinearLayout(context);
        this.cfR.setOrientation(1);
        this.cfR.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cEV = new View(context);
        this.cEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.Rq);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.Rq == null) {
            this.Rq = new MorePopupWindow(activity, this.cfR, view, aj.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void oo() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void op() {
                    if (e.this.Rq != null) {
                        com.baidu.adp.lib.g.g.a(e.this.Rq);
                    }
                }
            });
        }
        this.Rq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cEI != null) {
                    e.this.cEI.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.cEU = atVar;
        this.cEX = this.cEW.get(this.cEU.crU);
        if (this.cEX == null) {
            this.cEX = h.jQ(this.cEU.crU);
            this.cEX.a(this.mContext, this);
            this.cEW.put(this.cEU.crU, this.cEX);
        }
        this.cEX.setData(atVar.crV);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                k.ac(horizontalTabView.getContext());
                int ae = k.ae(horizontalTabView.getContext());
                int alm = this.cEX.alm();
                int measuredHeight = (ae - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < alm) {
                    horizontalTabView.getmShowMenuCallBack().ji(alm - measuredHeight);
                }
            }
        }
        this.cfR.removeAllViews();
        this.cfR.addView(this.cEX.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aj.j(this.cEV, d.e.common_color_10050);
        this.cfR.addView(this.cEV, layoutParams);
        a(activity, view, tabItemView);
        if (this.Rq != null) {
            this.Rq.refresh();
            this.Rq.setWidthAsWidthOfDeviceScreen(activity);
            this.Rq.setHeight(-1);
            this.Rq.showWindowInCustomPosition(0, 0);
        }
    }

    public void alo() {
        if (this.Rq != null) {
            try {
                this.Rq.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void xc() {
        if (this.cEX != null) {
            this.cEX.xc();
        }
        if (this.cEV != null) {
            aj.j(this.cEV, d.e.common_color_10050);
        }
        if (this.Rq != null) {
            this.Rq.setBackgroundDrawable(aj.getDrawable(d.g.transparent_bg));
        }
    }

    public b alp() {
        return this.cEH;
    }
}
