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
    private static e aIc = null;
    private boolean aId = false;
    private int aIe;

    private e() {
    }

    public static e Fx() {
        if (aIc == null) {
            synchronized (e.class) {
                if (aIc == null) {
                    aIc = new e();
                }
            }
        }
        return aIc;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aHX) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean Fr() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int Fs() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    ak akVar = new ak("userconvert");
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.E(dVar.Fu()));
                    akVar.ad("obj_locate", dVar.getCurrentPageKey());
                    akVar.ad("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aIb)) {
                        akVar.ad("obj_id", dVar.aIb);
                    }
                    TiebaStatic.log(akVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean Fr() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int Fs() {
                        return e.this.aIe;
                    }
                };
            }
            if (bVar.Ft() && bVar.a(dVar)) {
                ak akVar2 = new ak("stime");
                akVar2.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.E(dVar.Fu()));
                akVar2.ad("obj_type", dVar.getCurrentPageKey());
                akVar2.ad("obj_duration", String.valueOf(dVar.Fv()));
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

    public boolean Fy() {
        return this.aId;
    }

    public void bY(boolean z) {
        this.aId = z;
    }

    public int Fz() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aIe;
    }

    public void fp(int i) {
        this.aIe = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aIe);
    }
}
