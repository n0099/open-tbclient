package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes8.dex */
public class b {
    public static void a(bz bzVar, String str, String str2, int i) {
        if (bzVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new aq("c13022").dX("obj_name", str).dX("tid", bzVar.getTid()).w("fid", bzVar.getFid()).dX("obj_source", bzVar.mRecomSource).dX("obj_locate", str2).an("obj_type", i).dX("ab_tag", bzVar.mRecomAbTag));
        }
    }
}
