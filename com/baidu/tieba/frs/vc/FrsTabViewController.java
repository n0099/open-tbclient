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
    private View fek;
    private TbTabLayout gRw;
    private RelativeLayout hMP;
    private View hMQ;
    private FrsTabViewPager hMR;
    private LinearGradientView hMS;
    private TabData hMT;
    private FrsViewData hMU;
    private FragmentAdapter hMV;
    private com.baidu.tieba.frs.e hMW;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b hMX;
    private a hMY;
    private com.baidu.tieba.c.d hNa;
    private int hNd;
    private FrsFragment hpb;
    private RelativeLayout huL;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int hpW = 0;
    private int hMZ = -1;
    private boolean hNb = false;
    public boolean hNc = true;
    private boolean hNe = false;
    private boolean hNf = false;
    CustomMessageListener hNg = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.hNb) {
                FrsTabViewController.this.ccl();
                FrsTabViewController.this.hNb = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.hMR != null) {
                FrsTabViewController.this.hMR.bWN();
                if (!v.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) v.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof an) {
                        y yVar = new y();
                        yVar.tabId = bVar.tabId;
                        yVar.hqH = (an) bVar.fragment;
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
    private CustomMessageListener hNh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.hMU != null && FrsTabViewController.this.hMU.isShowRedTip() != booleanValue && FrsTabViewController.this.gRw.getTabCount() > 0 && !v.isEmpty(FrsTabViewController.this.hMT)) {
                        FrsTabViewController.this.hMU.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.hMT.size(), FrsTabViewController.this.gRw.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aF = FrsTabViewController.this.gRw.aF(i);
                            if (aF != null) {
                                if (FrsTabViewController.this.hMT.get(i).tabId == 89) {
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
    private CustomMessageListener fhS = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cco;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cco = FrsTabViewController.this.cco()) != null && cco.fragment != null && (cco.fragment instanceof al)) {
                        ((al) cco.fragment).brJ();
                    }
                }
            }
        }
    };
    private CustomMessageListener hNi = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.hMT.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.hMT.size()) {
                    FrsTabViewController.this.hMR.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener hNj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.hNa.Gu();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void bO(int i, int i2);
    }

    public void nM(boolean z) {
        this.gRw.setDisableTabSelect(z);
    }

    public FrsTabViewPager ccg() {
        return this.hMR;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.hpb = frsFragment;
        this.hMP = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.hMQ = view.findViewById(R.id.frs_tab_bg);
        this.fek = view.findViewById(R.id.divider_shadow);
        this.hMS = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.gRw = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.gRw.setOnTabSelectedListener(this);
        this.gRw.setSelectedTabTextBlod(true);
        this.gRw.setTabTextSize(vz(R.dimen.tbds46));
        this.hNa = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.gRw);
        this.hNa.cG(R.drawable.bg_tip_blue_up_left);
        this.hNa.cF(16);
        this.hNa.setUseDirectOffset(true);
        this.hNa.sx(vz(R.dimen.tbds34));
        this.hNa.setYOffset(vz(R.dimen.tbds10));
        this.hNa.c(this.hNj);
        this.hMR = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.hMV = new FragmentAdapter(this.hpb.getActivity().getSupportFragmentManager(), this.mFragments);
        this.hMR.addOnPageChangeListener(this.mOnPageChangeListener);
        this.huL = new RelativeLayout(this.hpb.getContext());
        this.hMX = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.huL);
    }

    private int vz(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cch() {
        return this.huL;
    }

    public View cci() {
        return this.hMS;
    }

    private boolean isBrandForum() {
        return this.hMU != null && this.hMU.getIsBrandForum();
    }

    public void registerListener() {
        this.hNg.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.hpb.registerListener(this.hNg);
        this.hpb.registerListener(this.hNh);
        this.hpb.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fhS, this.hpb.getBaseFragmentActivity().getUniqueId());
        this.hpb.registerListener(this.hNi);
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
                    if (frsTabInfo.is_general_tab.intValue() == 1) {
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
                                                com.baidu.tieba.tbadkCore.util.e.deD();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.deE();
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
                    } else if (frsTabInfo.tab_type.intValue() == 11 && vi(frsTabInfo.tab_id.intValue())) {
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ae.bWM().ug(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ac ud = ab.bWL().ud(dVar6.tabId);
                        if (ud != null && ud.hqX != null && ud.hqX.size() > 0) {
                            dVar6.hJv = new ay();
                            dVar6.hJv.hqW = ud.hqW;
                            dVar6.hJv.hqX = new LinkedList();
                            boolean z2 = true;
                            for (aa aaVar : ud.hqX) {
                                if (aaVar != null) {
                                    ax axVar = new ax();
                                    axVar.name = aaVar.name;
                                    axVar.hqT = aaVar.hqT;
                                    if (z2) {
                                        axVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.hJv.hqX.add(axVar);
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
                        ac ud2 = ab.bWL().ud(dVar7.tabId);
                        if (ud2 != null && ud2.hqX != null && ud2.hqX.size() > 0) {
                            dVar7.hJv = new ay();
                            dVar7.hJv.hqW = ud2.hqW;
                            dVar7.hJv.hqX = new LinkedList();
                            for (aa aaVar2 : ud2.hqX) {
                                if (aaVar2 != null) {
                                    ax axVar2 = new ax();
                                    axVar2.name = aaVar2.name;
                                    axVar2.hqT = aaVar2.hqT;
                                    dVar7.hJv.hqX.add(axVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.hpb.bUR().bWm().r(bk.dEW)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.hMZ > 0 && this.hMZ != frsViewData.getAlaLiveCount() && this.hMZ <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.hMZ + ")";
                            } else if (this.hMZ > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.hMZ == 0 && this.hMZ != frsViewData.getAlaLiveCount()) {
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
                this.hMU = frsViewData;
                if (this.hMU.getForum() != null) {
                    this.mThemeColorInfo = this.hMU.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.gRw.getTabCount() > 0 && !v.isEmpty(this.hMT)) {
                    int min = Math.min(this.hMT.size(), this.gRw.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aF = this.gRw.aF(i2);
                        if (aF != null) {
                            if (frsViewData.isShowRedTip() && this.hMT.get(i2).tabId == 89) {
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
                        if (this.hpb != null && this.hpb.bUM() != null && frsTabInfo2 != null) {
                            this.hpb.bUM().uX(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.hpb != null && this.hpb.aWN() != null) {
                        if (f != null && f.size() < 2) {
                            this.hpb.aWN().removeHeaderView(this.huL);
                        } else {
                            this.hpb.aWN().removeHeaderView(this.huL);
                            this.hpb.aWN().addHeaderView(this.huL);
                            if (this.hMX != null && frsViewData.getForum() != null) {
                                this.hMX.setData(f);
                                this.hMX.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.hMT = tabData;
                    ccj();
                    cA(arrayList);
                }
            }
        }
    }

    private void ccj() {
        int i = -1;
        if (!v.isEmpty(this.hMT)) {
            i = this.hMT.get(0).tabId;
        }
        if (this.hMU != null) {
            this.hMU.mHeadLineDefaultNavTabId = i;
        }
        if (this.hpb != null) {
            this.hpb.mHeadLineDefaultNavTabId = i;
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
        if (!v.isEmpty(this.hMV.mFragments) && tabData.size() == this.hMV.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.hMV.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.hMV.mFragments.get(i)).tabId) {
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

    public int cck() {
        Iterator it = this.hMT.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b vA(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean vB(int i) {
        if (i < 0 || this.hMT == null || this.hMT.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.hMT.size()) {
                i2 = -1;
                break;
            } else if (this.hMT.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.gRw.getTabCount()) {
            return false;
        }
        TbTabLayout.e aF = this.gRw.aF(i2);
        if (aF != null && !aF.isSelected()) {
            aF.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d vC(int i) {
        if (i < 0 || this.hMT == null || this.hMT.size() <= 0) {
            return null;
        }
        Iterator it = this.hMT.iterator();
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
        SvgManager.aUV().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.fek, R.drawable.personalize_tab_shadow);
        cct();
        if (this.gRw != null) {
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
            this.gRw.setSelectedTabIndicatorColor(color);
            am.setBackgroundColor(this.gRw, R.color.transparent);
            this.gRw.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.hMX != null && !isBrandForum()) {
            this.hMX.onChangeSkinType();
        }
        if (this.hMS != null) {
            this.hMS.changeSkinType(i);
        }
        if (!v.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void vD(int i) {
        this.hMZ = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.hMT != null && position >= 0 && position < this.hMT.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.hMT.get(position);
            if (dVar != null) {
                this.hNd = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.hMU != null && this.hMU.isShowRedTip()) {
                    this.hMU.setIsShowRedTip(false);
                    eVar.j(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.hpb.bVz() != null) {
                        this.hpb.bVz().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.hpb.bVz() != null) {
                    this.hpb.bVz().setIconFade(0);
                }
                if (this.hMY != null) {
                    this.hMY.bO(dVar.tabId, dVar.tabType);
                }
                com.baidu.tieba.frs.a.bTX().mG(dVar.tabId == 503);
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12398").dh("fid", this.hpb.forumId).ag("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        ccq();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.hMT != null && position >= 0 && position < this.hMT.size() && (dVar = this.hMT.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12398").dh("fid", this.hpb.forumId).ag("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.hMU != null && this.hMU.isShowRedTip()) {
                    this.hMU.setIsShowRedTip(false);
                    eVar.j(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        return (!v.isEmpty(this.hMT) && tabData.size() == this.hMT.size() && this.hMT.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !vi(frsTabInfo.tab_id.intValue());
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
                    if (FrsTabViewController.this.hpb != null && FrsTabViewController.this.hpb.bUR() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.hpb.bUR().bWn());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.hpb != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.hpb.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hpb.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hpb.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hpb.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hpb.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hpb.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hpb.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hpb.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hpb.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hpb.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.11
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.hpb.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hpb.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hpb.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.hMU.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.hMU.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.hMU.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.hMU);
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

    private void cA(List<FrsTabInfo> list) {
        if (!v.isEmpty(list)) {
            this.hMW = new com.baidu.tieba.frs.e(this.hpb.getActivity().getApplicationContext(), list);
            this.hMW.setForumId(this.hpb.getForumId());
            this.hMW.setForumName(this.hpb.getForumName());
            this.hMW.setFrom(this.hpb.getFrom());
            if (this.hMU != null && this.hMU.getForum() != null) {
                this.hMW.vH(this.hMU.getForum().getFirst_class());
                this.hMW.vI(this.hMU.getForum().getSecond_class());
                this.hMW.setForumGameLabel(this.hMU.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bS(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.hMW.b(c);
                }
            }
            this.hNb = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.hMW));
        }
    }

    private void bS(int i, int i2) {
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13008");
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.dh("fid", this.hpb.getForumId());
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
        anVar.aUS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccl() {
        int color;
        int i;
        if (this.hMW != null) {
            List<com.baidu.tbadk.mainTab.b> bUw = this.hMW.bUw();
            if (!v.isEmpty(bUw) && !v.isEmpty(this.hMT)) {
                if (this.gRw.getTabCount() > 0) {
                    this.gRw.removeAllTabs();
                }
                ccm();
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
                this.gRw.setSelectedTabIndicatorColor(color);
                Iterator it = this.hMT.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, bUw);
                    if (m != null) {
                        TbTabLayout.e b2 = this.gRw.pn().b(dVar.name);
                        boolean z = this.hMU.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.hMU != null && this.hMU.isShowRedTip() && dVar.tabId == 89) {
                            b2.j(0, true);
                        } else {
                            b2.j(0, false);
                        }
                        this.gRw.a(b2, z);
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
                if (this.gRw.getTabCount() > 0 && this.hMP.getVisibility() != 0) {
                    this.hMP.setVisibility(0);
                }
                this.hMV = new FragmentAdapter(this.hpb.getActivity().getSupportFragmentManager(), this.mFragments);
                this.hMR.setAdapter(this.hMV);
                this.hMV.notifyDataSetChanged();
                this.gRw.setupWithViewPager(this.hMR);
                this.hMR.setOffscreenPageLimit(this.mFragments.size());
                this.hMR.setCurrentItem(i3, false);
                this.hMR.bWN();
            }
        }
    }

    private void ccm() {
        if (this.hMR != null && this.hMV != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.hpb.getActivity().getSupportFragmentManager();
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

    public View ccn() {
        if (isBrandForum() || this.hMX == null) {
            return null;
        }
        return this.hMX.bYy();
    }

    public static boolean vi(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.hMY = aVar;
    }

    public void U(boolean z, boolean z2) {
        if (this.hNe != z) {
            this.hNe = z;
        }
        if (this.hNf != z2) {
            this.hNf = z2;
        }
        ccu();
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
                        FrsTabViewController.this.hpb.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.hpb.setPrimary(true);
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

    public b cco() {
        if (this.hMR == null) {
            return null;
        }
        return (b) v.getItem(this.mFragments, this.hMR.getCurrentItem());
    }

    public void ccp() {
        this.hNa.aA(this.hpb.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void ccq() {
        this.hNa.Gu();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void vE(int i) {
        this.hpW = i;
        cct();
    }

    public int ccr() {
        return this.hpW;
    }

    public int ccs() {
        return this.hNd;
    }

    private void cct() {
        if (this.hpW == 2) {
            am.setBackgroundColor(this.hMP, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hMQ, R.color.cp_bg_line_e);
            this.fek.setVisibility(0);
            this.hpb.bVq();
        } else if (this.hpW == 1) {
            am.setBackgroundColor(this.hMP, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hMQ, R.color.cp_bg_line_e);
            this.fek.setVisibility(0);
        } else {
            ccu();
            this.fek.setVisibility(8);
            if (this.hpb != null) {
                this.hpb.bVq();
            }
        }
    }

    private void ccu() {
        if (!this.hNe && !this.hNf) {
            am.setBackgroundColor(this.hMP, R.color.transparent);
            am.setBackgroundResource(this.hMQ, R.drawable.top_corners_bg);
            return;
        }
        am.setBackgroundColor(this.hMQ, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.hMP, R.color.cp_bg_line_e);
    }
}
