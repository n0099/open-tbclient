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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.as;
/* loaded from: classes2.dex */
public class e {
    private MorePopupWindow Tv;
    private LinearLayout cLr;
    private b doO;
    private a doP;
    private as dpa;
    private View dpb;
    private SparseArray<com.baidu.tieba.frs.tab.a> dpc = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a dpd;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void lg(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView blN;
        public ImageView dpg;
        public View dph;
        public View dpi;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.doO = bVar;
        this.doP = aVar;
        this.cLr = new LinearLayout(context);
        this.cLr.setOrientation(1);
        this.cLr.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.dpb = new View(context);
        this.dpb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.adp.lib.g.g.a(e.this.Tv);
            }
        });
    }

    private void a(Activity activity, View view2, final TabItemView tabItemView) {
        if (this.Tv == null) {
            this.Tv = new MorePopupWindow(activity, this.cLr, view2, ak.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void pu() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void pv() {
                    if (e.this.Tv != null) {
                        com.baidu.adp.lib.g.g.a(e.this.Tv);
                    }
                }
            });
        }
        this.Tv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.doP != null) {
                    e.this.doP.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view2, TabItemView tabItemView, as asVar) {
        this.dpa = asVar;
        this.dpd = this.dpc.get(this.dpa.dac);
        if (this.dpd == null) {
            this.dpd = h.lk(this.dpa.dac);
            this.dpd.a(this.mContext, this);
            this.dpc.put(this.dpa.dac, this.dpd);
        }
        this.dpd.setData(asVar.dad);
        if (view2 instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view2;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ag(horizontalTabView.getContext());
                int ah = l.ah(horizontalTabView.getContext());
                int auK = this.dpd.auK();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < auK) {
                    horizontalTabView.getmShowMenuCallBack().lh(auK - measuredHeight);
                }
            }
        }
        this.cLr.removeAllViews();
        this.cLr.addView(this.dpd.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ak.i(this.dpb, d.C0126d.common_color_10050);
        this.cLr.addView(this.dpb, layoutParams);
        a(activity, view2, tabItemView);
        if (this.Tv != null) {
            this.Tv.refresh();
            this.Tv.setWidthAsWidthOfDeviceScreen(activity);
            this.Tv.setHeight(-1);
            this.Tv.showWindowInCustomPosition(0, 0);
        }
    }

    public void auM() {
        if (this.Tv != null) {
            try {
                this.Tv.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b auN() {
        return this.doO;
    }
}
