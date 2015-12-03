package com.baidu.tieba.homepage.listview;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c byO;
    private final /* synthetic */ c.b byQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, c.b bVar) {
        this.byO = cVar;
        this.byQ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.byO.d(this.byQ);
    }
}
