package com.baidu.tieba.frs.entelechy.tabView;

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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.dl;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.frs.dz;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.u;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a implements d {
    private LinearLayout DF;
    private FrsActivity bJR;
    private HorizontalTabView bJS;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a bJT;
    private dl bJU;
    private TabData bJW;
    private p bJX;
    private boolean bJV = false;
    private dl bJY = new b(this);
    private HorizontalTabView.a bJZ = new c(this);

    public a(FrsActivity frsActivity) {
        this.bJS = null;
        this.bJR = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds80);
        this.DF = new LinearLayout(frsActivity.getActivity());
        this.DF.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bJS = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bJS.bQk = k.c(frsActivity.getActivity(), u.e.ds20);
        this.bJS.setAutoFillTabCount(4);
        this.bJS.setmShowMenuCallBack(this.bJZ);
        this.bJS.setNeedBottomLine(false);
        this.bJS.setTabBackgroudColor(u.d.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bJS.setLayoutParams(layoutParams);
        this.DF.addView(this.bJS);
        this.bJT = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.bJR, this.DF);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bJS != null) {
            this.bJS.vm();
        }
        if (this.bJT != null) {
            this.bJT.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(dl dlVar) {
        if (this.bJS != null) {
            this.bJS.setDataLoadInterface(this.bJY);
        }
        this.bJU = dlVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ag(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void u(BdListView bdListView) {
        if (this.DF != null && bdListView != null) {
            bdListView.removeHeaderView(this.DF);
            this.bJV = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView, int i) {
        if (this.DF != null && !this.bJV) {
            bdListView.addHeaderView(this.DF, Integer.valueOf(i), false);
            this.bJV = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0243 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011d  */
    @Override // com.baidu.tieba.frs.entelechy.b.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdListView bdListView, p pVar, int i) {
        boolean z;
        URI uri;
        if (pVar != null && pVar.baL() != null && pVar.baL().tab != null) {
            this.bJT.h(pVar.baL().menu, i);
            this.bJX = pVar;
            d(pVar);
            this.bJW = new TabData();
            for (FrsTabInfo frsTabInfo : pVar.baL().tab) {
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
                                sb.append(pVar.aDN().getId());
                                iVar.url = sb.toString();
                                if (!TextUtils.isEmpty(iVar.url)) {
                                }
                                iVar.bug = frsTabInfo.tab_id.intValue();
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
                                if (frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.hQ(frsTabInfo.tab_id.intValue())) {
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
                                        ay ayVar = new ay("c10078");
                                        ayVar.ab("obj_type", host);
                                        TiebaStatic.log(ayVar);
                                    }
                                }
                                iVar.bug = frsTabInfo.tab_id.intValue();
                                iVar.name = frsTabInfo.tab_name;
                                if (frsTabInfo.tab_type.intValue() != 11 && HorizontalTabView.hQ(frsTabInfo.tab_id.intValue())) {
                                    iVar.url = frsTabInfo.tab_url;
                                    if (Static.bV(iVar.url)) {
                                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                            this.bJW.add(iVar);
                                        }
                                    } else {
                                        this.bJW.add(iVar);
                                    }
                                } else if (frsTabInfo.tab_id.intValue() == 1 && dg.WX().hw(frsTabInfo.tab_id.intValue())) {
                                    de ht = dd.WW().ht(iVar.bug);
                                    if (ht != null && ht.bGR != null && ht.bGR.size() > 0) {
                                        iVar.bQA = new dz();
                                        iVar.bQA.bGQ = ht.bGQ;
                                        iVar.bQA.bGR = new LinkedList();
                                        boolean z2 = true;
                                        for (dc dcVar : ht.bGR) {
                                            if (dcVar != null) {
                                                dy dyVar = new dy();
                                                dyVar.name = dcVar.name;
                                                dyVar.bGN = dcVar.bGN;
                                                if (z2) {
                                                    dyVar.isSelected = true;
                                                    z = false;
                                                } else {
                                                    z = z2;
                                                }
                                                iVar.bQA.bGR.add(dyVar);
                                                z2 = z;
                                            }
                                        }
                                    }
                                    this.bJW.add(iVar);
                                } else if (frsTabInfo.tab_id.intValue() == 1) {
                                    de ht2 = dd.WW().ht(iVar.bug);
                                    if (ht2 != null && ht2.bGR != null && ht2.bGR.size() > 0) {
                                        iVar.bQA = new dz();
                                        iVar.bQA.bGQ = ht2.bGQ;
                                        iVar.bQA.bGR = new LinkedList();
                                        for (dc dcVar2 : ht2.bGR) {
                                            if (dcVar2 != null) {
                                                dy dyVar2 = new dy();
                                                dyVar2.name = dcVar2.name;
                                                dyVar2.bGN = dcVar2.bGN;
                                                iVar.bQA.bGR.add(dyVar2);
                                            }
                                        }
                                    }
                                    this.bJW.add(iVar);
                                }
                            }
                        }
                    }
                }
            }
            this.bJS.d(this.bJW, pVar.baH(), 4);
            if (!this.bJV) {
                b(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void dB(boolean z) {
        if (this.bJT != null) {
            if (z) {
                this.bJT.Yj();
            } else {
                this.bJT.Yk();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData Yb() {
        return this.bJW;
    }

    private void d(p pVar) {
        if (pVar == null || pVar.baE() == null || pVar.baE().size() == 0) {
            dd.WW().a(1, null);
            return;
        }
        List<CategoryInfo> baE = pVar.baE();
        de deVar = new de();
        deVar.bGQ = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < baE.size()) {
                if (baE.get(i2) != null) {
                    dc dcVar = new dc();
                    dcVar.bGN = baE.get(i2).category_id.intValue();
                    dcVar.name = baE.get(i2).category_name;
                    arrayList.add(dcVar);
                }
                i = i2 + 1;
            } else {
                deVar.bGR = arrayList;
                dd.WW().a(1, deVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View Yc() {
        if (this.bJT == null) {
            return null;
        }
        return this.bJT.Yc();
    }
}
