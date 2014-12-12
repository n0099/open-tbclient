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
import com.baidu.tbadk.core.atomData.DiscoverSquareActivityConfig;
import com.baidu.tbadk.core.atomData.EnterChatRoomConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.HotLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FoundNew.Banner;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private static boolean asG;
    private p asH;
    private BdListView asI;
    private NoNetworkView asJ;
    private com.baidu.tieba.discover.a.b asK;
    private BannerView asL;
    private com.baidu.tbadk.mvc.j.c<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.a.d> asM;
    private List<com.baidu.tieba.discover.data.c> asN;
    private List<com.baidu.tieba.discover.data.d> asO;
    private boolean asP;
    private boolean asQ;
    private List<String> asR;
    private final CustomMessageListener asS = new b(this, 2001236);
    private CustomMessageListener asT = new e(this, 2012119);
    private final CustomMessageListener asU = new f(this, 2009503);
    private ak mPullView;

    static {
        CD();
    }

    private static void CD() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012119, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void CE() {
        this.asU.setPriority(100);
        registerListener(this.asU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.asS);
        registerListener(this.asT);
        CE();
        this.asN = new ArrayList(0);
        this.asO = new ArrayList(0);
        this.asR = new ArrayList(0);
        CG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(boolean z) {
        if (this.asK != null) {
            this.asK.r("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> yw = this.asM.yw();
        if (yw != null && !yw.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : yw) {
                if (cVar != null && "discover_friend".equals(cVar.CS())) {
                    cVar.bs(z);
                    this.asM.x((com.baidu.tbadk.mvc.j.c<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.a.d>) cVar);
                }
            }
        }
    }

    private void t(View view) {
        this.asJ = (NoNetworkView) view.findViewById(com.baidu.tieba.w.view_no_network);
        this.asI = (BdListView) view.findViewById(com.baidu.tieba.w.listview);
        this.mPullView = new ak(getPageContext().getPageActivity());
        this.asI.setPullRefresh(this.mPullView);
        this.mPullView.a(new h(this));
        this.asI.setOnItemClickListener(new i(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.br(false);
            cVar.bs(false);
            if (this.asK != null) {
                this.asK.r(cVar.CS(), false);
            }
            this.asM.x((com.baidu.tbadk.mvc.j.c<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.a.d>) cVar);
            com.baidu.tbadk.core.sharedPref.b.og().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.CS())) {
                com.baidu.tbadk.core.sharedPref.b.og().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.CS())) {
                asG = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            a(cVar);
            String CS = cVar.CS();
            String title = cVar.getTitle();
            String CQ = cVar.CQ();
            if (!StringUtils.isNull(CS)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), CS, null);
            }
            if ("discover_friend".equals(CS)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(CS)) {
                CF();
            } else if ("discover_square".equals(CS)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902020, new DiscoverSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(CS)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(CS)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_look_shop".equals(CS)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902010, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(CS)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902040, new EnterChatRoomConfig(getPageContext().getPageActivity())));
            } else if ("discover_game_center".equals(CS)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (CQ != null) {
                if (CQ.startsWith("game:detail:")) {
                    bh.pK().a(getPageContext(), title, new String[]{CQ, "1000501"});
                } else {
                    bh.pK().a(getPageContext(), title, new String[]{CQ});
                }
            }
        }
    }

    public void CF() {
        if (TbadkApplication.getInst().getLocationShared()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902001, new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity())));
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        if (com.baidu.adp.base.m.D(getPageContext().getPageActivity()) != null) {
            aVar.bt(z.warning_location_switch_off);
            aVar.a(z.isopen, new j(this));
            aVar.b(getPageContext().getPageActivity().getResources().getString(z.cancel), new k(this));
            aVar.b(com.baidu.adp.base.m.D(getPageContext().getPageActivity()));
            aVar.nU();
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
        return layoutInflater.inflate(com.baidu.tieba.x.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        t(getView());
        this.asM = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), com.baidu.tieba.discover.a.d.class, com.baidu.tieba.x.discover_list_item, null);
        this.asI.setAdapter((ListAdapter) this.asM);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.CS())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.og().getBoolean("game_is_show_tip", true);
                cVar.br(false);
                cVar.bs(z);
            } else if ("discover_friend".equals(cVar.CS())) {
                cVar.br(false);
                cVar.bs(asG);
            } else if (!com.baidu.tbadk.core.sharedPref.b.og().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.br(false);
                cVar.bs(false);
            }
        }
    }

    private void CG() {
        this.asH = new p(getPageContext());
        this.asH.a(new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.asN) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        H(arrayList);
        this.asR.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.asO) {
            if (dVar != null && dVar.CW() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.K(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.CW()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.CW().add(cVar2);
                        fa(cVar2.CQ());
                    }
                }
            }
        }
        I(G(arrayList2));
    }

    private void fa(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String in = com.baidu.tieba.tbadkCore.util.k.in(str);
                if (!StringUtils.isNull(in)) {
                    this.asR.add(in);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", in, "ref_id", "1000501");
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> G(List<com.baidu.tieba.discover.data.d> list) {
        ArrayList arrayList = new ArrayList(0);
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (com.baidu.tieba.discover.data.d dVar : list) {
            int size = dVar.CW().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.CW().get(i);
                if (size == 1) {
                    cVar.eq(3);
                } else if (i == 0) {
                    cVar.eq(1);
                } else if (i == size - 1) {
                    cVar.eq(2);
                } else {
                    cVar.eq(0);
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
        String CS = cVar.CS();
        if ("discover_nearby".equals(CS)) {
            return TbadkApplication.getInst().appResponseToCmd(2902001);
        }
        if ("discover_square".equals(CS)) {
            return TbadkApplication.getInst().appResponseToCmd(2902020);
        }
        if ("discover_look_shop".equals(CS)) {
            return TbadkApplication.getInst().appResponseToCmd(2902010);
        }
        if ("discover_hot_video".equals(CS)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(CS)) {
            return TbadkApplication.getInst().appResponseToCmd(2902040);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        return (e(cVar) && PluginCenter.gX().hf() == null) ? false : true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_beauty_show".equals(cVar.CS())) {
            return true;
        }
        String CQ = cVar.CQ();
        return CQ != null && CQ.startsWith("xiuba:");
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.CS())) {
            return true;
        }
        String CQ = cVar.CQ();
        if (CQ != null) {
            return CQ.startsWith("gamecenter:") || CQ.startsWith("game:detail:");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.asI.removeHeaderView(this.asL);
        if (banner != null) {
            if (this.asL == null) {
                CH();
            }
            this.asL.reset();
            this.asL.a(getPageContext(), banner.pic_url, banner.link);
            this.asL.setBannerViewClickListener(new c(this, banner.link));
            this.asI.addHeaderView(this.asL);
        }
    }

    private void CH() {
        this.asL = new BannerView(getPageContext().getPageActivity());
        this.asL.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(com.baidu.tieba.u.ds100)));
    }

    private void CI() {
        this.asK = new com.baidu.tieba.discover.a.b(getPageContext().getPageActivity());
        this.asK.setOnHeaderItemClickListener(new d(this));
    }

    private void H(List<com.baidu.tieba.discover.data.c> list) {
        this.asI.removeHeaderView(this.asK);
        if (list != null && !list.isEmpty()) {
            if (this.asK == null) {
                CI();
            }
            this.asK.setData(list);
            this.asK.b(getPageContext());
            this.asI.addHeaderView(this.asK);
        }
    }

    private void I(List<com.baidu.tieba.discover.data.c> list) {
        this.asM.w(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (!this.asR.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.asR.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.asQ) {
            this.asI.jK();
            com.baidu.tbadk.core.i.C(getPageContext().getPageActivity(), "found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getBaseFragmentActivity().getLayoutMode().ab(i == 1);
        if (getView() != null) {
            getBaseFragmentActivity().getLayoutMode().h(getView());
        }
        if (this.asL != null) {
            this.asL.kE();
        }
        if (this.asK != null) {
            this.asK.b(getPageContext());
        }
        if (this.asJ != null) {
            this.asJ.onChangeSkinType(getPageContext(), i);
        }
        this.asM.a(getPageContext(), i);
        this.mPullView.cl(i);
    }
}
