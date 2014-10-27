package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ad this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.this$0 = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue < 0) {
            return;
        }
        list = this.this$0.Wx;
        if (intValue >= list.size()) {
            return;
        }
        list2 = this.this$0.Wx;
        az azVar = (az) list2.get(intValue);
        String v = com.baidu.tieba.im.util.i.v("[" + azVar.content + "]", true);
        if (v != null) {
            OfficialHistoryImageActivity.startActivity(this.this$0.mContext, v, String.valueOf(azVar.id));
        }
    }
}
