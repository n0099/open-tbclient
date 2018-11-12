package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.ImageOverlayView;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.webkit.internal.ETAG;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes6.dex */
public class FrsTabViewController implements TbTabLayout.b, k {
    private static final String TAG = FrsTabViewController.class.getSimpleName();
    private FrsFragment dDf;
    private RelativeLayout dXe;
    private TbTabLayout dXf;
    private RelativeLayout dXg;
    private FrsTabViewPager dXh;
    private View dXi;
    private ImageOverlayView dXj;
    private TbImageView dXk;
    private LinearLayout dXl;
    private TabData dXm;
    private l dXn;
    private FragmentAdapter dXo;
    private com.baidu.tieba.frs.e dXp;
    private com.baidu.tieba.frs.entelechy.c.a.a dXq;
    private a dXr;
    private com.baidu.tieba.c.d dXs;
    private List<b> mFragments;
    private int cCx = -1;
    private boolean dXt = false;
    public boolean dXu = true;
    CustomMessageListener dXv = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.dXt) {
                FrsTabViewController.this.aFH();
                FrsTabViewController.this.dXt = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.dXh != null) {
                FrsTabViewController.this.dXh.aAJ();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener dXw = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.dXf.getTabCount() > 0 && !v.I(FrsTabViewController.this.dXm)) {
                    FrsTabViewController.this.dXn.nn(true);
                    int min = Math.min(FrsTabViewController.this.dXm.size(), FrsTabViewController.this.dXf.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e bq = FrsTabViewController.this.dXf.bq(i);
                        if (bq != null) {
                            if (FrsTabViewController.this.dXm.get(i).tabId == 89) {
                                bq.g(0, true);
                            } else {
                                bq.g(0, false);
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bME = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b aFK;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aFK = FrsTabViewController.this.aFK()) != null && aFK.fragment != null && (aFK.fragment instanceof aj)) {
                        ((aj) aFK.fragment).ZQ();
                    }
                }
            }
        }
    };
    private View.OnClickListener dXx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.dXs.apA();
        }
    };
    private View.OnClickListener dXy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void fH(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.dDf = frsFragment;
        this.dXe = (RelativeLayout) view.findViewById(e.g.frs_tab_view_container);
        this.dXg = new RelativeLayout(this.dDf.getContext());
        this.dXg.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dXi = view.findViewById(e.g.fading_edge_view);
        this.dXf = (TbTabLayout) view.findViewById(e.g.frs_tab_layout);
        this.dXf.setOnTabSelectedListener(this);
        this.dXj = (ImageOverlayView) view.findViewById(e.g.frs_tab_overlayview);
        this.dXl = (LinearLayout) view.findViewById(e.g.frs_tab_arrow);
        this.dXk = (TbImageView) view.findViewById(e.g.smartapp_arrow);
        this.dXl.setOnClickListener(this.dXy);
        this.dXs = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.dXf);
        this.dXs.kE(e.f.bg_tip_blue_up_left);
        this.dXs.kD(16);
        this.dXs.aa(true);
        this.dXs.kH(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0200e.tbds34));
        this.dXs.setYOffset(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0200e.tbds10));
        this.dXs.n(this.dXx);
        this.dXq = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.dXg);
        this.dXh = (FrsTabViewPager) view.findViewById(e.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dXo = new FragmentAdapter(this.dDf.getActivity().getSupportFragmentManager(), this.mFragments);
        this.dXh.setAdapter(this.dXo);
        this.dXh.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void aT(View view) {
        if (isBrandForum()) {
            if ((view instanceof LinearLayout) && this.dXg.getParent() != null) {
                ((LinearLayout) view).removeView(this.dXg);
            }
        } else if ((view instanceof LinearLayout) && this.dXg.getParent() == null) {
            ((LinearLayout) view).addView(this.dXg);
        }
    }

    private boolean isBrandForum() {
        return this.dXn != null && this.dXn.bAr();
    }

    public void registerListener() {
        this.dXv.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dDf.registerListener(this.dXv);
        this.dDf.registerListener(this.dXw);
        this.dDf.registerListener(2001446, this.bME, this.dDf.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bzS() != null && lVar.bzS().tab != null) {
            if (lVar != null && !v.I(lVar.hcL)) {
                int size = lVar.hcL.size();
                if (size > 3) {
                    size = 3;
                }
                int h = com.baidu.adp.lib.util.l.h(this.dDf.getPageContext().getPageActivity(), e.C0200e.tbds72);
                this.dXj.i(size, h, h, com.baidu.adp.lib.util.l.h(this.dDf.getPageContext().getPageActivity(), e.C0200e.tbds2), e.d.cp_bg_line_d, com.baidu.adp.lib.util.l.h(this.dDf.getPageContext().getPageActivity(), e.C0200e.tbds12));
                this.dXj.setData(lVar.hcL);
                this.dXl.setVisibility(0);
            } else {
                this.dXl.setVisibility(8);
            }
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bzS().tab) {
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
                            sb.append(ETAG.ITEM_SEPARATOR);
                            sb.append(ImageViewerConfig.FORUM_ID);
                            sb.append(ETAG.EQUAL);
                            sb.append(lVar.ber().getId());
                            dVar3.url = sb.toString();
                            bB(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && mV(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.dB(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.aAI().ma(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        z lX = y.aAH().lX(dVar5.tabId);
                        if (lX != null && lX.dEU != null && lX.dEU.size() > 0) {
                            dVar5.dVr = new au();
                            dVar5.dVr.dET = lX.dET;
                            dVar5.dVr.dEU = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : lX.dEU) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.dEQ = xVar.dEQ;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.dVr.dEU.add(atVar);
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
                        z lX2 = y.aAH().lX(dVar6.tabId);
                        if (lX2 != null && lX2.dEU != null && lX2.dEU.size() > 0) {
                            dVar6.dVr = new au();
                            dVar6.dVr.dET = lX2.dET;
                            dVar6.dVr.dEU = new LinkedList();
                            for (x xVar2 : lX2.dEU) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.dEQ = xVar2.dEQ;
                                    dVar6.dVr.dEU.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.dDf.ayY().aAf().k(bb.apK)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (lVar.bzu() != 0 && lVar.bzu() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + lVar.bzu() + ")";
                            }
                            if (this.cCx > 0 && this.cCx != lVar.bzu() && this.cCx <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.cCx + ")";
                            } else if (this.cCx > 99 || lVar.bzu() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.cCx == 0 && this.cCx != lVar.bzu()) {
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
                    } else if (frsTabInfo.tab_type.intValue() == 91) {
                        com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                        dVar9.tabId = frsTabInfo.tab_id.intValue();
                        dVar9.name = ao.d(frsTabInfo.tab_name, 8, (String) null);
                        tabData.add(dVar9);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.dXn = lVar;
                if (!b(tabData) && this.dXf.getTabCount() > 0 && !v.I(this.dXm)) {
                    int min = Math.min(this.dXm.size(), this.dXf.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e bq = this.dXf.bq(i2);
                        if (bq != null) {
                            if (lVar.bzT() && this.dXm.get(i2).tabId == 89) {
                                bq.g(0, true);
                            } else {
                                bq.g(0, false);
                            }
                        }
                    }
                }
                if (lVar != null && lVar.bzS() != null) {
                    List<FrsTabInfo> list = lVar.bzS().menu;
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.d(list, 0);
                        if (this.dDf != null && this.dDf.ayT() != null && frsTabInfo2 != null) {
                            this.dDf.ayT().mL(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.dXq != null && lVar.ber() != null) {
                        this.dXq.setData(list, i);
                        this.dXq.setFid(lVar.ber().getId());
                    }
                }
                if (a(tabData)) {
                    this.dXm = tabData;
                    bP(arrayList);
                }
            }
        }
    }

    private boolean a(TabData tabData) {
        if (v.I(tabData)) {
            return false;
        }
        if (!v.I(this.dXo.mFragments) && tabData.size() == this.dXo.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.dXo.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.dXo.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.vc.k
    public boolean ni(int i) {
        if (i < 0 || this.dXm == null || this.dXm.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dXm.size()) {
                i2 = -1;
                break;
            } else if (this.dXm.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dXf.getTabCount()) {
            return false;
        }
        TbTabLayout.e bq = this.dXf.bq(i2);
        if (bq != null && !bq.isSelected()) {
            bq.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d nj(int i) {
        if (i < 0 || this.dXm == null || this.dXm.size() <= 0) {
            return null;
        }
        Iterator it = this.dXm.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dXe != null) {
            al.j(this.dXe, e.d.cp_bg_line_d);
        }
        if (this.dXi != null) {
            al.i(this.dXi, e.f.frs_tab_fading_edge);
        }
        if (this.dXf != null) {
            this.dXf.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.dXf.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            this.dXf.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
        if (this.dXq != null && !isBrandForum()) {
            this.dXq.onChangeSkinType();
        }
        if (this.dXj != null) {
            this.dXj.onChangeSkinType();
        }
        if (this.dXk != null) {
            al.b((ImageView) this.dXk, e.f.icon_arrow12_gray60_right, i);
        }
        if (!v.I(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void nk(int i) {
        this.cCx = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dXm != null && position >= 0 && position < this.dXm.size() && (dVar = this.dXm.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kV()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.kK() && dVar.tabId == 89 && this.dXn != null && this.dXn.bzT()) {
                this.dXn.nn(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.dXr != null) {
                this.dXr.fH(dVar.tabId);
            }
            TiebaStatic.log(new am("c12398").ax(ImageViewerConfig.FORUM_ID, this.dDf.forumId).x(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        aFM();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dXm != null && position >= 0 && position < this.dXm.size() && (dVar = this.dXm.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").ax(ImageViewerConfig.FORUM_ID, this.dDf.forumId).x(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean b(TabData tabData) {
        if (v.I(tabData)) {
            return false;
        }
        return (!v.I(this.dXm) && tabData.size() == this.dXm.size() && this.dXm.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !mV(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void bB(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    am amVar = new am(str2);
                    amVar.ax("obj_type", host);
                    TiebaStatic.log(amVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b c(FrsTabInfo frsTabInfo) {
        final int intValue = frsTabInfo.tab_id.intValue();
        if (intValue == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MK() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.dDf != null && FrsTabViewController.this.dDf.ayY() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.dDf.ayY().aAh());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bam = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.bat = com.baidu.tbadk.mainTab.c.bap;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bO(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 301 || intValue == 303) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MK() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dDf.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dDf.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bam = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.bat = com.baidu.tbadk.mainTab.c.bap;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bO(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 90) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MK() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dDf.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dDf.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dDf.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bam = frsADFragment;
                    cVar.type = 90;
                    cVar.bat = com.baidu.tbadk.mainTab.c.bap;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bO(Context context) {
                    return null;
                }
            };
        }
        if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MK() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dDf.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dDf.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dDf.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.dXn.hcJ);
                    bundle.putBoolean("need_log", FrsTabViewController.this.dXn.hbG == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.dXn.isBrandForum);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bam = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.bat = com.baidu.tbadk.mainTab.c.bap;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bO(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void bP(List<FrsTabInfo> list) {
        if (!v.I(list)) {
            this.dXp = new com.baidu.tieba.frs.e(this.dDf.getActivity().getApplicationContext(), list);
            this.dXp.setForumId(this.dDf.getForumId());
            this.dXp.setForumName(this.dDf.getForumName());
            if (this.dXn != null && this.dXn.ber() != null) {
                this.dXp.ec(this.dXn.ber().getFirst_class());
                this.dXp.ed(this.dXn.ber().getSecond_class());
                this.dXp.setForumGameLabel(this.dXn.ber().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.dXp.b(c);
                }
            }
            this.dXt = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dXp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFH() {
        int i;
        if (this.dXp != null) {
            List<com.baidu.tbadk.mainTab.b> ayH = this.dXp.ayH();
            if (!v.I(ayH) && !v.I(this.dXm)) {
                if (this.dXf.getTabCount() > 0) {
                    this.dXf.removeAllTabs();
                }
                aFI();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dXm.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, ayH);
                    if (c != null) {
                        TbTabLayout.e b2 = this.dXf.pd().b(dVar.name);
                        boolean z = this.dXn.hcK == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.dXn != null && this.dXn.bzT() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.dXf.a(b2, z);
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
                if (this.dXf.getTabCount() > 0 && this.dXe.getVisibility() != 0) {
                    this.dXe.setVisibility(0);
                }
                this.dXo = new FragmentAdapter(this.dDf.getActivity().getSupportFragmentManager(), this.mFragments);
                this.dXh.setAdapter(this.dXo);
                this.dXo.notifyDataSetChanged();
                this.dXf.setupWithViewPager(this.dXh);
                this.dXh.setOffscreenPageLimit(this.mFragments.size());
                this.dXh.setCurrentItem(i3, false);
                this.dXh.aAJ();
            }
        }
    }

    private void aFI() {
        if (this.dXh != null && this.dXo != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.dDf.getActivity().getSupportFragmentManager();
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
            if (i == bVar.ML().type) {
                return bVar.ML().bam;
            }
        }
        return null;
    }

    public View aFJ() {
        if (isBrandForum() || this.dXq == null) {
            return null;
        }
        return this.dXq.aCs();
    }

    public static boolean mV(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.dXr = aVar;
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public String title;

        public b() {
        }
    }

    public b aFK() {
        if (this.dXh == null) {
            return null;
        }
        return (b) v.d(this.mFragments, this.dXh.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void aFL() {
        this.dXs.bj(this.dDf.getString(e.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aFM() {
        this.dXs.apA();
    }
}
