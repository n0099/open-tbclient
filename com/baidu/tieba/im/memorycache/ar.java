package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.validate.ValidateActivity;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        ImMessageCenterPojo B;
        ImMessageCenterPojo B2;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
            String cmd = p.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (com.baidu.tieba.im.chat.receiveChatMsgHandler.q.fI(cmd)) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid("-1002");
                    imMessageCenterPojo.setCustomGroupType(-3);
                    imMessageCenterPojo.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.q.ao(cmd, p.getContent()));
                    imMessageCenterPojo.setLast_content_time(p.getTime());
                    imMessageCenterPojo.setLast_rid(com.baidu.adp.lib.g.c.a(p.getNotice_id(), 0L));
                    c.PK().b(imMessageCenterPojo, UpdatesActivity.isOpen ? 0 : 1);
                } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.q.fJ(cmd)) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    imMessageCenterPojo2.setGid("-1003");
                    imMessageCenterPojo2.setCustomGroupType(-4);
                    imMessageCenterPojo2.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.q.ao(cmd, p.getContent()));
                    imMessageCenterPojo2.setLast_content_time(p.getTime());
                    imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.g.c.a(p.getNotice_id(), 0L));
                    c.PK().b(imMessageCenterPojo2, ValidateActivity.isOpen ? 0 : 1);
                } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.q.fK(cmd)) {
                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                    imMessageCenterPojo3.setGid("-1004");
                    imMessageCenterPojo3.setCustomGroupType(-5);
                    imMessageCenterPojo3.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.q.ao(cmd, p.getContent()));
                    imMessageCenterPojo3.setLast_content_time(p.getTime());
                    imMessageCenterPojo3.setLast_rid(com.baidu.adp.lib.g.c.a(p.getNotice_id(), 0L));
                    c.PK().b(imMessageCenterPojo3, TbadkApplication.m251getInst().getSharedPreferences(TbConfig.SETTINGFILE, 0).getBoolean("live_notify_page_showing", false) ? 0 : 1);
                }
                if (cmd.equals("group_head_change")) {
                    UpdatesItemData f = com.baidu.tieba.im.groupUpdates.p.f(p);
                    if (f != null) {
                        String groupId = f.getGroupId();
                        if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(f.getGroupHeadUrl()) && (B2 = c.PK().B(groupId, 1)) != null) {
                            if (B2.getGroup_head() == null || !B2.getGroup_head().equals(f.getGroupHeadUrl())) {
                                c.PK().as(groupId, f.getGroupHeadUrl());
                                B2.setGroup_head(f.getGroupHeadUrl());
                                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new as(this, B2));
                                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                                customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                                customMessageTask.setPriority(4);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                            }
                        }
                    }
                } else if (cmd.equals("group_name_change")) {
                    UpdatesItemData f2 = com.baidu.tieba.im.groupUpdates.p.f(p);
                    if (f2 != null) {
                        String groupId2 = f2.getGroupId();
                        if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(f2.getGroupName()) && (B = c.PK().B(groupId2, 1)) != null) {
                            if (B.getGroup_name() == null || !B.getGroup_name().equals(f2.getGroupName())) {
                                c.PK().at(groupId2, f2.getGroupName());
                                B.setGroup_name(f2.getGroupName());
                                CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new at(this, B));
                                customMessageTask2.setParallel(TiebaIMConfig.getParallel());
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
                            com.baidu.tieba.im.groupInfo.z.Pb().b(TbadkApplication.getCurrentAccount(), optString, true, null);
                            com.baidu.tieba.im.groupInfo.z.Pb().a(TbadkApplication.getCurrentAccount(), optString, true, (com.baidu.tieba.im.a<Void>) null);
                            ImMessageCenterPojo imMessageCenterPojo4 = new ImMessageCenterPojo();
                            imMessageCenterPojo4.setGroup_name(optString3);
                            imMessageCenterPojo4.setCustomGroupType(1);
                            imMessageCenterPojo4.setGid(optString);
                            imMessageCenterPojo4.setGroup_head(optString2);
                            imMessageCenterPojo4.setLast_content_time(p.getTime());
                            imMessageCenterPojo4.setIs_hidden(0);
                            imMessageCenterPojo4.setUnread_count(0);
                            imMessageCenterPojo4.setLast_content(" ");
                            imMessageCenterPojo4.setLast_rid(com.baidu.tieba.im.chat.bu.F(optLong));
                            imMessageCenterPojo4.setPulled_msgId(com.baidu.tieba.im.chat.bu.F(optLong));
                            c.PK().g(imMessageCenterPojo4);
                            c.PK().a(1, com.baidu.tieba.im.chat.bu.F(optLong), optString);
                            CustomMessageTask customMessageTask3 = new CustomMessageTask(2001000, new au(this, imMessageCenterPojo4));
                            customMessageTask3.setParallel(TiebaIMConfig.getParallel());
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
                    this.this$0.gs(gid);
                }
            }
        }
    }
}
