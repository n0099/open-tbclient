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
    private MorePopupWindow cLc;
    private b gKa;
    private a gKb;
    private at gKm;
    private View gKn;
    private SparseArray<com.baidu.tieba.frs.tab.a> gKo = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a gKp;
    private LinearLayout gbN;
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
        public TextView cui;
        public ImageView gKs;
        public View gKt;
        public View gKu;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.gKa = bVar;
        this.gKb = aVar;
        this.gbN = new LinearLayout(context);
        this.gbN.setOrientation(1);
        this.gbN.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.gKn = new View(context);
        this.gKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cLc);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.cLc == null) {
            this.cLc = new MorePopupWindow(activity, this.gbN, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azI() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azJ() {
                    if (e.this.cLc != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cLc);
                    }
                }
            });
        }
        this.cLc.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.gKb != null) {
                    e.this.gKb.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.gKm = atVar;
        this.gKp = this.gKo.get(this.gKm.gsh);
        if (this.gKp == null) {
            this.gKp = h.ue(this.gKm.gsh);
            this.gKp.a(this.mContext, this);
            this.gKo.put(this.gKm.gsh, this.gKp);
        }
        this.gKp.setData(atVar.gsi);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bJN = this.gKp.bJN();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bJN) {
                    horizontalTabView.getmShowMenuCallBack().ub(bJN - measuredHeight);
                }
            }
        }
        this.gbN.removeAllViews();
        this.gbN.addView(this.gKp.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.gKn, R.color.common_color_10050);
        this.gbN.addView(this.gKn, layoutParams);
        a(activity, view, tabItemView);
        if (this.cLc != null) {
            this.cLc.refresh();
            this.cLc.setWidthAsWidthOfDeviceScreen(activity);
            this.cLc.setHeight(-1);
            this.cLc.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.cLc != null) {
            try {
                this.cLc.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bJP() {
        return this.gKa;
    }
}
