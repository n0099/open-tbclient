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
    private MorePopupWindow eJj;
    private LinearLayout iVo;
    private b jJK;
    private a jJL;
    private bd jJW;
    private View jJX;
    private SparseArray<com.baidu.tieba.frs.tab.a> jJY = new SparseArray<>();
    private com.baidu.tieba.frs.tab.a jJZ;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TabItemView tabItemView);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Ap(int i);
    }

    /* loaded from: classes2.dex */
    public static class c {
        public TextView eoT;
        public ImageView jKc;
        public View jKd;
        public View jKe;
    }

    public e(Context context, b bVar, a aVar) {
        this.mContext = context;
        this.jJK = bVar;
        this.jJL = aVar;
        this.iVo = new LinearLayout(context);
        this.iVo.setOrientation(1);
        this.iVo.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.jJX = new View(context);
        this.jJX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eJj);
            }
        });
    }

    private void a(Activity activity, View view, final TabItemView tabItemView) {
        if (this.eJj == null) {
            this.eJj = new MorePopupWindow(activity, this.iVo, view, ap.getDrawable(R.drawable.transparent_bg), new KeyEventDealContainerView.a() { // from class: com.baidu.tieba.frs.tab.e.2
                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkL() {
                }

                @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
                public void bkM() {
                    if (e.this.eJj != null) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(e.this.eJj);
                    }
                }
            });
        }
        this.eJj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.frs.tab.e.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (e.this.jJL != null) {
                    e.this.jJL.a(tabItemView);
                }
            }
        });
    }

    public void a(Activity activity, View view, TabItemView tabItemView, bd bdVar) {
        this.jJW = bdVar;
        this.jJZ = this.jJY.get(this.jJW.jmG);
        if (this.jJZ == null) {
            this.jJZ = h.At(this.jJW.jmG);
            this.jJZ.a(this.mContext, this);
            this.jJY.put(this.jJW.jmG, this.jJZ);
        }
        this.jJZ.setData(bdVar.jmH);
        if (view instanceof HorizontalTabView) {
            HorizontalTabView horizontalTabView = (HorizontalTabView) view;
            if (horizontalTabView.getmShowMenuCallBack() != null) {
                int[] iArr = new int[2];
                horizontalTabView.getLocationInWindow(iArr);
                l.initDeviceData(horizontalTabView.getContext());
                int equipmentHeight = l.getEquipmentHeight(horizontalTabView.getContext());
                int cKu = this.jJZ.cKu();
                int measuredHeight = (equipmentHeight - iArr[1]) - horizontalTabView.getMeasuredHeight();
                if (measuredHeight < cKu) {
                    horizontalTabView.getmShowMenuCallBack().Aq(cKu - measuredHeight);
                }
            }
        }
        this.iVo.removeAllViews();
        this.iVo.addView(this.jJZ.getView());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ap.setBackgroundResource(this.jJX, R.color.common_color_10050);
        this.iVo.addView(this.jJX, layoutParams);
        a(activity, view, tabItemView);
        if (this.eJj != null) {
            this.eJj.refresh();
            this.eJj.setWidthAsWidthOfDeviceScreen(activity);
            this.eJj.setHeight(-1);
            this.eJj.showWindowInCustomPosition(0, 0);
        }
    }

    public void cKw() {
        if (this.eJj != null) {
            try {
                this.eJj.dismiss();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public b cKx() {
        return this.jJK;
    }
}
