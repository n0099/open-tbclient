package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.model.ModelHelper;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        ImMessageCenterPojo a;
        UpdatesItemData convertToUpdatesItem;
        ImMessageCenterPojo ah;
        UpdatesItemData convertToUpdatesItem2;
        ImMessageCenterPojo ah2;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
            String cmd = p.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (com.baidu.tieba.im.chat.receiveChatMsgHandler.n.lz(cmd)) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid("-1002");
                    imMessageCenterPojo.setCustomGroupType(-3);
                    imMessageCenterPojo.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.n.bd(cmd, p.getContent()));
                    imMessageCenterPojo.setLast_content_time(p.getTime());
                    imMessageCenterPojo.setLast_rid(com.baidu.adp.lib.h.b.c(p.getNotice_id(), 0L));
                    b.axj().c(imMessageCenterPojo, ChatStatusManager.getInst().getIsOpen(6) ? 0 : 1);
                } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.n.lA(cmd)) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    imMessageCenterPojo2.setGid("-1003");
                    imMessageCenterPojo2.setCustomGroupType(-4);
                    imMessageCenterPojo2.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.n.bd(cmd, p.getContent()));
                    imMessageCenterPojo2.setLast_content_time(p.getTime());
                    imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.h.b.c(p.getNotice_id(), 0L));
                    b.axj().c(imMessageCenterPojo2, ChatStatusManager.getInst().getIsOpen(7) ? 0 : 1);
                } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.n.lC(cmd)) {
                    ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                    imMessageCenterPojo3.setGid("-1004");
                    imMessageCenterPojo3.setCustomGroupType(-5);
                    imMessageCenterPojo3.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.n.bd(cmd, p.getContent()));
                    imMessageCenterPojo3.setLast_content_time(p.getTime());
                    imMessageCenterPojo3.setLast_rid(com.baidu.adp.lib.h.b.c(p.getNotice_id(), 0L));
                    b.axj().c(imMessageCenterPojo3, ChatStatusManager.getInst().getIsOpen(8) ? 0 : 1);
                }
                if (cmd.equals("group_head_change")) {
                    if (ModelHelper.getInstance().getUpdatasModel() != null && (convertToUpdatesItem2 = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) != null) {
                        String groupId = convertToUpdatesItem2.getGroupId();
                        if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(convertToUpdatesItem2.getGroupHeadUrl()) && (ah2 = b.axj().ah(groupId, 1)) != null) {
                            if (ah2.getGroup_head() == null || !ah2.getGroup_head().equals(convertToUpdatesItem2.getGroupHeadUrl())) {
                                b.axj().bg(groupId, convertToUpdatesItem2.getGroupHeadUrl());
                                ah2.setGroup_head(convertToUpdatesItem2.getGroupHeadUrl());
                                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new ap(this, ah2));
                                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                                customMessageTask.setPriority(4);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                            }
                        }
                    }
                } else if (cmd.equals("group_name_change")) {
                    if (ModelHelper.getInstance().getUpdatasModel() != null && (convertToUpdatesItem = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) != null) {
                        String groupId2 = convertToUpdatesItem.getGroupId();
                        if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(convertToUpdatesItem.getGroupName()) && (ah = b.axj().ah(groupId2, 1)) != null) {
                            if (ah.getGroup_name() == null || !ah.getGroup_name().equals(convertToUpdatesItem.getGroupName())) {
                                b.axj().bh(groupId2, convertToUpdatesItem.getGroupName());
                                ah.setGroup_name(convertToUpdatesItem.getGroupName());
                                CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new aq(this, ah));
                                customMessageTask2.setParallel(TiebaIMConfig.getParallel());
                                customMessageTask2.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
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
                            com.baidu.tieba.im.settingcache.c.ayD().c(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                            com.baidu.tieba.im.settingcache.c.ayD().b(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                            ImMessageCenterPojo imMessageCenterPojo4 = new ImMessageCenterPojo();
                            imMessageCenterPojo4.setGroup_name(optString3);
                            imMessageCenterPojo4.setCustomGroupType(1);
                            imMessageCenterPojo4.setGid(optString);
                            imMessageCenterPojo4.setGroup_head(optString2);
                            imMessageCenterPojo4.setLast_content_time(p.getTime());
                            imMessageCenterPojo4.setIs_hidden(0);
                            imMessageCenterPojo4.setUnread_count(0);
                            imMessageCenterPojo4.setLast_content(" ");
                            imMessageCenterPojo4.setLast_rid(com.baidu.tieba.im.util.g.cc(optLong));
                            imMessageCenterPojo4.setPulled_msgId(com.baidu.tieba.im.util.g.cc(optLong));
                            b.axj().i(imMessageCenterPojo4);
                            b.axj().a(1, com.baidu.tieba.im.util.g.cc(optLong), optString);
                            CustomMessageTask customMessageTask3 = new CustomMessageTask(2001000, new ar(this, imMessageCenterPojo4));
                            customMessageTask3.setParallel(TiebaIMConfig.getParallel());
                            customMessageTask3.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                            customMessageTask3.setPriority(4);
                            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VALIDATE_JOIN_GROUP_SUCC), customMessageTask3);
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                    }
                } else if (cmd.equals("dismiss_group") || cmd.equals("kick_out")) {
                    String gid = p.getGid();
                    if (TextUtils.isEmpty(gid)) {
                        return;
                    }
                    this.this$0.mn(gid);
                } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.n.lB(cmd) && (a = com.baidu.tieba.im.chat.receiveChatMsgHandler.n.a(p, cmd)) != null) {
                    b.axj().c(a, 1);
                }
            }
        }
    }
}
