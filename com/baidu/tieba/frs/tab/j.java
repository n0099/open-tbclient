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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.cu;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow Mf;
    private LinearLayout bAK;
    private cu bTG;
    private View bTH;
    private SparseArray<f> bTI = new SparseArray<>();
    private f bTJ;
    private b bTu;
    private a bTv;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void iC(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView bTM;
        public View bTN;
        public View bTO;
        public TextView name;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.bTu = bVar;
        this.bTv = aVar;
        this.bAK = new LinearLayout(context);
        this.bAK.setOrientation(1);
        this.bAK.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bTH = new View(context);
        this.bTH.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.Mf == null) {
            this.Mf = new MorePopupWindow(activity, this.bAK, view, ap.getDrawable(r.g.transparent_bg), new l(this));
        }
        this.Mf.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, cu cuVar) {
        this.bTG = cuVar;
        this.bTJ = this.bTI.get(this.bTG.bIT);
        if (this.bTJ == null) {
            this.bTJ = s.iE(this.bTG.bIT);
            this.bTJ.a(this.mContext, this);
            this.bTI.put(this.bTG.bIT, this.bTJ);
        }
        this.bTJ.setData(cuVar.bIU);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.H(horizontalTabView.getContext());
                int J = com.baidu.adp.lib.util.k.J(horizontalTabView.getContext());
                int acz = this.bTJ.acz();
                int measuredHeight = (J - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < acz) {
                    horizontalTabView.getmShowMenuCallBack().id(acz - measuredHeight);
                }
            }
        }
        this.bAK.removeAllViews();
        this.bAK.addView(this.bTJ.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.j(this.bTH, r.e.common_color_10050);
        this.bAK.addView(this.bTH, layoutParams);
        a(activity, view, tabItemView);
        if (this.Mf != null) {
            this.Mf.refresh();
            this.Mf.setWidthAsWidthOfDeviceScreen(activity);
            this.Mf.setHeight(-1);
            this.Mf.showWindowInCustomPosition(0, 0);
        }
    }

    public void acB() {
        if (this.Mf != null) {
            try {
                this.Mf.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void ws() {
        if (this.bTJ != null) {
            this.bTJ.ws();
        }
        if (this.bTH != null) {
            ap.j(this.bTH, r.e.common_color_10050);
        }
        if (this.Mf != null) {
            this.Mf.setBackgroundDrawable(ap.getDrawable(r.g.transparent_bg));
        }
    }

    public b acC() {
        return this.bTu;
    }
}
