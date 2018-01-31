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
    private static e bxv = null;
    private boolean bxw = false;
    private int bxx;

    private e() {
    }

    public static e Nl() {
        if (bxv == null) {
            synchronized (e.class) {
                if (bxv == null) {
                    bxv = new e();
                }
            }
        }
        return bxv;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.bxq) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean Ng() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int Nh() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    ak akVar = new ak("userconvert");
                    akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.N(dVar.Ni()));
                    akVar.aa("obj_locate", dVar.getCurrentPageKey());
                    akVar.aa("obj_type", "0");
                    if (!StringUtils.isNull(dVar.bxu)) {
                        akVar.aa("obj_id", dVar.bxu);
                    }
                    TiebaStatic.log(akVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean Ng() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int Nh() {
                        return e.this.bxx;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                ak akVar2 = new ak("stime");
                akVar2.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.N(dVar.Ni()));
                akVar2.aa("obj_type", dVar.getCurrentPageKey());
                akVar2.aa("obj_duration", String.valueOf(dVar.Nj()));
                if (dVar.getFid() > 0) {
                    akVar2.aa(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    akVar2.aa("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    akVar2.aa(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    akVar2.aa("obj_param1", dVar.objParam1);
                }
                TiebaStatic.log(akVar2);
            }
        }
    }

    public boolean Nm() {
        return this.bxw;
    }

    public void cv(boolean z) {
        this.bxw = z;
    }

    public int Nn() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.bxx;
    }

    public void ii(int i) {
        this.bxx = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.bxx);
    }
}
