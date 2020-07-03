package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class b {
    public static void log() {
        ao aoVar = new ao("c13395");
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        aoVar.dk("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        aoVar.s("obj_duration", System.currentTimeMillis());
        aoVar.dk("obj_type", Build.MODEL);
        aoVar.dk("resource_id", Build.VERSION.RELEASE);
        aoVar.ag("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        aoVar.ag("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        aoVar.ag(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(aoVar);
    }
}
