package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import com.baidu.tbadk.core.util.bi;
/* loaded from: classes.dex */
final class o implements bi {
    @Override // com.baidu.tbadk.core.util.bi
    public final boolean a(Context context, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        String str = strArr[0];
        if (str.contains("tieba.baidu.com/group/index?id=")) {
            int indexOf = str.indexOf("tieba.baidu.com/group/index?id=") + "tieba.baidu.com/group/index?id=".length();
            int lastIndexOf = str.lastIndexOf(38);
            if (lastIndexOf == -1 || lastIndexOf < indexOf) {
                lastIndexOf = str.length();
            }
            long a = com.baidu.adp.lib.f.b.a(str.substring(indexOf, lastIndexOf), 0L);
            if (a <= 0) {
                return false;
            }
            com.baidu.tbadk.core.b.o oVar = new com.baidu.tbadk.core.b.o(context, a, 0);
            if (context instanceof com.baidu.tbadk.a) {
                ((com.baidu.tbadk.a) context).sendMessage(new com.baidu.adp.framework.message.a(2008011, oVar));
                return true;
            } else if (context instanceof com.baidu.tbadk.core.e) {
                ((com.baidu.tbadk.core.e) context).a(new com.baidu.adp.framework.message.a(2008011, oVar));
                return true;
            }
        }
        return false;
    }
}
