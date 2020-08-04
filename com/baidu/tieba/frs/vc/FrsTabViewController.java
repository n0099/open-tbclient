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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes16.dex */
public class FrsTabViewController implements TbTabLayout.b, n {
    private View fuQ;
    private FrsFragment hHU;
    private RelativeLayout hNN;
    private TbTabLayout hka;
    private RelativeLayout igS;
    private View igT;
    private FrsTabViewPager igU;
    private LinearGradientView igV;
    private TabData igW;
    private FrsViewData igX;
    private FragmentAdapter igY;
    private com.baidu.tieba.frs.g igZ;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b iha;
    private a ihb;
    private com.baidu.tieba.c.e ihd;
    private int ihg;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int hIO = 0;
    private int ihc = -1;
    private boolean ihe = false;
    public boolean ihf = true;
    private boolean ihh = false;
    private boolean ihi = false;
    CustomMessageListener ihj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.ihe) {
                FrsTabViewController.this.cjm();
                FrsTabViewController.this.ihe = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.igU != null) {
                FrsTabViewController.this.igU.cdx();
                if (!x.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) x.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof as) {
                        ab abVar = new ab();
                        abVar.tabId = bVar.tabId;
                        abVar.hJD = (as) bVar.fragment;
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
    private CustomMessageListener ihk = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.igX != null && FrsTabViewController.this.igX.isShowRedTip() != booleanValue && FrsTabViewController.this.hka.getTabCount() > 0 && !x.isEmpty(FrsTabViewController.this.igW)) {
                        FrsTabViewController.this.igX.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.igW.size(), FrsTabViewController.this.hka.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aN = FrsTabViewController.this.hka.aN(i);
                            if (aN != null) {
                                if (FrsTabViewController.this.igW.get(i).tabId == 89) {
                                    aN.k(0, booleanValue);
                                } else {
                                    aN.k(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fyz = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cjp;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cjp = FrsTabViewController.this.cjp()) != null && cjp.fragment != null && (cjp.fragment instanceof aq)) {
                        ((aq) cjp.fragment).bxR();
                    }
                }
            }
        }
    };
    private CustomMessageListener ihl = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.igW.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.igW.size()) {
                    FrsTabViewController.this.igU.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener ihm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.ihd.HN();
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void bW(int i, int i2);
    }

    public void oD(boolean z) {
        this.hka.setDisableTabSelect(z);
    }

    public FrsTabViewPager cjg() {
        return this.igU;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.hHU = frsFragment;
        this.igS = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.igT = view.findViewById(R.id.frs_tab_bg);
        this.fuQ = view.findViewById(R.id.divider_shadow);
        this.igV = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.hka = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.hka.setOnTabSelectedListener(this);
        this.hka.setSelectedTabTextBlod(true);
        this.hka.setTabTextSize(wy(R.dimen.tbds46));
        this.ihd = new com.baidu.tieba.c.e(frsFragment.getPageContext(), this.hka);
        this.ihd.cS(R.drawable.bg_tip_blue_up_left);
        this.ihd.cR(16);
        this.ihd.setUseDirectOffset(true);
        this.ihd.tr(wy(R.dimen.tbds34));
        this.ihd.setYOffset(wy(R.dimen.tbds10));
        this.ihd.c(this.ihm);
        this.igU = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.igY = new FragmentAdapter(this.hHU.getActivity().getSupportFragmentManager(), this.mFragments);
        this.igU.addOnPageChangeListener(this.mOnPageChangeListener);
        this.hNN = new RelativeLayout(this.hHU.getContext());
        this.iha = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.hNN);
    }

    private int wy(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cjh() {
        return this.hNN;
    }

    public View cji() {
        return this.igV;
    }

    private boolean isBrandForum() {
        return this.igX != null && this.igX.getIsBrandForum();
    }

    public void registerListener() {
        this.ihj.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.hHU.registerListener(this.ihj);
        this.hHU.registerListener(this.ihk);
        this.hHU.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fyz, this.hHU.getBaseFragmentActivity().getUniqueId());
        this.hHU.registerListener(this.ihl);
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
                            int Gu = com.baidu.tieba.frs.f.g.Gu("503~" + str + str2);
                            if (Gu == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aL("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == Gu) {
                                                com.baidu.tieba.tbadkCore.util.e.dmo();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.dmp();
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
                            eq(dVar4.url, "c10078");
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && wh(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.d.ws(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ah.cdw().vf(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        af vc = ae.cdv().vc(dVar6.tabId);
                        if (vc != null && vc.hJT != null && vc.hJT.size() > 0) {
                            dVar6.idy = new be();
                            dVar6.idy.hJS = vc.hJS;
                            dVar6.idy.hJT = new LinkedList();
                            boolean z2 = true;
                            for (ad adVar : vc.hJT) {
                                if (adVar != null) {
                                    bd bdVar = new bd();
                                    bdVar.name = adVar.name;
                                    bdVar.hJP = adVar.hJP;
                                    if (z2) {
                                        bdVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.idy.hJT.add(bdVar);
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
                        af vc2 = ae.cdv().vc(dVar7.tabId);
                        if (vc2 != null && vc2.hJT != null && vc2.hJT.size() > 0) {
                            dVar7.idy = new be();
                            dVar7.idy.hJS = vc2.hJS;
                            dVar7.idy.hJT = new LinkedList();
                            for (ad adVar2 : vc2.hJT) {
                                if (adVar2 != null) {
                                    bd bdVar2 = new bd();
                                    bdVar2.name = adVar2.name;
                                    bdVar2.hJP = adVar2.hJP;
                                    dVar7.idy.hJT.add(bdVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.hHU.cbw().ccU().s(bv.dRT)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.ihc > 0 && this.ihc != frsViewData.getAlaLiveCount() && this.ihc <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.ihc + ")";
                            } else if (this.ihc > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.ihc == 0 && this.ihc != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.aZP().getInt("chushou_game_tab", 1) == 1) {
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
                        dVar12.name = com.baidu.tbadk.core.util.as.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
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
                this.igX = frsViewData;
                if (this.igX.getForum() != null) {
                    this.mThemeColorInfo = this.igX.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.hka.getTabCount() > 0 && !x.isEmpty(this.igW)) {
                    int min = Math.min(this.igW.size(), this.hka.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aN = this.hka.aN(i2);
                        if (aN != null) {
                            if (frsViewData.isShowRedTip() && this.igW.get(i2).tabId == 89) {
                                aN.k(0, true);
                            } else {
                                aN.k(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) x.getItem(f, 0);
                        if (this.hHU != null && this.hHU.cbr() != null && frsTabInfo2 != null) {
                            this.hHU.cbr().vW(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.hHU != null && this.hHU.bcE() != null) {
                        if (f != null && f.size() < 2) {
                            this.hHU.bcE().removeHeaderView(this.hNN);
                        } else {
                            this.hHU.bcE().removeHeaderView(this.hNN);
                            this.hHU.bcE().addHeaderView(this.hNN);
                            if (this.iha != null && frsViewData.getForum() != null) {
                                this.iha.setData(f);
                                this.iha.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.igW = tabData;
                    cjj();
                    cQ(arrayList);
                }
            }
        }
    }

    private void cjj() {
        int i = -1;
        if (!x.isEmpty(this.igW)) {
            i = this.igW.get(0).tabId;
        }
        if (this.igX != null) {
            this.igX.mHeadLineDefaultNavTabId = i;
        }
        if (this.hHU != null) {
            this.hHU.mHeadLineDefaultNavTabId = i;
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
        if (x.isEmpty(tabData)) {
            return false;
        }
        b(tabData);
        if (!x.isEmpty(this.igY.mFragments) && tabData.size() == this.igY.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.igY.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.igY.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void b(TabData tabData) {
        if (!x.isEmpty(tabData)) {
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

    public int cjk() {
        Iterator it = this.igW.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b wz(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public int cjl() {
        Iterator it = this.igW.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && dVar.tabType == 16) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean wA(int i) {
        if (i < 0 || this.igW == null || this.igW.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.igW.size()) {
                i2 = -1;
                break;
            } else if (this.igW.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.hka.getTabCount()) {
            return false;
        }
        TbTabLayout.e aN = this.hka.aN(i2);
        if (aN != null && !aN.isSelected()) {
            aN.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d wB(int i) {
        if (i < 0 || this.igW == null || this.igW.size() <= 0) {
            return null;
        }
        Iterator it = this.igW.iterator();
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
        SvgManager.baR().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        ao.setBackgroundResource(this.fuQ, R.drawable.personalize_tab_shadow);
        cju();
        if (this.hka != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.a.dU(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.a.dU(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.a.dU(this.mThemeColorInfo.day.font_color);
                } else {
                    color = ao.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = ao.getColor(R.color.plugin_button_shadow_red);
            }
            this.hka.setSelectedTabIndicatorColor(color);
            ao.setBackgroundColor(this.hka, R.color.transparent);
            this.hka.setTabTextColors(ao.getColor(R.color.cp_cont_j), ao.getColor(R.color.cp_cont_b));
        }
        if (this.iha != null && !isBrandForum()) {
            this.iha.onChangeSkinType();
        }
        if (this.igV != null) {
            this.igV.changeSkinType(i);
        }
        if (!x.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void wC(int i) {
        this.ihc = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.igW != null && position >= 0 && position < this.igW.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.igW.get(position);
            if (dVar != null) {
                this.ihg = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.igX != null && this.igX.isShowRedTip()) {
                    this.igX.setIsShowRedTip(false);
                    eVar.k(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.hHU.ccg() != null) {
                        this.hHU.ccg().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.hHU.ccg() != null) {
                    this.hHU.ccg().setIconFade(0);
                }
                if (this.ihb != null) {
                    this.ihb.bW(dVar.tabId, dVar.tabType);
                }
                com.baidu.tieba.frs.b.caw().nw(dVar.tabId == 503);
                com.baidu.tieba.frs.a.cap().uy(dVar.tabId);
                TiebaStatic.log(new ap("c12398").dn("fid", this.hHU.forumId).ah("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        cjr();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.igW != null && position >= 0 && position < this.igW.size() && (dVar = this.igW.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new ap("c12398").dn("fid", this.hHU.forumId).ah("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.igX != null && this.igX.isShowRedTip()) {
                    this.igX.setIsShowRedTip(false);
                    eVar.k(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (x.isEmpty(tabData)) {
            return false;
        }
        return (!x.isEmpty(this.igW) && tabData.size() == this.igW.size() && this.igW.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !wh(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void eq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    ap apVar = new ap(str2);
                    apVar.dn("obj_type", host);
                    TiebaStatic.log(apVar);
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
                    if (FrsTabViewController.this.hHU != null && FrsTabViewController.this.hHU.cbw() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.hHU.cbw().ccV());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.hHU != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.hHU.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hHU.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hHU.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hHU.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hHU.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hHU.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.hHU.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hHU.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hHU.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hHU.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.hHU.getForumName());
                    bundle.putString("from", FrsTabViewController.this.hHU.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.hHU.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.igX.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.igX.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.igX.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.igX);
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

    private void cQ(List<FrsTabInfo> list) {
        if (!x.isEmpty(list)) {
            this.igZ = new com.baidu.tieba.frs.g(this.hHU.getActivity().getApplicationContext(), list);
            this.igZ.setForumId(this.hHU.getForumId());
            this.igZ.setForumName(this.hHU.getForumName());
            this.igZ.setFrom(this.hHU.getFrom());
            if (this.igX != null && this.igX.getForum() != null) {
                this.igZ.xe(this.igX.getForum().getFirst_class());
                this.igZ.xf(this.igX.getForum().getSecond_class());
                this.igZ.setForumGameLabel(this.igX.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    cb(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.igZ.b(c);
                }
            }
            this.ihe = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.igZ));
        }
    }

    private void cb(int i, int i2) {
        ap apVar = new ap("c13008");
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        apVar.dn("fid", this.hHU.getForumId());
        if (i == 89) {
            apVar.ah("obj_type", 1);
        } else if (i == 502) {
            apVar.ah("obj_type", 8);
        } else if (i == 90) {
            apVar.ah("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                apVar.ah("obj_type", 4);
            } else {
                apVar.ah("obj_type", 5);
            }
        } else if (i == 404) {
            apVar.ah("obj_type", 2);
        } else if (i == 301) {
            apVar.ah("obj_type", 7);
        } else if (i == 503) {
            apVar.ah("obj_type", 6);
        } else if (i == 504) {
            apVar.ah("obj_type", 11);
        }
        apVar.ah("obj_locate", i2);
        apVar.baO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjm() {
        int color;
        int i;
        if (this.igZ != null) {
            List<com.baidu.tbadk.mainTab.b> cbb = this.igZ.cbb();
            if (!x.isEmpty(cbb) && !x.isEmpty(this.igW)) {
                if (this.hka.getTabCount() > 0) {
                    this.hka.removeAllTabs();
                }
                cjn();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.a.dU(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.a.dU(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.a.dU(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = ao.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = ao.getColor(R.color.plugin_button_shadow_red);
                }
                this.hka.setSelectedTabIndicatorColor(color);
                Iterator it = this.igW.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, cbb);
                    if (m != null) {
                        TbTabLayout.e b2 = this.hka.pF().b(dVar.name);
                        boolean z = this.igX.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.igX != null && this.igX.isShowRedTip() && dVar.tabId == 89) {
                            b2.k(0, true);
                        } else {
                            b2.k(0, false);
                        }
                        this.hka.a(b2, z);
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
                if (this.hka.getTabCount() > 0 && this.igS.getVisibility() != 0) {
                    this.igS.setVisibility(0);
                }
                this.igY = new FragmentAdapter(this.hHU.getActivity().getSupportFragmentManager(), this.mFragments);
                this.igU.setAdapter(this.igY);
                this.igY.notifyDataSetChanged();
                this.hka.setupWithViewPager(this.igU);
                this.igU.setOffscreenPageLimit(this.mFragments.size());
                this.igU.setCurrentItem(i3, false);
                this.igU.cdx();
            }
        }
    }

    private void cjn() {
        if (this.igU != null && this.igY != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.hHU.getActivity().getSupportFragmentManager();
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

    public View cjo() {
        if (isBrandForum() || this.iha == null) {
            return null;
        }
        return this.iha.cfo();
    }

    public static boolean wh(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.ihb = aVar;
    }

    public void W(boolean z, boolean z2) {
        if (this.ihh != z) {
            this.ihh = z;
        }
        if (this.ihi != z2) {
            this.ihi = z2;
        }
        cjv();
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
                        FrsTabViewController.this.hHU.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.hHU.setPrimary(true);
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

    public b cjp() {
        if (this.igU == null) {
            return null;
        }
        return (b) x.getItem(this.mFragments, this.igU.getCurrentItem());
    }

    public void cjq() {
        this.ihd.aC(this.hHU.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void cjr() {
        this.ihd.HN();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void wD(int i) {
        this.hIO = i;
        cju();
    }

    public int cjs() {
        return this.hIO;
    }

    public int cjt() {
        return this.ihg;
    }

    private void cju() {
        if (this.hIO == 2) {
            ao.setBackgroundColor(this.igS, R.color.cp_bg_line_e);
            ao.setBackgroundColor(this.igT, R.color.cp_bg_line_e);
            this.fuQ.setVisibility(0);
            this.hHU.cbX();
        } else if (this.hIO == 1) {
            ao.setBackgroundColor(this.igS, R.color.cp_bg_line_e);
            ao.setBackgroundColor(this.igT, R.color.cp_bg_line_e);
            this.fuQ.setVisibility(0);
        } else {
            cjv();
            this.fuQ.setVisibility(8);
            if (this.hHU != null) {
                this.hHU.cbX();
            }
        }
    }

    private void cjv() {
        if (!this.ihh && !this.ihi) {
            ao.setBackgroundColor(this.igS, R.color.transparent);
            ao.setBackgroundResource(this.igT, R.drawable.top_corners_bg);
            return;
        }
        ao.setBackgroundColor(this.igT, R.color.cp_bg_line_e);
        ao.setBackgroundColor(this.igS, R.color.cp_bg_line_e);
    }
}
