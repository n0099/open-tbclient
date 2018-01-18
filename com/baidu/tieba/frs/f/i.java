package com.baidu.tieba.frs.f;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.l;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpStatus;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class i implements TbTabLayout.b, k {
    private static final String TAG = i.class.getSimpleName();
    private int cFL = -1;
    private com.baidu.tieba.frs.i dCx;
    private RelativeLayout dSd;
    private TbTabLayout dSe;
    private RelativeLayout dSf;
    private View dSg;
    private TabData dSh;
    private l dSi;
    private a dSj;
    private com.baidu.tieba.frs.c dSk;
    private com.baidu.tieba.frs.entelechy.c.a.a dSl;
    private b dSm;
    private BdBaseViewPager duc;
    private List<c> mFragments;

    /* loaded from: classes2.dex */
    public interface b {
        void hV(int i);
    }

    public i(com.baidu.tieba.frs.i iVar, View view) {
        this.dCx = iVar;
        this.dSd = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.dSf = (RelativeLayout) view.findViewById(d.g.frs_sort_menu_layout);
        this.dSg = view.findViewById(d.g.fading_edge_view);
        this.dSe = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.dSe.setOnTabSelectedListener(this);
        aj.t(this.dSd, d.C0107d.cp_bg_line_d);
        this.dSl = new com.baidu.tieba.frs.entelechy.c.a.a(iVar, this.dSf);
        this.duc = (BdBaseViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dSj = new a(this.dCx.getActivity().getSupportFragmentManager(), this.mFragments);
        this.duc.setAdapter(this.dSj);
        registerListener();
    }

    private void registerListener() {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.f.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.c)) {
                    i.this.axB();
                }
            }
        };
        customMessageListener.setPriority(Integer.MAX_VALUE);
        this.dCx.registerListener(customMessageListener);
    }

    @Override // com.baidu.tieba.frs.f.k
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.buc() != null && lVar.buc().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.buc().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        com.baidu.tieba.frs.tab.b bVar = new com.baidu.tieba.frs.tab.b();
                        bVar.tabId = frsTabInfo.tab_id.intValue();
                        bVar.name = frsTabInfo.tab_name;
                        tabData.add(bVar);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            com.baidu.tieba.frs.tab.b bVar2 = new com.baidu.tieba.frs.tab.b();
                            bVar2.tabId = frsTabInfo.tab_id.intValue();
                            bVar2.name = frsTabInfo.tab_name;
                            StringBuilder sb = new StringBuilder();
                            String lowerCase = frsTabInfo.tab_url.toLowerCase();
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                sb.append("http://");
                            }
                            sb.append(frsTabInfo.tab_url);
                            sb.append("&");
                            sb.append(ImageViewerConfig.FORUM_ID);
                            sb.append("=");
                            sb.append(lVar.aYE().getId());
                            bVar2.url = sb.toString();
                            aY(bVar2.url, "c10078");
                            tabData.add(bVar2);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && nX(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.b bVar3 = new com.baidu.tieba.frs.tab.b();
                        bVar3.tabId = frsTabInfo.tab_id.intValue();
                        bVar3.name = frsTabInfo.tab_name;
                        bVar3.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.ct(bVar3.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(bVar3);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(bVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ad.avj().nc(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.b bVar4 = new com.baidu.tieba.frs.tab.b();
                        bVar4.tabId = frsTabInfo.tab_id.intValue();
                        bVar4.name = frsTabInfo.tab_name;
                        ab mZ = aa.avi().mZ(bVar4.tabId);
                        if (mZ != null && mZ.dDT != null && mZ.dDT.size() > 0) {
                            bVar4.dQK = new aw();
                            bVar4.dQK.dDS = mZ.dDS;
                            bVar4.dQK.dDT = new LinkedList();
                            boolean z2 = true;
                            for (z zVar : mZ.dDT) {
                                if (zVar != null) {
                                    av avVar = new av();
                                    avVar.name = zVar.name;
                                    avVar.dDP = zVar.dDP;
                                    if (z2) {
                                        avVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    bVar4.dQK.dDT.add(avVar);
                                    z2 = z;
                                }
                            }
                        }
                        tabData.add(bVar4);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.b bVar5 = new com.baidu.tieba.frs.tab.b();
                        bVar5.tabId = frsTabInfo.tab_id.intValue();
                        bVar5.name = frsTabInfo.tab_name;
                        ab mZ2 = aa.avi().mZ(bVar5.tabId);
                        if (mZ2 != null && mZ2.dDT != null && mZ2.dDT.size() > 0) {
                            bVar5.dQK = new aw();
                            bVar5.dQK.dDS = mZ2.dDS;
                            bVar5.dQK.dDT = new LinkedList();
                            for (z zVar2 : mZ2.dDT) {
                                if (zVar2 != null) {
                                    av avVar2 = new av();
                                    avVar2.name = zVar2.name;
                                    avVar2.dDP = zVar2.dDP;
                                    bVar5.dQK.dDT.add(avVar2);
                                }
                            }
                        }
                        tabData.add(bVar5);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.dCx.atY().auP().k(bd.aNc)) {
                        com.baidu.tieba.frs.tab.b bVar6 = new com.baidu.tieba.frs.tab.b();
                        bVar6.name = frsTabInfo.tab_name;
                        if (lVar.btA() != 0 && lVar.btA() <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + lVar.btA() + ")";
                        }
                        if (this.cFL > 0 && this.cFL != lVar.btA() && this.cFL <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + this.cFL + ")";
                        } else if (this.cFL > 99 || lVar.btA() > 99) {
                            bVar6.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.cFL == 0 && this.cFL != lVar.btA()) {
                            bVar6.name = frsTabInfo.tab_name;
                        }
                        bVar6.tabId = frsTabInfo.tab_id.intValue();
                        tabData.add(bVar6);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0 && a(tabData)) {
                this.dSi = lVar;
                this.dSh = tabData;
                this.dSl.setData(lVar.buc().menu, i);
                if (lVar.aYE() != null) {
                    this.dSl.setFid(lVar.aYE().getId());
                }
                bv(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.f.k
    public boolean nT(int i) {
        if (i < 0 || this.dSh == null || this.dSh.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dSh.size()) {
                i2 = -1;
                break;
            } else if (this.dSh.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dSe.getTabCount()) {
            return false;
        }
        TbTabLayout.e dM = this.dSe.dM(i2);
        if (dM != null && !dM.isSelected()) {
            dM.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.b nU(int i) {
        if (i < 0 || this.dSh == null || this.dSh.size() <= 0) {
            return null;
        }
        Iterator it = this.dSh.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
            if (bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dSd != null) {
            aj.t(this.dSd, d.C0107d.cp_bg_line_d);
        }
        if (this.dSg != null) {
            aj.s(this.dSg, d.f.frs_tab_fading_edge);
        }
        if (this.dSe != null) {
            this.dSe.setSelectedTabIndicatorColor(aj.getColor(d.C0107d.cp_cont_f));
            this.dSe.setBackgroundColor(aj.getColor(d.C0107d.cp_bg_line_d));
            this.dSe.setTabTextColors(aj.getColor(d.C0107d.cp_cont_j), aj.getColor(d.C0107d.cp_cont_b));
        }
        if (this.dSl != null) {
            this.dSl.onChangeSkinType();
        }
        if (!v.E(this.mFragments)) {
            for (c cVar : this.mFragments) {
                if (cVar != null && (cVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) cVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void nV(int i) {
        this.cFL = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dSh != null && position >= 0 && position < this.dSh.size() && (bVar = this.dSh.get(position)) != null) {
            if (bVar.tabId == 1) {
                this.dSl.awC();
            } else if (!com.baidu.adp.lib.util.j.oI()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
            if (this.dSm != null) {
                this.dSm.hV(bVar.tabId);
            }
            TiebaStatic.log(new ak("c12398").ab(ImageViewerConfig.FORUM_ID, this.dCx.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dSh != null && position >= 0 && position < this.dSh.size() && (bVar = this.dSh.get(position)) != null && bVar.tabId == 1) {
            this.dSl.awD();
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dSh != null && position >= 0 && position < this.dSh.size() && (bVar = this.dSh.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(bVar.tabId)));
            TiebaStatic.log(new ak("c12398").ab(ImageViewerConfig.FORUM_ID, this.dCx.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    private boolean a(TabData tabData) {
        if (v.E(tabData)) {
            return false;
        }
        return (!v.E(this.dSh) && tabData.size() == this.dSh.size() && this.dSh.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !nX(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void aY(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    ak akVar = new ak(str2);
                    akVar.ab("obj_type", host);
                    TiebaStatic.log(akVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b nW(int i) {
        if (i == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.f.i.2
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Mm() {
                    com.baidu.tieba.frs.d dVar = new com.baidu.tieba.frs.d();
                    if (i.this.dCx != null && i.this.dCx.atY() != null) {
                        dVar.setView(i.this.dCx.atY().auQ());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bvG = dVar;
                    cVar.type = 1;
                    cVar.bvO = com.baidu.tbadk.mainTab.c.bvM;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.e bm(Context context) {
                    return null;
                }
            };
        }
        if (i == 301) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.f.i.3
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Mm() {
                    com.baidu.tieba.frs.good.b bVar = new com.baidu.tieba.frs.good.b();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", i.this.dCx.getForumName());
                    bundle.putString("from", i.this.dCx.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bVar.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bvG = bVar;
                    cVar.type = HttpStatus.SC_MOVED_PERMANENTLY;
                    cVar.bvO = com.baidu.tbadk.mainTab.c.bvM;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.e bm(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void bv(List<FrsTabInfo> list) {
        if (!v.E(list)) {
            this.dSk = new com.baidu.tieba.frs.c(this.dCx.getActivity().getApplicationContext(), list);
            this.dSk.setForumId(this.dCx.getForumId());
            this.dSk.setForumName(this.dCx.getForumName());
            if (this.dCx.auq() != null && this.dCx.auq().aYE() != null) {
                this.dSk.setForumGameLabel(this.dCx.auq().aYE().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b nW = nW(frsTabInfo.tab_id.intValue());
                if (nW != null) {
                    this.dSk.b(nW);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.dSk));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axB() {
        if (this.dSk != null) {
            List<com.baidu.tbadk.mainTab.b> atJ = this.dSk.atJ();
            if (!v.E(atJ) && !v.E(this.dSh)) {
                if (this.dSe.getTabCount() > 0) {
                    this.dSe.removeAllTabs();
                }
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dSh.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
                    Fragment b2 = b(bVar.tabId, atJ);
                    if (b2 != null) {
                        this.dSe.a(this.dSe.sS().n(bVar.name), this.dSi.btW() == bVar.tabId);
                        c cVar = new c();
                        cVar.tabId = bVar.tabId;
                        cVar.title = bVar.name;
                        cVar.fragment = b2;
                        this.mFragments.add(cVar);
                    } else {
                        it.remove();
                    }
                }
                if (this.dSe.getTabCount() > 0 && this.dSd.getVisibility() != 0) {
                    this.dSd.setVisibility(0);
                }
                this.dSj.notifyDataSetChanged();
                this.dSe.setupWithViewPager(this.duc);
                this.duc.setOffscreenPageLimit(this.mFragments.size());
            }
        }
    }

    private Fragment b(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.Mn().type) {
                return bVar.Mn().bvG;
            }
        }
        return null;
    }

    public View azl() {
        if (this.dSl == null) {
            return null;
        }
        return this.dSl.awB();
    }

    public void resetData() {
        this.dSh = null;
        this.dSi = null;
        if (this.dSl != null) {
            this.dSl.resetData();
        }
    }

    public static boolean nX(int i) {
        return i > 200 && i <= 300;
    }

    public void a(b bVar) {
        this.dSm = bVar;
    }

    /* loaded from: classes2.dex */
    public class a extends FragmentStatePagerAdapter {
        private List<c> mFragments;

        public a(FragmentManager fragmentManager, List<c> list) {
            super(fragmentManager);
            this.mFragments = list;
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return this.mFragments.get(i).fragment;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.mFragments.get(i).title;
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public Fragment fragment;
        public int tabId;
        public String title;

        public c() {
        }
    }

    public c azm() {
        if (this.duc == null) {
            return null;
        }
        return (c) v.f(this.mFragments, this.duc.getCurrentItem());
    }
}
