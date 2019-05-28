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
    private LinearLayout eYE;
    private b fKf;
    private a fKg;
    private as fKr;
    private View fKs;
    private SparseArray<com.baidu.tieba.frs.tab.a> fKt = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a fKu;
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
        public ImageView fKx;
        public View fKy;
        public View fKz;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.fKf = bVar;
        this.fKg = aVar;
        this.eYE = new LinearLayout(context);
        this.eYE.setOrientation(1);
        this.eYE.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.fKs = new View(context);
        this.fKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.bBr);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.bBr == null) {
            this.bBr = new MorePopupWindow(activity, this.eYE, view, al.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
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
                if (e.this.fKg != null) {
                    e.this.fKg.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.fKr = asVar;
        this.fKu = this.fKt.get(this.fKr.fsF);
        if (this.fKu == null) {
            this.fKu = h.sw(this.fKr.fsF);
            this.fKu.a(this.mContext, this);
            this.fKt.put(this.fKr.fsF, this.fKu);
        }
        this.fKu.setData(asVar.fsG);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ag(horizontalTabView.getContext());
                int ah = l.ah(horizontalTabView.getContext());
                int bpF = this.fKu.bpF();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bpF) {
                    horizontalTabView.getmShowMenuCallBack().st(bpF - measuredHeight);
                }
            }
        }
        this.eYE.removeAllViews();
        this.eYE.addView(this.fKu.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.k(this.fKs, R.color.common_color_10050);
        this.eYE.addView(this.fKs, layoutParams);
        a(activity, view, tabItemView);
        if (this.bBr != null) {
            this.bBr.refresh();
            this.bBr.setWidthAsWidthOfDeviceScreen(activity);
            this.bBr.setHeight(-1);
            this.bBr.showWindowInCustomPosition(0, 0);
        }
    }

    public void bpH() {
        if (this.bBr != null) {
            try {
                this.bBr.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bpI() {
        return this.fKf;
    }
}
