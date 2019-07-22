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
import com.baidu.tbadk.core.data.bg;
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
    private View dpj;
    private RelativeLayout fNb;
    private RelativeLayout fRE;
    private View fRF;
    private TbTabLayout fRG;
    private FrsTabViewPager fRH;
    private View fRI;
    private ImageOverlayView fRJ;
    private TbImageView fRK;
    private LinearLayout fRL;
    private LinearGradientView fRM;
    private TabData fRN;
    private FrsViewData fRO;
    private FragmentAdapter fRP;
    private com.baidu.tieba.frs.e fRQ;
    private com.baidu.tieba.frs.entelechy.c.a.b fRR;
    private a fRS;
    private com.baidu.tieba.c.d fRU;
    private FrsFragment fvH;
    private List<b> mFragments;
    private int fwB = 0;
    private int fRT = -1;
    private boolean fRV = false;
    public boolean fRW = true;
    CustomMessageListener fRX = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.fRV) {
                FrsTabViewController.this.bsN();
                FrsTabViewController.this.fRV = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.fRH != null) {
                FrsTabViewController.this.fRH.bnF();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener fRY = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.fRO != null && FrsTabViewController.this.fRO.isShowRedTip() != booleanValue && FrsTabViewController.this.fRG.getTabCount() > 0 && !v.aa(FrsTabViewController.this.fRN)) {
                        FrsTabViewController.this.fRO.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.fRN.size(), FrsTabViewController.this.fRG.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aV = FrsTabViewController.this.fRG.aV(i);
                            if (aV != null) {
                                if (FrsTabViewController.this.fRN.get(i).tabId == 89) {
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
    private CustomMessageListener dto = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b bsQ;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (bsQ = FrsTabViewController.this.bsQ()) != null && bsQ.fragment != null && (bsQ.fragment instanceof ag)) {
                        ((ag) bsQ.fragment).aKh();
                    }
                }
            }
        }
    };
    private CustomMessageListener fRZ = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.fRN.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.fRN.size()) {
                    FrsTabViewController.this.fRH.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener fSa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.fRU.bbz();
        }
    };
    private View.OnClickListener fSb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void kA(int i);
    }

    public void kR(boolean z) {
        this.fRG.setDisableTabSelect(z);
    }

    public FrsTabViewPager bsK() {
        return this.fRH;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.fvH = frsFragment;
        this.fRE = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.fRF = view.findViewById(R.id.frs_tab_bg);
        this.bqE = view.findViewById(R.id.frs_tab_divider);
        this.dpj = view.findViewById(R.id.divider_shadow);
        this.fRM = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.fRG = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.fRG.setOnTabSelectedListener(this);
        this.fRG.setSelectedTabTextBlod(true);
        this.fRG.setSelectedTabTextSize(sX(R.dimen.tbds46));
        this.fRG.setTabTextSize(sX(R.dimen.tbds40));
        this.fRI = view.findViewById(R.id.fading_edge_view);
        this.fRJ = (ImageOverlayView) view.findViewById(R.id.frs_tab_overlayview);
        this.fRL = (LinearLayout) view.findViewById(R.id.frs_tab_arrow);
        this.fRK = (TbImageView) view.findViewById(R.id.smartapp_arrow);
        this.fRL.setOnClickListener(this.fSb);
        this.fRU = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.fRG);
        this.fRU.qb(R.drawable.bg_tip_blue_up_left);
        this.fRU.qa(16);
        this.fRU.S(true);
        this.fRU.qe(sX(R.dimen.tbds34));
        this.fRU.setYOffset(sX(R.dimen.tbds10));
        this.fRU.q(this.fSa);
        this.fRH = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.fRP = new FragmentAdapter(this.fvH.getActivity().getSupportFragmentManager(), this.mFragments);
        this.fRH.addOnPageChangeListener(this.mOnPageChangeListener);
        this.fNb = new RelativeLayout(this.fvH.getContext());
        this.fRR = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.fNb);
    }

    private int sX(int i) {
        return l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout bsL() {
        return this.fNb;
    }

    public View bsM() {
        return this.fRM;
    }

    private boolean isBrandForum() {
        return this.fRO != null && this.fRO.getIsBrandForum();
    }

    public void registerListener() {
        this.fRX.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.fvH.registerListener(this.fRX);
        this.fvH.registerListener(this.fRY);
        this.fvH.registerListener(2001446, this.dto, this.fvH.getBaseFragmentActivity().getUniqueId());
        this.fvH.registerListener(this.fRZ);
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
                int g = l.g(this.fvH.getContext(), R.dimen.tbds72);
                this.fRJ.j(size, g, g, l.g(this.fvH.getContext(), R.dimen.tbds2), R.color.cp_bg_line_d, l.g(this.fvH.getContext(), R.dimen.tbds12));
                this.fRJ.setData(frsViewData.smartAppAvatar);
                this.fRL.setVisibility(0);
                this.fRI.setVisibility(0);
            } else {
                this.fRL.setVisibility(8);
                this.fRI.setVisibility(8);
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
                            int xF = com.baidu.tieba.frs.f.g.xF("503~" + str + str2);
                            if (xF == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.ax("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == xF) {
                                                com.baidu.tieba.tbadkCore.util.e.cqn();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cqo();
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
                    } else if (frsTabInfo.tab_type.intValue() == 11 && sJ(frsTabInfo.tab_id.intValue())) {
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
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.bnE().rN(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x rK = w.bnD().rK(dVar5.tabId);
                        if (rK != null && rK.fxC != null && rK.fxC.size() > 0) {
                            dVar5.fPl = new as();
                            dVar5.fPl.fxB = rK.fxB;
                            dVar5.fPl.fxC = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : rK.fxC) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.fxy = vVar.fxy;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.fPl.fxC.add(arVar);
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
                        x rK2 = w.bnD().rK(dVar6.tabId);
                        if (rK2 != null && rK2.fxC != null && rK2.fxC.size() > 0) {
                            dVar6.fPl = new as();
                            dVar6.fPl.fxB = rK2.fxB;
                            dVar6.fPl.fxC = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : rK2.fxC) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.fxy = vVar2.fxy;
                                    dVar6.fPl.fxC.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.fvH.blR().bne().n(bg.bJy)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.fRT > 0 && this.fRT != frsViewData.getAlaLiveCount() && this.fRT <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.fRT + ")";
                            } else if (this.fRT > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.fRT == 0 && this.fRT != frsViewData.getAlaLiveCount()) {
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
                this.fRO = frsViewData;
                if (!c(tabData) && this.fRG.getTabCount() > 0 && !v.aa(this.fRN)) {
                    int min = Math.min(this.fRN.size(), this.fRG.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aV = this.fRG.aV(i2);
                        if (aV != null) {
                            if (frsViewData.isShowRedTip() && this.fRN.get(i2).tabId == 89) {
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
                        if (this.fvH != null && this.fvH.blM() != null && frsTabInfo2 != null) {
                            this.fvH.blM().sy(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.fvH != null && this.fvH.ald() != null) {
                        if (f.size() < 2) {
                            this.fvH.ald().removeHeaderView(this.fNb);
                        } else {
                            this.fvH.ald().removeHeaderView(this.fNb);
                            this.fvH.ald().addHeaderView(this.fNb);
                            if (this.fRR != null && frsViewData.getForum() != null) {
                                this.fRR.setData(f, i);
                                this.fRR.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.fRN = tabData;
                    cn(arrayList);
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
        if (!v.aa(this.fRP.mFragments) && tabData.size() == this.fRP.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.fRP.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.fRP.mFragments.get(i)).tabId) {
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
    public boolean sY(int i) {
        if (i < 0 || this.fRN == null || this.fRN.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.fRN.size()) {
                i2 = -1;
                break;
            } else if (this.fRN.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fRG.getTabCount()) {
            return false;
        }
        TbTabLayout.e aV = this.fRG.aV(i2);
        if (aV != null && !aV.isSelected()) {
            aV.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d sZ(int i) {
        if (i < 0 || this.fRN == null || this.fRN.size() <= 0) {
            return null;
        }
        Iterator it = this.fRN.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        am.b(this.fRK, (int) R.drawable.icon_common_arrow20_right_n, i);
        am.k(this.fRI, R.drawable.frs_tab_fading_edge);
        am.k(this.dpj, R.drawable.personalize_tab_shadow);
        am.l(this.bqE, R.color.cp_bg_line_c);
        bsU();
        if (this.fRG != null) {
            this.fRG.setSelectedTabIndicatorColor(0);
            this.fRG.setBackgroundColor(0);
            this.fRG.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.fRR != null && !isBrandForum()) {
            this.fRR.onChangeSkinType();
        }
        if (this.fRJ != null) {
            this.fRJ.onChangeSkinType();
        }
        if (this.fRM != null) {
            this.fRM.changeSkinType(i);
        }
        if (!v.aa(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void ta(int i) {
        this.fRT = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.fRN != null && position >= 0 && position < this.fRN.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.fRN.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kc()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
                if (com.baidu.adp.lib.util.j.jQ() && dVar.tabId == 89 && this.fRO != null && this.fRO.isShowRedTip()) {
                    this.fRO.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.fvH.bmt() != null) {
                        this.fvH.bmt().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.fvH.bmt() != null) {
                    this.fvH.bmt().setIconFade(0);
                }
                if (this.fRS != null) {
                    this.fRS.kA(dVar.tabId);
                }
                com.baidu.tieba.frs.a.bkY().jJ(dVar.tabId == 301);
                TiebaStatic.log(new an("c12398").bT("fid", this.fvH.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        bsS();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.fRN != null && position >= 0 && position < this.fRN.size() && (dVar = this.fRN.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new an("c12398").bT("fid", this.fvH.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
                if (com.baidu.adp.lib.util.j.jQ() && dVar.tabId == 89 && this.fRO != null && this.fRO.isShowRedTip()) {
                    this.fRO.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.aa(tabData)) {
            return false;
        }
        return (!v.aa(this.fRN) && tabData.size() == this.fRN.size() && this.fRN.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !sJ(frsTabInfo.tab_id.intValue());
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
                public com.baidu.tbadk.mainTab.c atR() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.fvH != null && FrsTabViewController.this.fvH.blR() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.fvH.blR().bnf());
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("forum_id", FrsTabViewController.this.fvH.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    frsAllThreadFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxD = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.cxJ = com.baidu.tbadk.mainTab.c.cxG;
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
                public com.baidu.tbadk.mainTab.c atR() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fvH.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fvH.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fvH.getForumId());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxD = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.cxJ = com.baidu.tbadk.mainTab.c.cxG;
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
                public com.baidu.tbadk.mainTab.c atR() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fvH.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fvH.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fvH.getForumId());
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxD = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.cxJ = com.baidu.tbadk.mainTab.c.cxG;
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
                public com.baidu.tbadk.mainTab.c atR() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fvH.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fvH.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fvH.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxD = frsADFragment;
                    cVar.type = 90;
                    cVar.cxJ = com.baidu.tbadk.mainTab.c.cxG;
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
                public com.baidu.tbadk.mainTab.c atR() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fvH.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fvH.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fvH.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.fRO.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.fRO.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.fRO.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.fRO);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cxD = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.cxJ = com.baidu.tbadk.mainTab.c.cxG;
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

    private void cn(List<FrsTabInfo> list) {
        if (!v.aa(list)) {
            this.fRQ = new com.baidu.tieba.frs.e(this.fvH.getActivity().getApplicationContext(), list);
            this.fRQ.setForumId(this.fvH.getForumId());
            this.fRQ.setForumName(this.fvH.getForumName());
            if (this.fRO != null && this.fRO.getForum() != null) {
                this.fRQ.mH(this.fRO.getForum().getFirst_class());
                this.fRQ.mI(this.fRO.getForum().getSecond_class());
                this.fRQ.setForumGameLabel(this.fRO.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bu(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.fRQ.b(c);
                }
            }
            this.fRV = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.fRQ));
        }
    }

    private void bu(int i, int i2) {
        an anVar = new an("c13008");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT("fid", this.fvH.getForumId());
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
        anVar.aji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsN() {
        int i;
        if (this.fRQ != null) {
            List<com.baidu.tbadk.mainTab.b> bly = this.fRQ.bly();
            if (!v.aa(bly) && !v.aa(this.fRN)) {
                if (this.fRG.getTabCount() > 0) {
                    this.fRG.removeAllTabs();
                }
                bsO();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.fRN.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment g = g(dVar.tabId, bly);
                    if (g != null) {
                        TbTabLayout.e b2 = this.fRG.oP().b(dVar.name);
                        boolean z = this.fRO.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.fRO != null && this.fRO.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.fRG.a(b2, z);
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
                if (this.fRG.getTabCount() > 0 && this.fRE.getVisibility() != 0) {
                    this.fRE.setVisibility(0);
                }
                this.fRP = new FragmentAdapter(this.fvH.getActivity().getSupportFragmentManager(), this.mFragments);
                this.fRH.setAdapter(this.fRP);
                this.fRP.notifyDataSetChanged();
                this.fRG.setupWithViewPager(this.fRH);
                this.fRH.setOffscreenPageLimit(this.mFragments.size());
                this.fRH.setCurrentItem(i3, false);
                this.fRH.bnF();
            }
        }
    }

    private void bsO() {
        if (this.fRH != null && this.fRP != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.fvH.getActivity().getSupportFragmentManager();
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
            if (i == bVar.atS().type) {
                return bVar.atS().cxD;
            }
        }
        return null;
    }

    public View bsP() {
        if (isBrandForum() || this.fRR == null) {
            return null;
        }
        return this.fRR.bpm();
    }

    public static boolean sJ(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.fRS = aVar;
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
                        FrsTabViewController.this.fvH.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.fvH.setPrimary(true);
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

    public b bsQ() {
        if (this.fRH == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.fRH.getCurrentItem());
    }

    public void bsR() {
        this.fRU.cI(this.fvH.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void bsS() {
        this.fRU.bbz();
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void tb(int i) {
        this.fwB = i;
        bsU();
    }

    public int bsT() {
        return this.fwB;
    }

    private void bsU() {
        if (this.fwB == 2) {
            am.l(this.fRE, R.color.cp_bg_line_e);
            am.l(this.fRF, R.color.cp_bg_line_d);
            this.bqE.setVisibility(8);
            this.dpj.setVisibility(0);
            this.fvH.bmn();
        } else if (this.fwB == 1) {
            am.l(this.fRE, R.color.cp_bg_line_e);
            am.l(this.fRF, R.color.cp_bg_line_d);
            this.bqE.setVisibility(8);
            this.dpj.setVisibility(0);
        } else {
            am.l(this.fRE, R.color.cp_bg_line_e);
            am.k(this.fRF, R.drawable.top_corners_bg);
            this.bqE.setVisibility(0);
            this.dpj.setVisibility(8);
            this.fvH.bmm();
        }
    }
}
