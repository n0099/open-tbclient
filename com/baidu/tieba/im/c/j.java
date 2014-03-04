package com.baidu.tieba.im.c;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.GroupMsgReceivedHandler;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.NotifyMsgHandler;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.OfficialGroupMsgReceivedHandler;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.OperatingMsgReceivedhandler;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.PersonalGroupReceivedHandler;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.PersonalMsgReceivedHandler;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.SnapGroupMsgReceivedHandler;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.SystemMsgReceivedHandler;
import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.util.cb;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class j implements com.baidu.tieba.im.messageCenter.g {
    private static j a = null;
    private ArrayList<com.baidu.tieba.im.chat.receiveChatMsgHandler.d> b = new ArrayList<>();
    private String c;

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (a == null) {
                a = new j();
            }
            jVar = a;
        }
        return jVar;
    }

    public final void b() {
        com.baidu.tieba.im.messageCenter.d.a().a(202006, this);
        this.b.add(new SystemMsgReceivedHandler());
        this.b.add(new PersonalGroupReceivedHandler());
        this.b.add(new GroupMsgReceivedHandler());
        this.b.add(new OfficialGroupMsgReceivedHandler());
        this.b.add(new OperatingMsgReceivedhandler());
        this.b.add(new PersonalMsgReceivedHandler());
        this.b.add(new NotifyMsgHandler());
        this.b.add(new SnapGroupMsgReceivedHandler());
    }

    private j() {
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        if (sVar != null) {
            com.baidu.adp.lib.util.e.e("cmd:" + sVar.v());
            switch (sVar.v()) {
                case 202006:
                    o oVar = (o) sVar;
                    if (oVar != null) {
                        com.baidu.adp.lib.util.e.e("cmd: " + oVar.v() + "groupId: " + oVar.d());
                        if (oVar.a() == 3) {
                            TiebaApplication.g();
                            TiebaApplication.be();
                            return;
                        }
                        String valueOf = String.valueOf(oVar.d());
                        cb.a(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
                        if (!TextUtils.isEmpty(valueOf)) {
                            com.baidu.tieba.im.b.a.c().a(oVar.d(), oVar.c(), oVar.b());
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static void c() {
        com.baidu.tieba.im.b.a.c().i();
    }

    public final void a(CommonMsgPojo commonMsgPojo) {
        boolean z = true;
        if (commonMsgPojo != null) {
            com.baidu.tieba.im.message.b chatMessage = commonMsgPojo.toChatMessage();
            if (chatMessage != null) {
                SystemMsgData i = com.baidu.tieba.im.util.l.i(chatMessage);
                if (i != null && !i.getIsSelf()) {
                    z = false;
                }
                if (TiebaApplication.w()) {
                    if (chatMessage.g().getUserId().equals(TiebaApplication.v()) && chatMessage.i() != 11) {
                        z = false;
                    }
                }
            }
            if (commonMsgPojo.getRead_flag() == 0) {
                z = false;
            }
            if (!TiebaApplication.g().S() && !commonMsgPojo.isPrivate()) {
                z = false;
            }
            if (!TiebaApplication.g().R() && commonMsgPojo.isPrivate()) {
                z = false;
            }
            String gid = commonMsgPojo.getGid();
            if (!TextUtils.isEmpty(gid) && GroupChatActivity.a && gid.equals(GroupChatActivity.b)) {
                z = false;
            } else if (!TextUtils.isEmpty(gid) && PersonalChatActivity.a && gid.equals(PersonalChatActivity.b)) {
                z = false;
            } else if (!TextUtils.isEmpty(gid) && SnapGroupChatActivity.l && gid.equals(SnapGroupChatActivity.m)) {
                z = false;
            }
            i c = a.d().c(gid);
            if (c != null) {
                boolean isAcceptNotify = c.isAcceptNotify();
                if (z && !isAcceptNotify) {
                    z = false;
                }
                a.d().b(z, new k(this));
                return;
            }
            com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.v(), commonMsgPojo.getGid(), new l(this, z));
        }
    }

    public final void a(boolean z) {
        a.d().b(z, new n(this));
    }

    public static void d() {
        com.baidu.tieba.im.messageCenter.d.a().d(new com.baidu.tieba.im.message.j());
        com.baidu.adp.lib.util.e.e("dispatch group chat ");
    }

    public final String e() {
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }
}
