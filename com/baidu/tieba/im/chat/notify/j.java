package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ g aQC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.aQC = gVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        g gVar = this.aQC;
        imMessageCenterListAdapter = this.aQC.aQp;
        gVar.aQn = imMessageCenterListAdapter.getItem(i);
        g gVar2 = this.aQC;
        imMessageCenterShowItemData = this.aQC.aQn;
        gVar2.c(imMessageCenterShowItemData);
        if (this.aQC.aQs != null) {
            com.baidu.adp.lib.g.j.a(this.aQC.aQs, this.aQC.getActivity());
        }
        return true;
    }
}
