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
    private static e fgo = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean fgp = false;

    private e() {
    }

    public static e bxO() {
        if (fgo == null) {
            synchronized (e.class) {
                if (fgo == null) {
                    fgo = new e();
                }
            }
        }
        return fgo;
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
                    aqVar.dK("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    aqVar.dK("obj_locate", dVar.getCurrentPageKey());
                    aqVar.dK("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        aqVar.dK("obj_id", dVar.objID);
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
                aqVar2.dK("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                aqVar2.dK("obj_type", dVar.getCurrentPageKey());
                aqVar2.dK("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    aqVar2.dK("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    aqVar2.dK("tid", String.valueOf(dVar.getTid()));
                }
                if (!StringUtils.isNull(dVar.getNid())) {
                    aqVar2.dK("nid", dVar.getNid());
                }
                if (dVar.getPid() > 0) {
                    aqVar2.dK("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    aqVar2.dK("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    aqVar2.dK("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.fgn)) {
                    aqVar2.dK("is_dynamic", dVar.fgn);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    aqVar2.dK("resource_id", dVar.resourceId);
                }
                if (!at.isEmpty(dVar.getTaskId())) {
                    aqVar2.dK("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!at.isEmpty(dVar.bxM())) {
                    aqVar2.dK("ab_tag", dVar.bxM());
                }
                if (bxP()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        aqVar2.dK("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.fgl)) {
                        aqVar2.dK("obj_name", dVar.fgl);
                    }
                    aqVar2.dK("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.bxN())) {
                    aqVar2.dK("obj_location", dVar.bxN());
                }
                com.baidu.tbadk.l.e.a(context, aqVar2, dVar);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    public boolean bxP() {
        return this.fgp;
    }

    public void ka(boolean z) {
        this.fgp = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.blO().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.blO().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
