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
/* loaded from: classes6.dex */
public class e {
    private MorePopupWindow any;
    private LinearLayout dvt;
    private com.baidu.tieba.frs.tab.a efA;
    private b efl;
    private a efm;
    private au efx;
    private View efy;
    private SparseArray<com.baidu.tieba.frs.tab.a> efz = new SparseArray<>();
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void nA(int i);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public TextView bPV;
        public ImageView efD;
        public View efE;
        public View efF;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.efl = bVar;
        this.efm = aVar;
        this.dvt = new LinearLayout(context);
        this.dvt.setOrientation(1);
        this.dvt.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.efy = new View(context);
        this.efy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.any);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.any == null) {
            this.any = new MorePopupWindow(activity, this.dvt, view, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xq() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xr() {
                    if (e.this.any != null) {
                        com.baidu.adp.lib.g.g.a(e.this.any);
                    }
                }
            });
        }
        this.any.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.efm != null) {
                    e.this.efm.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.efx = auVar;
        this.efA = this.efz.get(this.efx.dOP);
        if (this.efA == null) {
            this.efA = h.nE(this.efx.dOP);
            this.efA.a(this.mContext, this);
            this.efz.put(this.efx.dOP, this.efA);
        }
        this.efA.setData(auVar.dOQ);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int aHZ = this.efA.aHZ();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aHZ) {
                    horizontalTabView.getmShowMenuCallBack().nB(aHZ - measuredHeight);
                }
            }
        }
        this.dvt.removeAllViews();
        this.dvt.addView(this.efA.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.i(this.efy, e.d.common_color_10050);
        this.dvt.addView(this.efy, layoutParams);
        a(activity, view, tabItemView);
        if (this.any != null) {
            this.any.refresh();
            this.any.setWidthAsWidthOfDeviceScreen(activity);
            this.any.setHeight(-1);
            this.any.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.any != null) {
            try {
                this.any.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b aIb() {
        return this.efl;
    }
}
