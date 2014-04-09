package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
final class au implements AdapterView.OnItemClickListener {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        az azVar;
        azVar = this.a.b;
        Object item = azVar.d().getItem(i);
        if (item != null) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = (ImMessageCenterShowItemData) item;
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                com.baidu.tieba.im.message.az.a("v_mread", new StringBuilder(String.valueOf(parseLong)).toString());
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001006, new com.baidu.tbadk.core.b.ae(this.a, parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
