package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class e {
    private static e aWC = null;
    private boolean aWD = false;
    private int aWE;

    private e() {
    }

    public static e LG() {
        if (aWC == null) {
            synchronized (e.class) {
                if (aWC == null) {
                    aWC = new e();
                }
            }
        }
        return aWC;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aWw) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean LB() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int LC() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    am amVar = new am("userconvert");
                    amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.L(dVar.LD()));
                    amVar.al("obj_locate", dVar.getCurrentPageKey());
                    amVar.al("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aWA)) {
                        amVar.al(VideoPlayActivityConfig.OBJ_ID, dVar.aWA);
                    }
                    TiebaStatic.log(amVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean LB() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int LC() {
                        return e.this.aWE;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                am amVar2 = new am("stime");
                amVar2.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.L(dVar.LD()));
                amVar2.al("obj_type", dVar.getCurrentPageKey());
                amVar2.al("obj_duration", String.valueOf(dVar.LE()));
                if (dVar.getFid() > 0) {
                    amVar2.al(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    amVar2.al("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    amVar2.al(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    amVar2.al("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.aWB)) {
                    amVar2.al("is_vertical", dVar.aWB);
                }
                if (!ao.isEmpty(dVar.getTaskId())) {
                    amVar2.al("task_id", String.valueOf(dVar.getTaskId()));
                }
                TiebaStatic.log(amVar2);
            }
        }
    }

    public boolean LH() {
        return this.aWD;
    }

    public void cj(boolean z) {
        this.aWD = z;
    }

    public int LI() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aWE;
    }

    public void fw(int i) {
        this.aWE = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aWE);
    }
}
