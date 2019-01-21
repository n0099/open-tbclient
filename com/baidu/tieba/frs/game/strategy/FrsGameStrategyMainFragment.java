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
import com.baidu.adp.widget.ListView.h;
import com.baidu.e.a.a;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0073a, ak {
    private String dWr;
    private e dWs;
    private b dWt;
    private String dbs;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b dWu = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.I(list2)) {
                if (FrsGameStrategyMainFragment.this.dWs != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dWs.getRootView());
                    FrsGameStrategyMainFragment.this.dWs.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.dWs.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dWs.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(e.j.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(e.C0210e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void c(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.dWs != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dWs.getRootView());
                    FrsGameStrategyMainFragment.this.dWs.d(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dWs.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(e.C0210e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a dWv = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aO(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dWt != null) {
                FrsGameStrategyMainFragment.this.dWt.aO(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aP(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dWt != null) {
                FrsGameStrategyMainFragment.this.dWt.aP(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean aQ(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dWt != null) {
                return FrsGameStrategyMainFragment.this.dWt.aQ(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.dWt != null) {
                return FrsGameStrategyMainFragment.this.dWt.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e mS(int i) {
            if (FrsGameStrategyMainFragment.this.dWt != null) {
                return FrsGameStrategyMainFragment.this.dWt.mS(i);
            }
            return null;
        }
    };
    private CustomMessageListener bRj = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.abv();
                }
            }
        }
    };
    private boolean bSI = true;
    private CustomMessageListener cav = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.dWs != null && FrsGameStrategyMainFragment.this.dWs.act() != null && !FrsGameStrategyMainFragment.this.dWs.act().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.dWs.act().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.dWs != null && FrsGameStrategyMainFragment.this.dWs.act() != null && FrsGameStrategyMainFragment.this.dWs.act().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.dWs.act().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.dbs = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dWr = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.dbs = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dWr = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.dWt = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.d(this.dbs, 0L), this.dWr);
        this.dWt.a(this.dWu);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cav.setSelfListener(true);
        registerListener(2001617, this.cav, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.cav, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.bRj, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dWt != null) {
            this.dWt.onDestory();
        }
        if (this.dWs != null) {
            this.dWs.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aFK();
        }
    }

    private void aFK() {
        if (this.bSI && this.dWt != null) {
            this.dWt.aO(0, 0);
            this.bSI = false;
            if (this.dWs != null) {
                this.isLoading = true;
                showLoadingView(this.dWs.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_game_strategy_layout, (ViewGroup) null);
        this.dWs = new com.baidu.tieba.frs.game.strategy.view.e(this, inflate);
        this.dWs.setFrom(this.mFrom);
        this.dWs.setFrsGameTabDataLoadListener(this.dWv);
        this.dWs.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            aFK();
            act().setCenterTextTitle(this.dWr);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.dbs);
        bundle.putString("name", this.dWr);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dWs != null) {
            this.dWs.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dWt != null) {
            this.dWt.aO(0, 0);
        }
        if (this.dWs != null) {
            hideNetRefreshView(this.dWs.getRootView());
            this.isLoading = true;
            showLoadingView(this.dWs.getRootView());
        }
    }

    public String getFid() {
        return this.dbs;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aX(getActivity().getApplicationContext())) {
                com.baidu.tbadk.core.util.ak.b(getPageContext());
            } else {
                showToast(e.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(e.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar act() {
        if (this.dWs != null) {
            return this.dWs.act();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abv() {
        if (!this.isLoading && this.dWs != null && j.kV()) {
            this.dWs.abv();
        }
    }
}
