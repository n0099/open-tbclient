package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        bb bbVar;
        bbVar = this.a.c;
        Object item = bbVar.b().getItem(i);
        if (item != null) {
            com.baidu.tieba.im.e.b.b(this.a, new ay(this, (ImMessageCenterShowItemData) item));
            return false;
        }
        return false;
    }
}
