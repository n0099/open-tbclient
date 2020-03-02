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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.at;
/* loaded from: classes9.dex */
public class e {
    private MorePopupWindow cLb;
    private b gJO;
    private a gJP;
    private at gKa;
    private View gKb;
    private SparseArray<com.baidu.tieba.frs.tab.a> gKc = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a gKd;
    private LinearLayout gbA;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void ua(int i);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public TextView cuh;
        public ImageView gKg;
        public View gKh;
        public View gKi;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.gJO = bVar;
        this.gJP = aVar;
        this.gbA = new LinearLayout(context);
        this.gbA.setOrientation(1);
        this.gbA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.gKb = new View(context);
        this.gKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cLb);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.cLb == null) {
            this.cLb = new MorePopupWindow(activity, this.gbA, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azI() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azJ() {
                    if (e.this.cLb != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cLb);
                    }
                }
            });
        }
        this.cLb.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.gJP != null) {
                    e.this.gJP.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.gKa = atVar;
        this.gKd = this.gKc.get(this.gKa.grU);
        if (this.gKd == null) {
            this.gKd = h.ue(this.gKa.grU);
            this.gKd.a(this.mContext, this);
            this.gKc.put(this.gKa.grU, this.gKd);
        }
        this.gKd.setData(atVar.grV);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bJM = this.gKd.bJM();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bJM) {
                    horizontalTabView.getmShowMenuCallBack().ub(bJM - measuredHeight);
                }
            }
        }
        this.gbA.removeAllViews();
        this.gbA.addView(this.gKd.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.gKb, R.color.common_color_10050);
        this.gbA.addView(this.gKb, layoutParams);
        a(activity, view, tabItemView);
        if (this.cLb != null) {
            this.cLb.refresh();
            this.cLb.setWidthAsWidthOfDeviceScreen(activity);
            this.cLb.setHeight(-1);
            this.cLb.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.cLb != null) {
            try {
                this.cLb.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bJO() {
        return this.gJO;
    }
}
