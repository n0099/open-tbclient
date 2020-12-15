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
import com.baidu.n.a.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0276a, as {
    private String fFV;
    private String gsd;
    private boolean isLoading;
    private e jjR;
    private b jjS;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b jjT = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !y.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.jjR != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jjR.getRootView());
                    FrsGameStrategyMainFragment.this.jjR.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.jjR.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jjR.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void m(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.jjR != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jjR.getRootView());
                    FrsGameStrategyMainFragment.this.jjR.n(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jjR.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a jjU = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cw(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jjS != null) {
                FrsGameStrategyMainFragment.this.jjS.cw(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cx(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jjS != null) {
                FrsGameStrategyMainFragment.this.jjS.cx(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean cy(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jjS != null) {
                return FrsGameStrategyMainFragment.this.jjS.cy(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.jjS != null) {
                return FrsGameStrategyMainFragment.this.jjS.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e AO(int i) {
            if (FrsGameStrategyMainFragment.this.jjS != null) {
                return FrsGameStrategyMainFragment.this.jjS.AO(i);
            }
            return null;
        }
    };
    private CustomMessageListener gxk = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.bTa();
                }
            }
        }
    };
    private boolean gtZ = true;
    private CustomMessageListener gNa = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.jjR != null && FrsGameStrategyMainFragment.this.jjR.bVL() != null && !FrsGameStrategyMainFragment.this.jjR.bVL().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.jjR.bVL().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.jjR != null && FrsGameStrategyMainFragment.this.jjR.bVL() != null && FrsGameStrategyMainFragment.this.jjR.bVL().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.jjR.bVL().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.fFV = bundle.getString("fid");
            this.gsd = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.fFV = getArguments().getString("fid");
            this.gsd = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.jjS = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.f.b.toLong(this.fFV, 0L), this.gsd);
        this.jjS.a(this.jjT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gNa.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.gNa, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.gNa, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gxk, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jjS != null) {
            this.jjS.onDestory();
        }
        if (this.jjR != null) {
            this.jjR.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cHr();
        }
    }

    private void cHr() {
        if (this.gtZ && this.jjS != null) {
            this.jjS.cw(0, 0);
            this.gtZ = false;
            if (this.jjR != null) {
                this.isLoading = true;
                showLoadingView(this.jjR.getRootView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.jjR = new e(this, inflate);
        this.jjR.setFrom(this.mFrom);
        this.jjR.setFrsGameTabDataLoadListener(this.jjU);
        this.jjR.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            cHr();
            bVL().setCenterTextTitle(this.gsd);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.fFV);
        bundle.putString("name", this.gsd);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jjR != null) {
            this.jjR.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.jjS != null) {
            this.jjS.cw(0, 0);
        }
        if (this.jjR != null) {
            hideNetRefreshView(this.jjR.getRootView());
            this.isLoading = true;
            showLoadingView(this.jjR.getRootView());
        }
    }

    public String getFid() {
        return this.fFV;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.n.a.a.InterfaceC0276a
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

    @Override // com.baidu.tieba.frs.as
    public NavigationBar bVL() {
        if (this.jjR != null) {
            return this.jjR.bVL();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTa() {
        if (!this.isLoading && this.jjR != null && j.isNetWorkAvailable()) {
            this.jjR.bTa();
        }
    }
}
