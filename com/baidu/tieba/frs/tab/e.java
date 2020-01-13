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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.at;
/* loaded from: classes7.dex */
public class e {
    private MorePopupWindow cGX;
    private LinearLayout fZy;
    private b gHN;
    private a gHO;
    private at gHZ;
    private View gIa;
    private SparseArray<com.baidu.tieba.frs.tab.a> gIb = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a gIc;
    private Context mContext;

    /* loaded from: classes7.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void tU(int i);
    }

    /* loaded from: classes7.dex */
    public static class c {
        public TextView cqf;
        public ImageView gIf;
        public View gIg;
        public View gIh;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.gHN = bVar;
        this.gHO = aVar;
        this.fZy = new LinearLayout(context);
        this.fZy.setOrientation(1);
        this.fZy.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.gIa = new View(context);
        this.gIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cGX);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.cGX == null) {
            this.cGX = new MorePopupWindow(activity, this.fZy, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void axs() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void axt() {
                    if (e.this.cGX != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cGX);
                    }
                }
            });
        }
        this.cGX.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.gHO != null) {
                    e.this.gHO.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.gHZ = atVar;
        this.gIc = this.gIb.get(this.gHZ.gpR);
        if (this.gIc == null) {
            this.gIc = h.tY(this.gHZ.gpR);
            this.gIc.a(this.mContext, this);
            this.gIb.put(this.gHZ.gpR, this.gIc);
        }
        this.gIc.setData(atVar.gpS);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bIi = this.gIc.bIi();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bIi) {
                    horizontalTabView.getmShowMenuCallBack().tV(bIi - measuredHeight);
                }
            }
        }
        this.fZy.removeAllViews();
        this.fZy.addView(this.gIc.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.gIa, R.color.common_color_10050);
        this.fZy.addView(this.gIa, layoutParams);
        a(activity, view, tabItemView);
        if (this.cGX != null) {
            this.cGX.refresh();
            this.cGX.setWidthAsWidthOfDeviceScreen(activity);
            this.cGX.setHeight(-1);
            this.cGX.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.cGX != null) {
            try {
                this.cGX.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bIk() {
        return this.gHN;
    }
}
