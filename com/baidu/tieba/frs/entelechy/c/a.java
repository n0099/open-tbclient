package com.baidu.tieba.frs.entelechy.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.browser.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.cn;
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
    private r bNK;
    private HorizontalTabView bTe;
    private com.baidu.tieba.frs.entelechy.c.a.a bTf;
    private bx bTg;
    private TabData bTi;
    private n bTj;
    private LinearLayout mRootLayout;
    private boolean bTh = false;
    private int liveCount = -1;
    private bx bTk = new b(this);
    private HorizontalTabView.b bTl = new c(this);

    public void hX(int i) {
        this.liveCount = i;
    }

    public a(r rVar) {
        this.bTe = null;
        this.bNK = rVar;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds114);
        this.mRootLayout = new LinearLayout(rVar.getActivity());
        aq.k(this.mRootLayout, w.e.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bTe = new HorizontalTabView(rVar.getPageContext());
        this.bTe.setForNewFrame(true);
        this.bTe.bZc = k.g(rVar.getActivity(), w.f.ds20);
        this.bTe.setAutoFillTabCount(4);
        this.bTe.setmShowMenuCallBack(this.bTl);
        this.bTe.setNeedBottomLine(false);
        this.bTe.setTabBackgroudColor(w.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = k.g(rVar.getActivity(), w.f.ds26);
        layoutParams.weight = 1.0f;
        this.bTe.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.bTe);
        this.bTf = new com.baidu.tieba.frs.entelechy.c.a.a(this.bNK, this.mRootLayout);
        this.bTe.setOnTabItemClickListener(new d(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.mRootLayout != null) {
            aq.k(this.mRootLayout, w.e.cp_bg_line_d);
        }
        if (this.bTe != null) {
            this.bTe.ww();
        }
        if (this.bTf != null) {
            this.bTf.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(bx bxVar) {
        if (this.bTe != null) {
            this.bTe.setDataLoadInterface(this.bTk);
        }
        this.bTg = bxVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void af(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.bTh = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.bTh) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.bTh = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, n nVar, int i) {
        boolean z;
        if (nVar != null && nVar.bfr() != null && nVar.bfr().tab != null) {
            this.bTf.i(nVar.bfr().menu, i);
            if (nVar.aHE() != null) {
                this.bTf.setFid(nVar.aHE().getId());
            }
            this.bTj = nVar;
            b(nVar);
            this.bTi = new TabData();
            for (FrsTabInfo frsTabInfo : nVar.bfr().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    j jVar = new j();
                    jVar.bZw = frsTabInfo.tab_id.intValue();
                    jVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.bTi.add(jVar);
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
                            sb.append(nVar.aHE().getId());
                            jVar.url = sb.toString();
                            aL(jVar.url, "c10078");
                            this.bTi.add(jVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.iw(frsTabInfo.tab_id.intValue())) {
                        jVar.url = frsTabInfo.tab_url;
                        if (i.bX(jVar.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                this.bTi.add(jVar);
                            }
                        } else {
                            this.bTi.add(jVar);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && bs.aac().hT(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        bq hQ = bp.aab().hQ(jVar.bZw);
                        if (hQ != null && hQ.bQV != null && hQ.bQV.size() > 0) {
                            jVar.bZx = new cn();
                            jVar.bZx.bQU = hQ.bQU;
                            jVar.bZx.bQV = new LinkedList();
                            boolean z2 = true;
                            for (bo boVar : hQ.bQV) {
                                if (boVar != null) {
                                    cm cmVar = new cm();
                                    cmVar.name = boVar.name;
                                    cmVar.bQR = boVar.bQR;
                                    if (z2) {
                                        cmVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    jVar.bZx.bQV.add(cmVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.bTi.add(jVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        bq hQ2 = bp.aab().hQ(jVar.bZw);
                        if (hQ2 != null && hQ2.bQV != null && hQ2.bQV.size() > 0) {
                            jVar.bZx = new cn();
                            jVar.bZx.bQU = hQ2.bQU;
                            jVar.bZx.bQV = new LinkedList();
                            for (bo boVar2 : hQ2.bQV) {
                                if (boVar2 != null) {
                                    cm cmVar2 = new cm();
                                    cmVar2.name = boVar2.name;
                                    cmVar2.bQR = boVar2.bQR;
                                    jVar.bZx.bQV.add(cmVar2);
                                }
                            }
                        }
                        this.bTi.add(jVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.bNK.YZ().ZO().l(bk.Xw)) {
                        j jVar2 = new j();
                        jVar2.name = frsTabInfo.tab_name;
                        if (nVar.beO() != 0 && nVar.beO() <= 99) {
                            jVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + nVar.beO() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != nVar.beO() && this.liveCount <= 99) {
                            jVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || nVar.beO() > 99) {
                            jVar2.name = String.valueOf(frsTabInfo.tab_name) + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != nVar.beO()) {
                            jVar2.name = frsTabInfo.tab_name;
                        }
                        jVar2.bZw = frsTabInfo.tab_id.intValue();
                        this.bTi.add(jVar2);
                    }
                }
            }
            this.bTe.d(this.bTi, nVar.bfl(), 12);
            if (!this.bTh) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.iw(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    as asVar = new as(str2);
                    asVar.aa("obj_type", host);
                    TiebaStatic.log(asVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView aaT() {
        return this.bTe;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void dY(boolean z) {
        if (this.bTf != null) {
            if (z) {
                this.bTf.aaV();
            } else {
                this.bTf.aaW();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData aaN() {
        return this.bTi;
    }

    private void b(n nVar) {
        if (nVar == null || nVar.bfi() == null || nVar.bfi().size() == 0) {
            bp.aab().a(1, null);
            return;
        }
        List<CategoryInfo> bfi = nVar.bfi();
        bq bqVar = new bq();
        bqVar.bQU = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bfi.size()) {
                if (bfi.get(i2) != null) {
                    bo boVar = new bo();
                    boVar.bQR = bfi.get(i2).category_id.intValue();
                    boVar.name = bfi.get(i2).category_name;
                    arrayList.add(boVar);
                }
                i = i2 + 1;
            } else {
                bqVar.bQV = arrayList;
                bp.aab().a(1, bqVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View aaO() {
        if (this.bTf == null) {
            return null;
        }
        return this.bTf.aaU();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View aaP() {
        return this.mRootLayout;
    }
}
