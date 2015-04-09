package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ OfficialBarTipActivity aZU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(OfficialBarTipActivity officialBarTipActivity) {
        this.aZU = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ap apVar;
        apVar = this.aZU.aZR;
        ImMessageCenterShowItemData fC = apVar.Os().getItem(i);
        if (fC != null) {
            com.baidu.tbadk.coreExtra.util.a.a(this.aZU.getPageContext().getContext(), new an(this, fC));
            return true;
        }
        return true;
    }
}
