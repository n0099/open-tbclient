package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.dynamic.FrsDynamicFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
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
public class FrsTabViewController implements TbTabLayout.b, j {
    private static final String TAG = FrsTabViewController.class.getSimpleName();
    private BdBaseViewPager azN;
    private RelativeLayout dGV;
    private TbTabLayout dGW;
    private RelativeLayout dGX;
    private View dGY;
    private TabData dGZ;
    private l dHa;
    private FragmentAdapter dHb;
    private com.baidu.tieba.frs.e dHc;
    private com.baidu.tieba.frs.entelechy.c.a.a dHd;
    private a dHe;
    private com.baidu.tieba.c.d dHf;
    private FrsFragment dnP;
    private List<b> mFragments;
    private int cmU = -1;
    private boolean dHg = false;
    public boolean dHh = true;
    CustomMessageListener dHi = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.dHg) {
                FrsTabViewController.this.ayH();
                FrsTabViewController.this.dHg = true;
            }
        }
    };
    private CustomMessageListener dHj = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.dGW.getTabCount() > 0 && !w.z(FrsTabViewController.this.dGZ)) {
                    FrsTabViewController.this.dHa.mo(true);
                    int min = Math.min(FrsTabViewController.this.dGZ.size(), FrsTabViewController.this.dGW.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e aR = FrsTabViewController.this.dGW.aR(i);
                        if (aR != null) {
                            if (FrsTabViewController.this.dGZ.get(i).tabId == 89) {
                                aR.g(0, true);
                            } else {
                                aR.g(0, false);
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bxz = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b aAM;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aAM = FrsTabViewController.this.aAM()) != null && aAM.fragment != null && (aAM.fragment instanceof aj)) {
                        ((aj) aAM.fragment).Ul();
                    }
                }
            }
        }
    };
    private View.OnClickListener dHk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.dHf.akO();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void eY(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.dnP = frsFragment;
        this.dGV = (RelativeLayout) view.findViewById(f.g.frs_tab_view_container);
        this.dGX = new RelativeLayout(this.dnP.getContext());
        this.dGX.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dGY = view.findViewById(f.g.fading_edge_view);
        this.dGW = (TbTabLayout) view.findViewById(f.g.frs_tab_layout);
        this.dGW.setOnTabSelectedListener(this);
        this.dHf = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.dGW);
        this.dHf.jo(f.C0146f.bg_tip_blue_up_left);
        this.dHf.jn(16);
        this.dHf.C(true);
        this.dHf.jr(com.baidu.adp.lib.util.l.f(frsFragment.getPageContext().getPageActivity(), f.e.tbds34));
        this.dHf.js(com.baidu.adp.lib.util.l.f(frsFragment.getPageContext().getPageActivity(), f.e.tbds10));
        this.dHf.k(this.dHk);
        this.dHd = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.dGX);
        this.azN = (BdBaseViewPager) view.findViewById(f.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dHb = new FragmentAdapter(this.dnP.getActivity().getSupportFragmentManager(), this.mFragments);
        this.azN.setAdapter(this.dHb);
        registerListener();
    }

    public void aD(View view) {
        if (isBrandForum()) {
            if ((view instanceof LinearLayout) && this.dGX.getParent() != null) {
                ((LinearLayout) view).removeView(this.dGX);
            }
        } else if ((view instanceof LinearLayout) && this.dGX.getParent() == null) {
            ((LinearLayout) view).addView(this.dGX);
        }
    }

    private boolean isBrandForum() {
        return this.dHa != null && this.dHa.bva();
    }

    private void registerListener() {
        this.dHi.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dnP.registerListener(this.dHi);
        this.dnP.registerListener(this.dHj);
        this.dnP.registerListener(2001446, this.bxz, this.dnP.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.buB() != null && lVar.buB().tab != null && this.dHh) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.buB().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    if (frsTabInfo.tab_id.intValue() == 89) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.tabId = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        tabData.add(dVar);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 12) {
                        com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                        dVar2.tabId = frsTabInfo.tab_id.intValue();
                        dVar2.name = frsTabInfo.tab_name;
                        tabData.add(dVar2);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                            dVar3.tabId = frsTabInfo.tab_id.intValue();
                            dVar3.name = frsTabInfo.tab_name;
                            StringBuilder sb = new StringBuilder();
                            String lowerCase = frsTabInfo.tab_url.toLowerCase();
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) && !lowerCase.contains("://")) {
                                sb.append("http://");
                            }
                            sb.append(frsTabInfo.tab_url);
                            sb.append("&");
                            sb.append(ImageViewerConfig.FORUM_ID);
                            sb.append("=");
                            sb.append(lVar.aZg().getId());
                            dVar3.url = sb.toString();
                            bh(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && lD(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.cT(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.avI().kH(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        z kE = y.avH().kE(dVar5.tabId);
                        if (kE != null && kE.dpw != null && kE.dpw.size() > 0) {
                            dVar5.dFh = new au();
                            dVar5.dFh.dpv = kE.dpv;
                            dVar5.dFh.dpw = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : kE.dpw) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.dps = xVar.dps;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.dFh.dpw.add(atVar);
                                    z2 = z;
                                }
                            }
                        }
                        tabData.add(dVar5);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        z kE2 = y.avH().kE(dVar6.tabId);
                        if (kE2 != null && kE2.dpw != null && kE2.dpw.size() > 0) {
                            dVar6.dFh = new au();
                            dVar6.dFh.dpv = kE2.dpv;
                            dVar6.dFh.dpw = new LinkedList();
                            for (x xVar2 : kE2.dpw) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.dps = xVar2.dps;
                                    dVar6.dFh.dpw.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.dnP.aul().avt().k(bb.ahB)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (lVar.bud() != 0 && lVar.bud() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + lVar.bud() + ")";
                            }
                            if (this.cmU > 0 && this.cmU != lVar.bud() && this.cmU <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.cmU + ")";
                            } else if (this.cmU > 99 || lVar.bud() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.cmU == 0 && this.cmU != lVar.bud()) {
                                dVar7.name = frsTabInfo.tab_name;
                            }
                            dVar7.tabId = frsTabInfo.tab_id.intValue();
                            tabData.add(dVar7);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 90) {
                        com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                        dVar8.tabId = frsTabInfo.tab_id.intValue();
                        dVar8.name = frsTabInfo.tab_name;
                        tabData.add(dVar8);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.dHa = lVar;
                if (!b(tabData) && this.dGW.getTabCount() > 0 && !w.z(this.dGZ)) {
                    int min = Math.min(this.dGZ.size(), this.dGW.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aR = this.dGW.aR(i2);
                        if (aR != null) {
                            if (lVar.buC() && this.dGZ.get(i2).tabId == 89) {
                                aR.g(0, true);
                            } else {
                                aR.g(0, false);
                            }
                        }
                    }
                }
                if (lVar != null && lVar.buB() != null) {
                    List<FrsTabInfo> list = lVar.buB().menu;
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) w.d(list, 0);
                        if (this.dnP != null && this.dnP.aug() != null && frsTabInfo2 != null) {
                            this.dnP.aug().lt(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.dHd != null && lVar.aZg() != null) {
                        this.dHd.setData(list, i);
                        this.dHd.setFid(lVar.aZg().getId());
                    }
                }
                if (a(tabData)) {
                    this.dGZ = tabData;
                    bA(arrayList);
                }
            }
        }
    }

    private boolean a(TabData tabData) {
        if (w.z(tabData)) {
            return false;
        }
        if (!w.z(this.dHb.mFragments) && tabData.size() == this.dHb.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.dHb.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.dHb.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.vc.j
    public boolean lQ(int i) {
        if (i < 0 || this.dGZ == null || this.dGZ.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dGZ.size()) {
                i2 = -1;
                break;
            } else if (this.dGZ.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dGW.getTabCount()) {
            return false;
        }
        TbTabLayout.e aR = this.dGW.aR(i2);
        if (aR != null && !aR.isSelected()) {
            aR.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d lR(int i) {
        if (i < 0 || this.dGZ == null || this.dGZ.size() <= 0) {
            return null;
        }
        Iterator it = this.dGZ.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dGV != null) {
            am.j(this.dGV, f.d.cp_bg_line_d);
        }
        if (this.dGY != null) {
            am.i(this.dGY, f.C0146f.frs_tab_fading_edge);
        }
        if (this.dGW != null) {
            this.dGW.setSelectedTabIndicatorColor(am.getColor(f.d.cp_cont_f));
            this.dGW.setBackgroundColor(am.getColor(f.d.cp_bg_line_d));
            this.dGW.setTabTextColors(am.getColor(f.d.cp_cont_j), am.getColor(f.d.cp_cont_b));
        }
        if (this.dHd != null && !isBrandForum()) {
            this.dHd.onChangeSkinType();
        }
        if (!w.z(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void lS(int i) {
        this.cmU = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dGZ != null && position >= 0 && position < this.dGZ.size() && (dVar = this.dGZ.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.jE()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.js() && dVar.tabId == 89 && this.dHa != null && this.dHa.buC()) {
                this.dHa.mo(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.dHe != null) {
                this.dHe.eY(dVar.tabId);
            }
            TiebaStatic.log(new an("c12398").ae(ImageViewerConfig.FORUM_ID, this.dnP.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        aAO();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dGZ != null && position >= 0 && position < this.dGZ.size() && (dVar = this.dGZ.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new an("c12398").ae(ImageViewerConfig.FORUM_ID, this.dnP.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean b(TabData tabData) {
        if (w.z(tabData)) {
            return false;
        }
        return (!w.z(this.dGZ) && tabData.size() == this.dGZ.size() && this.dGZ.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !lD(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void bh(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    an anVar = new an(str2);
                    anVar.ae("obj_type", host);
                    TiebaStatic.log(anVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b lT(final int i) {
        if (i == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Jn() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.dnP != null && FrsTabViewController.this.dnP.aul() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.dnP.aul().avu());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRI = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.aRQ = com.baidu.tbadk.mainTab.c.aRN;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bd(Context context) {
                    return null;
                }
            };
        }
        if (i == 301 || i == 303) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Jn() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dnP.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dnP.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, i == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRI = frsGoodFragment;
                    cVar.type = i;
                    cVar.aRQ = com.baidu.tbadk.mainTab.c.aRN;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bd(Context context) {
                    return null;
                }
            };
        }
        if (i == 89) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Jn() {
                    FrsDynamicFragment frsDynamicFragment = new FrsDynamicFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dnP.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dnP.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dnP.getForumId());
                    frsDynamicFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRI = frsDynamicFragment;
                    cVar.type = 89;
                    cVar.aRQ = com.baidu.tbadk.mainTab.c.aRN;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bd(Context context) {
                    return null;
                }
            };
        }
        if (i == 90) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Jn() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dnP.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dnP.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dnP.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRI = frsADFragment;
                    cVar.type = 90;
                    cVar.aRQ = com.baidu.tbadk.mainTab.c.aRN;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bd(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void bA(List<FrsTabInfo> list) {
        if (!w.z(list)) {
            this.dHc = new com.baidu.tieba.frs.e(this.dnP.getActivity().getApplicationContext(), list);
            this.dHc.setForumId(this.dnP.getForumId());
            this.dHc.setForumName(this.dnP.getForumName());
            if (this.dHa != null && this.dHa.aZg() != null) {
                this.dHc.du(this.dHa.aZg().getFirst_class());
                this.dHc.dv(this.dHa.aZg().getSecond_class());
            }
            if (this.dnP.auC() != null && this.dnP.auC().aZg() != null) {
                this.dHc.setForumGameLabel(this.dnP.auC().aZg().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b lT = lT(frsTabInfo.tab_id.intValue());
                if (lT != null) {
                    this.dHc.b(lT);
                }
            }
            this.dHg = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dHc));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayH() {
        int i;
        if (this.dHc != null) {
            List<com.baidu.tbadk.mainTab.b> atW = this.dHc.atW();
            if (!w.z(atW) && !w.z(this.dGZ)) {
                if (this.dGW.getTabCount() > 0) {
                    this.dGW.removeAllTabs();
                }
                aAK();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dGZ.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, atW);
                    if (c != null) {
                        TbTabLayout.e b2 = this.dGW.nR().b(dVar.name);
                        boolean z = this.dHa.gMp == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.dHa != null && this.dHa.buC() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.dGW.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = c;
                        this.mFragments.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i3 = i3;
                    i2 = i;
                }
                if (this.dGW.getTabCount() > 0 && this.dGV.getVisibility() != 0) {
                    this.dGV.setVisibility(0);
                }
                this.dHb = new FragmentAdapter(this.dnP.getActivity().getSupportFragmentManager(), this.mFragments);
                this.azN.setAdapter(this.dHb);
                this.dHb.notifyDataSetChanged();
                this.dGW.setupWithViewPager(this.azN);
                this.azN.setOffscreenPageLimit(this.mFragments.size());
                this.azN.setCurrentItem(i3, false);
            }
        }
    }

    private void aAK() {
        if (this.azN != null && this.dHb != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.dnP.getActivity().getSupportFragmentManager();
                FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
                int size = this.mFragments.size();
                for (int i = 0; i < size; i++) {
                    b bVar = this.mFragments.get(i);
                    if (bVar != null && bVar.fragment != null) {
                        beginTransaction.remove(bVar.fragment);
                    }
                }
                beginTransaction.commit();
                supportFragmentManager.executePendingTransactions();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
        }
    }

    private Fragment c(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.Jo().type) {
                return bVar.Jo().aRI;
            }
        }
        return null;
    }

    public View aAL() {
        if (isBrandForum() || this.dHd == null) {
            return null;
        }
        return this.dHd.axr();
    }

    public void resetData() {
        this.dHa = null;
        registerListener();
        if (this.dHd != null) {
            this.dHd.resetData();
        }
    }

    public static boolean lD(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.dHe = aVar;
    }

    /* loaded from: classes2.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<b> mFragments;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
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

        @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.mPrimaryPosition != i) {
                if (this.mPrimaryPosition != -1) {
                    ((BaseFragment) getItem(this.mPrimaryPosition)).setPrimary(false);
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public String title;

        public b() {
        }
    }

    public b aAM() {
        if (this.azN == null) {
            return null;
        }
        return (b) w.d(this.mFragments, this.azN.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void aAN() {
        this.dHf.aO(this.dnP.getString(f.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aAO() {
        this.dHf.akO();
    }
}
