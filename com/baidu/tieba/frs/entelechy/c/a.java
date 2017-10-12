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
    private f cxi;
    private HorizontalTabView cxj;
    private com.baidu.tieba.frs.entelechy.c.a.a cxk;
    private aj cxl;
    private TabData cxn;
    private i cxo;
    private LinearLayout mRootLayout;
    private boolean cxm = false;
    private int liveCount = -1;
    private aj cxp = new aj() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i == 101) {
                TiebaStatic.log(new ak("c12103").ad("fid", a.this.cxi.getForumId()));
            }
            if (i > 100) {
                if (aoVar != null && (aoVar.ctH instanceof String)) {
                    a.this.aW((String) aoVar.ctH, "c10079");
                }
            } else {
                ak akVar = new ak("c10074");
                akVar.r("obj_type", i);
                akVar.ad("fid", a.this.cxi.getForumId());
                TiebaStatic.log(akVar);
                if (i == 99) {
                    ak akVar2 = new ak("c11500");
                    akVar2.ad("obj_param1", "2").ad("obj_param2", "1");
                    TiebaStatic.log(akVar2);
                }
            }
            if (HorizontalTabView.jX(i) && aoVar != null) {
                String str = (String) aoVar.ctH;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        l.showToast(a.this.cxi.getPageContext().getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else {
                        av.vH().c(a.this.cxi.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.cxi != null && a.this.cxi.getPageContext() != null && a.this.cxi.getPageContext().getPageActivity() != null) {
                    a.this.cxi.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.cxi.getPageContext().getPageActivity()).createNormalCfg(a.this.cxi.cqm, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else {
                if (i == 49) {
                    if (a.this.cxi != null && a.this.cxi.getPageContext() != null && a.this.cxi.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.cxi.ahk().aMZ().getForumGameLabel())) {
                        if (aoVar != null) {
                            aoVar.ctI = true;
                        }
                        a.this.cxi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.cxi.getPageContext().getPageActivity(), a.this.cxi.getForumId(), a.this.cxi.getForumName(), a.this.cxi.ahk().aMZ().getForumGameLabel())));
                        return;
                    }
                } else if (i == 302) {
                    if (a.this.cxi != null && a.this.cxi.getPageContext() != null && a.this.cxi.getPageContext().getPageActivity() != null) {
                        TiebaStatic.log("c12410");
                        a.this.cxi.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(a.this.cxi.getPageContext().getPageActivity(), a.this.cxi.forumId)));
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    a.this.cxk.ajA();
                } else {
                    a.this.cxk.ajB();
                }
                if (a.this.cxl != null) {
                    a.this.cxl.a(i, i2, aoVar);
                }
            }
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void Pl() {
        }
    };
    private HorizontalTabView.c cxq = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void jt(int i) {
            a.this.cxi.agU().je(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean ju(int i) {
            return (a.this.cxi != null && a.this.cxi.ahl() && i == 1) ? false : true;
        }
    };

    public void js(int i) {
        this.liveCount = i;
    }

    public a(f fVar) {
        this.cxj = null;
        this.cxi = fVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds114);
        this.mRootLayout = new LinearLayout(fVar.getActivity());
        com.baidu.tbadk.core.util.aj.k(this.mRootLayout, d.e.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.cxj = new HorizontalTabView(fVar.getPageContext());
        this.cxj.setForNewFrame(true);
        this.cxj.cGd = l.f(fVar.getActivity(), d.f.ds20);
        this.cxj.setAutoFillTabCount(4);
        this.cxj.setmShowMenuCallBack(this.cxq);
        this.cxj.setNeedBottomLine(false);
        this.cxj.setTabBackgroudColor(d.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = l.f(fVar.getActivity(), d.f.ds26);
        layoutParams.weight = 1.0f;
        this.cxj.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.cxj);
        this.cxk = new com.baidu.tieba.frs.entelechy.c.a.a(this.cxi, this.mRootLayout);
        this.cxj.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cxo != null && a.this.cxo.aMZ() != null) {
                    TiebaStatic.log(new ak("c12047").ad("fid", a.this.cxo.aMZ().getId()));
                }
            }
        });
        this.cxj.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.cxi != null) {
                    a.this.cxi.cJ(dVar.cDa == 49);
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
        if (this.cxj != null) {
            this.cxj.wB();
        }
        if (this.cxk != null) {
            this.cxk.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(aj ajVar) {
        if (this.cxj != null) {
            this.cxj.setDataLoadInterface(this.cxp);
        }
        this.cxl = ajVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void as(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.cxm = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.cxm) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.cxm = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, i iVar, int i) {
        boolean z;
        if (iVar != null && iVar.bpZ() != null && iVar.bpZ().tab != null) {
            this.cxk.i(iVar.bpZ().menu, i);
            if (iVar.aMZ() != null) {
                this.cxk.setFid(iVar.aMZ().getId());
            }
            this.cxo = iVar;
            b(iVar);
            this.cxn = new TabData();
            if (v.u(iVar.bqg())) {
                for (FrsTabInfo frsTabInfo : iVar.bpZ().tab) {
                    if (!a(frsTabInfo) && !b(frsTabInfo)) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.cDa = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            this.cxn.add(dVar);
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
                                sb.append(iVar.aMZ().getId());
                                dVar.url = sb.toString();
                                aW(dVar.url, "c10078");
                                this.cxn.add(dVar);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.jX(frsTabInfo.tab_id.intValue())) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.ch(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cxn.add(dVar);
                                }
                            } else {
                                this.cxn.add(dVar);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && ac.aic().jk(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            aa jh = z.aib().jh(dVar.cDa);
                            if (jh != null && jh.ctp != null && jh.ctp.size() > 0) {
                                dVar.cGy = new au();
                                dVar.cGy.cto = jh.cto;
                                dVar.cGy.ctp = new LinkedList();
                                boolean z2 = true;
                                for (y yVar : jh.ctp) {
                                    if (yVar != null) {
                                        at atVar = new at();
                                        atVar.name = yVar.name;
                                        atVar.ctl = yVar.ctl;
                                        if (z2) {
                                            atVar.isSelected = true;
                                            z = false;
                                        } else {
                                            z = z2;
                                        }
                                        dVar.cGy.ctp.add(atVar);
                                        z2 = z;
                                    }
                                }
                            }
                            this.cxn.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            aa jh2 = z.aib().jh(dVar.cDa);
                            if (jh2 != null && jh2.ctp != null && jh2.ctp.size() > 0) {
                                dVar.cGy = new au();
                                dVar.cGy.cto = jh2.cto;
                                dVar.cGy.ctp = new LinkedList();
                                for (y yVar2 : jh2.ctp) {
                                    if (yVar2 != null) {
                                        at atVar2 = new at();
                                        atVar2.name = yVar2.name;
                                        atVar2.ctl = yVar2.ctl;
                                        dVar.cGy.ctp.add(atVar2);
                                    }
                                }
                            }
                            this.cxn.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 49 && this.cxi.agU().ahK().l(bh.Ym)) {
                            com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                            dVar2.name = frsTabInfo.tab_name;
                            if (iVar.bpw() != 0 && iVar.bpw() <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + iVar.bpw() + ")";
                            }
                            if (this.liveCount > 0 && this.liveCount != iVar.bpw() && this.liveCount <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                            } else if (this.liveCount > 99 || iVar.bpw() > 99) {
                                dVar2.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.liveCount == 0 && this.liveCount != iVar.bpw()) {
                                dVar2.name = frsTabInfo.tab_name;
                            }
                            dVar2.cDa = frsTabInfo.tab_id.intValue();
                            this.cxn.add(dVar2);
                        }
                    }
                }
            } else {
                Iterator<FrsTabInfo> it = iVar.bpZ().tab.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FrsTabInfo next = it.next();
                    if (next.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                        dVar3.cDa = next.tab_id.intValue();
                        dVar3.name = next.tab_name;
                        this.cxn.add(dVar3);
                        break;
                    }
                }
            }
            this.cxj.d(this.cxn, iVar.bpT(), 12);
            if (!this.cxm) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.jX(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    ak akVar = new ak(str2);
                    akVar.ad("obj_type", host);
                    TiebaStatic.log(akVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView ajy() {
        return this.cxj;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eV(boolean z) {
        if (this.cxk != null) {
            if (z) {
                this.cxk.ajA();
            } else {
                this.cxk.ajB();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData ajr() {
        return this.cxn;
    }

    private void b(i iVar) {
        if (iVar == null || iVar.bpQ() == null || iVar.bpQ().size() == 0) {
            z.aib().a(1, null);
            return;
        }
        List<CategoryInfo> bpQ = iVar.bpQ();
        aa aaVar = new aa();
        aaVar.cto = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bpQ.size()) {
                if (bpQ.get(i2) != null) {
                    y yVar = new y();
                    yVar.ctl = bpQ.get(i2).category_id.intValue();
                    yVar.name = bpQ.get(i2).category_name;
                    arrayList.add(yVar);
                }
                i = i2 + 1;
            } else {
                aaVar.ctp = arrayList;
                z.aib().a(1, aaVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View ajs() {
        if (this.cxk == null) {
            return null;
        }
        return this.cxk.ajz();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View ajt() {
        return this.mRootLayout;
    }
}
