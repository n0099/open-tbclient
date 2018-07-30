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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.au;
/* loaded from: classes2.dex */
public class e {
    private MorePopupWindow abg;
    private LinearLayout cWq;
    private b dFe;
    private a dFf;
    private au dFq;
    private View dFr;
    private SparseArray<com.baidu.tieba.frs.tab.a> dFs = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a dFt;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void lE(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView bwj;
        public ImageView dFw;
        public View dFx;
        public View dFy;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.dFe = bVar;
        this.dFf = aVar;
        this.cWq = new LinearLayout(context);
        this.cWq.setOrientation(1);
        this.cWq.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.dFr = new View(context);
        this.dFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.abg);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.abg == null) {
            this.abg = new MorePopupWindow(activity, this.cWq, view, am.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sC() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sD() {
                    if (e.this.abg != null) {
                        com.baidu.adp.lib.g.g.a(e.this.abg);
                    }
                }
            });
        }
        this.abg.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.dFf != null) {
                    e.this.dFf.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.dFq = auVar;
        this.dFt = this.dFs.get(this.dFq.dpx);
        if (this.dFt == null) {
            this.dFt = h.lI(this.dFq.dpx);
            this.dFt.a(this.mContext, this);
            this.dFs.put(this.dFq.dpx, this.dFt);
        }
        this.dFt.setData(auVar.dpy);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ai(horizontalTabView.getContext());
                int aj = l.aj(horizontalTabView.getContext());
                int aAg = this.dFt.aAg();
                int measuredHeight = (aj - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aAg) {
                    horizontalTabView.getmShowMenuCallBack().lF(aAg - measuredHeight);
                }
            }
        }
        this.cWq.removeAllViews();
        this.cWq.addView(this.dFt.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.i(this.dFr, d.C0140d.common_color_10050);
        this.cWq.addView(this.dFr, layoutParams);
        a(activity, view, tabItemView);
        if (this.abg != null) {
            this.abg.refresh();
            this.abg.setWidthAsWidthOfDeviceScreen(activity);
            this.abg.setHeight(-1);
            this.abg.showWindowInCustomPosition(0, 0);
        }
    }

    public void aAi() {
        if (this.abg != null) {
            try {
                this.abg.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b aAj() {
        return this.dFe;
    }
}
