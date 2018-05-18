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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.as;
/* loaded from: classes2.dex */
public class e {
    private MorePopupWindow Tr;
    private LinearLayout cMv;
    private b dpT;
    private a dpU;
    private as dqf;
    private View dqg;
    private SparseArray<com.baidu.tieba.frs.tab.a> dqh = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a dqi;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void lf(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView bmc;
        public ImageView dql;
        public View dqm;
        public View dqn;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.dpT = bVar;
        this.dpU = aVar;
        this.cMv = new LinearLayout(context);
        this.cMv.setOrientation(1);
        this.cMv.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.dqg = new View(context);
        this.dqg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.adp.lib.g.g.a(e.this.Tr);
            }
        });
    }

    private void a(Activity activity, View view2, final TabItemView tabItemView) {
        if (this.Tr == null) {
            this.Tr = new MorePopupWindow(activity, this.cMv, view2, ak.getDrawable(d.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void pt() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void pu() {
                    if (e.this.Tr != null) {
                        com.baidu.adp.lib.g.g.a(e.this.Tr);
                    }
                }
            });
        }
        this.Tr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.dpU != null) {
                    e.this.dpU.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view2, TabItemView tabItemView, as asVar) {
        this.dqf = asVar;
        this.dqi = this.dqh.get(this.dqf.dbi);
        if (this.dqi == null) {
            this.dqi = h.lj(this.dqf.dbi);
            this.dqi.a(this.mContext, this);
            this.dqh.put(this.dqf.dbi, this.dqi);
        }
        this.dqi.setData(asVar.dbj);
        if (view2 instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view2;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ag(horizontalTabView.getContext());
                int ah = l.ah(horizontalTabView.getContext());
                int auJ = this.dqi.auJ();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < auJ) {
                    horizontalTabView.getmShowMenuCallBack().lg(auJ - measuredHeight);
                }
            }
        }
        this.cMv.removeAllViews();
        this.cMv.addView(this.dqi.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ak.i(this.dqg, d.C0126d.common_color_10050);
        this.cMv.addView(this.dqg, layoutParams);
        a(activity, view2, tabItemView);
        if (this.Tr != null) {
            this.Tr.refresh();
            this.Tr.setWidthAsWidthOfDeviceScreen(activity);
            this.Tr.setHeight(-1);
            this.Tr.showWindowInCustomPosition(0, 0);
        }
    }

    public void auL() {
        if (this.Tr != null) {
            try {
                this.Tr.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b auM() {
        return this.dpT;
    }
}
