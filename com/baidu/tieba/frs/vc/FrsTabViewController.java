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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bg;
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
/* loaded from: classes22.dex */
public class FrsTabViewController implements TbTabLayout.b, n {
    private TbTabLayout fJT;
    private View gfU;
    private FrsFragment iDN;
    private RelativeLayout iKv;
    private RelativeLayout jdK;
    private View jdL;
    private FrsTabViewPager jdM;
    private LinearGradientView jdN;
    private TabData jdO;
    private FrsViewData jdP;
    private FragmentAdapter jdQ;
    private com.baidu.tieba.frs.g jdR;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b jdS;
    private a jdT;
    private com.baidu.tieba.c.e jdV;
    private int jdY;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int iEH = 0;
    private int jdU = -1;
    private boolean jdW = false;
    public boolean jdX = true;
    private boolean jdZ = false;
    private boolean jea = false;
    CustomMessageListener jeb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.jdW) {
                FrsTabViewController.this.cDO();
                FrsTabViewController.this.jdW = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.jdM != null) {
                FrsTabViewController.this.jdM.cxP();
                if (!y.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) y.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof au) {
                        ad adVar = new ad();
                        adVar.tabId = bVar.tabId;
                        adVar.iFF = (au) bVar.fragment;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, adVar));
                        return;
                    }
                    ad adVar2 = new ad();
                    adVar2.tabId = bVar.tabId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, adVar2));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener jec = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.jdP != null && FrsTabViewController.this.jdP.isShowRedTip() != booleanValue && FrsTabViewController.this.fJT.getTabCount() > 0 && !y.isEmpty(FrsTabViewController.this.jdO)) {
                        FrsTabViewController.this.jdP.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.jdO.size(), FrsTabViewController.this.fJT.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aU = FrsTabViewController.this.fJT.aU(i);
                            if (aU != null) {
                                if (FrsTabViewController.this.jdO.get(i).tabId == 89) {
                                    aU.l(0, booleanValue);
                                } else {
                                    aU.l(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gjF = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cDR;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cDR = FrsTabViewController.this.cDR()) != null && cDR.fragment != null && (cDR.fragment instanceof as)) {
                        ((as) cDR.fragment).bNv();
                    }
                }
            }
        }
    };
    private CustomMessageListener jed = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.jdO.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.jdO.size()) {
                    FrsTabViewController.this.jdM.setCurrentItem(i, true);
                }
            }
        }
    };
    private CustomMessageListener jee = new CustomMessageListener(2921488) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921488) {
                Iterator it = FrsTabViewController.this.jdO.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((com.baidu.tieba.frs.tab.d) it.next()).tabType == 3) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (i <= FrsTabViewController.this.jdO.size() && z) {
                    FrsTabViewController.this.jdM.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener jef = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.jdV.Qh();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void cj(int i, int i2);
    }

    public void qm(boolean z) {
        this.fJT.setDisableTabSelect(z);
    }

    public FrsTabViewPager cDI() {
        return this.jdM;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.iDN = frsFragment;
        this.jdK = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.jdL = view.findViewById(R.id.frs_tab_bg);
        this.gfU = view.findViewById(R.id.divider_shadow);
        this.jdN = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.fJT = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.fJT.setOnTabSelectedListener(this);
        this.fJT.setSelectedTabTextBlod(true);
        this.fJT.setTabTextSize(Ap(R.dimen.tbds46));
        this.jdV = new com.baidu.tieba.c.e(frsFragment.getPageContext(), this.fJT);
        this.jdV.fh(R.drawable.bg_tip_blue_up_left);
        this.jdV.fg(16);
        this.jdV.setUseDirectOffset(true);
        this.jdV.xd(Ap(R.dimen.tbds34));
        this.jdV.setYOffset(Ap(R.dimen.tbds10));
        this.jdV.c(this.jef);
        this.jdM = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.jdQ = new FragmentAdapter(this.iDN.getActivity().getSupportFragmentManager(), this.mFragments);
        this.jdM.addOnPageChangeListener(this.mOnPageChangeListener);
        this.iKv = new RelativeLayout(this.iDN.getContext());
        this.jdS = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.iKv);
    }

    private int Ap(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cDJ() {
        return this.iKv;
    }

    public View cDK() {
        return this.jdN;
    }

    private boolean isBrandForum() {
        return this.jdP != null && this.jdP.getIsBrandForum();
    }

    public void registerListener() {
        this.jeb.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.iDN.registerListener(this.jeb);
        this.iDN.registerListener(this.jec);
        this.iDN.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gjF, this.iDN.getBaseFragmentActivity().getUniqueId());
        this.iDN.registerListener(this.jed);
        this.iDN.registerListener(this.jee);
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
                            int KH = com.baidu.tieba.frs.f.i.KH("503~" + str + str2);
                            if (KH == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.i.aQ("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == KH) {
                                                com.baidu.tieba.tbadkCore.util.e.dIB();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.dIC();
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
                            fg(dVar4.url, "c10078");
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && zY(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.d.Ae(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && aj.cxO().yU(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ah yR = ag.cxN().yR(dVar6.tabId);
                        if (yR != null && yR.iFU != null && yR.iFU.size() > 0) {
                            dVar6.jan = new bg();
                            dVar6.jan.iFT = yR.iFT;
                            dVar6.jan.iFU = new LinkedList();
                            boolean z2 = true;
                            for (af afVar : yR.iFU) {
                                if (afVar != null) {
                                    bf bfVar = new bf();
                                    bfVar.name = afVar.name;
                                    bfVar.iFQ = afVar.iFQ;
                                    if (z2) {
                                        bfVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.jan.iFU.add(bfVar);
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
                        ah yR2 = ag.cxN().yR(dVar7.tabId);
                        if (yR2 != null && yR2.iFU != null && yR2.iFU.size() > 0) {
                            dVar7.jan = new bg();
                            dVar7.jan.iFT = yR2.iFT;
                            dVar7.jan.iFU = new LinkedList();
                            for (af afVar2 : yR2.iFU) {
                                if (afVar2 != null) {
                                    bf bfVar2 = new bf();
                                    bfVar2.name = afVar2.name;
                                    bfVar2.iFQ = afVar2.iFQ;
                                    dVar7.jan.iFU.add(bfVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.iDN.cvK().cxj().r(bw.eyh)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.jdU > 0 && this.jdU != frsViewData.getAlaLiveCount() && this.jdU <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.jdU + ")";
                            } else if (this.jdU > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.jdU == 0 && this.jdU != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.bnH().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            dVar9.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                            Aq(2);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        dVar10.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                        Aq(2);
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
                        dVar12.name = at.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
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
                    } else if (frsTabInfo.tab_type.intValue() == 3) {
                        com.baidu.tieba.frs.tab.d dVar14 = new com.baidu.tieba.frs.tab.d();
                        dVar14.tabId = frsTabInfo.tab_id.intValue();
                        dVar14.name = frsTabInfo.tab_name;
                        dVar14.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar14);
                        arrayList.add(frsTabInfo);
                        Aq(1);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.jdP = frsViewData;
                if (this.jdP.getForum() != null) {
                    this.mThemeColorInfo = this.jdP.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.fJT.getTabCount() > 0 && !y.isEmpty(this.jdO)) {
                    int min = Math.min(this.jdO.size(), this.fJT.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aU = this.fJT.aU(i2);
                        if (aU != null) {
                            if (frsViewData.isShowRedTip() && this.jdO.get(i2).tabId == 89) {
                                aU.l(0, true);
                            } else {
                                aU.l(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(f, 0);
                        if (this.iDN != null && this.iDN.cvF() != null && frsTabInfo2 != null) {
                            this.iDN.cvF().zN(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.iDN != null && this.iDN.bqA() != null) {
                        if (f != null && f.size() < 2) {
                            this.iDN.bqA().removeHeaderView(this.iKv);
                        } else {
                            this.iDN.bqA().removeHeaderView(this.iKv);
                            this.iDN.bqA().addHeaderView(this.iKv);
                            if (this.jdS != null && frsViewData.getForum() != null) {
                                this.jdS.setData(f);
                                this.jdS.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.jdO = tabData;
                    cDL();
                    dk(arrayList);
                }
            }
        }
    }

    private void Aq(int i) {
        TiebaStatic.log(new aq("c13971").dR("fid", this.iDN.forumId).dR("fname", this.iDN.getForumName()).aj("obj_locate", i));
    }

    private void cDL() {
        int i = -1;
        if (!y.isEmpty(this.jdO)) {
            i = this.jdO.get(0).tabId;
        }
        if (this.jdP != null) {
            this.jdP.mHeadLineDefaultNavTabId = i;
        }
        if (this.iDN != null) {
            this.iDN.mHeadLineDefaultNavTabId = i;
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
        if (y.isEmpty(tabData)) {
            return false;
        }
        b(tabData);
        if (!y.isEmpty(this.jdQ.mFragments) && tabData.size() == this.jdQ.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.jdQ.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.jdQ.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void b(TabData tabData) {
        if (!y.isEmpty(tabData)) {
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

    public int cDM() {
        Iterator it = this.jdO.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b Ar(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public int cDN() {
        Iterator it = this.jdO.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && dVar.tabType == 16) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean sW(int i) {
        if (i < 0 || this.jdO == null || this.jdO.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.jdO.size()) {
                i2 = -1;
                break;
            } else if (this.jdO.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fJT.getTabCount()) {
            return false;
        }
        TbTabLayout.e aU = this.fJT.aU(i2);
        if (aU != null && !aU.isSelected()) {
            aU.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d As(int i) {
        if (i < 0 || this.jdO == null || this.jdO.size() <= 0) {
            return null;
        }
        Iterator it = this.jdO.iterator();
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
        SvgManager.boN().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.gfU, R.drawable.personalize_tab_shadow);
        cDW();
        if (this.fJT != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.b.fv(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.b.fv(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.b.fv(this.mThemeColorInfo.day.font_color);
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = ap.getColor(R.color.plugin_button_shadow_red);
            }
            this.fJT.setSelectedTabIndicatorColor(color);
            ap.setBackgroundColor(this.fJT, R.color.transparent);
            this.fJT.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
        }
        if (this.jdS != null && !isBrandForum()) {
            this.jdS.onChangeSkinType();
        }
        if (this.jdN != null) {
            this.jdN.changeSkinType(i);
        }
        if (!y.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void At(int i) {
        this.jdU = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.jdO != null && position >= 0 && position < this.jdO.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.jdO.get(position);
            if (dVar != null) {
                this.jdY = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jdP != null && this.jdP.isShowRedTip()) {
                    this.jdP.setIsShowRedTip(false);
                    eVar.l(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.iDN.cwv() != null) {
                        this.iDN.cwv().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.iDN.cwv() != null) {
                    this.iDN.cwv().setIconFade(0);
                }
                if (this.jdT != null) {
                    this.jdT.cj(dVar.tabId, dVar.tabType);
                }
                com.baidu.tieba.frs.b.cuL().pf(dVar.tabId == 503);
                com.baidu.tieba.frs.a.cuE().yl(dVar.tabId);
                TiebaStatic.log(new aq("c12398").dR("fid", this.iDN.forumId).aj("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        cDT();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.jdO != null && position >= 0 && position < this.jdO.size() && (dVar = this.jdO.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new aq("c12398").dR("fid", this.iDN.forumId).aj("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jdP != null && this.jdP.isShowRedTip()) {
                    this.jdP.setIsShowRedTip(false);
                    eVar.l(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (y.isEmpty(tabData)) {
            return false;
        }
        return (!y.isEmpty(this.jdO) && tabData.size() == this.jdO.size() && this.jdO.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 92 || frsTabInfo.tab_type.intValue() == 3) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !zY(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void fg(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    aq aqVar = new aq(str2);
                    aqVar.dR("obj_type", host);
                    TiebaStatic.log(aqVar);
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
                    if (FrsTabViewController.this.iDN != null && FrsTabViewController.this.iDN.cvK() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.iDN.cvK().cxk());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.iDN != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.iDN.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iDN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iDN.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.iDN.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iDN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iDN.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.iDN.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iDN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iDN.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.iDN.getForumId());
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
        if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 3) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.12
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.iDN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iDN.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.iDN.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.jdP.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.jdP.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.jdP.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.jdP);
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

    private void dk(List<FrsTabInfo> list) {
        if (!y.isEmpty(list)) {
            this.jdR = new com.baidu.tieba.frs.g(this.iDN.getActivity().getApplicationContext(), list);
            this.jdR.setForumId(this.iDN.getForumId());
            this.jdR.setForumName(this.iDN.getForumName());
            this.jdR.setFrom(this.iDN.getFrom());
            if (this.jdP != null && this.jdP.getForum() != null) {
                this.jdR.AT(this.jdP.getForum().getFirst_class());
                this.jdR.AU(this.jdP.getForum().getSecond_class());
                this.jdR.setForumGameLabel(this.jdP.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    co(frsTabInfo.tab_id.intValue(), 1);
                }
                if (frsTabInfo.tab_type.intValue() == 3) {
                    Aq(1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.jdR.b(c);
                }
            }
            this.jdW = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.jdR));
        }
    }

    private void co(int i, int i2) {
        aq aqVar = new aq("c13008");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("fid", this.iDN.getForumId());
        if (i == 89) {
            aqVar.aj("obj_type", 1);
        } else if (i == 502) {
            aqVar.aj("obj_type", 8);
        } else if (i == 90) {
            aqVar.aj("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aqVar.aj("obj_type", 4);
            } else {
                aqVar.aj("obj_type", 5);
            }
        } else if (i == 404) {
            aqVar.aj("obj_type", 2);
        } else if (i == 301) {
            aqVar.aj("obj_type", 7);
        } else if (i == 503) {
            aqVar.aj("obj_type", 6);
        } else if (i == 504) {
            aqVar.aj("obj_type", 11);
        }
        aqVar.aj("obj_locate", i2);
        aqVar.boK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDO() {
        int color;
        int i;
        if (this.jdR != null) {
            List<com.baidu.tbadk.mainTab.b> cvp = this.jdR.cvp();
            if (!y.isEmpty(cvp) && !y.isEmpty(this.jdO)) {
                if (this.fJT.getTabCount() > 0) {
                    this.fJT.removeAllTabs();
                }
                cDP();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.b.fv(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.b.fv(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.b.fv(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = ap.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
                this.fJT.setSelectedTabIndicatorColor(color);
                Iterator it = this.jdO.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, cvp);
                    if (m != null) {
                        TbTabLayout.e b2 = this.fJT.rj().b(dVar.name);
                        boolean z = this.jdP.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.iDN.getFrom().equals(FrsActivityConfig.FROM_PB_OR_PERSON) && 3 == dVar.tabType) {
                            i3 = i2;
                        }
                        if (this.jdP != null && this.jdP.isShowRedTip() && dVar.tabId == 89) {
                            b2.l(0, true);
                        } else {
                            b2.l(0, false);
                        }
                        this.fJT.a(b2, z);
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
                if (this.fJT.getTabCount() > 0 && this.jdK.getVisibility() != 0) {
                    this.jdK.setVisibility(0);
                }
                this.jdQ = new FragmentAdapter(this.iDN.getActivity().getSupportFragmentManager(), this.mFragments);
                this.jdM.setAdapter(this.jdQ);
                this.jdQ.notifyDataSetChanged();
                this.fJT.setupWithViewPager(this.jdM);
                this.jdM.setOffscreenPageLimit(this.mFragments.size());
                this.jdM.setCurrentItem(i3, false);
                this.jdM.cxP();
            }
        }
    }

    private void cDP() {
        if (this.jdM != null && this.jdQ != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.iDN.getActivity().getSupportFragmentManager();
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

    public View cDQ() {
        if (isBrandForum() || this.jdS == null) {
            return null;
        }
        return this.jdS.czL();
    }

    public static boolean zY(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.jdT = aVar;
    }

    public void ae(boolean z, boolean z2) {
        if (this.jdZ != z) {
            this.jdZ = z;
        }
        if (this.jea != z2) {
            this.jea = z2;
        }
        cDX();
    }

    /* loaded from: classes22.dex */
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
                        FrsTabViewController.this.iDN.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.iDN.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes22.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public int tabType;
        public String title;

        public b() {
        }
    }

    public b cDR() {
        if (this.jdM == null) {
            return null;
        }
        return (b) y.getItem(this.mFragments, this.jdM.getCurrentItem());
    }

    public void cDS() {
        this.jdV.aL(this.iDN.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void cDT() {
        this.jdV.Qh();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void Au(int i) {
        this.iEH = i;
        cDW();
    }

    public int cDU() {
        return this.iEH;
    }

    public int cDV() {
        return this.jdY;
    }

    private void cDW() {
        if (this.iEH == 2) {
            ap.setBackgroundColor(this.jdK, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jdL, R.color.cp_bg_line_e);
            this.gfU.setVisibility(0);
            this.iDN.cwm();
        } else if (this.iEH == 1) {
            ap.setBackgroundColor(this.jdK, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jdL, R.color.cp_bg_line_e);
            this.gfU.setVisibility(0);
        } else {
            cDX();
            this.gfU.setVisibility(8);
            if (this.iDN != null) {
                this.iDN.cwm();
            }
        }
    }

    private void cDX() {
        if (!this.jdZ && !this.jea) {
            ap.setBackgroundColor(this.jdK, R.color.transparent);
            ap.setBackgroundResource(this.jdL, R.drawable.top_corners_bg);
            return;
        }
        ap.setBackgroundColor(this.jdL, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.jdK, R.color.cp_bg_line_e);
    }
}
