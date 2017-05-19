package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cIT;
    private final /* synthetic */ c.b cIV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cIT = absMsgImageActivity;
        this.cIV = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cIT.createListMenu(new String[]{this.cIT.getPageContext().getString(w.l.save)}, this.cIV);
        this.cIT.showListMenu();
        return false;
    }
}
