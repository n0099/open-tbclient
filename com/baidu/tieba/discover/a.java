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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.discover.data.OpenUserInfo;
import com.baidu.tieba.discover.data.OpenUserResponsedMessage;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FoundNew.Banner;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private static boolean aKX;
    private u aKY;
    private BdListView aKZ;
    private NoNetworkView aLa;
    private com.baidu.tieba.discover.a.b aLb;
    private BannerView aLc;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.discover.a.d> aLd;
    private List<com.baidu.tieba.discover.data.c> aLe;
    private List<com.baidu.tieba.discover.data.d> aLf;
    private boolean aLg;
    private boolean aLh;
    private boolean aLi;
    private List<String> aLj;
    private final CustomMessageListener aLk = new b(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private CustomMessageListener aLl = new j(this, CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW);
    private HttpMessageListener aLm = new k(this, CmdConfigHttp.CMD_GET_OPEN_USERINFO);
    private final CustomMessageListener aLn = new l(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener aLo = new m(this, CmdConfigCustom.DISCOVER_NEED_REFRESH_NET_PLUGIN);
    View aLp;
    private View mFooterView;
    private z mPullView;

    static {
        HL();
    }

    private static void HL() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW, new n());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void gc(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            m(str, "", "");
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.ts().getString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), "");
        if (TextUtils.isEmpty(string)) {
            gd(str);
            return;
        }
        OpenUserInfo openUserInfo = new OpenUserInfo();
        openUserInfo.parseLocalJson(string);
        if (TextUtils.isEmpty(openUserInfo.getOpenID()) || TextUtils.isEmpty(openUserInfo.getUserName())) {
            gd(str);
        } else {
            m(str, openUserInfo.getOpenID(), openUserInfo.getUserName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, String str2, String str3) {
        String string = getResources().getString(i.C0057i.xiuba_title);
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), false, String.valueOf(str) + "?openId=" + str2 + "&userName=" + str3, string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        PluginNetConfigInfos mk = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk();
        if (mk != null && mk.getConfigs() != null && !mk.getConfigs().isEmpty()) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : mk.getConfigs()) {
                if (pluginConfig != null && com.baidu.tbadk.pluign.a.Es().ft(pluginConfig.ext)) {
                    com.baidu.tbadk.pluign.a.Es().fr(pluginConfig.package_name);
                }
            }
        }
    }

    private void HN() {
        this.aLn.setPriority(100);
        registerListener(this.aLn);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aLk);
        registerListener(this.aLl);
        HN();
        BY();
        registerListener(this.aLo);
        registerListener(this.aLm);
        this.aLe = new ArrayList(0);
        this.aLf = new ArrayList(0);
        this.aLj = new ArrayList(0);
        HQ();
        HM();
    }

    private void BY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_OPEN_USERINFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_OPEN_USER_INFO);
        tbHttpMessageTask.setResponsedClass(OpenUserResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void gd(String str) {
        getPageContext().getOrignalPage().showLoadingDialog(getResources().getString(i.C0057i.loading), null);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_OPEN_USERINFO);
        httpMessage.setExtra(str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        if (this.aLb != null) {
            this.aLb.s("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> Dp = this.aLd.Dp();
        if (Dp != null && !Dp.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : Dp) {
                if (cVar != null && "discover_friend".equals(cVar.If())) {
                    cVar.bF(z);
                    this.aLd.z(cVar);
                }
            }
        }
    }

    private View HO() {
        this.mFooterView = LayoutInflater.from(getActivity()).inflate(i.g.discover_list_footer, (ViewGroup) this.aKZ, false);
        ((ViewGroup) this.mFooterView.findViewById(i.f.text_layout)).setOnClickListener(new o(this));
        com.baidu.tbadk.f.a.a(getPageContext(), this.mFooterView);
        return this.mFooterView;
    }

    private void x(View view) {
        this.aLa = (NoNetworkView) view.findViewById(i.f.view_no_network);
        this.aKZ = (BdListView) view.findViewById(i.f.listview);
        this.aKZ.addFooterView(HO());
        this.mPullView = new z(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aKZ.setPullRefresh(this.mPullView);
        this.mPullView.a(new p(this));
        this.aKZ.setOnItemClickListener(new q(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bE(false);
            cVar.bF(false);
            if (this.aLb != null) {
                this.aLb.s(cVar.If(), false);
            }
            this.aLd.notifyDataSetChanged();
            com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.If())) {
                com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.If())) {
                aKX = false;
            }
        }
    }

    private void a(PluginNetConfigInfos.PluginConfig pluginConfig) {
        if (pluginConfig != null && pluginConfig.newest != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
            aVar.cn(String.format(TbadkApplication.getInst().getString(i.C0057i.plugin_download_size_prompt), Float.valueOf(pluginConfig.newest.size / 1048576.0f)));
            aVar.a(TbadkCoreApplication.m411getInst().getString(i.C0057i.download), new c(this, pluginConfig));
            aVar.b(TbadkCoreApplication.m411getInst().getString(i.C0057i.cancel), new d(this));
            aVar.b(getPageContext());
            aVar.sP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            a(cVar);
            String If = cVar.If();
            String title = cVar.getTitle();
            String Id = cVar.Id();
            if (!StringUtils.isNull(If)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), If, null);
            }
            if ("discover_friend".equals(If)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(If)) {
                if (PluginPackageManager.lT().bs("com.baidu.tieba.pluginNeighbors")) {
                    a(PluginPackageManager.lT().getPluginConfig("com.baidu.tieba.pluginNeighbors"));
                } else {
                    HP();
                }
                TiebaStatic.log("c10086");
            } else if ("discover_square".equals(If)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(If)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(If)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
                TiebaStatic.log("c10086");
            } else if ("discover_look_shop".equals(If)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(If)) {
                if (PluginPackageManager.lT().bs("com.baidu.tieba.pluginRandomChat")) {
                    a(PluginPackageManager.lT().getPluginConfig("com.baidu.tieba.pluginRandomChat"));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_RANDCHAT, new EnterChatRoomConfig(getPageContext().getPageActivity())));
                }
            } else if ("discover_game_center".equals(If)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(If)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_FEED, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (Id != null) {
                if (Id.startsWith("game:detail:")) {
                    ax.uR().a(getPageContext(), title, new String[]{Id, "1000501"});
                } else if (Id.startsWith("http://m.xiu8.com")) {
                    TiebaStatic.log("c10104");
                    gc(Id);
                } else if (Id.startsWith("live:detail:TBCLiveID=")) {
                    int g = com.baidu.adp.lib.g.b.g(Id.replace("live:detail:TBCLiveID=", ""), -1);
                    if (g != -1) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomChatActivityConfig(getActivity(), g)));
                    }
                } else if (com.baidu.tbadk.core.util.o.cQ(Id) == 3) {
                    com.baidu.tbadk.core.util.o.a(getPageContext(), Id);
                } else {
                    ax.uR().a((TbPageContext<?>) getPageContext(), title, new String[]{Id}, true);
                }
            }
        }
    }

    public void HP() {
        if (TbadkApplication.getInst().getLocationShared()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_NEIGHBORS, new IntentConfig(getPageContext().getPageActivity())));
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bC(i.C0057i.warning_location_switch_off);
        aVar.a(i.C0057i.isopen, new e(this));
        aVar.b(i.C0057i.cancel, new f(this));
        aVar.b(getPageContext());
        aVar.sP();
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
        this.aLd = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, i.g.discover_list_item, null);
        this.aKZ.setAdapter((ListAdapter) this.aLd);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.If())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("game_is_show_tip", true);
                cVar.bE(false);
                cVar.bF(z);
            } else if ("discover_friend".equals(cVar.If())) {
                cVar.bE(false);
                cVar.bF(aKX);
            } else if (!com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bE(false);
                cVar.bF(false);
            }
        }
    }

    private void HQ() {
        this.aKY = new u(getPageContext());
        this.aKY.a(new g(this));
    }

    private void HR() {
        List<com.baidu.tieba.discover.data.c> list;
        com.baidu.tieba.discover.data.d dVar;
        if (this.aLf.isEmpty() || (dVar = this.aLf.get(this.aLf.size() - 1)) == null) {
            list = null;
        } else {
            list = dVar.Ik();
        }
        A(list);
        List<com.baidu.tieba.discover.data.c> HS = HS();
        if (HS == null) {
            HS = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        dVar2.setType(0);
        dVar2.G(arrayList);
        this.aLf.add(dVar2);
        arrayList.addAll(HS);
    }

    private void A(List<com.baidu.tieba.discover.data.c> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<com.baidu.tieba.discover.data.c> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.discover.data.c next = it.next();
                if (next != null && next.Ij()) {
                    it.remove();
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> HS() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String[] Et = com.baidu.tbadk.pluign.a.Es().Et();
        if (Et == null || Et.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : Et) {
            if (!StringUtils.isNull(str) && PluginPackageManager.lT().bq(str) && !PluginPackageManager.lT().br(str) && (pluginConfig = PluginPackageManager.lT().getPluginConfig(str)) != null) {
                com.baidu.tieba.discover.data.c cVar = new com.baidu.tieba.discover.data.c();
                cVar.setTitle(pluginConfig.display_name);
                cVar.gh(pluginConfig.icon);
                cVar.gi(this.aKY.gg(str));
                cVar.bF(PluginPackageManager.lT().bs(str));
                cVar.bG(true);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        HR();
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aLe) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        D(arrayList);
        this.aLj.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aLf) {
            if (dVar != null && dVar.Ik() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.G(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.Ik()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.Ik().add(cVar2);
                        ge(cVar2.Id());
                    }
                }
            }
        }
        B(arrayList2);
        E(C(arrayList2));
    }

    private void B(List<com.baidu.tieba.discover.data.d> list) {
        if (list == null || list.size() == 0) {
            if (!this.aLi) {
                HT();
                this.aLi = true;
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.d dVar = list.get(list.size() - 1);
        if (dVar == null || dVar.Ik() == null || dVar.Ik().size() == 0) {
            if (!this.aLi) {
                HT();
                this.aLi = true;
            }
        } else if (this.aLi) {
            this.aLi = false;
            if (this.mFooterView instanceof ViewGroup) {
                ((ViewGroup) this.mFooterView).removeViewAt(0);
            }
        }
    }

    private void HT() {
        if (this.mFooterView instanceof ViewGroup) {
            this.aLp = new View(getPageContext().getPageActivity());
            this.aLp.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(i.d.ds30)));
            al.j(this.aLp, i.c.cp_bg_line_c);
            ((ViewGroup) this.mFooterView).addView(this.aLp, 0);
        }
    }

    private void ge(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String kC = com.baidu.tieba.tbadkCore.util.l.kC(str);
                if (!StringUtils.isNull(kC)) {
                    this.aLj.add(kC);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", kC, "ref_id", "1000501");
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> C(List<com.baidu.tieba.discover.data.d> list) {
        ArrayList arrayList = new ArrayList(0);
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (com.baidu.tieba.discover.data.d dVar : list) {
            int size = dVar.Ik().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.Ik().get(i);
                if (size == 1) {
                    cVar.eH(3);
                } else if (i == 0) {
                    cVar.eH(1);
                } else if (i == size - 1) {
                    cVar.eH(2);
                } else {
                    cVar.eH(0);
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
        String If = cVar.If();
        if ("discover_nearby".equals(If)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_NEIGHBORS);
        }
        if ("discover_square".equals(If)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_look_shop".equals(If)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(If)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_RANDCHAT);
        }
        if (e(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(If)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_friend".equals(If)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        }
        return true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.If())) {
            return true;
        }
        String Id = cVar.Id();
        if (Id != null) {
            return Id.startsWith("gamecenter:") || Id.startsWith("game:detail:");
        }
        return false;
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_hot_video".equals(cVar.If())) {
            return true;
        }
        String Id = cVar.Id();
        return Id != null && Id.startsWith("live:detail:TBCLiveID=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aKZ.removeHeaderView(this.aLc);
        if (banner != null) {
            if (this.aLc == null) {
                HU();
            }
            this.aLc.reset();
            this.aLc.a(getPageContext(), banner.pic_url, banner.link);
            this.aLc.setBannerViewClickListener(new h(this, banner.link));
            this.aKZ.addHeaderView(this.aLc);
        }
    }

    private void HU() {
        this.aLc = new BannerView(getPageContext().getPageActivity());
        this.aLc.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(i.d.ds100)));
    }

    private void HV() {
        this.aLb = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aLb.setOnHeaderItemClickListener(new i(this));
    }

    private void D(List<com.baidu.tieba.discover.data.c> list) {
        this.aKZ.removeHeaderView(this.aLb);
        if (list != null && !list.isEmpty()) {
            if (this.aLb == null) {
                HV();
            }
            this.aLb.setData(list);
            this.aLb.e(getPageContext());
            this.aKZ.addHeaderView(this.aLb);
        }
    }

    private void E(List<com.baidu.tieba.discover.data.c> list) {
        this.aLd.r(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aLj.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aLj.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aLh) {
            this.aKZ.ny();
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
            if (this.aLc != null) {
                this.aLc.oQ();
            }
            com.baidu.tbadk.f.a.a(getPageContext(), this.mFooterView);
            if (this.aLb != null) {
                this.aLb.e(getPageContext());
            }
            if (this.aLa != null) {
                this.aLa.onChangeSkinType(getPageContext(), i);
            }
            if (this.aLp != null) {
                al.j(this.aLp, i.c.cp_bg_line_c);
            }
            this.aLd.a(getPageContext(), i);
            this.mPullView.cG(i);
        }
    }
}
