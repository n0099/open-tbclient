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
    private static boolean aBv;
    private BannerView aBA;
    private com.baidu.tbadk.mvc.j.d<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.a.d> aBB;
    private List<com.baidu.tieba.discover.data.c> aBC;
    private List<com.baidu.tieba.discover.data.d> aBD;
    private boolean aBE;
    private boolean aBF;
    private List<String> aBG;
    private final CustomMessageListener aBH = new b(this, 2001236);
    private CustomMessageListener aBI = new e(this, 2012119);
    private final CustomMessageListener aBJ = new f(this, 2009503);
    private p aBw;
    private BdListView aBx;
    private NoNetworkView aBy;
    private com.baidu.tieba.discover.a.b aBz;
    private ag mPullView;

    static {
        FP();
    }

    private static void FP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012119, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void FQ() {
        this.aBJ.setPriority(100);
        registerListener(this.aBJ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.aBH);
        registerListener(this.aBI);
        FQ();
        this.aBC = new ArrayList(0);
        this.aBD = new ArrayList(0);
        this.aBG = new ArrayList(0);
        FS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(boolean z) {
        if (this.aBz != null) {
            this.aBz.s("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> BU = this.aBB.BU();
        if (BU != null && !BU.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : BU) {
                if (cVar != null && "discover_friend".equals(cVar.Gg())) {
                    cVar.bu(z);
                    this.aBB.y(cVar);
                }
            }
        }
    }

    private void s(View view) {
        this.aBy = (NoNetworkView) view.findViewById(v.view_no_network);
        this.aBx = (BdListView) view.findViewById(v.listview);
        this.mPullView = new ag(getPageContext());
        this.aBx.setPullRefresh(this.mPullView);
        this.mPullView.a(new h(this));
        this.aBx.setOnItemClickListener(new i(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bt(false);
            cVar.bu(false);
            if (this.aBz != null) {
                this.aBz.s(cVar.Gg(), false);
            }
            this.aBB.y(cVar);
            com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.Gg())) {
                com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.Gg())) {
                aBv = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            a(cVar);
            String Gg = cVar.Gg();
            String title = cVar.getTitle();
            String Ge = cVar.Ge();
            if (!StringUtils.isNull(Gg)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), Gg, null);
            }
            if ("discover_friend".equals(Gg)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                sendMessage(new CustomMessage(2002001, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(Gg)) {
                FR();
            } else if ("discover_square".equals(Gg)) {
                sendMessage(new CustomMessage(2902023, new SingleSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(Gg)) {
                sendMessage(new CustomMessage(2002001, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(Gg)) {
                sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_look_shop".equals(Gg)) {
                sendMessage(new CustomMessage(2902010, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(Gg)) {
                sendMessage(new CustomMessage(2902040, new EnterChatRoomConfig(getPageContext().getPageActivity())));
            } else if ("discover_game_center".equals(Gg)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
                sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_square_trend".equals(Gg)) {
                sendMessage(new CustomMessage(2902024, new SingleForumFeedActivityConfig(getPageContext().getPageActivity())));
            } else if (Ge != null) {
                if (Ge.startsWith("game:detail:")) {
                    bk.tl().a(getPageContext(), title, new String[]{Ge, "1000501"});
                } else {
                    bk.tl().a(getPageContext(), title, new String[]{Ge});
                }
            }
        }
    }

    public void FR() {
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
        this.aBB = new com.baidu.tbadk.mvc.j.d<>(getPageContext(), com.baidu.tieba.discover.a.d.class, w.discover_list_item, null);
        this.aBx.setAdapter((ListAdapter) this.aBB);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.Gg())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("game_is_show_tip", true);
                cVar.bt(false);
                cVar.bu(z);
            } else if ("discover_friend".equals(cVar.Gg())) {
                cVar.bt(false);
                cVar.bu(aBv);
            } else if (!com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bt(false);
                cVar.bu(false);
            }
        }
    }

    private void FS() {
        this.aBw = new p(getPageContext());
        this.aBw.a(new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.aBC) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        B(arrayList);
        this.aBG.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.aBD) {
            if (dVar != null && dVar.Gk() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.E(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.Gk()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.Gk().add(cVar2);
                        fl(cVar2.Ge());
                    }
                }
            }
        }
        C(A(arrayList2));
    }

    private void fl(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String iM = com.baidu.tieba.tbadkCore.util.k.iM(str);
                if (!StringUtils.isNull(iM)) {
                    this.aBG.add(iM);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", iM, "ref_id", "1000501");
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
            int size = dVar.Gk().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.Gk().get(i);
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
        String Gg = cVar.Gg();
        if ("discover_nearby".equals(Gg)) {
            return TbadkApplication.getInst().appResponseToCmd(2902001);
        }
        if ("discover_square".equals(Gg)) {
            return TbadkApplication.getInst().appResponseToCmd(2902023);
        }
        if ("discover_look_shop".equals(Gg)) {
            return TbadkApplication.getInst().appResponseToCmd(2902010);
        }
        if ("discover_hot_video".equals(Gg)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(Gg)) {
            return TbadkApplication.getInst().appResponseToCmd(2902040);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        if ("discover_square_trend".equals(Gg)) {
            return TbadkApplication.getInst().appResponseToCmd(2902023);
        }
        if (e(cVar)) {
            return PluginCenter.getInstance().getXiubaClassInstance() != null;
        } else if ("discover_friend".equals(Gg)) {
            return TbadkApplication.getInst().appResponseToIntentClass(FriendFeedActivityConfig.class);
        } else {
            return true;
        }
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_beauty_show".equals(cVar.Gg())) {
            return true;
        }
        String Ge = cVar.Ge();
        return Ge != null && Ge.startsWith("xiuba:");
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.Gg())) {
            return true;
        }
        String Ge = cVar.Ge();
        if (Ge != null) {
            return Ge.startsWith("gamecenter:") || Ge.startsWith("game:detail:");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.aBx.removeHeaderView(this.aBA);
        if (banner != null) {
            if (this.aBA == null) {
                FT();
            }
            this.aBA.reset();
            this.aBA.a(getPageContext(), banner.pic_url, banner.link);
            this.aBA.setBannerViewClickListener(new c(this, banner.link));
            this.aBx.addHeaderView(this.aBA);
        }
    }

    private void FT() {
        this.aBA = new BannerView(getPageContext().getPageActivity());
        this.aBA.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds100)));
    }

    private void FU() {
        this.aBz = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.aBz.setOnHeaderItemClickListener(new d(this));
    }

    private void B(List<com.baidu.tieba.discover.data.c> list) {
        this.aBx.removeHeaderView(this.aBz);
        if (list != null && !list.isEmpty()) {
            if (this.aBz == null) {
                FU();
            }
            this.aBz.setData(list);
            this.aBz.f(getPageContext());
            this.aBx.addHeaderView(this.aBz);
        }
    }

    private void C(List<com.baidu.tieba.discover.data.c> list) {
        this.aBB.r(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.aBG.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.aBG.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.aBF) {
            this.aBx.mX();
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
        if (this.aBA != null) {
            this.aBA.oq();
        }
        if (this.aBz != null) {
            this.aBz.f(getPageContext());
        }
        if (this.aBy != null) {
            this.aBy.onChangeSkinType(getPageContext(), i);
        }
        this.aBB.a(getPageContext(), i);
        this.mPullView.ct(i);
    }
}
