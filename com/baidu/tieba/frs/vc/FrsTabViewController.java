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
    private FrsFragment cYF;
    private RelativeLayout dqJ;
    private TbTabLayout dqK;
    private RelativeLayout dqL;
    private View dqM;
    private TabData dqN;
    private l dqO;
    private FragmentAdapter dqP;
    private com.baidu.tieba.frs.c dqQ;
    private com.baidu.tieba.frs.entelechy.c.a.a dqR;
    private a dqS;
    private com.baidu.tieba.d.c dqT;
    private List<b> mFragments;
    private int bZW = -1;
    private CustomMessageListener dqU = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.dqK.getTabCount() > 0 && !v.w(FrsTabViewController.this.dqN)) {
                    FrsTabViewController.this.dqO.ml(true);
                    int min = Math.min(FrsTabViewController.this.dqN.size(), FrsTabViewController.this.dqK.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e aP = FrsTabViewController.this.dqK.aP(i);
                        if (aP != null) {
                            if (FrsTabViewController.this.dqN.get(i).tabId == 89) {
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
    private CustomMessageListener bnc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b avt;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (avt = FrsTabViewController.this.avt()) != null && avt.fragment != null && (avt.fragment instanceof ah)) {
                        ((ah) avt.fragment).Ql();
                    }
                }
            }
        }
    };
    private View.OnClickListener dqV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FrsTabViewController.this.dqT.ahf();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void eT(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view2) {
        this.cYF = frsFragment;
        this.dqJ = (RelativeLayout) view2.findViewById(d.g.frs_tab_view_container);
        this.dqL = new RelativeLayout(this.cYF.getContext());
        this.dqL.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dqM = view2.findViewById(d.g.fading_edge_view);
        this.dqK = (TbTabLayout) view2.findViewById(d.g.frs_tab_layout);
        this.dqK.setOnTabSelectedListener(this);
        this.dqT = new com.baidu.tieba.d.c(frsFragment.getPageContext(), this.dqK);
        this.dqT.je(d.f.bg_tip_blue_up_left);
        this.dqT.jd(16);
        this.dqT.B(true);
        this.dqT.jh(com.baidu.adp.lib.util.l.e(frsFragment.getPageContext().getPageActivity(), d.e.tbds34));
        this.dqT.ji(com.baidu.adp.lib.util.l.e(frsFragment.getPageContext().getPageActivity(), d.e.tbds10));
        this.dqT.j(this.dqV);
        this.dqR = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.dqL);
        this.aqY = (BdBaseViewPager) view2.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dqP = new FragmentAdapter(this.cYF.getActivity().getSupportFragmentManager(), this.mFragments);
        this.aqY.setAdapter(this.dqP);
        registerListener();
    }

    public void ay(View view2) {
        if ((view2 instanceof LinearLayout) && this.dqL.getParent() == null) {
            ((LinearLayout) view2).addView(this.dqL);
        }
    }

    private void registerListener() {
        CustomMessageListener customMessageListener = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.c)) {
                    FrsTabViewController.this.atu();
                }
            }
        };
        customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.cYF.registerListener(customMessageListener);
        this.cYF.registerListener(this.dqU);
        this.cYF.registerListener(2001446, this.bnc, this.cYF.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bqy() != null && lVar.bqy().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bqy().tab) {
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
                    } else if (frsTabInfo.tab_type.intValue() == 11 && lg(frsTabInfo.tab_id.intValue())) {
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.aqG().ko(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x kl = w.aqF().kl(dVar5.tabId);
                        if (kl != null && kl.dad != null && kl.dad.size() > 0) {
                            dVar5.doU = new as();
                            dVar5.doU.dac = kl.dac;
                            dVar5.doU.dad = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : kl.dad) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.cZZ = vVar.cZZ;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.doU.dad.add(arVar);
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
                        x kl2 = w.aqF().kl(dVar6.tabId);
                        if (kl2 != null && kl2.dad != null && kl2.dad.size() > 0) {
                            dVar6.doU = new as();
                            dVar6.doU.dac = kl2.dac;
                            dVar6.doU.dad = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : kl2.dad) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.cZZ = vVar2.cZZ;
                                    dVar6.doU.dad.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.cYF.apn().aqt().k(bd.ZL)) {
                        com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                        dVar7.name = frsTabInfo.tab_name;
                        if (lVar.bpZ() != 0 && lVar.bpZ() <= 99) {
                            dVar7.name = frsTabInfo.tab_name + "(" + lVar.bpZ() + ")";
                        }
                        if (this.bZW > 0 && this.bZW != lVar.bpZ() && this.bZW <= 99) {
                            dVar7.name = frsTabInfo.tab_name + "(" + this.bZW + ")";
                        } else if (this.bZW > 99 || lVar.bpZ() > 99) {
                            dVar7.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.bZW == 0 && this.bZW != lVar.bpZ()) {
                            dVar7.name = frsTabInfo.tab_name;
                        }
                        dVar7.tabId = frsTabInfo.tab_id.intValue();
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.dqO = lVar;
                if (!a(tabData)) {
                    if (this.dqK.getTabCount() > 0 && !v.w(this.dqN)) {
                        int min = Math.min(this.dqN.size(), this.dqK.getTabCount());
                        for (int i2 = 0; i2 < min; i2++) {
                            TbTabLayout.e aP = this.dqK.aP(i2);
                            if (aP != null) {
                                if (lVar.bqz() && this.dqN.get(i2).tabId == 89) {
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
                this.dqN = tabData;
                this.dqR.setData(lVar.bqy().menu, i);
                if (lVar.aVq() != null) {
                    this.dqR.setFid(lVar.aVq().getId());
                }
                br(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.vc.j
    public boolean lt(int i) {
        if (i < 0 || this.dqN == null || this.dqN.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dqN.size()) {
                i2 = -1;
                break;
            } else if (this.dqN.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dqK.getTabCount()) {
            return false;
        }
        TbTabLayout.e aP = this.dqK.aP(i2);
        if (aP != null && !aP.isSelected()) {
            aP.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d lu(int i) {
        if (i < 0 || this.dqN == null || this.dqN.size() <= 0) {
            return null;
        }
        Iterator it = this.dqN.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dqJ != null) {
            ak.j(this.dqJ, d.C0126d.cp_bg_line_d);
        }
        if (this.dqM != null) {
            ak.i(this.dqM, d.f.frs_tab_fading_edge);
        }
        if (this.dqK != null) {
            this.dqK.setSelectedTabIndicatorColor(ak.getColor(d.C0126d.cp_cont_f));
            this.dqK.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            this.dqK.setTabTextColors(ak.getColor(d.C0126d.cp_cont_j), ak.getColor(d.C0126d.cp_cont_b));
        }
        if (this.dqR != null) {
            this.dqR.onChangeSkinType();
        }
        if (!v.w(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void lv(int i) {
        this.bZW = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dqN != null && position >= 0 && position < this.dqN.size() && (dVar = this.dqN.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.gP()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.gD() && dVar.tabId == 89 && this.dqO != null && this.dqO.bqz()) {
                this.dqO.ml(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.dqS != null) {
                this.dqS.eT(dVar.tabId);
            }
            TiebaStatic.log(new al("c12398").ac(ImageViewerConfig.FORUM_ID, this.cYF.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        avv();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dqN != null && position >= 0 && position < this.dqN.size() && (dVar = this.dqN.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new al("c12398").ac(ImageViewerConfig.FORUM_ID, this.cYF.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean a(TabData tabData) {
        if (v.w(tabData)) {
            return false;
        }
        return (!v.w(this.dqN) && tabData.size() == this.dqN.size() && this.dqN.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !lg(frsTabInfo.tab_id.intValue());
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

    private com.baidu.tbadk.mainTab.b lw(int i) {
        if (i == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c Fx() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.cYF != null && FrsTabViewController.this.cYF.apn() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.cYF.apn().aqu());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aIm = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.aIu = com.baidu.tbadk.mainTab.c.aIs;
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
                public com.baidu.tbadk.mainTab.c Fx() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.cYF.getForumName());
                    bundle.putString("from", FrsTabViewController.this.cYF.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aIm = frsGoodFragment;
                    cVar.type = 301;
                    cVar.aIu = com.baidu.tbadk.mainTab.c.aIs;
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
                public com.baidu.tbadk.mainTab.c Fx() {
                    FrsDynamicFragment frsDynamicFragment = new FrsDynamicFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.cYF.getForumName());
                    bundle.putString("from", FrsTabViewController.this.cYF.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.cYF.getForumId());
                    frsDynamicFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aIm = frsDynamicFragment;
                    cVar.type = 89;
                    cVar.aIu = com.baidu.tbadk.mainTab.c.aIs;
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

    private void br(List<FrsTabInfo> list) {
        if (!v.w(list)) {
            this.dqQ = new com.baidu.tieba.frs.c(this.cYF.getActivity().getApplicationContext(), list);
            this.dqQ.setForumId(this.cYF.getForumId());
            this.dqQ.setForumName(this.cYF.getForumName());
            if (this.dqO != null && this.dqO.aVq() != null) {
                this.dqQ.cV(this.dqO.aVq().getFirst_class());
                this.dqQ.cW(this.dqO.aVq().getSecond_class());
            }
            if (this.cYF.apE() != null && this.cYF.apE().aVq() != null) {
                this.dqQ.setForumGameLabel(this.cYF.apE().aVq().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b lw = lw(frsTabInfo.tab_id.intValue());
                if (lw != null) {
                    this.dqQ.b(lw);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dqQ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atu() {
        if (this.dqQ != null) {
            List<com.baidu.tbadk.mainTab.b> aoX = this.dqQ.aoX();
            if (!v.w(aoX) && !v.w(this.dqN)) {
                if (this.dqK.getTabCount() > 0) {
                    this.dqK.removeAllTabs();
                }
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dqN.iterator();
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, aoX);
                    if (c != null) {
                        TbTabLayout.e f = this.dqK.ld().f(dVar.name);
                        boolean z = this.dqO.bqs() == dVar.tabId;
                        if (this.dqO != null && this.dqO.bqz() && dVar.tabId == 89) {
                            f.g(0, true);
                        } else {
                            f.g(0, false);
                        }
                        this.dqK.a(f, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = c;
                        this.mFragments.add(bVar);
                    } else {
                        it.remove();
                    }
                }
                if (this.dqK.getTabCount() > 0 && this.dqJ.getVisibility() != 0) {
                    this.dqJ.setVisibility(0);
                }
                this.dqP.notifyDataSetChanged();
                this.dqK.setupWithViewPager(this.aqY);
                this.aqY.setOffscreenPageLimit(this.mFragments.size());
            }
        }
    }

    private Fragment c(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.Fy().type) {
                return bVar.Fy().aIm;
            }
        }
        return null;
    }

    public View avs() {
        if (this.dqR == null) {
            return null;
        }
        return this.dqR.asf();
    }

    public void resetData() {
        this.dqN = null;
        this.dqO = null;
        if (this.dqR != null) {
            this.dqR.resetData();
        }
    }

    public static boolean lg(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.dqS = aVar;
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

    public b avt() {
        if (this.aqY == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.aqY.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void avu() {
        this.dqT.aJ(this.cYF.getString(d.k.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void avv() {
        this.dqT.ahf();
    }
}
