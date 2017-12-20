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
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.av;
/* loaded from: classes.dex */
public class e {
    private MorePopupWindow Sn;
    private av cZB;
    private View cZC;
    private SparseArray<com.baidu.tieba.frs.tab.a> cZD = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cZE;
    private b cZo;
    private a cZp;
    private LinearLayout cwu;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void kT(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aWS;
        public ImageView cZH;
        public View cZI;
        public View cZJ;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cZo = bVar;
        this.cZp = aVar;
        this.cwu = new LinearLayout(context);
        this.cwu.setOrientation(1);
        this.cwu.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cZC = new View(context);
        this.cZC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.Sn);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.Sn == null) {
            this.Sn = new MorePopupWindow(activity, this.cwu, view, aj.getDrawable(d.f.transparent_bg), new e.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.e.a
                public void ou() {
                }

                @Override // com.baidu.tbadk.core.view.e.a
                public void ov() {
                    if (e.this.Sn != null) {
                        com.baidu.adp.lib.g.g.a(e.this.Sn);
                    }
                }
            });
        }
        this.Sn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cZp != null) {
                    e.this.cZp.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, av avVar) {
        this.cZB = avVar;
        this.cZE = this.cZD.get(this.cZB.cKg);
        if (this.cZE == null) {
            this.cZE = h.kV(this.cZB.cKg);
            this.cZE.a(this.mContext, this);
            this.cZD.put(this.cZB.cKg, this.cZE);
        }
        this.cZE.setData(avVar.cKh);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ad(horizontalTabView.getContext());
                int ae = l.ae(horizontalTabView.getContext());
                int aqy = this.cZE.aqy();
                int measuredHeight = (ae - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aqy) {
                    horizontalTabView.getmShowMenuCallBack().ki(aqy - measuredHeight);
                }
            }
        }
        this.cwu.removeAllViews();
        this.cwu.addView(this.cZE.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aj.j(this.cZC, d.C0096d.common_color_10050);
        this.cwu.addView(this.cZC, layoutParams);
        a(activity, view, tabItemView);
        if (this.Sn != null) {
            this.Sn.refresh();
            this.Sn.setWidthAsWidthOfDeviceScreen(activity);
            this.Sn.setHeight(-1);
            this.Sn.showWindowInCustomPosition(0, 0);
        }
    }

    public void aqA() {
        if (this.Sn != null) {
            try {
                this.Sn.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wC() {
        if (this.cZE != null) {
            this.cZE.wC();
        }
        if (this.cZC != null) {
            aj.j(this.cZC, d.C0096d.common_color_10050);
        }
        if (this.Sn != null) {
            this.Sn.setBackgroundDrawable(aj.getDrawable(d.f.transparent_bg));
        }
    }

    public b aqB() {
        return this.cZo;
    }
}
