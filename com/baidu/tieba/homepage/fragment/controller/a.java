package com.baidu.tieba.homepage.fragment.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.fragment.data.UserModuleData;
import com.baidu.tieba.homepage.fragment.model.b;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseFragment implements b.a {
    private int bxU;
    private com.baidu.tieba.homepage.fragment.a.a bxV;
    private com.baidu.tieba.homepage.fragment.model.b bxW;
    private com.baidu.tieba.homepage.fragment.data.b bxX;
    private com.baidu.tbadk.core.view.viewpager.a.b bxY;
    private com.baidu.tbadk.f.h refreshView;
    private final int bxZ = 4;
    private boolean bya = false;
    private boolean byb = false;
    private final CustomMessageListener aNY = new b(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private CustomMessageListener aNW = new h(this, CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW);
    private CustomMessageListener aWI = new i(this, CmdConfigCustom.CMD_LIKE_FORUM);
    private CustomMessageListener aCn = new j(this, CmdConfigCustom.CMD_UNLIKE_FORUM);
    private final CustomMessageListener byc = new k(this, CmdConfigCustom.DISCOVER_NEED_REFRESH_NET_PLUGIN);
    private CustomMessageListener byd = new l(this, CmdConfigCustom.CMD_PHOTO_LIVE_PLUGIN_INSTALL_SUCCESS);

    private void showNetRefreshView(View view, String str, boolean z) {
        TI();
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new m(this));
        }
        this.refreshView.eB(getResources().getDimensionPixelSize(n.d.ds160));
        this.refreshView.fL(str);
        this.refreshView.b(view, z);
        this.refreshView.Dn();
    }

    private void TI() {
        if (this.refreshView != null) {
            this.refreshView.v(getView());
            this.refreshView = null;
        }
    }

    private void TJ() {
        this.bxV.a(new n(this));
        this.bxV.b(new o(this));
        registerListener(new c(this, CmdConfigCustom.CMD_HOME_PAGE_SEND_USER_MODULE));
        registerListener(new d(this, CmdConfigCustom.CMD_HOME_PAGE_LOAD_DATA_FROM_NET));
        registerListener(this.aNY);
        registerListener(new e(this, CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL));
        registerListener(new f(this, CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL));
        registerListener(this.byc);
        registerListener(this.aNW);
        registerListener(this.aWI);
        registerListener(this.aCn);
        registerListener(this.byd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.bxW = new com.baidu.tieba.homepage.fragment.model.b(getPageContext(), getUniqueId());
        this.bxW.a(this);
        TJ();
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (TbadkCoreApplication.m411getInst().isFriendFeedNew()) {
            TiebaStatic.log("c10540");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.MAINTAB_TAB_EMOTION, new com.baidu.tbadk.mainTab.a(false)));
        }
        if (isAdded() && isPrimary() && !this.bya) {
            TK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.refreshView != null) {
            this.refreshView.tH();
        }
        if (this.bxV != null) {
            this.bxV.onChangeSkinType(i);
        }
        super.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bxU = 3;
        View inflate = layoutInflater.inflate(n.g.home_page_activity, viewGroup, false);
        inflate.setDrawingCacheEnabled(false);
        this.bxV = new com.baidu.tieba.homepage.fragment.a.a(getPageContext(), inflate);
        return inflate;
    }

    private void TK() {
        if (com.baidu.adp.lib.util.i.iP()) {
            this.bxV.showLoadingView(this.bxV.byB, true);
        }
        this.bxW.IR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onResourceRecycle() {
        super.onResourceRecycle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIEW_PAGER_END_AUTO_SCROLL, 0));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIEW_PAGER_START_AUTO_SCROLL, 0));
    }

    @Override // com.baidu.tieba.homepage.fragment.model.b.a
    public void a(boolean z, String str, com.baidu.tieba.homepage.fragment.data.b bVar) {
        this.bxV.TT();
        TI();
        if (bVar == null || bVar.TN()) {
            if (z || (!com.baidu.adp.lib.util.i.iP() && !z)) {
                this.bxV.hideLoadingView(this.bxV.byB);
                if (this.bxX == null || this.bxX.TN()) {
                    showNetRefreshView(getView(), getPageContext().getResources().getString(n.i.neterror), false);
                    return;
                }
                return;
            }
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tZ().getString("home_page_user_module_config", null);
        if (string != null) {
            UserModuleData userModuleData = (UserModuleData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(string, UserModuleData.class);
            bVar.a(userModuleData);
            if (userModuleData == null || userModuleData.moduleDataList == null) {
                this.byb = true;
                bVar.a(bVar.byh);
            }
        } else {
            bVar.a(bVar.byh);
        }
        this.bxV.aM(bVar.TP());
        if (bVar.TQ() == null && (bVar.TP() == null || bVar.TP().isEmpty())) {
            if (z) {
                this.bxV.hideLoadingView(this.bxV.byB);
                if (this.bxX == null || this.bxX.TN()) {
                    showNetRefreshView(getView(), getPageContext().getResources().getString(n.i.neterror), false);
                    return;
                }
                return;
            }
            return;
        }
        this.bxX = bVar;
        this.bxV.b(bVar);
        a(this.bxX);
        this.bxV.hideLoadingView(this.bxV.byB);
        this.bya = true;
        if (string == null || this.byb) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putString("home_page_user_module_config", com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(bVar.byh));
            this.byb = false;
        }
    }

    @Override // com.baidu.tieba.homepage.fragment.model.b.a
    public void h(String str, String str2, int i) {
        this.bxV.TT();
        this.bxV.hideLoadingView(this.bxV.byB);
        if (str2 != null) {
            showToast(str2);
        }
        if (this.bxX == null || this.bxX.TN()) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(n.i.neterror), false);
        }
    }

    private com.baidu.tbadk.core.view.viewpager.a.b TL() {
        com.baidu.tbadk.core.view.viewpager.a.b bVar = new com.baidu.tbadk.core.view.viewpager.a.b(getActivity());
        bVar.setMaxScrollCountLimit(4);
        bVar.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.d(getActivity(), n.d.ds240)));
        bVar.setOnItemClickListener(new g(this));
        return bVar;
    }

    private void a(com.baidu.tieba.homepage.fragment.data.b bVar) {
        if (bVar != null && bVar.TQ() != null && bVar.TQ().TZ() != null) {
            com.baidu.tbadk.core.view.viewpager.a.b TL = TL();
            List<com.baidu.tieba.homepage.listview.card.a.b> TZ = bVar.TQ().TZ();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            if (y.k(TZ) == 0) {
                if (this.bxY != null) {
                    this.bxV.N(this.bxY);
                    this.bxY.setData(null);
                    this.bxY = null;
                    return;
                }
                return;
            }
            Iterator<com.baidu.tieba.homepage.listview.card.a.b> it = TZ.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                arrayList.add(it.next());
                i = i2 + 1;
                if (i == 4) {
                    break;
                }
            }
            TL.setData(arrayList);
            this.bxV.M(TL);
            if (this.bxY != null) {
                this.bxV.N(this.bxY);
            }
            this.bxY = TL;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TM() {
        if (this.bxX != null && this.bxX.byr != null) {
            this.bxX.byr.cY(false);
            this.bxV.TV();
        }
    }
}
