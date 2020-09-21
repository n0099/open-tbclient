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
/* loaded from: classes21.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0209a, at {
    private String eYo;
    private String fIi;
    private e ios;
    private b iot;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b iou = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<q> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !y.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.ios != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.ios.getRootView());
                    FrsGameStrategyMainFragment.this.ios.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.ios.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.ios.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void k(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.ios != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.ios.getRootView());
                    FrsGameStrategyMainFragment.this.ios.l(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.ios.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a iov = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cn(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.iot != null) {
                FrsGameStrategyMainFragment.this.iot.cn(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void co(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.iot != null) {
                FrsGameStrategyMainFragment.this.iot.co(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean cp(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.iot != null) {
                return FrsGameStrategyMainFragment.this.iot.cp(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.iot != null) {
                return FrsGameStrategyMainFragment.this.iot.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e yq(int i) {
            if (FrsGameStrategyMainFragment.this.iot != null) {
                return FrsGameStrategyMainFragment.this.iot.yq(i);
            }
            return null;
        }
    };
    private CustomMessageListener fNj = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.bIh();
                }
            }
        }
    };
    private boolean fJY = true;
    private CustomMessageListener gck = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.ios != null && FrsGameStrategyMainFragment.this.ios.bKS() != null && !FrsGameStrategyMainFragment.this.ios.bKS().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.ios.bKS().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.ios != null && FrsGameStrategyMainFragment.this.ios.bKS() != null && FrsGameStrategyMainFragment.this.ios.bKS().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.ios.bKS().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.eYo = bundle.getString("fid");
            this.fIi = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.eYo = getArguments().getString("fid");
            this.fIi = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.iot = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.f.b.toLong(this.eYo, 0L), this.fIi);
        this.iot.a(this.iou);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gck.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.gck, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.gck, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fNj, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.iot != null) {
            this.iot.onDestory();
        }
        if (this.ios != null) {
            this.ios.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            ctw();
        }
    }

    private void ctw() {
        if (this.fJY && this.iot != null) {
            this.iot.cn(0, 0);
            this.fJY = false;
            if (this.ios != null) {
                this.isLoading = true;
                showLoadingView(this.ios.getRootView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.ios = new e(this, inflate);
        this.ios.setFrom(this.mFrom);
        this.ios.setFrsGameTabDataLoadListener(this.iov);
        this.ios.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            ctw();
            bKS().setCenterTextTitle(this.fIi);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.eYo);
        bundle.putString("name", this.fIi);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ios != null) {
            this.ios.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.iot != null) {
            this.iot.cn(0, 0);
        }
        if (this.ios != null) {
            hideNetRefreshView(this.ios.getRootView());
            this.isLoading = true;
            showLoadingView(this.ios.getRootView());
        }
    }

    public String getFid() {
        return this.eYo;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.m.a.a.InterfaceC0209a
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
    public NavigationBar bKS() {
        if (this.ios != null) {
            return this.ios.bKS();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIh() {
        if (!this.isLoading && this.ios != null && j.isNetWorkAvailable()) {
            this.ios.bIh();
        }
    }
}
