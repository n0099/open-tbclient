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
    private static boolean aLk;
    View aLC;
    private u aLl;
    private BdListView aLm;
    private NoNetworkView aLn;
    private com.baidu.tieba.discover.a.b aLo;
    private BannerView aLp;
    private com.baidu.tbadk.mvc.g.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.d.b, com.baidu.tieba.discover.a.d> aLq;
    private List<com.baidu.tieba.discover.data.c> aLr;
    private List<com.baidu.tieba.discover.data.d> aLs;
    private boolean aLt;
    private boolean aLu;
    private boolean aLv;
    private List<String> aLw;
    private View mFooterView;
    private z mPullView;
    private final CustomMessageListener aLx = new b(this, CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP);
    private CustomMessageListener aLy = new j(this, CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW);
    private HttpMessageListener aLz = new k(this, CmdConfigHttp.CMD_GET_OPEN_USERINFO);
    private final CustomMessageListener aLA = new l(this, CmdConfigCustom.DISCOVER_NEED_ADD_VIEW);
    private final CustomMessageListener aLB = new m(this, CmdConfigCustom.DISCOVER_NEED_REFRESH_NET_PLUGIN);

    static {
        Hz();
    }

    private static void Hz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW, new n());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void gj(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            n(str, "", "");
            return;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.tx().getString("open_user_info_" + TbadkCoreApplication.getCurrentAccount(), "");
        if (TextUtils.isEmpty(string)) {
            gk(str);
            return;
        }
        OpenUserInfo openUserInfo = new OpenUserInfo();
        openUserInfo.parseLocalJson(string);
        if (TextUtils.isEmpty(openUserInfo.getOpenID()) || TextUtils.isEmpty(openUserInfo.getUserName())) {
            gk(str);
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
    public void HA() {
        PluginNetConfigInfos mh = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mg().mh();
        if (mh != null && mh.getConfigs() != null && !mh.getConfigs().isEmpty()) {
            for (PluginNetConfigInfos.PluginConfig pluginConfig : mh.getConfigs()) {
                if (pluginConfig != null && com.baidu.tbadk.pluign.a.EC().fB(pluginConfig.ext)) {
                    com.baidu.tbadk.pluign.a.EC().fz(pluginConfig.package_name);
                }
            }
        }
    }

    private void HB() {
        this.aLA.setPriority(100);
        registerListener(this.aLA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aLx);
        registerListener(this.aLy);
        HB();
        Cm();
        registerListener(this.aLB);
        registerListener(this.aLz);
        this.aLr = new ArrayList(0);
        this.aLs = new ArrayList(0);
        this.aLw = new ArrayList(0);
        HE();
        HA();
    }

    private void Cm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_OPEN_USERINFO, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_OPEN_USER_INFO);
        tbHttpMessageTask.setResponsedClass(OpenUserResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void gk(String str) {
        getPageContext().getOrignalPage().showLoadingDialog(getResources().getString(i.h.loading), null);
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_OPEN_USERINFO);
        httpMessage.setExtra(str);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        if (this.aLo != null) {
            this.aLo.u("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> Dz = this.aLq.Dz();
        if (Dz != null && !Dz.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : Dz) {
                if (cVar != null && "discover_friend".equals(cVar.HT())) {
                    cVar.bK(z);
                    this.aLq.A(cVar);
                }
            }
        }
    }

    private View HC() {
        this.mFooterView = LayoutInflater.from(getActivity()).inflate(i.g.discover_list_footer, (ViewGroup) this.aLm, false);
        ((ViewGroup) this.mFooterView.findViewById(i.f.text_layout)).setOnClickListener(new o(this));
        com.baidu.tbadk.h.a.a(getPageContext(), this.mFooterView);
        return this.mFooterView;
    }

    private void x(View view) {
        this.aLn = (NoNetworkView) view.findViewById(i.f.view_no_network);
        this.aLm = (BdListView) view.findViewById(i.f.listview);
        this.aLm.addFooterView(HC());
        this.mPullView = new z(getPageContext());
        this.mPullView.setTag(getUniqueId());
        this.aLm.setPullRefresh(this.mPullView);
        this.mPullView.a(new p(this));
        this.aLm.setOnItemClickListener(new q(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bJ(false);
            cVar.bK(false);
            if (this.aLo != null) {
                this.aLo.u(cVar.HT(), false);
            }
            this.aLq.notifyDataSetChanged();
            com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.HT())) {
                com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.HT())) {
                aLk = false;
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
            aVar.sU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            a(cVar);
            String HT = cVar.HT();
            String title = cVar.getTitle();
            String HR = cVar.HR();
            if (!StringUtils.isNull(HT)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), HT, null);
            }
            if ("discover_friend".equals(HT)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(HT)) {
                if (PluginPackageManager.lQ().bs("com.baidu.tieba.pluginNeighbors")) {
                    a(PluginPackageManager.lQ().getPluginConfig("com.baidu.tieba.pluginNeighbors"));
                } else {
                    HD();
                }
                TiebaStatic.log("c10086");
            } else if ("discover_square".equals(HT)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(HT)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(HT)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.SIGN_ALL_FORUM_CUSTOM_CMD, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
                TiebaStatic.log("c10086");
            } else if ("discover_look_shop".equals(HT)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(HT)) {
                if (PluginPackageManager.lQ().bs("com.baidu.tieba.pluginRandomChat")) {
                    a(PluginPackageManager.lQ().getPluginConfig("com.baidu.tieba.pluginRandomChat"));
                } else {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_RANDCHAT, new EnterChatRoomConfig(getPageContext().getPageActivity())));
                }
            } else if ("discover_game_center".equals(HT)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_GAME_MSG_TIP, false));
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(HT)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_FEED, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (HR != null) {
                if (HR.startsWith("game:detail:")) {
                    ax.uX().a(getPageContext(), title, new String[]{HR, "1000501"});
                } else if (HR.startsWith("http://m.xiu8.com")) {
                    TiebaStatic.log("c10104");
                    gj(HR);
                } else if (HR.startsWith("live:detail:TBCLiveID=")) {
                    int g = com.baidu.adp.lib.g.b.g(HR.replace("live:detail:TBCLiveID=", ""), -1);
                    if (g != -1) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomChatActivityConfig(getActivity(), g)));
                    }
                } else if (com.baidu.tbadk.core.util.o.cW(HR) == 3) {
                    com.baidu.tbadk.core.util.o.a(getPageContext(), HR);
                } else {
                    ax.uX().a((TbPageContext<?>) getPageContext(), title, new String[]{HR}, true);
                }
            }
        }
    }

    public void HD() {
        if (TbadkApplication.getInst().getLocationShared()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_NEIGHBORS, new IntentConfig(getPageContext().getPageActivity())));
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bF(i.h.warning_location_switch_off);
        aVar.a(i.h.isopen, new e(this));
        aVar.b(i.h.cancel, new f(this));
        aVar.b(getPageContext());
        aVar.sU();
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
        this.aLq = new com.baidu.tbadk.mvc.g.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, i.g.discover_list_item, null);
        this.aLm.setAdapter((ListAdapter) this.aLq);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.HT())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("game_is_show_tip", true);
                cVar.bJ(false);
                cVar.bK(z);
            } else if ("discover_friend".equals(cVar.HT())) {
                cVar.bJ(false);
                cVar.bK(aLk);
            } else if (!com.baidu.tbadk.core.sharedPref.b.tx().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bJ(false);
                cVar.bK(false);
            }
        }
    }

    private void HE() {
        this.aLl = new u(getPageContext());
        this.aLl.a(new g(this));
    }

    private void HF() {
        List<com.baidu.tieba.discover.data.c> list;
        com.baidu.tieba.discover.data.d dVar;
        if (this.aLs.isEmpty() || (dVar = this.aLs.get(this.aLs.size() - 1)) == null) {
            list = null;
        } else {
            list = dVar.HY();
        }
        B(list);
        List<com.baidu.tieba.discover.data.c> HG = HG();
        if (HG == null) {
            HG = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
        dVar2.setType(0);
        dVar2.H(arrayList);
        this.aLs.add(dVar2);
        arrayList.addAll(HG);
    }

    private void B(List<com.baidu.tieba.discover.data.c> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<com.baidu.tieba.discover.data.c> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.discover.data.c next = it.next();
                if (next != null && next.HX()) {
                    it.remove();
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> HG() {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String[] ED = com.baidu.tbadk.pluign.a.EC().ED();
        if (ED == null || ED.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : ED) {
            if (!StringUtils.isNull(str) && PluginPackageManager.lQ().bq(str) && !PluginPackageManager.lQ().br(str) && (pluginConfig = PluginPackageManager.lQ().getPluginConfig(str)) != null) {
                com.baidu.tieba.discover.data.c cVar = new com.baidu.tieba.discover.data.c();
                cVar.setTitle(pluginConfig.display_name);
                cVar.go(pluginConfig.icon);
                cVar.gp(this.aLl.gn(str));
                cVar.bK(PluginPackageManager.lQ().bs(str));
                cVar.bL(true);
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(boolean z) {
        HF();
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aLr) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        E(arrayList);
        this.aLw.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aLs) {
            if (dVar != null && dVar.HY() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.H(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.HY()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.HY().add(cVar2);
                        gl(cVar2.HR());
                    }
                }
            }
        }
        C(arrayList2);
        F(D(arrayList2));
    }

    private void C(List<com.baidu.tieba.discover.data.d> list) {
        if (list == null || list.size() == 0) {
            if (!this.aLv) {
                HH();
                this.aLv = true;
                return;
            }
            return;
        }
        com.baidu.tieba.discover.data.d dVar = list.get(list.size() - 1);
        if (dVar == null || dVar.HY() == null || dVar.HY().size() == 0) {
            if (!this.aLv) {
                HH();
                this.aLv = true;
            }
        } else if (this.aLv) {
            this.aLv = false;
            if (this.mFooterView instanceof ViewGroup) {
                ((ViewGroup) this.mFooterView).removeViewAt(0);
            }
        }
    }

    private void HH() {
        if (this.mFooterView instanceof ViewGroup) {
            this.aLC = new View(getPageContext().getPageActivity());
            this.aLC.setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(i.d.ds30)));
            al.i(this.aLC, i.c.cp_bg_line_c);
            ((ViewGroup) this.mFooterView).addView(this.aLC, 0);
        }
    }

    private void gl(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String lh = com.baidu.tieba.tbadkCore.util.l.lh(str);
                if (!StringUtils.isNull(lh)) {
                    this.aLw.add(lh);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", lh, "ref_id", "1000501");
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
            int size = dVar.HY().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.HY().get(i);
                if (size == 1) {
                    cVar.eO(3);
                } else if (i == 0) {
                    cVar.eO(1);
                } else if (i == size - 1) {
                    cVar.eO(2);
                } else {
                    cVar.eO(0);
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
        String HT = cVar.HT();
        if ("discover_nearby".equals(HT)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_NEIGHBORS);
        }
        if ("discover_square".equals(HT)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_look_shop".equals(HT)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_FACESHOP);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(HT)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_RANDCHAT);
        }
        if (e(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(HT)) {
            return TbadkApplication.getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE);
        }
        if ("discover_friend".equals(HT)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        }
        return true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.HT())) {
            return true;
        }
        String HR = cVar.HR();
        if (HR != null) {
            return HR.startsWith("gamecenter:") || HR.startsWith("game:detail:");
        }
        return false;
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_hot_video".equals(cVar.HT())) {
            return true;
        }
        String HR = cVar.HR();
        return HR != null && HR.startsWith("live:detail:TBCLiveID=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aLm.removeHeaderView(this.aLp);
        if (banner != null) {
            if (this.aLp == null) {
                HI();
            }
            this.aLp.reset();
            this.aLp.a(getPageContext(), banner.pic_url, banner.link);
            this.aLp.setBannerViewClickListener(new h(this, banner.link));
            this.aLm.addHeaderView(this.aLp);
        }
    }

    private void HI() {
        this.aLp = new BannerView(getPageContext().getPageActivity());
        this.aLp.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(i.d.ds100)));
    }

    private void HJ() {
        this.aLo = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aLo.setOnHeaderItemClickListener(new i(this));
    }

    private void E(List<com.baidu.tieba.discover.data.c> list) {
        this.aLm.removeHeaderView(this.aLo);
        if (list != null && !list.isEmpty()) {
            if (this.aLo == null) {
                HJ();
            }
            this.aLo.setData(list);
            this.aLo.e(getPageContext());
            this.aLm.addHeaderView(this.aLo);
        }
    }

    private void F(List<com.baidu.tieba.discover.data.c> list) {
        this.aLq.s(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aLw.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aLw.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aLu) {
            this.aLm.nv();
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
            if (this.aLp != null) {
                this.aLp.oN();
            }
            com.baidu.tbadk.h.a.a(getPageContext(), this.mFooterView);
            if (this.aLo != null) {
                this.aLo.e(getPageContext());
            }
            if (this.aLn != null) {
                this.aLn.onChangeSkinType(getPageContext(), i);
            }
            if (this.aLC != null) {
                al.i(this.aLC, i.c.cp_bg_line_c);
            }
            this.aLq.a(getPageContext(), i);
            this.mPullView.cM(i);
        }
    }
}
