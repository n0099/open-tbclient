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
/* loaded from: classes9.dex */
public class e {
    private MorePopupWindow cLa;
    private b gJM;
    private a gJN;
    private at gJY;
    private View gJZ;
    private SparseArray<com.baidu.tieba.frs.tab.a> gKa = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a gKb;
    private LinearLayout gby;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void ua(int i);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public TextView cug;
        public ImageView gKe;
        public View gKf;
        public View gKg;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.gJM = bVar;
        this.gJN = aVar;
        this.gby = new LinearLayout(context);
        this.gby.setOrientation(1);
        this.gby.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.gJZ = new View(context);
        this.gJZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cLa);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.cLa == null) {
            this.cLa = new MorePopupWindow(activity, this.gby, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azG() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azH() {
                    if (e.this.cLa != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cLa);
                    }
                }
            });
        }
        this.cLa.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.gJN != null) {
                    e.this.gJN.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.gJY = atVar;
        this.gKb = this.gKa.get(this.gJY.grS);
        if (this.gKb == null) {
            this.gKb = h.ue(this.gJY.grS);
            this.gKb.a(this.mContext, this);
            this.gKa.put(this.gJY.grS, this.gKb);
        }
        this.gKb.setData(atVar.grT);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bJK = this.gKb.bJK();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bJK) {
                    horizontalTabView.getmShowMenuCallBack().ub(bJK - measuredHeight);
                }
            }
        }
        this.gby.removeAllViews();
        this.gby.addView(this.gKb.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.gJZ, R.color.common_color_10050);
        this.gby.addView(this.gJZ, layoutParams);
        a(activity, view, tabItemView);
        if (this.cLa != null) {
            this.cLa.refresh();
            this.cLa.setWidthAsWidthOfDeviceScreen(activity);
            this.cLa.setHeight(-1);
            this.cLa.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.cLa != null) {
            try {
                this.cLa.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bJM() {
        return this.gJM;
    }
}
