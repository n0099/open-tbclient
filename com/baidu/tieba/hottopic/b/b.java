package com.baidu.tieba.hottopic.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes20.dex */
public class b {
    public static void a(bx bxVar, String str, String str2, int i) {
        if (bxVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ar("c13022").dR("obj_name", str).dR("tid", bxVar.getTid()).w("fid", bxVar.getFid()).dR("obj_source", bxVar.mRecomSource).dR("obj_locate", str2).ak("obj_type", i).dR("ab_tag", bxVar.mRecomAbTag));
        }
    }
}
