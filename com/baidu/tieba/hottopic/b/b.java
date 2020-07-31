package com.baidu.tieba.hottopic.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes15.dex */
public class b {
    public static void a(bv bvVar, String str, String str2, int i) {
        if (bvVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new ap("c13022").dn("obj_name", str).dn("tid", bvVar.getTid()).t("fid", bvVar.getFid()).dn("obj_source", bvVar.mRecomSource).dn("obj_locate", str2).ah("obj_type", i).dn("ab_tag", bvVar.mRecomAbTag));
        }
    }
}
