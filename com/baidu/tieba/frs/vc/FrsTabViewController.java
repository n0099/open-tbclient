package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.SmartAppFrsMountView;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
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
public class FrsTabViewController implements TbTabLayout.b, m {
    private View ent;
    private RelativeLayout gHJ;
    private View gMA;
    private TbTabLayout gMB;
    private FrsTabViewPager gMC;
    private View gMD;
    private SmartAppFrsMountView gME;
    private LinearGradientView gMF;
    private TabData gMG;
    private FrsViewData gMH;
    private FragmentAdapter gMI;
    private com.baidu.tieba.frs.e gMJ;
    private com.baidu.tieba.frs.entelechy.c.a.b gMK;
    private a gML;
    private com.baidu.tieba.c.d gMN;
    private RelativeLayout gMz;
    private FrsFragment gpX;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int gqQ = 0;
    private int gMM = -1;
    private boolean gMO = false;
    public boolean gMP = true;
    CustomMessageListener gMQ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.gMO) {
                FrsTabViewController.this.bKT();
                FrsTabViewController.this.gMO = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.gMC != null) {
                FrsTabViewController.this.gMC.bFD();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener gMR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.gMH != null && FrsTabViewController.this.gMH.isShowRedTip() != booleanValue && FrsTabViewController.this.gMB.getTabCount() > 0 && !v.isEmpty(FrsTabViewController.this.gMG)) {
                        FrsTabViewController.this.gMH.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.gMG.size(), FrsTabViewController.this.gMB.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e as = FrsTabViewController.this.gMB.as(i);
                            if (as != null) {
                                if (FrsTabViewController.this.gMG.get(i).tabId == 89) {
                                    as.g(0, booleanValue);
                                } else {
                                    as.g(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eqY = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bKW;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bKW = FrsTabViewController.this.bKW()) != null && bKW.fragment != null && (bKW.fragment instanceof ah)) {
                        ((ah) bKW.fragment).bdo();
                    }
                }
            }
        }
    };
    private CustomMessageListener gMS = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.gMG.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.gMG.size()) {
                    FrsTabViewController.this.gMC.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener gMT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.gMN.zx();
        }
    };
    private View.OnClickListener gMU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void mA(int i);
    }

    public void mh(boolean z) {
        this.gMB.setDisableTabSelect(z);
    }

    public FrsTabViewPager bKP() {
        return this.gMC;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.gpX = frsFragment;
        this.gMz = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.gMA = view.findViewById(R.id.frs_tab_bg);
        this.ent = view.findViewById(R.id.divider_shadow);
        this.gMF = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.gMB = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.gMB.setOnTabSelectedListener(this);
        this.gMB.setSelectedTabTextBlod(true);
        this.gMB.setTabTextSize(up(R.dimen.tbds46));
        this.gMD = view.findViewById(R.id.fading_edge_view);
        this.gME = (SmartAppFrsMountView) view.findViewById(R.id.frs_tab_arrow);
        this.gME.setOnClickListener(this.gMU);
        this.gMN = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.gMB);
        this.gMN.ck(R.drawable.bg_tip_blue_up_left);
        this.gMN.cj(16);
        this.gMN.setUseDirectOffset(true);
        this.gMN.rz(up(R.dimen.tbds34));
        this.gMN.setYOffset(up(R.dimen.tbds10));
        this.gMN.c(this.gMT);
        this.gMC = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.gMI = new FragmentAdapter(this.gpX.getActivity().getSupportFragmentManager(), this.mFragments);
        this.gMC.addOnPageChangeListener(this.mOnPageChangeListener);
        this.gHJ = new RelativeLayout(this.gpX.getContext());
        this.gMK = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.gHJ);
    }

    private int up(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bKQ() {
        return this.gHJ;
    }

    public View bKR() {
        return this.gMF;
    }

    private boolean isBrandForum() {
        return this.gMH != null && this.gMH.getIsBrandForum();
    }

    public void registerListener() {
        this.gMQ.setPriority(Integer.MAX_VALUE);
        this.gpX.registerListener(this.gMQ);
        this.gpX.registerListener(this.gMR);
        this.gpX.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.eqY, this.gpX.getBaseFragmentActivity().getUniqueId());
        this.gpX.registerListener(this.gMS);
    }

    @Override // com.baidu.tieba.frs.vc.m
    public void a(FrsViewData frsViewData, int i) {
        AccountData currentAccountObj;
        String str;
        String str2;
        boolean z;
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().tab != null) {
            if (!v.isEmpty(frsViewData.smartAppAvatar)) {
                if (frsViewData.smartApp != null && !TextUtils.isEmpty(frsViewData.smartApp.name)) {
                    this.gME.setData(frsViewData.smartApp.name, frsViewData.smartAppAvatar);
                } else {
                    this.gME.setData("", frsViewData.smartAppAvatar);
                }
                this.gME.setVisibility(0);
                this.gMD.setVisibility(0);
            } else {
                this.gME.setVisibility(8);
                this.gMD.setVisibility(8);
            }
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    if (frsTabInfo.tab_id.intValue() == 89 || frsTabInfo.tab_id.intValue() == 503) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.tabId = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        tabData.add(dVar);
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
                            int BM = com.baidu.tieba.frs.f.g.BM("503~" + str + str2);
                            if (BM == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aC("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == BM) {
                                                com.baidu.tieba.tbadkCore.util.e.cLY();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cLZ();
                                            }
                                        }
                                    }
                                }
                            }
                        }
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
                            sb.append("fid");
                            sb.append(ETAG.EQUAL);
                            sb.append(frsViewData.getForum().getId());
                            dVar3.url = sb.toString();
                            du(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && tZ(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.sj(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && aa.bFC().tb(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        y sY = x.bFB().sY(dVar5.tabId);
                        if (sY != null && sY.grT != null && sY.grT.size() > 0) {
                            dVar5.gJS = new at();
                            dVar5.gJS.grS = sY.grS;
                            dVar5.gJS.grT = new LinkedList();
                            boolean z2 = true;
                            for (w wVar : sY.grT) {
                                if (wVar != null) {
                                    as asVar = new as();
                                    asVar.name = wVar.name;
                                    asVar.grP = wVar.grP;
                                    if (z2) {
                                        asVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.gJS.grT.add(asVar);
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
                        y sY2 = x.bFB().sY(dVar6.tabId);
                        if (sY2 != null && sY2.grT != null && sY2.grT.size() > 0) {
                            dVar6.gJS = new at();
                            dVar6.gJS.grS = sY2.grS;
                            dVar6.gJS.grT = new LinkedList();
                            for (w wVar2 : sY2.grT) {
                                if (wVar2 != null) {
                                    as asVar2 = new as();
                                    asVar2.name = wVar2.name;
                                    asVar2.grP = wVar2.grP;
                                    dVar6.gJS.grT.add(asVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.gpX.bDN().bFd().p(bj.cRz)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.gMM > 0 && this.gMM != frsViewData.getAlaLiveCount() && this.gMM <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.gMM + ")";
                            } else if (this.gMM > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.gMM == 0 && this.gMM != frsViewData.getAlaLiveCount()) {
                                dVar7.name = frsTabInfo.tab_name;
                            }
                            dVar7.tabId = frsTabInfo.tab_id.intValue();
                            tabData.add(dVar7);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if ((com.baidu.tbadk.core.sharedPref.b.aFB().getInt("chushou_game_tab", 1) == 1) && TbadkCoreApplication.isChushouInit) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.name = frsTabInfo.tab_name;
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                        dVar9.tabId = frsTabInfo.tab_id.intValue();
                        dVar9.name = frsTabInfo.tab_name;
                        tabData.add(dVar9);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 90) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 91) {
                        com.baidu.tieba.frs.tab.d dVar11 = new com.baidu.tieba.frs.tab.d();
                        dVar11.tabId = frsTabInfo.tab_id.intValue();
                        dVar11.name = aq.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
                        tabData.add(dVar11);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 504) {
                        com.baidu.tieba.frs.tab.d dVar12 = new com.baidu.tieba.frs.tab.d();
                        dVar12.tabId = frsTabInfo.tab_id.intValue();
                        dVar12.name = frsTabInfo.tab_name;
                        tabData.add(dVar12);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.gMH = frsViewData;
                if (this.gMH.getForum() != null) {
                    this.mThemeColorInfo = this.gMH.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.gMB.getTabCount() > 0 && !v.isEmpty(this.gMG)) {
                    int min = Math.min(this.gMG.size(), this.gMB.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e as = this.gMB.as(i2);
                        if (as != null) {
                            if (frsViewData.isShowRedTip() && this.gMG.get(i2).tabId == 89) {
                                as.g(0, true);
                            } else {
                                as.g(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.getItem(f, 0);
                        if (this.gpX != null && this.gpX.bDI() != null && frsTabInfo2 != null) {
                            this.gpX.bDI().tN(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.gpX != null && this.gpX.aIf() != null) {
                        if (f.size() < 2) {
                            this.gpX.aIf().removeHeaderView(this.gHJ);
                        } else {
                            this.gpX.aIf().removeHeaderView(this.gHJ);
                            this.gpX.aIf().addHeaderView(this.gHJ);
                            if (this.gMK != null && frsViewData.getForum() != null) {
                                this.gMK.setData(f, i);
                                this.gMK.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.gMG = tabData;
                    bKS();
                    cr(arrayList);
                }
            }
        }
    }

    private void bKS() {
        int i = -1;
        if (!v.isEmpty(this.gMG)) {
            i = this.gMG.get(0).tabId;
        }
        if (this.gMH != null) {
            this.gMH.mHeadLineDefaultNavTabId = i;
        }
        if (this.gpX != null) {
            this.gpX.mHeadLineDefaultNavTabId = i;
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
        if (!v.isEmpty(this.gMI.mFragments) && tabData.size() == this.gMI.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.gMI.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.gMI.mFragments.get(i)).tabId) {
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

    @Override // com.baidu.tieba.frs.vc.m
    public boolean uq(int i) {
        if (i < 0 || this.gMG == null || this.gMG.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.gMG.size()) {
                i2 = -1;
                break;
            } else if (this.gMG.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.gMB.getTabCount()) {
            return false;
        }
        TbTabLayout.e as = this.gMB.as(i2);
        if (as != null && !as.isSelected()) {
            as.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d ur(int i) {
        if (i < 0 || this.gMG == null || this.gMG.size() <= 0) {
            return null;
        }
        Iterator it = this.gMG.iterator();
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
        SvgManager.aGA().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.ent, R.drawable.personalize_tab_shadow);
        bLa();
        if (this.gMB != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.a.cG(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.a.cG(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.a.cG(this.mThemeColorInfo.day.font_color);
                } else {
                    color = am.getColor(R.color.cp_link_tip_a);
                }
            } else {
                color = am.getColor(R.color.cp_link_tip_a);
            }
            this.gMB.setSelectedTabIndicatorColor(color);
            this.gMB.setBackgroundColor(0);
            this.gMB.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.gMK != null && !isBrandForum()) {
            this.gMK.onChangeSkinType();
        }
        if (this.gME != null) {
            this.gME.onChangeSkinType();
        }
        if (this.gMF != null) {
            this.gMF.changeSkinType(i);
        }
        if (!v.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void us(int i) {
        this.gMM = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.gMG != null && position >= 0 && position < this.gMG.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.gMG.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gMH != null && this.gMH.isShowRedTip()) {
                    this.gMH.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.gpX.bEt() != null) {
                        this.gpX.bEt().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.gpX.bEt() != null) {
                    this.gpX.bEt().setIconFade(0);
                }
                if (this.gML != null) {
                    this.gML.mA(dVar.tabId);
                }
                com.baidu.tieba.frs.a.bCT().lb(dVar.tabId == 301);
                TiebaStatic.log(new an("c12398").cy("fid", this.gpX.forumId).X("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bKY();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.gMG != null && position >= 0 && position < this.gMG.size() && (dVar = this.gMG.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new an("c12398").cy("fid", this.gpX.forumId).X("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gMH != null && this.gMH.isShowRedTip()) {
                    this.gMH.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        return (!v.isEmpty(this.gMG) && tabData.size() == this.gMG.size() && this.gMG.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 92) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !tZ(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void du(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    an anVar = new an(str2);
                    anVar.cy("obj_type", host);
                    TiebaStatic.log(anVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b c(FrsTabInfo frsTabInfo) {
        final int intValue = frsTabInfo.tab_id.intValue();
        if (intValue == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.gpX != null && FrsTabViewController.this.gpX.bDN() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.gpX.bDN().bFe());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.gpX != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.gpX.getForumId());
                    }
                    bundle.putInt("tab_id", intValue);
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gpX.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gpX.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gpX.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gpX.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gpX.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gpX.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.11
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gpX.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gpX.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gpX.getForumId());
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
        if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.12
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gpX.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gpX.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gpX.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.gMH.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.gMH.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.gMH.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.gMH);
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

    private void cr(List<FrsTabInfo> list) {
        if (!v.isEmpty(list)) {
            this.gMJ = new com.baidu.tieba.frs.e(this.gpX.getActivity().getApplicationContext(), list);
            this.gMJ.setForumId(this.gpX.getForumId());
            this.gMJ.setForumName(this.gpX.getForumName());
            this.gMJ.setFrom(this.gpX.getFrom());
            if (this.gMH != null && this.gMH.getForum() != null) {
                this.gMJ.sL(this.gMH.getForum().getFirst_class());
                this.gMJ.sM(this.gMH.getForum().getSecond_class());
                this.gMJ.setForumGameLabel(this.gMH.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bG(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.gMJ.b(c);
                }
            }
            this.gMO = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.gMJ));
        }
    }

    private void bG(int i, int i2) {
        an anVar = new an("c13008");
        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cy("fid", this.gpX.getForumId());
        if (i == 89) {
            anVar.X("obj_type", 1);
        } else if (i == 302) {
            anVar.X("obj_type", 3);
        } else if (i == 502) {
            anVar.X("obj_type", 8);
        } else if (i == 90) {
            anVar.X("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                anVar.X("obj_type", 4);
            } else {
                anVar.X("obj_type", 5);
            }
        } else if (i == 404) {
            anVar.X("obj_type", 2);
        } else if (i == 301) {
            anVar.X("obj_type", 7);
        } else if (i == 503) {
            anVar.X("obj_type", 6);
        } else if (i == 504) {
            anVar.X("obj_type", 11);
        }
        anVar.X("obj_locate", i2);
        anVar.aGx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKT() {
        int color;
        int i;
        if (this.gMJ != null) {
            List<com.baidu.tbadk.mainTab.b> bDt = this.gMJ.bDt();
            if (!v.isEmpty(bDt) && !v.isEmpty(this.gMG)) {
                if (this.gMB.getTabCount() > 0) {
                    this.gMB.removeAllTabs();
                }
                bKU();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.a.cG(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.a.cG(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.a.cG(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = am.getColor(R.color.cp_link_tip_a);
                    }
                } else {
                    color = am.getColor(R.color.cp_link_tip_a);
                }
                this.gMB.setSelectedTabIndicatorColor(color);
                Iterator it = this.gMG.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment l = l(dVar.tabId, bDt);
                    if (l != null) {
                        TbTabLayout.e b2 = this.gMB.kD().b(dVar.name);
                        boolean z = this.gMH.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.gMH != null && this.gMH.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.gMB.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = l;
                        this.mFragments.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i3 = i3;
                    i2 = i;
                }
                if (this.gMB.getTabCount() > 0 && this.gMz.getVisibility() != 0) {
                    this.gMz.setVisibility(0);
                }
                this.gMI = new FragmentAdapter(this.gpX.getActivity().getSupportFragmentManager(), this.mFragments);
                this.gMC.setAdapter(this.gMI);
                this.gMI.notifyDataSetChanged();
                this.gMB.setupWithViewPager(this.gMC);
                this.gMC.setOffscreenPageLimit(this.mFragments.size());
                this.gMC.setCurrentItem(i3, false);
                this.gMC.bFD();
            }
        }
    }

    private void bKU() {
        if (this.gMC != null && this.gMI != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.gpX.getActivity().getSupportFragmentManager();
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

    private Fragment l(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.getFragmentTabStructure().type) {
                return bVar.getFragmentTabStructure().frag;
            }
        }
        return null;
    }

    public View bKV() {
        if (isBrandForum() || this.gMK == null) {
            return null;
        }
        return this.gMK.bHp();
    }

    public static boolean tZ(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.gML = aVar;
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
                        FrsTabViewController.this.gpX.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.gpX.setPrimary(true);
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

    public b bKW() {
        if (this.gMC == null) {
            return null;
        }
        return (b) v.getItem(this.mFragments, this.gMC.getCurrentItem());
    }

    public void bKX() {
        this.gMN.aj(this.gpX.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void bKY() {
        this.gMN.zx();
    }

    @Override // com.baidu.tieba.frs.vc.m
    public void ut(int i) {
        this.gqQ = i;
        bLa();
    }

    public int bKZ() {
        return this.gqQ;
    }

    private void bLa() {
        if (this.gqQ == 2) {
            am.setBackgroundColor(this.gMz, R.color.cp_bg_line_h);
            am.setBackgroundColor(this.gMA, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gMD, R.drawable.frs_tab_sticky_fading_edge);
            this.ent.setVisibility(0);
            this.gpX.bEl();
        } else if (this.gqQ == 1) {
            am.setBackgroundColor(this.gMz, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gMA, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gMD, R.drawable.frs_tab_sticky_fading_edge);
            this.ent.setVisibility(0);
        } else {
            if (this.gpX != null && this.gpX.bDS()) {
                am.setBackgroundColor(this.gMz, R.color.transparent);
            } else {
                am.setBackgroundColor(this.gMz, R.color.cp_bg_line_c);
            }
            am.setBackgroundResource(this.gMA, R.drawable.top_corners_bg);
            am.setBackgroundResource(this.gMD, R.drawable.frs_tab_fading_edge);
            this.ent.setVisibility(8);
            if (this.gpX != null) {
                this.gpX.bEl();
            }
        }
    }
}
