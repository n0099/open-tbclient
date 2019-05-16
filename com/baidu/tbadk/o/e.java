package com.baidu.tbadk.o;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class e {
    private static e cxX = null;
    private int cxZ;
    private boolean cxY = false;
    private boolean cya = false;

    private e() {
    }

    public static e atQ() {
        if (cxX == null) {
            synchronized (e.class) {
                if (cxX == null) {
                    cxX = new e();
                }
            }
        }
        return cxX;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.cxQ) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.o.e.1
                        @Override // com.baidu.tbadk.o.b
                        public boolean atL() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.o.b
                        public int atM() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    am amVar = new am("userconvert");
                    amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.an(dVar.atN()));
                    amVar.bT("obj_locate", dVar.getCurrentPageKey());
                    amVar.bT("obj_type", "0");
                    if (!StringUtils.isNull(dVar.cxU)) {
                        amVar.bT(VideoPlayActivityConfig.OBJ_ID, dVar.cxU);
                    }
                    TiebaStatic.log(amVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.o.e.2
                    @Override // com.baidu.tbadk.o.b
                    public boolean atL() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.o.b
                    public int atM() {
                        return e.this.cxZ;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                am amVar2 = new am("stime");
                amVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.an(dVar.atN()));
                amVar2.bT("obj_type", dVar.getCurrentPageKey());
                amVar2.bT("obj_duration", String.valueOf(dVar.atO()));
                if (dVar.getFid() > 0) {
                    amVar2.bT("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    amVar2.bT("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    amVar2.bT(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    amVar2.bT("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.cxW)) {
                    amVar2.bT("is_vertical", dVar.cxW);
                }
                if (!ap.isEmpty(dVar.getTaskId())) {
                    amVar2.bT("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (atR()) {
                    if (!StringUtils.isNull(dVar.cxU)) {
                        amVar2.bT(VideoPlayActivityConfig.OBJ_ID, dVar.cxU);
                    }
                    if (!StringUtils.isNull(dVar.cxV)) {
                        amVar2.bT("obj_name", dVar.cxV);
                    }
                    amVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002");
                }
                TiebaStatic.log(amVar2);
            }
        }
    }

    public boolean atR() {
        return this.cya;
    }

    public void fy(boolean z) {
        this.cya = z;
    }

    public boolean atS() {
        return this.cxY;
    }

    public void fz(boolean z) {
        this.cxY = z;
    }

    public int atT() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.agM().getInt("page_stay_max_cost", 0) : this.cxZ;
    }

    public void kJ(int i) {
        this.cxZ = i;
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("page_stay_max_cost", this.cxZ);
    }
}
