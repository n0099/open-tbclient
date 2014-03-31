package com.baidu.tieba.im.chat.officialBar;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
final class av implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(OfficialBarTipActivity officialBarTipActivity) {
        this.a = officialBarTipActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        az azVar;
        azVar = this.a.b;
        Object item = azVar.d().getItem(i);
        if (item != null) {
            OfficialBarTipActivity officialBarTipActivity = this.a;
            aw awVar = new aw(this, (ImMessageCenterShowItemData) item);
            AlertDialog.Builder builder = new AlertDialog.Builder(officialBarTipActivity);
            builder.setTitle(com.baidu.tieba.im.j.operation);
            builder.setItems(new String[]{officialBarTipActivity.getString(com.baidu.tieba.im.j.delete_user_chat)}, awVar);
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            create.show();
        }
        return false;
    }
}
