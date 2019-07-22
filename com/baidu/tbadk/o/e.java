package com.baidu.tbadk.o;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class e {
    private static e czo = null;
    private int czq;
    private boolean czp = false;
    private boolean czr = false;

    private e() {
    }

    public static e auZ() {
        if (czo == null) {
            synchronized (e.class) {
                if (czo == null) {
                    czo = new e();
                }
            }
        }
        return czo;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.czg) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.o.e.1
                        @Override // com.baidu.tbadk.o.b
                        public boolean auT() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.o.b
                        public int auU() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    an anVar = new an("userconvert");
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.an(dVar.auV()));
                    anVar.bT("obj_locate", dVar.getCurrentPageKey());
                    anVar.bT("obj_type", "0");
                    if (!StringUtils.isNull(dVar.czk)) {
                        anVar.bT(VideoPlayActivityConfig.OBJ_ID, dVar.czk);
                    }
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.o.e.2
                    @Override // com.baidu.tbadk.o.b
                    public boolean auT() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.o.b
                    public int auU() {
                        return e.this.czq;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                an anVar2 = new an("stime");
                anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.an(dVar.auV()));
                anVar2.bT("obj_type", dVar.getCurrentPageKey());
                anVar2.bT("obj_duration", String.valueOf(dVar.auW()));
                if (dVar.getFid() > 0) {
                    anVar2.bT("fid", String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    anVar2.bT("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    anVar2.bT(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    anVar2.bT("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.czm)) {
                    anVar2.bT("is_vertical", dVar.czm);
                }
                if (!aq.isEmpty(dVar.getTaskId())) {
                    anVar2.bT("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!aq.isEmpty(dVar.auX())) {
                    anVar2.bT("ab_tag", dVar.auX());
                }
                if (ava()) {
                    if (!StringUtils.isNull(dVar.czk)) {
                        anVar2.bT(VideoPlayActivityConfig.OBJ_ID, dVar.czk);
                    }
                    if (!StringUtils.isNull(dVar.czl)) {
                        anVar2.bT("obj_name", dVar.czl);
                    }
                    anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002");
                }
                TiebaStatic.log(anVar2);
            }
        }
    }

    public boolean ava() {
        return this.czr;
    }

    public void fC(boolean z) {
        this.czr = z;
    }

    public boolean avb() {
        return this.czp;
    }

    public void fD(boolean z) {
        this.czp = z;
    }

    public int avc() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.ahO().getInt("page_stay_max_cost", 0) : this.czq;
    }

    public void kP(int i) {
        this.czq = i;
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt("page_stay_max_cost", this.czq);
    }
}
