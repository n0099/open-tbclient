package com.baidu.tieba.im.chat.b;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.b.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g {
    private static g jZU;

    private g() {
    }

    public static synchronized g cPt() {
        g gVar;
        synchronized (g.class) {
            if (jZU == null) {
                jZU = new g();
            }
            gVar = jZU;
        }
        return gVar;
    }

    public void K(String str, long j) {
        if (!TextUtils.isEmpty(str) && j > 0) {
            TbadkSettings.getInst().saveLong("tb_group_msg_" + str, j);
        }
    }

    public long gf(long j) {
        return TbadkSettings.getInst().loadLong("tb_group_msg_" + j, -1L);
    }

    public long[] b(GroupMsgData groupMsgData) {
        if (groupMsgData == null || groupMsgData.getGroupInfo() == null) {
            return null;
        }
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
    }

    public void c(GroupMsgData groupMsgData) {
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (!TextUtils.isEmpty(next.getStat())) {
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp().getApplicationContext(), "push_noti:" + next.getStat(), "taskId:" + next.getTaskId() + ";link:" + next.getLink() + ";uid:" + TbadkCoreApplication.getCurrentAccount());
                }
                if (!TextUtils.isEmpty(next.getLink()) && !TextUtils.isEmpty(next.getStat())) {
                    TiebaStatic.pushMsg(next.getMsgId(), 1, next.getLink(), next.getStat());
                }
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.DEAL_YY_NOTIFICATION);
                customMessage.setData(new at(next.getMsgId(), next.getTaskId(), next.getLink(), next.getContent(), next.getStat(), next.getServiceId()));
                MessageManager.getInstance().sendMessage(customMessage);
            }
            if (groupMsgData.getListMessage().size() > 0) {
                TiebaStatic.saveAndUploadMsg();
            }
        }
    }

    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new a.c() { // from class: com.baidu.tieba.im.chat.b.g.1
            @Override // com.baidu.tieba.im.chat.b.a.c
            public boolean Mj(String str) {
                return true;
            }
        }, false);
    }
}
