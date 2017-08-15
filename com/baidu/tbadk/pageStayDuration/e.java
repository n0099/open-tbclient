package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class e {
    private static e aIZ = null;
    private boolean aJa = false;
    private int aJb;

    private e() {
    }

    public static e FU() {
        if (aIZ == null) {
            synchronized (e.class) {
                if (aIZ == null) {
                    aIZ = new e();
                }
            }
        }
        return aIZ;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aIU) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean FO() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int FP() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    aj ajVar = new aj("userconvert");
                    ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FR()));
                    ajVar.aa("obj_locate", dVar.getCurrentPageKey());
                    ajVar.aa("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aIY)) {
                        ajVar.aa("obj_id", dVar.aIY);
                    }
                    TiebaStatic.log(ajVar);
                }
            } else if (dVar.FS() > 0) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean FO() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int FP() {
                            return e.this.aJb;
                        }
                    };
                }
                if (bVar.FQ() && bVar.a(dVar)) {
                    aj ajVar2 = new aj("stime");
                    ajVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FR()));
                    ajVar2.aa("obj_type", dVar.getCurrentPageKey());
                    ajVar2.aa("obj_duration", String.valueOf(dVar.FS()));
                    if (dVar.getFid() > 0) {
                        ajVar2.aa("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        ajVar2.aa("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        ajVar2.aa(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    if (!StringUtils.isNull(dVar.objParam1)) {
                        ajVar2.aa("obj_param1", dVar.objParam1);
                    }
                    TiebaStatic.log(ajVar2);
                }
            }
        }
    }

    public boolean FV() {
        return this.aJa;
    }

    public void bZ(boolean z) {
        this.aJa = z;
    }

    public int FW() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aJb;
    }

    public void fe(int i) {
        this.aJb = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aJb);
    }
}
