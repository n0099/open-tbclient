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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.bg;
/* loaded from: classes22.dex */
public class e {
    private MorePopupWindow eha;
    private b iNL;
    private a iNM;
    private bg iNX;
    private View iNY;
    private SparseArray<com.baidu.tieba.frs.tab.a> iNZ = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a iOa;
    private LinearLayout ibY;
    private Context mContext;

    /* loaded from: classes22.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes22.dex */
    public interface b {
        void zG(int i);
    }

    /* loaded from: classes22.dex */
    public static class c {
        public TextView dNo;
        public ImageView iOd;
        public View iOe;
        public View iOf;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.iNL = bVar;
        this.iNM = aVar;
        this.ibY = new LinearLayout(context);
        this.ibY.setOrientation(1);
        this.ibY.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.iNY = new View(context);
        this.iNY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eha);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.eha == null) {
            this.eha = new MorePopupWindow(activity, this.ibY, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bfe() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bff() {
                    if (e.this.eha != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eha);
                    }
                }
            });
        }
        this.eha.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.iNM != null) {
                    e.this.iNM.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bg bgVar) {
        this.iNX = bgVar;
        this.iOa = this.iNZ.get(this.iNX.itx);
        if (this.iOa == null) {
            this.iOa = h.zK(this.iNX.itx);
            this.iOa.a(this.mContext, this);
            this.iNZ.put(this.iNX.itx, this.iOa);
        }
        this.iOa.setData(bgVar.ity);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int czk = this.iOa.czk();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < czk) {
                    horizontalTabView.getmShowMenuCallBack().zH(czk - measuredHeight);
                }
            }
        }
        this.ibY.removeAllViews();
        this.ibY.addView(this.iOa.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.iNY, R.color.common_color_10050);
        this.ibY.addView(this.iNY, layoutParams);
        a(activity, view, tabItemView);
        if (this.eha != null) {
            this.eha.refresh();
            this.eha.setWidthAsWidthOfDeviceScreen(activity);
            this.eha.setHeight(-1);
            this.eha.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.eha != null) {
            try {
                this.eha.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b czm() {
        return this.iNL;
    }
}
