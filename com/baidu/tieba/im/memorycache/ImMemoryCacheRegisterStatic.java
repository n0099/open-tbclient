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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
import com.baidu.tieba.im.chat.bu;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ImMemoryCacheRegisterStatic {
    private static volatile ImMemoryCacheRegisterStatic d;
    private ResponseOnlineMessage c;
    private com.baidu.adp.framework.listener.d e = new u(this, 0);
    private com.baidu.adp.framework.listener.d f = new ak(this, 0);
    private CustomMessageListener g = new bd(this, 0);
    private CustomMessageListener h = new bk(this, 0);
    private CustomMessageListener i = new bl(this, 0);
    private com.baidu.adp.framework.listener.d j = new bm(this, 0);
    private com.baidu.adp.framework.listener.d k = new bo(this, 0);
    private com.baidu.adp.framework.listener.d l = new bp(this, 0);
    private CustomMessageListener m = new bq(this, 0);
    private CustomMessageListener n = new w(this, 0);
    private com.baidu.adp.framework.listener.d o = new y(this, 0);
    private com.baidu.adp.framework.listener.d p = new z(this, 0);
    private CustomMessageListener q = new aa(this, 0);
    private com.baidu.adp.framework.listener.d r = new ac(this, 0);
    private CustomMessageListener s = new ad(this, 0);
    private CustomMessageListener t = new ae(this, 0);
    private CustomMessageListener u = new af(this, 0);
    private CustomMessageListener v = new ah(this, 0);
    private CustomMessageListener w = new ai(this, 0);
    private CustomMessageListener x = new am(this, 0);
    private com.baidu.adp.framework.listener.d y = new ao(this, 103101);
    private CustomMessageTask.CustomRunnable<Integer> z = new aq(this);
    private CustomMessageListener A = new ar(this, 0);
    CustomMessageListener a = new av(this, 0);
    CustomMessageListener b = new aw(this, 0);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.b B = new az(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.b C = new ba(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.b D = new bb(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.b E = new bc(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.b F = new be(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.b G = new bf(this);
    private com.baidu.tieba.im.chat.receiveChatMsgHandler.b H = new bg(this);

    private ImMemoryCacheRegisterStatic() {
        b();
    }

    private static ImMemoryCacheRegisterStatic a() {
        com.baidu.adp.lib.util.j.a();
        if (d == null) {
            synchronized (ImMemoryCacheRegisterStatic.class) {
                if (d == null) {
                    d = new ImMemoryCacheRegisterStatic();
                }
            }
        }
        return d;
    }

    static {
        a();
    }

    private void b() {
        MessageManager.getInstance().registerListener(2013005, this.q);
        MessageManager.getInstance().registerListener(2013007, this.q);
        MessageManager.getInstance().registerListener(2013004, this.q);
        MessageManager.getInstance().registerListener(2013003, this.q);
        MessageManager.getInstance().registerListener(2013001, this.q);
        MessageManager.getInstance().registerListener(2013002, this.q);
        MessageManager.getInstance().registerListener(2013000, this.q);
        MessageManager.getInstance().registerListener(2013006, this.q);
        MessageManager.getInstance().registerListener(1001, this.r);
        MessageManager.getInstance().registerListener(2005016, this.t);
        MessageManager.getInstance().registerStickyMode(2016001);
        MessageManager.getInstance().registerListener(2016001, this.s);
        MessageManager.getInstance().registerListener(2016002, this.u);
        MessageManager.getInstance().registerListener(2008016, this.v);
        MessageManager.getInstance().registerListener(2016004, this.w);
        MessageManager.getInstance().registerListener(2016005, this.x);
        MessageManager.getInstance().registerListener(this.y);
        MessageManager.getInstance().registerListener(103112, this.o);
        MessageManager.getInstance().registerListener(103104, this.p);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016006, this.z);
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(2001216, this.g);
        MessageManager.getInstance().registerListener(2001217, this.h);
        MessageManager.getInstance().registerListener(2001218, this.i);
        MessageManager.getInstance().registerListener(202001, this.e);
        MessageManager.getInstance().registerListener(205001, this.f);
        MessageManager.getInstance().registerListener(2001130, this.A);
        MessageManager.getInstance().registerListener(2001129, this.A);
        MessageManager.getInstance().registerListener(2001132, this.A);
        MessageManager.getInstance().registerListener(2001133, this.A);
        MessageManager.getInstance().registerListener(2001134, this.A);
        MessageManager.getInstance().registerListener(2001135, this.A);
        MessageManager.getInstance().registerListener(2001136, this.A);
        MessageManager.getInstance().registerListener(2001137, this.A);
        MessageManager.getInstance().registerListener(2001138, this.A);
        MessageManager.getInstance().registerListener(2001139, this.A);
        MessageManager.getInstance().registerListener(2001141, this.A);
        MessageManager.getInstance().registerListener(2001142, this.A);
        MessageManager.getInstance().registerListener(2001143, this.A);
        MessageManager.getInstance().registerListener(2001167, this.A);
        MessageManager.getInstance().registerListener(107103, this.j);
        MessageManager.getInstance().registerListener(2001201, this.m);
        MessageManager.getInstance().registerListener(106101, this.k);
        MessageManager.getInstance().registerListener(106102, this.l);
        MessageManager.getInstance().registerListener(2016009, this.n);
        MessageManager.getInstance().registerListener(2001178, this.b);
        MessageManager.getInstance().registerListener(2001220, this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponsedMessage) {
            Message<?> orginalMessage = socketResponsedMessage.getOrginalMessage();
            if (orginalMessage instanceof ChatMessage) {
                TiebaStatic.imNet(socketResponsedMessage, String.valueOf(((ChatMessage) orginalMessage).getMsgType()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01ad, code lost:
        r1 = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        if (this.c != null) {
            for (GroupUpdateMessage groupUpdateMessage : this.c.getGroupInfos()) {
                if (groupUpdateMessage != null) {
                    BdLog.i("gid-serverMaxMid:" + groupUpdateMessage.getGroupId() + "-" + groupUpdateMessage.getLastMsgId());
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(groupUpdateMessage.getGroupId()));
                    imMessageCenterPojo.setCustomGroupType(com.baidu.tieba.im.b.a.a(groupUpdateMessage.getGroupType()));
                    imMessageCenterPojo.setGroup_head(groupUpdateMessage.getPortrait());
                    imMessageCenterPojo.setGroup_name(groupUpdateMessage.getName());
                    imMessageCenterPojo.setPulled_msgId(bu.b(groupUpdateMessage.getLastMsgId()));
                    if (imMessageCenterPojo.getCustomGroupType() == -2 || imMessageCenterPojo.getCustomGroupType() == -1 || imMessageCenterPojo.getCustomGroupType() == 5 || imMessageCenterPojo.getCustomGroupType() == 6) {
                        imMessageCenterPojo.setIs_hidden(1);
                    }
                    c.b().e(imMessageCenterPojo);
                    c.b().d(imMessageCenterPojo);
                }
            }
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            ImMessageCenterPojo imMessageCenterPojo2 = null;
            ImMessageCenterPojo imMessageCenterPojo3 = null;
            ArrayList arrayList3 = null;
            ImMessageCenterPojo imMessageCenterPojo4 = null;
            for (ImMessageCenterPojo imMessageCenterPojo5 : c.b().g()) {
                if (imMessageCenterPojo5.getCustomGroupType() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imMessageCenterPojo5);
                    boolean z = true;
                    for (GroupUpdateMessage groupUpdateMessage2 : this.c.getGroupInfos()) {
                        if (com.baidu.tieba.im.b.a.a(groupUpdateMessage2.getGroupType()) == 1 && imMessageCenterPojo5.getGid().equals(String.valueOf(groupUpdateMessage2.getGroupId()))) {
                            z = false;
                        }
                    }
                    if (z) {
                        ArrayList arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList4.add(imMessageCenterPojo5);
                        arrayList2 = arrayList4;
                    }
                } else if (imMessageCenterPojo5.getCustomGroupType() == -2) {
                    com.baidu.tieba.im.pushNotify.f.a().a(imMessageCenterPojo5.getGid());
                    imMessageCenterPojo3 = imMessageCenterPojo5;
                } else if (imMessageCenterPojo5.getCustomGroupType() == -1) {
                    com.baidu.tieba.im.chat.w.a(com.baidu.adp.lib.e.b.a(imMessageCenterPojo5.getGid(), 0));
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
                c.b().g().removeAll(arrayList2);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bh(this));
            customMessageTask.setParallel(com.baidu.tbadk.k.b());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            OnlineToDbCustomMessage onlineToDbCustomMessage = new OnlineToDbCustomMessage(2001000);
            onlineToDbCustomMessage.needCreateGroupList = arrayList;
            onlineToDbCustomMessage.systemGroup = imMessageCenterPojo3;
            onlineToDbCustomMessage.notifyGroup = imMessageCenterPojo2;
            onlineToDbCustomMessage.privateChatGroup = imMessageCenterPojo4;
            onlineToDbCustomMessage.yyGroupList = arrayList3;
            MessageManager.getInstance().sendMessage(onlineToDbCustomMessage, customMessageTask);
            this.c = null;
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
    public void a(String str) {
        HashMap<String, String> s;
        if (!TextUtils.isEmpty(str)) {
            c.b().b(str, 1);
            if (com.baidu.tbadk.coreExtra.messageCenter.a.a().u() != null && (s = com.baidu.tbadk.coreExtra.messageCenter.a.a().u().s()) != null && s.size() == 1 && s.containsKey(str)) {
                com.baidu.tbadk.coreExtra.messageCenter.a.a().a(str);
            }
            com.baidu.tieba.im.groupInfo.y.a().a(TbadkApplication.getCurrentAccount(), str, (com.baidu.tieba.im.a<Void>) null);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bi(this, str));
            customMessageTask.setParallel(com.baidu.tbadk.k.b());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null) {
            c.b().c(imMessageCenterPojo);
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bj(this, imMessageCenterPojo));
            customMessageTask.setParallel(com.baidu.tbadk.k.b());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
