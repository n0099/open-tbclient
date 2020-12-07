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
    private MorePopupWindow eAK;
    private LinearLayout iGd;
    private bg juE;
    private View juF;
    private SparseArray<com.baidu.tieba.frs.tab.a> juG = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a juH;
    private b jus;
    private a jut;
    private Context mContext;

    /* loaded from: classes22.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes22.dex */
    public interface b {
        void By(int i);
    }

    /* loaded from: classes22.dex */
    public static class c {
        public TextView egV;
        public ImageView juK;
        public View juL;
        public View juM;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.jus = bVar;
        this.jut = aVar;
        this.iGd = new LinearLayout(context);
        this.iGd.setOrientation(1);
        this.iGd.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.juF = new View(context);
        this.juF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eAK);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.eAK == null) {
            this.eAK = new MorePopupWindow(activity, this.iGd, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void blL() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void blM() {
                    if (e.this.eAK != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eAK);
                    }
                }
            });
        }
        this.eAK.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.jut != null) {
                    e.this.jut.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bg bgVar) {
        this.juE = bgVar;
        this.juH = this.juG.get(this.juE.iXu);
        if (this.juH == null) {
            this.juH = h.BC(this.juE.iXu);
            this.juH.a(this.mContext, this);
            this.juG.put(this.juE.iXu, this.juH);
        }
        this.juH.setData(bgVar.iXv);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cJK = this.juH.cJK();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cJK) {
                    horizontalTabView.getmShowMenuCallBack().Bz(cJK - measuredHeight);
                }
            }
        }
        this.iGd.removeAllViews();
        this.iGd.addView(this.juH.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.juF, R.color.common_color_10050);
        this.iGd.addView(this.juF, layoutParams);
        a(activity, view, tabItemView);
        if (this.eAK != null) {
            this.eAK.refresh();
            this.eAK.setWidthAsWidthOfDeviceScreen(activity);
            this.eAK.setHeight(-1);
            this.eAK.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.eAK != null) {
            try {
                this.eAK.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cJM() {
        return this.jus;
    }
}
