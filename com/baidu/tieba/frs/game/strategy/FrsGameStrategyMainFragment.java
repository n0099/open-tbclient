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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0049a, ah {
    private String eHo;
    private String fHC;
    private e fHD;
    private b fHE;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b fHF = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.aa(list2)) {
                if (FrsGameStrategyMainFragment.this.fHD != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fHD.getRootView());
                    FrsGameStrategyMainFragment.this.fHD.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.fHD.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fHD.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void f(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.fHD != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fHD.getRootView());
                    FrsGameStrategyMainFragment.this.fHD.g(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fHD.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a fHG = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bv(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fHE != null) {
                FrsGameStrategyMainFragment.this.fHE.bv(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bw(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fHE != null) {
                FrsGameStrategyMainFragment.this.fHE.bw(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean bx(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fHE != null) {
                return FrsGameStrategyMainFragment.this.fHE.bx(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.fHE != null) {
                return FrsGameStrategyMainFragment.this.fHE.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e sh(int i) {
            if (FrsGameStrategyMainFragment.this.fHE != null) {
                return FrsGameStrategyMainFragment.this.fHE.sh(i);
            }
            return null;
        }
    };
    private CustomMessageListener dvg = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.aKN();
                }
            }
        }
    };
    private boolean drA = true;
    private CustomMessageListener dFp = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.fHD != null && FrsGameStrategyMainFragment.this.fHD.aLN() != null && !FrsGameStrategyMainFragment.this.fHD.aLN().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.fHD.aLN().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.fHD != null && FrsGameStrategyMainFragment.this.fHD.aLN() != null && FrsGameStrategyMainFragment.this.fHD.aLN().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.fHD.aLN().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.eHo = bundle.getString("fid");
            this.fHC = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.eHo = getArguments().getString("fid");
            this.fHC = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.fHE = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.e(this.eHo, 0L), this.fHC);
        this.fHE.a(this.fHF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dFp.setSelfListener(true);
        registerListener(2001617, this.dFp, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.dFp, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.dvg, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fHE != null) {
            this.fHE.onDestory();
        }
        if (this.fHD != null) {
            this.fHD.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bqu();
        }
    }

    private void bqu() {
        if (this.drA && this.fHE != null) {
            this.fHE.bv(0, 0);
            this.drA = false;
            if (this.fHD != null) {
                this.isLoading = true;
                showLoadingView(this.fHD.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.fHD = new e(this, inflate);
        this.fHD.setFrom(this.mFrom);
        this.fHD.setFrsGameTabDataLoadListener(this.fHG);
        this.fHD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            bqu();
            aLN().setCenterTextTitle(this.fHC);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.eHo);
        bundle.putString("name", this.fHC);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fHD != null) {
            this.fHD.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.fHE != null) {
            this.fHE.bv(0, 0);
        }
        if (this.fHD != null) {
            hideNetRefreshView(this.fHD.getRootView());
            this.isLoading = true;
            showLoadingView(this.fHD.getRootView());
        }
    }

    public String getFid() {
        return this.eHo;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0049a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cy(getActivity().getApplicationContext())) {
                al.c(getPageContext());
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
    public NavigationBar aLN() {
        if (this.fHD != null) {
            return this.fHD.aLN();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKN() {
        if (!this.isLoading && this.fHD != null && j.kc()) {
            this.fHD.aKN();
        }
    }
}
