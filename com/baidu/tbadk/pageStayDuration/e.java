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
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class e {
    private static e cpR = null;
    private int cpT;
    private boolean cpS = false;
    private boolean cpU = false;

    private e() {
    }

    public static e aoM() {
        if (cpR == null) {
            synchronized (e.class) {
                if (cpR == null) {
                    cpR = new e();
                }
            }
        }
        return cpR;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.cpK) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean aoH() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int aoI() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    am amVar = new am("userconvert");
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.ag(dVar.aoJ()));
                    amVar.bJ("obj_locate", dVar.getCurrentPageKey());
                    amVar.bJ("obj_type", "0");
                    if (!StringUtils.isNull(dVar.cpO)) {
                        amVar.bJ(VideoPlayActivityConfig.OBJ_ID, dVar.cpO);
                    }
                    TiebaStatic.log(amVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean aoH() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int aoI() {
                        return e.this.cpT;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                am amVar2 = new am("stime");
                amVar2.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.ag(dVar.aoJ()));
                amVar2.bJ("obj_type", dVar.getCurrentPageKey());
                amVar2.bJ("obj_duration", String.valueOf(dVar.aoK()));
                if (dVar.getFid() > 0) {
                    amVar2.bJ(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    amVar2.bJ("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    amVar2.bJ(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    amVar2.bJ("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.cpQ)) {
                    amVar2.bJ("is_vertical", dVar.cpQ);
                }
                if (!ap.isEmpty(dVar.getTaskId())) {
                    amVar2.bJ("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (aoN()) {
                    if (!StringUtils.isNull(dVar.cpO)) {
                        amVar2.bJ(VideoPlayActivityConfig.OBJ_ID, dVar.cpO);
                    }
                    if (!StringUtils.isNull(dVar.cpP)) {
                        amVar2.bJ("obj_name", dVar.cpP);
                    }
                }
                TiebaStatic.log(amVar2);
            }
        }
    }

    public boolean aoN() {
        return this.cpU;
    }

    public void fc(boolean z) {
        this.cpU = z;
    }

    public boolean aoO() {
        return this.cpS;
    }

    public void fd(boolean z) {
        this.cpS = z;
    }

    public int aoP() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.cpT;
    }

    public void jV(int i) {
        this.cpT = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.cpT);
    }
}
