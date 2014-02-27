package com.baidu.tieba.im.chat;

import android.content.Intent;
import com.baidu.tieba.im.data.GroupData;
/* loaded from: classes.dex */
final class al implements com.baidu.adp.framework.task.a<com.baidu.tieba.a.b> {
    @Override // com.baidu.adp.framework.task.a
    public final com.baidu.adp.framework.message.b<com.baidu.tieba.a.b> a(com.baidu.adp.framework.message.a<com.baidu.tieba.a.b> aVar) {
        GroupData a;
        if (aVar != null && aVar.a() != null && (a = aVar.a().a()) != null && a.getGroupId() != 0) {
            String b = aVar.a().b();
            String valueOf = String.valueOf(a.getGroupId());
            if (!com.baidu.tieba.model.bs.a().a(valueOf)) {
                new com.baidu.tieba.account.x("chat_pg", b, valueOf).start();
                com.baidu.tieba.model.bs.a().a(valueOf, Long.valueOf(System.currentTimeMillis()));
            }
            Intent d = aVar.a().d();
            d.setClass(aVar.a().c(), GroupChatActivity.class);
            d.putExtra("group_author_id", String.valueOf(a.getAuthorId()));
            aVar.a().e();
        }
        return null;
    }
}
