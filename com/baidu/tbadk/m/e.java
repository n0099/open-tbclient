package com.baidu.tbadk.m;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.pageExtra.f;
/* loaded from: classes.dex */
public class e {
    private static e fBE = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean fBF = false;

    private e() {
    }

    public static e bEZ() {
        if (fBE == null) {
            synchronized (e.class) {
                if (fBE == null) {
                    fBE = new e();
                }
            }
        }
        return fBE;
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
                    ar arVar = new ar(PageStayDurationConstants.ROUTE_URL_KEY);
                    arVar.dY("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    arVar.dY("obj_locate", dVar.getCurrentPageKey());
                    arVar.dY("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        arVar.dY("obj_id", dVar.objID);
                    }
                    f.a(context, arVar, dVar);
                    TiebaStatic.log(arVar);
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
                ar arVar2 = new ar(PageStayDurationConstants.URL_KEY);
                arVar2.dY("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                arVar2.dY("obj_type", dVar.getCurrentPageKey());
                arVar2.dY("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    arVar2.dY("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    arVar2.dY("tid", String.valueOf(dVar.getTid()));
                }
                if (!StringUtils.isNull(dVar.getNid())) {
                    arVar2.dY("nid", dVar.getNid());
                }
                if (dVar.getPid() > 0) {
                    arVar2.dY("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    arVar2.dY("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    arVar2.dY("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.fBD)) {
                    arVar2.dY("is_dynamic", dVar.fBD);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    arVar2.dY("resource_id", dVar.resourceId);
                }
                if (!au.isEmpty(dVar.getTaskId())) {
                    arVar2.dY("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!au.isEmpty(dVar.bEX())) {
                    arVar2.dY("ab_tag", dVar.bEX());
                }
                if (bFa()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        arVar2.dY("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.fBB)) {
                        arVar2.dY("obj_name", dVar.fBB);
                    }
                    arVar2.dY("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.bEY())) {
                    arVar2.dY("obj_location", dVar.bEY());
                }
                f.a(context, arVar2, dVar);
                TiebaStatic.log(arVar2);
            }
        }
    }

    public boolean bFa() {
        return this.fBF;
    }

    public void kQ(boolean z) {
        this.fBF = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.bsO().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
