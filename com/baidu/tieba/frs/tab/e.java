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
    private MorePopupWindow bBt;
    private LinearLayout eYE;
    private b fKh;
    private a fKi;
    private as fKt;
    private View fKu;
    private SparseArray<com.baidu.tieba.frs.tab.a> fKv = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a fKw;
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
        public View fKA;
        public View fKB;
        public ImageView fKz;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.fKh = bVar;
        this.fKi = aVar;
        this.eYE = new LinearLayout(context);
        this.eYE.setOrientation(1);
        this.eYE.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.fKu = new View(context);
        this.fKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.bBt);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.bBt == null) {
            this.bBt = new MorePopupWindow(activity, this.eYE, view, al.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aaA() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aaB() {
                    if (e.this.bBt != null) {
                        com.baidu.adp.lib.g.g.a(e.this.bBt);
                    }
                }
            });
        }
        this.bBt.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.fKi != null) {
                    e.this.fKi.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.fKt = asVar;
        this.fKw = this.fKv.get(this.fKt.fsF);
        if (this.fKw == null) {
            this.fKw = h.sw(this.fKt.fsF);
            this.fKw.a(this.mContext, this);
            this.fKv.put(this.fKt.fsF, this.fKw);
        }
        this.fKw.setData(asVar.fsG);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ag(horizontalTabView.getContext());
                int ah = l.ah(horizontalTabView.getContext());
                int bpH = this.fKw.bpH();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bpH) {
                    horizontalTabView.getmShowMenuCallBack().st(bpH - measuredHeight);
                }
            }
        }
        this.eYE.removeAllViews();
        this.eYE.addView(this.fKw.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.k(this.fKu, R.color.common_color_10050);
        this.eYE.addView(this.fKu, layoutParams);
        a(activity, view, tabItemView);
        if (this.bBt != null) {
            this.bBt.refresh();
            this.bBt.setWidthAsWidthOfDeviceScreen(activity);
            this.bBt.setHeight(-1);
            this.bBt.showWindowInCustomPosition(0, 0);
        }
    }

    public void bpJ() {
        if (this.bBt != null) {
            try {
                this.bBt.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bpK() {
        return this.fKh;
    }
}
