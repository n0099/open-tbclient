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
/* loaded from: classes21.dex */
public class e {
    private MorePopupWindow dUY;
    private LinearLayout hNd;
    private b iyS;
    private a iyT;
    private bg ize;
    private View izf;
    private SparseArray<com.baidu.tieba.frs.tab.a> izg = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a izh;
    private Context mContext;

    /* loaded from: classes21.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void za(int i);
    }

    /* loaded from: classes21.dex */
    public static class c {
        public TextView dBn;
        public ImageView izk;
        public View izl;
        public View izm;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.iyS = bVar;
        this.iyT = aVar;
        this.hNd = new LinearLayout(context);
        this.hNd.setOrientation(1);
        this.hNd.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.izf = new View(context);
        this.izf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dUY);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.dUY == null) {
            this.dUY = new MorePopupWindow(activity, this.hNd, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bcw() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bcx() {
                    if (e.this.dUY != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dUY);
                    }
                }
            });
        }
        this.dUY.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.iyT != null) {
                    e.this.iyT.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bg bgVar) {
        this.ize = bgVar;
        this.izh = this.izg.get(this.ize.ieA);
        if (this.izh == null) {
            this.izh = h.ze(this.ize.ieA);
            this.izh.a(this.mContext, this);
            this.izg.put(this.ize.ieA, this.izh);
        }
        this.izh.setData(bgVar.ieB);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cvN = this.izh.cvN();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cvN) {
                    horizontalTabView.getmShowMenuCallBack().zb(cvN - measuredHeight);
                }
            }
        }
        this.hNd.removeAllViews();
        this.hNd.addView(this.izh.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.izf, R.color.common_color_10050);
        this.hNd.addView(this.izf, layoutParams);
        a(activity, view, tabItemView);
        if (this.dUY != null) {
            this.dUY.refresh();
            this.dUY.setWidthAsWidthOfDeviceScreen(activity);
            this.dUY.setHeight(-1);
            this.dUY.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.dUY != null) {
            try {
                this.dUY.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cvP() {
        return this.iyS;
    }
}
