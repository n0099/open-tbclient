package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ g aQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.aQQ = gVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        g gVar = this.aQQ;
        imMessageCenterListAdapter = this.aQQ.aQD;
        gVar.aQB = imMessageCenterListAdapter.getItem(i);
        g gVar2 = this.aQQ;
        imMessageCenterShowItemData = this.aQQ.aQB;
        gVar2.c(imMessageCenterShowItemData);
        if (this.aQQ.aQG != null) {
            com.baidu.adp.lib.g.j.a(this.aQQ.aQG, this.aQQ.getActivity());
        }
        return true;
    }
}
