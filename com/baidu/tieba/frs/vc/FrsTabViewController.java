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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
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
import com.baidu.tieba.frs.w;
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
    private BdBaseViewPager aqY;
    private FrsFragment cZJ;
    private RelativeLayout drO;
    private TbTabLayout drP;
    private RelativeLayout drQ;
    private View drR;
    private TabData drS;
    private l drT;
    private FragmentAdapter drU;
    private com.baidu.tieba.frs.c drV;
    private com.baidu.tieba.frs.entelechy.c.a.a drW;
    private a drX;
    private com.baidu.tieba.d.c drY;
    private List<b> mFragments;
    private int caO = -1;
    private CustomMessageListener drZ = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.drP.getTabCount() > 0 && !v.w(FrsTabViewController.this.drS)) {
                    FrsTabViewController.this.drT.mm(true);
                    int min = Math.min(FrsTabViewController.this.drS.size(), FrsTabViewController.this.drP.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e aP = FrsTabViewController.this.drP.aP(i);
                        if (aP != null) {
                            if (FrsTabViewController.this.drS.get(i).tabId == 89) {
                                aP.g(0, true);
                            } else {
                                aP.g(0, false);
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bnr = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b avs;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (avs = FrsTabViewController.this.avs()) != null && avs.fragment != null && (avs.fragment instanceof ah)) {
                        ((ah) avs.fragment).Qi();
                    }
                }
            }
        }
    };
    private View.OnClickListener dsa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FrsTabViewController.this.drY.ahf();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void eT(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view2) {
        this.cZJ = frsFragment;
        this.drO = (RelativeLayout) view2.findViewById(d.g.frs_tab_view_container);
        this.drQ = new RelativeLayout(this.cZJ.getContext());
        this.drQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.drR = view2.findViewById(d.g.fading_edge_view);
        this.drP = (TbTabLayout) view2.findViewById(d.g.frs_tab_layout);
        this.drP.setOnTabSelectedListener(this);
        this.drY = new com.baidu.tieba.d.c(frsFragment.getPageContext(), this.drP);
        this.drY.jc(d.f.bg_tip_blue_up_left);
        this.drY.jb(16);
        this.drY.B(true);
        this.drY.jf(com.baidu.adp.lib.util.l.e(frsFragment.getPageContext().getPageActivity(), d.e.tbds34));
        this.drY.jg(com.baidu.adp.lib.util.l.e(frsFragment.getPageContext().getPageActivity(), d.e.tbds10));
        this.drY.j(this.dsa);
        this.drW = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.drQ);
        this.aqY = (BdBaseViewPager) view2.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.drU = new FragmentAdapter(this.cZJ.getActivity().getSupportFragmentManager(), this.mFragments);
        this.aqY.setAdapter(this.drU);
        registerListener();
    }

    public void ay(View view2) {
        if ((view2 instanceof LinearLayout) && this.drQ.getParent() == null) {
            ((LinearLayout) view2).addView(this.drQ);
        }
    }

    private void registerListener() {
        CustomMessageListener customMessageListener = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.c)) {
                    FrsTabViewController.this.att();
                }
            }
        };
        customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.cZJ.registerListener(customMessageListener);
        this.cZJ.registerListener(this.drZ);
        this.cZJ.registerListener(2001446, this.bnr, this.cZJ.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bqw() != null && lVar.bqw().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bqw().tab) {
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
                            sb.append(lVar.aVq().getId());
                            dVar3.url = sb.toString();
                            aY(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && le(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.cu(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.aqF().km(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x kj = w.aqE().kj(dVar5.tabId);
                        if (kj != null && kj.dbj != null && kj.dbj.size() > 0) {
                            dVar5.dpZ = new as();
                            dVar5.dpZ.dbi = kj.dbi;
                            dVar5.dpZ.dbj = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : kj.dbj) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.dbf = vVar.dbf;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.dpZ.dbj.add(arVar);
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
                        x kj2 = w.aqE().kj(dVar6.tabId);
                        if (kj2 != null && kj2.dbj != null && kj2.dbj.size() > 0) {
                            dVar6.dpZ = new as();
                            dVar6.dpZ.dbi = kj2.dbi;
                            dVar6.dpZ.dbj = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : kj2.dbj) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.dbf = vVar2.dbf;
                                    dVar6.dpZ.dbj.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.cZJ.apm().aqs().k(bd.ZL)) {
                        com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                        dVar7.name = frsTabInfo.tab_name;
                        if (lVar.bpX() != 0 && lVar.bpX() <= 99) {
                            dVar7.name = frsTabInfo.tab_name + "(" + lVar.bpX() + ")";
                        }
                        if (this.caO > 0 && this.caO != lVar.bpX() && this.caO <= 99) {
                            dVar7.name = frsTabInfo.tab_name + "(" + this.caO + ")";
                        } else if (this.caO > 99 || lVar.bpX() > 99) {
                            dVar7.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.caO == 0 && this.caO != lVar.bpX()) {
                            dVar7.name = frsTabInfo.tab_name;
                        }
                        dVar7.tabId = frsTabInfo.tab_id.intValue();
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.drT = lVar;
                if (!a(tabData)) {
                    if (this.drP.getTabCount() > 0 && !v.w(this.drS)) {
                        int min = Math.min(this.drS.size(), this.drP.getTabCount());
                        for (int i2 = 0; i2 < min; i2++) {
                            TbTabLayout.e aP = this.drP.aP(i2);
                            if (aP != null) {
                                if (lVar.bqx() && this.drS.get(i2).tabId == 89) {
                                    aP.g(0, true);
                                } else {
                                    aP.g(0, false);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                this.drS = tabData;
                this.drW.setData(lVar.bqw().menu, i);
                if (lVar.aVq() != null) {
                    this.drW.setFid(lVar.aVq().getId());
                }
                bu(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.vc.j
    public boolean lr(int i) {
        if (i < 0 || this.drS == null || this.drS.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.drS.size()) {
                i2 = -1;
                break;
            } else if (this.drS.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.drP.getTabCount()) {
            return false;
        }
        TbTabLayout.e aP = this.drP.aP(i2);
        if (aP != null && !aP.isSelected()) {
            aP.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d ls(int i) {
        if (i < 0 || this.drS == null || this.drS.size() <= 0) {
            return null;
        }
        Iterator it = this.drS.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.drO != null) {
            ak.j(this.drO, d.C0126d.cp_bg_line_d);
        }
        if (this.drR != null) {
            ak.i(this.drR, d.f.frs_tab_fading_edge);
        }
        if (this.drP != null) {
            this.drP.setSelectedTabIndicatorColor(ak.getColor(d.C0126d.cp_cont_f));
            this.drP.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            this.drP.setTabTextColors(ak.getColor(d.C0126d.cp_cont_j), ak.getColor(d.C0126d.cp_cont_b));
        }
        if (this.drW != null) {
            this.drW.onChangeSkinType();
        }
        if (!v.w(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void lt(int i) {
        this.caO = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.drS != null && position >= 0 && position < this.drS.size() && (dVar = this.drS.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.gP()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.gD() && dVar.tabId == 89 && this.drT != null && this.drT.bqx()) {
                this.drT.mm(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.drX != null) {
                this.drX.eT(dVar.tabId);
            }
            TiebaStatic.log(new al("c12398").ac(ImageViewerConfig.FORUM_ID, this.cZJ.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        avu();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.drS != null && position >= 0 && position < this.drS.size() && (dVar = this.drS.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new al("c12398").ac(ImageViewerConfig.FORUM_ID, this.cZJ.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean a(TabData tabData) {
        if (v.w(tabData)) {
            return false;
        }
        return (!v.w(this.drS) && tabData.size() == this.drS.size() && this.drS.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !le(frsTabInfo.tab_id.intValue());
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
                    al alVar = new al(str2);
                    alVar.ac("obj_type", host);
                    TiebaStatic.log(alVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b lu(int i) {
        if (i == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Fv() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.cZJ != null && FrsTabViewController.this.cZJ.apm() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.cZJ.apm().aqt());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aIn = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.aIv = com.baidu.tbadk.mainTab.c.aIt;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator aT(Context context) {
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
                public com.baidu.tbadk.mainTab.c Fv() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.cZJ.getForumName());
                    bundle.putString("from", FrsTabViewController.this.cZJ.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aIn = frsGoodFragment;
                    cVar.type = 301;
                    cVar.aIv = com.baidu.tbadk.mainTab.c.aIt;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator aT(Context context) {
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
                public com.baidu.tbadk.mainTab.c Fv() {
                    FrsDynamicFragment frsDynamicFragment = new FrsDynamicFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.cZJ.getForumName());
                    bundle.putString("from", FrsTabViewController.this.cZJ.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.cZJ.getForumId());
                    frsDynamicFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aIn = frsDynamicFragment;
                    cVar.type = 89;
                    cVar.aIv = com.baidu.tbadk.mainTab.c.aIt;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator aT(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void bu(List<FrsTabInfo> list) {
        if (!v.w(list)) {
            this.drV = new com.baidu.tieba.frs.c(this.cZJ.getActivity().getApplicationContext(), list);
            this.drV.setForumId(this.cZJ.getForumId());
            this.drV.setForumName(this.cZJ.getForumName());
            if (this.drT != null && this.drT.aVq() != null) {
                this.drV.cV(this.drT.aVq().getFirst_class());
                this.drV.cW(this.drT.aVq().getSecond_class());
            }
            if (this.cZJ.apD() != null && this.cZJ.apD().aVq() != null) {
                this.drV.setForumGameLabel(this.cZJ.apD().aVq().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b lu = lu(frsTabInfo.tab_id.intValue());
                if (lu != null) {
                    this.drV.b(lu);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.drV));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void att() {
        if (this.drV != null) {
            List<com.baidu.tbadk.mainTab.b> aoW = this.drV.aoW();
            if (!v.w(aoW) && !v.w(this.drS)) {
                if (this.drP.getTabCount() > 0) {
                    this.drP.removeAllTabs();
                }
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.drS.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, aoW);
                    if (c != null) {
                        TbTabLayout.e f = this.drP.lc().f(dVar.name);
                        boolean z = this.drT.bqq() == dVar.tabId;
                        if (this.drT != null && this.drT.bqx() && dVar.tabId == 89) {
                            f.g(0, true);
                        } else {
                            f.g(0, false);
                        }
                        this.drP.a(f, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = c;
                        this.mFragments.add(bVar);
                    } else {
                        it.remove();
                    }
                }
                if (this.drP.getTabCount() > 0 && this.drO.getVisibility() != 0) {
                    this.drO.setVisibility(0);
                }
                this.drU.notifyDataSetChanged();
                this.drP.setupWithViewPager(this.aqY);
                this.aqY.setOffscreenPageLimit(this.mFragments.size());
            }
        }
    }

    private Fragment c(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.Fw().type) {
                return bVar.Fw().aIn;
            }
        }
        return null;
    }

    public View avr() {
        if (this.drW == null) {
            return null;
        }
        return this.drW.ase();
    }

    public void resetData() {
        this.drS = null;
        this.drT = null;
        if (this.drW != null) {
            this.drW.resetData();
        }
    }

    public static boolean le(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.drX = aVar;
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

    public b avs() {
        if (this.aqY == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.aqY.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void avt() {
        this.drY.aJ(this.cZJ.getString(d.k.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void avu() {
        this.drY.ahf();
    }
}
