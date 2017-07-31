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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.at;
/* loaded from: classes.dex */
public class e {
    private MorePopupWindow Sm;
    private LinearLayout cbH;
    private b cwb;
    private a cwc;
    private at cwq;
    private View cwr;
    private SparseArray<com.baidu.tieba.frs.tab.a> cws = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cwt;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void jq(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView cww;
        public View cwx;
        public View cwy;
        public TextView name;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cwb = bVar;
        this.cwc = aVar;
        this.cbH = new LinearLayout(context);
        this.cbH.setOrientation(1);
        this.cbH.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cwr = new View(context);
        this.cwr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.Sm);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.Sm == null) {
            this.Sm = new MorePopupWindow(activity, this.cbH, view, ai.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void ot() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void ou() {
                    if (e.this.Sm != null) {
                        com.baidu.adp.lib.g.g.a(e.this.Sm);
                    }
                }
            });
        }
        this.Sm.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cwc != null) {
                    e.this.cwc.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.cwq = atVar;
        this.cwt = this.cws.get(this.cwq.clN);
        if (this.cwt == null) {
            this.cwt = h.js(this.cwq.clN);
            this.cwt.a(this.mContext, this);
            this.cws.put(this.cwq.clN, this.cwt);
        }
        this.cwt.setData(atVar.clO);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                k.af(horizontalTabView.getContext());
                int ah = k.ah(horizontalTabView.getContext());
                int ajb = this.cwt.ajb();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < ajb) {
                    horizontalTabView.getmShowMenuCallBack().iS(ajb - measuredHeight);
                }
            }
        }
        this.cbH.removeAllViews();
        this.cbH.addView(this.cwt.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ai.j(this.cwr, d.e.common_color_10050);
        this.cbH.addView(this.cwr, layoutParams);
        a(activity, view, tabItemView);
        if (this.Sm != null) {
            this.Sm.refresh();
            this.Sm.setWidthAsWidthOfDeviceScreen(activity);
            this.Sm.setHeight(-1);
            this.Sm.showWindowInCustomPosition(0, 0);
        }
    }

    public void ajd() {
        if (this.Sm != null) {
            try {
                this.Sm.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void xd() {
        if (this.cwt != null) {
            this.cwt.xd();
        }
        if (this.cwr != null) {
            ai.j(this.cwr, d.e.common_color_10050);
        }
        if (this.Sm != null) {
            this.Sm.setBackgroundDrawable(ai.getDrawable(d.g.transparent_bg));
        }
    }

    public b aje() {
        return this.cwb;
    }
}
