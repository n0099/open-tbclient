package com.baidu.tieba.im.memorycache;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ImMemoryCacheRegisterStatic {
    private static volatile ImMemoryCacheRegisterStatic bjE;
    private ResponseOnlineMessage bjD;
    private com.baidu.adp.framework.listener.e bjF = new u(this, 0);
    private com.baidu.adp.framework.listener.e bjG = new al(this, 0);
    private CustomMessageListener bjH = new bf(this, 0);
    private CustomMessageListener bjI = new bm(this, 0);
    private CustomMessageListener bjJ = new bn(this, 0);
    private CustomMessageListener bjK = new bo(this, 0);
    private CustomMessageListener bjL = new bq(this, 0);
    private CustomMessageListener bjM = new br(this, 0);
    private CustomMessageListener bjN = new bt(this, 0);
    private CustomMessageListener bjO = new w(this, 0);
    private CustomMessageListener bjP = new x(this, 0);
    private com.baidu.adp.framework.listener.e bjQ = new z(this, 0);
    private CustomMessageListener bjR = new aa(this, 0);
    private CustomMessageListener bjS = new ab(this, 0);
    private CustomMessageListener bjT = new ac(this, 0);
    private CustomMessageListener bjU = new ae(this, 0);
    private CustomMessageListener bjV = new af(this, 0);
    private CustomMessageListener bjW = new ah(this, 0);
    private CustomMessageListener bjX = new aj(this, 2016016);
    private CustomMessageTask.CustomRunnable<Integer> bjY = new an(this);
    private CustomMessageListener bjZ = new ao(this, 0);
    CustomMessageListener bka = new as(this, 0);
    private com.baidu.adp.framework.listener.e bkb = new av(this, 0);
    private CustomMessageListener bkc = new ax(this, 0);
    private CustomMessageListener bkd = new az(this, 2016017);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bke = new bb(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bkf = new bc(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bkg = new bd(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bkh = new be(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bki = new bg(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bkj = new bh(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bkk = new bi(this);

    private ImMemoryCacheRegisterStatic() {
        yz();
    }

    private static ImMemoryCacheRegisterStatic SB() {
        com.baidu.adp.lib.util.n.iV();
        if (bjE == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bjE == null) {
                    bjE = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bjE;
    }

    static {
        SB();
    }

    private void yz() {
        MessageManager.getInstance().registerListener(2013005, this.bjP);
        MessageManager.getInstance().registerListener(2013007, this.bjP);
        MessageManager.getInstance().registerListener(2013004, this.bjP);
        MessageManager.getInstance().registerListener(2013003, this.bjP);
        MessageManager.getInstance().registerListener(2013001, this.bjP);
        MessageManager.getInstance().registerListener(2013002, this.bjP);
        MessageManager.getInstance().registerListener(2013000, this.bjP);
        MessageManager.getInstance().registerListener(2013006, this.bjP);
        MessageManager.getInstance().registerListener(2013008, this.bjP);
        MessageManager.getInstance().registerListener(2013009, this.bjP);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.bjQ);
        MessageManager.getInstance().registerListener(2005016, this.bjS);
        MessageManager.getInstance().registerStickyMode(2016001);
        MessageManager.getInstance().registerListener(2016001, this.bjR);
        MessageManager.getInstance().registerListener(2016002, this.bjT);
        MessageManager.getInstance().registerListener(2008016, this.bjU);
        MessageManager.getInstance().registerListener(2016004, this.bjV);
        MessageManager.getInstance().registerListener(2016005, this.bjW);
        MessageManager.getInstance().registerListener(this.bjX);
        MessageManager.getInstance().registerListener(2016015, this.bjO);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016006, this.bjY);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.bjH);
        MessageManager.getInstance().registerListener(2001217, this.bjI);
        MessageManager.getInstance().registerListener(2001218, this.bjJ);
        MessageManager.getInstance().registerListener(202001, this.bjF);
        MessageManager.getInstance().registerListener(205001, this.bjG);
        MessageManager.getInstance().registerListener(2001130, this.bjZ);
        MessageManager.getInstance().registerListener(2001129, this.bjZ);
        MessageManager.getInstance().registerListener(2001132, this.bjZ);
        MessageManager.getInstance().registerListener(2001133, this.bjZ);
        MessageManager.getInstance().registerListener(2001134, this.bjZ);
        MessageManager.getInstance().registerListener(2001135, this.bjZ);
        MessageManager.getInstance().registerListener(2001136, this.bjZ);
        MessageManager.getInstance().registerListener(2001137, this.bjZ);
        MessageManager.getInstance().registerListener(2001138, this.bjZ);
        MessageManager.getInstance().registerListener(2001139, this.bjZ);
        MessageManager.getInstance().registerListener(2001141, this.bjZ);
        MessageManager.getInstance().registerListener(2001142, this.bjZ);
        MessageManager.getInstance().registerListener(2001143, this.bjZ);
        MessageManager.getInstance().registerListener(2001167, this.bjZ);
        MessageManager.getInstance().registerListener(2016018, this.bjK);
        MessageManager.getInstance().registerListener(2001201, this.bjM);
        MessageManager.getInstance().registerListener(2016019, this.bjL);
        MessageManager.getInstance().registerListener(2016009, this.bjN);
        MessageManager.getInstance().registerListener(2001178, this.bka);
        MessageManager.getInstance().registerListener(205006, this.bkb);
        MessageManager.getInstance().registerListener(2016013, this.bkc);
        MessageManager.getInstance().registerListener(this.bkd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponsedMessage) {
            Message<?> orginalMessage = socketResponsedMessage.getOrginalMessage();
            if (orginalMessage instanceof ChatMessage) {
                TiebaStatic.imNet(socketResponsedMessage, String.valueOf(((ChatMessage) orginalMessage).getMsgType()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01d4, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void SC() {
        if (this.bjD != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.bjD.getGroupInfos()) {
                if (groupUpdateMessage != null) {
                    BdLog.i("gid-serverMaxMid:" + groupUpdateMessage.getGroupId() + "-" + groupUpdateMessage.getLastMsgId());
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.ge(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.h.af(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    c.Sq().i(imMessageCenterPojo);
                    c.Sq().h(imMessageCenterPojo);
                }
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            ImMessageCenterPojo imMessageCenterPojo5 = null;
            ArrayList arrayList3 = null;
            for (ImMessageCenterPojo imMessageCenterPojo6 : c.Sq().Sw()) {
                if (imMessageCenterPojo6.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo6);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bjD.getGroupInfos()) {
                        if (com.baidu.tieba.im.b.a.ge(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo6.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo6);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo6.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.d.Tl().gP(imMessageCenterPojo6.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.c.a.gm(com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo6.getGid(), 0));
                    imMessageCenterPojo4 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.c.a.gn(com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo6.getGid(), 0));
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
                c.Sq().aG(arrayList2);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bj(this));
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
            if (this.bjD.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList2;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.bjD = null;
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
    public void gO(String str) {
        HashMap<String, String> wu;
        if (!TextUtils.isEmpty(str)) {
            c.Sq().E(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vu() != null && (wu = com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vu().wu()) != null && wu.size() == 1 && wu.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.uZ().ds(str);
            }
            com.baidu.tieba.im.settingcache.c.TA().b(TbadkCoreApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bk(this, str));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            c.Sq().g(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bl(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
