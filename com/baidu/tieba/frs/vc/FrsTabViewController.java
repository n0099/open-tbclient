package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
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
/* loaded from: classes2.dex */
public class FrsTabViewController implements TbTabLayout.b, n {
    private View gCD;
    private TbTabLayout geR;
    private FrsViewData jGv;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b jLA;
    private a jLB;
    private PublishProgressView jLC;
    private com.baidu.tieba.c.e jLE;
    private int jLH;
    private RelativeLayout jLt;
    private View jLu;
    private FrsTabViewPager jLv;
    private LinearGradientView jLw;
    private TabData jLx;
    private FragmentAdapter jLy;
    private com.baidu.tieba.frs.g jLz;
    private FrsFragment jiE;
    private RelativeLayout jpq;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int jjy = 0;
    private int jLD = -1;
    private boolean jLF = false;
    public boolean jLG = true;
    private boolean jLI = false;
    private boolean jLJ = false;
    CustomMessageListener jLK = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.jLF) {
                FrsTabViewController.this.cLK();
                FrsTabViewController.this.jLF = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.jLv != null) {
                FrsTabViewController.this.jLv.cEA();
                if (!y.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) y.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof aq) {
                        z zVar = new z();
                        zVar.tabId = bVar.tabId;
                        zVar.jku = (aq) bVar.fragment;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar));
                        return;
                    }
                    z zVar2 = new z();
                    zVar2.tabId = bVar.tabId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar2));
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener jLL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.jGv != null && FrsTabViewController.this.jGv.isShowRedTip() != booleanValue && FrsTabViewController.this.geR.getTabCount() > 0 && !y.isEmpty(FrsTabViewController.this.jLx)) {
                        FrsTabViewController.this.jGv.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.jLx.size(), FrsTabViewController.this.geR.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aZ = FrsTabViewController.this.geR.aZ(i);
                            if (aZ != null) {
                                if (FrsTabViewController.this.jLx.get(i).tabId == 89) {
                                    aZ.l(0, booleanValue);
                                } else {
                                    aZ.l(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gGr = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cLN;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cLN = FrsTabViewController.this.cLN()) != null && cLN.fragment != null && (cLN.fragment instanceof ao)) {
                        ((ao) cLN.fragment).bSq();
                    }
                }
            }
        }
    };
    private final CustomMessageListener jLM = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                bi biVar = (bi) customResponsedMessage.getData();
                if (FrsTabViewController.this.jiE != null && biVar.zZ(FrsTabViewController.this.jiE.getForumId()) && FrsTabViewController.this.jLC != null) {
                    FrsTabViewController.this.jLC.b(biVar);
                }
            }
        }
    };
    private CustomMessageListener jLN = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.jLx.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.jLx.size()) {
                    FrsTabViewController.this.jLv.setCurrentItem(i, true);
                }
            }
        }
    };
    private CustomMessageListener jLO = new CustomMessageListener(2921488) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921488) {
                Iterator it = FrsTabViewController.this.jLx.iterator();
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
                if (i <= FrsTabViewController.this.jLx.size() && z) {
                    FrsTabViewController.this.jLv.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener jLP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.jLE.Tz();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void l(int i, int i2, String str);
    }

    public void rE(boolean z) {
        this.geR.setDisableTabSelect(z);
    }

    public FrsTabViewPager cLE() {
        return this.jLv;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.jiE = frsFragment;
        this.jLt = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.jLu = view.findViewById(R.id.frs_tab_bg);
        this.gCD = view.findViewById(R.id.divider_shadow);
        this.jLw = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.geR = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.geR.setOnTabSelectedListener(this);
        this.geR.setSelectedTabTextBlod(true);
        this.geR.setTabTextSize(AE(R.dimen.tbds42));
        this.jLE = new com.baidu.tieba.c.e(frsFragment.getPageContext(), this.geR);
        this.jLE.en(R.drawable.bg_tip_blue_up_left);
        this.jLE.em(16);
        this.jLE.setUseDirectOffset(true);
        this.jLE.xl(AE(R.dimen.tbds34));
        this.jLE.setYOffset(AE(R.dimen.tbds10));
        this.jLE.e(this.jLP);
        this.jLv = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.jLy = new FragmentAdapter(this.jiE.getActivity().getSupportFragmentManager(), this.mFragments);
        this.jLv.addOnPageChangeListener(this.mOnPageChangeListener);
        this.jpq = new RelativeLayout(this.jiE.getContext());
        this.jLA = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.jpq);
        this.jLC = (PublishProgressView) view.findViewById(R.id.publish_progress_view);
        this.jLC.setVisibility(8);
    }

    private int AE(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cLF() {
        return this.jpq;
    }

    public View cLG() {
        return this.jLw;
    }

    private boolean isBrandForum() {
        return this.jGv != null && this.jGv.getIsBrandForum();
    }

    public void registerListener() {
        this.jLK.setPriority(Integer.MAX_VALUE);
        this.jiE.registerListener(this.jLK);
        this.jiE.registerListener(this.jLL);
        this.jiE.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gGr, this.jiE.getBaseFragmentActivity().getUniqueId());
        this.jiE.registerListener(this.jLN);
        this.jiE.registerListener(this.jLO);
        this.jiE.registerListener(this.jLM);
    }

    public boolean cLH() {
        return this.jLC != null && this.jLC.getVisibility() == 0;
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
                            int Lg = com.baidu.tieba.frs.d.j.Lg("503~" + str + str2);
                            if (Lg == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.d.j.ba("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == Lg) {
                                                com.baidu.tieba.tbadkCore.util.e.dOL();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.dOM();
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
                    } else if (frsTabInfo.tab_type.intValue() == 11 && An(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.c.zB(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && af.cEz().za(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ad yX = ac.cEy().yX(dVar6.tabId);
                        if (yX != null && yX.jkJ != null && yX.jkJ.size() > 0) {
                            dVar6.jHT = new bd();
                            dVar6.jHT.jkI = yX.jkI;
                            dVar6.jHT.jkJ = new LinkedList();
                            boolean z2 = true;
                            for (ab abVar : yX.jkJ) {
                                if (abVar != null) {
                                    bc bcVar = new bc();
                                    bcVar.name = abVar.name;
                                    bcVar.jkF = abVar.jkF;
                                    if (z2) {
                                        bcVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.jHT.jkJ.add(bcVar);
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
                        ad yX2 = ac.cEy().yX(dVar7.tabId);
                        if (yX2 != null && yX2.jkJ != null && yX2.jkJ.size() > 0) {
                            dVar7.jHT = new bd();
                            dVar7.jHT.jkI = yX2.jkI;
                            dVar7.jHT.jkJ = new LinkedList();
                            for (ab abVar2 : yX2.jkJ) {
                                if (abVar2 != null) {
                                    bc bcVar2 = new bc();
                                    bcVar2.name = abVar2.name;
                                    bcVar2.jkF = abVar2.jkF;
                                    dVar7.jHT.jkJ.add(bcVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.jiE.cCu().cDU().r(cb.eQL)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.jLD > 0 && this.jLD != frsViewData.getAlaLiveCount() && this.jLD <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.jLD + ")";
                            } else if (this.jLD > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.jLD == 0 && this.jLD != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            dVar9.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                            AF(2);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        dVar10.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                        AF(2);
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
                        AF(1);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.jGv = frsViewData;
                if (this.jGv.getForum() != null) {
                    this.mThemeColorInfo = this.jGv.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.geR.getTabCount() > 0 && !y.isEmpty(this.jLx)) {
                    int min = Math.min(this.jLx.size(), this.geR.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aZ = this.geR.aZ(i2);
                        if (aZ != null) {
                            if (frsViewData.isShowRedTip() && this.jLx.get(i2).tabId == 89) {
                                aZ.l(0, true);
                            } else {
                                aZ.l(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(f, 0);
                        if (this.jiE != null && this.jiE.cCp() != null && frsTabInfo2 != null) {
                            this.jiE.cCp().Ac(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.jiE != null && this.jiE.getListView() != null) {
                        if (f != null && f.size() < 2) {
                            this.jiE.getListView().removeHeaderView(this.jpq);
                        } else {
                            this.jiE.getListView().removeHeaderView(this.jpq);
                            this.jiE.getListView().addHeaderView(this.jpq);
                            if (this.jLA != null && frsViewData.getForum() != null) {
                                this.jLA.setData(f);
                                this.jLA.setFid(frsViewData.getForum().getId());
                                this.jLA.iF(this.jiE.cCp().cJF());
                                if (com.baidu.tbadk.a.d.bjr() && com.baidu.tbadk.a.b.a.eGq != com.baidu.tbadk.a.b.a.bjK()) {
                                    this.jLA.iF(com.baidu.tbadk.a.b.a.bjK());
                                }
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.jLx = tabData;
                    cLI();
                    dE(arrayList);
                }
            }
        }
    }

    private void AF(int i) {
        TiebaStatic.log(new ar("c13971").dR("fid", this.jiE.forumId).dR("fname", this.jiE.getForumName()).ap("obj_locate", i));
    }

    private void cLI() {
        int i = -1;
        if (!y.isEmpty(this.jLx)) {
            i = this.jLx.get(0).tabId;
        }
        if (this.jGv != null) {
            this.jGv.mHeadLineDefaultNavTabId = i;
        }
        if (this.jiE != null) {
            this.jiE.mHeadLineDefaultNavTabId = i;
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
        if (!y.isEmpty(this.jLy.mFragments) && tabData.size() == this.jLy.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.jLy.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.jLy.mFragments.get(i)).tabId) {
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

    public int cLJ() {
        Iterator it = this.jLx.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b AG(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean sT(int i) {
        if (i < 0 || this.jLx == null || this.jLx.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.jLx.size()) {
                i2 = -1;
                break;
            } else if (this.jLx.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.geR.getTabCount()) {
            return false;
        }
        TbTabLayout.e aZ = this.geR.aZ(i2);
        if (aZ != null && !aZ.isSelected()) {
            aZ.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d AH(int i) {
        if (i < 0 || this.jLx == null || this.jLx.size() <= 0) {
            return null;
        }
        Iterator it = this.jLx.iterator();
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
        ap.setBackgroundResource(this.gCD, R.drawable.personalize_tab_shadow);
        cLS();
        if (this.geR != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.c.b.rM(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.c.b.rM(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.c.b.rM(this.mThemeColorInfo.day.font_color);
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = ap.getColor(R.color.plugin_button_shadow_red);
            }
            this.geR.setSelectedTabIndicatorColor(color);
            this.geR.setSelectedIndicatorBottomMargin(AE(R.dimen.tbds11));
            ap.setBackgroundColor(this.geR, R.color.transparent);
            this.geR.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
        }
        if (this.jLA != null && !isBrandForum()) {
            this.jLA.onChangeSkinType();
        }
        if (this.jLw != null) {
            this.jLw.changeSkinType(i);
        }
        if (!y.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void AI(int i) {
        this.jLD = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.jLx != null && position >= 0 && position < this.jLx.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.jLx.get(position);
            if (dVar != null) {
                this.jLH = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jGv != null && this.jGv.isShowRedTip()) {
                    this.jGv.setIsShowRedTip(false);
                    eVar.l(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.jiE.cDg() != null) {
                        this.jiE.cDg().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.jiE.cDg() != null) {
                    this.jiE.cDg().setIconFade(0);
                }
                if (com.baidu.tbadk.a.d.bjp()) {
                    com.baidu.tbadk.a.b.a.zu(dVar.name);
                }
                if (this.jLB != null) {
                    this.jLB.l(dVar.tabId, dVar.tabType, dVar.name);
                }
                com.baidu.tieba.frs.b.cBr().qr(dVar.tabId == 503);
                com.baidu.tieba.frs.a.cBk().ys(dVar.tabId);
                TiebaStatic.log(new ar("c12398").dR("fid", this.jiE.forumId).ap("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        cLP();
        if (this.jiE != null && this.jiE.cCr() != null) {
            this.jiE.cCr().cLi();
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.jLx != null && position >= 0 && position < this.jLx.size() && (dVar = this.jLx.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new ar("c12398").dR("fid", this.jiE.forumId).ap("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jGv != null && this.jGv.isShowRedTip()) {
                    this.jGv.setIsShowRedTip(false);
                    eVar.l(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (y.isEmpty(tabData)) {
            return false;
        }
        return (!y.isEmpty(this.jLx) && tabData.size() == this.jLx.size() && this.jLx.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !An(frsTabInfo.tab_id.intValue());
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
                    ar arVar = new ar(str2);
                    arVar.dR("obj_type", host);
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.jiE != null && FrsTabViewController.this.jiE.cCu() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.jiE.cCu().cDV());
                        FrsTabViewController.this.jiE.qA(com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jGv.showAdsense.intValue()));
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.jiE != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.jiE.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.11
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jGv.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jiE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jiE.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.jiE.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.12
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jGv.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jiE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jiE.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.jiE.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.13
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.jiE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jiE.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.jiE.getForumId());
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jGv.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jiE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jiE.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.jiE.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.jGv.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.jGv.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.jGv.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.jGv);
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

    private void dE(List<FrsTabInfo> list) {
        if (!y.isEmpty(list)) {
            this.jLz = new com.baidu.tieba.frs.g(this.jiE.getActivity().getApplicationContext(), list);
            this.jLz.setForumId(this.jiE.getForumId());
            this.jLz.setForumName(this.jiE.getForumName());
            this.jLz.setFrom(this.jiE.getFrom());
            if (this.jGv != null && this.jGv.getForum() != null) {
                this.jLz.An(this.jGv.getForum().getFirst_class());
                this.jLz.Ao(this.jGv.getForum().getSecond_class());
                this.jLz.setForumGameLabel(this.jGv.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    cp(frsTabInfo.tab_id.intValue(), 1);
                }
                if (frsTabInfo.tab_type.intValue() == 3) {
                    AF(1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.jLz.b(c);
                }
            }
            this.jLF = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.jLz));
        }
    }

    private void cp(int i, int i2) {
        ar arVar = new ar("c13008");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.jiE.getForumId());
        if (i == 89) {
            arVar.ap("obj_type", 1);
        } else if (i == 502) {
            arVar.ap("obj_type", 8);
        } else if (i == 90) {
            arVar.ap("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                arVar.ap("obj_type", 4);
            } else {
                arVar.ap("obj_type", 5);
            }
        } else if (i == 404) {
            arVar.ap("obj_type", 2);
        } else if (i == 301) {
            arVar.ap("obj_type", 7);
        } else if (i == 503) {
            arVar.ap("obj_type", 6);
        } else if (i == 504) {
            arVar.ap("obj_type", 11);
        }
        arVar.ap("obj_locate", i2);
        arVar.bsO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLK() {
        int color;
        int i;
        if (this.jLz != null) {
            List<com.baidu.tbadk.mainTab.b> cBX = this.jLz.cBX();
            if (!y.isEmpty(cBX) && !y.isEmpty(this.jLx)) {
                if (this.geR.getTabCount() > 0) {
                    this.geR.removeAllTabs();
                }
                cLL();
                ArrayList arrayList = new ArrayList();
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.c.b.rM(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.c.b.rM(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.c.b.rM(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = ap.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
                this.geR.setSelectedTabIndicatorColor(color);
                this.geR.setSelectedIndicatorBottomMargin(AE(R.dimen.tbds10));
                Iterator it = this.jLx.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment n = n(dVar.tabId, cBX);
                    if (n != null) {
                        TbTabLayout.e b2 = this.geR.qL().b(dVar.name);
                        boolean z = this.jGv.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.jiE.getFrom()) && 3 == dVar.tabType) {
                            i3 = i2;
                        }
                        if (this.jGv != null && this.jGv.isShowRedTip() && dVar.tabId == 89) {
                            b2.l(0, true);
                        } else {
                            b2.l(0, false);
                        }
                        this.geR.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = n;
                        bVar.tabType = dVar.tabType;
                        arrayList.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i2 = i;
                }
                if (arrayList.size() > 0) {
                    this.mFragments.clear();
                    this.mFragments.addAll(arrayList);
                }
                if (this.jLy == null) {
                    this.jLy = new FragmentAdapter(this.jiE.getActivity().getSupportFragmentManager(), this.mFragments);
                }
                this.jLv.setAdapter(this.jLy);
                this.jLy.notifyDataSetChanged();
                if (this.geR.getTabCount() > 0 && this.jLt.getVisibility() != 0) {
                    this.jLt.setVisibility(0);
                }
                this.geR.setupWithViewPager(this.jLv);
                this.jLv.setOffscreenPageLimit(this.mFragments.size());
                this.jLv.setCurrentItem(i3, false);
                this.jLv.cEA();
            }
        }
    }

    private void cLL() {
        if (this.jLv != null && this.jLy != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.jiE.getActivity().getSupportFragmentManager();
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

    private Fragment n(int i, List<com.baidu.tbadk.mainTab.b> list) {
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

    public View cLM() {
        if (isBrandForum() || this.jLA == null) {
            return null;
        }
        return this.jLA.cGE();
    }

    public static boolean An(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.jLB = aVar;
    }

    public void ag(boolean z, boolean z2) {
        if (this.jLI != z) {
            this.jLI = z;
        }
        if (this.jLJ != z2) {
            this.jLJ = z2;
        }
        cLT();
    }

    public void aK(float f) {
    }

    /* loaded from: classes2.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<b> mFragments;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.mFragments = list;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return this.mFragments.get(i).fragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.mFragments.get(i).title;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.mPrimaryPosition != i) {
                if (this.mPrimaryPosition != -1) {
                    BaseFragment baseFragment = (BaseFragment) getItem(this.mPrimaryPosition);
                    if (baseFragment instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.jiE.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.jiE.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public int tabType;
        public String title;

        public b() {
        }
    }

    public b cLN() {
        if (this.jLv == null) {
            return null;
        }
        return (b) y.getItem(this.mFragments, this.jLv.getCurrentItem());
    }

    public void cLO() {
        this.jLE.aJ(this.jiE.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void cLP() {
        this.jLE.Tz();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void AJ(int i) {
        this.jjy = i;
        cLS();
    }

    public int cLQ() {
        return this.jjy;
    }

    public int cLR() {
        return this.jLH;
    }

    private void cLS() {
        if (this.jjy == 2) {
            ap.setBackgroundColor(this.jLt, R.color.CAM_X0207);
            ap.setBackgroundColor(this.jLu, R.color.CAM_X0207);
            this.gCD.setVisibility(0);
            this.jiE.cCX();
        } else if (this.jjy == 1) {
            ap.setBackgroundColor(this.jLt, R.color.CAM_X0207);
            ap.setBackgroundColor(this.jLu, R.color.CAM_X0207);
            this.gCD.setVisibility(0);
        } else {
            cLT();
            this.gCD.setVisibility(8);
            if (this.jiE != null) {
                this.jiE.cCX();
            }
        }
    }

    private void cLT() {
        ap.setBackgroundColor(this.jLu, R.color.CAM_X0205);
        this.jLu.setAlpha(0.0f);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jLt).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
    }
}
