package com.baidu.tieba.history;

import android.view.View;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity aPd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbHistoryActivity pbHistoryActivity) {
        this.aPd = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aPd.getPageContext().getPageActivity());
        aVar.bx(z.editor_dialog_title);
        aVar.by(z.pb_history_clear_tip);
        aVar.a(z.confirm, new c(this));
        aVar.b(z.cancel, new d(this));
        aVar.b(this.aPd.getPageContext()).nX();
    }
}
