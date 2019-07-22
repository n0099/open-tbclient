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
    private b fPf;
    private a fPg;
    private as fPr;
    private View fPs;
    private SparseArray<com.baidu.tieba.frs.tab.a> fPt = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a fPu;
    private LinearLayout fdF;
    private Context mContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void sK(int i);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public TextView bmT;
        public ImageView fPx;
        public View fPy;
        public View fPz;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.fPf = bVar;
        this.fPg = aVar;
        this.fdF = new LinearLayout(context);
        this.fdF.setOrientation(1);
        this.fdF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.fPs = new View(context);
        this.fPs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.g.g.a(e.this.bCp);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.bCp == null) {
            this.bCp = new MorePopupWindow(activity, this.fdF, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
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
                if (e.this.fPg != null) {
                    e.this.fPg.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, as asVar) {
        this.fPr = asVar;
        this.fPu = this.fPt.get(this.fPr.fxB);
        if (this.fPu == null) {
            this.fPu = h.sO(this.fPr.fxB);
            this.fPu.a(this.mContext, this);
            this.fPt.put(this.fPr.fxB, this.fPu);
        }
        this.fPu.setData(asVar.fxC);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.ag(horizontalTabView.getContext());
                int ah = l.ah(horizontalTabView.getContext());
                int brI = this.fPu.brI();
                int measuredHeight = (ah - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < brI) {
                    horizontalTabView.getmShowMenuCallBack().sL(brI - measuredHeight);
                }
            }
        }
        this.fdF.removeAllViews();
        this.fdF.addView(this.fPu.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.k(this.fPs, R.color.common_color_10050);
        this.fdF.addView(this.fPs, layoutParams);
        a(activity, view, tabItemView);
        if (this.bCp != null) {
            this.bCp.refresh();
            this.bCp.setWidthAsWidthOfDeviceScreen(activity);
            this.bCp.setHeight(-1);
            this.bCp.showWindowInCustomPosition(0, 0);
        }
    }

    public void brK() {
        if (this.bCp != null) {
            try {
                this.bCp.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b brL() {
        return this.fPf;
    }
}
