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
    private static volatile ImMemoryCacheRegisterStatic bhZ;
    private ResponseOnlineMessage bhY;
    private com.baidu.adp.framework.listener.e bia = new u(this, 0);
    private com.baidu.adp.framework.listener.e bib = new ak(this, 0);
    private CustomMessageListener bic = new bg(this, 0);
    private CustomMessageListener bie = new bq(this, 0);
    private CustomMessageListener bif = new br(this, 0);
    private com.baidu.adp.framework.listener.e bih = new bs(this, 0);
    private com.baidu.adp.framework.listener.e bii = new bu(this, 0);
    private com.baidu.adp.framework.listener.e bij = new bv(this, 0);
    private CustomMessageListener bik = new bw(this, 0);
    private CustomMessageListener bil = new w(this, 0);
    private com.baidu.adp.framework.listener.e bim = new y(this, 0);
    private com.baidu.adp.framework.listener.e bin = new z(this, 0);
    private CustomMessageListener bio = new aa(this, 0);
    private com.baidu.adp.framework.listener.e bip = new ac(this, 0);
    private CustomMessageListener biq = new ad(this, 0);
    private CustomMessageListener bir = new ae(this, 0);
    private CustomMessageListener bis = new af(this, 0);
    private CustomMessageListener bit = new ah(this, 0);
    private CustomMessageListener biu = new ai(this, 0);
    private CustomMessageListener biv = new am(this, 0);
    private com.baidu.adp.framework.listener.e aWJ = new ao(this, 103101);
    private CustomMessageTask.CustomRunnable<Integer> biw = new aq(this);
    private CustomMessageListener bix = new ar(this, 0);
    CustomMessageListener biy = new av(this, 0);
    CustomMessageListener biz = new aw(this, 0);
    private com.baidu.adp.framework.listener.e biA = new az(this, 0);
    private CustomMessageListener biB = new bb(this, 0);
    private com.baidu.adp.framework.listener.e biC = new bd(this, 0);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biD = new bf(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biE = new bh(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biF = new bi(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biG = new bj(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biH = new bk(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biI = new bl(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c biJ = new bm(this);

    private ImMemoryCacheRegisterStatic() {
        rB();
    }

    private static ImMemoryCacheRegisterStatic QZ() {
        com.baidu.adp.lib.util.l.fs();
        if (bhZ == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bhZ == null) {
                    bhZ = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bhZ;
    }

    static {
        QZ();
    }

    private void rB() {
        MessageManager.getInstance().registerListener(2013005, this.bio);
        MessageManager.getInstance().registerListener(2013007, this.bio);
        MessageManager.getInstance().registerListener(2013004, this.bio);
        MessageManager.getInstance().registerListener(2013003, this.bio);
        MessageManager.getInstance().registerListener(2013001, this.bio);
        MessageManager.getInstance().registerListener(2013002, this.bio);
        MessageManager.getInstance().registerListener(2013000, this.bio);
        MessageManager.getInstance().registerListener(2013006, this.bio);
        MessageManager.getInstance().registerListener(2013008, this.bio);
        MessageManager.getInstance().registerListener(1001, this.bip);
        MessageManager.getInstance().registerListener(2005016, this.bir);
        MessageManager.getInstance().registerStickyMode(2016001);
        MessageManager.getInstance().registerListener(2016001, this.biq);
        MessageManager.getInstance().registerListener(2016002, this.bis);
        MessageManager.getInstance().registerListener(2008016, this.bit);
        MessageManager.getInstance().registerListener(2016004, this.biu);
        MessageManager.getInstance().registerListener(2016005, this.biv);
        MessageManager.getInstance().registerListener(this.aWJ);
        MessageManager.getInstance().registerListener(103112, this.bim);
        MessageManager.getInstance().registerListener(103104, this.bin);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016006, this.biw);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.bic);
        MessageManager.getInstance().registerListener(2001217, this.bie);
        MessageManager.getInstance().registerListener(2001218, this.bif);
        MessageManager.getInstance().registerListener(202001, this.bia);
        MessageManager.getInstance().registerListener(205001, this.bib);
        MessageManager.getInstance().registerListener(2001130, this.bix);
        MessageManager.getInstance().registerListener(2001129, this.bix);
        MessageManager.getInstance().registerListener(2001132, this.bix);
        MessageManager.getInstance().registerListener(2001133, this.bix);
        MessageManager.getInstance().registerListener(2001134, this.bix);
        MessageManager.getInstance().registerListener(2001135, this.bix);
        MessageManager.getInstance().registerListener(2001136, this.bix);
        MessageManager.getInstance().registerListener(2001137, this.bix);
        MessageManager.getInstance().registerListener(2001138, this.bix);
        MessageManager.getInstance().registerListener(2001139, this.bix);
        MessageManager.getInstance().registerListener(2001141, this.bix);
        MessageManager.getInstance().registerListener(2001142, this.bix);
        MessageManager.getInstance().registerListener(2001143, this.bix);
        MessageManager.getInstance().registerListener(2001167, this.bix);
        MessageManager.getInstance().registerListener(107103, this.bih);
        MessageManager.getInstance().registerListener(2001201, this.bik);
        MessageManager.getInstance().registerListener(106101, this.bii);
        MessageManager.getInstance().registerListener(106102, this.bij);
        MessageManager.getInstance().registerListener(2016009, this.bil);
        MessageManager.getInstance().registerListener(2001178, this.biz);
        MessageManager.getInstance().registerListener(2001220, this.biy);
        MessageManager.getInstance().registerListener(205006, this.biA);
        MessageManager.getInstance().registerListener(2016013, this.biB);
        MessageManager.getInstance().registerListener(103004, this.biC);
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
    public void Ra() {
        if (this.bhY != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.bhY.getGroupInfos()) {
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
                    c.QO().p(imMessageCenterPojo);
                    c.QO().o(imMessageCenterPojo);
                }
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ArrayList arrayList3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            for (ImMessageCenterPojo imMessageCenterPojo5 : c.QO().QU()) {
                if (imMessageCenterPojo5.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo5);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bhY.getGroupInfos()) {
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
                    com.baidu.tieba.im.pushNotify.d.Sg().hf(imMessageCenterPojo5.getGid());
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
                c.QO().ax(arrayList2);
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
            if (this.bhY.isUserAvailable()) {
                onlineToDbCustomMessage.needDeleteGroupList = arrayList2;
            }
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.bhY = null;
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
    public void gY(String str) {
        HashMap<String, String> sY;
        if (!TextUtils.isEmpty(str)) {
            c.QO().I(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.rY().ss() != null && (sY = com.baidu.tbadk.coreExtra.messageCenter.a.rY().ss().sY()) != null && sY.size() == 1 && sY.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.rY().dl(str);
            }
            com.baidu.tieba.im.settingcache.c.Tr().b(TbadkCoreApplication.getCurrentAccount(), str, null);
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
            c.QO().n(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bp(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
