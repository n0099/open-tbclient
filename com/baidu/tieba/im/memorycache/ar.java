package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.bu;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.live.livenotify.LiveNotifyActivity;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.validate.ValidateActivity;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        ImMessageCenterPojo a;
        ImMessageCenterPojo a2;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
            String cmd = p.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (com.baidu.tieba.im.chat.receiveChatMsgHandler.o.a(cmd)) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid("-1002");
                    imMessageCenterPojo.setCustomGroupType(-3);
                    imMessageCenterPojo.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.o.a(cmd, p.getContent()));
                    imMessageCenterPojo.setLast_content_time(p.getTime());
                    imMessageCenterPojo.setLast_rid(com.baidu.adp.lib.e.b.a(p.getNotice_id(), 0L));
                    c.b().a(imMessageCenterPojo, UpdatesActivity.a ? 0 : 1);
                } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.o.b(cmd)) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    imMessageCenterPojo2.setGid("-1003");
                    imMessageCenterPojo2.setCustomGroupType(-4);
                    imMessageCenterPojo2.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.o.a(cmd, p.getContent()));
                    imMessageCenterPojo2.setLast_content_time(p.getTime());
                    imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.e.b.a(p.getNotice_id(), 0L));
                    c.b().a(imMessageCenterPojo2, ValidateActivity.a ? 0 : 1);
                } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.o.c(cmd)) {
                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                    imMessageCenterPojo3.setGid("-1004");
                    imMessageCenterPojo3.setCustomGroupType(-5);
                    imMessageCenterPojo3.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.o.a(cmd, p.getContent()));
                    imMessageCenterPojo3.setLast_content_time(p.getTime());
                    imMessageCenterPojo3.setLast_rid(com.baidu.adp.lib.e.b.a(p.getNotice_id(), 0L));
                    c.b().a(imMessageCenterPojo3, LiveNotifyActivity.a ? 0 : 1);
                }
                if (cmd.equals("group_head_change")) {
                    UpdatesItemData a3 = com.baidu.tieba.im.groupUpdates.p.a(p);
                    if (a3 != null) {
                        String groupId = a3.getGroupId();
                        if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(a3.getGroupHeadUrl()) && (a2 = c.b().a(groupId, 1)) != null) {
                            if (a2.getGroup_head() == null || !a2.getGroup_head().equals(a3.getGroupHeadUrl())) {
                                c.b().a(groupId, a3.getGroupHeadUrl());
                                a2.setGroup_head(a3.getGroupHeadUrl());
                                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new as(this, a2));
                                customMessageTask.setParallel(com.baidu.tbadk.k.b());
                                customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                                customMessageTask.setPriority(4);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                            }
                        }
                    }
                } else if (cmd.equals("group_name_change")) {
                    UpdatesItemData a4 = com.baidu.tieba.im.groupUpdates.p.a(p);
                    if (a4 != null) {
                        String groupId2 = a4.getGroupId();
                        if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(a4.getGroupName()) && (a = c.b().a(groupId2, 1)) != null) {
                            if (a.getGroup_name() == null || !a.getGroup_name().equals(a4.getGroupName())) {
                                c.b().b(groupId2, a4.getGroupName());
                                a.setGroup_name(a4.getGroupName());
                                CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new at(this, a));
                                customMessageTask2.setParallel(com.baidu.tbadk.k.b());
                                customMessageTask2.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                                customMessageTask2.setPriority(4);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask2);
                            }
                        }
                    }
                } else if (cmd.equals("apply_join_success")) {
                    String content = p.getContent();
                    if (!TextUtils.isEmpty(content)) {
                        try {
                            JSONObject jSONObject = new JSONObject(content);
                            jSONObject.put("notice_id", p.getNotice_id());
                            JSONObject optJSONObject = jSONObject.optJSONObject("eventParam");
                            String optString = optJSONObject.optString("groupId");
                            String optString2 = optJSONObject.optString("groupImage");
                            String optString3 = optJSONObject.optString("groupName");
                            long optLong = optJSONObject.optLong("lastMsgId");
                            com.baidu.tieba.im.groupInfo.y.a().b(TbadkApplication.getCurrentAccount(), optString, true, null);
                            com.baidu.tieba.im.groupInfo.y.a().a(TbadkApplication.getCurrentAccount(), optString, true, (com.baidu.tieba.im.a<Void>) null);
                            ImMessageCenterPojo imMessageCenterPojo4 = new ImMessageCenterPojo();
                            imMessageCenterPojo4.setGroup_name(optString3);
                            imMessageCenterPojo4.setCustomGroupType(1);
                            imMessageCenterPojo4.setGid(optString);
                            imMessageCenterPojo4.setGroup_head(optString2);
                            imMessageCenterPojo4.setLast_content_time(p.getTime());
                            imMessageCenterPojo4.setIs_hidden(0);
                            imMessageCenterPojo4.setUnread_count(0);
                            imMessageCenterPojo4.setLast_content(" ");
                            imMessageCenterPojo4.setLast_rid(bu.b(optLong));
                            imMessageCenterPojo4.setPulled_msgId(bu.b(optLong));
                            c.b().c(imMessageCenterPojo4);
                            c.b().a(1, bu.b(optLong), optString);
                            CustomMessageTask customMessageTask3 = new CustomMessageTask(2001000, new au(this, imMessageCenterPojo4));
                            customMessageTask3.setParallel(com.baidu.tbadk.k.b());
                            customMessageTask3.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                            customMessageTask3.setPriority(4);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001219), customMessageTask3);
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                    }
                } else if (cmd.equals("dismiss_group") || cmd.equals("kick_out")) {
                    String gid = p.getGid();
                    if (TextUtils.isEmpty(gid)) {
                        return;
                    }
                    this.a.a(gid);
                }
            }
        }
    }
}
