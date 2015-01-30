package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ g aTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.aTE = gVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        g gVar = this.aTE;
        imMessageCenterListAdapter = this.aTE.aTr;
        gVar.aTp = imMessageCenterListAdapter.getItem(i);
        g gVar2 = this.aTE;
        imMessageCenterShowItemData = this.aTE.aTp;
        gVar2.c(imMessageCenterShowItemData);
        if (this.aTE.aTu != null) {
            com.baidu.adp.lib.g.k.a(this.aTE.aTu, this.aTE.getActivity());
        }
        return true;
    }
}
