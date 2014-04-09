package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class y extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        long[] jArr;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage2;
            if (groupMsgData.b().getGroupId() == 10) {
                b.a((GroupMsgData) customResponsedMessage2, false);
            } else {
                x.a();
                if (groupMsgData == null || groupMsgData.b() == null) {
                    jArr = null;
                } else {
                    long j = 0;
                    long groupId = groupMsgData.b().getGroupId();
                    Iterator<com.baidu.tieba.im.message.a.a> it = groupMsgData.c().iterator();
                    while (it.hasNext()) {
                        com.baidu.tieba.im.message.a.a next = it.next();
                        j = next.w() > j ? next.w() : j;
                    }
                    jArr = new long[]{groupId, j};
                }
                if (jArr != null) {
                    x.a();
                    x.a(String.valueOf(jArr[0]), jArr[1] / 100);
                }
            }
            x.a();
            if (groupMsgData == null || groupMsgData.b() == null) {
                return;
            }
            Iterator<com.baidu.tieba.im.message.a.a> it2 = groupMsgData.c().iterator();
            while (it2.hasNext()) {
                com.baidu.tieba.im.message.a.a next2 = it2.next();
                com.baidu.adp.framework.message.a aVar = new com.baidu.adp.framework.message.a(2012100);
                aVar.a((com.baidu.adp.framework.message.a) new com.baidu.tbadk.core.data.k(next2.w(), next2.m(), next2.v(), next2.n()));
                com.baidu.adp.framework.c.a().a(aVar);
            }
        }
    }

    public y() {
        super(2013006);
    }
}
