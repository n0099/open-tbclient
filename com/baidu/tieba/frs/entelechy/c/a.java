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
import com.baidu.tieba.t;
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
    private final String bWO = "1";
    private final String bWP = "obj_param1";
    private final String bWQ = "obj_param2";
    private final String bWR = "2";
    private final String bWS = "1";
    private final int bWT = 99;
    private dg bWU = new b(this);
    private HorizontalTabView.a bWV = new c(this);

    public a(FrsActivity frsActivity) {
        this.bWI = null;
        this.bWH = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds80);
        this.Gs = new LinearLayout(frsActivity.getActivity());
        this.Gs.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bWI = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bWI.cdo = k.e(frsActivity.getActivity(), t.e.ds20);
        this.bWI.setAutoFillTabCount(4);
        this.bWI.setmShowMenuCallBack(this.bWV);
        this.bWI.setNeedBottomLine(false);
        this.bWI.setTabBackgroudColor(t.d.cp_bg_line_d);
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
            this.bWI.wq();
        }
        if (this.bWJ != null) {
            this.bWJ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(dg dgVar) {
        if (this.bWI != null) {
            this.bWI.setDataLoadInterface(this.bWU);
        }
        this.bWK = dgVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ae(View view) {
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
        if (pVar != null && pVar.bhE() != null && pVar.bhE().tab != null) {
            this.bWJ.i(pVar.bhE().menu, i);
            if (pVar.aLP() != null) {
                this.bWJ.hi(pVar.aLP().getId());
            }
            this.bWN = pVar;
            d(pVar);
            this.bWM = new TabData();
            for (FrsTabInfo frsTabInfo : pVar.bhE().tab) {
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
                                sb.append(pVar.aLP().getId());
                                iVar.url = sb.toString();
                                if (!TextUtils.isEmpty(iVar.url)) {
                                }
                                iVar.bHI = frsTabInfo.tab_id.intValue();
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
                                if (frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.iu(frsTabInfo.tab_id.intValue())) {
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
                                iVar.bHI = frsTabInfo.tab_id.intValue();
                                iVar.name = frsTabInfo.tab_name;
                                if (frsTabInfo.tab_type.intValue() != 11 && HorizontalTabView.iu(frsTabInfo.tab_id.intValue())) {
                                    iVar.url = frsTabInfo.tab_url;
                                    if (Static.bX(iVar.url)) {
                                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                            this.bWM.add(iVar);
                                        }
                                    } else {
                                        this.bWM.add(iVar);
                                    }
                                } else if (frsTabInfo.tab_id.intValue() == 1 && dc.acm().hY(frsTabInfo.tab_id.intValue())) {
                                    da hV = cz.acl().hV(iVar.bHI);
                                    if (hV != null && hV.bTt != null && hV.bTt.size() > 0) {
                                        iVar.cdE = new du();
                                        iVar.cdE.bTs = hV.bTs;
                                        iVar.cdE.bTt = new LinkedList();
                                        boolean z2 = true;
                                        for (cy cyVar : hV.bTt) {
                                            if (cyVar != null) {
                                                dt dtVar = new dt();
                                                dtVar.name = cyVar.name;
                                                dtVar.bTp = cyVar.bTp;
                                                if (z2) {
                                                    dtVar.isSelected = true;
                                                    z = false;
                                                } else {
                                                    z = z2;
                                                }
                                                iVar.cdE.bTt.add(dtVar);
                                                z2 = z;
                                            }
                                        }
                                    }
                                    this.bWM.add(iVar);
                                } else if (frsTabInfo.tab_id.intValue() == 1) {
                                    da hV2 = cz.acl().hV(iVar.bHI);
                                    if (hV2 != null && hV2.bTt != null && hV2.bTt.size() > 0) {
                                        iVar.cdE = new du();
                                        iVar.cdE.bTs = hV2.bTs;
                                        iVar.cdE.bTt = new LinkedList();
                                        for (cy cyVar2 : hV2.bTt) {
                                            if (cyVar2 != null) {
                                                dt dtVar2 = new dt();
                                                dtVar2.name = cyVar2.name;
                                                dtVar2.bTp = cyVar2.bTp;
                                                iVar.cdE.bTt.add(dtVar2);
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
            this.bWI.d(this.bWM, pVar.bhz(), 4);
            if (!this.bWL) {
                b(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void dV(boolean z) {
        if (this.bWJ != null) {
            if (z) {
                this.bWJ.adp();
            } else {
                this.bWJ.adq();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData adh() {
        return this.bWM;
    }

    private void d(p pVar) {
        if (pVar == null || pVar.bhw() == null || pVar.bhw().size() == 0) {
            cz.acl().a(1, null);
            return;
        }
        List<CategoryInfo> bhw = pVar.bhw();
        da daVar = new da();
        daVar.bTs = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bhw.size()) {
                if (bhw.get(i2) != null) {
                    cy cyVar = new cy();
                    cyVar.bTp = bhw.get(i2).category_id.intValue();
                    cyVar.name = bhw.get(i2).category_name;
                    arrayList.add(cyVar);
                }
                i = i2 + 1;
            } else {
                daVar.bTt = arrayList;
                cz.acl().a(1, daVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View adi() {
        if (this.bWJ == null) {
            return null;
        }
        return this.bWJ.adi();
    }
}
