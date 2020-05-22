package com.baidu.tbadk.m;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class e {
    private static e ery = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean erz = false;

    private e() {
    }

    public static e bfu() {
        if (ery == null) {
            synchronized (e.class) {
                if (ery == null) {
                    ery = new e();
                }
            }
        }
        return ery;
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
                    anVar.dh("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    anVar.dh("obj_locate", dVar.getCurrentPageKey());
                    anVar.dh("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar.dh("obj_id", dVar.objID);
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
                anVar2.dh("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                anVar2.dh("obj_type", dVar.getCurrentPageKey());
                anVar2.dh("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    anVar2.dh("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    anVar2.dh("tid", String.valueOf(dVar.getTid()));
                }
                if (!StringUtils.isNull(dVar.getNid())) {
                    anVar2.dh("nid", dVar.getNid());
                }
                if (dVar.getPid() > 0) {
                    anVar2.dh("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    anVar2.dh("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    anVar2.dh("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.erx)) {
                    anVar2.dh("is_dynamic", dVar.erx);
                }
                if (!StringUtils.isNull(dVar.resourceId)) {
                    anVar2.dh("resource_id", dVar.resourceId);
                }
                if (!aq.isEmpty(dVar.getTaskId())) {
                    anVar2.dh("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!aq.isEmpty(dVar.bfs())) {
                    anVar2.dh("ab_tag", dVar.bfs());
                }
                if (bfv()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar2.dh("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.erv)) {
                        anVar2.dh("obj_name", dVar.erv);
                    }
                    anVar2.dh("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.bft())) {
                    anVar2.dh("obj_location", dVar.bft());
                }
                TiebaStatic.log(anVar2);
            }
        }
    }

    public boolean bfv() {
        return this.erz;
    }

    public void in(boolean z) {
        this.erz = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
