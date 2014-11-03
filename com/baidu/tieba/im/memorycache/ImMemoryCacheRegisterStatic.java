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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
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
    private static volatile ImMemoryCacheRegisterStatic bdp;
    private ResponseOnlineMessage bdo;
    private com.baidu.adp.framework.listener.e bdq = new u(this, 0);
    private com.baidu.adp.framework.listener.e bdr = new ak(this, 0);
    private CustomMessageListener bds = new bg(this, 0);
    private CustomMessageListener bdt = new bq(this, 0);
    private CustomMessageListener bdu = new br(this, 0);
    private com.baidu.adp.framework.listener.e bdv = new bs(this, 0);
    private com.baidu.adp.framework.listener.e bdw = new bu(this, 0);
    private com.baidu.adp.framework.listener.e bdx = new bv(this, 0);
    private CustomMessageListener bdy = new bw(this, 0);
    private CustomMessageListener bdz = new w(this, 0);
    private com.baidu.adp.framework.listener.e bdA = new y(this, 0);
    private com.baidu.adp.framework.listener.e bdB = new z(this, 0);
    private CustomMessageListener bdC = new aa(this, 0);
    private com.baidu.adp.framework.listener.e mOnlineListener = new ac(this, 0);
    private CustomMessageListener bdD = new ad(this, 0);
    private CustomMessageListener bdE = new ae(this, 0);
    private CustomMessageListener bdF = new af(this, 0);
    private CustomMessageListener bdG = new ah(this, 0);
    private CustomMessageListener bdH = new ai(this, 0);
    private CustomMessageListener bdI = new am(this, 0);
    private com.baidu.adp.framework.listener.e aTO = new ao(this, 103101);
    private CustomMessageTask.CustomRunnable<Integer> bdJ = new aq(this);
    private CustomMessageListener bdK = new ar(this, 0);
    CustomMessageListener bdL = new av(this, 0);
    CustomMessageListener bdM = new aw(this, 0);
    private com.baidu.adp.framework.listener.e bdN = new az(this, 0);
    private CustomMessageListener bdO = new bb(this, 0);
    private com.baidu.adp.framework.listener.e bdP = new bd(this, 0);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdQ = new bf(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdR = new bh(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdS = new bi(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdT = new bj(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdU = new bk(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdV = new bl(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdW = new bm(this);

    private ImMemoryCacheRegisterStatic() {
        op();
    }

    private static ImMemoryCacheRegisterStatic PY() {
        com.baidu.adp.lib.util.m.ft();
        if (bdp == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bdp == null) {
                    bdp = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bdp;
    }

    static {
        PY();
    }

    private void op() {
        MessageManager.getInstance().registerListener(2013005, this.bdC);
        MessageManager.getInstance().registerListener(2013007, this.bdC);
        MessageManager.getInstance().registerListener(2013004, this.bdC);
        MessageManager.getInstance().registerListener(2013003, this.bdC);
        MessageManager.getInstance().registerListener(2013001, this.bdC);
        MessageManager.getInstance().registerListener(2013002, this.bdC);
        MessageManager.getInstance().registerListener(2013000, this.bdC);
        MessageManager.getInstance().registerListener(2013006, this.bdC);
        MessageManager.getInstance().registerListener(1001, this.mOnlineListener);
        MessageManager.getInstance().registerListener(2005016, this.bdE);
        MessageManager.getInstance().registerStickyMode(2016001);
        MessageManager.getInstance().registerListener(2016001, this.bdD);
        MessageManager.getInstance().registerListener(2016002, this.bdF);
        MessageManager.getInstance().registerListener(2008016, this.bdG);
        MessageManager.getInstance().registerListener(2016004, this.bdH);
        MessageManager.getInstance().registerListener(2016005, this.bdI);
        MessageManager.getInstance().registerListener(this.aTO);
        MessageManager.getInstance().registerListener(103112, this.bdA);
        MessageManager.getInstance().registerListener(103104, this.bdB);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016006, this.bdJ);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.bds);
        MessageManager.getInstance().registerListener(2001217, this.bdt);
        MessageManager.getInstance().registerListener(2001218, this.bdu);
        MessageManager.getInstance().registerListener(202001, this.bdq);
        MessageManager.getInstance().registerListener(205001, this.bdr);
        MessageManager.getInstance().registerListener(2001130, this.bdK);
        MessageManager.getInstance().registerListener(2001129, this.bdK);
        MessageManager.getInstance().registerListener(2001132, this.bdK);
        MessageManager.getInstance().registerListener(2001133, this.bdK);
        MessageManager.getInstance().registerListener(2001134, this.bdK);
        MessageManager.getInstance().registerListener(2001135, this.bdK);
        MessageManager.getInstance().registerListener(2001136, this.bdK);
        MessageManager.getInstance().registerListener(2001137, this.bdK);
        MessageManager.getInstance().registerListener(2001138, this.bdK);
        MessageManager.getInstance().registerListener(2001139, this.bdK);
        MessageManager.getInstance().registerListener(2001141, this.bdK);
        MessageManager.getInstance().registerListener(2001142, this.bdK);
        MessageManager.getInstance().registerListener(2001143, this.bdK);
        MessageManager.getInstance().registerListener(2001167, this.bdK);
        MessageManager.getInstance().registerListener(107103, this.bdv);
        MessageManager.getInstance().registerListener(2001201, this.bdy);
        MessageManager.getInstance().registerListener(106101, this.bdw);
        MessageManager.getInstance().registerListener(106102, this.bdx);
        MessageManager.getInstance().registerListener(2016009, this.bdz);
        MessageManager.getInstance().registerListener(2001178, this.bdM);
        MessageManager.getInstance().registerListener(2001220, this.bdL);
        MessageManager.getInstance().registerListener(205006, this.bdN);
        MessageManager.getInstance().registerListener(2016013, this.bdO);
        MessageManager.getInstance().registerListener(103004, this.bdP);
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
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01ab, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void PZ() {
        if (this.bdo != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.bdo.getGroupInfos()) {
                if (groupUpdateMessage != null) {
                    BdLog.i("gid-serverMaxMid:" + groupUpdateMessage.getGroupId() + "-" + groupUpdateMessage.getLastMsgId());
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.c.a.fX(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.chat.bu.F(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    c.PN().i(imMessageCenterPojo);
                    c.PN().h(imMessageCenterPojo);
                }
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ArrayList arrayList3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            for (ImMessageCenterPojo imMessageCenterPojo5 : c.PN().PT()) {
                if (imMessageCenterPojo5.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo5);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bdo.getGroupInfos()) {
                        if (com.baidu.tieba.im.c.a.fX(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo5.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo5);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo5.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.f.Rq().gz(imMessageCenterPojo5.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo5;
                } else if (imMessageCenterPojo5.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.chat.w.fm(com.baidu.adp.lib.g.c.f(imMessageCenterPojo5.getGid(), 0));
                    imMessageCenterPojo4 = imMessageCenterPojo5;
                } else if (imMessageCenterPojo5.getCustomGroupType() == 6 || imMessageCenterPojo5.getCustomGroupType() == 7 || imMessageCenterPojo5.getCustomGroupType() == 8) {
                    ArrayList arrayList5 = arrayList3;
                    arrayList5.add(imMessageCenterPojo5);
                    arrayList3 = arrayList5;
                } else if (imMessageCenterPojo5.getCustomGroupType() == 5) {
                    imMessageCenterPojo2 = imMessageCenterPojo5;
                }
            }
            if (arrayList2 != null) {
                c.PN().PT().removeAll(arrayList2);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bn(this));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            OnlineToDbCustomMessage onlineToDbCustomMessage = new OnlineToDbCustomMessage(2001000);
            onlineToDbCustomMessage.needCreateGroupList = arrayList;
            onlineToDbCustomMessage.systemGroup = imMessageCenterPojo3;
            onlineToDbCustomMessage.notifyGroup = imMessageCenterPojo2;
            onlineToDbCustomMessage.privateChatGroup = imMessageCenterPojo4;
            onlineToDbCustomMessage.yyGroupList = arrayList3;
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.bdo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OnlineToDbCustomMessage extends CustomMessage<String> {
        public List<ImMessageCenterPojo> needCreateGroupList;
        public ImMessageCenterPojo notifyGroup;
        public ImMessageCenterPojo privateChatGroup;
        public ImMessageCenterPojo systemGroup;
        public List<ImMessageCenterPojo> yyGroupList;

        public OnlineToDbCustomMessage(int i) {
            super(i);
            this.needCreateGroupList = null;
            this.systemGroup = null;
            this.notifyGroup = null;
            this.privateChatGroup = null;
            this.yyGroupList = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gs(String str) {
        HashMap<String, String> pq;
        if (!TextUtils.isEmpty(str)) {
            c.PN().C(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.oD().oW() != null && (pq = com.baidu.tbadk.coreExtra.messageCenter.a.oD().oW().pq()) != null && pq.size() == 1 && pq.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.oD().cq(str);
            }
            com.baidu.tieba.im.groupInfo.aa.Pe().a(TbadkApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bo(this, str));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            c.PN().g(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bp(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
