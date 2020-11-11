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
    private static e fuI = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean fuJ = false;

    private e() {
    }

    public static e bCg() {
        if (fuI == null) {
            synchronized (e.class) {
                if (fuI == null) {
                    fuI = new e();
                }
            }
        }
        return fuI;
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
                if (bVar.canStat(dVar)) {
                    aq aqVar = new aq(PageStayDurationConstants.ROUTE_URL_KEY);
                    aqVar.dR("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    aqVar.dR("obj_locate", dVar.getCurrentPageKey());
                    aqVar.dR("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        aqVar.dR("obj_id", dVar.objID);
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
            if (bVar.isSwitchOpen() && bVar.canStat(dVar)) {
                aq aqVar2 = new aq(PageStayDurationConstants.URL_KEY);
                aqVar2.dR("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                aqVar2.dR("obj_type", dVar.getCurrentPageKey());
                aqVar2.dR("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    aqVar2.dR("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    aqVar2.dR("tid", String.valueOf(dVar.getTid()));
                }
                if (!StringUtils.isNull(dVar.getNid())) {
                    aqVar2.dR("nid", dVar.getNid());
                }
                if (dVar.getPid() > 0) {
                    aqVar2.dR("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    aqVar2.dR("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    aqVar2.dR("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.fuH)) {
                    aqVar2.dR("is_dynamic", dVar.fuH);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    aqVar2.dR("resource_id", dVar.resourceId);
                }
                if (!at.isEmpty(dVar.getTaskId())) {
                    aqVar2.dR("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!at.isEmpty(dVar.bCe())) {
                    aqVar2.dR("ab_tag", dVar.bCe());
                }
                if (bCh()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        aqVar2.dR("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.fuF)) {
                        aqVar2.dR("obj_name", dVar.fuF);
                    }
                    aqVar2.dR("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.bCf())) {
                    aqVar2.dR("obj_location", dVar.bCf());
                }
                com.baidu.tbadk.l.e.a(context, aqVar2, dVar);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    public boolean bCh() {
        return this.fuJ;
    }

    public void kw(boolean z) {
        this.fuJ = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.bqh().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
