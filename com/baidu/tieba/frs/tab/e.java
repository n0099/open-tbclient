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
    private MorePopupWindow bUr;
    private SparseArray<com.baidu.tieba.frs.tab.a> fQA = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a fQB;
    private b fQm;
    private a fQn;
    private as fQy;
    private View fQz;
    private LinearLayout fhN;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void rJ(int i);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public TextView bFm;
        public ImageView fQE;
        public View fQF;
        public View fQG;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.fQm = bVar;
        this.fQn = aVar;
        this.fhN = new LinearLayout(context);
        this.fhN.setOrientation(1);
        this.fhN.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.fQz = new View(context);
        this.fQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.dismissPopupWindow(e.this.bUr);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.bUr == null) {
            this.bUr = new MorePopupWindow(activity, this.fhN, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void agh() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void agi() {
                    if (e.this.bUr != null) {
                        com.baidu.adp.lib.g.g.dismissPopupWindow(e.this.bUr);
                    }
                }
            });
        }
        this.bUr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.fQn != null) {
                    e.this.fQn.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.fQy = asVar;
        this.fQB = this.fQA.get(this.fQy.fyl);
        if (this.fQB == null) {
            this.fQB = h.rN(this.fQy.fyl);
            this.fQB.a(this.mContext, this);
            this.fQA.put(this.fQy.fyl, this.fQB);
        }
        this.fQB.setData(asVar.fym);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bpK = this.fQB.bpK();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bpK) {
                    horizontalTabView.getmShowMenuCallBack().rK(bpK - measuredHeight);
                }
            }
        }
        this.fhN.removeAllViews();
        this.fhN.addView(this.fQB.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.fQz, R.color.common_color_10050);
        this.fhN.addView(this.fQz, layoutParams);
        a(activity, view, tabItemView);
        if (this.bUr != null) {
            this.bUr.refresh();
            this.bUr.setWidthAsWidthOfDeviceScreen(activity);
            this.bUr.setHeight(-1);
            this.bUr.showWindowInCustomPosition(0, 0);
        }
    }

    public void bpM() {
        if (this.bUr != null) {
            try {
                this.bUr.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bpN() {
        return this.fQm;
    }
}
