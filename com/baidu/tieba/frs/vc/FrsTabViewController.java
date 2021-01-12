package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.ActivityChooserView;
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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
    private TbTabLayout gcC;
    private View gzT;
    private FrsViewData jAR;
    private RelativeLayout jFP;
    private View jFQ;
    private FrsTabViewPager jFR;
    private LinearGradientView jFS;
    private TabData jFT;
    private FragmentAdapter jFU;
    private com.baidu.tieba.frs.g jFV;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b jFW;
    private a jFX;
    private PublishProgressView jFY;
    private com.baidu.tieba.c.e jGa;
    private int jGd;
    private FrsFragment jcX;
    private RelativeLayout jjJ;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int jdR = 0;
    private int jFZ = -1;
    private boolean jGb = false;
    public boolean jGc = true;
    private boolean jGe = false;
    private boolean jGf = false;
    CustomMessageListener jGg = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.jGb) {
                FrsTabViewController.this.cKw();
                FrsTabViewController.this.jGb = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.jFR != null) {
                FrsTabViewController.this.jFR.cDo();
                if (!x.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) x.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof aq) {
                        z zVar = new z();
                        zVar.tabId = bVar.tabId;
                        zVar.jeN = (aq) bVar.fragment;
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
    private CustomMessageListener jGh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.jAR != null && FrsTabViewController.this.jAR.isShowRedTip() != booleanValue && FrsTabViewController.this.gcC.getTabCount() > 0 && !x.isEmpty(FrsTabViewController.this.jFT)) {
                        FrsTabViewController.this.jAR.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.jFT.size(), FrsTabViewController.this.gcC.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aZ = FrsTabViewController.this.gcC.aZ(i);
                            if (aZ != null) {
                                if (FrsTabViewController.this.jFT.get(i).tabId == 89) {
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
    private CustomMessageListener gDH = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cKz;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cKz = FrsTabViewController.this.cKz()) != null && cKz.fragment != null && (cKz.fragment instanceof ao)) {
                        ((ao) cKz.fragment).bRN();
                    }
                }
            }
        }
    };
    private final CustomMessageListener jGi = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                if (FrsTabViewController.this.jcX != null && bgVar.zI(FrsTabViewController.this.jcX.getForumId()) && FrsTabViewController.this.jFY != null) {
                    FrsTabViewController.this.jFY.b(bgVar);
                }
            }
        }
    };
    private CustomMessageListener jGj = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.jFT.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.jFT.size()) {
                    FrsTabViewController.this.jFR.setCurrentItem(i, true);
                }
            }
        }
    };
    private CustomMessageListener jGk = new CustomMessageListener(2921488) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921488) {
                Iterator it = FrsTabViewController.this.jFT.iterator();
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
                if (i <= FrsTabViewController.this.jFT.size() && z) {
                    FrsTabViewController.this.jFR.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener jGl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.jGa.RS();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void m(int i, int i2, String str);
    }

    public void ru(boolean z) {
        this.gcC.setDisableTabSelect(z);
    }

    public FrsTabViewPager cKq() {
        return this.jFR;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.jcX = frsFragment;
        this.jFP = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.jFQ = view.findViewById(R.id.frs_tab_bg);
        this.gzT = view.findViewById(R.id.divider_shadow);
        this.jFS = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.gcC = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.gcC.setOnTabSelectedListener(this);
        this.gcC.setSelectedTabTextBlod(true);
        this.gcC.setTabTextSize(Au(R.dimen.tbds42));
        this.jGa = new com.baidu.tieba.c.e(frsFragment.getPageContext(), this.gcC);
        this.jGa.ej(R.drawable.bg_tip_blue_up_left);
        this.jGa.ei(16);
        this.jGa.setUseDirectOffset(true);
        this.jGa.xb(Au(R.dimen.tbds34));
        this.jGa.setYOffset(Au(R.dimen.tbds10));
        this.jGa.e(this.jGl);
        this.jFR = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.jFU = new FragmentAdapter(this.jcX.getActivity().getSupportFragmentManager(), this.mFragments);
        this.jFR.addOnPageChangeListener(this.mOnPageChangeListener);
        this.jjJ = new RelativeLayout(this.jcX.getContext());
        this.jFW = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.jjJ);
        this.jFY = (PublishProgressView) view.findViewById(R.id.publish_progress_view);
        this.jFY.setVisibility(8);
    }

    private int Au(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cKr() {
        return this.jjJ;
    }

    public View cKs() {
        return this.jFS;
    }

    private boolean isBrandForum() {
        return this.jAR != null && this.jAR.getIsBrandForum();
    }

    public void registerListener() {
        this.jGg.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.jcX.registerListener(this.jGg);
        this.jcX.registerListener(this.jGh);
        this.jcX.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gDH, this.jcX.getBaseFragmentActivity().getUniqueId());
        this.jcX.registerListener(this.jGj);
        this.jcX.registerListener(this.jGk);
        this.jcX.registerListener(this.jGi);
    }

    public boolean cKt() {
        return this.jFY != null && this.jFY.getVisibility() == 0;
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
                            int Kv = com.baidu.tieba.frs.d.j.Kv("503~" + str + str2);
                            if (Kv == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.d.j.ba("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == Kv) {
                                                com.baidu.tieba.tbadkCore.util.e.dMA();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.dMB();
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
                    } else if (frsTabInfo.tab_type.intValue() == 11 && Ad(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.c.zk(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && af.cDn().yQ(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ad yN = ac.cDm().yN(dVar6.tabId);
                        if (yN != null && yN.jfc != null && yN.jfc.size() > 0) {
                            dVar6.jCp = new bd();
                            dVar6.jCp.jfb = yN.jfb;
                            dVar6.jCp.jfc = new LinkedList();
                            boolean z2 = true;
                            for (ab abVar : yN.jfc) {
                                if (abVar != null) {
                                    bc bcVar = new bc();
                                    bcVar.name = abVar.name;
                                    bcVar.jeY = abVar.jeY;
                                    if (z2) {
                                        bcVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.jCp.jfc.add(bcVar);
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
                        ad yN2 = ac.cDm().yN(dVar7.tabId);
                        if (yN2 != null && yN2.jfc != null && yN2.jfc.size() > 0) {
                            dVar7.jCp = new bd();
                            dVar7.jCp.jfb = yN2.jfb;
                            dVar7.jCp.jfc = new LinkedList();
                            for (ab abVar2 : yN2.jfc) {
                                if (abVar2 != null) {
                                    bc bcVar2 = new bc();
                                    bcVar2.name = abVar2.name;
                                    bcVar2.jeY = abVar2.jeY;
                                    dVar7.jCp.jfc.add(bcVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.jcX.cBi().cCI().r(bz.eOz)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.jFZ > 0 && this.jFZ != frsViewData.getAlaLiveCount() && this.jFZ <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.jFZ + ")";
                            } else if (this.jFZ > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.jFZ == 0 && this.jFZ != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.brx().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            dVar9.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                            Av(2);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        dVar10.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                        Av(2);
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
                        Av(1);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.jAR = frsViewData;
                if (this.jAR.getForum() != null) {
                    this.mThemeColorInfo = this.jAR.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.gcC.getTabCount() > 0 && !x.isEmpty(this.jFT)) {
                    int min = Math.min(this.jFT.size(), this.gcC.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aZ = this.gcC.aZ(i2);
                        if (aZ != null) {
                            if (frsViewData.isShowRedTip() && this.jFT.get(i2).tabId == 89) {
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
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) x.getItem(f, 0);
                        if (this.jcX != null && this.jcX.cBd() != null && frsTabInfo2 != null) {
                            this.jcX.cBd().zS(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.jcX != null && this.jcX.getListView() != null) {
                        if (f != null && f.size() < 2) {
                            this.jcX.getListView().removeHeaderView(this.jjJ);
                        } else {
                            this.jcX.getListView().removeHeaderView(this.jjJ);
                            this.jcX.getListView().addHeaderView(this.jjJ);
                            if (this.jFW != null && frsViewData.getForum() != null) {
                                this.jFW.setData(f);
                                this.jFW.setFid(frsViewData.getForum().getId());
                                this.jFW.iC(this.jcX.cBd().cIs());
                                if (com.baidu.tbadk.a.d.bjf() && com.baidu.tbadk.a.b.a.eEj != com.baidu.tbadk.a.b.a.bjp()) {
                                    this.jFW.iC(com.baidu.tbadk.a.b.a.bjp());
                                }
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.jFT = tabData;
                    cKu();
                    dJ(arrayList);
                }
            }
        }
    }

    private void Av(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13971").dW("fid", this.jcX.forumId).dW("fname", this.jcX.getForumName()).an("obj_locate", i));
    }

    private void cKu() {
        int i = -1;
        if (!x.isEmpty(this.jFT)) {
            i = this.jFT.get(0).tabId;
        }
        if (this.jAR != null) {
            this.jAR.mHeadLineDefaultNavTabId = i;
        }
        if (this.jcX != null) {
            this.jcX.mHeadLineDefaultNavTabId = i;
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
        if (!x.isEmpty(this.jFU.mFragments) && tabData.size() == this.jFU.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.jFU.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.jFU.mFragments.get(i)).tabId) {
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

    public int cKv() {
        Iterator it = this.jFT.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b Aw(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean sO(int i) {
        if (i < 0 || this.jFT == null || this.jFT.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.jFT.size()) {
                i2 = -1;
                break;
            } else if (this.jFT.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.gcC.getTabCount()) {
            return false;
        }
        TbTabLayout.e aZ = this.gcC.aZ(i2);
        if (aZ != null && !aZ.isSelected()) {
            aZ.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d Ax(int i) {
        if (i < 0 || this.jFT == null || this.jFT.size() <= 0) {
            return null;
        }
        Iterator it = this.jFT.iterator();
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
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.gzT, R.drawable.personalize_tab_shadow);
        cKE();
        if (this.gcC != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.c.b.rt(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.c.b.rt(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.c.b.rt(this.mThemeColorInfo.day.font_color);
                } else {
                    color = com.baidu.tbadk.core.util.ao.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = com.baidu.tbadk.core.util.ao.getColor(R.color.plugin_button_shadow_red);
            }
            this.gcC.setSelectedTabIndicatorColor(color);
            this.gcC.setSelectedIndicatorBottomMargin(Au(R.dimen.tbds11));
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.gcC, R.color.transparent);
            this.gcC.setTabTextColors(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107), com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
        }
        if (this.jFW != null && !isBrandForum()) {
            this.jFW.onChangeSkinType();
        }
        if (this.jFS != null) {
            this.jFS.changeSkinType(i);
        }
        if (!x.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void Ay(int i) {
        this.jFZ = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.jFT != null && position >= 0 && position < this.jFT.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.jFT.get(position);
            if (dVar != null) {
                this.jGd = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jAR != null && this.jAR.isShowRedTip()) {
                    this.jAR.setIsShowRedTip(false);
                    eVar.l(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.jcX.cBU() != null) {
                        this.jcX.cBU().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.jcX.cBU() != null) {
                    this.jcX.cBU().setIconFade(0);
                }
                if (com.baidu.tbadk.a.d.bjd()) {
                    com.baidu.tbadk.a.b.a.zc(dVar.name);
                }
                if (this.jFX != null) {
                    this.jFX.m(dVar.tabId, dVar.tabType, dVar.name);
                }
                com.baidu.tieba.frs.b.cAg().qh(dVar.tabId == 503);
                com.baidu.tieba.frs.a.czZ().yi(dVar.tabId);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12398").dW("fid", this.jcX.forumId).an("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        cKB();
        if (this.jcX != null && this.jcX.cBf() != null) {
            this.jcX.cBf().cJU();
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.jFT != null && position >= 0 && position < this.jFT.size() && (dVar = this.jFT.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12398").dW("fid", this.jcX.forumId).an("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jAR != null && this.jAR.isShowRedTip()) {
                    this.jAR.setIsShowRedTip(false);
                    eVar.l(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (x.isEmpty(tabData)) {
            return false;
        }
        return (!x.isEmpty(this.jFT) && tabData.size() == this.jFT.size() && this.jFT.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !Ad(frsTabInfo.tab_id.intValue());
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
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str2);
                    aqVar.dW("obj_type", host);
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.jcX != null && FrsTabViewController.this.jcX.cBi() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.jcX.cBi().cCJ());
                        FrsTabViewController.this.jcX.qq(com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jAR.showAdsense.intValue()));
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.jcX != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.jcX.getForumId());
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
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jAR.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jcX.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jcX.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.jcX.getForumId());
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
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jAR.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jcX.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jcX.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.jcX.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.jcX.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jcX.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.jcX.getForumId());
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
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jAR.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jcX.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jcX.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.jcX.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.jAR.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.jAR.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.jAR.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.jAR);
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

    private void dJ(List<FrsTabInfo> list) {
        if (!x.isEmpty(list)) {
            this.jFV = new com.baidu.tieba.frs.g(this.jcX.getActivity().getApplicationContext(), list);
            this.jFV.setForumId(this.jcX.getForumId());
            this.jFV.setForumName(this.jcX.getForumName());
            this.jFV.setFrom(this.jcX.getFrom());
            if (this.jAR != null && this.jAR.getForum() != null) {
                this.jFV.zW(this.jAR.getForum().getFirst_class());
                this.jFV.zX(this.jAR.getForum().getSecond_class());
                this.jFV.setForumGameLabel(this.jAR.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    cs(frsTabInfo.tab_id.intValue(), 1);
                }
                if (frsTabInfo.tab_type.intValue() == 3) {
                    Av(1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.jFV.b(c);
                }
            }
            this.jGb = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.jFV));
        }
    }

    private void cs(int i, int i2) {
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13008");
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dW("fid", this.jcX.getForumId());
        if (i == 89) {
            aqVar.an("obj_type", 1);
        } else if (i == 502) {
            aqVar.an("obj_type", 8);
        } else if (i == 90) {
            aqVar.an("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aqVar.an("obj_type", 4);
            } else {
                aqVar.an("obj_type", 5);
            }
        } else if (i == 404) {
            aqVar.an("obj_type", 2);
        } else if (i == 301) {
            aqVar.an("obj_type", 7);
        } else if (i == 503) {
            aqVar.an("obj_type", 6);
        } else if (i == 504) {
            aqVar.an("obj_type", 11);
        }
        aqVar.an("obj_locate", i2);
        aqVar.bsu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKw() {
        int color;
        int i;
        if (this.jFV != null) {
            List<com.baidu.tbadk.mainTab.b> cAM = this.jFV.cAM();
            if (!x.isEmpty(cAM) && !x.isEmpty(this.jFT)) {
                if (this.gcC.getTabCount() > 0) {
                    this.gcC.removeAllTabs();
                }
                cKx();
                ArrayList arrayList = new ArrayList();
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.c.b.rt(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.c.b.rt(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.c.b.rt(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = com.baidu.tbadk.core.util.ao.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = com.baidu.tbadk.core.util.ao.getColor(R.color.plugin_button_shadow_red);
                }
                this.gcC.setSelectedTabIndicatorColor(color);
                this.gcC.setSelectedIndicatorBottomMargin(Au(R.dimen.tbds10));
                Iterator it = this.jFT.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, cAM);
                    if (m != null) {
                        TbTabLayout.e b2 = this.gcC.qN().b(dVar.name);
                        boolean z = this.jAR.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.jcX.getFrom()) && 3 == dVar.tabType) {
                            i3 = i2;
                        }
                        if (this.jAR != null && this.jAR.isShowRedTip() && dVar.tabId == 89) {
                            b2.l(0, true);
                        } else {
                            b2.l(0, false);
                        }
                        this.gcC.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = m;
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
                if (this.jFU == null) {
                    this.jFU = new FragmentAdapter(this.jcX.getActivity().getSupportFragmentManager(), this.mFragments);
                }
                this.jFR.setAdapter(this.jFU);
                this.jFU.notifyDataSetChanged();
                if (this.gcC.getTabCount() > 0 && this.jFP.getVisibility() != 0) {
                    this.jFP.setVisibility(0);
                }
                this.gcC.setupWithViewPager(this.jFR);
                this.jFR.setOffscreenPageLimit(this.mFragments.size());
                this.jFR.setCurrentItem(i3, false);
                this.jFR.cDo();
            }
        }
    }

    private void cKx() {
        if (this.jFR != null && this.jFU != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.jcX.getActivity().getSupportFragmentManager();
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

    public View cKy() {
        if (isBrandForum() || this.jFW == null) {
            return null;
        }
        return this.jFW.cFr();
    }

    public static boolean Ad(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.jFX = aVar;
    }

    public void ag(boolean z, boolean z2) {
        if (this.jGe != z) {
            this.jGe = z;
        }
        if (this.jGf != z2) {
            this.jGf = z2;
        }
        cKF();
    }

    public void aH(float f) {
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
                        FrsTabViewController.this.jcX.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.jcX.setPrimary(true);
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

    public b cKz() {
        if (this.jFR == null) {
            return null;
        }
        return (b) x.getItem(this.mFragments, this.jFR.getCurrentItem());
    }

    public void cKA() {
        this.jGa.aJ(this.jcX.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void cKB() {
        this.jGa.RS();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void Az(int i) {
        this.jdR = i;
        cKE();
    }

    public int cKC() {
        return this.jdR;
    }

    public int cKD() {
        return this.jGd;
    }

    private void cKE() {
        if (this.jdR == 2) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jFP, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jFQ, R.color.CAM_X0207);
            this.gzT.setVisibility(0);
            this.jcX.cBL();
        } else if (this.jdR == 1) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jFP, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jFQ, R.color.CAM_X0207);
            this.gzT.setVisibility(0);
        } else {
            cKF();
            this.gzT.setVisibility(8);
            if (this.jcX != null) {
                this.jcX.cBL();
            }
        }
    }

    private void cKF() {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jFQ, R.color.CAM_X0205);
        this.jFQ.setAlpha(0.0f);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jFP).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
    }
}
