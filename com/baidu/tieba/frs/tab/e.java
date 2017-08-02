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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.at;
/* loaded from: classes.dex */
public class e {
    private MorePopupWindow QN;
    private LinearLayout caB;
    private b cuJ;
    private a cuK;
    private at cuY;
    private View cuZ;
    private SparseArray<com.baidu.tieba.frs.tab.a> cva = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cvb;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void jq(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView cve;
        public View cvf;
        public View cvg;
        public TextView name;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cuJ = bVar;
        this.cuK = aVar;
        this.caB = new LinearLayout(context);
        this.caB.setOrientation(1);
        this.caB.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cuZ = new View(context);
        this.cuZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.QN);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.QN == null) {
            this.QN = new MorePopupWindow(activity, this.caB, view, ai.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void oj() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void ok() {
                    if (e.this.QN != null) {
                        com.baidu.adp.lib.g.g.a(e.this.QN);
                    }
                }
            });
        }
        this.QN.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cuK != null) {
                    e.this.cuK.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.cuY = atVar;
        this.cvb = this.cva.get(this.cuY.ckF);
        if (this.cvb == null) {
            this.cvb = h.js(this.cuY.ckF);
            this.cvb.a(this.mContext, this);
            this.cva.put(this.cuY.ckF, this.cvb);
        }
        this.cvb.setData(atVar.ckG);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                k.ae(horizontalTabView.getContext());
                int ag = k.ag(horizontalTabView.getContext());
                int aiP = this.cvb.aiP();
                int measuredHeight = (ag - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aiP) {
                    horizontalTabView.getmShowMenuCallBack().iS(aiP - measuredHeight);
                }
            }
        }
        this.caB.removeAllViews();
        this.caB.addView(this.cvb.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ai.j(this.cuZ, d.e.common_color_10050);
        this.caB.addView(this.cuZ, layoutParams);
        a(activity, view, tabItemView);
        if (this.QN != null) {
            this.QN.refresh();
            this.QN.setWidthAsWidthOfDeviceScreen(activity);
            this.QN.setHeight(-1);
            this.QN.showWindowInCustomPosition(0, 0);
        }
    }

    public void aiR() {
        if (this.QN != null) {
            try {
                this.QN.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wV() {
        if (this.cvb != null) {
            this.cvb.wV();
        }
        if (this.cuZ != null) {
            ai.j(this.cuZ, d.e.common_color_10050);
        }
        if (this.QN != null) {
            this.QN.setBackgroundDrawable(ai.getDrawable(d.g.transparent_bg));
        }
    }

    public b aiS() {
        return this.cuJ;
    }
}
