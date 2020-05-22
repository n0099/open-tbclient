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
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.dh("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        anVar.s("obj_duration", System.currentTimeMillis());
        anVar.dh("obj_type", Build.MODEL);
        anVar.dh("resource_id", Build.VERSION.RELEASE);
        anVar.ag("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        anVar.ag("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        anVar.ag(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(anVar);
    }
}
