package com.baidu.tieba.chat;

import com.baidu.tieba.data.chat.ChatPostData;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private ChatPostData f1129a = null;
    private ag b = null;
    private ah c = null;
    private com.baidu.tieba.data.chat.c d;

    public af() {
        this.d = null;
        this.d = com.baidu.tieba.data.chat.c.a();
    }

    public void a(ah ahVar) {
        this.c = ahVar;
    }

    public void a(ChatPostData chatPostData) {
        this.f1129a = chatPostData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.d
    public boolean LoadData() {
        if (this.f1129a != null && this.b == null) {
            this.b = new ag(this);
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
