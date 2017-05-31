package com.baidu.tieba.frs.entelechy.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.browser.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.tab.j;
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
public class a implements com.baidu.tieba.frs.entelechy.b.d {
    private r bTw;
    private HorizontalTabView bYW;
    private com.baidu.tieba.frs.entelechy.c.a.a bYX;
    private by bYY;
    private TabData bZa;
    private n bZb;
    private LinearLayout mRootLayout;
    private boolean bYZ = false;
    private int liveCount = -1;
    private by bZc = new b(this);
    private HorizontalTabView.c bZd = new c(this);

    public void iv(int i) {
        this.liveCount = i;
    }

    public a(r rVar) {
        this.bYW = null;
        this.bTw = rVar;
        int dimensionPixelSize = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds114);
        this.mRootLayout = new LinearLayout(rVar.getActivity());
        aq.k(this.mRootLayout, w.e.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bYW = new HorizontalTabView(rVar.getPageContext());
        this.bYW.setForNewFrame(true);
        this.bYW.cfn = k.g(rVar.getActivity(), w.f.ds20);
        this.bYW.setAutoFillTabCount(4);
        this.bYW.setmShowMenuCallBack(this.bZd);
        this.bYW.setNeedBottomLine(false);
        this.bYW.setTabBackgroudColor(w.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = k.g(rVar.getActivity(), w.f.ds26);
        layoutParams.weight = 1.0f;
        this.bYW.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.bYW);
        this.bYX = new com.baidu.tieba.frs.entelechy.c.a.a(this.bTw, this.mRootLayout);
        this.bYW.setOnTabItemClickListener(new d(this));
        this.bYW.setOnTabItemSelectListener(new e(this));
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.mRootLayout != null) {
            aq.k(this.mRootLayout, w.e.cp_bg_line_d);
        }
        if (this.bYW != null) {
            this.bYW.ws();
        }
        if (this.bYX != null) {
            this.bYX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(by byVar) {
        if (this.bYW != null) {
            this.bYW.setDataLoadInterface(this.bZc);
        }
        this.bYY = byVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void af(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.bYZ = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.bYZ) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.bYZ = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, n nVar, int i) {
        boolean z;
        if (nVar != null && nVar.bgM() != null && nVar.bgM().tab != null) {
            this.bYX.i(nVar.bgM().menu, i);
            if (nVar.aIz() != null) {
                this.bYX.setFid(nVar.aIz().getId());
            }
            this.bZb = nVar;
            b(nVar);
            this.bZa = new TabData();
            for (FrsTabInfo frsTabInfo : nVar.bgM().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    j jVar = new j();
                    jVar.cfI = frsTabInfo.tab_id.intValue();
                    jVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.bZa.add(jVar);
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
                            sb.append(nVar.aIz().getId());
                            jVar.url = sb.toString();
                            aJ(jVar.url, "c10078");
                            this.bZa.add(jVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.iU(frsTabInfo.tab_id.intValue())) {
                        jVar.url = frsTabInfo.tab_url;
                        if (i.bX(jVar.url)) {
                            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                this.bZa.add(jVar);
                            }
                        } else {
                            this.bZa.add(jVar);
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && bt.abe().ir(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        br io = bq.abd().io(jVar.cfI);
                        if (io != null && io.bWM != null && io.bWM.size() > 0) {
                            jVar.cfJ = new co();
                            jVar.cfJ.bWL = io.bWL;
                            jVar.cfJ.bWM = new LinkedList();
                            boolean z2 = true;
                            for (bp bpVar : io.bWM) {
                                if (bpVar != null) {
                                    cn cnVar = new cn();
                                    cnVar.name = bpVar.name;
                                    cnVar.bWI = bpVar.bWI;
                                    if (z2) {
                                        cnVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    jVar.cfJ.bWM.add(cnVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.bZa.add(jVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        br io2 = bq.abd().io(jVar.cfI);
                        if (io2 != null && io2.bWM != null && io2.bWM.size() > 0) {
                            jVar.cfJ = new co();
                            jVar.cfJ.bWL = io2.bWL;
                            jVar.cfJ.bWM = new LinkedList();
                            for (bp bpVar2 : io2.bWM) {
                                if (bpVar2 != null) {
                                    cn cnVar2 = new cn();
                                    cnVar2.name = bpVar2.name;
                                    cnVar2.bWI = bpVar2.bWI;
                                    jVar.cfJ.bWM.add(cnVar2);
                                }
                            }
                        }
                        this.bZa.add(jVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.bTw.aad().aaR().k(bl.Xs)) {
                        j jVar2 = new j();
                        jVar2.name = frsTabInfo.tab_name;
                        if (nVar.bgj() != 0 && nVar.bgj() <= 99) {
                            jVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + nVar.bgj() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != nVar.bgj() && this.liveCount <= 99) {
                            jVar2.name = String.valueOf(frsTabInfo.tab_name) + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || nVar.bgj() > 99) {
                            jVar2.name = String.valueOf(frsTabInfo.tab_name) + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != nVar.bgj()) {
                            jVar2.name = frsTabInfo.tab_name;
                        }
                        jVar2.cfI = frsTabInfo.tab_id.intValue();
                        this.bZa.add(jVar2);
                    }
                }
            }
            this.bYW.d(this.bZa, nVar.bgG(), 12);
            if (!this.bYZ) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.iU(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(String str, String str2) {
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

    public HorizontalTabView abX() {
        return this.bYW;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eo(boolean z) {
        if (this.bYX != null) {
            if (z) {
                this.bYX.abZ();
            } else {
                this.bYX.aca();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData abR() {
        return this.bZa;
    }

    private void b(n nVar) {
        if (nVar == null || nVar.bgD() == null || nVar.bgD().size() == 0) {
            bq.abd().a(1, null);
            return;
        }
        List<CategoryInfo> bgD = nVar.bgD();
        br brVar = new br();
        brVar.bWL = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bgD.size()) {
                if (bgD.get(i2) != null) {
                    bp bpVar = new bp();
                    bpVar.bWI = bgD.get(i2).category_id.intValue();
                    bpVar.name = bgD.get(i2).category_name;
                    arrayList.add(bpVar);
                }
                i = i2 + 1;
            } else {
                brVar.bWM = arrayList;
                bq.abd().a(1, brVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View abS() {
        if (this.bYX == null) {
            return null;
        }
        return this.bYX.abY();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View abT() {
        return this.mRootLayout;
    }
}
