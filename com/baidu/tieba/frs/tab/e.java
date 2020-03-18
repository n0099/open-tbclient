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
import com.baidu.tieba.frs.au;
/* loaded from: classes9.dex */
public class e {
    private MorePopupWindow cLn;
    private b gLf;
    private a gLg;
    private au gLr;
    private View gLs;
    private SparseArray<com.baidu.tieba.frs.tab.a> gLt = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a gLu;
    private LinearLayout gcw;
    private Context mContext;

    /* loaded from: classes9.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void ug(int i);
    }

    /* loaded from: classes9.dex */
    public static class c {
        public TextView cuv;
        public ImageView gLx;
        public View gLy;
        public View gLz;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.gLf = bVar;
        this.gLg = aVar;
        this.gcw = new LinearLayout(context);
        this.gcw.setOrientation(1);
        this.gcw.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.gLs = new View(context);
        this.gLs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cLn);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.cLn == null) {
            this.cLn = new MorePopupWindow(activity, this.gcw, view, am.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azL() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void azM() {
                    if (e.this.cLn != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.cLn);
                    }
                }
            });
        }
        this.cLn.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.gLg != null) {
                    e.this.gLg.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, au auVar) {
        this.gLr = auVar;
        this.gLu = this.gLt.get(this.gLr.gsR);
        if (this.gLu == null) {
            this.gLu = h.uk(this.gLr.gsR);
            this.gLu.a(this.mContext, this);
            this.gLt.put(this.gLr.gsR, this.gLu);
        }
        this.gLu.setData(auVar.gsS);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int bKa = this.gLu.bKa();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < bKa) {
                    horizontalTabView.getmShowMenuCallBack().uh(bKa - measuredHeight);
                }
            }
        }
        this.gcw.removeAllViews();
        this.gcw.addView(this.gLu.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.setBackgroundResource(this.gLs, R.color.common_color_10050);
        this.gcw.addView(this.gLs, layoutParams);
        a(activity, view, tabItemView);
        if (this.cLn != null) {
            this.cLn.refresh();
            this.cLn.setWidthAsWidthOfDeviceScreen(activity);
            this.cLn.setHeight(-1);
            this.cLn.showWindowInCustomPosition(0, 0);
        }
    }

    public void dismissMenu() {
        if (this.cLn != null) {
            try {
                this.cLn.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b bKc() {
        return this.gLf;
    }
}
