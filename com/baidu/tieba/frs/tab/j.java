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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow MS;
    private b bNg;
    private a bNh;
    private cy bNs;
    private View bNt;
    private SparseArray<f> bNu = new SparseArray<>();
    private f bNv;
    private LinearLayout bsY;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void hP(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public TextView aKH;
        public View bNA;
        public ImageView bNy;
        public View bNz;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.bNg = bVar;
        this.bNh = aVar;
        this.bsY = new LinearLayout(context);
        this.bsY.setOrientation(1);
        this.bsY.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bNt = new View(context);
        this.bNt.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.MS == null) {
            this.MS = new MorePopupWindow(activity, this.bsY, view, ar.getDrawable(r.f.transparent_bg), new l(this));
        }
        this.MS.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, cy cyVar) {
        this.bNs = cyVar;
        this.bNv = this.bNu.get(this.bNs.bBz);
        if (this.bNv == null) {
            this.bNv = s.hR(this.bNs.bBz);
            this.bNv.a(this.mContext, this);
            this.bNu.put(this.bNs.bBz, this.bNv);
        }
        this.bNv.setData(cyVar.bBA);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.H(horizontalTabView.getContext());
                int J = com.baidu.adp.lib.util.k.J(horizontalTabView.getContext());
                int abs = this.bNv.abs();
                int measuredHeight = (J - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < abs) {
                    horizontalTabView.getmShowMenuCallBack().hq(abs - measuredHeight);
                }
            }
        }
        this.bsY.removeAllViews();
        this.bsY.addView(this.bNv.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ar.k(this.bNt, r.d.common_color_10050);
        this.bsY.addView(this.bNt, layoutParams);
        a(activity, view, tabItemView);
        if (this.MS != null) {
            this.MS.refresh();
            this.MS.setWidthAsWidthOfDeviceScreen(activity);
            this.MS.setHeight(-1);
            this.MS.showWindowInCustomPosition(0, 0);
        }
    }

    public void abu() {
        if (this.MS != null) {
            try {
                this.MS.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void wx() {
        if (this.bNv != null) {
            this.bNv.wx();
        }
        if (this.bNt != null) {
            ar.k(this.bNt, r.d.common_color_10050);
        }
        if (this.MS != null) {
            this.MS.setBackgroundDrawable(ar.getDrawable(r.f.transparent_bg));
        }
    }

    public b abv() {
        return this.bNg;
    }
}
