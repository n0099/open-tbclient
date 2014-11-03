package com.baidu.tieba.faceshop;

import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.QueryDownloadMessage;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class bq {
    private final com.baidu.tbadk.core.view.y Yg;
    private final NavigationBar atG;
    private final NoNetworkView atH;
    private final v atW;
    private final TextView auT;
    private final bi auU;
    private final br auV;
    private final BaseActivity mActivity;
    private final LinearLayout mParent;
    private final BdListView vl;

    public bq(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        baseActivity.setContentView(ca.face_shop_activity);
        this.mParent = (LinearLayout) baseActivity.findViewById(bz.face_shop);
        this.atG = (NavigationBar) baseActivity.findViewById(bz.view_navigation_bar);
        this.atG.setTitleText(baseActivity.getResources().getString(cb.face_store));
        this.atG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.auT = this.atG.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(cb.manage));
        this.atH = (NoNetworkView) baseActivity.findViewById(bz.view_no_network);
        this.vl = (BdListView) baseActivity.findViewById(bz.face_shop_list);
        this.Yg = new com.baidu.tbadk.core.view.y(baseActivity);
        this.auU = new bi(baseActivity);
        this.auV = new br(this, baseActivity);
        this.vl.setAdapter((ListAdapter) this.auU);
        this.vl.setPullRefresh(this.Yg);
        this.vl.setNextPage(this.auV);
        this.auT.setOnClickListener(baseActivity);
        this.atW = new v(baseActivity, cc.common_alert_dialog);
    }

    public void c(FaceShopData faceShopData) {
        Dx();
        if (faceShopData != null && faceShopData.pack_list != null && faceShopData.pack_list.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<FacePackageData> it = faceShopData.pack_list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().pid));
            }
            r(arrayList);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
        }
    }

    public bi DB() {
        return this.auU;
    }

    public void Dx() {
        this.auV.DI();
        this.vl.hN();
    }

    public void DC() {
        this.vl.hO();
    }

    public void DD() {
        this.auV.DH();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.vl.setOnItemClickListener(onItemClickListener);
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }

    public void a(com.baidu.adp.widget.ListView.aa aaVar) {
        this.vl.setOnSrollToBottomListener(aaVar);
    }

    public void c(com.baidu.tbadk.core.view.u uVar) {
        this.atH.a(uVar);
    }

    public void d(com.baidu.tbadk.core.view.u uVar) {
        this.atH.b(uVar);
    }

    public void DE() {
        if (this.auV != null) {
            this.auV.hide();
        }
    }

    public void DF() {
        if (this.auV != null) {
            this.auV.Bc();
        }
    }

    public void onResume() {
        if (this.atH != null && this.atH.getVisibility() == 0 && com.baidu.adp.lib.util.j.fh()) {
            this.atH.Z(false);
        }
    }

    public void Dl() {
        if (this.atW != null) {
            this.atW.CQ();
            com.baidu.adp.lib.g.j.a(this.atW, this.mActivity);
        }
    }

    public void Dm() {
        if (this.atW != null) {
            this.atW.CR();
        }
    }

    public void Dn() {
        if (this.atW != null) {
            com.baidu.adp.lib.g.j.b(this.atW, this.mActivity);
        }
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.mParent);
        if (this.atG != null) {
            this.atG.onChangeSkinType(i);
        }
        if (this.Yg != null) {
            this.Yg.bM(i);
        }
        if (this.auV != null) {
            this.auV.cu(i);
        }
        if (this.atH != null) {
            this.atH.onChangeSkinType(i);
        }
    }

    public TextView DG() {
        return this.auT;
    }
}
