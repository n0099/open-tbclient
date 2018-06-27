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
import com.baidu.d.a.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0062a, ak {
    private String czo;
    private String dtS;
    private e dtT;
    private b dtU;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b dtV = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !w.A(list2)) {
                if (FrsGameStrategyMainFragment.this.dtT != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dtT.getRootView());
                    FrsGameStrategyMainFragment.this.dtT.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.dtT.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dtT.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(d.k.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void c(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.dtT != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dtT.getRootView());
                    FrsGameStrategyMainFragment.this.dtT.d(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dtT.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a dtW = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aC(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dtU != null) {
                FrsGameStrategyMainFragment.this.dtU.aC(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aD(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dtU != null) {
                FrsGameStrategyMainFragment.this.dtU.aD(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean aE(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dtU != null) {
                return FrsGameStrategyMainFragment.this.dtU.aE(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.dtU != null) {
                return FrsGameStrategyMainFragment.this.dtU.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e kM(int i) {
            if (FrsGameStrategyMainFragment.this.dtU != null) {
                return FrsGameStrategyMainFragment.this.dtU.kM(i);
            }
            return null;
        }
    };
    private CustomMessageListener bwS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.Ua();
                }
            }
        }
    };
    private boolean byr = true;
    private CustomMessageListener bFU = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.dtT != null && FrsGameStrategyMainFragment.this.dtT.UW() != null && !FrsGameStrategyMainFragment.this.dtT.UW().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.dtT.UW().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.dtT != null && FrsGameStrategyMainFragment.this.dtT.UW() != null && FrsGameStrategyMainFragment.this.dtT.UW().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.dtT.UW().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.czo = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dtS = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.czo = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dtS = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.dtU = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.czo, 0L), this.dtS);
        this.dtU.a(this.dtV);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bFU.setSelfListener(true);
        registerListener(2001617, this.bFU, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.bFU, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.bwS, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dtU != null) {
            this.dtU.onDestory();
        }
        if (this.dtT != null) {
            this.dtT.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            axg();
        }
    }

    private void axg() {
        if (this.byr && this.dtU != null) {
            this.dtU.aC(0, 0);
            this.byr = false;
            if (this.dtT != null) {
                this.isLoading = true;
                showLoadingView(this.dtT.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_game_strategy_layout, (ViewGroup) null);
        this.dtT = new e(this, inflate);
        this.dtT.setFrom(this.mFrom);
        this.dtT.setFrsGameTabDataLoadListener(this.dtW);
        this.dtT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            axg();
            UW().setCenterTextTitle(this.dtS);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.czo);
        bundle.putString("name", this.dtS);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dtT != null) {
            this.dtT.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dtU != null) {
            this.dtU.aC(0, 0);
        }
        if (this.dtT != null) {
            hideNetRefreshView(this.dtT.getRootView());
            this.isLoading = true;
            showLoadingView(this.dtT.getRootView());
        }
    }

    public String getFid() {
        return this.czo;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aN(getActivity().getApplicationContext())) {
                al.b(getPageContext());
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar UW() {
        if (this.dtT != null) {
            return this.dtT.UW();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ua() {
        if (!this.isLoading && this.dtT != null && j.jD()) {
            this.dtT.Ua();
        }
    }
}
