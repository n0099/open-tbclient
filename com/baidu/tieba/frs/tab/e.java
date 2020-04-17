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
    private MorePopupWindow dkv;
    private LinearLayout gLG;
    private ay huI;
    private View huJ;
    private SparseArray<com.baidu.tieba.frs.tab.a> huK = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a huL;
    private b huw;
    private a hux;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void uD(int i);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public TextView cTr;
        public ImageView huO;
        public View huP;
        public View huQ;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.huw = bVar;
        this.hux = aVar;
        this.gLG = new LinearLayout(context);
        this.gLG.setOrientation(1);
        this.gLG.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.huJ = new View(context);
        this.huJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dkv);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.dkv == null) {
            this.dkv = new MorePopupWindow(activity, this.gLG, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aHY() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aHZ() {
                    if (e.this.dkv != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dkv);
                    }
                }
            });
        }
        this.dkv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.hux != null) {
                    e.this.hux.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, ay ayVar) {
        this.huI = ayVar;
        this.huL = this.huK.get(this.huI.hcc);
        if (this.huL == null) {
            this.huL = h.uH(this.huI.hcc);
            this.huL.a(this.mContext, this);
            this.huK.put(this.huI.hcc, this.huL);
        }
        this.huL.setData(ayVar.hcd);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bUx = this.huL.bUx();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bUx) {
                    horizontalTabView.getmShowMenuCallBack().uE(bUx - measuredHeight);
                }
            }
        }
        this.gLG.removeAllViews();
        this.gLG.addView(this.huL.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.huJ, R.color.common_color_10050);
        this.gLG.addView(this.huJ, layoutParams);
        a(activity, view, tabItemView);
        if (this.dkv != null) {
            this.dkv.refresh();
            this.dkv.setWidthAsWidthOfDeviceScreen(activity);
            this.dkv.setHeight(-1);
            this.dkv.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.dkv != null) {
            try {
                this.dkv.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bUz() {
        return this.huw;
    }
}
