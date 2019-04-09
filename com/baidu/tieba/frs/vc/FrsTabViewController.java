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
    private View bjO;
    private View dcG;
    private FrsFragment fat;
    private RelativeLayout frG;
    private RelativeLayout fvO;
    private View fvP;
    private TbTabLayout fvQ;
    private FrsTabViewPager fvR;
    private View fvS;
    private ImageOverlayView fvT;
    private TbImageView fvU;
    private LinearLayout fvV;
    private LinearGradientView fvW;
    private TabData fvX;
    private FrsViewData fvY;
    private FragmentAdapter fvZ;
    private com.baidu.tieba.frs.e fwa;
    private com.baidu.tieba.frs.entelechy.c.a.b fwb;
    private a fwc;
    private com.baidu.tieba.c.d fwe;
    private List<b> mFragments;
    private int fbo = 0;
    private int fwd = -1;
    private boolean fwf = false;
    public boolean fwg = true;
    CustomMessageListener fwh = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.fwf) {
                FrsTabViewController.this.bjp();
                FrsTabViewController.this.fwf = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.fvR != null) {
                FrsTabViewController.this.fvR.bej();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener fwi = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.fvQ.getTabCount() > 0 && !v.T(FrsTabViewController.this.fvX)) {
                    FrsTabViewController.this.fvY.setIsShowRedTip(true);
                    int min = Math.min(FrsTabViewController.this.fvX.size(), FrsTabViewController.this.fvQ.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e bc = FrsTabViewController.this.fvQ.bc(i);
                        if (bc != null) {
                            if (FrsTabViewController.this.fvX.get(i).tabId == 89) {
                                bc.g(0, true);
                            } else {
                                bc.g(0, false);
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener dgB = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bjs;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bjs = FrsTabViewController.this.bjs()) != null && bjs.fragment != null && (bjs.fragment instanceof ag)) {
                        ((ag) bjs.fragment).aCq();
                    }
                }
            }
        }
    };
    private CustomMessageListener fwj = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.fvX.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.fvX.size()) {
                    FrsTabViewController.this.fvR.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener fwk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.fwe.aSp();
        }
    };
    private View.OnClickListener fwl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void jG(int i);
    }

    public void jR(boolean z) {
        this.fvQ.setDisableTabSelect(z);
    }

    public FrsTabViewPager bjm() {
        return this.fvR;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.fat = frsFragment;
        this.fvO = (RelativeLayout) view.findViewById(d.g.frs_tab_view_container);
        this.fvP = view.findViewById(d.g.frs_tab_bg);
        this.bjO = view.findViewById(d.g.frs_tab_divider);
        this.dcG = view.findViewById(d.g.divider_shadow);
        this.fvW = (LinearGradientView) view.findViewById(d.g.frs_tab_linear_bg);
        this.fvQ = (TbTabLayout) view.findViewById(d.g.frs_tab_layout);
        this.fvQ.setOnTabSelectedListener(this);
        this.fvQ.setSelectedTabTextBlod(true);
        this.fvQ.setSelectedTabTextSize(rx(d.e.tbds46));
        this.fvQ.setTabTextSize(rx(d.e.tbds40));
        this.fvS = view.findViewById(d.g.fading_edge_view);
        this.fvT = (ImageOverlayView) view.findViewById(d.g.frs_tab_overlayview);
        this.fvV = (LinearLayout) view.findViewById(d.g.frs_tab_arrow);
        this.fvU = (TbImageView) view.findViewById(d.g.smartapp_arrow);
        this.fvV.setOnClickListener(this.fwl);
        this.fwe = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.fvQ);
        this.fwe.oG(d.f.bg_tip_blue_up_left);
        this.fwe.oF(16);
        this.fwe.aa(true);
        this.fwe.oJ(rx(d.e.tbds34));
        this.fwe.setYOffset(rx(d.e.tbds10));
        this.fwe.o(this.fwk);
        this.fvR = (FrsTabViewPager) view.findViewById(d.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.fvZ = new FragmentAdapter(this.fat.getActivity().getSupportFragmentManager(), this.mFragments);
        this.fvR.addOnPageChangeListener(this.mOnPageChangeListener);
        this.frG = new RelativeLayout(this.fat.getContext());
        this.frG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.fwb = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.frG);
    }

    private int rx(int i) {
        return l.h(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bjn() {
        return this.frG;
    }

    public View bjo() {
        return this.fvW;
    }

    private boolean isBrandForum() {
        return this.fvY != null && this.fvY.getIsBrandForum();
    }

    public void registerListener() {
        this.fwh.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.fat.registerListener(this.fwh);
        this.fat.registerListener(this.fwi);
        this.fat.registerListener(2001446, this.dgB, this.fat.getBaseFragmentActivity().getUniqueId());
        this.fat.registerListener(this.fwj);
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
                int h = l.h(this.fat.getContext(), d.e.tbds72);
                this.fvT.i(size, h, h, l.h(this.fat.getContext(), d.e.tbds2), d.C0277d.cp_bg_line_d, l.h(this.fat.getContext(), d.e.tbds12));
                this.fvT.setData(frsViewData.smartAppAvatar);
                this.fvV.setVisibility(0);
                this.fvS.setVisibility(0);
            } else {
                this.fvV.setVisibility(8);
                this.fvS.setVisibility(8);
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
                            int vJ = com.baidu.tieba.frs.f.g.vJ("503~" + str + str2);
                            if (vJ == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.aA("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == vJ) {
                                                com.baidu.tieba.tbadkCore.util.e.cfn();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cfo();
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
                            cP(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && rj(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.kL(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.bei().qo(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x ql = w.beh().ql(dVar5.tabId);
                        if (ql != null && ql.fcr != null && ql.fcr.size() > 0) {
                            dVar5.ftu = new as();
                            dVar5.ftu.fcq = ql.fcq;
                            dVar5.ftu.fcr = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : ql.fcr) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.fcn = vVar.fcn;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.ftu.fcr.add(arVar);
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
                        x ql2 = w.beh().ql(dVar6.tabId);
                        if (ql2 != null && ql2.fcr != null && ql2.fcr.size() > 0) {
                            dVar6.ftu = new as();
                            dVar6.ftu.fcq = ql2.fcq;
                            dVar6.ftu.fcr = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : ql2.fcr) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.fcn = vVar2.fcn;
                                    dVar6.ftu.fcr.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.fat.bcs().bdI().l(bg.bBi)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.fwd > 0 && this.fwd != frsViewData.getAlaLiveCount() && this.fwd <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.fwd + ")";
                            } else if (this.fwd > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.fwd == 0 && this.fwd != frsViewData.getAlaLiveCount()) {
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
                this.fvY = frsViewData;
                if (!c(tabData) && this.fvQ.getTabCount() > 0 && !v.T(this.fvX)) {
                    int min = Math.min(this.fvX.size(), this.fvQ.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e bc = this.fvQ.bc(i2);
                        if (bc != null) {
                            if (frsViewData.isShowRedTip() && this.fvX.get(i2).tabId == 89) {
                                bc.g(0, true);
                            } else {
                                bc.g(0, false);
                            }
                        }
                    }
                }
                if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.c(f, 0);
                        if (this.fat != null && this.fat.bcn() != null && frsTabInfo2 != null) {
                            this.fat.bcn().qY(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.fat != null && this.fat.aeZ() != null) {
                        if (f.size() < 2) {
                            this.fat.aeZ().removeHeaderView(this.frG);
                        } else {
                            this.fat.aeZ().removeHeaderView(this.frG);
                            this.fat.aeZ().addHeaderView(this.frG);
                            if (this.fwb != null && frsViewData.getForum() != null) {
                                this.fwb.setData(f, i);
                                this.fwb.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.fvX = tabData;
                    ce(arrayList);
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
        if (!v.T(this.fvZ.mFragments) && tabData.size() == this.fvZ.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.fvZ.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.fvZ.mFragments.get(i)).tabId) {
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
    public boolean ry(int i) {
        if (i < 0 || this.fvX == null || this.fvX.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.fvX.size()) {
                i2 = -1;
                break;
            } else if (this.fvX.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fvQ.getTabCount()) {
            return false;
        }
        TbTabLayout.e bc = this.fvQ.bc(i2);
        if (bc != null && !bc.isSelected()) {
            bc.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d rz(int i) {
        if (i < 0 || this.fvX == null || this.fvX.size() <= 0) {
            return null;
        }
        Iterator it = this.fvX.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        al.b(this.fvU, d.f.icon_common_arrow20_right_n, i);
        al.k(this.fvS, d.f.frs_tab_fading_edge);
        al.k(this.dcG, d.f.personalize_tab_shadow);
        al.l(this.bjO, d.C0277d.cp_bg_line_c);
        bjw();
        if (this.fvQ != null) {
            this.fvQ.setSelectedTabIndicatorColor(0);
            this.fvQ.setBackgroundColor(0);
            this.fvQ.setTabTextColors(al.getColor(d.C0277d.cp_cont_j), al.getColor(d.C0277d.cp_cont_b));
        }
        if (this.fwb != null && !isBrandForum()) {
            this.fwb.onChangeSkinType();
        }
        if (this.fvT != null) {
            this.fvT.onChangeSkinType();
        }
        if (this.fvW != null) {
            this.fvW.changeSkinType(i);
        }
        if (!v.T(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void rA(int i) {
        this.fwd = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.fvX != null && position >= 0 && position < this.fvX.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.fvX.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kY()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
                if (com.baidu.adp.lib.util.j.kM() && dVar.tabId == 89 && this.fvY != null && this.fvY.isShowRedTip()) {
                    this.fvY.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.fat.bcU() != null) {
                        this.fat.bcU().setIconFade(d.f.btn_frs_professional_edit_n);
                    }
                } else if (this.fat.bcU() != null) {
                    this.fat.bcU().setIconFade(0);
                }
                if (this.fwc != null) {
                    this.fwc.jG(dVar.tabId);
                }
                TiebaStatic.log(new am("c12398").bJ(ImageViewerConfig.FORUM_ID, this.fat.forumId).T(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bju();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.fvX != null && position >= 0 && position < this.fvX.size() && (dVar = this.fvX.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").bJ(ImageViewerConfig.FORUM_ID, this.fat.forumId).T(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean c(TabData tabData) {
        if (v.T(tabData)) {
            return false;
        }
        return (!v.T(this.fvX) && tabData.size() == this.fvX.size() && this.fvX.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !rj(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void cP(String str, String str2) {
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
                public com.baidu.tbadk.mainTab.c anG() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.fat != null && FrsTabViewController.this.fat.bcs() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.fat.bcs().bdK());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cog = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.f5com = com.baidu.tbadk.mainTab.c.coj;
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
                public com.baidu.tbadk.mainTab.c anG() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fat.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fat.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cog = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.f5com = com.baidu.tbadk.mainTab.c.coj;
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
                public com.baidu.tbadk.mainTab.c anG() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fat.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fat.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cog = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.f5com = com.baidu.tbadk.mainTab.c.coj;
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
                public com.baidu.tbadk.mainTab.c anG() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fat.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fat.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fat.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cog = frsADFragment;
                    cVar.type = 90;
                    cVar.f5com = com.baidu.tbadk.mainTab.c.coj;
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
                public com.baidu.tbadk.mainTab.c anG() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fat.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fat.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fat.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.fvY.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.fvY.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.fvY.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.fvY);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cog = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.f5com = com.baidu.tbadk.mainTab.c.coj;
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

    private void ce(List<FrsTabInfo> list) {
        if (!v.T(list)) {
            this.fwa = new com.baidu.tieba.frs.e(this.fat.getActivity().getApplicationContext(), list);
            this.fwa.setForumId(this.fat.getForumId());
            this.fwa.setForumName(this.fat.getForumName());
            if (this.fvY != null && this.fvY.getForum() != null) {
                this.fwa.ls(this.fvY.getForum().getFirst_class());
                this.fwa.lt(this.fvY.getForum().getSecond_class());
                this.fwa.setForumGameLabel(this.fvY.getForum().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.fwa.b(c);
                }
            }
            this.fwf = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.fwa));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjp() {
        int i;
        if (this.fwa != null) {
            List<com.baidu.tbadk.mainTab.b> bca = this.fwa.bca();
            if (!v.T(bca) && !v.T(this.fvX)) {
                if (this.fvQ.getTabCount() > 0) {
                    this.fvQ.removeAllTabs();
                }
                bjq();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.fvX.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment g = g(dVar.tabId, bca);
                    if (g != null) {
                        TbTabLayout.e b2 = this.fvQ.pz().b(dVar.name);
                        boolean z = this.fvY.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.fvY != null && this.fvY.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.fvQ.a(b2, z);
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
                if (this.fvQ.getTabCount() > 0 && this.fvO.getVisibility() != 0) {
                    this.fvO.setVisibility(0);
                }
                this.fvZ = new FragmentAdapter(this.fat.getActivity().getSupportFragmentManager(), this.mFragments);
                this.fvR.setAdapter(this.fvZ);
                this.fvZ.notifyDataSetChanged();
                this.fvQ.setupWithViewPager(this.fvR);
                this.fvR.setOffscreenPageLimit(this.mFragments.size());
                this.fvR.setCurrentItem(i3, false);
                this.fvR.bej();
            }
        }
    }

    private void bjq() {
        if (this.fvR != null && this.fvZ != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.fat.getActivity().getSupportFragmentManager();
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
            if (i == bVar.anH().type) {
                return bVar.anH().cog;
            }
        }
        return null;
    }

    public View bjr() {
        if (isBrandForum() || this.fwb == null) {
            return null;
        }
        return this.fwb.bfP();
    }

    public static boolean rj(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.fwc = aVar;
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
                        FrsTabViewController.this.fat.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.fat.setPrimary(true);
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

    public b bjs() {
        if (this.fvR == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.fvR.getCurrentItem());
    }

    public void bjt() {
        this.fwe.cv(this.fat.getString(d.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void bju() {
        this.fwe.aSp();
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void rB(int i) {
        this.fbo = i;
        bjw();
    }

    public int bjv() {
        return this.fbo;
    }

    private void bjw() {
        if (this.fbo == 2) {
            al.l(this.fvO, d.C0277d.cp_bg_line_e);
            al.l(this.fvP, d.C0277d.cp_bg_line_d);
            this.bjO.setVisibility(8);
            this.dcG.setVisibility(0);
            this.fat.bcO();
        } else if (this.fbo == 1) {
            al.l(this.fvO, d.C0277d.cp_bg_line_e);
            al.l(this.fvP, d.C0277d.cp_bg_line_d);
            this.bjO.setVisibility(8);
            this.dcG.setVisibility(0);
        } else {
            al.l(this.fvO, d.C0277d.cp_bg_line_e);
            al.k(this.fvP, d.f.top_corners_bg);
            this.bjO.setVisibility(0);
            this.dcG.setVisibility(8);
            this.fat.bcN();
        }
    }
}
