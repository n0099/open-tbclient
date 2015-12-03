package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ImMemoryCacheRegisterStatic {
    private static volatile ImMemoryCacheRegisterStatic bTq;
    private ResponseOnlineMessage bTp;
    private com.baidu.adp.framework.listener.e bTr = new t(this, 0);
    private com.baidu.adp.framework.listener.e bTs = new ak(this, 0);
    private CustomMessageListener bTt = new bf(this, 0);
    private CustomMessageListener bTu = new bn(this, 0);
    private CustomMessageListener bTv = new bo(this, 0);
    private CustomMessageListener bTw = new bp(this, 0);
    private CustomMessageListener bTx = new br(this, 0);
    private CustomMessageListener bTy = new bs(this, 0);
    private CustomMessageListener bTz = new bu(this, 0);
    private CustomMessageListener bTA = new v(this, 0);
    private CustomMessageListener bTB = new w(this, 0);
    private com.baidu.adp.framework.listener.e bTC = new y(this, 0);
    private CustomMessageListener bTD = new z(this, 0);
    private CustomMessageListener bTE = new aa(this, 0);
    private CustomMessageListener bTF = new ab(this, 0);
    private CustomMessageListener bTG = new ad(this, 0);
    private CustomMessageListener bTH = new ae(this, 0);
    private CustomMessageListener bTI = new ag(this, 0);
    private CustomMessageListener bTJ = new ai(this, CmdConfigCustom.MEMORY_UPDATE_ITEM_CREATE_GROUP);
    private CustomMessageTask.CustomRunnable<Integer> bTK = new am(this);
    private CustomMessageListener bTL = new an(this, 0);
    CustomMessageListener bTM = new ar(this, 0);
    private com.baidu.adp.framework.listener.e bTN = new au(this, 0);
    private CustomMessageListener bTO = new aw(this, 0);
    private CustomMessageListener bTP = new ay(this, CmdConfigCustom.MEMORY_UPDATE_GROUP_HEAD_NAME);
    private CustomMessageListener bTQ = new ba(this, CmdConfigCustom.MEMORY_UPDATE_PULL_MSG_ID);
    private a.b bTR = new bc(this);
    private a.b bTS = new bd(this);
    private a.b bTT = new be(this);
    private a.b bTU = new bg(this);
    private a.b bTV = new bh(this);
    private a.b bTW = new bi(this);
    private a.b bTX = new bj(this);

    private ImMemoryCacheRegisterStatic() {
        BK();
    }

    private static ImMemoryCacheRegisterStatic ZE() {
        com.baidu.adp.lib.util.k.je();
        if (bTq == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bTq == null) {
                    bTq = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bTq;
    }

    static {
        ZE();
    }

    private void BK() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.bTB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_LIVE_CMD, this.bTB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_NOTIFY_CMD, this.bTB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.bTB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.bTB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_SNAP_CMD, this.bTB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_SYSTEM_CMD, this.bTB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_YY_CMD, this.bTB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_GROUP_CMD, this.bTB);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_GROUP_CMD, this.bTB);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.bTC);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, this.bTE);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MEMORY_INIT_COMPLETED);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bTD);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_LAST_MESSAGE, this.bTF);
        MessageManager.getInstance().registerListener(CmdConfigCustom.IM_CLEAR_MSG, this.bTG);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_VISIBILITY, this.bTH);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_UNREAD_COUNT, this.bTI);
        MessageManager.getInstance().registerListener(this.bTJ);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REMOVE_ITEM, this.bTA);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bTK);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_GROUP_UPDATE, this.bTt);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_VALIDATE, this.bTu);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_LIVE_BROADCAST, this.bTv);
        MessageManager.getInstance().registerListener(202001, this.bTr);
        MessageManager.getInstance().registerListener(205001, this.bTs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_GROUP, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_EVENT_INFO, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP_WARN, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIVE_NOTIFY_LOCAL, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIVE_MSG_NOTIFY, this.bTL);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_JOIN_LIVE, this.bTw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_QUIT_LIVE_GROUP, this.bTy);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_ENTER_CHAT_ROOM, this.bTx);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MODIFY_LOTS_VISIBILITY, this.bTz);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL, this.bTM);
        MessageManager.getInstance().registerListener(205006, this.bTN);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_NOTIFY_UPDATA_GROUP, this.bTO);
        MessageManager.getInstance().registerListener(this.bTP);
        MessageManager.getInstance().registerListener(this.bTQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x023d, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ZF() {
        StringBuilder sb;
        if (this.bTp != null) {
            StringBuilder sb2 = null;
            for (GroupUpdateMessage groupUpdateMessage : this.bTp.getGroupInfos()) {
                if (groupUpdateMessage != null) {
                    if (sb2 == null) {
                        sb = new StringBuilder(50);
                    } else {
                        sb2.append("|");
                        sb = sb2;
                    }
                    sb.append(groupUpdateMessage.getGroupId());
                    sb.append("-");
                    sb.append(groupUpdateMessage.getLastMsgId());
                    BdLog.i("gid-serverMaxMid:" + groupUpdateMessage.getGroupId() + "-" + groupUpdateMessage.getLastMsgId());
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.iq(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.aX(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    b.Zt().k(imMessageCenterPojo);
                    b.Zt().j(imMessageCenterPojo);
                    sb2 = sb;
                }
            }
            long j = -1;
            if (this.bTp.getOrginalMessage() != null) {
                j = this.bTp.getOrginalMessage().getClientLogID();
            }
            int cmd = this.bTp.getCmd();
            int error = this.bTp.getError();
            String errorString = this.bTp.getErrorString();
            Object[] objArr = new Object[2];
            objArr[0] = "comment";
            objArr[1] = sb2 == null ? "" : sb2.toString();
            com.baidu.tbadk.core.log.b.a("im", j, cmd, "ack", error, errorString, objArr);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            ImMessageCenterPojo imMessageCenterPojo5 = null;
            ArrayList arrayList3 = null;
            for (ImMessageCenterPojo imMessageCenterPojo6 : b.Zt().Zz()) {
                if (imMessageCenterPojo6.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo6);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bTp.getGroupInfos()) {
                        if (com.baidu.tieba.im.b.a.iq(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo6.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo6);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo6.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.d.aao().iE(imMessageCenterPojo6.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.c.a.iy(com.baidu.adp.lib.h.b.g(imMessageCenterPojo6.getGid(), 0));
                    imMessageCenterPojo4 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.c.a.iz(com.baidu.adp.lib.h.b.g(imMessageCenterPojo6.getGid(), 0));
                    imMessageCenterPojo5 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == 6 || imMessageCenterPojo6.getCustomGroupType() == 7 || imMessageCenterPojo6.getCustomGroupType() == 8) {
                    ArrayList arrayList5 = arrayList3;
                    arrayList5.add(imMessageCenterPojo6);
                    arrayList3 = arrayList5;
                } else if (imMessageCenterPojo6.getCustomGroupType() == 5) {
                    imMessageCenterPojo2 = imMessageCenterPojo6;
                }
            }
            if (arrayList2 != null) {
                b.Zt().ba(arrayList2);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bk(this));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            OnlineToDbCustomMessage onlineToDbCustomMessage = new OnlineToDbCustomMessage(2001000);
            onlineToDbCustomMessage.needCreateGroupList = arrayList;
            onlineToDbCustomMessage.systemGroup = imMessageCenterPojo3;
            onlineToDbCustomMessage.notifyGroup = imMessageCenterPojo2;
            onlineToDbCustomMessage.privateChatGroup = imMessageCenterPojo4;
            onlineToDbCustomMessage.officialChatGroup = imMessageCenterPojo5;
            onlineToDbCustomMessage.yyGroupList = arrayList3;
            if (this.bTp.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList2;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.bTp = null;
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
    public void iD(String str) {
        HashMap<String, String> zd;
        if (!TextUtils.isEmpty(str)) {
            b.Zt().P(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ye() != null && (zd = com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ye().zd()) != null && zd.size() == 1 && zd.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ef(str);
            }
            com.baidu.tieba.im.settingcache.c.aaD().b(TbadkCoreApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bl(this, str));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            b.Zt().i(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bm(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
