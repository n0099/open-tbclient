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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.data.bh;
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
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.ImageOverlayView;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class FrsTabViewController implements TbTabLayout.b, k {
    private static final String TAG = FrsTabViewController.class.getSimpleName();
    private View dyl;
    private RelativeLayout fOZ;
    private RelativeLayout fTD;
    private View fTE;
    private TbTabLayout fTF;
    private FrsTabViewPager fTG;
    private View fTH;
    private ImageOverlayView fTI;
    private ImageView fTJ;
    private LinearLayout fTK;
    private LinearGradientView fTL;
    private TabData fTM;
    private FrsViewData fTN;
    private FragmentAdapter fTO;
    private com.baidu.tieba.frs.e fTP;
    private com.baidu.tieba.frs.entelechy.c.a.b fTQ;
    private a fTR;
    private com.baidu.tieba.c.d fTT;
    private FrsFragment fxh;
    private List<b> mFragments;
    private int fya = 0;
    private int fTS = -1;
    private boolean fTU = false;
    public boolean fTV = true;
    CustomMessageListener fTW = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.fTU) {
                FrsTabViewController.this.bqR();
                FrsTabViewController.this.fTU = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.fTG != null) {
                FrsTabViewController.this.fTG.blE();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener fTX = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.fTN != null && FrsTabViewController.this.fTN.isShowRedTip() != booleanValue && FrsTabViewController.this.fTF.getTabCount() > 0 && !v.isEmpty(FrsTabViewController.this.fTM)) {
                        FrsTabViewController.this.fTN.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.fTM.size(), FrsTabViewController.this.fTF.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e am = FrsTabViewController.this.fTF.am(i);
                            if (am != null) {
                                if (FrsTabViewController.this.fTM.get(i).tabId == 89) {
                                    am.g(0, booleanValue);
                                } else {
                                    am.g(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener dBH = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bqU;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bqU = FrsTabViewController.this.bqU()) != null && bqU.fragment != null && (bqU.fragment instanceof ag)) {
                        ((ag) bqU.fragment).aKh();
                    }
                }
            }
        }
    };
    private CustomMessageListener fTY = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.fTM.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.fTM.size()) {
                    FrsTabViewController.this.fTG.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener fTZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.fTT.uP();
        }
    };
    private View.OnClickListener fUa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void jW(int i);
    }

    public void kH(boolean z) {
        this.fTF.setDisableTabSelect(z);
    }

    public FrsTabViewPager bqN() {
        return this.fTG;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.fxh = frsFragment;
        this.fTD = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.fTE = view.findViewById(R.id.frs_tab_bg);
        this.dyl = view.findViewById(R.id.divider_shadow);
        this.fTL = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.fTF = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.fTF.setOnTabSelectedListener(this);
        this.fTF.setSelectedTabTextBlod(true);
        this.fTF.setSelectedTabTextSize(rX(R.dimen.tbds46));
        this.fTF.setTabTextSize(rX(R.dimen.tbds40));
        this.fTH = view.findViewById(R.id.fading_edge_view);
        this.fTI = (ImageOverlayView) view.findViewById(R.id.frs_tab_overlayview);
        this.fTK = (LinearLayout) view.findViewById(R.id.frs_tab_arrow);
        this.fTJ = (ImageView) view.findViewById(R.id.smartapp_arrow);
        this.fTK.setOnClickListener(this.fUa);
        this.fTT = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.fTF);
        this.fTT.bB(R.drawable.bg_tip_blue_up_left);
        this.fTT.bA(16);
        this.fTT.setUseDirectOffset(true);
        this.fTT.ph(rX(R.dimen.tbds34));
        this.fTT.setYOffset(rX(R.dimen.tbds10));
        this.fTT.c(this.fTZ);
        this.fTG = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.fTO = new FragmentAdapter(this.fxh.getActivity().getSupportFragmentManager(), this.mFragments);
        this.fTG.addOnPageChangeListener(this.mOnPageChangeListener);
        this.fOZ = new RelativeLayout(this.fxh.getContext());
        this.fTQ = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.fOZ);
    }

    private int rX(int i) {
        return l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bqO() {
        return this.fOZ;
    }

    public View bqP() {
        return this.fTL;
    }

    private boolean isBrandForum() {
        return this.fTN != null && this.fTN.getIsBrandForum();
    }

    public void registerListener() {
        this.fTW.setPriority(Integer.MAX_VALUE);
        this.fxh.registerListener(this.fTW);
        this.fxh.registerListener(this.fTX);
        this.fxh.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.dBH, this.fxh.getBaseFragmentActivity().getUniqueId());
        this.fxh.registerListener(this.fTY);
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void a(FrsViewData frsViewData, int i) {
        AccountData currentAccountObj;
        String str;
        String str2;
        boolean z;
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().tab != null) {
            if (frsViewData != null && !v.isEmpty(frsViewData.smartAppAvatar)) {
                int size = frsViewData.smartAppAvatar.size();
                if (size > 3) {
                    size = 3;
                }
                int dimens = l.getDimens(this.fxh.getContext(), R.dimen.tbds72);
                this.fTI.j(size, dimens, dimens, l.getDimens(this.fxh.getContext(), R.dimen.tbds2), R.color.cp_bg_line_d, l.getDimens(this.fxh.getContext(), R.dimen.tbds12));
                this.fTI.setData(frsViewData.smartAppAvatar);
                this.fTK.setVisibility(0);
                this.fTH.setVisibility(0);
            } else {
                this.fTK.setVisibility(8);
                this.fTH.setVisibility(8);
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
                            int wx = com.baidu.tieba.frs.f.g.wx("503~" + str + str2);
                            if (wx == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.au("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == wx) {
                                                com.baidu.tieba.tbadkCore.util.e.cpq();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cpr();
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
                            sb.append("&");
                            sb.append("fid");
                            sb.append("=");
                            sb.append(frsViewData.getForum().getId());
                            dVar3.url = sb.toString();
                            cQ(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && rJ(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.mC(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.blD().qL(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x qI = w.blC().qI(dVar5.tabId);
                        if (qI != null && qI.fzd != null && qI.fzd.size() > 0) {
                            dVar5.fRj = new as();
                            dVar5.fRj.fzc = qI.fzc;
                            dVar5.fRj.fzd = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : qI.fzd) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.fyZ = vVar.fyZ;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.fRj.fzd.add(arVar);
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
                        x qI2 = w.blC().qI(dVar6.tabId);
                        if (qI2 != null && qI2.fzd != null && qI2.fzd.size() > 0) {
                            dVar6.fRj = new as();
                            dVar6.fRj.fzc = qI2.fzc;
                            dVar6.fRj.fzd = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : qI2.fzd) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.fyZ = vVar2.fyZ;
                                    dVar6.fRj.fzd.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.fxh.bjP().ble().o(bh.cbJ)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.fTS > 0 && this.fTS != frsViewData.getAlaLiveCount() && this.fTS <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.fTS + ")";
                            } else if (this.fTS > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.fTS == 0 && this.fTS != frsViewData.getAlaLiveCount()) {
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
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.fTN = frsViewData;
                if (!c(tabData) && this.fTF.getTabCount() > 0 && !v.isEmpty(this.fTM)) {
                    int min = Math.min(this.fTM.size(), this.fTF.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e am = this.fTF.am(i2);
                        if (am != null) {
                            if (frsViewData.isShowRedTip() && this.fTM.get(i2).tabId == 89) {
                                am.g(0, true);
                            } else {
                                am.g(0, false);
                            }
                        }
                    }
                }
                if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.getItem(f, 0);
                        if (this.fxh != null && this.fxh.bjK() != null && frsTabInfo2 != null) {
                            this.fxh.bjK().rx(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.fxh != null && this.fxh.aof() != null) {
                        if (f.size() < 2) {
                            this.fxh.aof().removeHeaderView(this.fOZ);
                        } else {
                            this.fxh.aof().removeHeaderView(this.fOZ);
                            this.fxh.aof().addHeaderView(this.fOZ);
                            if (this.fTQ != null && frsViewData.getForum() != null) {
                                this.fTQ.setData(f, i);
                                this.fTQ.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.fTM = tabData;
                    bqQ();
                    cz(arrayList);
                }
            }
        }
    }

    private void bqQ() {
        int i = -1;
        if (!v.isEmpty(this.fTM)) {
            i = this.fTM.get(0).tabId;
        }
        if (this.fTN != null) {
            this.fTN.mHeadLineDefaultNavTabId = i;
        }
        if (this.fxh != null) {
            this.fxh.mHeadLineDefaultNavTabId = i;
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
        if (!v.isEmpty(this.fTO.mFragments) && tabData.size() == this.fTO.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.fTO.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.fTO.mFragments.get(i)).tabId) {
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

    @Override // com.baidu.tieba.frs.vc.k
    public boolean rY(int i) {
        if (i < 0 || this.fTM == null || this.fTM.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.fTM.size()) {
                i2 = -1;
                break;
            } else if (this.fTM.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fTF.getTabCount()) {
            return false;
        }
        TbTabLayout.e am = this.fTF.am(i2);
        if (am != null && !am.isSelected()) {
            am.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d rZ(int i) {
        if (i < 0 || this.fTM == null || this.fTM.size() <= 0) {
            return null;
        }
        Iterator it = this.fTM.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        SvgManager.amN().a(R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.setBackgroundResource(this.fTH, R.drawable.frs_tab_fading_edge);
        am.setBackgroundResource(this.dyl, R.drawable.personalize_tab_shadow);
        bqY();
        if (this.fTF != null) {
            this.fTF.setSelectedTabIndicatorColor(0);
            this.fTF.setBackgroundColor(0);
            this.fTF.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.fTQ != null && !isBrandForum()) {
            this.fTQ.onChangeSkinType();
        }
        if (this.fTI != null) {
            this.fTI.onChangeSkinType();
        }
        if (this.fTL != null) {
            this.fTL.changeSkinType(i);
        }
        if (!v.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void sa(int i) {
        this.fTS = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.fTM != null && position >= 0 && position < this.fTM.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.fTM.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.fTN != null && this.fTN.isShowRedTip()) {
                    this.fTN.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.fxh.bku() != null) {
                        this.fxh.bku().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.fxh.bku() != null) {
                    this.fxh.bku().setIconFade(0);
                }
                if (this.fTR != null) {
                    this.fTR.jW(dVar.tabId);
                }
                com.baidu.tieba.frs.a.biW().jA(dVar.tabId == 301);
                TiebaStatic.log(new an("c12398").bS("fid", this.fxh.forumId).O("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bqW();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.fTM != null && position >= 0 && position < this.fTM.size() && (dVar = this.fTM.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new an("c12398").bS("fid", this.fxh.forumId).O("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.fTN != null && this.fTN.isShowRedTip()) {
                    this.fTN.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.isEmpty(tabData)) {
            return false;
        }
        return (!v.isEmpty(this.fTM) && tabData.size() == this.fTM.size() && this.fTM.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !rJ(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void cQ(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    an anVar = new an(str2);
                    anVar.bS("obj_type", host);
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
                public com.baidu.tbadk.mainTab.c avy() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.fxh != null && FrsTabViewController.this.fxh.bjP() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.fxh.bjP().blf());
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("forum_id", FrsTabViewController.this.fxh.getForumId());
                    bundle.putInt("tab_id", intValue);
                    frsAllThreadFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cB(Context context) {
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
                public com.baidu.tbadk.mainTab.c avy() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fxh.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fxh.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fxh.getForumId());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cB(Context context) {
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
                public com.baidu.tbadk.mainTab.c avy() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fxh.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fxh.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fxh.getForumId());
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cB(Context context) {
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
                public com.baidu.tbadk.mainTab.c avy() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fxh.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fxh.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fxh.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsADFragment;
                    cVar.type = 90;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cB(Context context) {
                    return null;
                }
            };
        }
        if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.12
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c avy() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fxh.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fxh.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fxh.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.fTN.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.fTN.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.fTN.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.fTN);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cB(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void cz(List<FrsTabInfo> list) {
        if (!v.isEmpty(list)) {
            this.fTP = new com.baidu.tieba.frs.e(this.fxh.getActivity().getApplicationContext(), list);
            this.fTP.setForumId(this.fxh.getForumId());
            this.fTP.setForumName(this.fxh.getForumName());
            if (this.fTN != null && this.fTN.getForum() != null) {
                this.fTP.nh(this.fTN.getForum().getFirst_class());
                this.fTP.ni(this.fTN.getForum().getSecond_class());
                this.fTP.setForumGameLabel(this.fTN.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bq(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.fTP.b(c);
                }
            }
            this.fTU = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.fTP));
        }
    }

    private void bq(int i, int i2) {
        an anVar = new an("c13008");
        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bS("fid", this.fxh.getForumId());
        if (i == 89) {
            anVar.O("obj_type", 1);
        } else if (i == 501) {
            anVar.O("obj_type", 3);
        } else if (i == 502) {
            anVar.O("obj_type", 8);
        } else if (i == 90) {
            anVar.O("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                anVar.O("obj_type", 4);
            } else {
                anVar.O("obj_type", 5);
            }
        } else if (i == 404) {
            anVar.O("obj_type", 2);
        } else if (i == 301 || i == 303) {
            anVar.O("obj_type", 7);
        } else if (i == 503) {
            anVar.O("obj_type", 6);
        }
        anVar.O("obj_locate", i2);
        anVar.amK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqR() {
        int i;
        if (this.fTP != null) {
            List<com.baidu.tbadk.mainTab.b> bjw = this.fTP.bjw();
            if (!v.isEmpty(bjw) && !v.isEmpty(this.fTM)) {
                if (this.fTF.getTabCount() > 0) {
                    this.fTF.removeAllTabs();
                }
                bqS();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.fTM.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment i4 = i(dVar.tabId, bjw);
                    if (i4 != null) {
                        TbTabLayout.e b2 = this.fTF.jW().b(dVar.name);
                        boolean z = this.fTN.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.fTN != null && this.fTN.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.fTF.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = i4;
                        this.mFragments.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i3 = i3;
                    i2 = i;
                }
                if (this.fTF.getTabCount() > 0 && this.fTD.getVisibility() != 0) {
                    this.fTD.setVisibility(0);
                }
                this.fTO = new FragmentAdapter(this.fxh.getActivity().getSupportFragmentManager(), this.mFragments);
                this.fTG.setAdapter(this.fTO);
                this.fTO.notifyDataSetChanged();
                this.fTF.setupWithViewPager(this.fTG);
                this.fTG.setOffscreenPageLimit(this.mFragments.size());
                this.fTG.setCurrentItem(i3, false);
                this.fTG.blE();
            }
        }
    }

    private void bqS() {
        if (this.fTG != null && this.fTO != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.fxh.getActivity().getSupportFragmentManager();
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

    private Fragment i(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.avz().type) {
                return bVar.avz().frag;
            }
        }
        return null;
    }

    public View bqT() {
        if (isBrandForum() || this.fTQ == null) {
            return null;
        }
        return this.fTQ.bnp();
    }

    public static boolean rJ(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.fTR = aVar;
    }

    /* loaded from: classes4.dex */
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
                        FrsTabViewController.this.fxh.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.fxh.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public String title;

        public b() {
        }
    }

    public b bqU() {
        if (this.fTG == null) {
            return null;
        }
        return (b) v.getItem(this.mFragments, this.fTG.getCurrentItem());
    }

    public void bqV() {
        this.fTT.R(this.fxh.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void bqW() {
        this.fTT.uP();
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void sb(int i) {
        this.fya = i;
        bqY();
    }

    public int bqX() {
        return this.fya;
    }

    private void bqY() {
        if (this.fya == 2) {
            am.setBackgroundColor(this.fTD, R.color.cp_bg_line_h);
            am.setBackgroundColor(this.fTE, R.color.cp_bg_line_h);
            this.dyl.setVisibility(0);
            this.fxh.bko();
        } else if (this.fya == 1) {
            am.setBackgroundColor(this.fTD, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.fTE, R.color.cp_bg_line_h);
            this.dyl.setVisibility(0);
        } else {
            if (this.fxh != null && this.fxh.bjU()) {
                am.setBackgroundColor(this.fTD, R.color.transparent);
            } else {
                am.setBackgroundColor(this.fTD, R.color.cp_bg_line_c);
            }
            am.setBackgroundResource(this.fTE, R.drawable.top_corners_bg);
            this.dyl.setVisibility(8);
            this.fxh.bkn();
        }
    }
}
