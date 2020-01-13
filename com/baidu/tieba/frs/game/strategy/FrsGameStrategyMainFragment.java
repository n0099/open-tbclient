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
import com.baidu.k.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes7.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0072a, ai {
    private String fKa;
    private String gxD;
    private e gxE;
    private b gxF;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b gxG = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.gxE != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.gxE.getRootView());
                    FrsGameStrategyMainFragment.this.gxE.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.gxE.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.gxE.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void j(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.gxE != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.gxE.getRootView());
                    FrsGameStrategyMainFragment.this.gxE.k(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.gxE.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a gxH = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bG(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.gxF != null) {
                FrsGameStrategyMainFragment.this.gxF.bG(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bH(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.gxF != null) {
                FrsGameStrategyMainFragment.this.gxF.bH(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean bI(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.gxF != null) {
                return FrsGameStrategyMainFragment.this.gxF.bI(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.gxF != null) {
                return FrsGameStrategyMainFragment.this.gxF.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e tk(int i) {
            if (FrsGameStrategyMainFragment.this.gxF != null) {
                return FrsGameStrategyMainFragment.this.gxF.tk(i);
            }
            return null;
        }
    };
    private CustomMessageListener emK = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.baZ();
                }
            }
        }
    };
    private boolean ejJ = true;
    private CustomMessageListener ezg = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.gxE != null && FrsGameStrategyMainFragment.this.gxE.bcw() != null && !FrsGameStrategyMainFragment.this.gxE.bcw().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.gxE.bcw().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.gxE != null && FrsGameStrategyMainFragment.this.gxE.bcw() != null && FrsGameStrategyMainFragment.this.gxE.bcw().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.gxE.bcw().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.fKa = bundle.getString("fid");
            this.gxD = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.fKa = getArguments().getString("fid");
            this.gxD = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.gxF = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.f.b.toLong(this.fKa, 0L), this.gxD);
        this.gxF.a(this.gxG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.ezg.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.ezg, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.ezg, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.emK, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gxF != null) {
            this.gxF.onDestory();
        }
        if (this.gxE != null) {
            this.gxE.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bFW();
        }
    }

    private void bFW() {
        if (this.ejJ && this.gxF != null) {
            this.gxF.bG(0, 0);
            this.ejJ = false;
            if (this.gxE != null) {
                this.isLoading = true;
                showLoadingView(this.gxE.getRootView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.gxE = new e(this, inflate);
        this.gxE.setFrom(this.mFrom);
        this.gxE.setFrsGameTabDataLoadListener(this.gxH);
        this.gxE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            bFW();
            bcw().setCenterTextTitle(this.gxD);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.fKa);
        bundle.putString("name", this.gxD);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gxE != null) {
            this.gxE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.gxF != null) {
            this.gxF.bG(0, 0);
        }
        if (this.gxE != null) {
            hideNetRefreshView(this.gxE.getRootView());
            this.isLoading = true;
            showLoadingView(this.gxE.getRootView());
        }
    }

    public String getFid() {
        return this.fKa;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.k.a.a.InterfaceC0072a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.checkCamera(getActivity().getApplicationContext())) {
                al.e(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ab.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar bcw() {
        if (this.gxE != null) {
            return this.gxE.bcw();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baZ() {
        if (!this.isLoading && this.gxE != null && j.isNetWorkAvailable()) {
            this.gxE.baZ();
        }
    }
}
