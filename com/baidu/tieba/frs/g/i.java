package com.baidu.tieba.frs.g;

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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.al;
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
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class i implements TbTabLayout.b, k {
    private static final String TAG = i.class.getSimpleName();
    private com.baidu.tieba.frs.i dFD;
    private RelativeLayout dVD;
    private TbTabLayout dVE;
    private RelativeLayout dVF;
    private View dVG;
    private TabData dVH;
    private l dVI;
    private a dVJ;
    private com.baidu.tieba.frs.c dVK;
    private com.baidu.tieba.frs.entelechy.c.a.a dVL;
    private b dVM;
    private com.baidu.tieba.d.c dVN;
    private BdBaseViewPager dxd;
    private List<c> mFragments;
    private int cJJ = -1;
    private CustomMessageListener cda = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.g.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c aAv;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aAv = i.this.aAv()) != null && aAv.fragment != null && (aAv.fragment instanceof al)) {
                        ((al) aAv.fragment).XK();
                    }
                }
            }
        }
    };
    private View.OnClickListener dVO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.i.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.dVN.ang();
        }
    };

    /* loaded from: classes2.dex */
    public interface b {
        void hT(int i);
    }

    public i(com.baidu.tieba.frs.i iVar, View view) {
        this.dFD = iVar;
        this.dVD = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.dVF = (RelativeLayout) view.findViewById(d.g.frs_sort_menu_layout);
        this.dVG = view.findViewById(d.g.fading_edge_view);
        this.dVE = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.dVE.setOnTabSelectedListener(this);
        this.dVN = new com.baidu.tieba.d.c(iVar.getPageContext(), this.dVE);
        this.dVN.lS(d.f.bg_tip_blue_up_left);
        this.dVN.lR(16);
        this.dVN.ai(true);
        this.dVN.lV(com.baidu.adp.lib.util.l.t(iVar.getPageContext().getPageActivity(), d.e.tbds34));
        this.dVN.lW(com.baidu.adp.lib.util.l.t(iVar.getPageContext().getPageActivity(), d.e.tbds10));
        this.dVN.j(this.dVO);
        this.dVL = new com.baidu.tieba.frs.entelechy.c.a.a(iVar, this.dVF);
        this.dxd = (BdBaseViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dVJ = new a(this.dFD.getActivity().getSupportFragmentManager(), this.mFragments);
        this.dxd.setAdapter(this.dVJ);
        registerListener();
    }

    private void registerListener() {
        CustomMessageListener customMessageListener = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.g.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.c)) {
                    i.this.ayD();
                }
            }
        };
        customMessageListener.setPriority(Integer.MAX_VALUE);
        this.dFD.registerListener(customMessageListener);
        this.dFD.registerListener(2001446, this.cda, this.dFD.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.g.k
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bvs() != null && lVar.bvs().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bvs().tab) {
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
                            sb.append(lVar.bar().getId());
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
                        if (com.baidu.tbadk.browser.e.cC(bVar3.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(bVar3);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(bVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ad.awl().na(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.b bVar4 = new com.baidu.tieba.frs.tab.b();
                        bVar4.tabId = frsTabInfo.tab_id.intValue();
                        bVar4.name = frsTabInfo.tab_name;
                        ab mX = aa.awk().mX(bVar4.tabId);
                        if (mX != null && mX.dHf != null && mX.dHf.size() > 0) {
                            bVar4.dUf = new aw();
                            bVar4.dUf.dHe = mX.dHe;
                            bVar4.dUf.dHf = new LinkedList();
                            boolean z2 = true;
                            for (z zVar : mX.dHf) {
                                if (zVar != null) {
                                    av avVar = new av();
                                    avVar.name = zVar.name;
                                    avVar.dHb = zVar.dHb;
                                    if (z2) {
                                        avVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    bVar4.dUf.dHf.add(avVar);
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
                        ab mX2 = aa.awk().mX(bVar5.tabId);
                        if (mX2 != null && mX2.dHf != null && mX2.dHf.size() > 0) {
                            bVar5.dUf = new aw();
                            bVar5.dUf.dHe = mX2.dHe;
                            bVar5.dUf.dHf = new LinkedList();
                            for (z zVar2 : mX2.dHf) {
                                if (zVar2 != null) {
                                    av avVar2 = new av();
                                    avVar2.name = zVar2.name;
                                    avVar2.dHb = zVar2.dHb;
                                    bVar5.dUf.dHf.add(avVar2);
                                }
                            }
                        }
                        tabData.add(bVar5);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.dFD.auS().avV().k(bd.aOn)) {
                        com.baidu.tieba.frs.tab.b bVar6 = new com.baidu.tieba.frs.tab.b();
                        bVar6.name = frsTabInfo.tab_name;
                        if (lVar.buQ() != 0 && lVar.buQ() <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + lVar.buQ() + ")";
                        }
                        if (this.cJJ > 0 && this.cJJ != lVar.buQ() && this.cJJ <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + this.cJJ + ")";
                        } else if (this.cJJ > 99 || lVar.buQ() > 99) {
                            bVar6.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.cJJ == 0 && this.cJJ != lVar.buQ()) {
                            bVar6.name = frsTabInfo.tab_name;
                        }
                        bVar6.tabId = frsTabInfo.tab_id.intValue();
                        tabData.add(bVar6);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0 && a(tabData)) {
                this.dVI = lVar;
                this.dVH = tabData;
                this.dVL.setData(lVar.bvs().menu, i);
                if (lVar.bar() != null) {
                    this.dVL.setFid(lVar.bar().getId());
                }
                bx(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.g.k
    public boolean nT(int i) {
        if (i < 0 || this.dVH == null || this.dVH.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dVH.size()) {
                i2 = -1;
                break;
            } else if (this.dVH.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dVE.getTabCount()) {
            return false;
        }
        TbTabLayout.e dM = this.dVE.dM(i2);
        if (dM != null && !dM.isSelected()) {
            dM.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.b nU(int i) {
        if (i < 0 || this.dVH == null || this.dVH.size() <= 0) {
            return null;
        }
        Iterator it = this.dVH.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
            if (bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dVD != null) {
            aj.t(this.dVD, d.C0141d.cp_bg_line_d);
        }
        if (this.dVG != null) {
            aj.s(this.dVG, d.f.frs_tab_fading_edge);
        }
        if (this.dVE != null) {
            this.dVE.setSelectedTabIndicatorColor(aj.getColor(d.C0141d.cp_cont_f));
            this.dVE.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            this.dVE.setTabTextColors(aj.getColor(d.C0141d.cp_cont_j), aj.getColor(d.C0141d.cp_cont_b));
        }
        if (this.dVL != null) {
            this.dVL.onChangeSkinType();
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
        this.cJJ = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dVH != null && position >= 0 && position < this.dVH.size() && (bVar = this.dVH.get(position)) != null) {
            if (bVar.tabId == 1) {
                this.dVL.axF();
            } else if (!com.baidu.adp.lib.util.j.oJ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (this.dVM != null) {
                this.dVM.hT(bVar.tabId);
            }
            TiebaStatic.log(new ak("c12398").ab(ImageViewerConfig.FORUM_ID, this.dFD.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dVH != null && position >= 0 && position < this.dVH.size() && (bVar = this.dVH.get(position)) != null && bVar.tabId == 1) {
            this.dVL.axG();
        }
        aAx();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dVH != null && position >= 0 && position < this.dVH.size() && (bVar = this.dVH.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(bVar.tabId)));
            TiebaStatic.log(new ak("c12398").ab(ImageViewerConfig.FORUM_ID, this.dFD.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    private boolean a(TabData tabData) {
        if (v.E(tabData)) {
            return false;
        }
        return (!v.E(this.dVH) && tabData.size() == this.dVH.size() && this.dVH.containsAll(tabData)) ? false : true;
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.g.i.3
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MT() {
                    com.baidu.tieba.frs.d dVar = new com.baidu.tieba.frs.d();
                    if (i.this.dFD != null && i.this.dFD.auS() != null) {
                        dVar.setView(i.this.dFD.auS().avW());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bxM = dVar;
                    cVar.type = 1;
                    cVar.bxU = com.baidu.tbadk.mainTab.c.bxS;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.e bi(Context context) {
                    return null;
                }
            };
        }
        if (i == 301) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.g.i.4
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MT() {
                    com.baidu.tieba.frs.good.b bVar = new com.baidu.tieba.frs.good.b();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", i.this.dFD.getForumName());
                    bundle.putString("from", i.this.dFD.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bVar.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bxM = bVar;
                    cVar.type = 301;
                    cVar.bxU = com.baidu.tbadk.mainTab.c.bxS;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.e bi(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void bx(List<FrsTabInfo> list) {
        if (!v.E(list)) {
            this.dVK = new com.baidu.tieba.frs.c(this.dFD.getActivity().getApplicationContext(), list);
            this.dVK.setForumId(this.dFD.getForumId());
            this.dVK.setForumName(this.dFD.getForumName());
            if (this.dFD.avk() != null && this.dFD.avk().bar() != null) {
                this.dVK.setForumGameLabel(this.dFD.avk().bar().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b nW = nW(frsTabInfo.tab_id.intValue());
                if (nW != null) {
                    this.dVK.b(nW);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dVK));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayD() {
        if (this.dVK != null) {
            List<com.baidu.tbadk.mainTab.b> auD = this.dVK.auD();
            if (!v.E(auD) && !v.E(this.dVH)) {
                if (this.dVE.getTabCount() > 0) {
                    this.dVE.removeAllTabs();
                }
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dVH.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
                    Fragment b2 = b(bVar.tabId, auD);
                    if (b2 != null) {
                        this.dVE.a(this.dVE.sR().n(bVar.name), this.dVI.bvm() == bVar.tabId);
                        c cVar = new c();
                        cVar.tabId = bVar.tabId;
                        cVar.title = bVar.name;
                        cVar.fragment = b2;
                        this.mFragments.add(cVar);
                    } else {
                        it.remove();
                    }
                }
                if (this.dVE.getTabCount() > 0 && this.dVD.getVisibility() != 0) {
                    this.dVD.setVisibility(0);
                }
                this.dVJ.notifyDataSetChanged();
                this.dVE.setupWithViewPager(this.dxd);
                this.dxd.setOffscreenPageLimit(this.mFragments.size());
            }
        }
    }

    private Fragment b(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.MU().type) {
                return bVar.MU().bxM;
            }
        }
        return null;
    }

    public View aAu() {
        if (this.dVL == null) {
            return null;
        }
        return this.dVL.axE();
    }

    public void resetData() {
        this.dVH = null;
        this.dVI = null;
        if (this.dVL != null) {
            this.dVL.resetData();
        }
    }

    public static boolean nX(int i) {
        return i > 200 && i <= 300;
    }

    public void a(b bVar) {
        this.dVM = bVar;
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

    public c aAv() {
        if (this.dxd == null) {
            return null;
        }
        return (c) v.f(this.mFragments, this.dxd.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.g.k
    public void aAw() {
        this.dVN.aK(this.dFD.getString(d.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aAx() {
        this.dVN.ang();
    }
}
