package com.baidu.tieba.forumfeed;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.b.ao;
/* loaded from: classes.dex */
final class t implements com.baidu.adp.framework.task.a<ao> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<ao> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), SingleForumFeedActivity.class);
            aVar.a().f();
        }
        return null;
    }
}
