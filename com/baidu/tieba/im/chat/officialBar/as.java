package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.util.DialogUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ OfficialBarTipActivity aRU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(OfficialBarTipActivity officialBarTipActivity) {
        this.aRU = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        au auVar;
        auVar = this.aRU.aRT;
        ImMessageCenterShowItemData fr = auVar.Ky().getItem(i);
        if (fr != null) {
            DialogUtil.deleteItem(this.aRU, new at(this, fr));
            return false;
        }
        return false;
    }
}
