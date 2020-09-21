package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class b {
    public static void log() {
        aq aqVar = new aq("c13395");
        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dF("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        aqVar.u("obj_duration", System.currentTimeMillis());
        aqVar.dF("obj_type", Build.MODEL);
        aqVar.dF("resource_id", Build.VERSION.RELEASE);
        aqVar.ai("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        aqVar.ai("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(aqVar);
    }
}
