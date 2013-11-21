package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.data.chat.ChatPostData;
import com.baidu.tieba.util.ap;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1010a = com.baidu.tieba.data.h.f1201a + "c/s/addmsg";
    private ap b = null;
    private NewErrorData c = null;

    public String a(ChatPostData chatPostData) {
        this.b = new ap(f1010a);
        this.b.a(PushConstants.EXTRA_USER_ID, chatPostData.getUserID());
        this.b.a("com_id", chatPostData.getFriendID());
        this.b.a("content", chatPostData.getContent());
        this.b.a("last_msg_id", String.valueOf(chatPostData.getLastMsgID()));
        String j = this.b.j();
        this.c = new NewErrorData();
        this.c.parserJson(j);
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
            return this.c.getErrorNumber();
        }
        return -1;
    }

    public String e() {
        if (this.c != null) {
            return this.c.getErrorMsg();
        }
        return null;
    }
}
