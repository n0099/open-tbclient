package com.baidu.tieba.chosen.posts;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ e aDf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.aDf = eVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.adp.base.j<?> jVar;
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aDf.getActivity());
        aVar.cn(this.aDf.getString(t.chosen_post_dialog_text));
        aVar.b(t.cancel, new h(this, aVar));
        aVar.a(t.confirm, new i(this, aVar, i));
        jVar = this.aDf.mContext;
        aVar.b(jVar);
        aVar.rL();
        return true;
    }
}
