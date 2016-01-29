package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity bNP;
    private final /* synthetic */ c.b bNR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.bNP = absMsgImageActivity;
        this.bNR = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bNP.createListMenu(new String[]{this.bNP.getPageContext().getString(t.j.save)}, this.bNR);
        this.bNP.showListMenu();
        return false;
    }
}
