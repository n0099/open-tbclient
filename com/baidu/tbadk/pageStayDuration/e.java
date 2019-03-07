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
    private static e cpO = null;
    private int cpQ;
    private boolean cpP = false;
    private boolean cpR = false;

    private e() {
    }

    public static e aoQ() {
        if (cpO == null) {
            synchronized (e.class) {
                if (cpO == null) {
                    cpO = new e();
                }
            }
        }
        return cpO;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.cpH) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean aoL() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int aoM() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    am amVar = new am("userconvert");
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.ag(dVar.aoN()));
                    amVar.bJ("obj_locate", dVar.getCurrentPageKey());
                    amVar.bJ("obj_type", "0");
                    if (!StringUtils.isNull(dVar.cpL)) {
                        amVar.bJ(VideoPlayActivityConfig.OBJ_ID, dVar.cpL);
                    }
                    TiebaStatic.log(amVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean aoL() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int aoM() {
                        return e.this.cpQ;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                am amVar2 = new am("stime");
                amVar2.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.ag(dVar.aoN()));
                amVar2.bJ("obj_type", dVar.getCurrentPageKey());
                amVar2.bJ("obj_duration", String.valueOf(dVar.aoO()));
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
                if (!StringUtils.isNull(dVar.cpN)) {
                    amVar2.bJ("is_vertical", dVar.cpN);
                }
                if (!ap.isEmpty(dVar.getTaskId())) {
                    amVar2.bJ("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (aoR()) {
                    if (!StringUtils.isNull(dVar.cpL)) {
                        amVar2.bJ(VideoPlayActivityConfig.OBJ_ID, dVar.cpL);
                    }
                    if (!StringUtils.isNull(dVar.cpM)) {
                        amVar2.bJ("obj_name", dVar.cpM);
                    }
                }
                TiebaStatic.log(amVar2);
            }
        }
    }

    public boolean aoR() {
        return this.cpR;
    }

    public void fc(boolean z) {
        this.cpR = z;
    }

    public boolean aoS() {
        return this.cpP;
    }

    public void fd(boolean z) {
        this.cpP = z;
    }

    public int aoT() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.cpQ;
    }

    public void jW(int i) {
        this.cpQ = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.cpQ);
    }
}
