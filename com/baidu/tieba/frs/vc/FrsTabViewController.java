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
    private FrsFragment dNc;
    private RelativeLayout ehg;
    private TbTabLayout ehh;
    private RelativeLayout ehi;
    private FrsTabViewPager ehj;
    private View ehk;
    private ImageOverlayView ehl;
    private TbImageView ehm;
    private LinearLayout ehn;
    private TabData eho;
    private l ehp;
    private FragmentAdapter ehq;
    private com.baidu.tieba.frs.e ehr;
    private com.baidu.tieba.frs.entelechy.c.a.a ehs;
    private a eht;
    private com.baidu.tieba.c.d ehu;
    private List<b> mFragments;
    private int cIg = -1;
    private boolean ehv = false;
    public boolean ehw = true;
    CustomMessageListener ehx = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.ehv) {
                FrsTabViewController.this.aIF();
                FrsTabViewController.this.ehv = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.ehj != null) {
                FrsTabViewController.this.ehj.aDF();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener ehy = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.ehh.getTabCount() > 0 && !v.I(FrsTabViewController.this.eho)) {
                    FrsTabViewController.this.ehp.nt(true);
                    int min = Math.min(FrsTabViewController.this.eho.size(), FrsTabViewController.this.ehh.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e bq = FrsTabViewController.this.ehh.bq(i);
                        if (bq != null) {
                            if (FrsTabViewController.this.eho.get(i).tabId == 89) {
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
    private CustomMessageListener bRj = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b aII;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aII = FrsTabViewController.this.aII()) != null && aII.fragment != null && (aII.fragment instanceof aj)) {
                        ((aj) aII.fragment).abv();
                    }
                }
            }
        }
    };
    private View.OnClickListener ehz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.ehu.asz();
        }
    };
    private View.OnClickListener ehA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
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
        this.dNc = frsFragment;
        this.ehg = (RelativeLayout) view.findViewById(e.g.frs_tab_view_container);
        this.ehi = new RelativeLayout(this.dNc.getContext());
        this.ehi.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.ehk = view.findViewById(e.g.fading_edge_view);
        this.ehh = (TbTabLayout) view.findViewById(e.g.frs_tab_layout);
        this.ehh.setOnTabSelectedListener(this);
        this.ehl = (ImageOverlayView) view.findViewById(e.g.frs_tab_overlayview);
        this.ehn = (LinearLayout) view.findViewById(e.g.frs_tab_arrow);
        this.ehm = (TbImageView) view.findViewById(e.g.smartapp_arrow);
        this.ehn.setOnClickListener(this.ehA);
        this.ehu = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.ehh);
        this.ehu.li(e.f.bg_tip_blue_up_left);
        this.ehu.lh(16);
        this.ehu.aa(true);
        this.ehu.ll(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.tbds34));
        this.ehu.setYOffset(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.tbds10));
        this.ehu.n(this.ehz);
        this.ehs = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.ehi);
        this.ehj = (FrsTabViewPager) view.findViewById(e.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.ehq = new FragmentAdapter(this.dNc.getActivity().getSupportFragmentManager(), this.mFragments);
        this.ehj.setAdapter(this.ehq);
        this.ehj.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void aW(View view) {
        if (isBrandForum()) {
            if ((view instanceof LinearLayout) && this.ehi.getParent() != null) {
                ((LinearLayout) view).removeView(this.ehi);
            }
        } else if ((view instanceof LinearLayout) && this.ehi.getParent() == null) {
            ((LinearLayout) view).addView(this.ehi);
        }
    }

    private boolean isBrandForum() {
        return this.ehp != null && this.ehp.bDL();
    }

    public void registerListener() {
        this.ehx.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dNc.registerListener(this.ehx);
        this.dNc.registerListener(this.ehy);
        this.dNc.registerListener(2001446, this.bRj, this.dNc.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bDm() != null && lVar.bDm().tab != null) {
            if (lVar != null && !v.I(lVar.hnV)) {
                int size = lVar.hnV.size();
                if (size > 3) {
                    size = 3;
                }
                int h = com.baidu.adp.lib.util.l.h(this.dNc.getPageContext().getPageActivity(), e.C0210e.tbds72);
                this.ehl.i(size, h, h, com.baidu.adp.lib.util.l.h(this.dNc.getPageContext().getPageActivity(), e.C0210e.tbds2), e.d.cp_bg_line_d, com.baidu.adp.lib.util.l.h(this.dNc.getPageContext().getPageActivity(), e.C0210e.tbds12));
                this.ehl.setData(lVar.hnV);
                this.ehn.setVisibility(0);
            } else {
                this.ehn.setVisibility(8);
            }
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bDm().tab) {
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
                            sb.append(lVar.bhx().getId());
                            dVar3.url = sb.toString();
                            bH(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && nz(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.eb(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.aDE().mE(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        z mB = y.aDD().mB(dVar5.tabId);
                        if (mB != null && mB.dOR != null && mB.dOR.size() > 0) {
                            dVar5.efs = new au();
                            dVar5.efs.dOQ = mB.dOQ;
                            dVar5.efs.dOR = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : mB.dOR) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.dON = xVar.dON;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.efs.dOR.add(atVar);
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
                        z mB2 = y.aDD().mB(dVar6.tabId);
                        if (mB2 != null && mB2.dOR != null && mB2.dOR.size() > 0) {
                            dVar6.efs = new au();
                            dVar6.efs.dOQ = mB2.dOQ;
                            dVar6.efs.dOR = new LinkedList();
                            for (x xVar2 : mB2.dOR) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.dON = xVar2.dON;
                                    dVar6.efs.dOR.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.dNc.aBU().aDb().k(bb.atN)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (lVar.bCO() != 0 && lVar.bCO() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + lVar.bCO() + ")";
                            }
                            if (this.cIg > 0 && this.cIg != lVar.bCO() && this.cIg <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.cIg + ")";
                            } else if (this.cIg > 99 || lVar.bCO() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.cIg == 0 && this.cIg != lVar.bCO()) {
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
                this.ehp = lVar;
                if (!b(tabData) && this.ehh.getTabCount() > 0 && !v.I(this.eho)) {
                    int min = Math.min(this.eho.size(), this.ehh.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e bq = this.ehh.bq(i2);
                        if (bq != null) {
                            if (lVar.bDn() && this.eho.get(i2).tabId == 89) {
                                bq.g(0, true);
                            } else {
                                bq.g(0, false);
                            }
                        }
                    }
                }
                if (lVar != null && lVar.bDm() != null) {
                    List<FrsTabInfo> list = lVar.bDm().menu;
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.d(list, 0);
                        if (this.dNc != null && this.dNc.aBP() != null && frsTabInfo2 != null) {
                            this.dNc.aBP().np(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.ehs != null && lVar.bhx() != null) {
                        this.ehs.setData(list, i);
                        this.ehs.setFid(lVar.bhx().getId());
                    }
                }
                if (a(tabData)) {
                    this.eho = tabData;
                    bT(arrayList);
                }
            }
        }
    }

    private boolean a(TabData tabData) {
        if (v.I(tabData)) {
            return false;
        }
        if (!v.I(this.ehq.mFragments) && tabData.size() == this.ehq.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.ehq.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.ehq.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.vc.k
    public boolean nM(int i) {
        if (i < 0 || this.eho == null || this.eho.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.eho.size()) {
                i2 = -1;
                break;
            } else if (this.eho.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.ehh.getTabCount()) {
            return false;
        }
        TbTabLayout.e bq = this.ehh.bq(i2);
        if (bq != null && !bq.isSelected()) {
            bq.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d nN(int i) {
        if (i < 0 || this.eho == null || this.eho.size() <= 0) {
            return null;
        }
        Iterator it = this.eho.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.ehg != null) {
            al.j(this.ehg, e.d.cp_bg_line_d);
        }
        if (this.ehk != null) {
            al.i(this.ehk, e.f.frs_tab_fading_edge);
        }
        if (this.ehh != null) {
            this.ehh.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.ehh.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            this.ehh.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
        if (this.ehs != null && !isBrandForum()) {
            this.ehs.onChangeSkinType();
        }
        if (this.ehl != null) {
            this.ehl.onChangeSkinType();
        }
        if (this.ehm != null) {
            al.b((ImageView) this.ehm, e.f.icon_arrow12_gray60_right, i);
        }
        if (!v.I(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void nO(int i) {
        this.cIg = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.eho != null && position >= 0 && position < this.eho.size() && (dVar = this.eho.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kV()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.kK() && dVar.tabId == 89 && this.ehp != null && this.ehp.bDn()) {
                this.ehp.nt(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.eht != null) {
                this.eht.fW(dVar.tabId);
            }
            TiebaStatic.log(new am("c12398").aB(ImageViewerConfig.FORUM_ID, this.dNc.forumId).y(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        aIK();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.eho != null && position >= 0 && position < this.eho.size() && (dVar = this.eho.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").aB(ImageViewerConfig.FORUM_ID, this.dNc.forumId).y(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean b(TabData tabData) {
        if (v.I(tabData)) {
            return false;
        }
        return (!v.I(this.eho) && tabData.size() == this.eho.size() && this.eho.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !nz(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void bH(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    am amVar = new am(str2);
                    amVar.aB("obj_type", host);
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
                public com.baidu.tbadk.mainTab.c Og() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.dNc != null && FrsTabViewController.this.dNc.aBU() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.dNc.aBU().aDd());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.beA = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.beG = com.baidu.tbadk.mainTab.c.beD;
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
                public com.baidu.tbadk.mainTab.c Og() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dNc.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dNc.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.beA = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.beG = com.baidu.tbadk.mainTab.c.beD;
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
                public com.baidu.tbadk.mainTab.c Og() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dNc.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dNc.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dNc.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.beA = frsADFragment;
                    cVar.type = 90;
                    cVar.beG = com.baidu.tbadk.mainTab.c.beD;
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
                public com.baidu.tbadk.mainTab.c Og() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dNc.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dNc.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dNc.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.ehp.hnT);
                    bundle.putBoolean("need_log", FrsTabViewController.this.ehp.hmQ == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.ehp.isBrandForum);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.beA = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.beG = com.baidu.tbadk.mainTab.c.beD;
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

    private void bT(List<FrsTabInfo> list) {
        if (!v.I(list)) {
            this.ehr = new com.baidu.tieba.frs.e(this.dNc.getActivity().getApplicationContext(), list);
            this.ehr.setForumId(this.dNc.getForumId());
            this.ehr.setForumName(this.dNc.getForumName());
            if (this.ehp != null && this.ehp.bhx() != null) {
                this.ehr.eD(this.ehp.bhx().getFirst_class());
                this.ehr.eE(this.ehp.bhx().getSecond_class());
                this.ehr.setForumGameLabel(this.ehp.bhx().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.ehr.b(c);
                }
            }
            this.ehv = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.ehr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIF() {
        int i;
        if (this.ehr != null) {
            List<com.baidu.tbadk.mainTab.b> aBD = this.ehr.aBD();
            if (!v.I(aBD) && !v.I(this.eho)) {
                if (this.ehh.getTabCount() > 0) {
                    this.ehh.removeAllTabs();
                }
                aIG();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.eho.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, aBD);
                    if (c != null) {
                        TbTabLayout.e b2 = this.ehh.pg().b(dVar.name);
                        boolean z = this.ehp.hnU == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.ehp != null && this.ehp.bDn() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.ehh.a(b2, z);
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
                if (this.ehh.getTabCount() > 0 && this.ehg.getVisibility() != 0) {
                    this.ehg.setVisibility(0);
                }
                this.ehq = new FragmentAdapter(this.dNc.getActivity().getSupportFragmentManager(), this.mFragments);
                this.ehj.setAdapter(this.ehq);
                this.ehq.notifyDataSetChanged();
                this.ehh.setupWithViewPager(this.ehj);
                this.ehj.setOffscreenPageLimit(this.mFragments.size());
                this.ehj.setCurrentItem(i3, false);
                this.ehj.aDF();
            }
        }
    }

    private void aIG() {
        if (this.ehj != null && this.ehq != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.dNc.getActivity().getSupportFragmentManager();
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
            if (i == bVar.Oh().type) {
                return bVar.Oh().beA;
            }
        }
        return null;
    }

    public View aIH() {
        if (isBrandForum() || this.ehs == null) {
            return null;
        }
        return this.ehs.aFq();
    }

    public static boolean nz(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.eht = aVar;
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

    public b aII() {
        if (this.ehj == null) {
            return null;
        }
        return (b) v.d(this.mFragments, this.ehj.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void aIJ() {
        this.ehu.bp(this.dNc.getString(e.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aIK() {
        this.ehu.asz();
    }
}
