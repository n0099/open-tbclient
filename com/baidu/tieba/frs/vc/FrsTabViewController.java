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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ad.FrsADFragment;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.dynamic.FrsDynamicFragment;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.view.ImageOverlayView;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.l;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class FrsTabViewController implements TbTabLayout.b, j {
    private static final String TAG = FrsTabViewController.class.getSimpleName();
    private RelativeLayout dOc;
    private TbTabLayout dOd;
    private RelativeLayout dOe;
    private FrsTabViewPager dOf;
    private View dOg;
    private ImageOverlayView dOh;
    private TbImageView dOi;
    private LinearLayout dOj;
    private TabData dOk;
    private l dOl;
    private FragmentAdapter dOm;
    private com.baidu.tieba.frs.e dOn;
    private com.baidu.tieba.frs.entelechy.c.a.a dOo;
    private a dOp;
    private com.baidu.tieba.c.d dOq;
    private FrsFragment dtN;
    private List<b> mFragments;
    private int csM = -1;
    private boolean dOr = false;
    public boolean dOs = true;
    CustomMessageListener dOt = new CustomMessageListener(2001623) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.frs.e) && !FrsTabViewController.this.dOr) {
                FrsTabViewController.this.aCT();
                FrsTabViewController.this.dOr = true;
            }
        }
    };
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (FrsTabViewController.this.dOf != null) {
                FrsTabViewController.this.dOf.axQ();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private CustomMessageListener dOu = new CustomMessageListener(2001612) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Boolean) && ((Boolean) data).booleanValue() && FrsTabViewController.this.dOd.getTabCount() > 0 && !v.z(FrsTabViewController.this.dOk)) {
                    FrsTabViewController.this.dOl.mL(true);
                    int min = Math.min(FrsTabViewController.this.dOk.size(), FrsTabViewController.this.dOd.getTabCount());
                    for (int i = 0; i < min; i++) {
                        TbTabLayout.e bb = FrsTabViewController.this.dOd.bb(i);
                        if (bb != null) {
                            if (FrsTabViewController.this.dOk.get(i).tabId == 89) {
                                bb.g(0, true);
                            } else {
                                bb.g(0, false);
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bDo = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b aCW;
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2) {
                    String str = split[0];
                    String str2 = split[1];
                    if ("FrsGameLive".equals(str) && 1 == Integer.valueOf(str2).intValue() && (aCW = FrsTabViewController.this.aCW()) != null && aCW.fragment != null && (aCW.fragment instanceof aj)) {
                        ((aj) aCW.fragment).VY();
                    }
                }
            }
        }
    };
    private View.OnClickListener dOv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FrsTabViewController.this.dOq.amz();
        }
    };
    private View.OnClickListener dOw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921363));
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void fk(int i);
    }

    public FrsTabViewController(FrsFragment frsFragment, View view) {
        this.dtN = frsFragment;
        this.dOc = (RelativeLayout) view.findViewById(e.g.frs_tab_view_container);
        this.dOe = new RelativeLayout(this.dtN.getContext());
        this.dOe.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.dOg = view.findViewById(e.g.fading_edge_view);
        this.dOd = (TbTabLayout) view.findViewById(e.g.frs_tab_layout);
        this.dOd.setOnTabSelectedListener(this);
        this.dOh = (ImageOverlayView) view.findViewById(e.g.frs_tab_overlayview);
        this.dOj = (LinearLayout) view.findViewById(e.g.frs_tab_arrow);
        this.dOi = (TbImageView) view.findViewById(e.g.smartapp_arrow);
        this.dOj.setOnClickListener(this.dOw);
        this.dOq = new com.baidu.tieba.c.d(frsFragment.getPageContext(), this.dOd);
        this.dOq.jN(e.f.bg_tip_blue_up_left);
        this.dOq.jM(16);
        this.dOq.M(true);
        this.dOq.jQ(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0141e.tbds34));
        this.dOq.jR(com.baidu.adp.lib.util.l.h(frsFragment.getPageContext().getPageActivity(), e.C0141e.tbds10));
        this.dOq.k(this.dOv);
        this.dOo = new com.baidu.tieba.frs.entelechy.c.a.a(frsFragment, this.dOe);
        this.dOf = (FrsTabViewPager) view.findViewById(e.g.frs_viewpager);
        this.mFragments = new ArrayList();
        this.dOm = new FragmentAdapter(this.dtN.getActivity().getSupportFragmentManager(), this.mFragments);
        this.dOf.setAdapter(this.dOm);
        this.dOf.addOnPageChangeListener(this.mOnPageChangeListener);
        registerListener();
    }

    public void aR(View view) {
        if (isBrandForum()) {
            if ((view instanceof LinearLayout) && this.dOe.getParent() != null) {
                ((LinearLayout) view).removeView(this.dOe);
            }
        } else if ((view instanceof LinearLayout) && this.dOe.getParent() == null) {
            ((LinearLayout) view).addView(this.dOe);
        }
    }

    private boolean isBrandForum() {
        return this.dOl != null && this.dOl.bxG();
    }

    private void registerListener() {
        this.dOt.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dtN.registerListener(this.dOt);
        this.dtN.registerListener(this.dOu);
        this.dtN.registerListener(2001446, this.bDo, this.dtN.getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void a(l lVar, int i) {
        boolean z;
        if (lVar != null && lVar.bxh() != null && lVar.bxh().tab != null) {
            if (lVar != null && !v.z(lVar.gTS)) {
                int size = lVar.gTS.size();
                if (size > 3) {
                    size = 3;
                }
                int h = com.baidu.adp.lib.util.l.h(this.dtN.getPageContext().getPageActivity(), e.C0141e.tbds84);
                this.dOh.h(size, h, h, com.baidu.adp.lib.util.l.h(this.dtN.getPageContext().getPageActivity(), e.C0141e.tbds5), e.d.cp_bg_line_d, com.baidu.adp.lib.util.l.h(this.dtN.getPageContext().getPageActivity(), e.C0141e.tbds19));
                this.dOh.setData(lVar.gTS);
                this.dOh.onChangeSkinType();
                this.dOj.setVisibility(0);
            } else {
                this.dOj.setVisibility(8);
            }
            TabData tabData = new TabData();
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : lVar.bxh().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    if (frsTabInfo.tab_id.intValue() == 89) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.tabId = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        tabData.add(dVar);
                        arrayList.add(frsTabInfo);
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
                            sb.append(ImageViewerConfig.FORUM_ID);
                            sb.append("=");
                            sb.append(lVar.bbH().getId());
                            dVar3.url = sb.toString();
                            bp(dVar3.url, "c10078");
                            tabData.add(dVar3);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && mf(frsTabInfo.tab_id.intValue())) {
                        com.baidu.tieba.frs.tab.d dVar4 = new com.baidu.tieba.frs.tab.d();
                        dVar4.tabId = frsTabInfo.tab_id.intValue();
                        dVar4.name = frsTabInfo.tab_name;
                        dVar4.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.d.dl(dVar4.url)) {
                            if (MessageManager.getInstance().findTask(2016447) != null) {
                                tabData.add(dVar4);
                                arrayList.add(frsTabInfo);
                            }
                        } else {
                            tabData.add(dVar4);
                            arrayList.add(frsTabInfo);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ab.axP().lk(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        com.baidu.tieba.frs.tab.d dVar5 = new com.baidu.tieba.frs.tab.d();
                        dVar5.tabId = frsTabInfo.tab_id.intValue();
                        dVar5.name = frsTabInfo.tab_name;
                        z lh = y.axO().lh(dVar5.tabId);
                        if (lh != null && lh.dvD != null && lh.dvD.size() > 0) {
                            dVar5.dMp = new au();
                            dVar5.dMp.dvC = lh.dvC;
                            dVar5.dMp.dvD = new LinkedList();
                            boolean z2 = true;
                            for (x xVar : lh.dvD) {
                                if (xVar != null) {
                                    at atVar = new at();
                                    atVar.name = xVar.name;
                                    atVar.dvz = xVar.dvz;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar5.dMp.dvD.add(atVar);
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
                        z lh2 = y.axO().lh(dVar6.tabId);
                        if (lh2 != null && lh2.dvD != null && lh2.dvD.size() > 0) {
                            dVar6.dMp = new au();
                            dVar6.dMp.dvC = lh2.dvC;
                            dVar6.dMp.dvD = new LinkedList();
                            for (x xVar2 : lh2.dvD) {
                                if (xVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = xVar2.name;
                                    atVar2.dvz = xVar2.dvz;
                                    dVar6.dMp.dvD.add(atVar2);
                                }
                            }
                        }
                        tabData.add(dVar6);
                        arrayList.add(frsTabInfo);
                    } else if (frsTabInfo.tab_id.intValue() == 49) {
                        if (this.dtN.awe().axm().k(bb.akb)) {
                            com.baidu.tieba.frs.tab.d dVar7 = new com.baidu.tieba.frs.tab.d();
                            dVar7.name = frsTabInfo.tab_name;
                            if (lVar.bwJ() != 0 && lVar.bwJ() <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + lVar.bwJ() + ")";
                            }
                            if (this.csM > 0 && this.csM != lVar.bwJ() && this.csM <= 99) {
                                dVar7.name = frsTabInfo.tab_name + "(" + this.csM + ")";
                            } else if (this.csM > 99 || lVar.bwJ() > 99) {
                                dVar7.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.csM == 0 && this.csM != lVar.bwJ()) {
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
                        dVar9.name = ao.d(frsTabInfo.tab_name, 8, (String) null);
                        tabData.add(dVar9);
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            if (tabData.size() != 0 && arrayList.size() != 0) {
                this.dOl = lVar;
                if (!b(tabData) && this.dOd.getTabCount() > 0 && !v.z(this.dOk)) {
                    int min = Math.min(this.dOk.size(), this.dOd.getTabCount());
                    for (int i2 = 0; i2 < min; i2++) {
                        TbTabLayout.e bb = this.dOd.bb(i2);
                        if (bb != null) {
                            if (lVar.bxi() && this.dOk.get(i2).tabId == 89) {
                                bb.g(0, true);
                            } else {
                                bb.g(0, false);
                            }
                        }
                    }
                }
                if (lVar != null && lVar.bxh() != null) {
                    List<FrsTabInfo> list = lVar.bxh().menu;
                    if (isBrandForum()) {
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) v.d(list, 0);
                        if (this.dtN != null && this.dtN.avZ() != null && frsTabInfo2 != null) {
                            this.dtN.avZ().lV(frsTabInfo2.tab_id.intValue());
                        }
                    } else if (this.dOo != null && lVar.bbH() != null) {
                        this.dOo.setData(list, i);
                        this.dOo.setFid(lVar.bbH().getId());
                    }
                }
                if (a(tabData)) {
                    this.dOk = tabData;
                    bB(arrayList);
                }
            }
        }
    }

    private boolean a(TabData tabData) {
        if (v.z(tabData)) {
            return false;
        }
        if (!v.z(this.dOm.mFragments) && tabData.size() == this.dOm.mFragments.size()) {
            int size = tabData.size();
            for (int i = 0; i < size; i++) {
                if (tabData.get(i) != null && this.dOm.mFragments.get(i) != null && tabData.get(i).tabId != ((b) this.dOm.mFragments.get(i)).tabId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.baidu.tieba.frs.vc.j
    public boolean ms(int i) {
        if (i < 0 || this.dOk == null || this.dOk.size() == 0) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.dOk.size()) {
                i2 = -1;
                break;
            } else if (this.dOk.get(i2).tabId == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= this.dOd.getTabCount()) {
            return false;
        }
        TbTabLayout.e bb = this.dOd.bb(i2);
        if (bb != null && !bb.isSelected()) {
            bb.select();
        }
        return true;
    }

    public com.baidu.tieba.frs.tab.d mt(int i) {
        if (i < 0 || this.dOk == null || this.dOk.size() <= 0) {
            return null;
        }
        Iterator it = this.dOk.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
            if (dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        if (this.dOc != null) {
            al.j(this.dOc, e.d.cp_bg_line_d);
        }
        if (this.dOg != null) {
            al.i(this.dOg, e.f.frs_tab_fading_edge);
        }
        if (this.dOd != null) {
            this.dOd.setSelectedTabIndicatorColor(al.getColor(e.d.cp_cont_f));
            this.dOd.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            this.dOd.setTabTextColors(al.getColor(e.d.cp_cont_j), al.getColor(e.d.cp_cont_b));
        }
        if (this.dOo != null && !isBrandForum()) {
            this.dOo.onChangeSkinType();
        }
        if (this.dOh != null) {
            this.dOh.onChangeSkinType();
        }
        if (this.dOi != null) {
            al.b((ImageView) this.dOi, e.f.icon_arrow12_gray60_right, i);
        }
        if (!v.z(this.mFragments)) {
            for (b bVar : this.mFragments) {
                if (bVar != null && (bVar.fragment instanceof BaseFragment)) {
                    ((BaseFragment) bVar.fragment).changeSkinType(i);
                }
            }
        }
    }

    public void mu(int i) {
        this.csM = i;
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void h(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dOk != null && position >= 0 && position < this.dOk.size() && (dVar = this.dOk.get(position)) != null) {
            if (dVar.tabId != 1 && !com.baidu.adp.lib.util.j.kK()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
            if (com.baidu.adp.lib.util.j.ky() && dVar.tabId == 89 && this.dOl != null && this.dOl.bxi()) {
                this.dOl.mL(false);
                eVar.g(0, false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001625, Integer.valueOf(dVar.tabId)));
            }
            if (this.dOp != null) {
                this.dOp.fk(dVar.tabId);
            }
            TiebaStatic.log(new am("c12398").al(ImageViewerConfig.FORUM_ID, this.dtN.forumId).w(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void i(TbTabLayout.e eVar) {
        aCY();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.b
    public void j(TbTabLayout.e eVar) {
        com.baidu.tieba.frs.tab.d dVar;
        int position = eVar.getPosition();
        if (this.dOk != null && position >= 0 && position < this.dOk.size() && (dVar = this.dOk.get(position)) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001624, Integer.valueOf(dVar.tabId)));
            TiebaStatic.log(new am("c12398").al(ImageViewerConfig.FORUM_ID, this.dtN.forumId).w(MyBookrackActivityConfig.TAB_ID, dVar.tabId));
        }
    }

    private boolean b(TabData tabData) {
        if (v.z(tabData)) {
            return false;
        }
        return (!v.z(this.dOk) && tabData.size() == this.dOk.size() && this.dOk.containsAll(tabData)) ? false : true;
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12 || frsTabInfo.tab_type.intValue() == 91) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !mf(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private void bp(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    am amVar = new am(str2);
                    amVar.al("obj_type", host);
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
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.7
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c KD() {
                    FrsAllThreadFragment frsAllThreadFragment = new FrsAllThreadFragment();
                    if (FrsTabViewController.this.dtN != null && FrsTabViewController.this.dtN.awe() != null) {
                        frsAllThreadFragment.setView(FrsTabViewController.this.dtN.awe().axo());
                    }
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aVa = frsAllThreadFragment;
                    cVar.type = 1;
                    cVar.aVg = com.baidu.tbadk.mainTab.c.aVd;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bJ(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 301 || intValue == 303) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.8
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c KD() {
                    FrsGoodFragment frsGoodFragment = new FrsGoodFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dtN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dtN.getFrom());
                    bundle.putBoolean("back_special", false);
                    bundle.putBoolean(FrsActivityConfig.GOOD, true);
                    bundle.putBoolean(FrsActivityConfig.IS_SELECTION, intValue == 303);
                    bundle.putLong("TibaStatic.StartTime", System.currentTimeMillis());
                    frsGoodFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aVa = frsGoodFragment;
                    cVar.type = intValue;
                    cVar.aVg = com.baidu.tbadk.mainTab.c.aVd;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bJ(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 89) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.9
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c KD() {
                    FrsDynamicFragment frsDynamicFragment = new FrsDynamicFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dtN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dtN.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dtN.getForumId());
                    frsDynamicFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aVa = frsDynamicFragment;
                    cVar.type = 89;
                    cVar.aVg = com.baidu.tbadk.mainTab.c.aVd;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bJ(Context context) {
                    return null;
                }
            };
        }
        if (intValue == 90) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.10
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c KD() {
                    FrsADFragment frsADFragment = new FrsADFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dtN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dtN.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dtN.getForumId());
                    frsADFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aVa = frsADFragment;
                    cVar.type = 90;
                    cVar.aVg = com.baidu.tbadk.mainTab.c.aVd;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bJ(Context context) {
                    return null;
                }
            };
        }
        if (frsTabInfo.tab_type.intValue() == 91) {
            return new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.vc.FrsTabViewController.11
                @Override // com.baidu.tbadk.mainTab.b
                public boolean isAvailable() {
                    return true;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public com.baidu.tbadk.mainTab.c KD() {
                    FrsCommonTabFragment frsCommonTabFragment = new FrsCommonTabFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("name", FrsTabViewController.this.dtN.getForumName());
                    bundle.putString("from", FrsTabViewController.this.dtN.getFrom());
                    bundle.putString("forum_id", FrsTabViewController.this.dtN.getForumId());
                    bundle.putInt(MyBookrackActivityConfig.TAB_ID, intValue);
                    bundle.putBoolean("can_auto_play_video", FrsTabViewController.this.dOl.gTQ);
                    bundle.putBoolean("need_log", FrsTabViewController.this.dOl.gSN == 1);
                    bundle.putBoolean("is_brand_forum", FrsTabViewController.this.dOl.isBrandForum);
                    frsCommonTabFragment.setArguments(bundle);
                    com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                    cVar.aVa = frsCommonTabFragment;
                    cVar.type = intValue;
                    cVar.aVg = com.baidu.tbadk.mainTab.c.aVd;
                    return cVar;
                }

                @Override // com.baidu.tbadk.mainTab.b
                public TbFragmentTabIndicator bJ(Context context) {
                    return null;
                }
            };
        }
        return null;
    }

    private void bB(List<FrsTabInfo> list) {
        if (!v.z(list)) {
            this.dOn = new com.baidu.tieba.frs.e(this.dtN.getActivity().getApplicationContext(), list);
            this.dOn.setForumId(this.dtN.getForumId());
            this.dOn.setForumName(this.dtN.getForumName());
            if (this.dOl != null && this.dOl.bbH() != null) {
                this.dOn.dM(this.dOl.bbH().getFirst_class());
                this.dOn.dN(this.dOl.bbH().getSecond_class());
                this.dOn.setForumGameLabel(this.dOl.bbH().getForumGameLabel());
            }
            for (FrsTabInfo frsTabInfo : list) {
                com.baidu.tbadk.mainTab.b c = c(frsTabInfo);
                if (c != null) {
                    this.dOn.b(c);
                }
            }
            this.dOr = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001623, this.dOn));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCT() {
        int i;
        if (this.dOn != null) {
            List<com.baidu.tbadk.mainTab.b> avN = this.dOn.avN();
            if (!v.z(avN) && !v.z(this.dOk)) {
                if (this.dOd.getTabCount() > 0) {
                    this.dOd.removeAllTabs();
                }
                aCU();
                if (this.mFragments.size() > 0) {
                    this.mFragments.clear();
                }
                Iterator it = this.dOk.iterator();
                int i2 = 0;
                int i3 = 0;
                while (it.hasNext()) {
                    com.baidu.tieba.frs.tab.d dVar = (com.baidu.tieba.frs.tab.d) it.next();
                    Fragment c = c(dVar.tabId, avN);
                    if (c != null) {
                        TbTabLayout.e b2 = this.dOd.oX().b(dVar.name);
                        boolean z = this.dOl.gTR == dVar.tabId;
                        if (z) {
                            i3 = i2;
                        }
                        if (this.dOl != null && this.dOl.bxi() && dVar.tabId == 89) {
                            b2.g(0, true);
                        } else {
                            b2.g(0, false);
                        }
                        this.dOd.a(b2, z);
                        b bVar = new b();
                        bVar.tabId = dVar.tabId;
                        bVar.title = dVar.name;
                        bVar.fragment = c;
                        this.mFragments.add(bVar);
                        i = i2 + 1;
                    } else {
                        it.remove();
                        i = i2;
                    }
                    i3 = i3;
                    i2 = i;
                }
                if (this.dOd.getTabCount() > 0 && this.dOc.getVisibility() != 0) {
                    this.dOc.setVisibility(0);
                }
                this.dOm = new FragmentAdapter(this.dtN.getActivity().getSupportFragmentManager(), this.mFragments);
                this.dOf.setAdapter(this.dOm);
                this.dOm.notifyDataSetChanged();
                this.dOd.setupWithViewPager(this.dOf);
                this.dOf.setOffscreenPageLimit(this.mFragments.size());
                this.dOf.setCurrentItem(i3, false);
                this.dOf.axQ();
            }
        }
    }

    private void aCU() {
        if (this.dOf != null && this.dOm != null && this.mFragments != null) {
            try {
                FragmentManager supportFragmentManager = this.dtN.getActivity().getSupportFragmentManager();
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

    private Fragment c(int i, List<com.baidu.tbadk.mainTab.b> list) {
        for (com.baidu.tbadk.mainTab.b bVar : list) {
            if (i == bVar.KE().type) {
                return bVar.KE().aVa;
            }
        }
        return null;
    }

    public View aCV() {
        if (isBrandForum() || this.dOo == null) {
            return null;
        }
        return this.dOo.azE();
    }

    public static boolean mf(int i) {
        return i > 200 && i <= 300;
    }

    public void a(a aVar) {
        this.dOp = aVar;
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
                    ((BaseFragment) getItem(this.mPrimaryPosition)).setPrimary(false);
                }
                this.mPrimaryPosition = i;
                if (obj instanceof BaseFragment) {
                    ((BaseFragment) obj).setPrimary(true);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public Fragment fragment;
        public int tabId;
        public String title;

        public b() {
        }
    }

    public b aCW() {
        if (this.dOf == null) {
            return null;
        }
        return (b) v.d(this.mFragments, this.dOf.getCurrentItem());
    }

    @Override // com.baidu.tieba.frs.vc.j
    public void aCX() {
        this.dOq.aW(this.dtN.getString(e.j.click_here_to_refresh), "key_show_frs_tab_click_to_refresh_tip");
    }

    public void aCY() {
        this.dOq.amz();
    }
}
