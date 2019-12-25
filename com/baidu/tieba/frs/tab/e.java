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
/* loaded from: classes6.dex */
public class e {
    private MorePopupWindow cGL;
    private LinearLayout fWp;
    private at gEK;
    private View gEL;
    private SparseArray<com.baidu.tieba.frs.tab.a> gEM = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a gEN;
    private b gEy;
    private a gEz;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void tP(int i);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public TextView cpT;
        public ImageView gEQ;
        public View gER;
        public View gES;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.gEy = bVar;
        this.gEz = aVar;
        this.fWp = new LinearLayout(context);
        this.fWp.setOrientation(1);
        this.fWp.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.gEL = new View(context);
        this.gEL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cGL);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.cGL == null) {
            this.cGL = new MorePopupWindow(activity, this.fWp, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void awZ() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void axa() {
                    if (e.this.cGL != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cGL);
                    }
                }
            });
        }
        this.cGL.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.gEz != null) {
                    e.this.gEz.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, at atVar) {
        this.gEK = atVar;
        this.gEN = this.gEM.get(this.gEK.gmI);
        if (this.gEN == null) {
            this.gEN = h.tT(this.gEK.gmI);
            this.gEN.a(this.mContext, this);
            this.gEM.put(this.gEK.gmI, this.gEN);
        }
        this.gEN.setData(atVar.gmJ);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bHg = this.gEN.bHg();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bHg) {
                    horizontalTabView.getmShowMenuCallBack().tQ(bHg - measuredHeight);
                }
            }
        }
        this.fWp.removeAllViews();
        this.fWp.addView(this.gEN.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.gEL, R.color.common_color_10050);
        this.fWp.addView(this.gEL, layoutParams);
        a(activity, view, tabItemView);
        if (this.cGL != null) {
            this.cGL.refresh();
            this.cGL.setWidthAsWidthOfDeviceScreen(activity);
            this.cGL.setHeight(-1);
            this.cGL.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.cGL != null) {
            try {
                this.cGL.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bHi() {
        return this.gEy;
    }
}
