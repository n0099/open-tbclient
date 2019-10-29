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
import com.baidu.tieba.frs.as;
/* loaded from: classes4.dex */
public class e {
    private MorePopupWindow bVi;
    private b fRd;
    private a fRe;
    private as fRp;
    private View fRq;
    private SparseArray<com.baidu.tieba.frs.tab.a> fRr = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a fRs;
    private LinearLayout fiG;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void rK(int i);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public TextView bGd;
        public ImageView fRv;
        public View fRw;
        public View fRx;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.fRd = bVar;
        this.fRe = aVar;
        this.fiG = new LinearLayout(context);
        this.fiG.setOrientation(1);
        this.fiG.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.fRq = new View(context);
        this.fRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.dismissPopupWindow(e.this.bVi);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.bVi == null) {
            this.bVi = new MorePopupWindow(activity, this.fiG, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void agj() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void agk() {
                    if (e.this.bVi != null) {
                        com.baidu.adp.lib.g.g.dismissPopupWindow(e.this.bVi);
                    }
                }
            });
        }
        this.bVi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.fRe != null) {
                    e.this.fRe.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.fRp = asVar;
        this.fRs = this.fRr.get(this.fRp.fzc);
        if (this.fRs == null) {
            this.fRs = h.rO(this.fRp.fzc);
            this.fRs.a(this.mContext, this);
            this.fRr.put(this.fRp.fzc, this.fRs);
        }
        this.fRs.setData(asVar.fzd);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bpM = this.fRs.bpM();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bpM) {
                    horizontalTabView.getmShowMenuCallBack().rL(bpM - measuredHeight);
                }
            }
        }
        this.fiG.removeAllViews();
        this.fiG.addView(this.fRs.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.fRq, R.color.common_color_10050);
        this.fiG.addView(this.fRq, layoutParams);
        a(activity, view, tabItemView);
        if (this.bVi != null) {
            this.bVi.refresh();
            this.bVi.setWidthAsWidthOfDeviceScreen(activity);
            this.bVi.setHeight(-1);
            this.bVi.showWindowInCustomPosition(0, 0);
        }
    }

    public void bpO() {
        if (this.bVi != null) {
            try {
                this.bVi.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bpP() {
        return this.fRd;
    }
}
