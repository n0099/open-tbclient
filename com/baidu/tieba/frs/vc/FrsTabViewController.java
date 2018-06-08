package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.dynamic.FrsDynamicFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.x;
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
    private BdBaseViewPager azf;
    private RelativeLayout dBb;
    private TbTabLayout dBc;
    private RelativeLayout dBd;
    private View dBe;
    private TabData dBf;
    private l dBg;
    private FragmentAdapter dBh;
    private com.baidu.tieba.frs.c dBi;
    private com.baidu.tieba.frs.entelechy.c.a.a dBj;
    private a dBk;
    private com.baidu.tieba.c.d dBl;
    private FrsFragment diZ;
    private List<b> mFragments;
    private int ciS = -1;
    private CustomMessageListener dBm = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.dBc.getTabCount() > 0 && !w.z(FrsTabViewController.this.dBf)) {
                    FrsTabViewController.this.dBg.ms(true);
                    int min = Math.min(FrsTabViewController.this.dBf.size(), FrsTabViewController.this.dBc.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e aQ = FrsTabViewController.this.dBc.aQ(i);
                        if (aQ != null) {
                            if (FrsTabViewController.this.dBf.get(i).tabId == 89) {
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
    private CustomMessageListener bvx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b azB;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (azB = FrsTabViewController.this.azB()) != null && azB.fragment != null && (azB.fragment instanceof ah)) {
                        ((ah) azB.fragment).TG();
                    }
                }
            }
        }
    };
    private View.OnClickListener dBn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.dBl.akT();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void eX(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.diZ = frsFragment;
        this.dBb = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.dBd = new RelativeLayout(this.diZ.getContext());
        this.dBd.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dBe = view.findViewById(d.g.fading_edge_view);
        this.dBc = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.dBc.setOnTabSelectedListener(this);
        this.dBl = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.dBc);
        this.dBl.jf(d.f.bg_tip_blue_up_left);
        this.dBl.je(16);
        this.dBl.D(true);
        this.dBl.ji(com.baidu.adp.lib.util.l.e(frsFragment.getPageContext().getPageActivity(), d.e.tbds34));
        this.dBl.jj(com.baidu.adp.lib.util.l.e(frsFragment.getPageContext().getPageActivity(), d.e.tbds10));
        this.dBl.j(this.dBn);
        this.dBj = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.dBd);
        this.azf = (BdBaseViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dBh = new FragmentAdapter(this.diZ.getActivity().getSupportFragmentManager(), this.mFragments);
        this.azf.setAdapter(this.dBh);
        registerListener();
    }

    public void ay(View view) {
        if ((view instanceof LinearLayout) && this.dBd.getParent() == null) {
            ((LinearLayout) view).addView(this.dBd);
        }
    }

    private void registerListener() {
        CustomMessageListener customMessageListener = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.c)) {
                    FrsTabViewController.this.axA();
                }
            }
        };
        customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.diZ.registerListener(customMessageListener);
        this.diZ.registerListener(this.dBm);
        this.diZ.registerListener(2001446, this.bvx, this.diZ.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bvw() != null && lVar.bvw().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bvw().tab) {
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
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                sb.append("http://");
                            }
                            sb.append(frsTabInfo.tab_url);
                            sb.append("&");
                            sb.append(ImageViewerConfig.FORUM_ID);
                            sb.append("=");
                            sb.append(lVar.bam().getId());
                            dVar3.url = sb.toString();
                            bf(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && ll(frsTabInfo.tab_id.intValue())) {
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.auK().kr(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x ko = com.baidu.tieba.frs.w.auJ().ko(dVar5.tabId);
                        if (ko != null && ko.dkz != null && ko.dkz.size() > 0) {
                            dVar5.dzl = new as();
                            dVar5.dzl.dky = ko.dky;
                            dVar5.dzl.dkz = new LinkedList();
                            boolean z2 = true;
                            for (v vVar : ko.dkz) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.dkv = vVar.dkv;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.dzl.dkz.add(arVar);
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
                        x ko2 = com.baidu.tieba.frs.w.auJ().ko(dVar6.tabId);
                        if (ko2 != null && ko2.dkz != null && ko2.dkz.size() > 0) {
                            dVar6.dzl = new as();
                            dVar6.dzl.dky = ko2.dky;
                            dVar6.dzl.dkz = new LinkedList();
                            for (v vVar2 : ko2.dkz) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.dkv = vVar2.dkv;
                                    dVar6.dzl.dkz.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.diZ.atr().aux().k(bd.ahN)) {
                        com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                        dVar7.name = frsTabInfo.tab_name;
                        if (lVar.buY() != 0 && lVar.buY() <= 99) {
                            dVar7.name = frsTabInfo.tab_name + "(" + lVar.buY() + ")";
                        }
                        if (this.ciS > 0 && this.ciS != lVar.buY() && this.ciS <= 99) {
                            dVar7.name = frsTabInfo.tab_name + "(" + this.ciS + ")";
                        } else if (this.ciS > 99 || lVar.buY() > 99) {
                            dVar7.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.ciS == 0 && this.ciS != lVar.buY()) {
                            dVar7.name = frsTabInfo.tab_name;
                        }
                        dVar7.tabId = frsTabInfo.tab_id.intValue();
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.dBg = lVar;
                if (!a(tabData)) {
                    if (this.dBc.getTabCount() > 0 && !w.z(this.dBf)) {
                        int min = Math.min(this.dBf.size(), this.dBc.getTabCount());
                        for (int i2 = 0; i2 < min; i2++) {
                            TbTabLayout.e aQ = this.dBc.aQ(i2);
                            if (aQ != null) {
                                if (lVar.bvx() && this.dBf.get(i2).tabId == 89) {
                                    aQ.g(0, true);
                                } else {
                                    aQ.g(0, false);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                this.dBf = tabData;
                this.dBj.setData(lVar.bvw().menu, i);
                if (lVar.bam() != null) {
                    this.dBj.setFid(lVar.bam().getId());
                }
                bx(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.vc.j
    public boolean ly(int i) {
        if (i < 0 || this.dBf == null || this.dBf.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dBf.size()) {
                i2 = -1;
                break;
            } else if (this.dBf.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dBc.getTabCount()) {
            return false;
        }
        TbTabLayout.e aQ = this.dBc.aQ(i2);
        if (aQ != null && !aQ.isSelected()) {
            aQ.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d lz(int i) {
        if (i < 0 || this.dBf == null || this.dBf.size() <= 0) {
            return null;
        }
        Iterator it = this.dBf.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dBb != null) {
            al.j(this.dBb, d.C0141d.cp_bg_line_d);
        }
        if (this.dBe != null) {
            al.i(this.dBe, d.f.frs_tab_fading_edge);
        }
        if (this.dBc != null) {
            this.dBc.setSelectedTabIndicatorColor(al.getColor(d.C0141d.cp_cont_f));
            this.dBc.setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_d));
            this.dBc.setTabTextColors(al.getColor(d.C0141d.cp_cont_j), al.getColor(d.C0141d.cp_cont_b));
        }
        if (this.dBj != null) {
            this.dBj.onChangeSkinType();
        }
        if (!w.z(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void lA(int i) {
        this.ciS = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dBf != null && position >= 0 && position < this.dBf.size() && (dVar = this.dBf.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.jD()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.jr() && dVar.tabId == 89 && this.dBg != null && this.dBg.bvx()) {
                this.dBg.ms(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.dBk != null) {
                this.dBk.eX(dVar.tabId);
            }
            TiebaStatic.log(new am("c12398").ah(ImageViewerConfig.FORUM_ID, this.diZ.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        azD();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dBf != null && position >= 0 && position < this.dBf.size() && (dVar = this.dBf.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").ah(ImageViewerConfig.FORUM_ID, this.diZ.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean a(TabData tabData) {
        if (w.z(tabData)) {
            return false;
        }
        return (!w.z(this.dBf) && tabData.size() == this.dBf.size() && this.dBf.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !ll(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void bf(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    am amVar = new am(str2);
                    amVar.ah("obj_type", host);
                    TiebaStatic.log(amVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b lB(int i) {
        if (i == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Ja() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.diZ != null && FrsTabViewController.this.diZ.atr() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.diZ.atr().auy());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aQP = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.aQW = com.baidu.tbadk.mainTab.c.aQU;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bd(Context context) {
                    return null;
                }
            };
        }
        if (i == 301) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Ja() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.diZ.getForumName());
                    bundle.putString("from", FrsTabViewController.this.diZ.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aQP = frsGoodFragment;
                    cVar.type = 301;
                    cVar.aQW = com.baidu.tbadk.mainTab.c.aQU;
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
                public com.baidu.tbadk.mainTab.c Ja() {
                    FrsDynamicFragment frsDynamicFragment = new FrsDynamicFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.diZ.getForumName());
                    bundle.putString("from", FrsTabViewController.this.diZ.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.diZ.getForumId());
                    frsDynamicFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aQP = frsDynamicFragment;
                    cVar.type = 89;
                    cVar.aQW = com.baidu.tbadk.mainTab.c.aQU;
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

    private void bx(List<FrsTabInfo> list) {
        if (!w.z(list)) {
            this.dBi = new com.baidu.tieba.frs.c(this.diZ.getActivity().getApplicationContext(), list);
            this.dBi.setForumId(this.diZ.getForumId());
            this.dBi.setForumName(this.diZ.getForumName());
            if (this.dBg != null && this.dBg.bam() != null) {
                this.dBi.du(this.dBg.bam().getFirst_class());
                this.dBi.dv(this.dBg.bam().getSecond_class());
            }
            if (this.diZ.atI() != null && this.diZ.atI().bam() != null) {
                this.dBi.setForumGameLabel(this.diZ.atI().bam().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b lB = lB(frsTabInfo.tab_id.intValue());
                if (lB != null) {
                    this.dBi.b(lB);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dBi));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axA() {
        if (this.dBi != null) {
            List<com.baidu.tbadk.mainTab.b> atc = this.dBi.atc();
            if (!w.z(atc) && !w.z(this.dBf)) {
                if (this.dBc.getTabCount() > 0) {
                    this.dBc.removeAllTabs();
                }
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dBf.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, atc);
                    if (c != null) {
                        TbTabLayout.e f = this.dBc.nR().f(dVar.name);
                        boolean z = this.dBg.bvq() == dVar.tabId;
                        if (this.dBg != null && this.dBg.bvx() && dVar.tabId == 89) {
                            f.g(0, true);
                        } else {
                            f.g(0, false);
                        }
                        this.dBc.a(f, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = c;
                        this.mFragments.add(bVar);
                    } else {
                        it.remove();
                    }
                }
                if (this.dBc.getTabCount() > 0 && this.dBb.getVisibility() != 0) {
                    this.dBb.setVisibility(0);
                }
                this.dBh.notifyDataSetChanged();
                this.dBc.setupWithViewPager(this.azf);
                this.azf.setOffscreenPageLimit(this.mFragments.size());
            }
        }
    }

    private Fragment c(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.Jb().type) {
                return bVar.Jb().aQP;
            }
        }
        return null;
    }

    public View azA() {
        if (this.dBj == null) {
            return null;
        }
        return this.dBj.awj();
    }

    public void resetData() {
        this.dBf = null;
        this.dBg = null;
        if (this.dBj != null) {
            this.dBj.resetData();
        }
    }

    public static boolean ll(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.dBk = aVar;
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

    public b azB() {
        if (this.azf == null) {
            return null;
        }
        return (b) w.c(this.mFragments, this.azf.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void azC() {
        this.dBl.aQ(this.diZ.getString(d.k.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void azD() {
        this.dBl.akT();
    }
}
