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
/* loaded from: classes21.dex */
public class e {
    private MorePopupWindow etI;
    private LinearLayout ivl;
    private b jgP;
    private a jgQ;
    private bg jhb;
    private View jhc;
    private SparseArray<com.baidu.tieba.frs.tab.a> jhd = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a jhe;
    private Context mContext;

    /* loaded from: classes21.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void AK(int i);
    }

    /* loaded from: classes21.dex */
    public static class c {
        public TextView dZV;
        public ImageView jhh;
        public View jhi;
        public View jhj;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.jgP = bVar;
        this.jgQ = aVar;
        this.ivl = new LinearLayout(context);
        this.ivl.setOrientation(1);
        this.ivl.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jhc = new View(context);
        this.jhc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.etI);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.etI == null) {
            this.etI = new MorePopupWindow(activity, this.ivl, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void biB() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void biC() {
                    if (e.this.etI != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.etI);
                    }
                }
            });
        }
        this.etI.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.jgQ != null) {
                    e.this.jgQ.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bg bgVar) {
        this.jhb = bgVar;
        this.jhe = this.jhd.get(this.jhb.iMD);
        if (this.jhe == null) {
            this.jhe = h.AO(this.jhb.iMD);
            this.jhe.a(this.mContext, this);
            this.jhd.put(this.jhb.iMD, this.jhe);
        }
        this.jhe.setData(bgVar.iME);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cEx = this.jhe.cEx();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cEx) {
                    horizontalTabView.getmShowMenuCallBack().AL(cEx - measuredHeight);
                }
            }
        }
        this.ivl.removeAllViews();
        this.ivl.addView(this.jhe.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.jhc, R.color.common_color_10050);
        this.ivl.addView(this.jhc, layoutParams);
        a(activity, view, tabItemView);
        if (this.etI != null) {
            this.etI.refresh();
            this.etI.setWidthAsWidthOfDeviceScreen(activity);
            this.etI.setHeight(-1);
            this.etI.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.etI != null) {
            try {
                this.etI.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cEz() {
        return this.jgP;
    }
}
