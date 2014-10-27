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
    private final com.baidu.tbadk.core.view.y Yc;
    private final v atN;
    private final NavigationBar atx;
    private final NoNetworkView aty;
    private final TextView auK;
    private final bi auL;
    private final br auM;
    private final BaseActivity mActivity;
    private final LinearLayout mParent;
    private final BdListView vl;

    public bq(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        baseActivity.setContentView(ca.face_shop_activity);
        this.mParent = (LinearLayout) baseActivity.findViewById(bz.face_shop);
        this.atx = (NavigationBar) baseActivity.findViewById(bz.view_navigation_bar);
        this.atx.setTitleText(baseActivity.getResources().getString(cb.face_store));
        this.atx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.auK = this.atx.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(cb.manage));
        this.aty = (NoNetworkView) baseActivity.findViewById(bz.view_no_network);
        this.vl = (BdListView) baseActivity.findViewById(bz.face_shop_list);
        this.Yc = new com.baidu.tbadk.core.view.y(baseActivity);
        this.auL = new bi(baseActivity);
        this.auM = new br(this, baseActivity);
        this.vl.setAdapter((ListAdapter) this.auL);
        this.vl.setPullRefresh(this.Yc);
        this.vl.setNextPage(this.auM);
        this.auK.setOnClickListener(baseActivity);
        this.atN = new v(baseActivity, cc.common_alert_dialog);
    }

    public void c(FaceShopData faceShopData) {
        Dv();
        if (faceShopData != null && faceShopData.pack_list != null && faceShopData.pack_list.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<FacePackageData> it = faceShopData.pack_list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(it.next().pid));
            }
            q(arrayList);
        }
    }

    public void q(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
        }
    }

    public bi Dz() {
        return this.auL;
    }

    public void Dv() {
        this.auM.DG();
        this.vl.hN();
    }

    public void DA() {
        this.vl.hO();
    }

    public void DB() {
        this.auM.DF();
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.vl.setOnItemClickListener(onItemClickListener);
    }

    public void b(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }

    public void a(com.baidu.adp.widget.ListView.aa aaVar) {
        this.vl.setOnSrollToBottomListener(aaVar);
    }

    public void c(com.baidu.tbadk.core.view.u uVar) {
        this.aty.a(uVar);
    }

    public void d(com.baidu.tbadk.core.view.u uVar) {
        this.aty.b(uVar);
    }

    public void DC() {
        if (this.auM != null) {
            this.auM.hide();
        }
    }

    public void DD() {
        if (this.auM != null) {
            this.auM.Ba();
        }
    }

    public void onResume() {
        if (this.aty != null && this.aty.getVisibility() == 0 && com.baidu.adp.lib.util.j.fh()) {
            this.aty.Z(false);
        }
    }

    public void Dj() {
        if (this.atN != null) {
            this.atN.CO();
            com.baidu.adp.lib.g.j.a(this.atN, this.mActivity);
        }
    }

    public void Dk() {
        if (this.atN != null) {
            this.atN.CP();
        }
    }

    public void Dl() {
        if (this.atN != null) {
            com.baidu.adp.lib.g.j.b(this.atN, this.mActivity);
        }
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.mParent);
        if (this.atx != null) {
            this.atx.onChangeSkinType(i);
        }
        if (this.Yc != null) {
            this.Yc.bM(i);
        }
        if (this.auM != null) {
            this.auM.cu(i);
        }
        if (this.aty != null) {
            this.aty.onChangeSkinType(i);
        }
    }

    public TextView DE() {
        return this.auK;
    }
}
