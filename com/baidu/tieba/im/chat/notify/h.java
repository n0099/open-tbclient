package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.a = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        n nVar;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        e eVar = this.a;
        nVar = this.a.g;
        eVar.e = (ImMessageCenterShowItemData) nVar.getItem(i);
        e eVar2 = this.a;
        imMessageCenterShowItemData = this.a.e;
        eVar2.a(imMessageCenterShowItemData);
        if (this.a.b != null) {
            com.baidu.adp.lib.e.e.a(this.a.b, this.a.getActivity());
        }
        return true;
    }
}
