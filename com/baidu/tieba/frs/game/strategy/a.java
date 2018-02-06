package com.baidu.tieba.frs.game.strategy;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.i;
import com.baidu.d.a.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.tab.c;
import com.baidu.tieba.frs.game.strategy.view.f;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseFragment implements a.InterfaceC0056a, am {
    private String cZU;
    private String dNQ;
    private f dNR;
    private b dNS;
    private boolean isLoading;
    private c dNT = new c() { // from class: com.baidu.tieba.frs.game.strategy.a.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.c
        public void a(int i, int i2, List<i> list, List<com.baidu.tieba.frs.game.strategy.tab.f> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.E(list2)) {
                if (a.this.dNR != null) {
                    a.this.isLoading = false;
                    a.this.hideLoadingView(a.this.dNR.getRootView());
                    a.this.dNR.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        a.this.dNR.h(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            a.this.showNetRefreshView(a.this.dNR.getRootView(), a.this.getResources().getString(d.j.no_data_text), false);
            a.this.setNetRefreshViewTopMargin(a.this.getResources().getDimensionPixelSize(d.e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.c
        public void e(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (a.this.dNR != null) {
                    a.this.isLoading = false;
                    a.this.hideLoadingView(a.this.dNR.getRootView());
                    a.this.dNR.f(i, i2, str);
                    return;
                }
                return;
            }
            a.this.showNetRefreshView(a.this.dNR.getRootView(), str, false);
            a.this.setNetRefreshViewTopMargin(a.this.getResources().getDimensionPixelSize(d.e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.b dNU = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.a.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void bx(int i, int i2) {
            if (a.this.dNS != null) {
                a.this.dNS.bx(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void by(int i, int i2) {
            if (a.this.dNS != null) {
                a.this.dNS.by(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public boolean bz(int i, int i2) {
            if (a.this.dNS != null) {
                return a.this.dNS.bz(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public String getForumId() {
            if (a.this.dNS != null) {
                return a.this.dNS.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public com.baidu.tieba.frs.game.strategy.tab.f no(int i) {
            if (a.this.dNS != null) {
                return a.this.dNS.no(i);
            }
            return null;
        }
    };
    private CustomMessageListener cdm = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    a.this.XL();
                }
            }
        }
    };
    private boolean clp = true;
    private CustomMessageListener dNV = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (a.this.dNR != null && a.this.dNR.avk() != null && !a.this.dNR.avk().getNavBarIsShow()) {
                        a.this.dNR.avk().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && a.this.dNR != null && a.this.dNR.avk() != null && a.this.dNR.avk().getNavBarIsShow()) {
                    a.this.dNR.avk().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cZU = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dNQ = bundle.getString("name");
        } else if (getArguments() != null) {
            this.cZU = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dNQ = getArguments().getString("name");
        }
        this.dNS = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.cZU, 0L), this.dNQ);
        this.dNS.a(this.dNT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dNV.setSelfListener(true);
        registerListener(2001617, this.dNV, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.dNV, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.cdm, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dNS != null) {
            this.dNS.onDestory();
        }
        if (this.dNR != null) {
            this.dNR.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.clp && this.dNS != null) {
            this.dNS.bx(0, 0);
            this.clp = false;
            if (this.dNR != null) {
                this.isLoading = true;
                showLoadingView(this.dNR.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_game_strategy_layout, (ViewGroup) null);
        this.dNR = new f(this, inflate);
        this.dNR.setFrsGameTabDataLoadListener(this.dNU);
        this.dNR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cZU);
        bundle.putString("name", this.dNQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dNR != null) {
            this.dNR.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dNS != null) {
            this.dNS.bx(0, 0);
        }
        if (this.dNR != null) {
            hideNetRefreshView(this.dNR.getRootView());
            this.isLoading = true;
            showLoadingView(this.dNR.getRootView());
        }
    }

    public String getFid() {
        return this.cZU;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aT(getActivity().getApplicationContext())) {
                ai.b(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar avk() {
        if (this.dNR != null) {
            return this.dNR.avk();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XL() {
        if (!this.isLoading && this.dNR != null && j.oJ()) {
            this.dNR.XL();
        }
    }
}
