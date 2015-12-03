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
    private static boolean aNI;
    private t aNJ;
    private BdListView aNK;
    private NoNetworkView aNL;
    private com.baidu.tieba.discover.a.b aNM;
    private BannerView aNN;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.discover.a.d> aNO;
    private List<com.baidu.tieba.discover.data.c> aNP;
    private List<com.baidu.tieba.discover.data.d> aNQ;
    private boolean aNR;
    private boolean aNS;
    private boolean aNT;
    private List<String> aNU;
    private final CustomMessageListener aNV = new b(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private CustomMessageListener aNW = new j(this, CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW);
    private HttpMessageListener aNX = new k(this, CmdConfigHttp.CMD_GET_OPEN_USERINFO);
    private final CustomMessageListener aNY = new l(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener aNZ = new m(this, CmdConfigCustom.DISCOVER_NEED_REFRESH_NET_PLUGIN);
    View aOa;
    private View mFooterView;
    private com.baidu.tbadk.core.view.s mPullView;

    static {
        IF();
    }

    private static void IF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW, new n());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void gD(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            o(str, "", "");
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tZ().getString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), "");
        if (TextUtils.isEmpty(string)) {
            gE(str);
            return;
        }
        OpenUserInfo openUserInfo = new OpenUserInfo();
        openUserInfo.parseLocalJson(string);
        if (TextUtils.isEmpty(openUserInfo.getOpenID()) || TextUtils.isEmpty(openUserInfo.getUserName())) {
            gE(str);
        } else {
            o(str, openUserInfo.getOpenID(), openUserInfo.getUserName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, String str2, String str3) {
        String string = getResources().getString(n.i.xiuba_title);
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, String.valueOf(str) + "?openId=" + str2 + "&userName=" + str3, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IG() {
        PluginNetConfigInfos mm = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ml().mm();
        if (mm != null && mm.getConfigs() != null && !mm.getConfigs().isEmpty()) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : mm.getConfigs()) {
                if (pluginConfig != null && com.baidu.tbadk.pluign.a.Fh().fW(pluginConfig.ext)) {
                    com.baidu.tbadk.pluign.a.Fh().fU(pluginConfig.package_name);
                }
            }
        }
    }

    private void IH() {
        this.aNY.setPriority(100);
        registerListener(this.aNY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aNV);
        registerListener(this.aNW);
        IH();
        CQ();
        registerListener(this.aNZ);
        registerListener(this.aNX);
        this.aNP = new ArrayList(0);
        this.aNQ = new ArrayList(0);
        this.aNU = new ArrayList(0);
        IK();
        IG();
    }

    private void CQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_OPEN_USERINFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_OPEN_USER_INFO);
        tbHttpMessageTask.setResponsedClass(OpenUserResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void gE(String str) {
        getPageContext().getOrignalPage().showLoadingDialog(getResources().getString(n.i.loading), null);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_OPEN_USERINFO);
        httpMessage.setExtra(str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(boolean z) {
        if (this.aNM != null) {
            this.aNM.u("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> Ed = this.aNO.Ed();
        if (Ed != null && !Ed.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : Ed) {
                if (cVar != null && "discover_friend".equals(cVar.IZ())) {
                    cVar.bU(z);
                    this.aNO.A(cVar);
                }
            }
        }
    }

    private View II() {
        this.mFooterView = LayoutInflater.from(getActivity()).inflate(n.g.discover_list_footer, (ViewGroup) this.aNK, false);
        ((ViewGroup) this.mFooterView.findViewById(n.f.text_layout)).setOnClickListener(new o(this));
        com.baidu.tbadk.i.a.a(getPageContext(), this.mFooterView);
        return this.mFooterView;
    }

    private void A(View view) {
        this.aNL = (NoNetworkView) view.findViewById(n.f.view_no_network);
        this.aNK = (BdListView) view.findViewById(n.f.listview);
        this.aNK.addFooterView(II());
        this.mPullView = new com.baidu.tbadk.core.view.s(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aNK.setPullRefresh(this.mPullView);
        this.mPullView.a(new p(this));
        this.aNK.setOnItemClickListener(new q(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bT(false);
            cVar.bU(false);
            if (this.aNM != null) {
                this.aNM.u(cVar.IZ(), false);
            }
            this.aNO.notifyDataSetChanged();
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.IZ())) {
                com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.IZ())) {
                aNI = false;
            }
        }
    }

    private void a(PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig != null && pluginConfig.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cC(String.format(TbadkApplication.getInst().getString(n.i.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f)));
            aVar.a(TbadkCoreApplication.m411getInst().getString(n.i.download), new c(this, pluginConfig));
            aVar.b(TbadkCoreApplication.m411getInst().getString(n.i.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.tv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        URI uri;
        if (cVar != null) {
            a(cVar);
            String IZ = cVar.IZ();
            String title = cVar.getTitle();
            String IX = cVar.IX();
            if (!StringUtils.isNull(IZ)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), IZ, null);
            }
            if ("discover_friend".equals(IZ)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(IZ)) {
                if (PluginPackageManager.lU().bv("com.baidu.tieba.pluginNeighbors")) {
                    a(PluginPackageManager.lU().getPluginConfig("com.baidu.tieba.pluginNeighbors"));
                } else {
                    IJ();
                }
                TiebaStatic.log("c10086");
            } else if ("discover_square".equals(IZ)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(IZ)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(IZ)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
                TiebaStatic.log("c10086");
            } else if ("discover_look_shop".equals(IZ)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(IZ)) {
                if (PluginPackageManager.lU().bv("com.baidu.tieba.pluginRandomChat")) {
                    a(PluginPackageManager.lU().getPluginConfig("com.baidu.tieba.pluginRandomChat"));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_RANDCHAT, new EnterChatRoomConfig(getPageContext().getPageActivity())));
                }
            } else if ("discover_game_center".equals(IZ)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(IZ)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_FEED, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (IX != null) {
                if (IX.startsWith("game:detail:")) {
                    bf.vD().a(getPageContext(), title, new String[]{IX, "1000501"});
                } else if (IX.startsWith("http://m.xiu8.com")) {
                    TiebaStatic.log("c10104");
                    gD(IX);
                } else if (IX.startsWith("live:detail:TBCLiveID=")) {
                    int g = com.baidu.adp.lib.h.b.g(IX.replace("live:detail:TBCLiveID=", ""), -1);
                    if (g != -1) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomChatActivityConfig(getActivity(), g)));
                    }
                } else if (com.baidu.tbadk.core.util.o.di(IX) == 3) {
                    com.baidu.tbadk.core.util.o.a(getPageContext(), IX);
                } else {
                    try {
                        uri = new URI(IX);
                    } catch (URISyntaxException e) {
                        BdLog.e(e);
                        uri = null;
                    }
                    TiebaStatic.log(new av("c10116").ab("obj_url", uri != null ? uri.getHost() : IX));
                    bf.vD().a((TbPageContext<?>) getPageContext(), title, new String[]{IX}, true);
                }
            }
        }
    }

    public void IJ() {
        if (TbadkApplication.getInst().getLocationShared()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_NEIGHBORS, new IntentConfig(getPageContext().getPageActivity())));
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bN(n.i.warning_location_switch_off);
        aVar.a(n.i.isopen, new e(this));
        aVar.b(n.i.cancel, new f(this));
        aVar.b(getPageContext());
        aVar.tv();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(n.g.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        A(getView());
        this.aNO = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, n.g.discover_list_item, null);
        this.aNK.setAdapter((ListAdapter) this.aNO);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.IZ())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("game_is_show_tip", true);
                cVar.bT(false);
                cVar.bU(z);
            } else if ("discover_friend".equals(cVar.IZ())) {
                cVar.bT(false);
                cVar.bU(aNI);
            } else if (!com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bT(false);
                cVar.bU(false);
            }
        }
    }

    private void IK() {
        this.aNJ = new t(getPageContext());
        this.aNJ.a(new g(this));
    }

    private void IL() {
        List<com.baidu.tieba.discover.data.c> list;
        com.baidu.tieba.discover.data.d dVar;
        if (this.aNQ.isEmpty() || (dVar = this.aNQ.get(this.aNQ.size() - 1)) == null) {
            list = null;
        } else {
            list = dVar.Je();
        }
        C(list);
        List<com.baidu.tieba.discover.data.c> IM = IM();
        if (IM == null) {
            IM = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        dVar2.setType(0);
        dVar2.I(arrayList);
        this.aNQ.add(dVar2);
        arrayList.addAll(IM);
    }

    private void C(List<com.baidu.tieba.discover.data.c> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<com.baidu.tieba.discover.data.c> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.discover.data.c next = it.next();
                if (next != null && next.Jd()) {
                    it.remove();
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> IM() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String[] Fi = com.baidu.tbadk.pluign.a.Fh().Fi();
        if (Fi == null || Fi.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : Fi) {
            if (!StringUtils.isNull(str) && PluginPackageManager.lU().bt(str) && !PluginPackageManager.lU().bu(str) && (pluginConfig = PluginPackageManager.lU().getPluginConfig(str)) != null) {
                com.baidu.tieba.discover.data.c cVar = new com.baidu.tieba.discover.data.c();
                cVar.setTitle(pluginConfig.display_name);
                cVar.gI(pluginConfig.icon);
                cVar.gJ(this.aNJ.gH(str));
                cVar.bU(PluginPackageManager.lU().bv(str));
                cVar.bV(true);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(boolean z) {
        IL();
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aNP) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        F(arrayList);
        this.aNU.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aNQ) {
            if (dVar != null && dVar.Je() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.I(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.Je()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.Je().add(cVar2);
                        gF(cVar2.IX());
                    }
                }
            }
        }
        D(arrayList2);
        G(E(arrayList2));
    }

    private void D(List<com.baidu.tieba.discover.data.d> list) {
        if (list == null || list.size() == 0) {
            if (!this.aNT) {
                IN();
                this.aNT = true;
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.d dVar = list.get(list.size() - 1);
        if (dVar == null || dVar.Je() == null || dVar.Je().size() == 0) {
            if (!this.aNT) {
                IN();
                this.aNT = true;
            }
        } else if (this.aNT) {
            this.aNT = false;
            if (this.mFooterView instanceof ViewGroup) {
                ((ViewGroup) this.mFooterView).removeViewAt(0);
            }
        }
    }

    private void IN() {
        if (this.mFooterView instanceof ViewGroup) {
            this.aOa = new View(getPageContext().getPageActivity());
            this.aOa.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(n.d.ds30)));
            as.j(this.aOa, n.c.cp_bg_line_c);
            ((ViewGroup) this.mFooterView).addView(this.aOa, 0);
        }
    }

    private void gF(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String mC = com.baidu.tieba.tbadkCore.util.n.mC(str);
                if (!StringUtils.isNull(mC)) {
                    this.aNU.add(mC);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", mC, "ref_id", "1000501");
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
            int size = dVar.Je().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.Je().get(i);
                if (size == 1) {
                    cVar.fi(3);
                } else if (i == 0) {
                    cVar.fi(1);
                } else if (i == size - 1) {
                    cVar.fi(2);
                } else {
                    cVar.fi(0);
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
        String IZ = cVar.IZ();
        if ("discover_nearby".equals(IZ)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_NEIGHBORS);
        }
        if ("discover_square".equals(IZ)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_look_shop".equals(IZ)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(IZ)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_RANDCHAT);
        }
        if (e(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(IZ)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_friend".equals(IZ)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        }
        return true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.IZ())) {
            return true;
        }
        String IX = cVar.IX();
        if (IX != null) {
            return IX.startsWith("gamecenter:") || IX.startsWith("game:detail:");
        }
        return false;
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_hot_video".equals(cVar.IZ())) {
            return true;
        }
        String IX = cVar.IX();
        return IX != null && IX.startsWith("live:detail:TBCLiveID=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aNK.removeHeaderView(this.aNN);
        if (banner != null) {
            if (this.aNN == null) {
                IO();
            }
            this.aNN.reset();
            this.aNN.a(getPageContext(), banner.pic_url, banner.link);
            this.aNN.setBannerViewClickListener(new h(this, banner.link));
            this.aNK.addHeaderView(this.aNN);
        }
    }

    private void IO() {
        this.aNN = new BannerView(getPageContext().getPageActivity());
        this.aNN.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(n.d.ds100)));
    }

    private void IP() {
        this.aNM = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aNM.setOnHeaderItemClickListener(new i(this));
    }

    private void F(List<com.baidu.tieba.discover.data.c> list) {
        this.aNK.removeHeaderView(this.aNM);
        if (list != null && !list.isEmpty()) {
            if (this.aNM == null) {
                IP();
            }
            this.aNM.setData(list);
            this.aNM.f(getPageContext());
            this.aNK.addHeaderView(this.aNM);
        }
    }

    private void G(List<com.baidu.tieba.discover.data.c> list) {
        this.aNO.r(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aNU.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aNU.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aNS) {
            this.aNK.nD();
            TiebaStatic.log("found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (getBaseFragmentActivity() != null) {
            getBaseFragmentActivity().getLayoutMode().af(i == 1);
            if (getView() != null) {
                getBaseFragmentActivity().getLayoutMode().k(getView());
            }
            if (this.aNN != null) {
                this.aNN.oV();
            }
            com.baidu.tbadk.i.a.a(getPageContext(), this.mFooterView);
            if (this.aNM != null) {
                this.aNM.f(getPageContext());
            }
            if (this.aNL != null) {
                this.aNL.onChangeSkinType(getPageContext(), i);
            }
            if (this.aOa != null) {
                as.j(this.aOa, n.c.cp_bg_line_c);
            }
            this.aNO.a(getPageContext(), i);
            this.mPullView.cV(i);
        }
    }
}
