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
    private b hKc;
    private a hKd;
    private ay hKo;
    private View hKp;
    private SparseArray<com.baidu.tieba.frs.tab.a> hKq = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a hKr;
    private LinearLayout haJ;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void vl(int i);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public TextView dez;
        public ImageView hKu;
        public View hKv;
        public View hKw;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.hKc = bVar;
        this.hKd = aVar;
        this.haJ = new LinearLayout(context);
        this.haJ.setOrientation(1);
        this.haJ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.hKp = new View(context);
        this.hKp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dyz);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.dyz == null) {
            this.dyz = new MorePopupWindow(activity, this.haJ, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
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
                if (e.this.hKd != null) {
                    e.this.hKd.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, ay ayVar) {
        this.hKo = ayVar;
        this.hKr = this.hKq.get(this.hKo.hrh);
        if (this.hKr == null) {
            this.hKr = h.vp(this.hKo.hrh);
            this.hKr.a(this.mContext, this);
            this.hKq.put(this.hKo.hrh, this.hKr);
        }
        this.hKr.setData(ayVar.hri);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cbb = this.hKr.cbb();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cbb) {
                    horizontalTabView.getmShowMenuCallBack().vm(cbb - measuredHeight);
                }
            }
        }
        this.haJ.removeAllViews();
        this.haJ.addView(this.hKr.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.hKp, R.color.common_color_10050);
        this.haJ.addView(this.hKp, layoutParams);
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

    public b cbd() {
        return this.hKc;
    }
}
