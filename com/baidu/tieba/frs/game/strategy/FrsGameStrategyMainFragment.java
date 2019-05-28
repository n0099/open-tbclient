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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0041a, ah {
    private String eAC;
    private String fAb;
    private e fAc;
    private b fAd;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b fAe = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.aa(list2)) {
                if (FrsGameStrategyMainFragment.this.fAc != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fAc.getRootView());
                    FrsGameStrategyMainFragment.this.fAc.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.fAc.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fAc.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void f(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.fAc != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fAc.getRootView());
                    FrsGameStrategyMainFragment.this.fAc.g(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fAc.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a fAf = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bq(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fAd != null) {
                FrsGameStrategyMainFragment.this.fAd.bq(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void br(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fAd != null) {
                FrsGameStrategyMainFragment.this.fAd.br(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean bs(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fAd != null) {
                return FrsGameStrategyMainFragment.this.fAd.bs(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.fAd != null) {
                return FrsGameStrategyMainFragment.this.fAd.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e rJ(int i) {
            if (FrsGameStrategyMainFragment.this.fAd != null) {
                return FrsGameStrategyMainFragment.this.fAd.rJ(i);
            }
            return null;
        }
    };
    private CustomMessageListener drf = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.aIG();
                }
            }
        }
    };
    private boolean dnK = true;
    private CustomMessageListener dAd = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.fAc != null && FrsGameStrategyMainFragment.this.fAc.aJC() != null && !FrsGameStrategyMainFragment.this.fAc.aJC().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.fAc.aJC().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.fAc != null && FrsGameStrategyMainFragment.this.fAc.aJC() != null && FrsGameStrategyMainFragment.this.fAc.aJC().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.fAc.aJC().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.eAC = bundle.getString("fid");
            this.fAb = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.eAC = getArguments().getString("fid");
            this.fAb = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.fAd = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.eAC, 0L), this.fAb);
        this.fAd.a(this.fAe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dAd.setSelfListener(true);
        registerListener(2001617, this.dAd, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.dAd, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.drf, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fAd != null) {
            this.fAd.onDestory();
        }
        if (this.fAc != null) {
            this.fAc.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bnu();
        }
    }

    private void bnu() {
        if (this.dnK && this.fAd != null) {
            this.fAd.bq(0, 0);
            this.dnK = false;
            if (this.fAc != null) {
                this.isLoading = true;
                showLoadingView(this.fAc.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.fAc = new e(this, inflate);
        this.fAc.setFrom(this.mFrom);
        this.fAc.setFrsGameTabDataLoadListener(this.fAf);
        this.fAc.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            bnu();
            aJC().setCenterTextTitle(this.fAb);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.eAC);
        bundle.putString("name", this.fAb);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fAc != null) {
            this.fAc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.fAd != null) {
            this.fAd.bq(0, 0);
        }
        if (this.fAc != null) {
            hideNetRefreshView(this.fAc.getRootView());
            this.isLoading = true;
            showLoadingView(this.fAc.getRootView());
        }
    }

    public String getFid() {
        return this.eAC;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0041a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cx(getActivity().getApplicationContext())) {
                ak.c(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aJC() {
        if (this.fAc != null) {
            return this.fAc.aJC();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIG() {
        if (!this.isLoading && this.fAc != null && j.jS()) {
            this.fAc.aIG();
        }
    }
}
