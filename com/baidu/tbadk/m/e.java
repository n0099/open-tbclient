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
    private static e dCX = null;
    private int maxCost;
    private boolean isSmallFlowOpen = false;
    private boolean dCY = false;

    private e() {
    }

    public static e aQV() {
        if (dCX == null) {
            synchronized (e.class) {
                if (dCX == null) {
                    dCX = new e();
                }
            }
        }
        return dCX;
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
                    anVar.cy("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                    anVar.cy("obj_locate", dVar.getCurrentPageKey());
                    anVar.cy("obj_type", "0");
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar.cy("obj_id", dVar.objID);
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
                anVar2.cy("obj_source", c.toSourceTraceString(dVar.getSorceKeyList()));
                anVar2.cy("obj_type", dVar.getCurrentPageKey());
                anVar2.cy("obj_duration", String.valueOf(dVar.getStayDurationTime()));
                if (dVar.getFid() > 0) {
                    anVar2.cy("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    anVar2.cy("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    anVar2.cy("pid", String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    anVar2.cy("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.isVertical)) {
                    anVar2.cy("is_vertical", dVar.isVertical);
                }
                if (!StringUtils.isNull(dVar.dCW)) {
                    anVar2.cy("is_dynamic", dVar.dCW);
                }
                if (!aq.isEmpty(dVar.getTaskId())) {
                    anVar2.cy("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!aq.isEmpty(dVar.aQT())) {
                    anVar2.cy(TiebaInitialize.Params.AB_TAG, dVar.aQT());
                }
                if (aQW()) {
                    if (!StringUtils.isNull(dVar.objID)) {
                        anVar2.cy("obj_id", dVar.objID);
                    }
                    if (!StringUtils.isNull(dVar.dCU)) {
                        anVar2.cy("obj_name", dVar.dCU);
                    }
                    anVar2.cy("obj_source", PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE);
                }
                if (!StringUtils.isNull(dVar.aQU())) {
                    anVar2.cy("obj_location", dVar.aQU());
                }
                TiebaStatic.log(anVar2);
            }
        }
    }

    public boolean aQW() {
        return this.dCY;
    }

    public void gS(boolean z) {
        this.dCY = z;
    }

    public boolean isSmallFlowOpen() {
        return this.isSmallFlowOpen;
    }

    public void setSamllFlowOpen(boolean z) {
        this.isSmallFlowOpen = z;
    }

    public int getMaxCostFromServer() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.aFB().getInt(SharedPrefConfig.PAGE_STY_MAX_COST, 0) : this.maxCost;
    }

    public void setMaxCostFromServer(int i) {
        this.maxCost = i;
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt(SharedPrefConfig.PAGE_STY_MAX_COST, this.maxCost);
    }
}
