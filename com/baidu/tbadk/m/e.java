package com.baidu.tbadk.m;

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
    private static e dyV = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean dyW = false;

    private e() {
    }

    public static e aOF() {
        if (dyV == null) {
            synchronized (e.class) {
                if (dyV == null) {
                    dyV = new e();
                }
            }
        }
        return dyV;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.isRouteStat) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.m.e.1
                        @Override // com.baidu.tbadk.m.b
                        public boolean isCurrentPageCanBeAddToSourceTrace() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.m.b
                        public int getMaxCost() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    an anVar = new an(PageStayDurationConstants.ROUTE_URL_KEY);
                    anVar.cp("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    anVar.cp("obj_locate", dVar.getCurrentPageKey());
                    anVar.cp("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar.cp("obj_id", dVar.objID);
                    }
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.m.e.2
                    @Override // com.baidu.tbadk.m.b
                    public boolean isCurrentPageCanBeAddToSourceTrace() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.m.b
                    public int getMaxCost() {
                        return e.this.maxCost;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                an anVar2 = new an(PageStayDurationConstants.URL_KEY);
                anVar2.cp("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                anVar2.cp("obj_type", dVar.getCurrentPageKey());
                anVar2.cp("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    anVar2.cp("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    anVar2.cp("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    anVar2.cp("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    anVar2.cp("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    anVar2.cp("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.dyU)) {
                    anVar2.cp("is_dynamic", dVar.dyU);
                }
                if (!aq.isEmpty(dVar.getTaskId())) {
                    anVar2.cp("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!aq.isEmpty(dVar.aOD())) {
                    anVar2.cp(TiebaInitialize.Params.AB_TAG, dVar.aOD());
                }
                if (aOG()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar2.cp("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.dyS)) {
                        anVar2.cp("obj_name", dVar.dyS);
                    }
                    anVar2.cp("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.aOE())) {
                    anVar2.cp("obj_location", dVar.aOE());
                }
                TiebaStatic.log(anVar2);
            }
        }
    }

    public boolean aOG() {
        return this.dyW;
    }

    public void gL(boolean z) {
        this.dyW = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.aDr().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
