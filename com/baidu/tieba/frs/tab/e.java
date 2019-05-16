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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.as;
/* loaded from: classes4.dex */
public class e {
    private MorePopupWindow bBr;
    private LinearLayout eYD;
    private b fKe;
    private a fKf;
    private as fKq;
    private View fKr;
    private SparseArray<com.baidu.tieba.frs.tab.a> fKs = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a fKt;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void ss(int i);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public TextView bmf;
        public ImageView fKw;
        public View fKx;
        public View fKy;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.fKe = bVar;
        this.fKf = aVar;
        this.eYD = new LinearLayout(context);
        this.eYD.setOrientation(1);
        this.eYD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.fKr = new View(context);
        this.fKr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.bBr);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.bBr == null) {
            this.bBr = new MorePopupWindow(activity, this.eYD, view, al.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aaA() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aaB() {
                    if (e.this.bBr != null) {
                        com.baidu.adp.lib.g.g.a(e.this.bBr);
                    }
                }
            });
        }
        this.bBr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.fKf != null) {
                    e.this.fKf.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.fKq = asVar;
        this.fKt = this.fKs.get(this.fKq.fsE);
        if (this.fKt == null) {
            this.fKt = h.sw(this.fKq.fsE);
            this.fKt.a(this.mContext, this);
            this.fKs.put(this.fKq.fsE, this.fKt);
        }
        this.fKt.setData(asVar.fsF);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ag(horizontalTabView.getContext());
                int ah = l.ah(horizontalTabView.getContext());
                int bpC = this.fKt.bpC();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bpC) {
                    horizontalTabView.getmShowMenuCallBack().st(bpC - measuredHeight);
                }
            }
        }
        this.eYD.removeAllViews();
        this.eYD.addView(this.fKt.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.k(this.fKr, R.color.common_color_10050);
        this.eYD.addView(this.fKr, layoutParams);
        a(activity, view, tabItemView);
        if (this.bBr != null) {
            this.bBr.refresh();
            this.bBr.setWidthAsWidthOfDeviceScreen(activity);
            this.bBr.setHeight(-1);
            this.bBr.showWindowInCustomPosition(0, 0);
        }
    }

    public void bpE() {
        if (this.bBr != null) {
            try {
                this.bBr.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bpF() {
        return this.fKe;
    }
}
