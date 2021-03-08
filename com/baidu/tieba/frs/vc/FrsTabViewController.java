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
    private View gEA;
    private TbTabLayout ggz;
    private FrsViewData jIs;
    private com.baidu.tieba.c.e jNB;
    private int jNE;
    private RelativeLayout jNq;
    private View jNr;
    private FrsTabViewPager jNs;
    private LinearGradientView jNt;
    private TabData jNu;
    private FragmentAdapter jNv;
    private com.baidu.tieba.frs.g jNw;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b jNx;
    private a jNy;
    private PublishProgressView jNz;
    private FrsFragment jkB;
    private RelativeLayout jrn;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int jlv = 0;
    private int jNA = -1;
    private boolean jNC = false;
    public boolean jND = true;
    private boolean jNF = false;
    private boolean jNG = false;
    CustomMessageListener jNH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.jNC) {
                FrsTabViewController.this.cLX();
                FrsTabViewController.this.jNC = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.jNs != null) {
                FrsTabViewController.this.jNs.cEN();
                if (!y.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) y.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof aq) {
                        z zVar = new z();
                        zVar.tabId = bVar.tabId;
                        zVar.jms = (aq) bVar.fragment;
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
    private CustomMessageListener jNI = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.jIs != null && FrsTabViewController.this.jIs.isShowRedTip() != booleanValue && FrsTabViewController.this.ggz.getTabCount() > 0 && !y.isEmpty(FrsTabViewController.this.jNu)) {
                        FrsTabViewController.this.jIs.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.jNu.size(), FrsTabViewController.this.ggz.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e ba = FrsTabViewController.this.ggz.ba(i);
                            if (ba != null) {
                                if (FrsTabViewController.this.jNu.get(i).tabId == 89) {
                                    ba.l(0, booleanValue);
                                } else {
                                    ba.l(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gIo = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cMa;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cMa = FrsTabViewController.this.cMa()) != null && cMa.fragment != null && (cMa.fragment instanceof ao)) {
                        ((ao) cMa.fragment).bSD();
                    }
                }
            }
        }
    };
    private final CustomMessageListener jNJ = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bi)) {
                bi biVar = (bi) customResponsedMessage.getData();
                if (FrsTabViewController.this.jkB != null && biVar.Ag(FrsTabViewController.this.jkB.getForumId()) && FrsTabViewController.this.jNz != null) {
                    FrsTabViewController.this.jNz.b(biVar);
                }
            }
        }
    };
    private CustomMessageListener jNK = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.jNu.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.jNu.size()) {
                    FrsTabViewController.this.jNs.setCurrentItem(i, true);
                }
            }
        }
    };
    private CustomMessageListener jNL = new CustomMessageListener(2921488) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921488) {
                Iterator it = FrsTabViewController.this.jNu.iterator();
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
                if (i <= FrsTabViewController.this.jNu.size() && z) {
                    FrsTabViewController.this.jNs.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener jNM = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.jNB.TC();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void l(int i, int i2, String str);
    }

    public void rE(boolean z) {
        this.ggz.setDisableTabSelect(z);
    }

    public FrsTabViewPager cLR() {
        return this.jNs;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.jkB = frsFragment;
        this.jNq = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.jNr = view.findViewById(R.id.frs_tab_bg);
        this.gEA = view.findViewById(R.id.divider_shadow);
        this.jNt = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.ggz = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.ggz.setOnTabSelectedListener(this);
        this.ggz.setSelectedTabTextBlod(true);
        this.ggz.setTabTextSize(AF(R.dimen.tbds42));
        this.jNB = new com.baidu.tieba.c.e(frsFragment.getPageContext(), this.ggz);
        this.jNB.eo(R.drawable.bg_tip_blue_up_left);
        this.jNB.en(16);
        this.jNB.setUseDirectOffset(true);
        this.jNB.xm(AF(R.dimen.tbds34));
        this.jNB.setYOffset(AF(R.dimen.tbds10));
        this.jNB.e(this.jNM);
        this.jNs = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.jNv = new FragmentAdapter(this.jkB.getActivity().getSupportFragmentManager(), this.mFragments);
        this.jNs.addOnPageChangeListener(this.mOnPageChangeListener);
        this.jrn = new RelativeLayout(this.jkB.getContext());
        this.jNx = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.jrn);
        this.jNz = (PublishProgressView) view.findViewById(R.id.publish_progress_view);
        this.jNz.setVisibility(8);
    }

    private int AF(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cLS() {
        return this.jrn;
    }

    public View cLT() {
        return this.jNt;
    }

    private boolean isBrandForum() {
        return this.jIs != null && this.jIs.getIsBrandForum();
    }

    public void registerListener() {
        this.jNH.setPriority(Integer.MAX_VALUE);
        this.jkB.registerListener(this.jNH);
        this.jkB.registerListener(this.jNI);
        this.jkB.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gIo, this.jkB.getBaseFragmentActivity().getUniqueId());
        this.jkB.registerListener(this.jNK);
        this.jkB.registerListener(this.jNL);
        this.jkB.registerListener(this.jNJ);
    }

    public boolean cLU() {
        return this.jNz != null && this.jNz.getVisibility() == 0;
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
                            int Lq = com.baidu.tieba.frs.d.j.Lq("503~" + str + str2);
                            if (Lq == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.d.j.bb("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == Lq) {
                                                com.baidu.tieba.tbadkCore.util.e.dPc();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.dPd();
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
                    } else if (frsTabInfo.tab_type.intValue() == 11 && Ao(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.c.zI(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && af.cEM().zb(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ad yY = ac.cEL().yY(dVar6.tabId);
                        if (yY != null && yY.jmH != null && yY.jmH.size() > 0) {
                            dVar6.jJQ = new bd();
                            dVar6.jJQ.jmG = yY.jmG;
                            dVar6.jJQ.jmH = new LinkedList();
                            boolean z2 = true;
                            for (ab abVar : yY.jmH) {
                                if (abVar != null) {
                                    bc bcVar = new bc();
                                    bcVar.name = abVar.name;
                                    bcVar.jmD = abVar.jmD;
                                    if (z2) {
                                        bcVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.jJQ.jmH.add(bcVar);
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
                        ad yY2 = ac.cEL().yY(dVar7.tabId);
                        if (yY2 != null && yY2.jmH != null && yY2.jmH.size() > 0) {
                            dVar7.jJQ = new bd();
                            dVar7.jJQ.jmG = yY2.jmG;
                            dVar7.jJQ.jmH = new LinkedList();
                            for (ab abVar2 : yY2.jmH) {
                                if (abVar2 != null) {
                                    bc bcVar2 = new bc();
                                    bcVar2.name = abVar2.name;
                                    bcVar2.jmD = abVar2.jmD;
                                    dVar7.jJQ.jmH.add(bcVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.jkB.cCH().cEh().r(cb.eSm)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.jNA > 0 && this.jNA != frsViewData.getAlaLiveCount() && this.jNA <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.jNA + ")";
                            } else if (this.jNA > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.jNA == 0 && this.jNA != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.brR().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            dVar9.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                            AG(2);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        dVar10.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                        AG(2);
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
                        AG(1);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.jIs = frsViewData;
                if (this.jIs.getForum() != null) {
                    this.mThemeColorInfo = this.jIs.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.ggz.getTabCount() > 0 && !y.isEmpty(this.jNu)) {
                    int min = Math.min(this.jNu.size(), this.ggz.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e ba = this.ggz.ba(i2);
                        if (ba != null) {
                            if (frsViewData.isShowRedTip() && this.jNu.get(i2).tabId == 89) {
                                ba.l(0, true);
                            } else {
                                ba.l(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) y.getItem(f, 0);
                        if (this.jkB != null && this.jkB.cCC() != null && frsTabInfo2 != null) {
                            this.jkB.cCC().Ad(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.jkB != null && this.jkB.getListView() != null) {
                        if (f != null && f.size() < 2) {
                            this.jkB.getListView().removeHeaderView(this.jrn);
                        } else {
                            this.jkB.getListView().removeHeaderView(this.jrn);
                            this.jkB.getListView().addHeaderView(this.jrn);
                            if (this.jNx != null && frsViewData.getForum() != null) {
                                this.jNx.setData(f);
                                this.jNx.setFid(frsViewData.getForum().getId());
                                this.jNx.iG(this.jkB.cCC().cJS());
                                if (com.baidu.tbadk.a.d.bjt() && com.baidu.tbadk.a.b.a.eHR != com.baidu.tbadk.a.b.a.bjM()) {
                                    this.jNx.iG(com.baidu.tbadk.a.b.a.bjM());
                                }
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.jNu = tabData;
                    cLV();
                    dE(arrayList);
                }
            }
        }
    }

    private void AG(int i) {
        TiebaStatic.log(new ar("c13971").dR("fid", this.jkB.forumId).dR("fname", this.jkB.getForumName()).aq("obj_locate", i));
    }

    private void cLV() {
        int i = -1;
        if (!y.isEmpty(this.jNu)) {
            i = this.jNu.get(0).tabId;
        }
        if (this.jIs != null) {
            this.jIs.mHeadLineDefaultNavTabId = i;
        }
        if (this.jkB != null) {
            this.jkB.mHeadLineDefaultNavTabId = i;
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
        if (!y.isEmpty(this.jNv.mFragments) && tabData.size() == this.jNv.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.jNv.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.jNv.mFragments.get(i)).tabId) {
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

    public int cLW() {
        Iterator it = this.jNu.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b AH(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean sV(int i) {
        if (i < 0 || this.jNu == null || this.jNu.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.jNu.size()) {
                i2 = -1;
                break;
            } else if (this.jNu.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.ggz.getTabCount()) {
            return false;
        }
        TbTabLayout.e ba = this.ggz.ba(i2);
        if (ba != null && !ba.isSelected()) {
            ba.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d AI(int i) {
        if (i < 0 || this.jNu == null || this.jNu.size() <= 0) {
            return null;
        }
        Iterator it = this.jNu.iterator();
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
        ap.setBackgroundResource(this.gEA, R.drawable.personalize_tab_shadow);
        cMf();
        if (this.ggz != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.c.b.rT(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.c.b.rT(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.c.b.rT(this.mThemeColorInfo.day.font_color);
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = ap.getColor(R.color.plugin_button_shadow_red);
            }
            this.ggz.setSelectedTabIndicatorColor(color);
            this.ggz.setSelectedIndicatorBottomMargin(AF(R.dimen.tbds11));
            ap.setBackgroundColor(this.ggz, R.color.transparent);
            this.ggz.setTabTextColors(ap.getColor(R.color.CAM_X0107), ap.getColor(R.color.CAM_X0105));
        }
        if (this.jNx != null && !isBrandForum()) {
            this.jNx.onChangeSkinType();
        }
        if (this.jNt != null) {
            this.jNt.changeSkinType(i);
        }
        if (!y.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void AJ(int i) {
        this.jNA = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.jNu != null && position >= 0 && position < this.jNu.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.jNu.get(position);
            if (dVar != null) {
                this.jNE = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jIs != null && this.jIs.isShowRedTip()) {
                    this.jIs.setIsShowRedTip(false);
                    eVar.l(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.jkB.cDt() != null) {
                        this.jkB.cDt().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.jkB.cDt() != null) {
                    this.jkB.cDt().setIconFade(0);
                }
                if (com.baidu.tbadk.a.d.bjr()) {
                    com.baidu.tbadk.a.b.a.zB(dVar.name);
                }
                if (this.jNy != null) {
                    this.jNy.l(dVar.tabId, dVar.tabType, dVar.name);
                }
                com.baidu.tieba.frs.b.cBE().qr(dVar.tabId == 503);
                com.baidu.tieba.frs.a.cBx().yt(dVar.tabId);
                TiebaStatic.log(new ar("c12398").dR("fid", this.jkB.forumId).aq("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        cMc();
        if (this.jkB != null && this.jkB.cCE() != null) {
            this.jkB.cCE().cLv();
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.jNu != null && position >= 0 && position < this.jNu.size() && (dVar = this.jNu.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new ar("c12398").dR("fid", this.jkB.forumId).aq("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jIs != null && this.jIs.isShowRedTip()) {
                    this.jIs.setIsShowRedTip(false);
                    eVar.l(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (y.isEmpty(tabData)) {
            return false;
        }
        return (!y.isEmpty(this.jNu) && tabData.size() == this.jNu.size() && this.jNu.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !Ao(frsTabInfo.tab_id.intValue());
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
                    if (FrsTabViewController.this.jkB != null && FrsTabViewController.this.jkB.cCH() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.jkB.cCH().cEi());
                        FrsTabViewController.this.jkB.qA(com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jIs.showAdsense.intValue()));
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.jkB != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.jkB.getForumId());
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
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jIs.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jkB.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jkB.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.jkB.getForumId());
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
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jIs.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jkB.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jkB.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.jkB.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.jkB.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jkB.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.jkB.getForumId());
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
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jIs.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jkB.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jkB.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.jkB.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.jIs.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.jIs.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.jIs.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.jIs);
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
            this.jNw = new com.baidu.tieba.frs.g(this.jkB.getActivity().getApplicationContext(), list);
            this.jNw.setForumId(this.jkB.getForumId());
            this.jNw.setForumName(this.jkB.getForumName());
            this.jNw.setFrom(this.jkB.getFrom());
            if (this.jIs != null && this.jIs.getForum() != null) {
                this.jNw.Au(this.jIs.getForum().getFirst_class());
                this.jNw.Av(this.jIs.getForum().getSecond_class());
                this.jNw.setForumGameLabel(this.jIs.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    cq(frsTabInfo.tab_id.intValue(), 1);
                }
                if (frsTabInfo.tab_type.intValue() == 3) {
                    AG(1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.jNw.b(c);
                }
            }
            this.jNC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.jNw));
        }
    }

    private void cq(int i, int i2) {
        ar arVar = new ar("c13008");
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("fid", this.jkB.getForumId());
        if (i == 89) {
            arVar.aq("obj_type", 1);
        } else if (i == 502) {
            arVar.aq("obj_type", 8);
        } else if (i == 90) {
            arVar.aq("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                arVar.aq("obj_type", 4);
            } else {
                arVar.aq("obj_type", 5);
            }
        } else if (i == 404) {
            arVar.aq("obj_type", 2);
        } else if (i == 301) {
            arVar.aq("obj_type", 7);
        } else if (i == 503) {
            arVar.aq("obj_type", 6);
        } else if (i == 504) {
            arVar.aq("obj_type", 11);
        }
        arVar.aq("obj_locate", i2);
        arVar.bsR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLX() {
        int color;
        int i;
        if (this.jNw != null) {
            List<com.baidu.tbadk.mainTab.b> cCk = this.jNw.cCk();
            if (!y.isEmpty(cCk) && !y.isEmpty(this.jNu)) {
                if (this.ggz.getTabCount() > 0) {
                    this.ggz.removeAllTabs();
                }
                cLY();
                ArrayList arrayList = new ArrayList();
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.c.b.rT(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.c.b.rT(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.c.b.rT(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = ap.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = ap.getColor(R.color.plugin_button_shadow_red);
                }
                this.ggz.setSelectedTabIndicatorColor(color);
                this.ggz.setSelectedIndicatorBottomMargin(AF(R.dimen.tbds10));
                Iterator it = this.jNu.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment n = n(dVar.tabId, cCk);
                    if (n != null) {
                        TbTabLayout.e b2 = this.ggz.qL().b(dVar.name);
                        boolean z = this.jIs.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.jkB.getFrom()) && 3 == dVar.tabType) {
                            i3 = i2;
                        }
                        if (this.jIs != null && this.jIs.isShowRedTip() && dVar.tabId == 89) {
                            b2.l(0, true);
                        } else {
                            b2.l(0, false);
                        }
                        this.ggz.a(b2, z);
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
                if (this.jNv == null) {
                    this.jNv = new FragmentAdapter(this.jkB.getActivity().getSupportFragmentManager(), this.mFragments);
                }
                this.jNs.setAdapter(this.jNv);
                this.jNv.notifyDataSetChanged();
                if (this.ggz.getTabCount() > 0 && this.jNq.getVisibility() != 0) {
                    this.jNq.setVisibility(0);
                }
                this.ggz.setupWithViewPager(this.jNs);
                this.jNs.setOffscreenPageLimit(this.mFragments.size());
                this.jNs.setCurrentItem(i3, false);
                this.jNs.cEN();
            }
        }
    }

    private void cLY() {
        if (this.jNs != null && this.jNv != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.jkB.getActivity().getSupportFragmentManager();
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

    public View cLZ() {
        if (isBrandForum() || this.jNx == null) {
            return null;
        }
        return this.jNx.cGR();
    }

    public static boolean Ao(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.jNy = aVar;
    }

    public void ag(boolean z, boolean z2) {
        if (this.jNF != z) {
            this.jNF = z;
        }
        if (this.jNG != z2) {
            this.jNG = z2;
        }
        cMg();
    }

    public void aO(float f) {
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
                        FrsTabViewController.this.jkB.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.jkB.setPrimary(true);
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

    public b cMa() {
        if (this.jNs == null) {
            return null;
        }
        return (b) y.getItem(this.mFragments, this.jNs.getCurrentItem());
    }

    public void cMb() {
        this.jNB.aJ(this.jkB.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void cMc() {
        this.jNB.TC();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void AK(int i) {
        this.jlv = i;
        cMf();
    }

    public int cMd() {
        return this.jlv;
    }

    public int cMe() {
        return this.jNE;
    }

    private void cMf() {
        if (this.jlv == 2) {
            ap.setBackgroundColor(this.jNq, R.color.CAM_X0207);
            ap.setBackgroundColor(this.jNr, R.color.CAM_X0207);
            this.gEA.setVisibility(0);
            this.jkB.cDk();
        } else if (this.jlv == 1) {
            ap.setBackgroundColor(this.jNq, R.color.CAM_X0207);
            ap.setBackgroundColor(this.jNr, R.color.CAM_X0207);
            this.gEA.setVisibility(0);
        } else {
            cMg();
            this.gEA.setVisibility(8);
            if (this.jkB != null) {
                this.jkB.cDk();
            }
        }
    }

    private void cMg() {
        ap.setBackgroundColor(this.jNr, R.color.CAM_X0205);
        this.jNr.setAlpha(0.0f);
        com.baidu.tbadk.core.elementsMaven.c.br(this.jNq).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
    }
}
