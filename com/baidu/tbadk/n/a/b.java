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
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dR("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        arVar.v("obj_duration", System.currentTimeMillis());
        arVar.dR("obj_type", Build.MODEL);
        arVar.dR("resource_id", Build.VERSION.RELEASE);
        arVar.aq("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        arVar.aq("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        arVar.aq(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(arVar);
    }
}
