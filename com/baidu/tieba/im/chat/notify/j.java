package com.baidu.tieba.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ g aTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.aTD = gVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        g gVar = this.aTD;
        imMessageCenterListAdapter = this.aTD.aTq;
        gVar.aTo = imMessageCenterListAdapter.getItem(i);
        g gVar2 = this.aTD;
        imMessageCenterShowItemData = this.aTD.aTo;
        gVar2.c(imMessageCenterShowItemData);
        if (this.aTD.aTt != null) {
            com.baidu.adp.lib.g.k.a(this.aTD.aTt, this.aTD.getActivity());
        }
        return true;
    }
}
