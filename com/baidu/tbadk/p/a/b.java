package com.baidu.tbadk.p.a;

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
        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bS("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        anVar.p("obj_duration", System.currentTimeMillis());
        anVar.bS("obj_type", Build.MODEL);
        anVar.bS("resource_id", Build.VERSION.RELEASE);
        anVar.O("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        anVar.O("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        anVar.O(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        anVar.O(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(anVar);
    }
}
