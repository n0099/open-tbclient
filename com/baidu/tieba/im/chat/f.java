package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cDW;
    private final /* synthetic */ c.b cDY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cDW = absMsgImageActivity;
        this.cDY = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cDW.createListMenu(new String[]{this.cDW.getPageContext().getString(u.j.save)}, this.cDY);
        this.cDW.showListMenu();
        return false;
    }
}
