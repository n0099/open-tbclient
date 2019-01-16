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
    private String dWq;
    private e dWr;
    private b dWs;
    private String dbr;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b dWt = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.I(list2)) {
                if (FrsGameStrategyMainFragment.this.dWr != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dWr.getRootView());
                    FrsGameStrategyMainFragment.this.dWr.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.dWr.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dWr.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(e.j.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(e.C0210e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void c(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.dWr != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dWr.getRootView());
                    FrsGameStrategyMainFragment.this.dWr.d(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dWr.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(e.C0210e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a dWu = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aO(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dWs != null) {
                FrsGameStrategyMainFragment.this.dWs.aO(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aP(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dWs != null) {
                FrsGameStrategyMainFragment.this.dWs.aP(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean aQ(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dWs != null) {
                return FrsGameStrategyMainFragment.this.dWs.aQ(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.dWs != null) {
                return FrsGameStrategyMainFragment.this.dWs.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e mS(int i) {
            if (FrsGameStrategyMainFragment.this.dWs != null) {
                return FrsGameStrategyMainFragment.this.dWs.mS(i);
            }
            return null;
        }
    };
    private CustomMessageListener bRi = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.abv();
                }
            }
        }
    };
    private boolean bSH = true;
    private CustomMessageListener cau = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.dWr != null && FrsGameStrategyMainFragment.this.dWr.act() != null && !FrsGameStrategyMainFragment.this.dWr.act().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.dWr.act().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.dWr != null && FrsGameStrategyMainFragment.this.dWr.act() != null && FrsGameStrategyMainFragment.this.dWr.act().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.dWr.act().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.dbr = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dWq = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.dbr = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dWq = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.dWs = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.d(this.dbr, 0L), this.dWq);
        this.dWs.a(this.dWt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cau.setSelfListener(true);
        registerListener(2001617, this.cau, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.cau, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.bRi, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dWs != null) {
            this.dWs.onDestory();
        }
        if (this.dWr != null) {
            this.dWr.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            aFK();
        }
    }

    private void aFK() {
        if (this.bSH && this.dWs != null) {
            this.dWs.aO(0, 0);
            this.bSH = false;
            if (this.dWr != null) {
                this.isLoading = true;
                showLoadingView(this.dWr.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_game_strategy_layout, (ViewGroup) null);
        this.dWr = new com.baidu.tieba.frs.game.strategy.view.e(this, inflate);
        this.dWr.setFrom(this.mFrom);
        this.dWr.setFrsGameTabDataLoadListener(this.dWu);
        this.dWr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            aFK();
            act().setCenterTextTitle(this.dWq);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.dbr);
        bundle.putString("name", this.dWq);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dWr != null) {
            this.dWr.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dWs != null) {
            this.dWs.aO(0, 0);
        }
        if (this.dWr != null) {
            hideNetRefreshView(this.dWr.getRootView());
            this.isLoading = true;
            showLoadingView(this.dWr.getRootView());
        }
    }

    public String getFid() {
        return this.dbr;
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
    public NavigationBar act() {
        if (this.dWr != null) {
            return this.dWr.act();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abv() {
        if (!this.isLoading && this.dWr != null && j.kV()) {
            this.dWr.abv();
        }
    }
}
