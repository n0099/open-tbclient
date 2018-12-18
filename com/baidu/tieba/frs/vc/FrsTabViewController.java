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
    private FrsFragment dJE;
    private RelativeLayout edI;
    private TbTabLayout edJ;
    private RelativeLayout edK;
    private FrsTabViewPager edL;
    private View edM;
    private ImageOverlayView edN;
    private TbImageView edO;
    private LinearLayout edP;
    private TabData edQ;
    private l edR;
    private FragmentAdapter edS;
    private com.baidu.tieba.frs.e edT;
    private com.baidu.tieba.frs.entelechy.c.a.a edU;
    private a edV;
    private com.baidu.tieba.c.d edW;
    private List<b> mFragments;
    private int cGu = -1;
    private boolean edX = false;
    public boolean edY = true;
    CustomMessageListener edZ = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.edX) {
                FrsTabViewController.this.aHt();
                FrsTabViewController.this.edX = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.edL != null) {
                FrsTabViewController.this.edL.aCt();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener eea = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.edJ.getTabCount() > 0 && !v.I(FrsTabViewController.this.edQ)) {
                    FrsTabViewController.this.edR.np(true);
                    int min = Math.min(FrsTabViewController.this.edQ.size(), FrsTabViewController.this.edJ.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e bq = FrsTabViewController.this.edJ.bq(i);
                        if (bq != null) {
                            if (FrsTabViewController.this.edQ.get(i).tabId == 89) {
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
    private CustomMessageListener bQu = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b aHw;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aHw = FrsTabViewController.this.aHw()) != null && aHw.fragment != null && (aHw.fragment instanceof aj)) {
                        ((aj) aHw.fragment).aaW();
                    }
                }
            }
        }
    };
    private View.OnClickListener eeb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.edW.arm();
        }
    };
    private View.OnClickListener eec = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void fV(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.dJE = frsFragment;
        this.edI = (RelativeLayout) view.findViewById(e.g.frs_tab_view_container);
        this.edK = new RelativeLayout(this.dJE.getContext());
        this.edK.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.edM = view.findViewById(e.g.fading_edge_view);
        this.edJ = (TbTabLayout) view.findViewById(e.g.frs_tab_layout);
        this.edJ.setOnTabSelectedListener(this);
        this.edN = (ImageOverlayView) view.findViewById(e.g.frs_tab_overlayview);
        this.edP = (LinearLayout) view.findViewById(e.g.frs_tab_arrow);
        this.edO = (TbImageView) view.findViewById(e.g.smartapp_arrow);
        this.edP.setOnClickListener(this.eec);
        this.edW = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.edJ);
        this.edW.kU(e.f.bg_tip_blue_up_left);
        this.edW.kT(16);
        this.edW.aa(true);
        this.edW.kX(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.tbds34));
        this.edW.setYOffset(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0210e.tbds10));
        this.edW.n(this.eeb);
        this.edU = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.edK);
        this.edL = (FrsTabViewPager) view.findViewById(e.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.edS = new FragmentAdapter(this.dJE.getActivity().getSupportFragmentManager(), this.mFragments);
        this.edL.setAdapter(this.edS);
        this.edL.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    public void aT(View view) {
        if (isBrandForum()) {
            if ((view instanceof LinearLayout) && this.edK.getParent() != null) {
                ((LinearLayout) view).removeView(this.edK);
            }
        } else if ((view instanceof LinearLayout) && this.edK.getParent() == null) {
            ((LinearLayout) view).addView(this.edK);
        }
    }

    private boolean isBrandForum() {
        return this.edR != null && this.edR.bCk();
    }

    public void registerListener() {
        this.edZ.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dJE.registerListener(this.edZ);
        this.dJE.registerListener(this.eea);
        this.dJE.registerListener(2001446, this.bQu, this.dJE.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bBL() != null && lVar.bBL().tab != null) {
            if (lVar != null && !v.I(lVar.hjE)) {
                int size = lVar.hjE.size();
                if (size > 3) {
                    size = 3;
                }
                int h = com.baidu.adp.lib.util.l.h(this.dJE.getPageContext().getPageActivity(), e.C0210e.tbds72);
                this.edN.i(size, h, h, com.baidu.adp.lib.util.l.h(this.dJE.getPageContext().getPageActivity(), e.C0210e.tbds2), e.d.cp_bg_line_d, com.baidu.adp.lib.util.l.h(this.dJE.getPageContext().getPageActivity(), e.C0210e.tbds12));
                this.edN.setData(lVar.hjE);
                this.edP.setVisibility(0);
            } else {
                this.edP.setVisibility(8);
            }
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bBL().tab) {
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
                            sb.append(lVar.bgh().getId());
                            dVar3.url = sb.toString();
                            bG(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && nl(frsTabInfo.tab_id.intValue())) {
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.aCs().mq(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        z mn = y.aCr().mn(dVar5.tabId);
                        if (mn != null && mn.dLt != null && mn.dLt.size() > 0) {
                            dVar5.ebU = new au();
                            dVar5.ebU.dLs = mn.dLs;
                            dVar5.ebU.dLt = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : mn.dLt) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.dLp = xVar.dLp;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.ebU.dLt.add(atVar);
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
                        z mn2 = y.aCr().mn(dVar6.tabId);
                        if (mn2 != null && mn2.dLt != null && mn2.dLt.size() > 0) {
                            dVar6.ebU = new au();
                            dVar6.ebU.dLs = mn2.dLs;
                            dVar6.ebU.dLt = new LinkedList();
                            for (x xVar2 : mn2.dLt) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.dLp = xVar2.dLp;
                                    dVar6.ebU.dLt.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.dJE.aAI().aBP().k(bb.atk)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (lVar.bBn() != 0 && lVar.bBn() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + lVar.bBn() + ")";
                            }
                            if (this.cGu > 0 && this.cGu != lVar.bBn() && this.cGu <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.cGu + ")";
                            } else if (this.cGu > 99 || lVar.bBn() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.cGu == 0 && this.cGu != lVar.bBn()) {
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
                this.edR = lVar;
                if (!b(tabData) && this.edJ.getTabCount() > 0 && !v.I(this.edQ)) {
                    int min = Math.min(this.edQ.size(), this.edJ.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e bq = this.edJ.bq(i2);
                        if (bq != null) {
                            if (lVar.bBM() && this.edQ.get(i2).tabId == 89) {
                                bq.g(0, true);
                            } else {
                                bq.g(0, false);
                            }
                        }
                    }
                }
                if (lVar != null && lVar.bBL() != null) {
                    List<FrsTabInfo> list = lVar.bBL().menu;
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.d(list, 0);
                        if (this.dJE != null && this.dJE.aAD() != null && frsTabInfo2 != null) {
                            this.dJE.aAD().nb(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.edU != null && lVar.bgh() != null) {
                        this.edU.setData(list, i);
                        this.edU.setFid(lVar.bgh().getId());
                    }
                }
                if (a(tabData)) {
                    this.edQ = tabData;
                    bR(arrayList);
                }
            }
        }
    }

    private boolean a(TabData tabData) {
        if (v.I(tabData)) {
            return false;
        }
        if (!v.I(this.edS.mFragments) && tabData.size() == this.edS.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.edS.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.edS.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.vc.k
    public boolean ny(int i) {
        if (i < 0 || this.edQ == null || this.edQ.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.edQ.size()) {
                i2 = -1;
                break;
            } else if (this.edQ.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.edJ.getTabCount()) {
            return false;
        }
        TbTabLayout.e bq = this.edJ.bq(i2);
        if (bq != null && !bq.isSelected()) {
            bq.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d nz(int i) {
        if (i < 0 || this.edQ == null || this.edQ.size() <= 0) {
            return null;
        }
        Iterator it = this.edQ.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.edI != null) {
            al.j(this.edI, e.d.cp_bg_line_d);
        }
        if (this.edM != null) {
            al.i(this.edM, e.f.frs_tab_fading_edge);
        }
        if (this.edJ != null) {
            this.edJ.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.edJ.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            this.edJ.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
        if (this.edU != null && !isBrandForum()) {
            this.edU.onChangeSkinType();
        }
        if (this.edN != null) {
            this.edN.onChangeSkinType();
        }
        if (this.edO != null) {
            al.b((ImageView) this.edO, e.f.icon_arrow12_gray60_right, i);
        }
        if (!v.I(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void nA(int i) {
        this.cGu = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.edQ != null && position >= 0 && position < this.edQ.size() && (dVar = this.edQ.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kV()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.kK() && dVar.tabId == 89 && this.edR != null && this.edR.bBM()) {
                this.edR.np(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.edV != null) {
                this.edV.fV(dVar.tabId);
            }
            TiebaStatic.log(new am("c12398").aA(ImageViewerConfig.FORUM_ID, this.dJE.forumId).x(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        aHy();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.edQ != null && position >= 0 && position < this.edQ.size() && (dVar = this.edQ.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").aA(ImageViewerConfig.FORUM_ID, this.dJE.forumId).x(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean b(TabData tabData) {
        if (v.I(tabData)) {
            return false;
        }
        return (!v.I(this.edQ) && tabData.size() == this.edQ.size() && this.edQ.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !nl(frsTabInfo.tab_id.intValue());
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
                public com.baidu.tbadk.mainTab.c NO() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.dJE != null && FrsTabViewController.this.dJE.aAI() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.dJE.aAI().aBR());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bdK = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.bdQ = com.baidu.tbadk.mainTab.c.bdN;
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
                public com.baidu.tbadk.mainTab.c NO() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dJE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dJE.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bdK = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.bdQ = com.baidu.tbadk.mainTab.c.bdN;
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
                public com.baidu.tbadk.mainTab.c NO() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dJE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dJE.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dJE.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bdK = frsADFragment;
                    cVar.type = 90;
                    cVar.bdQ = com.baidu.tbadk.mainTab.c.bdN;
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
                public com.baidu.tbadk.mainTab.c NO() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dJE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dJE.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dJE.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.edR.hjC);
                    bundle.putBoolean("need_log", FrsTabViewController.this.edR.hiz == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.edR.isBrandForum);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.bdK = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.bdQ = com.baidu.tbadk.mainTab.c.bdN;
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

    private void bR(List<FrsTabInfo> list) {
        if (!v.I(list)) {
            this.edT = new com.baidu.tieba.frs.e(this.dJE.getActivity().getApplicationContext(), list);
            this.edT.setForumId(this.dJE.getForumId());
            this.edT.setForumName(this.dJE.getForumName());
            if (this.edR != null && this.edR.bgh() != null) {
                this.edT.eu(this.edR.bgh().getFirst_class());
                this.edT.ev(this.edR.bgh().getSecond_class());
                this.edT.setForumGameLabel(this.edR.bgh().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.edT.b(c);
                }
            }
            this.edX = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.edT));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHt() {
        int i;
        if (this.edT != null) {
            List<com.baidu.tbadk.mainTab.b> aAr = this.edT.aAr();
            if (!v.I(aAr) && !v.I(this.edQ)) {
                if (this.edJ.getTabCount() > 0) {
                    this.edJ.removeAllTabs();
                }
                aHu();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.edQ.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, aAr);
                    if (c != null) {
                        TbTabLayout.e b2 = this.edJ.pc().b(dVar.name);
                        boolean z = this.edR.hjD == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.edR != null && this.edR.bBM() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.edJ.a(b2, z);
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
                if (this.edJ.getTabCount() > 0 && this.edI.getVisibility() != 0) {
                    this.edI.setVisibility(0);
                }
                this.edS = new FragmentAdapter(this.dJE.getActivity().getSupportFragmentManager(), this.mFragments);
                this.edL.setAdapter(this.edS);
                this.edS.notifyDataSetChanged();
                this.edJ.setupWithViewPager(this.edL);
                this.edL.setOffscreenPageLimit(this.mFragments.size());
                this.edL.setCurrentItem(i3, false);
                this.edL.aCt();
            }
        }
    }

    private void aHu() {
        if (this.edL != null && this.edS != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.dJE.getActivity().getSupportFragmentManager();
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
            if (i == bVar.NP().type) {
                return bVar.NP().bdK;
            }
        }
        return null;
    }

    public View aHv() {
        if (isBrandForum() || this.edU == null) {
            return null;
        }
        return this.edU.aEe();
    }

    public static boolean nl(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.edV = aVar;
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

    public b aHw() {
        if (this.edL == null) {
            return null;
        }
        return (b) v.d(this.mFragments, this.edL.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void aHx() {
        this.edW.bo(this.dJE.getString(e.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aHy() {
        this.edW.arm();
    }
}
