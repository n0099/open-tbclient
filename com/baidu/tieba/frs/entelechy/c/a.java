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
    private FrsActivity bST;
    private HorizontalTabView bSU;
    private com.baidu.tieba.frs.entelechy.c.a.a bSV;
    private cd bSW;
    private TabData bSY;
    private n bSZ;
    private LinearLayout mRootLayout;
    private boolean bSX = false;
    private int liveCount = -1;
    private cd bTa = new b(this);
    private HorizontalTabView.a bTb = new c(this);

    public void ib(int i) {
        this.liveCount = i;
    }

    public a(FrsActivity frsActivity) {
        this.bSU = null;
        this.bST = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds80);
        this.mRootLayout = new LinearLayout(frsActivity.getActivity());
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bSU = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bSU.bYX = k.g(frsActivity.getActivity(), w.f.ds20);
        this.bSU.setAutoFillTabCount(4);
        this.bSU.setmShowMenuCallBack(this.bTb);
        this.bSU.setNeedBottomLine(false);
        this.bSU.setTabBackgroudColor(w.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bSU.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.bSU);
        this.bSV = new com.baidu.tieba.frs.entelechy.c.a.a(this.bST, this.mRootLayout);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bSU != null) {
            this.bSU.xl();
        }
        if (this.bSV != null) {
            this.bSV.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(cd cdVar) {
        if (this.bSU != null) {
            this.bSU.setDataLoadInterface(this.bTa);
        }
        this.bSW = cdVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ah(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.bSX = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.bSX) {
            if (!this.bST.Zh()) {
                bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            }
            this.bSX = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, n nVar, int i) {
        boolean z;
        if (nVar != null && nVar.bgN() != null && nVar.bgN().tab != null) {
            this.bSV.i(nVar.bgN().menu, i);
            if (nVar.aJw() != null) {
                this.bSV.setFid(nVar.aJw().getId());
            }
            this.bSZ = nVar;
            c(nVar);
            this.bSY = new TabData();
            for (FrsTabInfo frsTabInfo : nVar.bgN().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    i iVar = new i();
                    iVar.bZn = frsTabInfo.tab_id.intValue();
                    iVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.bSY.add(iVar);
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
                            sb.append(nVar.aJw().getId());
                            iVar.url = sb.toString();
                            aM(iVar.url, "c10078");
                            this.bSY.add(iVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.iy(frsTabInfo.tab_id.intValue())) {
                        iVar.url = frsTabInfo.tab_url;
                        if (com.baidu.tbadk.browser.i.bX(iVar.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                this.bSY.add(iVar);
                            }
                        } else {
                            this.bSY.add(iVar);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && bz.aaC().hX(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        bx hU = bw.aaB().hU(iVar.bZn);
                        if (hU != null && hU.bPS != null && hU.bPS.size() > 0) {
                            iVar.bZo = new cw();
                            iVar.bZo.bPR = hU.bPR;
                            iVar.bZo.bPS = new LinkedList();
                            boolean z2 = true;
                            for (bv bvVar : hU.bPS) {
                                if (bvVar != null) {
                                    cv cvVar = new cv();
                                    cvVar.name = bvVar.name;
                                    cvVar.bPO = bvVar.bPO;
                                    if (z2) {
                                        cvVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    iVar.bZo.bPS.add(cvVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.bSY.add(iVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        bx hU2 = bw.aaB().hU(iVar.bZn);
                        if (hU2 != null && hU2.bPS != null && hU2.bPS.size() > 0) {
                            iVar.bZo = new cw();
                            iVar.bZo.bPR = hU2.bPR;
                            iVar.bZo.bPS = new LinkedList();
                            for (bv bvVar2 : hU2.bPS) {
                                if (bvVar2 != null) {
                                    cv cvVar2 = new cv();
                                    cvVar2.name = bvVar2.name;
                                    cvVar2.bPO = bvVar2.bPO;
                                    iVar.bZo.bPS.add(cvVar2);
                                }
                            }
                        }
                        this.bSY.add(iVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.bST.Za().aae().l(bi.Yd)) {
                        i iVar2 = new i();
                        iVar2.name = frsTabInfo.tab_name;
                        if (nVar.bgk() != 0 && nVar.bgk() <= 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + nVar.bgk() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != nVar.bgk() && this.liveCount <= 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || nVar.bgk() > 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != nVar.bgk()) {
                            iVar2.name = frsTabInfo.tab_name;
                        }
                        iVar2.bZn = frsTabInfo.tab_id.intValue();
                        this.bSY.add(iVar2);
                    }
                }
            }
            this.bSU.d(this.bSY, nVar.bgH(), 12);
            if (!this.bSX) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.iy(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(String str, String str2) {
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

    public HorizontalTabView abL() {
        return this.bSU;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void dY(boolean z) {
        if (this.bSV != null) {
            if (z) {
                this.bSV.abN();
            } else {
                this.bSV.abO();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData abz() {
        return this.bSY;
    }

    private void c(n nVar) {
        if (nVar == null || nVar.bgE() == null || nVar.bgE().size() == 0) {
            bw.aaB().a(1, null);
            return;
        }
        List<CategoryInfo> bgE = nVar.bgE();
        bx bxVar = new bx();
        bxVar.bPR = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bgE.size()) {
                if (bgE.get(i2) != null) {
                    bv bvVar = new bv();
                    bvVar.bPO = bgE.get(i2).category_id.intValue();
                    bvVar.name = bgE.get(i2).category_name;
                    arrayList.add(bvVar);
                }
                i = i2 + 1;
            } else {
                bxVar.bPS = arrayList;
                bw.aaB().a(1, bxVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View abA() {
        if (this.bSV == null) {
            return null;
        }
        return this.bSV.abM();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View abB() {
        return this.mRootLayout;
    }
}
