package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e aJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aJJ = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.base.i iVar;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aJJ.getActivity());
        aVar.ct(this.aJJ.getActivity().getString(i.h.chosen_post_dialog_text));
        aVar.b(i.h.cancel, new i(this, aVar));
        aVar.a(i.h.confirm, new j(this, aVar, i));
        iVar = this.aJJ.aJC;
        aVar.b(iVar.getPageContext());
        aVar.sR();
        return true;
    }
}
