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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.frs.cw;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j {
    private MorePopupWindow RA;
    private LinearLayout bHJ;
    private b bZh;
    private a bZi;
    private cw bZt;
    private View bZu;
    private SparseArray<f> bZv = new SparseArray<>();
    private f bZw;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void iz(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public View bZA;
        public View bZB;
        public ImageView bZz;
        public TextView name;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.bZh = bVar;
        this.bZi = aVar;
        this.bHJ = new LinearLayout(context);
        this.bHJ.setOrientation(1);
        this.bHJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.bZu = new View(context);
        this.bZu.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.RA == null) {
            this.RA = new MorePopupWindow(activity, this.bHJ, view, aq.getDrawable(w.g.transparent_bg), new l(this));
        }
        this.RA.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, cw cwVar) {
        this.bZt = cwVar;
        this.bZw = this.bZv.get(this.bZt.bPR);
        if (this.bZw == null) {
            this.bZw = s.iB(this.bZt.bPR);
            this.bZw.a(this.mContext, this);
            this.bZv.put(this.bZt.bPR, this.bZw);
        }
        this.bZw.setData(cwVar.bPS);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.ae(horizontalTabView.getContext());
                int ag = com.baidu.adp.lib.util.k.ag(horizontalTabView.getContext());
                int adr = this.bZw.adr();
                int measuredHeight = (ag - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < adr) {
                    horizontalTabView.getmShowMenuCallBack().ic(adr - measuredHeight);
                }
            }
        }
        this.bHJ.removeAllViews();
        this.bHJ.addView(this.bZw.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aq.j(this.bZu, w.e.common_color_10050);
        this.bHJ.addView(this.bZu, layoutParams);
        a(activity, view, tabItemView);
        if (this.RA != null) {
            this.RA.refresh();
            this.RA.setWidthAsWidthOfDeviceScreen(activity);
            this.RA.setHeight(-1);
            this.RA.showWindowInCustomPosition(0, 0);
        }
    }

    public void adt() {
        if (this.RA != null) {
            try {
                this.RA.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void xl() {
        if (this.bZw != null) {
            this.bZw.xl();
        }
        if (this.bZu != null) {
            aq.j(this.bZu, w.e.common_color_10050);
        }
        if (this.RA != null) {
            this.RA.setBackgroundDrawable(aq.getDrawable(w.g.transparent_bg));
        }
    }

    public b adu() {
        return this.bZh;
    }
}
