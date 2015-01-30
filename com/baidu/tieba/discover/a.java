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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DiscoverSquareActivityConfig;
import com.baidu.tbadk.core.atomData.EnterChatRoomConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.FriendFeedActivityConfig;
import com.baidu.tbadk.core.atomData.GameCenterActivityConfig;
import com.baidu.tbadk.core.atomData.HotLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.discover.view.DiscoverHeaderView;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FoundNew.Banner;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private static boolean atM;
    private p atN;
    private BdListView atO;
    private NoNetworkView atP;
    private View atQ;
    private DiscoverHeaderView atR;
    private BannerView atS;
    private com.baidu.tbadk.mvc.j.c<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.view.c> atT;
    private List<com.baidu.tieba.discover.data.c> atU;
    private List<com.baidu.tieba.discover.data.d> atV;
    private boolean atW;
    private boolean atX;
    private List<String> atY;
    private final CustomMessageListener atZ = new b(this, 2001236);
    private CustomMessageListener aua = new e(this, 2012119);
    private final CustomMessageListener aub = new f(this, 2009503);
    private ak mPullView;

    static {
        Dc();
    }

    private static void Dc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012119, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void Dd() {
        this.aub.setPriority(100);
        registerListener(this.aub);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.atZ);
        registerListener(this.aua);
        Dd();
        this.atU = new ArrayList(0);
        this.atV = new ArrayList(0);
        this.atY = new ArrayList(0);
        Df();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (this.atR != null) {
            this.atR.r("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> yM = this.atT.yM();
        if (yM != null && !yM.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : yM) {
                if (cVar != null && "discover_friend".equals(cVar.Dr())) {
                    cVar.bv(z);
                    this.atT.x((com.baidu.tbadk.mvc.j.c<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.view.c>) cVar);
                }
            }
        }
    }

    private void t(View view) {
        this.atO = (BdListView) view.findViewById(w.listview);
        this.mPullView = new ak(getPageContext());
        this.atO.setPullRefresh(this.mPullView);
        this.mPullView.a(new h(this));
        this.atO.setOnItemClickListener(new i(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bu(false);
            cVar.bv(false);
            if (this.atR != null) {
                this.atR.r(cVar.Dr(), false);
            }
            this.atT.x((com.baidu.tbadk.mvc.j.c<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.view.c>) cVar);
            com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.Dr())) {
                com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.Dr())) {
                atM = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            a(cVar);
            String Dr = cVar.Dr();
            String title = cVar.getTitle();
            String Dp = cVar.Dp();
            if (!StringUtils.isNull(Dr)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), Dr, null);
            }
            if ("discover_friend".equals(Dr)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(Dr)) {
                De();
            } else if ("discover_square".equals(Dr)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902020, new DiscoverSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(Dr)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(Dr)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_look_shop".equals(Dr)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902010, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(Dr)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902040, new EnterChatRoomConfig(getPageContext().getPageActivity())));
            } else if ("discover_game_center".equals(Dr)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (Dp != null) {
                if (Dp.startsWith("game:detail:")) {
                    bm.pV().a(getPageContext(), title, new String[]{Dp, "1000501"});
                } else {
                    bm.pV().a(getPageContext(), title, new String[]{Dp});
                }
            }
        }
    }

    public void De() {
        if (TbadkApplication.getInst().getLocationShared()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902001, new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity())));
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        if (com.baidu.adp.base.m.D(getPageContext().getPageActivity()) != null) {
            aVar.by(com.baidu.tieba.z.warning_location_switch_off);
            aVar.a(com.baidu.tieba.z.isopen, new j(this));
            aVar.b(getPageContext().getPageActivity().getResources().getString(com.baidu.tieba.z.cancel), new k(this));
            aVar.b(com.baidu.adp.base.m.D(getPageContext().getPageActivity()));
            aVar.nX();
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
        return layoutInflater.inflate(x.discover_activity, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        t(getView());
        this.atT = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), com.baidu.tieba.discover.view.c.class, x.discover_list_item, null);
        this.atO.setAdapter((ListAdapter) this.atT);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.Dr())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("game_is_show_tip", true);
                cVar.bu(false);
                cVar.bv(z);
            } else if ("discover_friend".equals(cVar.Dr())) {
                cVar.bu(false);
                cVar.bv(atM);
            } else if (!com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bu(false);
                cVar.bv(false);
            }
        }
    }

    private void Df() {
        this.atN = new p(getPageContext());
        this.atN.a(new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.atU) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        J(arrayList);
        this.atY.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.atV) {
            if (dVar != null && dVar.Dv() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.M(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.Dv()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.Dv().add(cVar2);
                        ff(cVar2.Dp());
                    }
                }
            }
        }
        K(I(arrayList2));
    }

    private void ff(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String iu = com.baidu.tieba.tbadkCore.util.k.iu(str);
                if (!StringUtils.isNull(iu)) {
                    this.atY.add(iu);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", iu, "ref_id", "1000501");
                }
            }
        }
    }

    private List<com.baidu.tieba.discover.data.c> I(List<com.baidu.tieba.discover.data.d> list) {
        ArrayList arrayList = new ArrayList(0);
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (com.baidu.tieba.discover.data.d dVar : list) {
            int size = dVar.Dv().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.Dv().get(i);
                if (size == 1) {
                    cVar.ew(3);
                } else if (i == 0) {
                    cVar.ew(1);
                } else if (i == size - 1) {
                    cVar.ew(2);
                } else {
                    cVar.ew(0);
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
        String Dr = cVar.Dr();
        if ("discover_nearby".equals(Dr)) {
            return TbadkApplication.getInst().appResponseToCmd(2902001);
        }
        if ("discover_square".equals(Dr)) {
            return TbadkApplication.getInst().appResponseToCmd(2902020);
        }
        if ("discover_look_shop".equals(Dr)) {
            return TbadkApplication.getInst().appResponseToCmd(2902010);
        }
        if ("discover_hot_video".equals(Dr)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(Dr)) {
            return TbadkApplication.getInst().appResponseToCmd(2902040);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        return (e(cVar) && PluginCenter.gW().hd() == null) ? false : true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_beauty_show".equals(cVar.Dr())) {
            return true;
        }
        String Dp = cVar.Dp();
        return Dp != null && Dp.startsWith("xiuba:");
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.Dr())) {
            return true;
        }
        String Dp = cVar.Dp();
        if (Dp != null) {
            return Dp.startsWith("gamecenter:") || Dp.startsWith("game:detail:");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.atO.removeHeaderView(this.atS);
        if (banner != null) {
            if (this.atS == null) {
                Dg();
            }
            this.atS.reset();
            this.atS.a(getPageContext(), banner.pic_url, banner.link);
            this.atS.setBannerViewClickListener(new c(this, banner.link));
            this.atO.addHeaderView(this.atS);
        }
    }

    private void Dg() {
        this.atS = new BannerView(getPageContext().getPageActivity());
        this.atS.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(u.ds100)));
    }

    private void Dh() {
        this.atQ = com.baidu.adp.lib.g.b.ei().inflate(getActivity(), x.discover_header, null);
        this.atP = (NoNetworkView) this.atQ.findViewById(w.view_no_network);
        this.atR = (DiscoverHeaderView) this.atQ.findViewById(w.discover_header_catagory);
        this.atR.setOnHeaderItemClickListener(new d(this));
    }

    private void J(List<com.baidu.tieba.discover.data.c> list) {
        this.atO.removeHeaderView(this.atQ);
        if (list != null && !list.isEmpty()) {
            if (this.atQ == null) {
                Dh();
            }
            this.atR.setData(list);
            this.atP.onChangeSkinType(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
            this.atR.c(getPageContext());
            this.atO.addHeaderView(this.atQ);
        }
    }

    private void K(List<com.baidu.tieba.discover.data.c> list) {
        this.atT.w(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.atY.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.atY.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.atX) {
            this.atO.jJ();
            com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "found_ck");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getBaseFragmentActivity().getLayoutMode().ab(i == 1);
        if (getView() != null) {
            getBaseFragmentActivity().getLayoutMode().h(getView());
        }
        if (this.atS != null) {
            this.atS.kE();
        }
        if (this.atR != null) {
            this.atR.c(getPageContext());
        }
        if (this.atP != null) {
            this.atP.onChangeSkinType(getPageContext(), i);
        }
        this.atT.a(getPageContext(), i);
        this.mPullView.cs(i);
    }
}
