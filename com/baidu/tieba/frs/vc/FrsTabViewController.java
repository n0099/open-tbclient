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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
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
    private View fpG;
    private FrsFragment hBW;
    private RelativeLayout hHM;
    private TbTabLayout heq;
    private RelativeLayout iaO;
    private View iaP;
    private FrsTabViewPager iaQ;
    private LinearGradientView iaR;
    private TabData iaS;
    private FrsViewData iaT;
    private FragmentAdapter iaU;
    private com.baidu.tieba.frs.g iaV;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b iaW;
    private a iaX;
    private com.baidu.tieba.c.e iaZ;
    private int ibc;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int hCQ = 0;
    private int iaY = -1;
    private boolean iba = false;
    public boolean ibb = true;
    private boolean ibd = false;
    private boolean ibe = false;
    CustomMessageListener ibf = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.iba) {
                FrsTabViewController.this.cfM();
                FrsTabViewController.this.iba = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.iaQ != null) {
                FrsTabViewController.this.iaQ.bZZ();
                if (!w.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) w.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof as) {
                        ab abVar = new ab();
                        abVar.tabId = bVar.tabId;
                        abVar.hDF = (as) bVar.fragment;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, abVar));
                        return;
                    }
                    ab abVar2 = new ab();
                    abVar2.tabId = bVar.tabId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, abVar2));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener ibg = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.iaT != null && FrsTabViewController.this.iaT.isShowRedTip() != booleanValue && FrsTabViewController.this.heq.getTabCount() > 0 && !w.isEmpty(FrsTabViewController.this.iaS)) {
                        FrsTabViewController.this.iaT.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.iaS.size(), FrsTabViewController.this.heq.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aL = FrsTabViewController.this.heq.aL(i);
                            if (aL != null) {
                                if (FrsTabViewController.this.iaS.get(i).tabId == 89) {
                                    aL.k(0, booleanValue);
                                } else {
                                    aL.k(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener ftr = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cfP;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cfP = FrsTabViewController.this.cfP()) != null && cfP.fragment != null && (cfP.fragment instanceof aq)) {
                        ((aq) cfP.fragment).buH();
                    }
                }
            }
        }
    };
    private CustomMessageListener ibh = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.iaS.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.iaS.size()) {
                    FrsTabViewController.this.iaQ.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener ibi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.iaZ.HH();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void bU(int i, int i2);
    }

    public void nY(boolean z) {
        this.heq.setDisableTabSelect(z);
    }

    public FrsTabViewPager cfG() {
        return this.iaQ;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.hBW = frsFragment;
        this.iaO = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.iaP = view.findViewById(R.id.frs_tab_bg);
        this.fpG = view.findViewById(R.id.divider_shadow);
        this.iaR = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.heq = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.heq.setOnTabSelectedListener(this);
        this.heq.setSelectedTabTextBlod(true);
        this.heq.setTabTextSize(wg(R.dimen.tbds46));
        this.iaZ = new com.baidu.tieba.c.e(frsFragment.getPageContext(), this.heq);
        this.iaZ.cS(R.drawable.bg_tip_blue_up_left);
        this.iaZ.cR(16);
        this.iaZ.setUseDirectOffset(true);
        this.iaZ.sZ(wg(R.dimen.tbds34));
        this.iaZ.setYOffset(wg(R.dimen.tbds10));
        this.iaZ.c(this.ibi);
        this.iaQ = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.iaU = new FragmentAdapter(this.hBW.getActivity().getSupportFragmentManager(), this.mFragments);
        this.iaQ.addOnPageChangeListener(this.mOnPageChangeListener);
        this.hHM = new RelativeLayout(this.hBW.getContext());
        this.iaW = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.hHM);
    }

    private int wg(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cfH() {
        return this.hHM;
    }

    public View cfI() {
        return this.iaR;
    }

    private boolean isBrandForum() {
        return this.iaT != null && this.iaT.getIsBrandForum();
    }

    public void registerListener() {
        this.ibf.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.hBW.registerListener(this.ibf);
        this.hBW.registerListener(this.ibg);
        this.hBW.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.ftr, this.hBW.getBaseFragmentActivity().getUniqueId());
        this.hBW.registerListener(this.ibh);
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
                            int FI = com.baidu.tieba.frs.f.g.FI("503~" + str + str2);
                            if (FI == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aM("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == FI) {
                                                com.baidu.tieba.tbadkCore.util.e.dje();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.djf();
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
                            eo(dVar4.url, "c10078");
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && vP(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.d.vq(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ah.bZY().uN(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        af uK = ae.bZX().uK(dVar6.tabId);
                        if (uK != null && uK.hDV != null && uK.hDV.size() > 0) {
                            dVar6.hXu = new be();
                            dVar6.hXu.hDU = uK.hDU;
                            dVar6.hXu.hDV = new LinkedList();
                            boolean z2 = true;
                            for (ad adVar : uK.hDV) {
                                if (adVar != null) {
                                    bd bdVar = new bd();
                                    bdVar.name = adVar.name;
                                    bdVar.hDR = adVar.hDR;
                                    if (z2) {
                                        bdVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.hXu.hDV.add(bdVar);
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
                        af uK2 = ae.bZX().uK(dVar7.tabId);
                        if (uK2 != null && uK2.hDV != null && uK2.hDV.size() > 0) {
                            dVar7.hXu = new be();
                            dVar7.hXu.hDU = uK2.hDU;
                            dVar7.hXu.hDV = new LinkedList();
                            for (ad adVar2 : uK2.hDV) {
                                if (adVar2 != null) {
                                    bd bdVar2 = new bd();
                                    bdVar2.name = adVar2.name;
                                    bdVar2.hDR = adVar2.hDR;
                                    dVar7.hXu.hDV.add(bdVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.hBW.bXZ().bZw().r(bu.dLI)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.iaY > 0 && this.iaY != frsViewData.getAlaLiveCount() && this.iaY <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.iaY + ")";
                            } else if (this.iaY > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.iaY == 0 && this.iaY != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.aVP().getInt("chushou_game_tab", 1) == 1) {
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
                        dVar12.name = ar.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
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
                this.iaT = frsViewData;
                if (this.iaT.getForum() != null) {
                    this.mThemeColorInfo = this.iaT.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.heq.getTabCount() > 0 && !w.isEmpty(this.iaS)) {
                    int min = Math.min(this.iaS.size(), this.heq.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aL = this.heq.aL(i2);
                        if (aL != null) {
                            if (frsViewData.isShowRedTip() && this.iaS.get(i2).tabId == 89) {
                                aL.k(0, true);
                            } else {
                                aL.k(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) w.getItem(f, 0);
                        if (this.hBW != null && this.hBW.bXU() != null && frsTabInfo2 != null) {
                            this.hBW.bXU().vE(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.hBW != null && this.hBW.aYH() != null) {
                        if (f != null && f.size() < 2) {
                            this.hBW.aYH().removeHeaderView(this.hHM);
                        } else {
                            this.hBW.aYH().removeHeaderView(this.hHM);
                            this.hBW.aYH().addHeaderView(this.hHM);
                            if (this.iaW != null && frsViewData.getForum() != null) {
                                this.iaW.setData(f);
                                this.iaW.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.iaS = tabData;
                    cfJ();
                    cL(arrayList);
                }
            }
        }
    }

    private void cfJ() {
        int i = -1;
        if (!w.isEmpty(this.iaS)) {
            i = this.iaS.get(0).tabId;
        }
        if (this.iaT != null) {
            this.iaT.mHeadLineDefaultNavTabId = i;
        }
        if (this.hBW != null) {
            this.hBW.mHeadLineDefaultNavTabId = i;
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
        if (w.isEmpty(tabData)) {
            return false;
        }
        b(tabData);
        if (!w.isEmpty(this.iaU.mFragments) && tabData.size() == this.iaU.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.iaU.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.iaU.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void b(TabData tabData) {
        if (!w.isEmpty(tabData)) {
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

    public int cfK() {
        Iterator it = this.iaS.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b wh(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public int cfL() {
        Iterator it = this.iaS.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && dVar.tabType == 16) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean wi(int i) {
        if (i < 0 || this.iaS == null || this.iaS.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.iaS.size()) {
                i2 = -1;
                break;
            } else if (this.iaS.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.heq.getTabCount()) {
            return false;
        }
        TbTabLayout.e aL = this.heq.aL(i2);
        if (aL != null && !aL.isSelected()) {
            aL.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d wj(int i) {
        if (i < 0 || this.iaS == null || this.iaS.size() <= 0) {
            return null;
        }
        Iterator it = this.iaS.iterator();
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
        SvgManager.aWQ().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        an.setBackgroundResource(this.fpG, R.drawable.personalize_tab_shadow);
        cfU();
        if (this.heq != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.a.dV(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.a.dV(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.a.dV(this.mThemeColorInfo.day.font_color);
                } else {
                    color = an.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = an.getColor(R.color.plugin_button_shadow_red);
            }
            this.heq.setSelectedTabIndicatorColor(color);
            an.setBackgroundColor(this.heq, R.color.transparent);
            this.heq.setTabTextColors(an.getColor(R.color.cp_cont_j), an.getColor(R.color.cp_cont_b));
        }
        if (this.iaW != null && !isBrandForum()) {
            this.iaW.onChangeSkinType();
        }
        if (this.iaR != null) {
            this.iaR.changeSkinType(i);
        }
        if (!w.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void wk(int i) {
        this.iaY = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.iaS != null && position >= 0 && position < this.iaS.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.iaS.get(position);
            if (dVar != null) {
                this.ibc = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.iaT != null && this.iaT.isShowRedTip()) {
                    this.iaT.setIsShowRedTip(false);
                    eVar.k(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.hBW.bYI() != null) {
                        this.hBW.bYI().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.hBW.bYI() != null) {
                    this.hBW.bYI().setIconFade(0);
                }
                if (this.iaX != null) {
                    this.iaX.bU(dVar.tabId, dVar.tabType);
                }
                com.baidu.tieba.frs.b.bXc().mR(dVar.tabId == 503);
                com.baidu.tieba.frs.a.bWV().ug(dVar.tabId);
                TiebaStatic.log(new ao("c12398").dk("fid", this.hBW.forumId).ag("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        cfR();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.iaS != null && position >= 0 && position < this.iaS.size() && (dVar = this.iaS.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new ao("c12398").dk("fid", this.hBW.forumId).ag("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.iaT != null && this.iaT.isShowRedTip()) {
                    this.iaT.setIsShowRedTip(false);
                    eVar.k(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (w.isEmpty(tabData)) {
            return false;
        }
        return (!w.isEmpty(this.iaS) && tabData.size() == this.iaS.size() && this.iaS.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !vP(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void eo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    ao aoVar = new ao(str2);
                    aoVar.dk("obj_type", host);
                    TiebaStatic.log(aoVar);
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
                    if (FrsTabViewController.this.hBW != null && FrsTabViewController.this.hBW.bXZ() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.hBW.bXZ().bZx());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.hBW != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.hBW.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hBW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hBW.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hBW.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hBW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hBW.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hBW.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hBW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hBW.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hBW.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hBW.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hBW.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hBW.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.iaT.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.iaT.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.iaT.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.iaT);
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

    private void cL(List<FrsTabInfo> list) {
        if (!w.isEmpty(list)) {
            this.iaV = new com.baidu.tieba.frs.g(this.hBW.getActivity().getApplicationContext(), list);
            this.iaV.setForumId(this.hBW.getForumId());
            this.iaV.setForumName(this.hBW.getForumName());
            this.iaV.setFrom(this.hBW.getFrom());
            if (this.iaT != null && this.iaT.getForum() != null) {
                this.iaV.vX(this.iaT.getForum().getFirst_class());
                this.iaV.vY(this.iaT.getForum().getSecond_class());
                this.iaV.setForumGameLabel(this.iaT.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bY(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.iaV.b(c);
                }
            }
            this.iba = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.iaV));
        }
    }

    private void bY(int i, int i2) {
        ao aoVar = new ao("c13008");
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        aoVar.dk("fid", this.hBW.getForumId());
        if (i == 89) {
            aoVar.ag("obj_type", 1);
        } else if (i == 502) {
            aoVar.ag("obj_type", 8);
        } else if (i == 90) {
            aoVar.ag("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aoVar.ag("obj_type", 4);
            } else {
                aoVar.ag("obj_type", 5);
            }
        } else if (i == 404) {
            aoVar.ag("obj_type", 2);
        } else if (i == 301) {
            aoVar.ag("obj_type", 7);
        } else if (i == 503) {
            aoVar.ag("obj_type", 6);
        } else if (i == 504) {
            aoVar.ag("obj_type", 11);
        }
        aoVar.ag("obj_locate", i2);
        aoVar.aWN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfM() {
        int color;
        int i;
        if (this.iaV != null) {
            List<com.baidu.tbadk.mainTab.b> bXE = this.iaV.bXE();
            if (!w.isEmpty(bXE) && !w.isEmpty(this.iaS)) {
                if (this.heq.getTabCount() > 0) {
                    this.heq.removeAllTabs();
                }
                cfN();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.a.dV(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.a.dV(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.a.dV(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = an.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = an.getColor(R.color.plugin_button_shadow_red);
                }
                this.heq.setSelectedTabIndicatorColor(color);
                Iterator it = this.iaS.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, bXE);
                    if (m != null) {
                        TbTabLayout.e b2 = this.heq.pE().b(dVar.name);
                        boolean z = this.iaT.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.iaT != null && this.iaT.isShowRedTip() && dVar.tabId == 89) {
                            b2.k(0, true);
                        } else {
                            b2.k(0, false);
                        }
                        this.heq.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = m;
                        bVar.tabType = dVar.tabType;
                        this.mFragments.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i3 = i3;
                    i2 = i;
                }
                if (this.heq.getTabCount() > 0 && this.iaO.getVisibility() != 0) {
                    this.iaO.setVisibility(0);
                }
                this.iaU = new FragmentAdapter(this.hBW.getActivity().getSupportFragmentManager(), this.mFragments);
                this.iaQ.setAdapter(this.iaU);
                this.iaU.notifyDataSetChanged();
                this.heq.setupWithViewPager(this.iaQ);
                this.iaQ.setOffscreenPageLimit(this.mFragments.size());
                this.iaQ.setCurrentItem(i3, false);
                this.iaQ.bZZ();
            }
        }
    }

    private void cfN() {
        if (this.iaQ != null && this.iaU != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.hBW.getActivity().getSupportFragmentManager();
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

    public View cfO() {
        if (isBrandForum() || this.iaW == null) {
            return null;
        }
        return this.iaW.cbP();
    }

    public static boolean vP(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.iaX = aVar;
    }

    public void V(boolean z, boolean z2) {
        if (this.ibd != z) {
            this.ibd = z;
        }
        if (this.ibe != z2) {
            this.ibe = z2;
        }
        cfV();
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
                        FrsTabViewController.this.hBW.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.hBW.setPrimary(true);
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
        public int tabType;
        public String title;

        public b() {
        }
    }

    public b cfP() {
        if (this.iaQ == null) {
            return null;
        }
        return (b) w.getItem(this.mFragments, this.iaQ.getCurrentItem());
    }

    public void cfQ() {
        this.iaZ.aC(this.hBW.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void cfR() {
        this.iaZ.HH();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void wl(int i) {
        this.hCQ = i;
        cfU();
    }

    public int cfS() {
        return this.hCQ;
    }

    public int cfT() {
        return this.ibc;
    }

    private void cfU() {
        if (this.hCQ == 2) {
            an.setBackgroundColor(this.iaO, R.color.cp_bg_line_e);
            an.setBackgroundColor(this.iaP, R.color.cp_bg_line_e);
            this.fpG.setVisibility(0);
            this.hBW.bYz();
        } else if (this.hCQ == 1) {
            an.setBackgroundColor(this.iaO, R.color.cp_bg_line_e);
            an.setBackgroundColor(this.iaP, R.color.cp_bg_line_e);
            this.fpG.setVisibility(0);
        } else {
            cfV();
            this.fpG.setVisibility(8);
            if (this.hBW != null) {
                this.hBW.bYz();
            }
        }
    }

    private void cfV() {
        if (!this.ibd && !this.ibe) {
            an.setBackgroundColor(this.iaO, R.color.transparent);
            an.setBackgroundResource(this.iaP, R.drawable.top_corners_bg);
            return;
        }
        an.setBackgroundColor(this.iaP, R.color.cp_bg_line_e);
        an.setBackgroundColor(this.iaO, R.color.cp_bg_line_e);
    }
}
