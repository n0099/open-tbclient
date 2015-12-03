package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e aNp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aNp = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.base.i iVar;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aNp.getActivity());
        aVar.cC(this.aNp.getActivity().getString(n.i.chosen_post_dialog_text));
        aVar.b(n.i.cancel, new i(this, aVar));
        aVar.a(n.i.confirm, new j(this, aVar, i));
        iVar = this.aNp.aNi;
        aVar.b(iVar.getPageContext());
        aVar.tv();
        return true;
    }
}
