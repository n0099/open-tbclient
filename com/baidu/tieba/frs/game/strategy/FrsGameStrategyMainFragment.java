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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.m.a.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0250a, at {
    private String fyR;
    private String gkl;
    private e iVE;
    private b iVF;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b iVG = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !y.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.iVE != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.iVE.getRootView());
                    FrsGameStrategyMainFragment.this.iVE.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.iVE.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.iVE.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void m(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.iVE != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.iVE.getRootView());
                    FrsGameStrategyMainFragment.this.iVE.n(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.iVE.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a iVH = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cr(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.iVF != null) {
                FrsGameStrategyMainFragment.this.iVF.cr(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cs(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.iVF != null) {
                FrsGameStrategyMainFragment.this.iVF.cs(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean ct(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.iVF != null) {
                return FrsGameStrategyMainFragment.this.iVF.ct(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.iVF != null) {
                return FrsGameStrategyMainFragment.this.iVF.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e zC(int i) {
            if (FrsGameStrategyMainFragment.this.iVF != null) {
                return FrsGameStrategyMainFragment.this.iVF.zC(i);
            }
            return null;
        }
    };
    private CustomMessageListener gps = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.bPV();
                }
            }
        }
    };
    private boolean gmh = true;
    private CustomMessageListener gEu = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.iVE != null && FrsGameStrategyMainFragment.this.iVE.bSH() != null && !FrsGameStrategyMainFragment.this.iVE.bSH().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.iVE.bSH().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.iVE != null && FrsGameStrategyMainFragment.this.iVE.bSH() != null && FrsGameStrategyMainFragment.this.iVE.bSH().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.iVE.bSH().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.fyR = bundle.getString("fid");
            this.gkl = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.fyR = getArguments().getString("fid");
            this.gkl = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.iVF = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.f.b.toLong(this.fyR, 0L), this.gkl);
        this.iVF.a(this.iVG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gEu.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.gEu, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.gEu, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gps, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iVF != null) {
            this.iVF.onDestory();
        }
        if (this.iVE != null) {
            this.iVE.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cCB();
        }
    }

    private void cCB() {
        if (this.gmh && this.iVF != null) {
            this.iVF.cr(0, 0);
            this.gmh = false;
            if (this.iVE != null) {
                this.isLoading = true;
                showLoadingView(this.iVE.getRootView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.iVE = new e(this, inflate);
        this.iVE.setFrom(this.mFrom);
        this.iVE.setFrsGameTabDataLoadListener(this.iVH);
        this.iVE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            cCB();
            bSH().setCenterTextTitle(this.gkl);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.fyR);
        bundle.putString("name", this.gkl);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iVE != null) {
            this.iVE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.iVF != null) {
            this.iVF.cr(0, 0);
        }
        if (this.iVE != null) {
            hideNetRefreshView(this.iVE.getRootView());
            this.isLoading = true;
            showLoadingView(this.iVE.getRootView());
        }
    }

    public String getFid() {
        return this.fyR;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0250a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.checkCamera(getActivity().getApplicationContext())) {
                ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bSH() {
        if (this.iVE != null) {
            return this.iVE.bSH();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPV() {
        if (!this.isLoading && this.iVE != null && j.isNetWorkAvailable()) {
            this.iVE.bPV();
        }
    }
}
