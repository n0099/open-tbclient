package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ g aSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.aSu = gVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        g gVar = this.aSu;
        imMessageCenterListAdapter = this.aSu.aSi;
        gVar.aSg = imMessageCenterListAdapter.getItem(i);
        g gVar2 = this.aSu;
        imMessageCenterShowItemData = this.aSu.aSg;
        gVar2.c(imMessageCenterShowItemData);
        if (this.aSu.aSl != null) {
            com.baidu.adp.lib.g.k.a(this.aSu.aSl, this.aSu.getActivity());
        }
        return true;
    }
}
