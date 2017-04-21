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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.cw;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.i;
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
public class a implements d {
    private FrsActivity bVk;
    private HorizontalTabView bVl;
    private com.baidu.tieba.frs.entelechy.c.a.a bVm;
    private cd bVn;
    private TabData bVp;
    private n bVq;
    private LinearLayout mRootLayout;
    private boolean bVo = false;
    private int liveCount = -1;
    private cd bVr = new b(this);
    private HorizontalTabView.a bVs = new c(this);

    public void ih(int i) {
        this.liveCount = i;
    }

    public a(FrsActivity frsActivity) {
        this.bVl = null;
        this.bVk = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds80);
        this.mRootLayout = new LinearLayout(frsActivity.getActivity());
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bVl = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bVl.cbo = k.g(frsActivity.getActivity(), w.f.ds20);
        this.bVl.setAutoFillTabCount(4);
        this.bVl.setmShowMenuCallBack(this.bVs);
        this.bVl.setNeedBottomLine(false);
        this.bVl.setTabBackgroudColor(w.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bVl.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.bVl);
        this.bVm = new com.baidu.tieba.frs.entelechy.c.a.a(this.bVk, this.mRootLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bVl != null) {
            this.bVl.xl();
        }
        if (this.bVm != null) {
            this.bVm.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(cd cdVar) {
        if (this.bVl != null) {
            this.bVl.setDataLoadInterface(this.bVr);
        }
        this.bVn = cdVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ah(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.bVo = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.bVo) {
            if (!this.bVk.aai()) {
                bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            }
            this.bVo = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, n nVar, int i) {
        boolean z;
        if (nVar != null && nVar.bhP() != null && nVar.bhP().tab != null) {
            this.bVm.i(nVar.bhP().menu, i);
            if (nVar.aKx() != null) {
                this.bVm.setFid(nVar.aKx().getId());
            }
            this.bVq = nVar;
            c(nVar);
            this.bVp = new TabData();
            for (FrsTabInfo frsTabInfo : nVar.bhP().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    i iVar = new i();
                    iVar.cbE = frsTabInfo.tab_id.intValue();
                    iVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.bVp.add(iVar);
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
                            sb.append(nVar.aKx().getId());
                            iVar.url = sb.toString();
                            aL(iVar.url, "c10078");
                            this.bVp.add(iVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.iE(frsTabInfo.tab_id.intValue())) {
                        iVar.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.i.bX(iVar.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                this.bVp.add(iVar);
                            }
                        } else {
                            this.bVp.add(iVar);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && bz.abD().id(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        bx ia = bw.abC().ia(iVar.cbE);
                        if (ia != null && ia.bSj != null && ia.bSj.size() > 0) {
                            iVar.cbF = new cw();
                            iVar.cbF.bSi = ia.bSi;
                            iVar.cbF.bSj = new LinkedList();
                            boolean z2 = true;
                            for (bv bvVar : ia.bSj) {
                                if (bvVar != null) {
                                    cv cvVar = new cv();
                                    cvVar.name = bvVar.name;
                                    cvVar.bSf = bvVar.bSf;
                                    if (z2) {
                                        cvVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    iVar.cbF.bSj.add(cvVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.bVp.add(iVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        bx ia2 = bw.abC().ia(iVar.cbE);
                        if (ia2 != null && ia2.bSj != null && ia2.bSj.size() > 0) {
                            iVar.cbF = new cw();
                            iVar.cbF.bSi = ia2.bSi;
                            iVar.cbF.bSj = new LinkedList();
                            for (bv bvVar2 : ia2.bSj) {
                                if (bvVar2 != null) {
                                    cv cvVar2 = new cv();
                                    cvVar2.name = bvVar2.name;
                                    cvVar2.bSf = bvVar2.bSf;
                                    iVar.cbF.bSj.add(cvVar2);
                                }
                            }
                        }
                        this.bVp.add(iVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.bVk.aab().abf().l(bi.Ye)) {
                        i iVar2 = new i();
                        iVar2.name = frsTabInfo.tab_name;
                        if (nVar.bhm() != 0 && nVar.bhm() <= 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + nVar.bhm() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != nVar.bhm() && this.liveCount <= 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || nVar.bhm() > 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != nVar.bhm()) {
                            iVar2.name = frsTabInfo.tab_name;
                        }
                        iVar2.cbE = frsTabInfo.tab_id.intValue();
                        this.bVp.add(iVar2);
                    }
                }
            }
            this.bVl.d(this.bVp, nVar.bhJ(), 12);
            if (!this.bVo) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.iE(frsTabInfo.tab_id.intValue());
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

    public HorizontalTabView acM() {
        return this.bVl;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ei(boolean z) {
        if (this.bVm != null) {
            if (z) {
                this.bVm.acO();
            } else {
                this.bVm.acP();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData acA() {
        return this.bVp;
    }

    private void c(n nVar) {
        if (nVar == null || nVar.bhG() == null || nVar.bhG().size() == 0) {
            bw.abC().a(1, null);
            return;
        }
        List<CategoryInfo> bhG = nVar.bhG();
        bx bxVar = new bx();
        bxVar.bSi = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bhG.size()) {
                if (bhG.get(i2) != null) {
                    bv bvVar = new bv();
                    bvVar.bSf = bhG.get(i2).category_id.intValue();
                    bvVar.name = bhG.get(i2).category_name;
                    arrayList.add(bvVar);
                }
                i = i2 + 1;
            } else {
                bxVar.bSj = arrayList;
                bw.abC().a(1, bxVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View acB() {
        if (this.bVm == null) {
            return null;
        }
        return this.bVm.acN();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View acC() {
        return this.mRootLayout;
    }
}
