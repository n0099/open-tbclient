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
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0041a, ah {
    private String eFy;
    private String fEZ;
    private e fFa;
    private b fFb;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b fFc = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<m> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.aa(list2)) {
                if (FrsGameStrategyMainFragment.this.fFa != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fFa.getRootView());
                    FrsGameStrategyMainFragment.this.fFa.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.fFa.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fFa.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(R.string.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void f(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.fFa != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.fFa.getRootView());
                    FrsGameStrategyMainFragment.this.fFa.g(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.fFa.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(R.dimen.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a fFd = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bv(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fFb != null) {
                FrsGameStrategyMainFragment.this.fFb.bv(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void bw(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fFb != null) {
                FrsGameStrategyMainFragment.this.fFb.bw(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean bx(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.fFb != null) {
                return FrsGameStrategyMainFragment.this.fFb.bx(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.fFb != null) {
                return FrsGameStrategyMainFragment.this.fFb.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e sb(int i) {
            if (FrsGameStrategyMainFragment.this.fFb != null) {
                return FrsGameStrategyMainFragment.this.fFb.sb(i);
            }
            return null;
        }
    };
    private CustomMessageListener dto = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.aKh();
                }
            }
        }
    };
    private boolean dpI = true;
    private CustomMessageListener dDx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.fFa != null && FrsGameStrategyMainFragment.this.fFa.aLh() != null && !FrsGameStrategyMainFragment.this.fFa.aLh().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.fFa.aLh().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.fFa != null && FrsGameStrategyMainFragment.this.fFa.aLh() != null && FrsGameStrategyMainFragment.this.fFa.aLh().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.fFa.aLh().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.eFy = bundle.getString("fid");
            this.fEZ = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.eFy = getArguments().getString("fid");
            this.fEZ = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.fFb = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.eFy, 0L), this.fEZ);
        this.fFb.a(this.fFc);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dDx.setSelfListener(true);
        registerListener(2001617, this.dDx, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.dDx, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.dto, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fFb != null) {
            this.fFb.onDestory();
        }
        if (this.fFa != null) {
            this.fFa.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            bpv();
        }
    }

    private void bpv() {
        if (this.dpI && this.fFb != null) {
            this.fFb.bv(0, 0);
            this.dpI = false;
            if (this.fFa != null) {
                this.isLoading = true;
                showLoadingView(this.fFa.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_game_strategy_layout, (ViewGroup) null);
        this.fFa = new e(this, inflate);
        this.fFa.setFrom(this.mFrom);
        this.fFa.setFrsGameTabDataLoadListener(this.fFd);
        this.fFa.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            bpv();
            aLh().setCenterTextTitle(this.fEZ);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("fid", this.eFy);
        bundle.putString("name", this.fEZ);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fFa != null) {
            this.fFa.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.fFb != null) {
            this.fFb.bv(0, 0);
        }
        if (this.fFa != null) {
            hideNetRefreshView(this.fFa.getRootView());
            this.isLoading = true;
            showLoadingView(this.fFa.getRootView());
        }
    }

    public String getFid() {
        return this.eFy;
    }

    @Override // android.support.v4.app.Fragment, com.baidu.e.a.a.InterfaceC0041a
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
    public NavigationBar aLh() {
        if (this.fFa != null) {
            return this.fFa.aLh();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        if (!this.isLoading && this.fFa != null && j.kc()) {
            this.fFa.aKh();
        }
    }
}
