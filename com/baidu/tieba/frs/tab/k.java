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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.cp;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k {
    private MorePopupWindow QA;
    private LinearLayout bVP;
    private b cnR;
    private a cnS;
    private cp cof;
    private View cog;
    private SparseArray<g> coh = new SparseArray<>();
    private g coi;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void jh(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView col;

        /* renamed from: com  reason: collision with root package name */
        public View f1com;
        public View con;
        public TextView name;
    }

    public k(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cnR = bVar;
        this.cnS = aVar;
        this.bVP = new LinearLayout(context);
        this.bVP.setOrientation(1);
        this.bVP.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cog = new View(context);
        this.cog.setOnClickListener(new l(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.QA == null) {
            this.QA = new MorePopupWindow(activity, this.bVP, view, as.getDrawable(w.g.transparent_bg), new m(this));
        }
        this.QA.setOnDismissListener(new n(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, cp cpVar) {
        this.cof = cpVar;
        this.coi = this.coh.get(this.cof.ceT);
        if (this.coi == null) {
            this.coi = t.jj(this.cof.ceT);
            this.coi.a(this.mContext, this);
            this.coh.put(this.cof.ceT, this.coi);
        }
        this.coi.setData(cpVar.ceU);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.ae(horizontalTabView.getContext());
                int ag = com.baidu.adp.lib.util.k.ag(horizontalTabView.getContext());
                int ahr = this.coi.ahr();
                int measuredHeight = (ag - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < ahr) {
                    horizontalTabView.getmShowMenuCallBack().iI(ahr - measuredHeight);
                }
            }
        }
        this.bVP.removeAllViews();
        this.bVP.addView(this.coi.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        as.j(this.cog, w.e.common_color_10050);
        this.bVP.addView(this.cog, layoutParams);
        a(activity, view, tabItemView);
        if (this.QA != null) {
            this.QA.refresh();
            this.QA.setWidthAsWidthOfDeviceScreen(activity);
            this.QA.setHeight(-1);
            this.QA.showWindowInCustomPosition(0, 0);
        }
    }

    public void aht() {
        if (this.QA != null) {
            try {
                this.QA.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wK() {
        if (this.coi != null) {
            this.coi.wK();
        }
        if (this.cog != null) {
            as.j(this.cog, w.e.common_color_10050);
        }
        if (this.QA != null) {
            this.QA.setBackgroundDrawable(as.getDrawable(w.g.transparent_bg));
        }
    }

    public b ahu() {
        return this.cnR;
    }
}
