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
    private MorePopupWindow RC;
    private au cGF;
    private View cGG;
    private SparseArray<com.baidu.tieba.frs.tab.a> cGH = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a cGI;
    private b cGs;
    private a cGt;
    private LinearLayout cfX;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void jY(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView cGL;
        public View cGM;
        public View cGN;
        public TextView name;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cGs = bVar;
        this.cGt = aVar;
        this.cfX = new LinearLayout(context);
        this.cfX.setOrientation(1);
        this.cfX.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cGG = new View(context);
        this.cGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.RC);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.RC == null) {
            this.RC = new MorePopupWindow(activity, this.cfX, view, aj.getDrawable(d.g.transparent_bg), new d.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.d.a
                public void op() {
                }

                @Override // com.baidu.tbadk.core.view.d.a
                public void oq() {
                    if (e.this.RC != null) {
                        com.baidu.adp.lib.g.g.a(e.this.RC);
                    }
                }
            });
        }
        this.RC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.cGt != null) {
                    e.this.cGt.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.cGF = auVar;
        this.cGI = this.cGH.get(this.cGF.cto);
        if (this.cGI == null) {
            this.cGI = h.ka(this.cGF.cto);
            this.cGI.a(this.mContext, this);
            this.cGH.put(this.cGF.cto, this.cGI);
        }
        this.cGI.setData(auVar.ctp);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ae(horizontalTabView.getContext());
                int af = l.af(horizontalTabView.getContext());
                int alB = this.cGI.alB();
                int measuredHeight = (af - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < alB) {
                    horizontalTabView.getmShowMenuCallBack().jt(alB - measuredHeight);
                }
            }
        }
        this.cfX.removeAllViews();
        this.cfX.addView(this.cGI.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aj.j(this.cGG, d.e.common_color_10050);
        this.cfX.addView(this.cGG, layoutParams);
        a(activity, view, tabItemView);
        if (this.RC != null) {
            this.RC.refresh();
            this.RC.setWidthAsWidthOfDeviceScreen(activity);
            this.RC.setHeight(-1);
            this.RC.showWindowInCustomPosition(0, 0);
        }
    }

    public void alD() {
        if (this.RC != null) {
            try {
                this.RC.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wB() {
        if (this.cGI != null) {
            this.cGI.wB();
        }
        if (this.cGG != null) {
            aj.j(this.cGG, d.e.common_color_10050);
        }
        if (this.RC != null) {
            this.RC.setBackgroundDrawable(aj.getDrawable(d.g.transparent_bg));
        }
    }

    public b alE() {
        return this.cGs;
    }
}
