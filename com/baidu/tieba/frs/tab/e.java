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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.be;
/* loaded from: classes9.dex */
public class e {
    private MorePopupWindow dDF;
    private be hXA;
    private View hXB;
    private SparseArray<com.baidu.tieba.frs.tab.a> hXC = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a hXD;
    private b hXo;
    private a hXp;
    private LinearLayout hmU;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void vQ(int i);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public TextView djl;
        public ImageView hXG;
        public View hXH;
        public View hXI;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.hXo = bVar;
        this.hXp = aVar;
        this.hmU = new LinearLayout(context);
        this.hmU.setOrientation(1);
        this.hmU.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.hXB = new View(context);
        this.hXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dDF);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.dDF == null) {
            this.dDF = new MorePopupWindow(activity, this.hmU, view, an.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aPq() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aPr() {
                    if (e.this.dDF != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dDF);
                    }
                }
            });
        }
        this.dDF.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.hXp != null) {
                    e.this.hXp.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, be beVar) {
        this.hXA = beVar;
        this.hXD = this.hXC.get(this.hXA.hDU);
        if (this.hXD == null) {
            this.hXD = h.vU(this.hXA.hDU);
            this.hXD.a(this.mContext, this);
            this.hXC.put(this.hXA.hDU, this.hXD);
        }
        this.hXD.setData(beVar.hDV);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cet = this.hXD.cet();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cet) {
                    horizontalTabView.getmShowMenuCallBack().vR(cet - measuredHeight);
                }
            }
        }
        this.hmU.removeAllViews();
        this.hmU.addView(this.hXD.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        an.setBackgroundResource(this.hXB, R.color.common_color_10050);
        this.hmU.addView(this.hXB, layoutParams);
        a(activity, view, tabItemView);
        if (this.dDF != null) {
            this.dDF.refresh();
            this.dDF.setWidthAsWidthOfDeviceScreen(activity);
            this.dDF.setHeight(-1);
            this.dDF.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.dDF != null) {
            try {
                this.dDF.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cev() {
        return this.hXo;
    }
}
