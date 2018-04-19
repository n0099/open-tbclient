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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0045a, ai {
    private String crJ;
    private String dgq;
    private e dgr;
    private b dgs;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b dgt = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.w(list2)) {
                if (FrsGameStrategyMainFragment.this.dgr != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dgr.getRootView());
                    FrsGameStrategyMainFragment.this.dgr.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.dgr.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dgr.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(d.k.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void c(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.dgr != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dgr.getRootView());
                    FrsGameStrategyMainFragment.this.dgr.d(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dgr.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a dgu = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aC(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dgs != null) {
                FrsGameStrategyMainFragment.this.dgs.aC(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aD(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dgs != null) {
                FrsGameStrategyMainFragment.this.dgs.aD(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean aE(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dgs != null) {
                return FrsGameStrategyMainFragment.this.dgs.aE(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.dgs != null) {
                return FrsGameStrategyMainFragment.this.dgs.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e kB(int i) {
            if (FrsGameStrategyMainFragment.this.dgs != null) {
                return FrsGameStrategyMainFragment.this.dgs.kB(i);
            }
            return null;
        }
    };
    private CustomMessageListener bnc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.Ql();
                }
            }
        }
    };
    private boolean bvq = true;
    private CustomMessageListener bvk = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.dgr != null && FrsGameStrategyMainFragment.this.dgr.Rg() != null && !FrsGameStrategyMainFragment.this.dgr.Rg().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.dgr.Rg().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.dgr != null && FrsGameStrategyMainFragment.this.dgr.Rg() != null && FrsGameStrategyMainFragment.this.dgr.Rg().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.dgr.Rg().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.crJ = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dgq = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.crJ = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dgq = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.dgs = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.crJ, 0L), this.dgq);
        this.dgs.a(this.dgt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bvk.setSelfListener(true);
        registerListener(2001617, this.bvk, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.bvk, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.bnc, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dgs != null) {
            this.dgs.onDestory();
        }
        if (this.dgr != null) {
            this.dgr.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            asx();
        }
    }

    private void asx() {
        if (this.bvq && this.dgs != null) {
            this.dgs.aC(0, 0);
            this.bvq = false;
            if (this.dgr != null) {
                this.isLoading = true;
                showLoadingView(this.dgr.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_game_strategy_layout, (ViewGroup) null);
        this.dgr = new e(this, inflate);
        this.dgr.setFrom(this.mFrom);
        this.dgr.setFrsGameTabDataLoadListener(this.dgu);
        this.dgr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            asx();
            Rg().setCenterTextTitle(this.dgq);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.crJ);
        bundle.putString("name", this.dgq);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgr != null) {
            this.dgr.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dgs != null) {
            this.dgs.aC(0, 0);
        }
        if (this.dgr != null) {
            hideNetRefreshView(this.dgr.getRootView());
            this.isLoading = true;
            showLoadingView(this.dgr.getRootView());
        }
    }

    public String getFid() {
        return this.crJ;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aD(getActivity().getApplicationContext())) {
                aj.b(getPageContext());
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar Rg() {
        if (this.dgr != null) {
            return this.dgr.Rg();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ql() {
        if (!this.isLoading && this.dgr != null && j.gP()) {
            this.dgr.Ql();
        }
    }
}
