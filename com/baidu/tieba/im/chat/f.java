package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    private final /* synthetic */ c.b cMB;
    final /* synthetic */ AbsMsgImageActivity cMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cMz = absMsgImageActivity;
        this.cMB = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cMz.createListMenu(new String[]{this.cMz.getPageContext().getString(w.l.save)}, this.cMB);
        this.cMz.showListMenu();
        return false;
    }
}
