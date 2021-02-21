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
import com.baidu.tieba.frs.bd;
/* loaded from: classes2.dex */
public class e {
    private MorePopupWindow eHI;
    private LinearLayout iTF;
    private b jIb;
    private a jIc;
    private bd jIn;
    private View jIo;
    private SparseArray<com.baidu.tieba.frs.tab.a> jIp = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a jIq;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Ao(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView enq;
        public ImageView jIt;
        public View jIu;
        public View jIv;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.jIb = bVar;
        this.jIc = aVar;
        this.iTF = new LinearLayout(context);
        this.iTF.setOrientation(1);
        this.iTF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jIo = new View(context);
        this.jIo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eHI);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.eHI == null) {
            this.eHI = new MorePopupWindow(activity, this.iTF, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkJ() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkK() {
                    if (e.this.eHI != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eHI);
                    }
                }
            });
        }
        this.eHI.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.jIc != null) {
                    e.this.jIc.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bd bdVar) {
        this.jIn = bdVar;
        this.jIq = this.jIp.get(this.jIn.jkW);
        if (this.jIq == null) {
            this.jIq = h.As(this.jIn.jkW);
            this.jIq.a(this.mContext, this);
            this.jIp.put(this.jIn.jkW, this.jIq);
        }
        this.jIq.setData(bdVar.jkX);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cKo = this.jIq.cKo();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cKo) {
                    horizontalTabView.getmShowMenuCallBack().Ap(cKo - measuredHeight);
                }
            }
        }
        this.iTF.removeAllViews();
        this.iTF.addView(this.jIq.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.jIo, R.color.common_color_10050);
        this.iTF.addView(this.jIo, layoutParams);
        a(activity, view, tabItemView);
        if (this.eHI != null) {
            this.eHI.refresh();
            this.eHI.setWidthAsWidthOfDeviceScreen(activity);
            this.eHI.setHeight(-1);
            this.eHI.showWindowInCustomPosition(0, 0);
        }
    }

    public void cKq() {
        if (this.eHI != null) {
            try {
                this.eHI.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cKr() {
        return this.jIb;
    }
}
