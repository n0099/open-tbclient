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
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ImMemoryCacheRegisterStatic {
    private static volatile ImMemoryCacheRegisterStatic bmi;
    private ResponseOnlineMessage bmh;
    private com.baidu.adp.framework.listener.e bmj = new u(this, 0);
    private com.baidu.adp.framework.listener.e bmk = new al(this, 0);
    private CustomMessageListener bml = new bg(this, 0);
    private CustomMessageListener bmm = new bo(this, 0);
    private CustomMessageListener bmn = new bp(this, 0);
    private CustomMessageListener bmo = new bq(this, 0);
    private CustomMessageListener bmp = new bs(this, 0);
    private CustomMessageListener bmq = new bt(this, 0);
    private CustomMessageListener bmr = new bv(this, 0);
    private CustomMessageListener bms = new w(this, 0);
    private CustomMessageListener bmt = new x(this, 0);
    private com.baidu.adp.framework.listener.e bmu = new z(this, 0);
    private CustomMessageListener bmv = new aa(this, 0);
    private CustomMessageListener bmw = new ab(this, 0);
    private CustomMessageListener bmx = new ac(this, 0);
    private CustomMessageListener bmy = new ae(this, 0);
    private CustomMessageListener bmz = new af(this, 0);
    private CustomMessageListener bmA = new ah(this, 0);
    private CustomMessageListener bmB = new aj(this, 2016016);
    private CustomMessageTask.CustomRunnable<Integer> bmC = new an(this);
    private CustomMessageListener bmD = new ao(this, 0);
    CustomMessageListener bmE = new as(this, 0);
    private com.baidu.adp.framework.listener.e bmF = new av(this, 0);
    private CustomMessageListener bmG = new ax(this, 0);
    private CustomMessageListener bmH = new az(this, 2016017);
    private CustomMessageListener bmI = new bb(this, 2016020);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmJ = new bd(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmK = new be(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmL = new bf(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmM = new bh(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmN = new bi(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmO = new bj(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmP = new bk(this);

    private ImMemoryCacheRegisterStatic() {
        zn();
    }

    private static ImMemoryCacheRegisterStatic TP() {
        com.baidu.adp.lib.util.n.jk();
        if (bmi == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bmi == null) {
                    bmi = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bmi;
    }

    static {
        TP();
    }

    private void zn() {
        MessageManager.getInstance().registerListener(2013006, this.bmt);
        MessageManager.getInstance().registerListener(2013008, this.bmt);
        MessageManager.getInstance().registerListener(2013005, this.bmt);
        MessageManager.getInstance().registerListener(2013004, this.bmt);
        MessageManager.getInstance().registerListener(2013002, this.bmt);
        MessageManager.getInstance().registerListener(2013003, this.bmt);
        MessageManager.getInstance().registerListener(2013001, this.bmt);
        MessageManager.getInstance().registerListener(2013007, this.bmt);
        MessageManager.getInstance().registerListener(2013009, this.bmt);
        MessageManager.getInstance().registerListener(2013010, this.bmt);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.bmu);
        MessageManager.getInstance().registerListener(2005016, this.bmw);
        MessageManager.getInstance().registerStickyMode(2016002);
        MessageManager.getInstance().registerListener(2016002, this.bmv);
        MessageManager.getInstance().registerListener(2016003, this.bmx);
        MessageManager.getInstance().registerListener(2008016, this.bmy);
        MessageManager.getInstance().registerListener(2016005, this.bmz);
        MessageManager.getInstance().registerListener(2016006, this.bmA);
        MessageManager.getInstance().registerListener(this.bmB);
        MessageManager.getInstance().registerListener(2016015, this.bms);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016007, this.bmC);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.bml);
        MessageManager.getInstance().registerListener(2001217, this.bmm);
        MessageManager.getInstance().registerListener(2001218, this.bmn);
        MessageManager.getInstance().registerListener(202001, this.bmj);
        MessageManager.getInstance().registerListener(205001, this.bmk);
        MessageManager.getInstance().registerListener(2001130, this.bmD);
        MessageManager.getInstance().registerListener(2001129, this.bmD);
        MessageManager.getInstance().registerListener(2001132, this.bmD);
        MessageManager.getInstance().registerListener(2001133, this.bmD);
        MessageManager.getInstance().registerListener(2001134, this.bmD);
        MessageManager.getInstance().registerListener(2001135, this.bmD);
        MessageManager.getInstance().registerListener(2001136, this.bmD);
        MessageManager.getInstance().registerListener(2001137, this.bmD);
        MessageManager.getInstance().registerListener(2001138, this.bmD);
        MessageManager.getInstance().registerListener(2001139, this.bmD);
        MessageManager.getInstance().registerListener(2001141, this.bmD);
        MessageManager.getInstance().registerListener(2001142, this.bmD);
        MessageManager.getInstance().registerListener(2001143, this.bmD);
        MessageManager.getInstance().registerListener(2001167, this.bmD);
        MessageManager.getInstance().registerListener(2016206, this.bmD);
        MessageManager.getInstance().registerListener(2016018, this.bmo);
        MessageManager.getInstance().registerListener(2001201, this.bmq);
        MessageManager.getInstance().registerListener(2016019, this.bmp);
        MessageManager.getInstance().registerListener(2016009, this.bmr);
        MessageManager.getInstance().registerListener(2001178, this.bmE);
        MessageManager.getInstance().registerListener(205006, this.bmF);
        MessageManager.getInstance().registerListener(2016013, this.bmG);
        MessageManager.getInstance().registerListener(this.bmH);
        MessageManager.getInstance().registerListener(this.bmI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x023d, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void TQ() {
        StringBuilder sb;
        if (this.bmh != null) {
            StringBuilder sb2 = null;
            for (GroupUpdateMessage groupUpdateMessage : this.bmh.getGroupInfos()) {
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
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.gv(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.h.ag(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    c.TE().i(imMessageCenterPojo);
                    c.TE().h(imMessageCenterPojo);
                    sb2 = sb;
                }
            }
            long j = -1;
            if (this.bmh.getOrginalMessage() != null) {
                j = this.bmh.getOrginalMessage().getClientLogID();
            }
            int cmd = this.bmh.getCmd();
            int error = this.bmh.getError();
            String errorString = this.bmh.getErrorString();
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
            for (ImMessageCenterPojo imMessageCenterPojo6 : c.TE().TK()) {
                if (imMessageCenterPojo6.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo6);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bmh.getGroupInfos()) {
                        if (com.baidu.tieba.im.b.a.gv(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo6.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo6);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo6.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.d.Uz().hs(imMessageCenterPojo6.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.c.a.gD(com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo6.getGid(), 0));
                    imMessageCenterPojo4 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.c.a.gE(com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo6.getGid(), 0));
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
                c.TE().aF(arrayList2);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bl(this));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            OnlineToDbCustomMessage onlineToDbCustomMessage = new OnlineToDbCustomMessage(2001000);
            onlineToDbCustomMessage.needCreateGroupList = arrayList;
            onlineToDbCustomMessage.systemGroup = imMessageCenterPojo3;
            onlineToDbCustomMessage.notifyGroup = imMessageCenterPojo2;
            onlineToDbCustomMessage.privateChatGroup = imMessageCenterPojo4;
            onlineToDbCustomMessage.officialChatGroup = imMessageCenterPojo5;
            onlineToDbCustomMessage.yyGroupList = arrayList3;
            if (this.bmh.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList2;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.bmh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
    public void hr(String str) {
        HashMap<String, String> xf;
        if (!TextUtils.isEmpty(str)) {
            c.TE().E(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we() != null && (xf = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().xf()) != null && xf.size() == 1 && xf.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().dJ(str);
            }
            com.baidu.tieba.im.settingcache.c.UO().b(TbadkCoreApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bm(this, str));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            c.TE().g(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bn(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
