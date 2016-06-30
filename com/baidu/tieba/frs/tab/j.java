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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.dz;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow KJ;
    private dz bQF;
    private View bQG;
    private SparseArray<f> bQH = new SparseArray<>();
    private f bQI;
    private b bQu;
    private a bQv;
    private LinearLayout bwk;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void hR(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aGR;
        public ImageView bQL;
        public View bQM;
        public View bQN;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.bQu = bVar;
        this.bQv = aVar;
        this.bwk = new LinearLayout(context);
        this.bwk.setOrientation(1);
        this.bwk.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bQG = new View(context);
        this.bQG.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.KJ == null) {
            this.KJ = new MorePopupWindow(activity, this.bwk, view, av.getDrawable(u.f.transparent_bg), new l(this));
        }
        this.KJ.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, dz dzVar) {
        this.bQF = dzVar;
        this.bQI = this.bQH.get(this.bQF.bGQ);
        if (this.bQI == null) {
            this.bQI = s.hT(this.bQF.bGQ);
            this.bQI.a(this.mContext, this);
            this.bQH.put(this.bQF.bGQ, this.bQI);
        }
        this.bQI.setData(dzVar.bGR);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.z(horizontalTabView.getContext());
                int B = com.baidu.adp.lib.util.k.B(horizontalTabView.getContext());
                int ZN = this.bQI.ZN();
                int measuredHeight = (B - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < ZN) {
                    horizontalTabView.getmShowMenuCallBack().hA(ZN - measuredHeight);
                }
            }
        }
        this.bwk.removeAllViews();
        this.bwk.addView(this.bQI.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        av.k(this.bQG, u.d.common_color_10050);
        this.bwk.addView(this.bQG, layoutParams);
        a(activity, view, tabItemView);
        if (this.KJ != null) {
            this.KJ.refresh();
            this.KJ.setWidthAsWidthOfDeviceScreen(activity);
            this.KJ.setHeight(-1);
            this.KJ.showWindowInCustomPosition(0, 0);
        }
    }

    public void ZO() {
        if (this.KJ != null) {
            try {
                this.KJ.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void vm() {
        if (this.bQI != null) {
            this.bQI.vm();
        }
        if (this.bQG != null) {
            av.k(this.bQG, u.d.common_color_10050);
        }
        if (this.KJ != null) {
            this.KJ.setBackgroundDrawable(av.getDrawable(u.f.transparent_bg));
        }
    }

    public b ZP() {
        return this.bQu;
    }
}
