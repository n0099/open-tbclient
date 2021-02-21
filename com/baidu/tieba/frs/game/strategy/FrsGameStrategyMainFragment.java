package com.baidu.tieba.frs.game.strategy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.n;
import com.baidu.l.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.tab.e;
import com.baidu.tieba.frs.game.strategy.view.d;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0148a, ap {
    private String fNd;
    private String gBt;
    private boolean isLoading;
    private d jxE;
    private b jxF;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b jxG = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !y.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.jxE != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jxE.getRootView());
                    FrsGameStrategyMainFragment.this.jxE.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.jxE.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jxE.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void m(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.jxE != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jxE.getRootView());
                    FrsGameStrategyMainFragment.this.jxE.n(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jxE.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a jxH = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cr(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jxF != null) {
                FrsGameStrategyMainFragment.this.jxF.cr(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cs(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jxF != null) {
                FrsGameStrategyMainFragment.this.jxF.cs(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean ct(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jxF != null) {
                return FrsGameStrategyMainFragment.this.jxF.ct(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.jxF != null) {
                return FrsGameStrategyMainFragment.this.jxF.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public e zE(int i) {
            if (FrsGameStrategyMainFragment.this.jxF != null) {
                return FrsGameStrategyMainFragment.this.jxF.zE(i);
            }
            return null;
        }
    };
    private CustomMessageListener gGF = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.bSx();
                }
            }
        }
    };
    private boolean gDp = true;
    private CustomMessageListener gXc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.jxE != null && FrsGameStrategyMainFragment.this.jxE.bVk() != null && !FrsGameStrategyMainFragment.this.jxE.bVk().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.jxE.bVk().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.jxE != null && FrsGameStrategyMainFragment.this.jxE.bVk() != null && FrsGameStrategyMainFragment.this.jxE.bVk().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.jxE.bVk().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.fNd = bundle.getString("fid");
            this.gBt = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.fNd = getArguments().getString("fid");
            this.gBt = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.jxF = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.f.b.toLong(this.fNd, 0L), this.gBt);
        this.jxF.a(this.jxG);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gXc.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.gXc, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.gXc, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gGF, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jxF != null) {
            this.jxF.onDestory();
        }
        if (this.jxE != null) {
            this.jxE.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cHU();
        }
    }

    private void cHU() {
        if (this.gDp && this.jxF != null) {
            this.jxF.cr(0, 0);
            this.gDp = false;
            if (this.jxE != null) {
                this.isLoading = true;
                showLoadingView(this.jxE.getRootView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.jxE = new d(this, inflate);
        this.jxE.setFrom(this.mFrom);
        this.jxE.setFrsGameTabDataLoadListener(this.jxH);
        this.jxE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            cHU();
            bVk().setCenterTextTitle(this.gBt);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.fNd);
        bundle.putString("name", this.gBt);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jxE != null) {
            this.jxE.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.jxF != null) {
            this.jxF.cr(0, 0);
        }
        if (this.jxE != null) {
            hideNetRefreshView(this.jxE.getRootView());
            this.isLoading = true;
            showLoadingView(this.jxE.getRootView());
        }
    }

    public String getFid() {
        return this.fNd;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0148a
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

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bVk() {
        if (this.jxE != null) {
            return this.jxE.bVk();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSx() {
        if (!this.isLoading && this.jxE != null && j.isNetWorkAvailable()) {
            this.jxE.bSx();
        }
    }
}
