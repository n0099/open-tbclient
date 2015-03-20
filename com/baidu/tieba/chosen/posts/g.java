package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ d aBj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.aBj = dVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.base.j<?> jVar;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aBj.getActivity());
        aVar.ca(this.aBj.getString(y.chosen_post_dialog_text));
        aVar.b(y.cancel, new h(this, aVar));
        aVar.a(y.confirm, new i(this, i, aVar));
        jVar = this.aBj.mContext;
        aVar.b(jVar);
        aVar.re();
        return true;
    }
}
