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
    private static e aJp = null;
    private boolean aJq = false;
    private int aJr;

    private e() {
    }

    public static e FW() {
        if (aJp == null) {
            synchronized (e.class) {
                if (aJp == null) {
                    aJp = new e();
                }
            }
        }
        return aJp;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aJk) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean FR() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int FS() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    ak akVar = new ak("userconvert");
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.G(dVar.FT()));
                    akVar.ac("obj_locate", dVar.getCurrentPageKey());
                    akVar.ac("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aJo)) {
                        akVar.ac("obj_id", dVar.aJo);
                    }
                    TiebaStatic.log(akVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean FR() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int FS() {
                        return e.this.aJr;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                ak akVar2 = new ak("stime");
                akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.G(dVar.FT()));
                akVar2.ac("obj_type", dVar.getCurrentPageKey());
                akVar2.ac("obj_duration", String.valueOf(dVar.FU()));
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

    public boolean FX() {
        return this.aJq;
    }

    public void bT(boolean z) {
        this.aJq = z;
    }

    public int FY() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aJr;
    }

    public void fn(int i) {
        this.aJr = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aJr);
    }
}
