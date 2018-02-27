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
import com.baidu.adp.widget.ListView.i;
import com.baidu.d.a.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.game.strategy.a.b;
import com.baidu.tieba.frs.game.strategy.tab.c;
import com.baidu.tieba.frs.game.strategy.view.f;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseFragment implements a.InterfaceC0056a, am {
    private String cZI;
    private String dNE;
    private f dNF;
    private b dNG;
    private boolean isLoading;
    private c dNH = new c() { // from class: com.baidu.tieba.frs.game.strategy.a.1
        @Override // com.baidu.tieba.frs.game.strategy.tab.c
        public void a(int i, int i2, List<i> list, List<com.baidu.tieba.frs.game.strategy.tab.f> list2, boolean z, boolean z2, int i3) {
            if (i != 0 || i2 != 0 || !v.E(list2)) {
                if (a.this.dNF != null) {
                    a.this.isLoading = false;
                    a.this.hideLoadingView(a.this.dNF.getRootView());
                    a.this.dNF.b(i, i2, list, list2, z, z2, i3);
                    if (i == 0 && i2 == 0) {
                        a.this.dNF.h(list2, z2);
                        return;
                    }
                    return;
                }
                return;
            }
            a.this.showNetRefreshView(a.this.dNF.getRootView(), a.this.getResources().getString(d.j.no_data_text), false);
            a.this.setNetRefreshViewTopMargin(a.this.getResources().getDimensionPixelSize(d.e.ds240));
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.c
        public void e(int i, int i2, String str) {
            if (i != 0 || i2 != 0) {
                if (a.this.dNF != null) {
                    a.this.isLoading = false;
                    a.this.hideLoadingView(a.this.dNF.getRootView());
                    a.this.dNF.f(i, i2, str);
                    return;
                }
                return;
            }
            a.this.showNetRefreshView(a.this.dNF.getRootView(), str, false);
            a.this.setNetRefreshViewTopMargin(a.this.getResources().getDimensionPixelSize(d.e.ds240));
        }
    };
    private com.baidu.tieba.frs.game.strategy.tab.b dNI = new com.baidu.tieba.frs.game.strategy.tab.b() { // from class: com.baidu.tieba.frs.game.strategy.a.2
        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void bx(int i, int i2) {
            if (a.this.dNG != null) {
                a.this.dNG.bx(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public void by(int i, int i2) {
            if (a.this.dNG != null) {
                a.this.dNG.by(i, i2);
            }
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public boolean bz(int i, int i2) {
            if (a.this.dNG != null) {
                return a.this.dNG.bz(i, i2);
            }
            return false;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public String getForumId() {
            if (a.this.dNG != null) {
                return a.this.dNG.getForumId();
            }
            return null;
        }

        @Override // com.baidu.tieba.frs.game.strategy.tab.b
        public com.baidu.tieba.frs.game.strategy.tab.f no(int i) {
            if (a.this.dNG != null) {
                return a.this.dNG.no(i);
            }
            return null;
        }
    };
    private CustomMessageListener cda = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGoodsTab".equals(split[0])) {
                    a.this.XK();
                }
            }
        }
    };
    private boolean cld = true;
    private CustomMessageListener dNJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.game.strategy.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001617) {
                    if (a.this.dNF != null && a.this.dNF.avj() != null && !a.this.dNF.avj().getNavBarIsShow()) {
                        a.this.dNF.avj().showNavigationBarWithAnimation();
                    }
                } else if (customResponsedMessage.getCmd() == 2001618 && a.this.dNF != null && a.this.dNF.avj() != null && a.this.dNF.avj().getNavBarIsShow()) {
                    a.this.dNF.avj().hideNavigationBarWithAnimation();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.cZI = bundle.getString(ImageViewerConfig.FORUM_ID);
            this.dNE = bundle.getString("name");
        } else if (getArguments() != null) {
            this.cZI = getArguments().getString(ImageViewerConfig.FORUM_ID);
            this.dNE = getArguments().getString("name");
        }
        this.dNG = new b(getActivity(), getUniqueId(), com.baidu.adp.lib.g.b.c(this.cZI, 0L), this.dNE);
        this.dNG.a(this.dNH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.dNJ.setSelfListener(true);
        registerListener(2001617, this.dNJ, getBaseFragmentActivity().getUniqueId());
        registerListener(2001618, this.dNJ, getBaseFragmentActivity().getUniqueId());
        registerListener(2001446, this.cda, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dNG != null) {
            this.dNG.onDestory();
        }
        if (this.dNF != null) {
            this.dNF.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.cld && this.dNG != null) {
            this.dNG.bx(0, 0);
            this.cld = false;
            if (this.dNF != null) {
                this.isLoading = true;
                showLoadingView(this.dNF.getRootView());
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_game_strategy_layout, (ViewGroup) null);
        this.dNF = new f(this, inflate);
        this.dNF.setFrsGameTabDataLoadListener(this.dNI);
        this.dNF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(ImageViewerConfig.FORUM_ID, this.cZI);
        bundle.putString("name", this.dNE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dNF != null) {
            this.dNF.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dNG != null) {
            this.dNG.bx(0, 0);
        }
        if (this.dNF != null) {
            hideNetRefreshView(this.dNF.getRootView());
            this.isLoading = true;
            showLoadingView(this.dNF.getRootView());
        }
    }

    public String getFid() {
        return this.cZI;
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aT(getActivity().getApplicationContext())) {
                ai.b(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tieba.frs.am
    public NavigationBar avj() {
        if (this.dNF != null) {
            return this.dNF.avj();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XK() {
        if (!this.isLoading && this.dNF != null && j.oJ()) {
            this.dNF.XK();
        }
    }
}
