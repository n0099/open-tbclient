package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ad a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.a = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        List list2;
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue < 0) {
            return;
        }
        list = this.a.c;
        if (intValue >= list.size()) {
            return;
        }
        list2 = this.a.c;
        ba baVar = (ba) list2.get(intValue);
        String a = com.baidu.tieba.im.d.j.a("[" + baVar.c + "]", true);
        if (a != null) {
            OfficialHistoryImageActivity.a(this.a.a, a, String.valueOf(baVar.d));
        }
    }
}
