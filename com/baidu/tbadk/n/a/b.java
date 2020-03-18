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
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cx("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        anVar.s("obj_duration", System.currentTimeMillis());
        anVar.cx("obj_type", Build.MODEL);
        anVar.cx("resource_id", Build.VERSION.RELEASE);
        anVar.X("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        anVar.X("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        anVar.X(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        anVar.X(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(anVar);
    }
}
