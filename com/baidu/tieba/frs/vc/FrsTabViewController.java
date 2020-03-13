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
    private View enI;
    private RelativeLayout gHX;
    private RelativeLayout gMN;
    private View gMO;
    private TbTabLayout gMP;
    private FrsTabViewPager gMQ;
    private View gMR;
    private SmartAppFrsMountView gMS;
    private LinearGradientView gMT;
    private TabData gMU;
    private FrsViewData gMV;
    private FragmentAdapter gMW;
    private com.baidu.tieba.frs.e gMX;
    private com.baidu.tieba.frs.entelechy.c.a.b gMY;
    private a gMZ;
    private com.baidu.tieba.c.d gNb;
    private FrsFragment gqm;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int grf = 0;
    private int gNa = -1;
    private boolean gNc = false;
    public boolean gNd = true;
    CustomMessageListener gNe = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.gNc) {
                FrsTabViewController.this.bKW();
                FrsTabViewController.this.gNc = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.gMQ != null) {
                FrsTabViewController.this.gMQ.bFG();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener gNf = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.gMV != null && FrsTabViewController.this.gMV.isShowRedTip() != booleanValue && FrsTabViewController.this.gMP.getTabCount() > 0 && !v.isEmpty(FrsTabViewController.this.gMU)) {
                        FrsTabViewController.this.gMV.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.gMU.size(), FrsTabViewController.this.gMP.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e as = FrsTabViewController.this.gMP.as(i);
                            if (as != null) {
                                if (FrsTabViewController.this.gMU.get(i).tabId == 89) {
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
    private CustomMessageListener erm = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bKZ;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bKZ = FrsTabViewController.this.bKZ()) != null && bKZ.fragment != null && (bKZ.fragment instanceof ah)) {
                        ((ah) bKZ.fragment).bdr();
                    }
                }
            }
        }
    };
    private CustomMessageListener gNg = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.gMU.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.gMU.size()) {
                    FrsTabViewController.this.gMQ.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener gNh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.gNb.zz();
        }
    };
    private View.OnClickListener gNi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
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
        this.gMP.setDisableTabSelect(z);
    }

    public FrsTabViewPager bKS() {
        return this.gMQ;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.gqm = frsFragment;
        this.gMN = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.gMO = view.findViewById(R.id.frs_tab_bg);
        this.enI = view.findViewById(R.id.divider_shadow);
        this.gMT = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.gMP = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.gMP.setOnTabSelectedListener(this);
        this.gMP.setSelectedTabTextBlod(true);
        this.gMP.setTabTextSize(up(R.dimen.tbds46));
        this.gMR = view.findViewById(R.id.fading_edge_view);
        this.gMS = (SmartAppFrsMountView) view.findViewById(R.id.frs_tab_arrow);
        this.gMS.setOnClickListener(this.gNi);
        this.gNb = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.gMP);
        this.gNb.ck(R.drawable.bg_tip_blue_up_left);
        this.gNb.cj(16);
        this.gNb.setUseDirectOffset(true);
        this.gNb.rz(up(R.dimen.tbds34));
        this.gNb.setYOffset(up(R.dimen.tbds10));
        this.gNb.c(this.gNh);
        this.gMQ = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.gMW = new FragmentAdapter(this.gqm.getActivity().getSupportFragmentManager(), this.mFragments);
        this.gMQ.addOnPageChangeListener(this.mOnPageChangeListener);
        this.gHX = new RelativeLayout(this.gqm.getContext());
        this.gMY = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.gHX);
    }

    private int up(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bKT() {
        return this.gHX;
    }

    public View bKU() {
        return this.gMT;
    }

    private boolean isBrandForum() {
        return this.gMV != null && this.gMV.getIsBrandForum();
    }

    public void registerListener() {
        this.gNe.setPriority(Integer.MAX_VALUE);
        this.gqm.registerListener(this.gNe);
        this.gqm.registerListener(this.gNf);
        this.gqm.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.erm, this.gqm.getBaseFragmentActivity().getUniqueId());
        this.gqm.registerListener(this.gNg);
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
                    this.gMS.setData(frsViewData.smartApp.name, frsViewData.smartAppAvatar);
                } else {
                    this.gMS.setData("", frsViewData.smartAppAvatar);
                }
                this.gMS.setVisibility(0);
                this.gMR.setVisibility(0);
            } else {
                this.gMS.setVisibility(8);
                this.gMR.setVisibility(8);
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
                            int BN = com.baidu.tieba.frs.f.g.BN("503~" + str + str2);
                            if (BN == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aC("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == BN) {
                                                com.baidu.tieba.tbadkCore.util.e.cMb();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cMc();
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && aa.bFF().tb(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        y sY = x.bFE().sY(dVar5.tabId);
                        if (sY != null && sY.gsi != null && sY.gsi.size() > 0) {
                            dVar5.gKg = new at();
                            dVar5.gKg.gsh = sY.gsh;
                            dVar5.gKg.gsi = new LinkedList();
                            boolean z2 = true;
                            for (w wVar : sY.gsi) {
                                if (wVar != null) {
                                    as asVar = new as();
                                    asVar.name = wVar.name;
                                    asVar.gse = wVar.gse;
                                    if (z2) {
                                        asVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.gKg.gsi.add(asVar);
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
                        y sY2 = x.bFE().sY(dVar6.tabId);
                        if (sY2 != null && sY2.gsi != null && sY2.gsi.size() > 0) {
                            dVar6.gKg = new at();
                            dVar6.gKg.gsh = sY2.gsh;
                            dVar6.gKg.gsi = new LinkedList();
                            for (w wVar2 : sY2.gsi) {
                                if (wVar2 != null) {
                                    as asVar2 = new as();
                                    asVar2.name = wVar2.name;
                                    asVar2.gse = wVar2.gse;
                                    dVar6.gKg.gsi.add(asVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.gqm.bDQ().bFg().p(bj.cRB)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.gNa > 0 && this.gNa != frsViewData.getAlaLiveCount() && this.gNa <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.gNa + ")";
                            } else if (this.gNa > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.gNa == 0 && this.gNa != frsViewData.getAlaLiveCount()) {
                                dVar7.name = frsTabInfo.tab_name;
                            }
                            dVar7.tabId = frsTabInfo.tab_id.intValue();
                            tabData.add(dVar7);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if ((com.baidu.tbadk.core.sharedPref.b.aFD().getInt("chushou_game_tab", 1) == 1) && TbadkCoreApplication.isChushouInit) {
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
                this.gMV = frsViewData;
                if (this.gMV.getForum() != null) {
                    this.mThemeColorInfo = this.gMV.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.gMP.getTabCount() > 0 && !v.isEmpty(this.gMU)) {
                    int min = Math.min(this.gMU.size(), this.gMP.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e as = this.gMP.as(i2);
                        if (as != null) {
                            if (frsViewData.isShowRedTip() && this.gMU.get(i2).tabId == 89) {
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
                        if (this.gqm != null && this.gqm.bDL() != null && frsTabInfo2 != null) {
                            this.gqm.bDL().tN(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.gqm != null && this.gqm.aIi() != null) {
                        if (f.size() < 2) {
                            this.gqm.aIi().removeHeaderView(this.gHX);
                        } else {
                            this.gqm.aIi().removeHeaderView(this.gHX);
                            this.gqm.aIi().addHeaderView(this.gHX);
                            if (this.gMY != null && frsViewData.getForum() != null) {
                                this.gMY.setData(f, i);
                                this.gMY.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.gMU = tabData;
                    bKV();
                    cr(arrayList);
                }
            }
        }
    }

    private void bKV() {
        int i = -1;
        if (!v.isEmpty(this.gMU)) {
            i = this.gMU.get(0).tabId;
        }
        if (this.gMV != null) {
            this.gMV.mHeadLineDefaultNavTabId = i;
        }
        if (this.gqm != null) {
            this.gqm.mHeadLineDefaultNavTabId = i;
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
        if (!v.isEmpty(this.gMW.mFragments) && tabData.size() == this.gMW.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.gMW.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.gMW.mFragments.get(i)).tabId) {
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
        if (i < 0 || this.gMU == null || this.gMU.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.gMU.size()) {
                i2 = -1;
                break;
            } else if (this.gMU.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.gMP.getTabCount()) {
            return false;
        }
        TbTabLayout.e as = this.gMP.as(i2);
        if (as != null && !as.isSelected()) {
            as.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d ur(int i) {
        if (i < 0 || this.gMU == null || this.gMU.size() <= 0) {
            return null;
        }
        Iterator it = this.gMU.iterator();
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
        SvgManager.aGC().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.enI, R.drawable.personalize_tab_shadow);
        bLd();
        if (this.gMP != null) {
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
            this.gMP.setSelectedTabIndicatorColor(color);
            this.gMP.setBackgroundColor(0);
            this.gMP.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.gMY != null && !isBrandForum()) {
            this.gMY.onChangeSkinType();
        }
        if (this.gMS != null) {
            this.gMS.onChangeSkinType();
        }
        if (this.gMT != null) {
            this.gMT.changeSkinType(i);
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
        this.gNa = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.gMU != null && position >= 0 && position < this.gMU.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.gMU.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gMV != null && this.gMV.isShowRedTip()) {
                    this.gMV.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.gqm.bEw() != null) {
                        this.gqm.bEw().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.gqm.bEw() != null) {
                    this.gqm.bEw().setIconFade(0);
                }
                if (this.gMZ != null) {
                    this.gMZ.mA(dVar.tabId);
                }
                com.baidu.tieba.frs.a.bCW().lb(dVar.tabId == 301);
                TiebaStatic.log(new an("c12398").cy("fid", this.gqm.forumId).X("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bLb();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.gMU != null && position >= 0 && position < this.gMU.size() && (dVar = this.gMU.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new an("c12398").cy("fid", this.gqm.forumId).X("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gMV != null && this.gMV.isShowRedTip()) {
                    this.gMV.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        return (!v.isEmpty(this.gMU) && tabData.size() == this.gMU.size() && this.gMU.containsAll(tabData)) ? false : true;
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
                    if (FrsTabViewController.this.gqm != null && FrsTabViewController.this.gqm.bDQ() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.gqm.bDQ().bFh());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.gqm != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.gqm.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.gqm.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gqm.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gqm.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.gqm.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gqm.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gqm.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.gqm.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gqm.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gqm.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.gqm.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gqm.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gqm.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.gMV.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.gMV.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.gMV.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.gMV);
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
            this.gMX = new com.baidu.tieba.frs.e(this.gqm.getActivity().getApplicationContext(), list);
            this.gMX.setForumId(this.gqm.getForumId());
            this.gMX.setForumName(this.gqm.getForumName());
            this.gMX.setFrom(this.gqm.getFrom());
            if (this.gMV != null && this.gMV.getForum() != null) {
                this.gMX.sL(this.gMV.getForum().getFirst_class());
                this.gMX.sM(this.gMV.getForum().getSecond_class());
                this.gMX.setForumGameLabel(this.gMV.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bG(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.gMX.b(c);
                }
            }
            this.gNc = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.gMX));
        }
    }

    private void bG(int i, int i2) {
        an anVar = new an("c13008");
        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cy("fid", this.gqm.getForumId());
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
        anVar.aGz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKW() {
        int color;
        int i;
        if (this.gMX != null) {
            List<com.baidu.tbadk.mainTab.b> bDw = this.gMX.bDw();
            if (!v.isEmpty(bDw) && !v.isEmpty(this.gMU)) {
                if (this.gMP.getTabCount() > 0) {
                    this.gMP.removeAllTabs();
                }
                bKX();
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
                this.gMP.setSelectedTabIndicatorColor(color);
                Iterator it = this.gMU.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment l = l(dVar.tabId, bDw);
                    if (l != null) {
                        TbTabLayout.e b2 = this.gMP.kD().b(dVar.name);
                        boolean z = this.gMV.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.gMV != null && this.gMV.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.gMP.a(b2, z);
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
                if (this.gMP.getTabCount() > 0 && this.gMN.getVisibility() != 0) {
                    this.gMN.setVisibility(0);
                }
                this.gMW = new FragmentAdapter(this.gqm.getActivity().getSupportFragmentManager(), this.mFragments);
                this.gMQ.setAdapter(this.gMW);
                this.gMW.notifyDataSetChanged();
                this.gMP.setupWithViewPager(this.gMQ);
                this.gMQ.setOffscreenPageLimit(this.mFragments.size());
                this.gMQ.setCurrentItem(i3, false);
                this.gMQ.bFG();
            }
        }
    }

    private void bKX() {
        if (this.gMQ != null && this.gMW != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.gqm.getActivity().getSupportFragmentManager();
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

    public View bKY() {
        if (isBrandForum() || this.gMY == null) {
            return null;
        }
        return this.gMY.bHs();
    }

    public static boolean tZ(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.gMZ = aVar;
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
                        FrsTabViewController.this.gqm.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.gqm.setPrimary(true);
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

    public b bKZ() {
        if (this.gMQ == null) {
            return null;
        }
        return (b) v.getItem(this.mFragments, this.gMQ.getCurrentItem());
    }

    public void bLa() {
        this.gNb.aj(this.gqm.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void bLb() {
        this.gNb.zz();
    }

    @Override // com.baidu.tieba.frs.vc.m
    public void ut(int i) {
        this.grf = i;
        bLd();
    }

    public int bLc() {
        return this.grf;
    }

    private void bLd() {
        if (this.grf == 2) {
            am.setBackgroundColor(this.gMN, R.color.cp_bg_line_h);
            am.setBackgroundColor(this.gMO, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gMR, R.drawable.frs_tab_sticky_fading_edge);
            this.enI.setVisibility(0);
            this.gqm.bEo();
        } else if (this.grf == 1) {
            am.setBackgroundColor(this.gMN, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gMO, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gMR, R.drawable.frs_tab_sticky_fading_edge);
            this.enI.setVisibility(0);
        } else {
            if (this.gqm != null && this.gqm.bDV()) {
                am.setBackgroundColor(this.gMN, R.color.transparent);
            } else {
                am.setBackgroundColor(this.gMN, R.color.cp_bg_line_c);
            }
            am.setBackgroundResource(this.gMO, R.drawable.top_corners_bg);
            am.setBackgroundResource(this.gMR, R.drawable.frs_tab_fading_edge);
            this.enI.setVisibility(8);
            if (this.gqm != null) {
                this.gqm.bEo();
            }
        }
    }
}
