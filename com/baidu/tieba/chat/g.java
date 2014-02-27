package com.baidu.tieba.chat;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.a = aVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        n nVar;
        n nVar2;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i >= 0) {
            nVar = this.a.k;
            long itemId = nVar.getItemId(i);
            if (itemId != -1 && itemId != -2) {
                a aVar = this.a;
                nVar2 = this.a.k;
                aVar.h = (ImMessageCenterShowItemData) nVar2.getItem(i);
                a aVar2 = this.a;
                imMessageCenterShowItemData = this.a.h;
                a.b(aVar2, imMessageCenterShowItemData);
                if (this.a.b != null) {
                    this.a.b.show();
                }
            }
            return true;
        }
        return false;
    }
}
