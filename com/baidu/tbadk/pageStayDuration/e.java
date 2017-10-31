package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class e {
    private static e aIz = null;
    private boolean aIA = false;
    private int aIB;

    private e() {
    }

    public static e FD() {
        if (aIz == null) {
            synchronized (e.class) {
                if (aIz == null) {
                    aIz = new e();
                }
            }
        }
        return aIz;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aIu) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean Fx() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int Fy() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    ak akVar = new ak("userconvert");
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FA()));
                    akVar.ac("obj_locate", dVar.getCurrentPageKey());
                    akVar.ac("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aIy)) {
                        akVar.ac("obj_id", dVar.aIy);
                    }
                    TiebaStatic.log(akVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean Fx() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int Fy() {
                        return e.this.aIB;
                    }
                };
            }
            if (bVar.Fz() && bVar.a(dVar)) {
                ak akVar2 = new ak("stime");
                akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FA()));
                akVar2.ac("obj_type", dVar.getCurrentPageKey());
                akVar2.ac("obj_duration", String.valueOf(dVar.FB()));
                if (dVar.getFid() > 0) {
                    akVar2.ac(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
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

    public boolean FE() {
        return this.aIA;
    }

    public void bS(boolean z) {
        this.aIA = z;
    }

    public int FF() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aIB;
    }

    public void fp(int i) {
        this.aIB = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aIB);
    }
}
