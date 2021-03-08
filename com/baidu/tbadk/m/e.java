package com.baidu.tbadk.m;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.pageExtra.f;
/* loaded from: classes.dex */
public class e {
    private static e fKp = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean fKq = false;

    private e() {
    }

    public static e bDW() {
        if (fKp == null) {
            synchronized (e.class) {
                if (fKp == null) {
                    fKp = new e();
                }
            }
        }
        return fKp;
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
                    arVar.dR("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    arVar.dR("obj_locate", dVar.getCurrentPageKey());
                    arVar.dR("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        arVar.dR("obj_id", dVar.objID);
                    }
                    if (dVar.bDV() != 0) {
                        arVar.aq("ad_source", dVar.bDV());
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
                arVar2.dR("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                arVar2.dR("obj_type", dVar.getCurrentPageKey());
                arVar2.dR("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    arVar2.dR("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    arVar2.dR("tid", String.valueOf(dVar.getTid()));
                }
                if (!StringUtils.isNull(dVar.bmq())) {
                    arVar2.dR(IntentConfig.NID, dVar.bmq());
                }
                if (dVar.getPid() > 0) {
                    arVar2.dR("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    arVar2.dR("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    arVar2.dR("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.fKn)) {
                    arVar2.dR("is_dynamic", dVar.fKn);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    arVar2.dR("resource_id", dVar.resourceId);
                }
                if (!au.isEmpty(dVar.getTaskId())) {
                    arVar2.dR("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!au.isEmpty(dVar.bDT())) {
                    arVar2.dR("ab_tag", dVar.bDT());
                }
                if (bDX()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        arVar2.dR("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.fKl)) {
                        arVar2.dR("obj_name", dVar.fKl);
                    }
                    arVar2.dR("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.bDU())) {
                    arVar2.dR("obj_location", dVar.bDU());
                }
                if (dVar.bDV() != 0) {
                    arVar2.aq("ad_source", dVar.bDV());
                }
                f.a(context, arVar2, dVar);
                TiebaStatic.log(arVar2);
            }
        }
    }

    public boolean bDX() {
        return this.fKq;
    }

    public void ll(boolean z) {
        this.fKq = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
