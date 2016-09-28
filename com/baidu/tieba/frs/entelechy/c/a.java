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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.frs.da;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.du;
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
    private LinearLayout Gs;
    private FrsActivity bWH;
    private HorizontalTabView bWI;
    private com.baidu.tieba.frs.entelechy.c.a.a bWJ;
    private dg bWK;
    private TabData bWM;
    private p bWN;
    private boolean bWL = false;
    private dg bWO = new b(this);
    private HorizontalTabView.a bWP = new c(this);

    public a(FrsActivity frsActivity) {
        this.bWI = null;
        this.bWH = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds80);
        this.Gs = new LinearLayout(frsActivity.getActivity());
        this.Gs.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bWI = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bWI.cdm = k.e(frsActivity.getActivity(), r.e.ds20);
        this.bWI.setAutoFillTabCount(4);
        this.bWI.setmShowMenuCallBack(this.bWP);
        this.bWI.setNeedBottomLine(false);
        this.bWI.setTabBackgroudColor(r.d.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bWI.setLayoutParams(layoutParams);
        this.Gs.addView(this.bWI);
        this.bWJ = new com.baidu.tieba.frs.entelechy.c.a.a(this.bWH, this.Gs);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bWI != null) {
            this.bWI.wH();
        }
        if (this.bWJ != null) {
            this.bWJ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(dg dgVar) {
        if (this.bWI != null) {
            this.bWI.setDataLoadInterface(this.bWO);
        }
        this.bWK = dgVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ad(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void u(BdListView bdListView) {
        if (this.Gs != null && bdListView != null) {
            bdListView.removeHeaderView(this.Gs);
            this.bWL = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView, int i) {
        if (this.Gs != null && !this.bWL) {
            bdListView.addHeaderView(this.Gs, Integer.valueOf(i), false);
            this.bWL = true;
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
        if (pVar != null && pVar.bio() != null && pVar.bio().tab != null) {
            this.bWJ.i(pVar.bio().menu, i);
            if (pVar.aMr() != null) {
                this.bWJ.setFid(pVar.aMr().getId());
            }
            this.bWN = pVar;
            d(pVar);
            this.bWM = new TabData();
            for (FrsTabInfo frsTabInfo : pVar.bio().tab) {
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
                                sb.append(pVar.aMr().getId());
                                iVar.url = sb.toString();
                                if (!TextUtils.isEmpty(iVar.url)) {
                                }
                                iVar.cdC = frsTabInfo.tab_id.intValue();
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
                                if (frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.iz(frsTabInfo.tab_id.intValue())) {
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
                                        ax axVar = new ax("c10078");
                                        axVar.ab("obj_type", host);
                                        TiebaStatic.log(axVar);
                                    }
                                }
                                iVar.cdC = frsTabInfo.tab_id.intValue();
                                iVar.name = frsTabInfo.tab_name;
                                if (frsTabInfo.tab_type.intValue() != 11 && HorizontalTabView.iz(frsTabInfo.tab_id.intValue())) {
                                    iVar.url = frsTabInfo.tab_url;
                                    if (Static.bX(iVar.url)) {
                                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                            this.bWM.add(iVar);
                                        }
                                    } else {
                                        this.bWM.add(iVar);
                                    }
                                } else if (frsTabInfo.tab_id.intValue() == 1 && dc.acz().ic(frsTabInfo.tab_id.intValue())) {
                                    da hZ = cz.acy().hZ(iVar.cdC);
                                    if (hZ != null && hZ.bTm != null && hZ.bTm.size() > 0) {
                                        iVar.cdD = new du();
                                        iVar.cdD.bTl = hZ.bTl;
                                        iVar.cdD.bTm = new LinkedList();
                                        boolean z2 = true;
                                        for (cy cyVar : hZ.bTm) {
                                            if (cyVar != null) {
                                                dt dtVar = new dt();
                                                dtVar.name = cyVar.name;
                                                dtVar.bTi = cyVar.bTi;
                                                if (z2) {
                                                    dtVar.isSelected = true;
                                                    z = false;
                                                } else {
                                                    z = z2;
                                                }
                                                iVar.cdD.bTm.add(dtVar);
                                                z2 = z;
                                            }
                                        }
                                    }
                                    this.bWM.add(iVar);
                                } else if (frsTabInfo.tab_id.intValue() == 1) {
                                    da hZ2 = cz.acy().hZ(iVar.cdC);
                                    if (hZ2 != null && hZ2.bTm != null && hZ2.bTm.size() > 0) {
                                        iVar.cdD = new du();
                                        iVar.cdD.bTl = hZ2.bTl;
                                        iVar.cdD.bTm = new LinkedList();
                                        for (cy cyVar2 : hZ2.bTm) {
                                            if (cyVar2 != null) {
                                                dt dtVar2 = new dt();
                                                dtVar2.name = cyVar2.name;
                                                dtVar2.bTi = cyVar2.bTi;
                                                iVar.cdD.bTm.add(dtVar2);
                                            }
                                        }
                                    }
                                    this.bWM.add(iVar);
                                }
                            }
                        }
                    }
                }
            }
            this.bWI.d(this.bWM, pVar.bii(), 4);
            if (!this.bWL) {
                b(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void dW(boolean z) {
        if (this.bWJ != null) {
            if (z) {
                this.bWJ.adD();
            } else {
                this.bWJ.adE();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData adv() {
        return this.bWM;
    }

    private void d(p pVar) {
        if (pVar == null || pVar.bif() == null || pVar.bif().size() == 0) {
            cz.acy().a(1, null);
            return;
        }
        List<CategoryInfo> bif = pVar.bif();
        da daVar = new da();
        daVar.bTl = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bif.size()) {
                if (bif.get(i2) != null) {
                    cy cyVar = new cy();
                    cyVar.bTi = bif.get(i2).category_id.intValue();
                    cyVar.name = bif.get(i2).category_name;
                    arrayList.add(cyVar);
                }
                i = i2 + 1;
            } else {
                daVar.bTm = arrayList;
                cz.acy().a(1, daVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View adw() {
        if (this.bWJ == null) {
            return null;
        }
        return this.bWJ.adw();
    }
}
