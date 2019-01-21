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
    private static e bgd = null;
    private boolean bge = false;
    private int bgf;

    private e() {
    }

    public static e Pk() {
        if (bgd == null) {
            synchronized (e.class) {
                if (bgd == null) {
                    bgd = new e();
                }
            }
        }
        return bgd;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.bfX) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean Pf() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int Pg() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    am amVar = new am("userconvert");
                    amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.U(dVar.Ph()));
                    amVar.aB("obj_locate", dVar.getCurrentPageKey());
                    amVar.aB("obj_type", "0");
                    if (!StringUtils.isNull(dVar.bgb)) {
                        amVar.aB(VideoPlayActivityConfig.OBJ_ID, dVar.bgb);
                    }
                    TiebaStatic.log(amVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean Pf() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int Pg() {
                        return e.this.bgf;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                am amVar2 = new am("stime");
                amVar2.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.U(dVar.Ph()));
                amVar2.aB("obj_type", dVar.getCurrentPageKey());
                amVar2.aB("obj_duration", String.valueOf(dVar.Pi()));
                if (dVar.getFid() > 0) {
                    amVar2.aB(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    amVar2.aB("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    amVar2.aB(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    amVar2.aB("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.bgc)) {
                    amVar2.aB("is_vertical", dVar.bgc);
                }
                if (!ao.isEmpty(dVar.getTaskId())) {
                    amVar2.aB("task_id", String.valueOf(dVar.getTaskId()));
                }
                TiebaStatic.log(amVar2);
            }
        }
    }

    public boolean Pl() {
        return this.bge;
    }

    public void cN(boolean z) {
        this.bge = z;
    }

    public int Pm() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.bgf;
    }

    public void gi(int i) {
        this.bgf = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.bgf);
    }
}
