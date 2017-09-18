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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.at;
/* loaded from: classes.dex */
public class e {
    private MorePopupWindow Rq;
    private a cFA;
    private at cFM;
    private View cFN;
    private SparseArray<com.baidu.tieba.frs.tab.a> cFO = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cFP;
    private b cFz;
    private LinearLayout cgJ;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void jQ(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView cFS;
        public View cFT;
        public View cFU;
        public TextView name;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cFz = bVar;
        this.cFA = aVar;
        this.cgJ = new LinearLayout(context);
        this.cgJ.setOrientation(1);
        this.cgJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cFN = new View(context);
        this.cFN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.Rq);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.Rq == null) {
            this.Rq = new MorePopupWindow(activity, this.cgJ, view, aj.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void oo() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void op() {
                    if (e.this.Rq != null) {
                        com.baidu.adp.lib.g.g.a(e.this.Rq);
                    }
                }
            });
        }
        this.Rq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cFA != null) {
                    e.this.cFA.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.cFM = atVar;
        this.cFP = this.cFO.get(this.cFM.csM);
        if (this.cFP == null) {
            this.cFP = h.jS(this.cFM.csM);
            this.cFP.a(this.mContext, this);
            this.cFO.put(this.cFM.csM, this.cFP);
        }
        this.cFP.setData(atVar.csN);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                k.ad(horizontalTabView.getContext());
                int af = k.af(horizontalTabView.getContext());
                int alx = this.cFP.alx();
                int measuredHeight = (af - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < alx) {
                    horizontalTabView.getmShowMenuCallBack().jk(alx - measuredHeight);
                }
            }
        }
        this.cgJ.removeAllViews();
        this.cgJ.addView(this.cFP.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aj.j(this.cFN, d.e.common_color_10050);
        this.cgJ.addView(this.cFN, layoutParams);
        a(activity, view, tabItemView);
        if (this.Rq != null) {
            this.Rq.refresh();
            this.Rq.setWidthAsWidthOfDeviceScreen(activity);
            this.Rq.setHeight(-1);
            this.Rq.showWindowInCustomPosition(0, 0);
        }
    }

    public void alz() {
        if (this.Rq != null) {
            try {
                this.Rq.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void xc() {
        if (this.cFP != null) {
            this.cFP.xc();
        }
        if (this.cFN != null) {
            aj.j(this.cFN, d.e.common_color_10050);
        }
        if (this.Rq != null) {
            this.Rq.setBackgroundDrawable(aj.getDrawable(d.g.transparent_bg));
        }
    }

    public b alA() {
        return this.cFz;
    }
}
