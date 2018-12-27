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
    private static e bfs = null;
    private boolean bft = false;
    private int bfu;

    private e() {
    }

    public static e OS() {
        if (bfs == null) {
            synchronized (e.class) {
                if (bfs == null) {
                    bfs = new e();
                }
            }
        }
        return bfs;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.bfm) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean ON() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int OO() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    am amVar = new am("userconvert");
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.T(dVar.OP()));
                    amVar.aA("obj_locate", dVar.getCurrentPageKey());
                    amVar.aA("obj_type", "0");
                    if (!StringUtils.isNull(dVar.bfq)) {
                        amVar.aA(VideoPlayActivityConfig.OBJ_ID, dVar.bfq);
                    }
                    TiebaStatic.log(amVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean ON() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int OO() {
                        return e.this.bfu;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                am amVar2 = new am("stime");
                amVar2.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.T(dVar.OP()));
                amVar2.aA("obj_type", dVar.getCurrentPageKey());
                amVar2.aA("obj_duration", String.valueOf(dVar.OQ()));
                if (dVar.getFid() > 0) {
                    amVar2.aA(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    amVar2.aA("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    amVar2.aA(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    amVar2.aA("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.bfr)) {
                    amVar2.aA("is_vertical", dVar.bfr);
                }
                if (!ao.isEmpty(dVar.getTaskId())) {
                    amVar2.aA("task_id", String.valueOf(dVar.getTaskId()));
                }
                TiebaStatic.log(amVar2);
            }
        }
    }

    public boolean OT() {
        return this.bft;
    }

    public void cK(boolean z) {
        this.bft = z;
    }

    public int OU() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.bfu;
    }

    public void gi(int i) {
        this.bfu = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.bfu);
    }
}
