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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
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
    private View bpR;
    private View dnj;
    private RelativeLayout fIb;
    private RelativeLayout fMF;
    private View fMG;
    private TbTabLayout fMH;
    private FrsTabViewPager fMI;
    private View fMJ;
    private ImageOverlayView fMK;
    private TbImageView fML;
    private LinearLayout fMM;
    private LinearGradientView fMN;
    private TabData fMO;
    private FrsViewData fMP;
    private FragmentAdapter fMQ;
    private com.baidu.tieba.frs.e fMR;
    private com.baidu.tieba.frs.entelechy.c.a.b fMS;
    private a fMT;
    private com.baidu.tieba.c.d fMV;
    private FrsFragment fqJ;
    private List<b> mFragments;
    private int frE = 0;
    private int fMU = -1;
    private boolean fMW = false;
    public boolean fMX = true;
    CustomMessageListener fMY = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.fMW) {
                FrsTabViewController.this.bqK();
                FrsTabViewController.this.fMW = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.fMI != null) {
                FrsTabViewController.this.fMI.blE();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener fMZ = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.fMP != null && FrsTabViewController.this.fMP.isShowRedTip() != booleanValue && FrsTabViewController.this.fMH.getTabCount() > 0 && !v.aa(FrsTabViewController.this.fMO)) {
                        FrsTabViewController.this.fMP.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.fMO.size(), FrsTabViewController.this.fMH.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aV = FrsTabViewController.this.fMH.aV(i);
                            if (aV != null) {
                                if (FrsTabViewController.this.fMO.get(i).tabId == 89) {
                                    aV.g(0, booleanValue);
                                } else {
                                    aV.g(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener drf = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bqN;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bqN = FrsTabViewController.this.bqN()) != null && bqN.fragment != null && (bqN.fragment instanceof ag)) {
                        ((ag) bqN.fragment).aIG();
                    }
                }
            }
        }
    };
    private CustomMessageListener fNa = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.fMO.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.fMO.size()) {
                    FrsTabViewController.this.fMI.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener fNb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.fMV.aZA();
        }
    };
    private View.OnClickListener fNc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void ku(int i);
    }

    public void kG(boolean z) {
        this.fMH.setDisableTabSelect(z);
    }

    public FrsTabViewPager bqH() {
        return this.fMI;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.fqJ = frsFragment;
        this.fMF = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.fMG = view.findViewById(R.id.frs_tab_bg);
        this.bpR = view.findViewById(R.id.frs_tab_divider);
        this.dnj = view.findViewById(R.id.divider_shadow);
        this.fMN = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.fMH = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.fMH.setOnTabSelectedListener(this);
        this.fMH.setSelectedTabTextBlod(true);
        this.fMH.setSelectedTabTextSize(sF(R.dimen.tbds46));
        this.fMH.setTabTextSize(sF(R.dimen.tbds40));
        this.fMJ = view.findViewById(R.id.fading_edge_view);
        this.fMK = (ImageOverlayView) view.findViewById(R.id.frs_tab_overlayview);
        this.fMM = (LinearLayout) view.findViewById(R.id.frs_tab_arrow);
        this.fML = (TbImageView) view.findViewById(R.id.smartapp_arrow);
        this.fMM.setOnClickListener(this.fNc);
        this.fMV = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.fMH);
        this.fMV.pK(R.drawable.bg_tip_blue_up_left);
        this.fMV.pJ(16);
        this.fMV.S(true);
        this.fMV.pN(sF(R.dimen.tbds34));
        this.fMV.setYOffset(sF(R.dimen.tbds10));
        this.fMV.q(this.fNb);
        this.fMI = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.fMQ = new FragmentAdapter(this.fqJ.getActivity().getSupportFragmentManager(), this.mFragments);
        this.fMI.addOnPageChangeListener(this.mOnPageChangeListener);
        this.fIb = new RelativeLayout(this.fqJ.getContext());
        this.fMS = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.fIb);
    }

    private int sF(int i) {
        return l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bqI() {
        return this.fIb;
    }

    public View bqJ() {
        return this.fMN;
    }

    private boolean isBrandForum() {
        return this.fMP != null && this.fMP.getIsBrandForum();
    }

    public void registerListener() {
        this.fMY.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.fqJ.registerListener(this.fMY);
        this.fqJ.registerListener(this.fMZ);
        this.fqJ.registerListener(2001446, this.drf, this.fqJ.getBaseFragmentActivity().getUniqueId());
        this.fqJ.registerListener(this.fNa);
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void a(FrsViewData frsViewData, int i) {
        AccountData currentAccountObj;
        String str;
        String str2;
        boolean z;
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().tab != null) {
            if (frsViewData != null && !v.aa(frsViewData.smartAppAvatar)) {
                int size = frsViewData.smartAppAvatar.size();
                if (size > 3) {
                    size = 3;
                }
                int g = l.g(this.fqJ.getContext(), R.dimen.tbds72);
                this.fMK.i(size, g, g, l.g(this.fqJ.getContext(), R.dimen.tbds2), R.color.cp_bg_line_d, l.g(this.fqJ.getContext(), R.dimen.tbds12));
                this.fMK.setData(frsViewData.smartAppAvatar);
                this.fMM.setVisibility(0);
                this.fMJ.setVisibility(0);
            } else {
                this.fMM.setVisibility(8);
                this.fMJ.setVisibility(8);
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
                            int wY = com.baidu.tieba.frs.f.g.wY("503~" + str + str2);
                            if (wY == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aw("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == wY) {
                                                com.baidu.tieba.tbadkCore.util.e.cnt();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cnu();
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
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                sb.append("http://");
                            }
                            sb.append(frsTabInfo.tab_url);
                            sb.append("&");
                            sb.append("fid");
                            sb.append("=");
                            sb.append(frsViewData.getForum().getId());
                            dVar3.url = sb.toString();
                            dc(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && sr(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.lQ(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.blD().rv(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x rs = w.blC().rs(dVar5.tabId);
                        if (rs != null && rs.fsG != null && rs.fsG.size() > 0) {
                            dVar5.fKl = new as();
                            dVar5.fKl.fsF = rs.fsF;
                            dVar5.fKl.fsG = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : rs.fsG) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.fsC = vVar.fsC;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.fKl.fsG.add(arVar);
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
                        x rs2 = w.blC().rs(dVar6.tabId);
                        if (rs2 != null && rs2.fsG != null && rs2.fsG.size() > 0) {
                            dVar6.fKl = new as();
                            dVar6.fKl.fsF = rs2.fsF;
                            dVar6.fKl.fsG = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : rs2.fsG) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.fsC = vVar2.fsC;
                                    dVar6.fKl.fsG.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.fqJ.bjP().blc().m(bg.bIx)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.fMU > 0 && this.fMU != frsViewData.getAlaLiveCount() && this.fMU <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.fMU + ")";
                            } else if (this.fMU > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.fMU == 0 && this.fMU != frsViewData.getAlaLiveCount()) {
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
                        dVar9.name = ap.j(frsTabInfo.tab_name, 8, null);
                        tabData.add(dVar9);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.fMP = frsViewData;
                if (!c(tabData) && this.fMH.getTabCount() > 0 && !v.aa(this.fMO)) {
                    int min = Math.min(this.fMO.size(), this.fMH.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aV = this.fMH.aV(i2);
                        if (aV != null) {
                            if (frsViewData.isShowRedTip() && this.fMO.get(i2).tabId == 89) {
                                aV.g(0, true);
                            } else {
                                aV.g(0, false);
                            }
                        }
                    }
                }
                if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.c(f, 0);
                        if (this.fqJ != null && this.fqJ.bjK() != null && frsTabInfo2 != null) {
                            this.fqJ.bjK().sg(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.fqJ != null && this.fqJ.ajY() != null) {
                        if (f.size() < 2) {
                            this.fqJ.ajY().removeHeaderView(this.fIb);
                        } else {
                            this.fqJ.ajY().removeHeaderView(this.fIb);
                            this.fqJ.ajY().addHeaderView(this.fIb);
                            if (this.fMS != null && frsViewData.getForum() != null) {
                                this.fMS.setData(f, i);
                                this.fMS.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.fMO = tabData;
                    cm(arrayList);
                }
            }
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
        if (v.aa(tabData)) {
            return false;
        }
        b(tabData);
        if (!v.aa(this.fMQ.mFragments) && tabData.size() == this.fMQ.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.fMQ.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.fMQ.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void b(TabData tabData) {
        if (!v.aa(tabData)) {
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
    public boolean sG(int i) {
        if (i < 0 || this.fMO == null || this.fMO.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.fMO.size()) {
                i2 = -1;
                break;
            } else if (this.fMO.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fMH.getTabCount()) {
            return false;
        }
        TbTabLayout.e aV = this.fMH.aV(i2);
        if (aV != null && !aV.isSelected()) {
            aV.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d sH(int i) {
        if (i < 0 || this.fMO == null || this.fMO.size() <= 0) {
            return null;
        }
        Iterator it = this.fMO.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        al.b(this.fML, (int) R.drawable.icon_common_arrow20_right_n, i);
        al.k(this.fMJ, R.drawable.frs_tab_fading_edge);
        al.k(this.dnj, R.drawable.personalize_tab_shadow);
        al.l(this.bpR, R.color.cp_bg_line_c);
        bqR();
        if (this.fMH != null) {
            this.fMH.setSelectedTabIndicatorColor(0);
            this.fMH.setBackgroundColor(0);
            this.fMH.setTabTextColors(al.getColor(R.color.cp_cont_j), al.getColor(R.color.cp_cont_b));
        }
        if (this.fMS != null && !isBrandForum()) {
            this.fMS.onChangeSkinType();
        }
        if (this.fMK != null) {
            this.fMK.onChangeSkinType();
        }
        if (this.fMN != null) {
            this.fMN.changeSkinType(i);
        }
        if (!v.aa(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void sI(int i) {
        this.fMU = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.fMO != null && position >= 0 && position < this.fMO.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.fMO.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.jS()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
                if (com.baidu.adp.lib.util.j.jG() && dVar.tabId == 89 && this.fMP != null && this.fMP.isShowRedTip()) {
                    this.fMP.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.fqJ.bkr() != null) {
                        this.fqJ.bkr().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.fqJ.bkr() != null) {
                    this.fqJ.bkr().setIconFade(0);
                }
                if (this.fMT != null) {
                    this.fMT.ku(dVar.tabId);
                }
                com.baidu.tieba.frs.a.biW().jz(dVar.tabId == 301);
                TiebaStatic.log(new am("c12398").bT("fid", this.fqJ.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bqP();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.fMO != null && position >= 0 && position < this.fMO.size() && (dVar = this.fMO.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new am("c12398").bT("fid", this.fqJ.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
                if (com.baidu.adp.lib.util.j.jG() && dVar.tabId == 89 && this.fMP != null && this.fMP.isShowRedTip()) {
                    this.fMP.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.aa(tabData)) {
            return false;
        }
        return (!v.aa(this.fMO) && tabData.size() == this.fMO.size() && this.fMO.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !sr(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void dc(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    am amVar = new am(str2);
                    amVar.bT("obj_type", host);
                    TiebaStatic.log(amVar);
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
                public com.baidu.tbadk.mainTab.c asJ() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.fqJ != null && FrsTabViewController.this.fqJ.bjP() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.fqJ.bjP().ble());
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("forum_id", FrsTabViewController.this.fqJ.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    frsAllThreadFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cwn = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.cwt = com.baidu.tbadk.mainTab.c.cwq;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cO(Context context) {
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
                public com.baidu.tbadk.mainTab.c asJ() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fqJ.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fqJ.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fqJ.getForumId());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cwn = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.cwt = com.baidu.tbadk.mainTab.c.cwq;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cO(Context context) {
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
                public com.baidu.tbadk.mainTab.c asJ() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fqJ.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fqJ.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fqJ.getForumId());
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cwn = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.cwt = com.baidu.tbadk.mainTab.c.cwq;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cO(Context context) {
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
                public com.baidu.tbadk.mainTab.c asJ() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fqJ.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fqJ.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fqJ.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cwn = frsADFragment;
                    cVar.type = 90;
                    cVar.cwt = com.baidu.tbadk.mainTab.c.cwq;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cO(Context context) {
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
                public com.baidu.tbadk.mainTab.c asJ() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fqJ.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fqJ.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fqJ.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.fMP.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.fMP.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.fMP.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.fMP);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cwn = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.cwt = com.baidu.tbadk.mainTab.c.cwq;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cO(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void cm(List<FrsTabInfo> list) {
        if (!v.aa(list)) {
            this.fMR = new com.baidu.tieba.frs.e(this.fqJ.getActivity().getApplicationContext(), list);
            this.fMR.setForumId(this.fqJ.getForumId());
            this.fMR.setForumName(this.fqJ.getForumName());
            if (this.fMP != null && this.fMP.getForum() != null) {
                this.fMR.mx(this.fMP.getForum().getFirst_class());
                this.fMR.my(this.fMP.getForum().getSecond_class());
                this.fMR.setForumGameLabel(this.fMP.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bp(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.fMR.b(c);
                }
            }
            this.fMW = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.fMR));
        }
    }

    private void bp(int i, int i2) {
        am amVar = new am("c13008");
        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.bT("fid", this.fqJ.getForumId());
        if (i == 89) {
            amVar.P("obj_type", 1);
        } else if (i == 501) {
            amVar.P("obj_type", 3);
        } else if (i == 502) {
            amVar.P("obj_type", 8);
        } else if (i == 90) {
            amVar.P("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                amVar.P("obj_type", 4);
            } else {
                amVar.P("obj_type", 5);
            }
        } else if (i == 404) {
            amVar.P("obj_type", 2);
        } else if (i == 301 || i == 303) {
            amVar.P("obj_type", 7);
        } else if (i == 503) {
            amVar.P("obj_type", 6);
        }
        amVar.P("obj_locate", i2);
        amVar.aif();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqK() {
        int i;
        if (this.fMR != null) {
            List<com.baidu.tbadk.mainTab.b> bjw = this.fMR.bjw();
            if (!v.aa(bjw) && !v.aa(this.fMO)) {
                if (this.fMH.getTabCount() > 0) {
                    this.fMH.removeAllTabs();
                }
                bqL();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.fMO.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment g = g(dVar.tabId, bjw);
                    if (g != null) {
                        TbTabLayout.e b2 = this.fMH.ou().b(dVar.name);
                        boolean z = this.fMP.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.fMP != null && this.fMP.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.fMH.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = g;
                        this.mFragments.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i3 = i3;
                    i2 = i;
                }
                if (this.fMH.getTabCount() > 0 && this.fMF.getVisibility() != 0) {
                    this.fMF.setVisibility(0);
                }
                this.fMQ = new FragmentAdapter(this.fqJ.getActivity().getSupportFragmentManager(), this.mFragments);
                this.fMI.setAdapter(this.fMQ);
                this.fMQ.notifyDataSetChanged();
                this.fMH.setupWithViewPager(this.fMI);
                this.fMI.setOffscreenPageLimit(this.mFragments.size());
                this.fMI.setCurrentItem(i3, false);
                this.fMI.blE();
            }
        }
    }

    private void bqL() {
        if (this.fMI != null && this.fMQ != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.fqJ.getActivity().getSupportFragmentManager();
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

    private Fragment g(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.asK().type) {
                return bVar.asK().cwn;
            }
        }
        return null;
    }

    public View bqM() {
        if (isBrandForum() || this.fMS == null) {
            return null;
        }
        return this.fMS.bnl();
    }

    public static boolean sr(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.fMT = aVar;
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
                        FrsTabViewController.this.fqJ.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.fqJ.setPrimary(true);
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

    public b bqN() {
        if (this.fMI == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.fMI.getCurrentItem());
    }

    public void bqO() {
        this.fMV.cH(this.fqJ.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void bqP() {
        this.fMV.aZA();
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void sJ(int i) {
        this.frE = i;
        bqR();
    }

    public int bqQ() {
        return this.frE;
    }

    private void bqR() {
        if (this.frE == 2) {
            al.l(this.fMF, R.color.cp_bg_line_e);
            al.l(this.fMG, R.color.cp_bg_line_d);
            this.bpR.setVisibility(8);
            this.dnj.setVisibility(0);
            this.fqJ.bkl();
        } else if (this.frE == 1) {
            al.l(this.fMF, R.color.cp_bg_line_e);
            al.l(this.fMG, R.color.cp_bg_line_d);
            this.bpR.setVisibility(8);
            this.dnj.setVisibility(0);
        } else {
            al.l(this.fMF, R.color.cp_bg_line_e);
            al.k(this.fMG, R.drawable.top_corners_bg);
            this.bpR.setVisibility(0);
            this.dnj.setVisibility(8);
            this.fqJ.bkk();
        }
    }
}
