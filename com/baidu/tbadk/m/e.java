package com.baidu.tbadk.m;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.pageExtra.f;
/* loaded from: classes.dex */
public class e {
    private static e fLk = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean fLl = false;

    private e() {
    }

    public static e bHt() {
        if (fLk == null) {
            synchronized (e.class) {
                if (fLk == null) {
                    fLk = new e();
                }
            }
        }
        return fLk;
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
                    aqVar.dX("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    aqVar.dX("obj_locate", dVar.getCurrentPageKey());
                    aqVar.dX("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        aqVar.dX("obj_id", dVar.objID);
                    }
                    f.a(context, aqVar, dVar);
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
                aqVar2.dX("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                aqVar2.dX("obj_type", dVar.getCurrentPageKey());
                aqVar2.dX("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    aqVar2.dX("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    aqVar2.dX("tid", String.valueOf(dVar.getTid()));
                }
                if (!StringUtils.isNull(dVar.bpP())) {
                    aqVar2.dX(IntentConfig.NID, dVar.bpP());
                }
                if (dVar.getPid() > 0) {
                    aqVar2.dX("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    aqVar2.dX("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    aqVar2.dX("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.fLj)) {
                    aqVar2.dX("is_dynamic", dVar.fLj);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    aqVar2.dX("resource_id", dVar.resourceId);
                }
                if (!at.isEmpty(dVar.getTaskId())) {
                    aqVar2.dX("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!at.isEmpty(dVar.bHr())) {
                    aqVar2.dX("ab_tag", dVar.bHr());
                }
                if (bHu()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        aqVar2.dX("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.fLh)) {
                        aqVar2.dX("obj_name", dVar.fLh);
                    }
                    aqVar2.dX("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.bHs())) {
                    aqVar2.dX("obj_location", dVar.bHs());
                }
                f.a(context, aqVar2, dVar);
                TiebaStatic.log(aqVar2);
            }
        }
    }

    public boolean bHu() {
        return this.fLl;
    }

    public void lm(boolean z) {
        this.fLl = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.bvr().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
