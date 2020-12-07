package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class b {
    public static void log() {
        ar arVar = new ar("c13395");
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dY("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        arVar.w("obj_duration", System.currentTimeMillis());
        arVar.dY("obj_type", Build.MODEL);
        arVar.dY("resource_id", Build.VERSION.RELEASE);
        arVar.al("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        arVar.al("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        arVar.al(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        arVar.al(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(arVar);
    }
}
