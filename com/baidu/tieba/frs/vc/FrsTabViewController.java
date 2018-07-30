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
    private BdBaseViewPager azQ;
    private RelativeLayout dGZ;
    private TbTabLayout dHa;
    private RelativeLayout dHb;
    private View dHc;
    private TabData dHd;
    private l dHe;
    private FragmentAdapter dHf;
    private com.baidu.tieba.frs.e dHg;
    private com.baidu.tieba.frs.entelechy.c.a.a dHh;
    private a dHi;
    private com.baidu.tieba.c.d dHj;
    private FrsFragment dnR;
    private List<b> mFragments;
    private int cmX = -1;
    private boolean dHk = false;
    public boolean dHl = true;
    CustomMessageListener dHm = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.dHk) {
                FrsTabViewController.this.ayJ();
                FrsTabViewController.this.dHk = true;
            }
        }
    };
    private CustomMessageListener dHn = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.dHa.getTabCount() > 0 && !w.z(FrsTabViewController.this.dHd)) {
                    FrsTabViewController.this.dHe.mo(true);
                    int min = Math.min(FrsTabViewController.this.dHd.size(), FrsTabViewController.this.dHa.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e aR = FrsTabViewController.this.dHa.aR(i);
                        if (aR != null) {
                            if (FrsTabViewController.this.dHd.get(i).tabId == 89) {
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
    private CustomMessageListener bxx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b aAP;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aAP = FrsTabViewController.this.aAP()) != null && aAP.fragment != null && (aAP.fragment instanceof aj)) {
                        ((aj) aAP.fragment).Ui();
                    }
                }
            }
        }
    };
    private View.OnClickListener dHo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.dHj.akM();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void eZ(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.dnR = frsFragment;
        this.dGZ = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.dHb = new RelativeLayout(this.dnR.getContext());
        this.dHb.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dHc = view.findViewById(d.g.fading_edge_view);
        this.dHa = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.dHa.setOnTabSelectedListener(this);
        this.dHj = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.dHa);
        this.dHj.jp(d.f.bg_tip_blue_up_left);
        this.dHj.jo(16);
        this.dHj.C(true);
        this.dHj.js(com.baidu.adp.lib.util.l.f(frsFragment.getPageContext().getPageActivity(), d.e.tbds34));
        this.dHj.jt(com.baidu.adp.lib.util.l.f(frsFragment.getPageContext().getPageActivity(), d.e.tbds10));
        this.dHj.k(this.dHo);
        this.dHh = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.dHb);
        this.azQ = (BdBaseViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dHf = new FragmentAdapter(this.dnR.getActivity().getSupportFragmentManager(), this.mFragments);
        this.azQ.setAdapter(this.dHf);
        registerListener();
    }

    public void aD(View view) {
        if (isBrandForum()) {
            if ((view instanceof LinearLayout) && this.dHb.getParent() != null) {
                ((LinearLayout) view).removeView(this.dHb);
            }
        } else if ((view instanceof LinearLayout) && this.dHb.getParent() == null) {
            ((LinearLayout) view).addView(this.dHb);
        }
    }

    private boolean isBrandForum() {
        return this.dHe != null && this.dHe.buZ();
    }

    private void registerListener() {
        this.dHm.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dnR.registerListener(this.dHm);
        this.dnR.registerListener(this.dHn);
        this.dnR.registerListener(2001446, this.bxx, this.dnR.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.buA() != null && lVar.buA().tab != null && this.dHl) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.buA().tab) {
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
                            sb.append(lVar.aZl().getId());
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
                        if (com.baidu.tbadk.browser.d.cS(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.avJ().kI(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        z kF = y.avI().kF(dVar5.tabId);
                        if (kF != null && kF.dpy != null && kF.dpy.size() > 0) {
                            dVar5.dFk = new au();
                            dVar5.dFk.dpx = kF.dpx;
                            dVar5.dFk.dpy = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : kF.dpy) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.dpu = xVar.dpu;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.dFk.dpy.add(atVar);
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
                        z kF2 = y.avI().kF(dVar6.tabId);
                        if (kF2 != null && kF2.dpy != null && kF2.dpy.size() > 0) {
                            dVar6.dFk = new au();
                            dVar6.dFk.dpx = kF2.dpx;
                            dVar6.dFk.dpy = new LinkedList();
                            for (x xVar2 : kF2.dpy) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.dpu = xVar2.dpu;
                                    dVar6.dFk.dpy.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.dnR.aum().avu().k(bb.ahB)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (lVar.buc() != 0 && lVar.buc() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + lVar.buc() + ")";
                            }
                            if (this.cmX > 0 && this.cmX != lVar.buc() && this.cmX <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.cmX + ")";
                            } else if (this.cmX > 99 || lVar.buc() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.cmX == 0 && this.cmX != lVar.buc()) {
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
                this.dHe = lVar;
                if (!b(tabData) && this.dHa.getTabCount() > 0 && !w.z(this.dHd)) {
                    int min = Math.min(this.dHd.size(), this.dHa.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aR = this.dHa.aR(i2);
                        if (aR != null) {
                            if (lVar.buB() && this.dHd.get(i2).tabId == 89) {
                                aR.g(0, true);
                            } else {
                                aR.g(0, false);
                            }
                        }
                    }
                }
                if (lVar != null && lVar.buA() != null) {
                    List<FrsTabInfo> list = lVar.buA().menu;
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) w.d(list, 0);
                        if (this.dnR != null && this.dnR.auh() != null && frsTabInfo2 != null) {
                            this.dnR.auh().lt(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.dHh != null && lVar.aZl() != null) {
                        this.dHh.setData(list, i);
                        this.dHh.setFid(lVar.aZl().getId());
                    }
                }
                if (a(tabData)) {
                    this.dHd = tabData;
                    bA(arrayList);
                }
            }
        }
    }

    private boolean a(TabData tabData) {
        if (w.z(tabData)) {
            return false;
        }
        if (!w.z(this.dHf.mFragments) && tabData.size() == this.dHf.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.dHf.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.dHf.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.vc.j
    public boolean lQ(int i) {
        if (i < 0 || this.dHd == null || this.dHd.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dHd.size()) {
                i2 = -1;
                break;
            } else if (this.dHd.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dHa.getTabCount()) {
            return false;
        }
        TbTabLayout.e aR = this.dHa.aR(i2);
        if (aR != null && !aR.isSelected()) {
            aR.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d lR(int i) {
        if (i < 0 || this.dHd == null || this.dHd.size() <= 0) {
            return null;
        }
        Iterator it = this.dHd.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dGZ != null) {
            am.j(this.dGZ, d.C0140d.cp_bg_line_d);
        }
        if (this.dHc != null) {
            am.i(this.dHc, d.f.frs_tab_fading_edge);
        }
        if (this.dHa != null) {
            this.dHa.setSelectedTabIndicatorColor(am.getColor(d.C0140d.cp_cont_f));
            this.dHa.setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_d));
            this.dHa.setTabTextColors(am.getColor(d.C0140d.cp_cont_j), am.getColor(d.C0140d.cp_cont_b));
        }
        if (this.dHh != null && !isBrandForum()) {
            this.dHh.onChangeSkinType();
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
        this.cmX = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dHd != null && position >= 0 && position < this.dHd.size() && (dVar = this.dHd.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.jE()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.js() && dVar.tabId == 89 && this.dHe != null && this.dHe.buB()) {
                this.dHe.mo(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.dHi != null) {
                this.dHi.eZ(dVar.tabId);
            }
            TiebaStatic.log(new an("c12398").af(ImageViewerConfig.FORUM_ID, this.dnR.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        aAR();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dHd != null && position >= 0 && position < this.dHd.size() && (dVar = this.dHd.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new an("c12398").af(ImageViewerConfig.FORUM_ID, this.dnR.forumId).r(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean b(TabData tabData) {
        if (w.z(tabData)) {
            return false;
        }
        return (!w.z(this.dHd) && tabData.size() == this.dHd.size() && this.dHd.containsAll(tabData)) ? false : true;
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
                    anVar.af("obj_type", host);
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
                    if (FrsTabViewController.this.dnR != null && FrsTabViewController.this.dnR.aum() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.dnR.aum().avv());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRL = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.aRS = com.baidu.tbadk.mainTab.c.aRQ;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator be(Context context) {
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
                    bundle.putString("name", FrsTabViewController.this.dnR.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dnR.getFrom());
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
                public TbFragmentTabIndicator be(Context context) {
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
                    bundle.putString("name", FrsTabViewController.this.dnR.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dnR.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dnR.getForumId());
                    frsDynamicFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRL = frsDynamicFragment;
                    cVar.type = 89;
                    cVar.aRS = com.baidu.tbadk.mainTab.c.aRQ;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator be(Context context) {
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
                    bundle.putString("name", FrsTabViewController.this.dnR.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dnR.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dnR.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aRL = frsADFragment;
                    cVar.type = 90;
                    cVar.aRS = com.baidu.tbadk.mainTab.c.aRQ;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator be(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void bA(List<FrsTabInfo> list) {
        if (!w.z(list)) {
            this.dHg = new com.baidu.tieba.frs.e(this.dnR.getActivity().getApplicationContext(), list);
            this.dHg.setForumId(this.dnR.getForumId());
            this.dHg.setForumName(this.dnR.getForumName());
            if (this.dHe != null && this.dHe.aZl() != null) {
                this.dHg.du(this.dHe.aZl().getFirst_class());
                this.dHg.dv(this.dHe.aZl().getSecond_class());
            }
            if (this.dnR.auD() != null && this.dnR.auD().aZl() != null) {
                this.dHg.setForumGameLabel(this.dnR.auD().aZl().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b lT = lT(frsTabInfo.tab_id.intValue());
                if (lT != null) {
                    this.dHg.b(lT);
                }
            }
            this.dHk = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dHg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayJ() {
        int i;
        if (this.dHg != null) {
            List<com.baidu.tbadk.mainTab.b> atX = this.dHg.atX();
            if (!w.z(atX) && !w.z(this.dHd)) {
                if (this.dHa.getTabCount() > 0) {
                    this.dHa.removeAllTabs();
                }
                aAN();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dHd.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, atX);
                    if (c != null) {
                        TbTabLayout.e b2 = this.dHa.nT().b(dVar.name);
                        boolean z = this.dHe.gMn == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.dHe != null && this.dHe.buB() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.dHa.a(b2, z);
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
                if (this.dHa.getTabCount() > 0 && this.dGZ.getVisibility() != 0) {
                    this.dGZ.setVisibility(0);
                }
                this.dHf = new FragmentAdapter(this.dnR.getActivity().getSupportFragmentManager(), this.mFragments);
                this.azQ.setAdapter(this.dHf);
                this.dHf.notifyDataSetChanged();
                this.dHa.setupWithViewPager(this.azQ);
                this.azQ.setOffscreenPageLimit(this.mFragments.size());
                this.azQ.setCurrentItem(i3, false);
            }
        }
    }

    private void aAN() {
        if (this.azQ != null && this.dHf != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.dnR.getActivity().getSupportFragmentManager();
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
                return bVar.Jo().aRL;
            }
        }
        return null;
    }

    public View aAO() {
        if (isBrandForum() || this.dHh == null) {
            return null;
        }
        return this.dHh.axs();
    }

    public void resetData() {
        this.dHe = null;
        registerListener();
        if (this.dHh != null) {
            this.dHh.resetData();
        }
    }

    public static boolean lD(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.dHi = aVar;
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

    public b aAP() {
        if (this.azQ == null) {
            return null;
        }
        return (b) w.d(this.mFragments, this.azQ.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void aAQ() {
        this.dHj.aO(this.dnR.getString(d.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aAR() {
        this.dHj.akM();
    }
}
