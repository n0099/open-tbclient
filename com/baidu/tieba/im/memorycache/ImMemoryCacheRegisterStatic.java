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
    private static volatile ImMemoryCacheRegisterStatic bmh;
    private ResponseOnlineMessage bmg;
    private com.baidu.adp.framework.listener.e bmi = new u(this, 0);
    private com.baidu.adp.framework.listener.e bmj = new al(this, 0);
    private CustomMessageListener bmk = new bg(this, 0);
    private CustomMessageListener bml = new bo(this, 0);
    private CustomMessageListener bmm = new bp(this, 0);
    private CustomMessageListener bmn = new bq(this, 0);
    private CustomMessageListener bmo = new bs(this, 0);
    private CustomMessageListener bmp = new bt(this, 0);
    private CustomMessageListener bmq = new bv(this, 0);
    private CustomMessageListener bmr = new w(this, 0);
    private CustomMessageListener bms = new x(this, 0);
    private com.baidu.adp.framework.listener.e bmt = new z(this, 0);
    private CustomMessageListener bmu = new aa(this, 0);
    private CustomMessageListener bmv = new ab(this, 0);
    private CustomMessageListener bmw = new ac(this, 0);
    private CustomMessageListener bmx = new ae(this, 0);
    private CustomMessageListener bmy = new af(this, 0);
    private CustomMessageListener bmz = new ah(this, 0);
    private CustomMessageListener bmA = new aj(this, 2016016);
    private CustomMessageTask.CustomRunnable<Integer> bmB = new an(this);
    private CustomMessageListener bmC = new ao(this, 0);
    CustomMessageListener bmD = new as(this, 0);
    private com.baidu.adp.framework.listener.e bmE = new av(this, 0);
    private CustomMessageListener bmF = new ax(this, 0);
    private CustomMessageListener bmG = new az(this, 2016017);
    private CustomMessageListener bmH = new bb(this, 2016020);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmI = new bd(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmJ = new be(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmK = new bf(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmL = new bh(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmM = new bi(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmN = new bj(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bmO = new bk(this);

    private ImMemoryCacheRegisterStatic() {
        zm();
    }

    private static ImMemoryCacheRegisterStatic TO() {
        com.baidu.adp.lib.util.n.jk();
        if (bmh == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bmh == null) {
                    bmh = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bmh;
    }

    static {
        TO();
    }

    private void zm() {
        MessageManager.getInstance().registerListener(2013006, this.bms);
        MessageManager.getInstance().registerListener(2013008, this.bms);
        MessageManager.getInstance().registerListener(2013005, this.bms);
        MessageManager.getInstance().registerListener(2013004, this.bms);
        MessageManager.getInstance().registerListener(2013002, this.bms);
        MessageManager.getInstance().registerListener(2013003, this.bms);
        MessageManager.getInstance().registerListener(2013001, this.bms);
        MessageManager.getInstance().registerListener(2013007, this.bms);
        MessageManager.getInstance().registerListener(2013009, this.bms);
        MessageManager.getInstance().registerListener(2013010, this.bms);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.bmt);
        MessageManager.getInstance().registerListener(2005016, this.bmv);
        MessageManager.getInstance().registerStickyMode(2016002);
        MessageManager.getInstance().registerListener(2016002, this.bmu);
        MessageManager.getInstance().registerListener(2016003, this.bmw);
        MessageManager.getInstance().registerListener(2008016, this.bmx);
        MessageManager.getInstance().registerListener(2016005, this.bmy);
        MessageManager.getInstance().registerListener(2016006, this.bmz);
        MessageManager.getInstance().registerListener(this.bmA);
        MessageManager.getInstance().registerListener(2016015, this.bmr);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016007, this.bmB);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.bmk);
        MessageManager.getInstance().registerListener(2001217, this.bml);
        MessageManager.getInstance().registerListener(2001218, this.bmm);
        MessageManager.getInstance().registerListener(202001, this.bmi);
        MessageManager.getInstance().registerListener(205001, this.bmj);
        MessageManager.getInstance().registerListener(2001130, this.bmC);
        MessageManager.getInstance().registerListener(2001129, this.bmC);
        MessageManager.getInstance().registerListener(2001132, this.bmC);
        MessageManager.getInstance().registerListener(2001133, this.bmC);
        MessageManager.getInstance().registerListener(2001134, this.bmC);
        MessageManager.getInstance().registerListener(2001135, this.bmC);
        MessageManager.getInstance().registerListener(2001136, this.bmC);
        MessageManager.getInstance().registerListener(2001137, this.bmC);
        MessageManager.getInstance().registerListener(2001138, this.bmC);
        MessageManager.getInstance().registerListener(2001139, this.bmC);
        MessageManager.getInstance().registerListener(2001141, this.bmC);
        MessageManager.getInstance().registerListener(2001142, this.bmC);
        MessageManager.getInstance().registerListener(2001143, this.bmC);
        MessageManager.getInstance().registerListener(2001167, this.bmC);
        MessageManager.getInstance().registerListener(2016206, this.bmC);
        MessageManager.getInstance().registerListener(2016018, this.bmn);
        MessageManager.getInstance().registerListener(2001201, this.bmp);
        MessageManager.getInstance().registerListener(2016019, this.bmo);
        MessageManager.getInstance().registerListener(2016009, this.bmq);
        MessageManager.getInstance().registerListener(2001178, this.bmD);
        MessageManager.getInstance().registerListener(205006, this.bmE);
        MessageManager.getInstance().registerListener(2016013, this.bmF);
        MessageManager.getInstance().registerListener(this.bmG);
        MessageManager.getInstance().registerListener(this.bmH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x023d, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void TP() {
        StringBuilder sb;
        if (this.bmg != null) {
            StringBuilder sb2 = null;
            for (GroupUpdateMessage groupUpdateMessage : this.bmg.getGroupInfos()) {
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
                    c.TD().i(imMessageCenterPojo);
                    c.TD().h(imMessageCenterPojo);
                    sb2 = sb;
                }
            }
            long j = -1;
            if (this.bmg.getOrginalMessage() != null) {
                j = this.bmg.getOrginalMessage().getClientLogID();
            }
            int cmd = this.bmg.getCmd();
            int error = this.bmg.getError();
            String errorString = this.bmg.getErrorString();
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
            for (ImMessageCenterPojo imMessageCenterPojo6 : c.TD().TJ()) {
                if (imMessageCenterPojo6.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo6);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bmg.getGroupInfos()) {
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
                    com.baidu.tieba.im.pushNotify.d.Uy().hs(imMessageCenterPojo6.getGid());
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
                c.TD().aF(arrayList2);
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
            if (this.bmg.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList2;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.bmg = null;
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
        HashMap<String, String> xe;
        if (!TextUtils.isEmpty(str)) {
            c.TD().E(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we() != null && (xe = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().we().xe()) != null && xe.size() == 1 && xe.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.vJ().dJ(str);
            }
            com.baidu.tieba.im.settingcache.c.UN().b(TbadkCoreApplication.getCurrentAccount(), str, null);
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
            c.TD().g(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bn(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
