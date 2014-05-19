package com.baidu.tieba.im.chat.notify;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {
    final /* synthetic */ b a;
    private final /* synthetic */ ImMessageCenterShowItemData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = bVar;
        this.b = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.r rVar;
        switch (i) {
            case 0:
                this.a.j = 4;
                rVar = this.a.d;
                rVar.a(this.b, new g(this));
                return;
            default:
                return;
        }
    }
}
