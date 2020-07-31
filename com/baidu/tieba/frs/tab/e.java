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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.be;
/* loaded from: classes16.dex */
public class e {
    private MorePopupWindow dJC;
    private LinearLayout hsG;
    private be idC;
    private View idD;
    private SparseArray<com.baidu.tieba.frs.tab.a> idE = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a idF;
    private b idn;
    private a ido;
    private Context mContext;

    /* loaded from: classes16.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes16.dex */
    public interface b {
        void wi(int i);
    }

    /* loaded from: classes16.dex */
    public static class c {
        public TextView dpg;
        public ImageView idI;
        public View idJ;
        public View idK;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.idn = bVar;
        this.ido = aVar;
        this.hsG = new LinearLayout(context);
        this.hsG.setOrientation(1);
        this.hsG.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.idD = new View(context);
        this.idD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dJC);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.dJC == null) {
            this.dJC = new MorePopupWindow(activity, this.hsG, view, ao.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aTl() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void aTm() {
                    if (e.this.dJC != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.dJC);
                    }
                }
            });
        }
        this.dJC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.ido != null) {
                    e.this.ido.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, be beVar) {
        this.idC = beVar;
        this.idF = this.idE.get(this.idC.hJS);
        if (this.idF == null) {
            this.idF = h.wm(this.idC.hJS);
            this.idF.a(this.mContext, this);
            this.idE.put(this.idC.hJS, this.idF);
        }
        this.idF.setData(beVar.hJT);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int chT = this.idF.chT();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < chT) {
                    horizontalTabView.getmShowMenuCallBack().wj(chT - measuredHeight);
                }
            }
        }
        this.hsG.removeAllViews();
        this.hsG.addView(this.idF.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ao.setBackgroundResource(this.idD, R.color.common_color_10050);
        this.hsG.addView(this.idD, layoutParams);
        a(activity, view, tabItemView);
        if (this.dJC != null) {
            this.dJC.refresh();
            this.dJC.setWidthAsWidthOfDeviceScreen(activity);
            this.dJC.setHeight(-1);
            this.dJC.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.dJC != null) {
            try {
                this.dJC.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b chV() {
        return this.idn;
    }
}
