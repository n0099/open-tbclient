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
import com.baidu.tieba.frs.ay;
/* loaded from: classes9.dex */
public class e {
    private MorePopupWindow dyz;
    private ay hJB;
    private View hJC;
    private SparseArray<com.baidu.tieba.frs.tab.a> hJD = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a hJE;
    private b hJp;
    private a hJq;
    private LinearLayout hay;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void vj(int i);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public TextView dez;
        public ImageView hJH;
        public View hJI;
        public View hJJ;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.hJp = bVar;
        this.hJq = aVar;
        this.hay = new LinearLayout(context);
        this.hay.setOrientation(1);
        this.hay.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.hJC = new View(context);
        this.hJC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dyz);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.dyz == null) {
            this.dyz = new MorePopupWindow(activity, this.hay, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aNK() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aNL() {
                    if (e.this.dyz != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dyz);
                    }
                }
            });
        }
        this.dyz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.hJq != null) {
                    e.this.hJq.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, ay ayVar) {
        this.hJB = ayVar;
        this.hJE = this.hJD.get(this.hJB.hqW);
        if (this.hJE == null) {
            this.hJE = h.vn(this.hJB.hqW);
            this.hJE.a(this.mContext, this);
            this.hJD.put(this.hJB.hqW, this.hJE);
        }
        this.hJE.setData(ayVar.hqX);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int caT = this.hJE.caT();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < caT) {
                    horizontalTabView.getmShowMenuCallBack().vk(caT - measuredHeight);
                }
            }
        }
        this.hay.removeAllViews();
        this.hay.addView(this.hJE.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.hJC, R.color.common_color_10050);
        this.hay.addView(this.hJC, layoutParams);
        a(activity, view, tabItemView);
        if (this.dyz != null) {
            this.dyz.refresh();
            this.dyz.setWidthAsWidthOfDeviceScreen(activity);
            this.dyz.setHeight(-1);
            this.dyz.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.dyz != null) {
            try {
                this.dyz.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b caV() {
        return this.hJp;
    }
}
