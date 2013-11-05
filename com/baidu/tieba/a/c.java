package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.data.chat.ChatPostData;
import com.baidu.tieba.util.ag;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f994a = com.baidu.tieba.data.h.f1165a + "c/s/addmsg";
    private ag b = null;
    private ak c = null;

    public String a(ChatPostData chatPostData) {
        this.b = new ag(f994a);
        this.b.a(PushConstants.EXTRA_USER_ID, chatPostData.getUserID());
        this.b.a("com_id", chatPostData.getFriendID());
        this.b.a("content", chatPostData.getContent());
        this.b.a("last_msg_id", String.valueOf(chatPostData.getLastMsgID()));
        String j = this.b.j();
        this.c = new ak();
        this.c.a(j);
        return j;
    }

    public void a() {
        if (this.b != null) {
            this.b.h();
        }
    }

    public boolean b() {
        if (this.b != null) {
            return this.b.c();
        }
        return false;
    }

    public String c() {
        if (this.b != null) {
            return this.b.g();
        }
        return null;
    }

    public int d() {
        if (this.c != null) {
            return this.c.a();
        }
        return -1;
    }

    public String e() {
        if (this.c != null) {
            return this.c.b();
        }
        return null;
    }
}
