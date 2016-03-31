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
    private static volatile ImMemoryCacheRegisterStatic cma;
    private ResponseOnlineMessage clZ;
    private com.baidu.adp.framework.listener.e cmb = new u(this, 0);
    private com.baidu.adp.framework.listener.e cmc = new al(this, 0);
    private CustomMessageListener cme = new bh(this, 0);
    private CustomMessageListener cmf = new bq(this, 0);
    private CustomMessageListener cmg = new br(this, 0);
    private CustomMessageListener cmh = new bs(this, 0);
    private CustomMessageListener cmi = new bu(this, 0);
    private CustomMessageListener cmj = new bv(this, 0);
    private CustomMessageListener cmk = new bx(this, 0);
    private CustomMessageListener cml = new w(this, 0);
    private CustomMessageListener cmm = new x(this, 0);
    private com.baidu.adp.framework.listener.e cmn = new z(this, 0);
    private CustomMessageListener cmo = new aa(this, 0);
    private CustomMessageListener aME = new ab(this, 0);
    private CustomMessageListener cmp = new ac(this, 0);
    private CustomMessageListener cmq = new ae(this, 0);
    private CustomMessageListener cmr = new af(this, 0);
    private CustomMessageListener cms = new ah(this, 0);
    private CustomMessageListener cmt = new aj(this, CmdConfigCustom.MEMORY_UPDATE_ITEM_CREATE_GROUP);
    private CustomMessageTask.CustomRunnable<Integer> cmu = new an(this);
    private CustomMessageListener cmv = new ao(this, 0);
    CustomMessageListener cmw = new as(this, 0);
    private com.baidu.adp.framework.listener.e cmx = new av(this, 0);
    private CustomMessageListener cmy = new ax(this, 0);
    private CustomMessageListener cmz = new az(this, CmdConfigCustom.MEMORY_UPDATE_GROUP_HEAD_NAME);
    private CustomMessageListener cmA = new bb(this, CmdConfigCustom.MEMORY_UPDATE_PULL_MSG_ID);
    private CustomMessageListener cmB = new bd(this, CmdConfigCustom.CMD_CLEAR_TASK_ID);
    private a.b cmC = new bf(this);
    private a.b cmD = new bg(this);
    private a.b cmE = new bi(this);
    private a.b cmF = new bj(this);
    private a.b cmG = new bk(this);
    private a.b cmH = new bl(this);
    private a.b cmI = new bm(this);

    private ImMemoryCacheRegisterStatic() {
        Dy();
    }

    private static ImMemoryCacheRegisterStatic ahd() {
        com.baidu.adp.lib.util.k.ju();
        if (cma == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (cma == null) {
                    cma = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return cma;
    }

    static {
        ahd();
    }

    private void Dy() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.cmm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_LIVE_CMD, this.cmm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_NOTIFY_CMD, this.cmm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_CMD, this.cmm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_CMD, this.cmm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_SNAP_CMD, this.cmm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_SYSTEM_CMD, this.cmm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_YY_CMD, this.cmm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_PERSONAL_GROUP_CMD, this.cmm);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_OFFICIAL_GROUP_CMD, this.cmm);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.cmn);
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, this.aME);
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.MEMORY_INIT_COMPLETED);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.cmo);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_LAST_MESSAGE, this.cmp);
        MessageManager.getInstance().registerListener(CmdConfigCustom.IM_CLEAR_MSG, this.cmq);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_VISIBILITY, this.cmr);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_MODIFY_UNREAD_COUNT, this.cms);
        MessageManager.getInstance().registerListener(this.cmt);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REMOVE_ITEM, this.cml);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.cmu);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_GROUP_UPDATE, this.cme);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_VALIDATE, this.cmf);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_DELETED_LIVE_BROADCAST, this.cmg);
        MessageManager.getInstance().registerListener(202001, this.cmb);
        MessageManager.getInstance().registerListener(205001, this.cmc);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_GROUP, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_EVENT_INFO, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP_WARN, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIVE_NOTIFY_LOCAL, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LIVE_MSG_NOTIFY, this.cmv);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_JOIN_LIVE, this.cmh);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_QUIT_LIVE_GROUP, this.cmj);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_UPDATE_ITEM_ENTER_CHAT_ROOM, this.cmi);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_REQUEST_MODIFY_LOTS_VISIBILITY, this.cmk);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL, this.cmw);
        MessageManager.getInstance().registerListener(205006, this.cmx);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_NOTIFY_UPDATA_GROUP, this.cmy);
        MessageManager.getInstance().registerListener(this.cmz);
        MessageManager.getInstance().registerListener(this.cmA);
        MessageManager.getInstance().registerListener(this.cmB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x023d, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ahe() {
        StringBuilder sb;
        if (this.clZ != null) {
            StringBuilder sb2 = null;
            for (GroupUpdateMessage groupUpdateMessage : this.clZ.getGroupInfos()) {
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
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.jS(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.g.bk(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    b.agR().k(imMessageCenterPojo);
                    b.agR().j(imMessageCenterPojo);
                    sb2 = sb;
                }
            }
            long j = -1;
            if (this.clZ.getOrginalMessage() != null) {
                j = this.clZ.getOrginalMessage().getClientLogID();
            }
            int cmd = this.clZ.getCmd();
            int error = this.clZ.getError();
            String errorString = this.clZ.getErrorString();
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
            for (ImMessageCenterPojo imMessageCenterPojo6 : b.agR().agX()) {
                if (imMessageCenterPojo6.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo6);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.clZ.getGroupInfos()) {
                        if (com.baidu.tieba.im.b.a.jS(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo6.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo6);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo6.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.d.ahV().jC(imMessageCenterPojo6.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.c.a.ka(com.baidu.adp.lib.h.b.g(imMessageCenterPojo6.getGid(), 0));
                    imMessageCenterPojo4 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.c.a.kb(com.baidu.adp.lib.h.b.g(imMessageCenterPojo6.getGid(), 0));
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
                b.agR().bj(arrayList2);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bn(this));
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
            if (this.clZ.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList2;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.clZ = null;
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
    public void jB(String str) {
        HashMap<String, String> AK;
        if (!TextUtils.isEmpty(str)) {
            b.agR().X(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.zp().zK() != null && (AK = com.baidu.tbadk.coreExtra.messageCenter.a.zp().zK().AK()) != null && AK.size() == 1 && AK.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.zp().en(str);
            }
            com.baidu.tieba.im.settingcache.c.aik().b(TbadkCoreApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bo(this, str));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            b.agR().i(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bp(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
