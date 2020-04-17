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
    private static e edg = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean edh = false;

    private e() {
    }

    public static e aZm() {
        if (edg == null) {
            synchronized (e.class) {
                if (edg == null) {
                    edg = new e();
                }
            }
        }
        return edg;
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
                    anVar.cI("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    anVar.cI("obj_locate", dVar.getCurrentPageKey());
                    anVar.cI("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar.cI("obj_id", dVar.objID);
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
                anVar2.cI("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                anVar2.cI("obj_type", dVar.getCurrentPageKey());
                anVar2.cI("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    anVar2.cI("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    anVar2.cI("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    anVar2.cI("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    anVar2.cI("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    anVar2.cI("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.edf)) {
                    anVar2.cI("is_dynamic", dVar.edf);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    anVar2.cI("resource_id", dVar.resourceId);
                }
                if (!aq.isEmpty(dVar.getTaskId())) {
                    anVar2.cI("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!aq.isEmpty(dVar.aZk())) {
                    anVar2.cI(TiebaInitialize.Params.AB_TAG, dVar.aZk());
                }
                if (aZn()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar2.cI("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.edd)) {
                        anVar2.cI("obj_name", dVar.edd);
                    }
                    anVar2.cI("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.aZl())) {
                    anVar2.cI("obj_location", dVar.aZl());
                }
                TiebaStatic.log(anVar2);
            }
        }
    }

    public boolean aZn() {
        return this.edh;
    }

    public void hR(boolean z) {
        this.edh = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.aNV().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
