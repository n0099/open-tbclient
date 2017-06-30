package com.baidu.tieba.frs.entelechy.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.bu;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.cp;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.w;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.frs.entelechy.b.d {
    private r cbE;
    private HorizontalTabView chf;
    private com.baidu.tieba.frs.entelechy.c.a.a chg;
    private bz chh;
    private TabData chj;
    private n chk;
    private LinearLayout mRootLayout;
    private boolean chi = false;
    private int liveCount = -1;
    private bz chl = new b(this);
    private HorizontalTabView.c chm = new c(this);

    public void iH(int i) {
        this.liveCount = i;
    }

    public a(r rVar) {
        this.chf = null;
        this.cbE = rVar;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds114);
        this.mRootLayout = new LinearLayout(rVar.getActivity());
        as.k(this.mRootLayout, w.e.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.chf = new HorizontalTabView(rVar.getPageContext());
        this.chf.setForNewFrame(true);
        this.chf.cnD = k.g(rVar.getActivity(), w.f.ds20);
        this.chf.setAutoFillTabCount(4);
        this.chf.setmShowMenuCallBack(this.chm);
        this.chf.setNeedBottomLine(false);
        this.chf.setTabBackgroudColor(w.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = k.g(rVar.getActivity(), w.f.ds26);
        layoutParams.weight = 1.0f;
        this.chf.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.chf);
        this.chg = new com.baidu.tieba.frs.entelechy.c.a.a(this.cbE, this.mRootLayout);
        this.chf.setOnTabItemClickListener(new d(this));
        this.chf.setOnTabItemSelectListener(new e(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.mRootLayout != null) {
            as.k(this.mRootLayout, w.e.cp_bg_line_d);
        }
        if (this.chf != null) {
            this.chf.wK();
        }
        if (this.chg != null) {
            this.chg.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(bz bzVar) {
        if (this.chf != null) {
            this.chf.setDataLoadInterface(this.chl);
        }
        this.chh = bzVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ag(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.chi = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.chi) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.chi = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, n nVar, int i) {
        boolean z;
        if (nVar != null && nVar.bla() != null && nVar.bla().tab != null) {
            this.chg.i(nVar.bla().menu, i);
            if (nVar.aMt() != null) {
                this.chg.setFid(nVar.aMt().getId());
            }
            this.chk = nVar;
            b(nVar);
            this.chj = new TabData();
            for (FrsTabInfo frsTabInfo : nVar.bla().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    j jVar = new j();
                    jVar.cnY = frsTabInfo.tab_id.intValue();
                    jVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.chj.add(jVar);
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
                            sb.append(nVar.aMt().getId());
                            jVar.url = sb.toString();
                            aQ(jVar.url, "c10078");
                            this.chj.add(jVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.jg(frsTabInfo.tab_id.intValue())) {
                        jVar.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.j.cd(jVar.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                this.chj.add(jVar);
                            }
                        } else {
                            this.chj.add(jVar);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && bu.aeV().iD(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        bs iA = br.aeU().iA(jVar.cnY);
                        if (iA != null && iA.ceU != null && iA.ceU.size() > 0) {
                            jVar.cnZ = new cp();
                            jVar.cnZ.ceT = iA.ceT;
                            jVar.cnZ.ceU = new LinkedList();
                            boolean z2 = true;
                            for (bq bqVar : iA.ceU) {
                                if (bqVar != null) {
                                    co coVar = new co();
                                    coVar.name = bqVar.name;
                                    coVar.ceQ = bqVar.ceQ;
                                    if (z2) {
                                        coVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    jVar.cnZ.ceU.add(coVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.chj.add(jVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        bs iA2 = br.aeU().iA(jVar.cnY);
                        if (iA2 != null && iA2.ceU != null && iA2.ceU.size() > 0) {
                            jVar.cnZ = new cp();
                            jVar.cnZ.ceT = iA2.ceT;
                            jVar.cnZ.ceU = new LinkedList();
                            for (bq bqVar2 : iA2.ceU) {
                                if (bqVar2 != null) {
                                    co coVar2 = new co();
                                    coVar2.name = bqVar2.name;
                                    coVar2.ceQ = bqVar2.ceQ;
                                    jVar.cnZ.ceU.add(coVar2);
                                }
                            }
                        }
                        this.chj.add(jVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.cbE.adU().aeI().k(bm.Xs)) {
                        j jVar2 = new j();
                        jVar2.name = frsTabInfo.tab_name;
                        if (nVar.bkx() != 0 && nVar.bkx() <= 99) {
                            jVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + nVar.bkx() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != nVar.bkx() && this.liveCount <= 99) {
                            jVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || nVar.bkx() > 99) {
                            jVar2.name = String.valueOf(frsTabInfo.tab_name) + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != nVar.bkx()) {
                            jVar2.name = frsTabInfo.tab_name;
                        }
                        jVar2.cnY = frsTabInfo.tab_id.intValue();
                        this.chj.add(jVar2);
                    }
                }
            }
            this.chf.d(this.chj, nVar.bkU(), 12);
            if (!this.chi) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.jg(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    au auVar = new au(str2);
                    auVar.Z("obj_type", host);
                    TiebaStatic.log(auVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView afP() {
        return this.chf;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eG(boolean z) {
        if (this.chg != null) {
            if (z) {
                this.chg.afR();
            } else {
                this.chg.afS();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData afI() {
        return this.chj;
    }

    private void b(n nVar) {
        if (nVar == null || nVar.bkR() == null || nVar.bkR().size() == 0) {
            br.aeU().a(1, null);
            return;
        }
        List<CategoryInfo> bkR = nVar.bkR();
        bs bsVar = new bs();
        bsVar.ceT = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bkR.size()) {
                if (bkR.get(i2) != null) {
                    bq bqVar = new bq();
                    bqVar.ceQ = bkR.get(i2).category_id.intValue();
                    bqVar.name = bkR.get(i2).category_name;
                    arrayList.add(bqVar);
                }
                i = i2 + 1;
            } else {
                bsVar.ceU = arrayList;
                br.aeU().a(1, bsVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View afJ() {
        if (this.chg == null) {
            return null;
        }
        return this.chg.afQ();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View afK() {
        return this.mRootLayout;
    }
}
