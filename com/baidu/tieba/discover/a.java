package com.baidu.tieba.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.EnterChatRoomConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.HotLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SingleForumFeedActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FoundNew.Banner;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private static boolean aBD;
    private p aBE;
    private BdListView aBF;
    private NoNetworkView aBG;
    private com.baidu.tieba.discover.a.b aBH;
    private BannerView aBI;
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.a.d> aBJ;
    private List<com.baidu.tieba.discover.data.c> aBK;
    private List<com.baidu.tieba.discover.data.d> aBL;
    private boolean aBM;
    private boolean aBN;
    private List<String> aBO;
    private final CustomMessageListener aBP = new b(this, 2001236);
    private CustomMessageListener aBQ = new e(this, 2012119);
    private final CustomMessageListener aBR = new f(this, 2009503);
    private ag mPullView;

    static {
        FV();
    }

    private static void FV() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012119, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void FW() {
        this.aBR.setPriority(100);
        registerListener(this.aBR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aBP);
        registerListener(this.aBQ);
        FW();
        this.aBK = new ArrayList(0);
        this.aBL = new ArrayList(0);
        this.aBO = new ArrayList(0);
        FY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(boolean z) {
        if (this.aBH != null) {
            this.aBH.s("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> Ca = this.aBJ.Ca();
        if (Ca != null && !Ca.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : Ca) {
                if (cVar != null && "discover_friend".equals(cVar.Gm())) {
                    cVar.bu(z);
                    this.aBJ.y(cVar);
                }
            }
        }
    }

    private void s(View view) {
        this.aBG = (NoNetworkView) view.findViewById(v.view_no_network);
        this.aBF = (BdListView) view.findViewById(v.listview);
        this.mPullView = new ag(getPageContext());
        this.aBF.setPullRefresh(this.mPullView);
        this.mPullView.a(new h(this));
        this.aBF.setOnItemClickListener(new i(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bt(false);
            cVar.bu(false);
            if (this.aBH != null) {
                this.aBH.s(cVar.Gm(), false);
            }
            this.aBJ.y(cVar);
            com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.Gm())) {
                com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.Gm())) {
                aBD = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            a(cVar);
            String Gm = cVar.Gm();
            String title = cVar.getTitle();
            String Gk = cVar.Gk();
            if (!StringUtils.isNull(Gm)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), Gm, null);
            }
            if ("discover_friend".equals(Gm)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage(2002001, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(Gm)) {
                FX();
            } else if ("discover_square".equals(Gm)) {
                sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(Gm)) {
                sendMessage(new CustomMessage(2002001, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(Gm)) {
                sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_look_shop".equals(Gm)) {
                sendMessage(new CustomMessage(2902010, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(Gm)) {
                sendMessage(new CustomMessage(2902040, new EnterChatRoomConfig(getPageContext().getPageActivity())));
            } else if ("discover_game_center".equals(Gm)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
                sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(Gm)) {
                sendMessage(new CustomMessage(2902024, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (Gk != null) {
                if (Gk.startsWith("game:detail:")) {
                    bk.tl().a(getPageContext(), title, new String[]{Gk, "1000501"});
                } else {
                    bk.tl().a(getPageContext(), title, new String[]{Gk});
                }
            }
        }
    }

    public void FX() {
        if (TbadkApplication.getInst().getLocationShared()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902001, new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity())));
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        if (com.baidu.adp.base.m.D(getPageContext().getPageActivity()) != null) {
            aVar.bx(y.warning_location_switch_off);
            aVar.a(y.isopen, new j(this));
            aVar.b(getPageContext().getPageActivity().getResources().getString(y.cancel), new k(this));
            aVar.b(com.baidu.adp.base.m.D(getPageContext().getPageActivity()));
            aVar.re();
        }
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
        return layoutInflater.inflate(w.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        s(getView());
        this.aBJ = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, w.discover_list_item, null);
        this.aBF.setAdapter((ListAdapter) this.aBJ);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.Gm())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("game_is_show_tip", true);
                cVar.bt(false);
                cVar.bu(z);
            } else if ("discover_friend".equals(cVar.Gm())) {
                cVar.bt(false);
                cVar.bu(aBD);
            } else if (!com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bt(false);
                cVar.bu(false);
            }
        }
    }

    private void FY() {
        this.aBE = new p(getPageContext());
        this.aBE.a(new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aBK) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        B(arrayList);
        this.aBO.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aBL) {
            if (dVar != null && dVar.Gq() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.E(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.Gq()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.Gq().add(cVar2);
                        fo(cVar2.Gk());
                    }
                }
            }
        }
        C(A(arrayList2));
    }

    private void fo(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String iP = com.baidu.tieba.tbadkCore.util.k.iP(str);
                if (!StringUtils.isNull(iP)) {
                    this.aBO.add(iP);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", iP, "ref_id", "1000501");
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> A(List<com.baidu.tieba.discover.data.d> list) {
        ArrayList arrayList = new ArrayList(0);
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (com.baidu.tieba.discover.data.d dVar : list) {
            int size = dVar.Gq().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.Gq().get(i);
                if (size == 1) {
                    cVar.ep(3);
                } else if (i == 0) {
                    cVar.ep(1);
                } else if (i == size - 1) {
                    cVar.ep(2);
                } else {
                    cVar.ep(0);
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
        String Gm = cVar.Gm();
        if ("discover_nearby".equals(Gm)) {
            return TbadkApplication.getInst().appResponseToCmd(2902001);
        }
        if ("discover_square".equals(Gm)) {
            return TbadkApplication.getInst().appResponseToCmd(2902023);
        }
        if ("discover_look_shop".equals(Gm)) {
            return TbadkApplication.getInst().appResponseToCmd(2902010);
        }
        if ("discover_hot_video".equals(Gm)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(Gm)) {
            return TbadkApplication.getInst().appResponseToCmd(2902040);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(Gm)) {
            return TbadkApplication.getInst().appResponseToCmd(2902023);
        }
        if (e(cVar)) {
            return PluginCenter.getInstance().getXiubaClassInstance() != null;
        } else if ("discover_friend".equals(Gm)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        } else {
            return true;
        }
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_beauty_show".equals(cVar.Gm())) {
            return true;
        }
        String Gk = cVar.Gk();
        return Gk != null && Gk.startsWith("xiuba:");
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.Gm())) {
            return true;
        }
        String Gk = cVar.Gk();
        if (Gk != null) {
            return Gk.startsWith("gamecenter:") || Gk.startsWith("game:detail:");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aBF.removeHeaderView(this.aBI);
        if (banner != null) {
            if (this.aBI == null) {
                FZ();
            }
            this.aBI.reset();
            this.aBI.a(getPageContext(), banner.pic_url, banner.link);
            this.aBI.setBannerViewClickListener(new c(this, banner.link));
            this.aBF.addHeaderView(this.aBI);
        }
    }

    private void FZ() {
        this.aBI = new BannerView(getPageContext().getPageActivity());
        this.aBI.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds100)));
    }

    private void Ga() {
        this.aBH = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aBH.setOnHeaderItemClickListener(new d(this));
    }

    private void B(List<com.baidu.tieba.discover.data.c> list) {
        this.aBF.removeHeaderView(this.aBH);
        if (list != null && !list.isEmpty()) {
            if (this.aBH == null) {
                Ga();
            }
            this.aBH.setData(list);
            this.aBH.f(getPageContext());
            this.aBF.addHeaderView(this.aBH);
        }
    }

    private void C(List<com.baidu.tieba.discover.data.c> list) {
        this.aBJ.r(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aBO.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aBO.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aBN) {
            this.aBF.mX();
            com.baidu.tbadk.core.k.B(getPageContext().getPageActivity(), "found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getBaseFragmentActivity().getLayoutMode().X(i == 1);
        if (getView() != null) {
            getBaseFragmentActivity().getLayoutMode().h(getView());
        }
        if (this.aBI != null) {
            this.aBI.oq();
        }
        if (this.aBH != null) {
            this.aBH.f(getPageContext());
        }
        if (this.aBG != null) {
            this.aBG.onChangeSkinType(getPageContext(), i);
        }
        this.aBJ.a(getPageContext(), i);
        this.mPullView.ct(i);
    }
}
