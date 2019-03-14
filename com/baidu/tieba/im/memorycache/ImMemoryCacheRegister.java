package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
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
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImMemoryCacheRegister {
    private static volatile ImMemoryCacheRegister goR;
    private ResponseOnlineMessage goQ;
    private com.baidu.adp.framework.listener.c goS = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.1
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
                b.buF().a(chatMessage.getCustomGroupType(), chatMessage, chatMessage.getGroupId(), 3);
                final ImMessageCenterPojo aT = b.buF().aT(chatMessage.getGroupId(), chatMessage.getCustomGroupType());
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.1.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                            return null;
                        }
                        try {
                            h.bso().bsp();
                            j.bsr().a(aT, 3);
                            com.baidu.tieba.im.db.c.bsh().e(chatMessage.getGroupId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.bso().endTransaction();
                        }
                        return new CustomResponsedMessage<>(2016012, socketResponsedMessage);
                    }
                });
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }
    };
    private com.baidu.adp.framework.listener.c goT = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final SocketResponsedMessage socketResponsedMessage) {
            final ImMessageCenterPojo aT;
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
                        com.baidu.tieba.im.sendmessage.a.dj(com.baidu.adp.lib.g.b.d(responseCommitPersonalMessage.getGroupId(), 0L));
                    } else {
                        com.baidu.tieba.im.sendmessage.a.dk(com.baidu.adp.lib.g.b.d(responseCommitPersonalMessage.getGroupId(), 0L));
                    }
                }
                com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "ack", socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), ClientCookie.COMMENT_ATTR, "uType " + toUserType, "touid", Long.valueOf(chatMessage.getToUserId()), "content", chatMessage.getContent());
                if (chatMessage instanceof PersonalChatMessage) {
                    b.buF().a(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    b.buF().a(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else {
                    return;
                }
                if (chatMessage instanceof PersonalChatMessage) {
                    aT = b.buF().aT(String.valueOf(e.s(chatMessage)), 2);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    aT = b.buF().aT(String.valueOf(e.s(chatMessage)), 4);
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
                                h.bso().endTransaction();
                            }
                            if (customMessage instanceof CustomMessage) {
                                h.bso().bsp();
                                j.bsr().a(aT, 3);
                                if (aT.getCustomGroupType() == 2) {
                                    m.bsz().a(chatMessage.getUserId(), chatMessage.getToUserId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                                } else {
                                    l.bsx().a(chatMessage.getUserId(), chatMessage.getToUserId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                                }
                                return new CustomResponsedMessage<>(2016012, socketResponsedMessage);
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
    private CustomMessageListener goU = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo aT;
            if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (aT = b.buF().aT("-1002", -3)) != null) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    aT.setUnread_count(0);
                    aT.setIs_hidden(1);
                    ImMemoryCacheRegister.this.p(aT);
                } else if (data instanceof ImMessageCenterPojo) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                    aT.setLast_content(imMessageCenterPojo.getLast_content());
                    aT.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    aT.setUnread_count(0);
                    aT.setIs_hidden(0);
                    ImMemoryCacheRegister.this.p(aT);
                }
            }
        }
    };
    private CustomMessageListener goV = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo aT;
            if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (aT = b.buF().aT("-1003", -4)) != null) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    aT.setUnread_count(0);
                    aT.setIs_hidden(1);
                    ImMemoryCacheRegister.this.p(aT);
                } else if (data instanceof ImMessageCenterPojo) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                    aT.setLast_content(imMessageCenterPojo.getLast_content());
                    aT.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    aT.setUnread_count(0);
                    aT.setIs_hidden(0);
                    ImMemoryCacheRegister.this.p(aT);
                }
            }
        }
    };
    private CustomMessageListener goW = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage;
            MemoryClearStrangerItemsMessage.a data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryClearStrangerItemsMessage) && (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) != null && data.dkO != null) {
                for (MemoryModifyVisibilityMessage.a aVar : data.dkO) {
                    b.buF().aN(aVar.id, aVar.customGroupType);
                }
                if (memoryClearStrangerItemsMessage.isAllClear()) {
                    b.buF().f("-1001", -7, false);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.27.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null) {
                            try {
                                if (customMessage instanceof CustomMessage) {
                                    h.bso().bsp();
                                    j.bsr().bsv();
                                    if (memoryClearStrangerItemsMessage.isAllClear()) {
                                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                        imMessageCenterPojo.setGid("-1001");
                                        imMessageCenterPojo.setCustomGroupType(-7);
                                        imMessageCenterPojo.setIs_hidden(1);
                                        j.bsr().f(imMessageCenterPojo);
                                    }
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            } finally {
                                h.bso().endTransaction();
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
    private CustomMessageListener goX = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MemoryItemRemoveMessage.a)) {
                MemoryItemRemoveMessage.a aVar = (MemoryItemRemoveMessage.a) customResponsedMessage.getData();
                if (aVar.customGroupType == 1) {
                    ImMemoryCacheRegister.this.xp(aVar.id);
                }
            }
        }
    };
    private CustomMessageListener goY = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.29
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
                        ImMessageCenterPojo aT = b.buF().aT(valueOf, customType);
                        if (groupMsgData.getCmd() == 2012125) {
                            com.baidu.tieba.im.chat.b.b.a(groupMsgData, aT, ImMemoryCacheRegister.this.gpo);
                        } else if (groupMsgData.getCmd() == 2012124) {
                            com.baidu.tieba.im.chat.b.c.a(groupMsgData, aT, ImMemoryCacheRegister.this.gpq);
                        } else if (groupMsgData.getCmd() == 2012123) {
                            d.b(groupMsgData, aT, ImMemoryCacheRegister.this.gpr);
                        } else if (groupMsgData.getCmd() == 2012121) {
                            com.baidu.tieba.im.chat.b.e.b(groupMsgData, aT, ImMemoryCacheRegister.this.gps);
                        } else if (groupMsgData.getCmd() == 2012120) {
                            f.a(groupMsgData, aT, ImMemoryCacheRegister.this.gpp);
                        } else if (groupMsgData.getCmd() == 2012128) {
                            if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                b.buF().c(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.gsf));
                            }
                        } else if (groupMsgData.getCmd() == 2012129) {
                            if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                ChatMessage chatMessage = groupMsgData.getListMessage().get(0);
                                if (!chatMessage.isPushForOperateAccount()) {
                                    b.buF().c(-9, chatMessage.getMsgId(), String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
                                }
                            }
                        } else if (groupMsgData.getCmd() == 2012126) {
                            if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                                g.a(groupMsgData, aT, new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.29.1
                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
                                        if (imMessageCenterPojo != null) {
                                            b.buF().c(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
                                        }
                                    }

                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void l(String str, List<CommonMsgPojo> list) {
                                    }
                                });
                            } else {
                                long[] b = g.bqE().b(groupMsgData);
                                if (b != null && b.length == 2) {
                                    if (b[0] <= 0 && b[1] > 0) {
                                        if (b[0] == 12) {
                                            b.buF().c(8, b[1], String.valueOf(12));
                                        } else if (b[0] == 11) {
                                            b.buF().c(7, b[1], String.valueOf(11));
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            g.bqE().c(groupMsgData);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c goZ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ImMemoryCacheRegister.this.goQ = (ResponseOnlineMessage) socketResponsedMessage;
                if (b.buF().goC.get()) {
                    ImMemoryCacheRegister.this.buT();
                }
            }
        }
    };
    private CustomMessageListener gpa = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002 && (customResponsedMessage instanceof MemoryInitCompleteMessage)) {
                ImMemoryCacheRegister.this.buT();
            }
        }
    };
    private CustomMessageListener cMS = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005018) {
                ImMemoryCacheRegister.this.goQ = null;
                com.baidu.tieba.im.sendmessage.a.dj(0L);
                com.baidu.tieba.im.sendmessage.a.dk(0L);
                b.buF().init();
                com.baidu.tbadk.coreExtra.messageCenter.c.aid().init();
            }
        }
    };
    private CustomMessageListener gpb = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyLastMsgMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016003 && (data = ((MemoryModifyLastMsgMessage) customResponsedMessage).getData()) != null) {
                b.buF().a(data.customGroupType, data.gpU, data.id, data.type);
                final ImMessageCenterPojo aT = b.buF().aT(data.id, data.customGroupType);
                if (aT != null) {
                    final ImMessageCenterPojo imMessageCenterPojo = null;
                    if (aT.getCustomGroupType() == 4) {
                        imMessageCenterPojo = b.buF().aT("-1000", -8);
                    }
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.4.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.bsr().a(aT, 2);
                            if (imMessageCenterPojo != null) {
                                j.bsr().a(imMessageCenterPojo, 2);
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
    private CustomMessageListener gpc = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008016) {
                b.buF().reset();
            }
        }
    };
    private CustomMessageListener gpd = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyVisibilityMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016005 && (customResponsedMessage instanceof MemoryModifyVisibilityMessage) && (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) != null) {
                final ImMessageCenterPojo aT = b.buF().aT(data.id, data.customGroupType);
                int i = data.visible ? 0 : 1;
                if (aT != null && i != aT.getIs_hidden()) {
                    if (data.customGroupType == 2) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().nK(data.id);
                    } else if (data.customGroupType == 4) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iA(com.baidu.adp.lib.g.b.l(data.id, 0));
                    } else if (data.customGroupType == -3) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iB(2);
                    } else if (data.customGroupType == -4) {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iB(1);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().nJ(data.id);
                    }
                    b.buF().f(data.id, data.customGroupType, data.visible);
                    aT.setIs_hidden(i);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.6.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
                            if (customMessage != null && customMessage.getData() != null) {
                                j.bsr().f(aT);
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
    private CustomMessageListener gpe = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearUnreadCountMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016006 && (customResponsedMessage instanceof MemoryClearUnreadCountMessage) && (data = ((MemoryClearUnreadCountMessage) customResponsedMessage).getData()) != null) {
                ImMessageCenterPojo aT = b.buF().aT(data.id, data.customGroupType);
                if (aT == null) {
                    BdLog.e("ClearUnreadCountMessage:  not find memery pojo");
                } else if (aT.getUnread_count() != 0) {
                    b.buF().aV(data.id, data.customGroupType);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.7.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<MemoryClearUnreadCountMessage.a> customMessage) {
                            if (customMessage == null) {
                            }
                            MemoryClearUnreadCountMessage.a data2 = customMessage.getData();
                            j.bsr().aQ(data2.id, data2.customGroupType);
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
    private CustomMessageListener gpf = new CustomMessageListener(2016016) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ImMessageCenterPojo)) {
                final ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData();
                b.buF().k(imMessageCenterPojo);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.8.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        try {
                            try {
                                h.bso().bsp();
                                j.bsr().f(imMessageCenterPojo);
                                com.baidu.tieba.im.db.c.bsh().wN(imMessageCenterPojo.getGid());
                                h.bso().endTransaction();
                                return null;
                            } catch (Exception e) {
                                BdLog.detailException(e);
                                h.bso().endTransaction();
                                return null;
                            }
                        } catch (Throwable th) {
                            h.bso().endTransaction();
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
    private CustomMessageTask.CustomRunnable<Integer> gpg = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.9
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
            List<ImMessageCenterPojo> buN;
            if (customMessage == null || !(customMessage instanceof RequestMemoryListMessage)) {
                return null;
            }
            int intValue = ((RequestMemoryListMessage) customMessage).getData().intValue();
            if (intValue == 3) {
                buN = b.buF().buM();
            } else if (intValue == 2) {
                buN = b.buF().buL();
            } else if (intValue == 1) {
                buN = b.buF().buJ();
            } else {
                buN = intValue == 4 ? b.buF().buN() : null;
            }
            return new ResponsedMemoryListMessage(buN, intValue);
        }
    };
    private CustomMessageListener gph = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            UpdatesItemData convertToUpdatesItem;
            final ImMessageCenterPojo aT;
            UpdatesItemData convertToUpdatesItem2;
            final ImMessageCenterPojo aT2;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                String cmd = p.getCmd();
                if (!TextUtils.isEmpty(cmd)) {
                    if (f.wy(cmd)) {
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        imMessageCenterPojo.setGid("-1002");
                        imMessageCenterPojo.setCustomGroupType(-3);
                        imMessageCenterPojo.setLast_content(f.cS(cmd, p.getContent()));
                        imMessageCenterPojo.setLast_content_time(p.getTime());
                        imMessageCenterPojo.setLast_rid(com.baidu.adp.lib.g.b.d(p.getNotice_id(), 0L));
                        b.buF().c(imMessageCenterPojo, ChatStatusManager.getInst().getIsOpen(6) ? 0 : 1);
                    } else if (f.wz(cmd)) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1003");
                        imMessageCenterPojo2.setCustomGroupType(-4);
                        imMessageCenterPojo2.setLast_content(f.cS(cmd, p.getContent()));
                        imMessageCenterPojo2.setLast_content_time(p.getTime());
                        imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.g.b.d(p.getNotice_id(), 0L));
                        b.buF().c(imMessageCenterPojo2, ChatStatusManager.getInst().getIsOpen(7) ? 0 : 1);
                    }
                    if (cmd.equals("group_head_change")) {
                        if (ModelHelper.getInstance().getUpdatasModel() != null && (convertToUpdatesItem2 = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) != null) {
                            String groupId = convertToUpdatesItem2.getGroupId();
                            if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(convertToUpdatesItem2.getGroupHeadUrl()) && (aT2 = b.buF().aT(groupId, 1)) != null) {
                                if (aT2.getGroup_head() == null || !aT2.getGroup_head().equals(convertToUpdatesItem2.getGroupHeadUrl())) {
                                    b.buF().cV(groupId, convertToUpdatesItem2.getGroupHeadUrl());
                                    aT2.setGroup_head(convertToUpdatesItem2.getGroupHeadUrl());
                                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.1
                                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                            j.bsr().f(aT2);
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
                            if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(convertToUpdatesItem.getGroupName()) && (aT = b.buF().aT(groupId2, 1)) != null) {
                                if (aT.getGroup_name() == null || !aT.getGroup_name().equals(convertToUpdatesItem.getGroupName())) {
                                    b.buF().cW(groupId2, convertToUpdatesItem.getGroupName());
                                    aT.setGroup_name(convertToUpdatesItem.getGroupName());
                                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.2
                                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                            j.bsr().f(aT);
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
                                com.baidu.tieba.im.settingcache.b.bwa().c(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                                com.baidu.tieba.im.settingcache.b.bwa().b(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                                final ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                imMessageCenterPojo3.setGroup_name(optString3);
                                imMessageCenterPojo3.setCustomGroupType(1);
                                imMessageCenterPojo3.setGid(optString);
                                imMessageCenterPojo3.setGroup_head(optString2);
                                imMessageCenterPojo3.setLast_content_time(p.getTime());
                                imMessageCenterPojo3.setIs_hidden(0);
                                imMessageCenterPojo3.setUnread_count(0);
                                imMessageCenterPojo3.setLast_content(" ");
                                imMessageCenterPojo3.setLast_rid(com.baidu.tieba.im.util.d.dm(optLong));
                                imMessageCenterPojo3.setPulled_msgId(com.baidu.tieba.im.util.d.dm(optLong));
                                b.buF().l(imMessageCenterPojo3);
                                b.buF().c(1, com.baidu.tieba.im.util.d.dm(optLong), optString);
                                CustomMessageTask customMessageTask3 = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.3
                                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                        try {
                                            h.bso().bsp();
                                            com.baidu.tieba.im.db.c.bsh().wN(imMessageCenterPojo3.getGid());
                                            j.bsr().f(imMessageCenterPojo3);
                                        } catch (Exception e) {
                                            BdLog.detailException(e);
                                        } finally {
                                            h.bso().endTransaction();
                                        }
                                        return new CustomResponsedMessage<>(2001214);
                                    }
                                });
                                customMessageTask3.setParallel(TiebaIMConfig.getParallel());
                                customMessageTask3.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                                customMessageTask3.setPriority(4);
                                MessageManager.getInstance().sendMessage(new CustomMessage(2001213), customMessageTask3);
                            } catch (Exception e) {
                                BdLog.detailException(e);
                            }
                        }
                    } else if (cmd.equals("dismiss_group") || cmd.equals("kick_out")) {
                        String gid = p.getGid();
                        if (!TextUtils.isEmpty(gid)) {
                            ImMemoryCacheRegister.this.xp(gid);
                        }
                    }
                }
            }
        }
    };
    CustomMessageListener gpi = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                final long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                int action = responseNewFriendUpdateUiMsg.getAction();
                if (action == 0) {
                    final ImMessageCenterPojo aT = b.buF().aT(String.valueOf(friendId), 2);
                    if (aT != null) {
                        aT.setIsFriend(1);
                        aT.setFollowStatus(1);
                        b.buF().l(aT);
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11.1
                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                j.bsr().f(aT);
                                return null;
                            }
                        });
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                    }
                } else if (action == 1) {
                    b.buF().aU(String.valueOf(friendId), 2);
                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11.2
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            try {
                                h.bso().bsp();
                                j.bsr().aO(String.valueOf(friendId), 2);
                                m.bsz().wK(String.valueOf(friendId));
                                return null;
                            } catch (Exception e) {
                                BdLog.detailException(e);
                                return null;
                            } finally {
                                h.bso().endTransaction();
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
    private com.baidu.adp.framework.listener.c gpj = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205006 && (socketResponsedMessage instanceof ResponsedPersonalMsgReadMessage)) {
                ResponsedPersonalMsgReadMessage responsedPersonalMsgReadMessage = (ResponsedPersonalMsgReadMessage) socketResponsedMessage;
                if (!responsedPersonalMsgReadMessage.hasError() && responsedPersonalMsgReadMessage.getGroupId() == com.baidu.tieba.im.sendmessage.a.gsf.longValue() && responsedPersonalMsgReadMessage.getToUserType() == 0) {
                    final ImMessageCenterPojo aT = b.buF().aT(String.valueOf(responsedPersonalMsgReadMessage.getToUid()), 2);
                    if (aT != null) {
                        long dm = com.baidu.tieba.im.util.d.dm(responsedPersonalMsgReadMessage.getHasSentMsgId());
                        if (dm > aT.getSent_msgId()) {
                            aT.setSent_msgId(dm);
                            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.13.1
                                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                    try {
                                        j.bsr().f(aT);
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
    private CustomMessageListener gpk = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo imMessageCenterPojo;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016013 && (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) != null) {
                b.buF().n(imMessageCenterPojo);
                b.buF().m(imMessageCenterPojo);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.14.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        try {
                            h.bso().bsp();
                            j.bsr().f(imMessageCenterPojo);
                            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                                com.baidu.tieba.im.db.c.bsh().wN(imMessageCenterPojo.getGid());
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.bso().endTransaction();
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
    private CustomMessageListener gpl = new CustomMessageListener(2016017) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo aT;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MemoryUpdateHeadNameMessage.a)) {
                MemoryUpdateHeadNameMessage.a aVar = (MemoryUpdateHeadNameMessage.a) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(aVar.id)) {
                    if ((!TextUtils.isEmpty(aVar.head) || !TextUtils.isEmpty(aVar.name)) && (aT = b.buF().aT(aVar.id, aVar.customGroupType)) != null) {
                        String str = aVar.name;
                        String str2 = aVar.head;
                        if (!TextUtils.isEmpty(str)) {
                            b.buF().cW(aVar.id, str);
                        }
                        if (!TextUtils.isEmpty(aVar.head)) {
                            b.buF().cV(aVar.id, str2);
                        }
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15.1
                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                if (customMessage != null) {
                                    j.bsr().a(aT, 2);
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
    private CustomMessageListener gpm = new CustomMessageListener(2016020) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo aT;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof PersonalChatMessage) {
                    b.buF().c(-1, ((PersonalChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.gsf));
                    aT = b.buF().aT(String.valueOf(com.baidu.tieba.im.sendmessage.a.gsf), -1);
                } else if (customResponsedMessage.getData() instanceof OfficialChatMessage) {
                    b.buF().c(-9, ((OfficialChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.gsg));
                    aT = b.buF().aT(String.valueOf(com.baidu.tieba.im.sendmessage.a.gsg), -9);
                } else {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    b.buF().c(1, chatMessage.getMsgId(), chatMessage.getGroupId());
                    aT = b.buF().aT(chatMessage.getGroupId(), 1);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.16.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        j.bsr().a(aT, 1);
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
    private CustomMessageListener gpn = new CustomMessageListener(2001382) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final List<ImMessageCenterPojo> buL = b.buF().buL();
            if (buL != null && buL.size() != 0) {
                for (ImMessageCenterPojo imMessageCenterPojo : buL) {
                    imMessageCenterPojo.setTaskId("");
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.17.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        for (ImMessageCenterPojo imMessageCenterPojo2 : buL) {
                            j.bsr().f(imMessageCenterPojo2);
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
    private a.b gpo = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.18
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.buF().j(imMessageCenterPojo);
            b.buF().c(1, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(1));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void l(String str, List<CommonMsgPojo> list) {
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
    private a.b gpp = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.19
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.buF().c(-2, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void l(String str, List<CommonMsgPojo> list) {
        }
    };
    private a.b gpq = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.20
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.buF().c(5, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(2));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void l(String str, List<CommonMsgPojo> list) {
            if (list != null && list.size() != 0) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 10) {
                        com.baidu.tieba.im.chat.b.a.ww(commonMsgPojo.getContent());
                    }
                }
            }
        }
    };
    private a.b gpr = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.21
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.buF().j(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void l(String str, List<CommonMsgPojo> list) {
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                    RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                    com.baidu.tieba.im.data.d a = e.a(commonMsgPojo);
                    if (a != null) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "message_receive", "receive", 1, "task_type", a.ggX, "task_id", a.taskId);
                    }
                }
            }
        }
    };
    private a.b gps = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.22
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.buF().j(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void l(String str, List<CommonMsgPojo> list) {
        }
    };

    private ImMemoryCacheRegister() {
        register();
    }

    public static ImMemoryCacheRegister buS() {
        com.baidu.adp.lib.util.l.lm();
        if (goR == null) {
            synchronized (ImMemoryCacheRegister.class) {
                if (goR == null) {
                    goR = new ImMemoryCacheRegister();
                }
            }
        }
        return goR;
    }

    private void register() {
        MessageManager.getInstance().registerListener(2012125, this.goY);
        MessageManager.getInstance().registerListener(2012124, this.goY);
        MessageManager.getInstance().registerListener(2012123, this.goY);
        MessageManager.getInstance().registerListener(2012121, this.goY);
        MessageManager.getInstance().registerListener(2012120, this.goY);
        MessageManager.getInstance().registerListener(2012126, this.goY);
        MessageManager.getInstance().registerListener(2012128, this.goY);
        MessageManager.getInstance().registerListener(2012129, this.goY);
        MessageManager.getInstance().registerListener(1001, this.goZ);
        MessageManager.getInstance().registerListener(2005018, this.cMS);
        MessageManager.getInstance().registerStickyMode(2016002);
        MessageManager.getInstance().registerListener(2016002, this.gpa);
        MessageManager.getInstance().registerListener(2016003, this.gpb);
        MessageManager.getInstance().registerListener(2008016, this.gpc);
        MessageManager.getInstance().registerListener(2016005, this.gpd);
        MessageManager.getInstance().registerListener(2016006, this.gpe);
        MessageManager.getInstance().registerListener(this.gpf);
        MessageManager.getInstance().registerListener(2016015, this.goX);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016007, this.gpg);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001210, this.goU);
        MessageManager.getInstance().registerListener(2001211, this.goV);
        MessageManager.getInstance().registerListener(202001, this.goS);
        MessageManager.getInstance().registerListener(205001, this.goT);
        MessageManager.getInstance().registerListener(2001126, this.gph);
        MessageManager.getInstance().registerListener(2001125, this.gph);
        MessageManager.getInstance().registerListener(2001128, this.gph);
        MessageManager.getInstance().registerListener(2001129, this.gph);
        MessageManager.getInstance().registerListener(2001130, this.gph);
        MessageManager.getInstance().registerListener(2001131, this.gph);
        MessageManager.getInstance().registerListener(2001132, this.gph);
        MessageManager.getInstance().registerListener(2001133, this.gph);
        MessageManager.getInstance().registerListener(2001134, this.gph);
        MessageManager.getInstance().registerListener(2001135, this.gph);
        MessageManager.getInstance().registerListener(2001137, this.gph);
        MessageManager.getInstance().registerListener(2001138, this.gph);
        MessageManager.getInstance().registerListener(2001139, this.gph);
        MessageManager.getInstance().registerListener(2016009, this.goW);
        MessageManager.getInstance().registerListener(2001174, this.gpi);
        MessageManager.getInstance().registerListener(205006, this.gpj);
        MessageManager.getInstance().registerListener(2016013, this.gpk);
        MessageManager.getInstance().registerListener(this.gpl);
        MessageManager.getInstance().registerListener(this.gpm);
        MessageManager.getInstance().registerListener(this.gpn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        ArrayList arrayList;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo imMessageCenterPojo2;
        ImMessageCenterPojo imMessageCenterPojo3;
        ImMessageCenterPojo imMessageCenterPojo4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        boolean z;
        StringBuilder sb;
        if (this.goQ != null) {
            StringBuilder sb2 = null;
            for (GroupUpdateMessage groupUpdateMessage : this.goQ.getGroupInfos()) {
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
                    imMessageCenterPojo5.setCustomGroupType(com.baidu.tieba.im.a.a.ui(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo5.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo5.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo5.setNameShow(groupUpdateMessage.getNameShow());
                    imMessageCenterPojo5.setPulled_msgId(com.baidu.tieba.im.util.d.dm(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo5.getCustomGroupType() == -2 || imMessageCenterPojo5.getCustomGroupType() == -1 || imMessageCenterPojo5.getCustomGroupType() == -9 || imMessageCenterPojo5.getCustomGroupType() == 5 || imMessageCenterPojo5.getCustomGroupType() == 6) {
                        imMessageCenterPojo5.setIs_hidden(1);
                    }
                    b.buF().n(imMessageCenterPojo5);
                    b.buF().m(imMessageCenterPojo5);
                    sb2 = sb;
                }
            }
            long j = -1;
            if (this.goQ.getOrginalMessage() != null) {
                j = this.goQ.getOrginalMessage().getClientLogID();
            }
            int cmd = this.goQ.getCmd();
            int error = this.goQ.getError();
            String errorString = this.goQ.getErrorString();
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
            for (ImMessageCenterPojo imMessageCenterPojo10 : b.buF().buK()) {
                if (imMessageCenterPojo10.getCustomGroupType() == 1) {
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    arrayList5.add(imMessageCenterPojo10);
                    boolean z2 = true;
                    Iterator<GroupUpdateMessage> it = this.goQ.getGroupInfos().iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        GroupUpdateMessage next = it.next();
                        if (com.baidu.tieba.im.a.a.ui(next.getGroupType()) == 1 && imMessageCenterPojo10.getGid().equals(String.valueOf(next.getGroupId()))) {
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
                    com.baidu.tieba.im.pushNotify.b.bvI().xq(imMessageCenterPojo10.getGid());
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    arrayList2 = arrayList4;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList3 = arrayList5;
                    arrayList = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo8;
                    imMessageCenterPojo3 = imMessageCenterPojo10;
                } else if (imMessageCenterPojo10.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.sendmessage.a.dj(com.baidu.adp.lib.g.b.d(imMessageCenterPojo10.getGid(), 0L));
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList2 = arrayList4;
                    arrayList3 = arrayList5;
                    ArrayList arrayList8 = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo10;
                    arrayList = arrayList8;
                } else if (imMessageCenterPojo10.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.sendmessage.a.dk(com.baidu.adp.lib.g.b.d(imMessageCenterPojo10.getGid(), 0L));
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
                b.buF().cX(arrayList4);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.31
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && (customMessage instanceof OnlineToDbCustomMessage)) {
                        OnlineToDbCustomMessage onlineToDbCustomMessage = (OnlineToDbCustomMessage) customMessage;
                        try {
                            h.bso().bsp();
                            if (onlineToDbCustomMessage.needCreateGroupList != null) {
                                com.baidu.tieba.im.db.c.bsh().cM(onlineToDbCustomMessage.needCreateGroupList);
                                for (ImMessageCenterPojo imMessageCenterPojo11 : onlineToDbCustomMessage.needCreateGroupList) {
                                    j.bsr().f(imMessageCenterPojo11);
                                }
                            }
                            if (onlineToDbCustomMessage.systemGroup != null) {
                                j.bsr().f(onlineToDbCustomMessage.systemGroup);
                            }
                            if (onlineToDbCustomMessage.privateChatGroup != null) {
                                j.bsr().f(onlineToDbCustomMessage.privateChatGroup);
                            }
                            if (onlineToDbCustomMessage.officialChatGroup != null) {
                                j.bsr().f(onlineToDbCustomMessage.officialChatGroup);
                            }
                            if (onlineToDbCustomMessage.notifyGroup != null) {
                                j.bsr().f(onlineToDbCustomMessage.notifyGroup);
                            }
                            if (onlineToDbCustomMessage.yyGroupList != null) {
                                for (ImMessageCenterPojo imMessageCenterPojo12 : onlineToDbCustomMessage.yyGroupList) {
                                    if (imMessageCenterPojo12.getCustomGroupType() == 6) {
                                        j.bsr().f(imMessageCenterPojo12);
                                    } else {
                                        g.bqE().w(imMessageCenterPojo12.getGid(), com.baidu.tieba.im.util.d.dn(imMessageCenterPojo12.getPulled_msgId()));
                                    }
                                }
                            }
                            if (onlineToDbCustomMessage.needDeleteGroupList != null) {
                                for (ImMessageCenterPojo imMessageCenterPojo13 : onlineToDbCustomMessage.needDeleteGroupList) {
                                    if (imMessageCenterPojo13 != null) {
                                        j.bsr().aO(imMessageCenterPojo13.getGid(), imMessageCenterPojo13.getCustomGroupType());
                                    }
                                }
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.bso().endTransaction();
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
            if (this.goQ.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList4;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.goQ = null;
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
    public void xp(final String str) {
        HashMap<String, String> ajm;
        if (!TextUtils.isEmpty(str)) {
            b.buF().aU(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW() != null && (ajm = com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahW().ajm()) != null && ajm.size() == 1 && ajm.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().nJ(str);
            }
            com.baidu.tieba.im.settingcache.b.bwa().b(TbadkCoreApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.24
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && (customMessage instanceof CustomMessage)) {
                        try {
                            h.bso().bsp();
                            j.bsr().aO(str, 1);
                            com.baidu.tieba.im.db.c.bsh().wK(str);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.bso().endTransaction();
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
    public void p(final ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            b.buF().l(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.25
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null) {
                        j.bsr().a(imMessageCenterPojo, 2);
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
