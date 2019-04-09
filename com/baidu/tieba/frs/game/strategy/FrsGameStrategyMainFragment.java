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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0042a, ah {
    private String ekN;
    private String fjF;
    private e fjG;
    private b fjH;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b fjI = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.T(list2)) {
                if (FrsGameStrategyMainFragment.this.fjG != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fjG.getRootView());
                    FrsGameStrategyMainFragment.this.fjG.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.fjG.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fjG.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(d.j.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void e(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.fjG != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fjG.getRootView());
                    FrsGameStrategyMainFragment.this.fjG.f(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fjG.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a fjJ = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bj(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fjH != null) {
                FrsGameStrategyMainFragment.this.fjH.bj(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bk(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fjH != null) {
                FrsGameStrategyMainFragment.this.fjH.bk(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean bl(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fjH != null) {
                return FrsGameStrategyMainFragment.this.fjH.bl(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.fjH != null) {
                return FrsGameStrategyMainFragment.this.fjH.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e qB(int i) {
            if (FrsGameStrategyMainFragment.this.fjH != null) {
                return FrsGameStrategyMainFragment.this.fjH.qB(i);
            }
            return null;
        }
    };
    private CustomMessageListener dgB = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.aCq();
                }
            }
        }
    };
    private boolean ddh = true;
    private CustomMessageListener dpx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.fjG != null && FrsGameStrategyMainFragment.this.fjG.aDm() != null && !FrsGameStrategyMainFragment.this.fjG.aDm().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.fjG.aDm().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.fjG != null && FrsGameStrategyMainFragment.this.fjG.aDm() != null && FrsGameStrategyMainFragment.this.fjG.aDm().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.fjG.aDm().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.ekN = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.fjF = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.ekN = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.fjF = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.fjH = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.d(this.ekN, 0L), this.fjF);
        this.fjH.a(this.fjI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dpx.setSelfListener(true);
        registerListener(2001617, this.dpx, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.dpx, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.dgB, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fjH != null) {
            this.fjH.onDestory();
        }
        if (this.fjG != null) {
            this.fjG.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bga();
        }
    }

    private void bga() {
        if (this.ddh && this.fjH != null) {
            this.fjH.bj(0, 0);
            this.ddh = false;
            if (this.fjG != null) {
                this.isLoading = true;
                showLoadingView(this.fjG.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_game_strategy_layout, (ViewGroup) null);
        this.fjG = new e(this, inflate);
        this.fjG.setFrom(this.mFrom);
        this.fjG.setFrsGameTabDataLoadListener(this.fjJ);
        this.fjG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            bga();
            aDm().setCenterTextTitle(this.fjF);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.ekN);
        bundle.putString("name", this.fjF);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fjG != null) {
            this.fjG.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.fjH != null) {
            this.fjH.bj(0, 0);
        }
        if (this.fjG != null) {
            hideNetRefreshView(this.fjG.getRootView());
            this.isLoading = true;
            showLoadingView(this.fjG.getRootView());
        }
    }

    public String getFid() {
        return this.ekN;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0042a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.cS(getActivity().getApplicationContext())) {
                ak.c(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aDm() {
        if (this.fjG != null) {
            return this.fjG.aDm();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCq() {
        if (!this.isLoading && this.fjG != null && j.kY()) {
            this.fjG.aCq();
        }
    }
}
