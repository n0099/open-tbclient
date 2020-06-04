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
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class FrsTabViewController implements TbTabLayout.b, n {
    private View fev;
    private TbTabLayout gRH;
    private RelativeLayout hNC;
    private View hND;
    private FrsTabViewPager hNE;
    private LinearGradientView hNF;
    private TabData hNG;
    private FrsViewData hNH;
    private FragmentAdapter hNI;
    private com.baidu.tieba.frs.e hNJ;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b hNK;
    private a hNL;
    private com.baidu.tieba.c.d hNN;
    private int hNQ;
    private FrsFragment hpm;
    private RelativeLayout huW;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int hqh = 0;
    private int hNM = -1;
    private boolean hNO = false;
    public boolean hNP = true;
    private boolean hNR = false;
    private boolean hNS = false;
    CustomMessageListener hNT = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.hNO) {
                FrsTabViewController.this.cct();
                FrsTabViewController.this.hNO = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.hNE != null) {
                FrsTabViewController.this.hNE.bWP();
                if (!v.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) v.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof an) {
                        y yVar = new y();
                        yVar.tabId = bVar.tabId;
                        yVar.hqS = (an) bVar.fragment;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, yVar));
                        return;
                    }
                    y yVar2 = new y();
                    yVar2.tabId = bVar.tabId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, yVar2));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener hNU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.hNH != null && FrsTabViewController.this.hNH.isShowRedTip() != booleanValue && FrsTabViewController.this.gRH.getTabCount() > 0 && !v.isEmpty(FrsTabViewController.this.hNG)) {
                        FrsTabViewController.this.hNH.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.hNG.size(), FrsTabViewController.this.gRH.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aF = FrsTabViewController.this.gRH.aF(i);
                            if (aF != null) {
                                if (FrsTabViewController.this.hNG.get(i).tabId == 89) {
                                    aF.j(0, booleanValue);
                                } else {
                                    aF.j(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fie = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b ccw;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (ccw = FrsTabViewController.this.ccw()) != null && ccw.fragment != null && (ccw.fragment instanceof al)) {
                        ((al) ccw.fragment).brL();
                    }
                }
            }
        }
    };
    private CustomMessageListener hNV = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.hNG.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.hNG.size()) {
                    FrsTabViewController.this.hNE.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener hNW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.hNN.Gu();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void bO(int i, int i2);
    }

    public void nM(boolean z) {
        this.gRH.setDisableTabSelect(z);
    }

    public FrsTabViewPager cco() {
        return this.hNE;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.hpm = frsFragment;
        this.hNC = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.hND = view.findViewById(R.id.frs_tab_bg);
        this.fev = view.findViewById(R.id.divider_shadow);
        this.hNF = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.gRH = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.gRH.setOnTabSelectedListener(this);
        this.gRH.setSelectedTabTextBlod(true);
        this.gRH.setTabTextSize(vB(R.dimen.tbds46));
        this.hNN = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.gRH);
        this.hNN.cI(R.drawable.bg_tip_blue_up_left);
        this.hNN.cH(16);
        this.hNN.setUseDirectOffset(true);
        this.hNN.sz(vB(R.dimen.tbds34));
        this.hNN.setYOffset(vB(R.dimen.tbds10));
        this.hNN.c(this.hNW);
        this.hNE = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.hNI = new FragmentAdapter(this.hpm.getActivity().getSupportFragmentManager(), this.mFragments);
        this.hNE.addOnPageChangeListener(this.mOnPageChangeListener);
        this.huW = new RelativeLayout(this.hpm.getContext());
        this.hNK = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.huW);
    }

    private int vB(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout ccp() {
        return this.huW;
    }

    public View ccq() {
        return this.hNF;
    }

    private boolean isBrandForum() {
        return this.hNH != null && this.hNH.getIsBrandForum();
    }

    public void registerListener() {
        this.hNT.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.hpm.registerListener(this.hNT);
        this.hpm.registerListener(this.hNU);
        this.hpm.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fie, this.hpm.getBaseFragmentActivity().getUniqueId());
        this.hpm.registerListener(this.hNV);
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void a(FrsViewData frsViewData, int i) {
        AccountData currentAccountObj;
        String str;
        String str2;
        boolean z;
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    if (frsTabInfo.is_general_tab.intValue() == 1 || frsTabInfo.tab_type.intValue() == 16) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.name = frsTabInfo.tab_name;
                        dVar.tabId = frsTabInfo.tab_id.intValue();
                        dVar.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 89 || frsTabInfo.tab_id.intValue() == 503) {
                        com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                        dVar2.tabId = frsTabInfo.tab_id.intValue();
                        dVar2.name = frsTabInfo.tab_name;
                        dVar2.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar2);
                        arrayList.add(frsTabInfo);
                        if (frsTabInfo.tab_id.intValue() == 503) {
                            if (TbadkCoreApplication.getCurrentAccountObj() == null) {
                                str = "";
                            } else {
                                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
                            }
                            if (frsViewData.getForum() == null || frsViewData.getForum().getName() == null) {
                                str2 = "";
                            } else {
                                str2 = frsViewData.getForum().getName();
                            }
                            int Fh = com.baidu.tieba.frs.f.g.Fh("503~" + str + str2);
                            if (Fh == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aN("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == Fh) {
                                                com.baidu.tieba.tbadkCore.util.e.deS();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.deT();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 12) {
                        com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                        dVar3.tabId = frsTabInfo.tab_id.intValue();
                        dVar3.name = frsTabInfo.tab_name;
                        dVar3.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar3);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                            dVar4.tabId = frsTabInfo.tab_id.intValue();
                            dVar4.name = frsTabInfo.tab_name;
                            dVar4.tabType = frsTabInfo.tab_type.intValue();
                            StringBuilder sb = new StringBuilder();
                            String lowerCase = frsTabInfo.tab_url.toLowerCase();
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) && !lowerCase.contains("://")) {
                                sb.append("http://");
                            }
                            sb.append(frsTabInfo.tab_url);
                            sb.append(ETAG.ITEM_SEPARATOR);
                            sb.append("fid");
                            sb.append(ETAG.EQUAL);
                            sb.append(frsViewData.getForum().getId());
                            dVar4.url = sb.toString();
                            ei(dVar4.url, "c10078");
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && vk(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.d.vg(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ae.bWO().ui(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ac uf = ab.bWN().uf(dVar6.tabId);
                        if (uf != null && uf.hri != null && uf.hri.size() > 0) {
                            dVar6.hKi = new ay();
                            dVar6.hKi.hrh = uf.hrh;
                            dVar6.hKi.hri = new LinkedList();
                            boolean z2 = true;
                            for (aa aaVar : uf.hri) {
                                if (aaVar != null) {
                                    ax axVar = new ax();
                                    axVar.name = aaVar.name;
                                    axVar.hre = aaVar.hre;
                                    if (z2) {
                                        axVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.hKi.hri.add(axVar);
                                    z2 = z;
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                        dVar7.tabId = frsTabInfo.tab_id.intValue();
                        dVar7.name = frsTabInfo.tab_name;
                        dVar7.tabType = frsTabInfo.tab_type.intValue();
                        ac uf2 = ab.bWN().uf(dVar7.tabId);
                        if (uf2 != null && uf2.hri != null && uf2.hri.size() > 0) {
                            dVar7.hKi = new ay();
                            dVar7.hKi.hrh = uf2.hrh;
                            dVar7.hKi.hri = new LinkedList();
                            for (aa aaVar2 : uf2.hri) {
                                if (aaVar2 != null) {
                                    ax axVar2 = new ax();
                                    axVar2.name = aaVar2.name;
                                    axVar2.hre = aaVar2.hre;
                                    dVar7.hKi.hri.add(axVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.hpm.bUT().bWo().r(bk.dEW)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.hNM > 0 && this.hNM != frsViewData.getAlaLiveCount() && this.hNM <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.hNM + ")";
                            } else if (this.hNM > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.hNM == 0 && this.hNM != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            dVar9.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        dVar10.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 90) {
                        com.baidu.tieba.frs.tab.d dVar11 = new com.baidu.tieba.frs.tab.d();
                        dVar11.tabId = frsTabInfo.tab_id.intValue();
                        dVar11.name = frsTabInfo.tab_name;
                        dVar11.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar11);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 91) {
                        com.baidu.tieba.frs.tab.d dVar12 = new com.baidu.tieba.frs.tab.d();
                        dVar12.tabId = frsTabInfo.tab_id.intValue();
                        dVar12.name = aq.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
                        dVar12.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar12);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 504) {
                        com.baidu.tieba.frs.tab.d dVar13 = new com.baidu.tieba.frs.tab.d();
                        dVar13.tabId = frsTabInfo.tab_id.intValue();
                        dVar13.name = frsTabInfo.tab_name;
                        dVar13.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar13);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.hNH = frsViewData;
                if (this.hNH.getForum() != null) {
                    this.mThemeColorInfo = this.hNH.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.gRH.getTabCount() > 0 && !v.isEmpty(this.hNG)) {
                    int min = Math.min(this.hNG.size(), this.gRH.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aF = this.gRH.aF(i2);
                        if (aF != null) {
                            if (frsViewData.isShowRedTip() && this.hNG.get(i2).tabId == 89) {
                                aF.j(0, true);
                            } else {
                                aF.j(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.getItem(f, 0);
                        if (this.hpm != null && this.hpm.bUO() != null && frsTabInfo2 != null) {
                            this.hpm.bUO().uZ(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.hpm != null && this.hpm.aWO() != null) {
                        if (f != null && f.size() < 2) {
                            this.hpm.aWO().removeHeaderView(this.huW);
                        } else {
                            this.hpm.aWO().removeHeaderView(this.huW);
                            this.hpm.aWO().addHeaderView(this.huW);
                            if (this.hNK != null && frsViewData.getForum() != null) {
                                this.hNK.setData(f);
                                this.hNK.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.hNG = tabData;
                    ccr();
                    cB(arrayList);
                }
            }
        }
    }

    private void ccr() {
        int i = -1;
        if (!v.isEmpty(this.hNG)) {
            i = this.hNG.get(0).tabId;
        }
        if (this.hNH != null) {
            this.hNH.mHeadLineDefaultNavTabId = i;
        }
        if (this.hpm != null) {
            this.hpm.mHeadLineDefaultNavTabId = i;
        }
    }

    private List<FrsTabInfo> f(FrsViewData frsViewData) {
        int i;
        Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().tab.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            FrsTabInfo next = it.next();
            if (next.tab_id.intValue() == 1) {
                i = next.tab_type.intValue();
                break;
            }
        }
        if (i == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().menu) {
            if (frsTabInfo.tab_type.intValue() == i) {
                arrayList.add(frsTabInfo);
            }
        }
        return arrayList;
    }

    private boolean a(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        b(tabData);
        if (!v.isEmpty(this.hNI.mFragments) && tabData.size() == this.hNI.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.hNI.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.hNI.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void b(TabData tabData) {
        if (!v.isEmpty(tabData)) {
            boolean isRegistedIntent = TbadkCoreApplication.getInst().isRegistedIntent(HotRanklistActivityConfig.class);
            ArrayList arrayList = new ArrayList();
            Iterator it = tabData.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                if (dVar != null && dVar.tabId == 401 && !isRegistedIntent) {
                    arrayList.add(dVar);
                }
            }
            tabData.removeAll(arrayList);
        }
    }

    public int ccs() {
        Iterator it = this.hNG.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b vC(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean vD(int i) {
        if (i < 0 || this.hNG == null || this.hNG.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.hNG.size()) {
                i2 = -1;
                break;
            } else if (this.hNG.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.gRH.getTabCount()) {
            return false;
        }
        TbTabLayout.e aF = this.gRH.aF(i2);
        if (aF != null && !aF.isSelected()) {
            aF.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d vE(int i) {
        if (i < 0 || this.hNG == null || this.hNG.size() <= 0) {
            return null;
        }
        Iterator it = this.hNG.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        int color;
        SvgManager.aUW().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.fev, R.drawable.personalize_tab_shadow);
        ccB();
        if (this.gRH != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.a.dT(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.a.dT(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.a.dT(this.mThemeColorInfo.day.font_color);
                } else {
                    color = am.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = am.getColor(R.color.plugin_button_shadow_red);
            }
            this.gRH.setSelectedTabIndicatorColor(color);
            am.setBackgroundColor(this.gRH, R.color.transparent);
            this.gRH.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.hNK != null && !isBrandForum()) {
            this.hNK.onChangeSkinType();
        }
        if (this.hNF != null) {
            this.hNF.changeSkinType(i);
        }
        if (!v.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void vF(int i) {
        this.hNM = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.hNG != null && position >= 0 && position < this.hNG.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.hNG.get(position);
            if (dVar != null) {
                this.hNQ = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.hNH != null && this.hNH.isShowRedTip()) {
                    this.hNH.setIsShowRedTip(false);
                    eVar.j(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.hpm.bVB() != null) {
                        this.hpm.bVB().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.hpm.bVB() != null) {
                    this.hpm.bVB().setIconFade(0);
                }
                if (this.hNL != null) {
                    this.hNL.bO(dVar.tabId, dVar.tabType);
                }
                com.baidu.tieba.frs.a.bTZ().mG(dVar.tabId == 503);
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12398").dh("fid", this.hpm.forumId).ag("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        ccy();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.hNG != null && position >= 0 && position < this.hNG.size() && (dVar = this.hNG.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12398").dh("fid", this.hpm.forumId).ag("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.hNH != null && this.hNH.isShowRedTip()) {
                    this.hNH.setIsShowRedTip(false);
                    eVar.j(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        return (!v.isEmpty(this.hNG) && tabData.size() == this.hNG.size() && this.hNG.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 92) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !vk(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void ei(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str2);
                    anVar.dh("obj_type", host);
                    TiebaStatic.log(anVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b c(final FrsTabInfo frsTabInfo) {
        final int intValue = frsTabInfo.tab_id.intValue();
        if (intValue == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.hpm != null && FrsTabViewController.this.hpm.bUT() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.hpm.bUT().bWp());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.hpm != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.hpm.getForumId());
                    }
                    bundle.putInt("tab_id", intValue);
                    bundle.putBoolean("isAdded", false);
                    frsAllThreadFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 301) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.hpm.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hpm.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hpm.getForumId());
                    bundle.putBoolean("isAdded", false);
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 503) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.hpm.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hpm.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hpm.getForumId());
                    bundle.putBoolean("isAdded", false);
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
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
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.hpm.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hpm.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hpm.getForumId());
                    bundle.putBoolean("isAdded", false);
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsADFragment;
                    cVar.type = 90;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            };
        }
        if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.11
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.hpm.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hpm.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hpm.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.hNH.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.hNH.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.hNH.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.hNH);
                    bundle.putBoolean("isAdded", false);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void cB(List<FrsTabInfo> list) {
        if (!v.isEmpty(list)) {
            this.hNJ = new com.baidu.tieba.frs.e(this.hpm.getActivity().getApplicationContext(), list);
            this.hNJ.setForumId(this.hpm.getForumId());
            this.hNJ.setForumName(this.hpm.getForumName());
            this.hNJ.setFrom(this.hpm.getFrom());
            if (this.hNH != null && this.hNH.getForum() != null) {
                this.hNJ.vH(this.hNH.getForum().getFirst_class());
                this.hNJ.vI(this.hNH.getForum().getSecond_class());
                this.hNJ.setForumGameLabel(this.hNH.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bS(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.hNJ.b(c);
                }
            }
            this.hNO = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.hNJ));
        }
    }

    private void bS(int i, int i2) {
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13008");
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.dh("fid", this.hpm.getForumId());
        if (i == 89) {
            anVar.ag("obj_type", 1);
        } else if (i == 302) {
            anVar.ag("obj_type", 3);
        } else if (i == 502) {
            anVar.ag("obj_type", 8);
        } else if (i == 90) {
            anVar.ag("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                anVar.ag("obj_type", 4);
            } else {
                anVar.ag("obj_type", 5);
            }
        } else if (i == 404) {
            anVar.ag("obj_type", 2);
        } else if (i == 301) {
            anVar.ag("obj_type", 7);
        } else if (i == 503) {
            anVar.ag("obj_type", 6);
        } else if (i == 504) {
            anVar.ag("obj_type", 11);
        }
        anVar.ag("obj_locate", i2);
        anVar.aUT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cct() {
        int color;
        int i;
        if (this.hNJ != null) {
            List<com.baidu.tbadk.mainTab.b> bUy = this.hNJ.bUy();
            if (!v.isEmpty(bUy) && !v.isEmpty(this.hNG)) {
                if (this.gRH.getTabCount() > 0) {
                    this.gRH.removeAllTabs();
                }
                ccu();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.a.dT(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.a.dT(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.a.dT(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = am.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = am.getColor(R.color.plugin_button_shadow_red);
                }
                this.gRH.setSelectedTabIndicatorColor(color);
                Iterator it = this.hNG.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, bUy);
                    if (m != null) {
                        TbTabLayout.e b2 = this.gRH.pn().b(dVar.name);
                        boolean z = this.hNH.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.hNH != null && this.hNH.isShowRedTip() && dVar.tabId == 89) {
                            b2.j(0, true);
                        } else {
                            b2.j(0, false);
                        }
                        this.gRH.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = m;
                        this.mFragments.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i3 = i3;
                    i2 = i;
                }
                if (this.gRH.getTabCount() > 0 && this.hNC.getVisibility() != 0) {
                    this.hNC.setVisibility(0);
                }
                this.hNI = new FragmentAdapter(this.hpm.getActivity().getSupportFragmentManager(), this.mFragments);
                this.hNE.setAdapter(this.hNI);
                this.hNI.notifyDataSetChanged();
                this.gRH.setupWithViewPager(this.hNE);
                this.hNE.setOffscreenPageLimit(this.mFragments.size());
                this.hNE.setCurrentItem(i3, false);
                this.hNE.bWP();
            }
        }
    }

    private void ccu() {
        if (this.hNE != null && this.hNI != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.hpm.getActivity().getSupportFragmentManager();
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

    private Fragment m(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            Bundle arguments = bVar.getFragmentTabStructure().frag.getArguments();
            if (arguments != null && i == bVar.getFragmentTabStructure().type && !arguments.getBoolean("isAdded")) {
                arguments.putBoolean("isAdded", true);
                bVar.getFragmentTabStructure().frag.setArguments(arguments);
                return bVar.getFragmentTabStructure().frag;
            }
        }
        return null;
    }

    public View ccv() {
        if (isBrandForum() || this.hNK == null) {
            return null;
        }
        return this.hNK.bYB();
    }

    public static boolean vk(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.hNL = aVar;
    }

    public void U(boolean z, boolean z2) {
        if (this.hNR != z) {
            this.hNR = z;
        }
        if (this.hNS != z2) {
            this.hNS = z2;
        }
        ccC();
    }

    /* loaded from: classes9.dex */
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
                    BaseFragment baseFragment = (BaseFragment) getItem(this.mPrimaryPosition);
                    if (baseFragment instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.hpm.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.hpm.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public String title;

        public b() {
        }
    }

    public b ccw() {
        if (this.hNE == null) {
            return null;
        }
        return (b) v.getItem(this.mFragments, this.hNE.getCurrentItem());
    }

    public void ccx() {
        this.hNN.aA(this.hpm.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void ccy() {
        this.hNN.Gu();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void vG(int i) {
        this.hqh = i;
        ccB();
    }

    public int ccz() {
        return this.hqh;
    }

    public int ccA() {
        return this.hNQ;
    }

    private void ccB() {
        if (this.hqh == 2) {
            am.setBackgroundColor(this.hNC, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hND, R.color.cp_bg_line_e);
            this.fev.setVisibility(0);
            this.hpm.bVs();
        } else if (this.hqh == 1) {
            am.setBackgroundColor(this.hNC, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hND, R.color.cp_bg_line_e);
            this.fev.setVisibility(0);
        } else {
            ccC();
            this.fev.setVisibility(8);
            if (this.hpm != null) {
                this.hpm.bVs();
            }
        }
    }

    private void ccC() {
        if (!this.hNR && !this.hNS) {
            am.setBackgroundColor(this.hNC, R.color.transparent);
            am.setBackgroundResource(this.hND, R.drawable.top_corners_bg);
            return;
        }
        am.setBackgroundColor(this.hND, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.hNC, R.color.cp_bg_line_e);
    }
}
