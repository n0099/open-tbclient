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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.n;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a implements d {
    private LinearLayout FE;
    private FrsActivity bLZ;
    private HorizontalTabView bMa;
    private com.baidu.tieba.frs.entelechy.c.a.a bMb;
    private cb bMc;
    private TabData bMe;
    private n bMf;
    private boolean bMd = false;
    private int liveCount = -1;
    private cb bMg = new b(this);
    private HorizontalTabView.a bMh = new c(this);

    public void ic(int i) {
        this.liveCount = i;
    }

    public a(FrsActivity frsActivity) {
        this.bMa = null;
        this.bLZ = frsActivity;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds80);
        this.FE = new LinearLayout(frsActivity.getActivity());
        this.FE.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bMa = new HorizontalTabView(frsActivity.getPageContext().getPageActivity());
        this.bMa.bTk = k.e(frsActivity.getActivity(), r.f.ds20);
        this.bMa.setAutoFillTabCount(4);
        this.bMa.setmShowMenuCallBack(this.bMh);
        this.bMa.setNeedBottomLine(false);
        this.bMa.setTabBackgroudColor(r.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.weight = 1.0f;
        this.bMa.setLayoutParams(layoutParams);
        this.FE.addView(this.bMa);
        this.bMb = new com.baidu.tieba.frs.entelechy.c.a.a(this.bLZ, this.FE);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.bMa != null) {
            this.bMa.ws();
        }
        if (this.bMb != null) {
            this.bMb.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(cb cbVar) {
        if (this.bMa != null) {
            this.bMa.setDataLoadInterface(this.bMg);
        }
        this.bMc = cbVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aj(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.FE != null && bdListView != null) {
            bdListView.removeHeaderView(this.FE);
            this.bMd = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.FE != null && !this.bMd) {
            if (!this.bLZ.XM()) {
                bdListView.addHeaderView(this.FE, Integer.valueOf(i), false);
            }
            this.bMd = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, n nVar, int i) {
        boolean z;
        if (nVar != null && nVar.bgn() != null && nVar.bgn().tab != null) {
            this.bMb.h(nVar.bgn().menu, i);
            if (nVar.aJY() != null) {
                this.bMb.setFid(nVar.aJY().getId());
            }
            this.bMf = nVar;
            c(nVar);
            this.bMe = new TabData();
            for (FrsTabInfo frsTabInfo : nVar.bgn().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    i iVar = new i();
                    iVar.bTA = frsTabInfo.tab_id.intValue();
                    iVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.bMe.add(iVar);
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
                            sb.append(nVar.aJY().getId());
                            iVar.url = sb.toString();
                            aK(iVar.url, "c10078");
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.iB(frsTabInfo.tab_id.intValue())) {
                        iVar.url = frsTabInfo.tab_url;
                        if (Static.bX(iVar.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                this.bMe.add(iVar);
                            }
                        } else {
                            this.bMe.add(iVar);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && bx.Zf().hY(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        bv hV = bu.Ze().hV(iVar.bTA);
                        if (hV != null && hV.bIU != null && hV.bIU.size() > 0) {
                            iVar.bTB = new cu();
                            iVar.bTB.bIT = hV.bIT;
                            iVar.bTB.bIU = new LinkedList();
                            boolean z2 = true;
                            for (bt btVar : hV.bIU) {
                                if (btVar != null) {
                                    ct ctVar = new ct();
                                    ctVar.name = btVar.name;
                                    ctVar.bIQ = btVar.bIQ;
                                    if (z2) {
                                        ctVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    iVar.bTB.bIU.add(ctVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.bMe.add(iVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        bv hV2 = bu.Ze().hV(iVar.bTA);
                        if (hV2 != null && hV2.bIU != null && hV2.bIU.size() > 0) {
                            iVar.bTB = new cu();
                            iVar.bTB.bIT = hV2.bIT;
                            iVar.bTB.bIU = new LinkedList();
                            for (bt btVar2 : hV2.bIU) {
                                if (btVar2 != null) {
                                    ct ctVar2 = new ct();
                                    ctVar2.name = btVar2.name;
                                    ctVar2.bIQ = btVar2.bIQ;
                                    iVar.bTB.bIU.add(ctVar2);
                                }
                            }
                        }
                        this.bMe.add(iVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.bLZ.XF().YH().l(bh.SA)) {
                        i iVar2 = new i();
                        iVar2.name = frsTabInfo.tab_name;
                        if (nVar.bfJ() != 0 && nVar.bfJ() <= 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + nVar.bfJ() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != nVar.bfJ() && this.liveCount <= 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || nVar.bfJ() > 99) {
                            iVar2.name = String.valueOf(frsTabInfo.tab_name) + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != nVar.bfJ()) {
                            iVar2.name = frsTabInfo.tab_name;
                        }
                        iVar2.bTA = frsTabInfo.tab_id.intValue();
                        this.bMe.add(iVar2);
                    }
                }
            }
            this.bMa.d(this.bMe, nVar.bgh(), 12);
            if (!this.bMd) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.iB(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    ar arVar = new ar(str2);
                    arVar.ab("obj_type", host);
                    TiebaStatic.log(arVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView aar() {
        return this.bMa;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void dW(boolean z) {
        if (this.bMb != null) {
            if (z) {
                this.bMb.aau();
            } else {
                this.bMb.aav();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData aaf() {
        return this.bMe;
    }

    private void c(n nVar) {
        if (nVar == null || nVar.bge() == null || nVar.bge().size() == 0) {
            bu.Ze().a(1, null);
            return;
        }
        List<CategoryInfo> bge = nVar.bge();
        bv bvVar = new bv();
        bvVar.bIT = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bge.size()) {
                if (bge.get(i2) != null) {
                    bt btVar = new bt();
                    btVar.bIQ = bge.get(i2).category_id.intValue();
                    btVar.name = bge.get(i2).category_name;
                    arrayList.add(btVar);
                }
                i = i2 + 1;
            } else {
                bvVar.bIU = arrayList;
                bu.Ze().a(1, bvVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View aag() {
        if (this.bMb == null) {
            return null;
        }
        return this.bMb.aas();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View aah() {
        return this.FE;
    }
}
