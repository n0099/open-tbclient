package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(MsglistActivity msglistActivity) {
        this.a = msglistActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (bool != null) {
            if (bool.booleanValue()) {
                this.a.d.K();
            } else {
                this.a.d.L();
            }
        }
    }
}
