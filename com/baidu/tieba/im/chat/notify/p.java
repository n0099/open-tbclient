package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(d dVar) {
        this.a = dVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        u uVar;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        d dVar = this.a;
        uVar = this.a.h;
        dVar.f = (ImMessageCenterShowItemData) uVar.getItem(i);
        d dVar2 = this.a;
        imMessageCenterShowItemData = this.a.f;
        dVar2.a(imMessageCenterShowItemData);
        if (this.a.b != null) {
            this.a.b.show();
        }
        return true;
    }
}
