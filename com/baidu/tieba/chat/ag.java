package com.baidu.tieba.chat;

import com.baidu.tieba.data.chat.ChatPostData;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private ChatPostData f1176a = null;
    private ah b = null;
    private ai c = null;
    private com.baidu.tieba.data.chat.c d;

    public ag() {
        this.d = null;
        this.d = com.baidu.tieba.data.chat.c.a();
    }

    public void a(ai aiVar) {
        this.c = aiVar;
    }

    public void a(ChatPostData chatPostData) {
        this.f1176a = chatPostData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        if (this.f1176a != null && this.b == null) {
            this.b = new ah(this);
            this.b.execute(new Object[0]);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return false;
        }
        return false;
    }
}
