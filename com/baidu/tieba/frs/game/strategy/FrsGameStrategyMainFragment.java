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
import com.baidu.e.a.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0062a, ak {
    private String cBR;
    private String dwC;
    private e dwD;
    private b dwE;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b dwF = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !w.z(list2)) {
                if (FrsGameStrategyMainFragment.this.dwD != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dwD.getRootView());
                    FrsGameStrategyMainFragment.this.dwD.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.dwD.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dwD.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(f.j.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(f.e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void c(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.dwD != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dwD.getRootView());
                    FrsGameStrategyMainFragment.this.dwD.d(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dwD.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(f.e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a dwG = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aF(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dwE != null) {
                FrsGameStrategyMainFragment.this.dwE.aF(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aG(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dwE != null) {
                FrsGameStrategyMainFragment.this.dwE.aG(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean aH(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dwE != null) {
                return FrsGameStrategyMainFragment.this.dwE.aH(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.dwE != null) {
                return FrsGameStrategyMainFragment.this.dwE.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e kW(int i) {
            if (FrsGameStrategyMainFragment.this.dwE != null) {
                return FrsGameStrategyMainFragment.this.dwE.kW(i);
            }
            return null;
        }
    };
    private CustomMessageListener bxz = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.Ul();
                }
            }
        }
    };
    private boolean byZ = true;
    private CustomMessageListener bGJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.dwD != null && FrsGameStrategyMainFragment.this.dwD.Vj() != null && !FrsGameStrategyMainFragment.this.dwD.Vj().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.dwD.Vj().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.dwD != null && FrsGameStrategyMainFragment.this.dwD.Vj() != null && FrsGameStrategyMainFragment.this.dwD.Vj().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.dwD.Vj().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cBR = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dwC = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.cBR = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dwC = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.dwE = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.cBR, 0L), this.dwC);
        this.dwE.a(this.dwF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bGJ.setSelfListener(true);
        registerListener(2001617, this.bGJ, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.bGJ, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.bxz, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dwE != null) {
            this.dwE.onDestory();
        }
        if (this.dwD != null) {
            this.dwD.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            axJ();
        }
    }

    private void axJ() {
        if (this.byZ && this.dwE != null) {
            this.dwE.aF(0, 0);
            this.byZ = false;
            if (this.dwD != null) {
                this.isLoading = true;
                showLoadingView(this.dwD.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(f.h.frs_game_strategy_layout, (ViewGroup) null);
        this.dwD = new e(this, inflate);
        this.dwD.setFrom(this.mFrom);
        this.dwD.setFrsGameTabDataLoadListener(this.dwG);
        this.dwD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            axJ();
            Vj().setCenterTextTitle(this.dwC);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cBR);
        bundle.putString("name", this.dwC);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dwD != null) {
            this.dwD.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dwE != null) {
            this.dwE.aF(0, 0);
        }
        if (this.dwD != null) {
            hideNetRefreshView(this.dwD.getRootView());
            this.isLoading = true;
            showLoadingView(this.dwD.getRootView());
        }
    }

    public String getFid() {
        return this.cBR;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aN(getActivity().getApplicationContext())) {
                al.b(getPageContext());
            } else {
                showToast(f.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(f.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar Vj() {
        if (this.dwD != null) {
            return this.dwD.Vj();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ul() {
        if (!this.isLoading && this.dwD != null && j.jE()) {
            this.dwD.Ul();
        }
    }
}
