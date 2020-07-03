package com.baidu.tieba.hottopic.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes8.dex */
public class b {
    public static void a(bu buVar, String str, String str2, int i) {
        if (buVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ao("c13022").dk("obj_name", str).dk("tid", buVar.getTid()).s("fid", buVar.getFid()).dk("obj_source", buVar.mRecomSource).dk("obj_locate", str2).ag("obj_type", i).dk("ab_tag", buVar.mRecomAbTag));
        }
    }
}
