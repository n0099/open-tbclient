package com.baidu.tieba.history;

import android.view.View;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity aNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbHistoryActivity pbHistoryActivity) {
        this.aNU = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aNU.getPageContext().getPageActivity());
        aVar.bs(z.editor_dialog_title);
        aVar.bt(z.pb_history_clear_tip);
        aVar.a(z.confirm, new c(this));
        aVar.b(z.cancel, new d(this));
        aVar.b(this.aNU.getPageContext()).nU();
    }
}
