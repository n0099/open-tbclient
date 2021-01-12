package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes7.dex */
public class b {
    public static void a(bz bzVar, String str, String str2, int i) {
        if (bzVar != null && !TextUtils.isEmpty(str)) {
            TiebaStatic.log(new aq("c13022").dW("obj_name", str).dW("tid", bzVar.getTid()).w("fid", bzVar.getFid()).dW("obj_source", bzVar.mRecomSource).dW("obj_locate", str2).an("obj_type", i).dW("ab_tag", bzVar.mRecomAbTag));
        }
    }
}
