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
    private MorePopupWindow So;
    private av cZF;
    private View cZG;
    private SparseArray<com.baidu.tieba.frs.tab.a> cZH = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cZI;
    private b cZs;
    private a cZt;
    private LinearLayout cwy;
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
        public TextView aWW;
        public ImageView cZL;
        public View cZM;
        public View cZN;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cZs = bVar;
        this.cZt = aVar;
        this.cwy = new LinearLayout(context);
        this.cwy.setOrientation(1);
        this.cwy.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cZG = new View(context);
        this.cZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.So);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.So == null) {
            this.So = new MorePopupWindow(activity, this.cwy, view, aj.getDrawable(d.f.transparent_bg), new e.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.e.a
                public void ou() {
                }

                @Override // com.baidu.tbadk.core.view.e.a
                public void ov() {
                    if (e.this.So != null) {
                        com.baidu.adp.lib.g.g.a(e.this.So);
                    }
                }
            });
        }
        this.So.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cZt != null) {
                    e.this.cZt.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, av avVar) {
        this.cZF = avVar;
        this.cZI = this.cZH.get(this.cZF.cKk);
        if (this.cZI == null) {
            this.cZI = h.kV(this.cZF.cKk);
            this.cZI.a(this.mContext, this);
            this.cZH.put(this.cZF.cKk, this.cZI);
        }
        this.cZI.setData(avVar.cKl);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ad(horizontalTabView.getContext());
                int ae = l.ae(horizontalTabView.getContext());
                int aqz = this.cZI.aqz();
                int measuredHeight = (ae - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aqz) {
                    horizontalTabView.getmShowMenuCallBack().ki(aqz - measuredHeight);
                }
            }
        }
        this.cwy.removeAllViews();
        this.cwy.addView(this.cZI.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aj.j(this.cZG, d.C0095d.common_color_10050);
        this.cwy.addView(this.cZG, layoutParams);
        a(activity, view, tabItemView);
        if (this.So != null) {
            this.So.refresh();
            this.So.setWidthAsWidthOfDeviceScreen(activity);
            this.So.setHeight(-1);
            this.So.showWindowInCustomPosition(0, 0);
        }
    }

    public void aqB() {
        if (this.So != null) {
            try {
                this.So.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wC() {
        if (this.cZI != null) {
            this.cZI.wC();
        }
        if (this.cZG != null) {
            aj.j(this.cZG, d.C0095d.common_color_10050);
        }
        if (this.So != null) {
            this.So.setBackgroundDrawable(aj.getDrawable(d.f.transparent_bg));
        }
    }

    public b aqC() {
        return this.cZs;
    }
}
