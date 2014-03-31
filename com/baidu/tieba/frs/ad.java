package com.baidu.tieba.frs;

import android.content.Context;
/* loaded from: classes.dex */
final class ad implements com.baidu.tbadk.core.util.bi {
    @Override // com.baidu.tbadk.core.util.bi
    public final boolean a(Context context, String[] strArr) {
        String str;
        String lowerCase = strArr[0].toLowerCase();
        if (strArr.length <= 1) {
            str = null;
        } else {
            str = strArr[1];
        }
        if (lowerCase.startsWith("frs:")) {
            String substring = lowerCase.substring(4);
            if (context instanceof com.baidu.tbadk.a) {
                ((com.baidu.tbadk.a) context).sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(context).a(substring, str)));
            } else if (context instanceof com.baidu.tbadk.core.e) {
                ((com.baidu.tbadk.core.e) context).a(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(context).a(substring, str)));
            }
        }
        return false;
    }
}
