package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ OfficialBarTipActivity aZE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(OfficialBarTipActivity officialBarTipActivity) {
        this.aZE = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ap apVar;
        apVar = this.aZE.aZB;
        ImMessageCenterShowItemData fA = apVar.Of().getItem(i);
        if (fA != null) {
            com.baidu.tbadk.coreExtra.util.a.a(this.aZE.getPageContext().getContext(), new an(this, fA));
            return true;
        }
        return true;
    }
}
