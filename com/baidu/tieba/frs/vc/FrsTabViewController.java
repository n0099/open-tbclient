package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PublishProgressView;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.z;
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
/* loaded from: classes2.dex */
public class FrsTabViewController implements TbTabLayout.b, n {
    private View gEA;
    private TbTabLayout ghk;
    private FrsViewData jFx;
    private FragmentAdapter jKA;
    private com.baidu.tieba.frs.g jKB;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b jKC;
    private a jKD;
    private PublishProgressView jKE;
    private com.baidu.tieba.c.e jKG;
    private int jKJ;
    private RelativeLayout jKv;
    private View jKw;
    private FrsTabViewPager jKx;
    private LinearGradientView jKy;
    private TabData jKz;
    private FrsFragment jhE;
    private RelativeLayout joq;
    private List<b> mFragments;
    private ThemeColorInfo mThemeColorInfo;
    private int jiz = 0;
    private int jKF = -1;
    private boolean jKH = false;
    public boolean jKI = true;
    private boolean jKK = false;
    private boolean jKL = false;
    CustomMessageListener jKM = new CustomMessageListener(CmdConfigCustom.CMD_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.g) && !FrsTabViewController.this.jKH) {
                FrsTabViewController.this.cOo();
                FrsTabViewController.this.jKH = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.jKx != null) {
                FrsTabViewController.this.jKx.cHg();
                if (!x.isEmpty(FrsTabViewController.this.mFragments) && FrsTabViewController.this.mFragments.size() > i) {
                    b bVar = (b) x.getItem(FrsTabViewController.this.mFragments, i);
                    if (bVar.fragment instanceof aq) {
                        z zVar = new z();
                        zVar.tabId = bVar.tabId;
                        zVar.jjv = (aq) bVar.fragment;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar));
                        return;
                    }
                    z zVar2 = new z();
                    zVar2.tabId = bVar.tabId;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921448, zVar2));
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener jKN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    boolean booleanValue = ((Boolean) data).booleanValue();
                    if (FrsTabViewController.this.jFx != null && FrsTabViewController.this.jFx.isShowRedTip() != booleanValue && FrsTabViewController.this.ghk.getTabCount() > 0 && !x.isEmpty(FrsTabViewController.this.jKz)) {
                        FrsTabViewController.this.jFx.setIsShowRedTip(booleanValue);
                        int min = Math.min(FrsTabViewController.this.jKz.size(), FrsTabViewController.this.ghk.getTabCount());
                        for (int i = 0; i < min; i++) {
                            TbTabLayout.e aZ = FrsTabViewController.this.ghk.aZ(i);
                            if (aZ != null) {
                                if (FrsTabViewController.this.jKz.get(i).tabId == 89) {
                                    aZ.l(0, booleanValue);
                                } else {
                                    aZ.l(0, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gIn = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b cOr;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (cOr = FrsTabViewController.this.cOr()) != null && cOr.fragment != null && (cOr.fragment instanceof ao)) {
                        ((ao) cOr.fragment).bVF();
                    }
                }
            }
        }
    };
    private final CustomMessageListener jKO = new CustomMessageListener(2921526) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof bg)) {
                bg bgVar = (bg) customResponsedMessage.getData();
                if (FrsTabViewController.this.jhE != null && bgVar.AT(FrsTabViewController.this.jhE.getForumId()) && FrsTabViewController.this.jKE != null) {
                    FrsTabViewController.this.jKE.b(bgVar);
                }
            }
        }
    };
    private CustomMessageListener jKP = new CustomMessageListener(2921384) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921384) {
                int i2 = 0;
                Iterator it = FrsTabViewController.this.jKz.iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext() || ((com.baidu.tieba.frs.tab.d) it.next()).tabId == 301) {
                        break;
                    }
                    i2 = i + 1;
                }
                if (i <= FrsTabViewController.this.jKz.size()) {
                    FrsTabViewController.this.jKx.setCurrentItem(i, true);
                }
            }
        }
    };
    private CustomMessageListener jKQ = new CustomMessageListener(2921488) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921488) {
                Iterator it = FrsTabViewController.this.jKz.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((com.baidu.tieba.frs.tab.d) it.next()).tabType == 3) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (i <= FrsTabViewController.this.jKz.size() && z) {
                    FrsTabViewController.this.jKx.setCurrentItem(i, true);
                }
            }
        }
    };
    private View.OnClickListener jKR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.jKG.VL();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void m(int i, int i2, String str);
    }

    public void ry(boolean z) {
        this.ghk.setDisableTabSelect(z);
    }

    public FrsTabViewPager cOi() {
        return this.jKx;
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.jhE = frsFragment;
        this.jKv = (RelativeLayout) view.findViewById(R.id.frs_tab_view_container);
        this.jKw = view.findViewById(R.id.frs_tab_bg);
        this.gEA = view.findViewById(R.id.divider_shadow);
        this.jKy = (LinearGradientView) view.findViewById(R.id.frs_tab_linear_bg);
        this.ghk = (TbTabLayout) view.findViewById(R.id.frs_tab_layout);
        this.ghk.setOnTabSelectedListener(this);
        this.ghk.setSelectedTabTextBlod(true);
        this.ghk.setTabTextSize(Ca(R.dimen.tbds42));
        this.jKG = new com.baidu.tieba.c.e(frsFragment.getPageContext(), this.ghk);
        this.jKG.fP(R.drawable.bg_tip_blue_up_left);
        this.jKG.fO(16);
        this.jKG.setUseDirectOffset(true);
        this.jKG.yH(Ca(R.dimen.tbds34));
        this.jKG.setYOffset(Ca(R.dimen.tbds10));
        this.jKG.e(this.jKR);
        this.jKx = (FrsTabViewPager) view.findViewById(R.id.frs_viewpager);
        this.mFragments = new ArrayList();
        this.jKA = new FragmentAdapter(this.jhE.getActivity().getSupportFragmentManager(), this.mFragments);
        this.jKx.addOnPageChangeListener(this.mOnPageChangeListener);
        this.joq = new RelativeLayout(this.jhE.getContext());
        this.jKC = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.b(frsFragment, this.joq);
        this.jKE = (PublishProgressView) view.findViewById(R.id.publish_progress_view);
        this.jKE.setVisibility(8);
    }

    private int Ca(int i) {
        return com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), i);
    }

    public RelativeLayout cOj() {
        return this.joq;
    }

    public View cOk() {
        return this.jKy;
    }

    private boolean isBrandForum() {
        return this.jFx != null && this.jFx.getIsBrandForum();
    }

    public void registerListener() {
        this.jKM.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.jhE.registerListener(this.jKM);
        this.jhE.registerListener(this.jKN);
        this.jhE.registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gIn, this.jhE.getBaseFragmentActivity().getUniqueId());
        this.jhE.registerListener(this.jKP);
        this.jhE.registerListener(this.jKQ);
        this.jhE.registerListener(this.jKO);
    }

    public boolean cOl() {
        return this.jKE != null && this.jKE.getVisibility() == 0;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void a(FrsViewData frsViewData, int i) {
        AccountData currentAccountObj;
        String str;
        String str2;
        boolean z;
        if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null && frsViewData.getEntelechyTabInfo().tab != null) {
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    if (frsTabInfo.is_general_tab.intValue() == 1 || frsTabInfo.tab_type.intValue() == 16) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.name = frsTabInfo.tab_name;
                        dVar.tabId = frsTabInfo.tab_id.intValue();
                        dVar.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 89 || frsTabInfo.tab_id.intValue() == 503) {
                        com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                        dVar2.tabId = frsTabInfo.tab_id.intValue();
                        dVar2.name = frsTabInfo.tab_name;
                        dVar2.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar2);
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
                            int LF = com.baidu.tieba.frs.d.j.LF("503~" + str + str2);
                            if (LF == -1) {
                                Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().menu.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        FrsTabInfo next = it.next();
                                        if (next.tab_type == frsTabInfo.tab_type) {
                                            com.baidu.tieba.frs.d.j.ba("503~" + str + str2, next.tab_id.intValue());
                                            if (7 == LF) {
                                                com.baidu.tieba.tbadkCore.util.e.dQs();
                                            } else {
                                                com.baidu.tieba.tbadkCore.util.e.dQt();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 12) {
                        com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                        dVar3.tabId = frsTabInfo.tab_id.intValue();
                        dVar3.name = frsTabInfo.tab_name;
                        dVar3.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar3);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                            dVar4.tabId = frsTabInfo.tab_id.intValue();
                            dVar4.name = frsTabInfo.tab_name;
                            dVar4.tabType = frsTabInfo.tab_type.intValue();
                            StringBuilder sb = new StringBuilder();
                            String lowerCase = frsTabInfo.tab_url.toLowerCase();
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) && !lowerCase.contains("://")) {
                                sb.append("http://");
                            }
                            sb.append(frsTabInfo.tab_url);
                            sb.append(ETAG.ITEM_SEPARATOR);
                            sb.append("fid");
                            sb.append("=");
                            sb.append(frsViewData.getForum().getId());
                            dVar4.url = sb.toString();
                            fn(dVar4.url, "c10078");
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && BJ(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        dVar5.url = frsTabInfo.tab_url;
                        dVar5.tabType = frsTabInfo.tab_type.intValue();
                        if (com.baidu.tbadk.browser.c.Av(dVar5.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                tabData.add(dVar5);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar5);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && af.cHf().Aw(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar6 = new com.baidu.tieba.frs.tab.d();
                        dVar6.tabId = frsTabInfo.tab_id.intValue();
                        dVar6.name = frsTabInfo.tab_name;
                        dVar6.tabType = frsTabInfo.tab_type.intValue();
                        ad At = ac.cHe().At(dVar6.tabId);
                        if (At != null && At.jjK != null && At.jjK.size() > 0) {
                            dVar6.jGV = new bd();
                            dVar6.jGV.jjJ = At.jjJ;
                            dVar6.jGV.jjK = new LinkedList();
                            boolean z2 = true;
                            for (ab abVar : At.jjK) {
                                if (abVar != null) {
                                    bc bcVar = new bc();
                                    bcVar.name = abVar.name;
                                    bcVar.jjG = abVar.jjG;
                                    if (z2) {
                                        bcVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar6.jGV.jjK.add(bcVar);
                                    z2 = z;
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                        dVar7.tabId = frsTabInfo.tab_id.intValue();
                        dVar7.name = frsTabInfo.tab_name;
                        dVar7.tabType = frsTabInfo.tab_type.intValue();
                        ad At2 = ac.cHe().At(dVar7.tabId);
                        if (At2 != null && At2.jjK != null && At2.jjK.size() > 0) {
                            dVar7.jGV = new bd();
                            dVar7.jGV.jjJ = At2.jjJ;
                            dVar7.jGV.jjK = new LinkedList();
                            for (ab abVar2 : At2.jjK) {
                                if (abVar2 != null) {
                                    bc bcVar2 = new bc();
                                    bcVar2.name = abVar2.name;
                                    bcVar2.jjG = abVar2.jjG;
                                    dVar7.jGV.jjK.add(bcVar2);
                                }
                            }
                        }
                        tabData.add(dVar7);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.jhE.cFa().cGA().r(bz.eTk)) {
                            com.baidu.tieba.frs.tab.d dVar8 = new com.baidu.tieba.frs.tab.d();
                            dVar8.name = frsTabInfo.tab_name;
                            if (frsViewData.getAlaLiveCount() != 0 && frsViewData.getAlaLiveCount() <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + frsViewData.getAlaLiveCount() + ")";
                            }
                            if (this.jKF > 0 && this.jKF != frsViewData.getAlaLiveCount() && this.jKF <= 99) {
                                dVar8.name = frsTabInfo.tab_name + "(" + this.jKF + ")";
                            } else if (this.jKF > 99 || frsViewData.getAlaLiveCount() > 99) {
                                dVar8.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.jKF == 0 && this.jKF != frsViewData.getAlaLiveCount()) {
                                dVar8.name = frsTabInfo.tab_name;
                            }
                            dVar8.tabId = frsTabInfo.tab_id.intValue();
                            dVar8.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar8);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1121) {
                        if (com.baidu.tbadk.core.sharedPref.b.bvr().getInt("chushou_game_tab", 1) == 1) {
                            com.baidu.tieba.frs.tab.d dVar9 = new com.baidu.tieba.frs.tab.d();
                            dVar9.tabId = frsTabInfo.tab_id.intValue();
                            dVar9.name = frsTabInfo.tab_name;
                            dVar9.tabType = frsTabInfo.tab_type.intValue();
                            tabData.add(dVar9);
                            arrayList.add(frsTabInfo);
                            Cb(2);
                        }
                    } else if (frsTabInfo.tab_id.intValue() == 1120) {
                        com.baidu.tieba.frs.tab.d dVar10 = new com.baidu.tieba.frs.tab.d();
                        dVar10.tabId = frsTabInfo.tab_id.intValue();
                        dVar10.name = frsTabInfo.tab_name;
                        dVar10.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar10);
                        arrayList.add(frsTabInfo);
                        Cb(2);
                    } else if (frsTabInfo.tab_id.intValue() == 90) {
                        com.baidu.tieba.frs.tab.d dVar11 = new com.baidu.tieba.frs.tab.d();
                        dVar11.tabId = frsTabInfo.tab_id.intValue();
                        dVar11.name = frsTabInfo.tab_name;
                        dVar11.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar11);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 91) {
                        com.baidu.tieba.frs.tab.d dVar12 = new com.baidu.tieba.frs.tab.d();
                        dVar12.tabId = frsTabInfo.tab_id.intValue();
                        dVar12.name = at.cutChineseAndEnglishWithSuffix(frsTabInfo.tab_name, 8, null);
                        dVar12.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar12);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 504) {
                        com.baidu.tieba.frs.tab.d dVar13 = new com.baidu.tieba.frs.tab.d();
                        dVar13.tabId = frsTabInfo.tab_id.intValue();
                        dVar13.name = frsTabInfo.tab_name;
                        dVar13.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar13);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_type.intValue() == 3) {
                        com.baidu.tieba.frs.tab.d dVar14 = new com.baidu.tieba.frs.tab.d();
                        dVar14.tabId = frsTabInfo.tab_id.intValue();
                        dVar14.name = frsTabInfo.tab_name;
                        dVar14.tabType = frsTabInfo.tab_type.intValue();
                        tabData.add(dVar14);
                        arrayList.add(frsTabInfo);
                        Cb(1);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.jFx = frsViewData;
                if (this.jFx.getForum() != null) {
                    this.mThemeColorInfo = this.jFx.getForum().getThemeColorInfo();
                }
                if (!c(tabData) && this.ghk.getTabCount() > 0 && !x.isEmpty(this.jKz)) {
                    int min = Math.min(this.jKz.size(), this.ghk.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e aZ = this.ghk.aZ(i2);
                        if (aZ != null) {
                            if (frsViewData.isShowRedTip() && this.jKz.get(i2).tabId == 89) {
                                aZ.l(0, true);
                            } else {
                                aZ.l(0, false);
                            }
                        }
                    }
                }
                if (frsViewData.getEntelechyTabInfo() != null) {
                    List<FrsTabInfo> f = f(frsViewData);
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) x.getItem(f, 0);
                        if (this.jhE != null && this.jhE.cEV() != null && frsTabInfo2 != null) {
                            this.jhE.cEV().By(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.jhE != null && this.jhE.getListView() != null) {
                        if (f != null && f.size() < 2) {
                            this.jhE.getListView().removeHeaderView(this.joq);
                        } else {
                            this.jhE.getListView().removeHeaderView(this.joq);
                            this.jhE.getListView().addHeaderView(this.joq);
                            if (this.jKC != null && frsViewData.getForum() != null) {
                                this.jKC.setData(f);
                                this.jKC.setFid(frsViewData.getForum().getId());
                                this.jKC.ki(this.jhE.cEV().cMk());
                                if (com.baidu.tbadk.a.d.bmZ() && com.baidu.tbadk.a.b.a.eIU != com.baidu.tbadk.a.b.a.bnj()) {
                                    this.jKC.ki(com.baidu.tbadk.a.b.a.bnj());
                                }
                            }
                        }
                    }
                }
                if (a(tabData)) {
                    this.jKz = tabData;
                    cOm();
                    dJ(arrayList);
                }
            }
        }
    }

    private void Cb(int i) {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13971").dX("fid", this.jhE.forumId).dX("fname", this.jhE.getForumName()).an("obj_locate", i));
    }

    private void cOm() {
        int i = -1;
        if (!x.isEmpty(this.jKz)) {
            i = this.jKz.get(0).tabId;
        }
        if (this.jFx != null) {
            this.jFx.mHeadLineDefaultNavTabId = i;
        }
        if (this.jhE != null) {
            this.jhE.mHeadLineDefaultNavTabId = i;
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
        if (x.isEmpty(tabData)) {
            return false;
        }
        b(tabData);
        if (!x.isEmpty(this.jKA.mFragments) && tabData.size() == this.jKA.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.jKA.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.jKA.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private void b(TabData tabData) {
        if (!x.isEmpty(tabData)) {
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

    public int cOn() {
        Iterator it = this.jKz.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar != null && (dVar.tabId == 1 || dVar.tabId == 503)) {
                return dVar.tabId;
            }
        }
        return 0;
    }

    public b Cc(int i) {
        for (b bVar : this.mFragments) {
            if (bVar != null && bVar.tabId == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.vc.n
    public boolean uu(int i) {
        if (i < 0 || this.jKz == null || this.jKz.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.jKz.size()) {
                i2 = -1;
                break;
            } else if (this.jKz.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.ghk.getTabCount()) {
            return false;
        }
        TbTabLayout.e aZ = this.ghk.aZ(i2);
        if (aZ != null && !aZ.isSelected()) {
            aZ.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d Cd(int i) {
        if (i < 0 || this.jKz == null || this.jKz.size() <= 0) {
            return null;
        }
        Iterator it = this.jKz.iterator();
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
        com.baidu.tbadk.core.util.ao.setBackgroundResource(this.gEA, R.drawable.personalize_tab_shadow);
        cOw();
        if (this.ghk != null) {
            if (this.mThemeColorInfo != null) {
                if (this.mThemeColorInfo.dark != null && i == 4) {
                    color = com.baidu.tieba.lego.card.c.b.sF(this.mThemeColorInfo.dark.font_color);
                } else if (this.mThemeColorInfo.night != null && i == 1) {
                    color = com.baidu.tieba.lego.card.c.b.sF(this.mThemeColorInfo.night.font_color);
                } else if (this.mThemeColorInfo.day != null && i == 0) {
                    color = com.baidu.tieba.lego.card.c.b.sF(this.mThemeColorInfo.day.font_color);
                } else {
                    color = com.baidu.tbadk.core.util.ao.getColor(R.color.plugin_button_shadow_red);
                }
            } else {
                color = com.baidu.tbadk.core.util.ao.getColor(R.color.plugin_button_shadow_red);
            }
            this.ghk.setSelectedTabIndicatorColor(color);
            this.ghk.setSelectedIndicatorBottomMargin(Ca(R.dimen.tbds11));
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.ghk, R.color.transparent);
            this.ghk.setTabTextColors(com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0107), com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0105));
        }
        if (this.jKC != null && !isBrandForum()) {
            this.jKC.onChangeSkinType();
        }
        if (this.jKy != null) {
            this.jKy.changeSkinType(i);
        }
        if (!x.isEmpty(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void Ce(int i) {
        this.jKF = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        int position = eVar.getPosition();
        if (this.jKz != null && position >= 0 && position < this.jKz.size()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921397, 0));
            com.baidu.tieba.frs.tab.d dVar = this.jKz.get(position);
            if (dVar != null) {
                this.jKJ = dVar.tabId;
                if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jFx != null && this.jFx.isShowRedTip()) {
                    this.jFx.setIsShowRedTip(false);
                    eVar.l(0, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SELECTED, Integer.valueOf(dVar.tabId)));
                }
                if (dVar.tabId == 502) {
                    if (this.jhE.cFM() != null) {
                        this.jhE.cFM().setIconFade(R.drawable.btn_frs_professional_edit_n);
                    }
                } else if (this.jhE.cFM() != null) {
                    this.jhE.cFM().setIconFade(0);
                }
                if (com.baidu.tbadk.a.d.bmX()) {
                    com.baidu.tbadk.a.b.a.An(dVar.name);
                }
                if (this.jKD != null) {
                    this.jKD.m(dVar.tabId, dVar.tabType, dVar.name);
                }
                com.baidu.tieba.frs.b.cDY().ql(dVar.tabId == 503);
                com.baidu.tieba.frs.a.cDR().zO(dVar.tabId);
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12398").dX("fid", this.jhE.forumId).an("tab_id", dVar.tabId));
            }
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        cOt();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        if (eVar != null) {
            int position = eVar.getPosition();
            if (this.jKz != null && position >= 0 && position < this.jKz.size() && (dVar = this.jKz.get(position)) != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_CLICK, Integer.valueOf(dVar.tabId)));
                TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c12398").dX("fid", this.jhE.forumId).an("tab_id", dVar.tabId));
                if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately() && dVar.tabId == 89 && this.jFx != null && this.jFx.isShowRedTip()) {
                    this.jFx.setIsShowRedTip(false);
                    eVar.l(0, false);
                }
            }
        }
    }

    private boolean c(TabData tabData) {
        if (x.isEmpty(tabData)) {
            return false;
        }
        return (!x.isEmpty(this.jKz) && tabData.size() == this.jKz.size() && this.jKz.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91 || frsTabInfo.tab_type.intValue() == 13 || frsTabInfo.tab_type.intValue() == 14 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 92 || frsTabInfo.tab_type.intValue() == 3) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !BJ(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void fn(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq(str2);
                    aqVar.dX("obj_type", host);
                    TiebaStatic.log(aqVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    private com.baidu.tbadk.mainTab.b c(final FrsTabInfo frsTabInfo) {
        final int intValue = frsTabInfo.tab_id.intValue();
        if (intValue == 1) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.jhE != null && FrsTabViewController.this.jhE.cFa() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.jhE.cFa().cGB());
                        FrsTabViewController.this.jhE.qu(com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jFx.showAdsense.intValue()));
                    }
                    Bundle bundle = new Bundle();
                    if (FrsTabViewController.this.jhE != null) {
                        bundle.putString("forum_id", FrsTabViewController.this.jhE.getForumId());
                    }
                    bundle.putInt("tab_id", intValue);
                    bundle.putBoolean("isAdded", false);
                    frsAllThreadFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 301) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.11
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jFx.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jhE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jhE.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.jhE.getForumId());
                    bundle.putBoolean("isAdded", false);
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 503) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.12
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsNewAreaFragment frsNewAreaFragment = new FrsNewAreaFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jFx.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jhE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jhE.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    bundle.putString("forum_id", FrsTabViewController.this.jhE.getForumId());
                    bundle.putBoolean("isAdded", false);
                    frsNewAreaFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsNewAreaFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 90) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.13
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.jhE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jhE.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.jhE.getForumId());
                    bundle.putBoolean("isAdded", false);
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsADFragment;
                    cVar.type = 90;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            };
        }
        if (frsTabInfo.tab_type.intValue() == 91 || intValue == 89 || intValue == 504 || frsTabInfo.tab_type.intValue() == 15 || frsTabInfo.tab_type.intValue() == 16 || frsTabInfo.tab_type.intValue() == 3) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(FrsActivityConfig.FLAG_SHOW_AD, com.baidu.tieba.funad.a.a(frsTabInfo, FrsTabViewController.this.jFx.showAdsense.intValue()));
                    bundle.putString("name", FrsTabViewController.this.jhE.getForumName());
                    bundle.putString("from", FrsTabViewController.this.jhE.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.jhE.getForumId());
                    bundle.putInt("tab_id", intValue);
                    bundle.putInt("tab_type", frsTabInfo.tab_type.intValue());
                    bundle.putString("tab_name", frsTabInfo.tab_name);
                    bundle.putInt("is_general_tab", frsTabInfo.is_general_tab.intValue());
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.jFx.isFrsVideoAutoPlay);
                    bundle.putBoolean("need_log", FrsTabViewController.this.jFx.needLog == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.jFx.isBrandForum);
                    bundle.putSerializable("view_data", FrsTabViewController.this.jFx);
                    bundle.putBoolean("isAdded", false);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.frag = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator getTabIndicator(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void dJ(List<FrsTabInfo> list) {
        if (!x.isEmpty(list)) {
            this.jKB = new com.baidu.tieba.frs.g(this.jhE.getActivity().getApplicationContext(), list);
            this.jKB.setForumId(this.jhE.getForumId());
            this.jKB.setForumName(this.jhE.getForumName());
            this.jKB.setFrom(this.jhE.getFrom());
            if (this.jFx != null && this.jFx.getForum() != null) {
                this.jKB.Bh(this.jFx.getForum().getFirst_class());
                this.jKB.Bi(this.jFx.getForum().getSecond_class());
                this.jKB.setForumGameLabel(this.jFx.getForum().getForumGameLabel());
            }
            int i = 0;
            for (FrsTabInfo frsTabInfo : list) {
                if (i == 0) {
                    cs(frsTabInfo.tab_id.intValue(), 1);
                }
                if (frsTabInfo.tab_type.intValue() == 3) {
                    Cb(1);
                }
                i++;
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.jKB.b(c);
                }
            }
            this.jKH = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_TAB, this.jKB));
        }
    }

    private void cs(int i, int i2) {
        com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13008");
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dX("fid", this.jhE.getForumId());
        if (i == 89) {
            aqVar.an("obj_type", 1);
        } else if (i == 502) {
            aqVar.an("obj_type", 8);
        } else if (i == 90) {
            aqVar.an("obj_type", 9);
        } else if (i == 1) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                aqVar.an("obj_type", 4);
            } else {
                aqVar.an("obj_type", 5);
            }
        } else if (i == 404) {
            aqVar.an("obj_type", 2);
        } else if (i == 301) {
            aqVar.an("obj_type", 7);
        } else if (i == 503) {
            aqVar.an("obj_type", 6);
        } else if (i == 504) {
            aqVar.an("obj_type", 11);
        }
        aqVar.an("obj_locate", i2);
        aqVar.bwo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOo() {
        int color;
        int i;
        if (this.jKB != null) {
            List<com.baidu.tbadk.mainTab.b> cEE = this.jKB.cEE();
            if (!x.isEmpty(cEE) && !x.isEmpty(this.jKz)) {
                if (this.ghk.getTabCount() > 0) {
                    this.ghk.removeAllTabs();
                }
                cOp();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.mThemeColorInfo != null) {
                    if (this.mThemeColorInfo.dark != null && skinType == 4) {
                        color = com.baidu.tieba.lego.card.c.b.sF(this.mThemeColorInfo.dark.font_color);
                    } else if (this.mThemeColorInfo.night != null && skinType == 1) {
                        color = com.baidu.tieba.lego.card.c.b.sF(this.mThemeColorInfo.night.font_color);
                    } else if (this.mThemeColorInfo.day != null && skinType == 0) {
                        color = com.baidu.tieba.lego.card.c.b.sF(this.mThemeColorInfo.day.font_color);
                    } else {
                        color = com.baidu.tbadk.core.util.ao.getColor(R.color.plugin_button_shadow_red);
                    }
                } else {
                    color = com.baidu.tbadk.core.util.ao.getColor(R.color.plugin_button_shadow_red);
                }
                this.ghk.setSelectedTabIndicatorColor(color);
                this.ghk.setSelectedIndicatorBottomMargin(Ca(R.dimen.tbds10));
                Iterator it = this.jKz.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment m = m(dVar.tabId, cEE);
                    if (m != null) {
                        TbTabLayout.e b2 = this.ghk.qN().b(dVar.name);
                        boolean z = this.jFx.defaultShowTab == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (FrsActivityConfig.FROM_PB_OR_PERSON.equals(this.jhE.getFrom()) && 3 == dVar.tabType) {
                            i3 = i2;
                        }
                        if (this.jFx != null && this.jFx.isShowRedTip() && dVar.tabId == 89) {
                            b2.l(0, true);
                        } else {
                            b2.l(0, false);
                        }
                        this.ghk.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = m;
                        bVar.tabType = dVar.tabType;
                        this.mFragments.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i2 = i;
                }
                if (this.ghk.getTabCount() > 0 && this.jKv.getVisibility() != 0) {
                    this.jKv.setVisibility(0);
                }
                this.jKA = new FragmentAdapter(this.jhE.getActivity().getSupportFragmentManager(), this.mFragments);
                this.jKx.setAdapter(this.jKA);
                this.jKA.notifyDataSetChanged();
                this.ghk.setupWithViewPager(this.jKx);
                this.jKx.setOffscreenPageLimit(this.mFragments.size());
                this.jKx.setCurrentItem(i3, false);
                this.jKx.cHg();
            }
        }
    }

    private void cOp() {
        if (this.jKx != null && this.jKA != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.jhE.getActivity().getSupportFragmentManager();
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

    private Fragment m(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            Bundle arguments = bVar.getFragmentTabStructure().frag.getArguments();
            if (arguments != null && i == bVar.getFragmentTabStructure().type && !arguments.getBoolean("isAdded")) {
                arguments.putBoolean("isAdded", true);
                bVar.getFragmentTabStructure().frag.setArguments(arguments);
                return bVar.getFragmentTabStructure().frag;
            }
        }
        return null;
    }

    public View cOq() {
        if (isBrandForum() || this.jKC == null) {
            return null;
        }
        return this.jKC.cJj();
    }

    public static boolean BJ(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.jKD = aVar;
    }

    public void ag(boolean z, boolean z2) {
        if (this.jKK != z) {
            this.jKK = z;
        }
        if (this.jKL != z2) {
            this.jKL = z2;
        }
        cOx();
    }

    public void aH(float f) {
    }

    /* loaded from: classes2.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<b> mFragments;
        private int mPrimaryPosition;

        public FragmentAdapter(FragmentManager fragmentManager, List<b> list) {
            super(fragmentManager);
            this.mPrimaryPosition = -1;
            this.mFragments = list;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return this.mFragments.get(i).fragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.mFragments.get(i).title;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null && this.mPrimaryPosition != i) {
                if (this.mPrimaryPosition != -1) {
                    BaseFragment baseFragment = (BaseFragment) getItem(this.mPrimaryPosition);
                    if (baseFragment instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.jhE.setPrimary(false);
                    } else {
                        baseFragment.setPrimary(false);
                    }
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    BaseFragment baseFragment2 = (BaseFragment) obj;
                    if (baseFragment2 instanceof FrsAllThreadFragment) {
                        FrsTabViewController.this.jhE.setPrimary(true);
                    } else {
                        baseFragment2.setPrimary(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public int tabType;
        public String title;

        public b() {
        }
    }

    public b cOr() {
        if (this.jKx == null) {
            return null;
        }
        return (b) x.getItem(this.mFragments, this.jKx.getCurrentItem());
    }

    public void cOs() {
        this.jKG.aK(this.jhE.getString(R.string.click_here_to_refresh), SharedPrefConfig.KEY_SHOW_FRS_TAB_CLICK_TO_REFRESH_TIP);
    }

    public void cOt() {
        this.jKG.VL();
    }

    @Override // com.baidu.tieba.frs.vc.n
    public void Cf(int i) {
        this.jiz = i;
        cOw();
    }

    public int cOu() {
        return this.jiz;
    }

    public int cOv() {
        return this.jKJ;
    }

    private void cOw() {
        if (this.jiz == 2) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jKv, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jKw, R.color.CAM_X0207);
            this.gEA.setVisibility(0);
            this.jhE.cFD();
        } else if (this.jiz == 1) {
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jKv, R.color.CAM_X0207);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jKw, R.color.CAM_X0207);
            this.gEA.setVisibility(0);
        } else {
            cOx();
            this.gEA.setVisibility(8);
            if (this.jhE != null) {
                this.jhE.cFD();
            }
        }
    }

    private void cOx() {
        com.baidu.tbadk.core.util.ao.setBackgroundColor(this.jKw, R.color.CAM_X0205);
        this.jKw.setAlpha(0.0f);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jKv).l(new int[]{R.color.CAM_X0202, R.color.CAM_X0204});
    }
}
