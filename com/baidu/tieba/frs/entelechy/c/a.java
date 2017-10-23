package com.baidu.tieba.frs.entelechy.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaGameFrsLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGoodActivityConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.i;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a implements d {
    private f cwW;
    private HorizontalTabView cwX;
    private com.baidu.tieba.frs.entelechy.c.a.a cwY;
    private aj cwZ;
    private TabData cxb;
    private i cxc;
    private LinearLayout mRootLayout;
    private boolean cxa = false;
    private int liveCount = -1;
    private aj cxd = new aj() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i == 101) {
                TiebaStatic.log(new ak("c12103").ac("fid", a.this.cwW.getForumId()));
            }
            if (i > 100) {
                if (aoVar != null && (aoVar.ctu instanceof String)) {
                    a.this.aV((String) aoVar.ctu, "c10079");
                }
            } else {
                ak akVar = new ak("c10074");
                akVar.r("obj_type", i);
                akVar.ac("fid", a.this.cwW.getForumId());
                TiebaStatic.log(akVar);
                if (i == 99) {
                    ak akVar2 = new ak("c11500");
                    akVar2.ac("obj_param1", "2").ac("obj_param2", "1");
                    TiebaStatic.log(akVar2);
                }
            }
            if (HorizontalTabView.jW(i) && aoVar != null) {
                String str = (String) aoVar.ctu;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        l.showToast(a.this.cwW.getPageContext().getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else {
                        av.vA().c(a.this.cwW.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.cwW != null && a.this.cwW.getPageContext() != null && a.this.cwW.getPageContext().getPageActivity() != null) {
                    a.this.cwW.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.cwW.getPageContext().getPageActivity()).createNormalCfg(a.this.cwW.cqa, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else {
                if (i == 49) {
                    if (a.this.cwW != null && a.this.cwW.getPageContext() != null && a.this.cwW.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.cwW.ahf().aMU().getForumGameLabel())) {
                        if (aoVar != null) {
                            aoVar.ctv = true;
                        }
                        a.this.cwW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.cwW.getPageContext().getPageActivity(), a.this.cwW.getForumId(), a.this.cwW.getForumName(), a.this.cwW.ahf().aMU().getForumGameLabel())));
                        return;
                    }
                } else if (i == 302) {
                    if (a.this.cwW != null && a.this.cwW.getPageContext() != null && a.this.cwW.getPageContext().getPageActivity() != null) {
                        TiebaStatic.log("c12410");
                        a.this.cwW.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(a.this.cwW.getPageContext().getPageActivity(), a.this.cwW.forumId)));
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    a.this.cwY.ajv();
                } else {
                    a.this.cwY.ajw();
                }
                if (a.this.cwZ != null) {
                    a.this.cwZ.a(i, i2, aoVar);
                }
            }
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void Pf() {
        }
    };
    private HorizontalTabView.c cxe = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void js(int i) {
            a.this.cwW.agP().jd(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean jt(int i) {
            return (a.this.cwW != null && a.this.cwW.ahg() && i == 1) ? false : true;
        }
    };

    public void jr(int i) {
        this.liveCount = i;
    }

    public a(f fVar) {
        this.cwX = null;
        this.cwW = fVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds114);
        this.mRootLayout = new LinearLayout(fVar.getActivity());
        com.baidu.tbadk.core.util.aj.k(this.mRootLayout, d.e.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.cwX = new HorizontalTabView(fVar.getPageContext());
        this.cwX.setForNewFrame(true);
        this.cwX.cFR = l.f(fVar.getActivity(), d.f.ds20);
        this.cwX.setAutoFillTabCount(4);
        this.cwX.setmShowMenuCallBack(this.cxe);
        this.cwX.setNeedBottomLine(false);
        this.cwX.setTabBackgroudColor(d.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = l.f(fVar.getActivity(), d.f.ds26);
        layoutParams.weight = 1.0f;
        this.cwX.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.cwX);
        this.cwY = new com.baidu.tieba.frs.entelechy.c.a.a(this.cwW, this.mRootLayout);
        this.cwX.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cxc != null && a.this.cxc.aMU() != null) {
                    TiebaStatic.log(new ak("c12047").ac("fid", a.this.cxc.aMU().getId()));
                }
            }
        });
        this.cwX.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.cwW != null) {
                    a.this.cwW.cI(dVar.cCO == 49);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.mRootLayout != null) {
            com.baidu.tbadk.core.util.aj.k(this.mRootLayout, d.e.cp_bg_line_d);
        }
        if (this.cwX != null) {
            this.cwX.wu();
        }
        if (this.cwY != null) {
            this.cwY.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(aj ajVar) {
        if (this.cwX != null) {
            this.cwX.setDataLoadInterface(this.cxd);
        }
        this.cwZ = ajVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void as(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.cxa = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.cxa) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.cxa = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, i iVar, int i) {
        boolean z;
        if (iVar != null && iVar.bpS() != null && iVar.bpS().tab != null) {
            this.cwY.i(iVar.bpS().menu, i);
            if (iVar.aMU() != null) {
                this.cwY.setFid(iVar.aMU().getId());
            }
            this.cxc = iVar;
            b(iVar);
            this.cxb = new TabData();
            if (v.u(iVar.bpZ())) {
                for (FrsTabInfo frsTabInfo : iVar.bpS().tab) {
                    if (!a(frsTabInfo) && !b(frsTabInfo)) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.cCO = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            this.cxb.add(dVar);
                        } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                            if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                StringBuilder sb = new StringBuilder();
                                String lowerCase = frsTabInfo.tab_url.toLowerCase();
                                if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                    sb.append("http://");
                                }
                                sb.append(frsTabInfo.tab_url);
                                sb.append("&");
                                sb.append("fid");
                                sb.append("=");
                                sb.append(iVar.aMU().getId());
                                dVar.url = sb.toString();
                                aV(dVar.url, "c10078");
                                this.cxb.add(dVar);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.jW(frsTabInfo.tab_id.intValue())) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.cg(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cxb.add(dVar);
                                }
                            } else {
                                this.cxb.add(dVar);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && ac.ahX().jj(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            aa jg = z.ahW().jg(dVar.cCO);
                            if (jg != null && jg.ctd != null && jg.ctd.size() > 0) {
                                dVar.cGm = new au();
                                dVar.cGm.ctc = jg.ctc;
                                dVar.cGm.ctd = new LinkedList();
                                boolean z2 = true;
                                for (y yVar : jg.ctd) {
                                    if (yVar != null) {
                                        at atVar = new at();
                                        atVar.name = yVar.name;
                                        atVar.csZ = yVar.csZ;
                                        if (z2) {
                                            atVar.isSelected = true;
                                            z = false;
                                        } else {
                                            z = z2;
                                        }
                                        dVar.cGm.ctd.add(atVar);
                                        z2 = z;
                                    }
                                }
                            }
                            this.cxb.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            aa jg2 = z.ahW().jg(dVar.cCO);
                            if (jg2 != null && jg2.ctd != null && jg2.ctd.size() > 0) {
                                dVar.cGm = new au();
                                dVar.cGm.ctc = jg2.ctc;
                                dVar.cGm.ctd = new LinkedList();
                                for (y yVar2 : jg2.ctd) {
                                    if (yVar2 != null) {
                                        at atVar2 = new at();
                                        atVar2.name = yVar2.name;
                                        atVar2.csZ = yVar2.csZ;
                                        dVar.cGm.ctd.add(atVar2);
                                    }
                                }
                            }
                            this.cxb.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 49 && this.cwW.agP().ahF().l(bh.Ya)) {
                            com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                            dVar2.name = frsTabInfo.tab_name;
                            if (iVar.bpp() != 0 && iVar.bpp() <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + iVar.bpp() + ")";
                            }
                            if (this.liveCount > 0 && this.liveCount != iVar.bpp() && this.liveCount <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                            } else if (this.liveCount > 99 || iVar.bpp() > 99) {
                                dVar2.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.liveCount == 0 && this.liveCount != iVar.bpp()) {
                                dVar2.name = frsTabInfo.tab_name;
                            }
                            dVar2.cCO = frsTabInfo.tab_id.intValue();
                            this.cxb.add(dVar2);
                        }
                    }
                }
            } else {
                Iterator<FrsTabInfo> it = iVar.bpS().tab.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FrsTabInfo next = it.next();
                    if (next.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                        dVar3.cCO = next.tab_id.intValue();
                        dVar3.name = next.tab_name;
                        this.cxb.add(dVar3);
                        break;
                    }
                }
            }
            this.cwX.d(this.cxb, iVar.bpM(), 12);
            if (!this.cxa) {
                a(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.jW(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    ak akVar = new ak(str2);
                    akVar.ac("obj_type", host);
                    TiebaStatic.log(akVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView ajt() {
        return this.cwX;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eU(boolean z) {
        if (this.cwY != null) {
            if (z) {
                this.cwY.ajv();
            } else {
                this.cwY.ajw();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData ajm() {
        return this.cxb;
    }

    private void b(i iVar) {
        if (iVar == null || iVar.bpJ() == null || iVar.bpJ().size() == 0) {
            z.ahW().a(1, null);
            return;
        }
        List<CategoryInfo> bpJ = iVar.bpJ();
        aa aaVar = new aa();
        aaVar.ctc = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bpJ.size()) {
                if (bpJ.get(i2) != null) {
                    y yVar = new y();
                    yVar.csZ = bpJ.get(i2).category_id.intValue();
                    yVar.name = bpJ.get(i2).category_name;
                    arrayList.add(yVar);
                }
                i = i2 + 1;
            } else {
                aaVar.ctd = arrayList;
                z.ahW().a(1, aaVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View ajn() {
        if (this.cwY == null) {
            return null;
        }
        return this.cwY.aju();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View ajo() {
        return this.mRootLayout;
    }
}
