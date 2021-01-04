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
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.dX("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        aqVar.w("obj_duration", System.currentTimeMillis());
        aqVar.dX("obj_type", Build.MODEL);
        aqVar.dX("resource_id", Build.VERSION.RELEASE);
        aqVar.an("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        aqVar.an("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        aqVar.an(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(aqVar);
    }
}
