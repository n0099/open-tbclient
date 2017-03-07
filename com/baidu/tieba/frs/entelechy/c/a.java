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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.bu;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.cu;
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
    private LinearLayout bLW;
    private FrsActivity bTf;
    private HorizontalTabView bTg;
    private com.baidu.tieba.frs.entelechy.c.a.a bTh;
    private cb bTi;
    private TabData bTk;
    private n bTl;
    private boolean bTj = false;
    private int liveCount = -1;
    private cb bTm = new b(this);
    private HorizontalTabView.a bTn = new c(this);

    public void hY(int i) {
        this.liveCount = i;
    }

    public a(FrsActivity frsActivity) {
        this.bTg = null;
        this.bTf = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds80);
        this.bLW = new LinearLayout(frsActivity.getActivity());
        this.bLW.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bTg = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bTg.caw = k.g(frsActivity.getActivity(), w.f.ds20);
        this.bTg.setAutoFillTabCount(4);
        this.bTg.setmShowMenuCallBack(this.bTn);
        this.bTg.setNeedBottomLine(false);
        this.bTg.setTabBackgroudColor(w.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bTg.setLayoutParams(layoutParams);
        this.bLW.addView(this.bTg);
        this.bTh = new com.baidu.tieba.frs.entelechy.c.a.a(this.bTf, this.bLW);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bTg != null) {
            this.bTg.wP();
        }
        if (this.bTh != null) {
            this.bTh.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(cb cbVar) {
        if (this.bTg != null) {
            this.bTg.setDataLoadInterface(this.bTm);
        }
        this.bTi = cbVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ah(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.bLW != null && bdListView != null) {
            bdListView.removeHeaderView(this.bLW);
            this.bTj = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.bLW != null && !this.bTj) {
            if (!this.bTf.YL()) {
                bdListView.addHeaderView(this.bLW, Integer.valueOf(i), false);
            }
            this.bTj = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, n nVar, int i) {
        boolean z;
        if (nVar != null && nVar.bga() != null && nVar.bga().tab != null) {
            this.bTh.i(nVar.bga().menu, i);
            if (nVar.aJp() != null) {
                this.bTh.setFid(nVar.aJp().getId());
            }
            this.bTl = nVar;
            c(nVar);
            this.bTk = new TabData();
            for (FrsTabInfo frsTabInfo : nVar.bga().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    i iVar = new i();
                    iVar.caM = frsTabInfo.tab_id.intValue();
                    iVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.bTk.add(iVar);
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
                            sb.append(nVar.aJp().getId());
                            iVar.url = sb.toString();
                            aI(iVar.url, "c10078");
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.ix(frsTabInfo.tab_id.intValue())) {
                        iVar.url = frsTabInfo.tab_url;
                        if (Static.bQ(iVar.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                this.bTk.add(iVar);
                            }
                        } else {
                            this.bTk.add(iVar);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && bx.aae().hU(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        bv hR = bu.aad().hR(iVar.caM);
                        if (hR != null && hR.bQd != null && hR.bQd.size() > 0) {
                            iVar.caN = new cu();
                            iVar.caN.bQc = hR.bQc;
                            iVar.caN.bQd = new LinkedList();
                            boolean z2 = true;
                            for (bt btVar : hR.bQd) {
                                if (btVar != null) {
                                    ct ctVar = new ct();
                                    ctVar.name = btVar.name;
                                    ctVar.bPZ = btVar.bPZ;
                                    if (z2) {
                                        ctVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    iVar.caN.bQd.add(ctVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.bTk.add(iVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        bv hR2 = bu.aad().hR(iVar.caM);
                        if (hR2 != null && hR2.bQd != null && hR2.bQd.size() > 0) {
                            iVar.caN = new cu();
                            iVar.caN.bQc = hR2.bQc;
                            iVar.caN.bQd = new LinkedList();
                            for (bt btVar2 : hR2.bQd) {
                                if (btVar2 != null) {
                                    ct ctVar2 = new ct();
                                    ctVar2.name = btVar2.name;
                                    ctVar2.bPZ = btVar2.bPZ;
                                    iVar.caN.bQd.add(ctVar2);
                                }
                            }
                        }
                        this.bTk.add(iVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.bTf.YE().ZG().l(bj.XN)) {
                        i iVar2 = new i();
                        iVar2.name = frsTabInfo.tab_name;
                        if (nVar.bfw() != 0 && nVar.bfw() <= 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + nVar.bfw() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != nVar.bfw() && this.liveCount <= 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || nVar.bfw() > 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != nVar.bfw()) {
                            iVar2.name = frsTabInfo.tab_name;
                        }
                        iVar2.caM = frsTabInfo.tab_id.intValue();
                        this.bTk.add(iVar2);
                    }
                }
            }
            this.bTg.d(this.bTk, nVar.bfU(), 12);
            if (!this.bTj) {
                a(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4 || frsTabInfo.tab_id.intValue() == 2;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.ix(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    as asVar = new as(str2);
                    asVar.Z("obj_type", host);
                    TiebaStatic.log(asVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView abo() {
        return this.bTg;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void dW(boolean z) {
        if (this.bTh != null) {
            if (z) {
                this.bTh.abr();
            } else {
                this.bTh.abs();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData abc() {
        return this.bTk;
    }

    private void c(n nVar) {
        if (nVar == null || nVar.bfR() == null || nVar.bfR().size() == 0) {
            bu.aad().a(1, null);
            return;
        }
        List<CategoryInfo> bfR = nVar.bfR();
        bv bvVar = new bv();
        bvVar.bQc = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bfR.size()) {
                if (bfR.get(i2) != null) {
                    bt btVar = new bt();
                    btVar.bPZ = bfR.get(i2).category_id.intValue();
                    btVar.name = bfR.get(i2).category_name;
                    arrayList.add(btVar);
                }
                i = i2 + 1;
            } else {
                bvVar.bQd = arrayList;
                bu.aad().a(1, bvVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View abd() {
        if (this.bTh == null) {
            return null;
        }
        return this.bTh.abp();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View abe() {
        return this.bLW;
    }
}
