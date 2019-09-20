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
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
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
    private View drb;
    private RelativeLayout fPF;
    private RelativeLayout fUj;
    private View fUk;
    private TbTabLayout fUl;
    private FrsTabViewPager fUm;
    private View fUn;
    private ImageOverlayView fUo;
    private ImageView fUp;
    private LinearLayout fUq;
    private LinearGradientView fUr;
    private TabData fUs;
    private FrsViewData fUt;
    private FragmentAdapter fUu;
    private com.baidu.tieba.frs.e fUv;
    private com.baidu.tieba.frs.entelechy.c.a.b fUw;
    private a fUx;
    private com.baidu.tieba.c.d fUz;
    private FrsFragment fxT;
    private List<b> mFragments;
    private int fyN = 0;
    private int fUy = -1;
    private boolean fUA = false;
    public boolean fUB = true;
    CustomMessageListener fUC = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.fUA) {
                FrsTabViewController.this.btO();
                FrsTabViewController.this.fUA = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.fUm != null) {
                FrsTabViewController.this.fUm.boA();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener fUD = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.fUt != null && FrsTabViewController.this.fUt.isShowRedTip() != booleanValue && FrsTabViewController.this.fUl.getTabCount() > 0 && !v.aa(FrsTabViewController.this.fUs)) {
                        FrsTabViewController.this.fUt.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.fUs.size(), FrsTabViewController.this.fUl.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aV = FrsTabViewController.this.fUl.aV(i);
                            if (aV != null) {
                                if (FrsTabViewController.this.fUs.get(i).tabId == 89) {
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
    private CustomMessageListener dvg = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b btR;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (btR = FrsTabViewController.this.btR()) != null && btR.fragment != null && (btR.fragment instanceof ag)) {
                        ((ag) btR.fragment).aKN();
                    }
                }
            }
        }
    };
    private CustomMessageListener fUE = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.fUs.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.fUs.size()) {
                    FrsTabViewController.this.fUm.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener fUF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.fUz.bcf();
        }
    };
    private View.OnClickListener fUG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921371));
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void kE(int i);
    }

    public void kU(boolean z) {
        this.fUl.setDisableTabSelect(z);
    }

    public FrsTabViewPager btK() {
        return this.fUm;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.fxT = frsFragment;
        this.fUj = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.fUk = view.findViewById(R.id.frs_tab_bg);
        this.drb = view.findViewById(R.id.divider_shadow);
        this.fUr = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.fUl = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.fUl.setOnTabSelectedListener(this);
        this.fUl.setSelectedTabTextBlod(true);
        this.fUl.setSelectedTabTextSize(td(R.dimen.tbds46));
        this.fUl.setTabTextSize(td(R.dimen.tbds40));
        this.fUn = view.findViewById(R.id.fading_edge_view);
        this.fUo = (ImageOverlayView) view.findViewById(R.id.frs_tab_overlayview);
        this.fUq = (LinearLayout) view.findViewById(R.id.frs_tab_arrow);
        this.fUp = (ImageView) view.findViewById(R.id.smartapp_arrow);
        this.fUq.setOnClickListener(this.fUG);
        this.fUz = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.fUl);
        this.fUz.qf(R.drawable.bg_tip_blue_up_left);
        this.fUz.qe(16);
        this.fUz.S(true);
        this.fUz.qi(td(R.dimen.tbds34));
        this.fUz.setYOffset(td(R.dimen.tbds10));
        this.fUz.q(this.fUF);
        this.fUm = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.fUu = new FragmentAdapter(this.fxT.getActivity().getSupportFragmentManager(), this.mFragments);
        this.fUm.addOnPageChangeListener(this.mOnPageChangeListener);
        this.fPF = new RelativeLayout(this.fxT.getContext());
        this.fUw = new com.baidu.tieba.frs.entelechy.c.a.b(frsFragment, this.fPF);
    }

    private int td(int i) {
        return l.g(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout btL() {
        return this.fPF;
    }

    public View btM() {
        return this.fUr;
    }

    private boolean isBrandForum() {
        return this.fUt != null && this.fUt.getIsBrandForum();
    }

    public void registerListener() {
        this.fUC.setPriority(Integer.MAX_VALUE);
        this.fxT.registerListener(this.fUC);
        this.fxT.registerListener(this.fUD);
        this.fxT.registerListener(2001446, this.dvg, this.fxT.getBaseFragmentActivity().getUniqueId());
        this.fxT.registerListener(this.fUE);
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
                int g = l.g(this.fxT.getContext(), R.dimen.tbds72);
                this.fUo.j(size, g, g, l.g(this.fxT.getContext(), R.dimen.tbds2), R.color.cp_bg_line_d, l.g(this.fxT.getContext(), R.dimen.tbds12));
                this.fUo.setData(frsViewData.smartAppAvatar);
                this.fUq.setVisibility(0);
                this.fUn.setVisibility(0);
            } else {
                this.fUq.setVisibility(8);
                this.fUn.setVisibility(8);
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
                            int yf = com.baidu.tieba.frs.f.g.yf("503~" + str + str2);
                            if (yf == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.f.g.az("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == yf) {
                                                com.baidu.tieba.tbadkCore.util.e.crx();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.cry();
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
                            df(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && sP(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.mb(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && z.boz().rS(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        x rP = w.boy().rP(dVar5.tabId);
                        if (rP != null && rP.fzO != null && rP.fzO.size() > 0) {
                            dVar5.fRQ = new as();
                            dVar5.fRQ.fzN = rP.fzN;
                            dVar5.fRQ.fzO = new LinkedList();
                            boolean z2 = true;
                            for (com.baidu.tieba.frs.v vVar : rP.fzO) {
                                if (vVar != null) {
                                    ar arVar = new ar();
                                    arVar.name = vVar.name;
                                    arVar.fzK = vVar.fzK;
                                    if (z2) {
                                        arVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.fRQ.fzO.add(arVar);
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
                        x rP2 = w.boy().rP(dVar6.tabId);
                        if (rP2 != null && rP2.fzO != null && rP2.fzO.size() > 0) {
                            dVar6.fRQ = new as();
                            dVar6.fRQ.fzN = rP2.fzN;
                            dVar6.fRQ.fzO = new LinkedList();
                            for (com.baidu.tieba.frs.v vVar2 : rP2.fzO) {
                                if (vVar2 != null) {
                                    ar arVar2 = new ar();
                                    arVar2.name = vVar2.name;
                                    arVar2.fzK = vVar2.fzK;
                                    dVar6.fRQ.fzO.add(arVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.fxT.bmJ().bnZ().n(bh.bKb)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.fUy > 0 && this.fUy != frsViewData.getAlaLiveCount() && this.fUy <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.fUy + ")";
                            } else if (this.fUy > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.fUy == 0 && this.fUy != frsViewData.getAlaLiveCount()) {
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
                this.fUt = frsViewData;
                if (!c(tabData) && this.fUl.getTabCount() > 0 && !v.aa(this.fUs)) {
                    int min = Math.min(this.fUs.size(), this.fUl.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aV = this.fUl.aV(i2);
                        if (aV != null) {
                            if (frsViewData.isShowRedTip() && this.fUs.get(i2).tabId == 89) {
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
                        if (this.fxT != null && this.fxT.bmE() != null && frsTabInfo2 != null) {
                            this.fxT.bmE().sE(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.fxT != null && this.fxT.alr() != null) {
                        if (f.size() < 2) {
                            this.fxT.alr().removeHeaderView(this.fPF);
                        } else {
                            this.fxT.alr().removeHeaderView(this.fPF);
                            this.fxT.alr().addHeaderView(this.fPF);
                            if (this.fUw != null && frsViewData.getForum() != null) {
                                this.fUw.setData(f, i);
                                this.fUw.setFid(frsViewData.getForum().getId());
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.fUs = tabData;
                    btN();
                    cm(arrayList);
                }
            }
        }
    }

    private void btN() {
        int i = -1;
        if (!v.aa(this.fUs)) {
            i = this.fUs.get(0).tabId;
        }
        if (this.fUt != null) {
            this.fUt.mHeadLineDefaultNavTabId = i;
        }
        if (this.fxT != null) {
            this.fxT.mHeadLineDefaultNavTabId = i;
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
        if (!v.aa(this.fUu.mFragments) && tabData.size() == this.fUu.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.fUu.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.fUu.mFragments.get(i)).tabId) {
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
    public boolean te(int i) {
        if (i < 0 || this.fUs == null || this.fUs.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.fUs.size()) {
                i2 = -1;
                break;
            } else if (this.fUs.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.fUl.getTabCount()) {
            return false;
        }
        TbTabLayout.e aV = this.fUl.aV(i2);
        if (aV != null && !aV.isSelected()) {
            aV.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d tf(int i) {
        if (i < 0 || this.fUs == null || this.fUs.size() <= 0) {
            return null;
        }
        Iterator it = this.fUs.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        SvgManager.ajv().a(R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
        am.k(this.fUn, R.drawable.frs_tab_fading_edge);
        am.k(this.drb, R.drawable.personalize_tab_shadow);
        btV();
        if (this.fUl != null) {
            this.fUl.setSelectedTabIndicatorColor(0);
            this.fUl.setBackgroundColor(0);
            this.fUl.setTabTextColors(am.getColor(R.color.cp_cont_j), am.getColor(R.color.cp_cont_b));
        }
        if (this.fUw != null && !isBrandForum()) {
            this.fUw.onChangeSkinType();
        }
        if (this.fUo != null) {
            this.fUo.onChangeSkinType();
        }
        if (this.fUr != null) {
            this.fUr.changeSkinType(i);
        }
        if (!v.aa(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void tg(int i) {
        this.fUy = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.fUs != null && position >= 0 && position < this.fUs.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.fUs.get(position);
            if (dVar != null) {
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kc()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
                if (com.baidu.adp.lib.util.j.jQ() && dVar.tabId == 89 && this.fUt != null && this.fUt.isShowRedTip()) {
                    this.fUt.setIsShowRedTip(false);
                    eVar.g(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.fxT.bno() != null) {
                        this.fxT.bno().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.fxT.bno() != null) {
                    this.fxT.bno().setIconFade(0);
                }
                if (this.fUx != null) {
                    this.fUx.kE(dVar.tabId);
                }
                com.baidu.tieba.frs.a.blQ().jM(dVar.tabId == 301);
                TiebaStatic.log(new an("c12398").bT("fid", this.fxT.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        btT();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.fUs != null && position >= 0 && position < this.fUs.size() && (dVar = this.fUs.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new an("c12398").bT("fid", this.fxT.forumId).P(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
                if (com.baidu.adp.lib.util.j.jQ() && dVar.tabId == 89 && this.fUt != null && this.fUt.isShowRedTip()) {
                    this.fUt.setIsShowRedTip(false);
                    eVar.g(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (v.aa(tabData)) {
            return false;
        }
        return (!v.aa(this.fUs) && tabData.size() == this.fUs.size() && this.fUs.containsAll(tabData)) ? false : true;
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
                    return frsTabInfo.tab_type.intValue() == 11 && !sP(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void df(String str, String str2) {
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
                public com.baidu.tbadk.mainTab.c auf() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.fxT != null && FrsTabViewController.this.fxT.bmJ() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.fxT.bmJ().boa());
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("forum_id", FrsTabViewController.this.fxT.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    frsAllThreadFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cyG = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.cyM = com.baidu.tbadk.mainTab.c.cyJ;
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
                public com.baidu.tbadk.mainTab.c auf() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fxT.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fxT.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fxT.getForumId());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cyG = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.cyM = com.baidu.tbadk.mainTab.c.cyJ;
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
                public com.baidu.tbadk.mainTab.c auf() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fxT.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fxT.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.fxT.getForumId());
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cyG = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.cyM = com.baidu.tbadk.mainTab.c.cyJ;
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
                public com.baidu.tbadk.mainTab.c auf() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fxT.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fxT.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fxT.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cyG = frsADFragment;
                    cVar.type = 90;
                    cVar.cyM = com.baidu.tbadk.mainTab.c.cyJ;
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
                public com.baidu.tbadk.mainTab.c auf() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.fxT.getForumName());
                    bundle.putString("from", FrsTabViewController.this.fxT.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.fxT.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.fUt.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.fUt.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.fUt.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.fUt);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.cyG = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.cyM = com.baidu.tbadk.mainTab.c.cyJ;
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
            this.fUv = new com.baidu.tieba.frs.e(this.fxT.getActivity().getApplicationContext(), list);
            this.fUv.setForumId(this.fxT.getForumId());
            this.fUv.setForumName(this.fxT.getForumName());
            if (this.fUt != null && this.fUt.getForum() != null) {
                this.fUv.mJ(this.fUt.getForum().getFirst_class());
                this.fUv.mK(this.fUt.getForum().getSecond_class());
                this.fUv.setForumGameLabel(this.fUt.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    bu(frsTabInfo.tab_id.intValue(), 1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.fUv.b(c);
                }
            }
            this.fUA = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.fUv));
        }
    }

    private void bu(int i, int i2) {
        an anVar = new an("c13008");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT("fid", this.fxT.getForumId());
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
        anVar.ajq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btO() {
        int i;
        if (this.fUv != null) {
            List<com.baidu.tbadk.mainTab.b> bmq = this.fUv.bmq();
            if (!v.aa(bmq) && !v.aa(this.fUs)) {
                if (this.fUl.getTabCount() > 0) {
                    this.fUl.removeAllTabs();
                }
                btP();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.fUs.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment g = g(dVar.tabId, bmq);
                    if (g != null) {
                        TbTabLayout.e b2 = this.fUl.oQ().b(dVar.name);
                        boolean z = this.fUt.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.fUt != null && this.fUt.isShowRedTip() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.fUl.a(b2, z);
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
                if (this.fUl.getTabCount() > 0 && this.fUj.getVisibility() != 0) {
                    this.fUj.setVisibility(0);
                }
                this.fUu = new FragmentAdapter(this.fxT.getActivity().getSupportFragmentManager(), this.mFragments);
                this.fUm.setAdapter(this.fUu);
                this.fUu.notifyDataSetChanged();
                this.fUl.setupWithViewPager(this.fUm);
                this.fUm.setOffscreenPageLimit(this.mFragments.size());
                this.fUm.setCurrentItem(i3, false);
                this.fUm.boA();
            }
        }
    }

    private void btP() {
        if (this.fUm != null && this.fUu != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.fxT.getActivity().getSupportFragmentManager();
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
            if (i == bVar.aug().type) {
                return bVar.aug().cyG;
            }
        }
        return null;
    }

    public View btQ() {
        if (isBrandForum() || this.fUw == null) {
            return null;
        }
        return this.fUw.bqk();
    }

    public static boolean sP(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.fUx = aVar;
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
                        FrsTabViewController.this.fxT.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.fxT.setPrimary(true);
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

    public b btR() {
        if (this.fUm == null) {
            return null;
        }
        return (b) v.c(this.mFragments, this.fUm.getCurrentItem());
    }

    public void btS() {
        this.fUz.cJ(this.fxT.getString(R.string.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void btT() {
        this.fUz.bcf();
    }

    @Override // com.baidu.tieba.frs.vc.k
    public void th(int i) {
        this.fyN = i;
        btV();
    }

    public int btU() {
        return this.fyN;
    }

    private void btV() {
        if (this.fyN == 2) {
            am.l(this.fUj, R.color.cp_bg_line_h);
            am.l(this.fUk, R.color.cp_bg_line_h);
            this.drb.setVisibility(0);
            this.fxT.bni();
        } else if (this.fyN == 1) {
            am.l(this.fUj, R.color.cp_bg_line_e);
            am.l(this.fUk, R.color.cp_bg_line_h);
            this.drb.setVisibility(0);
        } else {
            if (this.fxT != null && this.fxT.bmO()) {
                am.l(this.fUj, R.color.transparent);
            } else {
                am.l(this.fUj, R.color.cp_bg_line_c);
            }
            am.k(this.fUk, R.drawable.top_corners_bg);
            this.drb.setVisibility(8);
            this.fxT.bnh();
        }
    }
}
