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
    private MorePopupWindow RC;
    private LinearLayout bKa;
    private cw cbK;
    private View cbL;
    private SparseArray<f> cbM = new SparseArray<>();
    private f cbN;
    private b cby;
    private a cbz;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes.dex */
    public interface b {
        void iF(int i);
    }

    /* loaded from: classes.dex */
    public static class c {
        public ImageView cbQ;
        public View cbR;
        public View cbS;
        public TextView name;
    }

    public j(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.cby = bVar;
        this.cbz = aVar;
        this.bKa = new LinearLayout(context);
        this.bKa.setOrientation(1);
        this.bKa.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.cbL = new View(context);
        this.cbL.setOnClickListener(new k(this));
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.RC == null) {
            this.RC = new MorePopupWindow(activity, this.bKa, view, aq.getDrawable(w.g.transparent_bg), new l(this));
        }
        this.RC.setOnDismissListener(new m(this, tabItemView));
    }

    public void a(Activity activity, View view, TabItemView tabItemView, cw cwVar) {
        this.cbK = cwVar;
        this.cbN = this.cbM.get(this.cbK.bSi);
        if (this.cbN == null) {
            this.cbN = s.iH(this.cbK.bSi);
            this.cbN.a(this.mContext, this);
            this.cbM.put(this.cbK.bSi, this.cbN);
        }
        this.cbN.setData(cwVar.bSj);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                com.baidu.adp.lib.util.k.ae(horizontalTabView.getContext());
                int ag = com.baidu.adp.lib.util.k.ag(horizontalTabView.getContext());
                int aes = this.cbN.aes();
                int measuredHeight = (ag - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aes) {
                    horizontalTabView.getmShowMenuCallBack().ii(aes - measuredHeight);
                }
            }
        }
        this.bKa.removeAllViews();
        this.bKa.addView(this.cbN.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        aq.j(this.cbL, w.e.common_color_10050);
        this.bKa.addView(this.cbL, layoutParams);
        a(activity, view, tabItemView);
        if (this.RC != null) {
            this.RC.refresh();
            this.RC.setWidthAsWidthOfDeviceScreen(activity);
            this.RC.setHeight(-1);
            this.RC.showWindowInCustomPosition(0, 0);
        }
    }

    public void aeu() {
        if (this.RC != null) {
            try {
                this.RC.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public void xl() {
        if (this.cbN != null) {
            this.cbN.xl();
        }
        if (this.cbL != null) {
            aq.j(this.cbL, w.e.common_color_10050);
        }
        if (this.RC != null) {
            this.RC.setBackgroundDrawable(aq.getDrawable(w.g.transparent_bg));
        }
    }

    public b aev() {
        return this.cby;
    }
}
