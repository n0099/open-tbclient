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
    private static volatile ImMemoryCacheRegisterStatic bgH;
    private ResponseOnlineMessage bgG;
    private com.baidu.adp.framework.listener.e bgI = new u(this, 0);
    private com.baidu.adp.framework.listener.e bgJ = new ak(this, 0);
    private CustomMessageListener bgK = new bg(this, 0);
    private CustomMessageListener bgL = new bq(this, 0);
    private CustomMessageListener bgM = new br(this, 0);
    private com.baidu.adp.framework.listener.e bgN = new bs(this, 0);
    private com.baidu.adp.framework.listener.e bgO = new bu(this, 0);
    private com.baidu.adp.framework.listener.e bgP = new bv(this, 0);
    private CustomMessageListener bgQ = new bw(this, 0);
    private CustomMessageListener bgR = new w(this, 0);
    private com.baidu.adp.framework.listener.e bgS = new y(this, 0);
    private com.baidu.adp.framework.listener.e bgT = new z(this, 0);
    private CustomMessageListener bgU = new aa(this, 0);
    private com.baidu.adp.framework.listener.e mOnlineListener = new ac(this, 0);
    private CustomMessageListener bgV = new ad(this, 0);
    private CustomMessageListener bgW = new ae(this, 0);
    private CustomMessageListener bgX = new af(this, 0);
    private CustomMessageListener bgY = new ah(this, 0);
    private CustomMessageListener bgZ = new ai(this, 0);
    private CustomMessageListener bha = new am(this, 0);
    private com.baidu.adp.framework.listener.e aVq = new ao(this, 103101);
    private CustomMessageTask.CustomRunnable<Integer> bhb = new aq(this);
    private CustomMessageListener bhc = new ar(this, 0);
    CustomMessageListener bhd = new av(this, 0);
    CustomMessageListener bhe = new aw(this, 0);
    private com.baidu.adp.framework.listener.e bhf = new az(this, 0);
    private CustomMessageListener bhg = new bb(this, 0);
    private com.baidu.adp.framework.listener.e bhh = new bd(this, 0);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bhi = new bf(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bhj = new bh(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bhk = new bi(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bhl = new bj(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bhm = new bk(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bhn = new bl(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.c bho = new bm(this);

    private ImMemoryCacheRegisterStatic() {
        register();
    }

    private static ImMemoryCacheRegisterStatic QD() {
        com.baidu.adp.lib.util.l.ft();
        if (bgH == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (bgH == null) {
                    bgH = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return bgH;
    }

    static {
        QD();
    }

    private void register() {
        MessageManager.getInstance().registerListener(2013005, this.bgU);
        MessageManager.getInstance().registerListener(2013007, this.bgU);
        MessageManager.getInstance().registerListener(2013004, this.bgU);
        MessageManager.getInstance().registerListener(2013003, this.bgU);
        MessageManager.getInstance().registerListener(2013001, this.bgU);
        MessageManager.getInstance().registerListener(2013002, this.bgU);
        MessageManager.getInstance().registerListener(2013000, this.bgU);
        MessageManager.getInstance().registerListener(2013006, this.bgU);
        MessageManager.getInstance().registerListener(1001, this.mOnlineListener);
        MessageManager.getInstance().registerListener(2005016, this.bgW);
        MessageManager.getInstance().registerStickyMode(2016001);
        MessageManager.getInstance().registerListener(2016001, this.bgV);
        MessageManager.getInstance().registerListener(2016002, this.bgX);
        MessageManager.getInstance().registerListener(2008016, this.bgY);
        MessageManager.getInstance().registerListener(2016004, this.bgZ);
        MessageManager.getInstance().registerListener(2016005, this.bha);
        MessageManager.getInstance().registerListener(this.aVq);
        MessageManager.getInstance().registerListener(103112, this.bgS);
        MessageManager.getInstance().registerListener(103104, this.bgT);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016006, this.bhb);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.bgK);
        MessageManager.getInstance().registerListener(2001217, this.bgL);
        MessageManager.getInstance().registerListener(2001218, this.bgM);
        MessageManager.getInstance().registerListener(202001, this.bgI);
        MessageManager.getInstance().registerListener(205001, this.bgJ);
        MessageManager.getInstance().registerListener(2001130, this.bhc);
        MessageManager.getInstance().registerListener(2001129, this.bhc);
        MessageManager.getInstance().registerListener(2001132, this.bhc);
        MessageManager.getInstance().registerListener(2001133, this.bhc);
        MessageManager.getInstance().registerListener(2001134, this.bhc);
        MessageManager.getInstance().registerListener(2001135, this.bhc);
        MessageManager.getInstance().registerListener(2001136, this.bhc);
        MessageManager.getInstance().registerListener(2001137, this.bhc);
        MessageManager.getInstance().registerListener(2001138, this.bhc);
        MessageManager.getInstance().registerListener(2001139, this.bhc);
        MessageManager.getInstance().registerListener(2001141, this.bhc);
        MessageManager.getInstance().registerListener(2001142, this.bhc);
        MessageManager.getInstance().registerListener(2001143, this.bhc);
        MessageManager.getInstance().registerListener(2001167, this.bhc);
        MessageManager.getInstance().registerListener(107103, this.bgN);
        MessageManager.getInstance().registerListener(2001201, this.bgQ);
        MessageManager.getInstance().registerListener(106101, this.bgO);
        MessageManager.getInstance().registerListener(106102, this.bgP);
        MessageManager.getInstance().registerListener(2016009, this.bgR);
        MessageManager.getInstance().registerListener(2001178, this.bhe);
        MessageManager.getInstance().registerListener(2001220, this.bhd);
        MessageManager.getInstance().registerListener(205006, this.bhf);
        MessageManager.getInstance().registerListener(2016013, this.bhg);
        MessageManager.getInstance().registerListener(103004, this.bhh);
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
    public void QE() {
        if (this.bgG != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.bgG.getGroupInfos()) {
                if (groupUpdateMessage != null) {
                    BdLog.i("gid-serverMaxMid:" + groupUpdateMessage.getGroupId() + "-" + groupUpdateMessage.getLastMsgId());
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.gg(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(com.baidu.tieba.im.util.h.af(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    c.Qs().p(imMessageCenterPojo);
                    c.Qs().o(imMessageCenterPojo);
                }
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ArrayList arrayList3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            for (ImMessageCenterPojo imMessageCenterPojo5 : c.Qs().Qy()) {
                if (imMessageCenterPojo5.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo5);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.bgG.getGroupInfos()) {
                        if (com.baidu.tieba.im.b.a.gg(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo5.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo5);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo5.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.d.RK().ha(imMessageCenterPojo5.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo5;
                } else if (imMessageCenterPojo5.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.c.a.gw(com.baidu.adp.lib.g.c.toInt(imMessageCenterPojo5.getGid(), 0));
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
                c.Qs().Qy().removeAll(arrayList2);
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
            this.bgG = null;
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
    public void gT(String str) {
        HashMap<String, String> sH;
        if (!TextUtils.isEmpty(str)) {
            c.Qs().I(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc() != null && (sH = com.baidu.tbadk.coreExtra.messageCenter.a.rI().sc().sH()) != null && sH.size() == 1 && sH.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.rI().dm(str);
            }
            com.baidu.tieba.im.settingcache.c.SV().b(TbadkCoreApplication.getCurrentAccount(), str, null);
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
            c.Qs().n(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bp(this, imMessageCenterPojo));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
