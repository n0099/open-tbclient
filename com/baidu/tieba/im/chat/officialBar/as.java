package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        aw awVar;
        awVar = this.a.c;
        Object item = awVar.b().getItem(i);
        if (item != null) {
            com.baidu.tieba.im.d.b.b(this.a, new at(this, (ImMessageCenterShowItemData) item));
            return false;
        }
        return false;
    }
}
