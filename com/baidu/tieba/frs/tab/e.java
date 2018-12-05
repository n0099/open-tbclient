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
    private MorePopupWindow amW;
    private LinearLayout drW;
    private b ebO;
    private a ebP;
    private au eca;
    private View ecb;
    private SparseArray<com.baidu.tieba.frs.tab.a> ecc = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a ecd;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void nm(int i);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public TextView bPh;
        public ImageView ecg;
        public View ech;
        public View eci;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.ebO = bVar;
        this.ebP = aVar;
        this.drW = new LinearLayout(context);
        this.drW.setOrientation(1);
        this.drW.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.ecb = new View(context);
        this.ecb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.amW);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.amW == null) {
            this.amW = new MorePopupWindow(activity, this.drW, view, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xd() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xe() {
                    if (e.this.amW != null) {
                        com.baidu.adp.lib.g.g.a(e.this.amW);
                    }
                }
            });
        }
        this.amW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.ebP != null) {
                    e.this.ebP.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.eca = auVar;
        this.ecd = this.ecc.get(this.eca.dLs);
        if (this.ecd == null) {
            this.ecd = h.nq(this.eca.dLs);
            this.ecd.a(this.mContext, this);
            this.ecc.put(this.eca.dLs, this.ecd);
        }
        this.ecd.setData(auVar.dLt);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int aGN = this.ecd.aGN();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aGN) {
                    horizontalTabView.getmShowMenuCallBack().nn(aGN - measuredHeight);
                }
            }
        }
        this.drW.removeAllViews();
        this.drW.addView(this.ecd.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.i(this.ecb, e.d.common_color_10050);
        this.drW.addView(this.ecb, layoutParams);
        a(activity, view, tabItemView);
        if (this.amW != null) {
            this.amW.refresh();
            this.amW.setWidthAsWidthOfDeviceScreen(activity);
            this.amW.setHeight(-1);
            this.amW.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.amW != null) {
            try {
                this.amW.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b aGP() {
        return this.ebO;
    }
}
