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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
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
    private static boolean aKc;
    private u aKd;
    private BdListView aKe;
    private NoNetworkView aKf;
    private com.baidu.tieba.discover.a.b aKg;
    private BannerView aKh;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.discover.a.d> aKi;
    private List<com.baidu.tieba.discover.data.c> aKj;
    private List<com.baidu.tieba.discover.data.d> aKk;
    private boolean aKl;
    private boolean aKm;
    private boolean aKn;
    private List<String> aKo;
    private final CustomMessageListener aKp = new b(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private CustomMessageListener aKq = new j(this, CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW);
    private HttpMessageListener aKr = new k(this, CmdConfigHttp.CMD_GET_OPEN_USERINFO);
    private final CustomMessageListener aKs = new l(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener aKt = new m(this, CmdConfigCustom.DISCOVER_NEED_REFRESH_NET_PLUGIN);
    View aKu;
    private View mFooterView;
    private com.baidu.tbadk.core.view.r mPullView;

    static {
        Ht();
    }

    private static void Ht() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW, new n());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void gm(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            n(str, "", "");
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tu().getString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), "");
        if (TextUtils.isEmpty(string)) {
            gn(str);
            return;
        }
        OpenUserInfo openUserInfo = new OpenUserInfo();
        openUserInfo.parseLocalJson(string);
        if (TextUtils.isEmpty(openUserInfo.getOpenID()) || TextUtils.isEmpty(openUserInfo.getUserName())) {
            gn(str);
        } else {
            n(str, openUserInfo.getOpenID(), openUserInfo.getUserName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, String str3) {
        String string = getResources().getString(i.h.xiuba_title);
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), false, String.valueOf(str) + "?openId=" + str2 + "&userName=" + str3, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hu() {
        PluginNetConfigInfos mi = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi();
        if (mi != null && mi.getConfigs() != null && !mi.getConfigs().isEmpty()) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : mi.getConfigs()) {
                if (pluginConfig != null && com.baidu.tbadk.pluign.a.Ep().fG(pluginConfig.ext)) {
                    com.baidu.tbadk.pluign.a.Ep().fE(pluginConfig.package_name);
                }
            }
        }
    }

    private void Hv() {
        this.aKs.setPriority(100);
        registerListener(this.aKs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aKp);
        registerListener(this.aKq);
        Hv();
        BZ();
        registerListener(this.aKt);
        registerListener(this.aKr);
        this.aKj = new ArrayList(0);
        this.aKk = new ArrayList(0);
        this.aKo = new ArrayList(0);
        Hy();
        Hu();
    }

    private void BZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_OPEN_USERINFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_OPEN_USER_INFO);
        tbHttpMessageTask.setResponsedClass(OpenUserResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void gn(String str) {
        getPageContext().getOrignalPage().showLoadingDialog(getResources().getString(i.h.loading), null);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_OPEN_USERINFO);
        httpMessage.setExtra(str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(boolean z) {
        if (this.aKg != null) {
            this.aKg.v("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> Dm = this.aKi.Dm();
        if (Dm != null && !Dm.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : Dm) {
                if (cVar != null && "discover_friend".equals(cVar.HN())) {
                    cVar.bH(z);
                    this.aKi.A(cVar);
                }
            }
        }
    }

    private View Hw() {
        this.mFooterView = LayoutInflater.from(getActivity()).inflate(i.g.discover_list_footer, (ViewGroup) this.aKe, false);
        ((ViewGroup) this.mFooterView.findViewById(i.f.text_layout)).setOnClickListener(new o(this));
        com.baidu.tbadk.h.a.a(getPageContext(), this.mFooterView);
        return this.mFooterView;
    }

    private void x(View view) {
        this.aKf = (NoNetworkView) view.findViewById(i.f.view_no_network);
        this.aKe = (BdListView) view.findViewById(i.f.listview);
        this.aKe.addFooterView(Hw());
        this.mPullView = new com.baidu.tbadk.core.view.r(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aKe.setPullRefresh(this.mPullView);
        this.mPullView.a(new p(this));
        this.aKe.setOnItemClickListener(new q(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bG(false);
            cVar.bH(false);
            if (this.aKg != null) {
                this.aKg.v(cVar.HN(), false);
            }
            this.aKi.notifyDataSetChanged();
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.HN())) {
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.HN())) {
                aKc = false;
            }
        }
    }

    private void a(PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig != null && pluginConfig.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.ct(String.format(TbadkApplication.getInst().getString(i.h.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f)));
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
            String HN = cVar.HN();
            String title = cVar.getTitle();
            String HL = cVar.HL();
            if (!StringUtils.isNull(HN)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), HN, null);
            }
            if ("discover_friend".equals(HN)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(HN)) {
                if (PluginPackageManager.lR().bt("com.baidu.tieba.pluginNeighbors")) {
                    a(PluginPackageManager.lR().getPluginConfig("com.baidu.tieba.pluginNeighbors"));
                } else {
                    Hx();
                }
                TiebaStatic.log("c10086");
            } else if ("discover_square".equals(HN)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(HN)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(HN)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
                TiebaStatic.log("c10086");
            } else if ("discover_look_shop".equals(HN)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(HN)) {
                if (PluginPackageManager.lR().bt("com.baidu.tieba.pluginRandomChat")) {
                    a(PluginPackageManager.lR().getPluginConfig("com.baidu.tieba.pluginRandomChat"));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_RANDCHAT, new EnterChatRoomConfig(getPageContext().getPageActivity())));
                }
            } else if ("discover_game_center".equals(HN)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(HN)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_FEED, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (HL != null) {
                if (HL.startsWith("game:detail:")) {
                    ay.uV().a(getPageContext(), title, new String[]{HL, "1000501"});
                } else if (HL.startsWith("http://m.xiu8.com")) {
                    TiebaStatic.log("c10104");
                    gm(HL);
                } else if (HL.startsWith("live:detail:TBCLiveID=")) {
                    int g = com.baidu.adp.lib.g.b.g(HL.replace("live:detail:TBCLiveID=", ""), -1);
                    if (g != -1) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomChatActivityConfig(getActivity(), g)));
                    }
                } else if (com.baidu.tbadk.core.util.o.cZ(HL) == 3) {
                    com.baidu.tbadk.core.util.o.a(getPageContext(), HL);
                } else {
                    try {
                        uri = new URI(HL);
                    } catch (URISyntaxException e) {
                        BdLog.e(e);
                        uri = null;
                    }
                    TiebaStatic.log(new ap("c10116").ae("obj_url", uri != null ? uri.getHost() : HL));
                    ay.uV().a((TbPageContext<?>) getPageContext(), title, new String[]{HL}, true);
                }
            }
        }
    }

    public void Hx() {
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
        x(getView());
        this.aKi = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, i.g.discover_list_item, null);
        this.aKe.setAdapter((ListAdapter) this.aKi);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.HN())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("game_is_show_tip", true);
                cVar.bG(false);
                cVar.bH(z);
            } else if ("discover_friend".equals(cVar.HN())) {
                cVar.bG(false);
                cVar.bH(aKc);
            } else if (!com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bG(false);
                cVar.bH(false);
            }
        }
    }

    private void Hy() {
        this.aKd = new u(getPageContext());
        this.aKd.a(new g(this));
    }

    private void Hz() {
        List<com.baidu.tieba.discover.data.c> list;
        com.baidu.tieba.discover.data.d dVar;
        if (this.aKk.isEmpty() || (dVar = this.aKk.get(this.aKk.size() - 1)) == null) {
            list = null;
        } else {
            list = dVar.HS();
        }
        B(list);
        List<com.baidu.tieba.discover.data.c> HA = HA();
        if (HA == null) {
            HA = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        dVar2.setType(0);
        dVar2.H(arrayList);
        this.aKk.add(dVar2);
        arrayList.addAll(HA);
    }

    private void B(List<com.baidu.tieba.discover.data.c> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<com.baidu.tieba.discover.data.c> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.discover.data.c next = it.next();
                if (next != null && next.HR()) {
                    it.remove();
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> HA() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String[] Eq = com.baidu.tbadk.pluign.a.Ep().Eq();
        if (Eq == null || Eq.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : Eq) {
            if (!StringUtils.isNull(str) && PluginPackageManager.lR().br(str) && !PluginPackageManager.lR().bs(str) && (pluginConfig = PluginPackageManager.lR().getPluginConfig(str)) != null) {
                com.baidu.tieba.discover.data.c cVar = new com.baidu.tieba.discover.data.c();
                cVar.setTitle(pluginConfig.display_name);
                cVar.gr(pluginConfig.icon);
                cVar.gs(this.aKd.gq(str));
                cVar.bH(PluginPackageManager.lR().bt(str));
                cVar.bI(true);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        Hz();
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aKj) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        E(arrayList);
        this.aKo.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aKk) {
            if (dVar != null && dVar.HS() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.H(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.HS()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.HS().add(cVar2);
                        go(cVar2.HL());
                    }
                }
            }
        }
        C(arrayList2);
        F(D(arrayList2));
    }

    private void C(List<com.baidu.tieba.discover.data.d> list) {
        if (list == null || list.size() == 0) {
            if (!this.aKn) {
                HB();
                this.aKn = true;
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.d dVar = list.get(list.size() - 1);
        if (dVar == null || dVar.HS() == null || dVar.HS().size() == 0) {
            if (!this.aKn) {
                HB();
                this.aKn = true;
            }
        } else if (this.aKn) {
            this.aKn = false;
            if (this.mFooterView instanceof ViewGroup) {
                ((ViewGroup) this.mFooterView).removeViewAt(0);
            }
        }
    }

    private void HB() {
        if (this.mFooterView instanceof ViewGroup) {
            this.aKu = new View(getPageContext().getPageActivity());
            this.aKu.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(i.d.ds30)));
            am.j(this.aKu, i.c.cp_bg_line_c);
            ((ViewGroup) this.mFooterView).addView(this.aKu, 0);
        }
    }

    private void go(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String lF = com.baidu.tieba.tbadkCore.util.n.lF(str);
                if (!StringUtils.isNull(lF)) {
                    this.aKo.add(lF);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", lF, "ref_id", "1000501");
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
            int size = dVar.HS().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.HS().get(i);
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
        String HN = cVar.HN();
        if ("discover_nearby".equals(HN)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_NEIGHBORS);
        }
        if ("discover_square".equals(HN)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_look_shop".equals(HN)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(HN)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_RANDCHAT);
        }
        if (e(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(HN)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_friend".equals(HN)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        }
        return true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.HN())) {
            return true;
        }
        String HL = cVar.HL();
        if (HL != null) {
            return HL.startsWith("gamecenter:") || HL.startsWith("game:detail:");
        }
        return false;
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_hot_video".equals(cVar.HN())) {
            return true;
        }
        String HL = cVar.HL();
        return HL != null && HL.startsWith("live:detail:TBCLiveID=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aKe.removeHeaderView(this.aKh);
        if (banner != null) {
            if (this.aKh == null) {
                HC();
            }
            this.aKh.reset();
            this.aKh.a(getPageContext(), banner.pic_url, banner.link);
            this.aKh.setBannerViewClickListener(new h(this, banner.link));
            this.aKe.addHeaderView(this.aKh);
        }
    }

    private void HC() {
        this.aKh = new BannerView(getPageContext().getPageActivity());
        this.aKh.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(i.d.ds100)));
    }

    private void HD() {
        this.aKg = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aKg.setOnHeaderItemClickListener(new i(this));
    }

    private void E(List<com.baidu.tieba.discover.data.c> list) {
        this.aKe.removeHeaderView(this.aKg);
        if (list != null && !list.isEmpty()) {
            if (this.aKg == null) {
                HD();
            }
            this.aKg.setData(list);
            this.aKg.e(getPageContext());
            this.aKe.addHeaderView(this.aKg);
        }
    }

    private void F(List<com.baidu.tieba.discover.data.c> list) {
        this.aKi.r(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aKo.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aKo.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aKm) {
            this.aKe.nw();
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
            if (this.aKh != null) {
                this.aKh.oO();
            }
            com.baidu.tbadk.h.a.a(getPageContext(), this.mFooterView);
            if (this.aKg != null) {
                this.aKg.e(getPageContext());
            }
            if (this.aKf != null) {
                this.aKf.onChangeSkinType(getPageContext(), i);
            }
            if (this.aKu != null) {
                am.j(this.aKu, i.c.cp_bg_line_c);
            }
            this.aKi.a(getPageContext(), i);
            this.mPullView.cN(i);
        }
    }
}
