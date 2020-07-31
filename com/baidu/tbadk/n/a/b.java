package com.baidu.tbadk.n.a;

import android.os.Build;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class b {
    public static void log() {
        ap apVar = new ap("c13395");
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        apVar.dn("obj_id", TbadkCoreApplication.getInst().getCuidGalaxy2());
        apVar.t("obj_duration", System.currentTimeMillis());
        apVar.dn("obj_type", Build.MODEL);
        apVar.dn("resource_id", Build.VERSION.RELEASE);
        apVar.ah("aid", TbSingleton.getInstance().getCpuFlopsDuration());
        apVar.ah("obj_param1", TbSingleton.getInstance().getAnimComputedFps("anim_switch_slide"));
        apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, TbSingleton.getInstance().getAnimComputedFps("anim_switch_trans_frs"));
        apVar.ah(TiebaInitialize.Params.OBJ_PARAM3, TbSingleton.getInstance().getAnimComputedFps("anim_switch_sendthread_maintab"));
        TiebaStatic.log(apVar);
    }
}
