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
    private static volatile ImMemoryCacheRegister exX;
    private ResponseOnlineMessage exW;
    private com.baidu.adp.framework.listener.c exY = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.1
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
                b.aLV().a(chatMessage.getCustomGroupType(), chatMessage, chatMessage.getGroupId(), 3);
                final ImMessageCenterPojo an = b.aLV().an(chatMessage.getGroupId(), chatMessage.getCustomGroupType());
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.1.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage == null || !(customMessage instanceof CustomMessage)) {
                            return null;
                        }
                        try {
                            h.aJD().aJE();
                            j.aJG().a(an, 3);
                            com.baidu.tieba.im.db.c.aJw().c(chatMessage.getGroupId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.aJD().endTransaction();
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
    private com.baidu.adp.framework.listener.c exZ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final SocketResponsedMessage socketResponsedMessage) {
            final ImMessageCenterPojo an;
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
                        com.baidu.tieba.im.sendmessage.a.cm(com.baidu.adp.lib.g.b.c(responseCommitPersonalMessage.getGroupId(), 0L));
                    } else {
                        com.baidu.tieba.im.sendmessage.a.cn(com.baidu.adp.lib.g.b.c(responseCommitPersonalMessage.getGroupId(), 0L));
                    }
                }
                com.baidu.tbadk.core.d.a.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "ack", socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), ClientCookie.COMMENT_ATTR, "uType " + toUserType, "touid", Long.valueOf(chatMessage.getToUserId()), "content", chatMessage.getContent());
                if (chatMessage instanceof PersonalChatMessage) {
                    b.aLV().a(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    b.aLV().a(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
                } else {
                    return;
                }
                if (chatMessage instanceof PersonalChatMessage) {
                    an = b.aLV().an(String.valueOf(e.s(chatMessage)), 2);
                } else if (chatMessage instanceof OfficialChatMessage) {
                    an = b.aLV().an(String.valueOf(e.s(chatMessage)), 4);
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
                                h.aJD().endTransaction();
                            }
                            if (customMessage instanceof CustomMessage) {
                                h.aJD().aJE();
                                j.aJG().a(an, 3);
                                if (an.getCustomGroupType() == 2) {
                                    m.aJO().a(chatMessage.getUserId(), chatMessage.getToUserId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
                                } else {
                                    l.aJM().a(chatMessage.getUserId(), chatMessage.getToUserId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), chatMessage.getLocalData().getStatus().shortValue());
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
    private CustomMessageListener eya = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo an;
            if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (an = b.aLV().an("-1002", -3)) != null) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    an.setUnread_count(0);
                    an.setIs_hidden(1);
                    ImMemoryCacheRegister.this.p(an);
                } else if (data instanceof ImMessageCenterPojo) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                    an.setLast_content(imMessageCenterPojo.getLast_content());
                    an.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    an.setUnread_count(0);
                    an.setIs_hidden(0);
                    ImMemoryCacheRegister.this.p(an);
                }
            }
        }
    };
    private CustomMessageListener eyb = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.26
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ImMessageCenterPojo an;
            if (customResponsedMessage != null && (customResponsedMessage instanceof CustomResponsedMessage) && !customResponsedMessage.hasError() && (an = b.aLV().an("-1003", -4)) != null) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    an.setUnread_count(0);
                    an.setIs_hidden(1);
                    ImMemoryCacheRegister.this.p(an);
                } else if (data instanceof ImMessageCenterPojo) {
                    ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) data;
                    an.setLast_content(imMessageCenterPojo.getLast_content());
                    an.setLast_content_time(imMessageCenterPojo.getLast_content_time());
                    an.setUnread_count(0);
                    an.setIs_hidden(0);
                    ImMemoryCacheRegister.this.p(an);
                }
            }
        }
    };
    private CustomMessageListener eyc = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.27
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final MemoryClearStrangerItemsMessage memoryClearStrangerItemsMessage;
            MemoryClearStrangerItemsMessage.a data;
            if (customResponsedMessage != null && (customResponsedMessage instanceof MemoryClearStrangerItemsMessage) && (data = (memoryClearStrangerItemsMessage = (MemoryClearStrangerItemsMessage) customResponsedMessage).getData()) != null && data.bCi != null) {
                for (MemoryModifyVisibilityMessage.a aVar : data.bCi) {
                    b.aLV().ah(aVar.id, aVar.customGroupType);
                }
                if (memoryClearStrangerItemsMessage.isAllClear()) {
                    b.aLV().e("-1001", -7, false);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.27.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        if (customMessage != null) {
                            try {
                                if (customMessage instanceof CustomMessage) {
                                    h.aJD().aJE();
                                    j.aJG().aJK();
                                    if (memoryClearStrangerItemsMessage.isAllClear()) {
                                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                                        imMessageCenterPojo.setGid("-1001");
                                        imMessageCenterPojo.setCustomGroupType(-7);
                                        imMessageCenterPojo.setIs_hidden(1);
                                        j.aJG().f(imMessageCenterPojo);
                                    }
                                }
                            } catch (Exception e) {
                                BdLog.e(e.getMessage());
                            } finally {
                                h.aJD().endTransaction();
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
    private CustomMessageListener eyd = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MemoryItemRemoveMessage.a)) {
                MemoryItemRemoveMessage.a aVar = (MemoryItemRemoveMessage.a) customResponsedMessage.getData();
                if (aVar.customGroupType == 1) {
                    ImMemoryCacheRegister.this.oI(aVar.id);
                }
            }
        }
    };
    private CustomMessageListener eye = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.29
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
                        ImMessageCenterPojo an = b.aLV().an(valueOf, customType);
                        if (groupMsgData.getCmd() == 2012125) {
                            com.baidu.tieba.im.chat.b.b.a(groupMsgData, an, ImMemoryCacheRegister.this.eyv);
                        } else if (groupMsgData.getCmd() == 2012124) {
                            com.baidu.tieba.im.chat.b.c.a(groupMsgData, an, ImMemoryCacheRegister.this.eyx);
                        } else if (groupMsgData.getCmd() == 2012123) {
                            d.b(groupMsgData, an, ImMemoryCacheRegister.this.eyy);
                        } else if (groupMsgData.getCmd() == 2012121) {
                            com.baidu.tieba.im.chat.b.e.b(groupMsgData, an, ImMemoryCacheRegister.this.eyz);
                        } else if (groupMsgData.getCmd() == 2012120) {
                            f.a(groupMsgData, an, ImMemoryCacheRegister.this.eyw);
                        } else if (groupMsgData.getCmd() == 2012128) {
                            if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                b.aLV().c(-1, groupMsgData.getListMessage().get(0).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.eBm));
                            }
                        } else if (groupMsgData.getCmd() == 2012129) {
                            if (groupMsgData.getListMessage() != null && groupMsgData.getListMessage().size() > 0) {
                                ChatMessage chatMessage = groupMsgData.getListMessage().get(0);
                                if (!chatMessage.isPushForOperateAccount()) {
                                    b.aLV().c(-9, chatMessage.getMsgId(), String.valueOf(groupMsgData.getGroupInfo().getGroupId()));
                                }
                            }
                        } else if (groupMsgData.getCmd() == 2012126) {
                            if (groupMsgData.getGroupInfo().getGroupId() == 10) {
                                g.a(groupMsgData, an, new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.29.1
                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
                                        if (imMessageCenterPojo != null) {
                                            b.aLV().c(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
                                        }
                                    }

                                    @Override // com.baidu.tieba.im.chat.b.a.b
                                    public void i(String str, List<CommonMsgPojo> list) {
                                    }
                                });
                            } else {
                                long[] b = g.aHS().b(groupMsgData);
                                if (b != null && b.length == 2) {
                                    if (b[0] <= 0 && b[1] > 0) {
                                        if (b[0] == 12) {
                                            b.aLV().c(8, b[1], String.valueOf(12));
                                        } else if (b[0] == 11) {
                                            b.aLV().c(7, b[1], String.valueOf(11));
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            g.aHS().c(groupMsgData);
                        }
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.c eyf = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
                ImMemoryCacheRegister.this.exW = (ResponseOnlineMessage) socketResponsedMessage;
                if (b.aLV().exI.get()) {
                    ImMemoryCacheRegister.this.aMj();
                }
            }
        }
    };
    private CustomMessageListener eyg = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016002 && (customResponsedMessage instanceof MemoryInitCompleteMessage)) {
                ImMemoryCacheRegister.this.aMj();
            }
        }
    };
    private CustomMessageListener bmU = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005018) {
                ImMemoryCacheRegister.this.exW = null;
                com.baidu.tieba.im.sendmessage.a.cm(0L);
                com.baidu.tieba.im.sendmessage.a.cn(0L);
                b.aLV().init();
                com.baidu.tbadk.coreExtra.messageCenter.b.DO().init();
            }
        }
    };
    private CustomMessageListener eyh = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyLastMsgMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016003 && (data = ((MemoryModifyLastMsgMessage) customResponsedMessage).getData()) != null) {
                b.aLV().a(data.customGroupType, data.ezb, data.id, data.type);
                final ImMessageCenterPojo an = b.aLV().an(data.id, data.customGroupType);
                if (an != null) {
                    final ImMessageCenterPojo imMessageCenterPojo = null;
                    if (an.getCustomGroupType() == 4) {
                        imMessageCenterPojo = b.aLV().an("-1000", -8);
                    }
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.4.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            j.aJG().a(an, 2);
                            if (imMessageCenterPojo != null) {
                                j.aJG().a(imMessageCenterPojo, 2);
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
    private CustomMessageListener eyi = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2008016) {
                b.aLV().reset();
            }
        }
    };
    private CustomMessageListener eyj = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryModifyVisibilityMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016005 && (customResponsedMessage instanceof MemoryModifyVisibilityMessage) && (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) != null) {
                final ImMessageCenterPojo an = b.aLV().an(data.id, data.customGroupType);
                int i = data.visible ? 0 : 1;
                if (an != null && i != an.getIs_hidden()) {
                    if (data.customGroupType == 2) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fG(data.id);
                    } else if (data.customGroupType == 4) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dW(com.baidu.adp.lib.g.b.g(data.id, 0));
                    } else if (data.customGroupType == -3) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dX(2);
                    } else if (data.customGroupType == -4) {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dX(1);
                    } else {
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fF(data.id);
                    }
                    b.aLV().e(data.id, data.customGroupType, data.visible);
                    an.setIs_hidden(i);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<MemoryModifyVisibilityMessage.a>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.6.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<MemoryModifyVisibilityMessage.a> customMessage) {
                            if (customMessage != null && customMessage.getData() != null) {
                                j.aJG().f(an);
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
    private CustomMessageListener eyk = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MemoryClearUnreadCountMessage.a data;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016006 && (customResponsedMessage instanceof MemoryClearUnreadCountMessage) && (data = ((MemoryClearUnreadCountMessage) customResponsedMessage).getData()) != null) {
                ImMessageCenterPojo an = b.aLV().an(data.id, data.customGroupType);
                if (an == null) {
                    BdLog.e("ClearUnreadCountMessage:  not find memery pojo");
                } else if (an.getUnread_count() != 0) {
                    b.aLV().ap(data.id, data.customGroupType);
                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<MemoryClearUnreadCountMessage.a>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.7.1
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<MemoryClearUnreadCountMessage.a> customMessage) {
                            if (customMessage == null) {
                            }
                            MemoryClearUnreadCountMessage.a data2 = customMessage.getData();
                            j.aJG().ak(data2.id, data2.customGroupType);
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
    private CustomMessageListener eyl = new CustomMessageListener(2016016) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ImMessageCenterPojo)) {
                final ImMessageCenterPojo imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData();
                b.aLV().k(imMessageCenterPojo);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.8.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        try {
                            try {
                                h.aJD().aJE();
                                j.aJG().f(imMessageCenterPojo);
                                com.baidu.tieba.im.db.c.aJw().oe(imMessageCenterPojo.getGid());
                                h.aJD().endTransaction();
                                return null;
                            } catch (Exception e) {
                                BdLog.detailException(e);
                                h.aJD().endTransaction();
                                return null;
                            }
                        } catch (Throwable th) {
                            h.aJD().endTransaction();
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
    private CustomMessageTask.CustomRunnable<Integer> eyn = new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.9
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
            List<ImMessageCenterPojo> aMd;
            if (customMessage == null || !(customMessage instanceof RequestMemoryListMessage)) {
                return null;
            }
            int intValue = ((RequestMemoryListMessage) customMessage).getData().intValue();
            if (intValue == 3) {
                aMd = b.aLV().aMc();
            } else if (intValue == 2) {
                aMd = b.aLV().aMb();
            } else if (intValue == 1) {
                aMd = b.aLV().aLZ();
            } else {
                aMd = intValue == 4 ? b.aLV().aMd() : null;
            }
            return new ResponsedMemoryListMessage(aMd, intValue);
        }
    };
    private CustomMessageListener eyo = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            UpdatesItemData convertToUpdatesItem;
            final ImMessageCenterPojo an;
            UpdatesItemData convertToUpdatesItem2;
            final ImMessageCenterPojo an2;
            if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                String cmd = p.getCmd();
                if (!TextUtils.isEmpty(cmd)) {
                    if (f.nP(cmd)) {
                        ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                        imMessageCenterPojo.setGid("-1002");
                        imMessageCenterPojo.setCustomGroupType(-3);
                        imMessageCenterPojo.setLast_content(f.bl(cmd, p.getContent()));
                        imMessageCenterPojo.setLast_content_time(p.getTime());
                        imMessageCenterPojo.setLast_rid(com.baidu.adp.lib.g.b.c(p.getNotice_id(), 0L));
                        b.aLV().c(imMessageCenterPojo, ChatStatusManager.getInst().getIsOpen(6) ? 0 : 1);
                    } else if (f.nQ(cmd)) {
                        ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                        imMessageCenterPojo2.setGid("-1003");
                        imMessageCenterPojo2.setCustomGroupType(-4);
                        imMessageCenterPojo2.setLast_content(f.bl(cmd, p.getContent()));
                        imMessageCenterPojo2.setLast_content_time(p.getTime());
                        imMessageCenterPojo2.setLast_rid(com.baidu.adp.lib.g.b.c(p.getNotice_id(), 0L));
                        b.aLV().c(imMessageCenterPojo2, ChatStatusManager.getInst().getIsOpen(7) ? 0 : 1);
                    }
                    if (cmd.equals("group_head_change")) {
                        if (ModelHelper.getInstance().getUpdatasModel() != null && (convertToUpdatesItem2 = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(p)) != null) {
                            String groupId = convertToUpdatesItem2.getGroupId();
                            if (!TextUtils.isEmpty(groupId) && !TextUtils.isEmpty(convertToUpdatesItem2.getGroupHeadUrl()) && (an2 = b.aLV().an(groupId, 1)) != null) {
                                if (an2.getGroup_head() == null || !an2.getGroup_head().equals(convertToUpdatesItem2.getGroupHeadUrl())) {
                                    b.aLV().bo(groupId, convertToUpdatesItem2.getGroupHeadUrl());
                                    an2.setGroup_head(convertToUpdatesItem2.getGroupHeadUrl());
                                    CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.1
                                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                            j.aJG().f(an2);
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
                            if (!TextUtils.isEmpty(groupId2) && !TextUtils.isEmpty(convertToUpdatesItem.getGroupName()) && (an = b.aLV().an(groupId2, 1)) != null) {
                                if (an.getGroup_name() == null || !an.getGroup_name().equals(convertToUpdatesItem.getGroupName())) {
                                    b.aLV().bp(groupId2, convertToUpdatesItem.getGroupName());
                                    an.setGroup_name(convertToUpdatesItem.getGroupName());
                                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.2
                                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                            j.aJG().f(an);
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
                                com.baidu.tieba.im.settingcache.b.aNq().c(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                                com.baidu.tieba.im.settingcache.b.aNq().b(TbadkCoreApplication.getCurrentAccount(), optString, true, null);
                                final ImMessageCenterPojo imMessageCenterPojo3 = new ImMessageCenterPojo();
                                imMessageCenterPojo3.setGroup_name(optString3);
                                imMessageCenterPojo3.setCustomGroupType(1);
                                imMessageCenterPojo3.setGid(optString);
                                imMessageCenterPojo3.setGroup_head(optString2);
                                imMessageCenterPojo3.setLast_content_time(p.getTime());
                                imMessageCenterPojo3.setIs_hidden(0);
                                imMessageCenterPojo3.setUnread_count(0);
                                imMessageCenterPojo3.setLast_content(" ");
                                imMessageCenterPojo3.setLast_rid(com.baidu.tieba.im.util.d.cp(optLong));
                                imMessageCenterPojo3.setPulled_msgId(com.baidu.tieba.im.util.d.cp(optLong));
                                b.aLV().l(imMessageCenterPojo3);
                                b.aLV().c(1, com.baidu.tieba.im.util.d.cp(optLong), optString);
                                CustomMessageTask customMessageTask3 = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.10.3
                                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                        try {
                                            h.aJD().aJE();
                                            com.baidu.tieba.im.db.c.aJw().oe(imMessageCenterPojo3.getGid());
                                            j.aJG().f(imMessageCenterPojo3);
                                        } catch (Exception e) {
                                            BdLog.detailException(e);
                                        } finally {
                                            h.aJD().endTransaction();
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
                            ImMemoryCacheRegister.this.oI(gid);
                        }
                    }
                }
            }
        }
    };
    CustomMessageListener eyp = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
                final long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                int action = responseNewFriendUpdateUiMsg.getAction();
                if (action == 0) {
                    final ImMessageCenterPojo an = b.aLV().an(String.valueOf(friendId), 2);
                    if (an != null) {
                        an.setIsFriend(1);
                        an.setFollowStatus(1);
                        b.aLV().l(an);
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11.1
                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                j.aJG().f(an);
                                return null;
                            }
                        });
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                    }
                } else if (action == 1) {
                    b.aLV().ao(String.valueOf(friendId), 2);
                    CustomMessageTask customMessageTask2 = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.11.2
                        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                            try {
                                h.aJD().aJE();
                                j.aJG().ai(String.valueOf(friendId), 2);
                                m.aJO().ob(String.valueOf(friendId));
                                return null;
                            } catch (Exception e) {
                                BdLog.detailException(e);
                                return null;
                            } finally {
                                h.aJD().endTransaction();
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
    private com.baidu.adp.framework.listener.c eyq = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205006 && (socketResponsedMessage instanceof ResponsedPersonalMsgReadMessage)) {
                ResponsedPersonalMsgReadMessage responsedPersonalMsgReadMessage = (ResponsedPersonalMsgReadMessage) socketResponsedMessage;
                if (!responsedPersonalMsgReadMessage.hasError() && responsedPersonalMsgReadMessage.getGroupId() == com.baidu.tieba.im.sendmessage.a.eBm.longValue() && responsedPersonalMsgReadMessage.getToUserType() == 0) {
                    final ImMessageCenterPojo an = b.aLV().an(String.valueOf(responsedPersonalMsgReadMessage.getToUid()), 2);
                    if (an != null) {
                        long cp = com.baidu.tieba.im.util.d.cp(responsedPersonalMsgReadMessage.getHasSentMsgId());
                        if (cp > an.getSent_msgId()) {
                            an.setSent_msgId(cp);
                            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.13.1
                                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                    try {
                                        j.aJG().f(an);
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
    private CustomMessageListener eyr = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo imMessageCenterPojo;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016013 && (imMessageCenterPojo = (ImMessageCenterPojo) customResponsedMessage.getData()) != null) {
                b.aLV().n(imMessageCenterPojo);
                b.aLV().m(imMessageCenterPojo);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.14.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        try {
                            h.aJD().aJE();
                            j.aJG().f(imMessageCenterPojo);
                            if (imMessageCenterPojo.getCustomGroupType() == 1) {
                                com.baidu.tieba.im.db.c.aJw().oe(imMessageCenterPojo.getGid());
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.aJD().endTransaction();
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
    private CustomMessageListener eys = new CustomMessageListener(2016017) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo an;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof MemoryUpdateHeadNameMessage.a)) {
                MemoryUpdateHeadNameMessage.a aVar = (MemoryUpdateHeadNameMessage.a) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(aVar.id)) {
                    if ((!TextUtils.isEmpty(aVar.head) || !TextUtils.isEmpty(aVar.name)) && (an = b.aLV().an(aVar.id, aVar.customGroupType)) != null) {
                        String str = aVar.name;
                        String str2 = aVar.head;
                        if (!TextUtils.isEmpty(str)) {
                            b.aLV().bp(aVar.id, str);
                        }
                        if (!TextUtils.isEmpty(aVar.head)) {
                            b.aLV().bo(aVar.id, str2);
                        }
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.15.1
                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                                if (customMessage != null) {
                                    j.aJG().a(an, 2);
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
    private CustomMessageListener eyt = new CustomMessageListener(2016020) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final ImMessageCenterPojo an;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                if (customResponsedMessage.getData() instanceof PersonalChatMessage) {
                    b.aLV().c(-1, ((PersonalChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.eBm));
                    an = b.aLV().an(String.valueOf(com.baidu.tieba.im.sendmessage.a.eBm), -1);
                } else if (customResponsedMessage.getData() instanceof OfficialChatMessage) {
                    b.aLV().c(-9, ((OfficialChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.eBn));
                    an = b.aLV().an(String.valueOf(com.baidu.tieba.im.sendmessage.a.eBn), -9);
                } else {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    b.aLV().c(1, chatMessage.getMsgId(), chatMessage.getGroupId());
                    an = b.aLV().an(chatMessage.getGroupId(), 1);
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.16.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        j.aJG().a(an, 1);
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
    private CustomMessageListener eyu = new CustomMessageListener(2001382) { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            final List<ImMessageCenterPojo> aMb = b.aLV().aMb();
            if (aMb != null && aMb.size() != 0) {
                for (ImMessageCenterPojo imMessageCenterPojo : aMb) {
                    imMessageCenterPojo.setTaskId("");
                }
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.17.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                        for (ImMessageCenterPojo imMessageCenterPojo2 : aMb) {
                            j.aJG().f(imMessageCenterPojo2);
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
    private a.b eyv = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.18
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aLV().j(imMessageCenterPojo);
            b.aLV().c(1, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(1));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void i(String str, List<CommonMsgPojo> list) {
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
    private a.b eyw = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.19
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aLV().c(-2, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void i(String str, List<CommonMsgPojo> list) {
        }
    };
    private a.b eyx = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.20
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aLV().c(5, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(2));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void i(String str, List<CommonMsgPojo> list) {
            if (list != null && list.size() != 0) {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (commonMsgPojo != null && commonMsgPojo.getMsg_type() == 10) {
                        com.baidu.tieba.im.chat.b.a.nN(commonMsgPojo.getContent());
                    }
                }
            }
        }
    };
    private a.b eyy = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.21
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aLV().j(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(4));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void i(String str, List<CommonMsgPojo> list) {
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo != null && !commonMsgPojo.isSelf()) {
                    RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MPUSH, commonMsgPojo.getUid());
                    com.baidu.tieba.im.data.d a = e.a(commonMsgPojo);
                    if (a != null) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "message_receive", "receive", 1, "task_type", a.eqa, "task_id", a.taskId);
                    }
                }
            }
        }
    };
    private a.b eyz = new a.b() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.22
        @Override // com.baidu.tieba.im.chat.b.a.b
        public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
            b.aLV().j(imMessageCenterPojo);
            if (z) {
                MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
            }
        }

        @Override // com.baidu.tieba.im.chat.b.a.b
        public void i(String str, List<CommonMsgPojo> list) {
        }
    };

    private ImMemoryCacheRegister() {
        register();
    }

    public static ImMemoryCacheRegister aMi() {
        com.baidu.adp.lib.util.l.jT();
        if (exX == null) {
            synchronized (ImMemoryCacheRegister.class) {
                if (exX == null) {
                    exX = new ImMemoryCacheRegister();
                }
            }
        }
        return exX;
    }

    private void register() {
        MessageManager.getInstance().registerListener(2012125, this.eye);
        MessageManager.getInstance().registerListener(2012124, this.eye);
        MessageManager.getInstance().registerListener(2012123, this.eye);
        MessageManager.getInstance().registerListener(2012121, this.eye);
        MessageManager.getInstance().registerListener(2012120, this.eye);
        MessageManager.getInstance().registerListener(2012126, this.eye);
        MessageManager.getInstance().registerListener(2012128, this.eye);
        MessageManager.getInstance().registerListener(2012129, this.eye);
        MessageManager.getInstance().registerListener(1001, this.eyf);
        MessageManager.getInstance().registerListener(2005018, this.bmU);
        MessageManager.getInstance().registerStickyMode(2016002);
        MessageManager.getInstance().registerListener(2016002, this.eyg);
        MessageManager.getInstance().registerListener(2016003, this.eyh);
        MessageManager.getInstance().registerListener(2008016, this.eyi);
        MessageManager.getInstance().registerListener(2016005, this.eyj);
        MessageManager.getInstance().registerListener(2016006, this.eyk);
        MessageManager.getInstance().registerListener(this.eyl);
        MessageManager.getInstance().registerListener(2016015, this.eyd);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016007, this.eyn);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001210, this.eya);
        MessageManager.getInstance().registerListener(2001211, this.eyb);
        MessageManager.getInstance().registerListener(202001, this.exY);
        MessageManager.getInstance().registerListener(205001, this.exZ);
        MessageManager.getInstance().registerListener(2001126, this.eyo);
        MessageManager.getInstance().registerListener(2001125, this.eyo);
        MessageManager.getInstance().registerListener(2001128, this.eyo);
        MessageManager.getInstance().registerListener(2001129, this.eyo);
        MessageManager.getInstance().registerListener(2001130, this.eyo);
        MessageManager.getInstance().registerListener(2001131, this.eyo);
        MessageManager.getInstance().registerListener(2001132, this.eyo);
        MessageManager.getInstance().registerListener(2001133, this.eyo);
        MessageManager.getInstance().registerListener(2001134, this.eyo);
        MessageManager.getInstance().registerListener(2001135, this.eyo);
        MessageManager.getInstance().registerListener(2001137, this.eyo);
        MessageManager.getInstance().registerListener(2001138, this.eyo);
        MessageManager.getInstance().registerListener(2001139, this.eyo);
        MessageManager.getInstance().registerListener(2016009, this.eyc);
        MessageManager.getInstance().registerListener(2001174, this.eyp);
        MessageManager.getInstance().registerListener(205006, this.eyq);
        MessageManager.getInstance().registerListener(2016013, this.eyr);
        MessageManager.getInstance().registerListener(this.eys);
        MessageManager.getInstance().registerListener(this.eyt);
        MessageManager.getInstance().registerListener(this.eyu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMj() {
        ArrayList arrayList;
        ImMessageCenterPojo imMessageCenterPojo;
        ImMessageCenterPojo imMessageCenterPojo2;
        ImMessageCenterPojo imMessageCenterPojo3;
        ImMessageCenterPojo imMessageCenterPojo4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        boolean z;
        StringBuilder sb;
        if (this.exW != null) {
            StringBuilder sb2 = null;
            for (GroupUpdateMessage groupUpdateMessage : this.exW.getGroupInfos()) {
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
                    imMessageCenterPojo5.setCustomGroupType(com.baidu.tieba.im.a.a.ov(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo5.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo5.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo5.setNameShow(groupUpdateMessage.getNameShow());
                    imMessageCenterPojo5.setPulled_msgId(com.baidu.tieba.im.util.d.cp(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo5.getCustomGroupType() == -2 || imMessageCenterPojo5.getCustomGroupType() == -1 || imMessageCenterPojo5.getCustomGroupType() == -9 || imMessageCenterPojo5.getCustomGroupType() == 5 || imMessageCenterPojo5.getCustomGroupType() == 6) {
                        imMessageCenterPojo5.setIs_hidden(1);
                    }
                    b.aLV().n(imMessageCenterPojo5);
                    b.aLV().m(imMessageCenterPojo5);
                    sb2 = sb;
                }
            }
            long j = -1;
            if (this.exW.getOrginalMessage() != null) {
                j = this.exW.getOrginalMessage().getClientLogID();
            }
            int cmd = this.exW.getCmd();
            int error = this.exW.getError();
            String errorString = this.exW.getErrorString();
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
            for (ImMessageCenterPojo imMessageCenterPojo10 : b.aLV().aMa()) {
                if (imMessageCenterPojo10.getCustomGroupType() == 1) {
                    if (arrayList5 == null) {
                        arrayList5 = new ArrayList();
                    }
                    arrayList5.add(imMessageCenterPojo10);
                    boolean z2 = true;
                    Iterator<GroupUpdateMessage> it = this.exW.getGroupInfos().iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        GroupUpdateMessage next = it.next();
                        if (com.baidu.tieba.im.a.a.ov(next.getGroupType()) == 1 && imMessageCenterPojo10.getGid().equals(String.valueOf(next.getGroupId()))) {
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
                    com.baidu.tieba.im.pushNotify.b.aMY().oJ(imMessageCenterPojo10.getGid());
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    arrayList2 = arrayList4;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList3 = arrayList5;
                    arrayList = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo8;
                    imMessageCenterPojo3 = imMessageCenterPojo10;
                } else if (imMessageCenterPojo10.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.sendmessage.a.cm(com.baidu.adp.lib.g.b.c(imMessageCenterPojo10.getGid(), 0L));
                    imMessageCenterPojo2 = imMessageCenterPojo9;
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                    imMessageCenterPojo4 = imMessageCenterPojo7;
                    arrayList2 = arrayList4;
                    arrayList3 = arrayList5;
                    ArrayList arrayList8 = arrayList6;
                    imMessageCenterPojo = imMessageCenterPojo10;
                    arrayList = arrayList8;
                } else if (imMessageCenterPojo10.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.sendmessage.a.cn(com.baidu.adp.lib.g.b.c(imMessageCenterPojo10.getGid(), 0L));
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
                b.aLV().cr(arrayList4);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.31
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && (customMessage instanceof OnlineToDbCustomMessage)) {
                        OnlineToDbCustomMessage onlineToDbCustomMessage = (OnlineToDbCustomMessage) customMessage;
                        try {
                            h.aJD().aJE();
                            if (onlineToDbCustomMessage.needCreateGroupList != null) {
                                com.baidu.tieba.im.db.c.aJw().cg(onlineToDbCustomMessage.needCreateGroupList);
                                for (ImMessageCenterPojo imMessageCenterPojo11 : onlineToDbCustomMessage.needCreateGroupList) {
                                    j.aJG().f(imMessageCenterPojo11);
                                }
                            }
                            if (onlineToDbCustomMessage.systemGroup != null) {
                                j.aJG().f(onlineToDbCustomMessage.systemGroup);
                            }
                            if (onlineToDbCustomMessage.privateChatGroup != null) {
                                j.aJG().f(onlineToDbCustomMessage.privateChatGroup);
                            }
                            if (onlineToDbCustomMessage.officialChatGroup != null) {
                                j.aJG().f(onlineToDbCustomMessage.officialChatGroup);
                            }
                            if (onlineToDbCustomMessage.notifyGroup != null) {
                                j.aJG().f(onlineToDbCustomMessage.notifyGroup);
                            }
                            if (onlineToDbCustomMessage.yyGroupList != null) {
                                for (ImMessageCenterPojo imMessageCenterPojo12 : onlineToDbCustomMessage.yyGroupList) {
                                    if (imMessageCenterPojo12.getCustomGroupType() == 6) {
                                        j.aJG().f(imMessageCenterPojo12);
                                    } else {
                                        g.aHS().q(imMessageCenterPojo12.getGid(), com.baidu.tieba.im.util.d.cq(imMessageCenterPojo12.getPulled_msgId()));
                                    }
                                }
                            }
                            if (onlineToDbCustomMessage.needDeleteGroupList != null) {
                                for (ImMessageCenterPojo imMessageCenterPojo13 : onlineToDbCustomMessage.needDeleteGroupList) {
                                    if (imMessageCenterPojo13 != null) {
                                        j.aJG().ai(imMessageCenterPojo13.getGid(), imMessageCenterPojo13.getCustomGroupType());
                                    }
                                }
                            }
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.aJD().endTransaction();
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
            if (this.exW.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList4;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.exW = null;
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
    public void oI(final String str) {
        HashMap<String, String> ES;
        if (!TextUtils.isEmpty(str)) {
            b.aLV().ao(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH() != null && (ES = com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DH().ES()) != null && ES.size() == 1 && ES.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().fF(str);
            }
            com.baidu.tieba.im.settingcache.b.aNq().b(TbadkCoreApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.24
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null && (customMessage instanceof CustomMessage)) {
                        try {
                            h.aJD().aJE();
                            j.aJG().ai(str, 1);
                            com.baidu.tieba.im.db.c.aJw().ob(str);
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                        } finally {
                            h.aJD().endTransaction();
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
            b.aLV().l(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.memorycache.ImMemoryCacheRegister.25
                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                    if (customMessage != null) {
                        j.aJG().a(imMessageCenterPojo, 2);
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
