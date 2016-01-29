package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e aTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aTp = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.base.i iVar;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aTp.getActivity());
        aVar.cE(this.aTp.getActivity().getString(t.j.chosen_post_dialog_text));
        aVar.b(t.j.cancel, new i(this, aVar));
        aVar.a(t.j.confirm, new j(this, aVar, i));
        iVar = this.aTp.aTi;
        aVar.b(iVar.getPageContext());
        aVar.uj();
        return true;
    }
}
