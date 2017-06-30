package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p {
    private static p daB;

    private p() {
    }

    public static synchronized p aqy() {
        p pVar;
        synchronized (p.class) {
            if (daB == null) {
                daB = new p();
            }
            pVar = daB;
        }
        return pVar;
    }

    public void m(String str, long j) {
        if (!TextUtils.isEmpty(str) && j > 0) {
            TbadkSettings.getInst().saveLong("tb_group_msg_" + str, j);
        }
    }

    public long lH(int i) {
        return TbadkSettings.getInst().loadLong("tb_group_msg_" + i, -1L);
    }

    public long[] b(GroupMsgData groupMsgData) {
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

    public void c(GroupMsgData groupMsgData) {
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            Iterator<ChatMessage> it = groupMsgData.getListMessage().iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (!TextUtils.isEmpty(next.getStat())) {
                    TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp().getApplicationContext(), "push_noti:" + next.getStat(), "taskId:" + next.getTaskId() + ";link:" + next.getLink() + ";uid:" + TbadkCoreApplication.getCurrentAccount());
                }
                if (!TextUtils.isEmpty(next.getLink()) && !TextUtils.isEmpty(next.getStat())) {
                    TiebaStatic.pushMsg(next.getMsgId(), 1, next.getLink(), next.getStat());
                }
                if (TbadkCoreApplication.m9getInst().isPromotedMessageOn()) {
                    CustomMessage customMessage = new CustomMessage(CmdConfigCustom.DEAL_YY_NOTIFICATION);
                    customMessage.setData(new aq(next.getMsgId(), next.getTaskId(), next.getLink(), next.getContent(), next.getStat()));
                    MessageManager.getInstance().sendMessage(customMessage);
                } else {
                    return;
                }
            }
            if (groupMsgData.getListMessage().size() > 0) {
                TiebaStatic.saveAndUploadMsg();
            }
        }
    }

    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new q(), false);
    }
}
