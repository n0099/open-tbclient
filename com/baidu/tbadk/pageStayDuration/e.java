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
    private static e aHP = null;
    private boolean aHQ = false;
    private int aHR;

    private e() {
    }

    public static e Fr() {
        if (aHP == null) {
            synchronized (e.class) {
                if (aHP == null) {
                    aHP = new e();
                }
            }
        }
        return aHP;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aHK) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean Fl() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int Fm() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    ak akVar = new ak("userconvert");
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.E(dVar.Fo()));
                    akVar.ac("obj_locate", dVar.getCurrentPageKey());
                    akVar.ac("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aHO)) {
                        akVar.ac("obj_id", dVar.aHO);
                    }
                    TiebaStatic.log(akVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean Fl() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int Fm() {
                        return e.this.aHR;
                    }
                };
            }
            if (bVar.Fn() && bVar.a(dVar)) {
                ak akVar2 = new ak("stime");
                akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.E(dVar.Fo()));
                akVar2.ac("obj_type", dVar.getCurrentPageKey());
                akVar2.ac("obj_duration", String.valueOf(dVar.Fp()));
                if (dVar.getFid() > 0) {
                    akVar2.ac("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    akVar2.ac("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    akVar2.ac(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    akVar2.ac("obj_param1", dVar.objParam1);
                }
                TiebaStatic.log(akVar2);
            }
        }
    }

    public boolean Fs() {
        return this.aHQ;
    }

    public void bX(boolean z) {
        this.aHQ = z;
    }

    public int Ft() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aHR;
    }

    public void fo(int i) {
        this.aHR = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aHR);
    }
}
