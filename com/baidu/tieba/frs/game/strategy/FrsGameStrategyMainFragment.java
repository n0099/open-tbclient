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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0061a, ai {
    private String cBu;
    private String dqJ;
    private e dqK;
    private b dqL;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b dqM = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !w.z(list2)) {
                if (FrsGameStrategyMainFragment.this.dqK != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dqK.getRootView());
                    FrsGameStrategyMainFragment.this.dqK.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.dqK.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dqK.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(d.k.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void c(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.dqK != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dqK.getRootView());
                    FrsGameStrategyMainFragment.this.dqK.d(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dqK.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a dqN = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aD(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dqL != null) {
                FrsGameStrategyMainFragment.this.dqL.aD(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aE(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dqL != null) {
                FrsGameStrategyMainFragment.this.dqL.aE(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean aF(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dqL != null) {
                return FrsGameStrategyMainFragment.this.dqL.aF(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.dqL != null) {
                return FrsGameStrategyMainFragment.this.dqL.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e kF(int i) {
            if (FrsGameStrategyMainFragment.this.dqL != null) {
                return FrsGameStrategyMainFragment.this.dqL.kF(i);
            }
            return null;
        }
    };
    private CustomMessageListener bvx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.TG();
                }
            }
        }
    };
    private boolean bEd = true;
    private CustomMessageListener bDX = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.dqK != null && FrsGameStrategyMainFragment.this.dqK.UB() != null && !FrsGameStrategyMainFragment.this.dqK.UB().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.dqK.UB().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.dqK != null && FrsGameStrategyMainFragment.this.dqK.UB() != null && FrsGameStrategyMainFragment.this.dqK.UB().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.dqK.UB().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cBu = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dqJ = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.cBu = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dqJ = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.dqL = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.cBu, 0L), this.dqJ);
        this.dqL.a(this.dqM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bDX.setSelfListener(true);
        registerListener(2001617, this.bDX, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.bDX, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.bvx, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dqL != null) {
            this.dqL.onDestory();
        }
        if (this.dqK != null) {
            this.dqK.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            awC();
        }
    }

    private void awC() {
        if (this.bEd && this.dqL != null) {
            this.dqL.aD(0, 0);
            this.bEd = false;
            if (this.dqK != null) {
                this.isLoading = true;
                showLoadingView(this.dqK.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_game_strategy_layout, (ViewGroup) null);
        this.dqK = new e(this, inflate);
        this.dqK.setFrom(this.mFrom);
        this.dqK.setFrsGameTabDataLoadListener(this.dqN);
        this.dqK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            awC();
            UB().setCenterTextTitle(this.dqJ);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cBu);
        bundle.putString("name", this.dqJ);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dqK != null) {
            this.dqK.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dqL != null) {
            this.dqL.aD(0, 0);
        }
        if (this.dqK != null) {
            hideNetRefreshView(this.dqK.getRootView());
            this.isLoading = true;
            showLoadingView(this.dqK.getRootView());
        }
    }

    public String getFid() {
        return this.cBu;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aN(getActivity().getApplicationContext())) {
                ak.b(getPageContext());
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar UB() {
        if (this.dqK != null) {
            return this.dqK.UB();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TG() {
        if (!this.isLoading && this.dqK != null && j.jD()) {
            this.dqK.TG();
        }
    }
}
