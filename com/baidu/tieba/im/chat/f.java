package com.baidu.tieba.im.chat;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ AbsMsgImageActivity cGL;
    private final /* synthetic */ c.b cGN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AbsMsgImageActivity absMsgImageActivity, c.b bVar) {
        this.cGL = absMsgImageActivity;
        this.cGN = bVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cGL.createListMenu(new String[]{this.cGL.getPageContext().getString(u.j.save)}, this.cGN);
        this.cGL.showListMenu();
        return false;
    }
}
