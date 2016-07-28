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
    private LinearLayout Ef;
    private dl bLA;
    private TabData bLC;
    private p bLD;
    private FrsActivity bLx;
    private HorizontalTabView bLy;
    private com.baidu.tieba.frs.entelechy.c.a.a bLz;
    private boolean bLB = false;
    private dl bLE = new b(this);
    private HorizontalTabView.a bLF = new c(this);

    public a(FrsActivity frsActivity) {
        this.bLy = null;
        this.bLx = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds80);
        this.Ef = new LinearLayout(frsActivity.getActivity());
        this.Ef.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bLy = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bLy.bSi = k.c(frsActivity.getActivity(), u.e.ds20);
        this.bLy.setAutoFillTabCount(4);
        this.bLy.setmShowMenuCallBack(this.bLF);
        this.bLy.setNeedBottomLine(false);
        this.bLy.setTabBackgroudColor(u.d.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bLy.setLayoutParams(layoutParams);
        this.Ef.addView(this.bLy);
        this.bLz = new com.baidu.tieba.frs.entelechy.c.a.a(this.bLx, this.Ef);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bLy != null) {
            this.bLy.vm();
        }
        if (this.bLz != null) {
            this.bLz.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(dl dlVar) {
        if (this.bLy != null) {
            this.bLy.setDataLoadInterface(this.bLE);
        }
        this.bLA = dlVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ae(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void u(BdListView bdListView) {
        if (this.Ef != null && bdListView != null) {
            bdListView.removeHeaderView(this.Ef);
            this.bLB = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView, int i) {
        if (this.Ef != null && !this.bLB) {
            bdListView.addHeaderView(this.Ef, Integer.valueOf(i), false);
            this.bLB = true;
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
        if (pVar != null && pVar.bdZ() != null && pVar.bdZ().tab != null) {
            this.bLz.i(pVar.bdZ().menu, i);
            if (pVar.aGX() != null) {
                this.bLz.gF(pVar.aGX().getId());
            }
            this.bLD = pVar;
            d(pVar);
            this.bLC = new TabData();
            for (FrsTabInfo frsTabInfo : pVar.bdZ().tab) {
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
                                sb.append(pVar.aGX().getId());
                                iVar.url = sb.toString();
                                if (!TextUtils.isEmpty(iVar.url)) {
                                }
                                iVar.bwu = frsTabInfo.tab_id.intValue();
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
                                if (frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.hR(frsTabInfo.tab_id.intValue())) {
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
                                iVar.bwu = frsTabInfo.tab_id.intValue();
                                iVar.name = frsTabInfo.tab_name;
                                if (frsTabInfo.tab_type.intValue() != 11 && HorizontalTabView.hR(frsTabInfo.tab_id.intValue())) {
                                    iVar.url = frsTabInfo.tab_url;
                                    if (Static.bW(iVar.url)) {
                                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                            this.bLC.add(iVar);
                                        }
                                    } else {
                                        this.bLC.add(iVar);
                                    }
                                } else if (frsTabInfo.tab_id.intValue() == 1 && dg.Xp().hv(frsTabInfo.tab_id.intValue())) {
                                    de hs = dd.Xo().hs(iVar.bwu);
                                    if (hs != null && hs.bIn != null && hs.bIn.size() > 0) {
                                        iVar.bSy = new dz();
                                        iVar.bSy.bIm = hs.bIm;
                                        iVar.bSy.bIn = new LinkedList();
                                        boolean z2 = true;
                                        for (dc dcVar : hs.bIn) {
                                            if (dcVar != null) {
                                                dy dyVar = new dy();
                                                dyVar.name = dcVar.name;
                                                dyVar.bIj = dcVar.bIj;
                                                if (z2) {
                                                    dyVar.isSelected = true;
                                                    z = false;
                                                } else {
                                                    z = z2;
                                                }
                                                iVar.bSy.bIn.add(dyVar);
                                                z2 = z;
                                            }
                                        }
                                    }
                                    this.bLC.add(iVar);
                                } else if (frsTabInfo.tab_id.intValue() == 1) {
                                    de hs2 = dd.Xo().hs(iVar.bwu);
                                    if (hs2 != null && hs2.bIn != null && hs2.bIn.size() > 0) {
                                        iVar.bSy = new dz();
                                        iVar.bSy.bIm = hs2.bIm;
                                        iVar.bSy.bIn = new LinkedList();
                                        for (dc dcVar2 : hs2.bIn) {
                                            if (dcVar2 != null) {
                                                dy dyVar2 = new dy();
                                                dyVar2.name = dcVar2.name;
                                                dyVar2.bIj = dcVar2.bIj;
                                                iVar.bSy.bIn.add(dyVar2);
                                            }
                                        }
                                    }
                                    this.bLC.add(iVar);
                                }
                            }
                        }
                    }
                }
            }
            this.bLy.d(this.bLC, pVar.bdV(), 4);
            if (!this.bLB) {
                b(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void dz(boolean z) {
        if (this.bLz != null) {
            if (z) {
                this.bLz.YD();
            } else {
                this.bLz.YE();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData Yv() {
        return this.bLC;
    }

    private void d(p pVar) {
        if (pVar == null || pVar.bdS() == null || pVar.bdS().size() == 0) {
            dd.Xo().a(1, null);
            return;
        }
        List<CategoryInfo> bdS = pVar.bdS();
        de deVar = new de();
        deVar.bIm = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bdS.size()) {
                if (bdS.get(i2) != null) {
                    dc dcVar = new dc();
                    dcVar.bIj = bdS.get(i2).category_id.intValue();
                    dcVar.name = bdS.get(i2).category_name;
                    arrayList.add(dcVar);
                }
                i = i2 + 1;
            } else {
                deVar.bIn = arrayList;
                dd.Xo().a(1, deVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View Yw() {
        if (this.bLz == null) {
            return null;
        }
        return this.bLz.Yw();
    }
}
