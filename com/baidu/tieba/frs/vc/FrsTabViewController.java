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
import com.baidu.tbadk.core.data.bj;
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
    private View eRx;
    private TbTabLayout gCH;
    private FrsFragment hah;
    private RelativeLayout hfR;
    private RelativeLayout hxW;
    private View hxX;
    private FrsTabViewPager hxY;
    private LinearGradientView hxZ;
    private TabData hya;
    private FrsViewData hyb;
    private FragmentAdapter hyc;
    private com.baidu.tieba.frs.e hyd;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b hye;
    private a hyf;
    private com.baidu.tieba.c.d hyh;
    private int hyk;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int hbc = 0;
    private int hyg = -1;
    private boolean hyi = false;
    public boolean hyj = true;
    private boolean hyl = false;
    private boolean hym = false;
    CustomMessageListener hyn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.hyi) {
                FrsTabViewController.this.bVO();
                FrsTabViewController.this.hyi = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.hxY != null) {
                FrsTabViewController.this.hxY.bQs();
                if (!v.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) v.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof an) {
                        y yVar = new y();
                        yVar.tabId = bVar.tabId;
                        yVar.hbN = (an) bVar.fragment;
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
    private CustomMessageListener hyo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.hyb != null && FrsTabViewController.this.hyb.isShowRedTip() != booleanValue && FrsTabViewController.this.gCH.getTabCount() > 0 && !v.isEmpty(FrsTabViewController.this.hya)) {
                        FrsTabViewController.this.hyb.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.hya.size(), FrsTabViewController.this.gCH.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aE = FrsTabViewController.this.gCH.aE(i);
                            if (aE != null) {
                                if (FrsTabViewController.this.hya.get(i).tabId == 89) {
                                    aE.j(0, booleanValue);
                                } else {
                                    aE.j(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eVf = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bVR;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bVR = FrsTabViewController.this.bVR()) != null && bVR.fragment != null && (bVR.fragment instanceof al)) {
                        ((al) bVR.fragment).bmn();
                    }
                }
            }
        }
    };
    private CustomMessageListener hyp = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.hya.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.hya.size()) {
                    FrsTabViewController.this.hxY.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener hyq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.hyh.EE();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void mN(int i);
    }

    public void nr(boolean z) {
        this.gCH.setDisableTabSelect(z);
    }

    public FrsTabViewPager bVJ() {
        return this.hxY;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.hah = frsFragment;
        this.hxW = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.hxX = view.findViewById(R.id.frs_tab_bg);
        this.eRx = view.findViewById(R.id.divider_shadow);
        this.hxZ = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.gCH = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.gCH.setOnTabSelectedListener(this);
        this.gCH.setSelectedTabTextBlod(true);
        this.gCH.setTabTextSize(uT(R.dimen.tbds46));
        this.hyh = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.gCH);
        this.hyh.cz(R.drawable.bg_tip_blue_up_left);
        this.hyh.cy(16);
        this.hyh.setUseDirectOffset(true);
        this.hyh.rS(uT(R.dimen.tbds34));
        this.hyh.setYOffset(uT(R.dimen.tbds10));
        this.hyh.c(this.hyq);
        this.hxY = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.hyc = new FragmentAdapter(this.hah.getActivity().getSupportFragmentManager(), this.mFragments);
        this.hxY.addOnPageChangeListener(this.mOnPageChangeListener);
        this.hfR = new RelativeLayout(this.hah.getContext());
        this.hye = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.hfR);
    }

    private int uT(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bVK() {
        return this.hfR;
    }

    public View bVL() {
        return this.hxZ;
    }

    private boolean isBrandForum() {
        return this.hyb != null && this.hyb.getIsBrandForum();
    }

    public void registerListener() {
        this.hyn.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.hah.registerListener(this.hyn);
        this.hah.registerListener(this.hyo);
        this.hah.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.eVf, this.hah.getBaseFragmentActivity().getUniqueId());
        this.hah.registerListener(this.hyp);
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
                            int Dv = com.baidu.tieba.frs.f.g.Dv("503~" + str + str2);
                            if (Dv == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aM("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == Dv) {
                                                com.baidu.tieba.tbadkCore.util.e.cXr();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cXs();
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
                            dH(dVar4.url, "c10078");
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && uC(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.tx(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ae.bQr().tB(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        ac ty = ab.bQq().ty(dVar6.tabId);
                        if (ty != null && ty.hcd != null && ty.hcd.size() > 0) {
                            dVar6.huC = new ay();
                            dVar6.huC.hcc = ty.hcc;
                            dVar6.huC.hcd = new LinkedList();
                            boolean z2 = true;
                            for (aa aaVar : ty.hcd) {
                                if (aaVar != null) {
                                    ax axVar = new ax();
                                    axVar.name = aaVar.name;
                                    axVar.hbZ = aaVar.hbZ;
                                    if (z2) {
                                        axVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.huC.hcd.add(axVar);
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
                        ac ty2 = ab.bQq().ty(dVar7.tabId);
                        if (ty2 != null && ty2.hcd != null && ty2.hcd.size() > 0) {
                            dVar7.huC = new ay();
                            dVar7.huC.hcc = ty2.hcc;
                            dVar7.huC.hcd = new LinkedList();
                            for (aa aaVar2 : ty2.hcd) {
                                if (aaVar2 != null) {
                                    ax axVar2 = new ax();
                                    axVar2.name = aaVar2.name;
                                    axVar2.hbZ = aaVar2.hbZ;
                                    dVar7.huC.hcd.add(axVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.hah.bOx().bPR().p(bj.dqW)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.hyg > 0 && this.hyg != frsViewData.getAlaLiveCount() && this.hyg <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.hyg + ")";
                            } else if (this.hyg > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.hyg == 0 && this.hyg != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.aNV().getInt("chushou_game_tab", 1) == 1) {
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
                this.hyb = frsViewData;
                if (this.hyb.getForum() != null) {
                    this.mThemeColorInfo = this.hyb.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.gCH.getTabCount() > 0 && !v.isEmpty(this.hya)) {
                    int min = Math.min(this.hya.size(), this.gCH.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aE = this.gCH.aE(i2);
                        if (aE != null) {
                            if (frsViewData.isShowRedTip() && this.hya.get(i2).tabId == 89) {
                                aE.j(0, true);
                            } else {
                                aE.j(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.getItem(f, 0);
                        if (this.hah != null && this.hah.bOs() != null && frsTabInfo2 != null) {
                            this.hah.bOs().ur(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.hah != null && this.hah.aQI() != null) {
                        if (f != null && f.size() < 2) {
                            this.hah.aQI().removeHeaderView(this.hfR);
                        } else {
                            this.hah.aQI().removeHeaderView(this.hfR);
                            this.hah.aQI().addHeaderView(this.hfR);
                            if (this.hye != null && frsViewData.getForum() != null) {
                                this.hye.setData(f);
                                this.hye.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.hya = tabData;
                    bVM();
                    cD(arrayList);
                }
            }
        }
    }

    private void bVM() {
        int i = -1;
        if (!v.isEmpty(this.hya)) {
            i = this.hya.get(0).tabId;
        }
        if (this.hyb != null) {
            this.hyb.mHeadLineDefaultNavTabId = i;
        }
        if (this.hah != null) {
            this.hah.mHeadLineDefaultNavTabId = i;
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
        if (!v.isEmpty(this.hyc.mFragments) && tabData.size() == this.hyc.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.hyc.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.hyc.mFragments.get(i)).tabId) {
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

    public int bVN() {
        Iterator it = this.hya.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b uU(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean uV(int i) {
        if (i < 0 || this.hya == null || this.hya.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.hya.size()) {
                i2 = -1;
                break;
            } else if (this.hya.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.gCH.getTabCount()) {
            return false;
        }
        TbTabLayout.e aE = this.gCH.aE(i2);
        if (aE != null && !aE.isSelected()) {
            aE.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d uW(int i) {
        if (i < 0 || this.hya == null || this.hya.size() <= 0) {
            return null;
        }
        Iterator it = this.hya.iterator();
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
        SvgManager.aOU().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.eRx, R.drawable.personalize_tab_shadow);
        bVW();
        if (this.gCH != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.a.dA(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.a.dA(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.a.dA(this.mThemeColorInfo.day.font_color);
                } else {
                    color = am.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = am.getColor(R.color.plugin_button_shadow_red);
            }
            this.gCH.setSelectedTabIndicatorColor(color);
            am.setBackgroundColor(this.gCH, R.color.transparent);
            this.gCH.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.hye != null && !isBrandForum()) {
            this.hye.onChangeSkinType();
        }
        if (this.hxZ != null) {
            this.hxZ.changeSkinType(i);
        }
        if (!v.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void uX(int i) {
        this.hyg = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.hya != null && position >= 0 && position < this.hya.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.hya.get(position);
            if (dVar != null) {
                this.hyk = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.hyb != null && this.hyb.isShowRedTip()) {
                    this.hyb.setIsShowRedTip(false);
                    eVar.j(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.hah.bPf() != null) {
                        this.hah.bPf().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.hah.bPf() != null) {
                    this.hah.bPf().setIconFade(0);
                }
                if (this.hyf != null) {
                    this.hyf.mN(dVar.tabId);
                }
                com.baidu.tieba.frs.a.bND().ml(dVar.tabId == 503);
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12398").cI("fid", this.hah.forumId).af("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bVT();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.hya != null && position >= 0 && position < this.hya.size() && (dVar = this.hya.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12398").cI("fid", this.hah.forumId).af("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.hyb != null && this.hyb.isShowRedTip()) {
                    this.hyb.setIsShowRedTip(false);
                    eVar.j(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        return (!v.isEmpty(this.hya) && tabData.size() == this.hya.size() && this.hya.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !uC(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void dH(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an(str2);
                    anVar.cI("obj_type", host);
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
                    if (FrsTabViewController.this.hah != null && FrsTabViewController.this.hah.bOx() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.hah.bOx().bPS());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.hah != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.hah.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hah.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hah.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hah.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hah.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hah.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hah.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hah.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hah.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hah.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hah.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hah.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hah.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.hyb.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.hyb.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.hyb.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.hyb);
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

    private void cD(List<FrsTabInfo> list) {
        if (!v.isEmpty(list)) {
            this.hyd = new com.baidu.tieba.frs.e(this.hah.getActivity().getApplicationContext(), list);
            this.hyd.setForumId(this.hah.getForumId());
            this.hyd.setForumName(this.hah.getForumName());
            this.hyd.setFrom(this.hah.getFrom());
            if (this.hyb != null && this.hyb.getForum() != null) {
                this.hyd.tY(this.hyb.getForum().getFirst_class());
                this.hyd.tZ(this.hyb.getForum().getSecond_class());
                this.hyd.setForumGameLabel(this.hyb.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bN(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.hyd.b(c);
                }
            }
            this.hyi = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.hyd));
        }
    }

    private void bN(int i, int i2) {
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13008");
        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cI("fid", this.hah.getForumId());
        if (i == 89) {
            anVar.af("obj_type", 1);
        } else if (i == 302) {
            anVar.af("obj_type", 3);
        } else if (i == 502) {
            anVar.af("obj_type", 8);
        } else if (i == 90) {
            anVar.af("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                anVar.af("obj_type", 4);
            } else {
                anVar.af("obj_type", 5);
            }
        } else if (i == 404) {
            anVar.af("obj_type", 2);
        } else if (i == 301) {
            anVar.af("obj_type", 7);
        } else if (i == 503) {
            anVar.af("obj_type", 6);
        } else if (i == 504) {
            anVar.af("obj_type", 11);
        }
        anVar.af("obj_locate", i2);
        anVar.aOR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVO() {
        int color;
        int i;
        if (this.hyd != null) {
            List<com.baidu.tbadk.mainTab.b> bOc = this.hyd.bOc();
            if (!v.isEmpty(bOc) && !v.isEmpty(this.hya)) {
                if (this.gCH.getTabCount() > 0) {
                    this.gCH.removeAllTabs();
                }
                bVP();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.a.dA(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.a.dA(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.a.dA(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = am.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = am.getColor(R.color.plugin_button_shadow_red);
                }
                this.gCH.setSelectedTabIndicatorColor(color);
                Iterator it = this.hya.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, bOc);
                    if (m != null) {
                        TbTabLayout.e b2 = this.gCH.ph().b(dVar.name);
                        boolean z = this.hyb.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.hyb != null && this.hyb.isShowRedTip() && dVar.tabId == 89) {
                            b2.j(0, true);
                        } else {
                            b2.j(0, false);
                        }
                        this.gCH.a(b2, z);
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
                if (this.gCH.getTabCount() > 0 && this.hxW.getVisibility() != 0) {
                    this.hxW.setVisibility(0);
                }
                this.hyc = new FragmentAdapter(this.hah.getActivity().getSupportFragmentManager(), this.mFragments);
                this.hxY.setAdapter(this.hyc);
                this.hyc.notifyDataSetChanged();
                this.gCH.setupWithViewPager(this.hxY);
                this.hxY.setOffscreenPageLimit(this.mFragments.size());
                this.hxY.setCurrentItem(i3, false);
                this.hxY.bQs();
            }
        }
    }

    private void bVP() {
        if (this.hxY != null && this.hyc != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.hah.getActivity().getSupportFragmentManager();
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

    public View bVQ() {
        if (isBrandForum() || this.hye == null) {
            return null;
        }
        return this.hye.bSe();
    }

    public static boolean uC(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.hyf = aVar;
    }

    public void R(boolean z, boolean z2) {
        if (this.hyl != z) {
            this.hyl = z;
        }
        if (this.hym != z2) {
            this.hym = z2;
        }
        bVX();
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
                        FrsTabViewController.this.hah.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.hah.setPrimary(true);
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

    public b bVR() {
        if (this.hxY == null) {
            return null;
        }
        return (b) v.getItem(this.mFragments, this.hxY.getCurrentItem());
    }

    public void bVS() {
        this.hyh.al(this.hah.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void bVT() {
        this.hyh.EE();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void uY(int i) {
        this.hbc = i;
        bVW();
    }

    public int bVU() {
        return this.hbc;
    }

    public int bVV() {
        return this.hyk;
    }

    private void bVW() {
        if (this.hbc == 2) {
            am.setBackgroundColor(this.hxW, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hxX, R.color.cp_bg_line_e);
            this.eRx.setVisibility(0);
            this.hah.bOW();
        } else if (this.hbc == 1) {
            am.setBackgroundColor(this.hxW, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.hxX, R.color.cp_bg_line_e);
            this.eRx.setVisibility(0);
        } else {
            bVX();
            this.eRx.setVisibility(8);
            if (this.hah != null) {
                this.hah.bOW();
            }
        }
    }

    private void bVX() {
        if (!this.hyl && !this.hym) {
            am.setBackgroundColor(this.hxW, R.color.transparent);
            am.setBackgroundResource(this.hxX, R.drawable.top_corners_bg);
            return;
        }
        am.setBackgroundColor(this.hxX, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.hxW, R.color.cp_bg_line_e);
    }
}
