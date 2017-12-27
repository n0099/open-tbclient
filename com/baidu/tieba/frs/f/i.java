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
import com.baidu.tbadk.core.data.be;
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
    private int cFB = -1;
    private RelativeLayout dNB;
    private TbTabLayout dNC;
    private RelativeLayout dND;
    private View dNE;
    private TabData dNF;
    private l dNG;
    private a dNH;
    private com.baidu.tieba.frs.c dNI;
    private com.baidu.tieba.frs.entelechy.c.a.a dNJ;
    private b dNK;
    private BdBaseViewPager dpC;
    private com.baidu.tieba.frs.i dxW;
    private List<c> mFragments;

    /* loaded from: classes2.dex */
    public interface b {
        void hZ(int i);
    }

    public i(com.baidu.tieba.frs.i iVar, View view) {
        this.dxW = iVar;
        this.dNB = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.dND = (RelativeLayout) view.findViewById(d.g.frs_sort_menu_layout);
        this.dNE = view.findViewById(d.g.fading_edge_view);
        this.dNC = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.dNC.setOnTabSelectedListener(this);
        aj.t(this.dNB, d.C0108d.cp_bg_line_d);
        this.dNJ = new com.baidu.tieba.frs.entelechy.c.a.a(iVar, this.dND);
        this.dpC = (BdBaseViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dNH = new a(this.dxW.getActivity().getSupportFragmentManager(), this.mFragments);
        this.dpC.setAdapter(this.dNH);
        registerListener();
    }

    private void registerListener() {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.f.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.c)) {
                    i.this.awy();
                }
            }
        };
        customMessageListener.setPriority(Integer.MAX_VALUE);
        this.dxW.registerListener(customMessageListener);
    }

    @Override // com.baidu.tieba.frs.f.k
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bAG() != null && lVar.bAG().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bAG().tab) {
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
                            sb.append(lVar.aYy().getId());
                            bVar2.url = sb.toString();
                            aY(bVar2.url, "c10078");
                            tabData.add(bVar2);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && nU(frsTabInfo.tab_id.intValue())) {
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ad.aug().mZ(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.b bVar4 = new com.baidu.tieba.frs.tab.b();
                        bVar4.tabId = frsTabInfo.tab_id.intValue();
                        bVar4.name = frsTabInfo.tab_name;
                        ab mW = aa.auf().mW(bVar4.tabId);
                        if (mW != null && mW.dzs != null && mW.dzs.size() > 0) {
                            bVar4.dMi = new aw();
                            bVar4.dMi.dzr = mW.dzr;
                            bVar4.dMi.dzs = new LinkedList();
                            boolean z2 = true;
                            for (z zVar : mW.dzs) {
                                if (zVar != null) {
                                    av avVar = new av();
                                    avVar.name = zVar.name;
                                    avVar.dzo = zVar.dzo;
                                    if (z2) {
                                        avVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    bVar4.dMi.dzs.add(avVar);
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
                        ab mW2 = aa.auf().mW(bVar5.tabId);
                        if (mW2 != null && mW2.dzs != null && mW2.dzs.size() > 0) {
                            bVar5.dMi = new aw();
                            bVar5.dMi.dzr = mW2.dzr;
                            bVar5.dMi.dzs = new LinkedList();
                            for (z zVar2 : mW2.dzs) {
                                if (zVar2 != null) {
                                    av avVar2 = new av();
                                    avVar2.name = zVar2.name;
                                    avVar2.dzo = zVar2.dzo;
                                    bVar5.dMi.dzs.add(avVar2);
                                }
                            }
                        }
                        tabData.add(bVar5);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.dxW.asV().atM().k(be.aNg)) {
                        com.baidu.tieba.frs.tab.b bVar6 = new com.baidu.tieba.frs.tab.b();
                        bVar6.name = frsTabInfo.tab_name;
                        if (lVar.bAe() != 0 && lVar.bAe() <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + lVar.bAe() + ")";
                        }
                        if (this.cFB > 0 && this.cFB != lVar.bAe() && this.cFB <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + this.cFB + ")";
                        } else if (this.cFB > 99 || lVar.bAe() > 99) {
                            bVar6.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.cFB == 0 && this.cFB != lVar.bAe()) {
                            bVar6.name = frsTabInfo.tab_name;
                        }
                        bVar6.tabId = frsTabInfo.tab_id.intValue();
                        tabData.add(bVar6);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0 && a(tabData)) {
                this.dNG = lVar;
                this.dNF = tabData;
                this.dNJ.setData(lVar.bAG().menu, i);
                if (lVar.aYy() != null) {
                    this.dNJ.setFid(lVar.aYy().getId());
                }
                bx(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.f.k
    public boolean nQ(int i) {
        if (i < 0 || this.dNF == null || this.dNF.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dNF.size()) {
                i2 = -1;
                break;
            } else if (this.dNF.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dNC.getTabCount()) {
            return false;
        }
        TbTabLayout.e dM = this.dNC.dM(i2);
        if (dM != null && !dM.isSelected()) {
            dM.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.b nR(int i) {
        if (i < 0 || this.dNF == null || this.dNF.size() <= 0) {
            return null;
        }
        Iterator it = this.dNF.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
            if (bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dNB != null) {
            aj.t(this.dNB, d.C0108d.cp_bg_line_d);
        }
        if (this.dNE != null) {
            aj.s(this.dNE, d.f.frs_tab_fading_edge);
        }
        if (this.dNC != null) {
            this.dNC.setSelectedTabIndicatorColor(aj.getColor(d.C0108d.cp_cont_f));
            this.dNC.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            this.dNC.setTabTextColors(aj.getColor(d.C0108d.cp_cont_j), aj.getColor(d.C0108d.cp_cont_b));
        }
        if (this.dNJ != null) {
            this.dNJ.onChangeSkinType();
        }
        if (!v.G(this.mFragments)) {
            for (c cVar : this.mFragments) {
                if (cVar != null && (cVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) cVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void nS(int i) {
        this.cFB = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dNF != null && position >= 0 && position < this.dNF.size() && (bVar = this.dNF.get(position)) != null) {
            if (bVar.tabId == 1) {
                this.dNJ.avz();
            } else if (!com.baidu.adp.lib.util.j.oI()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
            if (this.dNK != null) {
                this.dNK.hZ(bVar.tabId);
            }
            TiebaStatic.log(new ak("c12398").ab(ImageViewerConfig.FORUM_ID, this.dxW.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dNF != null && position >= 0 && position < this.dNF.size() && (bVar = this.dNF.get(position)) != null && bVar.tabId == 1) {
            this.dNJ.avA();
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dNF != null && position >= 0 && position < this.dNF.size() && (bVar = this.dNF.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(bVar.tabId)));
            TiebaStatic.log(new ak("c12398").ab(ImageViewerConfig.FORUM_ID, this.dxW.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    private boolean a(TabData tabData) {
        if (v.G(tabData)) {
            return false;
        }
        return (!v.G(this.dNF) && tabData.size() == this.dNF.size() && this.dNF.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !nU(frsTabInfo.tab_id.intValue());
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

    private com.baidu.tbadk.mainTab.b nT(int i) {
        if (i == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.f.i.2
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c My() {
                    com.baidu.tieba.frs.d dVar = new com.baidu.tieba.frs.d();
                    if (i.this.dxW != null && i.this.dxW.asV() != null) {
                        dVar.setView(i.this.dxW.asV().atN());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bvx = dVar;
                    cVar.type = 1;
                    cVar.bvF = com.baidu.tbadk.mainTab.c.bvD;
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
                public com.baidu.tbadk.mainTab.c My() {
                    com.baidu.tieba.frs.good.b bVar = new com.baidu.tieba.frs.good.b();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", i.this.dxW.getForumName());
                    bundle.putString("from", i.this.dxW.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bVar.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bvx = bVar;
                    cVar.type = HttpStatus.SC_MOVED_PERMANENTLY;
                    cVar.bvF = com.baidu.tbadk.mainTab.c.bvD;
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

    private void bx(List<FrsTabInfo> list) {
        if (!v.G(list)) {
            this.dNI = new com.baidu.tieba.frs.c(this.dxW.getActivity().getApplicationContext(), list);
            this.dNI.setForumId(this.dxW.getForumId());
            this.dNI.setForumName(this.dxW.getForumName());
            if (this.dxW.atn() != null && this.dxW.atn().aYy() != null) {
                this.dNI.setForumGameLabel(this.dxW.atn().aYy().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b nT = nT(frsTabInfo.tab_id.intValue());
                if (nT != null) {
                    this.dNI.b(nT);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.dNI));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awy() {
        if (this.dNI != null) {
            List<com.baidu.tbadk.mainTab.b> asG = this.dNI.asG();
            if (!v.G(asG) && !v.G(this.dNF)) {
                if (this.dNC.getTabCount() > 0) {
                    this.dNC.removeAllTabs();
                }
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dNF.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
                    Fragment b2 = b(bVar.tabId, asG);
                    if (b2 != null) {
                        this.dNC.a(this.dNC.sS().n(bVar.name), this.dNG.bAA() == bVar.tabId);
                        c cVar = new c();
                        cVar.tabId = bVar.tabId;
                        cVar.title = bVar.name;
                        cVar.fragment = b2;
                        this.mFragments.add(cVar);
                    } else {
                        it.remove();
                    }
                }
                if (this.dNC.getTabCount() > 0 && this.dNB.getVisibility() != 0) {
                    this.dNB.setVisibility(0);
                }
                this.dNH.notifyDataSetChanged();
                this.dNC.setupWithViewPager(this.dpC);
                this.dpC.setOffscreenPageLimit(this.mFragments.size());
            }
        }
    }

    private Fragment b(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.Mz().type) {
                return bVar.Mz().bvx;
            }
        }
        return null;
    }

    public View ayi() {
        if (this.dNJ == null) {
            return null;
        }
        return this.dNJ.avy();
    }

    public void resetData() {
        this.dNF = null;
        this.dNG = null;
        if (this.dNJ != null) {
            this.dNJ.resetData();
        }
    }

    public static boolean nU(int i) {
        return i > 200 && i <= 300;
    }

    public void a(b bVar) {
        this.dNK = bVar;
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

    public c ayj() {
        if (this.dpC == null) {
            return null;
        }
        return (c) v.f(this.mFragments, this.dpC.getCurrentItem());
    }
}
