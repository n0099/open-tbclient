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
    private View dni;
    private RelativeLayout fIa;
    private RelativeLayout fME;
    private View fMF;
    private TbTabLayout fMG;
    private FrsTabViewPager fMH;
    private View fMI;
    private ImageOverlayView fMJ;
    private TbImageView fMK;
    private LinearLayout fML;
    private LinearGradientView fMM;
    private TabData fMN;
    private FrsViewData fMO;
    private FragmentAdapter fMP;
    private com.baidu.tieba.frs.e fMQ;
    private com.baidu.tieba.frs.entelechy.c.a.b fMR;
    private a fMS;
    private com.baidu.tieba.c.d fMU;
    private FrsFragment fqI;
    private List<b> mFragments;
    private int frD = 0;
    private int fMT = -1;
    private boolean fMV = false;
    public boolean fMW = true;
    CustomMessageListener fMX = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.fMV) {
                FrsTabViewController.this.bqH();
                FrsTabViewController.this.fMV = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.fMH != null) {
                FrsTabViewController.this.fMH.blB();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener fMY = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.fMO != null && FrsTabViewController.this.fMO.isShowRedTip() != booleanValue && FrsTabViewController.this.fMG.getTabCount() > 0 && !v.aa(FrsTabViewController.this.fMN)) {
                        FrsTabViewController.this.fMO.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.fMN.size(), FrsTabViewController.this.fMG.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aV = FrsTabViewController.this.fMG.aV(i);
                            if (aV != null) {
                                if (FrsTabViewController.this.fMN.get(i).tabId == 89) {
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
    private CustomMessageListener dre = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bqK;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bqK = FrsTabViewController.this.bqK()) != null && bqK.fragment != null && (bqK.fragment instanceof ag)) {
                        ((ag) bqK.fragment).aID();
                    }
                }
            }
        }
    };
    private CustomMessageListener fMZ = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.fMN.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.fMN.size()) {
                    FrsTabViewController.this.fMH.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener fNa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.fMU.aZx();
        }
    };
    private View.OnClickListener fNb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
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
        this.fMG.setDisableTabSelect(z);
    }

    public FrsTabViewPager bqE() {
        return this.fMH;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.fqI = frsFragment;
        this.fME = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.fMF = view.findViewById(R.id.frs_tab_bg);
        this.bpR = view.findViewById(R.id.frs_tab_divider);
        this.dni = view.findViewById(R.id.divider_shadow);
        this.fMM = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.fMG = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.fMG.setOnTabSelectedListener(this);
        this.fMG.setSelectedTabTextBlod(true);
        this.fMG.setSelectedTabTextSize(sF(R.dimen.tbds46));
        this.fMG.setTabTextSize(sF(R.dimen.tbds40));
        this.fMI = view.findViewById(R.id.fading_edge_view);
        this.fMJ = (ImageOverlayView) view.findViewById(R.id.frs_tab_overlayview);
        this.fML = (LinearLayout) view.findViewById(R.id.frs_tab_arrow);
        this.fMK = (TbImageView) view.findViewById(R.id.smartapp_arrow);
        this.fML.setOnClickListener(this.fNb);
        this.fMU = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.fMG);
        this.fMU.pK(R.drawable.bg_tip_blue_up_left);
        this.fMU.pJ(16);
        this.fMU.S(true);
        this.fMU.pN(sF(R.dimen.tbds34));
        this.fMU.setYOffset(sF(R.dimen.tbds10));
        this.fMU.q(this.fNa);
        this.fMH = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.fMP = new FragmentAdapter(this.fqI.getActivity().getSupportFragmentManager(), this.mFragments);
        this.fMH.addOnPageChangeListener(this.mOnPageChangeListener);
        this.fIa = new RelativeLayout(this.fqI.getContext());
        this.fMR = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.fIa);
    }

    private int sF(int i) {
        return l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bqF() {
        return this.fIa;
    }

    public View bqG() {
        return this.fMM;
    }

    private boolean isBrandForum() {
        return this.fMO != null && this.fMO.getIsBrandForum();
    }

    public void registerListener() {
        this.fMX.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.fqI.registerListener(this.fMX);
        this.fqI.registerListener(this.fMY);
        this.fqI.registerListener(2001446, this.dre, this.fqI.getBaseFragmentActivity().getUniqueId());
        this.fqI.registerListener(this.fMZ);
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
                int g = l.g(this.fqI.getContext(), R.dimen.tbds72);
                this.fMJ.i(size, g, g, l.g(this.fqI.getContext(), R.dimen.tbds2), R.color.cp_bg_line_d, l.g(this.fqI.getContext(), R.dimen.tbds12));
                this.fMJ.setData(frsViewData.smartAppAvatar);
                this.fML.setVisibility(0);
                this.fMI.setVisibility(0);
            } else {
                this.fML.setVisibility(8);
                this.fMI.setVisibility(8);
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
                                                com.baidu.tieba.tbadkCore.util.e.cnr();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cns();
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.blA().rv(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x rs = w.blz().rs(dVar5.tabId);
                        if (rs != null && rs.fsF != null && rs.fsF.size() > 0) {
                            dVar5.fKk = new as();
                            dVar5.fKk.fsE = rs.fsE;
                            dVar5.fKk.fsF = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : rs.fsF) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.fsB = vVar.fsB;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.fKk.fsF.add(arVar);
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
                        x rs2 = w.blz().rs(dVar6.tabId);
                        if (rs2 != null && rs2.fsF != null && rs2.fsF.size() > 0) {
                            dVar6.fKk = new as();
                            dVar6.fKk.fsE = rs2.fsE;
                            dVar6.fKk.fsF = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : rs2.fsF) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.fsB = vVar2.fsB;
                                    dVar6.fKk.fsF.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.fqI.bjM().bkZ().m(bg.bIx)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.fMT > 0 && this.fMT != frsViewData.getAlaLiveCount() && this.fMT <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.fMT + ")";
                            } else if (this.fMT > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.fMT == 0 && this.fMT != frsViewData.getAlaLiveCount()) {
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
                this.fMO = frsViewData;
                if (!c(tabData) && this.fMG.getTabCount() > 0 && !v.aa(this.fMN)) {
                    int min = Math.min(this.fMN.size(), this.fMG.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aV = this.fMG.aV(i2);
                        if (aV != null) {
                            if (frsViewData.isShowRedTip() && this.fMN.get(i2).tabId == 89) {
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
                        if (this.fqI != null && this.fqI.bjH() != null && frsTabInfo2 != null) {
                            this.fqI.bjH().sg(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.fqI != null && this.fqI.ajY() != null) {
                        if (f.size() < 2) {
                            this.fqI.ajY().removeHeaderView(this.fIa);
                        } else {
                            this.fqI.ajY().removeHeaderView(this.fIa);
                            this.fqI.ajY().addHeaderView(this.fIa);
                            if (this.fMR != null && frsViewData.getForum() != null) {
                                this.fMR.setData(f, i);
                                this.fMR.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.fMN = tabData;
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
        if (!v.aa(this.fMP.mFragments) && tabData.size() == this.fMP.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.fMP.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.fMP.mFragments.get(i)).tabId) {
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
        if (i < 0 || this.fMN == null || this.fMN.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.fMN.size()) {
                i2 = -1;
                break;
            } else if (this.fMN.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fMG.getTabCount()) {
            return false;
        }
        TbTabLayout.e aV = this.fMG.aV(i2);
        if (aV != null && !aV.isSelected()) {
            aV.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d sH(int i) {
        if (i < 0 || this.fMN == null || this.fMN.size() <= 0) {
            return null;
        }
        Iterator it = this.fMN.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        al.b(this.fMK, (int) R.drawable.icon_common_arrow20_right_n, i);
        al.k(this.fMI, R.drawable.frs_tab_fading_edge);
        al.k(this.dni, R.drawable.personalize_tab_shadow);
        al.l(this.bpR, R.color.cp_bg_line_c);
        bqO();
        if (this.fMG != null) {
            this.fMG.setSelectedTabIndicatorColor(0);
            this.fMG.setBackgroundColor(0);
            this.fMG.setTabTextColors(al.getColor(R.color.cp_cont_j), al.getColor(R.color.cp_cont_b));
        }
        if (this.fMR != null && !isBrandForum()) {
            this.fMR.onChangeSkinType();
        }
        if (this.fMJ != null) {
            this.fMJ.onChangeSkinType();
        }
        if (this.fMM != null) {
            this.fMM.changeSkinType(i);
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
        this.fMT = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.fMN != null && position >= 0 && position < this.fMN.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.fMN.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.jS()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
                if (com.baidu.adp.lib.util.j.jG() && dVar.tabId == 89 && this.fMO != null && this.fMO.isShowRedTip()) {
                    this.fMO.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.fqI.bko() != null) {
                        this.fqI.bko().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.fqI.bko() != null) {
                    this.fqI.bko().setIconFade(0);
                }
                if (this.fMS != null) {
                    this.fMS.ku(dVar.tabId);
                }
                com.baidu.tieba.frs.a.biT().jz(dVar.tabId == 301);
                TiebaStatic.log(new am("c12398").bT("fid", this.fqI.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bqM();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.fMN != null && position >= 0 && position < this.fMN.size() && (dVar = this.fMN.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new am("c12398").bT("fid", this.fqI.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
                if (com.baidu.adp.lib.util.j.jG() && dVar.tabId == 89 && this.fMO != null && this.fMO.isShowRedTip()) {
                    this.fMO.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.aa(tabData)) {
            return false;
        }
        return (!v.aa(this.fMN) && tabData.size() == this.fMN.size() && this.fMN.containsAll(tabData)) ? false : true;
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
                    if (FrsTabViewController.this.fqI != null && FrsTabViewController.this.fqI.bjM() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.fqI.bjM().blb());
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("forum_id", FrsTabViewController.this.fqI.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.fqI.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fqI.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fqI.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.fqI.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fqI.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fqI.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.fqI.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fqI.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fqI.getForumId());
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
                    bundle.putString("name", FrsTabViewController.this.fqI.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fqI.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fqI.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.fMO.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.fMO.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.fMO.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.fMO);
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
            this.fMQ = new com.baidu.tieba.frs.e(this.fqI.getActivity().getApplicationContext(), list);
            this.fMQ.setForumId(this.fqI.getForumId());
            this.fMQ.setForumName(this.fqI.getForumName());
            if (this.fMO != null && this.fMO.getForum() != null) {
                this.fMQ.mx(this.fMO.getForum().getFirst_class());
                this.fMQ.my(this.fMO.getForum().getSecond_class());
                this.fMQ.setForumGameLabel(this.fMO.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bp(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.fMQ.b(c);
                }
            }
            this.fMV = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.fMQ));
        }
    }

    private void bp(int i, int i2) {
        am amVar = new am("c13008");
        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.bT("fid", this.fqI.getForumId());
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
    public void bqH() {
        int i;
        if (this.fMQ != null) {
            List<com.baidu.tbadk.mainTab.b> bjt = this.fMQ.bjt();
            if (!v.aa(bjt) && !v.aa(this.fMN)) {
                if (this.fMG.getTabCount() > 0) {
                    this.fMG.removeAllTabs();
                }
                bqI();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.fMN.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment g = g(dVar.tabId, bjt);
                    if (g != null) {
                        TbTabLayout.e b2 = this.fMG.ou().b(dVar.name);
                        boolean z = this.fMO.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.fMO != null && this.fMO.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.fMG.a(b2, z);
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
                if (this.fMG.getTabCount() > 0 && this.fME.getVisibility() != 0) {
                    this.fME.setVisibility(0);
                }
                this.fMP = new FragmentAdapter(this.fqI.getActivity().getSupportFragmentManager(), this.mFragments);
                this.fMH.setAdapter(this.fMP);
                this.fMP.notifyDataSetChanged();
                this.fMG.setupWithViewPager(this.fMH);
                this.fMH.setOffscreenPageLimit(this.mFragments.size());
                this.fMH.setCurrentItem(i3, false);
                this.fMH.blB();
            }
        }
    }

    private void bqI() {
        if (this.fMH != null && this.fMP != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.fqI.getActivity().getSupportFragmentManager();
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

    public View bqJ() {
        if (isBrandForum() || this.fMR == null) {
            return null;
        }
        return this.fMR.bni();
    }

    public static boolean sr(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.fMS = aVar;
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
                        FrsTabViewController.this.fqI.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.fqI.setPrimary(true);
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

    public b bqK() {
        if (this.fMH == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.fMH.getCurrentItem());
    }

    public void bqL() {
        this.fMU.cH(this.fqI.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void bqM() {
        this.fMU.aZx();
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void sJ(int i) {
        this.frD = i;
        bqO();
    }

    public int bqN() {
        return this.frD;
    }

    private void bqO() {
        if (this.frD == 2) {
            al.l(this.fME, R.color.cp_bg_line_e);
            al.l(this.fMF, R.color.cp_bg_line_d);
            this.bpR.setVisibility(8);
            this.dni.setVisibility(0);
            this.fqI.bki();
        } else if (this.frD == 1) {
            al.l(this.fME, R.color.cp_bg_line_e);
            al.l(this.fMF, R.color.cp_bg_line_d);
            this.bpR.setVisibility(8);
            this.dni.setVisibility(0);
        } else {
            al.l(this.fME, R.color.cp_bg_line_e);
            al.k(this.fMF, R.drawable.top_corners_bg);
            this.bpR.setVisibility(0);
            this.dni.setVisibility(8);
            this.fqI.bkh();
        }
    }
}
