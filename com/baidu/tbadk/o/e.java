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
    private static e cxY = null;
    private int cya;
    private boolean cxZ = false;
    private boolean cyb = false;

    private e() {
    }

    public static e atQ() {
        if (cxY == null) {
            synchronized (e.class) {
                if (cxY == null) {
                    cxY = new e();
                }
            }
        }
        return cxY;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.cxR) {
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
                    if (!StringUtils.isNull(dVar.cxV)) {
                        amVar.bT(VideoPlayActivityConfig.OBJ_ID, dVar.cxV);
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
                        return e.this.cya;
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
                if (!StringUtils.isNull(dVar.cxX)) {
                    amVar2.bT("is_vertical", dVar.cxX);
                }
                if (!ap.isEmpty(dVar.getTaskId())) {
                    amVar2.bT("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (atR()) {
                    if (!StringUtils.isNull(dVar.cxV)) {
                        amVar2.bT(VideoPlayActivityConfig.OBJ_ID, dVar.cxV);
                    }
                    if (!StringUtils.isNull(dVar.cxW)) {
                        amVar2.bT("obj_name", dVar.cxW);
                    }
                    amVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002");
                }
                TiebaStatic.log(amVar2);
            }
        }
    }

    public boolean atR() {
        return this.cyb;
    }

    public void fy(boolean z) {
        this.cyb = z;
    }

    public boolean atS() {
        return this.cxZ;
    }

    public void fz(boolean z) {
        this.cxZ = z;
    }

    public int atT() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.agM().getInt("page_stay_max_cost", 0) : this.cya;
    }

    public void kJ(int i) {
        this.cya = i;
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("page_stay_max_cost", this.cya);
    }
}
