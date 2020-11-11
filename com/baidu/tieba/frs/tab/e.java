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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.bg;
/* loaded from: classes22.dex */
public class e {
    private MorePopupWindow evr;
    private LinearLayout iux;
    private b jge;
    private a jgf;
    private bg jgq;
    private View jgr;
    private SparseArray<com.baidu.tieba.frs.tab.a> jgs = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a jgt;
    private Context mContext;

    /* loaded from: classes22.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes22.dex */
    public interface b {
        void Am(int i);
    }

    /* loaded from: classes22.dex */
    public static class c {
        public TextView ebD;
        public ImageView jgw;
        public View jgx;
        public View jgy;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.jge = bVar;
        this.jgf = aVar;
        this.iux = new LinearLayout(context);
        this.iux.setOrientation(1);
        this.iux.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jgr = new View(context);
        this.jgr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.evr);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.evr == null) {
            this.evr = new MorePopupWindow(activity, this.iux, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bjx() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bjy() {
                    if (e.this.evr != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.evr);
                    }
                }
            });
        }
        this.evr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.jgf != null) {
                    e.this.jgf.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bg bgVar) {
        this.jgq = bgVar;
        this.jgt = this.jgs.get(this.jgq.iLQ);
        if (this.jgt == null) {
            this.jgt = h.Aq(this.jgq.iLQ);
            this.jgt.a(this.mContext, this);
            this.jgs.put(this.jgq.iLQ, this.jgt);
        }
        this.jgt.setData(bgVar.iLR);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cES = this.jgt.cES();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cES) {
                    horizontalTabView.getmShowMenuCallBack().An(cES - measuredHeight);
                }
            }
        }
        this.iux.removeAllViews();
        this.iux.addView(this.jgt.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.jgr, R.color.common_color_10050);
        this.iux.addView(this.jgr, layoutParams);
        a(activity, view, tabItemView);
        if (this.evr != null) {
            this.evr.refresh();
            this.evr.setWidthAsWidthOfDeviceScreen(activity);
            this.evr.setHeight(-1);
            this.evr.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.evr != null) {
            try {
                this.evr.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cEU() {
        return this.jge;
    }
}
