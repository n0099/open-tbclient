package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ax axVar;
        axVar = this.a.b;
        Object item = axVar.b().getItem(i);
        if (item != null) {
            com.baidu.tieba.im.e.b.b(this.a, new au(this, (ImMessageCenterShowItemData) item));
            return false;
        }
        return false;
    }
}
