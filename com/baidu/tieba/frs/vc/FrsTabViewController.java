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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.at;
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
    private TbTabLayout fXD;
    private View gtB;
    private FrsFragment iVs;
    private RelativeLayout jbZ;
    private FrsViewData jtc;
    private RelativeLayout jxY;
    private View jxZ;
    private FrsTabViewPager jya;
    private LinearGradientView jyb;
    private TabData jyc;
    private FragmentAdapter jyd;
    private com.baidu.tieba.frs.g jye;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b jyf;
    private a jyg;
    private com.baidu.tieba.d.e jyi;
    private int jyl;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int iWm = 0;
    private int jyh = -1;
    private boolean jyj = false;
    public boolean jyk = true;
    private boolean jym = false;
    private boolean jyn = false;
    CustomMessageListener jyo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.jyj) {
                FrsTabViewController.this.cLk();
                FrsTabViewController.this.jyj = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.jya != null) {
                FrsTabViewController.this.jya.cEk();
                if (!y.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) y.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof at) {
                        ac acVar = new ac();
                        acVar.tabId = bVar.tabId;
                        acVar.iXi = (at) bVar.fragment;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, acVar));
                        return;
                    }
                    ac acVar2 = new ac();
                    acVar2.tabId = bVar.tabId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, acVar2));
                }
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener jyp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.jtc != null && FrsTabViewController.this.jtc.isShowRedTip() != booleanValue && FrsTabViewController.this.fXD.getTabCount() > 0 && !y.isEmpty(FrsTabViewController.this.jyc)) {
                        FrsTabViewController.this.jtc.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.jyc.size(), FrsTabViewController.this.fXD.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aY = FrsTabViewController.this.fXD.aY(i);
                            if (aY != null) {
                                if (FrsTabViewController.this.jyc.get(i).tabId == 89) {
                                    aY.l(0, booleanValue);
                                } else {
                                    aY.l(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gxk = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cLn;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cLn = FrsTabViewController.this.cLn()) != null && cLn.fragment != null && (cLn.fragment instanceof ar)) {
                        ((ar) cLn.fragment).bTa();
                    }
                }
            }
        }
    };
    private CustomMessageListener jyq = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.jyc.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.jyc.size()) {
                    FrsTabViewController.this.jya.setCurrentItem(i, true);
                }
            }
        }
    };
    private CustomMessageListener jyr = new CustomMessageListener(2921488) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921488) {
                Iterator it = FrsTabViewController.this.jyc.iterator();
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
                if (i <= FrsTabViewController.this.jyc.size() && z) {
                    FrsTabViewController.this.jya.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener jys = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.jyi.UG();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void cp(int i, int i2);
    }

    public void qZ(boolean z) {
        this.fXD.setDisableTabSelect(z);
    }

    public FrsTabViewPager cLf() {
        return this.jya;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.iVs = frsFragment;
        this.jxY = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.jxZ = view.findViewById(R.id.frs_tab_bg);
        this.gtB = view.findViewById(R.id.divider_shadow);
        this.jyb = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.fXD = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.fXD.setOnTabSelectedListener(this);
        this.fXD.setSelectedTabTextBlod(true);
        this.fXD.setTabTextSize(BO(R.dimen.tbds42));
        this.jyi = new com.baidu.tieba.d.e(frsFragment.getPageContext(), this.fXD);
        this.jyi.fO(R.drawable.bg_tip_blue_up_left);
        this.jyi.fN(16);
        this.jyi.setUseDirectOffset(true);
        this.jyi.yt(BO(R.dimen.tbds34));
        this.jyi.setYOffset(BO(R.dimen.tbds10));
        this.jyi.d(this.jys);
        this.jya = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.jyd = new FragmentAdapter(this.iVs.getActivity().getSupportFragmentManager(), this.mFragments);
        this.jya.addOnPageChangeListener(this.mOnPageChangeListener);
        this.jbZ = new RelativeLayout(this.iVs.getContext());
        this.jyf = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.jbZ);
    }

    private int BO(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cLg() {
        return this.jbZ;
    }

    public View cLh() {
        return this.jyb;
    }

    private boolean isBrandForum() {
        return this.jtc != null && this.jtc.getIsBrandForum();
    }

    public void registerListener() {
        this.jyo.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.iVs.registerListener(this.jyo);
        this.iVs.registerListener(this.jyp);
        this.iVs.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gxk, this.iVs.getBaseFragmentActivity().getUniqueId());
        this.iVs.registerListener(this.jyq);
        this.iVs.registerListener(this.jyr);
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
                            int LG = com.baidu.tieba.frs.f.j.LG("503~" + str + str2);
                            if (LG == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.j.aS("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == LG) {
                                                com.baidu.tieba.tbadkCore.util.e.dQv();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.dQw();
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
                            sb.append("=");
                            sb.append(frsViewData.getForum().getId());
                            dVar4.url = sb.toString();
                            fm(dVar4.url, "c10078");
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && Bx(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.c.Ax(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ai.cEj().Ak(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ag Ah = af.cEi().Ah(dVar6.tabId);
                        if (Ah != null && Ah.iXx != null && Ah.iXx.size() > 0) {
                            dVar6.juA = new bg();
                            dVar6.juA.iXw = Ah.iXw;
                            dVar6.juA.iXx = new LinkedList();
                            boolean z2 = true;
                            for (ae aeVar : Ah.iXx) {
                                if (aeVar != null) {
                                    bf bfVar = new bf();
                                    bfVar.name = aeVar.name;
                                    bfVar.iXt = aeVar.iXt;
                                    if (z2) {
                                        bfVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.juA.iXx.add(bfVar);
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
                        ag Ah2 = af.cEi().Ah(dVar7.tabId);
                        if (Ah2 != null && Ah2.iXx != null && Ah2.iXx.size() > 0) {
                            dVar7.juA = new bg();
                            dVar7.juA.iXw = Ah2.iXw;
                            dVar7.juA.iXx = new LinkedList();
                            for (ae aeVar2 : Ah2.iXx) {
                                if (aeVar2 != null) {
                                    bf bfVar2 = new bf();
                                    bfVar2.name = aeVar2.name;
                                    bfVar2.iXt = aeVar2.iXt;
                                    dVar7.juA.iXx.add(bfVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.iVs.cCf().cDF().r(by.eJr)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.jyh > 0 && this.jyh != frsViewData.getAlaLiveCount() && this.jyh <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.jyh + ")";
                            } else if (this.jyh > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.jyh == 0 && this.jyh != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            dVar9.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                            BP(2);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        dVar10.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                        BP(2);
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
                        dVar12.name = au.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
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
                        BP(1);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.jtc = frsViewData;
                if (this.jtc.getForum() != null) {
                    this.mThemeColorInfo = this.jtc.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.fXD.getTabCount() > 0 && !y.isEmpty(this.jyc)) {
                    int min = Math.min(this.jyc.size(), this.fXD.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aY = this.fXD.aY(i2);
                        if (aY != null) {
                            if (frsViewData.isShowRedTip() && this.jyc.get(i2).tabId == 89) {
                                aY.l(0, true);
                            } else {
                                aY.l(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(f, 0);
                        if (this.iVs != null && this.iVs.cCa() != null && frsTabInfo2 != null) {
                            this.iVs.cCa().Bm(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.iVs != null && this.iVs.bvQ() != null) {
                        if (f != null && f.size() < 2) {
                            this.iVs.bvQ().removeHeaderView(this.jbZ);
                        } else {
                            this.iVs.bvQ().removeHeaderView(this.jbZ);
                            this.iVs.bvQ().addHeaderView(this.jbZ);
                            if (this.jyf != null && frsViewData.getForum() != null) {
                                this.jyf.setData(f);
                                this.jyf.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.jyc = tabData;
                    cLi();
                    dB(arrayList);
                }
            }
        }
    }

    private void BP(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13971").dY("fid", this.iVs.forumId).dY("fname", this.iVs.getForumName()).al("obj_locate", i));
    }

    private void cLi() {
        int i = -1;
        if (!y.isEmpty(this.jyc)) {
            i = this.jyc.get(0).tabId;
        }
        if (this.jtc != null) {
            this.jtc.mHeadLineDefaultNavTabId = i;
        }
        if (this.iVs != null) {
            this.iVs.mHeadLineDefaultNavTabId = i;
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
        if (!y.isEmpty(this.jyd.mFragments) && tabData.size() == this.jyd.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.jyd.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.jyd.mFragments.get(i)).tabId) {
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

    public int cLj() {
        Iterator it = this.jyc.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b BQ(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean ui(int i) {
        if (i < 0 || this.jyc == null || this.jyc.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.jyc.size()) {
                i2 = -1;
                break;
            } else if (this.jyc.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fXD.getTabCount()) {
            return false;
        }
        TbTabLayout.e aY = this.fXD.aY(i2);
        if (aY != null && !aY.isSelected()) {
            aY.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d BR(int i) {
        if (i < 0 || this.jyc == null || this.jyc.size() <= 0) {
            return null;
        }
        Iterator it = this.jyc.iterator();
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
        ap.setBackgroundResource(this.gtB, R.drawable.personalize_tab_shadow);
        cLs();
        if (this.fXD != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.b.sI(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.b.sI(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.b.sI(this.mThemeColorInfo.day.font_color);
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = ap.getColor(R.color.plugin_button_shadow_red);
            }
            this.fXD.setSelectedTabIndicatorColor(color);
            this.fXD.setSelectedIndicatorBottomMargin(BO(R.dimen.tbds11));
            ap.setBackgroundColor(this.fXD, R.color.transparent);
            this.fXD.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
        }
        if (this.jyf != null && !isBrandForum()) {
            this.jyf.onChangeSkinType();
        }
        if (this.jyb != null) {
            this.jyb.changeSkinType(i);
        }
        if (!y.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void BS(int i) {
        this.jyh = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.jyc != null && position >= 0 && position < this.jyc.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.jyc.get(position);
            if (dVar != null) {
                this.jyl = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jtc != null && this.jtc.isShowRedTip()) {
                    this.jtc.setIsShowRedTip(false);
                    eVar.l(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.iVs.cCR() != null) {
                        this.iVs.cCR().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.iVs.cCR() != null) {
                    this.iVs.cCR().setIconFade(0);
                }
                if (this.jyg != null) {
                    this.jyg.cp(dVar.tabId, dVar.tabType);
                }
                com.baidu.tieba.frs.b.cBe().pO(dVar.tabId == 503);
                com.baidu.tieba.frs.a.cAX().zB(dVar.tabId);
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12398").dY("fid", this.iVs.forumId).al("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        cLp();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.jyc != null && position >= 0 && position < this.jyc.size() && (dVar = this.jyc.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12398").dY("fid", this.iVs.forumId).al("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jtc != null && this.jtc.isShowRedTip()) {
                    this.jtc.setIsShowRedTip(false);
                    eVar.l(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (y.isEmpty(tabData)) {
            return false;
        }
        return (!y.isEmpty(this.jyc) && tabData.size() == this.jyc.size() && this.jyc.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !Bx(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void fm(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(str2);
                    arVar.dY("obj_type", host);
                    TiebaStatic.log(arVar);
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
                    if (FrsTabViewController.this.iVs != null && FrsTabViewController.this.iVs.cCf() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.iVs.cCf().cDG());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.iVs != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.iVs.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iVs.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iVs.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.iVs.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iVs.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iVs.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.iVs.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iVs.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iVs.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.iVs.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.iVs.getForumName());
                    bundle.putString("from", FrsTabViewController.this.iVs.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.iVs.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.jtc.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.jtc.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.jtc.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.jtc);
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

    private void dB(List<FrsTabInfo> list) {
        if (!y.isEmpty(list)) {
            this.jye = new com.baidu.tieba.frs.g(this.iVs.getActivity().getApplicationContext(), list);
            this.jye.setForumId(this.iVs.getForumId());
            this.jye.setForumName(this.iVs.getForumName());
            this.jye.setFrom(this.iVs.getFrom());
            if (this.jtc != null && this.jtc.getForum() != null) {
                this.jye.Bj(this.jtc.getForum().getFirst_class());
                this.jye.Bk(this.jtc.getForum().getSecond_class());
                this.jye.setForumGameLabel(this.jtc.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    cu(frsTabInfo.tab_id.intValue(), 1);
                }
                if (frsTabInfo.tab_type.intValue() == 3) {
                    BP(1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.jye.b(c);
                }
            }
            this.jyj = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.jye));
        }
    }

    private void cu(int i, int i2) {
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13008");
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dY("fid", this.iVs.getForumId());
        if (i == 89) {
            arVar.al("obj_type", 1);
        } else if (i == 502) {
            arVar.al("obj_type", 8);
        } else if (i == 90) {
            arVar.al("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                arVar.al("obj_type", 4);
            } else {
                arVar.al("obj_type", 5);
            }
        } else if (i == 404) {
            arVar.al("obj_type", 2);
        } else if (i == 301) {
            arVar.al("obj_type", 7);
        } else if (i == 503) {
            arVar.al("obj_type", 6);
        } else if (i == 504) {
            arVar.al("obj_type", 11);
        }
        arVar.al("obj_locate", i2);
        arVar.btT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLk() {
        int color;
        int i;
        if (this.jye != null) {
            List<com.baidu.tbadk.mainTab.b> cBK = this.jye.cBK();
            if (!y.isEmpty(cBK) && !y.isEmpty(this.jyc)) {
                if (this.fXD.getTabCount() > 0) {
                    this.fXD.removeAllTabs();
                }
                cLl();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.b.sI(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.b.sI(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.b.sI(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = ap.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
                this.fXD.setSelectedTabIndicatorColor(color);
                this.fXD.setSelectedIndicatorBottomMargin(BO(R.dimen.tbds10));
                Iterator it = this.jyc.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, cBK);
                    if (m != null) {
                        TbTabLayout.e b2 = this.fXD.rl().b(dVar.name);
                        boolean z = this.jtc.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.iVs.getFrom()) && 3 == dVar.tabType) {
                            i3 = i2;
                        }
                        if (this.jtc != null && this.jtc.isShowRedTip() && dVar.tabId == 89) {
                            b2.l(0, true);
                        } else {
                            b2.l(0, false);
                        }
                        this.fXD.a(b2, z);
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
                if (this.fXD.getTabCount() > 0 && this.jxY.getVisibility() != 0) {
                    this.jxY.setVisibility(0);
                }
                this.jyd = new FragmentAdapter(this.iVs.getActivity().getSupportFragmentManager(), this.mFragments);
                this.jya.setAdapter(this.jyd);
                this.jyd.notifyDataSetChanged();
                this.fXD.setupWithViewPager(this.jya);
                this.jya.setOffscreenPageLimit(this.mFragments.size());
                this.jya.setCurrentItem(i3, false);
                this.jya.cEk();
            }
        }
    }

    private void cLl() {
        if (this.jya != null && this.jyd != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.iVs.getActivity().getSupportFragmentManager();
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

    public View cLm() {
        if (isBrandForum() || this.jyf == null) {
            return null;
        }
        return this.jyf.cGj();
    }

    public static boolean Bx(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.jyg = aVar;
    }

    public void ae(boolean z, boolean z2) {
        if (this.jym != z) {
            this.jym = z;
        }
        if (this.jyn != z2) {
            this.jyn = z2;
        }
        cLt();
    }

    public void aF(float f) {
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
                        FrsTabViewController.this.iVs.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.iVs.setPrimary(true);
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

    public b cLn() {
        if (this.jya == null) {
            return null;
        }
        return (b) y.getItem(this.mFragments, this.jya.getCurrentItem());
    }

    public void cLo() {
        this.jyi.aP(this.iVs.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void cLp() {
        this.jyi.UG();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void BT(int i) {
        this.iWm = i;
        cLs();
    }

    public int cLq() {
        return this.iWm;
    }

    public int cLr() {
        return this.jyl;
    }

    private void cLs() {
        if (this.iWm == 2) {
            if (com.baidu.tbadk.a.d.bkA()) {
                ap.setBackgroundColor(this.jxY, R.color.CAM_X0208);
                ap.setBackgroundColor(this.jxZ, R.color.CAM_X0208);
            } else {
                ap.setBackgroundColor(this.jxY, R.color.CAM_X0207);
                ap.setBackgroundColor(this.jxZ, R.color.CAM_X0207);
            }
            this.gtB.setVisibility(0);
            this.iVs.cCI();
        } else if (this.iWm == 1) {
            if (com.baidu.tbadk.a.d.bkA()) {
                ap.setBackgroundColor(this.jxY, R.color.CAM_X0208);
                ap.setBackgroundColor(this.jxZ, R.color.CAM_X0208);
            } else {
                ap.setBackgroundColor(this.jxY, R.color.CAM_X0207);
                ap.setBackgroundColor(this.jxZ, R.color.CAM_X0207);
            }
            this.gtB.setVisibility(0);
        } else {
            cLt();
            this.gtB.setVisibility(8);
            if (this.iVs != null) {
                this.iVs.cCI();
            }
        }
    }

    private void cLt() {
        ap.setBackgroundColor(this.jxZ, R.color.CAM_X0205);
        this.jxZ.setAlpha(0.0f);
        if (com.baidu.tbadk.a.d.bkA()) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jxY).setBackGroundColor(R.color.CAM_X0205);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jxY).k(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
        }
    }
}
