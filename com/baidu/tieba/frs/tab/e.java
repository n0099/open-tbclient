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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.au;
/* loaded from: classes.dex */
public class e {
    private MorePopupWindow Sq;
    private b cZc;
    private a cZd;
    private au cZp;
    private View cZq;
    private SparseArray<com.baidu.tieba.frs.tab.a> cZr = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cZs;
    private LinearLayout cwl;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void kR(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aWQ;
        public ImageView cZv;
        public View cZw;
        public View cZx;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cZc = bVar;
        this.cZd = aVar;
        this.cwl = new LinearLayout(context);
        this.cwl.setOrientation(1);
        this.cwl.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cZq = new View(context);
        this.cZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.Sq);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.Sq == null) {
            this.Sq = new MorePopupWindow(activity, this.cwl, view, aj.getDrawable(d.f.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void ow() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void ox() {
                    if (e.this.Sq != null) {
                        com.baidu.adp.lib.g.g.a(e.this.Sq);
                    }
                }
            });
        }
        this.Sq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cZd != null) {
                    e.this.cZd.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.cZp = auVar;
        this.cZs = this.cZr.get(this.cZp.cJW);
        if (this.cZs == null) {
            this.cZs = h.kT(this.cZp.cJW);
            this.cZs.a(this.mContext, this);
            this.cZr.put(this.cZp.cJW, this.cZs);
        }
        this.cZs.setData(auVar.cJX);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ad(horizontalTabView.getContext());
                int ae = l.ae(horizontalTabView.getContext());
                int aqq = this.cZs.aqq();
                int measuredHeight = (ae - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aqq) {
                    horizontalTabView.getmShowMenuCallBack().kg(aqq - measuredHeight);
                }
            }
        }
        this.cwl.removeAllViews();
        this.cwl.addView(this.cZs.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aj.j(this.cZq, d.C0082d.common_color_10050);
        this.cwl.addView(this.cZq, layoutParams);
        a(activity, view, tabItemView);
        if (this.Sq != null) {
            this.Sq.refresh();
            this.Sq.setWidthAsWidthOfDeviceScreen(activity);
            this.Sq.setHeight(-1);
            this.Sq.showWindowInCustomPosition(0, 0);
        }
    }

    public void aqs() {
        if (this.Sq != null) {
            try {
                this.Sq.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wE() {
        if (this.cZs != null) {
            this.cZs.wE();
        }
        if (this.cZq != null) {
            aj.j(this.cZq, d.C0082d.common_color_10050);
        }
        if (this.Sq != null) {
            this.Sq.setBackgroundDrawable(aj.getDrawable(d.f.transparent_bg));
        }
    }

    public b aqt() {
        return this.cZc;
    }
}
