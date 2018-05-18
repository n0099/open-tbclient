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
    private static e aJQ = null;
    private boolean aJR = false;
    private int aJS;

    private e() {
    }

    public static e Gr() {
        if (aJQ == null) {
            synchronized (e.class) {
                if (aJQ == null) {
                    aJQ = new e();
                }
            }
        }
        return aJQ;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aJK) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean Gm() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int Gn() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    al alVar = new al("userconvert");
                    alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.H(dVar.Go()));
                    alVar.ac("obj_locate", dVar.getCurrentPageKey());
                    alVar.ac("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aJO)) {
                        alVar.ac(VideoPlayActivityConfig.OBJ_ID, dVar.aJO);
                    }
                    TiebaStatic.log(alVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean Gm() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int Gn() {
                        return e.this.aJS;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                al alVar2 = new al("stime");
                alVar2.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.H(dVar.Go()));
                alVar2.ac("obj_type", dVar.getCurrentPageKey());
                alVar2.ac("obj_duration", String.valueOf(dVar.Gp()));
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
                if (!StringUtils.isNull(dVar.aJP)) {
                    alVar2.ac("is_vertical", dVar.aJP);
                }
                TiebaStatic.log(alVar2);
            }
        }
    }

    public boolean Gs() {
        return this.aJR;
    }

    public void bR(boolean z) {
        this.aJR = z;
    }

    public int Gt() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aJS;
    }

    public void ff(int i) {
        this.aJS = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aJS);
    }
}
