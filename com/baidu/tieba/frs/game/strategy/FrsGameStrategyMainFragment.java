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
import com.baidu.f.a.a;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0073a, ak {
    private String cQb;
    private String dLm;
    private e dLn;
    private b dLo;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b dLp = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.J(list2)) {
                if (FrsGameStrategyMainFragment.this.dLn != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dLn.getRootView());
                    FrsGameStrategyMainFragment.this.dLn.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.dLn.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dLn.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(e.j.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(e.C0175e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void c(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.dLn != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dLn.getRootView());
                    FrsGameStrategyMainFragment.this.dLn.d(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dLn.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(e.C0175e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a dLq = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aM(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dLo != null) {
                FrsGameStrategyMainFragment.this.dLo.aM(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aN(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dLo != null) {
                FrsGameStrategyMainFragment.this.dLo.aN(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean aO(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dLo != null) {
                return FrsGameStrategyMainFragment.this.dLo.aO(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.dLo != null) {
                return FrsGameStrategyMainFragment.this.dLo.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e lX(int i) {
            if (FrsGameStrategyMainFragment.this.dLo != null) {
                return FrsGameStrategyMainFragment.this.dLo.lX(i);
            }
            return null;
        }
    };
    private CustomMessageListener bLT = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.ZG();
                }
            }
        }
    };
    private boolean bNr = true;
    private CustomMessageListener bVa = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.dLn != null && FrsGameStrategyMainFragment.this.dLn.aaE() != null && !FrsGameStrategyMainFragment.this.dLn.aaE().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.dLn.aaE().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.dLn != null && FrsGameStrategyMainFragment.this.dLn.aaE() != null && FrsGameStrategyMainFragment.this.dLn.aaE().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.dLn.aaE().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cQb = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dLm = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.cQb = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dLm = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.dLo = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.d(this.cQb, 0L), this.dLm);
        this.dLo.a(this.dLp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bVa.setSelfListener(true);
        registerListener(2001617, this.bVa, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.bVa, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.bLT, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dLo != null) {
            this.dLo.onDestory();
        }
        if (this.dLn != null) {
            this.dLn.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aDs();
        }
    }

    private void aDs() {
        if (this.bNr && this.dLo != null) {
            this.dLo.aM(0, 0);
            this.bNr = false;
            if (this.dLn != null) {
                this.isLoading = true;
                showLoadingView(this.dLn.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_game_strategy_layout, (ViewGroup) null);
        this.dLn = new com.baidu.tieba.frs.game.strategy.view.e(this, inflate);
        this.dLn.setFrom(this.mFrom);
        this.dLn.setFrsGameTabDataLoadListener(this.dLq);
        this.dLn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            aDs();
            aaE().setCenterTextTitle(this.dLm);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cQb);
        bundle.putString("name", this.dLm);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dLn != null) {
            this.dLn.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dLo != null) {
            this.dLo.aM(0, 0);
        }
        if (this.dLn != null) {
            hideNetRefreshView(this.dLn.getRootView());
            this.isLoading = true;
            showLoadingView(this.dLn.getRootView());
        }
    }

    public String getFid() {
        return this.cQb;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aX(getActivity().getApplicationContext())) {
                com.baidu.tbadk.core.util.ak.b(getPageContext());
            } else {
                showToast(e.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(e.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar aaE() {
        if (this.dLn != null) {
            return this.dLn.aaE();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZG() {
        if (!this.isLoading && this.dLn != null && j.kX()) {
            this.dLn.ZG();
        }
    }
}
