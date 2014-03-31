package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        p pVar;
        p pVar2;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i >= 0) {
            pVar = this.a.j;
            long itemId = pVar.getItemId(i);
            if (itemId != -1 && itemId != -2) {
                b bVar = this.a;
                pVar2 = this.a.j;
                bVar.g = (ImMessageCenterShowItemData) pVar2.getItem(i);
                b bVar2 = this.a;
                imMessageCenterShowItemData = this.a.g;
                b.b(bVar2, imMessageCenterShowItemData);
                if (this.a.a != null) {
                    this.a.a.show();
                }
            }
            return true;
        }
        return false;
    }
}
