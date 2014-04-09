package com.baidu.tieba.im.c;

import com.baidu.adp.framework.b.m;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.data.GroupIdTypeData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public final class l extends m {
    private long a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.f' to match base method */
    @Override // com.baidu.adp.framework.b.i
    public final /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        GroupMsgData next;
        String E;
        int i;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 instanceof ResponsePullMessage) {
            if (socketResponsedMessage2.e() == 110000) {
                com.baidu.adp.framework.c.a().b(new ResponseUnLoginMessage());
            }
            if (this.a % 10 == 0) {
                TiebaStatic.a(socketResponsedMessage2);
                this.a++;
            }
            b.a().h();
            Iterator<GroupMsgData> it = ((ResponsePullMessage) socketResponsedMessage2).d().iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (next != null && next.b() != null) {
                    int groupId = next.b().getGroupId();
                    Iterator<com.baidu.tieba.im.message.a.a> it2 = next.c().iterator();
                    long j = 0;
                    while (it2.hasNext()) {
                        com.baidu.tieba.im.message.a.a next2 = it2.next();
                        if (next2.w() > j) {
                            j = next2.w();
                        }
                    }
                    com.baidu.tbadk.coreExtra.messageCenter.d.a().a(groupId, j / 100);
                }
                GroupIdTypeData b = next.b();
                switch (b.getGroupType()) {
                    case 1:
                        b.setCustomType(0);
                        a(next);
                        continue;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        b.setCustomType(1);
                        a(next);
                        continue;
                    case 6:
                        if (next == null) {
                            continue;
                        } else if (next.b() != null) {
                            x.a(next.b().getGroupId());
                            if (next.c() != null && (E = TbadkApplication.E()) != null) {
                                long a = com.baidu.adp.lib.f.b.a(E, 0L);
                                LinkedList<com.baidu.tieba.im.message.a.a> c = next.c();
                                HashMap hashMap = new HashMap();
                                for (com.baidu.tieba.im.message.a.a aVar : c) {
                                    long x = aVar.x();
                                    int userType = aVar.r().getUserType();
                                    if (x == a) {
                                        x = aVar.l();
                                        i = aVar.s().getUserType();
                                    } else {
                                        i = userType;
                                    }
                                    GroupMsgData groupMsgData = (GroupMsgData) hashMap.get(Long.valueOf(x));
                                    if (groupMsgData == null) {
                                        if (i == 1) {
                                            groupMsgData = new GroupMsgData(2013003);
                                            groupMsgData.b().setCustomType(4);
                                        } else {
                                            groupMsgData = new GroupMsgData(2013001);
                                            groupMsgData.b().setCustomType(2);
                                        }
                                        hashMap.put(Long.valueOf(x), groupMsgData);
                                    }
                                    groupMsgData.c().add(aVar);
                                }
                                for (Map.Entry entry : hashMap.entrySet()) {
                                    if (entry != null && entry.getValue() != null) {
                                        a((GroupMsgData) entry.getValue());
                                    }
                                }
                            }
                        }
                        break;
                    case 7:
                        b.setCustomType(3);
                        a(next);
                        continue;
                    case 8:
                        b.setCustomType(5);
                        a(next);
                        break;
                }
                b.setCustomType(6);
                a(next);
            }
            return null;
        }
        return null;
    }

    public l() {
        super(202003);
        this.a = 0L;
    }

    private static void a(GroupMsgData groupMsgData) {
        if (groupMsgData != null && groupMsgData.b() != null) {
            com.baidu.adp.framework.c.a().b(groupMsgData);
        }
    }
}
