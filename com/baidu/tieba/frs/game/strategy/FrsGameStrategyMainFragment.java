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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.view.e;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameStrategyMainFragment extends BaseFragment implements a.InterfaceC0062a, ak {
    private String cBU;
    private String dwF;
    private e dwG;
    private b dwH;
    private boolean isLoading;
    private String mFrom;
    private com.baidu.tieba.frs.game.strategy.tab.b dwI = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void a(int i, int i2, List<h> list, List<com.baidu.tieba.frs.game.strategy.tab.e> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !w.z(list2)) {
                if (FrsGameStrategyMainFragment.this.dwG != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dwG.getRootView());
                    FrsGameStrategyMainFragment.this.dwG.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        FrsGameStrategyMainFragment.this.dwG.setTabData(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dwG.getRootView(), FrsGameStrategyMainFragment.this.getResources().getString(d.j.no_data_text), false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void c(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (FrsGameStrategyMainFragment.this.dwG != null) {
                    FrsGameStrategyMainFragment.this.isLoading = false;
                    FrsGameStrategyMainFragment.this.hideLoadingView(FrsGameStrategyMainFragment.this.dwG.getRootView());
                    FrsGameStrategyMainFragment.this.dwG.d(i, i2, str);
                    return;
                }
                return;
            }
            FrsGameStrategyMainFragment.this.showNetRefreshView(FrsGameStrategyMainFragment.this.dwG.getRootView(), str, false);
            FrsGameStrategyMainFragment.this.setNetRefreshViewTopMargin(FrsGameStrategyMainFragment.this.getResources().getDimensionPixelSize(d.e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.a dwJ = new com.baidu.tieba.frs.game.strategy.tab.a() { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aF(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dwH != null) {
                FrsGameStrategyMainFragment.this.dwH.aF(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public void aG(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dwH != null) {
                FrsGameStrategyMainFragment.this.dwH.aG(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public boolean aH(int i, int i2) {
            if (FrsGameStrategyMainFragment.this.dwH != null) {
                return FrsGameStrategyMainFragment.this.dwH.aH(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public String getForumId() {
            if (FrsGameStrategyMainFragment.this.dwH != null) {
                return FrsGameStrategyMainFragment.this.dwH.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.a
        public com.baidu.tieba.frs.game.strategy.tab.e kX(int i) {
            if (FrsGameStrategyMainFragment.this.dwH != null) {
                return FrsGameStrategyMainFragment.this.dwH.kX(i);
            }
            return null;
        }
    };
    private CustomMessageListener bxx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    FrsGameStrategyMainFragment.this.Ui();
                }
            }
        }
    };
    private boolean byX = true;
    private CustomMessageListener bGJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.FrsGameStrategyMainFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (FrsGameStrategyMainFragment.this.dwG != null && FrsGameStrategyMainFragment.this.dwG.Vf() != null && !FrsGameStrategyMainFragment.this.dwG.Vf().getNavBarIsShow()) {
                        FrsGameStrategyMainFragment.this.dwG.Vf().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && FrsGameStrategyMainFragment.this.dwG != null && FrsGameStrategyMainFragment.this.dwG.Vf() != null && FrsGameStrategyMainFragment.this.dwG.Vf().getNavBarIsShow()) {
                    FrsGameStrategyMainFragment.this.dwG.Vf().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cBU = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dwF = bundle.getString("name");
            this.mFrom = bundle.getString("key_from");
        } else if (getArguments() != null) {
            this.cBU = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dwF = getArguments().getString("name");
            this.mFrom = getArguments().getString("key_from");
        }
        this.dwH = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.cBU, 0L), this.dwF);
        this.dwH.a(this.dwI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.bGJ.setSelfListener(true);
        registerListener(2001617, this.bGJ, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.bGJ, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.bxx, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dwH != null) {
            this.dwH.onDestory();
        }
        if (this.dwG != null) {
            this.dwG.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            axL();
        }
    }

    private void axL() {
        if (this.byX && this.dwH != null) {
            this.dwH.aF(0, 0);
            this.byX = false;
            if (this.dwG != null) {
                this.isLoading = true;
                showLoadingView(this.dwG.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_game_strategy_layout, (ViewGroup) null);
        this.dwG = new e(this, inflate);
        this.dwG.setFrom(this.mFrom);
        this.dwG.setFrsGameTabDataLoadListener(this.dwJ);
        this.dwG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if ("from_single_act".equals(this.mFrom)) {
            axL();
            Vf().setCenterTextTitle(this.dwF);
        }
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cBU);
        bundle.putString("name", this.dwF);
        bundle.putString("key_from", this.mFrom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dwG != null) {
            this.dwG.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dwH != null) {
            this.dwH.aF(0, 0);
        }
        if (this.dwG != null) {
            hideNetRefreshView(this.dwG.getRootView());
            this.isLoading = true;
            showLoadingView(this.dwG.getRootView());
        }
    }

    public String getFid() {
        return this.cBU;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aO(getActivity().getApplicationContext())) {
                al.b(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar Vf() {
        if (this.dwG != null) {
            return this.dwG.Vf();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui() {
        if (!this.isLoading && this.dwG != null && j.jE()) {
            this.dwG.Ui();
        }
    }
}
