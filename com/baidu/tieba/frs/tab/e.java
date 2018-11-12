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
    private MorePopupWindow aju;
    private com.baidu.tieba.frs.tab.a dVA;
    private b dVl;
    private a dVm;
    private au dVx;
    private View dVy;
    private SparseArray<com.baidu.tieba.frs.tab.a> dVz = new SparseArray<>();
    private LinearLayout dlu;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void mW(int i);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public TextView bLs;
        public ImageView dVD;
        public View dVE;
        public View dVF;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.dVl = bVar;
        this.dVm = aVar;
        this.dlu = new LinearLayout(context);
        this.dlu.setOrientation(1);
        this.dlu.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.dVy = new View(context);
        this.dVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.aju);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.aju == null) {
            this.aju = new MorePopupWindow(activity, this.dlu, view, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void vZ() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void wa() {
                    if (e.this.aju != null) {
                        com.baidu.adp.lib.g.g.a(e.this.aju);
                    }
                }
            });
        }
        this.aju.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.dVm != null) {
                    e.this.dVm.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.dVx = auVar;
        this.dVA = this.dVz.get(this.dVx.dET);
        if (this.dVA == null) {
            this.dVA = h.na(this.dVx.dET);
            this.dVA.a(this.mContext, this);
            this.dVz.put(this.dVx.dET, this.dVA);
        }
        this.dVA.setData(auVar.dEU);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int aFb = this.dVA.aFb();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aFb) {
                    horizontalTabView.getmShowMenuCallBack().mX(aFb - measuredHeight);
                }
            }
        }
        this.dlu.removeAllViews();
        this.dlu.addView(this.dVA.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.i(this.dVy, e.d.common_color_10050);
        this.dlu.addView(this.dVy, layoutParams);
        a(activity, view, tabItemView);
        if (this.aju != null) {
            this.aju.refresh();
            this.aju.setWidthAsWidthOfDeviceScreen(activity);
            this.aju.setHeight(-1);
            this.aju.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.aju != null) {
            try {
                this.aju.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b aFd() {
        return this.dVl;
    }
}
