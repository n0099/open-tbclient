package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity brt;
    private final /* synthetic */ c.b brv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.brt = absMsgImageActivity;
        this.brv = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.brt.createListMenu(new String[]{this.brt.getPageContext().getString(i.h.save)}, this.brv);
        this.brt.showListMenu();
        return false;
    }
}
