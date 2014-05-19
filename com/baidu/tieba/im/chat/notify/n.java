package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(b bVar) {
        this.a = bVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        s sVar;
        s sVar2;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i >= 0) {
            sVar = this.a.l;
            long itemId = sVar.getItemId(i);
            if (itemId != -1 && itemId != -2) {
                b bVar = this.a;
                sVar2 = this.a.l;
                bVar.i = (ImMessageCenterShowItemData) sVar2.getItem(i);
                b bVar2 = this.a;
                imMessageCenterShowItemData = this.a.i;
                bVar2.a(imMessageCenterShowItemData);
                if (this.a.b != null) {
                    this.a.b.show();
                }
            }
            return true;
        }
        return false;
    }
}
