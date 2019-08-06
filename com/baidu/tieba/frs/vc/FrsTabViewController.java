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
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private View bqE;
    private View dpq;
    private RelativeLayout fNP;
    private LinearGradientView fSA;
    private TabData fSB;
    private FrsViewData fSC;
    private FragmentAdapter fSD;
    private com.baidu.tieba.frs.e fSE;
    private com.baidu.tieba.frs.entelechy.c.a.b fSF;
    private a fSG;
    private com.baidu.tieba.c.d fSI;
    private RelativeLayout fSs;
    private View fSt;
    private TbTabLayout fSu;
    private FrsTabViewPager fSv;
    private View fSw;
    private ImageOverlayView fSx;
    private TbImageView fSy;
    private LinearLayout fSz;
    private FrsFragment fwg;
    private List<b> mFragments;
    private int fxa = 0;
    private int fSH = -1;
    private boolean fSJ = false;
    public boolean fSK = true;
    CustomMessageListener fSL = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.fSJ) {
                FrsTabViewController.this.bta();
                FrsTabViewController.this.fSJ = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.fSv != null) {
                FrsTabViewController.this.fSv.bnP();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener fSM = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.fSC != null && FrsTabViewController.this.fSC.isShowRedTip() != booleanValue && FrsTabViewController.this.fSu.getTabCount() > 0 && !v.aa(FrsTabViewController.this.fSB)) {
                        FrsTabViewController.this.fSC.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.fSB.size(), FrsTabViewController.this.fSu.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aV = FrsTabViewController.this.fSu.aV(i);
                            if (aV != null) {
                                if (FrsTabViewController.this.fSB.get(i).tabId == 89) {
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
    private CustomMessageListener dtv = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b btd;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (btd = FrsTabViewController.this.btd()) != null && btd.fragment != null && (btd.fragment instanceof ag)) {
                        ((ag) btd.fragment).aKj();
                    }
                }
            }
        }
    };
    private CustomMessageListener fSN = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.fSB.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.fSB.size()) {
                    FrsTabViewController.this.fSv.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener fSO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.fSI.bbB();
        }
    };
    private View.OnClickListener fSP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void kB(int i);
    }

    public void kR(boolean z) {
        this.fSu.setDisableTabSelect(z);
    }

    public FrsTabViewPager bsX() {
        return this.fSv;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.fwg = frsFragment;
        this.fSs = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.fSt = view.findViewById(R.id.frs_tab_bg);
        this.bqE = view.findViewById(R.id.frs_tab_divider);
        this.dpq = view.findViewById(R.id.divider_shadow);
        this.fSA = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.fSu = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.fSu.setOnTabSelectedListener(this);
        this.fSu.setSelectedTabTextBlod(true);
        this.fSu.setSelectedTabTextSize(sZ(R.dimen.tbds46));
        this.fSu.setTabTextSize(sZ(R.dimen.tbds40));
        this.fSw = view.findViewById(R.id.fading_edge_view);
        this.fSx = (ImageOverlayView) view.findViewById(R.id.frs_tab_overlayview);
        this.fSz = (LinearLayout) view.findViewById(R.id.frs_tab_arrow);
        this.fSy = (TbImageView) view.findViewById(R.id.smartapp_arrow);
        this.fSz.setOnClickListener(this.fSP);
        this.fSI = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.fSu);
        this.fSI.qc(R.drawable.bg_tip_blue_up_left);
        this.fSI.qb(16);
        this.fSI.S(true);
        this.fSI.qf(sZ(R.dimen.tbds34));
        this.fSI.setYOffset(sZ(R.dimen.tbds10));
        this.fSI.q(this.fSO);
        this.fSv = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.fSD = new FragmentAdapter(this.fwg.getActivity().getSupportFragmentManager(), this.mFragments);
        this.fSv.addOnPageChangeListener(this.mOnPageChangeListener);
        this.fNP = new RelativeLayout(this.fwg.getContext());
        this.fSF = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.fNP);
    }

    private int sZ(int i) {
        return l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bsY() {
        return this.fNP;
    }

    public View bsZ() {
        return this.fSA;
    }

    private boolean isBrandForum() {
        return this.fSC != null && this.fSC.getIsBrandForum();
    }

    public void registerListener() {
        this.fSL.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.fwg.registerListener(this.fSL);
        this.fwg.registerListener(this.fSM);
        this.fwg.registerListener(2001446, this.dtv, this.fwg.getBaseFragmentActivity().getUniqueId());
        this.fwg.registerListener(this.fSN);
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
                int g = l.g(this.fwg.getContext(), R.dimen.tbds72);
                this.fSx.j(size, g, g, l.g(this.fwg.getContext(), R.dimen.tbds2), R.color.cp_bg_line_d, l.g(this.fwg.getContext(), R.dimen.tbds12));
                this.fSx.setData(frsViewData.smartAppAvatar);
                this.fSz.setVisibility(0);
                this.fSw.setVisibility(0);
            } else {
                this.fSz.setVisibility(8);
                this.fSw.setVisibility(8);
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
                            int xG = com.baidu.tieba.frs.f.g.xG("503~" + str + str2);
                            if (xG == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.ax("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == xG) {
                                                com.baidu.tieba.tbadkCore.util.e.cqJ();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cqK();
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
                            dd(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && sL(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.lZ(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.bnO().rP(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x rM = w.bnN().rM(dVar5.tabId);
                        if (rM != null && rM.fyb != null && rM.fyb.size() > 0) {
                            dVar5.fPZ = new as();
                            dVar5.fPZ.fya = rM.fya;
                            dVar5.fPZ.fyb = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : rM.fyb) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.fxX = vVar.fxX;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.fPZ.fyb.add(arVar);
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
                        x rM2 = w.bnN().rM(dVar6.tabId);
                        if (rM2 != null && rM2.fyb != null && rM2.fyb.size() > 0) {
                            dVar6.fPZ = new as();
                            dVar6.fPZ.fya = rM2.fya;
                            dVar6.fPZ.fyb = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : rM2.fyb) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.fxX = vVar2.fxX;
                                    dVar6.fPZ.fyb.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.fwg.blY().bno().n(bh.bJD)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.fSH > 0 && this.fSH != frsViewData.getAlaLiveCount() && this.fSH <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.fSH + ")";
                            } else if (this.fSH > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.fSH == 0 && this.fSH != frsViewData.getAlaLiveCount()) {
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
                        dVar9.name = aq.j(frsTabInfo.tab_name, 8, null);
                        tabData.add(dVar9);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.fSC = frsViewData;
                if (!c(tabData) && this.fSu.getTabCount() > 0 && !v.aa(this.fSB)) {
                    int min = Math.min(this.fSB.size(), this.fSu.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aV = this.fSu.aV(i2);
                        if (aV != null) {
                            if (frsViewData.isShowRedTip() && this.fSB.get(i2).tabId == 89) {
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
                        if (this.fwg != null && this.fwg.blT() != null && frsTabInfo2 != null) {
                            this.fwg.blT().sA(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.fwg != null && this.fwg.alf() != null) {
                        if (f.size() < 2) {
                            this.fwg.alf().removeHeaderView(this.fNP);
                        } else {
                            this.fwg.alf().removeHeaderView(this.fNP);
                            this.fwg.alf().addHeaderView(this.fNP);
                            if (this.fSF != null && frsViewData.getForum() != null) {
                                this.fSF.setData(f, i);
                                this.fSF.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.fSB = tabData;
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
        if (!v.aa(this.fSD.mFragments) && tabData.size() == this.fSD.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.fSD.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.fSD.mFragments.get(i)).tabId) {
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
    public boolean ta(int i) {
        if (i < 0 || this.fSB == null || this.fSB.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.fSB.size()) {
                i2 = -1;
                break;
            } else if (this.fSB.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fSu.getTabCount()) {
            return false;
        }
        TbTabLayout.e aV = this.fSu.aV(i2);
        if (aV != null && !aV.isSelected()) {
            aV.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d tb(int i) {
        if (i < 0 || this.fSB == null || this.fSB.size() <= 0) {
            return null;
        }
        Iterator it = this.fSB.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        am.b(this.fSy, (int) R.drawable.icon_common_arrow20_right_n, i);
        am.k(this.fSw, R.drawable.frs_tab_fading_edge);
        am.k(this.dpq, R.drawable.personalize_tab_shadow);
        am.l(this.bqE, R.color.cp_bg_line_c);
        bth();
        if (this.fSu != null) {
            this.fSu.setSelectedTabIndicatorColor(0);
            this.fSu.setBackgroundColor(0);
            this.fSu.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.fSF != null && !isBrandForum()) {
            this.fSF.onChangeSkinType();
        }
        if (this.fSx != null) {
            this.fSx.onChangeSkinType();
        }
        if (this.fSA != null) {
            this.fSA.changeSkinType(i);
        }
        if (!v.aa(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void tc(int i) {
        this.fSH = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.fSB != null && position >= 0 && position < this.fSB.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.fSB.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kc()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
                if (com.baidu.adp.lib.util.j.jQ() && dVar.tabId == 89 && this.fSC != null && this.fSC.isShowRedTip()) {
                    this.fSC.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.fwg.bmD() != null) {
                        this.fwg.bmD().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.fwg.bmD() != null) {
                    this.fwg.bmD().setIconFade(0);
                }
                if (this.fSG != null) {
                    this.fSG.kB(dVar.tabId);
                }
                com.baidu.tieba.frs.a.blf().jJ(dVar.tabId == 301);
                TiebaStatic.log(new an("c12398").bT("fid", this.fwg.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        btf();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.fSB != null && position >= 0 && position < this.fSB.size() && (dVar = this.fSB.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new an("c12398").bT("fid", this.fwg.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
                if (com.baidu.adp.lib.util.j.jQ() && dVar.tabId == 89 && this.fSC != null && this.fSC.isShowRedTip()) {
                    this.fSC.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.aa(tabData)) {
            return false;
        }
        return (!v.aa(this.fSB) && tabData.size() == this.fSB.size() && this.fSB.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !sL(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void dd(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    an anVar = new an(str2);
                    anVar.bT("obj_type", host);
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
                public com.baidu.tbadk.mainTab.c atT() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.fwg != null && FrsTabViewController.this.fwg.blY() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.fwg.blY().bnp());
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("forum_id", FrsTabViewController.this.fwg.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    frsAllThreadFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxK = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.cxQ = com.baidu.tbadk.mainTab.c.cxN;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cP(Context context) {
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
                public com.baidu.tbadk.mainTab.c atT() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fwg.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fwg.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fwg.getForumId());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxK = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.cxQ = com.baidu.tbadk.mainTab.c.cxN;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cP(Context context) {
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
                public com.baidu.tbadk.mainTab.c atT() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fwg.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fwg.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fwg.getForumId());
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxK = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.cxQ = com.baidu.tbadk.mainTab.c.cxN;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cP(Context context) {
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
                public com.baidu.tbadk.mainTab.c atT() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fwg.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fwg.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fwg.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxK = frsADFragment;
                    cVar.type = 90;
                    cVar.cxQ = com.baidu.tbadk.mainTab.c.cxN;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cP(Context context) {
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
                public com.baidu.tbadk.mainTab.c atT() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fwg.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fwg.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fwg.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.fSC.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.fSC.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.fSC.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.fSC);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxK = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.cxQ = com.baidu.tbadk.mainTab.c.cxN;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator cP(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void cm(List<FrsTabInfo> list) {
        if (!v.aa(list)) {
            this.fSE = new com.baidu.tieba.frs.e(this.fwg.getActivity().getApplicationContext(), list);
            this.fSE.setForumId(this.fwg.getForumId());
            this.fSE.setForumName(this.fwg.getForumName());
            if (this.fSC != null && this.fSC.getForum() != null) {
                this.fSE.mH(this.fSC.getForum().getFirst_class());
                this.fSE.mI(this.fSC.getForum().getSecond_class());
                this.fSE.setForumGameLabel(this.fSC.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bu(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.fSE.b(c);
                }
            }
            this.fSJ = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.fSE));
        }
    }

    private void bu(int i, int i2) {
        an anVar = new an("c13008");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT("fid", this.fwg.getForumId());
        if (i == 89) {
            anVar.P("obj_type", 1);
        } else if (i == 501) {
            anVar.P("obj_type", 3);
        } else if (i == 502) {
            anVar.P("obj_type", 8);
        } else if (i == 90) {
            anVar.P("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                anVar.P("obj_type", 4);
            } else {
                anVar.P("obj_type", 5);
            }
        } else if (i == 404) {
            anVar.P("obj_type", 2);
        } else if (i == 301 || i == 303) {
            anVar.P("obj_type", 7);
        } else if (i == 503) {
            anVar.P("obj_type", 6);
        }
        anVar.P("obj_locate", i2);
        anVar.ajk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bta() {
        int i;
        if (this.fSE != null) {
            List<com.baidu.tbadk.mainTab.b> blF = this.fSE.blF();
            if (!v.aa(blF) && !v.aa(this.fSB)) {
                if (this.fSu.getTabCount() > 0) {
                    this.fSu.removeAllTabs();
                }
                btb();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.fSB.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment g = g(dVar.tabId, blF);
                    if (g != null) {
                        TbTabLayout.e b2 = this.fSu.oP().b(dVar.name);
                        boolean z = this.fSC.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.fSC != null && this.fSC.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.fSu.a(b2, z);
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
                if (this.fSu.getTabCount() > 0 && this.fSs.getVisibility() != 0) {
                    this.fSs.setVisibility(0);
                }
                this.fSD = new FragmentAdapter(this.fwg.getActivity().getSupportFragmentManager(), this.mFragments);
                this.fSv.setAdapter(this.fSD);
                this.fSD.notifyDataSetChanged();
                this.fSu.setupWithViewPager(this.fSv);
                this.fSv.setOffscreenPageLimit(this.mFragments.size());
                this.fSv.setCurrentItem(i3, false);
                this.fSv.bnP();
            }
        }
    }

    private void btb() {
        if (this.fSv != null && this.fSD != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.fwg.getActivity().getSupportFragmentManager();
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
            if (i == bVar.atU().type) {
                return bVar.atU().cxK;
            }
        }
        return null;
    }

    public View btc() {
        if (isBrandForum() || this.fSF == null) {
            return null;
        }
        return this.fSF.bpz();
    }

    public static boolean sL(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.fSG = aVar;
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
                        FrsTabViewController.this.fwg.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.fwg.setPrimary(true);
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

    public b btd() {
        if (this.fSv == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.fSv.getCurrentItem());
    }

    public void bte() {
        this.fSI.cI(this.fwg.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void btf() {
        this.fSI.bbB();
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void td(int i) {
        this.fxa = i;
        bth();
    }

    public int btg() {
        return this.fxa;
    }

    private void bth() {
        if (this.fxa == 2) {
            am.l(this.fSs, R.color.cp_bg_line_e);
            am.l(this.fSt, R.color.cp_bg_line_d);
            this.bqE.setVisibility(8);
            this.dpq.setVisibility(0);
            this.fwg.bmx();
        } else if (this.fxa == 1) {
            am.l(this.fSs, R.color.cp_bg_line_e);
            am.l(this.fSt, R.color.cp_bg_line_d);
            this.bqE.setVisibility(8);
            this.dpq.setVisibility(0);
        } else {
            if (this.fwg != null && this.fwg.bmd()) {
                am.l(this.fSs, R.color.transparent);
            } else {
                am.l(this.fSs, R.color.cp_bg_line_e);
            }
            am.k(this.fSt, R.drawable.top_corners_bg);
            this.bqE.setVisibility(0);
            this.dpq.setVisibility(8);
            this.fwg.bmw();
        }
    }
}
