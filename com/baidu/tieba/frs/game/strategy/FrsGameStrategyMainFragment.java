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
import com.baidu.adp.widget.ListView.m;
import com.baidu.e.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0055a, ah {
    private String ePT;
    private String fGR;
    private e fGS;
    private b fGT;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b fGU = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.fGS != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fGS.getRootView());
                    FrsGameStrategyMainFragment.this.fGS.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.fGS.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fGS.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void f(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.fGS != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fGS.getRootView());
                    FrsGameStrategyMainFragment.this.fGS.g(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fGS.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a fGV = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void br(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fGT != null) {
                FrsGameStrategyMainFragment.this.fGT.br(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bs(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fGT != null) {
                FrsGameStrategyMainFragment.this.fGT.bs(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean bt(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fGT != null) {
                return FrsGameStrategyMainFragment.this.fGT.bt(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.fGT != null) {
                return FrsGameStrategyMainFragment.this.fGT.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e ra(int i) {
            if (FrsGameStrategyMainFragment.this.fGT != null) {
                return FrsGameStrategyMainFragment.this.fGT.ra(i);
            }
            return null;
        }
    };
    private CustomMessageListener dBH = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.aKh();
                }
            }
        }
    };
    private boolean dyK = true;
    private CustomMessageListener dKw = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.fGS != null && FrsGameStrategyMainFragment.this.fGS.aKR() != null && !FrsGameStrategyMainFragment.this.fGS.aKR().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.fGS.aKR().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.fGS != null && FrsGameStrategyMainFragment.this.fGS.aKR() != null && FrsGameStrategyMainFragment.this.fGS.aKR().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.fGS.aKR().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.ePT = bundle.getString("fid");
            this.fGR = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.ePT = getArguments().getString("fid");
            this.fGR = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.fGT = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.toLong(this.ePT, 0L), this.fGR);
        this.fGT.a(this.fGU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dKw.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.dKw, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.dKw, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.dBH, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fGT != null) {
            this.fGT.onDestory();
        }
        if (this.fGS != null) {
            this.fGS.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bnz();
        }
    }

    private void bnz() {
        if (this.dyK && this.fGT != null) {
            this.fGT.br(0, 0);
            this.dyK = false;
            if (this.fGS != null) {
                this.isLoading = true;
                showLoadingView(this.fGS.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.fGS = new e(this, inflate);
        this.fGS.setFrom(this.mFrom);
        this.fGS.setFrsGameTabDataLoadListener(this.fGV);
        this.fGS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            bnz();
            aKR().setCenterTextTitle(this.fGR);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.ePT);
        bundle.putString("name", this.fGR);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fGS != null) {
            this.fGS.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.fGT != null) {
            this.fGT.br(0, 0);
        }
        if (this.fGS != null) {
            hideNetRefreshView(this.fGS.getRootView());
            this.isLoading = true;
            showLoadingView(this.fGS.getRootView());
        }
    }

    public String getFid() {
        return this.ePT;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0055a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getActivity().getApplicationContext())) {
                al.c(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aKR() {
        if (this.fGS != null) {
            return this.fGS.aKR();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        if (!this.isLoading && this.fGS != null && j.isNetWorkAvailable()) {
            this.fGS.aKh();
        }
    }
}
