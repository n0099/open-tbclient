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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.n.a.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.tab.e;
import com.baidu.tieba.frs.game.strategy.view.d;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0277a, ap {
    private String fPy;
    private String gDc;
    private boolean isLoading;
    private d jwq;
    private b jwr;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b jws = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !x.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.jwq != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jwq.getRootView());
                    FrsGameStrategyMainFragment.this.jwq.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.jwq.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jwq.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void n(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.jwq != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jwq.getRootView());
                    FrsGameStrategyMainFragment.this.jwq.o(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jwq.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a jwt = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void ct(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jwr != null) {
                FrsGameStrategyMainFragment.this.jwr.ct(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cu(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jwr != null) {
                FrsGameStrategyMainFragment.this.jwr.cu(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean cv(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jwr != null) {
                return FrsGameStrategyMainFragment.this.jwr.cv(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.jwr != null) {
                return FrsGameStrategyMainFragment.this.jwr.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public e Ba(int i) {
            if (FrsGameStrategyMainFragment.this.jwr != null) {
                return FrsGameStrategyMainFragment.this.jwr.Ba(i);
            }
            return null;
        }
    };
    private CustomMessageListener gIn = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.bVE();
                }
            }
        }
    };
    private boolean gEY = true;
    private CustomMessageListener gYK = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.jwq != null && FrsGameStrategyMainFragment.this.jwq.bYq() != null && !FrsGameStrategyMainFragment.this.jwq.bYq().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.jwq.bYq().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.jwq != null && FrsGameStrategyMainFragment.this.jwq.bYq() != null && FrsGameStrategyMainFragment.this.jwq.bYq().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.jwq.bYq().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.fPy = bundle.getString("fid");
            this.gDc = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.fPy = getArguments().getString("fid");
            this.gDc = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.jwr = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.f.b.toLong(this.fPy, 0L), this.gDc);
        this.jwr.a(this.jws);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gYK.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.gYK, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.gYK, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gIn, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jwr != null) {
            this.jwr.onDestory();
        }
        if (this.jwq != null) {
            this.jwq.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cKr();
        }
    }

    private void cKr() {
        if (this.gEY && this.jwr != null) {
            this.jwr.ct(0, 0);
            this.gEY = false;
            if (this.jwq != null) {
                this.isLoading = true;
                showLoadingView(this.jwq.getRootView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.jwq = new d(this, inflate);
        this.jwq.setFrom(this.mFrom);
        this.jwq.setFrsGameTabDataLoadListener(this.jwt);
        this.jwq.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            cKr();
            bYq().setCenterTextTitle(this.gDc);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.fPy);
        bundle.putString("name", this.gDc);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jwq != null) {
            this.jwq.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.jwr != null) {
            this.jwr.ct(0, 0);
        }
        if (this.jwq != null) {
            hideNetRefreshView(this.jwq.getRootView());
            this.isLoading = true;
            showLoadingView(this.jwq.getRootView());
        }
    }

    public String getFid() {
        return this.fPy;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.n.a.a.InterfaceC0277a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ad.checkCamera(getActivity().getApplicationContext())) {
                an.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ad.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bYq() {
        if (this.jwq != null) {
            return this.jwq.bYq();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVE() {
        if (!this.isLoading && this.jwq != null && j.isNetWorkAvailable()) {
            this.jwq.bVE();
        }
    }
}
