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
import com.baidu.tieba.frs.dynamic.FrsDynamicFragment;
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
public class FrsTabViewController implements TbTabLayout.b, j {
    private static final String TAG = FrsTabViewController.class.getSimpleName();
    private FrsFragment dBO;
    private RelativeLayout dVY;
    private TbTabLayout dVZ;
    private RelativeLayout dWa;
    private FrsTabViewPager dWb;
    private View dWc;
    private ImageOverlayView dWd;
    private TbImageView dWe;
    private LinearLayout dWf;
    private TabData dWg;
    private l dWh;
    private FragmentAdapter dWi;
    private com.baidu.tieba.frs.e dWj;
    private com.baidu.tieba.frs.entelechy.c.a.a dWk;
    private a dWl;
    private com.baidu.tieba.c.d dWm;
    private List<b> mFragments;
    private int cBp = -1;
    private boolean dWn = false;
    public boolean dWo = true;
    CustomMessageListener dWp = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.dWn) {
                FrsTabViewController.this.aGl();
                FrsTabViewController.this.dWn = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.dWb != null) {
                FrsTabViewController.this.dWb.aBm();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener dWq = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.dVZ.getTabCount() > 0 && !v.J(FrsTabViewController.this.dWg)) {
                    FrsTabViewController.this.dWh.nc(true);
                    int min = Math.min(FrsTabViewController.this.dWg.size(), FrsTabViewController.this.dVZ.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e bb = FrsTabViewController.this.dVZ.bb(i);
                        if (bb != null) {
                            if (FrsTabViewController.this.dWg.get(i).tabId == 89) {
                                bb.g(0, true);
                            } else {
                                bb.g(0, false);
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bLT = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b aGo;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(BaseRequestAction.SPLITE);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aGo = FrsTabViewController.this.aGo()) != null && aGo.fragment != null && (aGo.fragment instanceof aj)) {
                        ((aj) aGo.fragment).ZG();
                    }
                }
            }
        }
    };
    private View.OnClickListener dWr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.dWm.apZ();
        }
    };
    private View.OnClickListener dWs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void ft(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.dBO = frsFragment;
        this.dVY = (RelativeLayout) view.findViewById(e.g.frs_tab_view_container);
        this.dWa = new RelativeLayout(this.dBO.getContext());
        this.dWa.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dWc = view.findViewById(e.g.fading_edge_view);
        this.dVZ = (TbTabLayout) view.findViewById(e.g.frs_tab_layout);
        this.dVZ.setOnTabSelectedListener(this);
        this.dWd = (ImageOverlayView) view.findViewById(e.g.frs_tab_overlayview);
        this.dWf = (LinearLayout) view.findViewById(e.g.frs_tab_arrow);
        this.dWe = (TbImageView) view.findViewById(e.g.smartapp_arrow);
        this.dWf.setOnClickListener(this.dWs);
        this.dWm = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.dVZ);
        this.dWm.kl(e.f.bg_tip_blue_up_left);
        this.dWm.kk(16);
        this.dWm.M(true);
        this.dWm.ko(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0175e.tbds34));
        this.dWm.kp(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0175e.tbds10));
        this.dWm.l(this.dWr);
        this.dWk = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.dWa);
        this.dWb = (FrsTabViewPager) view.findViewById(e.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dWi = new FragmentAdapter(this.dBO.getActivity().getSupportFragmentManager(), this.mFragments);
        this.dWb.setAdapter(this.dWi);
        this.dWb.addOnPageChangeListener(this.mOnPageChangeListener);
        registerListener();
    }

    public void aR(View view) {
        if (isBrandForum()) {
            if ((view instanceof LinearLayout) && this.dWa.getParent() != null) {
                ((LinearLayout) view).removeView(this.dWa);
            }
        } else if ((view instanceof LinearLayout) && this.dWa.getParent() == null) {
            ((LinearLayout) view).addView(this.dWa);
        }
    }

    private boolean isBrandForum() {
        return this.dWh != null && this.dWh.bAV();
    }

    private void registerListener() {
        this.dWp.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dBO.registerListener(this.dWp);
        this.dBO.registerListener(this.dWq);
        this.dBO.registerListener(2001446, this.bLT, this.dBO.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bAw() != null && lVar.bAw().tab != null) {
            if (lVar != null && !v.J(lVar.hbo)) {
                int size = lVar.hbo.size();
                if (size > 3) {
                    size = 3;
                }
                int h = com.baidu.adp.lib.util.l.h(this.dBO.getPageContext().getPageActivity(), e.C0175e.tbds72);
                this.dWd.h(size, h, h, com.baidu.adp.lib.util.l.h(this.dBO.getPageContext().getPageActivity(), e.C0175e.tbds2), e.d.cp_bg_line_d, com.baidu.adp.lib.util.l.h(this.dBO.getPageContext().getPageActivity(), e.C0175e.tbds12));
                this.dWd.setData(lVar.hbo);
                this.dWf.setVisibility(0);
            } else {
                this.dWf.setVisibility(8);
            }
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bAw().tab) {
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
                            sb.append(lVar.beT().getId());
                            dVar3.url = sb.toString();
                            bB(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && mD(frsTabInfo.tab_id.intValue())) {
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.aBl().lI(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        z lF = y.aBk().lF(dVar5.tabId);
                        if (lF != null && lF.dDE != null && lF.dDE.size() > 0) {
                            dVar5.dUl = new au();
                            dVar5.dUl.dDD = lF.dDD;
                            dVar5.dUl.dDE = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : lF.dDE) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.dDA = xVar.dDA;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.dUl.dDE.add(atVar);
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
                        z lF2 = y.aBk().lF(dVar6.tabId);
                        if (lF2 != null && lF2.dDE != null && lF2.dDE.size() > 0) {
                            dVar6.dUl = new au();
                            dVar6.dUl.dDD = lF2.dDD;
                            dVar6.dUl.dDE = new LinkedList();
                            for (x xVar2 : lF2.dDE) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.dDA = xVar2.dDA;
                                    dVar6.dUl.dDE.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.dBO.azB().aAI().k(bb.aoW)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (lVar.bzY() != 0 && lVar.bzY() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + lVar.bzY() + ")";
                            }
                            if (this.cBp > 0 && this.cBp != lVar.bzY() && this.cBp <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.cBp + ")";
                            } else if (this.cBp > 99 || lVar.bzY() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.cBp == 0 && this.cBp != lVar.bzY()) {
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
                this.dWh = lVar;
                if (!b(tabData) && this.dVZ.getTabCount() > 0 && !v.J(this.dWg)) {
                    int min = Math.min(this.dWg.size(), this.dVZ.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e bb = this.dVZ.bb(i2);
                        if (bb != null) {
                            if (lVar.bAx() && this.dWg.get(i2).tabId == 89) {
                                bb.g(0, true);
                            } else {
                                bb.g(0, false);
                            }
                        }
                    }
                }
                if (lVar != null && lVar.bAw() != null) {
                    List<FrsTabInfo> list = lVar.bAw().menu;
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.d(list, 0);
                        if (this.dBO != null && this.dBO.azw() != null && frsTabInfo2 != null) {
                            this.dBO.azw().mt(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.dWk != null && lVar.beT() != null) {
                        this.dWk.setData(list, i);
                        this.dWk.setFid(lVar.beT().getId());
                    }
                }
                if (a(tabData)) {
                    this.dWg = tabData;
                    bR(arrayList);
                }
            }
        }
    }

    private boolean a(TabData tabData) {
        if (v.J(tabData)) {
            return false;
        }
        if (!v.J(this.dWi.mFragments) && tabData.size() == this.dWi.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.dWi.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.dWi.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.vc.j
    public boolean mQ(int i) {
        if (i < 0 || this.dWg == null || this.dWg.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dWg.size()) {
                i2 = -1;
                break;
            } else if (this.dWg.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dVZ.getTabCount()) {
            return false;
        }
        TbTabLayout.e bb = this.dVZ.bb(i2);
        if (bb != null && !bb.isSelected()) {
            bb.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d mR(int i) {
        if (i < 0 || this.dWg == null || this.dWg.size() <= 0) {
            return null;
        }
        Iterator it = this.dWg.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dVY != null) {
            al.j(this.dVY, e.d.cp_bg_line_d);
        }
        if (this.dWc != null) {
            al.i(this.dWc, e.f.frs_tab_fading_edge);
        }
        if (this.dVZ != null) {
            this.dVZ.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.dVZ.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            this.dVZ.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
        if (this.dWk != null && !isBrandForum()) {
            this.dWk.onChangeSkinType();
        }
        if (this.dWd != null) {
            this.dWd.onChangeSkinType();
        }
        if (this.dWe != null) {
            al.b((ImageView) this.dWe, e.f.icon_arrow12_gray60_right, i);
        }
        if (!v.J(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void mS(int i) {
        this.cBp = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dWg != null && position >= 0 && position < this.dWg.size() && (dVar = this.dWg.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kX()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.kM() && dVar.tabId == 89 && this.dWh != null && this.dWh.bAx()) {
                this.dWh.nc(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.dWl != null) {
                this.dWl.ft(dVar.tabId);
            }
            TiebaStatic.log(new am("c12398").ax(ImageViewerConfig.FORUM_ID, this.dBO.forumId).x(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        aGq();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dWg != null && position >= 0 && position < this.dWg.size() && (dVar = this.dWg.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").ax(ImageViewerConfig.FORUM_ID, this.dBO.forumId).x(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean b(TabData tabData) {
        if (v.J(tabData)) {
            return false;
        }
        return (!v.J(this.dWg) && tabData.size() == this.dWg.size() && this.dWg.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !mD(frsTabInfo.tab_id.intValue());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MB() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.dBO != null && FrsTabViewController.this.dBO.azB() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.dBO.azB().aAK());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aZz = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.aZF = com.baidu.tbadk.mainTab.c.aZC;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bR(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 301 || intValue == 303) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MB() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dBO.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dBO.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aZz = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.aZF = com.baidu.tbadk.mainTab.c.aZC;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bR(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 89) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MB() {
                    FrsDynamicFragment frsDynamicFragment = new FrsDynamicFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dBO.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dBO.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dBO.getForumId());
                    frsDynamicFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aZz = frsDynamicFragment;
                    cVar.type = 89;
                    cVar.aZF = com.baidu.tbadk.mainTab.c.aZC;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bR(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 90) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MB() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dBO.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dBO.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dBO.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aZz = frsADFragment;
                    cVar.type = 90;
                    cVar.aZF = com.baidu.tbadk.mainTab.c.aZC;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bR(Context context) {
                    return null;
                }
            };
        }
        if (frsTabInfo.tab_type.intValue() == 91) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.11
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c MB() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dBO.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dBO.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dBO.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.dWh.hbm);
                    bundle.putBoolean("need_log", FrsTabViewController.this.dWh.haj == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.dWh.isBrandForum);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aZz = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.aZF = com.baidu.tbadk.mainTab.c.aZC;
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
        if (!v.J(list)) {
            this.dWj = new com.baidu.tieba.frs.e(this.dBO.getActivity().getApplicationContext(), list);
            this.dWj.setForumId(this.dBO.getForumId());
            this.dWj.setForumName(this.dBO.getForumName());
            if (this.dWh != null && this.dWh.beT() != null) {
                this.dWj.ec(this.dWh.beT().getFirst_class());
                this.dWj.ed(this.dWh.beT().getSecond_class());
                this.dWj.setForumGameLabel(this.dWh.beT().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.dWj.b(c);
                }
            }
            this.dWn = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dWj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGl() {
        int i;
        if (this.dWj != null) {
            List<com.baidu.tbadk.mainTab.b> azk = this.dWj.azk();
            if (!v.J(azk) && !v.J(this.dWg)) {
                if (this.dVZ.getTabCount() > 0) {
                    this.dVZ.removeAllTabs();
                }
                aGm();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dWg.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, azk);
                    if (c != null) {
                        TbTabLayout.e b2 = this.dVZ.pf().b(dVar.name);
                        boolean z = this.dWh.hbn == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.dWh != null && this.dWh.bAx() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.dVZ.a(b2, z);
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
                if (this.dVZ.getTabCount() > 0 && this.dVY.getVisibility() != 0) {
                    this.dVY.setVisibility(0);
                }
                this.dWi = new FragmentAdapter(this.dBO.getActivity().getSupportFragmentManager(), this.mFragments);
                this.dWb.setAdapter(this.dWi);
                this.dWi.notifyDataSetChanged();
                this.dVZ.setupWithViewPager(this.dWb);
                this.dWb.setOffscreenPageLimit(this.mFragments.size());
                this.dWb.setCurrentItem(i3, false);
                this.dWb.aBm();
            }
        }
    }

    private void aGm() {
        if (this.dWb != null && this.dWi != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.dBO.getActivity().getSupportFragmentManager();
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
            if (i == bVar.MC().type) {
                return bVar.MC().aZz;
            }
        }
        return null;
    }

    public View aGn() {
        if (isBrandForum() || this.dWk == null) {
            return null;
        }
        return this.dWk.aCY();
    }

    public static boolean mD(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.dWl = aVar;
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

    public b aGo() {
        if (this.dWb == null) {
            return null;
        }
        return (b) v.d(this.mFragments, this.dWb.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void aGp() {
        this.dWm.bj(this.dBO.getString(e.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aGq() {
        this.dWm.apZ();
    }
}
