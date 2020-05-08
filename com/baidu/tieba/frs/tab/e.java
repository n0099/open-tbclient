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
import com.baidu.tieba.frs.ay;
/* loaded from: classes9.dex */
public class e {
    private MorePopupWindow dkz;
    private LinearLayout gLM;
    private b huC;
    private a huD;
    private ay huO;
    private View huP;
    private SparseArray<com.baidu.tieba.frs.tab.a> huQ = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a huR;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void uD(int i);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public TextView cTw;
        public ImageView huU;
        public View huV;
        public View huW;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.huC = bVar;
        this.huD = aVar;
        this.gLM = new LinearLayout(context);
        this.gLM.setOrientation(1);
        this.gLM.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.huP = new View(context);
        this.huP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dkz);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.dkz == null) {
            this.dkz = new MorePopupWindow(activity, this.gLM, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aHW() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aHX() {
                    if (e.this.dkz != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dkz);
                    }
                }
            });
        }
        this.dkz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.huD != null) {
                    e.this.huD.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, ay ayVar) {
        this.huO = ayVar;
        this.huR = this.huQ.get(this.huO.hci);
        if (this.huR == null) {
            this.huR = h.uH(this.huO.hci);
            this.huR.a(this.mContext, this);
            this.huQ.put(this.huO.hci, this.huR);
        }
        this.huR.setData(ayVar.hcj);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bUv = this.huR.bUv();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bUv) {
                    horizontalTabView.getmShowMenuCallBack().uE(bUv - measuredHeight);
                }
            }
        }
        this.gLM.removeAllViews();
        this.gLM.addView(this.huR.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.huP, R.color.common_color_10050);
        this.gLM.addView(this.huP, layoutParams);
        a(activity, view, tabItemView);
        if (this.dkz != null) {
            this.dkz.refresh();
            this.dkz.setWidthAsWidthOfDeviceScreen(activity);
            this.dkz.setHeight(-1);
            this.dkz.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.dkz != null) {
            try {
                this.dkz.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bUx() {
        return this.huC;
    }
}
