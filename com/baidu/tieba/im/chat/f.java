package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cTL;
    private final /* synthetic */ c.b cTN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cTL = absMsgImageActivity;
        this.cTN = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cTL.createListMenu(new String[]{this.cTL.getPageContext().getString(r.j.save)}, this.cTN);
        this.cTL.showListMenu();
        return false;
    }
}
