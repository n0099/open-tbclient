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
    private static volatile ImMemoryCacheRegisterStatic bEk;
    private ResponseOnlineMessage bEj;
    private com.baidu.adp.framework.listener.e bEl = new t(this, 0);
    private com.baidu.adp.framework.listener.e bEm = new ak(this, 0);
    private CustomMessageListener bEn = new bf(this, 0);
    private CustomMessageListener bEo = new bn(this, 0);
    private CustomMessageListener bEp = new bo(this, 0);
    private CustomMessageListener bEq = new bp(this, 0);
    private CustomMessageListener bEr = new br(this, 0);
    private CustomMessageListener bEs = new bs(this, 0);
    private CustomMessageListener bEt = new bu(this, 0);
    private CustomMessageListener bEu = new v(this, 0);
    private CustomMessageListener bEv = new w(this, 0);
    private com.baidu.adp.framework.listener.e bEw = new y(this, 0);
    private CustomMessageListener bEx = new z(this, 0);
    private CustomMessageListener aEc = new aa(this, 0);
    private CustomMessageListener bEy = new ab(this, 0);
    private CustomMessageListener bEz = new ad(this, 0);
    private CustomMessageListener bEA = new ae(this, 0);
    private CustomMessageListener bEB = new ag(this, 0);
    private CustomMessageListener bEC = new ai(this, CmdConfigCustom.MEMORY_UPDATE_ITEM_CREATE_GROUP);
    private CustomMessageTask.CustomRunnable<Integer> bED = new am(this);
    private CustomMessageListener bEE = new an(this, 0);
    CustomMessageListener bEF = new ar(this, 0);
    private com.baidu.adp.framework.listener.e bEG = new au(this, 0);
    private CustomMessageListener bEH = new aw(this, 0);
    private CustomMessageListener bEI = new ay(this, CmdConfigCustom.MEMORY_UPDATE_GROUP_HEAD_NAME);
    private CustomMessageListener bEJ = new ba(this, CmdConfigCustom.MEMORY_UPDATE_PULL_MSG_ID);
    private a.b bEK = new bc(this);
    private a.b bEL = new bd(this);
    private a.b bEM = new be(this);
    private a.b bEN = new bg(this);
    private a.b bEO = new bh(this);
    private a.b bEP = new bi(this);
    private a.b bEQ = new bj(this);

    private ImMemoryCacheRegisterStatic() {
        AM();
    }

    private static ImMemoryCacheRegisterStatic Wy() {
        com.baidu.adp.lib.util.k.jc();
        if (bEk == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bEk == null) {
                    bEk = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bEk;
    }

    static {
        Wy();
    }

    private void AM() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.bEv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_LIVE_CMD, this.bEv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_NOTIFY_CMD, this.bEv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.bEv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.bEv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_SNAP_CMD, this.bEv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_SYSTEM_CMD, this.bEv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_YY_CMD, this.bEv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_GROUP_CMD, this.bEv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_GROUP_CMD, this.bEv);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.bEw);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, this.aEc);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MEMORY_INIT_COMPLETED);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.bEx);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_LAST_MESSAGE, this.bEy);
        MessageManager.getInstance().registerListener(CmdConfigCustom.IM_CLEAR_MSG, this.bEz);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_VISIBILITY, this.bEA);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_UNREAD_COUNT, this.bEB);
        MessageManager.getInstance().registerListener(this.bEC);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REMOVE_ITEM, this.bEu);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.bED);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_GROUP_UPDATE, this.bEn);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_VALIDATE, this.bEo);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_LIVE_BROADCAST, this.bEp);
        MessageManager.getInstance().registerListener(202001, this.bEl);
        MessageManager.getInstance().registerListener(205001, this.bEm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_GROUP, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_EVENT_INFO, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP_WARN, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIVE_NOTIFY_LOCAL, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIVE_MSG_NOTIFY, this.bEE);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_JOIN_LIVE, this.bEq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_QUIT_LIVE_GROUP, this.bEs);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_ENTER_CHAT_ROOM, this.bEr);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MODIFY_LOTS_VISIBILITY, this.bEt);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL, this.bEF);
        MessageManager.getInstance().registerListener(205006, this.bEG);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_NOTIFY_UPDATA_GROUP, this.bEH);
        MessageManager.getInstance().registerListener(this.bEI);
        MessageManager.getInstance().registerListener(this.bEJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x023d, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wz() {
        StringBuilder sb;
        if (this.bEj != null) {
            StringBuilder sb2 = null;
            for (GroupUpdateMessage groupUpdateMessage : this.bEj.getGroupInfos()) {
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
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.hC(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.aJ(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    b.Wn().k(imMessageCenterPojo);
                    b.Wn().j(imMessageCenterPojo);
                    sb2 = sb;
                }
            }
            long j = -1;
            if (this.bEj.getOrginalMessage() != null) {
                j = this.bEj.getOrginalMessage().getClientLogID();
            }
            int cmd = this.bEj.getCmd();
            int error = this.bEj.getError();
            String errorString = this.bEj.getErrorString();
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
            for (ImMessageCenterPojo imMessageCenterPojo6 : b.Wn().Wt()) {
                if (imMessageCenterPojo6.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo6);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bEj.getGroupInfos()) {
                        if (com.baidu.tieba.im.b.a.hC(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo6.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo6);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo6.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.d.Xi().ik(imMessageCenterPojo6.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.c.a.hK(com.baidu.adp.lib.g.b.g(imMessageCenterPojo6.getGid(), 0));
                    imMessageCenterPojo4 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.c.a.hL(com.baidu.adp.lib.g.b.g(imMessageCenterPojo6.getGid(), 0));
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
                b.Wn().aP(arrayList2);
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
            if (this.bEj.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList2;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.bEj = null;
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
    public void ij(String str) {
        HashMap<String, String> yh;
        if (!TextUtils.isEmpty(str)) {
            b.Wn().K(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh() != null && (yh = com.baidu.tbadk.coreExtra.messageCenter.a.wM().xh().yh()) != null && yh.size() == 1 && yh.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.wM().dW(str);
            }
            com.baidu.tieba.im.settingcache.c.Xx().b(TbadkCoreApplication.getCurrentAccount(), str, null);
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
            b.Wn().i(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bm(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
