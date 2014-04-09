package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar) {
        this.a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        q qVar2;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i >= 0) {
            qVar = this.a.k;
            long itemId = qVar.getItemId(i);
            if (itemId != -1 && itemId != -2) {
                b bVar = this.a;
                qVar2 = this.a.k;
                bVar.h = (ImMessageCenterShowItemData) qVar2.getItem(i);
                b bVar2 = this.a;
                imMessageCenterShowItemData = this.a.h;
                b.b(bVar2, imMessageCenterShowItemData);
                if (this.a.b != null) {
                    this.a.b.show();
                }
            }
            return true;
        }
        return false;
    }
}
