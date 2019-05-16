package com.baidu.tbadk.p.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class b {
    public static void log() {
        am amVar = new am("c13395");
        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.bT(VideoPlayActivityConfig.OBJ_ID, TbadkCoreApplication.getInst().getCuidGalaxy2());
        amVar.l("obj_duration", System.currentTimeMillis());
        amVar.bT("obj_type", Build.MODEL);
        amVar.bT("resource_id", Build.VERSION.RELEASE);
        amVar.P("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        amVar.P("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        amVar.P("obj_param2", TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        amVar.P("obj_param3", TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(amVar);
    }
}
