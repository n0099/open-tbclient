package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cSr;
    private final /* synthetic */ c.b cSt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cSr = absMsgImageActivity;
        this.cSt = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cSr.createListMenu(new String[]{this.cSr.getPageContext().getString(t.j.save)}, this.cSt);
        this.cSr.showListMenu();
        return false;
    }
}
