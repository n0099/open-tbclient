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
    private static e aIH = null;
    private boolean aII = false;
    private int aIJ;

    private e() {
    }

    public static e FO() {
        if (aIH == null) {
            synchronized (e.class) {
                if (aIH == null) {
                    aIH = new e();
                }
            }
        }
        return aIH;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aIC) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean FJ() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int FK() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    ak akVar = new ak("userconvert");
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FL()));
                    akVar.ac("obj_locate", dVar.getCurrentPageKey());
                    akVar.ac("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aIG)) {
                        akVar.ac("obj_id", dVar.aIG);
                    }
                    TiebaStatic.log(akVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean FJ() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int FK() {
                        return e.this.aIJ;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                ak akVar2 = new ak("stime");
                akVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.F(dVar.FL()));
                akVar2.ac("obj_type", dVar.getCurrentPageKey());
                akVar2.ac("obj_duration", String.valueOf(dVar.FM()));
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

    public boolean FP() {
        return this.aII;
    }

    public void bT(boolean z) {
        this.aII = z;
    }

    public int FQ() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aIJ;
    }

    public void fo(int i) {
        this.aIJ = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aIJ);
    }
}
