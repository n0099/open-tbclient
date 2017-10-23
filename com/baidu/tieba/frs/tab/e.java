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
    private MorePopupWindow Rq;
    private b cGg;
    private a cGh;
    private au cGt;
    private View cGu;
    private SparseArray<com.baidu.tieba.frs.tab.a> cGv = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cGw;
    private LinearLayout cfL;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void jX(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public View cGA;
        public View cGB;
        public ImageView cGz;
        public TextView name;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cGg = bVar;
        this.cGh = aVar;
        this.cfL = new LinearLayout(context);
        this.cfL.setOrientation(1);
        this.cfL.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cGu = new View(context);
        this.cGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.Rq);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.Rq == null) {
            this.Rq = new MorePopupWindow(activity, this.cfL, view, aj.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void oi() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void oj() {
                    if (e.this.Rq != null) {
                        com.baidu.adp.lib.g.g.a(e.this.Rq);
                    }
                }
            });
        }
        this.Rq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cGh != null) {
                    e.this.cGh.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.cGt = auVar;
        this.cGw = this.cGv.get(this.cGt.ctc);
        if (this.cGw == null) {
            this.cGw = h.jZ(this.cGt.ctc);
            this.cGw.a(this.mContext, this);
            this.cGv.put(this.cGt.ctc, this.cGw);
        }
        this.cGw.setData(auVar.ctd);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ae(horizontalTabView.getContext());
                int af = l.af(horizontalTabView.getContext());
                int alw = this.cGw.alw();
                int measuredHeight = (af - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < alw) {
                    horizontalTabView.getmShowMenuCallBack().js(alw - measuredHeight);
                }
            }
        }
        this.cfL.removeAllViews();
        this.cfL.addView(this.cGw.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aj.j(this.cGu, d.e.common_color_10050);
        this.cfL.addView(this.cGu, layoutParams);
        a(activity, view, tabItemView);
        if (this.Rq != null) {
            this.Rq.refresh();
            this.Rq.setWidthAsWidthOfDeviceScreen(activity);
            this.Rq.setHeight(-1);
            this.Rq.showWindowInCustomPosition(0, 0);
        }
    }

    public void aly() {
        if (this.Rq != null) {
            try {
                this.Rq.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wu() {
        if (this.cGw != null) {
            this.cGw.wu();
        }
        if (this.cGu != null) {
            aj.j(this.cGu, d.e.common_color_10050);
        }
        if (this.Rq != null) {
            this.Rq.setBackgroundDrawable(aj.getDrawable(d.g.transparent_bg));
        }
    }

    public b alz() {
        return this.cGg;
    }
}
