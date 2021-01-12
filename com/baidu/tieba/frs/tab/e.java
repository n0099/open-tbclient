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
import com.baidu.tieba.frs.bd;
/* loaded from: classes2.dex */
public class e {
    private MorePopupWindow eFC;
    private LinearLayout iNK;
    private b jCj;
    private a jCk;
    private bd jCv;
    private View jCw;
    private SparseArray<com.baidu.tieba.frs.tab.a> jCx = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a jCy;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Ae(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView eli;
        public ImageView jCB;
        public View jCC;
        public View jCD;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.jCj = bVar;
        this.jCk = aVar;
        this.iNK = new LinearLayout(context);
        this.iNK.setOrientation(1);
        this.iNK.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jCw = new View(context);
        this.jCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eFC);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.eFC == null) {
            this.eFC = new MorePopupWindow(activity, this.iNK, view, ao.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkr() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bks() {
                    if (e.this.eFC != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eFC);
                    }
                }
            });
        }
        this.eFC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.jCk != null) {
                    e.this.jCk.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bd bdVar) {
        this.jCv = bdVar;
        this.jCy = this.jCx.get(this.jCv.jfb);
        if (this.jCy == null) {
            this.jCy = h.Ai(this.jCv.jfb);
            this.jCy.a(this.mContext, this);
            this.jCx.put(this.jCv.jfb, this.jCy);
        }
        this.jCy.setData(bdVar.jfc);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cIU = this.jCy.cIU();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cIU) {
                    horizontalTabView.getmShowMenuCallBack().Af(cIU - measuredHeight);
                }
            }
        }
        this.iNK.removeAllViews();
        this.iNK.addView(this.jCy.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ao.setBackgroundResource(this.jCw, R.color.common_color_10050);
        this.iNK.addView(this.jCw, layoutParams);
        a(activity, view, tabItemView);
        if (this.eFC != null) {
            this.eFC.refresh();
            this.eFC.setWidthAsWidthOfDeviceScreen(activity);
            this.eFC.setHeight(-1);
            this.eFC.showWindowInCustomPosition(0, 0);
        }
    }

    public void cIW() {
        if (this.eFC != null) {
            try {
                this.eFC.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cIX() {
        return this.jCj;
    }
}
