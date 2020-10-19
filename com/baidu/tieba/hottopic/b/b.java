package com.baidu.tieba.hottopic.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes21.dex */
public class b {
    public static void a(bw bwVar, String str, String str2, int i) {
        if (bwVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new aq("c13022").dK("obj_name", str).dK("tid", bwVar.getTid()).u("fid", bwVar.getFid()).dK("obj_source", bwVar.mRecomSource).dK("obj_locate", str2).aj("obj_type", i).dK("ab_tag", bwVar.mRecomAbTag));
        }
    }
}
