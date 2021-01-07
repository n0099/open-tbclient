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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.bd;
/* loaded from: classes2.dex */
public class e {
    private MorePopupWindow eKn;
    private LinearLayout iSr;
    private b jGP;
    private a jGQ;
    private bd jHb;
    private View jHc;
    private SparseArray<com.baidu.tieba.frs.tab.a> jHd = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a jHe;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void BK(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView epX;
        public ImageView jHh;
        public View jHi;
        public View jHj;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.jGP = bVar;
        this.jGQ = aVar;
        this.iSr = new LinearLayout(context);
        this.iSr.setOrientation(1);
        this.iSr.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jHc = new View(context);
        this.jHc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eKn);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.eKn == null) {
            this.eKn = new MorePopupWindow(activity, this.iSr, view, ao.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bol() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bom() {
                    if (e.this.eKn != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eKn);
                    }
                }
            });
        }
        this.eKn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.jGQ != null) {
                    e.this.jGQ.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bd bdVar) {
        this.jHb = bdVar;
        this.jHe = this.jHd.get(this.jHb.jjJ);
        if (this.jHe == null) {
            this.jHe = h.BO(this.jHb.jjJ);
            this.jHe.a(this.mContext, this);
            this.jHd.put(this.jHb.jjJ, this.jHe);
        }
        this.jHe.setData(bdVar.jjK);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cMM = this.jHe.cMM();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cMM) {
                    horizontalTabView.getmShowMenuCallBack().BL(cMM - measuredHeight);
                }
            }
        }
        this.iSr.removeAllViews();
        this.iSr.addView(this.jHe.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ao.setBackgroundResource(this.jHc, R.color.common_color_10050);
        this.iSr.addView(this.jHc, layoutParams);
        a(activity, view, tabItemView);
        if (this.eKn != null) {
            this.eKn.refresh();
            this.eKn.setWidthAsWidthOfDeviceScreen(activity);
            this.eKn.setHeight(-1);
            this.eKn.showWindowInCustomPosition(0, 0);
        }
    }

    public void cMO() {
        if (this.eKn != null) {
            try {
                this.eKn.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cMP() {
        return this.jGP;
    }
}
