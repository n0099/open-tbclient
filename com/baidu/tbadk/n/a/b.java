package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class b {
    public static void log() {
        an anVar = new an("c13395");
        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cI("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        anVar.t("obj_duration", System.currentTimeMillis());
        anVar.cI("obj_type", Build.MODEL);
        anVar.cI("resource_id", Build.VERSION.RELEASE);
        anVar.af("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        anVar.af("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        anVar.af(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        anVar.af(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(anVar);
    }
}
