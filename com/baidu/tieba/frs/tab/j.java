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
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow KJ;
    private LinearLayout ban;
    private b bsQ;
    private a bsR;
    private fu btb;
    private View btc;
    private SparseArray<f> btd = new SparseArray<>();
    private f bte;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void gM(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aGp;
        public ImageView bth;
        public View bti;
        public View btj;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.bsQ = bVar;
        this.bsR = aVar;
        this.ban = new LinearLayout(context);
        this.ban.setOrientation(1);
        this.ban.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.btc = new View(context);
        this.btc.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.KJ == null) {
            this.KJ = new MorePopupWindow(activity, this.ban, view, at.getDrawable(t.f.transparent_bg), new l(this));
        }
        this.KJ.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, fu fuVar) {
        this.btb = fuVar;
        this.bte = this.btd.get(this.btb.bmc);
        if (this.bte == null) {
            this.bte = s.gO(this.btb.bmc);
            this.bte.a(this.mContext, this);
            this.btd.put(this.btb.bmc, this.bte);
        }
        this.bte.setData(fuVar.bmd);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.A(horizontalTabView.getContext());
                int C = com.baidu.adp.lib.util.k.C(horizontalTabView.getContext());
                int Ty = this.bte.Ty();
                int measuredHeight = (C - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < Ty) {
                    horizontalTabView.getmShowMenuCallBack().gy(Ty - measuredHeight);
                }
            }
        }
        this.ban.removeAllViews();
        this.ban.addView(this.bte.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        at.k(this.btc, t.d.black_alpha40);
        this.ban.addView(this.btc, layoutParams);
        a(activity, view, tabItemView);
        if (this.KJ != null) {
            this.KJ.refresh();
            this.KJ.setWidthAsWidthOfDeviceScreen(activity);
            this.KJ.setHeight(-1);
            this.KJ.showWindowInCustomPosition(0, 0);
        }
    }

    public void Tz() {
        if (this.KJ != null) {
            try {
                this.KJ.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void vm() {
        if (this.bte != null) {
            this.bte.vm();
        }
        if (this.btc != null) {
            at.k(this.btc, t.d.black_alpha40);
        }
        if (this.KJ != null) {
            this.KJ.setBackgroundDrawable(at.getDrawable(t.f.transparent_bg));
        }
    }

    public b TA() {
        return this.bsQ;
    }
}
