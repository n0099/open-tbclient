package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.SnapChatMsgHelper;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.d;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.f;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.h;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.g;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ChatRoomEventResponseMessage;
import com.baidu.tieba.im.message.GroupMemberChangeResponsedMessage;
import com.baidu.tieba.im.message.MemoryClearStrangerItemsMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.MemoryItemRemoveMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import com.baidu.tieba.im.message.MemoryUpdateHeadNameMessage;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.ResponseMemoryNotifyUpdataGroupMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.model.ModelHelper;
import com.baidu.tieba.im.util.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImMemoryCacheRegister {
    private static volatile ImMemoryCacheRegister eES;
    private ResponseOnlineMessage eER;
    private com.baidu.adp.framework.listener.c eET = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseCommitGroupMessage)) {
                final ChatMessage chatMessage = (ChatMessage) socketResponsedMessage.getOrginalMessage();
                if (chatMessage.getLocalData() == null) {
                    chatMessage.setLocalData(new MsgLocalData());
                }
                if (socketResponsedMessage.hasError()) {
                    chatMessage.getLocalData().setStatus((short) 2);
                } else {
                    chatMessage.getLocalData().setStatus((short) 3);
                    long msgId = ((ResponseCommitGroupMessage) socketResponsedMessage).getMsgId();
                    long recordId = ((ResponseCommitGroupMessage) socketResponsedMessage).getRecordId();
                    chatMessage.setMsgId(msgId);
                    chatMessage.setRecordId(recordId);
                }
                com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "ack", socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), new Object[0]);
                b.aJa().a(chatMessage.getCustomGroupType(), chatMessage, chatMessage.getGroupId(), 3);
                final ImMessageCenterPojo am = b.aJa().am(chatMessage.getGroupId(), chatMessage.getCustomGroupType());
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.1.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                            return null;
                        }
                        try {
                            g.aGG().aGH();
                            i.aGK().a(am, 3);
                            com.baidu.tieba.im.db.c.aGC().b(chatMessage.getGroupId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            g.aGG().endTransaction();
                        }
                        return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, socketResponsedMessage);
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    };
    private com.baidu.adp.framework.listener.c eEU = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final SocketResponsedMessage socketResponsedMessage) {
            final ImMessageCenterPojo am;
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
                ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) socketResponsedMessage;
                final ChatMessage chatMessage = (ChatMessage) responseCommitPersonalMessage.getOrginalMessage();
                int toUserType = responseCommitPersonalMessage.getToUserType();
                if (socketResponsedMessage.hasError()) {
                    chatMessage.getLocalData().setStatus((short) 2);
                } else {
                    long msgId = responseCommitPersonalMessage.getMsgId();
                    long recordId = responseCommitPersonalMessage.getRecordId();
                    chatMessage.setMsgId(msgId);
                    chatMessage.setRecordId(recordId);
                    chatMessage.getLocalData().setStatus((short) 3);
                    if (responseCommitPersonalMessage.getToUserType() == 0) {
                        com.baidu.tieba.im.sendmessage.a.qx(com.baidu.adp.lib.g.b.h(responseCommitPersonalMessage.getGroupId(), 0));
                    } else {
                        com.baidu.tieba.im.sendmessage.a.qy(com.baidu.adp.lib.g.b.h(responseCommitPersonalMessage.getGroupId(), 0));
                    }
                }
                com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "ack", socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), ClientCookie.COMMENT_ATTR, "uType " + toUserType, "touid", Long.valueOf(chatMessage.getToUserId()), "content", chatMessage.getContent());
                if (chatMessage instanceof PersonalChatMessage) {
                    b.aJa().a(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    b.aJa().a(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else {
                    return;
                }
                if (chatMessage instanceof PersonalChatMessage) {
                    am = b.aJa().am(String.valueOf(e.s(chatMessage)), 2);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    am = b.aJa().am(String.valueOf(e.s(chatMessage)), 4);
                } else {
                    return;
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.12.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null) {
                            try {
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            } finally {
                                g.aGG().endTransaction();
                            }
                            if (customMessage instanceof CustomMessage) {
                                g.aGG().aGH();
                                i.aGK().a(am, 3);
                                if (am.getCustomGroupType() == 2) {
                                    l.aGR().a(chatMessage.getUserId(), chatMessage.getToUserId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                                } else {
                                    k.aGQ().a(chatMessage.getUserId(), chatMessage.getToUserId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                                }
                                return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, socketResponsedMessage);
                            }
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    };
    private CustomMessageListener eEV = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo am;
            if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (am = b.aJa().am("-1002", -3)) != null) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    am.setUnread_count(0);
                    am.setIs_hidden(1);
                    ImMemoryCacheRegister.this.m(am);
                } else if (data instanceof ImMessageCenterPojo) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                    am.setLast_content(imMessageCenterPojo.getLast_content());
                    am.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    am.setUnread_count(0);
                    am.setIs_hidden(0);
                    ImMemoryCacheRegister.this.m(am);
                }
            }
        }
    };
    private CustomMessageListener eEW = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo am;
            if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (am = b.aJa().am("-1003", -4)) != null) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    am.setUnread_count(0);
                    am.setIs_hidden(1);
                    ImMemoryCacheRegister.this.m(am);
                } else if (data instanceof ImMessageCenterPojo) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                    am.setLast_content(imMessageCenterPojo.getLast_content());
                    am.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    am.setUnread_count(0);
                    am.setIs_hidden(0);
                    ImMemoryCacheRegister.this.m(am);
                }
            }
        }
    };
    private CustomMessageListener eEX = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo am;
            if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (am = b.aJa().am("-1004", -5)) != null) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    am.setUnread_count(0);
                    am.setIs_hidden(1);
                    ImMemoryCacheRegister.this.m(am);
                } else if (data instanceof ImMessageCenterPojo) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                    am.setLast_content(imMessageCenterPojo.getLast_content());
                    am.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    am.setUnread_count(0);
                    am.setIs_hidden(0);
                    ImMemoryCacheRegister.this.m(am);
                }
            }
        }
    };
    private CustomMessageListener eEY = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ImMessageCenterPojo)) {
                final ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData();
                b.aJa().i(imMessageCenterPojo);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.34.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null && (customMessage instanceof CustomMessage)) {
                            com.baidu.tieba.im.db.c.aGC().mY(imMessageCenterPojo.getGid());
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    };
    private CustomMessageListener eEZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ImMessageCenterPojo)) {
                b.aJa().i((ImMessageCenterPojo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eFa = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final String valueOf = String.valueOf(customResponsedMessage.getData());
            b.aJa().ao(valueOf, 9);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.36.1
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && (customMessage instanceof CustomMessage)) {
                        com.baidu.tieba.im.db.c.aGC().mW(valueOf);
                    }
                    return null;
                }
            });
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    };
    private CustomMessageListener eFb = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage;
            MemoryClearStrangerItemsMessage.a data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryClearStrangerItemsMessage) && (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) != null && data.eEh != null) {
                for (MemoryModifyVisibilityMessage.a aVar : data.eEh) {
                    b.aJa().ao(aVar.id, aVar.customGroupType);
                }
                if (memoryClearStrangerItemsMessage.isAllClear()) {
                    b.aJa().e("-1001", -7, false);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.37.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null) {
                            try {
                                if (customMessage instanceof CustomMessage) {
                                    g.aGG().aGH();
                                    i.aGK().aGO();
                                    if (memoryClearStrangerItemsMessage.isAllClear()) {
                                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                        imMessageCenterPojo.setGid("-1001");
                                        imMessageCenterPojo.setCustomGroupType(-7);
                                        imMessageCenterPojo.setIs_hidden(1);
                                        i.aGK().c(imMessageCenterPojo);
                                    }
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            } finally {
                                g.aGG().endTransaction();
                            }
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    };
    private CustomMessageListener eFc = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MemoryItemRemoveMessage.a)) {
                MemoryItemRemoveMessage.a aVar = (MemoryItemRemoveMessage.a) customResponsedMessage.getData();
                if (aVar.customGroupType == 1) {
                    ImMemoryCacheRegister.this.ny(aVar.id);
                } else if (aVar.customGroupType == 3) {
                    b.aJa().ao(aVar.id, 3);
                }
            }
        }
    };
    private CustomMessageListener eFd = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof GroupMsgData)) {
                GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
                if (groupMsgData.getGroupInfo() != null) {
                    if (groupMsgData.getGroupInfo().getGroupId() == 0) {
                        BdLog.e("groupMsgData.getGroupInfo().getGroupId() == 0");
                    }
                    String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
                    int customType = groupMsgData.getGroupInfo().getCustomType();
                    if (!TextUtils.isEmpty(valueOf)) {
                        ImMessageCenterPojo am = b.aJa().am(valueOf, customType);
                        if (groupMsgData.getCmd() == 2012125) {
                            com.baidu.tieba.im.chat.receiveChatMsgHandler.b.a(groupMsgData, am, ImMemoryCacheRegister.this.eFt);
                        } else if (groupMsgData.getCmd() == 2012127) {
                            com.baidu.tieba.im.chat.receiveChatMsgHandler.c.a(groupMsgData, am, ImMemoryCacheRegister.this.eFv);
                        } else if (groupMsgData.getCmd() == 2012124) {
                            d.a(groupMsgData, am, ImMemoryCacheRegister.this.eFw);
                        } else if (groupMsgData.getCmd() == 2012123) {
                            com.baidu.tieba.im.chat.receiveChatMsgHandler.e.b(groupMsgData, am, ImMemoryCacheRegister.this.eFy);
                        } else if (groupMsgData.getCmd() == 2012121) {
                            f.b(groupMsgData, am, ImMemoryCacheRegister.this.eFz);
                        } else if (groupMsgData.getCmd() == 2012122) {
                            SnapChatMsgHelper.a(groupMsgData, am, ImMemoryCacheRegister.this.eFx);
                        } else if (groupMsgData.getCmd() == 2012120) {
                            com.baidu.tieba.im.chat.receiveChatMsgHandler.g.a(groupMsgData, am, ImMemoryCacheRegister.this.eFu);
                        } else if (groupMsgData.getCmd() == 2012128) {
                            if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                b.aJa().a(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.eIo));
                            }
                        } else if (groupMsgData.getCmd() == 2012129) {
                            if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                ChatMessage chatMessage = groupMsgData.getListMessage().get(0);
                                if (!chatMessage.isPushForOperateAccount()) {
                                    b.aJa().a(-9, chatMessage.getMsgId(), String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
                                }
                            }
                        } else if (groupMsgData.getCmd() == 2012126) {
                            if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                                h.a(groupMsgData, am, new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.3.1
                                    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
                                    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
                                        if (imMessageCenterPojo != null) {
                                            b.aJa().a(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
                                        }
                                    }

                                    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
                                    public void g(String str, List<CommonMsgPojo> list) {
                                    }
                                });
                            } else {
                                long[] b = h.aEY().b(groupMsgData);
                                if (b != null && b.length == 2) {
                                    if (b[0] <= 0 && b[1] > 0) {
                                        if (b[0] == 12) {
                                            b.aJa().a(8, b[1], String.valueOf(12));
                                        } else if (b[0] == 11) {
                                            b.aJa().a(7, b[1], String.valueOf(11));
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            h.aEY().c(groupMsgData);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c eFe = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ImMemoryCacheRegister.this.eER = (ResponseOnlineMessage) socketResponsedMessage;
                if (b.aJa().eED.get()) {
                    ImMemoryCacheRegister.this.aJn();
                }
            }
        }
    };
    private CustomMessageListener eFf = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002 && (customResponsedMessage instanceof MemoryInitCompleteMessage)) {
                ImMemoryCacheRegister.this.aJn();
            }
        }
    };
    private CustomMessageListener bQx = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005018) {
                ImMemoryCacheRegister.this.eER = null;
                com.baidu.tieba.im.sendmessage.a.qx(0);
                com.baidu.tieba.im.sendmessage.a.qy(0);
                b.aJa().init();
            }
        }
    };
    private CustomMessageListener eFg = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyLastMsgMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016003 && (data = ((MemoryModifyLastMsgMessage) customResponsedMessage).getData()) != null) {
                b.aJa().a(data.customGroupType, data.eGd, data.id, data.type);
                final ImMessageCenterPojo am = b.aJa().am(data.id, data.customGroupType);
                if (am != null) {
                    final ImMessageCenterPojo imMessageCenterPojo = null;
                    if (am.getCustomGroupType() == 4) {
                        imMessageCenterPojo = b.aJa().am("-1000", -8);
                    }
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.8.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            i.aGK().a(am, 2);
                            if (imMessageCenterPojo != null) {
                                i.aGK().a(imMessageCenterPojo, 2);
                                return null;
                            }
                            return null;
                        }
                    });
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                }
            }
        }
    };
    private CustomMessageListener eFh = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008016) {
                b.aJa().reset();
            }
        }
    };
    private CustomMessageListener eFi = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyVisibilityMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016005 && (customResponsedMessage instanceof MemoryModifyVisibilityMessage) && (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) != null) {
                final ImMessageCenterPojo am = b.aJa().am(data.id, data.customGroupType);
                int i = data.visible ? 0 : 1;
                if (am != null && i != am.getIs_hidden()) {
                    if (data.customGroupType == 2) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().fe(data.id);
                    } else if (data.customGroupType == 4) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().gQ(com.baidu.adp.lib.g.b.h(data.id, 0));
                    } else if (data.customGroupType == -3) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().gR(2);
                    } else if (data.customGroupType == -4) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().gR(1);
                    } else if (data.customGroupType == -5) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().gR(3);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gh().fd(data.id);
                    }
                    b.aJa().e(data.id, data.customGroupType, data.visible);
                    am.setIs_hidden(i);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
                            if (customMessage != null && customMessage.getData() != null) {
                                i.aGK().c(am);
                            }
                            return null;
                        }
                    });
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
                }
            }
        }
    };
    private CustomMessageListener eFj = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearUnreadCountMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016006 && (customResponsedMessage instanceof MemoryClearUnreadCountMessage) && (data = ((MemoryClearUnreadCountMessage) customResponsedMessage).getData()) != null) {
                ImMessageCenterPojo am = b.aJa().am(data.id, data.customGroupType);
                if (am == null) {
                    BdLog.e("ClearUnreadCountMessage:  not find memery pojo");
                } else if (am.getUnread_count() != 0) {
                    b.aJa().ap(data.id, data.customGroupType);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<MemoryClearUnreadCountMessage.a> customMessage) {
                            if (customMessage == null) {
                            }
                            MemoryClearUnreadCountMessage.a data2 = customMessage.getData();
                            i.aGK().aj(data2.id, data2.customGroupType);
                            return null;
                        }
                    });
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
                }
            }
        }
    };
    private CustomMessageListener eFk = new CustomMessageListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_CREATE_GROUP) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ImMessageCenterPojo)) {
                final ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData();
                b.aJa().h(imMessageCenterPojo);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.13.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        try {
                            try {
                                g.aGG().aGH();
                                i.aGK().c(imMessageCenterPojo);
                                com.baidu.tieba.im.db.c.aGC().mY(imMessageCenterPojo.getGid());
                                g.aGG().endTransaction();
                                return null;
                            } catch (Exception e) {
                                BdLog.detailException(e);
                                g.aGG().endTransaction();
                                return null;
                            }
                        } catch (Throwable th) {
                            g.aGG().endTransaction();
                            throw th;
                        }
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    };
    private CustomMessageTask.CustomRunnable<Integer> eFl = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.14
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
            List<ImMessageCenterPojo> aJj;
            if (customMessage == null || !(customMessage instanceof RequestMemoryListMessage)) {
                return null;
            }
            int intValue = ((RequestMemoryListMessage) customMessage).getData().intValue();
            if (intValue == 3) {
                aJj = b.aJa().aJi();
            } else if (intValue == 2) {
                aJj = b.aJa().aJh();
            } else if (intValue == 1) {
                aJj = b.aJa().aJf();
            } else {
                aJj = intValue == 4 ? b.aJa().aJj() : null;
            }
            return new ResponsedMemoryListMessage(aJj, intValue);
        }
    };
    private CustomMessageListener eFm = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            ImMessageCenterPojo a;
            UpdatesItemData convertToUpdatesItem;
            final ImMessageCenterPojo am;
            UpdatesItemData convertToUpdatesItem2;
            final ImMessageCenterPojo am2;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                String cmd = p.getCmd();
                if (!TextUtils.isEmpty(cmd)) {
                    if (com.baidu.tieba.im.chat.receiveChatMsgHandler.g.mI(cmd)) {
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        imMessageCenterPojo.setGid("-1002");
                        imMessageCenterPojo.setCustomGroupType(-3);
                        imMessageCenterPojo.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.g.ba(cmd, p.getContent()));
                        imMessageCenterPojo.setLast_content_time(p.getTime());
                        imMessageCenterPojo.setLast_rid(com.baidu.adp.lib.g.b.c(p.getNotice_id(), 0L));
                        b.aJa().c(imMessageCenterPojo, ChatStatusManager.getInst().getIsOpen(6) ? 0 : 1);
                    } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.g.mJ(cmd)) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1003");
                        imMessageCenterPojo2.setCustomGroupType(-4);
                        imMessageCenterPojo2.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.g.ba(cmd, p.getContent()));
                        imMessageCenterPojo2.setLast_content_time(p.getTime());
                        imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.g.b.c(p.getNotice_id(), 0L));
                        b.aJa().c(imMessageCenterPojo2, ChatStatusManager.getInst().getIsOpen(7) ? 0 : 1);
                    } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.g.mL(cmd)) {
                        ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                        imMessageCenterPojo3.setGid("-1004");
                        imMessageCenterPojo3.setCustomGroupType(-5);
                        imMessageCenterPojo3.setLast_content(com.baidu.tieba.im.chat.receiveChatMsgHandler.g.ba(cmd, p.getContent()));
                        imMessageCenterPojo3.setLast_content_time(p.getTime());
                        imMessageCenterPojo3.setLast_rid(com.baidu.adp.lib.g.b.c(p.getNotice_id(), 0L));
                        b.aJa().c(imMessageCenterPojo3, ChatStatusManager.getInst().getIsOpen(8) ? 0 : 1);
                    }
                    if (cmd.equals("group_head_change")) {
                        if (ModelHelper.getInstance().getUpdatasModel() != null && (convertToUpdatesItem2 = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) != null) {
                            String groupId = convertToUpdatesItem2.getGroupId();
                            if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(convertToUpdatesItem2.getGroupHeadUrl()) && (am2 = b.aJa().am(groupId, 1)) != null) {
                                if (am2.getGroup_head() == null || !am2.getGroup_head().equals(convertToUpdatesItem2.getGroupHeadUrl())) {
                                    b.aJa().bd(groupId, convertToUpdatesItem2.getGroupHeadUrl());
                                    am2.setGroup_head(convertToUpdatesItem2.getGroupHeadUrl());
                                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15.1
                                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                            i.aGK().c(am2);
                                            return null;
                                        }
                                    });
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
                            if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(convertToUpdatesItem.getGroupName()) && (am = b.aJa().am(groupId2, 1)) != null) {
                                if (am.getGroup_name() == null || !am.getGroup_name().equals(convertToUpdatesItem.getGroupName())) {
                                    b.aJa().be(groupId2, convertToUpdatesItem.getGroupName());
                                    am.setGroup_name(convertToUpdatesItem.getGroupName());
                                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15.2
                                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                            i.aGK().c(am);
                                            return null;
                                        }
                                    });
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
                                com.baidu.tieba.im.settingcache.b.aKs().c(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                                com.baidu.tieba.im.settingcache.b.aKs().b(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                                final ImMessageCenterPojo imMessageCenterPojo4 = new ImMessageCenterPojo();
                                imMessageCenterPojo4.setGroup_name(optString3);
                                imMessageCenterPojo4.setCustomGroupType(1);
                                imMessageCenterPojo4.setGid(optString);
                                imMessageCenterPojo4.setGroup_head(optString2);
                                imMessageCenterPojo4.setLast_content_time(p.getTime());
                                imMessageCenterPojo4.setIs_hidden(0);
                                imMessageCenterPojo4.setUnread_count(0);
                                imMessageCenterPojo4.setLast_content(" ");
                                imMessageCenterPojo4.setLast_rid(com.baidu.tieba.im.util.d.cg(optLong));
                                imMessageCenterPojo4.setPulled_msgId(com.baidu.tieba.im.util.d.cg(optLong));
                                b.aJa().i(imMessageCenterPojo4);
                                b.aJa().a(1, com.baidu.tieba.im.util.d.cg(optLong), optString);
                                CustomMessageTask customMessageTask3 = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15.3
                                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                        try {
                                            g.aGG().aGH();
                                            com.baidu.tieba.im.db.c.aGC().mY(imMessageCenterPojo4.getGid());
                                            i.aGK().c(imMessageCenterPojo4);
                                        } catch (Exception e) {
                                            BdLog.detailException(e);
                                        } finally {
                                            g.aGG().endTransaction();
                                        }
                                        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_IM_GROUP_CONFIRM_PASSED);
                                    }
                                });
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
                        if (!TextUtils.isEmpty(gid)) {
                            ImMemoryCacheRegister.this.ny(gid);
                        }
                    } else if (com.baidu.tieba.im.chat.receiveChatMsgHandler.g.mK(cmd) && (a = com.baidu.tieba.im.chat.receiveChatMsgHandler.g.a(p, cmd)) != null) {
                        b.aJa().c(a, 1);
                    }
                }
            }
        }
    };
    CustomMessageListener eFn = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                final long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                int action = responseNewFriendUpdateUiMsg.getAction();
                if (action == 0) {
                    final ImMessageCenterPojo am = b.aJa().am(String.valueOf(friendId), 2);
                    if (am != null) {
                        am.setIsFriend(1);
                        am.setFollowStatus(1);
                        b.aJa().i(am);
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.16.1
                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                i.aGK().c(am);
                                return null;
                            }
                        });
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                    }
                } else if (action == 1) {
                    b.aJa().an(String.valueOf(friendId), 2);
                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.16.2
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            try {
                                g.aGG().aGH();
                                i.aGK().ah(String.valueOf(friendId), 2);
                                l.aGR().mW(String.valueOf(friendId));
                                return null;
                            } catch (Exception e) {
                                BdLog.detailException(e);
                                return null;
                            } finally {
                                g.aGG().endTransaction();
                            }
                        }
                    });
                    customMessageTask2.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask2.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask2.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask2);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c eFo = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205006 && (socketResponsedMessage instanceof ResponsedPersonalMsgReadMessage)) {
                ResponsedPersonalMsgReadMessage responsedPersonalMsgReadMessage = (ResponsedPersonalMsgReadMessage) socketResponsedMessage;
                if (!responsedPersonalMsgReadMessage.hasError() && responsedPersonalMsgReadMessage.getGroupId() == com.baidu.tieba.im.sendmessage.a.eIo && responsedPersonalMsgReadMessage.getToUserType() == 0) {
                    final ImMessageCenterPojo am = b.aJa().am(String.valueOf(responsedPersonalMsgReadMessage.getToUid()), 2);
                    if (am != null) {
                        long cg = com.baidu.tieba.im.util.d.cg(responsedPersonalMsgReadMessage.getHasSentMsgId());
                        if (cg > am.getSent_msgId()) {
                            am.setSent_msgId(cg);
                            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.17.1
                                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                    try {
                                        i.aGK().c(am);
                                        return null;
                                    } catch (Exception e) {
                                        BdLog.detailException(e);
                                        return null;
                                    }
                                }
                            });
                            customMessageTask.setParallel(TiebaIMConfig.getParallel());
                            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                            customMessageTask.setPriority(4);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener eFp = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo imMessageCenterPojo;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016013 && (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) != null) {
                b.aJa().k(imMessageCenterPojo);
                b.aJa().j(imMessageCenterPojo);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.18.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        try {
                            g.aGG().aGH();
                            i.aGK().c(imMessageCenterPojo);
                            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                                com.baidu.tieba.im.db.c.aGC().mY(imMessageCenterPojo.getGid());
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            g.aGG().endTransaction();
                        }
                        return new ResponseMemoryNotifyUpdataGroupMessage(imMessageCenterPojo);
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    };
    private CustomMessageListener eFq = new CustomMessageListener(CmdConfigCustom.MEMORY_UPDATE_GROUP_HEAD_NAME) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo am;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MemoryUpdateHeadNameMessage.a)) {
                MemoryUpdateHeadNameMessage.a aVar = (MemoryUpdateHeadNameMessage.a) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(aVar.id)) {
                    if ((!TextUtils.isEmpty(aVar.head) || !TextUtils.isEmpty(aVar.name)) && (am = b.aJa().am(aVar.id, aVar.customGroupType)) != null) {
                        String str = aVar.name;
                        String str2 = aVar.head;
                        if (!TextUtils.isEmpty(str)) {
                            b.aJa().be(aVar.id, str);
                        }
                        if (!TextUtils.isEmpty(aVar.head)) {
                            b.aJa().bd(aVar.id, str2);
                        }
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.19.1
                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                if (customMessage != null) {
                                    i.aGK().a(am, 2);
                                }
                                return null;
                            }
                        });
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                    }
                }
            }
        }
    };
    private CustomMessageListener eFr = new CustomMessageListener(CmdConfigCustom.MEMORY_UPDATE_PULL_MSG_ID) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo am;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof PersonalChatMessage) {
                    b.aJa().a(-1, ((PersonalChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.eIo));
                    am = b.aJa().am(String.valueOf(com.baidu.tieba.im.sendmessage.a.eIo), -1);
                } else if (customResponsedMessage.getData() instanceof OfficialChatMessage) {
                    b.aJa().a(-9, ((OfficialChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.eIp));
                    am = b.aJa().am(String.valueOf(com.baidu.tieba.im.sendmessage.a.eIp), -9);
                } else {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    b.aJa().a(1, chatMessage.getMsgId(), chatMessage.getGroupId());
                    am = b.aJa().am(chatMessage.getGroupId(), 1);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.20.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        i.aGK().a(am, 1);
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    };
    private CustomMessageListener eFs = new CustomMessageListener(CmdConfigCustom.CMD_CLEAR_TASK_ID) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final List<ImMessageCenterPojo> aJh = b.aJa().aJh();
            if (aJh != null && aJh.size() != 0) {
                for (ImMessageCenterPojo imMessageCenterPojo : aJh) {
                    imMessageCenterPojo.setTaskId("");
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.21.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        for (ImMessageCenterPojo imMessageCenterPojo2 : aJh) {
                            i.aGK().c(imMessageCenterPojo2);
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    };
    private a.b eFt = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.22
        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aJa().g(imMessageCenterPojo);
            b.aJa().a(1, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(1));
            }
        }

        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void g(String str, List<CommonMsgPojo> list) {
            if (list != null && list.size() != 0) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo.getMsg_type() == 11) {
                        try {
                            String optString = new JSONObject(commonMsgPojo.getContent()).optString("eventId");
                            if ("105".equals(optString) || "106".equals(optString)) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new GroupMemberChangeResponsedMessage(str));
                            }
                        } catch (JSONException e) {
                            BdLog.detailException(e);
                        }
                    }
                }
            }
        }
    };
    private a.b eFu = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.24
        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aJa().a(-2, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
        }

        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void g(String str, List<CommonMsgPojo> list) {
        }
    };
    private a.b eFv = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.25
        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aJa().g(imMessageCenterPojo);
            b.aJa().a(9, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
        }

        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void g(String str, List<CommonMsgPojo> list) {
        }
    };
    private a.b eFw = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.26
        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aJa().a(5, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(2));
            }
        }

        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void g(String str, List<CommonMsgPojo> list) {
            if (list != null && list.size() != 0) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 10) {
                        com.baidu.tieba.im.chat.receiveChatMsgHandler.a.mG(commonMsgPojo.getContent());
                    }
                }
            }
        }
    };
    private a.b eFx = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.27
        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aJa().a(3, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
        }

        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void g(String str, List<CommonMsgPojo> list) {
            if (list != null && list.size() != 0) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo.getMsg_type() == 11) {
                        String content = commonMsgPojo.getContent();
                        try {
                            String optString = new JSONObject(content).optString("eventId");
                            if (Info.kBaiduPIDValue.equals(optString) || "202".equals(optString) || "203".equals(optString) || "205".equals(optString)) {
                                MessageManager.getInstance().dispatchResponsedMessageToUI(new ChatRoomEventResponseMessage(content));
                            }
                        } catch (JSONException e) {
                            BdLog.detailException(e);
                        }
                    }
                }
            }
        }
    };
    private a.b eFy = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.28
        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aJa().g(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
            }
        }

        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void g(String str, List<CommonMsgPojo> list) {
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                    RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                    com.baidu.tieba.im.data.d a = e.a(commonMsgPojo);
                    if (a != null) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "message_receive", "receive", 1, "task_type", a.exg, "task_id", a.taskId);
                    }
                }
            }
        }
    };
    private a.b eFz = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.29
        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aJa().g(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
            }
        }

        @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
        public void g(String str, List<CommonMsgPojo> list) {
        }
    };

    private ImMemoryCacheRegister() {
        register();
    }

    public static ImMemoryCacheRegister aJm() {
        com.baidu.adp.lib.util.l.oY();
        if (eES == null) {
            synchronized (ImMemoryCacheRegister.class) {
                if (eES == null) {
                    eES = new ImMemoryCacheRegister();
                }
            }
        }
        return eES;
    }

    private void register() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.eFd);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_LIVE_CMD, this.eFd);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_NOTIFY_CMD, this.eFd);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.eFd);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.eFd);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_SNAP_CMD, this.eFd);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_SYSTEM_CMD, this.eFd);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_YY_CMD, this.eFd);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_GROUP_CMD, this.eFd);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_GROUP_CMD, this.eFd);
        MessageManager.getInstance().registerListener(1001, this.eFe);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_FOR_IM, this.bQx);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MEMORY_INIT_COMPLETED);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.eFf);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_LAST_MESSAGE, this.eFg);
        MessageManager.getInstance().registerListener(CmdConfigCustom.IM_CLEAR_MSG, this.eFh);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_VISIBILITY, this.eFi);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_UNREAD_COUNT, this.eFj);
        MessageManager.getInstance().registerListener(this.eFk);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REMOVE_ITEM, this.eFc);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.eFl);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_GROUP_UPDATE, this.eEV);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_VALIDATE, this.eEW);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_LIVE_BROADCAST, this.eEX);
        MessageManager.getInstance().registerListener(202001, this.eET);
        MessageManager.getInstance().registerListener(205001, this.eEU);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_GROUP, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_EVENT_INFO, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP_WARN, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIVE_NOTIFY_LOCAL, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIVE_MSG_NOTIFY, this.eFm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_JOIN_LIVE, this.eEY);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_QUIT_LIVE_GROUP, this.eFa);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_ENTER_CHAT_ROOM, this.eEZ);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MODIFY_LOTS_VISIBILITY, this.eFb);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL, this.eFn);
        MessageManager.getInstance().registerListener(205006, this.eFo);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_NOTIFY_UPDATA_GROUP, this.eFp);
        MessageManager.getInstance().registerListener(this.eFq);
        MessageManager.getInstance().registerListener(this.eFr);
        MessageManager.getInstance().registerListener(this.eFs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJn() {
        ArrayList arrayList;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo imMessageCenterPojo2;
        ImMessageCenterPojo imMessageCenterPojo3;
        ImMessageCenterPojo imMessageCenterPojo4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        boolean z;
        StringBuilder sb;
        if (this.eER != null) {
            StringBuilder sb2 = null;
            for (GroupUpdateMessage groupUpdateMessage : this.eER.getGroupInfos()) {
                if (groupUpdateMessage != null) {
                    if (sb2 == null) {
                        sb = new StringBuilder(50);
                    } else {
                        sb2.append("|");
                        sb = sb2;
                    }
                    sb.append(groupUpdateMessage.getGroupId());
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(groupUpdateMessage.getLastMsgId());
                    BdLog.i("gid-serverMaxMid:" + groupUpdateMessage.getGroupId() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + groupUpdateMessage.getLastMsgId());
                    ImMessageCenterPojo imMessageCenterPojo5 = new ImMessageCenterPojo();
                    imMessageCenterPojo5.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo5.setCustomGroupType(com.baidu.tieba.im.a.a.qq(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo5.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo5.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo5.setPulled_msgId(com.baidu.tieba.im.util.d.cg(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo5.getCustomGroupType() == -2 || imMessageCenterPojo5.getCustomGroupType() == -1 || imMessageCenterPojo5.getCustomGroupType() == -9 || imMessageCenterPojo5.getCustomGroupType() == 5 || imMessageCenterPojo5.getCustomGroupType() == 6) {
                        imMessageCenterPojo5.setIs_hidden(1);
                    }
                    b.aJa().k(imMessageCenterPojo5);
                    b.aJa().j(imMessageCenterPojo5);
                    sb2 = sb;
                }
            }
            long j = -1;
            if (this.eER.getOrginalMessage() != null) {
                j = this.eER.getOrginalMessage().getClientLogID();
            }
            int cmd = this.eER.getCmd();
            int error = this.eER.getError();
            String errorString = this.eER.getErrorString();
            Object[] objArr = new Object[2];
            objArr[0] = ClientCookie.COMMENT_ATTR;
            objArr[1] = sb2 == null ? "" : sb2.toString();
            com.baidu.tbadk.core.d.a.a("im", j, cmd, "ack", error, errorString, objArr);
            ArrayList arrayList4 = null;
            ArrayList arrayList5 = null;
            ImMessageCenterPojo imMessageCenterPojo6 = null;
            ImMessageCenterPojo imMessageCenterPojo7 = null;
            ImMessageCenterPojo imMessageCenterPojo8 = null;
            ImMessageCenterPojo imMessageCenterPojo9 = null;
            ArrayList arrayList6 = null;
            for (ImMessageCenterPojo imMessageCenterPojo10 : b.aJa().aJg()) {
                if (imMessageCenterPojo10.getCustomGroupType() == 1) {
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    arrayList5.add(imMessageCenterPojo10);
                    boolean z2 = true;
                    Iterator<GroupUpdateMessage> it = this.eER.getGroupInfos().iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        GroupUpdateMessage next = it.next();
                        if (com.baidu.tieba.im.a.a.qq(next.getGroupType()) == 1 && imMessageCenterPojo10.getGid().equals(String.valueOf(next.getGroupId()))) {
                            z = false;
                        }
                        z2 = z;
                    }
                    if (z) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(imMessageCenterPojo10);
                    }
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList3 = arrayList5;
                    ArrayList arrayList7 = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo8;
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                    arrayList2 = arrayList4;
                    arrayList = arrayList7;
                } else if (imMessageCenterPojo10.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.b.aKd().nz(imMessageCenterPojo10.getGid());
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    arrayList2 = arrayList4;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList3 = arrayList5;
                    arrayList = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo8;
                    imMessageCenterPojo3 = imMessageCenterPojo10;
                } else if (imMessageCenterPojo10.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.sendmessage.a.qx(com.baidu.adp.lib.g.b.h(imMessageCenterPojo10.getGid(), 0));
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList2 = arrayList4;
                    arrayList3 = arrayList5;
                    ArrayList arrayList8 = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo10;
                    arrayList = arrayList8;
                } else if (imMessageCenterPojo10.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.sendmessage.a.qy(com.baidu.adp.lib.g.b.h(imMessageCenterPojo10.getGid(), 0));
                    imMessageCenterPojo2 = imMessageCenterPojo10;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList = arrayList6;
                    arrayList3 = arrayList5;
                    imMessageCenterPojo = imMessageCenterPojo8;
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                    arrayList2 = arrayList4;
                } else if (imMessageCenterPojo10.getCustomGroupType() == 6 || imMessageCenterPojo10.getCustomGroupType() == 7 || imMessageCenterPojo10.getCustomGroupType() == 8) {
                    ArrayList arrayList9 = arrayList6 == null ? new ArrayList() : arrayList6;
                    arrayList9.add(imMessageCenterPojo10);
                    arrayList = arrayList9;
                    imMessageCenterPojo = imMessageCenterPojo8;
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList2 = arrayList4;
                    arrayList3 = arrayList5;
                } else if (imMessageCenterPojo10.getCustomGroupType() == 5) {
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    arrayList3 = arrayList5;
                    imMessageCenterPojo4 = imMessageCenterPojo10;
                    arrayList = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo8;
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                    arrayList2 = arrayList4;
                } else {
                    arrayList = arrayList6;
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    imMessageCenterPojo = imMessageCenterPojo8;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                    arrayList3 = arrayList5;
                    arrayList2 = arrayList4;
                }
                arrayList5 = arrayList3;
                arrayList4 = arrayList2;
                imMessageCenterPojo7 = imMessageCenterPojo4;
                imMessageCenterPojo6 = imMessageCenterPojo3;
                imMessageCenterPojo8 = imMessageCenterPojo;
                imMessageCenterPojo9 = imMessageCenterPojo2;
                arrayList6 = arrayList;
            }
            if (arrayList4 != null) {
                b.aJa().ch(arrayList4);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.5
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && (customMessage instanceof OnlineToDbCustomMessage)) {
                        OnlineToDbCustomMessage onlineToDbCustomMessage = (OnlineToDbCustomMessage) customMessage;
                        try {
                            g.aGG().aGH();
                            if (onlineToDbCustomMessage.needCreateGroupList != null) {
                                com.baidu.tieba.im.db.c.aGC().bZ(onlineToDbCustomMessage.needCreateGroupList);
                                for (ImMessageCenterPojo imMessageCenterPojo11 : onlineToDbCustomMessage.needCreateGroupList) {
                                    i.aGK().c(imMessageCenterPojo11);
                                }
                            }
                            if (onlineToDbCustomMessage.systemGroup != null) {
                                i.aGK().c(onlineToDbCustomMessage.systemGroup);
                            }
                            if (onlineToDbCustomMessage.privateChatGroup != null) {
                                i.aGK().c(onlineToDbCustomMessage.privateChatGroup);
                            }
                            if (onlineToDbCustomMessage.officialChatGroup != null) {
                                i.aGK().c(onlineToDbCustomMessage.officialChatGroup);
                            }
                            if (onlineToDbCustomMessage.notifyGroup != null) {
                                i.aGK().c(onlineToDbCustomMessage.notifyGroup);
                            }
                            if (onlineToDbCustomMessage.yyGroupList != null) {
                                for (ImMessageCenterPojo imMessageCenterPojo12 : onlineToDbCustomMessage.yyGroupList) {
                                    if (imMessageCenterPojo12.getCustomGroupType() == 6) {
                                        i.aGK().c(imMessageCenterPojo12);
                                    } else {
                                        h.aEY().r(imMessageCenterPojo12.getGid(), com.baidu.tieba.im.util.d.ch(imMessageCenterPojo12.getPulled_msgId()));
                                    }
                                }
                            }
                            if (onlineToDbCustomMessage.needDeleteGroupList != null) {
                                for (ImMessageCenterPojo imMessageCenterPojo13 : onlineToDbCustomMessage.needDeleteGroupList) {
                                    if (imMessageCenterPojo13 != null) {
                                        i.aGK().ah(imMessageCenterPojo13.getGid(), imMessageCenterPojo13.getCustomGroupType());
                                    }
                                }
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            g.aGG().endTransaction();
                        }
                    }
                    return null;
                }
            });
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            OnlineToDbCustomMessage onlineToDbCustomMessage = new OnlineToDbCustomMessage(2001000);
            onlineToDbCustomMessage.needCreateGroupList = arrayList5;
            onlineToDbCustomMessage.systemGroup = imMessageCenterPojo6;
            onlineToDbCustomMessage.notifyGroup = imMessageCenterPojo7;
            onlineToDbCustomMessage.privateChatGroup = imMessageCenterPojo8;
            onlineToDbCustomMessage.officialChatGroup = imMessageCenterPojo9;
            onlineToDbCustomMessage.yyGroupList = arrayList6;
            if (this.eER.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList4;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.eER = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class OnlineToDbCustomMessage extends CustomMessage<String> {
        public List<ImMessageCenterPojo> needCreateGroupList;
        public List<ImMessageCenterPojo> needDeleteGroupList;
        public ImMessageCenterPojo notifyGroup;
        public ImMessageCenterPojo officialChatGroup;
        public ImMessageCenterPojo privateChatGroup;
        public ImMessageCenterPojo systemGroup;
        public List<ImMessageCenterPojo> yyGroupList;

        public OnlineToDbCustomMessage(int i) {
            super(i);
            this.needCreateGroupList = null;
            this.systemGroup = null;
            this.notifyGroup = null;
            this.privateChatGroup = null;
            this.officialChatGroup = null;
            this.yyGroupList = null;
            this.needDeleteGroupList = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(final String str) {
        HashMap<String, String> HG;
        if (!TextUtils.isEmpty(str)) {
            b.aJa().an(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC() != null && (HG = com.baidu.tbadk.coreExtra.messageCenter.a.Gh().GC().HG()) != null && HG.size() == 1 && HG.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Gh().fd(str);
            }
            com.baidu.tieba.im.settingcache.b.aKs().b(TbadkCoreApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.30
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && (customMessage instanceof CustomMessage)) {
                        try {
                            g.aGG().aGH();
                            i.aGK().ah(str, 1);
                            com.baidu.tieba.im.db.c.aGC().mW(str);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            g.aGG().endTransaction();
                        }
                    }
                    return null;
                }
            });
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            b.aJa().i(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.31
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null) {
                        i.aGK().a(imMessageCenterPojo, 2);
                    }
                    return null;
                }
            });
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
