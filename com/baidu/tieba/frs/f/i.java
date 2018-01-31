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
    private int cFY = -1;
    private com.baidu.tieba.frs.i dCS;
    private RelativeLayout dSA;
    private View dSB;
    private TabData dSC;
    private l dSD;
    private a dSE;
    private com.baidu.tieba.frs.c dSF;
    private com.baidu.tieba.frs.entelechy.c.a.a dSG;
    private b dSH;
    private RelativeLayout dSy;
    private TbTabLayout dSz;
    private BdBaseViewPager dux;
    private List<c> mFragments;

    /* loaded from: classes2.dex */
    public interface b {
        void hV(int i);
    }

    public i(com.baidu.tieba.frs.i iVar, View view) {
        this.dCS = iVar;
        this.dSy = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.dSA = (RelativeLayout) view.findViewById(d.g.frs_sort_menu_layout);
        this.dSB = view.findViewById(d.g.fading_edge_view);
        this.dSz = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.dSz.setOnTabSelectedListener(this);
        aj.t(this.dSy, d.C0108d.cp_bg_line_d);
        this.dSG = new com.baidu.tieba.frs.entelechy.c.a.a(iVar, this.dSA);
        this.dux = (BdBaseViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dSE = new a(this.dCS.getActivity().getSupportFragmentManager(), this.mFragments);
        this.dux.setAdapter(this.dSE);
        registerListener();
    }

    private void registerListener() {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.f.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.c)) {
                    i.this.axG();
                }
            }
        };
        customMessageListener.setPriority(Integer.MAX_VALUE);
        this.dCS.registerListener(customMessageListener);
    }

    @Override // com.baidu.tieba.frs.f.k
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bue() != null && lVar.bue().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bue().tab) {
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
                            sb.append(lVar.aYJ().getId());
                            bVar2.url = sb.toString();
                            aX(bVar2.url, "c10078");
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ad.avo().nc(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.b bVar4 = new com.baidu.tieba.frs.tab.b();
                        bVar4.tabId = frsTabInfo.tab_id.intValue();
                        bVar4.name = frsTabInfo.tab_name;
                        ab mZ = aa.avn().mZ(bVar4.tabId);
                        if (mZ != null && mZ.dEo != null && mZ.dEo.size() > 0) {
                            bVar4.dRf = new aw();
                            bVar4.dRf.dEn = mZ.dEn;
                            bVar4.dRf.dEo = new LinkedList();
                            boolean z2 = true;
                            for (z zVar : mZ.dEo) {
                                if (zVar != null) {
                                    av avVar = new av();
                                    avVar.name = zVar.name;
                                    avVar.dEk = zVar.dEk;
                                    if (z2) {
                                        avVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    bVar4.dRf.dEo.add(avVar);
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
                        ab mZ2 = aa.avn().mZ(bVar5.tabId);
                        if (mZ2 != null && mZ2.dEo != null && mZ2.dEo.size() > 0) {
                            bVar5.dRf = new aw();
                            bVar5.dRf.dEn = mZ2.dEn;
                            bVar5.dRf.dEo = new LinkedList();
                            for (z zVar2 : mZ2.dEo) {
                                if (zVar2 != null) {
                                    av avVar2 = new av();
                                    avVar2.name = zVar2.name;
                                    avVar2.dEk = zVar2.dEk;
                                    bVar5.dRf.dEo.add(avVar2);
                                }
                            }
                        }
                        tabData.add(bVar5);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.dCS.aud().auU().k(bd.aNf)) {
                        com.baidu.tieba.frs.tab.b bVar6 = new com.baidu.tieba.frs.tab.b();
                        bVar6.name = frsTabInfo.tab_name;
                        if (lVar.btC() != 0 && lVar.btC() <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + lVar.btC() + ")";
                        }
                        if (this.cFY > 0 && this.cFY != lVar.btC() && this.cFY <= 99) {
                            bVar6.name = frsTabInfo.tab_name + "(" + this.cFY + ")";
                        } else if (this.cFY > 99 || lVar.btC() > 99) {
                            bVar6.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.cFY == 0 && this.cFY != lVar.btC()) {
                            bVar6.name = frsTabInfo.tab_name;
                        }
                        bVar6.tabId = frsTabInfo.tab_id.intValue();
                        tabData.add(bVar6);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0 && a(tabData)) {
                this.dSD = lVar;
                this.dSC = tabData;
                this.dSG.setData(lVar.bue().menu, i);
                if (lVar.aYJ() != null) {
                    this.dSG.setFid(lVar.aYJ().getId());
                }
                bv(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.f.k
    public boolean nT(int i) {
        if (i < 0 || this.dSC == null || this.dSC.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dSC.size()) {
                i2 = -1;
                break;
            } else if (this.dSC.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dSz.getTabCount()) {
            return false;
        }
        TbTabLayout.e dM = this.dSz.dM(i2);
        if (dM != null && !dM.isSelected()) {
            dM.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.b nU(int i) {
        if (i < 0 || this.dSC == null || this.dSC.size() <= 0) {
            return null;
        }
        Iterator it = this.dSC.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
            if (bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dSy != null) {
            aj.t(this.dSy, d.C0108d.cp_bg_line_d);
        }
        if (this.dSB != null) {
            aj.s(this.dSB, d.f.frs_tab_fading_edge);
        }
        if (this.dSz != null) {
            this.dSz.setSelectedTabIndicatorColor(aj.getColor(d.C0108d.cp_cont_f));
            this.dSz.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            this.dSz.setTabTextColors(aj.getColor(d.C0108d.cp_cont_j), aj.getColor(d.C0108d.cp_cont_b));
        }
        if (this.dSG != null) {
            this.dSG.onChangeSkinType();
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
        this.cFY = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dSC != null && position >= 0 && position < this.dSC.size() && (bVar = this.dSC.get(position)) != null) {
            if (bVar.tabId == 1) {
                this.dSG.awH();
            } else if (!com.baidu.adp.lib.util.j.oJ()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
            if (this.dSH != null) {
                this.dSH.hV(bVar.tabId);
            }
            TiebaStatic.log(new ak("c12398").aa(ImageViewerConfig.FORUM_ID, this.dCS.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dSC != null && position >= 0 && position < this.dSC.size() && (bVar = this.dSC.get(position)) != null && bVar.tabId == 1) {
            this.dSG.awI();
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.b bVar;
        int position = eVar.getPosition();
        if (this.dSC != null && position >= 0 && position < this.dSC.size() && (bVar = this.dSC.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(bVar.tabId)));
            TiebaStatic.log(new ak("c12398").aa(ImageViewerConfig.FORUM_ID, this.dCS.forumId).s(MyBookrackActivityConfig.TAB_ID, bVar.tabId));
        }
    }

    private boolean a(TabData tabData) {
        if (v.E(tabData)) {
            return false;
        }
        return (!v.E(this.dSC) && tabData.size() == this.dSC.size() && this.dSC.containsAll(tabData)) ? false : true;
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

    private void aX(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    ak akVar = new ak(str2);
                    akVar.aa("obj_type", host);
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
                public com.baidu.tbadk.mainTab.c Mo() {
                    com.baidu.tieba.frs.d dVar = new com.baidu.tieba.frs.d();
                    if (i.this.dCS != null && i.this.dCS.aud() != null) {
                        dVar.setView(i.this.dCS.aud().auV());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bvP = dVar;
                    cVar.type = 1;
                    cVar.bvX = com.baidu.tbadk.mainTab.c.bvV;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.e bj(Context context) {
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
                public com.baidu.tbadk.mainTab.c Mo() {
                    com.baidu.tieba.frs.good.b bVar = new com.baidu.tieba.frs.good.b();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", i.this.dCS.getForumName());
                    bundle.putString("from", i.this.dCS.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bVar.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bvP = bVar;
                    cVar.type = HttpStatus.SC_MOVED_PERMANENTLY;
                    cVar.bvX = com.baidu.tbadk.mainTab.c.bvV;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.e bj(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void bv(List<FrsTabInfo> list) {
        if (!v.E(list)) {
            this.dSF = new com.baidu.tieba.frs.c(this.dCS.getActivity().getApplicationContext(), list);
            this.dSF.setForumId(this.dCS.getForumId());
            this.dSF.setForumName(this.dCS.getForumName());
            if (this.dCS.auv() != null && this.dCS.auv().aYJ() != null) {
                this.dSF.setForumGameLabel(this.dCS.auv().aYJ().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b nW = nW(frsTabInfo.tab_id.intValue());
                if (nW != null) {
                    this.dSF.b(nW);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.dSF));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axG() {
        if (this.dSF != null) {
            List<com.baidu.tbadk.mainTab.b> atO = this.dSF.atO();
            if (!v.E(atO) && !v.E(this.dSC)) {
                if (this.dSz.getTabCount() > 0) {
                    this.dSz.removeAllTabs();
                }
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dSC.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.b bVar = (com.baidu.tieba.frs.tab.b) it.next();
                    Fragment b2 = b(bVar.tabId, atO);
                    if (b2 != null) {
                        this.dSz.a(this.dSz.sT().n(bVar.name), this.dSD.btY() == bVar.tabId);
                        c cVar = new c();
                        cVar.tabId = bVar.tabId;
                        cVar.title = bVar.name;
                        cVar.fragment = b2;
                        this.mFragments.add(cVar);
                    } else {
                        it.remove();
                    }
                }
                if (this.dSz.getTabCount() > 0 && this.dSy.getVisibility() != 0) {
                    this.dSy.setVisibility(0);
                }
                this.dSE.notifyDataSetChanged();
                this.dSz.setupWithViewPager(this.dux);
                this.dux.setOffscreenPageLimit(this.mFragments.size());
            }
        }
    }

    private Fragment b(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.Mp().type) {
                return bVar.Mp().bvP;
            }
        }
        return null;
    }

    public View azq() {
        if (this.dSG == null) {
            return null;
        }
        return this.dSG.awG();
    }

    public void resetData() {
        this.dSC = null;
        this.dSD = null;
        if (this.dSG != null) {
            this.dSG.resetData();
        }
    }

    public static boolean nX(int i) {
        return i > 200 && i <= 300;
    }

    public void a(b bVar) {
        this.dSH = bVar;
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

    public c azr() {
        if (this.dux == null) {
            return null;
        }
        return (c) v.f(this.mFragments, this.dux.getCurrentItem());
    }
}
