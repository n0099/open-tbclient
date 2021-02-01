package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes8.dex */
public class b {
    public static void a(cb cbVar, String str, String str2, int i) {
        if (cbVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ar("c13022").dR("obj_name", str).dR("tid", cbVar.getTid()).v("fid", cbVar.getFid()).dR("obj_source", cbVar.mRecomSource).dR("obj_locate", str2).ap("obj_type", i).dR("ab_tag", cbVar.mRecomAbTag));
        }
    }
}
