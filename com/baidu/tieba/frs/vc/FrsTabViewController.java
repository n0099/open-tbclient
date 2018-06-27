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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
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
    private BdBaseViewPager azX;
    private RelativeLayout dEn;
    private TbTabLayout dEo;
    private RelativeLayout dEp;
    private View dEq;
    private TabData dEr;
    private l dEs;
    private FragmentAdapter dEt;
    private com.baidu.tieba.frs.e dEu;
    private com.baidu.tieba.frs.entelechy.c.a.a dEv;
    private a dEw;
    private com.baidu.tieba.c.d dEx;
    private FrsFragment dla;
    private List<b> mFragments;
    private int clj = -1;
    private boolean dEy = false;
    CustomMessageListener dEz = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.dEy) {
                FrsTabViewController.this.aye();
                FrsTabViewController.this.dEy = true;
            }
        }
    };
    private CustomMessageListener dEA = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.dEo.getTabCount() > 0 && !w.A(FrsTabViewController.this.dEr)) {
                    FrsTabViewController.this.dEs.mD(true);
                    int min = Math.min(FrsTabViewController.this.dEr.size(), FrsTabViewController.this.dEo.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e aQ = FrsTabViewController.this.dEo.aQ(i);
                        if (aQ != null) {
                            if (FrsTabViewController.this.dEr.get(i).tabId == 89) {
                                aQ.g(0, true);
                            } else {
                                aQ.g(0, false);
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bwS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b aAi;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aAi = FrsTabViewController.this.aAi()) != null && aAi.fragment != null && (aAi.fragment instanceof aj)) {
                        ((aj) aAi.fragment).Ua();
                    }
                }
            }
        }
    };
    private View.OnClickListener dEB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.dEx.akn();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void eY(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.dla = frsFragment;
        this.dEn = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.dEp = new RelativeLayout(this.dla.getContext());
        this.dEp.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dEq = view.findViewById(d.g.fading_edge_view);
        this.dEo = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.dEo.setOnTabSelectedListener(this);
        this.dEx = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.dEo);
        this.dEx.jd(d.f.bg_tip_blue_up_left);
        this.dEx.jc(16);
        this.dEx.D(true);
        this.dEx.jg(com.baidu.adp.lib.util.l.e(frsFragment.getPageContext().getPageActivity(), d.e.tbds34));
        this.dEx.jh(com.baidu.adp.lib.util.l.e(frsFragment.getPageContext().getPageActivity(), d.e.tbds10));
        this.dEx.k(this.dEB);
        this.dEv = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.dEp);
        this.azX = (BdBaseViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dEt = new FragmentAdapter(this.dla.getActivity().getSupportFragmentManager(), this.mFragments);
        this.azX.setAdapter(this.dEt);
        registerListener();
    }

    public void aA(View view) {
        if (isBrandForum()) {
            if ((view instanceof LinearLayout) && this.dEp.getParent() != null) {
                ((LinearLayout) view).removeView(this.dEp);
            }
        } else if ((view instanceof LinearLayout) && this.dEp.getParent() == null) {
            ((LinearLayout) view).addView(this.dEp);
        }
    }

    private boolean isBrandForum() {
        return this.dEs != null && this.dEs.bwv();
    }

    private void registerListener() {
        this.dEz.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dla.registerListener(this.dEz);
        this.dla.registerListener(this.dEA);
        this.dla.registerListener(2001446, this.bwS, this.dla.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bvW() != null && lVar.bvW().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bvW().tab) {
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
                            sb.append(lVar.baT().getId());
                            dVar3.url = sb.toString();
                            bj(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && ls(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.cV(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.ave().kx(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        z ku = y.avd().ku(dVar5.tabId);
                        if (ku != null && ku.dmG != null && ku.dmG.size() > 0) {
                            dVar5.dCy = new au();
                            dVar5.dCy.dmF = ku.dmF;
                            dVar5.dCy.dmG = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : ku.dmG) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.dmC = xVar.dmC;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.dCy.dmG.add(atVar);
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
                        z ku2 = y.avd().ku(dVar6.tabId);
                        if (ku2 != null && ku2.dmG != null && ku2.dmG.size() > 0) {
                            dVar6.dCy = new au();
                            dVar6.dCy.dmF = ku2.dmF;
                            dVar6.dCy.dmG = new LinkedList();
                            for (x xVar2 : ku2.dmG) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.dmC = xVar2.dmC;
                                    dVar6.dCy.dmG.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.dla.atI().auQ().k(bc.aif)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (lVar.bvy() != 0 && lVar.bvy() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + lVar.bvy() + ")";
                            }
                            if (this.clj > 0 && this.clj != lVar.bvy() && this.clj <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.clj + ")";
                            } else if (this.clj > 99 || lVar.bvy() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.clj == 0 && this.clj != lVar.bvy()) {
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
                this.dEs = lVar;
                if (!b(tabData) && this.dEo.getTabCount() > 0 && !w.A(this.dEr)) {
                    int min = Math.min(this.dEr.size(), this.dEo.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aQ = this.dEo.aQ(i2);
                        if (aQ != null) {
                            if (lVar.bvX() && this.dEr.get(i2).tabId == 89) {
                                aQ.g(0, true);
                            } else {
                                aQ.g(0, false);
                            }
                        }
                    }
                }
                if (!isBrandForum()) {
                    this.dEv.setData(lVar.bvW().menu, i);
                    if (lVar.baT() != null) {
                        this.dEv.setFid(lVar.baT().getId());
                    }
                }
                if (a(tabData)) {
                    this.dEr = tabData;
                    bB(arrayList);
                }
            }
        }
    }

    private boolean a(TabData tabData) {
        if (w.A(tabData)) {
            return false;
        }
        if (!w.A(this.dEt.mFragments) && tabData.size() == this.dEt.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.dEt.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.dEt.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.vc.j
    public boolean lF(int i) {
        if (i < 0 || this.dEr == null || this.dEr.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dEr.size()) {
                i2 = -1;
                break;
            } else if (this.dEr.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dEo.getTabCount()) {
            return false;
        }
        TbTabLayout.e aQ = this.dEo.aQ(i2);
        if (aQ != null && !aQ.isSelected()) {
            aQ.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d lG(int i) {
        if (i < 0 || this.dEr == null || this.dEr.size() <= 0) {
            return null;
        }
        Iterator it = this.dEr.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dEn != null) {
            am.j(this.dEn, d.C0142d.cp_bg_line_d);
        }
        if (this.dEq != null) {
            am.i(this.dEq, d.f.frs_tab_fading_edge);
        }
        if (this.dEo != null) {
            this.dEo.setSelectedTabIndicatorColor(am.getColor(d.C0142d.cp_cont_f));
            this.dEo.setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_d));
            this.dEo.setTabTextColors(am.getColor(d.C0142d.cp_cont_j), am.getColor(d.C0142d.cp_cont_b));
        }
        if (this.dEv != null && !isBrandForum()) {
            this.dEv.onChangeSkinType();
        }
        if (!w.A(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void lH(int i) {
        this.clj = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dEr != null && position >= 0 && position < this.dEr.size() && (dVar = this.dEr.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.jD()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.jr() && dVar.tabId == 89 && this.dEs != null && this.dEs.bvX()) {
                this.dEs.mD(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.dEw != null) {
                this.dEw.eY(dVar.tabId);
            }
            TiebaStatic.log(new an("c12398").ah(ImageViewerConfig.FORUM_ID, this.dla.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        aAk();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dEr != null && position >= 0 && position < this.dEr.size() && (dVar = this.dEr.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new an("c12398").ah(ImageViewerConfig.FORUM_ID, this.dla.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean b(TabData tabData) {
        if (w.A(tabData)) {
            return false;
        }
        return (!w.A(this.dEr) && tabData.size() == this.dEr.size() && this.dEr.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !ls(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void bj(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    an anVar = new an(str2);
                    anVar.ah("obj_type", host);
                    TiebaStatic.log(anVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b lI(final int i) {
        if (i == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Js() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.dla != null && FrsTabViewController.this.dla.atI() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.dla.atI().auR());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRL = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.aRS = com.baidu.tbadk.mainTab.c.aRQ;
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
                public com.baidu.tbadk.mainTab.c Js() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dla.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dla.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, i == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRL = frsGoodFragment;
                    cVar.type = i;
                    cVar.aRS = com.baidu.tbadk.mainTab.c.aRQ;
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
                public com.baidu.tbadk.mainTab.c Js() {
                    FrsDynamicFragment frsDynamicFragment = new FrsDynamicFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dla.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dla.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dla.getForumId());
                    frsDynamicFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRL = frsDynamicFragment;
                    cVar.type = 89;
                    cVar.aRS = com.baidu.tbadk.mainTab.c.aRQ;
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
                public com.baidu.tbadk.mainTab.c Js() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dla.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dla.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dla.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRL = frsADFragment;
                    cVar.type = 90;
                    cVar.aRS = com.baidu.tbadk.mainTab.c.aRQ;
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

    private void bB(List<FrsTabInfo> list) {
        if (!w.A(list)) {
            this.dEu = new com.baidu.tieba.frs.e(this.dla.getActivity().getApplicationContext(), list);
            this.dEu.setForumId(this.dla.getForumId());
            this.dEu.setForumName(this.dla.getForumName());
            if (this.dEs != null && this.dEs.baT() != null) {
                this.dEu.dx(this.dEs.baT().getFirst_class());
                this.dEu.dy(this.dEs.baT().getSecond_class());
            }
            if (this.dla.atZ() != null && this.dla.atZ().baT() != null) {
                this.dEu.setForumGameLabel(this.dla.atZ().baT().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b lI = lI(frsTabInfo.tab_id.intValue());
                if (lI != null) {
                    this.dEu.b(lI);
                }
            }
            this.dEy = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dEu));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aye() {
        int i;
        if (this.dEu != null) {
            List<com.baidu.tbadk.mainTab.b> att = this.dEu.att();
            if (!w.A(att) && !w.A(this.dEr)) {
                if (this.dEo.getTabCount() > 0) {
                    this.dEo.removeAllTabs();
                }
                aAg();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dEr.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, att);
                    if (c != null) {
                        TbTabLayout.e f = this.dEo.nR().f(dVar.name);
                        boolean z = this.dEs.gLp == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.dEs != null && this.dEs.bvX() && dVar.tabId == 89) {
                            f.g(0, true);
                        } else {
                            f.g(0, false);
                        }
                        this.dEo.a(f, z);
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
                if (this.dEo.getTabCount() > 0 && this.dEn.getVisibility() != 0) {
                    this.dEn.setVisibility(0);
                }
                this.dEt = new FragmentAdapter(this.dla.getActivity().getSupportFragmentManager(), this.mFragments);
                this.azX.setAdapter(this.dEt);
                this.dEt.notifyDataSetChanged();
                this.dEo.setupWithViewPager(this.azX);
                this.azX.setOffscreenPageLimit(this.mFragments.size());
                this.azX.setCurrentItem(i3, false);
            }
        }
    }

    private void aAg() {
        if (this.azX != null && this.dEt != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.dla.getActivity().getSupportFragmentManager();
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
            if (i == bVar.Jt().type) {
                return bVar.Jt().aRL;
            }
        }
        return null;
    }

    public View aAh() {
        if (isBrandForum() || this.dEv == null) {
            return null;
        }
        return this.dEv.awN();
    }

    public void resetData() {
        this.dEr = null;
        this.dEs = null;
        registerListener();
        if (this.dEv != null) {
            this.dEv.resetData();
        }
    }

    public static boolean ls(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.dEw = aVar;
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

    public b aAi() {
        if (this.azX == null) {
            return null;
        }
        return (b) w.d(this.mFragments, this.azX.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void aAj() {
        this.dEx.aQ(this.dla.getString(d.k.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aAk() {
        this.dEx.akn();
    }
}
