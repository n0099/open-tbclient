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
    private static volatile ImMemoryCacheRegisterStatic bjo;
    private ResponseOnlineMessage bjn;
    private com.baidu.adp.framework.listener.e bjp = new u(this, 0);
    private com.baidu.adp.framework.listener.e bjq = new al(this, 0);
    private CustomMessageListener bjr = new bf(this, 0);
    private CustomMessageListener bjs = new bm(this, 0);
    private CustomMessageListener bjt = new bn(this, 0);
    private CustomMessageListener bju = new bo(this, 0);
    private CustomMessageListener bjv = new bq(this, 0);
    private CustomMessageListener bjw = new br(this, 0);
    private CustomMessageListener bjx = new bt(this, 0);
    private CustomMessageListener bjy = new w(this, 0);
    private CustomMessageListener bjz = new x(this, 0);
    private com.baidu.adp.framework.listener.e bjA = new z(this, 0);
    private CustomMessageListener bjB = new aa(this, 0);
    private CustomMessageListener bjC = new ab(this, 0);
    private CustomMessageListener bjD = new ac(this, 0);
    private CustomMessageListener bjE = new ae(this, 0);
    private CustomMessageListener bjF = new af(this, 0);
    private CustomMessageListener bjG = new ah(this, 0);
    private CustomMessageListener bjH = new aj(this, 2016016);
    private CustomMessageTask.CustomRunnable<Integer> bjI = new an(this);
    private CustomMessageListener bjJ = new ao(this, 0);
    CustomMessageListener bjK = new as(this, 0);
    private com.baidu.adp.framework.listener.e bjL = new av(this, 0);
    private CustomMessageListener bjM = new ax(this, 0);
    private CustomMessageListener bjN = new az(this, 2016017);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bjO = new bb(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bjP = new bc(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bjQ = new bd(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bjR = new be(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bjS = new bg(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bjT = new bh(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bjU = new bi(this);

    private ImMemoryCacheRegisterStatic() {
        yt();
    }

    private static ImMemoryCacheRegisterStatic So() {
        com.baidu.adp.lib.util.n.iV();
        if (bjo == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bjo == null) {
                    bjo = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bjo;
    }

    static {
        So();
    }

    private void yt() {
        MessageManager.getInstance().registerListener(2013005, this.bjz);
        MessageManager.getInstance().registerListener(2013007, this.bjz);
        MessageManager.getInstance().registerListener(2013004, this.bjz);
        MessageManager.getInstance().registerListener(2013003, this.bjz);
        MessageManager.getInstance().registerListener(2013001, this.bjz);
        MessageManager.getInstance().registerListener(2013002, this.bjz);
        MessageManager.getInstance().registerListener(2013000, this.bjz);
        MessageManager.getInstance().registerListener(2013006, this.bjz);
        MessageManager.getInstance().registerListener(2013008, this.bjz);
        MessageManager.getInstance().registerListener(2013009, this.bjz);
        MessageManager.getInstance().registerListener(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, this.bjA);
        MessageManager.getInstance().registerListener(2005016, this.bjC);
        MessageManager.getInstance().registerStickyMode(2016001);
        MessageManager.getInstance().registerListener(2016001, this.bjB);
        MessageManager.getInstance().registerListener(2016002, this.bjD);
        MessageManager.getInstance().registerListener(2008016, this.bjE);
        MessageManager.getInstance().registerListener(2016004, this.bjF);
        MessageManager.getInstance().registerListener(2016005, this.bjG);
        MessageManager.getInstance().registerListener(this.bjH);
        MessageManager.getInstance().registerListener(2016015, this.bjy);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016006, this.bjI);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.bjr);
        MessageManager.getInstance().registerListener(2001217, this.bjs);
        MessageManager.getInstance().registerListener(2001218, this.bjt);
        MessageManager.getInstance().registerListener(202001, this.bjp);
        MessageManager.getInstance().registerListener(205001, this.bjq);
        MessageManager.getInstance().registerListener(2001130, this.bjJ);
        MessageManager.getInstance().registerListener(2001129, this.bjJ);
        MessageManager.getInstance().registerListener(2001132, this.bjJ);
        MessageManager.getInstance().registerListener(2001133, this.bjJ);
        MessageManager.getInstance().registerListener(2001134, this.bjJ);
        MessageManager.getInstance().registerListener(2001135, this.bjJ);
        MessageManager.getInstance().registerListener(2001136, this.bjJ);
        MessageManager.getInstance().registerListener(2001137, this.bjJ);
        MessageManager.getInstance().registerListener(2001138, this.bjJ);
        MessageManager.getInstance().registerListener(2001139, this.bjJ);
        MessageManager.getInstance().registerListener(2001141, this.bjJ);
        MessageManager.getInstance().registerListener(2001142, this.bjJ);
        MessageManager.getInstance().registerListener(2001143, this.bjJ);
        MessageManager.getInstance().registerListener(2001167, this.bjJ);
        MessageManager.getInstance().registerListener(2016018, this.bju);
        MessageManager.getInstance().registerListener(2001201, this.bjw);
        MessageManager.getInstance().registerListener(2016019, this.bjv);
        MessageManager.getInstance().registerListener(2016009, this.bjx);
        MessageManager.getInstance().registerListener(2001178, this.bjK);
        MessageManager.getInstance().registerListener(205006, this.bjL);
        MessageManager.getInstance().registerListener(2016013, this.bjM);
        MessageManager.getInstance().registerListener(this.bjN);
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
    public void Sp() {
        if (this.bjn != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.bjn.getGroupInfos()) {
                if (groupUpdateMessage != null) {
                    BdLog.i("gid-serverMaxMid:" + groupUpdateMessage.getGroupId() + "-" + groupUpdateMessage.getLastMsgId());
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.gc(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.h.af(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == -9 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    c.Sd().i(imMessageCenterPojo);
                    c.Sd().h(imMessageCenterPojo);
                }
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            ImMessageCenterPojo imMessageCenterPojo5 = null;
            ArrayList arrayList3 = null;
            for (ImMessageCenterPojo imMessageCenterPojo6 : c.Sd().Sj()) {
                if (imMessageCenterPojo6.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo6);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bjn.getGroupInfos()) {
                        if (com.baidu.tieba.im.b.a.gc(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo6.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo6);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo6.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.d.SY().gM(imMessageCenterPojo6.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.c.a.gk(com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo6.getGid(), 0));
                    imMessageCenterPojo4 = imMessageCenterPojo6;
                } else if (imMessageCenterPojo6.getCustomGroupType() == -9) {
                    com.baidu.tieba.im.c.a.gl(com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo6.getGid(), 0));
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
                c.Sd().aE(arrayList2);
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
            if (this.bjn.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList2;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.bjn = null;
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
    public void gL(String str) {
        HashMap<String, String> wo;
        if (!TextUtils.isEmpty(str)) {
            c.Sd().E(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.uT().vo() != null && (wo = com.baidu.tbadk.coreExtra.messageCenter.a.uT().vo().wo()) != null && wo.size() == 1 && wo.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.uT().dp(str);
            }
            com.baidu.tieba.im.settingcache.c.Tn().b(TbadkCoreApplication.getCurrentAccount(), str, null);
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
            c.Sd().g(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bl(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
