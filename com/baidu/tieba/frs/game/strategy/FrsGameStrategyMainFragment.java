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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.tab.e;
import com.baidu.tieba.frs.game.strategy.view.d;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0148a, ap {
    private String fKR;
    private String gyv;
    private boolean isLoading;
    private d jrK;
    private b jrL;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b jrM = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !x.isEmpty(list2)) {
                if (FrsGameStrategyMainFragment.this.jrK != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jrK.getRootView());
                    FrsGameStrategyMainFragment.this.jrK.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.jrK.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jrK.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void n(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.jrK != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.jrK.getRootView());
                    FrsGameStrategyMainFragment.this.jrK.o(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.jrK.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a jrN = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void ct(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jrL != null) {
                FrsGameStrategyMainFragment.this.jrL.ct(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void cu(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jrL != null) {
                FrsGameStrategyMainFragment.this.jrL.cu(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean cv(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.jrL != null) {
                return FrsGameStrategyMainFragment.this.jrL.cv(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.jrL != null) {
                return FrsGameStrategyMainFragment.this.jrL.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public e zu(int i) {
            if (FrsGameStrategyMainFragment.this.jrL != null) {
                return FrsGameStrategyMainFragment.this.jrL.zu(i);
            }
            return null;
        }
    };
    private CustomMessageListener gDH = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.bRN();
                }
            }
        }
    };
    private boolean gAr = true;
    private CustomMessageListener gUe = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.jrK != null && FrsGameStrategyMainFragment.this.jrK.bUz() != null && !FrsGameStrategyMainFragment.this.jrK.bUz().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.jrK.bUz().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.jrK != null && FrsGameStrategyMainFragment.this.jrK.bUz() != null && FrsGameStrategyMainFragment.this.jrK.bUz().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.jrK.bUz().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.fKR = bundle.getString("fid");
            this.gyv = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.fKR = getArguments().getString("fid");
            this.gyv = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.jrL = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.f.b.toLong(this.fKR, 0L), this.gyv);
        this.jrL.a(this.jrM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.gUe.setSelfListener(true);
        registerListener(CmdConfigCustom.CMD_GAME_FRS_SHOW_TAB, this.gUe, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_GAME_FRS_HIDE_TAB, this.gUe, getBaseFragmentActivity().getUniqueId());
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gDH, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.jrL != null) {
            this.jrL.onDestory();
        }
        if (this.jrK != null) {
            this.jrK.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            cGA();
        }
    }

    private void cGA() {
        if (this.gAr && this.jrL != null) {
            this.jrL.ct(0, 0);
            this.gAr = false;
            if (this.jrK != null) {
                this.isLoading = true;
                showLoadingView(this.jrK.getRootView());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.jrK = new d(this, inflate);
        this.jrK.setFrom(this.mFrom);
        this.jrK.setFrsGameTabDataLoadListener(this.jrN);
        this.jrK.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            cGA();
            bUz().setCenterTextTitle(this.gyv);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.fKR);
        bundle.putString("name", this.gyv);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jrK != null) {
            this.jrK.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (this.jrL != null) {
            this.jrL.ct(0, 0);
        }
        if (this.jrK != null) {
            hideNetRefreshView(this.jrK.getRootView());
            this.isLoading = true;
            showLoadingView(this.jrK.getRootView());
        }
    }

    public String getFid() {
        return this.fKR;
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.l.a.a.InterfaceC0148a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ad.checkCamera(getActivity().getApplicationContext())) {
                an.g(getPageContext());
            } else {
                showToast(R.string.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> transformPermissionResult = ad.transformPermissionResult(strArr, iArr);
            if (transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(R.string.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bUz() {
        if (this.jrK != null) {
            return this.jrK.bUz();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        if (!this.isLoading && this.jrK != null && j.isNetWorkAvailable()) {
            this.jrK.bRN();
        }
    }
}
