package com.baidu.tbadk.m;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class e {
    private static e eGF = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean eGG = false;

    private e() {
    }

    public static e blm() {
        if (eGF == null) {
            synchronized (e.class) {
                if (eGF == null) {
                    eGF = new e();
                }
            }
        }
        return eGF;
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
                    ap apVar = new ap(PageStayDurationConstants.ROUTE_URL_KEY);
                    apVar.dn("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    apVar.dn("obj_locate", dVar.getCurrentPageKey());
                    apVar.dn("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        apVar.dn("obj_id", dVar.objID);
                    }
                    com.baidu.tbadk.l.e.a(context, apVar, dVar);
                    TiebaStatic.log(apVar);
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
                ap apVar2 = new ap(PageStayDurationConstants.URL_KEY);
                apVar2.dn("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                apVar2.dn("obj_type", dVar.getCurrentPageKey());
                apVar2.dn("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    apVar2.dn("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    apVar2.dn("tid", String.valueOf(dVar.getTid()));
                }
                if (!StringUtils.isNull(dVar.getNid())) {
                    apVar2.dn("nid", dVar.getNid());
                }
                if (dVar.getPid() > 0) {
                    apVar2.dn("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    apVar2.dn("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    apVar2.dn("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.eGE)) {
                    apVar2.dn("is_dynamic", dVar.eGE);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    apVar2.dn("resource_id", dVar.resourceId);
                }
                if (!as.isEmpty(dVar.getTaskId())) {
                    apVar2.dn("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!as.isEmpty(dVar.blk())) {
                    apVar2.dn("ab_tag", dVar.blk());
                }
                if (bln()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        apVar2.dn("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.eGC)) {
                        apVar2.dn("obj_name", dVar.eGC);
                    }
                    apVar2.dn("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.bll())) {
                    apVar2.dn("obj_location", dVar.bll());
                }
                com.baidu.tbadk.l.e.a(context, apVar2, dVar);
                TiebaStatic.log(apVar2);
            }
        }
    }

    public boolean bln() {
        return this.eGG;
    }

    public void jb(boolean z) {
        this.eGG = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.aZP().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
