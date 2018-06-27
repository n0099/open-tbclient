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
    private MorePopupWindow abD;
    private LinearLayout cTD;
    private au dCE;
    private View dCF;
    private SparseArray<com.baidu.tieba.frs.tab.a> dCG = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a dCH;
    private b dCs;
    private a dCt;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void lt(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView bvD;
        public ImageView dCK;
        public View dCL;
        public View dCM;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.dCs = bVar;
        this.dCt = aVar;
        this.cTD = new LinearLayout(context);
        this.cTD.setOrientation(1);
        this.cTD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.dCF = new View(context);
        this.dCF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.abD);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.abD == null) {
            this.abD = new MorePopupWindow(activity, this.cTD, view, am.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sQ() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void sR() {
                    if (e.this.abD != null) {
                        com.baidu.adp.lib.g.g.a(e.this.abD);
                    }
                }
            });
        }
        this.abD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.dCt != null) {
                    e.this.dCt.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.dCE = auVar;
        this.dCH = this.dCG.get(this.dCE.dmF);
        if (this.dCH == null) {
            this.dCH = h.lx(this.dCE.dmF);
            this.dCH.a(this.mContext, this);
            this.dCG.put(this.dCE.dmF, this.dCH);
        }
        this.dCH.setData(auVar.dmG);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ai(horizontalTabView.getContext());
                int aj = l.aj(horizontalTabView.getContext());
                int azz = this.dCH.azz();
                int measuredHeight = (aj - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < azz) {
                    horizontalTabView.getmShowMenuCallBack().lu(azz - measuredHeight);
                }
            }
        }
        this.cTD.removeAllViews();
        this.cTD.addView(this.dCH.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.i(this.dCF, d.C0142d.common_color_10050);
        this.cTD.addView(this.dCF, layoutParams);
        a(activity, view, tabItemView);
        if (this.abD != null) {
            this.abD.refresh();
            this.abD.setWidthAsWidthOfDeviceScreen(activity);
            this.abD.setHeight(-1);
            this.abD.showWindowInCustomPosition(0, 0);
        }
    }

    public void azB() {
        if (this.abD != null) {
            try {
                this.abD.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b azC() {
        return this.dCs;
    }
}
