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
    private static ViewGroup anb;
    private static com.baidu.tbadk.b.a ant;
    private static List<DiscoverItemView> anu = new ArrayList(6);
    private static CustomMessageListener anx = new c(2009501);
    private static BaseFragmentActivity mActivity;
    private View HS;
    private ViewGroup anc;
    private BannerView and;
    private DiscoverItemView ane;
    private DiscoverItemView anf;
    private DiscoverItemView ang;
    private DiscoverItemView anh;
    private DiscoverItemView ani;
    private DiscoverItemView anj;
    private NoNetworkView ank;
    private aa anl;
    private BdPullRefreshScrollView anm;
    private r ano;
    private List<s> ans;
    private l anw;
    private boolean ann = false;
    private long anp = 0;
    private String anq = null;
    private boolean anr = false;
    private List<DiscoverItemView> anv = new ArrayList();
    private com.baidu.adp.widget.ScrollView.l any = new b(this);
    private View.OnClickListener Hd = new d(this);
    private CustomMessageListener anz = new e(this, 2012118);
    private n anA = new f(this);
    private final CustomMessageListener anB = new g(this, 2001236);

    static {
        anx.setPriority(2);
    }

    private void initUI() {
        this.HS = getView();
        this.ank = (NoNetworkView) this.HS.findViewById(com.baidu.tieba.v.view_no_network);
        AJ();
        this.anl = new aa(mActivity);
        this.anm = (BdPullRefreshScrollView) this.HS.findViewById(com.baidu.tieba.v.scroll_view);
        this.anm.setCustomHeaderView(this.anl);
        this.anm.setOnPullDownListener(this.any);
        anb = (ViewGroup) this.HS.findViewById(com.baidu.tieba.v.local_dis_container);
        this.anc = (ViewGroup) this.HS.findViewById(com.baidu.tieba.v.mis_dis_container);
        this.and = (BannerView) this.HS.findViewById(com.baidu.tieba.v.dis_banner);
        this.ane = (DiscoverItemView) this.HS.findViewById(com.baidu.tieba.v.item_friendsnews);
        this.anf = (DiscoverItemView) this.HS.findViewById(com.baidu.tieba.v.item_livetelecast);
        this.ang = (DiscoverItemView) this.HS.findViewById(com.baidu.tieba.v.item_findmore);
        this.anh = (DiscoverItemView) this.HS.findViewById(com.baidu.tieba.v.item_square);
        this.ani = (DiscoverItemView) this.HS.findViewById(com.baidu.tieba.v.item_qiandao);
        this.anj = (DiscoverItemView) this.HS.findViewById(com.baidu.tieba.v.item_member);
        this.ane.em(com.baidu.tieba.u.icon_friendsnews).en(y.friendsnews).f(this.Hd).eo(DiscoverItemView.anN).bw(TbadkApplication.m251getInst().isFriendFeedNew()).bx(false).by(false);
        this.anf.em(com.baidu.tieba.u.icon_live_telecast).en(y.livetelecast).f(this.Hd);
        this.ang.em(com.baidu.tieba.u.icon_find_more).en(y.data_more).f(this.Hd).bz(true);
        this.ang.setIconAutoChange(true);
        this.anh.em(com.baidu.tieba.u.icon_ba_square).en(y.square).f(this.Hd);
        this.ani.em(com.baidu.tieba.u.icon_all_sign_dis).en(y.ba_all_sign).f(this.Hd);
        this.anj.em(com.baidu.tieba.u.icon_member_center).en(y.member_center).f(this.Hd).bz(false).bw(true).bx(true);
        anu.add(this.anh);
        anu.add(this.ane);
        anu.add(this.ang);
        anu.add(this.ani);
        anu.add(this.anf);
        anu.add(this.anj);
    }

    protected void AI() {
        MessageManager.getInstance().registerListener(anx);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2009501, new com.baidu.tbadk.b.a(mActivity)));
    }

    private void AJ() {
        this.ank.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        if (this.anw != null) {
            this.anw.AO();
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
        MessageManager.getInstance().registerListener(this.anz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        MessageManager.getInstance().unRegisterListener(this.anz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        AI();
        initUI();
        this.anw = new l(this.anA);
        registerListener(this.anB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.ane.bw(TbadkApplication.m251getInst().isFriendFeedNew());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007004, new com.baidu.tbadk.mainTab.a(false)));
        if (!this.ann && com.baidu.adp.lib.util.m.isNetOk()) {
            this.anm.setRefreshing(1);
            com.baidu.tbadk.core.i.m(mActivity, "found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        mActivity.getLayoutMode().L(i == 1);
        mActivity.getLayoutMode().h(this.HS.findViewById(com.baidu.tieba.v.container));
        for (DiscoverItemView discoverItemView : anu) {
            discoverItemView.onChangeSkinType(i);
        }
        for (DiscoverItemView discoverItemView2 : this.anv) {
            discoverItemView2.onChangeSkinType(i);
        }
        this.ank.onChangeSkinType(i);
        this.anl.bM(i);
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
    public static void AK() {
        if (ant != null && ant.qY() != null) {
            DiscoverItemView discoverItemView = new DiscoverItemView(mActivity);
            anb.removeAllViews();
            discoverItemView.em(ant.qW()).en(ant.qX()).f(ant.qY());
            anb.addView(discoverItemView);
            discoverItemView.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
            discoverItemView.bz(true);
            anu.add(discoverItemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        if (this.ans != null) {
            this.anc.removeAllViews();
            this.anv.clear();
            this.anr = com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("game_is_show_tip", false);
            int size = this.ans.size();
            for (int i = 0; i < size; i++) {
                s sVar = this.ans.get(i);
                if (sVar != null) {
                    DiscoverItemView discoverItemView = new DiscoverItemView(mActivity);
                    discoverItemView.eA(sVar.mIconUrl).eB(sVar.anX).eC(sVar.mTitle).bw(sVar.VK).bx(true).eD(sVar.anX).f(this.Hd);
                    if (!TextUtils.isEmpty(this.anq) && this.anq.equals(sVar.anX) && (z || this.anr)) {
                        discoverItemView.bx(false);
                        discoverItemView.bw(this.anr);
                        if (sVar.VK) {
                            TbadkSettings.getInst().saveBoolean(com.baidu.adp.lib.util.u.aE(sVar.anX), true);
                        }
                    }
                    if (i == 0) {
                        this.anj.bz(false);
                    }
                    this.anc.addView(discoverItemView);
                    discoverItemView.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
                    this.anv.add(discoverItemView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AL() {
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
                AL();
            }
        }
    }
}
