package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cZt;
    private final /* synthetic */ c.b cZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cZt = absMsgImageActivity;
        this.cZv = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cZt.createListMenu(new String[]{this.cZt.getPageContext().getString(r.j.save)}, this.cZv);
        this.cZt.showListMenu();
        return false;
    }
}
