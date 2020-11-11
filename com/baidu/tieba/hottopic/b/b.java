package com.baidu.tieba.hottopic.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes21.dex */
public class b {
    public static void a(bw bwVar, String str, String str2, int i) {
        if (bwVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new aq("c13022").dR("obj_name", str).dR("tid", bwVar.getTid()).w("fid", bwVar.getFid()).dR("obj_source", bwVar.mRecomSource).dR("obj_locate", str2).al("obj_type", i).dR("ab_tag", bwVar.mRecomAbTag));
        }
    }
}
