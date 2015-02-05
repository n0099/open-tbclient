package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ OfficialBarTipActivity aUQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(OfficialBarTipActivity officialBarTipActivity) {
        this.aUQ = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ao aoVar;
        aoVar = this.aUQ.aUP;
        ImMessageCenterShowItemData fz = aoVar.La().getItem(i);
        if (fz != null) {
            com.baidu.tbadk.coreExtra.util.a.a(this.aUQ.getPageContext().getContext(), new an(this, fz));
            return true;
        }
        return true;
    }
}
