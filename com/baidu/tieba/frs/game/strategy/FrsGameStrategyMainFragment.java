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
    private String csP;
    private String dhu;
    private e dhv;
    private b dhw;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b dhx = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.w(list2)) {
                if (FrsGameStrategyMainFragment.this.dhv != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dhv.getRootView());
                    FrsGameStrategyMainFragment.this.dhv.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.dhv.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dhv.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(d.k.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void c(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.dhv != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dhv.getRootView());
                    FrsGameStrategyMainFragment.this.dhv.d(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dhv.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a dhy = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aB(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dhw != null) {
                FrsGameStrategyMainFragment.this.dhw.aB(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aC(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dhw != null) {
                FrsGameStrategyMainFragment.this.dhw.aC(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean aD(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dhw != null) {
                return FrsGameStrategyMainFragment.this.dhw.aD(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.dhw != null) {
                return FrsGameStrategyMainFragment.this.dhw.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e kA(int i) {
            if (FrsGameStrategyMainFragment.this.dhw != null) {
                return FrsGameStrategyMainFragment.this.dhw.kA(i);
            }
            return null;
        }
    };
    private CustomMessageListener bnr = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.Qi();
                }
            }
        }
    };
    private boolean bwa = true;
    private CustomMessageListener bvU = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.dhv != null && FrsGameStrategyMainFragment.this.dhv.Rd() != null && !FrsGameStrategyMainFragment.this.dhv.Rd().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.dhv.Rd().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.dhv != null && FrsGameStrategyMainFragment.this.dhv.Rd() != null && FrsGameStrategyMainFragment.this.dhv.Rd().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.dhv.Rd().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.csP = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dhu = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.csP = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dhu = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.dhw = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.csP, 0L), this.dhu);
        this.dhw.a(this.dhx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bvU.setSelfListener(true);
        registerListener(2001617, this.bvU, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.bvU, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.bnr, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dhw != null) {
            this.dhw.onDestory();
        }
        if (this.dhv != null) {
            this.dhv.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            asw();
        }
    }

    private void asw() {
        if (this.bwa && this.dhw != null) {
            this.dhw.aB(0, 0);
            this.bwa = false;
            if (this.dhv != null) {
                this.isLoading = true;
                showLoadingView(this.dhv.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_game_strategy_layout, (ViewGroup) null);
        this.dhv = new e(this, inflate);
        this.dhv.setFrom(this.mFrom);
        this.dhv.setFrsGameTabDataLoadListener(this.dhy);
        this.dhv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            asw();
            Rd().setCenterTextTitle(this.dhu);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.csP);
        bundle.putString("name", this.dhu);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dhv != null) {
            this.dhv.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dhw != null) {
            this.dhw.aB(0, 0);
        }
        if (this.dhv != null) {
            hideNetRefreshView(this.dhv.getRootView());
            this.isLoading = true;
            showLoadingView(this.dhv.getRootView());
        }
    }

    public String getFid() {
        return this.csP;
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
    public NavigationBar Rd() {
        if (this.dhv != null) {
            return this.dhv.Rd();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qi() {
        if (!this.isLoading && this.dhv != null && j.gP()) {
            this.dhv.Qi();
        }
    }
}
