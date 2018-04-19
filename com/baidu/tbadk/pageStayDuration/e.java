package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class e {
    private static e aJP = null;
    private boolean aJQ = false;
    private int aJR;

    private e() {
    }

    public static e Gt() {
        if (aJP == null) {
            synchronized (e.class) {
                if (aJP == null) {
                    aJP = new e();
                }
            }
        }
        return aJP;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aJJ) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean Go() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int Gp() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    al alVar = new al("userconvert");
                    alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.H(dVar.Gq()));
                    alVar.ac("obj_locate", dVar.getCurrentPageKey());
                    alVar.ac("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aJN)) {
                        alVar.ac(VideoPlayActivityConfig.OBJ_ID, dVar.aJN);
                    }
                    TiebaStatic.log(alVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean Go() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int Gp() {
                        return e.this.aJR;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                al alVar2 = new al("stime");
                alVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.H(dVar.Gq()));
                alVar2.ac("obj_type", dVar.getCurrentPageKey());
                alVar2.ac("obj_duration", String.valueOf(dVar.Gr()));
                if (dVar.getFid() > 0) {
                    alVar2.ac(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    alVar2.ac("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    alVar2.ac(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    alVar2.ac("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.aJO)) {
                    alVar2.ac("is_vertical", dVar.aJO);
                }
                TiebaStatic.log(alVar2);
            }
        }
    }

    public boolean Gu() {
        return this.aJQ;
    }

    public void bR(boolean z) {
        this.aJQ = z;
    }

    public int Gv() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aJR;
    }

    public void fe(int i) {
        this.aJR = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aJR);
    }
}
