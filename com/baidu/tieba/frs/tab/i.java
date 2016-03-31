package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.fv;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i {
    private MorePopupWindow PS;
    private LinearLayout bez;
    private b btT;
    private a btU;
    private fv buf;
    private View bug;
    private SparseArray<f> buh = new SparseArray<>();
    private f bui;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void he(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aKg;
        public ImageView bul;
        public View bum;
        public View bun;
    }

    public i(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.btT = bVar;
        this.btU = aVar;
        this.bez = new LinearLayout(context);
        this.bez.setOrientation(1);
        this.bez.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bug = new View(context);
        this.bug.setOnClickListener(new j(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.PS == null) {
            this.PS = new MorePopupWindow(activity, this.bez, view, at.getDrawable(t.f.transparent_bg), new k(this));
        }
        this.PS.setOnDismissListener(new l(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, fv fvVar) {
        this.buf = fvVar;
        this.bui = this.buh.get(this.buf.bqP);
        if (this.bui == null) {
            this.bui = r.hi(this.buf.bqP);
            this.bui.a(this.mContext, this);
            this.buh.put(this.buf.bqP, this.bui);
        }
        this.bui.setData(fvVar.bqQ);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.A(horizontalTabView.getContext());
                int C = com.baidu.adp.lib.util.k.C(horizontalTabView.getContext());
                int Ts = this.bui.Ts();
                int measuredHeight = (C - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < Ts) {
                    horizontalTabView.getmShowMenuCallBack().hf(Ts - measuredHeight);
                }
            }
        }
        this.bez.removeAllViews();
        this.bez.addView(this.bui.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        at.k(this.bug, t.d.black_alpha40);
        this.bez.addView(this.bug, layoutParams);
        a(activity, view, tabItemView);
        if (this.PS != null) {
            this.PS.refresh();
            this.PS.setWidthAsWidthOfDeviceScreen(activity);
            this.PS.setHeight(-1);
            this.PS.showWindowInCustomPosition(0, 0);
        }
    }

    public void Tt() {
        if (this.PS != null) {
            try {
                this.PS.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void xy() {
        if (this.bui != null) {
            this.bui.xy();
        }
        if (this.bug != null) {
            at.k(this.bug, t.d.black_alpha40);
        }
        if (this.PS != null) {
            this.PS.setBackgroundDrawable(at.getDrawable(t.f.transparent_bg));
        }
    }

    public b Tu() {
        return this.btT;
    }
}
