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
    private static e aHJ = null;
    private boolean aHK = false;
    private int aHL;

    private e() {
    }

    public static e FM() {
        if (aHJ == null) {
            synchronized (e.class) {
                if (aHJ == null) {
                    aHJ = new e();
                }
            }
        }
        return aHJ;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aHE) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean FG() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int FH() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    aj ajVar = new aj("userconvert");
                    ajVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FJ()));
                    ajVar.aa("obj_locate", dVar.getCurrentPageKey());
                    ajVar.aa("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aHI)) {
                        ajVar.aa("obj_id", dVar.aHI);
                    }
                    TiebaStatic.log(ajVar);
                }
            } else if (dVar.FK() > 0) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean FG() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int FH() {
                            return e.this.aHL;
                        }
                    };
                }
                if (bVar.FI() && bVar.a(dVar)) {
                    aj ajVar2 = new aj("stime");
                    ajVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FJ()));
                    ajVar2.aa("obj_type", dVar.getCurrentPageKey());
                    ajVar2.aa("obj_duration", String.valueOf(dVar.FK()));
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

    public boolean FN() {
        return this.aHK;
    }

    public void bZ(boolean z) {
        this.aHK = z;
    }

    public int FO() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aHL;
    }

    public void fc(int i) {
        this.aHL = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aHL);
    }
}
