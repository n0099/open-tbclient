package com.baidu.tbadk.o.a;

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
        amVar.bJ("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.bJ(VideoPlayActivityConfig.OBJ_ID, TbadkCoreApplication.getInst().getCuidGalaxy2());
        amVar.k("obj_duration", System.currentTimeMillis());
        amVar.bJ("obj_type", Build.MODEL);
        amVar.bJ("resource_id", Build.VERSION.RELEASE);
        amVar.T("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        amVar.T("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        amVar.T("obj_param2", TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        amVar.T("obj_param3", TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(amVar);
    }
}
