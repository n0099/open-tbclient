package com.baidu.tbadk.m;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class e {
    private static e eAq = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean eAr = false;

    private e() {
    }

    public static e bhB() {
        if (eAq == null) {
            synchronized (e.class) {
                if (eAq == null) {
                    eAq = new e();
                }
            }
        }
        return eAq;
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
                    ao aoVar = new ao(PageStayDurationConstants.ROUTE_URL_KEY);
                    aoVar.dk("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    aoVar.dk("obj_locate", dVar.getCurrentPageKey());
                    aoVar.dk("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        aoVar.dk("obj_id", dVar.objID);
                    }
                    com.baidu.tbadk.l.e.a(context, aoVar, dVar);
                    TiebaStatic.log(aoVar);
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
                ao aoVar2 = new ao(PageStayDurationConstants.URL_KEY);
                aoVar2.dk("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                aoVar2.dk("obj_type", dVar.getCurrentPageKey());
                aoVar2.dk("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    aoVar2.dk("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    aoVar2.dk("tid", String.valueOf(dVar.getTid()));
                }
                if (!StringUtils.isNull(dVar.getNid())) {
                    aoVar2.dk("nid", dVar.getNid());
                }
                if (dVar.getPid() > 0) {
                    aoVar2.dk("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    aoVar2.dk("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    aoVar2.dk("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.eAo)) {
                    aoVar2.dk("is_dynamic", dVar.eAo);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    aoVar2.dk("resource_id", dVar.resourceId);
                }
                if (!ar.isEmpty(dVar.getTaskId())) {
                    aoVar2.dk("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!ar.isEmpty(dVar.bhz())) {
                    aoVar2.dk("ab_tag", dVar.bhz());
                }
                if (bhC()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        aoVar2.dk("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.eAm)) {
                        aoVar2.dk("obj_name", dVar.eAm);
                    }
                    aoVar2.dk("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.bhA())) {
                    aoVar2.dk("obj_location", dVar.bhA());
                }
                com.baidu.tbadk.l.e.a(context, aoVar2, dVar);
                TiebaStatic.log(aoVar2);
            }
        }
    }

    public boolean bhC() {
        return this.eAr;
    }

    public void iw(boolean z) {
        this.eAr = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.aVP().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
