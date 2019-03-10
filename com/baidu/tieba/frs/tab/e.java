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
    private MorePopupWindow bui;
    private LinearLayout eIL;
    private b ftD;
    private a ftE;
    private as ftP;
    private View ftQ;
    private SparseArray<com.baidu.tieba.frs.tab.a> ftR = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a ftS;
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
        public TextView dfo;
        public ImageView ftV;
        public View ftW;
        public View ftX;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.ftD = bVar;
        this.ftE = aVar;
        this.eIL = new LinearLayout(context);
        this.eIL.setOrientation(1);
        this.eIL.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.ftQ = new View(context);
        this.ftQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.bui);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.bui == null) {
            this.bui = new MorePopupWindow(activity, this.eIL, view, al.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VX() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void VY() {
                    if (e.this.bui != null) {
                        com.baidu.adp.lib.g.g.a(e.this.bui);
                    }
                }
            });
        }
        this.bui.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.ftE != null) {
                    e.this.ftE.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.ftP = asVar;
        this.ftS = this.ftR.get(this.ftP.fcE);
        if (this.ftS == null) {
            this.ftS = h.rs(this.ftP.fcE);
            this.ftS.a(this.mContext, this);
            this.ftR.put(this.ftP.fcE, this.ftS);
        }
        this.ftS.setData(asVar.fcF);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int bip = this.ftS.bip();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bip) {
                    horizontalTabView.getmShowMenuCallBack().rp(bip - measuredHeight);
                }
            }
        }
        this.eIL.removeAllViews();
        this.eIL.addView(this.ftS.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.k(this.ftQ, d.C0236d.common_color_10050);
        this.eIL.addView(this.ftQ, layoutParams);
        a(activity, view, tabItemView);
        if (this.bui != null) {
            this.bui.refresh();
            this.bui.setWidthAsWidthOfDeviceScreen(activity);
            this.bui.setHeight(-1);
            this.bui.showWindowInCustomPosition(0, 0);
        }
    }

    public void bir() {
        if (this.bui != null) {
            try {
                this.bui.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bis() {
        return this.ftD;
    }
}
