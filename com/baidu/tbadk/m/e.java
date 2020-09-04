package com.baidu.tbadk.m;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class e {
    private static e eRp = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean eRq = false;

    private e() {
    }

    public static e bua() {
        if (eRp == null) {
            synchronized (e.class) {
                if (eRp == null) {
                    eRp = new e();
                }
            }
        }
        return eRp;
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
                    aq aqVar = new aq(PageStayDurationConstants.ROUTE_URL_KEY);
                    aqVar.dD("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    aqVar.dD("obj_locate", dVar.getCurrentPageKey());
                    aqVar.dD("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        aqVar.dD("obj_id", dVar.objID);
                    }
                    com.baidu.tbadk.l.e.a(context, aqVar, dVar);
                    TiebaStatic.log(aqVar);
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
                aq aqVar2 = new aq(PageStayDurationConstants.URL_KEY);
                aqVar2.dD("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                aqVar2.dD("obj_type", dVar.getCurrentPageKey());
                aqVar2.dD("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    aqVar2.dD("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    aqVar2.dD("tid", String.valueOf(dVar.getTid()));
                }
                if (!StringUtils.isNull(dVar.getNid())) {
                    aqVar2.dD("nid", dVar.getNid());
                }
                if (dVar.getPid() > 0) {
                    aqVar2.dD("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    aqVar2.dD("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    aqVar2.dD("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.eRo)) {
                    aqVar2.dD("is_dynamic", dVar.eRo);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    aqVar2.dD("resource_id", dVar.resourceId);
                }
                if (!at.isEmpty(dVar.getTaskId())) {
                    aqVar2.dD("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!at.isEmpty(dVar.btY())) {
                    aqVar2.dD("ab_tag", dVar.btY());
                }
                if (bub()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        aqVar2.dD("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.eRm)) {
                        aqVar2.dD("obj_name", dVar.eRm);
                    }
                    aqVar2.dD("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.btZ())) {
                    aqVar2.dD("obj_location", dVar.btZ());
                }
                com.baidu.tbadk.l.e.a(context, aqVar2, dVar);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    public boolean bub() {
        return this.eRq;
    }

    public void jB(boolean z) {
        this.eRq = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
