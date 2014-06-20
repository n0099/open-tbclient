package com.baidu.tieba.im.e;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ String a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        ImMessageCenterPojo a = com.baidu.tieba.im.b.e.a(this.a);
        if (a != null) {
            a.setGroup_name(this.b);
        }
    }
}
