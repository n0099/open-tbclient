package com.baidu.tbadk.pageStayDuration;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class e {
    private static e aTn = null;
    private boolean aTo = false;
    private int aTp;

    private e() {
    }

    public static e Kr() {
        if (aTn == null) {
            synchronized (e.class) {
                if (aTn == null) {
                    aTn = new e();
                }
            }
        }
        return aTn;
    }

    public void a(Context context, d dVar, b bVar) {
        if (dVar != null && !StringUtils.isNull(dVar.getCurrentPageKey())) {
            if (dVar.aTh) {
                if (bVar == null) {
                    bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.1
                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public boolean Km() {
                            return true;
                        }

                        @Override // com.baidu.tbadk.pageStayDuration.b
                        public int Kn() {
                            return 6;
                        }
                    };
                }
                if (bVar.a(dVar)) {
                    an anVar = new an("userconvert");
                    anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.L(dVar.Ko()));
                    anVar.ah("obj_locate", dVar.getCurrentPageKey());
                    anVar.ah("obj_type", "0");
                    if (!StringUtils.isNull(dVar.aTl)) {
                        anVar.ah(VideoPlayActivityConfig.OBJ_ID, dVar.aTl);
                    }
                    TiebaStatic.log(anVar);
                    return;
                }
                return;
            }
            if (bVar == null) {
                bVar = new b() { // from class: com.baidu.tbadk.pageStayDuration.e.2
                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public boolean Km() {
                        return true;
                    }

                    @Override // com.baidu.tbadk.pageStayDuration.b
                    public int Kn() {
                        return e.this.aTp;
                    }
                };
            }
            if (bVar.isSwitchOpen() && bVar.a(dVar)) {
                an anVar2 = new an("stime");
                anVar2.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, c.L(dVar.Ko()));
                anVar2.ah("obj_type", dVar.getCurrentPageKey());
                anVar2.ah("obj_duration", String.valueOf(dVar.Kp()));
                if (dVar.getFid() > 0) {
                    anVar2.ah(ImageViewerConfig.FORUM_ID, String.valueOf(dVar.getFid()));
                }
                if (dVar.getTid() > 0) {
                    anVar2.ah("tid", String.valueOf(dVar.getTid()));
                }
                if (dVar.getPid() > 0) {
                    anVar2.ah(Info.kBaiduPIDKey, String.valueOf(dVar.getPid()));
                }
                if (!StringUtils.isNull(dVar.objParam1)) {
                    anVar2.ah("obj_param1", dVar.objParam1);
                }
                if (!StringUtils.isNull(dVar.aTm)) {
                    anVar2.ah("is_vertical", dVar.aTm);
                }
                TiebaStatic.log(anVar2);
            }
        }
    }

    public boolean Ks() {
        return this.aTo;
    }

    public void bY(boolean z) {
        this.aTo = z;
    }

    public int Kt() {
        return !TbadkCoreApplication.getInst().isMainProcess(true) ? com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("page_stay_max_cost", 0) : this.aTp;
    }

    public void fk(int i) {
        this.aTp = i;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("page_stay_max_cost", this.aTp);
    }
}
