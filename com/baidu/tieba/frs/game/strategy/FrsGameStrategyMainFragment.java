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
import com.baidu.l.a.a;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.tab.e;
import com.baidu.tieba.frs.game.strategy.view.d;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0154a, ap {
    private String fOD;
    private String gDc;
    private boolean isLoading;
    private d jzn;
    private b jzo;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b jzp = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !y.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.jzn != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jzn.getRootView());
                    FrsGameStrategyMainFragment.this.jzn.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.jzn.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jzn.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void m(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.jzn != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jzn.getRootView());
                    FrsGameStrategyMainFragment.this.jzn.n(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jzn.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a jzq = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cr(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jzo != null) {
                FrsGameStrategyMainFragment.this.jzo.cr(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cs(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jzo != null) {
                FrsGameStrategyMainFragment.this.jzo.cs(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean ct(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jzo != null) {
                return FrsGameStrategyMainFragment.this.jzo.ct(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.jzo != null) {
                return FrsGameStrategyMainFragment.this.jzo.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public e zF(int i) {
            if (FrsGameStrategyMainFragment.this.jzo != null) {
                return FrsGameStrategyMainFragment.this.jzo.zF(i);
            }
            return null;
        }
    };
    private CustomMessageListener gIo = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.bSD();
                }
            }
        }
    };
    private boolean gEY = true;
    private CustomMessageListener gYL = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.jzn != null && FrsGameStrategyMainFragment.this.jzn.bVq() != null && !FrsGameStrategyMainFragment.this.jzn.bVq().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.jzn.bVq().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.jzn != null && FrsGameStrategyMainFragment.this.jzn.bVq() != null && FrsGameStrategyMainFragment.this.jzn.bVq().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.jzn.bVq().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.fOD = bundle.getString("fid");
            this.gDc = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.fOD = getArguments().getString("fid");
            this.gDc = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.jzo = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.f.b.toLong(this.fOD, 0L), this.gDc);
        this.jzo.a(this.jzp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gYL.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.gYL, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.gYL, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gIo, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jzo != null) {
            this.jzo.onDestory();
        }
        if (this.jzn != null) {
            this.jzn.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cIa();
        }
    }

    private void cIa() {
        if (this.gEY && this.jzo != null) {
            this.jzo.cr(0, 0);
            this.gEY = false;
            if (this.jzn != null) {
                this.isLoading = true;
                showLoadingView(this.jzn.getRootView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.jzn = new d(this, inflate);
        this.jzn.setFrom(this.mFrom);
        this.jzn.setFrsGameTabDataLoadListener(this.jzq);
        this.jzn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            cIa();
            bVq().setCenterTextTitle(this.gDc);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.fOD);
        bundle.putString("name", this.gDc);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jzn != null) {
            this.jzn.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.jzo != null) {
            this.jzo.cr(0, 0);
        }
        if (this.jzn != null) {
            hideNetRefreshView(this.jzn.getRootView());
            this.isLoading = true;
            showLoadingView(this.jzn.getRootView());
        }
    }

    public String getFid() {
        return this.fOD;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0154a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ae.checkCamera(getActivity().getApplicationContext())) {
                ao.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ae.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bVq() {
        if (this.jzn != null) {
            return this.jzn.bVq();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSD() {
        if (!this.isLoading && this.jzn != null && j.isNetWorkAvailable()) {
            this.jzn.bSD();
        }
    }
}
