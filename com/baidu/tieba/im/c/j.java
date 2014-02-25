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
public class j implements com.baidu.tieba.im.messageCenter.g {
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

    public void b() {
        f();
    }

    private j() {
    }

    private void f() {
        com.baidu.tieba.im.messageCenter.e.a().a(202006, this);
        this.b.add(new SystemMsgReceivedHandler());
        this.b.add(new PersonalGroupReceivedHandler());
        this.b.add(new GroupMsgReceivedHandler());
        this.b.add(new OfficialGroupMsgReceivedHandler());
        this.b.add(new OperatingMsgReceivedhandler());
        this.b.add(new PersonalMsgReceivedHandler());
        this.b.add(new NotifyMsgHandler());
        this.b.add(new SnapGroupMsgReceivedHandler());
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        if (sVar != null) {
            com.baidu.adp.lib.util.f.e("cmd:" + sVar.w());
            switch (sVar.w()) {
                case 202006:
                    a((o) sVar);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(o oVar) {
        if (oVar != null) {
            com.baidu.adp.lib.util.f.e("cmd: " + oVar.w() + "groupId: " + oVar.d());
            if (oVar.a() == 3) {
                TiebaApplication.g().bm();
                return;
            }
            String valueOf = String.valueOf(oVar.d());
            cb.a(202006, 0, "server push new", "PushNotifyManager-push_notify", "succ", 0, "", 0L, 0, "gid:" + valueOf);
            if (!TextUtils.isEmpty(valueOf)) {
                com.baidu.tieba.im.b.a.c().a(oVar.d(), oVar.c(), oVar.b());
            }
        }
    }

    public void c() {
        com.baidu.tieba.im.b.a.c().i();
    }

    public void a(CommonMsgPojo commonMsgPojo) {
        boolean z = true;
        if (commonMsgPojo != null) {
            com.baidu.tieba.im.message.g chatMessage = commonMsgPojo.toChatMessage();
            if (chatMessage != null) {
                SystemMsgData j = com.baidu.tieba.im.util.l.j(chatMessage);
                if (j != null && !j.getIsSelf()) {
                    z = false;
                }
                if (TiebaApplication.B()) {
                    if (chatMessage.g().getUserId().equals(TiebaApplication.A()) && chatMessage.i() != 11) {
                        z = false;
                    }
                }
            }
            if (commonMsgPojo.getRead_flag() == 0) {
                z = false;
            }
            if (!TiebaApplication.g().Y() && !commonMsgPojo.isPrivate()) {
                z = false;
            }
            if (!TiebaApplication.g().X() && commonMsgPojo.isPrivate()) {
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
            i e = a.f().e(gid);
            if (e != null) {
                boolean isAcceptNotify = e.isAcceptNotify();
                if (z && !isAcceptNotify) {
                    z = false;
                }
                a.f().b(z, new k(this));
                return;
            }
            com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.A(), commonMsgPojo.getGid(), new l(this, z));
        }
    }

    public void a(boolean z) {
        a.f().b(z, new n(this));
    }

    public void d() {
        com.baidu.tieba.im.messageCenter.e.a().d(new com.baidu.tieba.im.message.j());
        com.baidu.adp.lib.util.f.e("dispatch group chat ");
    }

    public String e() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
