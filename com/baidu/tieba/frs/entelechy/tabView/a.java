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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.em;
import com.baidu.tieba.frs.en;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.eo;
import com.baidu.tieba.frs.eq;
import com.baidu.tieba.frs.fg;
import com.baidu.tieba.frs.ft;
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.t;
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
    private LinearLayout DE;
    private FrsActivity bpj;
    private HorizontalTabView bpk;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a bpl;
    private fg bpm;
    private TabData bpo;
    private o bpp;
    private boolean bpn = false;
    private fg bpq = new b(this);
    private HorizontalTabView.a bpr = new c(this);

    public a(FrsActivity frsActivity) {
        this.bpk = null;
        this.bpj = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds80);
        this.DE = new LinearLayout(frsActivity.getActivity());
        this.DE.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bpk = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bpk.bsG = k.c(frsActivity.getActivity(), t.e.ds20);
        this.bpk.setAutoFillTabCount(4);
        this.bpk.setmShowMenuCallBack(this.bpr);
        this.bpk.setNeedBottomLine(false);
        this.bpk.setTabBackgroudColor(t.d.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bpk.setLayoutParams(layoutParams);
        this.DE.addView(this.bpk);
        this.bpl = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.bpj, this.DE);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bpk != null) {
            this.bpk.vl();
        }
        if (this.bpl != null) {
            this.bpl.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(fg fgVar) {
        if (this.bpk != null) {
            this.bpk.setDataLoadInterface(this.bpq);
        }
        this.bpm = fgVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ae(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void u(BdListView bdListView) {
        if (this.DE != null && bdListView != null) {
            bdListView.removeHeaderView(this.DE);
            this.bpn = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView, int i) {
        if (this.DE != null && !this.bpn) {
            bdListView.addHeaderView(this.DE, Integer.valueOf(i), false);
            this.bpn = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0243 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011d  */
    @Override // com.baidu.tieba.frs.entelechy.b.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdListView bdListView, o oVar) {
        boolean z;
        URI uri;
        if (oVar != null && oVar.aSy() != null && oVar.aSy().tab != null) {
            this.bpl.setData(oVar.aSy().menu);
            this.bpp = oVar;
            c(oVar);
            this.bpo = new TabData();
            for (FrsTabInfo frsTabInfo : oVar.aSy().tab) {
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
                                sb.append(oVar.avA().getId());
                                iVar.url = sb.toString();
                                if (!TextUtils.isEmpty(iVar.url)) {
                                }
                                iVar.aYo = frsTabInfo.tab_id.intValue();
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
                                if (frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.gM(frsTabInfo.tab_id.intValue())) {
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
                                        aw awVar = new aw("c10078");
                                        awVar.ac("obj_type", host);
                                        TiebaStatic.log(awVar);
                                    }
                                }
                                iVar.aYo = frsTabInfo.tab_id.intValue();
                                iVar.name = frsTabInfo.tab_name;
                                if (frsTabInfo.tab_type.intValue() != 11 && HorizontalTabView.gM(frsTabInfo.tab_id.intValue())) {
                                    iVar.url = frsTabInfo.tab_url;
                                    if (Static.bW(iVar.url)) {
                                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                            this.bpo.add(iVar);
                                        }
                                    } else {
                                        this.bpo.add(iVar);
                                    }
                                } else if (frsTabInfo.tab_id.intValue() == 1 && eq.RD().gw(frsTabInfo.tab_id.intValue())) {
                                    eo gt = en.RC().gt(iVar.aYo);
                                    if (gt != null && gt.bmd != null && gt.bmd.size() > 0) {
                                        iVar.bsW = new fu();
                                        iVar.bsW.bmc = gt.bmc;
                                        iVar.bsW.bmd = new LinkedList();
                                        boolean z2 = true;
                                        for (em emVar : gt.bmd) {
                                            if (emVar != null) {
                                                ft ftVar = new ft();
                                                ftVar.name = emVar.name;
                                                ftVar.blZ = emVar.blZ;
                                                if (z2) {
                                                    ftVar.isSelected = true;
                                                    z = false;
                                                } else {
                                                    z = z2;
                                                }
                                                iVar.bsW.bmd.add(ftVar);
                                                z2 = z;
                                            }
                                        }
                                    }
                                    this.bpo.add(iVar);
                                } else if (frsTabInfo.tab_id.intValue() == 1) {
                                    eo gt2 = en.RC().gt(iVar.aYo);
                                    if (gt2 != null && gt2.bmd != null && gt2.bmd.size() > 0) {
                                        iVar.bsW = new fu();
                                        iVar.bsW.bmc = gt2.bmc;
                                        iVar.bsW.bmd = new LinkedList();
                                        for (em emVar2 : gt2.bmd) {
                                            if (emVar2 != null) {
                                                ft ftVar2 = new ft();
                                                ftVar2.name = emVar2.name;
                                                ftVar2.blZ = emVar2.blZ;
                                                iVar.bsW.bmd.add(ftVar2);
                                            }
                                        }
                                    }
                                    this.bpo.add(iVar);
                                }
                            }
                        }
                    }
                }
            }
            this.bpk.c(this.bpo, oVar.aSu(), 4);
            if (!this.bpn) {
                b(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void de(boolean z) {
        if (this.bpl != null) {
            if (z) {
                this.bpl.SI();
            } else {
                this.bpl.SJ();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData SD() {
        return this.bpo;
    }

    private void c(o oVar) {
        if (oVar == null || oVar.aSr() == null || oVar.aSr().size() == 0) {
            en.RC().a(1, null);
            return;
        }
        List<CategoryInfo> aSr = oVar.aSr();
        eo eoVar = new eo();
        eoVar.bmc = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < aSr.size()) {
                if (aSr.get(i2) != null) {
                    em emVar = new em();
                    emVar.blZ = aSr.get(i2).category_id.intValue();
                    emVar.name = aSr.get(i2).category_name;
                    arrayList.add(emVar);
                }
                i = i2 + 1;
            } else {
                eoVar.bmd = arrayList;
                en.RC().a(1, eoVar);
                return;
            }
        }
    }
}
