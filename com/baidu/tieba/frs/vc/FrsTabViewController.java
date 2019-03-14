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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tieba.d;
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
    private View bjK;
    private View dcB;
    private FrsFragment faG;
    private RelativeLayout frU;
    private RelativeLayout fwc;
    private View fwd;
    private TbTabLayout fwe;
    private FrsTabViewPager fwf;
    private View fwg;
    private ImageOverlayView fwh;
    private TbImageView fwi;
    private LinearLayout fwj;
    private LinearGradientView fwk;
    private TabData fwl;
    private FrsViewData fwm;
    private FragmentAdapter fwn;
    private com.baidu.tieba.frs.e fwo;
    private com.baidu.tieba.frs.entelechy.c.a.b fwp;
    private a fwq;
    private com.baidu.tieba.c.d fwr;
    private List<b> mFragments;
    private int fbB = 0;
    private int dVE = -1;
    private boolean fws = false;
    public boolean fwt = true;
    CustomMessageListener fwu = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.fws) {
                FrsTabViewController.this.bjr();
                FrsTabViewController.this.fws = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.fwf != null) {
                FrsTabViewController.this.fwf.bel();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener fwv = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.fwe.getTabCount() > 0 && !v.T(FrsTabViewController.this.fwl)) {
                    FrsTabViewController.this.fwm.setIsShowRedTip(true);
                    int min = Math.min(FrsTabViewController.this.fwl.size(), FrsTabViewController.this.fwe.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e bd = FrsTabViewController.this.fwe.bd(i);
                        if (bd != null) {
                            if (FrsTabViewController.this.fwl.get(i).tabId == 89) {
                                bd.g(0, true);
                            } else {
                                bd.g(0, false);
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener dgw = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bju;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bju = FrsTabViewController.this.bju()) != null && bju.fragment != null && (bju.fragment instanceof ag)) {
                        ((ag) bju.fragment).aCt();
                    }
                }
            }
        }
    };
    private CustomMessageListener fww = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.fwl.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.fwl.size()) {
                    FrsTabViewController.this.fwf.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener fwx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.fwr.aSr();
        }
    };
    private View.OnClickListener fwy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void jH(int i);
    }

    public void jR(boolean z) {
        this.fwe.setDisableTabSelect(z);
    }

    public FrsTabViewPager bjo() {
        return this.fwf;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.faG = frsFragment;
        this.fwc = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.fwd = view.findViewById(d.g.frs_tab_bg);
        this.bjK = view.findViewById(d.g.frs_tab_divider);
        this.dcB = view.findViewById(d.g.divider_shadow);
        this.fwk = (LinearGradientView) view.findViewById(d.g.frs_tab_linear_bg);
        this.fwe = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.fwe.setOnTabSelectedListener(this);
        this.fwe.setSelectedTabTextBlod(true);
        this.fwe.setSelectedTabTextSize(rB(d.e.tbds46));
        this.fwe.setTabTextSize(rB(d.e.tbds40));
        this.fwg = view.findViewById(d.g.fading_edge_view);
        this.fwh = (ImageOverlayView) view.findViewById(d.g.frs_tab_overlayview);
        this.fwj = (LinearLayout) view.findViewById(d.g.frs_tab_arrow);
        this.fwi = (TbImageView) view.findViewById(d.g.smartapp_arrow);
        this.fwj.setOnClickListener(this.fwy);
        this.fwr = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.fwe);
        this.fwr.oK(d.f.bg_tip_blue_up_left);
        this.fwr.oJ(16);
        this.fwr.aa(true);
        this.fwr.oN(rB(d.e.tbds34));
        this.fwr.setYOffset(rB(d.e.tbds10));
        this.fwr.o(this.fwx);
        this.fwf = (FrsTabViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.fwn = new FragmentAdapter(this.faG.getActivity().getSupportFragmentManager(), this.mFragments);
        this.fwf.addOnPageChangeListener(this.mOnPageChangeListener);
        this.frU = new RelativeLayout(this.faG.getContext());
        this.frU.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fwp = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.frU);
    }

    private int rB(int i) {
        return l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bjp() {
        return this.frU;
    }

    public View bjq() {
        return this.fwk;
    }

    private boolean isBrandForum() {
        return this.fwm != null && this.fwm.getIsBrandForum();
    }

    public void registerListener() {
        this.fwu.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.faG.registerListener(this.fwu);
        this.faG.registerListener(this.fwv);
        this.faG.registerListener(2001446, this.dgw, this.faG.getBaseFragmentActivity().getUniqueId());
        this.faG.registerListener(this.fww);
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void a(FrsViewData frsViewData, int i) {
        AccountData currentAccountObj;
        String str;
        String str2;
        boolean z;
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().tab != null) {
            if (frsViewData != null && !v.T(frsViewData.smartAppAvatar)) {
                int size = frsViewData.smartAppAvatar.size();
                if (size > 3) {
                    size = 3;
                }
                int h = l.h(this.faG.getContext(), d.e.tbds72);
                this.fwh.i(size, h, h, l.h(this.faG.getContext(), d.e.tbds2), d.C0277d.cp_bg_line_d, l.h(this.faG.getContext(), d.e.tbds12));
                this.fwh.setData(frsViewData.smartAppAvatar);
                this.fwj.setVisibility(0);
                this.fwg.setVisibility(0);
            } else {
                this.fwj.setVisibility(8);
                this.fwg.setVisibility(8);
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
                                str = currentAccountObj.getID() + "~";
                            }
                            if (frsViewData.getForum() == null || frsViewData.getForum().getName() == null) {
                                str2 = "";
                            } else {
                                str2 = frsViewData.getForum().getName();
                            }
                            int vK = com.baidu.tieba.frs.f.g.vK("503~" + str + str2);
                            if (vK == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aA("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == vK) {
                                                com.baidu.tieba.tbadkCore.util.e.cfr();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cfs();
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
                            sb.append(ImageViewerConfig.FORUM_ID);
                            sb.append("=");
                            sb.append(frsViewData.getForum().getId());
                            dVar3.url = sb.toString();
                            cO(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && rn(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.kK(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.bek().qs(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x qp = w.bej().qp(dVar5.tabId);
                        if (qp != null && qp.fcE != null && qp.fcE.size() > 0) {
                            dVar5.ftI = new as();
                            dVar5.ftI.fcD = qp.fcD;
                            dVar5.ftI.fcE = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : qp.fcE) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.fcA = vVar.fcA;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.ftI.fcE.add(arVar);
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
                        x qp2 = w.bej().qp(dVar6.tabId);
                        if (qp2 != null && qp2.fcE != null && qp2.fcE.size() > 0) {
                            dVar6.ftI = new as();
                            dVar6.ftI.fcD = qp2.fcD;
                            dVar6.ftI.fcE = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : qp2.fcE) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.fcA = vVar2.fcA;
                                    dVar6.ftI.fcE.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.faG.bcu().bdK().l(bg.bBe)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.dVE > 0 && this.dVE != frsViewData.getAlaLiveCount() && this.dVE <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.dVE + ")";
                            } else if (this.dVE > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.dVE == 0 && this.dVE != frsViewData.getAlaLiveCount()) {
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
                        dVar9.name = ap.g(frsTabInfo.tab_name, 8, null);
                        tabData.add(dVar9);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.fwm = frsViewData;
                if (!c(tabData) && this.fwe.getTabCount() > 0 && !v.T(this.fwl)) {
                    int min = Math.min(this.fwl.size(), this.fwe.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e bd = this.fwe.bd(i2);
                        if (bd != null) {
                            if (frsViewData.isShowRedTip() && this.fwl.get(i2).tabId == 89) {
                                bd.g(0, true);
                            } else {
                                bd.g(0, false);
                            }
                        }
                    }
                }
                if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.c(f, 0);
                        if (this.faG != null && this.faG.bcp() != null && frsTabInfo2 != null) {
                            this.faG.bcp().rc(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.faG != null && this.faG.afc() != null) {
                        if (f.size() < 2) {
                            this.faG.afc().removeHeaderView(this.frU);
                        } else {
                            this.faG.afc().removeHeaderView(this.frU);
                            this.faG.afc().addHeaderView(this.frU);
                            if (this.fwp != null && frsViewData.getForum() != null) {
                                this.fwp.setData(f, i);
                                this.fwp.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.fwl = tabData;
                    ch(arrayList);
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
        if (v.T(tabData)) {
            return false;
        }
        b(tabData);
        if (!v.T(this.fwn.mFragments) && tabData.size() == this.fwn.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.fwn.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.fwn.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void b(TabData tabData) {
        if (!v.T(tabData)) {
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
    public boolean rC(int i) {
        if (i < 0 || this.fwl == null || this.fwl.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.fwl.size()) {
                i2 = -1;
                break;
            } else if (this.fwl.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fwe.getTabCount()) {
            return false;
        }
        TbTabLayout.e bd = this.fwe.bd(i2);
        if (bd != null && !bd.isSelected()) {
            bd.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d rD(int i) {
        if (i < 0 || this.fwl == null || this.fwl.size() <= 0) {
            return null;
        }
        Iterator it = this.fwl.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        al.b(this.fwi, d.f.icon_common_arrow20_right_n, i);
        al.k(this.fwg, d.f.frs_tab_fading_edge);
        al.k(this.dcB, d.f.personalize_tab_shadow);
        al.l(this.bjK, d.C0277d.cp_bg_line_c);
        bjy();
        if (this.fwe != null) {
            this.fwe.setSelectedTabIndicatorColor(0);
            this.fwe.setBackgroundColor(0);
            this.fwe.setTabTextColors(al.getColor(d.C0277d.cp_cont_j), al.getColor(d.C0277d.cp_cont_b));
        }
        if (this.fwp != null && !isBrandForum()) {
            this.fwp.onChangeSkinType();
        }
        if (this.fwh != null) {
            this.fwh.onChangeSkinType();
        }
        if (this.fwk != null) {
            this.fwk.changeSkinType(i);
        }
        if (!v.T(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void rE(int i) {
        this.dVE = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.fwl != null && position >= 0 && position < this.fwl.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.fwl.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kY()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
                if (com.baidu.adp.lib.util.j.kM() && dVar.tabId == 89 && this.fwm != null && this.fwm.isShowRedTip()) {
                    this.fwm.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.faG.bcW() != null) {
                        this.faG.bcW().setIconFade(d.f.btn_frs_professional_edit_n);
                    }
                } else if (this.faG.bcW() != null) {
                    this.faG.bcW().setIconFade(0);
                }
                if (this.fwq != null) {
                    this.fwq.jH(dVar.tabId);
                }
                TiebaStatic.log(new am("c12398").bJ(ImageViewerConfig.FORUM_ID, this.faG.forumId).T(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bjw();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.fwl != null && position >= 0 && position < this.fwl.size() && (dVar = this.fwl.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").bJ(ImageViewerConfig.FORUM_ID, this.faG.forumId).T(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean c(TabData tabData) {
        if (v.T(tabData)) {
            return false;
        }
        return (!v.T(this.fwl) && tabData.size() == this.fwl.size() && this.fwl.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !rn(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void cO(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    am amVar = new am(str2);
                    amVar.bJ("obj_type", host);
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
                public com.baidu.tbadk.mainTab.c anJ() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.faG != null && FrsTabViewController.this.faG.bcu() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.faG.bcu().bdM());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cod = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.coj = com.baidu.tbadk.mainTab.c.cog;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator di(Context context) {
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
                public com.baidu.tbadk.mainTab.c anJ() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.faG.getForumName());
                    bundle.putString("from", FrsTabViewController.this.faG.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cod = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.coj = com.baidu.tbadk.mainTab.c.cog;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator di(Context context) {
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
                public com.baidu.tbadk.mainTab.c anJ() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.faG.getForumName());
                    bundle.putString("from", FrsTabViewController.this.faG.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cod = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.coj = com.baidu.tbadk.mainTab.c.cog;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator di(Context context) {
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
                public com.baidu.tbadk.mainTab.c anJ() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.faG.getForumName());
                    bundle.putString("from", FrsTabViewController.this.faG.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.faG.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cod = frsADFragment;
                    cVar.type = 90;
                    cVar.coj = com.baidu.tbadk.mainTab.c.cog;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator di(Context context) {
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
                public com.baidu.tbadk.mainTab.c anJ() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.faG.getForumName());
                    bundle.putString("from", FrsTabViewController.this.faG.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.faG.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.fwm.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.fwm.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.fwm.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.fwm);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cod = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.coj = com.baidu.tbadk.mainTab.c.cog;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator di(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void ch(List<FrsTabInfo> list) {
        if (!v.T(list)) {
            this.fwo = new com.baidu.tieba.frs.e(this.faG.getActivity().getApplicationContext(), list);
            this.fwo.setForumId(this.faG.getForumId());
            this.fwo.setForumName(this.faG.getForumName());
            if (this.fwm != null && this.fwm.getForum() != null) {
                this.fwo.lr(this.fwm.getForum().getFirst_class());
                this.fwo.ls(this.fwm.getForum().getSecond_class());
                this.fwo.setForumGameLabel(this.fwm.getForum().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.fwo.b(c);
                }
            }
            this.fws = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.fwo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjr() {
        int i;
        if (this.fwo != null) {
            List<com.baidu.tbadk.mainTab.b> bcc = this.fwo.bcc();
            if (!v.T(bcc) && !v.T(this.fwl)) {
                if (this.fwe.getTabCount() > 0) {
                    this.fwe.removeAllTabs();
                }
                bjs();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.fwl.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment g = g(dVar.tabId, bcc);
                    if (g != null) {
                        TbTabLayout.e b2 = this.fwe.pz().b(dVar.name);
                        boolean z = this.fwm.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.fwm != null && this.fwm.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.fwe.a(b2, z);
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
                if (this.fwe.getTabCount() > 0 && this.fwc.getVisibility() != 0) {
                    this.fwc.setVisibility(0);
                }
                this.fwn = new FragmentAdapter(this.faG.getActivity().getSupportFragmentManager(), this.mFragments);
                this.fwf.setAdapter(this.fwn);
                this.fwn.notifyDataSetChanged();
                this.fwe.setupWithViewPager(this.fwf);
                this.fwf.setOffscreenPageLimit(this.mFragments.size());
                this.fwf.setCurrentItem(i3, false);
                this.fwf.bel();
            }
        }
    }

    private void bjs() {
        if (this.fwf != null && this.fwn != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.faG.getActivity().getSupportFragmentManager();
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
            if (i == bVar.anK().type) {
                return bVar.anK().cod;
            }
        }
        return null;
    }

    public View bjt() {
        if (isBrandForum() || this.fwp == null) {
            return null;
        }
        return this.fwp.bfR();
    }

    public static boolean rn(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.fwq = aVar;
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
                        FrsTabViewController.this.faG.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.faG.setPrimary(true);
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

    public b bju() {
        if (this.fwf == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.fwf.getCurrentItem());
    }

    public void bjv() {
        this.fwr.cu(this.faG.getString(d.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void bjw() {
        this.fwr.aSr();
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void rF(int i) {
        this.fbB = i;
        bjy();
    }

    public int bjx() {
        return this.fbB;
    }

    private void bjy() {
        if (this.fbB == 2) {
            al.l(this.fwc, d.C0277d.cp_bg_line_e);
            al.l(this.fwd, d.C0277d.cp_bg_line_d);
            this.bjK.setVisibility(8);
            this.dcB.setVisibility(0);
            this.faG.bcQ();
        } else if (this.fbB == 1) {
            al.l(this.fwc, d.C0277d.cp_bg_line_e);
            al.l(this.fwd, d.C0277d.cp_bg_line_d);
            this.bjK.setVisibility(8);
            this.dcB.setVisibility(0);
        } else {
            al.l(this.fwc, d.C0277d.cp_bg_line_e);
            al.k(this.fwd, d.f.top_corners_bg);
            this.bjK.setVisibility(0);
            this.dcB.setVisibility(8);
            this.faG.bcP();
        }
    }
}
