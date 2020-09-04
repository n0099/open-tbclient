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
/* loaded from: classes16.dex */
public class e {
    private MorePopupWindow dSO;
    private LinearLayout hGc;
    private b irC;
    private a irD;
    private bg irO;
    private View irP;
    private SparseArray<com.baidu.tieba.frs.tab.a> irQ = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a irR;
    private Context mContext;

    /* loaded from: classes16.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes16.dex */
    public interface b {
        void yB(int i);
    }

    /* loaded from: classes16.dex */
    public static class c {
        public TextView dzm;
        public ImageView irU;
        public View irV;
        public View irW;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.irC = bVar;
        this.irD = aVar;
        this.hGc = new LinearLayout(context);
        this.hGc.setOrientation(1);
        this.hGc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.irP = new View(context);
        this.irP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dSO);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.dSO == null) {
            this.dSO = new MorePopupWindow(activity, this.hGc, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bbC() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bbD() {
                    if (e.this.dSO != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dSO);
                    }
                }
            });
        }
        this.dSO.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.irD != null) {
                    e.this.irD.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bg bgVar) {
        this.irO = bgVar;
        this.irR = this.irQ.get(this.irO.hXw);
        if (this.irR == null) {
            this.irR = h.yF(this.irO.hXw);
            this.irR.a(this.mContext, this);
            this.irQ.put(this.irO.hXw, this.irR);
        }
        this.irR.setData(bgVar.hXx);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int csy = this.irR.csy();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < csy) {
                    horizontalTabView.getmShowMenuCallBack().yC(csy - measuredHeight);
                }
            }
        }
        this.hGc.removeAllViews();
        this.hGc.addView(this.irR.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.irP, R.color.common_color_10050);
        this.hGc.addView(this.irP, layoutParams);
        a(activity, view, tabItemView);
        if (this.dSO != null) {
            this.dSO.refresh();
            this.dSO.setWidthAsWidthOfDeviceScreen(activity);
            this.dSO.setHeight(-1);
            this.dSO.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.dSO != null) {
            try {
                this.dSO.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b csA() {
        return this.irC;
    }
}
