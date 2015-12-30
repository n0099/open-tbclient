package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aRi = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.base.i iVar;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aRi.getActivity());
        aVar.cF(this.aRi.getActivity().getString(n.j.chosen_post_dialog_text));
        aVar.b(n.j.cancel, new i(this, aVar));
        aVar.a(n.j.confirm, new j(this, aVar, i));
        iVar = this.aRi.aRb;
        aVar.b(iVar.getPageContext());
        aVar.tf();
        return true;
    }
}
