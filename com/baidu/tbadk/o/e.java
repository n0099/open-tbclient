package com.baidu.tbadk.o;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class e {
    private static e cLD = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean cLE = false;

    private e() {
    }

    public static e awz() {
        if (cLD == null) {
            synchronized (e.class) {
                if (cLD == null) {
                    cLD = new e();
                }
            }
        }
        return cLD;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.isRouteStat) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.o.e.1
                        @Override // com.baidu.tbadk.o.b
                        public boolean isCurrentPageCanBeAddToSourceTrace() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.o.b
                        public int getMaxCost() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    an anVar = new an(PageStayDurationConstants.ROUTE_URL_KEY);
                    anVar.bS("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    anVar.bS("obj_locate", dVar.getCurrentPageKey());
                    anVar.bS("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar.bS("obj_id", dVar.objID);
                    }
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.o.e.2
                    @Override // com.baidu.tbadk.o.b
                    public boolean isCurrentPageCanBeAddToSourceTrace() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.o.b
                    public int getMaxCost() {
                        return e.this.maxCost;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                an anVar2 = new an(PageStayDurationConstants.URL_KEY);
                anVar2.bS("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                anVar2.bS("obj_type", dVar.getCurrentPageKey());
                anVar2.bS("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    anVar2.bS("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    anVar2.bS("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    anVar2.bS("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    anVar2.bS("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    anVar2.bS("is_vertical", dVar.isVertical);
                }
                if (!aq.isEmpty(dVar.getTaskId())) {
                    anVar2.bS("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!aq.isEmpty(dVar.awy())) {
                    anVar2.bS(TiebaInitialize.Params.AB_TAG, dVar.awy());
                }
                if (awA()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar2.bS("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.cLB)) {
                        anVar2.bS("obj_name", dVar.cLB);
                    }
                    anVar2.bS("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                TiebaStatic.log(anVar2);
            }
        }
    }

    public boolean awA() {
        return this.cLE;
    }

    public void fv(boolean z) {
        this.cLE = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.alR().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.alR().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
