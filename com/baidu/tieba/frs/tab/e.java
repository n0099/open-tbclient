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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.au;
/* loaded from: classes6.dex */
public class e {
    private MorePopupWindow amW;
    private LinearLayout duK;
    private b eeF;
    private a eeG;
    private au eeR;
    private View eeS;
    private SparseArray<com.baidu.tieba.frs.tab.a> eeT = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a eeU;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void nz(int i);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public TextView bPk;
        public ImageView eeX;
        public View eeY;
        public View eeZ;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.eeF = bVar;
        this.eeG = aVar;
        this.duK = new LinearLayout(context);
        this.duK.setOrientation(1);
        this.duK.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.eeS = new View(context);
        this.eeS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.amW);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.amW == null) {
            this.amW = new MorePopupWindow(activity, this.duK, view, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xd() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xe() {
                    if (e.this.amW != null) {
                        com.baidu.adp.lib.g.g.a(e.this.amW);
                    }
                }
            });
        }
        this.amW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.eeG != null) {
                    e.this.eeG.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.eeR = auVar;
        this.eeU = this.eeT.get(this.eeR.dOg);
        if (this.eeU == null) {
            this.eeU = h.nD(this.eeR.dOg);
            this.eeU.a(this.mContext, this);
            this.eeT.put(this.eeR.dOg, this.eeU);
        }
        this.eeU.setData(auVar.dOh);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int aHC = this.eeU.aHC();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aHC) {
                    horizontalTabView.getmShowMenuCallBack().nA(aHC - measuredHeight);
                }
            }
        }
        this.duK.removeAllViews();
        this.duK.addView(this.eeU.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.i(this.eeS, e.d.common_color_10050);
        this.duK.addView(this.eeS, layoutParams);
        a(activity, view, tabItemView);
        if (this.amW != null) {
            this.amW.refresh();
            this.amW.setWidthAsWidthOfDeviceScreen(activity);
            this.amW.setHeight(-1);
            this.amW.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.amW != null) {
            try {
                this.amW.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b aHE() {
        return this.eeF;
    }
}
