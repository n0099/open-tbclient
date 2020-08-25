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
/* loaded from: classes16.dex */
public class FrsTabViewController implements TbTabLayout.b, n {
    private View fGj;
    private FrsFragment hVk;
    private TbTabLayout hwR;
    private RelativeLayout ibS;
    private RelativeLayout iuW;
    private View iuX;
    private FrsTabViewPager iuY;
    private LinearGradientView iuZ;
    private TabData iva;
    private FrsViewData ivb;
    private FragmentAdapter ivc;
    private com.baidu.tieba.frs.g ivd;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b ive;
    private a ivf;
    private com.baidu.tieba.c.e ivh;
    private int ivk;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int hWe = 0;
    private int ivg = -1;
    private boolean ivi = false;
    public boolean ivj = true;
    private boolean ivl = false;
    private boolean ivm = false;
    CustomMessageListener ivn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.ivi) {
                FrsTabViewController.this.ctQ();
                FrsTabViewController.this.ivi = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.iuY != null) {
                FrsTabViewController.this.iuY.cnW();
                if (!y.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) y.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof au) {
                        ad adVar = new ad();
                        adVar.tabId = bVar.tabId;
                        adVar.hXc = (au) bVar.fragment;
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
    private CustomMessageListener ivo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.ivb != null && FrsTabViewController.this.ivb.isShowRedTip() != booleanValue && FrsTabViewController.this.hwR.getTabCount() > 0 && !y.isEmpty(FrsTabViewController.this.iva)) {
                        FrsTabViewController.this.ivb.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.iva.size(), FrsTabViewController.this.hwR.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aQ = FrsTabViewController.this.hwR.aQ(i);
                            if (aQ != null) {
                                if (FrsTabViewController.this.iva.get(i).tabId == 89) {
                                    aQ.l(0, booleanValue);
                                } else {
                                    aQ.l(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fJR = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b ctT;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (ctT = FrsTabViewController.this.ctT()) != null && ctT.fragment != null && (ctT.fragment instanceof as)) {
                        ((as) ctT.fragment).bGQ();
                    }
                }
            }
        }
    };
    private CustomMessageListener ivp = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.iva.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.iva.size()) {
                    FrsTabViewController.this.iuY.setCurrentItem(i, true);
                }
            }
        }
    };
    private CustomMessageListener ivq = new CustomMessageListener(2921488) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921488) {
                Iterator it = FrsTabViewController.this.iva.iterator();
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
                if (i <= FrsTabViewController.this.iva.size() && z) {
                    FrsTabViewController.this.iuY.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener ivr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.ivh.NG();
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void ce(int i, int i2);
    }

    public void ph(boolean z) {
        this.hwR.setDisableTabSelect(z);
    }

    public FrsTabViewPager ctK() {
        return this.iuY;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.hVk = frsFragment;
        this.iuW = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.iuX = view.findViewById(R.id.frs_tab_bg);
        this.fGj = view.findViewById(R.id.divider_shadow);
        this.iuZ = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.hwR = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.hwR.setOnTabSelectedListener(this);
        this.hwR.setSelectedTabTextBlod(true);
        this.hwR.setTabTextSize(yR(R.dimen.tbds46));
        this.ivh = new com.baidu.tieba.c.e(frsFragment.getPageContext(), this.hwR);
        this.ivh.eL(R.drawable.bg_tip_blue_up_left);
        this.ivh.eK(16);
        this.ivh.setUseDirectOffset(true);
        this.ivh.vF(yR(R.dimen.tbds34));
        this.ivh.setYOffset(yR(R.dimen.tbds10));
        this.ivh.c(this.ivr);
        this.iuY = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.ivc = new FragmentAdapter(this.hVk.getActivity().getSupportFragmentManager(), this.mFragments);
        this.iuY.addOnPageChangeListener(this.mOnPageChangeListener);
        this.ibS = new RelativeLayout(this.hVk.getContext());
        this.ive = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.ibS);
    }

    private int yR(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout ctL() {
        return this.ibS;
    }

    public View ctM() {
        return this.iuZ;
    }

    private boolean isBrandForum() {
        return this.ivb != null && this.ivb.getIsBrandForum();
    }

    public void registerListener() {
        this.ivn.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.hVk.registerListener(this.ivn);
        this.hVk.registerListener(this.ivo);
        this.hVk.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fJR, this.hVk.getBaseFragmentActivity().getUniqueId());
        this.hVk.registerListener(this.ivp);
        this.hVk.registerListener(this.ivq);
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
                            int IW = com.baidu.tieba.frs.f.g.IW("503~" + str + str2);
                            if (IW == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aO("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == IW) {
                                                com.baidu.tieba.tbadkCore.util.e.dxJ();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.dxK();
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
                            eH(dVar4.url, "c10078");
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && yA(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.d.yD(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && aj.cnV().xw(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ah xt = ag.cnU().xt(dVar6.tabId);
                        if (xt != null && xt.hXr != null && xt.hXr.size() > 0) {
                            dVar6.irC = new bg();
                            dVar6.irC.hXq = xt.hXq;
                            dVar6.irC.hXr = new LinkedList();
                            boolean z2 = true;
                            for (af afVar : xt.hXr) {
                                if (afVar != null) {
                                    bf bfVar = new bf();
                                    bfVar.name = afVar.name;
                                    bfVar.hXn = afVar.hXn;
                                    if (z2) {
                                        bfVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.irC.hXr.add(bfVar);
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
                        ah xt2 = ag.cnU().xt(dVar7.tabId);
                        if (xt2 != null && xt2.hXr != null && xt2.hXr.size() > 0) {
                            dVar7.irC = new bg();
                            dVar7.irC.hXq = xt2.hXq;
                            dVar7.irC.hXr = new LinkedList();
                            for (af afVar2 : xt2.hXr) {
                                if (afVar2 != null) {
                                    bf bfVar2 = new bf();
                                    bfVar2.name = afVar2.name;
                                    bfVar2.hXn = afVar2.hXn;
                                    dVar7.irC.hXr.add(bfVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.hVk.clS().cnr().s(bw.ebp)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.ivg > 0 && this.ivg != frsViewData.getAlaLiveCount() && this.ivg <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.ivg + ")";
                            } else if (this.ivg > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.ivg == 0 && this.ivg != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            dVar9.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                            yS(2);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        dVar10.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                        yS(2);
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
                        yS(1);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.ivb = frsViewData;
                if (this.ivb.getForum() != null) {
                    this.mThemeColorInfo = this.ivb.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.hwR.getTabCount() > 0 && !y.isEmpty(this.iva)) {
                    int min = Math.min(this.iva.size(), this.hwR.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aQ = this.hwR.aQ(i2);
                        if (aQ != null) {
                            if (frsViewData.isShowRedTip() && this.iva.get(i2).tabId == 89) {
                                aQ.l(0, true);
                            } else {
                                aQ.l(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(f, 0);
                        if (this.hVk != null && this.hVk.clN() != null && frsTabInfo2 != null) {
                            this.hVk.clN().yp(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.hVk != null && this.hVk.blc() != null) {
                        if (f != null && f.size() < 2) {
                            this.hVk.blc().removeHeaderView(this.ibS);
                        } else {
                            this.hVk.blc().removeHeaderView(this.ibS);
                            this.hVk.blc().addHeaderView(this.ibS);
                            if (this.ive != null && frsViewData.getForum() != null) {
                                this.ive.setData(f);
                                this.ive.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.iva = tabData;
                    ctN();
                    cS(arrayList);
                }
            }
        }
    }

    private void yS(int i) {
        TiebaStatic.log(new aq("c13971").dD("fid", this.hVk.forumId).dD("fname", this.hVk.getForumName()).ai("obj_locate", i));
    }

    private void ctN() {
        int i = -1;
        if (!y.isEmpty(this.iva)) {
            i = this.iva.get(0).tabId;
        }
        if (this.ivb != null) {
            this.ivb.mHeadLineDefaultNavTabId = i;
        }
        if (this.hVk != null) {
            this.hVk.mHeadLineDefaultNavTabId = i;
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
        if (!y.isEmpty(this.ivc.mFragments) && tabData.size() == this.ivc.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.ivc.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.ivc.mFragments.get(i)).tabId) {
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

    public int ctO() {
        Iterator it = this.iva.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b yT(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public int ctP() {
        Iterator it = this.iva.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && dVar.tabType == 16) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean yU(int i) {
        if (i < 0 || this.iva == null || this.iva.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.iva.size()) {
                i2 = -1;
                break;
            } else if (this.iva.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.hwR.getTabCount()) {
            return false;
        }
        TbTabLayout.e aQ = this.hwR.aQ(i2);
        if (aQ != null && !aQ.isSelected()) {
            aQ.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d yV(int i) {
        if (i < 0 || this.iva == null || this.iva.size() <= 0) {
            return null;
        }
        Iterator it = this.iva.iterator();
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
        SvgManager.bjq().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.fGj, R.drawable.personalize_tab_shadow);
        ctY();
        if (this.hwR != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.b.fn(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.b.fn(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.b.fn(this.mThemeColorInfo.day.font_color);
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = ap.getColor(R.color.plugin_button_shadow_red);
            }
            this.hwR.setSelectedTabIndicatorColor(color);
            ap.setBackgroundColor(this.hwR, R.color.transparent);
            this.hwR.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
        }
        if (this.ive != null && !isBrandForum()) {
            this.ive.onChangeSkinType();
        }
        if (this.iuZ != null) {
            this.iuZ.changeSkinType(i);
        }
        if (!y.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void yW(int i) {
        this.ivg = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.iva != null && position >= 0 && position < this.iva.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.iva.get(position);
            if (dVar != null) {
                this.ivk = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.ivb != null && this.ivb.isShowRedTip()) {
                    this.ivb.setIsShowRedTip(false);
                    eVar.l(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.hVk.cmD() != null) {
                        this.hVk.cmD().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.hVk.cmD() != null) {
                    this.hVk.cmD().setIconFade(0);
                }
                if (this.ivf != null) {
                    this.ivf.ce(dVar.tabId, dVar.tabType);
                }
                com.baidu.tieba.frs.b.ckS().oa(dVar.tabId == 503);
                com.baidu.tieba.frs.a.ckL().wN(dVar.tabId);
                TiebaStatic.log(new aq("c12398").dD("fid", this.hVk.forumId).ai("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        ctV();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.iva != null && position >= 0 && position < this.iva.size() && (dVar = this.iva.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new aq("c12398").dD("fid", this.hVk.forumId).ai("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.ivb != null && this.ivb.isShowRedTip()) {
                    this.ivb.setIsShowRedTip(false);
                    eVar.l(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (y.isEmpty(tabData)) {
            return false;
        }
        return (!y.isEmpty(this.iva) && tabData.size() == this.iva.size() && this.iva.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !yA(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void eH(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    aq aqVar = new aq(str2);
                    aqVar.dD("obj_type", host);
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
                    if (FrsTabViewController.this.hVk != null && FrsTabViewController.this.hVk.clS() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.hVk.clS().cns());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.hVk != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.hVk.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hVk.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hVk.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hVk.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hVk.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hVk.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hVk.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hVk.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hVk.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hVk.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hVk.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hVk.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hVk.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.ivb.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.ivb.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.ivb.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.ivb);
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

    private void cS(List<FrsTabInfo> list) {
        if (!y.isEmpty(list)) {
            this.ivd = new com.baidu.tieba.frs.g(this.hVk.getActivity().getApplicationContext(), list);
            this.ivd.setForumId(this.hVk.getForumId());
            this.ivd.setForumName(this.hVk.getForumName());
            this.ivd.setFrom(this.hVk.getFrom());
            if (this.ivb != null && this.ivb.getForum() != null) {
                this.ivd.zs(this.ivb.getForum().getFirst_class());
                this.ivd.zt(this.ivb.getForum().getSecond_class());
                this.ivd.setForumGameLabel(this.ivb.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    cj(frsTabInfo.tab_id.intValue(), 1);
                }
                if (frsTabInfo.tab_type.intValue() == 3) {
                    yS(1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.ivd.b(c);
                }
            }
            this.ivi = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.ivd));
        }
    }

    private void cj(int i, int i2) {
        aq aqVar = new aq("c13008");
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dD("fid", this.hVk.getForumId());
        if (i == 89) {
            aqVar.ai("obj_type", 1);
        } else if (i == 502) {
            aqVar.ai("obj_type", 8);
        } else if (i == 90) {
            aqVar.ai("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aqVar.ai("obj_type", 4);
            } else {
                aqVar.ai("obj_type", 5);
            }
        } else if (i == 404) {
            aqVar.ai("obj_type", 2);
        } else if (i == 301) {
            aqVar.ai("obj_type", 7);
        } else if (i == 503) {
            aqVar.ai("obj_type", 6);
        } else if (i == 504) {
            aqVar.ai("obj_type", 11);
        }
        aqVar.ai("obj_locate", i2);
        aqVar.bjn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctQ() {
        int color;
        int i;
        if (this.ivd != null) {
            List<com.baidu.tbadk.mainTab.b> clx = this.ivd.clx();
            if (!y.isEmpty(clx) && !y.isEmpty(this.iva)) {
                if (this.hwR.getTabCount() > 0) {
                    this.hwR.removeAllTabs();
                }
                ctR();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.b.fn(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.b.fn(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.b.fn(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = ap.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
                this.hwR.setSelectedTabIndicatorColor(color);
                Iterator it = this.iva.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, clx);
                    if (m != null) {
                        TbTabLayout.e b2 = this.hwR.re().b(dVar.name);
                        boolean z = this.ivb.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.hVk.getFrom().equals(FrsActivityConfig.FROM_PB_OR_PERSON) && 3 == dVar.tabType) {
                            i3 = i2;
                        }
                        if (this.ivb != null && this.ivb.isShowRedTip() && dVar.tabId == 89) {
                            b2.l(0, true);
                        } else {
                            b2.l(0, false);
                        }
                        this.hwR.a(b2, z);
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
                if (this.hwR.getTabCount() > 0 && this.iuW.getVisibility() != 0) {
                    this.iuW.setVisibility(0);
                }
                this.ivc = new FragmentAdapter(this.hVk.getActivity().getSupportFragmentManager(), this.mFragments);
                this.iuY.setAdapter(this.ivc);
                this.ivc.notifyDataSetChanged();
                this.hwR.setupWithViewPager(this.iuY);
                this.iuY.setOffscreenPageLimit(this.mFragments.size());
                this.iuY.setCurrentItem(i3, false);
                this.iuY.cnW();
            }
        }
    }

    private void ctR() {
        if (this.iuY != null && this.ivc != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.hVk.getActivity().getSupportFragmentManager();
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

    public View ctS() {
        if (isBrandForum() || this.ive == null) {
            return null;
        }
        return this.ive.cpT();
    }

    public static boolean yA(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.ivf = aVar;
    }

    public void aa(boolean z, boolean z2) {
        if (this.ivl != z) {
            this.ivl = z;
        }
        if (this.ivm != z2) {
            this.ivm = z2;
        }
        ctZ();
    }

    /* loaded from: classes16.dex */
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
                        FrsTabViewController.this.hVk.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.hVk.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public int tabType;
        public String title;

        public b() {
        }
    }

    public b ctT() {
        if (this.iuY == null) {
            return null;
        }
        return (b) y.getItem(this.mFragments, this.iuY.getCurrentItem());
    }

    public void ctU() {
        this.ivh.aG(this.hVk.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void ctV() {
        this.ivh.NG();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void yX(int i) {
        this.hWe = i;
        ctY();
    }

    public int ctW() {
        return this.hWe;
    }

    public int ctX() {
        return this.ivk;
    }

    private void ctY() {
        if (this.hWe == 2) {
            ap.setBackgroundColor(this.iuW, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.iuX, R.color.cp_bg_line_e);
            this.fGj.setVisibility(0);
            this.hVk.cmu();
        } else if (this.hWe == 1) {
            ap.setBackgroundColor(this.iuW, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.iuX, R.color.cp_bg_line_e);
            this.fGj.setVisibility(0);
        } else {
            ctZ();
            this.fGj.setVisibility(8);
            if (this.hVk != null) {
                this.hVk.cmu();
            }
        }
    }

    private void ctZ() {
        if (!this.ivl && !this.ivm) {
            ap.setBackgroundColor(this.iuW, R.color.transparent);
            ap.setBackgroundResource(this.iuX, R.drawable.top_corners_bg);
            return;
        }
        ap.setBackgroundColor(this.iuX, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.iuW, R.color.cp_bg_line_e);
    }
}
