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
    private TbTabLayout fPJ;
    private View glJ;
    private FrsFragment iJK;
    private RelativeLayout iQs;
    private RelativeLayout jjI;
    private View jjJ;
    private FrsTabViewPager jjK;
    private LinearGradientView jjL;
    private TabData jjM;
    private FrsViewData jjN;
    private FragmentAdapter jjO;
    private com.baidu.tieba.frs.g jjP;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b jjQ;
    private a jjR;
    private com.baidu.tieba.c.e jjT;
    private int jjW;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int iKE = 0;
    private int jjS = -1;
    private boolean jjU = false;
    public boolean jjV = true;
    private boolean jjX = false;
    private boolean jjY = false;
    CustomMessageListener jjZ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.jjU) {
                FrsTabViewController.this.cGp();
                FrsTabViewController.this.jjU = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.jjK != null) {
                FrsTabViewController.this.jjK.cAq();
                if (!y.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) y.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof au) {
                        ad adVar = new ad();
                        adVar.tabId = bVar.tabId;
                        adVar.iLC = (au) bVar.fragment;
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
    private CustomMessageListener jka = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.jjN != null && FrsTabViewController.this.jjN.isShowRedTip() != booleanValue && FrsTabViewController.this.fPJ.getTabCount() > 0 && !y.isEmpty(FrsTabViewController.this.jjM)) {
                        FrsTabViewController.this.jjN.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.jjM.size(), FrsTabViewController.this.fPJ.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aU = FrsTabViewController.this.fPJ.aU(i);
                            if (aU != null) {
                                if (FrsTabViewController.this.jjM.get(i).tabId == 89) {
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
    private CustomMessageListener gps = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cGs;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cGs = FrsTabViewController.this.cGs()) != null && cGs.fragment != null && (cGs.fragment instanceof as)) {
                        ((as) cGs.fragment).bPV();
                    }
                }
            }
        }
    };
    private CustomMessageListener jkb = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.jjM.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.jjM.size()) {
                    FrsTabViewController.this.jjK.setCurrentItem(i, true);
                }
            }
        }
    };
    private CustomMessageListener jkc = new CustomMessageListener(2921488) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921488) {
                Iterator it = FrsTabViewController.this.jjM.iterator();
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
                if (i <= FrsTabViewController.this.jjM.size() && z) {
                    FrsTabViewController.this.jjK.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener jkd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.jjT.SR();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void cl(int i, int i2);
    }

    public void qv(boolean z) {
        this.fPJ.setDisableTabSelect(z);
    }

    public FrsTabViewPager cGj() {
        return this.jjK;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.iJK = frsFragment;
        this.jjI = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.jjJ = view.findViewById(R.id.frs_tab_bg);
        this.glJ = view.findViewById(R.id.divider_shadow);
        this.jjL = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.fPJ = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.fPJ.setOnTabSelectedListener(this);
        this.fPJ.setSelectedTabTextBlod(true);
        this.fPJ.setTabTextSize(AC(R.dimen.tbds46));
        this.jjT = new com.baidu.tieba.c.e(frsFragment.getPageContext(), this.fPJ);
        this.jjT.fu(R.drawable.bg_tip_blue_up_left);
        this.jjT.ft(16);
        this.jjT.setUseDirectOffset(true);
        this.jjT.xq(AC(R.dimen.tbds34));
        this.jjT.setYOffset(AC(R.dimen.tbds10));
        this.jjT.d(this.jkd);
        this.jjK = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.jjO = new FragmentAdapter(this.iJK.getActivity().getSupportFragmentManager(), this.mFragments);
        this.jjK.addOnPageChangeListener(this.mOnPageChangeListener);
        this.iQs = new RelativeLayout(this.iJK.getContext());
        this.jjQ = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.iQs);
    }

    private int AC(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cGk() {
        return this.iQs;
    }

    public View cGl() {
        return this.jjL;
    }

    private boolean isBrandForum() {
        return this.jjN != null && this.jjN.getIsBrandForum();
    }

    public void registerListener() {
        this.jjZ.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.iJK.registerListener(this.jjZ);
        this.iJK.registerListener(this.jka);
        this.iJK.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gps, this.iJK.getBaseFragmentActivity().getUniqueId());
        this.iJK.registerListener(this.jkb);
        this.iJK.registerListener(this.jkc);
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
                            int KY = com.baidu.tieba.frs.f.i.KY("503~" + str + str2);
                            if (KY == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.i.aS("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == KY) {
                                                com.baidu.tieba.tbadkCore.util.e.dLd();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.dLe();
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
                    } else if (frsTabInfo.tab_type.intValue() == 11 && Al(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.d.As(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && aj.cAp().zh(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ah ze = ag.cAo().ze(dVar6.tabId);
                        if (ze != null && ze.iLR != null && ze.iLR.size() > 0) {
                            dVar6.jgk = new bg();
                            dVar6.jgk.iLQ = ze.iLQ;
                            dVar6.jgk.iLR = new LinkedList();
                            boolean z2 = true;
                            for (af afVar : ze.iLR) {
                                if (afVar != null) {
                                    bf bfVar = new bf();
                                    bfVar.name = afVar.name;
                                    bfVar.iLN = afVar.iLN;
                                    if (z2) {
                                        bfVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.jgk.iLR.add(bfVar);
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
                        ah ze2 = ag.cAo().ze(dVar7.tabId);
                        if (ze2 != null && ze2.iLR != null && ze2.iLR.size() > 0) {
                            dVar7.jgk = new bg();
                            dVar7.jgk.iLQ = ze2.iLQ;
                            dVar7.jgk.iLR = new LinkedList();
                            for (af afVar2 : ze2.iLR) {
                                if (afVar2 != null) {
                                    bf bfVar2 = new bf();
                                    bfVar2.name = afVar2.name;
                                    bfVar2.iLN = afVar2.iLN;
                                    dVar7.jgk.iLR.add(bfVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.iJK.cyl().czK().r(bw.eDX)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.jjS > 0 && this.jjS != frsViewData.getAlaLiveCount() && this.jjS <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.jjS + ")";
                            } else if (this.jjS > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.jjS == 0 && this.jjS != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.bqh().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            dVar9.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                            AD(2);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        dVar10.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                        AD(2);
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
                        AD(1);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.jjN = frsViewData;
                if (this.jjN.getForum() != null) {
                    this.mThemeColorInfo = this.jjN.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.fPJ.getTabCount() > 0 && !y.isEmpty(this.jjM)) {
                    int min = Math.min(this.jjM.size(), this.fPJ.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aU = this.fPJ.aU(i2);
                        if (aU != null) {
                            if (frsViewData.isShowRedTip() && this.jjM.get(i2).tabId == 89) {
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
                        if (this.iJK != null && this.iJK.cyg() != null && frsTabInfo2 != null) {
                            this.iJK.cyg().Aa(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.iJK != null && this.iJK.bta() != null) {
                        if (f != null && f.size() < 2) {
                            this.iJK.bta().removeHeaderView(this.iQs);
                        } else {
                            this.iJK.bta().removeHeaderView(this.iQs);
                            this.iJK.bta().addHeaderView(this.iQs);
                            if (this.jjQ != null && frsViewData.getForum() != null) {
                                this.jjQ.setData(f);
                                this.jjQ.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.jjM = tabData;
                    cGm();
                    ds(arrayList);
                }
            }
        }
    }

    private void AD(int i) {
        TiebaStatic.log(new aq("c13971").dR("fid", this.iJK.forumId).dR("fname", this.iJK.getForumName()).al("obj_locate", i));
    }

    private void cGm() {
        int i = -1;
        if (!y.isEmpty(this.jjM)) {
            i = this.jjM.get(0).tabId;
        }
        if (this.jjN != null) {
            this.jjN.mHeadLineDefaultNavTabId = i;
        }
        if (this.iJK != null) {
            this.iJK.mHeadLineDefaultNavTabId = i;
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
        if (!y.isEmpty(this.jjO.mFragments) && tabData.size() == this.jjO.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.jjO.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.jjO.mFragments.get(i)).tabId) {
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

    public int cGn() {
        Iterator it = this.jjM.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b AE(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    public int cGo() {
        Iterator it = this.jjM.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && dVar.tabType == 16) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean tg(int i) {
        if (i < 0 || this.jjM == null || this.jjM.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.jjM.size()) {
                i2 = -1;
                break;
            } else if (this.jjM.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fPJ.getTabCount()) {
            return false;
        }
        TbTabLayout.e aU = this.fPJ.aU(i2);
        if (aU != null && !aU.isSelected()) {
            aU.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d AF(int i) {
        if (i < 0 || this.jjM == null || this.jjM.size() <= 0) {
            return null;
        }
        Iterator it = this.jjM.iterator();
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
        SvgManager.brn().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        ap.setBackgroundResource(this.glJ, R.drawable.personalize_tab_shadow);
        cGx();
        if (this.fPJ != null) {
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
            this.fPJ.setSelectedTabIndicatorColor(color);
            ap.setBackgroundColor(this.fPJ, R.color.transparent);
            this.fPJ.setTabTextColors(ap.getColor(R.color.cp_cont_j), ap.getColor(R.color.cp_cont_b));
        }
        if (this.jjQ != null && !isBrandForum()) {
            this.jjQ.onChangeSkinType();
        }
        if (this.jjL != null) {
            this.jjL.changeSkinType(i);
        }
        if (!y.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void AG(int i) {
        this.jjS = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.jjM != null && position >= 0 && position < this.jjM.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.jjM.get(position);
            if (dVar != null) {
                this.jjW = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jjN != null && this.jjN.isShowRedTip()) {
                    this.jjN.setIsShowRedTip(false);
                    eVar.l(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.iJK.cyW() != null) {
                        this.iJK.cyW().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.iJK.cyW() != null) {
                    this.iJK.cyW().setIconFade(0);
                }
                if (this.jjR != null) {
                    this.jjR.cl(dVar.tabId, dVar.tabType);
                }
                com.baidu.tieba.frs.b.cxm().po(dVar.tabId == 503);
                com.baidu.tieba.frs.a.cxf().yy(dVar.tabId);
                TiebaStatic.log(new aq("c12398").dR("fid", this.iJK.forumId).al("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        cGu();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.jjM != null && position >= 0 && position < this.jjM.size() && (dVar = this.jjM.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new aq("c12398").dR("fid", this.iJK.forumId).al("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jjN != null && this.jjN.isShowRedTip()) {
                    this.jjN.setIsShowRedTip(false);
                    eVar.l(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (y.isEmpty(tabData)) {
            return false;
        }
        return (!y.isEmpty(this.jjM) && tabData.size() == this.jjM.size() && this.jjM.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !Al(frsTabInfo.tab_id.intValue());
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
                    if (FrsTabViewController.this.iJK != null && FrsTabViewController.this.iJK.cyl() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.iJK.cyl().czL());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.iJK != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.iJK.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iJK.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iJK.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.iJK.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iJK.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iJK.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.iJK.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iJK.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iJK.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.iJK.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iJK.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iJK.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.iJK.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.jjN.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.jjN.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.jjN.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.jjN);
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

    private void ds(List<FrsTabInfo> list) {
        if (!y.isEmpty(list)) {
            this.jjP = new com.baidu.tieba.frs.g(this.iJK.getActivity().getApplicationContext(), list);
            this.jjP.setForumId(this.iJK.getForumId());
            this.jjP.setForumName(this.iJK.getForumName());
            this.jjP.setFrom(this.iJK.getFrom());
            if (this.jjN != null && this.jjN.getForum() != null) {
                this.jjP.Bh(this.jjN.getForum().getFirst_class());
                this.jjP.Bi(this.jjN.getForum().getSecond_class());
                this.jjP.setForumGameLabel(this.jjN.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    cq(frsTabInfo.tab_id.intValue(), 1);
                }
                if (frsTabInfo.tab_type.intValue() == 3) {
                    AD(1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.jjP.b(c);
                }
            }
            this.jjU = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.jjP));
        }
    }

    private void cq(int i, int i2) {
        aq aqVar = new aq("c13008");
        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dR("fid", this.iJK.getForumId());
        if (i == 89) {
            aqVar.al("obj_type", 1);
        } else if (i == 502) {
            aqVar.al("obj_type", 8);
        } else if (i == 90) {
            aqVar.al("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aqVar.al("obj_type", 4);
            } else {
                aqVar.al("obj_type", 5);
            }
        } else if (i == 404) {
            aqVar.al("obj_type", 2);
        } else if (i == 301) {
            aqVar.al("obj_type", 7);
        } else if (i == 503) {
            aqVar.al("obj_type", 6);
        } else if (i == 504) {
            aqVar.al("obj_type", 11);
        }
        aqVar.al("obj_locate", i2);
        aqVar.brk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGp() {
        int color;
        int i;
        if (this.jjP != null) {
            List<com.baidu.tbadk.mainTab.b> cxQ = this.jjP.cxQ();
            if (!y.isEmpty(cxQ) && !y.isEmpty(this.jjM)) {
                if (this.fPJ.getTabCount() > 0) {
                    this.fPJ.removeAllTabs();
                }
                cGq();
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
                this.fPJ.setSelectedTabIndicatorColor(color);
                Iterator it = this.jjM.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, cxQ);
                    if (m != null) {
                        TbTabLayout.e b2 = this.fPJ.rj().b(dVar.name);
                        boolean z = this.jjN.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.iJK.getFrom().equals(FrsActivityConfig.FROM_PB_OR_PERSON) && 3 == dVar.tabType) {
                            i3 = i2;
                        }
                        if (this.jjN != null && this.jjN.isShowRedTip() && dVar.tabId == 89) {
                            b2.l(0, true);
                        } else {
                            b2.l(0, false);
                        }
                        this.fPJ.a(b2, z);
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
                if (this.fPJ.getTabCount() > 0 && this.jjI.getVisibility() != 0) {
                    this.jjI.setVisibility(0);
                }
                this.jjO = new FragmentAdapter(this.iJK.getActivity().getSupportFragmentManager(), this.mFragments);
                this.jjK.setAdapter(this.jjO);
                this.jjO.notifyDataSetChanged();
                this.fPJ.setupWithViewPager(this.jjK);
                this.jjK.setOffscreenPageLimit(this.mFragments.size());
                this.jjK.setCurrentItem(i3, false);
                this.jjK.cAq();
            }
        }
    }

    private void cGq() {
        if (this.jjK != null && this.jjO != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.iJK.getActivity().getSupportFragmentManager();
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

    public View cGr() {
        if (isBrandForum() || this.jjQ == null) {
            return null;
        }
        return this.jjQ.cCm();
    }

    public static boolean Al(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.jjR = aVar;
    }

    public void ae(boolean z, boolean z2) {
        if (this.jjX != z) {
            this.jjX = z;
        }
        if (this.jjY != z2) {
            this.jjY = z2;
        }
        cGy();
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
                        FrsTabViewController.this.iJK.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.iJK.setPrimary(true);
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

    public b cGs() {
        if (this.jjK == null) {
            return null;
        }
        return (b) y.getItem(this.mFragments, this.jjK.getCurrentItem());
    }

    public void cGt() {
        this.jjT.aM(this.iJK.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void cGu() {
        this.jjT.SR();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void AH(int i) {
        this.iKE = i;
        cGx();
    }

    public int cGv() {
        return this.iKE;
    }

    public int cGw() {
        return this.jjW;
    }

    private void cGx() {
        if (this.iKE == 2) {
            ap.setBackgroundColor(this.jjI, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jjJ, R.color.cp_bg_line_e);
            this.glJ.setVisibility(0);
            this.iJK.cyN();
        } else if (this.iKE == 1) {
            ap.setBackgroundColor(this.jjI, R.color.cp_bg_line_e);
            ap.setBackgroundColor(this.jjJ, R.color.cp_bg_line_e);
            this.glJ.setVisibility(0);
        } else {
            cGy();
            this.glJ.setVisibility(8);
            if (this.iJK != null) {
                this.iJK.cyN();
            }
        }
    }

    private void cGy() {
        if (!this.jjX && !this.jjY) {
            ap.setBackgroundColor(this.jjI, R.color.transparent);
            ap.setBackgroundResource(this.jjJ, R.drawable.top_corners_bg);
            return;
        }
        ap.setBackgroundColor(this.jjJ, R.color.cp_bg_line_e);
        ap.setBackgroundColor(this.jjI, R.color.cp_bg_line_e);
    }
}
