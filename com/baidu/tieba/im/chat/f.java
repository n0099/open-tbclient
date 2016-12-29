package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cEF;
    private final /* synthetic */ c.b cEH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cEF = absMsgImageActivity;
        this.cEH = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cEF.createListMenu(new String[]{this.cEF.getPageContext().getString(r.j.save)}, this.cEH);
        this.cEF.showListMenu();
        return false;
    }
}
