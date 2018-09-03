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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.au;
/* loaded from: classes2.dex */
public class e {
    private MorePopupWindow abh;
    private LinearLayout cWm;
    private b dFb;
    private a dFc;
    private au dFn;
    private View dFo;
    private SparseArray<com.baidu.tieba.frs.tab.a> dFp = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a dFq;
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
        public TextView bwl;
        public ImageView dFt;
        public View dFu;
        public View dFv;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.dFb = bVar;
        this.dFc = aVar;
        this.cWm = new LinearLayout(context);
        this.cWm.setOrientation(1);
        this.cWm.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.dFo = new View(context);
        this.dFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.abh);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.abh == null) {
            this.abh = new MorePopupWindow(activity, this.cWm, view, am.getDrawable(f.C0146f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sB() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sC() {
                    if (e.this.abh != null) {
                        com.baidu.adp.lib.g.g.a(e.this.abh);
                    }
                }
            });
        }
        this.abh.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.dFc != null) {
                    e.this.dFc.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.dFn = auVar;
        this.dFq = this.dFp.get(this.dFn.dpv);
        if (this.dFq == null) {
            this.dFq = h.lI(this.dFn.dpv);
            this.dFq.a(this.mContext, this);
            this.dFp.put(this.dFn.dpv, this.dFq);
        }
        this.dFq.setData(auVar.dpw);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ai(horizontalTabView.getContext());
                int aj = l.aj(horizontalTabView.getContext());
                int aAd = this.dFq.aAd();
                int measuredHeight = (aj - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aAd) {
                    horizontalTabView.getmShowMenuCallBack().lF(aAd - measuredHeight);
                }
            }
        }
        this.cWm.removeAllViews();
        this.cWm.addView(this.dFq.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.i(this.dFo, f.d.common_color_10050);
        this.cWm.addView(this.dFo, layoutParams);
        a(activity, view, tabItemView);
        if (this.abh != null) {
            this.abh.refresh();
            this.abh.setWidthAsWidthOfDeviceScreen(activity);
            this.abh.setHeight(-1);
            this.abh.showWindowInCustomPosition(0, 0);
        }
    }

    public void aAf() {
        if (this.abh != null) {
            try {
                this.abh.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b aAg() {
        return this.dFb;
    }
}
