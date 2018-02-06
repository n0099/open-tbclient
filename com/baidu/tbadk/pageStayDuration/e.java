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
    private static e bzC = null;
    private boolean bzD = false;
    private int bzE;

    private e() {
    }

    public static e NR() {
        if (bzC == null) {
            synchronized (e.class) {
                if (bzC == null) {
                    bzC = new e();
                }
            }
        }
        return bzC;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.bzx) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean NM() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int NN() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    ak akVar = new ak("userconvert");
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.P(dVar.NO()));
                    akVar.ab("obj_locate", dVar.getCurrentPageKey());
                    akVar.ab("obj_type", "0");
                    if (!StringUtils.isNull(dVar.bzB)) {
                        akVar.ab("obj_id", dVar.bzB);
                    }
                    TiebaStatic.log(akVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean NM() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int NN() {
                        return e.this.bzE;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                ak akVar2 = new ak("stime");
                akVar2.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.P(dVar.NO()));
                akVar2.ab("obj_type", dVar.getCurrentPageKey());
                akVar2.ab("obj_duration", String.valueOf(dVar.NP()));
                if (dVar.getFid() > 0) {
                    akVar2.ab(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    akVar2.ab("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    akVar2.ab(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    akVar2.ab("obj_param1", dVar.objParam1);
                }
                TiebaStatic.log(akVar2);
            }
        }
    }

    public boolean NS() {
        return this.bzD;
    }

    public void cz(boolean z) {
        this.bzD = z;
    }

    public int NT() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.bzE;
    }

    /* renamed from: if  reason: not valid java name */
    public void m13if(int i) {
        this.bzE = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.bzE);
    }
}
