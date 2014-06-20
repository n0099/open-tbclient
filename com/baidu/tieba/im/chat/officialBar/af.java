package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ae a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.a = aeVar;
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
        String a = com.baidu.tieba.im.e.r.a("[" + ((ba) list2.get(intValue)).c + "]", true);
        if (a != null) {
            OfficialHistoryImageActivity.a(this.a.a, a);
        }
    }
}
