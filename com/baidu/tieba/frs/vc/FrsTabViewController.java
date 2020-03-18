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
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.SmartAppFrsMountView;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
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
    private View enZ;
    private RelativeLayout gNS;
    private View gNT;
    private TbTabLayout gNU;
    private FrsTabViewPager gNV;
    private View gNW;
    private SmartAppFrsMountView gNX;
    private LinearGradientView gNY;
    private TabData gNZ;
    private FrsViewData gOa;
    private FragmentAdapter gOb;
    private com.baidu.tieba.frs.e gOc;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b gOd;
    private a gOe;
    private com.baidu.tieba.c.d gOg;
    private int gOj;
    private FrsFragment gqW;
    private RelativeLayout gwG;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int grP = 0;
    private int gOf = -1;
    private boolean gOh = false;
    public boolean gOi = true;
    CustomMessageListener gOk = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.gOh) {
                FrsTabViewController.this.bLk();
                FrsTabViewController.this.gOh = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.gNV != null) {
                FrsTabViewController.this.gNV.bFQ();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener gOl = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.gOa != null && FrsTabViewController.this.gOa.isShowRedTip() != booleanValue && FrsTabViewController.this.gNU.getTabCount() > 0 && !v.isEmpty(FrsTabViewController.this.gNZ)) {
                        FrsTabViewController.this.gOa.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.gNZ.size(), FrsTabViewController.this.gNU.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e as = FrsTabViewController.this.gNU.as(i);
                            if (as != null) {
                                if (FrsTabViewController.this.gNZ.get(i).tabId == 89) {
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
    private CustomMessageListener erJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bLn;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bLn = FrsTabViewController.this.bLn()) != null && bLn.fragment != null && (bLn.fragment instanceof ai)) {
                        ((ai) bLn.fragment).bdw();
                    }
                }
            }
        }
    };
    private CustomMessageListener gOm = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.gNZ.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.gNZ.size()) {
                    FrsTabViewController.this.gNV.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener gOn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.gOg.zG();
        }
    };
    private View.OnClickListener gOo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void mC(int i);
    }

    public void mn(boolean z) {
        this.gNU.setDisableTabSelect(z);
    }

    public FrsTabViewPager bLf() {
        return this.gNV;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.gqW = frsFragment;
        this.gNS = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.gNT = view.findViewById(R.id.frs_tab_bg);
        this.enZ = view.findViewById(R.id.divider_shadow);
        this.gNY = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.gNU = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.gNU.setOnTabSelectedListener(this);
        this.gNU.setSelectedTabTextBlod(true);
        this.gNU.setTabTextSize(uv(R.dimen.tbds46));
        this.gNW = view.findViewById(R.id.fading_edge_view);
        this.gNX = (SmartAppFrsMountView) view.findViewById(R.id.frs_tab_arrow);
        this.gNX.setOnClickListener(this.gOo);
        this.gOg = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.gNU);
        this.gOg.ck(R.drawable.bg_tip_blue_up_left);
        this.gOg.cj(16);
        this.gOg.setUseDirectOffset(true);
        this.gOg.rB(uv(R.dimen.tbds34));
        this.gOg.setYOffset(uv(R.dimen.tbds10));
        this.gOg.c(this.gOn);
        this.gNV = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.gOb = new FragmentAdapter(this.gqW.getActivity().getSupportFragmentManager(), this.mFragments);
        this.gNV.addOnPageChangeListener(this.mOnPageChangeListener);
        this.gwG = new RelativeLayout(this.gqW.getContext());
        this.gOd = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.gwG);
    }

    private int uv(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bLg() {
        return this.gwG;
    }

    public View bLh() {
        return this.gNY;
    }

    private boolean isBrandForum() {
        return this.gOa != null && this.gOa.getIsBrandForum();
    }

    public void registerListener() {
        this.gOk.setPriority(Integer.MAX_VALUE);
        this.gqW.registerListener(this.gOk);
        this.gqW.registerListener(this.gOl);
        this.gqW.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.erJ, this.gqW.getBaseFragmentActivity().getUniqueId());
        this.gqW.registerListener(this.gOm);
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
                    this.gNX.setData(frsViewData.smartApp.name, frsViewData.smartAppAvatar);
                } else {
                    this.gNX.setData("", frsViewData.smartAppAvatar);
                }
                this.gNX.setVisibility(0);
                this.gNW.setVisibility(0);
            } else {
                this.gNX.setVisibility(8);
                this.gNW.setVisibility(8);
            }
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    if (frsTabInfo.is_general_tab.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.name = frsTabInfo.tab_name;
                        dVar.tabId = frsTabInfo.tab_id.intValue();
                        tabData.add(dVar);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 89 || frsTabInfo.tab_id.intValue() == 503) {
                        com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                        dVar2.tabId = frsTabInfo.tab_id.intValue();
                        dVar2.name = frsTabInfo.tab_name;
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
                            int BM = com.baidu.tieba.frs.f.g.BM("503~" + str + str2);
                            if (BM == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aC("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == BM) {
                                                com.baidu.tieba.tbadkCore.util.e.cMv();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cMw();
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
                        tabData.add(dVar3);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                            dVar4.tabId = frsTabInfo.tab_id.intValue();
                            dVar4.name = frsTabInfo.tab_name;
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
                            ds(dVar4.url, "c10078");
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && uf(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.si(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.bFP().td(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        z ta = y.bFO().ta(dVar6.tabId);
                        if (ta != null && ta.gsS != null && ta.gsS.size() > 0) {
                            dVar6.gLl = new au();
                            dVar6.gLl.gsR = ta.gsR;
                            dVar6.gLl.gsS = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : ta.gsS) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.gsO = xVar.gsO;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.gLl.gsS.add(atVar);
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
                        z ta2 = y.bFO().ta(dVar7.tabId);
                        if (ta2 != null && ta2.gsS != null && ta2.gsS.size() > 0) {
                            dVar7.gLl = new au();
                            dVar7.gLl.gsR = ta2.gsR;
                            dVar7.gLl.gsS = new LinkedList();
                            for (x xVar2 : ta2.gsS) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.gsO = xVar2.gsO;
                                    dVar7.gLl.gsS.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.gqW.bDY().bFq().p(bj.cRO)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.gOf > 0 && this.gOf != frsViewData.getAlaLiveCount() && this.gOf <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.gOf + ")";
                            } else if (this.gOf > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.gOf == 0 && this.gOf != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.aFH().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 90) {
                        com.baidu.tieba.frs.tab.d dVar11 = new com.baidu.tieba.frs.tab.d();
                        dVar11.tabId = frsTabInfo.tab_id.intValue();
                        dVar11.name = frsTabInfo.tab_name;
                        tabData.add(dVar11);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 91) {
                        com.baidu.tieba.frs.tab.d dVar12 = new com.baidu.tieba.frs.tab.d();
                        dVar12.tabId = frsTabInfo.tab_id.intValue();
                        dVar12.name = aq.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
                        tabData.add(dVar12);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 504) {
                        com.baidu.tieba.frs.tab.d dVar13 = new com.baidu.tieba.frs.tab.d();
                        dVar13.tabId = frsTabInfo.tab_id.intValue();
                        dVar13.name = frsTabInfo.tab_name;
                        tabData.add(dVar13);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.gOa = frsViewData;
                if (this.gOa.getForum() != null) {
                    this.mThemeColorInfo = this.gOa.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.gNU.getTabCount() > 0 && !v.isEmpty(this.gNZ)) {
                    int min = Math.min(this.gNZ.size(), this.gNU.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e as = this.gNU.as(i2);
                        if (as != null) {
                            if (frsViewData.isShowRedTip() && this.gNZ.get(i2).tabId == 89) {
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
                        if (this.gqW != null && this.gqW.bDT() != null && frsTabInfo2 != null) {
                            this.gqW.bDT().tT(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.gqW != null && this.gqW.aIm() != null) {
                        if (f != null && f.size() < 2) {
                            this.gqW.aIm().removeHeaderView(this.gwG);
                        } else {
                            this.gqW.aIm().removeHeaderView(this.gwG);
                            this.gqW.aIm().addHeaderView(this.gwG);
                            if (this.gOd != null && frsViewData.getForum() != null) {
                                this.gOd.setData(f);
                                this.gOd.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.gNZ = tabData;
                    bLi();
                    cr(arrayList);
                }
            }
        }
    }

    private void bLi() {
        int i = -1;
        if (!v.isEmpty(this.gNZ)) {
            i = this.gNZ.get(0).tabId;
        }
        if (this.gOa != null) {
            this.gOa.mHeadLineDefaultNavTabId = i;
        }
        if (this.gqW != null) {
            this.gqW.mHeadLineDefaultNavTabId = i;
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
        if (!v.isEmpty(this.gOb.mFragments) && tabData.size() == this.gOb.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.gOb.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.gOb.mFragments.get(i)).tabId) {
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

    public int bLj() {
        Iterator it = this.gNZ.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b uw(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.vc.m
    public boolean ux(int i) {
        if (i < 0 || this.gNZ == null || this.gNZ.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.gNZ.size()) {
                i2 = -1;
                break;
            } else if (this.gNZ.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.gNU.getTabCount()) {
            return false;
        }
        TbTabLayout.e as = this.gNU.as(i2);
        if (as != null && !as.isSelected()) {
            as.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d uy(int i) {
        if (i < 0 || this.gNZ == null || this.gNZ.size() <= 0) {
            return null;
        }
        Iterator it = this.gNZ.iterator();
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
        SvgManager.aGG().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.enZ, R.drawable.personalize_tab_shadow);
        bLr();
        if (this.gNU != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.a.cF(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.a.cF(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.a.cF(this.mThemeColorInfo.day.font_color);
                } else {
                    color = am.getColor(R.color.cp_link_tip_a);
                }
            } else {
                color = am.getColor(R.color.cp_link_tip_a);
            }
            this.gNU.setSelectedTabIndicatorColor(color);
            this.gNU.setBackgroundColor(0);
            this.gNU.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.gOd != null && !isBrandForum()) {
            this.gOd.onChangeSkinType();
        }
        if (this.gNX != null) {
            this.gNX.onChangeSkinType();
        }
        if (this.gNY != null) {
            this.gNY.changeSkinType(i);
        }
        if (!v.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void uz(int i) {
        this.gOf = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.gNZ != null && position >= 0 && position < this.gNZ.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.gNZ.get(position);
            if (dVar != null) {
                this.gOj = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gOa != null && this.gOa.isShowRedTip()) {
                    this.gOa.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.gqW.bEG() != null) {
                        this.gqW.bEG().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.gqW.bEG() != null) {
                    this.gqW.bEG().setIconFade(0);
                }
                if (this.gOe != null) {
                    this.gOe.mC(dVar.tabId);
                }
                com.baidu.tieba.frs.a.bDd().lg(dVar.tabId == 301);
                TiebaStatic.log(new an("c12398").cx("fid", this.gqW.forumId).X("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bLp();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.gNZ != null && position >= 0 && position < this.gNZ.size() && (dVar = this.gNZ.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new an("c12398").cx("fid", this.gqW.forumId).X("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gOa != null && this.gOa.isShowRedTip()) {
                    this.gOa.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        return (!v.isEmpty(this.gNZ) && tabData.size() == this.gNZ.size() && this.gNZ.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 92) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !uf(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void ds(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    an anVar = new an(str2);
                    anVar.cx("obj_type", host);
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.gqW != null && FrsTabViewController.this.gqW.bDY() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.gqW.bDY().bFr());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.gqW != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.gqW.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gqW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gqW.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gqW.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gqW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gqW.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gqW.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.11
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gqW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gqW.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gqW.getForumId());
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
        if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504 || frsTabInfo.tab_type.intValue() == 15) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.12
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gqW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gqW.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gqW.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.gOa.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.gOa.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.gOa.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.gOa);
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

    private void cr(List<FrsTabInfo> list) {
        if (!v.isEmpty(list)) {
            this.gOc = new com.baidu.tieba.frs.e(this.gqW.getActivity().getApplicationContext(), list);
            this.gOc.setForumId(this.gqW.getForumId());
            this.gOc.setForumName(this.gqW.getForumName());
            this.gOc.setFrom(this.gqW.getFrom());
            if (this.gOa != null && this.gOa.getForum() != null) {
                this.gOc.sK(this.gOa.getForum().getFirst_class());
                this.gOc.sL(this.gOa.getForum().getSecond_class());
                this.gOc.setForumGameLabel(this.gOa.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bH(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.gOc.b(c);
                }
            }
            this.gOh = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.gOc));
        }
    }

    private void bH(int i, int i2) {
        an anVar = new an("c13008");
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cx("fid", this.gqW.getForumId());
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
        anVar.aGD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLk() {
        int color;
        int i;
        if (this.gOc != null) {
            List<com.baidu.tbadk.mainTab.b> bDE = this.gOc.bDE();
            if (!v.isEmpty(bDE) && !v.isEmpty(this.gNZ)) {
                if (this.gNU.getTabCount() > 0) {
                    this.gNU.removeAllTabs();
                }
                bLl();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.a.cF(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.a.cF(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.a.cF(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = am.getColor(R.color.cp_link_tip_a);
                    }
                } else {
                    color = am.getColor(R.color.cp_link_tip_a);
                }
                this.gNU.setSelectedTabIndicatorColor(color);
                Iterator it = this.gNZ.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment l = l(dVar.tabId, bDE);
                    if (l != null) {
                        TbTabLayout.e b2 = this.gNU.kD().b(dVar.name);
                        boolean z = this.gOa.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.gOa != null && this.gOa.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.gNU.a(b2, z);
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
                if (this.gNU.getTabCount() > 0 && this.gNS.getVisibility() != 0) {
                    this.gNS.setVisibility(0);
                }
                this.gOb = new FragmentAdapter(this.gqW.getActivity().getSupportFragmentManager(), this.mFragments);
                this.gNV.setAdapter(this.gOb);
                this.gOb.notifyDataSetChanged();
                this.gNU.setupWithViewPager(this.gNV);
                this.gNV.setOffscreenPageLimit(this.mFragments.size());
                this.gNV.setCurrentItem(i3, false);
                this.gNV.bFQ();
            }
        }
    }

    private void bLl() {
        if (this.gNV != null && this.gOb != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.gqW.getActivity().getSupportFragmentManager();
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
            Bundle arguments = bVar.getFragmentTabStructure().frag.getArguments();
            if (arguments != null && i == bVar.getFragmentTabStructure().type && !arguments.getBoolean("isAdded")) {
                arguments.putBoolean("isAdded", true);
                bVar.getFragmentTabStructure().frag.setArguments(arguments);
                return bVar.getFragmentTabStructure().frag;
            }
        }
        return null;
    }

    public View bLm() {
        if (isBrandForum() || this.gOd == null) {
            return null;
        }
        return this.gOd.bHF();
    }

    public static boolean uf(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.gOe = aVar;
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
                        FrsTabViewController.this.gqW.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.gqW.setPrimary(true);
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

    public b bLn() {
        if (this.gNV == null) {
            return null;
        }
        return (b) v.getItem(this.mFragments, this.gNV.getCurrentItem());
    }

    public void bLo() {
        this.gOg.ai(this.gqW.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void bLp() {
        this.gOg.zG();
    }

    @Override // com.baidu.tieba.frs.vc.m
    public void uA(int i) {
        this.grP = i;
        bLr();
    }

    public int bLq() {
        return this.grP;
    }

    public int byH() {
        return this.gOj;
    }

    private void bLr() {
        if (this.grP == 2) {
            am.setBackgroundColor(this.gNS, R.color.cp_bg_line_h);
            am.setBackgroundColor(this.gNT, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gNW, R.drawable.frs_tab_sticky_fading_edge);
            this.enZ.setVisibility(0);
            this.gqW.bEx();
        } else if (this.grP == 1) {
            am.setBackgroundColor(this.gNS, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gNT, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gNW, R.drawable.frs_tab_sticky_fading_edge);
            this.enZ.setVisibility(0);
        } else {
            if (this.gqW != null && this.gqW.bEd()) {
                am.setBackgroundColor(this.gNS, R.color.transparent);
            } else {
                am.setBackgroundColor(this.gNS, R.color.cp_bg_line_c);
            }
            am.setBackgroundResource(this.gNT, R.drawable.top_corners_bg);
            am.setBackgroundResource(this.gNW, R.drawable.frs_tab_fading_edge);
            this.enZ.setVisibility(8);
            if (this.gqW != null) {
                this.gqW.bEx();
            }
        }
    }
}
