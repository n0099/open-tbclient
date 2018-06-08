package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class e {
    private static e aSr = null;
    private boolean aSs = false;
    private int aSt;

    private e() {
    }

    public static e JZ() {
        if (aSr == null) {
            synchronized (e.class) {
                if (aSr == null) {
                    aSr = new e();
                }
            }
        }
        return aSr;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aSl) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean JU() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int JV() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    am amVar = new am("userconvert");
                    amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.K(dVar.JW()));
                    amVar.ah("obj_locate", dVar.getCurrentPageKey());
                    amVar.ah("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aSp)) {
                        amVar.ah(VideoPlayActivityConfig.OBJ_ID, dVar.aSp);
                    }
                    TiebaStatic.log(amVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean JU() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int JV() {
                        return e.this.aSt;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                am amVar2 = new am("stime");
                amVar2.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.K(dVar.JW()));
                amVar2.ah("obj_type", dVar.getCurrentPageKey());
                amVar2.ah("obj_duration", String.valueOf(dVar.JX()));
                if (dVar.getFid() > 0) {
                    amVar2.ah(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    amVar2.ah("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    amVar2.ah(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    amVar2.ah("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.aSq)) {
                    amVar2.ah("is_vertical", dVar.aSq);
                }
                TiebaStatic.log(amVar2);
            }
        }
    }

    public boolean Ka() {
        return this.aSs;
    }

    public void bV(boolean z) {
        this.aSs = z;
    }

    public int Kb() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aSt;
    }

    public void fj(int i) {
        this.aSt = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aSt);
    }
}
