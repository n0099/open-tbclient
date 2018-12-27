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
    private FrsFragment dMs;
    private TbTabLayout egA;
    private RelativeLayout egB;
    private FrsTabViewPager egC;
    private View egD;
    private ImageOverlayView egE;
    private TbImageView egF;
    private LinearLayout egG;
    private TabData egH;
    private l egI;
    private FragmentAdapter egJ;
    private com.baidu.tieba.frs.e egK;
    private com.baidu.tieba.frs.entelechy.c.a.a egL;
    private a egM;
    private com.baidu.tieba.c.d egN;
    private RelativeLayout egz;
    private List<b> mFragments;
    private int cHu = -1;
    private boolean egO = false;
    public boolean egP = true;
    CustomMessageListener egQ = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.egO) {
                FrsTabViewController.this.aIi();
                FrsTabViewController.this.egO = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.egC != null) {
                FrsTabViewController.this.egC.aDi();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener egR = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.egA.getTabCount() > 0 && !v.I(FrsTabViewController.this.egH)) {
                    FrsTabViewController.this.egI.ns(true);
                    int min = Math.min(FrsTabViewController.this.egH.size(), FrsTabViewController.this.egA.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e bq = FrsTabViewController.this.egA.bq(i);
                        if (bq != null) {
                            if (FrsTabViewController.this.egH.get(i).tabId == 89) {
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
    private CustomMessageListener bQx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b aIl;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aIl = FrsTabViewController.this.aIl()) != null && aIl.fragment != null && (aIl.fragment instanceof aj)) {
                        ((aj) aIl.fragment).aaY();
                    }
                }
            }
        }
    };
    private View.OnClickListener egS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.egN.asb();
        }
    };
    private View.OnClickListener egT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void fW(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.dMs = frsFragment;
        this.egz = (RelativeLayout) view.findViewById(e.g.frs_tab_view_container);
        this.egB = new RelativeLayout(this.dMs.getContext());
        this.egB.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.egD = view.findViewById(e.g.fading_edge_view);
        this.egA = (TbTabLayout) view.findViewById(e.g.frs_tab_layout);
        this.egA.setOnTabSelectedListener(this);
        this.egE = (ImageOverlayView) view.findViewById(e.g.frs_tab_overlayview);
        this.egG = (LinearLayout) view.findViewById(e.g.frs_tab_arrow);
        this.egF = (TbImageView) view.findViewById(e.g.smartapp_arrow);
        this.egG.setOnClickListener(this.egT);
        this.egN = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.egA);
        this.egN.lh(e.f.bg_tip_blue_up_left);
        this.egN.lg(16);
        this.egN.aa(true);
        this.egN.lk(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.tbds34));
        this.egN.setYOffset(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.tbds10));
        this.egN.n(this.egS);
        this.egL = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.egB);
        this.egC = (FrsTabViewPager) view.findViewById(e.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.egJ = new FragmentAdapter(this.dMs.getActivity().getSupportFragmentManager(), this.mFragments);
        this.egC.setAdapter(this.egJ);
        this.egC.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void aW(View view) {
        if (isBrandForum()) {
            if ((view instanceof LinearLayout) && this.egB.getParent() != null) {
                ((LinearLayout) view).removeView(this.egB);
            }
        } else if ((view instanceof LinearLayout) && this.egB.getParent() == null) {
            ((LinearLayout) view).addView(this.egB);
        }
    }

    private boolean isBrandForum() {
        return this.egI != null && this.egI.bDc();
    }

    public void registerListener() {
        this.egQ.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dMs.registerListener(this.egQ);
        this.dMs.registerListener(this.egR);
        this.dMs.registerListener(2001446, this.bQx, this.dMs.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bCD() != null && lVar.bCD().tab != null) {
            if (lVar != null && !v.I(lVar.hmP)) {
                int size = lVar.hmP.size();
                if (size > 3) {
                    size = 3;
                }
                int h = com.baidu.adp.lib.util.l.h(this.dMs.getPageContext().getPageActivity(), e.C0210e.tbds72);
                this.egE.i(size, h, h, com.baidu.adp.lib.util.l.h(this.dMs.getPageContext().getPageActivity(), e.C0210e.tbds2), e.d.cp_bg_line_d, com.baidu.adp.lib.util.l.h(this.dMs.getPageContext().getPageActivity(), e.C0210e.tbds12));
                this.egE.setData(lVar.hmP);
                this.egG.setVisibility(0);
            } else {
                this.egG.setVisibility(8);
            }
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bCD().tab) {
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
                            sb.append(lVar.bgT().getId());
                            dVar3.url = sb.toString();
                            bG(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && ny(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.dT(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.aDh().mD(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        z mA = y.aDg().mA(dVar5.tabId);
                        if (mA != null && mA.dOh != null && mA.dOh.size() > 0) {
                            dVar5.eeL = new au();
                            dVar5.eeL.dOg = mA.dOg;
                            dVar5.eeL.dOh = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : mA.dOh) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.dOd = xVar.dOd;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.eeL.dOh.add(atVar);
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
                        z mA2 = y.aDg().mA(dVar6.tabId);
                        if (mA2 != null && mA2.dOh != null && mA2.dOh.size() > 0) {
                            dVar6.eeL = new au();
                            dVar6.eeL.dOg = mA2.dOg;
                            dVar6.eeL.dOh = new LinkedList();
                            for (x xVar2 : mA2.dOh) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.dOd = xVar2.dOd;
                                    dVar6.eeL.dOh.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.dMs.aBx().aCE().k(bb.atk)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (lVar.bCf() != 0 && lVar.bCf() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + lVar.bCf() + ")";
                            }
                            if (this.cHu > 0 && this.cHu != lVar.bCf() && this.cHu <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.cHu + ")";
                            } else if (this.cHu > 99 || lVar.bCf() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.cHu == 0 && this.cHu != lVar.bCf()) {
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
                this.egI = lVar;
                if (!b(tabData) && this.egA.getTabCount() > 0 && !v.I(this.egH)) {
                    int min = Math.min(this.egH.size(), this.egA.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e bq = this.egA.bq(i2);
                        if (bq != null) {
                            if (lVar.bCE() && this.egH.get(i2).tabId == 89) {
                                bq.g(0, true);
                            } else {
                                bq.g(0, false);
                            }
                        }
                    }
                }
                if (lVar != null && lVar.bCD() != null) {
                    List<FrsTabInfo> list = lVar.bCD().menu;
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.d(list, 0);
                        if (this.dMs != null && this.dMs.aBs() != null && frsTabInfo2 != null) {
                            this.dMs.aBs().no(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.egL != null && lVar.bgT() != null) {
                        this.egL.setData(list, i);
                        this.egL.setFid(lVar.bgT().getId());
                    }
                }
                if (a(tabData)) {
                    this.egH = tabData;
                    bS(arrayList);
                }
            }
        }
    }

    private boolean a(TabData tabData) {
        if (v.I(tabData)) {
            return false;
        }
        if (!v.I(this.egJ.mFragments) && tabData.size() == this.egJ.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.egJ.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.egJ.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.vc.k
    public boolean nL(int i) {
        if (i < 0 || this.egH == null || this.egH.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.egH.size()) {
                i2 = -1;
                break;
            } else if (this.egH.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.egA.getTabCount()) {
            return false;
        }
        TbTabLayout.e bq = this.egA.bq(i2);
        if (bq != null && !bq.isSelected()) {
            bq.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d nM(int i) {
        if (i < 0 || this.egH == null || this.egH.size() <= 0) {
            return null;
        }
        Iterator it = this.egH.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.egz != null) {
            al.j(this.egz, e.d.cp_bg_line_d);
        }
        if (this.egD != null) {
            al.i(this.egD, e.f.frs_tab_fading_edge);
        }
        if (this.egA != null) {
            this.egA.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.egA.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            this.egA.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
        if (this.egL != null && !isBrandForum()) {
            this.egL.onChangeSkinType();
        }
        if (this.egE != null) {
            this.egE.onChangeSkinType();
        }
        if (this.egF != null) {
            al.b((ImageView) this.egF, e.f.icon_arrow12_gray60_right, i);
        }
        if (!v.I(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void nN(int i) {
        this.cHu = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.egH != null && position >= 0 && position < this.egH.size() && (dVar = this.egH.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kV()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.kK() && dVar.tabId == 89 && this.egI != null && this.egI.bCE()) {
                this.egI.ns(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.egM != null) {
                this.egM.fW(dVar.tabId);
            }
            TiebaStatic.log(new am("c12398").aA(ImageViewerConfig.FORUM_ID, this.dMs.forumId).x(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        aIn();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.egH != null && position >= 0 && position < this.egH.size() && (dVar = this.egH.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").aA(ImageViewerConfig.FORUM_ID, this.dMs.forumId).x(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean b(TabData tabData) {
        if (v.I(tabData)) {
            return false;
        }
        return (!v.I(this.egH) && tabData.size() == this.egH.size() && this.egH.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !ny(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void bG(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    am amVar = new am(str2);
                    amVar.aA("obj_type", host);
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
                public com.baidu.tbadk.mainTab.c NP() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.dMs != null && FrsTabViewController.this.dMs.aBx() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.dMs.aBx().aCG());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bdN = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.bdT = com.baidu.tbadk.mainTab.c.bdQ;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bR(Context context) {
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
                public com.baidu.tbadk.mainTab.c NP() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dMs.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dMs.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bdN = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.bdT = com.baidu.tbadk.mainTab.c.bdQ;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bR(Context context) {
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
                public com.baidu.tbadk.mainTab.c NP() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dMs.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dMs.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dMs.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bdN = frsADFragment;
                    cVar.type = 90;
                    cVar.bdT = com.baidu.tbadk.mainTab.c.bdQ;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bR(Context context) {
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
                public com.baidu.tbadk.mainTab.c NP() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dMs.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dMs.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dMs.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.egI.hmN);
                    bundle.putBoolean("need_log", FrsTabViewController.this.egI.hlK == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.egI.isBrandForum);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bdN = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.bdT = com.baidu.tbadk.mainTab.c.bdQ;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bR(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void bS(List<FrsTabInfo> list) {
        if (!v.I(list)) {
            this.egK = new com.baidu.tieba.frs.e(this.dMs.getActivity().getApplicationContext(), list);
            this.egK.setForumId(this.dMs.getForumId());
            this.egK.setForumName(this.dMs.getForumName());
            if (this.egI != null && this.egI.bgT() != null) {
                this.egK.eu(this.egI.bgT().getFirst_class());
                this.egK.ev(this.egI.bgT().getSecond_class());
                this.egK.setForumGameLabel(this.egI.bgT().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.egK.b(c);
                }
            }
            this.egO = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.egK));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIi() {
        int i;
        if (this.egK != null) {
            List<com.baidu.tbadk.mainTab.b> aBg = this.egK.aBg();
            if (!v.I(aBg) && !v.I(this.egH)) {
                if (this.egA.getTabCount() > 0) {
                    this.egA.removeAllTabs();
                }
                aIj();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.egH.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, aBg);
                    if (c != null) {
                        TbTabLayout.e b2 = this.egA.pc().b(dVar.name);
                        boolean z = this.egI.hmO == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.egI != null && this.egI.bCE() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.egA.a(b2, z);
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
                if (this.egA.getTabCount() > 0 && this.egz.getVisibility() != 0) {
                    this.egz.setVisibility(0);
                }
                this.egJ = new FragmentAdapter(this.dMs.getActivity().getSupportFragmentManager(), this.mFragments);
                this.egC.setAdapter(this.egJ);
                this.egJ.notifyDataSetChanged();
                this.egA.setupWithViewPager(this.egC);
                this.egC.setOffscreenPageLimit(this.mFragments.size());
                this.egC.setCurrentItem(i3, false);
                this.egC.aDi();
            }
        }
    }

    private void aIj() {
        if (this.egC != null && this.egJ != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.dMs.getActivity().getSupportFragmentManager();
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
            if (i == bVar.NQ().type) {
                return bVar.NQ().bdN;
            }
        }
        return null;
    }

    public View aIk() {
        if (isBrandForum() || this.egL == null) {
            return null;
        }
        return this.egL.aET();
    }

    public static boolean ny(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.egM = aVar;
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

    public b aIl() {
        if (this.egC == null) {
            return null;
        }
        return (b) v.d(this.mFragments, this.egC.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void aIm() {
        this.egN.bo(this.dMs.getString(e.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aIn() {
        this.egN.asb();
    }
}
