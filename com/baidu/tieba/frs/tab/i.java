package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.fn;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i {
    private MorePopupWindow Su;
    private LinearLayout aZO;
    private a boS;
    private fn bpd;
    private View bpe;
    private SparseArray<f> bpf = new SparseArray<>();
    private f bpg;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void gM(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TextView aHk;
        public ImageView bpj;
        public View bpk;
        public View bpl;
    }

    public i(Context context, a aVar) {
        this.mContext = context;
        this.boS = aVar;
        this.aZO = new LinearLayout(context);
        this.aZO.setOrientation(1);
        this.aZO.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bpe = new View(context);
        this.bpe.setOnClickListener(new j(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.Su == null) {
            this.Su = new MorePopupWindow(activity, this.aZO, view, ar.getDrawable(t.f.transparent_bg), new k(this));
        }
        this.Su.setOnDismissListener(new l(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, fn fnVar) {
        this.bpd = fnVar;
        this.bpg = this.bpf.get(this.bpd.blx);
        if (this.bpg == null) {
            this.bpg = r.gQ(this.bpd.blx);
            this.bpg.a(this.mContext, this);
            this.bpf.put(this.bpd.blx, this.bpg);
        }
        this.bpg.setData(fnVar.bly);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.J(horizontalTabView.getContext());
                int L = com.baidu.adp.lib.util.k.L(horizontalTabView.getContext());
                int RE = this.bpg.RE();
                int measuredHeight = (L - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < RE) {
                    horizontalTabView.getmShowMenuCallBack().gN(RE - measuredHeight);
                }
            }
        }
        this.aZO.removeAllViews();
        this.aZO.addView(this.bpg.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ar.k(this.bpe, t.d.black_alpha40);
        this.aZO.addView(this.bpe, layoutParams);
        a(activity, view, tabItemView);
        if (this.Su != null) {
            this.Su.refresh();
            this.Su.setWidthAsWidthOfDeviceScreen(activity);
            this.Su.setHeight(-1);
            this.Su.showWindowInCustomPosition(0, 0);
        }
    }

    public void RF() {
        if (this.Su != null) {
            com.baidu.adp.lib.h.j.a(this.Su);
        }
    }

    public void xf() {
        if (this.bpg != null) {
            this.bpg.xf();
        }
        if (this.bpe != null) {
            ar.k(this.bpe, t.d.black_alpha40);
        }
        if (this.Su != null) {
            this.Su.setBackgroundDrawable(ar.getDrawable(t.f.transparent_bg));
        }
    }

    public a RG() {
        return this.boS;
    }
}
