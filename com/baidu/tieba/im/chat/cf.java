package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cf implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(MsglistActivity msglistActivity) {
        this.a = msglistActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        Boolean bool2 = bool;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                this.a.d.H();
            } else {
                this.a.d.I();
            }
        }
    }
}
