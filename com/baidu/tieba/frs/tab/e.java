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
import com.baidu.tieba.frs.as;
/* loaded from: classes4.dex */
public class e {
    private MorePopupWindow bCp;
    private b fPT;
    private a fPU;
    private as fQf;
    private View fQg;
    private SparseArray<com.baidu.tieba.frs.tab.a> fQh = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a fQi;
    private LinearLayout fef;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void sM(int i);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public TextView bmT;
        public ImageView fQl;
        public View fQm;
        public View fQn;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.fPT = bVar;
        this.fPU = aVar;
        this.fef = new LinearLayout(context);
        this.fef.setOrientation(1);
        this.fef.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.fQg = new View(context);
        this.fQg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.bCp);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.bCp == null) {
            this.bCp = new MorePopupWindow(activity, this.fef, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void abz() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void abA() {
                    if (e.this.bCp != null) {
                        com.baidu.adp.lib.g.g.a(e.this.bCp);
                    }
                }
            });
        }
        this.bCp.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.fPU != null) {
                    e.this.fPU.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.fQf = asVar;
        this.fQi = this.fQh.get(this.fQf.fya);
        if (this.fQi == null) {
            this.fQi = h.sQ(this.fQf.fya);
            this.fQi.a(this.mContext, this);
            this.fQh.put(this.fQf.fya, this.fQi);
        }
        this.fQi.setData(asVar.fyb);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ag(horizontalTabView.getContext());
                int ah = l.ah(horizontalTabView.getContext());
                int brV = this.fQi.brV();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < brV) {
                    horizontalTabView.getmShowMenuCallBack().sN(brV - measuredHeight);
                }
            }
        }
        this.fef.removeAllViews();
        this.fef.addView(this.fQi.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.k(this.fQg, R.color.common_color_10050);
        this.fef.addView(this.fQg, layoutParams);
        a(activity, view, tabItemView);
        if (this.bCp != null) {
            this.bCp.refresh();
            this.bCp.setWidthAsWidthOfDeviceScreen(activity);
            this.bCp.setHeight(-1);
            this.bCp.showWindowInCustomPosition(0, 0);
        }
    }

    public void brX() {
        if (this.bCp != null) {
            try {
                this.bCp.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b brY() {
        return this.fPT;
    }
}
