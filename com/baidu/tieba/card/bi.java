package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ bd aQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bd bdVar) {
        this.aQB = bdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.l lVar;
        by<com.baidu.tieba.card.a.l> JO = this.aQB.JO();
        if (JO != null) {
            view.setTag("2");
            lVar = this.aQB.aQq;
            JO.a(view, lVar);
        }
    }
}
