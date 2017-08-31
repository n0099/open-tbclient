package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class e {
    private static e aIE = null;
    private boolean aIF = false;
    private int aIG;

    private e() {
    }

    public static e FS() {
        if (aIE == null) {
            synchronized (e.class) {
                if (aIE == null) {
                    aIE = new e();
                }
            }
        }
        return aIE;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aIz) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean FM() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int FN() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    ak akVar = new ak("userconvert");
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FP()));
                    akVar.ad("obj_locate", dVar.getCurrentPageKey());
                    akVar.ad("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aID)) {
                        akVar.ad("obj_id", dVar.aID);
                    }
                    TiebaStatic.log(akVar);
                }
            } else if (dVar.FQ() > 0) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean FM() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int FN() {
                            return e.this.aIG;
                        }
                    };
                }
                if (bVar.FO() && bVar.a(dVar)) {
                    ak akVar2 = new ak("stime");
                    akVar2.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FP()));
                    akVar2.ad("obj_type", dVar.getCurrentPageKey());
                    akVar2.ad("obj_duration", String.valueOf(dVar.FQ()));
                    if (dVar.getFid() > 0) {
                        akVar2.ad("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        akVar2.ad("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        akVar2.ad(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    if (!StringUtils.isNull(dVar.objParam1)) {
                        akVar2.ad("obj_param1", dVar.objParam1);
                    }
                    TiebaStatic.log(akVar2);
                }
            }
        }
    }

    public boolean FT() {
        return this.aIF;
    }

    public void bZ(boolean z) {
        this.aIF = z;
    }

    public int FU() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aIG;
    }

    public void fe(int i) {
        this.aIG = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aIG);
    }
}
