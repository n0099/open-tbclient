package com.baidu.tieba.im.f;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r3) {
        ImMessageCenterPojo a = com.baidu.tieba.im.b.e.a(this.a);
        if (a != null) {
            a.setGroup_head(this.b);
        }
    }
}
