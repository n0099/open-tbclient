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
    private MorePopupWindow aiH;
    private b dUe;
    private a dUf;
    private au dUq;
    private View dUr;
    private SparseArray<com.baidu.tieba.frs.tab.a> dUs = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a dUt;
    private LinearLayout dkp;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void mE(int i);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public TextView bKH;
        public ImageView dUw;
        public View dUx;
        public View dUy;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.dUe = bVar;
        this.dUf = aVar;
        this.dkp = new LinearLayout(context);
        this.dkp.setOrientation(1);
        this.dkp.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.dUr = new View(context);
        this.dUr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.aiH);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.aiH == null) {
            this.aiH = new MorePopupWindow(activity, this.dkp, view, al.getDrawable(e.f.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void vR() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void vS() {
                    if (e.this.aiH != null) {
                        com.baidu.adp.lib.g.g.a(e.this.aiH);
                    }
                }
            });
        }
        this.aiH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.dUf != null) {
                    e.this.dUf.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.dUq = auVar;
        this.dUt = this.dUs.get(this.dUq.dDD);
        if (this.dUt == null) {
            this.dUt = h.mI(this.dUq.dDD);
            this.dUt.a(this.mContext, this);
            this.dUs.put(this.dUq.dDD, this.dUt);
        }
        this.dUt.setData(auVar.dDE);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.aP(horizontalTabView.getContext());
                int aQ = l.aQ(horizontalTabView.getContext());
                int aFF = this.dUt.aFF();
                int measuredHeight = (aQ - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < aFF) {
                    horizontalTabView.getmShowMenuCallBack().mF(aFF - measuredHeight);
                }
            }
        }
        this.dkp.removeAllViews();
        this.dkp.addView(this.dUt.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.i(this.dUr, e.d.common_color_10050);
        this.dkp.addView(this.dUr, layoutParams);
        a(activity, view, tabItemView);
        if (this.aiH != null) {
            this.aiH.refresh();
            this.aiH.setWidthAsWidthOfDeviceScreen(activity);
            this.aiH.setHeight(-1);
            this.aiH.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.aiH != null) {
            try {
                this.aiH.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b aFH() {
        return this.dUe;
    }
}
