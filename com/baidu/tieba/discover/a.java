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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.discover.data.OpenUserInfo;
import com.baidu.tieba.discover.data.OpenUserResponsedMessage;
import com.baidu.tieba.n;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FoundNew.Banner;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private static boolean aRA;
    private t aRB;
    private BdListView aRC;
    private NoNetworkView aRD;
    private com.baidu.tieba.discover.a.b aRE;
    private BannerView aRF;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.discover.a.d> aRG;
    private List<com.baidu.tieba.discover.data.c> aRH;
    private List<com.baidu.tieba.discover.data.d> aRI;
    private boolean aRJ;
    private boolean aRK;
    private boolean aRL;
    private List<String> aRM;
    private final CustomMessageListener aRN = new b(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private CustomMessageListener aRO = new j(this, CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW);
    private HttpMessageListener aRP = new k(this, CmdConfigHttp.CMD_GET_OPEN_USERINFO);
    private final CustomMessageListener aRQ = new l(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener aRR = new m(this, CmdConfigCustom.DISCOVER_NEED_REFRESH_NET_PLUGIN);
    View aRS;
    private View mFooterView;
    private com.baidu.tbadk.core.view.t mPullView;

    static {
        IW();
    }

    private static void IW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW, new n());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void gO(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            o(str, "", "");
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tJ().getString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), "");
        if (TextUtils.isEmpty(string)) {
            gP(str);
            return;
        }
        OpenUserInfo openUserInfo = new OpenUserInfo();
        openUserInfo.parseLocalJson(string);
        if (TextUtils.isEmpty(openUserInfo.getOpenID()) || TextUtils.isEmpty(openUserInfo.getUserName())) {
            gP(str);
        } else {
            o(str, openUserInfo.getOpenID(), openUserInfo.getUserName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2, String str3) {
        String string = getResources().getString(n.j.xiuba_title);
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, String.valueOf(str) + "?openId=" + str2 + "&userName=" + str3, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IX() {
        PluginNetConfigInfos lK = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.lJ().lK();
        if (lK != null && lK.getConfigs() != null && !lK.getConfigs().isEmpty()) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : lK.getConfigs()) {
                if (pluginConfig != null && com.baidu.tbadk.pluign.a.EV().ga(pluginConfig.ext)) {
                    com.baidu.tbadk.pluign.a.EV().fY(pluginConfig.package_name);
                }
            }
        }
    }

    private void IY() {
        this.aRQ.setPriority(100);
        registerListener(this.aRQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aRN);
        registerListener(this.aRO);
        IY();
        CF();
        registerListener(this.aRR);
        registerListener(this.aRP);
        this.aRH = new ArrayList(0);
        this.aRI = new ArrayList(0);
        this.aRM = new ArrayList(0);
        Jb();
        IX();
    }

    private void CF() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_OPEN_USERINFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_OPEN_USER_INFO);
        tbHttpMessageTask.setResponsedClass(OpenUserResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void gP(String str) {
        getPageContext().getOrignalPage().showLoadingDialog(getResources().getString(n.j.loading), null);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_OPEN_USERINFO);
        httpMessage.setExtra(str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(boolean z) {
        if (this.aRE != null) {
            this.aRE.u("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> DS = this.aRG.DS();
        if (DS != null && !DS.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : DS) {
                if (cVar != null && "discover_friend".equals(cVar.Jq())) {
                    cVar.bV(z);
                    this.aRG.A(cVar);
                }
            }
        }
    }

    private View IZ() {
        this.mFooterView = LayoutInflater.from(getActivity()).inflate(n.h.discover_list_footer, (ViewGroup) this.aRC, false);
        ((ViewGroup) this.mFooterView.findViewById(n.g.text_layout)).setOnClickListener(new o(this));
        com.baidu.tbadk.i.a.a(getPageContext(), this.mFooterView);
        return this.mFooterView;
    }

    private void B(View view) {
        this.aRD = (NoNetworkView) view.findViewById(n.g.view_no_network);
        this.aRC = (BdListView) view.findViewById(n.g.listview);
        this.aRC.addFooterView(IZ());
        this.mPullView = new com.baidu.tbadk.core.view.t(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aRC.setPullRefresh(this.mPullView);
        this.mPullView.a(new p(this));
        this.aRC.setOnItemClickListener(new q(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bU(false);
            cVar.bV(false);
            if (this.aRE != null) {
                this.aRE.u(cVar.Jq(), false);
            }
            this.aRG.notifyDataSetChanged();
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.Jq())) {
                com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.Jq())) {
                aRA = false;
            }
        }
    }

    private void a(PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig != null && pluginConfig.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cF(String.format(TbadkApplication.getInst().getString(n.j.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f)));
            aVar.a(TbadkCoreApplication.m411getInst().getString(n.j.download), new c(this, pluginConfig));
            aVar.b(TbadkCoreApplication.m411getInst().getString(n.j.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        URI uri;
        if (cVar != null) {
            a(cVar);
            String Jq = cVar.Jq();
            String title = cVar.getTitle();
            String Jo = cVar.Jo();
            if (!StringUtils.isNull(Jq)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), Jq, null);
            }
            if ("discover_friend".equals(Jq)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(Jq)) {
                if (PluginPackageManager.ls().by("com.baidu.tieba.pluginNeighbors")) {
                    a(PluginPackageManager.ls().getPluginConfig("com.baidu.tieba.pluginNeighbors"));
                } else {
                    Ja();
                }
                TiebaStatic.log("c10086");
            } else if ("discover_square".equals(Jq)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(Jq)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(Jq)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
                TiebaStatic.log("c10086");
            } else if ("discover_look_shop".equals(Jq)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(Jq)) {
                if (PluginPackageManager.ls().by("com.baidu.tieba.pluginRandomChat")) {
                    a(PluginPackageManager.ls().getPluginConfig("com.baidu.tieba.pluginRandomChat"));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_RANDCHAT, new EnterChatRoomConfig(getPageContext().getPageActivity())));
                }
            } else if ("discover_game_center".equals(Jq)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(Jq)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_FEED, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (Jo != null) {
                if (Jo.startsWith("game:detail:")) {
                    bf.vn().a(getPageContext(), title, new String[]{Jo, "1000501"});
                } else if (Jo.startsWith("http://m.xiu8.com")) {
                    TiebaStatic.log("c10104");
                    gO(Jo);
                } else if (Jo.startsWith("live:detail:TBCLiveID=")) {
                    int g = com.baidu.adp.lib.h.b.g(Jo.replace("live:detail:TBCLiveID=", ""), -1);
                    if (g != -1) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomChatActivityConfig(getActivity(), g)));
                    }
                } else if (com.baidu.tbadk.core.util.o.dl(Jo) == 3) {
                    com.baidu.tbadk.core.util.o.a(getPageContext(), Jo);
                } else {
                    try {
                        uri = new URI(Jo);
                    } catch (URISyntaxException e) {
                        BdLog.e(e);
                        uri = null;
                    }
                    TiebaStatic.log(new av("c10116").aa("obj_url", uri != null ? uri.getHost() : Jo));
                    bf.vn().a((TbPageContext<?>) getPageContext(), title, new String[]{Jo}, true);
                }
            }
        }
    }

    public void Ja() {
        if (TbadkApplication.getInst().getLocationShared()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_NEIGHBORS, new IntentConfig(getPageContext().getPageActivity())));
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bG(n.j.warning_location_switch_off);
        aVar.a(n.j.isopen, new e(this));
        aVar.b(n.j.cancel, new f(this));
        aVar.b(getPageContext());
        aVar.tf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(n.h.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        B(getView());
        this.aRG = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, n.h.discover_list_item, null);
        this.aRC.setAdapter((ListAdapter) this.aRG);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.Jq())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("game_is_show_tip", true);
                cVar.bU(false);
                cVar.bV(z);
            } else if ("discover_friend".equals(cVar.Jq())) {
                cVar.bU(false);
                cVar.bV(aRA);
            } else if (!com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bU(false);
                cVar.bV(false);
            }
        }
    }

    private void Jb() {
        this.aRB = new t(getPageContext());
        this.aRB.a(new g(this));
    }

    private void Jc() {
        List<com.baidu.tieba.discover.data.c> list;
        com.baidu.tieba.discover.data.d dVar;
        if (this.aRI.isEmpty() || (dVar = this.aRI.get(this.aRI.size() - 1)) == null) {
            list = null;
        } else {
            list = dVar.Jv();
        }
        D(list);
        List<com.baidu.tieba.discover.data.c> Jd = Jd();
        if (Jd == null) {
            Jd = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        dVar2.setType(0);
        dVar2.J(arrayList);
        this.aRI.add(dVar2);
        arrayList.addAll(Jd);
    }

    private void D(List<com.baidu.tieba.discover.data.c> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<com.baidu.tieba.discover.data.c> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.discover.data.c next = it.next();
                if (next != null && next.Ju()) {
                    it.remove();
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> Jd() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String[] EW = com.baidu.tbadk.pluign.a.EV().EW();
        if (EW == null || EW.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : EW) {
            if (!StringUtils.isNull(str) && PluginPackageManager.ls().bw(str) && !PluginPackageManager.ls().bx(str) && (pluginConfig = PluginPackageManager.ls().getPluginConfig(str)) != null) {
                com.baidu.tieba.discover.data.c cVar = new com.baidu.tieba.discover.data.c();
                cVar.setTitle(pluginConfig.display_name);
                cVar.gT(pluginConfig.icon);
                cVar.gU(this.aRB.gS(str));
                cVar.bV(PluginPackageManager.ls().by(str));
                cVar.bW(true);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(boolean z) {
        Jc();
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aRH) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        G(arrayList);
        this.aRM.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aRI) {
            if (dVar != null && dVar.Jv() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.J(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.Jv()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.Jv().add(cVar2);
                        gQ(cVar2.Jo());
                    }
                }
            }
        }
        E(arrayList2);
        H(F(arrayList2));
    }

    private void E(List<com.baidu.tieba.discover.data.d> list) {
        if (list == null || list.size() == 0) {
            if (!this.aRL) {
                Je();
                this.aRL = true;
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.d dVar = list.get(list.size() - 1);
        if (dVar == null || dVar.Jv() == null || dVar.Jv().size() == 0) {
            if (!this.aRL) {
                Je();
                this.aRL = true;
            }
        } else if (this.aRL) {
            this.aRL = false;
            if (this.mFooterView instanceof ViewGroup) {
                ((ViewGroup) this.mFooterView).removeViewAt(0);
            }
        }
    }

    private void Je() {
        if (this.mFooterView instanceof ViewGroup) {
            this.aRS = new View(getPageContext().getPageActivity());
            this.aRS.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(n.e.ds30)));
            as.j(this.aRS, n.d.cp_bg_line_c);
            ((ViewGroup) this.mFooterView).addView(this.aRS, 0);
        }
    }

    private void gQ(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String mA = com.baidu.tieba.tbadkCore.util.n.mA(str);
                if (!StringUtils.isNull(mA)) {
                    this.aRM.add(mA);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", mA, "ref_id", "1000501");
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> F(List<com.baidu.tieba.discover.data.d> list) {
        ArrayList arrayList = new ArrayList(0);
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (com.baidu.tieba.discover.data.d dVar : list) {
            int size = dVar.Jv().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.Jv().get(i);
                if (size == 1) {
                    cVar.fd(3);
                } else if (i == 0) {
                    cVar.fd(1);
                } else if (i == size - 1) {
                    cVar.fd(2);
                } else {
                    cVar.fd(0);
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
        String Jq = cVar.Jq();
        if ("discover_nearby".equals(Jq)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_NEIGHBORS);
        }
        if ("discover_square".equals(Jq)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_look_shop".equals(Jq)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(Jq)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_RANDCHAT);
        }
        if (e(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(Jq)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_friend".equals(Jq)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        }
        return true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.Jq())) {
            return true;
        }
        String Jo = cVar.Jo();
        if (Jo != null) {
            return Jo.startsWith("gamecenter:") || Jo.startsWith("game:detail:");
        }
        return false;
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_hot_video".equals(cVar.Jq())) {
            return true;
        }
        String Jo = cVar.Jo();
        return Jo != null && Jo.startsWith("live:detail:TBCLiveID=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aRC.removeHeaderView(this.aRF);
        if (banner != null) {
            if (this.aRF == null) {
                Jf();
            }
            this.aRF.reset();
            this.aRF.a(getPageContext(), banner.pic_url, banner.link);
            this.aRF.setBannerViewClickListener(new h(this, banner.link));
            this.aRC.addHeaderView(this.aRF);
        }
    }

    private void Jf() {
        this.aRF = new BannerView(getPageContext().getPageActivity());
        this.aRF.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(n.e.ds100)));
    }

    private void Jg() {
        this.aRE = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aRE.setOnHeaderItemClickListener(new i(this));
    }

    private void G(List<com.baidu.tieba.discover.data.c> list) {
        this.aRC.removeHeaderView(this.aRE);
        if (list != null && !list.isEmpty()) {
            if (this.aRE == null) {
                Jg();
            }
            this.aRE.setData(list);
            this.aRE.f(getPageContext());
            this.aRC.addHeaderView(this.aRE);
        }
    }

    private void H(List<com.baidu.tieba.discover.data.c> list) {
        this.aRG.s(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aRM.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aRM.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aRK) {
            this.aRC.nb();
            TiebaStatic.log("found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (getBaseFragmentActivity() != null) {
            getBaseFragmentActivity().getLayoutMode().ac(i == 1);
            if (getView() != null) {
                getBaseFragmentActivity().getLayoutMode().k(getView());
            }
            if (this.aRF != null) {
                this.aRF.ot();
            }
            com.baidu.tbadk.i.a.a(getPageContext(), this.mFooterView);
            if (this.aRE != null) {
                this.aRE.f(getPageContext());
            }
            if (this.aRD != null) {
                this.aRD.onChangeSkinType(getPageContext(), i);
            }
            if (this.aRS != null) {
                as.j(this.aRS, n.d.cp_bg_line_c);
            }
            this.aRG.a(getPageContext(), i);
            this.mPullView.cP(i);
        }
    }
}
