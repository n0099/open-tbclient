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
    private static boolean aDz;
    private u aDA;
    private BdListView aDB;
    private NoNetworkView aDC;
    private com.baidu.tieba.discover.a.b aDD;
    private BannerView aDE;
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.a.d> aDF;
    private List<com.baidu.tieba.discover.data.c> aDG;
    private List<com.baidu.tieba.discover.data.d> aDH;
    private boolean aDI;
    private boolean aDJ;
    private boolean aDK;
    private List<String> aDL;
    private final CustomMessageListener aDM = new b(this, 2001236);
    private CustomMessageListener aDN = new j(this, 2012119);
    private HttpMessageListener aDO = new k(this, CmdConfigHttp.CMD_GET_OPEN_USERINFO);
    private final CustomMessageListener aDP = new l(this, 2009503);
    private final CustomMessageListener aDQ = new m(this, 2009504);
    View aDR;
    private View mFooterView;
    private al mPullView;

    static {
        GT();
    }

    private static void GT() {
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
    public void GU() {
        PluginNetConfigInfos md = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mc().md();
        if (md != null && md.getConfigs() != null && !md.getConfigs().isEmpty()) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : md.getConfigs()) {
                if (pluginConfig != null && com.baidu.tbadk.pluign.a.DM().fb(pluginConfig.ext)) {
                    com.baidu.tbadk.pluign.a.DM().eZ(pluginConfig.package_name);
                }
            }
        }
    }

    private void GV() {
        this.aDP.setPriority(100);
        registerListener(this.aDP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aDM);
        registerListener(this.aDN);
        GV();
        Ag();
        registerListener(this.aDQ);
        registerListener(this.aDO);
        this.aDG = new ArrayList(0);
        this.aDH = new ArrayList(0);
        this.aDL = new ArrayList(0);
        GY();
        GU();
    }

    private void Ag() {
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
        if (this.aDD != null) {
            this.aDD.s("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> CM = this.aDF.CM();
        if (CM != null && !CM.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : CM) {
                if (cVar != null && "discover_friend".equals(cVar.Hp())) {
                    cVar.bD(z);
                    this.aDF.y(cVar);
                }
            }
        }
    }

    private View GW() {
        this.mFooterView = com.baidu.adp.lib.g.b.hr().a(getActivity(), com.baidu.tieba.r.discover_list_footer, this.aDB, false);
        ((ViewGroup) this.mFooterView.findViewById(com.baidu.tieba.q.text_layout)).setOnClickListener(new o(this));
        com.baidu.tbadk.f.a.a(getPageContext(), this.mFooterView);
        return this.mFooterView;
    }

    private void v(View view) {
        this.aDC = (NoNetworkView) view.findViewById(com.baidu.tieba.q.view_no_network);
        this.aDB = (BdListView) view.findViewById(com.baidu.tieba.q.listview);
        this.aDB.addFooterView(GW());
        this.mPullView = new al(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aDB.setPullRefresh(this.mPullView);
        this.mPullView.a(new p(this));
        this.aDB.setOnItemClickListener(new q(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bC(false);
            cVar.bD(false);
            if (this.aDD != null) {
                this.aDD.s(cVar.Hp(), false);
            }
            this.aDF.notifyDataSetChanged();
            com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.Hp())) {
                com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.Hp())) {
                aDz = false;
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
            String Hp = cVar.Hp();
            String title = cVar.getTitle();
            String Hn = cVar.Hn();
            if (!StringUtils.isNull(Hp)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), Hp, null);
            }
            if ("discover_friend".equals(Hp)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage(2002001, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(Hp)) {
                if (PluginPackageManager.lM().by("com.baidu.tieba.pluginNeighbors")) {
                    a(PluginPackageManager.lM().getPluginConfig("com.baidu.tieba.pluginNeighbors"));
                } else {
                    GX();
                }
            } else if ("discover_square".equals(Hp)) {
                sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(Hp)) {
                sendMessage(new CustomMessage(2002001, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(Hp)) {
                sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_look_shop".equals(Hp)) {
                sendMessage(new CustomMessage(2902010, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(Hp)) {
                if (PluginPackageManager.lM().by("com.baidu.tieba.pluginRandomChat")) {
                    a(PluginPackageManager.lM().getPluginConfig("com.baidu.tieba.pluginRandomChat"));
                } else {
                    sendMessage(new CustomMessage(2902040, new EnterChatRoomConfig(getPageContext().getPageActivity())));
                }
            } else if ("discover_game_center".equals(Hp)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
                sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(Hp)) {
                sendMessage(new CustomMessage(2902024, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (Hn != null) {
                if (Hn.startsWith("game:detail:")) {
                    bi.tO().a(getPageContext(), title, new String[]{Hn, "1000501"});
                } else if (Hn.startsWith("http://m.xiu8.com")) {
                    fJ(Hn);
                } else if (Hn.startsWith("live:detail:TBCLiveID=")) {
                    int i = com.baidu.adp.lib.g.c.toInt(Hn.replace("live:detail:TBCLiveID=", ""), -1);
                    if (i != -1) {
                        sendMessage(new CustomMessage(2002001, new LiveRoomChatActivityConfig(getActivity(), i)));
                    }
                } else {
                    bi.tO().a(getPageContext(), title, new String[]{Hn});
                }
            }
        }
    }

    public void GX() {
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
        this.aDF = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, com.baidu.tieba.r.discover_list_item, null);
        this.aDB.setAdapter((ListAdapter) this.aDF);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.Hp())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("game_is_show_tip", true);
                cVar.bC(false);
                cVar.bD(z);
            } else if ("discover_friend".equals(cVar.Hp())) {
                cVar.bC(false);
                cVar.bD(aDz);
            } else if (!com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bC(false);
                cVar.bD(false);
            }
        }
    }

    private void GY() {
        this.aDA = new u(getPageContext());
        this.aDA.a(new g(this));
    }

    private void GZ() {
        List<com.baidu.tieba.discover.data.c> list;
        com.baidu.tieba.discover.data.d dVar;
        if (this.aDH.isEmpty() || (dVar = this.aDH.get(this.aDH.size() - 1)) == null) {
            list = null;
        } else {
            list = dVar.Hu();
        }
        B(list);
        List<com.baidu.tieba.discover.data.c> Ha = Ha();
        if (Ha == null) {
            Ha = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        dVar2.setType(0);
        dVar2.H(arrayList);
        this.aDH.add(dVar2);
        arrayList.addAll(Ha);
    }

    private void B(List<com.baidu.tieba.discover.data.c> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<com.baidu.tieba.discover.data.c> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.discover.data.c next = it.next();
                if (next != null && next.Ht()) {
                    it.remove();
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> Ha() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String[] DN = com.baidu.tbadk.pluign.a.DM().DN();
        if (DN == null || DN.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : DN) {
            if (!StringUtils.isNull(str) && PluginPackageManager.lM().bw(str) && !PluginPackageManager.lM().bx(str) && (pluginConfig = PluginPackageManager.lM().getPluginConfig(str)) != null) {
                com.baidu.tieba.discover.data.c cVar = new com.baidu.tieba.discover.data.c();
                cVar.setTitle(pluginConfig.display_name);
                cVar.fO(pluginConfig.icon);
                cVar.fP(this.aDA.fN(str));
                cVar.bD(PluginPackageManager.lM().by(str));
                cVar.bE(true);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(boolean z) {
        GZ();
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aDG) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        E(arrayList);
        this.aDL.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aDH) {
            if (dVar != null && dVar.Hu() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.H(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.Hu()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.Hu().add(cVar2);
                        fL(cVar2.Hn());
                    }
                }
            }
        }
        C(arrayList2);
        F(D(arrayList2));
    }

    private void C(List<com.baidu.tieba.discover.data.d> list) {
        if (list == null || list.size() == 0) {
            if (!this.aDK) {
                Hb();
                this.aDK = true;
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.d dVar = list.get(list.size() - 1);
        if (dVar == null || dVar.Hu() == null || dVar.Hu().size() == 0) {
            if (!this.aDK) {
                Hb();
                this.aDK = true;
            }
        } else if (this.aDK) {
            this.aDK = false;
            if (this.mFooterView instanceof ViewGroup) {
                ((ViewGroup) this.mFooterView).removeViewAt(0);
            }
        }
    }

    private void Hb() {
        if (this.mFooterView instanceof ViewGroup) {
            this.aDR = new View(getPageContext().getPageActivity());
            this.aDR.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(com.baidu.tieba.o.ds30)));
            ay.j(this.aDR, com.baidu.tieba.n.cp_bg_line_c);
            ((ViewGroup) this.mFooterView).addView(this.aDR, 0);
        }
    }

    private void fL(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String jJ = com.baidu.tieba.tbadkCore.util.k.jJ(str);
                if (!StringUtils.isNull(jJ)) {
                    this.aDL.add(jJ);
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
            int size = dVar.Hu().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.Hu().get(i);
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
        String Hp = cVar.Hp();
        if ("discover_nearby".equals(Hp)) {
            return TbadkApplication.getInst().appResponseToCmd(2902001);
        }
        if ("discover_square".equals(Hp)) {
            return TbadkApplication.getInst().appResponseToCmd(2902023);
        }
        if ("discover_look_shop".equals(Hp)) {
            return TbadkApplication.getInst().appResponseToCmd(2902010);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(Hp)) {
            return TbadkApplication.getInst().appResponseToCmd(2902040);
        }
        if (e(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(Hp)) {
            return TbadkApplication.getInst().appResponseToCmd(2902023);
        }
        if ("discover_friend".equals(Hp)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        }
        return true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.Hp())) {
            return true;
        }
        String Hn = cVar.Hn();
        if (Hn != null) {
            return Hn.startsWith("gamecenter:") || Hn.startsWith("game:detail:");
        }
        return false;
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_hot_video".equals(cVar.Hp())) {
            return true;
        }
        String Hn = cVar.Hn();
        return Hn != null && Hn.startsWith("live:detail:TBCLiveID=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aDB.removeHeaderView(this.aDE);
        if (banner != null) {
            if (this.aDE == null) {
                Hc();
            }
            this.aDE.reset();
            this.aDE.a(getPageContext(), banner.pic_url, banner.link);
            this.aDE.setBannerViewClickListener(new h(this, banner.link));
            this.aDB.addHeaderView(this.aDE);
        }
    }

    private void Hc() {
        this.aDE = new BannerView(getPageContext().getPageActivity());
        this.aDE.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds100)));
    }

    private void Hd() {
        this.aDD = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aDD.setOnHeaderItemClickListener(new i(this));
    }

    private void E(List<com.baidu.tieba.discover.data.c> list) {
        this.aDB.removeHeaderView(this.aDD);
        if (list != null && !list.isEmpty()) {
            if (this.aDD == null) {
                Hd();
            }
            this.aDD.setData(list);
            this.aDD.d(getPageContext());
            this.aDB.addHeaderView(this.aDD);
        }
    }

    private void F(List<com.baidu.tieba.discover.data.c> list) {
        this.aDF.s(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aDL.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aDL.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aDJ) {
            this.aDB.no();
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
            if (this.aDE != null) {
                this.aDE.oG();
            }
            com.baidu.tbadk.f.a.a(getPageContext(), this.mFooterView);
            if (this.aDD != null) {
                this.aDD.d(getPageContext());
            }
            if (this.aDC != null) {
                this.aDC.onChangeSkinType(getPageContext(), i);
            }
            if (this.aDR != null) {
                ay.j(this.aDR, com.baidu.tieba.n.cp_bg_line_c);
            }
            this.aDF.a(getPageContext(), i);
            this.mPullView.cy(i);
        }
    }
}
