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
    private MorePopupWindow epy;
    private LinearLayout ioA;
    private b jah;
    private a jai;
    private bg jat;
    private View jau;
    private SparseArray<com.baidu.tieba.frs.tab.a> jav = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a jaw;
    private Context mContext;

    /* loaded from: classes22.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes22.dex */
    public interface b {
        void zZ(int i);
    }

    /* loaded from: classes22.dex */
    public static class c {
        public TextView dVL;
        public View jaA;
        public View jaB;
        public ImageView jaz;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.jah = bVar;
        this.jai = aVar;
        this.ioA = new LinearLayout(context);
        this.ioA.setOrientation(1);
        this.ioA.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jau = new View(context);
        this.jau.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.epy);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.epy == null) {
            this.epy = new MorePopupWindow(activity, this.ioA, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bgX() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bgY() {
                    if (e.this.epy != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.epy);
                    }
                }
            });
        }
        this.epy.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.jai != null) {
                    e.this.jai.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bg bgVar) {
        this.jat = bgVar;
        this.jaw = this.jav.get(this.jat.iFT);
        if (this.jaw == null) {
            this.jaw = h.Ad(this.jat.iFT);
            this.jaw.a(this.mContext, this);
            this.jav.put(this.jat.iFT, this.jaw);
        }
        this.jaw.setData(bgVar.iFU);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cCr = this.jaw.cCr();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cCr) {
                    horizontalTabView.getmShowMenuCallBack().Aa(cCr - measuredHeight);
                }
            }
        }
        this.ioA.removeAllViews();
        this.ioA.addView(this.jaw.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.jau, R.color.common_color_10050);
        this.ioA.addView(this.jau, layoutParams);
        a(activity, view, tabItemView);
        if (this.epy != null) {
            this.epy.refresh();
            this.epy.setWidthAsWidthOfDeviceScreen(activity);
            this.epy.setHeight(-1);
            this.epy.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.epy != null) {
            try {
                this.epy.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cCt() {
        return this.jah;
    }
}
