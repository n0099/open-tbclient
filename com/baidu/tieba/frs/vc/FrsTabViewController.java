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
    private View bjJ;
    private View dcF;
    private FrsFragment faH;
    private RelativeLayout frV;
    private RelativeLayout fwd;
    private View fwe;
    private TbTabLayout fwf;
    private FrsTabViewPager fwg;
    private View fwh;
    private ImageOverlayView fwi;
    private TbImageView fwj;
    private LinearLayout fwk;
    private LinearGradientView fwl;
    private TabData fwm;
    private FrsViewData fwn;
    private FragmentAdapter fwo;
    private com.baidu.tieba.frs.e fwp;
    private com.baidu.tieba.frs.entelechy.c.a.b fwq;
    private a fwr;
    private com.baidu.tieba.c.d fws;
    private List<b> mFragments;
    private int fbC = 0;
    private int dVI = -1;
    private boolean fwt = false;
    public boolean fwu = true;
    CustomMessageListener fwv = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.fwt) {
                FrsTabViewController.this.bjr();
                FrsTabViewController.this.fwt = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.fwg != null) {
                FrsTabViewController.this.fwg.bel();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener fww = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.fwf.getTabCount() > 0 && !v.T(FrsTabViewController.this.fwm)) {
                    FrsTabViewController.this.fwn.setIsShowRedTip(true);
                    int min = Math.min(FrsTabViewController.this.fwm.size(), FrsTabViewController.this.fwf.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e bd = FrsTabViewController.this.fwf.bd(i);
                        if (bd != null) {
                            if (FrsTabViewController.this.fwm.get(i).tabId == 89) {
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
    private CustomMessageListener dgA = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
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
    private CustomMessageListener fwx = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.fwm.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.fwm.size()) {
                    FrsTabViewController.this.fwg.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener fwy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.fws.aSr();
        }
    };
    private View.OnClickListener fwz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
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
        this.fwf.setDisableTabSelect(z);
    }

    public FrsTabViewPager bjo() {
        return this.fwg;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.faH = frsFragment;
        this.fwd = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.fwe = view.findViewById(d.g.frs_tab_bg);
        this.bjJ = view.findViewById(d.g.frs_tab_divider);
        this.dcF = view.findViewById(d.g.divider_shadow);
        this.fwl = (LinearGradientView) view.findViewById(d.g.frs_tab_linear_bg);
        this.fwf = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.fwf.setOnTabSelectedListener(this);
        this.fwf.setSelectedTabTextBlod(true);
        this.fwf.setSelectedTabTextSize(rB(d.e.tbds46));
        this.fwf.setTabTextSize(rB(d.e.tbds40));
        this.fwh = view.findViewById(d.g.fading_edge_view);
        this.fwi = (ImageOverlayView) view.findViewById(d.g.frs_tab_overlayview);
        this.fwk = (LinearLayout) view.findViewById(d.g.frs_tab_arrow);
        this.fwj = (TbImageView) view.findViewById(d.g.smartapp_arrow);
        this.fwk.setOnClickListener(this.fwz);
        this.fws = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.fwf);
        this.fws.oK(d.f.bg_tip_blue_up_left);
        this.fws.oJ(16);
        this.fws.aa(true);
        this.fws.oN(rB(d.e.tbds34));
        this.fws.setYOffset(rB(d.e.tbds10));
        this.fws.o(this.fwy);
        this.fwg = (FrsTabViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.fwo = new FragmentAdapter(this.faH.getActivity().getSupportFragmentManager(), this.mFragments);
        this.fwg.addOnPageChangeListener(this.mOnPageChangeListener);
        this.frV = new RelativeLayout(this.faH.getContext());
        this.frV.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fwq = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.frV);
    }

    private int rB(int i) {
        return l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bjp() {
        return this.frV;
    }

    public View bjq() {
        return this.fwl;
    }

    private boolean isBrandForum() {
        return this.fwn != null && this.fwn.getIsBrandForum();
    }

    public void registerListener() {
        this.fwv.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.faH.registerListener(this.fwv);
        this.faH.registerListener(this.fww);
        this.faH.registerListener(2001446, this.dgA, this.faH.getBaseFragmentActivity().getUniqueId());
        this.faH.registerListener(this.fwx);
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
                int h = l.h(this.faH.getContext(), d.e.tbds72);
                this.fwi.i(size, h, h, l.h(this.faH.getContext(), d.e.tbds2), d.C0236d.cp_bg_line_d, l.h(this.faH.getContext(), d.e.tbds12));
                this.fwi.setData(frsViewData.smartAppAvatar);
                this.fwk.setVisibility(0);
                this.fwh.setVisibility(0);
            } else {
                this.fwk.setVisibility(8);
                this.fwh.setVisibility(8);
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
                            int vL = com.baidu.tieba.frs.f.g.vL("503~" + str + str2);
                            if (vL == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aA("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == vL) {
                                                com.baidu.tieba.tbadkCore.util.e.cfo();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cfp();
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
                        if (qp != null && qp.fcF != null && qp.fcF.size() > 0) {
                            dVar5.ftJ = new as();
                            dVar5.ftJ.fcE = qp.fcE;
                            dVar5.ftJ.fcF = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : qp.fcF) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.fcB = vVar.fcB;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.ftJ.fcF.add(arVar);
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
                        if (qp2 != null && qp2.fcF != null && qp2.fcF.size() > 0) {
                            dVar6.ftJ = new as();
                            dVar6.ftJ.fcE = qp2.fcE;
                            dVar6.ftJ.fcF = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : qp2.fcF) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.fcB = vVar2.fcB;
                                    dVar6.ftJ.fcF.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.faH.bcu().bdK().l(bg.bBc)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.dVI > 0 && this.dVI != frsViewData.getAlaLiveCount() && this.dVI <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.dVI + ")";
                            } else if (this.dVI > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.dVI == 0 && this.dVI != frsViewData.getAlaLiveCount()) {
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
                this.fwn = frsViewData;
                if (!c(tabData) && this.fwf.getTabCount() > 0 && !v.T(this.fwm)) {
                    int min = Math.min(this.fwm.size(), this.fwf.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e bd = this.fwf.bd(i2);
                        if (bd != null) {
                            if (frsViewData.isShowRedTip() && this.fwm.get(i2).tabId == 89) {
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
                        if (this.faH != null && this.faH.bcp() != null && frsTabInfo2 != null) {
                            this.faH.bcp().rc(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.faH != null && this.faH.afc() != null) {
                        if (f.size() < 2) {
                            this.faH.afc().removeHeaderView(this.frV);
                        } else {
                            this.faH.afc().removeHeaderView(this.frV);
                            this.faH.afc().addHeaderView(this.frV);
                            if (this.fwq != null && frsViewData.getForum() != null) {
                                this.fwq.setData(f, i);
                                this.fwq.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.fwm = tabData;
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
        if (!v.T(this.fwo.mFragments) && tabData.size() == this.fwo.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.fwo.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.fwo.mFragments.get(i)).tabId) {
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
        if (i < 0 || this.fwm == null || this.fwm.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.fwm.size()) {
                i2 = -1;
                break;
            } else if (this.fwm.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fwf.getTabCount()) {
            return false;
        }
        TbTabLayout.e bd = this.fwf.bd(i2);
        if (bd != null && !bd.isSelected()) {
            bd.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d rD(int i) {
        if (i < 0 || this.fwm == null || this.fwm.size() <= 0) {
            return null;
        }
        Iterator it = this.fwm.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        al.b(this.fwj, d.f.icon_common_arrow20_right_n, i);
        al.k(this.fwh, d.f.frs_tab_fading_edge);
        al.k(this.dcF, d.f.personalize_tab_shadow);
        al.l(this.bjJ, d.C0236d.cp_bg_line_c);
        bjy();
        if (this.fwf != null) {
            this.fwf.setSelectedTabIndicatorColor(0);
            this.fwf.setBackgroundColor(0);
            this.fwf.setTabTextColors(al.getColor(d.C0236d.cp_cont_j), al.getColor(d.C0236d.cp_cont_b));
        }
        if (this.fwq != null && !isBrandForum()) {
            this.fwq.onChangeSkinType();
        }
        if (this.fwi != null) {
            this.fwi.onChangeSkinType();
        }
        if (this.fwl != null) {
            this.fwl.changeSkinType(i);
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
        this.dVI = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.fwm != null && position >= 0 && position < this.fwm.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.fwm.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kY()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
                if (com.baidu.adp.lib.util.j.kM() && dVar.tabId == 89 && this.fwn != null && this.fwn.isShowRedTip()) {
                    this.fwn.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.faH.bcW() != null) {
                        this.faH.bcW().setIconFade(d.f.btn_frs_professional_edit_n);
                    }
                } else if (this.faH.bcW() != null) {
                    this.faH.bcW().setIconFade(0);
                }
                if (this.fwr != null) {
                    this.fwr.jH(dVar.tabId);
                }
                TiebaStatic.log(new am("c12398").bJ(ImageViewerConfig.FORUM_ID, this.faH.forumId).T(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
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
        if (this.fwm != null && position >= 0 && position < this.fwm.size() && (dVar = this.fwm.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").bJ(ImageViewerConfig.FORUM_ID, this.faH.forumId).T(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean c(TabData tabData) {
        if (v.T(tabData)) {
            return false;
        }
        return (!v.T(this.fwm) && tabData.size() == this.fwm.size() && this.fwm.containsAll(tabData)) ? false : true;
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
                public com.baidu.tbadk.mainTab.c anK() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.faH != null && FrsTabViewController.this.faH.bcu() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.faH.bcu().bdM());
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
                public com.baidu.tbadk.mainTab.c anK() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.faH.getForumName());
                    bundle.putString("from", FrsTabViewController.this.faH.getFrom());
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
                public com.baidu.tbadk.mainTab.c anK() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.faH.getForumName());
                    bundle.putString("from", FrsTabViewController.this.faH.getFrom());
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
                public com.baidu.tbadk.mainTab.c anK() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.faH.getForumName());
                    bundle.putString("from", FrsTabViewController.this.faH.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.faH.getForumId());
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
                public com.baidu.tbadk.mainTab.c anK() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.faH.getForumName());
                    bundle.putString("from", FrsTabViewController.this.faH.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.faH.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.fwn.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.fwn.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.fwn.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.fwn);
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
            this.fwp = new com.baidu.tieba.frs.e(this.faH.getActivity().getApplicationContext(), list);
            this.fwp.setForumId(this.faH.getForumId());
            this.fwp.setForumName(this.faH.getForumName());
            if (this.fwn != null && this.fwn.getForum() != null) {
                this.fwp.lr(this.fwn.getForum().getFirst_class());
                this.fwp.ls(this.fwn.getForum().getSecond_class());
                this.fwp.setForumGameLabel(this.fwn.getForum().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.fwp.b(c);
                }
            }
            this.fwt = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.fwp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjr() {
        int i;
        if (this.fwp != null) {
            List<com.baidu.tbadk.mainTab.b> bcc = this.fwp.bcc();
            if (!v.T(bcc) && !v.T(this.fwm)) {
                if (this.fwf.getTabCount() > 0) {
                    this.fwf.removeAllTabs();
                }
                bjs();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.fwm.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment g = g(dVar.tabId, bcc);
                    if (g != null) {
                        TbTabLayout.e b2 = this.fwf.pz().b(dVar.name);
                        boolean z = this.fwn.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.fwn != null && this.fwn.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.fwf.a(b2, z);
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
                if (this.fwf.getTabCount() > 0 && this.fwd.getVisibility() != 0) {
                    this.fwd.setVisibility(0);
                }
                this.fwo = new FragmentAdapter(this.faH.getActivity().getSupportFragmentManager(), this.mFragments);
                this.fwg.setAdapter(this.fwo);
                this.fwo.notifyDataSetChanged();
                this.fwf.setupWithViewPager(this.fwg);
                this.fwg.setOffscreenPageLimit(this.mFragments.size());
                this.fwg.setCurrentItem(i3, false);
                this.fwg.bel();
            }
        }
    }

    private void bjs() {
        if (this.fwg != null && this.fwo != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.faH.getActivity().getSupportFragmentManager();
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
            if (i == bVar.anL().type) {
                return bVar.anL().cod;
            }
        }
        return null;
    }

    public View bjt() {
        if (isBrandForum() || this.fwq == null) {
            return null;
        }
        return this.fwq.bfR();
    }

    public static boolean rn(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.fwr = aVar;
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
                        FrsTabViewController.this.faH.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.faH.setPrimary(true);
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
        if (this.fwg == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.fwg.getCurrentItem());
    }

    public void bjv() {
        this.fws.cu(this.faH.getString(d.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void bjw() {
        this.fws.aSr();
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void rF(int i) {
        this.fbC = i;
        bjy();
    }

    public int bjx() {
        return this.fbC;
    }

    private void bjy() {
        if (this.fbC == 2) {
            al.l(this.fwd, d.C0236d.cp_bg_line_e);
            al.l(this.fwe, d.C0236d.cp_bg_line_d);
            this.bjJ.setVisibility(8);
            this.dcF.setVisibility(0);
            this.faH.bcQ();
        } else if (this.fbC == 1) {
            al.l(this.fwd, d.C0236d.cp_bg_line_e);
            al.l(this.fwe, d.C0236d.cp_bg_line_d);
            this.bjJ.setVisibility(8);
            this.dcF.setVisibility(0);
        } else {
            al.l(this.fwd, d.C0236d.cp_bg_line_e);
            al.k(this.fwe, d.f.top_corners_bg);
            this.bjJ.setVisibility(0);
            this.dcF.setVisibility(8);
            this.faH.bcP();
        }
    }
}
