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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.discover.data.OpenUserInfo;
import com.baidu.tieba.discover.data.OpenUserResponsedMessage;
import com.baidu.tieba.i;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FoundNew.Banner;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private static boolean aJh;
    private u aJi;
    private BdListView aJj;
    private NoNetworkView aJk;
    private com.baidu.tieba.discover.a.b aJl;
    private BannerView aJm;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.discover.a.d> aJn;
    private List<com.baidu.tieba.discover.data.c> aJo;
    private List<com.baidu.tieba.discover.data.d> aJp;
    private boolean aJq;
    private boolean aJr;
    private boolean aJs;
    private List<String> aJt;
    private final CustomMessageListener aJu = new b(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private CustomMessageListener aJv = new j(this, CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW);
    private HttpMessageListener aJw = new k(this, CmdConfigHttp.CMD_GET_OPEN_USERINFO);
    private final CustomMessageListener aJx = new l(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener aJy = new m(this, CmdConfigCustom.DISCOVER_NEED_REFRESH_NET_PLUGIN);
    View aJz;
    private View mFooterView;
    private com.baidu.tbadk.core.view.r mPullView;

    static {
        Hm();
    }

    private static void Hm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW, new n());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void go(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            m(str, "", "");
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tu().getString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), "");
        if (TextUtils.isEmpty(string)) {
            gp(str);
            return;
        }
        OpenUserInfo openUserInfo = new OpenUserInfo();
        openUserInfo.parseLocalJson(string);
        if (TextUtils.isEmpty(openUserInfo.getOpenID()) || TextUtils.isEmpty(openUserInfo.getUserName())) {
            gp(str);
        } else {
            m(str, openUserInfo.getOpenID(), openUserInfo.getUserName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, String str2, String str3) {
        String string = getResources().getString(i.h.xiuba_title);
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), false, String.valueOf(str) + "?openId=" + str2 + "&userName=" + str3, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn() {
        PluginNetConfigInfos mj = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mi().mj();
        if (mj != null && mj.getConfigs() != null && !mj.getConfigs().isEmpty()) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : mj.getConfigs()) {
                if (pluginConfig != null && com.baidu.tbadk.pluign.a.Ef().fI(pluginConfig.ext)) {
                    com.baidu.tbadk.pluign.a.Ef().fG(pluginConfig.package_name);
                }
            }
        }
    }

    private void Ho() {
        this.aJx.setPriority(100);
        registerListener(this.aJx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aJu);
        registerListener(this.aJv);
        Ho();
        BP();
        registerListener(this.aJy);
        registerListener(this.aJw);
        this.aJo = new ArrayList(0);
        this.aJp = new ArrayList(0);
        this.aJt = new ArrayList(0);
        Hr();
        Hn();
    }

    private void BP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_OPEN_USERINFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_OPEN_USER_INFO);
        tbHttpMessageTask.setResponsedClass(OpenUserResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void gp(String str) {
        getPageContext().getOrignalPage().showLoadingDialog(getResources().getString(i.h.loading), null);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_OPEN_USERINFO);
        httpMessage.setExtra(str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (this.aJl != null) {
            this.aJl.t("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> Dc = this.aJn.Dc();
        if (Dc != null && !Dc.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : Dc) {
                if (cVar != null && "discover_friend".equals(cVar.HG())) {
                    cVar.bJ(z);
                    this.aJn.A(cVar);
                }
            }
        }
    }

    private View Hp() {
        this.mFooterView = LayoutInflater.from(getActivity()).inflate(i.g.discover_list_footer, (ViewGroup) this.aJj, false);
        ((ViewGroup) this.mFooterView.findViewById(i.f.text_layout)).setOnClickListener(new o(this));
        com.baidu.tbadk.h.a.a(getPageContext(), this.mFooterView);
        return this.mFooterView;
    }

    private void y(View view) {
        this.aJk = (NoNetworkView) view.findViewById(i.f.view_no_network);
        this.aJj = (BdListView) view.findViewById(i.f.listview);
        this.aJj.addFooterView(Hp());
        this.mPullView = new com.baidu.tbadk.core.view.r(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aJj.setPullRefresh(this.mPullView);
        this.mPullView.a(new p(this));
        this.aJj.setOnItemClickListener(new q(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bI(false);
            cVar.bJ(false);
            if (this.aJl != null) {
                this.aJl.t(cVar.HG(), false);
            }
            this.aJn.notifyDataSetChanged();
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.HG())) {
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.HG())) {
                aJh = false;
            }
        }
    }

    private void a(PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig != null && pluginConfig.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cu(String.format(TbadkApplication.getInst().getString(i.h.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f)));
            aVar.a(TbadkCoreApplication.m411getInst().getString(i.h.download), new c(this, pluginConfig));
            aVar.b(TbadkCoreApplication.m411getInst().getString(i.h.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.sR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        URI uri;
        if (cVar != null) {
            a(cVar);
            String HG = cVar.HG();
            String title = cVar.getTitle();
            String HE = cVar.HE();
            if (!StringUtils.isNull(HG)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), HG, null);
            }
            if ("discover_friend".equals(HG)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(HG)) {
                if (PluginPackageManager.lS().br("com.baidu.tieba.pluginNeighbors")) {
                    a(PluginPackageManager.lS().getPluginConfig("com.baidu.tieba.pluginNeighbors"));
                } else {
                    Hq();
                }
                TiebaStatic.log("c10086");
            } else if ("discover_square".equals(HG)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(HG)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(HG)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
                TiebaStatic.log("c10086");
            } else if ("discover_look_shop".equals(HG)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(HG)) {
                if (PluginPackageManager.lS().br("com.baidu.tieba.pluginRandomChat")) {
                    a(PluginPackageManager.lS().getPluginConfig("com.baidu.tieba.pluginRandomChat"));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_RANDCHAT, new EnterChatRoomConfig(getPageContext().getPageActivity())));
                }
            } else if ("discover_game_center".equals(HG)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(HG)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_FEED, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (HE != null) {
                if (HE.startsWith("game:detail:")) {
                    az.uX().a(getPageContext(), title, new String[]{HE, "1000501"});
                } else if (HE.startsWith("http://m.xiu8.com")) {
                    TiebaStatic.log("c10104");
                    go(HE);
                } else if (HE.startsWith("live:detail:TBCLiveID=")) {
                    int g = com.baidu.adp.lib.g.b.g(HE.replace("live:detail:TBCLiveID=", ""), -1);
                    if (g != -1) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomChatActivityConfig(getActivity(), g)));
                    }
                } else if (com.baidu.tbadk.core.util.o.da(HE) == 3) {
                    com.baidu.tbadk.core.util.o.a(getPageContext(), HE);
                } else {
                    try {
                        uri = new URI(HE);
                    } catch (URISyntaxException e) {
                        BdLog.e(e);
                        uri = null;
                    }
                    TiebaStatic.log(new aq("c10116").ae("obj_url", uri != null ? uri.getHost() : HE));
                    az.uX().a((TbPageContext<?>) getPageContext(), title, new String[]{HE}, true);
                }
            }
        }
    }

    public void Hq() {
        if (TbadkApplication.getInst().getLocationShared()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_NEIGHBORS, new IntentConfig(getPageContext().getPageActivity())));
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bF(i.h.warning_location_switch_off);
        aVar.a(i.h.isopen, new e(this));
        aVar.b(i.h.cancel, new f(this));
        aVar.b(getPageContext());
        aVar.sR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "plugin_discover_create", null);
        if (TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_NEIGHBORS)) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "plugin_discover_neighbors", null);
        }
        if (TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_RANDCHAT)) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "plugin_discover_randchat", null);
        }
        return layoutInflater.inflate(i.g.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        y(getView());
        this.aJn = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, i.g.discover_list_item, null);
        this.aJj.setAdapter((ListAdapter) this.aJn);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.HG())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("game_is_show_tip", true);
                cVar.bI(false);
                cVar.bJ(z);
            } else if ("discover_friend".equals(cVar.HG())) {
                cVar.bI(false);
                cVar.bJ(aJh);
            } else if (!com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bI(false);
                cVar.bJ(false);
            }
        }
    }

    private void Hr() {
        this.aJi = new u(getPageContext());
        this.aJi.a(new g(this));
    }

    private void Hs() {
        List<com.baidu.tieba.discover.data.c> list;
        com.baidu.tieba.discover.data.d dVar;
        if (this.aJp.isEmpty() || (dVar = this.aJp.get(this.aJp.size() - 1)) == null) {
            list = null;
        } else {
            list = dVar.HL();
        }
        C(list);
        List<com.baidu.tieba.discover.data.c> Ht = Ht();
        if (Ht == null) {
            Ht = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        dVar2.setType(0);
        dVar2.I(arrayList);
        this.aJp.add(dVar2);
        arrayList.addAll(Ht);
    }

    private void C(List<com.baidu.tieba.discover.data.c> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<com.baidu.tieba.discover.data.c> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.discover.data.c next = it.next();
                if (next != null && next.HK()) {
                    it.remove();
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> Ht() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String[] Eg = com.baidu.tbadk.pluign.a.Ef().Eg();
        if (Eg == null || Eg.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : Eg) {
            if (!StringUtils.isNull(str) && PluginPackageManager.lS().bp(str) && !PluginPackageManager.lS().bq(str) && (pluginConfig = PluginPackageManager.lS().getPluginConfig(str)) != null) {
                com.baidu.tieba.discover.data.c cVar = new com.baidu.tieba.discover.data.c();
                cVar.setTitle(pluginConfig.display_name);
                cVar.gt(pluginConfig.icon);
                cVar.gu(this.aJi.gs(str));
                cVar.bJ(PluginPackageManager.lS().br(str));
                cVar.bK(true);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        Hs();
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aJo) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        F(arrayList);
        this.aJt.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aJp) {
            if (dVar != null && dVar.HL() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.I(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.HL()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.HL().add(cVar2);
                        gq(cVar2.HE());
                    }
                }
            }
        }
        D(arrayList2);
        G(E(arrayList2));
    }

    private void D(List<com.baidu.tieba.discover.data.d> list) {
        if (list == null || list.size() == 0) {
            if (!this.aJs) {
                Hu();
                this.aJs = true;
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.d dVar = list.get(list.size() - 1);
        if (dVar == null || dVar.HL() == null || dVar.HL().size() == 0) {
            if (!this.aJs) {
                Hu();
                this.aJs = true;
            }
        } else if (this.aJs) {
            this.aJs = false;
            if (this.mFooterView instanceof ViewGroup) {
                ((ViewGroup) this.mFooterView).removeViewAt(0);
            }
        }
    }

    private void Hu() {
        if (this.mFooterView instanceof ViewGroup) {
            this.aJz = new View(getPageContext().getPageActivity());
            this.aJz.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(i.d.ds30)));
            an.j(this.aJz, i.c.cp_bg_line_c);
            ((ViewGroup) this.mFooterView).addView(this.aJz, 0);
        }
    }

    private void gq(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String lO = com.baidu.tieba.tbadkCore.util.n.lO(str);
                if (!StringUtils.isNull(lO)) {
                    this.aJt.add(lO);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", lO, "ref_id", "1000501");
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> E(List<com.baidu.tieba.discover.data.d> list) {
        ArrayList arrayList = new ArrayList(0);
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (com.baidu.tieba.discover.data.d dVar : list) {
            int size = dVar.HL().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.HL().get(i);
                if (size == 1) {
                    cVar.eT(3);
                } else if (i == 0) {
                    cVar.eT(1);
                } else if (i == size - 1) {
                    cVar.eT(2);
                } else {
                    cVar.eT(0);
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
        String HG = cVar.HG();
        if ("discover_nearby".equals(HG)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_NEIGHBORS);
        }
        if ("discover_square".equals(HG)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_look_shop".equals(HG)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(HG)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_RANDCHAT);
        }
        if (e(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(HG)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_friend".equals(HG)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        }
        return true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.HG())) {
            return true;
        }
        String HE = cVar.HE();
        if (HE != null) {
            return HE.startsWith("gamecenter:") || HE.startsWith("game:detail:");
        }
        return false;
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_hot_video".equals(cVar.HG())) {
            return true;
        }
        String HE = cVar.HE();
        return HE != null && HE.startsWith("live:detail:TBCLiveID=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aJj.removeHeaderView(this.aJm);
        if (banner != null) {
            if (this.aJm == null) {
                Hv();
            }
            this.aJm.reset();
            this.aJm.a(getPageContext(), banner.pic_url, banner.link);
            this.aJm.setBannerViewClickListener(new h(this, banner.link));
            this.aJj.addHeaderView(this.aJm);
        }
    }

    private void Hv() {
        this.aJm = new BannerView(getPageContext().getPageActivity());
        this.aJm.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(i.d.ds100)));
    }

    private void Hw() {
        this.aJl = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aJl.setOnHeaderItemClickListener(new i(this));
    }

    private void F(List<com.baidu.tieba.discover.data.c> list) {
        this.aJj.removeHeaderView(this.aJl);
        if (list != null && !list.isEmpty()) {
            if (this.aJl == null) {
                Hw();
            }
            this.aJl.setData(list);
            this.aJl.e(getPageContext());
            this.aJj.addHeaderView(this.aJl);
        }
    }

    private void G(List<com.baidu.tieba.discover.data.c> list) {
        this.aJn.s(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aJt.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aJt.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aJr) {
            this.aJj.nx();
            TiebaStatic.log("found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (getBaseFragmentActivity() != null) {
            getBaseFragmentActivity().getLayoutMode().ad(i == 1);
            if (getView() != null) {
                getBaseFragmentActivity().getLayoutMode().k(getView());
            }
            if (this.aJm != null) {
                this.aJm.oP();
            }
            com.baidu.tbadk.h.a.a(getPageContext(), this.mFooterView);
            if (this.aJl != null) {
                this.aJl.e(getPageContext());
            }
            if (this.aJk != null) {
                this.aJk.onChangeSkinType(getPageContext(), i);
            }
            if (this.aJz != null) {
                an.j(this.aJz, i.c.cp_bg_line_c);
            }
            this.aJn.a(getPageContext(), i);
            this.mPullView.cN(i);
        }
    }
}
