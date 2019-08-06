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
    private static e czv = null;
    private int czx;
    private boolean czw = false;
    private boolean czy = false;

    private e() {
    }

    public static e avb() {
        if (czv == null) {
            synchronized (e.class) {
                if (czv == null) {
                    czv = new e();
                }
            }
        }
        return czv;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.czn) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.o.e.1
                        @Override // com.baidu.tbadk.o.b
                        public boolean auV() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.o.b
                        public int auW() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    an anVar = new an("userconvert");
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.an(dVar.auX()));
                    anVar.bT("obj_locate", dVar.getCurrentPageKey());
                    anVar.bT("obj_type", "0");
                    if (!StringUtils.isNull(dVar.czr)) {
                        anVar.bT(VideoPlayActivityConfig.OBJ_ID, dVar.czr);
                    }
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.o.e.2
                    @Override // com.baidu.tbadk.o.b
                    public boolean auV() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.o.b
                    public int auW() {
                        return e.this.czx;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                an anVar2 = new an("stime");
                anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.an(dVar.auX()));
                anVar2.bT("obj_type", dVar.getCurrentPageKey());
                anVar2.bT("obj_duration", String.valueOf(dVar.auY()));
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
                if (!StringUtils.isNull(dVar.czt)) {
                    anVar2.bT("is_vertical", dVar.czt);
                }
                if (!aq.isEmpty(dVar.getTaskId())) {
                    anVar2.bT("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!aq.isEmpty(dVar.auZ())) {
                    anVar2.bT("ab_tag", dVar.auZ());
                }
                if (avc()) {
                    if (!StringUtils.isNull(dVar.czr)) {
                        anVar2.bT(VideoPlayActivityConfig.OBJ_ID, dVar.czr);
                    }
                    if (!StringUtils.isNull(dVar.czs)) {
                        anVar2.bT("obj_name", dVar.czs);
                    }
                    anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002");
                }
                TiebaStatic.log(anVar2);
            }
        }
    }

    public boolean avc() {
        return this.czy;
    }

    public void fC(boolean z) {
        this.czy = z;
    }

    public boolean avd() {
        return this.czw;
    }

    public void fD(boolean z) {
        this.czw = z;
    }

    public int ave() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("page_stay_max_cost", 0) : this.czx;
    }

    public void kQ(int i) {
        this.czx = i;
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("page_stay_max_cost", this.czx);
    }
}
