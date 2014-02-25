package com.baidu.tieba.im.c;

import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.mention.ah;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tieba.im.db.e {
    final /* synthetic */ a a;
    private final /* synthetic */ ah b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, ah ahVar) {
        this.a = aVar;
        this.b = ahVar;
    }

    @Override // com.baidu.tieba.im.db.e
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean a;
        ImMessageCenterShowItemData a2;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            a = this.a.a(next);
            if (a) {
                a2 = this.a.a(next.getGid(), next);
                this.a.a(a2, this.b);
            }
        }
    }
}
