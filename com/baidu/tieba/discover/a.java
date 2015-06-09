package com.baidu.tieba.discover;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EnterChatRoomConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.HotLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.LiveRoomChatActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SingleForumFeedActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.al;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.discover.data.OpenUserInfo;
import com.baidu.tieba.discover.data.OpenUserResponsedMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FoundNew.Banner;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private static boolean aDA;
    private u aDB;
    private BdListView aDC;
    private NoNetworkView aDD;
    private com.baidu.tieba.discover.a.b aDE;
    private BannerView aDF;
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.a.d> aDG;
    private List<com.baidu.tieba.discover.data.c> aDH;
    private List<com.baidu.tieba.discover.data.d> aDI;
    private boolean aDJ;
    private boolean aDK;
    private boolean aDL;
    private List<String> aDM;
    private final CustomMessageListener aDN = new b(this, 2001236);
    private CustomMessageListener aDO = new j(this, 2012119);
    private HttpMessageListener aDP = new k(this, CmdConfigHttp.CMD_GET_OPEN_USERINFO);
    private final CustomMessageListener aDQ = new l(this, 2009503);
    private final CustomMessageListener aDR = new m(this, 2009504);
    View aDS;
    private View mFooterView;
    private al mPullView;

    static {
        GU();
    }

    private static void GU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012119, new n());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void fJ(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            l(str, "", "");
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.sl().getString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), "");
        if (TextUtils.isEmpty(string)) {
            fK(str);
            return;
        }
        OpenUserInfo openUserInfo = new OpenUserInfo();
        openUserInfo.parseLocalJson(string);
        if (TextUtils.isEmpty(openUserInfo.getOpenID()) || TextUtils.isEmpty(openUserInfo.getUserName())) {
            fK(str);
        } else {
            l(str, openUserInfo.getOpenID(), openUserInfo.getUserName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, String str2, String str3) {
        String string = getResources().getString(com.baidu.tieba.t.xiuba_title);
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, String.valueOf(str) + "?openId=" + str2 + "&userName=" + str3, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GV() {
        PluginNetConfigInfos md = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().md();
        if (md != null && md.getConfigs() != null && !md.getConfigs().isEmpty()) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : md.getConfigs()) {
                if (pluginConfig != null && com.baidu.tbadk.pluign.a.DN().fb(pluginConfig.ext)) {
                    com.baidu.tbadk.pluign.a.DN().eZ(pluginConfig.package_name);
                }
            }
        }
    }

    private void GW() {
        this.aDQ.setPriority(100);
        registerListener(this.aDQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aDN);
        registerListener(this.aDO);
        GW();
        Ah();
        registerListener(this.aDR);
        registerListener(this.aDP);
        this.aDH = new ArrayList(0);
        this.aDI = new ArrayList(0);
        this.aDM = new ArrayList(0);
        GZ();
        GV();
    }

    private void Ah() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_OPEN_USERINFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_OPEN_USER_INFO);
        tbHttpMessageTask.setResponsedClass(OpenUserResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void fK(String str) {
        getPageContext().getOrignalPage().showLoadingDialog(getResources().getString(com.baidu.tieba.t.loading), null);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_OPEN_USERINFO);
        httpMessage.setExtra(str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(boolean z) {
        if (this.aDE != null) {
            this.aDE.s("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> CN = this.aDG.CN();
        if (CN != null && !CN.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : CN) {
                if (cVar != null && "discover_friend".equals(cVar.Hq())) {
                    cVar.bD(z);
                    this.aDG.y(cVar);
                }
            }
        }
    }

    private View GX() {
        this.mFooterView = com.baidu.adp.lib.g.b.hr().a(getActivity(), com.baidu.tieba.r.discover_list_footer, this.aDC, false);
        ((ViewGroup) this.mFooterView.findViewById(com.baidu.tieba.q.text_layout)).setOnClickListener(new o(this));
        com.baidu.tbadk.f.a.a(getPageContext(), this.mFooterView);
        return this.mFooterView;
    }

    private void v(View view) {
        this.aDD = (NoNetworkView) view.findViewById(com.baidu.tieba.q.view_no_network);
        this.aDC = (BdListView) view.findViewById(com.baidu.tieba.q.listview);
        this.aDC.addFooterView(GX());
        this.mPullView = new al(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aDC.setPullRefresh(this.mPullView);
        this.mPullView.a(new p(this));
        this.aDC.setOnItemClickListener(new q(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bC(false);
            cVar.bD(false);
            if (this.aDE != null) {
                this.aDE.s(cVar.Hq(), false);
            }
            this.aDG.notifyDataSetChanged();
            com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.Hq())) {
                com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.Hq())) {
                aDA = false;
            }
        }
    }

    private void a(PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig != null && pluginConfig.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cn(String.format(TbadkApplication.getInst().getString(com.baidu.tieba.t.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f)));
            aVar.a(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.download), new c(this, pluginConfig));
            aVar.b(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.rL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            a(cVar);
            String Hq = cVar.Hq();
            String title = cVar.getTitle();
            String Ho = cVar.Ho();
            if (!StringUtils.isNull(Hq)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), Hq, null);
            }
            if ("discover_friend".equals(Hq)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage(2002001, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(Hq)) {
                if (PluginPackageManager.lM().by("com.baidu.tieba.pluginNeighbors")) {
                    a(PluginPackageManager.lM().getPluginConfig("com.baidu.tieba.pluginNeighbors"));
                } else {
                    GY();
                }
            } else if ("discover_square".equals(Hq)) {
                sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(Hq)) {
                sendMessage(new CustomMessage(2002001, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(Hq)) {
                sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_look_shop".equals(Hq)) {
                sendMessage(new CustomMessage(2902010, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(Hq)) {
                if (PluginPackageManager.lM().by("com.baidu.tieba.pluginRandomChat")) {
                    a(PluginPackageManager.lM().getPluginConfig("com.baidu.tieba.pluginRandomChat"));
                } else {
                    sendMessage(new CustomMessage(2902040, new EnterChatRoomConfig(getPageContext().getPageActivity())));
                }
            } else if ("discover_game_center".equals(Hq)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
                sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(Hq)) {
                sendMessage(new CustomMessage(2902024, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (Ho != null) {
                if (Ho.startsWith("game:detail:")) {
                    bi.tO().a(getPageContext(), title, new String[]{Ho, "1000501"});
                } else if (Ho.startsWith("http://m.xiu8.com")) {
                    fJ(Ho);
                } else if (Ho.startsWith("live:detail:TBCLiveID=")) {
                    int i = com.baidu.adp.lib.g.c.toInt(Ho.replace("live:detail:TBCLiveID=", ""), -1);
                    if (i != -1) {
                        sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(getActivity(), i)));
                    }
                } else {
                    bi.tO().a(getPageContext(), title, new String[]{Ho});
                }
            }
        }
    }

    public void GY() {
        if (TbadkApplication.getInst().getLocationShared()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902001, new com.baidu.tbadk.core.frameworkData.c(getPageContext().getPageActivity())));
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bu(com.baidu.tieba.t.warning_location_switch_off);
        aVar.a(com.baidu.tieba.t.isopen, new e(this));
        aVar.b(com.baidu.tieba.t.cancel, new f(this));
        aVar.b(getPageContext());
        aVar.rL();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "plugin_discover_create", null);
        if (TbadkApplication.getInst().appResponseToCmd(2902001)) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "plugin_discover_neighbors", null);
        }
        if (TbadkApplication.getInst().appResponseToCmd(2902040)) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "plugin_discover_randchat", null);
        }
        return layoutInflater.inflate(com.baidu.tieba.r.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        v(getView());
        this.aDG = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, com.baidu.tieba.r.discover_list_item, null);
        this.aDC.setAdapter((ListAdapter) this.aDG);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.Hq())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("game_is_show_tip", true);
                cVar.bC(false);
                cVar.bD(z);
            } else if ("discover_friend".equals(cVar.Hq())) {
                cVar.bC(false);
                cVar.bD(aDA);
            } else if (!com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bC(false);
                cVar.bD(false);
            }
        }
    }

    private void GZ() {
        this.aDB = new u(getPageContext());
        this.aDB.a(new g(this));
    }

    private void Ha() {
        List<com.baidu.tieba.discover.data.c> list;
        com.baidu.tieba.discover.data.d dVar;
        if (this.aDI.isEmpty() || (dVar = this.aDI.get(this.aDI.size() - 1)) == null) {
            list = null;
        } else {
            list = dVar.Hv();
        }
        B(list);
        List<com.baidu.tieba.discover.data.c> Hb = Hb();
        if (Hb == null) {
            Hb = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        dVar2.setType(0);
        dVar2.H(arrayList);
        this.aDI.add(dVar2);
        arrayList.addAll(Hb);
    }

    private void B(List<com.baidu.tieba.discover.data.c> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<com.baidu.tieba.discover.data.c> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.discover.data.c next = it.next();
                if (next != null && next.Hu()) {
                    it.remove();
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> Hb() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String[] DO = com.baidu.tbadk.pluign.a.DN().DO();
        if (DO == null || DO.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : DO) {
            if (!StringUtils.isNull(str) && PluginPackageManager.lM().bw(str) && !PluginPackageManager.lM().bx(str) && (pluginConfig = PluginPackageManager.lM().getPluginConfig(str)) != null) {
                com.baidu.tieba.discover.data.c cVar = new com.baidu.tieba.discover.data.c();
                cVar.setTitle(pluginConfig.display_name);
                cVar.fO(pluginConfig.icon);
                cVar.fP(this.aDB.fN(str));
                cVar.bD(PluginPackageManager.lM().by(str));
                cVar.bE(true);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(boolean z) {
        Ha();
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aDH) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        E(arrayList);
        this.aDM.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aDI) {
            if (dVar != null && dVar.Hv() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.H(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.Hv()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.Hv().add(cVar2);
                        fL(cVar2.Ho());
                    }
                }
            }
        }
        C(arrayList2);
        F(D(arrayList2));
    }

    private void C(List<com.baidu.tieba.discover.data.d> list) {
        if (list == null || list.size() == 0) {
            if (!this.aDL) {
                Hc();
                this.aDL = true;
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.d dVar = list.get(list.size() - 1);
        if (dVar == null || dVar.Hv() == null || dVar.Hv().size() == 0) {
            if (!this.aDL) {
                Hc();
                this.aDL = true;
            }
        } else if (this.aDL) {
            this.aDL = false;
            if (this.mFooterView instanceof ViewGroup) {
                ((ViewGroup) this.mFooterView).removeViewAt(0);
            }
        }
    }

    private void Hc() {
        if (this.mFooterView instanceof ViewGroup) {
            this.aDS = new View(getPageContext().getPageActivity());
            this.aDS.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(com.baidu.tieba.o.ds30)));
            ay.j(this.aDS, com.baidu.tieba.n.cp_bg_line_c);
            ((ViewGroup) this.mFooterView).addView(this.aDS, 0);
        }
    }

    private void fL(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String jJ = com.baidu.tieba.tbadkCore.util.k.jJ(str);
                if (!StringUtils.isNull(jJ)) {
                    this.aDM.add(jJ);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", jJ, "ref_id", "1000501");
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> D(List<com.baidu.tieba.discover.data.d> list) {
        ArrayList arrayList = new ArrayList(0);
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (com.baidu.tieba.discover.data.d dVar : list) {
            int size = dVar.Hv().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.Hv().get(i);
                if (size == 1) {
                    cVar.eB(3);
                } else if (i == 0) {
                    cVar.eB(1);
                } else if (i == size - 1) {
                    cVar.eB(2);
                } else {
                    cVar.eB(0);
                }
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private boolean d(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        String Hq = cVar.Hq();
        if ("discover_nearby".equals(Hq)) {
            return TbadkApplication.getInst().appResponseToCmd(2902001);
        }
        if ("discover_square".equals(Hq)) {
            return TbadkApplication.getInst().appResponseToCmd(2902023);
        }
        if ("discover_look_shop".equals(Hq)) {
            return TbadkApplication.getInst().appResponseToCmd(2902010);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(Hq)) {
            return TbadkApplication.getInst().appResponseToCmd(2902040);
        }
        if (e(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(Hq)) {
            return TbadkApplication.getInst().appResponseToCmd(2902023);
        }
        if ("discover_friend".equals(Hq)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        }
        return true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.Hq())) {
            return true;
        }
        String Ho = cVar.Ho();
        if (Ho != null) {
            return Ho.startsWith("gamecenter:") || Ho.startsWith("game:detail:");
        }
        return false;
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_hot_video".equals(cVar.Hq())) {
            return true;
        }
        String Ho = cVar.Ho();
        return Ho != null && Ho.startsWith("live:detail:TBCLiveID=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aDC.removeHeaderView(this.aDF);
        if (banner != null) {
            if (this.aDF == null) {
                Hd();
            }
            this.aDF.reset();
            this.aDF.a(getPageContext(), banner.pic_url, banner.link);
            this.aDF.setBannerViewClickListener(new h(this, banner.link));
            this.aDC.addHeaderView(this.aDF);
        }
    }

    private void Hd() {
        this.aDF = new BannerView(getPageContext().getPageActivity());
        this.aDF.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds100)));
    }

    private void He() {
        this.aDE = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aDE.setOnHeaderItemClickListener(new i(this));
    }

    private void E(List<com.baidu.tieba.discover.data.c> list) {
        this.aDC.removeHeaderView(this.aDE);
        if (list != null && !list.isEmpty()) {
            if (this.aDE == null) {
                He();
            }
            this.aDE.setData(list);
            this.aDE.d(getPageContext());
            this.aDC.addHeaderView(this.aDE);
        }
    }

    private void F(List<com.baidu.tieba.discover.data.c> list) {
        this.aDG.s(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aDM.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aDM.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aDK) {
            this.aDC.no();
            com.baidu.tbadk.core.k.B(getPageContext().getPageActivity(), "found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (getBaseFragmentActivity() != null) {
            getBaseFragmentActivity().getLayoutMode().ab(i == 1);
            if (getView() != null) {
                getBaseFragmentActivity().getLayoutMode().j(getView());
            }
            if (this.aDF != null) {
                this.aDF.oG();
            }
            com.baidu.tbadk.f.a.a(getPageContext(), this.mFooterView);
            if (this.aDE != null) {
                this.aDE.d(getPageContext());
            }
            if (this.aDD != null) {
                this.aDD.onChangeSkinType(getPageContext(), i);
            }
            if (this.aDS != null) {
                ay.j(this.aDS, com.baidu.tieba.n.cp_bg_line_c);
            }
            this.aDG.a(getPageContext(), i);
            this.mPullView.cy(i);
        }
    }
}
