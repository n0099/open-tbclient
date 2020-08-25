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
/* loaded from: classes16.dex */
public class e {
    private MorePopupWindow dSK;
    private LinearLayout hFW;
    private bg irI;
    private View irJ;
    private SparseArray<com.baidu.tieba.frs.tab.a> irK = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a irL;
    private b irw;
    private a irx;
    private Context mContext;

    /* loaded from: classes16.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes16.dex */
    public interface b {
        void yB(int i);
    }

    /* loaded from: classes16.dex */
    public static class c {
        public TextView dzi;
        public ImageView irO;
        public View irP;
        public View irQ;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.irw = bVar;
        this.irx = aVar;
        this.hFW = new LinearLayout(context);
        this.hFW.setOrientation(1);
        this.hFW.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.irJ = new View(context);
        this.irJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dSK);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.dSK == null) {
            this.dSK = new MorePopupWindow(activity, this.hFW, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bbC() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bbD() {
                    if (e.this.dSK != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dSK);
                    }
                }
            });
        }
        this.dSK.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.irx != null) {
                    e.this.irx.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bg bgVar) {
        this.irI = bgVar;
        this.irL = this.irK.get(this.irI.hXq);
        if (this.irL == null) {
            this.irL = h.yF(this.irI.hXq);
            this.irL.a(this.mContext, this);
            this.irK.put(this.irI.hXq, this.irL);
        }
        this.irL.setData(bgVar.hXr);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int csx = this.irL.csx();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < csx) {
                    horizontalTabView.getmShowMenuCallBack().yC(csx - measuredHeight);
                }
            }
        }
        this.hFW.removeAllViews();
        this.hFW.addView(this.irL.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.irJ, R.color.common_color_10050);
        this.hFW.addView(this.irJ, layoutParams);
        a(activity, view, tabItemView);
        if (this.dSK != null) {
            this.dSK.refresh();
            this.dSK.setWidthAsWidthOfDeviceScreen(activity);
            this.dSK.setHeight(-1);
            this.dSK.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.dSK != null) {
            try {
                this.dSK.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b csz() {
        return this.irw;
    }
}
