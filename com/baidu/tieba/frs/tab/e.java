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
    private MorePopupWindow buk;
    private LinearLayout eIH;
    private b ftC;
    private a ftD;
    private as ftO;
    private View ftP;
    private SparseArray<com.baidu.tieba.frs.tab.a> ftQ = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a ftR;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void ro(int i);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public TextView dfk;
        public ImageView ftU;
        public View ftV;
        public View ftW;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.ftC = bVar;
        this.ftD = aVar;
        this.eIH = new LinearLayout(context);
        this.eIH.setOrientation(1);
        this.eIH.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.ftP = new View(context);
        this.ftP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.buk);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.buk == null) {
            this.buk = new MorePopupWindow(activity, this.eIH, view, al.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VX() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VY() {
                    if (e.this.buk != null) {
                        com.baidu.adp.lib.g.g.a(e.this.buk);
                    }
                }
            });
        }
        this.buk.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.ftD != null) {
                    e.this.ftD.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.ftO = asVar;
        this.ftR = this.ftQ.get(this.ftO.fcD);
        if (this.ftR == null) {
            this.ftR = h.rs(this.ftO.fcD);
            this.ftR.a(this.mContext, this);
            this.ftQ.put(this.ftO.fcD, this.ftR);
        }
        this.ftR.setData(asVar.fcE);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int bio = this.ftR.bio();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bio) {
                    horizontalTabView.getmShowMenuCallBack().rp(bio - measuredHeight);
                }
            }
        }
        this.eIH.removeAllViews();
        this.eIH.addView(this.ftR.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.k(this.ftP, d.C0277d.common_color_10050);
        this.eIH.addView(this.ftP, layoutParams);
        a(activity, view, tabItemView);
        if (this.buk != null) {
            this.buk.refresh();
            this.buk.setWidthAsWidthOfDeviceScreen(activity);
            this.buk.setHeight(-1);
            this.buk.showWindowInCustomPosition(0, 0);
        }
    }

    public void biq() {
        if (this.buk != null) {
            try {
                this.buk.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bir() {
        return this.ftC;
    }
}
