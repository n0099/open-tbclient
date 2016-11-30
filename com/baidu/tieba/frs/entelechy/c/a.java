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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.p;
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
    private FrsActivity bZY;
    private HorizontalTabView bZZ;
    private com.baidu.tieba.frs.entelechy.c.a.a caa;
    private ce cab;
    private TabData cad;
    private p cae;
    private boolean cac = false;
    private ce caf = new b(this);
    private HorizontalTabView.a cag = new c(this);

    public a(FrsActivity frsActivity) {
        this.bZZ = null;
        this.bZY = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds80);
        this.Gu = new LinearLayout(frsActivity.getActivity());
        this.Gu.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bZZ = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bZZ.chn = k.e(frsActivity.getActivity(), r.e.ds20);
        this.bZZ.setAutoFillTabCount(4);
        this.bZZ.setmShowMenuCallBack(this.cag);
        this.bZZ.setNeedBottomLine(false);
        this.bZZ.setTabBackgroudColor(r.d.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bZZ.setLayoutParams(layoutParams);
        this.Gu.addView(this.bZZ);
        this.caa = new com.baidu.tieba.frs.entelechy.c.a.a(this.bZY, this.Gu);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bZZ != null) {
            this.bZZ.wM();
        }
        if (this.caa != null) {
            this.caa.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(ce ceVar) {
        if (this.bZZ != null) {
            this.bZZ.setDataLoadInterface(this.caf);
        }
        this.cab = ceVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ae(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void u(BdListView bdListView) {
        if (this.Gu != null && bdListView != null) {
            bdListView.removeHeaderView(this.Gu);
            this.cac = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView, int i) {
        if (this.Gu != null && !this.cac) {
            if (!this.bZY.ach()) {
                bdListView.addHeaderView(this.Gu, Integer.valueOf(i), false);
            }
            this.cac = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0256 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    @Override // com.baidu.tieba.frs.entelechy.b.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdListView bdListView, p pVar, int i) {
        boolean z;
        URI uri;
        if (pVar != null && pVar.bkJ() != null && pVar.bkJ().tab != null) {
            this.caa.i(pVar.bkJ().menu, i);
            if (pVar.aOk() != null) {
                this.caa.setFid(pVar.aOk().getId());
            }
            this.cae = pVar;
            d(pVar);
            this.cad = new TabData();
            for (FrsTabInfo frsTabInfo : pVar.bkJ().tab) {
                if (frsTabInfo != null && frsTabInfo.tab_id.intValue() > 0 && !TextUtils.isEmpty(frsTabInfo.tab_name) && !TextUtils.isEmpty(frsTabInfo.tab_name.trim()) && (frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11)) {
                    if (frsTabInfo.tab_id.intValue() != 3 && frsTabInfo.tab_id.intValue() != 4 && frsTabInfo.tab_id.intValue() != 2) {
                        i iVar = new i();
                        if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
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
                                sb.append(pVar.aOk().getId());
                                iVar.url = sb.toString();
                                if (!TextUtils.isEmpty(iVar.url)) {
                                }
                                iVar.chD = frsTabInfo.tab_id.intValue();
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
                                if (frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.iE(frsTabInfo.tab_id.intValue())) {
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
                                        av avVar = new av("c10078");
                                        avVar.ab("obj_type", host);
                                        TiebaStatic.log(avVar);
                                    }
                                }
                                iVar.chD = frsTabInfo.tab_id.intValue();
                                iVar.name = frsTabInfo.tab_name;
                                if (frsTabInfo.tab_type.intValue() != 11 && HorizontalTabView.iE(frsTabInfo.tab_id.intValue())) {
                                    iVar.url = frsTabInfo.tab_url;
                                    if (Static.bY(iVar.url)) {
                                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                            this.cad.add(iVar);
                                        }
                                    } else {
                                        this.cad.add(iVar);
                                    }
                                } else if (frsTabInfo.tab_id.intValue() == 1 && ca.adF().ib(frsTabInfo.tab_id.intValue())) {
                                    by hY = bx.adE().hY(iVar.chD);
                                    if (hY != null && hY.bVs != null && hY.bVs.size() > 0) {
                                        iVar.chE = new cy();
                                        iVar.chE.bVr = hY.bVr;
                                        iVar.chE.bVs = new LinkedList();
                                        boolean z2 = true;
                                        for (bw bwVar : hY.bVs) {
                                            if (bwVar != null) {
                                                cx cxVar = new cx();
                                                cxVar.name = bwVar.name;
                                                cxVar.bVo = bwVar.bVo;
                                                if (z2) {
                                                    cxVar.isSelected = true;
                                                    z = false;
                                                } else {
                                                    z = z2;
                                                }
                                                iVar.chE.bVs.add(cxVar);
                                                z2 = z;
                                            }
                                        }
                                    }
                                    this.cad.add(iVar);
                                } else if (frsTabInfo.tab_id.intValue() == 1) {
                                    by hY2 = bx.adE().hY(iVar.chD);
                                    if (hY2 != null && hY2.bVs != null && hY2.bVs.size() > 0) {
                                        iVar.chE = new cy();
                                        iVar.chE.bVr = hY2.bVr;
                                        iVar.chE.bVs = new LinkedList();
                                        for (bw bwVar2 : hY2.bVs) {
                                            if (bwVar2 != null) {
                                                cx cxVar2 = new cx();
                                                cxVar2.name = bwVar2.name;
                                                cxVar2.bVo = bwVar2.bVo;
                                                iVar.chE.bVs.add(cxVar2);
                                            }
                                        }
                                    }
                                    this.cad.add(iVar);
                                }
                            }
                        }
                    }
                }
            }
            this.bZZ.e(this.cad, pVar.bkD(), 4);
            if (!this.cac) {
                b(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eh(boolean z) {
        if (this.caa != null) {
            if (z) {
                this.caa.aeW();
            } else {
                this.caa.aeX();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData aeI() {
        return this.cad;
    }

    private void d(p pVar) {
        if (pVar == null || pVar.bkA() == null || pVar.bkA().size() == 0) {
            bx.adE().a(1, null);
            return;
        }
        List<CategoryInfo> bkA = pVar.bkA();
        by byVar = new by();
        byVar.bVr = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bkA.size()) {
                if (bkA.get(i2) != null) {
                    bw bwVar = new bw();
                    bwVar.bVo = bkA.get(i2).category_id.intValue();
                    bwVar.name = bkA.get(i2).category_name;
                    arrayList.add(bwVar);
                }
                i = i2 + 1;
            } else {
                byVar.bVs = arrayList;
                bx.adE().a(1, byVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View aeJ() {
        if (this.caa == null) {
            return null;
        }
        return this.caa.aeU();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View aeK() {
        return this.Gu;
    }
}
