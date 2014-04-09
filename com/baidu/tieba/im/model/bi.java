package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class bi implements com.baidu.adp.framework.task.a<String> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<Boolean> a(com.baidu.adp.framework.message.a<String> aVar) {
        if (aVar != null) {
            String a = aVar.a();
            if (!TextUtils.isEmpty(a)) {
                bd.a(a, (com.baidu.tieba.im.a<Void>) null);
            }
        }
        return null;
    }
}
