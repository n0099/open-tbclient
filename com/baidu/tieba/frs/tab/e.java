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
import com.baidu.tieba.e;
import com.baidu.tieba.frs.au;
/* loaded from: classes2.dex */
public class e {
    private MorePopupWindow adK;
    private b dMj;
    private a dMk;
    private au dMv;
    private View dMw;
    private SparseArray<com.baidu.tieba.frs.tab.a> dMx = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a dMy;
    private LinearLayout dcf;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void mg(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView bCa;
        public ImageView dMB;
        public View dMC;
        public View dMD;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.dMj = bVar;
        this.dMk = aVar;
        this.dcf = new LinearLayout(context);
        this.dcf.setOrientation(1);
        this.dcf.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.dMw = new View(context);
        this.dMw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.adK);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.adK == null) {
            this.adK = new MorePopupWindow(activity, this.dcf, view, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void tI() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void tJ() {
                    if (e.this.adK != null) {
                        com.baidu.adp.lib.g.g.a(e.this.adK);
                    }
                }
            });
        }
        this.adK.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.dMk != null) {
                    e.this.dMk.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.dMv = auVar;
        this.dMy = this.dMx.get(this.dMv.dvC);
        if (this.dMy == null) {
            this.dMy = h.mk(this.dMv.dvC);
            this.dMy.a(this.mContext, this);
            this.dMx.put(this.dMv.dvC, this.dMy);
        }
        this.dMy.setData(auVar.dvD);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int aCm = this.dMy.aCm();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aCm) {
                    horizontalTabView.getmShowMenuCallBack().mh(aCm - measuredHeight);
                }
            }
        }
        this.dcf.removeAllViews();
        this.dcf.addView(this.dMy.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.i(this.dMw, e.d.common_color_10050);
        this.dcf.addView(this.dMw, layoutParams);
        a(activity, view, tabItemView);
        if (this.adK != null) {
            this.adK.refresh();
            this.adK.setWidthAsWidthOfDeviceScreen(activity);
            this.adK.setHeight(-1);
            this.adK.showWindowInCustomPosition(0, 0);
        }
    }

    public void aCo() {
        if (this.adK != null) {
            try {
                this.adK.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b aCp() {
        return this.dMj;
    }
}
