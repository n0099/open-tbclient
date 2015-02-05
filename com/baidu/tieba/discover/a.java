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
    private static boolean atJ;
    private p atK;
    private BdListView atL;
    private NoNetworkView atM;
    private View atN;
    private DiscoverHeaderView atO;
    private BannerView atP;
    private com.baidu.tbadk.mvc.j.c<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.view.c> atQ;
    private List<com.baidu.tieba.discover.data.c> atR;
    private List<com.baidu.tieba.discover.data.d> atS;
    private boolean atT;
    private boolean atU;
    private List<String> atV;
    private final CustomMessageListener atW = new b(this, 2001236);
    private CustomMessageListener atX = new e(this, 2012119);
    private final CustomMessageListener atY = new f(this, 2009503);
    private ak mPullView;

    static {
        CW();
    }

    private static void CW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012119, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void CX() {
        this.atY.setPriority(100);
        registerListener(this.atY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.atW);
        registerListener(this.atX);
        CX();
        this.atR = new ArrayList(0);
        this.atS = new ArrayList(0);
        this.atV = new ArrayList(0);
        CZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (this.atO != null) {
            this.atO.r("discover_friend", z);
        }
        List<com.baidu.tieba.discover.data.c> yG = this.atQ.yG();
        if (yG != null && !yG.isEmpty()) {
            for (com.baidu.tieba.discover.data.c cVar : yG) {
                if (cVar != null && "discover_friend".equals(cVar.Dl())) {
                    cVar.bv(z);
                    this.atQ.x((com.baidu.tbadk.mvc.j.c<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.view.c>) cVar);
                }
            }
        }
    }

    private void t(View view) {
        this.atL = (BdListView) view.findViewById(w.listview);
        this.mPullView = new ak(getPageContext());
        this.atL.setPullRefresh(this.mPullView);
        this.mPullView.a(new h(this));
        this.atL.setOnItemClickListener(new i(this));
    }

    private void a(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            cVar.bu(false);
            cVar.bv(false);
            if (this.atO != null) {
                this.atO.r(cVar.Dl(), false);
            }
            this.atQ.x((com.baidu.tbadk.mvc.j.c<com.baidu.tieba.discover.data.c, com.baidu.tbadk.mvc.e.c, com.baidu.tieba.discover.view.c>) cVar);
            com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("discover_tip_show_" + cVar.getTitle(), false);
            if ("discover_game_center".equals(cVar.Dl())) {
                com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("game_is_show_tip", false);
            } else if ("discover_friend".equals(cVar.Dl())) {
                atJ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            a(cVar);
            String Dl = cVar.Dl();
            String title = cVar.getTitle();
            String Dj = cVar.Dj();
            if (!StringUtils.isNull(Dl)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), Dl, null);
            }
            if ("discover_friend".equals(Dl)) {
                TbadkApplication.getInst().setFriendFeedNew(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FriendFeedActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_nearby".equals(Dl)) {
                CY();
            } else if ("discover_square".equals(Dl)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902020, new DiscoverSquareActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_hot_video".equals(Dl)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotLiveListActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_one_sign".equals(Dl)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2010030, new SignAllForumActivityConfig(getPageContext().getPageActivity())));
            } else if ("discover_look_shop".equals(Dl)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902010, new FaceShopActivityConfig(getPageContext().getPageActivity(), "faceshop_from_more")));
            } else if ("discover_rand_friend".equals(Dl)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902040, new EnterChatRoomConfig(getPageContext().getPageActivity())));
            } else if ("discover_game_center".equals(Dl)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001236, false));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (Dj != null) {
                if (Dj.startsWith("game:detail:")) {
                    bm.pO().a(getPageContext(), title, new String[]{Dj, "1000501"});
                } else {
                    bm.pO().a(getPageContext(), title, new String[]{Dj});
                }
            }
        }
    }

    public void CY() {
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
            aVar.nQ();
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
        this.atQ = new com.baidu.tbadk.mvc.j.c<>(getPageContext(), com.baidu.tieba.discover.view.c.class, x.discover_list_item, null);
        this.atL.setAdapter((ListAdapter) this.atQ);
    }

    private void c(com.baidu.tieba.discover.data.c cVar) {
        if (cVar != null) {
            if ("discover_game_center".equals(cVar.Dl())) {
                boolean z = com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("game_is_show_tip", true);
                cVar.bu(false);
                cVar.bv(z);
            } else if ("discover_friend".equals(cVar.Dl())) {
                cVar.bu(false);
                cVar.bv(atJ);
            } else if (!com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("discover_tip_show_" + cVar.getTitle(), true)) {
                cVar.bu(false);
                cVar.bv(false);
            }
        }
    }

    private void CZ() {
        this.atK = new p(getPageContext());
        this.atK.a(new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (com.baidu.tieba.discover.data.c cVar : this.atR) {
            if (cVar != null && !StringUtils.isNull(cVar.getTitle()) && d(cVar) && arrayList.size() < 3) {
                if (z) {
                    c(cVar);
                }
                arrayList.add(cVar);
            }
        }
        J(arrayList);
        this.atV.clear();
        ArrayList arrayList2 = new ArrayList(0);
        for (com.baidu.tieba.discover.data.d dVar : this.atS) {
            if (dVar != null && dVar.Dp() != null) {
                com.baidu.tieba.discover.data.d dVar2 = new com.baidu.tieba.discover.data.d();
                dVar2.M(new ArrayList(0));
                arrayList2.add(dVar2);
                for (com.baidu.tieba.discover.data.c cVar2 : dVar.Dp()) {
                    if (cVar2 != null && !StringUtils.isNull(cVar2.getTitle()) && d(cVar2)) {
                        if (z) {
                            c(cVar2);
                        }
                        dVar2.Dp().add(cVar2);
                        fc(cVar2.Dj());
                    }
                }
            }
        }
        K(I(arrayList2));
    }

    private void fc(String str) {
        if (str != null) {
            if (str.startsWith("gamecenter:")) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            } else if (str.startsWith("game:detail:")) {
                String is = com.baidu.tieba.tbadkCore.util.k.is(str);
                if (!StringUtils.isNull(is)) {
                    this.atV.add(is);
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", is, "ref_id", "1000501");
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
            int size = dVar.Dp().size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.discover.data.c cVar = dVar.Dp().get(i);
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
        String Dl = cVar.Dl();
        if ("discover_nearby".equals(Dl)) {
            return TbadkApplication.getInst().appResponseToCmd(2902001);
        }
        if ("discover_square".equals(Dl)) {
            return TbadkApplication.getInst().appResponseToCmd(2902020);
        }
        if ("discover_look_shop".equals(Dl)) {
            return TbadkApplication.getInst().appResponseToCmd(2902010);
        }
        if ("discover_hot_video".equals(Dl)) {
            return TbadkApplication.getInst().appResponseToIntentClass(HotLiveListActivityConfig.class);
        }
        if ("discover_rand_friend".equals(Dl)) {
            return TbadkApplication.getInst().appResponseToCmd(2902040);
        }
        if (f(cVar)) {
            return TbadkApplication.getInst().appResponseToIntentClass(GameCenterActivityConfig.class);
        }
        return (e(cVar) && PluginCenter.getInstance().getXiubaClassInstance() == null) ? false : true;
    }

    private boolean e(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_beauty_show".equals(cVar.Dl())) {
            return true;
        }
        String Dj = cVar.Dj();
        return Dj != null && Dj.startsWith("xiuba:");
    }

    private boolean f(com.baidu.tieba.discover.data.c cVar) {
        if (cVar == null) {
            return false;
        }
        if ("discover_game_center".equals(cVar.Dl())) {
            return true;
        }
        String Dj = cVar.Dj();
        if (Dj != null) {
            return Dj.startsWith("gamecenter:") || Dj.startsWith("game:detail:");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Banner banner) {
        this.atL.removeHeaderView(this.atP);
        if (banner != null) {
            if (this.atP == null) {
                Da();
            }
            this.atP.reset();
            this.atP.a(getPageContext(), banner.pic_url, banner.link);
            this.atP.setBannerViewClickListener(new c(this, banner.link));
            this.atL.addHeaderView(this.atP);
        }
    }

    private void Da() {
        this.atP = new BannerView(getPageContext().getPageActivity());
        this.atP.setLayoutParams(new AbsListView.LayoutParams(-1, TbadkApplication.getInst().getResources().getDimensionPixelSize(u.ds100)));
    }

    private void Db() {
        this.atN = com.baidu.adp.lib.g.b.ei().inflate(getActivity(), x.discover_header, null);
        this.atM = (NoNetworkView) this.atN.findViewById(w.view_no_network);
        this.atO = (DiscoverHeaderView) this.atN.findViewById(w.discover_header_catagory);
        this.atO.setOnHeaderItemClickListener(new d(this));
    }

    private void J(List<com.baidu.tieba.discover.data.c> list) {
        this.atL.removeHeaderView(this.atN);
        if (list != null && !list.isEmpty()) {
            if (this.atN == null) {
                Db();
            }
            this.atO.setData(list);
            this.atM.onChangeSkinType(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
            this.atO.c(getPageContext());
            this.atL.addHeaderView(this.atN);
        }
    }

    private void K(List<com.baidu.tieba.discover.data.c> list) {
        this.atQ.w(list);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && !this.atV.isEmpty()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "discover_game_center_show", null);
            Iterator<String> it = this.atV.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "game_show", "show", 1, "dev_id", it.next(), "ref_id", "1000501");
            }
        }
        if (!this.atU) {
            this.atL.jC();
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
        if (this.atP != null) {
            this.atP.kx();
        }
        if (this.atO != null) {
            this.atO.c(getPageContext());
        }
        if (this.atM != null) {
            this.atM.onChangeSkinType(getPageContext(), i);
        }
        this.atQ.a(getPageContext(), i);
        this.mPullView.cs(i);
    }
}
