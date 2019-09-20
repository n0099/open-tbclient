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
    private MorePopupWindow bCN;
    private b fRK;
    private a fRL;
    private as fRW;
    private View fRX;
    private SparseArray<com.baidu.tieba.frs.tab.a> fRY = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a fRZ;
    private LinearLayout ffS;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void sQ(int i);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public TextView bnr;
        public ImageView fSc;
        public View fSd;
        public View fSe;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.fRK = bVar;
        this.fRL = aVar;
        this.ffS = new LinearLayout(context);
        this.ffS.setOrientation(1);
        this.ffS.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.fRX = new View(context);
        this.fRX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.bCN);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.bCN == null) {
            this.bCN = new MorePopupWindow(activity, this.ffS, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void abD() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void abE() {
                    if (e.this.bCN != null) {
                        com.baidu.adp.lib.g.g.a(e.this.bCN);
                    }
                }
            });
        }
        this.bCN.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.fRL != null) {
                    e.this.fRL.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.fRW = asVar;
        this.fRZ = this.fRY.get(this.fRW.fzN);
        if (this.fRZ == null) {
            this.fRZ = h.sU(this.fRW.fzN);
            this.fRZ.a(this.mContext, this);
            this.fRY.put(this.fRW.fzN, this.fRZ);
        }
        this.fRZ.setData(asVar.fzO);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ag(horizontalTabView.getContext());
                int ah = l.ah(horizontalTabView.getContext());
                int bsI = this.fRZ.bsI();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bsI) {
                    horizontalTabView.getmShowMenuCallBack().sR(bsI - measuredHeight);
                }
            }
        }
        this.ffS.removeAllViews();
        this.ffS.addView(this.fRZ.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.k(this.fRX, R.color.common_color_10050);
        this.ffS.addView(this.fRX, layoutParams);
        a(activity, view, tabItemView);
        if (this.bCN != null) {
            this.bCN.refresh();
            this.bCN.setWidthAsWidthOfDeviceScreen(activity);
            this.bCN.setHeight(-1);
            this.bCN.showWindowInCustomPosition(0, 0);
        }
    }

    public void bsK() {
        if (this.bCN != null) {
            try {
                this.bCN.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bsL() {
        return this.fRK;
    }
}
