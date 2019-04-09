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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.as;
/* loaded from: classes4.dex */
public class e {
    private MorePopupWindow buo;
    private LinearLayout eIu;
    private as ftA;
    private View ftB;
    private SparseArray<com.baidu.tieba.frs.tab.a> ftC = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a ftD;
    private b fto;
    private a ftp;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void rk(int i);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public TextView dfp;
        public ImageView ftG;
        public View ftH;
        public View ftI;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.fto = bVar;
        this.ftp = aVar;
        this.eIu = new LinearLayout(context);
        this.eIu.setOrientation(1);
        this.eIu.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.ftB = new View(context);
        this.ftB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.buo);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.buo == null) {
            this.buo = new MorePopupWindow(activity, this.eIu, view, al.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VU() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VV() {
                    if (e.this.buo != null) {
                        com.baidu.adp.lib.g.g.a(e.this.buo);
                    }
                }
            });
        }
        this.buo.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.ftp != null) {
                    e.this.ftp.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.ftA = asVar;
        this.ftD = this.ftC.get(this.ftA.fcq);
        if (this.ftD == null) {
            this.ftD = h.ro(this.ftA.fcq);
            this.ftD.a(this.mContext, this);
            this.ftC.put(this.ftA.fcq, this.ftD);
        }
        this.ftD.setData(asVar.fcr);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int bim = this.ftD.bim();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bim) {
                    horizontalTabView.getmShowMenuCallBack().rl(bim - measuredHeight);
                }
            }
        }
        this.eIu.removeAllViews();
        this.eIu.addView(this.ftD.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.k(this.ftB, d.C0277d.common_color_10050);
        this.eIu.addView(this.ftB, layoutParams);
        a(activity, view, tabItemView);
        if (this.buo != null) {
            this.buo.refresh();
            this.buo.setWidthAsWidthOfDeviceScreen(activity);
            this.buo.setHeight(-1);
            this.buo.showWindowInCustomPosition(0, 0);
        }
    }

    public void bio() {
        if (this.buo != null) {
            try {
                this.buo.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bip() {
        return this.fto;
    }
}
