package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ OfficialBarTipActivity aTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(OfficialBarTipActivity officialBarTipActivity) {
        this.aTB = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ao aoVar;
        aoVar = this.aTB.aTA;
        ImMessageCenterShowItemData fu = aoVar.KK().getItem(i);
        if (fu != null) {
            com.baidu.tbadk.coreExtra.util.a.a(this.aTB.getPageContext().getContext(), new an(this, fu));
            return false;
        }
        return false;
    }
}
