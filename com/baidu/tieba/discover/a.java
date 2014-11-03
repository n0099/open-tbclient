package com.baidu.tieba.discover;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ScrollView.BdPullRefreshScrollView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.XiubaPlugin;
import com.baidu.tieba.view.aa;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private static com.baidu.tbadk.b.a anC;
    private static List<DiscoverItemView> anD = new ArrayList(6);
    private static CustomMessageListener anG = new c(2009501);
    private static ViewGroup ank;
    private static BaseFragmentActivity mActivity;
    private View HT;
    private List<s> anB;
    private l anF;
    private ViewGroup anl;
    private BannerView anm;
    private DiscoverItemView ann;
    private DiscoverItemView ano;
    private DiscoverItemView anp;
    private DiscoverItemView anq;
    private DiscoverItemView anr;
    private DiscoverItemView ans;
    private NoNetworkView ant;
    private aa anu;
    private BdPullRefreshScrollView anv;
    private r anx;
    private boolean anw = false;
    private long any = 0;
    private String anz = null;
    private boolean anA = false;
    private List<DiscoverItemView> anE = new ArrayList();
    private com.baidu.adp.widget.ScrollView.l anH = new b(this);
    private View.OnClickListener He = new d(this);
    private CustomMessageListener anI = new e(this, 2012118);
    private n anJ = new f(this);
    private final CustomMessageListener anK = new g(this, 2001236);

    static {
        anG.setPriority(2);
    }

    private void initUI() {
        this.HT = getView();
        this.ant = (NoNetworkView) this.HT.findViewById(com.baidu.tieba.v.view_no_network);
        AL();
        this.anu = new aa(mActivity);
        this.anv = (BdPullRefreshScrollView) this.HT.findViewById(com.baidu.tieba.v.scroll_view);
        this.anv.setCustomHeaderView(this.anu);
        this.anv.setOnPullDownListener(this.anH);
        ank = (ViewGroup) this.HT.findViewById(com.baidu.tieba.v.local_dis_container);
        this.anl = (ViewGroup) this.HT.findViewById(com.baidu.tieba.v.mis_dis_container);
        this.anm = (BannerView) this.HT.findViewById(com.baidu.tieba.v.dis_banner);
        this.ann = (DiscoverItemView) this.HT.findViewById(com.baidu.tieba.v.item_friendsnews);
        this.ano = (DiscoverItemView) this.HT.findViewById(com.baidu.tieba.v.item_livetelecast);
        this.anp = (DiscoverItemView) this.HT.findViewById(com.baidu.tieba.v.item_findmore);
        this.anq = (DiscoverItemView) this.HT.findViewById(com.baidu.tieba.v.item_square);
        this.anr = (DiscoverItemView) this.HT.findViewById(com.baidu.tieba.v.item_qiandao);
        this.ans = (DiscoverItemView) this.HT.findViewById(com.baidu.tieba.v.item_member);
        this.ann.em(com.baidu.tieba.u.icon_friendsnews).en(y.friendsnews).f(this.He).eo(DiscoverItemView.anW).bw(TbadkApplication.m251getInst().isFriendFeedNew()).bx(false).by(false);
        this.ano.em(com.baidu.tieba.u.icon_live_telecast).en(y.livetelecast).f(this.He);
        this.anp.em(com.baidu.tieba.u.icon_find_more).en(y.data_more).f(this.He).bz(true);
        this.anp.setIconAutoChange(true);
        this.anq.em(com.baidu.tieba.u.icon_ba_square).en(y.square).f(this.He);
        this.anr.em(com.baidu.tieba.u.icon_all_sign_dis).en(y.ba_all_sign).f(this.He);
        this.ans.em(com.baidu.tieba.u.icon_member_center).en(y.member_center).f(this.He).bz(false).bw(true).bx(true);
        anD.add(this.anq);
        anD.add(this.ann);
        anD.add(this.anp);
        anD.add(this.anr);
        anD.add(this.ano);
        anD.add(this.ans);
    }

    protected void AK() {
        MessageManager.getInstance().registerListener(anG);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2009501, new com.baidu.tbadk.b.a(mActivity)));
    }

    private void AL() {
        this.ant.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yj() {
        if (this.anF != null) {
            this.anF.AQ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.w.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (BaseFragmentActivity) activity;
        MessageManager.getInstance().registerListener(this.anI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.anI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        AK();
        initUI();
        this.anF = new l(this.anJ);
        registerListener(this.anK);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ann.bw(TbadkApplication.m251getInst().isFriendFeedNew());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(false)));
        if (!this.anw && com.baidu.adp.lib.util.m.isNetOk()) {
            this.anv.setRefreshing(1);
            com.baidu.tbadk.core.j.m(mActivity, "found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        mActivity.getLayoutMode().L(i == 1);
        mActivity.getLayoutMode().h(this.HT.findViewById(com.baidu.tieba.v.container));
        for (DiscoverItemView discoverItemView : anD) {
            discoverItemView.onChangeSkinType(i);
        }
        for (DiscoverItemView discoverItemView2 : this.anE) {
            discoverItemView2.onChangeSkinType(i);
        }
        this.ant.onChangeSkinType(i);
        this.anu.bM(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(long j) {
        long j2 = com.baidu.tbadk.core.sharedPref.b.lk().getLong("game_last_time", 0L);
        if (j2 == 0 || j > j2) {
            com.baidu.tbadk.core.sharedPref.b.lk().putLong("game_last_time", j);
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("game_is_show_tip", true);
            return true;
        }
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("game_is_show_tip", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void AM() {
        if (anC != null && anC.ra() != null) {
            DiscoverItemView discoverItemView = new DiscoverItemView(mActivity);
            ank.removeAllViews();
            discoverItemView.em(anC.qY()).en(anC.qZ()).f(anC.ra());
            ank.addView(discoverItemView);
            discoverItemView.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            discoverItemView.bz(true);
            anD.add(discoverItemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        if (this.anB != null) {
            this.anl.removeAllViews();
            this.anE.clear();
            this.anA = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("game_is_show_tip", false);
            int size = this.anB.size();
            for (int i = 0; i < size; i++) {
                s sVar = this.anB.get(i);
                if (sVar != null) {
                    DiscoverItemView discoverItemView = new DiscoverItemView(mActivity);
                    discoverItemView.eA(sVar.mIconUrl).eB(sVar.aog).eC(sVar.mTitle).bw(sVar.VO).bx(true).eD(sVar.aog).f(this.He);
                    if (!TextUtils.isEmpty(this.anz) && this.anz.equals(sVar.aog) && (z || this.anA)) {
                        discoverItemView.bx(false);
                        discoverItemView.bw(this.anA);
                        if (sVar.VO) {
                            TbadkSettings.getInst().saveBoolean(com.baidu.adp.lib.util.u.aE(sVar.aog), true);
                        }
                    }
                    if (i == 0) {
                        this.ans.bz(false);
                    }
                    this.anl.addView(discoverItemView);
                    discoverItemView.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
                    this.anE.add(discoverItemView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN() {
        XiubaPlugin xiubaPlugin;
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_XIUBA);
        if (pluginByName != null && pluginByName.checkEnable() && (xiubaPlugin = (XiubaPlugin) pluginByName.getClassInstance(XiubaPlugin.class)) != null) {
            xiubaPlugin.startXiuba(mActivity);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 23005 || i == 23006) {
                AN();
            }
        }
    }
}
