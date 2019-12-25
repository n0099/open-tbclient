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
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cp("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        anVar.s("obj_duration", System.currentTimeMillis());
        anVar.cp("obj_type", Build.MODEL);
        anVar.cp("resource_id", Build.VERSION.RELEASE);
        anVar.Z("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        anVar.Z("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        anVar.Z(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        anVar.Z(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(anVar);
    }
}
