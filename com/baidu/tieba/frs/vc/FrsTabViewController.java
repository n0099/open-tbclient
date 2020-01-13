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
/* loaded from: classes7.dex */
public class FrsTabViewController implements TbTabLayout.b, m {
    private View ejk;
    private RelativeLayout gFK;
    private RelativeLayout gKA;
    private View gKB;
    private TbTabLayout gKC;
    private FrsTabViewPager gKD;
    private View gKE;
    private SmartAppFrsMountView gKF;
    private LinearGradientView gKG;
    private TabData gKH;
    private FrsViewData gKI;
    private FragmentAdapter gKJ;
    private com.baidu.tieba.frs.e gKK;
    private com.baidu.tieba.frs.entelechy.c.a.b gKL;
    private a gKM;
    private com.baidu.tieba.c.d gKO;
    private FrsFragment gnW;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int goP = 0;
    private int gKN = -1;
    private boolean gKP = false;
    public boolean gKQ = true;
    CustomMessageListener gKR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.gKP) {
                FrsTabViewController.this.bJs();
                FrsTabViewController.this.gKP = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.gKD != null) {
                FrsTabViewController.this.gKD.bEa();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener gKS = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.gKI != null && FrsTabViewController.this.gKI.isShowRedTip() != booleanValue && FrsTabViewController.this.gKC.getTabCount() > 0 && !v.isEmpty(FrsTabViewController.this.gKH)) {
                        FrsTabViewController.this.gKI.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.gKH.size(), FrsTabViewController.this.gKC.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e ap = FrsTabViewController.this.gKC.ap(i);
                            if (ap != null) {
                                if (FrsTabViewController.this.gKH.get(i).tabId == 89) {
                                    ap.g(0, booleanValue);
                                } else {
                                    ap.g(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener emK = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bJv;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bJv = FrsTabViewController.this.bJv()) != null && bJv.fragment != null && (bJv.fragment instanceof ah)) {
                        ((ah) bJv.fragment).baZ();
                    }
                }
            }
        }
    };
    private CustomMessageListener gKT = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.gKH.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.gKH.size()) {
                    FrsTabViewController.this.gKD.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener gKU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.gKO.xg();
        }
    };
    private View.OnClickListener gKV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void mi(int i);
    }

    public void mf(boolean z) {
        this.gKC.setDisableTabSelect(z);
    }

    public FrsTabViewPager bJo() {
        return this.gKD;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.gnW = frsFragment;
        this.gKA = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.gKB = view.findViewById(R.id.frs_tab_bg);
        this.ejk = view.findViewById(R.id.divider_shadow);
        this.gKG = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.gKC = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.gKC.setOnTabSelectedListener(this);
        this.gKC.setSelectedTabTextBlod(true);
        this.gKC.setTabTextSize(uj(R.dimen.tbds46));
        this.gKE = view.findViewById(R.id.fading_edge_view);
        this.gKF = (SmartAppFrsMountView) view.findViewById(R.id.frs_tab_arrow);
        this.gKF.setOnClickListener(this.gKV);
        this.gKO = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.gKC);
        this.gKO.bU(R.drawable.bg_tip_blue_up_left);
        this.gKO.bT(16);
        this.gKO.setUseDirectOffset(true);
        this.gKO.rs(uj(R.dimen.tbds34));
        this.gKO.setYOffset(uj(R.dimen.tbds10));
        this.gKO.c(this.gKU);
        this.gKD = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.gKJ = new FragmentAdapter(this.gnW.getActivity().getSupportFragmentManager(), this.mFragments);
        this.gKD.addOnPageChangeListener(this.mOnPageChangeListener);
        this.gFK = new RelativeLayout(this.gnW.getContext());
        this.gKL = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.gFK);
    }

    private int uj(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bJp() {
        return this.gFK;
    }

    public View bJq() {
        return this.gKG;
    }

    private boolean isBrandForum() {
        return this.gKI != null && this.gKI.getIsBrandForum();
    }

    public void registerListener() {
        this.gKR.setPriority(Integer.MAX_VALUE);
        this.gnW.registerListener(this.gKR);
        this.gnW.registerListener(this.gKS);
        this.gnW.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.emK, this.gnW.getBaseFragmentActivity().getUniqueId());
        this.gnW.registerListener(this.gKT);
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
                    this.gKF.setData(frsViewData.smartApp.name, frsViewData.smartAppAvatar);
                } else {
                    this.gKF.setData("", frsViewData.smartAppAvatar);
                }
                this.gKF.setVisibility(0);
                this.gKE.setVisibility(0);
            } else {
                this.gKF.setVisibility(8);
                this.gKE.setVisibility(8);
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
                            int Bw = com.baidu.tieba.frs.f.g.Bw("503~" + str + str2);
                            if (Bw == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aE("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == Bw) {
                                                com.baidu.tieba.tbadkCore.util.e.cKy();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cKz();
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
                            dl(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && tT(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.rT(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && aa.bDZ().sV(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        y sS = x.bDY().sS(dVar5.tabId);
                        if (sS != null && sS.gpS != null && sS.gpS.size() > 0) {
                            dVar5.gHT = new at();
                            dVar5.gHT.gpR = sS.gpR;
                            dVar5.gHT.gpS = new LinkedList();
                            boolean z2 = true;
                            for (w wVar : sS.gpS) {
                                if (wVar != null) {
                                    as asVar = new as();
                                    asVar.name = wVar.name;
                                    asVar.gpO = wVar.gpO;
                                    if (z2) {
                                        asVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.gHT.gpS.add(asVar);
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
                        y sS2 = x.bDY().sS(dVar6.tabId);
                        if (sS2 != null && sS2.gpS != null && sS2.gpS.size() > 0) {
                            dVar6.gHT = new at();
                            dVar6.gHT.gpR = sS2.gpR;
                            dVar6.gHT.gpS = new LinkedList();
                            for (w wVar2 : sS2.gpS) {
                                if (wVar2 != null) {
                                    as asVar2 = new as();
                                    asVar2.name = wVar2.name;
                                    asVar2.gpO = wVar2.gpO;
                                    dVar6.gHT.gpS.add(asVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.gnW.bCk().bDA().p(bj.cNw)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.gKN > 0 && this.gKN != frsViewData.getAlaLiveCount() && this.gKN <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.gKN + ")";
                            } else if (this.gKN > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.gKN == 0 && this.gKN != frsViewData.getAlaLiveCount()) {
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
                        dVar9.name = aq.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
                        tabData.add(dVar9);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 504) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.gKI = frsViewData;
                if (this.gKI.getForum() != null) {
                    this.mThemeColorInfo = this.gKI.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.gKC.getTabCount() > 0 && !v.isEmpty(this.gKH)) {
                    int min = Math.min(this.gKH.size(), this.gKC.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e ap = this.gKC.ap(i2);
                        if (ap != null) {
                            if (frsViewData.isShowRedTip() && this.gKH.get(i2).tabId == 89) {
                                ap.g(0, true);
                            } else {
                                ap.g(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.getItem(f, 0);
                        if (this.gnW != null && this.gnW.bCf() != null && frsTabInfo2 != null) {
                            this.gnW.bCf().tH(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.gnW != null && this.gnW.aFQ() != null) {
                        if (f.size() < 2) {
                            this.gnW.aFQ().removeHeaderView(this.gFK);
                        } else {
                            this.gnW.aFQ().removeHeaderView(this.gFK);
                            this.gnW.aFQ().addHeaderView(this.gFK);
                            if (this.gKL != null && frsViewData.getForum() != null) {
                                this.gKL.setData(f, i);
                                this.gKL.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.gKH = tabData;
                    bJr();
                    cv(arrayList);
                }
            }
        }
    }

    private void bJr() {
        int i = -1;
        if (!v.isEmpty(this.gKH)) {
            i = this.gKH.get(0).tabId;
        }
        if (this.gKI != null) {
            this.gKI.mHeadLineDefaultNavTabId = i;
        }
        if (this.gnW != null) {
            this.gnW.mHeadLineDefaultNavTabId = i;
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
        if (!v.isEmpty(this.gKJ.mFragments) && tabData.size() == this.gKJ.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.gKJ.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.gKJ.mFragments.get(i)).tabId) {
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
    public boolean uk(int i) {
        if (i < 0 || this.gKH == null || this.gKH.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.gKH.size()) {
                i2 = -1;
                break;
            } else if (this.gKH.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.gKC.getTabCount()) {
            return false;
        }
        TbTabLayout.e ap = this.gKC.ap(i2);
        if (ap != null && !ap.isSelected()) {
            ap.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d ul(int i) {
        if (i < 0 || this.gKH == null || this.gKH.size() <= 0) {
            return null;
        }
        Iterator it = this.gKH.iterator();
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
        SvgManager.aEp().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.ejk, R.drawable.personalize_tab_shadow);
        bJz();
        if (this.gKC != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.day.font_color);
                } else {
                    color = am.getColor(R.color.cp_link_tip_a);
                }
            } else {
                color = am.getColor(R.color.cp_link_tip_a);
            }
            this.gKC.setSelectedTabIndicatorColor(color);
            this.gKC.setBackgroundColor(0);
            this.gKC.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.gKL != null && !isBrandForum()) {
            this.gKL.onChangeSkinType();
        }
        if (this.gKF != null) {
            this.gKF.onChangeSkinType();
        }
        if (this.gKG != null) {
            this.gKG.changeSkinType(i);
        }
        if (!v.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void um(int i) {
        this.gKN = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.gKH != null && position >= 0 && position < this.gKH.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.gKH.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gKI != null && this.gKI.isShowRedTip()) {
                    this.gKI.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.gnW.bCQ() != null) {
                        this.gnW.bCQ().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.gnW.bCQ() != null) {
                    this.gnW.bCQ().setIconFade(0);
                }
                if (this.gKM != null) {
                    this.gKM.mi(dVar.tabId);
                }
                com.baidu.tieba.frs.a.bBr().kX(dVar.tabId == 301);
                TiebaStatic.log(new an("c12398").cp("fid", this.gnW.forumId).Z("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bJx();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.gKH != null && position >= 0 && position < this.gKH.size() && (dVar = this.gKH.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new an("c12398").cp("fid", this.gnW.forumId).Z("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gKI != null && this.gKI.isShowRedTip()) {
                    this.gKI.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        return (!v.isEmpty(this.gKH) && tabData.size() == this.gKH.size() && this.gKH.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !tT(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void dl(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    an anVar = new an(str2);
                    anVar.cp("obj_type", host);
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
                public com.baidu.tbadk.mainTab.c aNx() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.gnW != null && FrsTabViewController.this.gnW.bCk() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.gnW.bCk().bDB());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.gnW != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.gnW.getForumId());
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
                public TbFragmentTabIndicator dW(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 301 || intValue == 303) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c aNx() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gnW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gnW.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gnW.getForumId());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator dW(Context context) {
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
                public com.baidu.tbadk.mainTab.c aNx() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gnW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gnW.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gnW.getForumId());
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator dW(Context context) {
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
                public com.baidu.tbadk.mainTab.c aNx() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gnW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gnW.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gnW.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsADFragment;
                    cVar.type = 90;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator dW(Context context) {
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
                public com.baidu.tbadk.mainTab.c aNx() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gnW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gnW.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gnW.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.gKI.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.gKI.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.gKI.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.gKI);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator dW(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void cv(List<FrsTabInfo> list) {
        if (!v.isEmpty(list)) {
            this.gKK = new com.baidu.tieba.frs.e(this.gnW.getActivity().getApplicationContext(), list);
            this.gKK.setForumId(this.gnW.getForumId());
            this.gKK.setForumName(this.gnW.getForumName());
            this.gKK.setFrom(this.gnW.getFrom());
            if (this.gKI != null && this.gKI.getForum() != null) {
                this.gKK.sv(this.gKI.getForum().getFirst_class());
                this.gKK.sw(this.gKI.getForum().getSecond_class());
                this.gKK.setForumGameLabel(this.gKI.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bF(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.gKK.b(c);
                }
            }
            this.gKP = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.gKK));
        }
    }

    private void bF(int i, int i2) {
        an anVar = new an("c13008");
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cp("fid", this.gnW.getForumId());
        if (i == 89) {
            anVar.Z("obj_type", 1);
        } else if (i == 302) {
            anVar.Z("obj_type", 3);
        } else if (i == 502) {
            anVar.Z("obj_type", 8);
        } else if (i == 90) {
            anVar.Z("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                anVar.Z("obj_type", 4);
            } else {
                anVar.Z("obj_type", 5);
            }
        } else if (i == 404) {
            anVar.Z("obj_type", 2);
        } else if (i == 301 || i == 303) {
            anVar.Z("obj_type", 7);
        } else if (i == 503) {
            anVar.Z("obj_type", 6);
        } else if (i == 504) {
            anVar.Z("obj_type", 11);
        }
        anVar.Z("obj_locate", i2);
        anVar.aEm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJs() {
        int color;
        int i;
        if (this.gKK != null) {
            List<com.baidu.tbadk.mainTab.b> bBQ = this.gKK.bBQ();
            if (!v.isEmpty(bBQ) && !v.isEmpty(this.gKH)) {
                if (this.gKC.getTabCount() > 0) {
                    this.gKC.removeAllTabs();
                }
                bJt();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = am.getColor(R.color.cp_link_tip_a);
                    }
                } else {
                    color = am.getColor(R.color.cp_link_tip_a);
                }
                this.gKC.setSelectedTabIndicatorColor(color);
                Iterator it = this.gKH.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment l = l(dVar.tabId, bBQ);
                    if (l != null) {
                        TbTabLayout.e b2 = this.gKC.ko().b(dVar.name);
                        boolean z = this.gKI.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.gKI != null && this.gKI.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.gKC.a(b2, z);
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
                if (this.gKC.getTabCount() > 0 && this.gKA.getVisibility() != 0) {
                    this.gKA.setVisibility(0);
                }
                this.gKJ = new FragmentAdapter(this.gnW.getActivity().getSupportFragmentManager(), this.mFragments);
                this.gKD.setAdapter(this.gKJ);
                this.gKJ.notifyDataSetChanged();
                this.gKC.setupWithViewPager(this.gKD);
                this.gKD.setOffscreenPageLimit(this.mFragments.size());
                this.gKD.setCurrentItem(i3, false);
                this.gKD.bEa();
            }
        }
    }

    private void bJt() {
        if (this.gKD != null && this.gKJ != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.gnW.getActivity().getSupportFragmentManager();
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
            if (i == bVar.aNy().type) {
                return bVar.aNy().frag;
            }
        }
        return null;
    }

    public View bJu() {
        if (isBrandForum() || this.gKL == null) {
            return null;
        }
        return this.gKL.bFN();
    }

    public static boolean tT(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.gKM = aVar;
    }

    /* loaded from: classes7.dex */
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
                        FrsTabViewController.this.gnW.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.gnW.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public String title;

        public b() {
        }
    }

    public b bJv() {
        if (this.gKD == null) {
            return null;
        }
        return (b) v.getItem(this.mFragments, this.gKD.getCurrentItem());
    }

    public void bJw() {
        this.gKO.Y(this.gnW.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void bJx() {
        this.gKO.xg();
    }

    @Override // com.baidu.tieba.frs.vc.m
    public void un(int i) {
        this.goP = i;
        bJz();
    }

    public int bJy() {
        return this.goP;
    }

    private void bJz() {
        if (this.goP == 2) {
            am.setBackgroundColor(this.gKA, R.color.cp_bg_line_h);
            am.setBackgroundColor(this.gKB, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gKE, R.drawable.frs_tab_sticky_fading_edge);
            this.ejk.setVisibility(0);
            this.gnW.bCI();
        } else if (this.goP == 1) {
            am.setBackgroundColor(this.gKA, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gKB, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gKE, R.drawable.frs_tab_sticky_fading_edge);
            this.ejk.setVisibility(0);
        } else {
            if (this.gnW != null && this.gnW.bCp()) {
                am.setBackgroundColor(this.gKA, R.color.transparent);
            } else {
                am.setBackgroundColor(this.gKA, R.color.cp_bg_line_c);
            }
            am.setBackgroundResource(this.gKB, R.drawable.top_corners_bg);
            am.setBackgroundResource(this.gKE, R.drawable.frs_tab_fading_edge);
            this.ejk.setVisibility(8);
            if (this.gnW != null) {
                this.gnW.bCI();
            }
        }
    }
}
