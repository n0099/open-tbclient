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
/* loaded from: classes2.dex */
public class e {
    private MorePopupWindow abA;
    private LinearLayout cVB;
    private b dzf;
    private a dzg;
    private as dzr;
    private View dzs;
    private SparseArray<com.baidu.tieba.frs.tab.a> dzt = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a dzu;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void lm(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView bui;
        public ImageView dzx;
        public View dzy;
        public View dzz;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.dzf = bVar;
        this.dzg = aVar;
        this.cVB = new LinearLayout(context);
        this.cVB.setOrientation(1);
        this.cVB.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.dzs = new View(context);
        this.dzs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.abA);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.abA == null) {
            this.abA = new MorePopupWindow(activity, this.cVB, view, al.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sO() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sP() {
                    if (e.this.abA != null) {
                        com.baidu.adp.lib.g.g.a(e.this.abA);
                    }
                }
            });
        }
        this.abA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.dzg != null) {
                    e.this.dzg.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.dzr = asVar;
        this.dzu = this.dzt.get(this.dzr.dky);
        if (this.dzu == null) {
            this.dzu = h.lq(this.dzr.dky);
            this.dzu.a(this.mContext, this);
            this.dzt.put(this.dzr.dky, this.dzu);
        }
        this.dzu.setData(asVar.dkz);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ai(horizontalTabView.getContext());
                int aj = l.aj(horizontalTabView.getContext());
                int ayT = this.dzu.ayT();
                int measuredHeight = (aj - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < ayT) {
                    horizontalTabView.getmShowMenuCallBack().ln(ayT - measuredHeight);
                }
            }
        }
        this.cVB.removeAllViews();
        this.cVB.addView(this.dzu.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.i(this.dzs, d.C0141d.common_color_10050);
        this.cVB.addView(this.dzs, layoutParams);
        a(activity, view, tabItemView);
        if (this.abA != null) {
            this.abA.refresh();
            this.abA.setWidthAsWidthOfDeviceScreen(activity);
            this.abA.setHeight(-1);
            this.abA.showWindowInCustomPosition(0, 0);
        }
    }

    public void ayV() {
        if (this.abA != null) {
            try {
                this.abA.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b ayW() {
        return this.dzf;
    }
}
