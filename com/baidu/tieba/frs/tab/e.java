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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.au;
/* loaded from: classes6.dex */
public class e {
    private MorePopupWindow anz;
    private LinearLayout dvu;
    private SparseArray<com.baidu.tieba.frs.tab.a> efA = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a efB;
    private b efm;
    private a efn;
    private au efy;
    private View efz;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void nA(int i);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public TextView bPW;
        public ImageView efE;
        public View efF;
        public View efG;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.efm = bVar;
        this.efn = aVar;
        this.dvu = new LinearLayout(context);
        this.dvu.setOrientation(1);
        this.dvu.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.efz = new View(context);
        this.efz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.anz);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.anz == null) {
            this.anz = new MorePopupWindow(activity, this.dvu, view, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xq() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void xr() {
                    if (e.this.anz != null) {
                        com.baidu.adp.lib.g.g.a(e.this.anz);
                    }
                }
            });
        }
        this.anz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.efn != null) {
                    e.this.efn.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.efy = auVar;
        this.efB = this.efA.get(this.efy.dOQ);
        if (this.efB == null) {
            this.efB = h.nE(this.efy.dOQ);
            this.efB.a(this.mContext, this);
            this.efA.put(this.efy.dOQ, this.efB);
        }
        this.efB.setData(auVar.dOR);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int aHZ = this.efB.aHZ();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aHZ) {
                    horizontalTabView.getmShowMenuCallBack().nB(aHZ - measuredHeight);
                }
            }
        }
        this.dvu.removeAllViews();
        this.dvu.addView(this.efB.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.i(this.efz, e.d.common_color_10050);
        this.dvu.addView(this.efz, layoutParams);
        a(activity, view, tabItemView);
        if (this.anz != null) {
            this.anz.refresh();
            this.anz.setWidthAsWidthOfDeviceScreen(activity);
            this.anz.setHeight(-1);
            this.anz.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.anz != null) {
            try {
                this.anz.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b aIb() {
        return this.efm;
    }
}
