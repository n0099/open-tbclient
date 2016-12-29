package com.baidu.tieba.frs.entelechy.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.browser.Static;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.o;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a implements d {
    private LinearLayout Gu;
    private FrsActivity bFI;
    private HorizontalTabView bFJ;
    private com.baidu.tieba.frs.entelechy.c.a.a bFK;
    private cd bFL;
    private TabData bFN;
    private o bFO;
    private boolean bFM = false;
    private cd bFP = new b(this);
    private HorizontalTabView.a bFQ = new c(this);

    public a(FrsActivity frsActivity) {
        this.bFJ = null;
        this.bFI = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds80);
        this.Gu = new LinearLayout(frsActivity.getActivity());
        this.Gu.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bFJ = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bFJ.bMW = k.e(frsActivity.getActivity(), r.e.ds20);
        this.bFJ.setAutoFillTabCount(4);
        this.bFJ.setmShowMenuCallBack(this.bFQ);
        this.bFJ.setNeedBottomLine(false);
        this.bFJ.setTabBackgroudColor(r.d.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bFJ.setLayoutParams(layoutParams);
        this.Gu.addView(this.bFJ);
        this.bFK = new com.baidu.tieba.frs.entelechy.c.a.a(this.bFI, this.Gu);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bFJ != null) {
            this.bFJ.wx();
        }
        if (this.bFK != null) {
            this.bFK.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(cd cdVar) {
        if (this.bFJ != null) {
            this.bFJ.setDataLoadInterface(this.bFP);
        }
        this.bFL = cdVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ae(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void u(BdListView bdListView) {
        if (this.Gu != null && bdListView != null) {
            bdListView.removeHeaderView(this.Gu);
            this.bFM = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView, int i) {
        if (this.Gu != null && !this.bFM) {
            if (!this.bFI.Wv()) {
                bdListView.addHeaderView(this.Gu, Integer.valueOf(i), false);
            }
            this.bFM = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x027b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0155  */
    @Override // com.baidu.tieba.frs.entelechy.b.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdListView bdListView, o oVar, int i) {
        boolean z;
        URI uri;
        if (oVar != null && oVar.bez() != null && oVar.bez().tab != null) {
            this.bFK.h(oVar.bez().menu, i);
            if (oVar.aIk() != null) {
                this.bFK.setFid(oVar.aIk().getId());
            }
            this.bFO = oVar;
            d(oVar);
            this.bFN = new TabData();
            for (FrsTabInfo frsTabInfo : oVar.bez().tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() > 0 && !TextUtils.isEmpty(frsTabInfo.tab_name) && !TextUtils.isEmpty(frsTabInfo.tab_name.trim()) && (frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12)) {
                    if (frsTabInfo.tab_id.intValue() != 3 && frsTabInfo.tab_id.intValue() != 4 && frsTabInfo.tab_id.intValue() != 2) {
                        i iVar = new i();
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            iVar.bNm = frsTabInfo.tab_id.intValue();
                            iVar.name = frsTabInfo.tab_name;
                            this.bFN.add(iVar);
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
                                sb.append(oVar.aIk().getId());
                                iVar.url = sb.toString();
                                if (!TextUtils.isEmpty(iVar.url)) {
                                }
                                iVar.bNm = frsTabInfo.tab_id.intValue();
                                iVar.name = frsTabInfo.tab_name;
                                if (frsTabInfo.tab_type.intValue() != 11) {
                                }
                                if (frsTabInfo.tab_id.intValue() == 1) {
                                }
                                if (frsTabInfo.tab_id.intValue() == 1) {
                                }
                            }
                        } else if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                            if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                                if (frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.hO(frsTabInfo.tab_id.intValue())) {
                                }
                                if (!TextUtils.isEmpty(iVar.url)) {
                                    try {
                                        uri = new URI(iVar.url);
                                    } catch (URISyntaxException e) {
                                        BdLog.e(e);
                                        uri = null;
                                    }
                                    if (uri != null) {
                                        String host = uri.getHost();
                                        at atVar = new at("c10078");
                                        atVar.ab("obj_type", host);
                                        TiebaStatic.log(atVar);
                                    }
                                }
                                iVar.bNm = frsTabInfo.tab_id.intValue();
                                iVar.name = frsTabInfo.tab_name;
                                if (frsTabInfo.tab_type.intValue() != 11 && HorizontalTabView.hO(frsTabInfo.tab_id.intValue())) {
                                    iVar.url = frsTabInfo.tab_url;
                                    if (Static.bZ(iVar.url)) {
                                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                            this.bFN.add(iVar);
                                        }
                                    } else {
                                        this.bFN.add(iVar);
                                    }
                                } else if (frsTabInfo.tab_id.intValue() == 1 && bz.XY().hm(frsTabInfo.tab_id.intValue())) {
                                    bx hj = bw.XX().hj(iVar.bNm);
                                    if (hj != null && hj.bBA != null && hj.bBA.size() > 0) {
                                        iVar.bNn = new cy();
                                        iVar.bNn.bBz = hj.bBz;
                                        iVar.bNn.bBA = new LinkedList();
                                        boolean z2 = true;
                                        for (bv bvVar : hj.bBA) {
                                            if (bvVar != null) {
                                                cx cxVar = new cx();
                                                cxVar.name = bvVar.name;
                                                cxVar.bBw = bvVar.bBw;
                                                if (z2) {
                                                    cxVar.isSelected = true;
                                                    z = false;
                                                } else {
                                                    z = z2;
                                                }
                                                iVar.bNn.bBA.add(cxVar);
                                                z2 = z;
                                            }
                                        }
                                    }
                                    this.bFN.add(iVar);
                                } else if (frsTabInfo.tab_id.intValue() == 1) {
                                    bx hj2 = bw.XX().hj(iVar.bNm);
                                    if (hj2 != null && hj2.bBA != null && hj2.bBA.size() > 0) {
                                        iVar.bNn = new cy();
                                        iVar.bNn.bBz = hj2.bBz;
                                        iVar.bNn.bBA = new LinkedList();
                                        for (bv bvVar2 : hj2.bBA) {
                                            if (bvVar2 != null) {
                                                cx cxVar2 = new cx();
                                                cxVar2.name = bvVar2.name;
                                                cxVar2.bBw = bvVar2.bBw;
                                                iVar.bNn.bBA.add(cxVar2);
                                            }
                                        }
                                    }
                                    this.bFN.add(iVar);
                                }
                            }
                        }
                    }
                }
            }
            this.bFJ.d(this.bFN, oVar.bet(), 4);
            if (!this.bFM) {
                b(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void dR(boolean z) {
        if (this.bFK != null) {
            if (z) {
                this.bFK.Zr();
            } else {
                this.bFK.Zs();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData Zd() {
        return this.bFN;
    }

    private void d(o oVar) {
        if (oVar == null || oVar.beq() == null || oVar.beq().size() == 0) {
            bw.XX().a(1, null);
            return;
        }
        List<CategoryInfo> beq = oVar.beq();
        bx bxVar = new bx();
        bxVar.bBz = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < beq.size()) {
                if (beq.get(i2) != null) {
                    bv bvVar = new bv();
                    bvVar.bBw = beq.get(i2).category_id.intValue();
                    bvVar.name = beq.get(i2).category_name;
                    arrayList.add(bvVar);
                }
                i = i2 + 1;
            } else {
                bxVar.bBA = arrayList;
                bw.XX().a(1, bxVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View Ze() {
        if (this.bFK == null) {
            return null;
        }
        return this.bFK.Zp();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View Zf() {
        return this.Gu;
    }
}
