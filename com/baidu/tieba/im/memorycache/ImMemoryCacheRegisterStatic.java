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
    private static volatile ImMemoryCacheRegisterStatic bdb;
    private ResponseOnlineMessage bda;
    private com.baidu.adp.framework.listener.e bdc = new u(this, 0);
    private com.baidu.adp.framework.listener.e bdd = new ak(this, 0);
    private CustomMessageListener bde = new bg(this, 0);
    private CustomMessageListener bdf = new bq(this, 0);
    private CustomMessageListener bdg = new br(this, 0);
    private com.baidu.adp.framework.listener.e bdh = new bs(this, 0);
    private com.baidu.adp.framework.listener.e bdi = new bu(this, 0);
    private com.baidu.adp.framework.listener.e bdj = new bv(this, 0);
    private CustomMessageListener bdk = new bw(this, 0);
    private CustomMessageListener bdl = new w(this, 0);
    private com.baidu.adp.framework.listener.e bdm = new y(this, 0);
    private com.baidu.adp.framework.listener.e bdn = new z(this, 0);
    private CustomMessageListener bdo = new aa(this, 0);
    private com.baidu.adp.framework.listener.e mOnlineListener = new ac(this, 0);
    private CustomMessageListener bdp = new ad(this, 0);
    private CustomMessageListener bdq = new ae(this, 0);
    private CustomMessageListener bdr = new af(this, 0);
    private CustomMessageListener bds = new ah(this, 0);
    private CustomMessageListener bdt = new ai(this, 0);
    private CustomMessageListener bdu = new am(this, 0);
    private com.baidu.adp.framework.listener.e aTA = new ao(this, 103101);
    private CustomMessageTask.CustomRunnable<Integer> bdv = new aq(this);
    private CustomMessageListener bdw = new ar(this, 0);
    CustomMessageListener bdx = new av(this, 0);
    CustomMessageListener bdy = new aw(this, 0);
    private com.baidu.adp.framework.listener.e bdz = new az(this, 0);
    private CustomMessageListener bdA = new bb(this, 0);
    private com.baidu.adp.framework.listener.e bdB = new bd(this, 0);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdC = new bf(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdD = new bh(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdE = new bi(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdF = new bj(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdG = new bk(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdH = new bl(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bdI = new bm(this);

    private ImMemoryCacheRegisterStatic() {
        op();
    }

    private static ImMemoryCacheRegisterStatic PV() {
        com.baidu.adp.lib.util.m.ft();
        if (bdb == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bdb == null) {
                    bdb = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bdb;
    }

    static {
        PV();
    }

    private void op() {
        MessageManager.getInstance().registerListener(2013005, this.bdo);
        MessageManager.getInstance().registerListener(2013007, this.bdo);
        MessageManager.getInstance().registerListener(2013004, this.bdo);
        MessageManager.getInstance().registerListener(2013003, this.bdo);
        MessageManager.getInstance().registerListener(2013001, this.bdo);
        MessageManager.getInstance().registerListener(2013002, this.bdo);
        MessageManager.getInstance().registerListener(2013000, this.bdo);
        MessageManager.getInstance().registerListener(2013006, this.bdo);
        MessageManager.getInstance().registerListener(1001, this.mOnlineListener);
        MessageManager.getInstance().registerListener(2005016, this.bdq);
        MessageManager.getInstance().registerStickyMode(2016001);
        MessageManager.getInstance().registerListener(2016001, this.bdp);
        MessageManager.getInstance().registerListener(2016002, this.bdr);
        MessageManager.getInstance().registerListener(2008016, this.bds);
        MessageManager.getInstance().registerListener(2016004, this.bdt);
        MessageManager.getInstance().registerListener(2016005, this.bdu);
        MessageManager.getInstance().registerListener(this.aTA);
        MessageManager.getInstance().registerListener(103112, this.bdm);
        MessageManager.getInstance().registerListener(103104, this.bdn);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016006, this.bdv);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.bde);
        MessageManager.getInstance().registerListener(2001217, this.bdf);
        MessageManager.getInstance().registerListener(2001218, this.bdg);
        MessageManager.getInstance().registerListener(202001, this.bdc);
        MessageManager.getInstance().registerListener(205001, this.bdd);
        MessageManager.getInstance().registerListener(2001130, this.bdw);
        MessageManager.getInstance().registerListener(2001129, this.bdw);
        MessageManager.getInstance().registerListener(2001132, this.bdw);
        MessageManager.getInstance().registerListener(2001133, this.bdw);
        MessageManager.getInstance().registerListener(2001134, this.bdw);
        MessageManager.getInstance().registerListener(2001135, this.bdw);
        MessageManager.getInstance().registerListener(2001136, this.bdw);
        MessageManager.getInstance().registerListener(2001137, this.bdw);
        MessageManager.getInstance().registerListener(2001138, this.bdw);
        MessageManager.getInstance().registerListener(2001139, this.bdw);
        MessageManager.getInstance().registerListener(2001141, this.bdw);
        MessageManager.getInstance().registerListener(2001142, this.bdw);
        MessageManager.getInstance().registerListener(2001143, this.bdw);
        MessageManager.getInstance().registerListener(2001167, this.bdw);
        MessageManager.getInstance().registerListener(107103, this.bdh);
        MessageManager.getInstance().registerListener(2001201, this.bdk);
        MessageManager.getInstance().registerListener(106101, this.bdi);
        MessageManager.getInstance().registerListener(106102, this.bdj);
        MessageManager.getInstance().registerListener(2016009, this.bdl);
        MessageManager.getInstance().registerListener(2001178, this.bdy);
        MessageManager.getInstance().registerListener(2001220, this.bdx);
        MessageManager.getInstance().registerListener(205006, this.bdz);
        MessageManager.getInstance().registerListener(2016013, this.bdA);
        MessageManager.getInstance().registerListener(103004, this.bdB);
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
    public void PW() {
        if (this.bda != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.bda.getGroupInfos()) {
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
                    c.PK().i(imMessageCenterPojo);
                    c.PK().h(imMessageCenterPojo);
                }
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ArrayList arrayList3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            for (ImMessageCenterPojo imMessageCenterPojo5 : c.PK().PQ()) {
                if (imMessageCenterPojo5.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo5);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bda.getGroupInfos()) {
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
                    com.baidu.tieba.im.pushNotify.f.Rn().gz(imMessageCenterPojo5.getGid());
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
                c.PK().PQ().removeAll(arrayList2);
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
            this.bda = null;
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
        HashMap<String, String> po;
        if (!TextUtils.isEmpty(str)) {
            c.PK().C(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.oB().oU() != null && (po = com.baidu.tbadk.coreExtra.messageCenter.a.oB().oU().po()) != null && po.size() == 1 && po.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.oB().cp(str);
            }
            com.baidu.tieba.im.groupInfo.z.Pb().a(TbadkApplication.getCurrentAccount(), str, null);
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
            c.PK().g(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bp(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
