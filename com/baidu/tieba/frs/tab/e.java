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
    private MorePopupWindow Sp;
    private LinearLayout ccu;
    private b cye;
    private a cyf;
    private at cyr;
    private View cys;
    private SparseArray<com.baidu.tieba.frs.tab.a> cyt = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cyu;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void jA(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView cyx;
        public View cyy;
        public View cyz;
        public TextView name;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cye = bVar;
        this.cyf = aVar;
        this.ccu = new LinearLayout(context);
        this.ccu.setOrientation(1);
        this.ccu.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cys = new View(context);
        this.cys.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.Sp);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.Sp == null) {
            this.Sp = new MorePopupWindow(activity, this.ccu, view, ai.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void ou() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void ov() {
                    if (e.this.Sp != null) {
                        com.baidu.adp.lib.g.g.a(e.this.Sp);
                    }
                }
            });
        }
        this.Sp.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cyf != null) {
                    e.this.cyf.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.cyr = atVar;
        this.cyu = this.cyt.get(this.cyr.cmA);
        if (this.cyu == null) {
            this.cyu = h.jC(this.cyr.cmA);
            this.cyu.a(this.mContext, this);
            this.cyt.put(this.cyr.cmA, this.cyu);
        }
        this.cyu.setData(atVar.cmB);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                k.af(horizontalTabView.getContext());
                int ah = k.ah(horizontalTabView.getContext());
                int ajC = this.cyu.ajC();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < ajC) {
                    horizontalTabView.getmShowMenuCallBack().iU(ajC - measuredHeight);
                }
            }
        }
        this.ccu.removeAllViews();
        this.ccu.addView(this.cyu.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ai.j(this.cys, d.e.common_color_10050);
        this.ccu.addView(this.cys, layoutParams);
        a(activity, view, tabItemView);
        if (this.Sp != null) {
            this.Sp.refresh();
            this.Sp.setWidthAsWidthOfDeviceScreen(activity);
            this.Sp.setHeight(-1);
            this.Sp.showWindowInCustomPosition(0, 0);
        }
    }

    public void ajE() {
        if (this.Sp != null) {
            try {
                this.Sp.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void xd() {
        if (this.cyu != null) {
            this.cyu.xd();
        }
        if (this.cys != null) {
            ai.j(this.cys, d.e.common_color_10050);
        }
        if (this.Sp != null) {
            this.Sp.setBackgroundDrawable(ai.getDrawable(d.g.transparent_bg));
        }
    }

    public b ajF() {
        return this.cye;
    }
}
