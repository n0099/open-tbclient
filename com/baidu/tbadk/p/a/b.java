package com.baidu.tbadk.p.a;

import android.os.Build;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes.dex */
public class b {
    public static void log() {
        an anVar = new an("c13395");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT(VideoPlayActivityConfig.OBJ_ID, TbadkCoreApplication.getInst().getCuidGalaxy2());
        anVar.l("obj_duration", System.currentTimeMillis());
        anVar.bT("obj_type", Build.MODEL);
        anVar.bT("resource_id", Build.VERSION.RELEASE);
        anVar.P("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        anVar.P("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        anVar.P("obj_param2", TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        anVar.P("obj_param3", TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(anVar);
    }
}
