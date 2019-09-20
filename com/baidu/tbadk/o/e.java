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
    private static e cAr = null;
    private int cAt;
    private boolean cAs = false;
    private boolean cAu = false;

    private e() {
    }

    public static e avn() {
        if (cAr == null) {
            synchronized (e.class) {
                if (cAr == null) {
                    cAr = new e();
                }
            }
        }
        return cAr;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.cAj) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.o.e.1
                        @Override // com.baidu.tbadk.o.b
                        public boolean avh() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.o.b
                        public int avi() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    an anVar = new an("userconvert");
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.an(dVar.avj()));
                    anVar.bT("obj_locate", dVar.getCurrentPageKey());
                    anVar.bT("obj_type", "0");
                    if (!StringUtils.isNull(dVar.cAn)) {
                        anVar.bT(VideoPlayActivityConfig.OBJ_ID, dVar.cAn);
                    }
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.o.e.2
                    @Override // com.baidu.tbadk.o.b
                    public boolean avh() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.o.b
                    public int avi() {
                        return e.this.cAt;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                an anVar2 = new an("stime");
                anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.an(dVar.avj()));
                anVar2.bT("obj_type", dVar.getCurrentPageKey());
                anVar2.bT("obj_duration", String.valueOf(dVar.avk()));
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
                if (!StringUtils.isNull(dVar.cAp)) {
                    anVar2.bT("is_vertical", dVar.cAp);
                }
                if (!aq.isEmpty(dVar.getTaskId())) {
                    anVar2.bT("task_id", String.valueOf(dVar.getTaskId()));
                }
                if (!aq.isEmpty(dVar.avl())) {
                    anVar2.bT("ab_tag", dVar.avl());
                }
                if (avo()) {
                    if (!StringUtils.isNull(dVar.cAn)) {
                        anVar2.bT(VideoPlayActivityConfig.OBJ_ID, dVar.cAn);
                    }
                    if (!StringUtils.isNull(dVar.cAo)) {
                        anVar2.bT("obj_name", dVar.cAo);
                    }
                    anVar2.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "a002");
                }
                TiebaStatic.log(anVar2);
            }
        }
    }

    public boolean avo() {
        return this.cAu;
    }

    public void fF(boolean z) {
        this.cAu = z;
    }

    public boolean avp() {
        return this.cAs;
    }

    public void fG(boolean z) {
        this.cAs = z;
    }

    public int avq() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.ahU().getInt("page_stay_max_cost", 0) : this.cAt;
    }

    public void kT(int i) {
        this.cAt = i;
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt("page_stay_max_cost", this.cAt);
    }
}
