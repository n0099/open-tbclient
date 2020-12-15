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
    private LinearLayout iGf;
    private bg juG;
    private View juH;
    private SparseArray<com.baidu.tieba.frs.tab.a> juI = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a juJ;
    private b juu;
    private a juv;
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
        public ImageView juM;
        public View juN;
        public View juO;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.juu = bVar;
        this.juv = aVar;
        this.iGf = new LinearLayout(context);
        this.iGf.setOrientation(1);
        this.iGf.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.juH = new View(context);
        this.juH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eAK);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.eAK == null) {
            this.eAK = new MorePopupWindow(activity, this.iGf, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
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
                if (e.this.juv != null) {
                    e.this.juv.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bg bgVar) {
        this.juG = bgVar;
        this.juJ = this.juI.get(this.juG.iXw);
        if (this.juJ == null) {
            this.juJ = h.BC(this.juG.iXw);
            this.juJ.a(this.mContext, this);
            this.juI.put(this.juG.iXw, this.juJ);
        }
        this.juJ.setData(bgVar.iXx);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cJL = this.juJ.cJL();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cJL) {
                    horizontalTabView.getmShowMenuCallBack().Bz(cJL - measuredHeight);
                }
            }
        }
        this.iGf.removeAllViews();
        this.iGf.addView(this.juJ.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.juH, R.color.common_color_10050);
        this.iGf.addView(this.juH, layoutParams);
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

    public b cJN() {
        return this.juu;
    }
}
