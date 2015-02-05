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
    private static volatile ImMemoryCacheRegisterStatic bhY;
    private ResponseOnlineMessage bhX;
    private com.baidu.adp.framework.listener.e bhZ = new u(this, 0);
    private com.baidu.adp.framework.listener.e bia = new ak(this, 0);
    private CustomMessageListener bib = new bg(this, 0);
    private CustomMessageListener bic = new bq(this, 0);
    private CustomMessageListener bie = new br(this, 0);
    private com.baidu.adp.framework.listener.e bif = new bs(this, 0);
    private com.baidu.adp.framework.listener.e bih = new bu(this, 0);
    private com.baidu.adp.framework.listener.e bii = new bv(this, 0);
    private CustomMessageListener bij = new bw(this, 0);
    private CustomMessageListener bik = new w(this, 0);
    private com.baidu.adp.framework.listener.e bil = new y(this, 0);
    private com.baidu.adp.framework.listener.e bim = new z(this, 0);
    private CustomMessageListener bin = new aa(this, 0);
    private com.baidu.adp.framework.listener.e bio = new ac(this, 0);
    private CustomMessageListener bip = new ad(this, 0);
    private CustomMessageListener biq = new ae(this, 0);
    private CustomMessageListener bir = new af(this, 0);
    private CustomMessageListener bis = new ah(this, 0);
    private CustomMessageListener bit = new ai(this, 0);
    private CustomMessageListener biu = new am(this, 0);
    private com.baidu.adp.framework.listener.e aWI = new ao(this, 103101);
    private CustomMessageTask.CustomRunnable<Integer> biv = new aq(this);
    private CustomMessageListener biw = new ar(this, 0);
    CustomMessageListener bix = new av(this, 0);
    CustomMessageListener biy = new aw(this, 0);
    private com.baidu.adp.framework.listener.e biz = new az(this, 0);
    private CustomMessageListener biA = new bb(this, 0);
    private com.baidu.adp.framework.listener.e biB = new bd(this, 0);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biC = new bf(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biD = new bh(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biE = new bi(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biF = new bj(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biG = new bk(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biH = new bl(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biI = new bm(this);

    private ImMemoryCacheRegisterStatic() {
        rv();
    }

    private static ImMemoryCacheRegisterStatic QU() {
        com.baidu.adp.lib.util.l.fs();
        if (bhY == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bhY == null) {
                    bhY = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bhY;
    }

    static {
        QU();
    }

    private void rv() {
        MessageManager.getInstance().registerListener(2013005, this.bin);
        MessageManager.getInstance().registerListener(2013007, this.bin);
        MessageManager.getInstance().registerListener(2013004, this.bin);
        MessageManager.getInstance().registerListener(2013003, this.bin);
        MessageManager.getInstance().registerListener(2013001, this.bin);
        MessageManager.getInstance().registerListener(2013002, this.bin);
        MessageManager.getInstance().registerListener(2013000, this.bin);
        MessageManager.getInstance().registerListener(2013006, this.bin);
        MessageManager.getInstance().registerListener(2013008, this.bin);
        MessageManager.getInstance().registerListener(1001, this.bio);
        MessageManager.getInstance().registerListener(2005016, this.biq);
        MessageManager.getInstance().registerStickyMode(2016001);
        MessageManager.getInstance().registerListener(2016001, this.bip);
        MessageManager.getInstance().registerListener(2016002, this.bir);
        MessageManager.getInstance().registerListener(2008016, this.bis);
        MessageManager.getInstance().registerListener(2016004, this.bit);
        MessageManager.getInstance().registerListener(2016005, this.biu);
        MessageManager.getInstance().registerListener(this.aWI);
        MessageManager.getInstance().registerListener(103112, this.bil);
        MessageManager.getInstance().registerListener(103104, this.bim);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016006, this.biv);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.bib);
        MessageManager.getInstance().registerListener(2001217, this.bic);
        MessageManager.getInstance().registerListener(2001218, this.bie);
        MessageManager.getInstance().registerListener(202001, this.bhZ);
        MessageManager.getInstance().registerListener(205001, this.bia);
        MessageManager.getInstance().registerListener(2001130, this.biw);
        MessageManager.getInstance().registerListener(2001129, this.biw);
        MessageManager.getInstance().registerListener(2001132, this.biw);
        MessageManager.getInstance().registerListener(2001133, this.biw);
        MessageManager.getInstance().registerListener(2001134, this.biw);
        MessageManager.getInstance().registerListener(2001135, this.biw);
        MessageManager.getInstance().registerListener(2001136, this.biw);
        MessageManager.getInstance().registerListener(2001137, this.biw);
        MessageManager.getInstance().registerListener(2001138, this.biw);
        MessageManager.getInstance().registerListener(2001139, this.biw);
        MessageManager.getInstance().registerListener(2001141, this.biw);
        MessageManager.getInstance().registerListener(2001142, this.biw);
        MessageManager.getInstance().registerListener(2001143, this.biw);
        MessageManager.getInstance().registerListener(2001167, this.biw);
        MessageManager.getInstance().registerListener(107103, this.bif);
        MessageManager.getInstance().registerListener(2001201, this.bij);
        MessageManager.getInstance().registerListener(106101, this.bih);
        MessageManager.getInstance().registerListener(106102, this.bii);
        MessageManager.getInstance().registerListener(2016009, this.bik);
        MessageManager.getInstance().registerListener(2001178, this.biy);
        MessageManager.getInstance().registerListener(2001220, this.bix);
        MessageManager.getInstance().registerListener(205006, this.biz);
        MessageManager.getInstance().registerListener(2016013, this.biA);
        MessageManager.getInstance().registerListener(103004, this.biB);
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
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01b1, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void QV() {
        if (this.bhX != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.bhX.getGroupInfos()) {
                if (groupUpdateMessage != null) {
                    BdLog.i("gid-serverMaxMid:" + groupUpdateMessage.getGroupId() + "-" + groupUpdateMessage.getLastMsgId());
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.gn(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.h.af(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    c.QJ().p(imMessageCenterPojo);
                    c.QJ().o(imMessageCenterPojo);
                }
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ArrayList arrayList3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            for (ImMessageCenterPojo imMessageCenterPojo5 : c.QJ().QP()) {
                if (imMessageCenterPojo5.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo5);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bhX.getGroupInfos()) {
                        if (com.baidu.tieba.im.b.a.gn(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo5.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo5);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo5.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.d.Sb().hc(imMessageCenterPojo5.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo5;
                } else if (imMessageCenterPojo5.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.c.a.gF(com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo5.getGid(), 0));
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
                c.QJ().ax(arrayList2);
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
            if (this.bhX.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList2;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.bhX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class OnlineToDbCustomMessage extends CustomMessage<String> {
        public List<ImMessageCenterPojo> needCreateGroupList;
        public List<ImMessageCenterPojo> needDeleteGroupList;
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
            this.needDeleteGroupList = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(String str) {
        HashMap<String, String> sS;
        if (!TextUtils.isEmpty(str)) {
            c.QJ().I(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm() != null && (sS = com.baidu.tbadk.coreExtra.messageCenter.a.rS().sm().sS()) != null && sS.size() == 1 && sS.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.rS().di(str);
            }
            com.baidu.tieba.im.settingcache.c.Tm().b(TbadkCoreApplication.getCurrentAccount(), str, null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bo(this, str));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            c.QJ().n(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bp(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
