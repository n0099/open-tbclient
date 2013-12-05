package com.baidu.tieba.a;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.data.NewErrorData;
import com.baidu.tieba.data.chat.ChatPostData;
import com.baidu.tieba.util.am;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1020a = com.baidu.tieba.data.h.f1248a + "c/s/addmsg";
    private am b = null;
    private NewErrorData c = null;

    public String a(ChatPostData chatPostData) {
        this.b = new am(f1020a);
        this.b.a(PushConstants.EXTRA_USER_ID, chatPostData.getUserID());
        this.b.a("com_id", chatPostData.getFriendID());
        this.b.a("content", chatPostData.getContent());
        this.b.a("last_msg_id", String.valueOf(chatPostData.getLastMsgID()));
        String l = this.b.l();
        this.c = new NewErrorData();
        this.c.parserJson(l);
        return l;
    }

    public void a() {
        if (this.b != null) {
            this.b.j();
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
            return this.b.i();
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
