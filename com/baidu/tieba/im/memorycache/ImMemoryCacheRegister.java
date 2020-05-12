package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.b.a;
import com.baidu.tieba.im.chat.b.d;
import com.baidu.tieba.im.chat.b.f;
import com.baidu.tieba.im.chat.b.g;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.h;
import com.baidu.tieba.im.db.j;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImMemoryCacheRegister {
    private static volatile ImMemoryCacheRegister irp;
    private ResponseOnlineMessage iro;
    private com.baidu.adp.framework.listener.c irq = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.1
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
                b.chB().a(chatMessage.getCustomGroupType(), chatMessage, chatMessage.getGroupId(), 3);
                final ImMessageCenterPojo bf = b.chB().bf(chatMessage.getGroupId(), chatMessage.getCustomGroupType());
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.1.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                            return null;
                        }
                        try {
                            h.cfl().cfm();
                            j.cfp().a(bf, 3);
                            com.baidu.tieba.im.db.c.cfe().g(chatMessage.getGroupId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.cfl().cfn();
                        }
                        return new CustomResponsedMessage<>(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, socketResponsedMessage);
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }
        }
    };
    private com.baidu.adp.framework.listener.c irr = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final SocketResponsedMessage socketResponsedMessage) {
            final ImMessageCenterPojo bf;
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
                        com.baidu.tieba.im.sendmessage.a.eK(com.baidu.adp.lib.f.b.toLong(responseCommitPersonalMessage.getGroupId(), 0L));
                    } else {
                        com.baidu.tieba.im.sendmessage.a.eL(com.baidu.adp.lib.f.b.toLong(responseCommitPersonalMessage.getGroupId(), 0L));
                    }
                }
                com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "ack", socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), "comment", "uType " + toUserType, "touid", Long.valueOf(chatMessage.getToUserId()), "content", chatMessage.getContent());
                if (chatMessage instanceof PersonalChatMessage) {
                    b.chB().a(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    b.chB().a(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else {
                    return;
                }
                if (chatMessage instanceof PersonalChatMessage) {
                    bf = b.chB().bf(String.valueOf(e.n(chatMessage)), 2);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    bf = b.chB().bf(String.valueOf(e.n(chatMessage)), 4);
                } else {
                    return;
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.12.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null) {
                            try {
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            } finally {
                                h.cfl().cfn();
                            }
                            if (customMessage instanceof CustomMessage) {
                                h.cfl().cfm();
                                j.cfp().a(bf, 3);
                                if (bf.getCustomGroupType() == 2) {
                                    m.cfx().a(chatMessage.getUserId(), chatMessage.getToUserId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                                } else {
                                    l.cfv().a(chatMessage.getUserId(), chatMessage.getToUserId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
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
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }
        }
    };
    private CustomMessageListener irs = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo bf;
            if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (bf = b.chB().bf(TbEnum.CustomGroupId.GROUP_UPDATE, -3)) != null) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    bf.setUnread_count(0);
                    bf.setIs_hidden(1);
                    ImMemoryCacheRegister.this.p(bf);
                } else if (data instanceof ImMessageCenterPojo) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                    bf.setLast_content(imMessageCenterPojo.getLast_content());
                    bf.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    bf.setUnread_count(0);
                    bf.setIs_hidden(0);
                    ImMemoryCacheRegister.this.p(bf);
                }
            }
        }
    };
    private CustomMessageListener irt = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo bf;
            if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (bf = b.chB().bf(TbEnum.CustomGroupId.GROUP_VALIDATION, -4)) != null) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    bf.setUnread_count(0);
                    bf.setIs_hidden(1);
                    ImMemoryCacheRegister.this.p(bf);
                } else if (data instanceof ImMessageCenterPojo) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                    bf.setLast_content(imMessageCenterPojo.getLast_content());
                    bf.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    bf.setUnread_count(0);
                    bf.setIs_hidden(0);
                    ImMemoryCacheRegister.this.p(bf);
                }
            }
        }
    };
    private CustomMessageListener iru = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage;
            MemoryClearStrangerItemsMessage.a data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryClearStrangerItemsMessage) && (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) != null && data.avh != null) {
                for (MemoryModifyVisibilityMessage.a aVar : data.avh) {
                    b.chB().aZ(aVar.id, aVar.customGroupType);
                }
                if (memoryClearStrangerItemsMessage.isAllClear()) {
                    b.chB().e(TbEnum.CustomGroupId.STRANGE_MERGE, -7, false);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.27.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null) {
                            try {
                                if (customMessage instanceof CustomMessage) {
                                    h.cfl().cfm();
                                    j.cfp().cft();
                                    if (memoryClearStrangerItemsMessage.isAllClear()) {
                                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                        imMessageCenterPojo.setGid(TbEnum.CustomGroupId.STRANGE_MERGE);
                                        imMessageCenterPojo.setCustomGroupType(-7);
                                        imMessageCenterPojo.setIs_hidden(1);
                                        j.cfp().f(imMessageCenterPojo);
                                    }
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            } finally {
                                h.cfl().cfn();
                            }
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }
        }
    };
    private CustomMessageListener irv = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MemoryItemRemoveMessage.a)) {
                MemoryItemRemoveMessage.a aVar = (MemoryItemRemoveMessage.a) customResponsedMessage.getData();
                if (aVar.customGroupType == 1) {
                    ImMemoryCacheRegister.this.Fd(aVar.id);
                }
            }
        }
    };
    private CustomMessageListener irw = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.29
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
                        ImMessageCenterPojo bf = b.chB().bf(valueOf, customType);
                        if (groupMsgData.getCmd() == 2012125) {
                            com.baidu.tieba.im.chat.b.b.a(groupMsgData, bf, ImMemoryCacheRegister.this.irM);
                        } else if (groupMsgData.getCmd() == 2012124) {
                            com.baidu.tieba.im.chat.b.c.a(groupMsgData, bf, ImMemoryCacheRegister.this.irO);
                        } else if (groupMsgData.getCmd() == 2012123) {
                            d.b(groupMsgData, bf, ImMemoryCacheRegister.this.irP);
                        } else if (groupMsgData.getCmd() == 2012121) {
                            com.baidu.tieba.im.chat.b.e.b(groupMsgData, bf, ImMemoryCacheRegister.this.irQ);
                        } else if (groupMsgData.getCmd() == 2012120) {
                            f.a(groupMsgData, bf, ImMemoryCacheRegister.this.irN);
                        } else if (groupMsgData.getCmd() == 2012128) {
                            if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                b.chB().d(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.iuF));
                            }
                        } else if (groupMsgData.getCmd() == 2012129) {
                            if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                ChatMessage chatMessage = groupMsgData.getListMessage().get(0);
                                if (!chatMessage.isPushForOperateAccount()) {
                                    b.chB().d(-9, chatMessage.getMsgId(), String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
                                }
                            }
                        } else if (groupMsgData.getCmd() == 2012126) {
                            if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                                g.a(groupMsgData, bf, new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.29.1
                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
                                        if (imMessageCenterPojo != null) {
                                            b.chB().d(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
                                        }
                                    }

                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void k(String str, List<CommonMsgPojo> list) {
                                    }
                                });
                            } else {
                                long[] b = g.cdB().b(groupMsgData);
                                if (b != null && b.length == 2) {
                                    if (b[0] <= 0 && b[1] > 0) {
                                        if (b[0] == 12) {
                                            b.chB().d(8, b[1], String.valueOf(12));
                                        } else if (b[0] == 11) {
                                            b.chB().d(7, b[1], String.valueOf(11));
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            g.cdB().c(groupMsgData);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c irx = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ImMemoryCacheRegister.this.iro = (ResponseOnlineMessage) socketResponsedMessage;
                if (b.chB().ira.get()) {
                    ImMemoryCacheRegister.this.chP();
                }
            }
        }
    };
    private CustomMessageListener iry = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002 && (customResponsedMessage instanceof MemoryInitCompleteMessage)) {
                ImMemoryCacheRegister.this.chP();
            }
        }
    };
    private CustomMessageListener mAccountChangeListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005018) {
                ImMemoryCacheRegister.this.iro = null;
                com.baidu.tieba.im.sendmessage.a.eK(0L);
                com.baidu.tieba.im.sendmessage.a.eL(0L);
                b.chB().init();
                com.baidu.tbadk.coreExtra.messageCenter.c.aTH().init();
            }
        }
    };
    private CustomMessageListener irz = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyLastMsgMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016003 && (data = ((MemoryModifyLastMsgMessage) customResponsedMessage).getData()) != null) {
                b.chB().a(data.customGroupType, data.iss, data.id, data.type);
                final ImMessageCenterPojo bf = b.chB().bf(data.id, data.customGroupType);
                if (bf != null) {
                    final ImMessageCenterPojo imMessageCenterPojo = null;
                    if (bf.getCustomGroupType() == 4) {
                        imMessageCenterPojo = b.chB().bf(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8);
                    }
                    CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.4.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.cfp().a(bf, 2);
                            if (imMessageCenterPojo != null) {
                                j.cfp().a(imMessageCenterPojo, 2);
                                return null;
                            }
                            return null;
                        }
                    });
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
                }
            }
        }
    };
    private CustomMessageListener irA = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008016) {
                b.chB().reset();
            }
        }
    };
    private CustomMessageListener irB = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyVisibilityMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016005 && (customResponsedMessage instanceof MemoryModifyVisibilityMessage) && (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) != null) {
                final ImMessageCenterPojo bf = b.chB().bf(data.id, data.customGroupType);
                int i = data.visible ? 0 : 1;
                if (bf != null && i != bf.getIs_hidden()) {
                    if (data.customGroupType == 2) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().vG(data.id);
                    } else if (data.customGroupType == 4) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().lZ(com.baidu.adp.lib.f.b.toInt(data.id, 0));
                    } else if (data.customGroupType == -3) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().ma(2);
                    } else if (data.customGroupType == -4) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().ma(1);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().vF(data.id);
                    }
                    b.chB().e(data.id, data.customGroupType, data.visible);
                    bf.setIs_hidden(i);
                    CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.6.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
                            if (customMessage != null && customMessage.getData() != null) {
                                j.cfp().f(bf);
                            }
                            return null;
                        }
                    });
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, data), customMessageTask);
                }
            }
        }
    };
    private CustomMessageListener irC = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearUnreadCountMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016006 && (customResponsedMessage instanceof MemoryClearUnreadCountMessage) && (data = ((MemoryClearUnreadCountMessage) customResponsedMessage).getData()) != null) {
                ImMessageCenterPojo bf = b.chB().bf(data.id, data.customGroupType);
                if (bf == null) {
                    BdLog.e("ClearUnreadCountMessage:  not find memery pojo");
                } else if (bf.getUnread_count() != 0) {
                    b.chB().bh(data.id, data.customGroupType);
                    CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.7.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<MemoryClearUnreadCountMessage.a> customMessage) {
                            if (customMessage == null) {
                            }
                            MemoryClearUnreadCountMessage.a data2 = customMessage.getData();
                            j.cfp().bc(data2.id, data2.customGroupType);
                            return null;
                        }
                    });
                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) MessageConfig.BASE_CUSTOM_CMD, data), customMessageTask);
                }
            }
        }
    };
    private CustomMessageListener irD = new CustomMessageListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_CREATE_GROUP) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ImMessageCenterPojo)) {
                final ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData();
                b.chB().k(imMessageCenterPojo);
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.8.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        try {
                            try {
                                h.cfl().cfm();
                                j.cfp().f(imMessageCenterPojo);
                                com.baidu.tieba.im.db.c.cfe().EA(imMessageCenterPojo.getGid());
                                h.cfl().cfn();
                                return null;
                            } catch (Exception e) {
                                BdLog.detailException(e);
                                h.cfl().cfn();
                                return null;
                            }
                        } catch (Throwable th) {
                            h.cfl().cfn();
                            throw th;
                        }
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }
        }
    };
    private CustomMessageTask.CustomRunnable<Integer> irE = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.9
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
            List<ImMessageCenterPojo> chJ;
            if (customMessage == null || !(customMessage instanceof RequestMemoryListMessage)) {
                return null;
            }
            int intValue = ((RequestMemoryListMessage) customMessage).getData().intValue();
            if (intValue == 3) {
                chJ = b.chB().chI();
            } else if (intValue == 2) {
                chJ = b.chB().chH();
            } else if (intValue == 1) {
                chJ = b.chB().chF();
            } else {
                chJ = intValue == 4 ? b.chB().chJ() : null;
            }
            return new ResponsedMemoryListMessage(chJ, intValue);
        }
    };
    private CustomMessageListener irF = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            UpdatesItemData convertToUpdatesItem;
            final ImMessageCenterPojo bf;
            UpdatesItemData convertToUpdatesItem2;
            final ImMessageCenterPojo bf2;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                String cmd = p.getCmd();
                if (!TextUtils.isEmpty(cmd)) {
                    if (f.Em(cmd)) {
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        imMessageCenterPojo.setGid(TbEnum.CustomGroupId.GROUP_UPDATE);
                        imMessageCenterPojo.setCustomGroupType(-3);
                        imMessageCenterPojo.setLast_content(f.dM(cmd, p.getContent()));
                        imMessageCenterPojo.setLast_content_time(p.getTime());
                        imMessageCenterPojo.setLast_rid(com.baidu.adp.lib.f.b.toLong(p.getNotice_id(), 0L));
                        b.chB().c(imMessageCenterPojo, ChatStatusManager.getInst().getIsOpen(6) ? 0 : 1);
                    } else if (f.En(cmd)) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid(TbEnum.CustomGroupId.GROUP_VALIDATION);
                        imMessageCenterPojo2.setCustomGroupType(-4);
                        imMessageCenterPojo2.setLast_content(f.dM(cmd, p.getContent()));
                        imMessageCenterPojo2.setLast_content_time(p.getTime());
                        imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.f.b.toLong(p.getNotice_id(), 0L));
                        b.chB().c(imMessageCenterPojo2, ChatStatusManager.getInst().getIsOpen(7) ? 0 : 1);
                    }
                    if (cmd.equals("group_head_change")) {
                        if (ModelHelper.getInstance().getUpdatasModel() != null && (convertToUpdatesItem2 = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) != null) {
                            String groupId = convertToUpdatesItem2.getGroupId();
                            if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(convertToUpdatesItem2.getGroupHeadUrl()) && (bf2 = b.chB().bf(groupId, 1)) != null) {
                                if (bf2.getGroup_head() == null || !bf2.getGroup_head().equals(convertToUpdatesItem2.getGroupHeadUrl())) {
                                    b.chB().dP(groupId, convertToUpdatesItem2.getGroupHeadUrl());
                                    bf2.setGroup_head(convertToUpdatesItem2.getGroupHeadUrl());
                                    CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.1
                                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                            j.cfp().f(bf2);
                                            return null;
                                        }
                                    });
                                    customMessageTask.setParallel(TiebaIMConfig.getParallel());
                                    customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                                    customMessageTask.setPriority(4);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
                                }
                            }
                        }
                    } else if (cmd.equals("group_name_change")) {
                        if (ModelHelper.getInstance().getUpdatasModel() != null && (convertToUpdatesItem = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) != null) {
                            String groupId2 = convertToUpdatesItem.getGroupId();
                            if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(convertToUpdatesItem.getGroupName()) && (bf = b.chB().bf(groupId2, 1)) != null) {
                                if (bf.getGroup_name() == null || !bf.getGroup_name().equals(convertToUpdatesItem.getGroupName())) {
                                    b.chB().dQ(groupId2, convertToUpdatesItem.getGroupName());
                                    bf.setGroup_name(convertToUpdatesItem.getGroupName());
                                    CustomMessageTask customMessageTask2 = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.2
                                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                            j.cfp().f(bf);
                                            return null;
                                        }
                                    });
                                    customMessageTask2.setParallel(TiebaIMConfig.getParallel());
                                    customMessageTask2.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                                    customMessageTask2.setPriority(4);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask2);
                                }
                            }
                        }
                    } else if (cmd.equals("apply_join_success")) {
                        String content = p.getContent();
                        if (!TextUtils.isEmpty(content)) {
                            try {
                                JSONObject jSONObject = new JSONObject(content);
                                jSONObject.put("notice_id", p.getNotice_id());
                                JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                                String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                                String optString2 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_IMAGE);
                                String optString3 = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                                long optLong = optJSONObject.optLong(TbEnum.SystemMessage.KEY_LAST_MSG_ID);
                                com.baidu.tieba.im.settingcache.b.ciS().c(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                                com.baidu.tieba.im.settingcache.b.ciS().b(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                                final ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                imMessageCenterPojo3.setGroup_name(optString3);
                                imMessageCenterPojo3.setCustomGroupType(1);
                                imMessageCenterPojo3.setGid(optString);
                                imMessageCenterPojo3.setGroup_head(optString2);
                                imMessageCenterPojo3.setLast_content_time(p.getTime());
                                imMessageCenterPojo3.setIs_hidden(0);
                                imMessageCenterPojo3.setUnread_count(0);
                                imMessageCenterPojo3.setLast_content(" ");
                                imMessageCenterPojo3.setLast_rid(com.baidu.tieba.im.util.d.eM(optLong));
                                imMessageCenterPojo3.setPulled_msgId(com.baidu.tieba.im.util.d.eM(optLong));
                                b.chB().l(imMessageCenterPojo3);
                                b.chB().d(1, com.baidu.tieba.im.util.d.eM(optLong), optString);
                                CustomMessageTask customMessageTask3 = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.3
                                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                        try {
                                            h.cfl().cfm();
                                            com.baidu.tieba.im.db.c.cfe().EA(imMessageCenterPojo3.getGid());
                                            j.cfp().f(imMessageCenterPojo3);
                                        } catch (Exception e) {
                                            BdLog.detailException(e);
                                        } finally {
                                            h.cfl().cfn();
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
                            ImMemoryCacheRegister.this.Fd(gid);
                        }
                    }
                }
            }
        }
    };
    CustomMessageListener irG = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                final long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                int action = responseNewFriendUpdateUiMsg.getAction();
                if (action == 0) {
                    final ImMessageCenterPojo bf = b.chB().bf(String.valueOf(friendId), 2);
                    if (bf != null) {
                        bf.setIsFriend(1);
                        bf.setFollowStatus(1);
                        b.chB().l(bf);
                        CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11.1
                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                j.cfp().f(bf);
                                return null;
                            }
                        });
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
                    }
                } else if (action == 1) {
                    b.chB().bg(String.valueOf(friendId), 2);
                    CustomMessageTask customMessageTask2 = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11.2
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            try {
                                h.cfl().cfm();
                                j.cfp().ba(String.valueOf(friendId), 2);
                                m.cfx().Ex(String.valueOf(friendId));
                                return null;
                            } catch (Exception e) {
                                BdLog.detailException(e);
                                return null;
                            } finally {
                                h.cfl().cfn();
                            }
                        }
                    });
                    customMessageTask2.setParallel(TiebaIMConfig.getParallel());
                    customMessageTask2.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                    customMessageTask2.setPriority(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask2);
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c irH = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205006 && (socketResponsedMessage instanceof ResponsedPersonalMsgReadMessage)) {
                ResponsedPersonalMsgReadMessage responsedPersonalMsgReadMessage = (ResponsedPersonalMsgReadMessage) socketResponsedMessage;
                if (!responsedPersonalMsgReadMessage.hasError() && responsedPersonalMsgReadMessage.getGroupId() == com.baidu.tieba.im.sendmessage.a.iuF.longValue() && responsedPersonalMsgReadMessage.getToUserType() == 0) {
                    final ImMessageCenterPojo bf = b.chB().bf(String.valueOf(responsedPersonalMsgReadMessage.getToUid()), 2);
                    if (bf != null) {
                        long eM = com.baidu.tieba.im.util.d.eM(responsedPersonalMsgReadMessage.getHasSentMsgId());
                        if (eM > bf.getSent_msgId()) {
                            bf.setSent_msgId(eM);
                            CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.13.1
                                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                    try {
                                        j.cfp().f(bf);
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
                            MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener irI = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo imMessageCenterPojo;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016013 && (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) != null) {
                b.chB().n(imMessageCenterPojo);
                b.chB().m(imMessageCenterPojo);
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.14.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        try {
                            h.cfl().cfm();
                            j.cfp().f(imMessageCenterPojo);
                            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                                com.baidu.tieba.im.db.c.cfe().EA(imMessageCenterPojo.getGid());
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.cfl().cfn();
                        }
                        return new ResponseMemoryNotifyUpdataGroupMessage(imMessageCenterPojo);
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }
        }
    };
    private CustomMessageListener irJ = new CustomMessageListener(CmdConfigCustom.MEMORY_UPDATE_GROUP_HEAD_NAME) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo bf;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MemoryUpdateHeadNameMessage.a)) {
                MemoryUpdateHeadNameMessage.a aVar = (MemoryUpdateHeadNameMessage.a) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(aVar.id)) {
                    if ((!TextUtils.isEmpty(aVar.head) || !TextUtils.isEmpty(aVar.name)) && (bf = b.chB().bf(aVar.id, aVar.customGroupType)) != null) {
                        String str = aVar.name;
                        String str2 = aVar.head;
                        if (!TextUtils.isEmpty(str)) {
                            b.chB().dQ(aVar.id, str);
                        }
                        if (!TextUtils.isEmpty(aVar.head)) {
                            b.chB().dP(aVar.id, str2);
                        }
                        CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15.1
                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                if (customMessage != null) {
                                    j.cfp().a(bf, 2);
                                }
                                return null;
                            }
                        });
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
                    }
                }
            }
        }
    };
    private CustomMessageListener irK = new CustomMessageListener(CmdConfigCustom.MEMORY_UPDATE_PULL_MSG_ID) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo bf;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof PersonalChatMessage) {
                    b.chB().d(-1, ((PersonalChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.iuF));
                    bf = b.chB().bf(String.valueOf(com.baidu.tieba.im.sendmessage.a.iuF), -1);
                } else if (customResponsedMessage.getData() instanceof OfficialChatMessage) {
                    b.chB().d(-9, ((OfficialChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.iuG));
                    bf = b.chB().bf(String.valueOf(com.baidu.tieba.im.sendmessage.a.iuG), -9);
                } else {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    b.chB().d(1, chatMessage.getMsgId(), chatMessage.getGroupId());
                    bf = b.chB().bf(chatMessage.getGroupId(), 1);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.16.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        j.cfp().a(bf, 1);
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }
        }
    };
    private CustomMessageListener irL = new CustomMessageListener(CmdConfigCustom.CMD_CLEAR_TASK_ID) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final List<ImMessageCenterPojo> chH = b.chB().chH();
            if (chH != null && chH.size() != 0) {
                for (ImMessageCenterPojo imMessageCenterPojo : chH) {
                    imMessageCenterPojo.setTaskId("");
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.17.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        for (ImMessageCenterPojo imMessageCenterPojo2 : chH) {
                            j.cfp().f(imMessageCenterPojo2);
                        }
                        return null;
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
            }
        }
    };
    private a.b irM = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.18
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.chB().j(imMessageCenterPojo);
            b.chB().d(1, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(1));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void k(String str, List<CommonMsgPojo> list) {
            if (list != null && list.size() != 0) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo.getMsg_type() == 11) {
                        try {
                            String optString = new JSONObject(commonMsgPojo.getContent()).optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                            if (TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN.equals(optString) || TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT.equals(optString)) {
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
    private a.b irN = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.19
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.chB().d(-2, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void k(String str, List<CommonMsgPojo> list) {
        }
    };
    private a.b irO = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.20
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.chB().d(5, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(2));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void k(String str, List<CommonMsgPojo> list) {
            if (list != null && list.size() != 0) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 10) {
                        com.baidu.tieba.im.chat.b.a.Ek(commonMsgPojo.getContent());
                    }
                }
            }
        }
    };
    private a.b irP = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.21
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.chB().j(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void k(String str, List<CommonMsgPojo> list) {
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                    RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                    com.baidu.tieba.im.data.d a = e.a(commonMsgPojo);
                    if (a != null) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "message_receive", "receive", 1, "task_type", a.ijp, "task_id", a.taskId);
                    }
                }
            }
        }
    };
    private a.b irQ = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.22
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.chB().j(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void k(String str, List<CommonMsgPojo> list) {
        }
    };

    private ImMemoryCacheRegister() {
        register();
    }

    public static ImMemoryCacheRegister chO() {
        com.baidu.adp.lib.util.l.checkMainThread();
        if (irp == null) {
            synchronized (ImMemoryCacheRegister.class) {
                if (irp == null) {
                    irp = new ImMemoryCacheRegister();
                }
            }
        }
        return irp;
    }

    private void register() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.irw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_NOTIFY_CMD, this.irw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.irw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.irw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_SYSTEM_CMD, this.irw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_YY_CMD, this.irw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_GROUP_CMD, this.irw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_GROUP_CMD, this.irw);
        MessageManager.getInstance().registerListener(1001, this.irx);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_FOR_IM, this.mAccountChangeListener);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MEMORY_INIT_COMPLETED);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.iry);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_LAST_MESSAGE, this.irz);
        MessageManager.getInstance().registerListener(CmdConfigCustom.IM_CLEAR_MSG, this.irA);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_VISIBILITY, this.irB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_UNREAD_COUNT, this.irC);
        MessageManager.getInstance().registerListener(this.irD);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REMOVE_ITEM, this.irv);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.irE);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_GROUP_UPDATE, this.irs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_VALIDATE, this.irt);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_GROUP_CHAT_MSG, this.irq);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_COMMIT_PERSONAL_MSG, this.irr);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_GROUP, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_EVENT_INFO, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP_WARN, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP, this.irF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MODIFY_LOTS_VISIBILITY, this.iru);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL, this.irG);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_PERSONAL_SEND_MSG_HAS_READ, this.irH);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_NOTIFY_UPDATA_GROUP, this.irI);
        MessageManager.getInstance().registerListener(this.irJ);
        MessageManager.getInstance().registerListener(this.irK);
        MessageManager.getInstance().registerListener(this.irL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chP() {
        ArrayList arrayList;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo imMessageCenterPojo2;
        ImMessageCenterPojo imMessageCenterPojo3;
        ImMessageCenterPojo imMessageCenterPojo4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        boolean z;
        StringBuilder sb;
        if (this.iro != null) {
            StringBuilder sb2 = null;
            for (GroupUpdateMessage groupUpdateMessage : this.iro.getGroupInfos()) {
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
                    imMessageCenterPojo5.setCustomGroupType(com.baidu.tieba.im.a.a.xq(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo5.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo5.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo5.setNameShow(groupUpdateMessage.getNameShow());
                    imMessageCenterPojo5.setPulled_msgId(com.baidu.tieba.im.util.d.eM(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo5.getCustomGroupType() == -2 || imMessageCenterPojo5.getCustomGroupType() == -1 || imMessageCenterPojo5.getCustomGroupType() == -9 || imMessageCenterPojo5.getCustomGroupType() == 5 || imMessageCenterPojo5.getCustomGroupType() == 6) {
                        imMessageCenterPojo5.setIs_hidden(1);
                    }
                    b.chB().n(imMessageCenterPojo5);
                    b.chB().m(imMessageCenterPojo5);
                    sb2 = sb;
                }
            }
            long j = -1;
            if (this.iro.getOrginalMessage() != null) {
                j = this.iro.getOrginalMessage().getClientLogID();
            }
            int cmd = this.iro.getCmd();
            int error = this.iro.getError();
            String errorString = this.iro.getErrorString();
            Object[] objArr = new Object[2];
            objArr[0] = "comment";
            objArr[1] = sb2 == null ? "" : sb2.toString();
            com.baidu.tbadk.core.d.a.a("im", j, cmd, "ack", error, errorString, objArr);
            ArrayList arrayList4 = null;
            ArrayList arrayList5 = null;
            ImMessageCenterPojo imMessageCenterPojo6 = null;
            ImMessageCenterPojo imMessageCenterPojo7 = null;
            ImMessageCenterPojo imMessageCenterPojo8 = null;
            ImMessageCenterPojo imMessageCenterPojo9 = null;
            ArrayList arrayList6 = null;
            for (ImMessageCenterPojo imMessageCenterPojo10 : b.chB().chG()) {
                if (imMessageCenterPojo10.getCustomGroupType() == 1) {
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    arrayList5.add(imMessageCenterPojo10);
                    boolean z2 = true;
                    Iterator<GroupUpdateMessage> it = this.iro.getGroupInfos().iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        GroupUpdateMessage next = it.next();
                        if (com.baidu.tieba.im.a.a.xq(next.getGroupType()) == 1 && imMessageCenterPojo10.getGid().equals(String.valueOf(next.getGroupId()))) {
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
                    com.baidu.tieba.im.pushNotify.b.ciB().Fe(imMessageCenterPojo10.getGid());
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    arrayList2 = arrayList4;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList3 = arrayList5;
                    arrayList = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo8;
                    imMessageCenterPojo3 = imMessageCenterPojo10;
                } else if (imMessageCenterPojo10.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.sendmessage.a.eK(com.baidu.adp.lib.f.b.toLong(imMessageCenterPojo10.getGid(), 0L));
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList2 = arrayList4;
                    arrayList3 = arrayList5;
                    ArrayList arrayList8 = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo10;
                    arrayList = arrayList8;
                } else if (imMessageCenterPojo10.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.sendmessage.a.eL(com.baidu.adp.lib.f.b.toLong(imMessageCenterPojo10.getGid(), 0L));
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
                b.chB().dm(arrayList4);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.31
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && (customMessage instanceof OnlineToDbCustomMessage)) {
                        OnlineToDbCustomMessage onlineToDbCustomMessage = (OnlineToDbCustomMessage) customMessage;
                        try {
                            h.cfl().cfm();
                            if (onlineToDbCustomMessage.needCreateGroupList != null) {
                                com.baidu.tieba.im.db.c.cfe().db(onlineToDbCustomMessage.needCreateGroupList);
                                for (ImMessageCenterPojo imMessageCenterPojo11 : onlineToDbCustomMessage.needCreateGroupList) {
                                    j.cfp().f(imMessageCenterPojo11);
                                }
                            }
                            if (onlineToDbCustomMessage.systemGroup != null) {
                                j.cfp().f(onlineToDbCustomMessage.systemGroup);
                            }
                            if (onlineToDbCustomMessage.privateChatGroup != null) {
                                j.cfp().f(onlineToDbCustomMessage.privateChatGroup);
                            }
                            if (onlineToDbCustomMessage.officialChatGroup != null) {
                                j.cfp().f(onlineToDbCustomMessage.officialChatGroup);
                            }
                            if (onlineToDbCustomMessage.notifyGroup != null) {
                                j.cfp().f(onlineToDbCustomMessage.notifyGroup);
                            }
                            if (onlineToDbCustomMessage.yyGroupList != null) {
                                for (ImMessageCenterPojo imMessageCenterPojo12 : onlineToDbCustomMessage.yyGroupList) {
                                    if (imMessageCenterPojo12.getCustomGroupType() == 6) {
                                        j.cfp().f(imMessageCenterPojo12);
                                    } else {
                                        g.cdB().H(imMessageCenterPojo12.getGid(), com.baidu.tieba.im.util.d.eN(imMessageCenterPojo12.getPulled_msgId()));
                                    }
                                }
                            }
                            if (onlineToDbCustomMessage.needDeleteGroupList != null) {
                                for (ImMessageCenterPojo imMessageCenterPojo13 : onlineToDbCustomMessage.needDeleteGroupList) {
                                    if (imMessageCenterPojo13 != null) {
                                        j.cfp().ba(imMessageCenterPojo13.getGid(), imMessageCenterPojo13.getCustomGroupType());
                                    }
                                }
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.cfl().cfn();
                        }
                    }
                    return null;
                }
            });
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            OnlineToDbCustomMessage onlineToDbCustomMessage = new OnlineToDbCustomMessage(MessageConfig.BASE_CUSTOM_CMD);
            onlineToDbCustomMessage.needCreateGroupList = arrayList5;
            onlineToDbCustomMessage.systemGroup = imMessageCenterPojo6;
            onlineToDbCustomMessage.notifyGroup = imMessageCenterPojo7;
            onlineToDbCustomMessage.privateChatGroup = imMessageCenterPojo8;
            onlineToDbCustomMessage.officialChatGroup = imMessageCenterPojo9;
            onlineToDbCustomMessage.yyGroupList = arrayList6;
            if (this.iro.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList4;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.iro = null;
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
    public void Fd(final String str) {
        HashMap<String, String> groupGidName;
        if (!TextUtils.isEmpty(str)) {
            b.chB().bg(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTA() != null && (groupGidName = com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTA().getGroupGidName()) != null && groupGidName.size() == 1 && groupGidName.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().vF(str);
            }
            com.baidu.tieba.im.settingcache.b.ciS().b(TbadkCoreApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.24
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && (customMessage instanceof CustomMessage)) {
                        try {
                            h.cfl().cfm();
                            j.cfp().ba(str, 1);
                            com.baidu.tieba.im.db.c.cfe().Ex(str);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.cfl().cfn();
                        }
                    }
                    return null;
                }
            });
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            b.chB().l(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(MessageConfig.BASE_CUSTOM_CMD, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.25
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null) {
                        j.cfp().a(imMessageCenterPojo, 2);
                    }
                    return null;
                }
            });
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(MessageConfig.BASE_CUSTOM_CMD), customMessageTask);
        }
    }
}
