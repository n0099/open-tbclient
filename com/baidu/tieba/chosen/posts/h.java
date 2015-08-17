package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e aKD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aKD = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.base.i iVar;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aKD.getActivity());
        aVar.cn(this.aKD.getActivity().getString(i.C0057i.chosen_post_dialog_text));
        aVar.b(i.C0057i.cancel, new i(this, aVar));
        aVar.a(i.C0057i.confirm, new j(this, aVar, i));
        iVar = this.aKD.aKw;
        aVar.b(iVar.getPageContext());
        aVar.sP();
        return true;
    }
}
