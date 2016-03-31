package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ b bwr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bwr = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bwr.MX == null || this.bwr.MX.getOrignalPage() == null || this.bwr.MX.getOrignalPage().checkUpIsLogin()) {
            bg.wM().c(this.bwr.MX, new String[]{(String) view.getTag()});
        }
    }
}
