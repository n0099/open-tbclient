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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.tbadkCore.m;
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
    private com.baidu.tieba.frs.i dFH;
    private RelativeLayout dVJ;
    private TbTabLayout dVK;
    private RelativeLayout dVL;
    private View dVM;
    private TabData dVN;
    private m dVO;
    private a dVP;
    private com.baidu.tieba.frs.c dVQ;
    private com.baidu.tieba.frs.entelechy.c.a.a dVR;
    private b dVS;
    private com.baidu.tieba.d.c dVT;
    private BdBaseViewPager dxg;
    private List<c> mFragments;
    private int cJM = -1;
    private CustomMessageListener cdd = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.g.i.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c aAx;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aAx = i.this.aAx()) != null && aAx.fragment != null && (aAx.fragment instanceof al)) {
                        ((al) aAx.fragment).XL();
                    }
                }
            }
        }
    };
    private View.OnClickListener dVU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.g.i.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.dVT.anh();
        }
    };

    /* loaded from: classes2.dex */
    public interface b {
        void hT(int i);
    }

    public i(com.baidu.tieba.frs.i iVar, View view) {
        this.dFH = iVar;
        this.dVJ = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.dVL = (RelativeLayout) view.findViewById(d.g.frs_sort_menu_layout);
        this.dVM = view.findViewById(d.g.fading_edge_view);
        this.dVK = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.dVK.setOnTabSelectedListener(this);
        this.dVT = new com.baidu.tieba.d.c(iVar.getPageContext(), this.dVK);
        this.dVT.lS(d.f.bg_tip_blue_up_left);
        this.dVT.lR(16);
        this.dVT.ai(true);
        this.dVT.lV(l.t(iVar.getPageContext().getPageActivity(), d.e.tbds34));
        this.dVT.lW(l.t(iVar.getPageContext().getPageActivity(), d.e.tbds10));
        this.dVT.j(this.dVU);
        this.dVR = new com.baidu.tieba.frs.entelechy.c.a.a(iVar, this.dVL);
        this.dxg = (BdBaseViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dVP = new a(this.dFH.getActivity().getSupportFragmentManager(), this.mFragments);
        this.dxg.setAdapter(this.dVP);
        registerListener();
    }

    private void registerListener() {
        CustomMessageListener customMessageListener = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.g.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.c)) {
                    i.this.ayF();
                }
            }
        };
        customMessageListener.setPriority(Integer.MAX_VALUE);
        this.dFH.registerListener(customMessageListener);
        this.dFH.registerListener(2001446, this.cdd, this.dFH.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.g.k
    public void a(m mVar, int i) {
        boolean z;
        if (mVar != null && mVar.bvv() != null && mVar.bvv().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : mVar.bvv().tab) {
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
                            sb.append(mVar.bas().getId());
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ad.awn().na(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.b bVar4 = new com.baidu.tieba.frs.tab.b();
                        bVar4.tabId = frsTabInfo.tab_id.intValue();
                        bVar4.name = frsTabInfo.tab_name;
                        ab mX = aa.awm().mX(bVar4.tabId);
                        if (mX != null && mX.dHk != null && mX.dHk.size() > 0) {
                            bVar4.dUk = new aw();
                            bVar4.dUk.dHj = mX.dHj;
                            bVar4.dUk.dHk = new LinkedList();
                            boolean z2 = true;
                            for (z zVar : mX.dHk) {
                                if (zVar != null) {
                                    av avVar = new av();
                                    avVar.name = zVar.name;
                                    avVar.dHg = zVar.dHg;
                                    if (z2) {
                                        avVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    bVar4.dUk.dHk.add(avVar);
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
                        ab mX2 = aa.awm().mX(bVar5.tabId);
                        if (mX2 != null && mX2.dHk != null && mX2.dHk.size() > 0) {
                            bVar5.dUk = new aw();
                            bVar5.dUk.dHj = mX2.dHj;
                            bVar5.dUk.dHk = new LinkedList();
                            for (z zVar2 : mX2.dHk) {
                                if (zVar2 != null) {
                                    av avVar2 = new av();
                                    avVar2.name = zVar2.name;
                                    avVar2.dHg = zVar2.dHg;
                                    bVar5.dUk.dHk.add(avVar2);
                                }
                            }
                        }
                        tabData.add(bVar5);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.dFH.auT().avX().k(bd.aOo)) {
                        com.baidu.tieba.frs.tab.b bVar6 = new com.baidu.tieba.frs.tab.b();
                        bVar6.name = frsTabInfo.tab_name;
                        if (mVar.buS() != 0 && mVar.buS() <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + mVar.buS() + ")";
                        }
                        if (this.cJM > 0 && this.cJM != mVar.buS() && this.cJM <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + this.cJM + ")";
                        } else if (this.cJM > 99 || mVar.buS() > 99) {
                            bVar6.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.cJM == 0 && this.cJM != mVar.buS()) {
                            bVar6.name = frsTabInfo.tab_name;
                        }
                        bVar6.tabId = frsTabInfo.tab_id.intValue();
                        tabData.add(bVar6);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0 && a(tabData)) {
                this.dVO = mVar;
                this.dVN = tabData;
                this.dVR.setData(mVar.bvv().menu, i);
                if (mVar.bas() != null) {
                    this.dVR.setFid(mVar.bas().getId());
                }
                bx(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.g.k
    public boolean nT(int i) {
        if (i < 0 || this.dVN == null || this.dVN.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dVN.size()) {
                i2 = -1;
                break;
            } else if (this.dVN.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dVK.getTabCount()) {
            return false;
        }
        TbTabLayout.e dM = this.dVK.dM(i2);
        if (dM != null && !dM.isSelected()) {
            dM.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.b nU(int i) {
        if (i < 0 || this.dVN == null || this.dVN.size() <= 0) {
            return null;
        }
        Iterator it = this.dVN.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
            if (bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dVJ != null) {
            aj.t(this.dVJ, d.C0141d.cp_bg_line_d);
        }
        if (this.dVM != null) {
            aj.s(this.dVM, d.f.frs_tab_fading_edge);
        }
        if (this.dVK != null) {
            this.dVK.setSelectedTabIndicatorColor(aj.getColor(d.C0141d.cp_cont_f));
            this.dVK.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_d));
            this.dVK.setTabTextColors(aj.getColor(d.C0141d.cp_cont_j), aj.getColor(d.C0141d.cp_cont_b));
        }
        if (this.dVR != null) {
            this.dVR.onChangeSkinType();
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
        this.cJM = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dVN != null && position >= 0 && position < this.dVN.size() && (bVar = this.dVN.get(position)) != null) {
            if (bVar.tabId == 1) {
                this.dVR.axH();
            } else if (!com.baidu.adp.lib.util.j.oJ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (this.dVS != null) {
                this.dVS.hT(bVar.tabId);
            }
            TiebaStatic.log(new ak("c12398").ab(ImageViewerConfig.FORUM_ID, this.dFH.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dVN != null && position >= 0 && position < this.dVN.size() && (bVar = this.dVN.get(position)) != null && bVar.tabId == 1) {
            this.dVR.axI();
        }
        aAz();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dVN != null && position >= 0 && position < this.dVN.size() && (bVar = this.dVN.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(bVar.tabId)));
            TiebaStatic.log(new ak("c12398").ab(ImageViewerConfig.FORUM_ID, this.dFH.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    private boolean a(TabData tabData) {
        if (v.E(tabData)) {
            return false;
        }
        return (!v.E(this.dVN) && tabData.size() == this.dVN.size() && this.dVN.containsAll(tabData)) ? false : true;
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
                public com.baidu.tbadk.mainTab.c MU() {
                    com.baidu.tieba.frs.d dVar = new com.baidu.tieba.frs.d();
                    if (i.this.dFH != null && i.this.dFH.auT() != null) {
                        dVar.setView(i.this.dFH.auT().avY());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bxP = dVar;
                    cVar.type = 1;
                    cVar.bxX = com.baidu.tbadk.mainTab.c.bxV;
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
                public com.baidu.tbadk.mainTab.c MU() {
                    com.baidu.tieba.frs.good.b bVar = new com.baidu.tieba.frs.good.b();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", i.this.dFH.getForumName());
                    bundle.putString("from", i.this.dFH.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bVar.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bxP = bVar;
                    cVar.type = 301;
                    cVar.bxX = com.baidu.tbadk.mainTab.c.bxV;
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
            this.dVQ = new com.baidu.tieba.frs.c(this.dFH.getActivity().getApplicationContext(), list);
            this.dVQ.setForumId(this.dFH.getForumId());
            this.dVQ.setForumName(this.dFH.getForumName());
            if (this.dFH.avl() != null && this.dFH.avl().bas() != null) {
                this.dVQ.setForumGameLabel(this.dFH.avl().bas().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b nW = nW(frsTabInfo.tab_id.intValue());
                if (nW != null) {
                    this.dVQ.b(nW);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dVQ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayF() {
        if (this.dVQ != null) {
            List<com.baidu.tbadk.mainTab.b> auE = this.dVQ.auE();
            if (!v.E(auE) && !v.E(this.dVN)) {
                if (this.dVK.getTabCount() > 0) {
                    this.dVK.removeAllTabs();
                }
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dVN.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
                    Fragment b2 = b(bVar.tabId, auE);
                    if (b2 != null) {
                        this.dVK.a(this.dVK.sR().n(bVar.name), this.dVO.bvp() == bVar.tabId);
                        c cVar = new c();
                        cVar.tabId = bVar.tabId;
                        cVar.title = bVar.name;
                        cVar.fragment = b2;
                        this.mFragments.add(cVar);
                    } else {
                        it.remove();
                    }
                }
                if (this.dVK.getTabCount() > 0 && this.dVJ.getVisibility() != 0) {
                    this.dVJ.setVisibility(0);
                }
                this.dVP.notifyDataSetChanged();
                this.dVK.setupWithViewPager(this.dxg);
                this.dxg.setOffscreenPageLimit(this.mFragments.size());
            }
        }
    }

    private Fragment b(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.MV().type) {
                return bVar.MV().bxP;
            }
        }
        return null;
    }

    public View aAw() {
        if (this.dVR == null) {
            return null;
        }
        return this.dVR.axG();
    }

    public void resetData() {
        this.dVN = null;
        this.dVO = null;
        if (this.dVR != null) {
            this.dVR.resetData();
        }
    }

    public static boolean nX(int i) {
        return i > 200 && i <= 300;
    }

    public void a(b bVar) {
        this.dVS = bVar;
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

    public c aAx() {
        if (this.dxg == null) {
            return null;
        }
        return (c) v.f(this.mFragments, this.dxg.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.g.k
    public void aAy() {
        this.dVT.aK(this.dFH.getString(d.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aAz() {
        this.dVT.anh();
    }
}
