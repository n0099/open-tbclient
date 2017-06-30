package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class e {
    private static e aGB = null;
    private boolean aGC = false;
    private int aGD;

    private e() {
    }

    public static e Fw() {
        if (aGB == null) {
            synchronized (e.class) {
                if (aGB == null) {
                    aGB = new e();
                }
            }
        }
        return aGB;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aGw) {
                if (bVar == null) {
                    bVar = new f(this);
                }
                if (bVar.a(dVar)) {
                    au auVar = new au("userconvert");
                    auVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.B(dVar.Ft()));
                    auVar.Z("obj_locate", dVar.getCurrentPageKey());
                    auVar.Z("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aGA)) {
                        auVar.Z("obj_id", dVar.aGA);
                    }
                    TiebaStatic.log(auVar);
                }
            } else if (dVar.Fu() > 0) {
                if (bVar == null) {
                    bVar = new g(this);
                }
                if (bVar.Fs() && bVar.a(dVar)) {
                    au auVar2 = new au("stime");
                    auVar2.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.B(dVar.Ft()));
                    auVar2.Z("obj_type", dVar.getCurrentPageKey());
                    auVar2.Z("obj_duration", String.valueOf(dVar.Fu()));
                    if (dVar.getFid() > 0) {
                        auVar2.Z("fid", String.valueOf(dVar.getFid()));
                    }
                    if (dVar.getTid() > 0) {
                        auVar2.Z("tid", String.valueOf(dVar.getTid()));
                    }
                    if (dVar.getPid() > 0) {
                        auVar2.Z(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                    }
                    if (!StringUtils.isNull(dVar.objParam1)) {
                        auVar2.Z("obj_param1", dVar.objParam1);
                    }
                    TiebaStatic.log(auVar2);
                }
            }
        }
    }

    public boolean Fx() {
        return this.aGC;
    }

    public void bW(boolean z) {
        this.aGC = z;
    }

    public int Fy() {
        return !TbadkCoreApplication.m9getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aGD;
    }

    public void eZ(int i) {
        this.aGD = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aGD);
    }
}
