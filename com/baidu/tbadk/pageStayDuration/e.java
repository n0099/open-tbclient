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
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class e {
    private static e bbP = null;
    private boolean bbQ = false;
    private int bbR;

    private e() {
    }

    public static e NN() {
        if (bbP == null) {
            synchronized (e.class) {
                if (bbP == null) {
                    bbP = new e();
                }
            }
        }
        return bbP;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.bbJ) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean NI() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int NJ() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    am amVar = new am("userconvert");
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.T(dVar.NK()));
                    amVar.ax("obj_locate", dVar.getCurrentPageKey());
                    amVar.ax("obj_type", "0");
                    if (!StringUtils.isNull(dVar.bbN)) {
                        amVar.ax(VideoPlayActivityConfig.OBJ_ID, dVar.bbN);
                    }
                    TiebaStatic.log(amVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean NI() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int NJ() {
                        return e.this.bbR;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                am amVar2 = new am("stime");
                amVar2.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.T(dVar.NK()));
                amVar2.ax("obj_type", dVar.getCurrentPageKey());
                amVar2.ax("obj_duration", String.valueOf(dVar.NL()));
                if (dVar.getFid() > 0) {
                    amVar2.ax(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    amVar2.ax("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    amVar2.ax(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    amVar2.ax("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.bbO)) {
                    amVar2.ax("is_vertical", dVar.bbO);
                }
                if (!ao.isEmpty(dVar.getTaskId())) {
                    amVar2.ax("task_id", String.valueOf(dVar.getTaskId()));
                }
                TiebaStatic.log(amVar2);
            }
        }
    }

    public boolean NO() {
        return this.bbQ;
    }

    public void cJ(boolean z) {
        this.bbQ = z;
    }

    public int NP() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.bbR;
    }

    public void fT(int i) {
        this.bbR = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.bbR);
    }
}
