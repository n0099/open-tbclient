package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.ImageOverlayView;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
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
/* loaded from: classes6.dex */
public class FrsTabViewController implements TbTabLayout.b, m {
    private View eiw;
    private RelativeLayout gCv;
    private com.baidu.tieba.c.d gHB;
    private RelativeLayout gHl;
    private View gHm;
    private TbTabLayout gHn;
    private FrsTabViewPager gHo;
    private View gHp;
    private ImageOverlayView gHq;
    private ImageView gHr;
    private LinearLayout gHs;
    private LinearGradientView gHt;
    private TabData gHu;
    private FrsViewData gHv;
    private FragmentAdapter gHw;
    private com.baidu.tieba.frs.e gHx;
    private com.baidu.tieba.frs.entelechy.c.a.b gHy;
    private a gHz;
    private FrsFragment gkN;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int glG = 0;
    private int gHA = -1;
    private boolean gHC = false;
    public boolean gHD = true;
    CustomMessageListener gHE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.gHC) {
                FrsTabViewController.this.bIq();
                FrsTabViewController.this.gHC = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.gHo != null) {
                FrsTabViewController.this.gHo.bCY();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener gHF = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.gHv != null && FrsTabViewController.this.gHv.isShowRedTip() != booleanValue && FrsTabViewController.this.gHn.getTabCount() > 0 && !v.isEmpty(FrsTabViewController.this.gHu)) {
                        FrsTabViewController.this.gHv.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.gHu.size(), FrsTabViewController.this.gHn.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e ap = FrsTabViewController.this.gHn.ap(i);
                            if (ap != null) {
                                if (FrsTabViewController.this.gHu.get(i).tabId == 89) {
                                    ap.g(0, booleanValue);
                                } else {
                                    ap.g(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener elP = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bIt;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bIt = FrsTabViewController.this.bIt()) != null && bIt.fragment != null && (bIt.fragment instanceof ah)) {
                        ((ah) bIt.fragment).baE();
                    }
                }
            }
        }
    };
    private CustomMessageListener gHG = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.gHu.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.gHu.size()) {
                    FrsTabViewController.this.gHo.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener gHH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.gHB.wP();
        }
    };
    private View.OnClickListener gHI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void mi(int i);
    }

    public void lU(boolean z) {
        this.gHn.setDisableTabSelect(z);
    }

    public FrsTabViewPager bIm() {
        return this.gHo;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.gkN = frsFragment;
        this.gHl = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.gHm = view.findViewById(R.id.frs_tab_bg);
        this.eiw = view.findViewById(R.id.divider_shadow);
        this.gHt = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.gHn = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.gHn.setOnTabSelectedListener(this);
        this.gHn.setSelectedTabTextBlod(true);
        this.gHn.setTabTextSize(ue(R.dimen.tbds46));
        this.gHp = view.findViewById(R.id.fading_edge_view);
        this.gHq = (ImageOverlayView) view.findViewById(R.id.frs_tab_overlayview);
        this.gHs = (LinearLayout) view.findViewById(R.id.frs_tab_arrow);
        this.gHr = (ImageView) view.findViewById(R.id.smartapp_arrow);
        this.gHs.setOnClickListener(this.gHI);
        this.gHB = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.gHn);
        this.gHB.bT(R.drawable.bg_tip_blue_up_left);
        this.gHB.bS(16);
        this.gHB.setUseDirectOffset(true);
        this.gHB.rn(ue(R.dimen.tbds34));
        this.gHB.setYOffset(ue(R.dimen.tbds10));
        this.gHB.c(this.gHH);
        this.gHo = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.gHw = new FragmentAdapter(this.gkN.getActivity().getSupportFragmentManager(), this.mFragments);
        this.gHo.addOnPageChangeListener(this.mOnPageChangeListener);
        this.gCv = new RelativeLayout(this.gkN.getContext());
        this.gHy = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.gCv);
    }

    private int ue(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bIn() {
        return this.gCv;
    }

    public View bIo() {
        return this.gHt;
    }

    private boolean isBrandForum() {
        return this.gHv != null && this.gHv.getIsBrandForum();
    }

    public void registerListener() {
        this.gHE.setPriority(Integer.MAX_VALUE);
        this.gkN.registerListener(this.gHE);
        this.gkN.registerListener(this.gHF);
        this.gkN.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.elP, this.gkN.getBaseFragmentActivity().getUniqueId());
        this.gkN.registerListener(this.gHG);
    }

    @Override // com.baidu.tieba.frs.vc.m
    public void a(FrsViewData frsViewData, int i) {
        AccountData currentAccountObj;
        String str;
        String str2;
        boolean z;
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().tab != null) {
            if (!v.isEmpty(frsViewData.smartAppAvatar)) {
                int size = frsViewData.smartAppAvatar.size();
                if (size > 3) {
                    size = 3;
                }
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.gkN.getContext(), R.dimen.tbds63);
                this.gHq.k(size, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(this.gkN.getContext(), R.dimen.tbds2), R.color.cp_bg_line_d, com.baidu.adp.lib.util.l.getDimens(this.gkN.getContext(), R.dimen.tbds12));
                this.gHq.setData(frsViewData.smartAppAvatar);
                this.gHs.setVisibility(0);
                this.gHp.setVisibility(0);
            } else {
                this.gHs.setVisibility(8);
                this.gHp.setVisibility(8);
            }
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    if (frsTabInfo.tab_id.intValue() == 89 || frsTabInfo.tab_id.intValue() == 503) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.tabId = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        tabData.add(dVar);
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
                            int Bm = com.baidu.tieba.frs.f.g.Bm("503~" + str + str2);
                            if (Bm == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aD("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == Bm) {
                                                com.baidu.tieba.tbadkCore.util.e.cJu();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cJv();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 12) {
                        com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                        dVar2.tabId = frsTabInfo.tab_id.intValue();
                        dVar2.name = frsTabInfo.tab_name;
                        tabData.add(dVar2);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                            dVar3.tabId = frsTabInfo.tab_id.intValue();
                            dVar3.name = frsTabInfo.tab_name;
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
                            dVar3.url = sb.toString();
                            dj(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && tO(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.rQ(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && aa.bCX().sQ(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        y sN = x.bCW().sN(dVar5.tabId);
                        if (sN != null && sN.gmJ != null && sN.gmJ.size() > 0) {
                            dVar5.gEE = new at();
                            dVar5.gEE.gmI = sN.gmI;
                            dVar5.gEE.gmJ = new LinkedList();
                            boolean z2 = true;
                            for (w wVar : sN.gmJ) {
                                if (wVar != null) {
                                    as asVar = new as();
                                    asVar.name = wVar.name;
                                    asVar.gmF = wVar.gmF;
                                    if (z2) {
                                        asVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.gEE.gmJ.add(asVar);
                                    z2 = z;
                                }
                            }
                        }
                        tabData.add(dVar5);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        y sN2 = x.bCW().sN(dVar6.tabId);
                        if (sN2 != null && sN2.gmJ != null && sN2.gmJ.size() > 0) {
                            dVar6.gEE = new at();
                            dVar6.gEE.gmI = sN2.gmI;
                            dVar6.gEE.gmJ = new LinkedList();
                            for (w wVar2 : sN2.gmJ) {
                                if (wVar2 != null) {
                                    as asVar2 = new as();
                                    asVar2.name = wVar2.name;
                                    asVar2.gmF = wVar2.gmF;
                                    dVar6.gEE.gmJ.add(asVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.gkN.bBi().bCy().p(bj.cNm)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.gHA > 0 && this.gHA != frsViewData.getAlaLiveCount() && this.gHA <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.gHA + ")";
                            } else if (this.gHA > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.gHA == 0 && this.gHA != frsViewData.getAlaLiveCount()) {
                                dVar7.name = frsTabInfo.tab_name;
                            }
                            dVar7.tabId = frsTabInfo.tab_id.intValue();
                            tabData.add(dVar7);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 90) {
                        com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                        dVar8.tabId = frsTabInfo.tab_id.intValue();
                        dVar8.name = frsTabInfo.tab_name;
                        tabData.add(dVar8);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 91) {
                        com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                        dVar9.tabId = frsTabInfo.tab_id.intValue();
                        dVar9.name = aq.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
                        tabData.add(dVar9);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 504) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.gHv = frsViewData;
                if (this.gHv.getForum() != null) {
                    this.mThemeColorInfo = this.gHv.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.gHn.getTabCount() > 0 && !v.isEmpty(this.gHu)) {
                    int min = Math.min(this.gHu.size(), this.gHn.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e ap = this.gHn.ap(i2);
                        if (ap != null) {
                            if (frsViewData.isShowRedTip() && this.gHu.get(i2).tabId == 89) {
                                ap.g(0, true);
                            } else {
                                ap.g(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.getItem(f, 0);
                        if (this.gkN != null && this.gkN.bBd() != null && frsTabInfo2 != null) {
                            this.gkN.bBd().tC(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.gkN != null && this.gkN.aFx() != null) {
                        if (f.size() < 2) {
                            this.gkN.aFx().removeHeaderView(this.gCv);
                        } else {
                            this.gkN.aFx().removeHeaderView(this.gCv);
                            this.gkN.aFx().addHeaderView(this.gCv);
                            if (this.gHy != null && frsViewData.getForum() != null) {
                                this.gHy.setData(f, i);
                                this.gHy.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.gHu = tabData;
                    bIp();
                    cv(arrayList);
                }
            }
        }
    }

    private void bIp() {
        int i = -1;
        if (!v.isEmpty(this.gHu)) {
            i = this.gHu.get(0).tabId;
        }
        if (this.gHv != null) {
            this.gHv.mHeadLineDefaultNavTabId = i;
        }
        if (this.gkN != null) {
            this.gkN.mHeadLineDefaultNavTabId = i;
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
        if (!v.isEmpty(this.gHw.mFragments) && tabData.size() == this.gHw.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.gHw.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.gHw.mFragments.get(i)).tabId) {
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

    @Override // com.baidu.tieba.frs.vc.m
    public boolean uf(int i) {
        if (i < 0 || this.gHu == null || this.gHu.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.gHu.size()) {
                i2 = -1;
                break;
            } else if (this.gHu.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.gHn.getTabCount()) {
            return false;
        }
        TbTabLayout.e ap = this.gHn.ap(i2);
        if (ap != null && !ap.isSelected()) {
            ap.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d ug(int i) {
        if (i < 0 || this.gHu == null || this.gHu.size() <= 0) {
            return null;
        }
        Iterator it = this.gHu.iterator();
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
        SvgManager.aDW().a(R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.eiw, R.drawable.personalize_tab_shadow);
        bIx();
        if (this.gHn != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.day.font_color);
                } else {
                    color = am.getColor(R.color.cp_link_tip_a);
                }
            } else {
                color = am.getColor(R.color.cp_link_tip_a);
            }
            this.gHn.setSelectedTabIndicatorColor(color);
            this.gHn.setBackgroundColor(0);
            this.gHn.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.gHy != null && !isBrandForum()) {
            this.gHy.onChangeSkinType();
        }
        if (this.gHq != null) {
            this.gHq.onChangeSkinType();
        }
        SvgManager.aDW().a(this.gHr, R.drawable.icon_pure_arrow12_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
        if (this.gHt != null) {
            this.gHt.changeSkinType(i);
        }
        if (!v.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void uh(int i) {
        this.gHA = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.gHu != null && position >= 0 && position < this.gHu.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.gHu.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gHv != null && this.gHv.isShowRedTip()) {
                    this.gHv.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.gkN.bBO() != null) {
                        this.gkN.bBO().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.gkN.bBO() != null) {
                    this.gkN.bBO().setIconFade(0);
                }
                if (this.gHz != null) {
                    this.gHz.mi(dVar.tabId);
                }
                com.baidu.tieba.frs.a.bAp().kM(dVar.tabId == 301);
                TiebaStatic.log(new an("c12398").cp("fid", this.gkN.forumId).Z("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bIv();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.gHu != null && position >= 0 && position < this.gHu.size() && (dVar = this.gHu.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new an("c12398").cp("fid", this.gkN.forumId).Z("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.gHv != null && this.gHv.isShowRedTip()) {
                    this.gHv.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        return (!v.isEmpty(this.gHu) && tabData.size() == this.gHu.size() && this.gHu.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !tO(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void dj(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    an anVar = new an(str2);
                    anVar.cp("obj_type", host);
                    TiebaStatic.log(anVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b c(FrsTabInfo frsTabInfo) {
        final int intValue = frsTabInfo.tab_id.intValue();
        if (intValue == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c aNe() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.gkN != null && FrsTabViewController.this.gkN.bBi() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.gkN.bBi().bCz());
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.gkN != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.gkN.getForumId());
                    }
                    bundle.putInt("tab_id", intValue);
                    frsAllThreadFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator dW(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 301 || intValue == 303) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c aNe() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gkN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gkN.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gkN.getForumId());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator dW(Context context) {
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
                public com.baidu.tbadk.mainTab.c aNe() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gkN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gkN.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.gkN.getForumId());
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator dW(Context context) {
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
                public com.baidu.tbadk.mainTab.c aNe() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gkN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gkN.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gkN.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsADFragment;
                    cVar.type = 90;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator dW(Context context) {
                    return null;
                }
            };
        }
        if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.12
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c aNe() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.gkN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.gkN.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.gkN.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.gHv.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.gHv.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.gHv.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.gHv);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator dW(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void cv(List<FrsTabInfo> list) {
        if (!v.isEmpty(list)) {
            this.gHx = new com.baidu.tieba.frs.e(this.gkN.getActivity().getApplicationContext(), list);
            this.gHx.setForumId(this.gkN.getForumId());
            this.gHx.setForumName(this.gkN.getForumName());
            this.gHx.setFrom(this.gkN.getFrom());
            if (this.gHv != null && this.gHv.getForum() != null) {
                this.gHx.ss(this.gHv.getForum().getFirst_class());
                this.gHx.st(this.gHv.getForum().getSecond_class());
                this.gHx.setForumGameLabel(this.gHv.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bG(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.gHx.b(c);
                }
            }
            this.gHC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.gHx));
        }
    }

    private void bG(int i, int i2) {
        an anVar = new an("c13008");
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cp("fid", this.gkN.getForumId());
        if (i == 89) {
            anVar.Z("obj_type", 1);
        } else if (i == 302) {
            anVar.Z("obj_type", 3);
        } else if (i == 502) {
            anVar.Z("obj_type", 8);
        } else if (i == 90) {
            anVar.Z("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                anVar.Z("obj_type", 4);
            } else {
                anVar.Z("obj_type", 5);
            }
        } else if (i == 404) {
            anVar.Z("obj_type", 2);
        } else if (i == 301 || i == 303) {
            anVar.Z("obj_type", 7);
        } else if (i == 503) {
            anVar.Z("obj_type", 6);
        } else if (i == 504) {
            anVar.Z("obj_type", 11);
        }
        anVar.Z("obj_locate", i2);
        anVar.aDT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIq() {
        int color;
        int i;
        if (this.gHx != null) {
            List<com.baidu.tbadk.mainTab.b> bAO = this.gHx.bAO();
            if (!v.isEmpty(bAO) && !v.isEmpty(this.gHu)) {
                if (this.gHn.getTabCount() > 0) {
                    this.gHn.removeAllTabs();
                }
                bIr();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.d.a.cy(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = am.getColor(R.color.cp_link_tip_a);
                    }
                } else {
                    color = am.getColor(R.color.cp_link_tip_a);
                }
                this.gHn.setSelectedTabIndicatorColor(color);
                Iterator it = this.gHu.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment l = l(dVar.tabId, bAO);
                    if (l != null) {
                        TbTabLayout.e b2 = this.gHn.kn().b(dVar.name);
                        boolean z = this.gHv.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.gHv != null && this.gHv.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.gHn.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = l;
                        this.mFragments.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i3 = i3;
                    i2 = i;
                }
                if (this.gHn.getTabCount() > 0 && this.gHl.getVisibility() != 0) {
                    this.gHl.setVisibility(0);
                }
                this.gHw = new FragmentAdapter(this.gkN.getActivity().getSupportFragmentManager(), this.mFragments);
                this.gHo.setAdapter(this.gHw);
                this.gHw.notifyDataSetChanged();
                this.gHn.setupWithViewPager(this.gHo);
                this.gHo.setOffscreenPageLimit(this.mFragments.size());
                this.gHo.setCurrentItem(i3, false);
                this.gHo.bCY();
            }
        }
    }

    private void bIr() {
        if (this.gHo != null && this.gHw != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.gkN.getActivity().getSupportFragmentManager();
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

    private Fragment l(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.aNf().type) {
                return bVar.aNf().frag;
            }
        }
        return null;
    }

    public View bIs() {
        if (isBrandForum() || this.gHy == null) {
            return null;
        }
        return this.gHy.bEL();
    }

    public static boolean tO(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.gHz = aVar;
    }

    /* loaded from: classes6.dex */
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
                        FrsTabViewController.this.gkN.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.gkN.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public String title;

        public b() {
        }
    }

    public b bIt() {
        if (this.gHo == null) {
            return null;
        }
        return (b) v.getItem(this.mFragments, this.gHo.getCurrentItem());
    }

    public void bIu() {
        this.gHB.Z(this.gkN.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void bIv() {
        this.gHB.wP();
    }

    @Override // com.baidu.tieba.frs.vc.m
    public void ui(int i) {
        this.glG = i;
        bIx();
    }

    public int bIw() {
        return this.glG;
    }

    private void bIx() {
        if (this.glG == 2) {
            am.setBackgroundColor(this.gHl, R.color.cp_bg_line_h);
            am.setBackgroundColor(this.gHm, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gHp, R.drawable.frs_tab_sticky_fading_edge);
            this.eiw.setVisibility(0);
            this.gkN.bBG();
        } else if (this.glG == 1) {
            am.setBackgroundColor(this.gHl, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gHm, R.color.cp_bg_line_h);
            am.setBackgroundResource(this.gHp, R.drawable.frs_tab_sticky_fading_edge);
            this.eiw.setVisibility(0);
        } else {
            if (this.gkN != null && this.gkN.bBn()) {
                am.setBackgroundColor(this.gHl, R.color.transparent);
            } else {
                am.setBackgroundColor(this.gHl, R.color.cp_bg_line_c);
            }
            am.setBackgroundResource(this.gHm, R.drawable.top_corners_bg);
            am.setBackgroundResource(this.gHp, R.drawable.frs_tab_fading_edge);
            this.eiw.setVisibility(8);
            if (this.gkN != null) {
                this.gkN.bBG();
            }
        }
    }
}
