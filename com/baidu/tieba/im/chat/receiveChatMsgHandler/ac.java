package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ac {
    private static ac a;

    private ac() {
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            if (a == null) {
                a = new ac();
            }
            acVar = a;
        }
        return acVar;
    }

    public void a(LinkedHashMap<String, Long> linkedHashMap) {
        if (linkedHashMap != null && linkedHashMap.size() != 0) {
            for (Map.Entry<String, Long> entry : linkedHashMap.entrySet()) {
                a(entry.getKey(), entry.getValue().longValue());
            }
        }
    }

    public void a(String str, long j) {
        if (!TextUtils.isEmpty(str) && j > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.e.a().a(com.baidu.adp.lib.f.b.a(str, -1), j);
            com.baidu.tbadk.i.a().b("tb_group_msg_" + str, j);
        }
    }

    public long a(int i) {
        return com.baidu.tbadk.i.a().a("tb_group_msg_" + i, -1L);
    }

    public long[] a(GroupMsgData groupMsgData) {
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            long j = 0;
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
            while (true) {
                long j2 = j;
                if (!it.hasNext()) {
                    return new long[]{groupId, j2};
                }
                ChatMessage next = it.next();
                j = next.getMsgId() > j2 ? next.getMsgId() : j2;
            }
        } else {
            return null;
        }
    }

    public void b(GroupMsgData groupMsgData) {
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (TbadkApplication.m252getInst().getIsUseBaiduStatOn() && !TextUtils.isEmpty(next.getStat())) {
                    TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp().getApplicationContext(), "push_noti:" + next.getStat(), "taskId:" + next.getTaskId() + ";link:" + next.getLink() + ";uid:" + TbadkApplication.getCurrentAccount());
                }
                if (!TextUtils.isEmpty(next.getLink()) && !TextUtils.isEmpty(next.getStat())) {
                    TiebaStatic.pushMsg(next.getMsgId(), 1, next.getLink(), next.getStat());
                }
                CustomMessage customMessage = new CustomMessage(2012100);
                customMessage.setData(new com.baidu.tbadk.core.data.j(next.getMsgId(), next.getTaskId(), next.getLink(), next.getContent(), next.getStat()));
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }
}
