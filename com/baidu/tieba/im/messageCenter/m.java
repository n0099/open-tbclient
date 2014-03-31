package com.baidu.tieba.im.messageCenter;

import android.support.v4.app.Fragment;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.v;
/* loaded from: classes.dex */
final class m implements com.baidu.adp.framework.task.a<v> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<Fragment> a(com.baidu.adp.framework.message.a<v> aVar) {
        if (aVar != null && aVar.a() != null) {
            Fragment b = aVar.a().b();
            if (b instanceof com.baidu.tieba.im.chat.notify.b) {
                ((com.baidu.tieba.im.chat.notify.b) b).a();
            }
        }
        return null;
    }
}
