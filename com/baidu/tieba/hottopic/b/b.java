package com.baidu.tieba.hottopic.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes21.dex */
public class b {
    public static void a(by byVar, String str, String str2, int i) {
        if (byVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ar("c13022").dY("obj_name", str).dY("tid", byVar.getTid()).w("fid", byVar.getFid()).dY("obj_source", byVar.mRecomSource).dY("obj_locate", str2).al("obj_type", i).dY("ab_tag", byVar.mRecomAbTag));
        }
    }
}
